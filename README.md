# fms-release-diff

Autonomous Claris FileMaker Server release monitor. When Claris ships a new
FileMaker Server release, this project automatically:

1. **Detects the new release** from Claris's public updaters feed
   (`https://www.claris.com/cms/resources/downloads/updaters/product-updaters.txt`)
2. **Downloads the Ubuntu installer** by resolving the trial download URL
   pattern (`https://downloads.claris.com/TBUB/<major>/fms_<ver>.<build>_Ubuntu24_amd64.zip`,
   build number discovered by probing - valid builds return `206`, invalid ones
   redirect to an error page)
3. **Extracts the web-tier jars** from the installer (`jwpc.war` -> `jwpc.jar`,
   `fmwp.jar`, `fmi_core_lib.jar`, `idl.jar`, `fm_tomcat.jar`, fmi utility jars)
4. **Decompiles them with CFR** (identical pipeline every release, so diffs are
   apples-to-apples)
5. **Generates a markdown diff report** vs the previous release, highlighting
   security-relevant changes (auth, privileges, headers, sessions, crypto,
   uploads, ...)
6. **Commits** the new decompiled baseline, the state, and the report

The scheduled workflow exits early unless a new release is detected, so it
only does real work when Claris actually ships something.

## Layout

```
scripts/check_version.py       # feed check + state comparison
scripts/download_installer.sh  # URL resolution (pattern probe or manual link)
scripts/extract_jars.sh        # installer zip -> deb -> war -> jars
scripts/decompile.sh           # CFR decompile of the FM jars
scripts/diff_report.py         # source diff -> markdown report
.github/workflows/watch.yml    # daily cron + manual dispatch
state/version.json             # last processed release
baseline/src/                  # decompiled source of the last processed release
reports/                       # generated release-diff reports
```

## Usage

- **Automatic:** runs daily at 06:00 UTC via GitHub Actions. No-op unless a new
  FileMaker Server Linux release appears in the feed.
- **Manual self-test:** Actions -> *watch-fms-releases* -> *Run workflow* with
  `force=true` re-processes the current release (expect an empty diff).
- **New release with a non-standard link:** run the workflow with `manual_url`
  set to a fresh trial link (the pattern probe usually makes this unnecessary).

## Slack notifications

Every run posts to Slack:

- 🟢 **Daily heartbeat** — no new release, latest processed version
- 🚀 **New release alert** — version, change counts (added/removed/modified/
  security-relevant), link to the full report
- 🔴 **Failure alert** — if the workflow errors, link to the run logs

The webhook URL lives in `config/slack_webhook.txt`. For better hygiene, add it
as the `SLACK_WEBHOOK_URL` repository secret instead (Settings → Secrets and
variables → Actions) — the secret takes precedence over the committed file.

## Generate a report locally

```bash
scripts/download_installer.sh 26.0.4 work
scripts/extract_jars.sh work/installer.zip work
scripts/decompile.sh work/jars work/src
python3 scripts/diff_report.py --old baseline/src --new work/src \
    --old-version 26.0.3.309 --new-version 26.0.4.X \
    --out reports/26.0.3.309_to_26.0.4.X.md
```

## ⚠️ Keep this repository private

`baseline/src/` and the reports contain **decompiled proprietary Claris
code**. Do not make this repository public.
