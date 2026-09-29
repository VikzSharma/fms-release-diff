/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.log.JWPCLogger
 */
package com.filemaker.jwpc.fmwp.datatype;

import com.filemaker.jwpc.fmwp.util.DataConverter;
import com.filemaker.jwpc.log.JWPCLogger;
import java.util.HashSet;

public class UniversalPath
implements Cloneable {
    private static JWPCLogger logger = JWPCLogger.getLogger(UniversalPath.class);
    public static final char Char_Delete = '\u007f';
    public static final char Char_PrivateUse0 = '\ue000';
    public static final char Char_PrivateUse1 = '\ue001';
    public static final char pathSeparator = '/';
    public static final String pathSeparatorStr = "/";
    public static final char uniPathSeparator = '\ue000';
    private static final char[] uniPathSeparatorArray = new char[]{'\ue000'};
    public static final String uniPathSeparatorStr = new String(uniPathSeparatorArray);
    public static final char parentDirectory = '\ue001';
    public static final char[] parentDirectoryArray = new char[]{'\ue001'};
    public static final String parentDirectoryStr = new String(parentDirectoryArray);
    public static final char uniStringSeparator = '\u007f';
    private static final char[] uniStringSeparatorArray = new char[]{'\u007f'};
    public static final String uniStringSeparatorStr = new String(uniStringSeparatorArray);
    public static final char typeSeparator = ':';
    public static final String typeSeparatorStr = ":";
    public static final String fileType = "file";
    public static final String winFileType = "filewin";
    public static final String macFileType = "filemac";
    public static final String fmNetFileType = "fmnet";
    public static final String imageType = "image";
    public static final String winImageType = "imagewin";
    public static final String macImageType = "imagemac";
    public static final String movieType = "movie";
    public static final String winMovieType = "moviewin";
    public static final String macMovieType = "moviemac";
    public static final char[] addrDot = new char[]{'\\', '.'};
    public static final String addrDotDeliminator = new String(new char[]{'\\', '.'});
    private static HashSet<String> pathTypeSet = new HashSet();
    private String mType;
    private String mPath;
    private String mDirectory;
    private String mName;
    private String mFQName;

    public UniversalPath() {
    }

    public UniversalPath(String string) {
        int n = string.indexOf(58);
        String string2 = null;
        if (n < 0) {
            this.setType(fmNetFileType);
            string2 = string;
        } else if (n != 0) {
            String string3 = string.substring(0, n);
            if (pathTypeSet.contains(string3)) {
                this.setType(string3);
                string2 = string.substring(n + 1);
            } else {
                this.setType(fileType);
                string2 = string;
            }
        }
        if (string2 != null) {
            n = string2.lastIndexOf(pathSeparatorStr);
            if (n < 0) {
                this.setPath(pathSeparatorStr + DataConverter.hostAddress + pathSeparatorStr);
                this.setName(string2);
            } else if (string2.endsWith(pathSeparatorStr)) {
                this.setPath(string2);
            } else {
                this.setPath(string2.substring(0, n + 1));
                this.setName(string2.substring(n + 1));
            }
        }
    }

    public UniversalPath(String string, String string2, String string3) {
        this.setType(string);
        this.setPath(string2);
        this.setName(string3);
    }

    public UniversalPath(UniversalPath universalPath) {
        this.mType = universalPath.mType;
        this.mPath = universalPath.mPath;
        this.mName = universalPath.mName;
    }

    public String getType() {
        return this.mType;
    }

    public String getPath() {
        return this.mPath;
    }

    public String getUniPath() {
        String string = this.mPath.replace('/', '\ue000');
        return string;
    }

    public String getDirectory() {
        return this.mDirectory;
    }

    public String getName() {
        return this.mName;
    }

    public String getFQName() {
        return this.mFQName;
    }

    public synchronized void setFQName(String string) {
        if (string != null && string.length() > 0) {
            int n = string.indexOf(typeSeparatorStr);
            String string2 = null;
            String string3 = null;
            if (n > 0) {
                string3 = string.substring(0, n);
                if (!(string3.equalsIgnoreCase(fileType) || string3.equalsIgnoreCase(fmNetFileType) || string3.equalsIgnoreCase(winFileType) || string3.equalsIgnoreCase(macFileType))) {
                    this.mType = fileType;
                    string2 = string;
                    logger.debug("setFQName() unknow file type " + string3 + ", file name set to " + string2);
                } else {
                    this.mType = string3;
                    string2 = string.substring(n + 1);
                }
            } else {
                this.mType = fileType;
                string2 = string;
                logger.debug("setFQName() cannot find file type, file name set to " + string2);
            }
            n = string2.lastIndexOf(47);
            if (n > 0) {
                this.mPath = string2.substring(0, n + 1);
                if (this.mPath.length() < string2.length()) {
                    this.mName = string2.substring(n + 1);
                } else {
                    logger.debug("setFQName() path " + string + " only has a path part " + this.mPath);
                }
            } else {
                this.mName = string2;
                logger.debug("setFQName() path " + string + " only has a name part " + this.mName);
            }
            this.setDirectory();
        }
    }

    public int extensionLocation(String string) {
        int n = string.length();
        if (n > 0) {
            int n2;
            --n;
            for (n2 = 0; n >= 0 && string.charAt(n) != '.' && n2 < 5; ++n2, --n) {
            }
            if (n < 0 || n2 > 4) {
                n = string.length();
            }
        }
        return n;
    }

    public String getBasename() {
        Object object = this.getName();
        int n = this.extensionLocation((String)object);
        int n2 = ((String)object).length() - n;
        if (n2 > 0) {
            object = ((String)object).substring(0, n) + ((String)object).substring(n2 + n);
        }
        return object;
    }

    public static String URLLightEncode(String string) {
        char[] cArray = string.toCharArray();
        int n = cArray.length;
        StringBuilder stringBuilder = new StringBuilder(n);
        for (int i = 0; i < n; ++i) {
            if (cArray[i] == '%') {
                stringBuilder.append('%');
                stringBuilder.append('2');
                stringBuilder.append('5');
                continue;
            }
            if (cArray[i] == '/') {
                stringBuilder.append('%');
                stringBuilder.append('2');
                stringBuilder.append('5');
                continue;
            }
            stringBuilder.append(cArray[i]);
        }
        return stringBuilder.toString();
    }

    public static String URLLightDecode(String string) {
        Object object = new String(new StringBuilder(string).reverse());
        if (object != null && ((String)object).length() != 0) {
            char[] cArray = ((String)object).toCharArray();
            int n = 0;
            while (n < cArray.length) {
                if (cArray[n] == '%') {
                    Integer n2 = 0;
                    Integer n3 = 0;
                    if (n == cArray.length - 1) {
                        object = (String)object + "%";
                        continue;
                    }
                    char c = cArray[n];
                    if (++n == string.length() || !UniversalPath.decodeHexNybble(c, n2)) {
                        object = (String)object + "%";
                        object = (String)object + c;
                        continue;
                    }
                    char c2 = cArray[n];
                    ++n;
                    if (!UniversalPath.decodeHexNybble(c2, n3)) {
                        object = (String)object + "%";
                        object = (String)object + c;
                        object = (String)object + c2;
                        continue;
                    }
                    object = (String)object + (char)(n2 << 4 | n3);
                    continue;
                }
                object = (String)object + cArray[n];
                ++n;
            }
        }
        return object;
    }

    public static boolean decodeHexNybble(char c, Integer n) {
        int n2 = -1;
        if (c >= '0' && c <= '9') {
            n2 = c - 48;
        } else if (c >= 'A' && c <= 'F') {
            n2 = c + -55;
        } else if (c >= 'a' && c <= 'f') {
            n2 = c + -87;
        }
        return n2 >= 0;
    }

    public boolean isValid() {
        char c;
        boolean bl;
        boolean bl2 = this.mPath == null || this.mPath.length() == 0;
        boolean bl3 = this.mName == null || this.mName.length() == 0;
        boolean bl4 = bl = !bl2 || !bl3;
        if (bl && !bl2) {
            c = this.mPath.charAt(this.mPath.length() - 1);
            boolean bl5 = bl = c == '/';
        }
        if (this.mType.equalsIgnoreCase(fmNetFileType)) {
            if (1 >= this.countPathElements()) {
                bl = false;
            } else if (!this.isAbsolute()) {
                bl = false;
            } else {
                c = '\u0000';
                String string = this.getPathElement(1);
                String[] stringArray = string.split(addrDotDeliminator);
                if (stringArray.length == 4) {
                    for (int i = 0; c == '\u0000' && i < stringArray.length; ++i) {
                        try {
                            short s = Short.parseShort(stringArray[i]);
                            if (s >= 0 && s <= 255) continue;
                            c = '\u0001';
                            continue;
                        }
                        catch (NumberFormatException numberFormatException) {
                            c = '\u0001';
                        }
                    }
                }
                bl = c == '\u0000';
            }
        }
        return bl;
    }

    public boolean isAbsolute() {
        return this.mPath.length() != 0 ? this.mPath.charAt(0) == '/' || this.mPath.charAt(0) == '\ue000' : false;
    }

    public int countPathElements() {
        int n;
        int n2 = 0;
        if (this.mPath != null && (n = this.mPath.length()) != 0) {
            char[] cArray = this.mPath.toCharArray();
            for (int i = 0; i < n; ++i) {
                if (cArray[i] != '/') continue;
                ++n2;
            }
        }
        return n2;
    }

    public String getPathElement(int n) {
        String string = null;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        if (this.mPath != null) {
            while (true) {
                if ((n4 = this.mPath.indexOf(47, n3)) == -1) {
                    n4 = this.mPath.indexOf(57344, n3);
                }
                if (n4 == -1) break;
                if (n2 == n) {
                    string = new String(this.mPath.substring(n3, n4));
                    break;
                }
                n3 = n4 + 1;
                ++n2;
            }
        }
        return string;
    }

    private synchronized void setType(String string) {
        this.mType = string;
        if (this.mDirectory != null) {
            this.setDirectory();
        }
    }

    public synchronized void setPath(String string) {
        this.mPath = string.replace('\ue000', '/');
        this.setDirectory();
    }

    private void setDirectory() {
        this.mDirectory = this.mType != null ? this.mType + typeSeparatorStr + this.mPath : this.mPath;
        this.mFQName = this.mName != null ? this.mDirectory + this.mName : this.mDirectory;
    }

    private void setName(String string) {
        this.mName = string.replace('\ue000', '/');
        if (this.mName != null) {
            this.mFQName = this.mDirectory + this.mName;
        }
    }

    public String toString() {
        return this.mFQName;
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof UniversalPath) {
            UniversalPath universalPath = (UniversalPath)object;
            if (this.mFQName.equalsIgnoreCase(universalPath.mFQName)) {
                bl = true;
            }
        }
        return bl;
    }

    public boolean isDirectory() {
        return this.mName.length() == 0;
    }

    public UniversalPath clone() {
        return new UniversalPath(this);
    }

    public static boolean checkPathType(String string) {
        boolean bl = false;
        if (pathTypeSet.contains(string)) {
            bl = true;
        }
        return bl;
    }

    static {
        pathTypeSet.add(fileType);
        pathTypeSet.add(fmNetFileType);
        pathTypeSet.add(winFileType);
        pathTypeSet.add(macFileType);
    }
}

