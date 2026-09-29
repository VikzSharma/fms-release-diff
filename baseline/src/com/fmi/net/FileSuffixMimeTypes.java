/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.net;

import com.fmi.net.URI;
import com.fmi.net.URIInputStream;
import com.fmi.net.UnsupportedSchemeException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashMap;

public class FileSuffixMimeTypes {
    private HashMap m_mimeTypes;

    public FileSuffixMimeTypes() {
        try {
            this.m_mimeTypes = new HashMap(150);
            this.loadMimeTypes(new URI("resource:/com/fmi/net/mime.types"));
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void addFileSuffix(String suffix, String mimeType) {
        this.m_mimeTypes.put(suffix, mimeType);
    }

    public String getMimeType(String suffix) {
        return (String)this.m_mimeTypes.get(suffix);
    }

    public void loadMimeTypes(URI mimeTypesURI) throws UnsupportedSchemeException, IOException {
        BufferedReader mimeTypesFile = null;
        try {
            String line;
            mimeTypesFile = new LineNumberReader(new InputStreamReader(new BufferedInputStream(new URIInputStream(mimeTypesURI))));
            while ((line = ((LineNumberReader)mimeTypesFile).readLine()) != null) {
                String mimeType = null;
                int tokenStartIndex = 0;
                boolean lastCharWhiteSpace = true;
                int lineLength = line.length();
                int endOfLineIndex = lineLength - 1;
                if (lineLength <= 0 || line.charAt(0) == '#') continue;
                int i = 0;
                while (i < lineLength) {
                    boolean currentCharWhiteSpace;
                    char currentChar = line.charAt(i);
                    boolean bl = currentCharWhiteSpace = currentChar == '\t' || currentChar == ' ';
                    if (currentCharWhiteSpace || i == endOfLineIndex) {
                        if (!lastCharWhiteSpace || !currentCharWhiteSpace) {
                            if (mimeType == null) {
                                mimeType = i == endOfLineIndex ? line.substring(tokenStartIndex) : line.substring(tokenStartIndex, i);
                            } else if (i == endOfLineIndex) {
                                this.m_mimeTypes.put(line.substring(tokenStartIndex), mimeType);
                            } else {
                                this.m_mimeTypes.put(line.substring(tokenStartIndex, i), mimeType);
                            }
                        }
                    } else if (lastCharWhiteSpace) {
                        tokenStartIndex = i;
                    }
                    lastCharWhiteSpace = currentCharWhiteSpace;
                    ++i;
                }
            }
        }
        finally {
            if (mimeTypesFile != null) {
                mimeTypesFile.close();
            }
        }
    }
}

