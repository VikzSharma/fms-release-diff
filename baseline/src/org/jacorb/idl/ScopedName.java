/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Stack;
import java.util.StringTokenizer;
import org.jacorb.idl.AliasTypeSpec;
import org.jacorb.idl.ConstDecl;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.Interface;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.SequenceType;
import org.jacorb.idl.SimpleTypeSpec;
import org.jacorb.idl.SwitchTypeSpec;
import org.jacorb.idl.TypeMap;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;

public class ScopedName
extends SimpleTypeSpec
implements SwitchTypeSpec {
    private static Hashtable pseudoScopes = new Hashtable();
    private static Hashtable enumMap = new Hashtable();
    private static Stack recursionStack = new Stack();
    private TypeSpec resolvedSpec = null;
    private String resolvedName = null;
    private boolean resolved = false;
    private Interface resolvedInterface = null;
    boolean set = false;
    public String typeName = null;

    public static void definePseudoScope(String string) {
        pseudoScopes.put(string, "");
    }

    public static boolean isPseudoScope(String string) {
        return pseudoScopes.containsKey(string);
    }

    public static String unPseudoName(String string) {
        String string2 = ScopedName.unPseudo(string);
        if (string2.endsWith("PackagePackage") || !string2.startsWith("_") && string2.endsWith("Package")) {
            string2 = string2.substring(0, string2.lastIndexOf("Package"));
        }
        return string2;
    }

    private static String unPseudo(String string) {
        if (string.length() > 0 && string.charAt(0) == '.') {
            string = string.substring(1);
        }
        String string2 = string;
        String string3 = null;
        int n = string.lastIndexOf(46);
        if (n < 0) {
            return string;
        }
        while (!ScopedName.isPseudoScope(string2)) {
            n = string2.lastIndexOf(46);
            if (n < 0) {
                return string;
            }
            string2 = string.substring(0, n);
            string3 = string.substring(n + 1);
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string2, ".");
        String[] stringArray = new String[stringTokenizer.countTokens()];
        int n2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            stringArray[n2++] = stringTokenizer.nextToken();
        }
        StringBuffer stringBuffer = new StringBuffer();
        int n3 = 1;
        stringBuffer.append(stringArray[0]);
        while (!ScopedName.isPseudoScope(stringBuffer.toString())) {
            if (n3 == stringArray.length) {
                return string;
            }
            stringBuffer.append(".");
            stringBuffer.append(stringArray[n3++]);
        }
        StringBuffer stringBuffer2 = new StringBuffer(stringBuffer.toString());
        stringBuffer.append("Package");
        while (n3 < stringArray.length) {
            stringBuffer.append("." + stringArray[n3]);
            stringBuffer2.append("." + stringArray[n3]);
            if (ScopedName.isPseudoScope(stringBuffer2.toString())) {
                stringBuffer.append("Package");
            }
            ++n3;
        }
        if (string3 != null) {
            stringBuffer.append("." + string3);
        }
        return stringBuffer.toString();
    }

    public static void enumMap(String string, String string2) {
        enumMap.put(string, string2);
    }

    private static String unEnum(String string) {
        String string2 = (String)enumMap.get(string);
        if (string2 != null) {
            return string2;
        }
        return string;
    }

    public ScopedName(int n) {
        super(n);
    }

    public Object clone() {
        ScopedName scopedName = new ScopedName(ScopedName.new_num());
        scopedName.resolvedSpec = this.resolvedSpec;
        scopedName.resolvedName = this.resolvedName;
        scopedName.resolved = this.resolved;
        scopedName.typeName = this.typeName;
        scopedName.token = this.token;
        scopedName.set = this.set;
        scopedName.pack_name = this.pack_name;
        scopedName.name = this.name;
        scopedName.is_pseudo = this.is_pseudo;
        scopedName.included = this.included;
        scopedName.inhibitionFlag = this.inhibitionFlag;
        return scopedName;
    }

    public void setId(String string) {
        if (this.logger.isInfoEnabled()) {
            this.logger.info("ScopedName.setId " + string);
        }
        this.typeName = string;
        this.escapeName();
    }

    public void escapeName() {
        if (!this.isEscaped(this.typeName)) {
            if (this.typeName.indexOf(46) > -1) {
                if (lexer.strictJavaEscapeCheck(this.typeName.substring(this.typeName.lastIndexOf(46) + 1))) {
                    this.typeName = this.typeName.substring(0, this.typeName.lastIndexOf(46) + 1) + "_" + this.typeName.substring(this.typeName.lastIndexOf(46) + 1);
                }
            } else if (lexer.strictJavaEscapeCheck(this.typeName)) {
                this.typeName = "_" + this.typeName;
            }
        }
        if (this.logger.isInfoEnabled()) {
            this.logger.info("ScopedName.escapeName " + this.typeName);
        }
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
    }

    public void parse() {
    }

    public boolean resolved() {
        return this.resolved;
    }

    public boolean basic() {
        TypeSpec typeSpec = this.resolvedTypeSpec();
        return typeSpec.basic();
    }

    public boolean is_pseudo() {
        return NameTable.isDefined(this.resolvedName(), "pseudo interface");
    }

    public TypeSpec resolvedTypeSpec() {
        if (!this.resolved) {
            this.resolvedName = this.resolvedName();
        }
        if (this.resolvedSpec == null) {
            parser.fatal_error("Not a type: " + this.resolvedName, this.token);
        }
        return this.resolvedSpec;
    }

    public boolean isEscaped(String string) {
        String string2 = null;
        string2 = string.indexOf(46) > -1 ? string.substring(string.lastIndexOf(46) + 1) : string;
        return string2.startsWith("_");
    }

    public String resolvedName() {
        ConstDecl constDecl;
        if (!this.resolved) {
            this.resolvedName = this.resolvedName(this.pack_name, this.typeName);
        }
        if ((constDecl = ConstDecl.getDeclaration(this.resolvedName)) != null && !constDecl.contained()) {
            this.resolvedName = this.resolvedName + ".value";
        }
        this.resolved = true;
        return this.resolvedName;
    }

    private String resolvedName(String string, String string2) {
        int n;
        int n2;
        int n3;
        int n4;
        Object object;
        String string3;
        if (this.logger.isInfoEnabled()) {
            this.logger.info("Resolve " + string + ":" + string2);
        }
        if (string2 == null) {
            throw new RuntimeException("Parser Error: null string in ScopedName (pack_name: " + string + ") !");
        }
        String string4 = null;
        boolean bl = false;
        if (string2.charAt(0) == '.') {
            string2 = string2.substring(1);
            bl = true;
        }
        String string5 = "";
        if (string2.endsWith("[]")) {
            string4 = string2.substring(0, string2.indexOf("["));
            string5 = "[]";
        } else {
            string4 = string2;
        }
        if (!bl && NameTable.isDefined(string + "." + string4)) {
            String string6 = this.unMap(string + "." + string4);
            if (this.logger.isInfoEnabled()) {
                this.logger.info("resolve, " + string + "." + string4 + " was in name table, returning " + string6 + " suffix: " + string5);
            }
            return string6 + string5;
        }
        if ((bl || string4.indexOf(46) > -1) && NameTable.isDefined(string4)) {
            String string7 = this.unMap(string4);
            if (this.logger.isInfoEnabled()) {
                this.logger.info("resolve, found " + string4 + " in name table, returning " + string7 + " suffix: " + string5);
            }
            return string7 + string5;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string2, ".");
        String[] stringArray = new String[stringTokenizer.countTokens()];
        int n5 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            stringArray[n5] = stringTokenizer.nextToken();
            ++n5;
        }
        if (stringArray.length > 0 && !(string3 = parser.pack_replace(stringArray[0])).equals(stringArray[0])) {
            object = new StringBuffer();
            ((StringBuffer)object).append(string3);
            for (n4 = 1; n4 < stringArray.length; ++n4) {
                ((StringBuffer)object).append(".");
                ((StringBuffer)object).append(stringArray[n4]);
            }
            string4 = ((StringBuffer)object).toString();
            if (NameTable.isDefined(string4)) {
                String string8 = this.unMap(string4);
                if (this.logger.isInfoEnabled()) {
                    this.logger.info("resolve b, " + string4 + " was in name table, returning " + string8 + " suffix: " + string5);
                }
                return string8 + string5;
            }
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(string, ".");
        object = new String[stringTokenizer2.countTokens()];
        n4 = 0;
        while (stringTokenizer2.hasMoreTokens()) {
            object[n4] = stringTokenizer2.nextToken();
            ++n4;
        }
        if (stringArray.length == 0 || ((Object)object).length == 0) {
            if (NameTable.isDefined(string4)) {
                return this.unMap(string4) + string5;
            }
            parser.fatal_error("Undefined name: " + string2 + " .", this.token);
        }
        if (stringArray[0].equals(object[0])) {
            StringBuffer stringBuffer = new StringBuffer();
            int n6 = n3 = stringArray.length < ((Object)object).length ? stringArray.length : ((Object)object).length;
            if (n3 > 1) {
                int n7;
                for (n7 = 1; n7 < n3 - 1 && stringArray[n7].equals(object[n7]); ++n7) {
                }
                stringBuffer.append(stringArray[n7]);
                for (n2 = n7 + 1; n2 < stringArray.length; ++n2) {
                    stringBuffer.append(".");
                    stringBuffer.append(stringArray[n2]);
                }
                string2 = stringBuffer.toString();
            }
        }
        String string9 = "";
        n3 = 0;
        if (parser.package_prefix != null) {
            string9 = parser.package_prefix + ".";
            StringTokenizer stringTokenizer3 = new StringTokenizer(string9, ".");
            String[] stringArray2 = new String[stringTokenizer3.countTokens()];
            n = 0;
            while (stringTokenizer3.hasMoreTokens()) {
                stringArray2[n] = stringTokenizer3.nextToken();
                ++n;
            }
            while (n3 < stringArray2.length && stringArray2[n3].equals(object[n3])) {
                ++n3;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        n2 = ((Object)object).length - n3;
        if (n2 > 0) {
            stringBuffer.append((String)object[n3] + ".");
        }
        for (n = n3 + 1; n < ((Object)object).length; ++n) {
            stringBuffer.append((String)object[n]);
            stringBuffer.append(".");
        }
        stringBuffer.append(string2);
        n = n3 + 1;
        while (!NameTable.isDefined(string9 + stringBuffer.toString())) {
            if (n > ((Object)object).length) {
                parser.fatal_error("Undefined name: " + string + "." + string2, this.token);
                return "/* unresolved name */";
            }
            stringBuffer = new StringBuffer();
            if ((n2 = ((Object)object).length - n++) > 0) {
                stringBuffer.append((String)object[n3] + ".");
                for (int i = n3 + 1; i < n2 + n3; ++i) {
                    stringBuffer.append((String)object[i]);
                    stringBuffer.append(".");
                }
            }
            stringBuffer.append(string2);
        }
        String string10 = this.unMap(string9 + stringBuffer.toString()) + string5;
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("ScopedName.resolve (at end) returns: " + string10);
        }
        return string10;
    }

    public TypeSpec typeSpec() {
        return this;
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.set = true;
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
    }

    private String qualify(String string) {
        if (string.charAt(0) == '.') {
            return string.substring(1);
        }
        if (!this.pack_name.equals("")) {
            return this.pack_name + "." + string;
        }
        return string;
    }

    private String unMap(String string) {
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("ScopedName.unmap: " + string);
        }
        TypeSpec typeSpec = TypeMap.map(string);
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("ScopedName.unmap: " + string + ", Type.map( " + string + " ) is : " + typeSpec);
        }
        TypeSpec typeSpec2 = null;
        while (!(typeSpec == null || typeSpec instanceof ScopedName || typeSpec instanceof ConstrTypeSpec || (typeSpec2 = typeSpec).equals(typeSpec = typeSpec.typeSpec()))) {
        }
        if (typeSpec == null) {
            if (typeSpec2 != null) {
                this.resolvedSpec = typeSpec2;
                return typeSpec2.typeName();
            }
            this.resolvedSpec = typeSpec;
            return ScopedName.unEnum(string);
        }
        if (typeSpec instanceof ConstrTypeSpec) {
            this.resolvedSpec = typeSpec;
            return typeSpec.typeName();
        }
        if (typeSpec instanceof ScopedName && typeSpec != null && typeSpec2 != typeSpec) {
            return this.unMap(typeSpec.typeName());
        }
        if (typeSpec instanceof AliasTypeSpec && ((AliasTypeSpec)typeSpec).originalType().typeSpec() instanceof SequenceType) {
            this.resolvedSpec = typeSpec;
            return typeSpec.typeName();
        }
        if (typeSpec == null) {
            this.resolvedSpec = typeSpec2;
            return typeSpec2.typeName();
        }
        this.resolvedSpec = typeSpec;
        return string;
    }

    public String typeName() {
        String string = ScopedName.unPseudo(this.resolvedName(this.pack_name, this.typeName));
        if (string.endsWith("PackagePackage") || !this.isEscaped(string) && string.endsWith("Package")) {
            string = string.substring(0, string.lastIndexOf("Package"));
        }
        return string;
    }

    public String holderName() {
        return this.resolvedTypeSpec().holderName();
    }

    public String printReadExpression(String string) {
        return this.resolvedTypeSpec().printReadExpression(string);
    }

    public String printWriteStatement(String string, String string2) {
        return this.resolvedTypeSpec().printWriteStatement(string, string2);
    }

    public String printInsertExpression() {
        return this.resolvedTypeSpec().printInsertExpression();
    }

    public String printExtractExpression() {
        return this.resolvedTypeSpec().printExtractExpression();
    }

    public String getTypeCodeExpression() {
        return this.resolvedTypeSpec().getTypeCodeExpression();
    }

    public String id() {
        return this.resolvedTypeSpec().id();
    }

    public String toString() {
        String string = this.typeName();
        if (this.resolvedTypeSpec() != null && !string.startsWith("org.omg") && !string.startsWith("java.lang")) {
            string = this.resolvedTypeSpec().omgPrefix() + string;
        }
        return string;
    }

    public void print(PrintWriter printWriter) {
    }

    public String IDLName() {
        String string = this.toString();
        StringBuffer stringBuffer = new StringBuffer();
        int n = 0;
        while (string.substring(n).indexOf(46) > 0) {
            int n2 = n + string.substring(n).indexOf(46);
            stringBuffer.append(string.substring(n, n2) + "::");
            n = n2 + 1;
        }
        stringBuffer.append(string.substring(n));
        return stringBuffer.toString();
    }

    public static void addRecursionScope(String string) {
        recursionStack.push(string);
    }

    public static void removeRecursionScope(String string) {
        String string2 = (String)recursionStack.pop();
        if (!(string == null || string2 != null && string2.equals(string))) {
            throw new RuntimeException("RecursionScope Error, expected " + string + ", got " + string2);
        }
    }

    public static boolean isRecursionScope(String string) {
        return recursionStack.search(string) != -1;
    }

    public boolean isSwitchable() {
        TypeSpec typeSpec = this.resolvedTypeSpec();
        return typeSpec instanceof SwitchTypeSpec && ((SwitchTypeSpec)((Object)typeSpec)).isSwitchable();
    }
}

