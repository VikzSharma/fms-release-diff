#!/usr/bin/env bash
# extract_jars.sh - Extract the FileMaker web-tier jars from an installer zip.
#
# Usage: scripts/extract_jars.sh <installer.zip> <workdir>
#
# Pipeline: zip -> .deb -> dpkg-deb -x -> jwpc.war -> WEB-INF/lib jars
set -euo pipefail

ZIP="${1:?usage: extract_jars.sh <installer.zip> <workdir>}"
WORK="${2:?usage: extract_jars.sh <installer.zip> <workdir>}"
PE_SUB="opt/FileMaker/FileMaker Server/Web Publishing/publishing-engine"

mkdir -p "$WORK/unpacked" "$WORK/debroot" "$WORK/jars"

echo "[*] unzipping installer"
unzip -o -q "$ZIP" -d "$WORK/unpacked"

DEB=$(find "$WORK/unpacked" -maxdepth 1 -name "*.deb" | head -1)
[ -n "$DEB" ] || { echo "error: no .deb in installer" >&2; exit 1; }
echo "[*] deb: $(basename "$DEB")"

echo "[*] extracting deb"
dpkg-deb -x "$DEB" "$WORK/debroot"

WAR=$(find "$WORK/debroot" -name "jwpc.war" | head -1)
[ -n "$WAR" ] || { echo "error: jwpc.war not found in deb" >&2; exit 1; }
echo "[*] war: $WAR"

echo "[*] extracting FileMaker jars from war"
cd "$WORK/jars"
for j in $(unzip -l "$WAR" | awk '{print $4}' | grep -E '^WEB-INF/lib/[^/]+\.jar$'); do
    case "$j" in
        *jwpc*|*fmwp*|*fmi_core*|*idl*|*atmosphere*|*fmi.jar|*ContextMenu*|*ImageScaler*|*ScrollEventPanel*|*countdownclock*)
            unzip -o -j -q "$WAR" "$j" || true ;;
    esac
done

# fm_tomcat.jar lives in the tomcat tree, not inside the war
FM_TOMCAT=$(find "$WORK/debroot" -name "fm_tomcat.jar" | head -1)
[ -n "$FM_TOMCAT" ] && cp "$FM_TOMCAT" .

# record the deb version for the report/state
dpkg-deb -f "$DEB" Version > "$WORK/version.txt" 2>/dev/null || true

echo "[+] jars staged: $(ls *.jar | wc -l)"
ls -la "$WORK/jars"
