#!/usr/bin/env bash
# download_installer.sh - Resolve and download the FileMaker Server Ubuntu installer.
#
# Usage:
#   scripts/download_installer.sh <download-url-or-version> [output-dir]
#
#   - If the argument starts with http(s)://, download that URL directly
#     (use for fresh trial links that do not follow the TBUB pattern).
#   - Otherwise treat it as a version (e.g. 26.0.4) and discover the build
#     number by probing the known URL pattern:
#       https://downloads.claris.com/TBUB/<major>/fms_<ver>.<build>_Ubuntu24_amd64.zip
#     Invalid builds redirect (302) to the error page; valid ones return 200/206.
set -euo pipefail

ARG="${1:?usage: download_installer.sh <url-or-version> [outdir]}"
OUTDIR="${2:-work}"
mkdir -p "$OUTDIR"

download() {
    local url="$1" dest="$2"
    echo "[*] downloading $url"
    wget -q --show-progress --progress=dot:giga -O "$dest" "$url"
    echo "[+] saved: $dest ($(du -h "$dest" | cut -f1))"
}

if [[ "$ARG" == http* ]]; then
    download "$ARG" "$OUTDIR/installer.zip"
    exit 0
fi

VERSION="$ARG"
MAJOR="${VERSION%%.*}"                 # 26.0.4 -> 26
UBUNTUS=("Ubuntu24" "Ubuntu22")

# Discover the build number: probe builds in parallel, keep the max valid one.
find_build() {
    local uver="$1" found=""
    local seq=$(seq 1 400)
    local results
    results=$(printf '%s\n' $seq | xargs -P 16 -I{} bash -c '
        url="https://downloads.claris.com/TBUB/'"$MAJOR"'/fms_'"$VERSION"'.{}_'"$uver"'_amd64.zip"
        code=$(curl -s -o /dev/null -w "%{http_code}" -m 15 -r 0-0 "$url" 2>/dev/null || echo 000)
        if [ "$code" = "206" ] || [ "$code" = "200" ]; then echo "{}"; fi
    ' 2>/dev/null || true)
    found=$(printf '%s\n' $results | sort -n | tail -1)
    echo "$found"
}

for uver in "${UBUNTUS[@]}"; do
    echo "[*] probing builds for $VERSION ($uver) ..."
    BUILD=$(find_build "$uver")
    if [ -n "$BUILD" ]; then
        URL="https://downloads.claris.com/TBUB/$MAJOR/fms_${VERSION}.${BUILD}_${uver}_amd64.zip"
        echo "[+] resolved: $URL"
        download "$URL" "$OUTDIR/installer.zip"
        echo "$URL" > "$OUTDIR/installer.url"
        exit 0
    fi
done

echo "error: could not resolve an installer URL for $VERSION" >&2
echo "hint: trigger the workflow with manual_url set to a fresh trial link" >&2
exit 1
