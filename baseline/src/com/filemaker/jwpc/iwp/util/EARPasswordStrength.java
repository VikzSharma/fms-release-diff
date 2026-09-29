/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.util;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.util.Utilities;

public class EARPasswordStrength {
    private static int kEARNewPassword_WeakMax = 11;
    private static int kEARNewPassword_ModerateMax = 25;

    public static String EARPaswordQualityDescription(App app, String string) {
        String string2 = "";
        if (Utilities.isEmptyString(string)) {
            return IWPI18N.get(app, "WEAK", new Object[0]);
        }
        EPasswordStrength ePasswordStrength = EARPasswordStrength.EARPaswordStrength(string);
        switch (ePasswordStrength.ordinal()) {
            case 0: {
                string2 = IWPI18N.get(app, "WEAK", new Object[0]);
                break;
            }
            case 1: {
                string2 = IWPI18N.get(app, "MODERATE", new Object[0]);
                break;
            }
            case 2: {
                string2 = IWPI18N.get(app, "STRONG", new Object[0]);
            }
        }
        return string2;
    }

    private static EPasswordStrength EARPaswordStrength(String string) {
        int n = EARPasswordStrength.EARPaswordQuality(string);
        EPasswordStrength ePasswordStrength = EPasswordStrength.kPW_Weak;
        if (n > kEARNewPassword_WeakMax && n <= kEARNewPassword_ModerateMax) {
            ePasswordStrength = EPasswordStrength.kPW_Moderate;
        } else if (n > kEARNewPassword_ModerateMax) {
            ePasswordStrength = EPasswordStrength.kPW_Strong;
        }
        return ePasswordStrength;
    }

    private static int EARPaswordQuality(String string) {
        String string2 = string;
        char[] cArray = string2.toCharArray();
        int n = cArray.length;
        int n2 = 0;
        if (n < 8) {
            n2 = (int)((double)n / 3.0);
        } else if (n >= 8 && n < 12) {
            n2 = n;
        } else {
            char c = '\u0000';
            int n3 = 0;
            int n4 = 0;
            int n5 = 0;
            double d = 0.0;
            Boolean bl = false;
            Boolean bl2 = false;
            Boolean bl3 = false;
            Boolean bl4 = false;
            Boolean bl5 = false;
            block5: for (int i = 0; i < n; ++i) {
                c = cArray[i];
                if (c >= 'a' && c <= 'z') {
                    n3 = 1;
                    bl = true;
                } else if (c >= 'A' && c <= 'Z') {
                    n3 = 2;
                    bl2 = true;
                } else if (c >= '0' && c <= '9') {
                    n3 = 3;
                    bl3 = true;
                } else if (c == ',' || c == '.' || c == '!' || c == '@' || c == '#' || c == '$' || c == '*') {
                    n3 = 4;
                    bl4 = true;
                } else {
                    n3 = 5;
                    bl5 = true;
                }
                n5 = n3 == n4 ? (int)((char)(n5 + 1)) : 0;
                n4 = n3;
                switch (n5) {
                    case 0: {
                        d += (double)n3 * 0.1 * ((double)n * 1.3);
                        continue block5;
                    }
                    case 1: {
                        d += (double)n3 * 0.033 * ((double)n * 1.3);
                        continue block5;
                    }
                    case 2: {
                        d += (double)n3 * 0.002 * ((double)n * 1.3);
                        continue block5;
                    }
                    default: {
                        d += (double)n3 * 1.0E-4 * ((double)n * 1.3);
                    }
                }
            }
            n2 = bl5 != false && bl4 != false && bl3 != false && bl2 != false && bl != false ? (int)(d / 1.9) : (bl4 != false && bl3 != false && bl2 != false && bl != false ? (int)(d / 2.2) : (bl3 != false && bl2 != false && bl != false ? (int)(d / 2.5) : (!(bl5 == false && bl4 == false || bl3 == false && bl2 == false || bl == false) ? (int)(d / 2.8) : ((bl5 != false || bl4 != false || bl3 != false || bl2 != false) && bl != false ? (int)(d / 4.0) : (int)(d / 8.0)))));
            if (n2 < 11) {
                n2 = 11;
            }
        }
        return n2;
    }

    private static enum EPasswordStrength {
        kPW_Weak,
        kPW_Moderate,
        kPW_Strong;

    }
}

