/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log.Logger
 */
package org.jacorb.idl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;
import org.apache.log.Logger;
import org.jacorb.idl.GlobalInputStream;
import org.jacorb.idl.Module;
import org.jacorb.idl.PositionInfo;
import org.jacorb.idl.fixed_token;
import org.jacorb.idl.parser;
import org.jacorb.idl.runtime.char_token;
import org.jacorb.idl.runtime.float_token;
import org.jacorb.idl.runtime.int_token;
import org.jacorb.idl.runtime.long_token;
import org.jacorb.idl.runtime.token;
import org.jacorb.idl.str_token;

public class lexer {
    private static Logger logger = parser.getLogger();
    protected static int next_char;
    protected static int next_char2;
    protected static final int EOF_CHAR = -1;
    protected static Hashtable keywords;
    protected static Hashtable keywords_lower_case;
    protected static Hashtable java_keywords;
    protected static Hashtable char_symbols;
    protected static Hashtable defines;
    protected static boolean conditionalCompilation;
    private static Stack ifStack;
    private static Stack tokenStack;
    protected static int current_line;
    protected static StringBuffer line;
    protected static int current_position;
    protected static boolean in_string;
    protected static boolean wide;
    static int error_count;
    public static int warning_count;
    public static String currentPragmaPrefix;
    public static String currentFile;

    public static void reset() {
        current_position = 1;
        error_count = 0;
        warning_count = 0;
        currentPragmaPrefix = "";
        line = new StringBuffer();
        ifStack.removeAllElements();
        tokenStack.removeAllElements();
        defines.clear();
    }

    public static void init() throws IOException {
        defines.put("JACORB_IDL_1_4", "");
        keywords.put("abstract", new Integer(2));
        keywords.put("any", new Integer(3));
        keywords.put("attribute", new Integer(4));
        keywords.put("boolean", new Integer(5));
        keywords.put("case", new Integer(6));
        keywords.put("char", new Integer(7));
        keywords.put("const", new Integer(8));
        keywords.put("context", new Integer(9));
        keywords.put("custom", new Integer(10));
        keywords.put("default", new Integer(11));
        keywords.put("double", new Integer(12));
        keywords.put("enum", new Integer(13));
        keywords.put("exception", new Integer(14));
        keywords.put("factory", new Integer(15));
        keywords.put("FALSE", new Integer(16));
        keywords.put("fixed", new Integer(17));
        keywords.put("float", new Integer(18));
        keywords.put("getraises", new Integer(19));
        keywords.put("in", new Integer(20));
        keywords.put("inout", new Integer(21));
        keywords.put("interface", new Integer(22));
        keywords.put("local", new Integer(23));
        keywords.put("long", new Integer(24));
        keywords.put("module", new Integer(25));
        keywords.put("native", new Integer(26));
        keywords.put("Object", new Integer(27));
        keywords.put("octet", new Integer(28));
        keywords.put("oneway", new Integer(29));
        keywords.put("out", new Integer(30));
        keywords.put("private", new Integer(31));
        keywords.put("public", new Integer(32));
        keywords.put("pseudo", new Integer(33));
        keywords.put("raises", new Integer(34));
        keywords.put("readonly", new Integer(35));
        keywords.put("sequence", new Integer(37));
        keywords.put("setraises", new Integer(36));
        keywords.put("short", new Integer(38));
        keywords.put("string", new Integer(39));
        keywords.put("struct", new Integer(40));
        keywords.put("supports", new Integer(41));
        keywords.put("switch", new Integer(42));
        keywords.put("TRUE", new Integer(43));
        keywords.put("truncatable", new Integer(44));
        keywords.put("typedef", new Integer(45));
        keywords.put("unsigned", new Integer(46));
        keywords.put("union", new Integer(47));
        keywords.put("ValueBase", new Integer(48));
        keywords.put("valuetype", new Integer(49));
        keywords.put("void", new Integer(50));
        keywords.put("wchar", new Integer(51));
        keywords.put("wstring", new Integer(52));
        keywords.put("::", new Integer(78));
        keywords.put("<<", new Integer(80));
        keywords.put(">>", new Integer(79));
        keywords.put("L\"", new Integer(81));
        Enumeration enumeration = keywords.keys();
        while (enumeration.hasMoreElements()) {
            String string = (String)enumeration.nextElement();
            String string2 = string.toLowerCase();
            keywords_lower_case.put(string2, string);
        }
        char_symbols.put(new Integer(59), new Integer(53));
        char_symbols.put(new Integer(44), new Integer(54));
        char_symbols.put(new Integer(42), new Integer(55));
        char_symbols.put(new Integer(46), new Integer(56));
        char_symbols.put(new Integer(58), new Integer(57));
        char_symbols.put(new Integer(61), new Integer(58));
        char_symbols.put(new Integer(43), new Integer(59));
        char_symbols.put(new Integer(45), new Integer(60));
        char_symbols.put(new Integer(123), new Integer(63));
        char_symbols.put(new Integer(125), new Integer(64));
        char_symbols.put(new Integer(40), new Integer(61));
        char_symbols.put(new Integer(41), new Integer(62));
        char_symbols.put(new Integer(91), new Integer(65));
        char_symbols.put(new Integer(93), new Integer(66));
        char_symbols.put(new Integer(60), new Integer(67));
        char_symbols.put(new Integer(62), new Integer(68));
        char_symbols.put(new Integer(39), new Integer(69));
        char_symbols.put(new Integer(34), new Integer(70));
        char_symbols.put(new Integer(92), new Integer(71));
        char_symbols.put(new Integer(94), new Integer(73));
        char_symbols.put(new Integer(38), new Integer(74));
        char_symbols.put(new Integer(47), new Integer(75));
        char_symbols.put(new Integer(37), new Integer(76));
        char_symbols.put(new Integer(126), new Integer(77));
        char_symbols.put(new Integer(124), new Integer(72));
        char_symbols.put(new Integer(32), new Integer(82));
        java_keywords.put("abstract", "");
        java_keywords.put("boolean", "");
        java_keywords.put("break", "");
        java_keywords.put("byte", "");
        java_keywords.put("case", "");
        java_keywords.put("catch", "");
        java_keywords.put("char", "");
        java_keywords.put("class", "");
        java_keywords.put("const", "");
        java_keywords.put("continue", "");
        java_keywords.put("default", "");
        java_keywords.put("do", "");
        java_keywords.put("double", "");
        java_keywords.put("else", "");
        java_keywords.put("extends", "");
        java_keywords.put("false", "");
        java_keywords.put("final", "");
        java_keywords.put("finally", "");
        java_keywords.put("float", "");
        java_keywords.put("for", "");
        java_keywords.put("goto", "");
        java_keywords.put("if", "");
        java_keywords.put("implements", "");
        java_keywords.put("import", "");
        java_keywords.put("instanceof", "");
        java_keywords.put("int", "");
        java_keywords.put("interface", "");
        java_keywords.put("long", "");
        java_keywords.put("native", "");
        java_keywords.put("new", "");
        java_keywords.put("null", "");
        java_keywords.put("package", "");
        java_keywords.put("private", "");
        java_keywords.put("protected", "");
        java_keywords.put("public", "");
        java_keywords.put("return", "");
        java_keywords.put("short", "");
        java_keywords.put("static", "");
        java_keywords.put("super", "");
        java_keywords.put("switch", "");
        java_keywords.put("synchronized", "");
        java_keywords.put("true", "");
        java_keywords.put("this", "");
        java_keywords.put("throw", "");
        java_keywords.put("throws", "");
        java_keywords.put("transient", "");
        java_keywords.put("try", "");
        java_keywords.put("void", "");
        java_keywords.put("volatile", "");
        java_keywords.put("while", "");
        java_keywords.put("clone", "");
        java_keywords.put("equals", "");
        java_keywords.put("finalize", "");
        java_keywords.put("getClass", "");
        java_keywords.put("hashCode", "");
        java_keywords.put("notify", "");
        java_keywords.put("notifyAll", "");
        java_keywords.put("toString", "");
        java_keywords.put("wait", "");
        ifStack.push(new Boolean(true));
        try {
            next_char = GlobalInputStream.read();
        }
        catch (Exception exception) {
            parser.fatal_error("Cannot read from file " + GlobalInputStream.currentFile().getAbsolutePath() + ", please check file name.", null);
        }
        next_char2 = next_char == -1 ? -1 : GlobalInputStream.read();
    }

