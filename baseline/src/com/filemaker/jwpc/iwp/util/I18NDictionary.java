/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;

public class I18NDictionary
implements Serializable {
    protected HashMap<String, Properties> languages = new HashMap();
    protected HashMap<String, Properties> countries = new HashMap();
    private String defaultLanguage = "en";

    public String get(Locale locale, String string) {
        return this.get(locale.getLanguage(), locale.getCountry(), string);
    }

    private String get(String string, String string2, String string3) {
        Properties properties = this.getLanguageBundle(string, string2);
        return properties.getProperty(string3, this.getLanguageBundle(this.getDefaultLanguage(), "").getProperty(string3, string3));
    }

    private void loadWords(String string, String string2, Reader reader) throws IOException {
        Properties properties = this.getLanguageBundle(string, string2);
        properties.load(reader);
        try {
            reader.close();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private void loadWords(String string, String string2, File file, boolean bl) throws IOException {
        Properties properties = this.getLanguageBundle(string, string2);
        if (!properties.containsKey(file.getAbsolutePath()) || bl) {
            properties.put(file.getAbsolutePath(), "1");
            this.loadWords(string, string2, new InputStreamReader((InputStream)new FileInputStream(file), "utf-8"));
        }
    }

    private Properties getLanguageBundle(String string, String string2) {
        StringBuilder stringBuilder;
        String string3;
        Properties properties = null;
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("Language code cannot be null or empty. " + string);
        }
        String string4 = string.toLowerCase();
        String string5 = string3 = string2 == null ? "" : string2.toLowerCase();
        if (this.countries.size() > 0) {
            stringBuilder = new StringBuilder(string4);
            stringBuilder.append("_");
            stringBuilder.append(string3);
            properties = this.countries.get(stringBuilder.toString());
            stringBuilder = null;
        }
        if (properties == null) {
            properties = this.languages.get(string4);
        }
        if (properties == null) {
            properties = new Properties();
            this.languages.put(string4, properties);
            if (!string3.isEmpty()) {
                stringBuilder = new StringBuilder(string4);
                stringBuilder.append("_");
                stringBuilder.append(string3);
                this.countries.put(stringBuilder.toString(), properties);
                stringBuilder = null;
            }
        }
        return properties;
    }

    private String getDefaultLanguage() {
        return this.defaultLanguage;
    }

    public void setDefaultLanguage(String string) {
        this.defaultLanguage = string;
    }

    public void loadTranslationFilesFromThemeFolder(File file) throws IOException {
        File file2 = new File(file, "i18n");
        if (file2.exists() && file2.isDirectory()) {
            File[] fileArray;
            for (File file3 : fileArray = file2.listFiles()) {
                if (!file3.isDirectory()) continue;
                this.loadTranslationsFromLanguageDirectory(file3);
            }
        }
        file2 = null;
    }

    private void loadTranslationsFromLanguageDirectory(File file) throws IOException {
        File[] fileArray = file.listFiles();
        Object object = file.getName();
        Object object2 = "";
        if (((String)object).contains("_")) {
            Object[] objectArray = ((String)object).split("_");
            object = objectArray[0];
            object2 = objectArray[1];
        }
        for (File file2 : fileArray) {
            if (!file2.getName().toLowerCase().endsWith(".properties")) continue;
            this.loadWords((String)object, (String)object2, file2, true);
        }
    }

    public void clear() {
        this.languages.clear();
        this.countries.clear();
    }
}

