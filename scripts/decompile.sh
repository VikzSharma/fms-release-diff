#!/usr/bin/env bash
# decompile.sh - Decompile the FileMaker web-tier jars with CFR.
#
# Usage: scripts/decompile.sh <jars-dir> <src-outdir>
#
# The jar set mirrors the canonical set used to seed the baseline:
# jwpc, fmwp, fmi_core_lib, idl, fm_tomcat + the small fmi utility jars.
set -euo pipefail

JARSDIR="${1:?usage: decompile.sh <jars-dir> <src-outdir>}"
SRC="${2:?usage: decompile.sh <jars-dir> <src-outdir>}"
CFR_VERSION="0.152"
CFR_URL="https://repo1.maven.org/maven2/org/benf/cfr/${CFR_VERSION}/cfr-${CFR_VERSION}.jar"

mkdir -p "$SRC"
CFR="$JARSDIR/cfr.jar"
[ -f "$CFR" ] || { wget -q "$CFR_URL" -O "$CFR"; }

JARS=$(ls "$JARSDIR" | grep -E '^(jwpc|fmwp|fmi_core_lib|idl|fm_tomcat|.*\.fmi)\.jar$' | grep -v cfr || true)
# always include the FM core set if present
for j in jwpc fmwp fmi_core_lib idl fm_tomcat; do
    [ -f "$JARSDIR/$j.jar" ] && JARS="$JARS $j.jar"
done
JARS=$(echo $JARS | tr ' ' '\n' | sort -u | tr '\n' ' ')

echo "[*] decompiling: $JARS"
for j in $JARS; do
    echo "    - $j"
    java -jar "$CFR" "$JARSDIR/$j" --outputdir "$SRC" --silent true 2>/dev/null | tail -1 || true
done

COUNT=$(find "$SRC" -name "*.java" | wc -l)
echo "[+] decompiled: $COUNT java files"
[ "$COUNT" -gt 100 ] || { echo "error: suspiciously few files ($COUNT)" >&2; exit 1; }