    public static void define(String string, String string2) {
        if (logger.isDebugEnabled()) {
            logger.debug("Defining: " + string + " as " + string2);
        }
        defines.put(string, string2);
    }

    public static void undefine(String string) {
        if (logger.isDebugEnabled()) {
            logger.debug("Un-defining: " + string);
        }
        defines.remove(string);
    }

    public static String defined(String string) {
        return (String)defines.get(string);
    }

    public static int currentLine() {
        return current_line;
    }

    public static PositionInfo getPosition() {
        return new PositionInfo(current_line, current_position, currentPragmaPrefix, line.toString(), GlobalInputStream.currentFile());
    }

    public static void restorePosition(PositionInfo positionInfo) {
        current_line = positionInfo.line_no;
        currentPragmaPrefix = positionInfo.pragma_prefix;
        current_position = 0;
    }

    protected static void advance() throws IOException {
        int n = next_char;
        next_char = next_char2;
        next_char2 = GlobalInputStream.read();
        line.append((char)n);
        ++current_position;
        if (n == 10) {
            ++current_line;
            current_position = 1;
            line = new StringBuffer();
        }
    }

    public static void emit_error(String string) {
        if (parser.getLogger().isErrorEnabled()) {
            logger.error(GlobalInputStream.currentFile().getAbsolutePath() + ", line: " + current_line + "(" + current_position + "): " + string + "\n\t" + line.toString());
        }
        ++error_count;
    }

    public static void emit_error(String string, str_token str_token2) {
        if (str_token2 == null) {
            lexer.emit_error(string);
        } else {
            if (parser.getLogger().isErrorEnabled()) {
                logger.error(str_token2.fileName + ", line:" + str_token2.line_no + "(" + str_token2.char_pos + "): " + string + "\n\t" + str_token2.line_val);
            }
            ++error_count;
        }
    }

