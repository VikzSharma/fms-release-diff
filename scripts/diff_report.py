#!/usr/bin/env python3
"""
diff_report.py - Diff two decompiled FileMaker Server source trees and
generate a markdown report of what changed between releases.

Usage:
    python3 scripts/diff_report.py \
        --old baseline/src \
        --new work/src \
        --old-version 26.0.1.68 \
        --new-version 26.0.3.309 \
        --out reports/26.0.1.68_to_26.0.3.309.md \
        [--full-diff-out reports/26.0.1.68_to_26.0.3.309_full.diff]

The report highlights security-relevant changes (authentication, privilege,
headers, sessions, crypto, uploads, ...) and lists all other changes in a
condensed form.
"""
import argparse
import difflib
import json
import os
import re
from datetime import datetime, timezone

SECURITY_KEYWORDS = [
    "auth", "privilege", "permission", "role", "admin", "session",
    "cookie", "token", "header", "x-fmi", "password", "credential",
    "secret", "license", "upload", "validate", "sanitize", "escape",
    "crypto", "cipher", "key", "trust", "bypass", "disable", "enable",
    "filter", "cors", "csp", "jwt", "oauth", "verify", "signature",
]

MAX_HUNK_LINES = 60          # context+hunk lines shown per security file
MAX_SECURITY_FILES = 80      # security files with inline hunks


def list_java_files(root):
    result = {}
    for dirpath, _, files in os.walk(root):
        for f in files:
            if f.endswith(".java"):
                full = os.path.join(dirpath, f)
                rel = os.path.relpath(full, root)
                result[rel] = full
    return result


def is_security_relevant(path, added_lines):
    p = path.lower()
    path_hit = any(k in p for k in SECURITY_KEYWORDS)
    content_hit = any(any(k in line.lower() for k in SECURITY_KEYWORDS) for line in added_lines)
    return path_hit or content_hit


def unified_stats(old_lines, new_lines, rel):
    sm = difflib.SequenceMatcher(None, old_lines, new_lines, autojunk=False)
    added, removed = 0, 0
    hunks = []
    for tag, i1, i2, j1, j2 in sm.get_opcodes():
        if tag == "equal":
            continue
        if tag in ("delete", "replace"):
            removed += i2 - i1
        if tag in ("insert", "replace"):
            added += j2 - j1
        hunks.append((tag, i1, i2, j1, j2))
    return added, removed, hunks


