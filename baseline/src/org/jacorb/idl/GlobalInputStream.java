/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log.Logger
 */
package org.jacorb.idl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;
import java.util.StringTokenizer;
import org.apache.log.Logger;
import org.jacorb.idl.PositionInfo;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;

public class GlobalInputStream {
    private static InputStream stream;
    private static Stack lookahead_stack;
    private static boolean included;
    private static StringBuffer expandedText;
    private static int pos;
    private static boolean eof;
    private static File currentFile;
    private static String[] path_names;
    private static Logger logger;
    static Stack positions;

    public static void init() {
        lookahead_stack = new Stack();
        included = false;
        expandedText = new StringBuffer();
        pos = 0;
        eof = false;
        currentFile = null;
        positions = new Stack();
        logger = parser.getLogger();
    }

    public static void setInput(String string) throws IOException {
        currentFile = new File(string);
        stream = new FileInputStream(currentFile);
    }

    public static boolean isMoreRecentThan(File file) {
        return parser.forceOverwrite || file.lastModified() < currentFile.lastModified();
    }

    public static boolean includeState() {
        return included;
    }

    public static void insert(String string) {
        expandedText.insert(pos, string);
    }

    public static void include(String string, int n, boolean bl) throws FileNotFoundException {
        included = true;
        PositionInfo positionInfo = lexer.getPosition();
        positionInfo.file = GlobalInputStream.currentFile();
        positionInfo.stream = stream;
        stream = GlobalInputStream.find(string, bl);
        positions.push(positionInfo);
        lookahead_stack.push(new Integer(n));
        if (logger.isInfoEnabled()) {
            logger.info("Including " + string);
        }
    }

    public static void setIncludePath(String string) {
        int n;
        StringTokenizer stringTokenizer = new StringTokenizer(string, File.pathSeparator);
        if (path_names == null) {
            path_names = new String[stringTokenizer.countTokens()];
            n = 0;
        } else {
            n = path_names.length;
            String[] stringArray = new String[stringTokenizer.countTokens() + path_names.length];
            for (int i = 0; i < path_names.length; ++i) {
                stringArray[i] = path_names[i];
            }
            path_names = stringArray;
        }
        while (stringTokenizer.hasMoreTokens()) {
            GlobalInputStream.path_names[n++] = stringTokenizer.nextToken();
        }
    }

    private static FileInputStream find(String string, boolean bl) throws FileNotFoundException {
        if (!bl) {
            if (string.indexOf(File.separator) != 0) {
                String string2 = null;
                try {
                    string2 = currentFile.getCanonicalPath();
                    if (string2.indexOf(File.separator) > -1) {
                        string2 = string2.substring(0, string2.lastIndexOf(File.separator));
                    }
                }
                catch (IOException iOException) {
                    logger.error("Caught error finding file ", (Throwable)iOException);
                }
                if (logger.isInfoEnabled()) {
                    logger.info("opening " + string2 + File.separator + string);
                }
                currentFile = new File(string2 + File.separator + string);
            } else {
                currentFile = new File(string);
            }
            try {
                return new FileInputStream(currentFile);
            }
            catch (IOException iOException) {
                return GlobalInputStream.find(string, true);
            }
        }
        if (path_names == null) {
            parser.fatal_error("File " + string + " not found in include path", null);
        } else {
            for (int i = 0; i < path_names.length; ++i) {
                try {
                    if (logger.isInfoEnabled()) {
                        logger.info("opening " + path_names[i] + File.separator + string);
                    }
                    currentFile = new File(path_names[i] + File.separator + string);
                    return new FileInputStream(currentFile);
                }
                catch (FileNotFoundException fileNotFoundException) {
                    continue;
                }
            }
        }
        parser.fatal_error("File " + string + " not found in include path", null);
        return null;
    }

    public static File currentFile() {
        return currentFile;
    }

    public static InputStream currentStream() {
        return stream;
    }

    public static int read() throws IOException {
        int n = 0;
        if (eof && positions.size() == 0) {
            return -1;
        }
        if (expandedText.length() > 0) {
            if (pos < expandedText.length()) {
                n = expandedText.charAt(pos++);
            }
            if (pos == expandedText.length()) {
                expandedText = new StringBuffer();
                pos = 0;
            }
        } else {
            n = GlobalInputStream.currentStream().read();
            if (n == -1) {
                GlobalInputStream.currentStream().close();
                if (included) {
                    parser.setInhibitionState(false);
                    PositionInfo positionInfo = (PositionInfo)positions.pop();
                    stream = positionInfo.stream;
                    currentFile = positionInfo.file;
                    n = (Integer)lookahead_stack.pop();
                    boolean bl = included = !positions.empty();
                    if (logger.isInfoEnabled()) {
                        logger.info("returning to " + currentFile + " included: " + included);
                    }
                    lexer.restorePosition(positionInfo);
                } else {
                    eof = true;
                }
            }
        }
        return n;
    }
}