    public static void emit_warn(String string) {
        if (parser.getLogger().isWarnEnabled()) {
            logger.warn(string + " at " + current_line + "(" + current_position + "): \"" + line.toString() + "\"");
        }
        ++warning_count;
    }

    public static void emit_warn(String string, str_token str_token2) {
        if (str_token2 == null) {
            lexer.emit_warn(string);
        } else {
            if (parser.getLogger().isWarnEnabled()) {
                logger.warn(" at " + str_token2.fileName + ", line:" + str_token2.line_no + "(" + str_token2.char_pos + "): " + string + "\n\t" + str_token2.line_val);
            }
            ++warning_count;
        }
    }

    protected static boolean id_start_char(int n) {
        return n >= 97 && n <= 122 || n >= 65 && n <= 90 || n == 95;
    }

    protected static boolean id_char(int n) {
        return lexer.id_start_char(n) || n == 95 || n >= 48 && n <= 57;
    }

    protected static int find_single_char(int n) {
        Integer n2 = (Integer)char_symbols.get(new Integer((char)n));
        if (n2 == null) {
            return -1;
        }
        return n2;
    }

    protected static void swallow_comment() throws IOException {
        if (next_char2 == 42) {
            lexer.advance();
            lexer.advance();
            while (true) {
                if (next_char == -1) {
                    lexer.emit_error("Specification file ends inside a comment", null);
                    return;
                }
                if (next_char == 42 && next_char2 == 47) {
                    lexer.advance();
                    lexer.advance();
                    return;
                }
                lexer.advance();
            }
        }
        if (next_char2 == 47) {
            lexer.advance();
            lexer.advance();
            while (next_char != 10 && next_char != 12 && next_char != 13 && next_char != -1) {
                lexer.advance();
            }
            return;
        }
        lexer.emit_error("Malformed comment in specification -- ignored", null);
        lexer.advance();
    }