def render_hunks(old_lines, new_lines, hunks, rel):
    out = []
    for tag, i1, i2, j1, j2 in hunks:
        ctx = 3
        lo = max(0, min(i1, j1) - ctx)
        for n in range(lo, min(i1, j1)):
            out.append("  " + old_lines[n].rstrip())
        for n in range(i1, i2):
            out.append("- " + old_lines[n].rstrip())
        for n in range(j1, j2):
            out.append("+ " + new_lines[n].rstrip())
        out.append("")
        if len(out) > MAX_HUNK_LINES:
            out.append("  ... (truncated)")
            break
    return "\n".join(out)


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--old", required=True, help="old decompiled src dir")
    ap.add_argument("--new", required=True, help="new decompiled src dir")
    ap.add_argument("--old-version", required=True)
    ap.add_argument("--new-version", required=True)
    ap.add_argument("--out", required=True, help="markdown report path")
    ap.add_argument("--full-diff-out", help="optional full unified diff path")
    ap.add_argument("--summary-out", help="optional JSON summary path (for Slack notifications)")
    args = ap.parse_args()

    old_files = list_java_files(args.old)
    new_files = list_java_files(args.new)

    added = sorted(set(new_files) - set(old_files))
    removed = sorted(set(old_files) - set(new_files))
    common = sorted(set(old_files) & set(new_files))

    modified = []          # (rel, plus, minus, security)
    security_detail = []  # (rel, hunk_text)
    for rel in common:
        with open(old_files[rel], encoding="utf-8", errors="replace") as f:
            old_lines = f.readlines()
        with open(new_files[rel], encoding="utf-8", errors="replace") as f:
            new_lines = f.readlines()
        plus, minus, hunks = unified_stats(old_lines, new_lines, rel)
        if plus == 0 and minus == 0:
            continue
        sec = is_security_relevant(rel, [l for l in new_lines[:400]])
        modified.append((rel, plus, minus, sec))
        if sec:
            security_detail.append((rel, render_hunks(old_lines, new_lines, hunks, rel)))

    sec_modified = [m for m in modified if m[3]]
    other_modified = [m for m in modified if not m[3]]
    sec_added = [a for a in added if any(k in a.lower() for k in SECURITY_KEYWORDS)]

    lines = []
    lines.append(f"# FileMaker Server {args.old_version} → {args.new_version}")
    lines.append("")
    lines.append(f"*Decompiled source diff — generated {datetime.now(timezone.utc).strftime('%Y-%m-%d %H:%M UTC')}*")
    lines.append("")
    lines.append("## Summary")
    lines.append("")
    lines.append("| Metric | Count |")
    lines.append("|--------|-------|")
    lines.append(f"| Java files (old) | {len(old_files)} |")
    lines.append(f"| Java files (new) | {len(new_files)} |")
    lines.append(f"| Added files | {len(added)} |")
    lines.append(f"| Removed files | {len(removed)} |")
    lines.append(f"| Modified files | {len(modified)} |")
    lines.append(f"| **Security-relevant modified** | **{len(sec_modified)}** |")
    lines.append("")
    lines.append("## Security-relevant changes")
    lines.append("")
    if not sec_modified:
        lines.append("*No modified files matched security keywords.*")
    else:
        lines.append("| File | + | - |")
        lines.append("|------|---|---|")
        for rel, plus, minus, _ in sec_modified:
            lines.append(f"| `{rel}` | +{plus} | -{minus} |")
        lines.append("")
        lines.append("### Diff detail (security-relevant files)")
        lines.append("")
        for rel, hunk in security_detail[:MAX_SECURITY_FILES]:
            lines.append(f"#### `{rel}`")
            lines.append("")
            lines.append("```diff")
            lines.append(hunk)
            lines.append("```")
            lines.append("")
    lines.append("## Other modified files")
    lines.append("")
    if not other_modified:
        lines.append("*None.*")
    else:
        lines.append("| File | + | - |")
        lines.append("|------|---|---|")
        for rel, plus, minus, _ in other_modified:
            lines.append(f"| `{rel}` | +{plus} | -{minus} |")
    lines.append("")
    lines.append("## Added files")
    lines.append("")
    sec_flag = " 🔒" if sec_added else ""
    if not added:
        lines.append("*None.*")
    else:
        for a in added:
            mark = " 🔒" if any(k in a.lower() for k in SECURITY_KEYWORDS) else ""
            lines.append(f"- `{a}`{mark}")
    lines.append("")
    lines.append("## Removed files")
    lines.append("")
    if not removed:
        lines.append("*None.*")
    else:
        for r in removed:
            lines.append(f"- `{r}`")
    lines.append("")

    os.makedirs(os.path.dirname(args.out), exist_ok=True)
    with open(args.out, "w", encoding="utf-8") as f:
        f.write("\n".join(lines))

    if args.full_diff_out:
        os.makedirs(os.path.dirname(args.full_diff_out), exist_ok=True)
        with open(args.full_diff_out, "w", encoding="utf-8") as f:
            for rel in common:
                with open(old_files[rel], encoding="utf-8", errors="replace") as fo:
                    ol = fo.readlines()
                with open(new_files[rel], encoding="utf-8", errors="replace") as fn:
                    nl = fn.readlines()
                if ol == nl:
                    continue
                f.write(f"=== {rel} ===\n")
                f.writelines(difflib.unified_diff(ol, nl, fromfile=f"a/{rel}", tofile=f"b/{rel}"))

    summary = {
        "old_version": args.old_version,
        "new_version": args.new_version,
        "old_files": len(old_files),
        "new_files": len(new_files),
        "added": len(added),
        "removed": len(removed),
        "modified": len(modified),
        "security_modified": len(sec_modified),
        "report": args.out,
    }
    if args.summary_out:
        os.makedirs(os.path.dirname(args.summary_out), exist_ok=True)
        with open(args.summary_out, "w") as f:
            json.dump(summary, f, indent=2)

    print(json.dumps(summary, indent=2))


if __name__ == "__main__":
    main()
