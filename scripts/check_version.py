#!/usr/bin/env python3
"""
check_version.py - Check Claris's public updaters feed for a FileMaker Server
release newer than the one recorded in state/version.json.

Writes GitHub Actions outputs (GITHUB_OUTPUT) and plain stdout:
    version=<x.y.z>          newest FileMaker Server Linux version in the feed
    new_release=true|false   true if feed version differs from recorded state

Exits 0 in both cases (skip vs process); exits 1 only on feed errors.
"""
import json
import os
import re
import sys
import urllib.request

FEED_URL = "https://www.claris.com/cms/resources/downloads/updaters/product-updaters.txt"
STATE_FILE = os.path.join(os.path.dirname(__file__), "..", "state", "version.json")


def version_tuple(v):
    return tuple(int(x) for x in v.split("."))


def main():
    try:
        with urllib.request.urlopen(FEED_URL, timeout=30) as r:
            data = json.load(r)
    except Exception as e:
        print(f"error fetching feed: {e}", file=sys.stderr)
        sys.exit(1)

    versions = set()
    for item in data:
        product = str(item.get("product", "")).strip()
        platform = str(item.get("platform", "")).strip()
        if product.startswith("FileMaker Server") and platform == "Linux":
            m = re.search(r"\((\d+\.\d+\.\d+)\)", str(item.get("version", "")))
            if m:
                versions.add(m.group(1))

    if not versions:
        print("error: no FileMaker Server Linux versions found in feed", file=sys.stderr)
        sys.exit(1)

    latest = max(versions, key=version_tuple)

    state_version = None
    if os.path.exists(STATE_FILE):
        try:
            with open(STATE_FILE) as f:
                state_version = json.load(f).get("version")
        except Exception:
            pass

    new_release = "true" if (state_version is None or version_tuple(latest) > version_tuple(state_version)) else "false"

    out = f"version={latest}\nnew_release={new_release}\n"
    with open(os.environ.get("GITHUB_OUTPUT", "/dev/stdout"), "a") as f:
        f.write(out)
    print(f"feed latest: {latest} | recorded: {state_version} | new_release: {new_release}")


if __name__ == "__main__":
    main()