    /*
     * Enabled aggressive block sorting
     */
    protected static void preprocess() throws IOException {
        block45: {
            String string;
            block54: {
                String string2;
                String string3;
                CharSequence charSequence;
                block56: {
                    block55: {
                        block53: {
                            boolean bl;
                            block52: {
                                block51: {
                                    block50: {
                                        block49: {
                                            block48: {
                                                block47: {
                                                    block46: {
                                                        if (next_char == -1) {
                                                            lexer.emit_error("Specification file ends inside a preprocessor directive", null);
                                                            return;
                                                        }
                                                        if (next_char != 35) {
                                                            lexer.emit_error("expected #, got " + (char)next_char + " instead!", null);
                                                        } else {
                                                            lexer.advance();
                                                        }
                                                        while (32 == next_char || 9 == next_char) {
                                                            lexer.advance();
                                                        }
                                                        string = lexer.get_string();
                                                        if (string.equals("include")) {
                                                            if (!conditionalCompilation) {
                                                                return;
                                                            }
                                                            lexer.swallow_whitespace();
                                                            boolean bl2 = next_char == 60;
                                                            lexer.advance();
                                                            String string4 = lexer.get_string();
                                                            if (bl2 && next_char != 62) {
                                                                lexer.emit_error("Syntax error in #include directive, expecting '>'");
                                                            } else if (!bl2 && next_char != 34) {
                                                                lexer.emit_error("Syntax error in #include directive, expecting \"");
                                                            }
                                                            while (next_char != 10 && next_char != 12 && next_char != 13 && next_char != -1) {
                                                                lexer.advance();
                                                            }
                                                            GlobalInputStream.include(string4, next_char2, bl2);
                                                            current_line = 0;
                                                            lexer.advance();
                                                            lexer.advance();
                                                            return;
                                                        }
                                                        if (!string.equals("define")) break block46;
                                                        if (!conditionalCompilation) {
                                                            return;
                                                        }
                                                        lexer.swallow_whitespace();
                                                        String string5 = lexer.get_string();
                                                        charSequence = new StringBuffer();
                                                        if (next_char == 32) {
                                                            lexer.advance();
                                                        }
                                                        while (next_char != 10) {
                                                            if (next_char == 92) {
                                                                lexer.advance();
                                                                lexer.advance();
                                                            }
                                                            ((StringBuffer)charSequence).append((char)next_char);
                                                            lexer.advance();
                                                        }
                                                        lexer.define(string5, ((StringBuffer)charSequence).toString());
                                                        break block45;
                                                    }
                                                    if (!string.equals("error")) break block47;
                                                    if (!conditionalCompilation) {
                                                        return;
                                                    }
                                                    lexer.advance();
                                                    String string6 = lexer.get_string();
                                                    lexer.emit_error(string6);
                                                    break block45;
                                                }
                                                if (!string.equals("undef")) break block48;
                                                if (!conditionalCompilation) {
                                                    return;
                                                }
                                                lexer.swallow_whitespace();
                                                String string7 = lexer.get_string();
                                                lexer.undefine(string7);
                                                break block45;
                                            }
                                            if (!string.equals("if") && !string.equals("elif")) break block49;
                                            if (!string.equals("elif")) {
                                                ifStack.push(new Boolean(conditionalCompilation));
                                                if (!conditionalCompilation) {
                                                    return;
                                                }
                                            }
                                            lexer.swallow_whitespace();
                                            boolean bl3 = true;
                                            if (33 == next_char) {
                                                lexer.advance();
                                                bl3 = false;
                                            }
                                            if (((String)(charSequence = lexer.get_string_no_paren())).equals("defined")) {
                                                boolean bl4;
                                                lexer.swallow_whitespace();
                                                boolean bl5 = bl4 = 40 == next_char;
                                                if (bl4) {
                                                    lexer.advance();
                                                    lexer.swallow_whitespace();
                                                }
                                                string3 = lexer.get_string_no_paren();
                                                if (bl4) {
                                                    lexer.swallow_whitespace();
                                                    if (logger.isDebugEnabled()) {
                                                        logger.debug("next char: " + next_char);
                                                    }
                                                    if (41 != next_char) {
                                                        lexer.emit_error("Expected ) terminating #if defined", null);
                                                        return;
                                                    }
                                                    lexer.advance();
                                                }
                                                conditionalCompilation = bl3 ? null != lexer.defined(string3) : null == lexer.defined(string3);
                                                break block45;
                                            } else if (((String)charSequence).equals("0")) {
                                                conditionalCompilation = false;
                                                break block45;
                                            } else {
                                                if (!((String)charSequence).equals("1")) {
                                                    lexer.emit_error("Expected \"defined\" following #if: " + string, null);
                                                    return;
                                                }
                                                conditionalCompilation = true;
                                            }
                                            break block45;
                                        }
                                        if (!string.equals("ifdef")) break block50;
                                        ifStack.push(new Boolean(conditionalCompilation));
                                        if (!conditionalCompilation) {
                                            return;
                                        }
                                        lexer.swallow_whitespace();
                                        String string8 = lexer.get_string();
                                        conditionalCompilation = lexer.defined(string8) != null;
                                        break block45;
                                    }
                                    if (!string.equals("ifndef")) break block51;
                                    ifStack.push(new Boolean(conditionalCompilation));
                                    if (!conditionalCompilation) {
                                        return;
                                    }
                                    lexer.swallow_whitespace();
                                    String string9 = lexer.get_string();
                                    conditionalCompilation = lexer.defined(string9) == null;
                                    break block45;
                                }
                                if (!string.equals("else")) break block52;
                                if (((Boolean)ifStack.peek()).booleanValue()) {
                                    conditionalCompilation = !conditionalCompilation;
                                }
                                break block45;
                            }
                            if (!string.equals("endif")) break block53;
                            conditionalCompilation = bl = ((Boolean)ifStack.pop()).booleanValue();
                            break block45;
                        }
                        if (!string.equals("pragma")) break block54;
                        if (!conditionalCompilation) {
                            return;
                        }
                        lexer.swallow_whitespace();
                        string2 = lexer.get_string();
                        if (!string2.equals("prefix")) break block55;
                        lexer.advance();
                        currentPragmaPrefix = lexer.get_string();
                        break block45;
                    }
                    if (!string2.equals("version")) break block56;
                    lexer.advance();
                    charSequence = lexer.get_string();
                    lexer.advance();
                    String string10 = lexer.get_string();
                    string3 = (String)parser.currentScopeData().versionMap.get(charSequence);
                    if (string3 == null) {
                        parser.currentScopeData().versionMap.put(charSequence, string10);
                    } else if (!string3.equals(string10)) {
                        lexer.emit_error("Version re-declaration with different value: #pragma version " + string10, null);
                    }
                    String string11 = (String)parser.currentScopeData().idMap.get(charSequence);
                    if (string11 != null && !string10.equals(string11.substring(1 + string11.lastIndexOf(58)))) {
                        lexer.emit_error("Declaring version with different version to already declared ID for " + string2, null);
                    }
                    break block45;
                }
                if (string2.equals("ID")) {
                    lexer.advance();
                    charSequence = lexer.get_string();
                    lexer.advance();
                    String string12 = lexer.get_string();
                    string3 = (String)parser.currentScopeData().idMap.get(charSequence);
                    if (string3 == null) {
                        parser.currentScopeData().idMap.put(charSequence, string12);
                    } else if (!string3.equals(string12)) {
                        lexer.emit_error("ID re-declaration with different value: #pragma id " + string12, null);
                    }
                    if (parser.currentScopeData().versionMap.get(charSequence) != null && !((String)parser.currentScopeData().versionMap.get(charSequence)).equals(string12.substring(1 + string12.lastIndexOf(58)))) {
                        lexer.emit_error("Declaring ID with different version to already declared version for " + string2, null);
                    }
                    break block45;
                } else if (string2.equals("inhibit_code_generation")) {
                    parser.setInhibitionState(true);
                    break block45;
                } else {
                    lexer.emit_warn("Unknown pragma, ignoring: #pragma " + string2, null);
                }
                break block45;
            }
            lexer.emit_error("Unrecognized preprocessor directive " + string, null);
        }
        while (next_char != 10 && next_char != 12 && next_char != 13 && next_char != -1) {
            lexer.advance();
        }
    }

