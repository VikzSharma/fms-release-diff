/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log.Logger
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import org.apache.log.Logger;
import org.jacorb.idl.BaseType;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.Module;
import org.jacorb.idl.ParseException;
import org.jacorb.idl.PositionInfo;
import org.jacorb.idl.Scope;
import org.jacorb.idl.ScopeData;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;
import org.jacorb.idl.runtime.symbol;
import org.jacorb.idl.str_token;

public class IdlSymbol
extends symbol {
    private static int num = 10000;
    public String pack_name = "";
    String name = "";
    protected boolean is_pseudo = false;
    protected boolean included = false;
    protected boolean inhibitionFlag = false;
    str_token token;
    protected String _id;
    private String _version;
    protected IdlSymbol enclosing_symbol;
    protected String omg_package_prefix = "";
    private Hashtable imports = new Hashtable();
    String typeName;
    protected static final char fileSeparator = System.getProperty("file.separator").charAt(0);
    Logger logger;
    PositionInfo myPosition = null;

    public IdlSymbol(int n) {
        super(n);
        this.inhibitionFlag = parser.getInhibitionState();
        this.logger = parser.getLogger();
        this.myPosition = lexer.getPosition();
    }

    void set_included(boolean bl) {
        this.included = bl;
    }

    public boolean is_included() {
        return this.included;
    }

    public void set_pseudo() {
        this.is_pseudo = true;
    }

    public boolean is_pseudo() {
        return this.is_pseudo;
    }

    public void set_token(str_token str_token2) {
        this.token = str_token2;
        if (this.token != null) {
            if (this.token.pragma_prefix.equals("omg.org")) {
                this.omg_package_prefix = "org.omg.";
            }
            this.set_name(this.token.str_val);
        }
    }

    public str_token get_token() {
        return this.token;
    }

    public String name() {
        return this.name;
    }

    public void escapeName() {
        if (!this.isEscaped() && !this.pack_name.startsWith("org.omg.Messaging") && lexer.strictJavaEscapeCheck(this.name)) {
            if (this.name.indexOf(46) > 0) {
                this.logger.warn("Dots within a simple name!");
            }
            this.name = "_" + this.name;
        }
    }

    public boolean isEscaped() {
        return this.name().startsWith("_");
    }

    public String deEscapeName() {
        String string = this.name();
        if (string.startsWith("_")) {
            string = string.substring(1);
        }
        return string;
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
    }

    public IdlSymbol getEnclosingSymbol() {
        return this.enclosing_symbol;
    }

    public static int new_num() {
        return num++;
    }

    public void set_name(String string) {
        this.name = string;
    }

    String full_name() {
        if (this.name.length() == 0) {
            return null;
        }
        if (this.pack_name.length() > 0) {
            return this.pack_name + "." + this.name;
        }
        return this.name;
    }

    String javaName() {
        if (this.name.length() == 0) {
            return null;
        }
        if (this.pack_name.length() > 0) {
            if (!this.pack_name.startsWith("org.omg")) {
                return this.omg_package_prefix + this.pack_name + "." + this.name;
            }
            return this.pack_name + "." + this.name;
        }
        return this.name;
    }

    public String omgPrefix() {
        return this.omg_package_prefix;
    }

    public void parse() throws ParseException {
    }

    public void print(PrintWriter printWriter) {
        throw new RuntimeException("--abstract--!");
    }

    public void printImport(PrintWriter printWriter) {
        if (!this.pack_name.equals("")) {
            Enumeration enumeration = this.imports.keys();
            while (enumeration.hasMoreElements()) {
                String string = (String)enumeration.nextElement();
                printWriter.println("import " + string + ";");
            }
            printWriter.println();
        }
    }

    public void addImportedAlias(String string) {
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("addImportedAlias " + string);
        }
        if (string.indexOf(46) < 0 && !BaseType.isBasicName(string)) {
            this.imports.put(string + "Helper", "");
        }
    }

    public void addImportedName(String string) {
        if (string != null && string.endsWith("[]")) {
            string = string.substring(0, string.length() - 2);
        }
        if (string != null && string.indexOf(46) < 0 && !BaseType.isBasicName(string)) {
            this.addImportedName(string, null);
        }
    }

    public void addImportedName(String string, TypeSpec typeSpec) {
        if (string != null && string.indexOf(46) < 0 && !BaseType.isBasicName(string)) {
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("addImportedName " + string);
            }
            if (typeSpec == null || !BaseType.isBasicName(typeSpec.toString())) {
                this.imports.put(string, "");
            }
            this.imports.put(string + "Helper", "");
        }
    }

    public void addImportedNameHolder(String string) {
        if (string.indexOf(46) < 0 && !BaseType.isBasicName(string)) {
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("addImportedNameHolder " + string);
            }
            this.imports.put(string, "");
        }
    }

    public void setPrintPhaseNames() {
        if (this.pack_name.length() > 0) {
            this.typeName = ScopedName.unPseudoName(this.pack_name + "." + this.name);
            if (!this.typeName.startsWith("org.omg")) {
                this.typeName = this.omg_package_prefix + this.typeName;
            }
            this.pack_name = this.typeName.substring(0, this.typeName.lastIndexOf("."));
        } else {
            this.typeName = ScopedName.unPseudoName(this.name);
        }
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("setPrintPhaseNames: pack_name " + this.pack_name + ", name " + this.name + " typename " + this.typeName);
        }
    }

    public void printIdMethod(PrintWriter printWriter) {
        printWriter.println("\tpublic static String id()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn \"" + this.id() + "\";");
        printWriter.println("\t}");
    }

    public String id() {
        block9: {
            IdlSymbol idlSymbol = this.enclosing_symbol;
            StringBuffer stringBuffer = new StringBuffer();
            ScopeData scopeData = null;
            str_token str_token2 = null;
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("Id for name " + this.name);
            }
            if (this._id != null) break block9;
            do {
                String string;
                block11: {
                    block10: {
                        if (idlSymbol == null) break block10;
                        str_token2 = idlSymbol.get_token();
                        if (idlSymbol instanceof Scope && (scopeData = ((Scope)((Object)idlSymbol)).getScopeData()) == null) {
                            parser.fatal_error("ScopeDate null for " + this.name + " " + this.getClass().getName(), null);
                        }
                        if (scopeData != null && scopeData.idMap.get(this.name) != null) {
                            this._id = (String)scopeData.idMap.get(this.name);
                            break;
                        }
                        if (this.token == null || !"".equals(this.token.pragma_prefix) && !str_token2.pragma_prefix.equals(this.token.pragma_prefix)) break;
                        string = idlSymbol.name;
                        if (!(idlSymbol instanceof Module)) break block11;
                        String string2 = ((Module)idlSymbol).originalModuleName();
                        if (!string2.startsWith("org")) {
                            string = ((Module)idlSymbol).originalModuleName();
                        }
                        if (!idlSymbol.isEscaped()) break block11;
                        string = string.substring(1);
                        break block11;
                    }
                    if (parser.scopes.size() != 1 || parser.currentScopeData().idMap.get(this.name) == null) break;
                    this._id = (String)parser.currentScopeData().idMap.get(this.name);
                    break;
                }
                stringBuffer.insert(0, string + "/");
                idlSymbol = idlSymbol.getEnclosingSymbol();
            } while (idlSymbol != null);
            if (this._id == null) {
                if (this.isEscaped()) {
                    stringBuffer.append(this.name.substring(1));
                } else {
                    stringBuffer.append(this.name);
                }
                this._id = this.token != null && this.token.pragma_prefix.length() > 0 ? "IDL:" + this.token.pragma_prefix + "/" + stringBuffer.toString().replace('.', '/') + ":" + this.version() : "IDL:" + stringBuffer.toString().replace('.', '/') + ":" + this.version();
            }
        }
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Id for name " + this.name + " is " + this._id);
        }
        return this._id;
    }

    private String version() {
        IdlSymbol idlSymbol = this;
        if (this._version == null) {
            String string;
            Object object;
            block9: {
                while (true) {
                    Hashtable hashtable;
                    if (idlSymbol != null && !(idlSymbol instanceof Scope)) {
                        idlSymbol = idlSymbol.getEnclosingSymbol();
                        continue;
                    }
                    if (idlSymbol == null) break;
                    object = ((Scope)((Object)idlSymbol)).getScopeData();
                    if (object == null) {
                        parser.fatal_error("ScopeData null for " + this.name + " " + this.getClass().getName(), null);
                    }
                    if ((string = (String)(hashtable = ((ScopeData)object).versionMap).get(this.name)) != null) {
                        this._version = string;
                        break block9;
                    }
                    idlSymbol = idlSymbol.getEnclosingSymbol();
                }
                this._version = parser.scopes.size() == 1 && parser.currentScopeData().versionMap.get(this.name) != null ? (String)parser.currentScopeData().versionMap.get(this.name) : "1.0";
            }
            if (idlSymbol != null) {
                idlSymbol = idlSymbol.getEnclosingSymbol();
            }
            while (true) {
                if (idlSymbol != null && !(idlSymbol instanceof Scope)) {
                    idlSymbol = idlSymbol.getEnclosingSymbol();
                    continue;
                }
                if (idlSymbol == null) break;
                object = ((Scope)((Object)idlSymbol)).getScopeData().versionMap;
                string = (String)((Hashtable)object).get(this.name);
                if (string != null) {
                    lexer.emit_error("Version for " + this.name + " already declared!", idlSymbol.get_token());
                    break;
                }
                idlSymbol = idlSymbol.getEnclosingSymbol();
            }
        }
        return this._version;
    }

    protected boolean generateIncluded() {
        return parser.generateIncluded() && !this.inhibitionFlag;
    }

    protected String getFullName(String string) {
        if (!string.startsWith("org.omg") && !string.startsWith("java.lang")) {
            return this.omgPrefix() + string;
        }
        return string;
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
    }

    protected final void printClassComment(String string, String string2, PrintWriter printWriter) {
        printWriter.println("/**");
        printWriter.println(" * Generated from IDL " + string.trim() + " \"" + string2 + "\".");
        printWriter.println(" *");
        printWriter.println(" * @author JacORB IDL compiler V 2.3.0, 17-Feb-2007");
        printWriter.println(" * @version generated at " + parser.currentDate);
        printWriter.println(" */\n");
    }
}

