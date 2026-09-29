/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.util;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.util.I18NDictionary;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public final class IWPI18N {
    private static final I18NDictionary DICTIONARY = new I18NDictionary();
    private static boolean initialized = false;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void setDefaultLanguage(String string) {
        I18NDictionary i18NDictionary = DICTIONARY;
        synchronized (i18NDictionary) {
            if (!initialized) {
                initialized = true;
                String string2 = IWPUtilities.mapISO6392CodeToISO6391(AppServlet.getLanguage());
                DICTIONARY.setDefaultLanguage(string2);
                File file = new File(string, "VAADIN/themes/default");
                if (file.exists() && file.isDirectory()) {
                    try {
                        DICTIONARY.loadTranslationFilesFromThemeFolder(file);
                    }
                    catch (IOException iOException) {
                        System.err.println(String.format("Cannot load translation files from the theme folder %s", file));
                        iOException.printStackTrace();
                    }
                }
            }
        }
    }

    public static String get(App app, String string, Object ... objectArray) {
        Locale locale = null;
        if (app != null) {
            locale = app.getLocale();
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return IWPI18N.get(locale, string, objectArray);
    }

    public static String get(Locale locale, String string, Object ... objectArray) {
        String string2 = DICTIONARY.get(locale, string);
        if (objectArray != null && objectArray.length > 0) {
            return String.format(string2, objectArray);
        }
        return string2;
    }
}