    private static String get_string_no_paren() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        char c = (char)next_char;
        while (c != ' ' && c != '\t' && c != '\r' && c != '\n' && c != '\f' && c != '\uffffffff' && c != '\"' && c != '<' && c != '>' && c != '(' && c != ')') {
            stringBuffer.append(c);
            lexer.advance();
            c = (char)next_char;
        }
        return stringBuffer.toString();
    }

    private static String get_string() throws IOException {
        StringBuffer stringBuffer = new StringBuffer("");
        if (next_char == 34) {
            lexer.advance();
            while (next_char != 34) {
                if (next_char == -1) {
                    lexer.emit_error("Unexpected EOF in string");
                }
                stringBuffer.append((char)next_char);
                lexer.advance();
            }
        } else {
            while (next_char != 32 && next_char != 9 && next_char != 13 && next_char != 10 && next_char != 12 && next_char != -1 && next_char != 34 && next_char != 60 && next_char != 62) {
                stringBuffer.append((char)next_char);
                lexer.advance();
            }
        }
        return stringBuffer.toString();
    }

    protected static token do_symbol() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        Integer n = null;
        char[] cArray = new char[]{(char)next_char};
        stringBuffer.append(cArray, 0, 1);
        lexer.advance();
        while (lexer.id_char(next_char)) {
            cArray[0] = (char)next_char;
            stringBuffer.append(cArray, 0, 1);
            lexer.advance();
        }
        String string = stringBuffer.toString();
        String string2 = lexer.defined(string);
        if (string2 != null) {
            char[] cArray2 = new char[]{(char)next_char, (char)next_char2};
            GlobalInputStream.insert(string2 + new String(cArray2));
            lexer.advance();
            lexer.advance();
            return null;
        }
        n = (Integer)keywords.get(string);
        if (n != null) {
            if (lexer.isScope(string)) {
                parser.openScope();
            }
            return new token(n);
        }
        if (null != (string = lexer.checkIdentifier(string))) {
            return new str_token(83, string, lexer.getPosition(), GlobalInputStream.currentFile().getName());
        }
        return null;
    }

    private static boolean isScope(String string) {
        return string.equals("module") || string.equals("interface") || string.equals("struct") || string.equals("exception") || string.equals("union");
    }

    public static String checkIdentifier(String string) {
        if (logger.isInfoEnabled()) {
            logger.info("checking identifier " + string);
        }
        if (string.charAt(0) == '_') {
            string = string.substring(1);
        } else {
            String string2 = null;
            string2 = parser.strict_names ? (String)keywords_lower_case.get(string.toLowerCase()) : (String)keywords.get(string);
            if (string2 != null) {
                lexer.emit_error("Identifier " + string + " collides with keyword " + string2 + ".");
                return null;
            }
        }
        if (lexer.needsJavaEscape(string)) {
            string = "_" + string;
        }
        return string;
    }

    private static boolean needsJavaEscape(String string) {
        return java_keywords.containsKey(string);
    }

    public static boolean strictJavaEscapeCheck(String string) {
        return !string.equals("Helper") && string.endsWith("Helper") || !string.equals("Holder") && string.endsWith("Holder") || !string.equals("Operations") && string.endsWith("Operations") || !string.equals("Package") && string.endsWith("Package") || !string.equals("POA") && string.endsWith("POA") || !string.equals("POATie") && string.endsWith("POATie");
    }

    public static boolean needsJavaEscape(Module module) {
        String string = module.pack_name;
        if (logger.isDebugEnabled()) {
            logger.debug("checking module name " + string);
        }
        return lexer.strictJavaEscapeCheck(string);
    }

    public static token next_token() throws IOException {
        parser.set_included(GlobalInputStream.includeState());
        token token2 = lexer.real_next_token();
        return token2;
    }

    private static void swallow_whitespace() throws IOException {
        while (next_char == 32 || next_char == 9 || next_char == 10 || next_char == 12 || next_char == 13) {
            lexer.advance();
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected static token real_next_token() throws IOException {
        Object object;
        if (!tokenStack.empty()) {
            return (token)tokenStack.pop();
        }
        while (true) {
            block100: {
                block92: {
                    int n;
                    block93: {
                        block96: {
                            block94: {
                                block98: {
                                    char c;
                                    char c2;
                                    char c3;
                                    char c4;
                                    block91: {
                                        block99: {
                                            block97: {
                                                block95: {
                                                    char c5;
                                                    if (in_string) break block92;
                                                    lexer.swallow_whitespace();
                                                    if ((char)next_char == '#') {
                                                        lexer.preprocess();
                                                        continue;
                                                    }
                                                    if (next_char == 47 && (next_char2 == 42 || next_char2 == 47)) {
                                                        lexer.swallow_comment();
                                                        continue;
                                                    }
                                                    if (!conditionalCompilation) {
                                                        lexer.advance();
                                                        if (next_char != -1) continue;
                                                        lexer.emit_error("EOF in conditional compilation!", null);
                                                        return null;
                                                    }
                                                    if (next_char == 58) {
                                                        if (next_char2 == 58) {
                                                            lexer.advance();
                                                            lexer.advance();
                                                            return new token(78);
                                                        }
                                                        lexer.advance();
                                                        return new token(57);
                                                    }
                                                    if (next_char == 76 && (next_char2 == 34 || next_char2 == 39)) {
                                                        wide = true;
                                                        lexer.advance();
                                                        if (next_char2 == 34) {
                                                            lexer.advance();
                                                            in_string = true;
                                                            return new token(81);
                                                        }
                                                    }
                                                    if (next_char == 60) {
                                                        if (next_char2 == 60) {
                                                            lexer.advance();
                                                            lexer.advance();
                                                            return new token(80);
                                                        }
                                                        lexer.advance();
                                                        return new token(67);
                                                    }
                                                    if (next_char == 62) {
                                                        if (next_char2 == 62) {
                                                            lexer.advance();
                                                            lexer.advance();
                                                            return new token(79);
                                                        }
                                                        lexer.advance();
                                                        return new token(68);
                                                    }
                                                    if (next_char == 48) {
                                                        long l = 0L;
                                                        long l2 = 0L;
                                                        int n2 = 8;
                                                        int n3 = 0;
                                                        lexer.advance();
                                                        if (next_char == 46) {
                                                            StringBuffer stringBuffer = new StringBuffer("0.");
                                                            lexer.advance();
                                                            while (next_char >= 48 && next_char <= 57) {
                                                                stringBuffer.append((char)next_char);
                                                                lexer.advance();
                                                            }
                                                            float f = new Float(stringBuffer.toString()).floatValue();
                                                            return new float_token(87, f);
                                                        }
                                                        if (next_char == 120 || next_char == 88) {
                                                            lexer.advance();
                                                            n2 = 16;
                                                        }
                                                        StringBuffer stringBuffer = new StringBuffer("0");
                                                        n3 = Character.digit((char)next_char, n2);
                                                        while (n3 != -1) {
                                                            stringBuffer.append((char)next_char);
                                                            lexer.advance();
                                                            n3 = Character.digit((char)next_char, n2);
                                                        }
                                                        String string = stringBuffer.toString();
                                                        try {
                                                            return new int_token(85, Integer.parseInt(string, n2));
                                                        }
                                                        catch (NumberFormatException numberFormatException) {
                                                            try {
                                                                return new long_token(86, Long.parseLong(string, n2));
                                                            }
                                                            catch (NumberFormatException numberFormatException2) {
                                                                lexer.emit_error("Invalid octal/hex value:  " + string);
                                                                return null;
                                                            }
                                                        }
                                                    }
                                                    if (lexer.isDigit((char)next_char) || next_char == 46 || next_char == 45 && lexer.isDigit((char)next_char2)) {
                                                        object = new StringBuffer();
                                                        StringBuffer stringBuffer = null;
                                                        c4 = '\u0000';
                                                        if (next_char == 45) {
                                                            ((StringBuffer)object).append((char)next_char);
                                                            lexer.advance();
                                                        }
                                                        while (next_char >= 48 && next_char <= 57) {
                                                            ((StringBuffer)object).append((char)next_char);
                                                            lexer.advance();
                                                        }
                                                        if (next_char == 46) {
                                                            stringBuffer = new StringBuffer();
                                                            lexer.advance();
                                                            while (next_char >= 48 && next_char <= 57) {
                                                                stringBuffer.append((char)next_char);
                                                                lexer.advance();
                                                            }
                                                        }
                                                        if (next_char == 101 || next_char == 69) {
                                                            if (stringBuffer == null) {
                                                                stringBuffer = new StringBuffer();
                                                            }
                                                            stringBuffer.append('e');
                                                            lexer.advance();
                                                            if (next_char == 45 || next_char == 43) {
                                                                stringBuffer.append((char)next_char);
                                                                lexer.advance();
                                                            }
                                                            while (next_char >= 48 && next_char <= 57) {
                                                                stringBuffer.append((char)next_char);
                                                                lexer.advance();
                                                            }
                                                            if (stringBuffer.length() != 1) return new float_token(87, Float.valueOf(((StringBuffer)object).toString() + "." + stringBuffer.toString()).floatValue());
                                                            lexer.emit_error("Empty exponent in float/double.");
                                                            continue;
                                                        }
                                                        if (next_char == 100 || next_char == 68) {
                                                            lexer.advance();
                                                            if (stringBuffer == null) {
                                                                stringBuffer = new StringBuffer();
                                                            }
                                                            BigDecimal bigDecimal = new BigDecimal(((StringBuffer)object).toString() + "." + stringBuffer.toString());
                                                            return new fixed_token(88, bigDecimal);
                                                        }
                                                        if (stringBuffer == null) {
                                                            void var4_19;
                                                            Object var4_15 = null;
                                                            String string = ((StringBuffer)object).toString();
                                                            try {
                                                                int_token int_token2 = new int_token(85, Integer.parseInt(string));
                                                                return var4_19;
                                                            }
                                                            catch (NumberFormatException numberFormatException) {
                                                                try {
                                                                    long_token long_token2 = new long_token(86, Long.parseLong(string));
                                                                    return var4_19;
                                                                }
                                                                catch (NumberFormatException numberFormatException3) {
                                                                    try {
                                                                        fixed_token fixed_token2 = new fixed_token(88, new BigDecimal(string));
                                                                        return var4_19;
                                                                    }
                                                                    catch (NumberFormatException numberFormatException4) {
                                                                        lexer.emit_error("Invalid long value:  " + string);
                                                                    }
                                                                }
                                                            }
                                                            return var4_19;
                                                        }
                                                        try {
                                                            float f = Float.valueOf(((StringBuffer)object).toString() + "." + stringBuffer.toString()).floatValue();
                                                            return new float_token(87, f);
                                                        }
                                                        catch (NumberFormatException numberFormatException) {
                                                            lexer.emit_error("Unexpected symbol:  " + ((StringBuffer)object).toString() + "." + stringBuffer.toString());
                                                        }
                                                    }
                                                    n = lexer.find_single_char(next_char);
                                                    if ((char)next_char == '\"') {
                                                        in_string = true;
                                                        lexer.advance();
                                                        return new token(70);
                                                    }
                                                    if ((char)next_char != '\'') break block93;
                                                    lexer.advance();
                                                    object = null;
                                                    if (next_char != 92) break block94;
                                                    lexer.advance();
                                                    if (!lexer.isDigit((char)next_char)) break block95;
                                                    char c6 = '0';
                                                    c4 = '0';
                                                    char c7 = (char)next_char;
                                                    if (lexer.isDigit((char)next_char2)) {
                                                        lexer.advance();
                                                        c4 = c7;
                                                        char c8 = (char)next_char;
                                                        if (lexer.isDigit((char)next_char2)) {
                                                            lexer.advance();
                                                            c6 = c4;
                                                            c4 = c8;
                                                            c5 = (char)next_char;
                                                        }
                                                    }
                                                    object = new char_token(84, (char)Integer.parseInt(new String(new char[]{c6, c4, c5}), 8));
                                                    break block96;
                                                }
                                                if ((char)next_char != 'x') break block97;
                                                lexer.advance();
                                                char c9 = '0';
                                                c4 = (char)next_char;
                                                if (lexer.isHexLetterOrDigit((char)next_char2)) {
                                                    lexer.advance();
                                                    c9 = c4;
                                                    c4 = (char)next_char;
                                                } else if ((char)next_char2 != '\'') {
                                                    lexer.emit_error("Illegal hex character");
                                                    return null;
                                                }
                                                object = new char_token(84, (char)Integer.parseInt(new String(new char[]{c9, c4}), 16));
                                                break block96;
                                            }
                                            if ((char)next_char != 'u') break block98;
                                            if (!wide) {
                                                lexer.emit_error("Unicode characters are only legal with wide character");
                                                return null;
                                            }
                                            lexer.advance();
                                            c3 = '0';
                                            c4 = '0';
                                            int n4 = 48;
                                            c2 = (char)next_char;
                                            if (!lexer.isHexLetterOrDigit((char)next_char2)) break block99;
                                            lexer.advance();
                                            char c10 = c2;
                                            c2 = (char)next_char;
                                            if (lexer.isHexLetterOrDigit((char)next_char2)) {
                                                lexer.advance();
                                                c4 = c10;
                                                char c11 = c2;
                                                c2 = (char)next_char;
                                                if (lexer.isHexLetterOrDigit((char)next_char2)) {
                                                    lexer.advance();
                                                    c3 = c4;
                                                    c4 = c11;
                                                    c = c2;
                                                    c2 = (char)next_char;
                                                    break block91;
                                                } else if ((char)next_char2 != '\'') {
                                                    lexer.emit_error("Illegal unicode character");
                                                    return null;
                                                }
                                                break block91;
                                            } else if ((char)next_char2 != '\'') {
                                                lexer.emit_error("Illegal unicode character");
                                                return null;
                                            }
                                            break block91;
                                        }
                                        if ((char)next_char2 != '\'') {
                                            lexer.emit_error("Illegal unicode character");
                                            return null;
                                        }
                                    }
                                    object = new char_token(84, (char)Integer.parseInt(new String(new char[]{c3, c4, c, c2}), 16));
                                    break block96;
                                }
                                switch (next_char) {
                                    case 110: {
                                        object = new char_token(84, '\n');
                                        break block96;
                                    }
                                    case 116: {
                                        object = new char_token(84, '\t');
                                        break block96;
                                    }
                                    case 118: {
                                        object = new char_token(84, '\u000b');
                                        break block96;
                                    }
                                    case 98: {
                                        object = new char_token(84, '\b');
                                        break block96;
                                    }
                                    case 114: {
                                        object = new char_token(84, '\r');
                                        break block96;
                                    }
                                    case 102: {
                                        object = new char_token(84, '\f');
                                        break block96;
                                    }
                                    case 97: {
                                        object = new char_token(84, '\u0007');
                                        break block96;
                                    }
                                    case 92: {
                                        object = new char_token(84, '\\');
                                        break block96;
                                    }
                                    case 63: {
                                        object = new char_token(84, '?');
                                        break block96;
                                    }
                                    case 48: {
                                        object = new char_token(84, '\u0000');
                                        break block96;
                                    }
                                    case 39: {
                                        object = new char_token(84, '\'');
                                        break block96;
                                    }
                                    case 34: {
                                        object = new char_token(84, '\"');
                                        break block96;
                                    }
                                    default: {
                                        lexer.emit_error("Invalid escape symbol '");
                                        return null;
                                    }
                                }
                            }
                            object = new char_token(84, (char)next_char);
                        }
                        lexer.advance();
                        if ((char)next_char == '\'') {
                            tokenStack.push(new token(69));
                            tokenStack.push(object);
                            lexer.advance();
                            wide = false;
                            return new token(69);
                        }
                        lexer.emit_error("Expecting closing '");
                        return null;
                    }
                    if (n != -1) {
                        lexer.advance();
                        return new token(n);
                    }
                    if (lexer.id_start_char(next_char)) {
                        object = lexer.do_symbol();
                        if (object == null) continue;
                        return object;
                    }
                    if (next_char == -1) {
                        return new token(0);
                    }
                    break block100;
                }
                if ((char)next_char == '\"') {
                    in_string = false;
                    lexer.advance();
                    return new token(70);
                }
                break;
            }
            lexer.emit_warn("Unrecognized character '" + new Character((char)next_char) + "'(" + next_char + ") -- ignored");
            lexer.advance();
        }
        object = new StringBuffer();
        char c = ' ';
        do {
            if (next_char == 92) {
                switch (next_char2) {
                    case 97: {
                        ((StringBuffer)object).append("\\007");
                        c = 'a';
                        lexer.advance();
                        break;
                    }
                    case 118: {
                        ((StringBuffer)object).append("\\013");
                        c = 'v';
                        lexer.advance();
                        break;
                    }
                    case 63: {
                        ((StringBuffer)object).append("?");
                        c = '?';
                        lexer.advance();
                        break;
                    }
                    case 120: {
                        lexer.advance();
                        lexer.advance();
                        String string = Integer.toOctalString(Integer.parseInt(new String(new char[]{(char)next_char, (char)next_char2}), 16));
                        if (string.length() != 3) {
                            if (string.length() == 1) {
                                string = "0" + string;
                            }
                            string = "0" + string;
                        }
                        ((StringBuffer)object).append("\\" + string);
                        c = (char)next_char2;
                        lexer.advance();
                        break;
                    }
                    case 117: {
                        if (!wide) {
                            lexer.emit_error("Unicode characters are only legal with wide strings");
                            return null;
                        }
                        ((StringBuffer)object).append((char)next_char);
                        ((StringBuffer)object).append((char)next_char2);
                        lexer.advance();
                        lexer.advance();
                        char c12 = (char)next_char;
                        char c13 = '0';
                        char c14 = '0';
                        char c15 = '0';
                        if (!lexer.isHexLetterOrDigit((char)next_char2)) {
                            lexer.emit_error("Illegal unicode character");
                            return null;
                        }
                        lexer.advance();
                        c13 = (char)next_char;
                        if (!lexer.isHexLetterOrDigit((char)next_char2)) {
                            lexer.emit_error("Illegal unicode character");
                            return null;
                        }
                        lexer.advance();
                        c14 = (char)next_char;
                        if (!lexer.isHexLetterOrDigit((char)next_char2)) {
                            lexer.emit_error("Illegal unicode character");
                            return null;
                        }
                        lexer.advance();
                        c15 = (char)next_char;
                        c = c15;
                        ((StringBuffer)object).append(c12);
                        ((StringBuffer)object).append(c13);
                        ((StringBuffer)object).append(c14);
                        ((StringBuffer)object).append(c15);
                        break;
                    }
                    default: {
                        c = (char)next_char;
                        ((StringBuffer)object).append((char)next_char);
                        break;
                    }
                }
            } else {
                c = (char)next_char;
                ((StringBuffer)object).append((char)next_char);
            }
            lexer.advance();
        } while ((char)next_char != '\"' || c == 92);
        wide = false;
        String string = ((StringBuffer)object).toString();
        return new str_token(83, string, lexer.getPosition(), GlobalInputStream.currentFile().getName());
    }

    static boolean isDigit(char c) {
        boolean bl = false;
        if (c >= '0' && c <= '9') {
            bl = true;
        }
        return bl;
    }

    private static boolean isHexLetterOrDigit(char c) {
        boolean bl = false;
        if (c >= '0') {
            if (c <= '9') {
                bl = true;
            } else if (c >= 'A') {
                if (c <= 'F') {
                    bl = true;
                }
                if (c >= 'a' && c <= 'f') {
                    bl = true;
                }
            }
        }
        return bl;
    }

    static {
        keywords = new Hashtable();
        keywords_lower_case = new Hashtable();
        java_keywords = new Hashtable();
        char_symbols = new Hashtable(25);
        defines = new Hashtable();
        conditionalCompilation = true;
        ifStack = new Stack();
        tokenStack = new Stack();
        current_line = 1;
        line = new StringBuffer();
        current_position = 1;
        in_string = false;
        wide = false;
        error_count = 0;
        warning_count = 0;
        currentPragmaPrefix = "";
        currentFile = "";
    }
}

