#!/usr/bin/env python3
"""
slack_notify.py - Post a message to a Slack incoming webhook.

Usage:
    python3 scripts/slack_notify.py <webhook-url> <message-text>

Exit codes: 0 = delivered, 1 = failure (non-2xx from Slack).
"""
import json
import sys
import urllib.request


def main():
    if len(sys.argv) < 3:
        print("usage: slack_notify.py <webhook-url> <message>", file=sys.stderr)
        sys.exit(1)

    webhook, text = sys.argv[1], sys.argv[2]
    payload = json.dumps({"text": text}).encode()

    req = urllib.request.Request(
        webhook,
        data=payload,
        headers={"Content-Type": "application/json"},
        method="POST",
    )
    try:
        with urllib.request.urlopen(req, timeout=30) as resp:
            body = resp.read().decode(errors="replace")
            print(f"slack response: {resp.status} {body!r}")
            sys.exit(0 if resp.status == 200 else 1)
    except urllib.error.HTTPError as e:
        print(f"slack error: {e.code} {e.read().decode(errors='replace')!r}", file=sys.stderr)
        sys.exit(1)
    except Exception as e:
        print(f"slack error: {e}", file=sys.stderr)
        sys.exit(1)


if __name__ == "__main__":
    main()
