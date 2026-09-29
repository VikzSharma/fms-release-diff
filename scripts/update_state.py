#!/usr/bin/env python3
"""update_state.py - Write state/version.json after processing a release."""
import json
import sys
from datetime import datetime, timezone

if len(sys.argv) < 3:
    print("usage: update_state.py <full-version> <feed-version> [installer-url]", file=sys.stderr)
    sys.exit(1)

full = sys.argv[1]
feed = sys.argv[2]
url = sys.argv[3] if len(sys.argv) > 3 else "manual"
version = ".".join(full.split(".")[:3])

state = {
    "version": version,
    "build": full,
    "feed_version": feed,
    "installer_url": url,
    "processed_at": datetime.now(timezone.utc).isoformat(),
}
with open("state/version.json", "w") as f:
    json.dump(state, f, indent=2)
print(json.dumps(state, indent=2))
