/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import org.jacorb.idl.AliasTypeSpec;
import org.jacorb.idl.ConstExpr;
import org.jacorb.idl.ConstType;
import org.jacorb.idl.Declaration;
import org.jacorb.idl.Environment;
import org.jacorb.idl.FixedPointConstType;
import org.jacorb.idl.FixedPointType;
import org.jacorb.idl.FloatType;
import org.jacorb.idl.GlobalInputStream;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.Interface;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.OctetType;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.ShortType;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;

public class ConstDecl
extends Declaration {
    private static Hashtable values = new Hashtable();
    private static Hashtable declarations = new Hashtable();
    private ScopedName t = new ScopedName(ConstDecl.new_num());
    private int pos_int_const = 0;
    private boolean int_const_set = false;
    public ConstExpr const_expr;
    public ConstType const_type;

    public ConstDecl(int n) {
        super(n);
    }

    public static void init() {
        values.clear();
        declarations.clear();
    }

    public static String namedValue(ScopedName scopedName) {
        String string = scopedName.resolvedName();
        if (values.containsKey(string)) {
            return (String)values.get(string);
        }
        return string;
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        super.setPackage(string);
        this.const_type.setPackage(string);
        this.const_expr.setPackage(string);
        this.t.typeName = this.name;
        this.t.setPackage(string);
    }

    public void parse() {
        this.const_expr.setDeclaration(this);
        try {
            NameTable.define(this.full_name(), "constant");
        }
        catch (NameAlreadyDefined nameAlreadyDefined) {
            parser.error("Constant " + this.full_name() + " already defined", this.token);
        }
        this.const_type.parse();
        this.const_expr.parse();
        this.t.typeName = this.name;
        values.put(this.t.resolvedName() + (this.contained() ? "" : ".value"), this.const_expr.value());
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("ConstDecl.parse, put value: " + this.t.resolvedName() + (this.contained() ? "" : ".value") + " , " + this.const_expr.value());
        }
        declarations.put(this.t.resolvedName(), this);
    }

    static ConstDecl getDeclaration(String string) {
        return (ConstDecl)declarations.get(string);
    }

    int pos_int_const() {
        if (!this.int_const_set) {
            this.pos_int_const = this.const_expr.pos_int_const();
            this.int_const_set = true;
        }
        return this.pos_int_const;
    }

    public void printContained(PrintWriter printWriter) {
        printWriter.print("\t" + this.const_type + " " + this.name + " = ");
        printWriter.print(this.getValue());
        printWriter.println(";");
    }

    boolean contained() {
        boolean bl = false;
        for (IdlSymbol idlSymbol = this.getEnclosingSymbol(); idlSymbol != null; idlSymbol = idlSymbol.getEnclosingSymbol()) {
            if (!(idlSymbol instanceof Interface)) continue;
            bl = true;
            break;
        }
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("ConstDecl.contained()? " + this.full_name() + " returns " + bl);
        }
        return bl;
    }

    public void print(PrintWriter printWriter) {
        if (this.contained() || this.included && !this.generateIncluded()) {
            return;
        }
        try {
            String string;
            File file;
            String string2;
            String string3 = ScopedName.unPseudoName(this.full_name());
            if (string3.indexOf(46) > 0) {
                this.pack_name = string3.substring(0, string3.lastIndexOf(46));
                string2 = string3.substring(string3.lastIndexOf(46) + 1);
            } else {
                this.pack_name = "";
                string2 = string3;
            }
            String string4 = parser.out_dir + fileSeparator + this.pack_name.replace('.', fileSeparator);
            File file2 = new File(string4);
            if (!file2.exists() && !file2.mkdirs()) {
                parser.fatal_error("Unable to create " + string4, null);
            }
            if (GlobalInputStream.isMoreRecentThan(file = new File(file2, string = string2 + ".java"))) {
                PrintWriter printWriter2 = new PrintWriter(new FileWriter(file));
                if (this.logger.isDebugEnabled()) {
                    this.logger.debug("ConstDecl.print " + string);
                }
                if (Environment.JAVA14 && this.pack_name.equals("")) {
                    lexer.emit_warn("No package defined for " + string2 + " - illegal in JDK1.4", this.token);
                }
                if (!this.pack_name.equals("")) {
                    printWriter2.println("package " + this.pack_name + ";");
                }
                this.printClassComment("const", string2, printWriter2);
                printWriter2.println("public interface " + string2);
                printWriter2.println("{");
                printWriter2.print("\t" + this.const_type.toString() + " value = ");
                printWriter2.print(this.getValue());
                printWriter2.println(";");
                printWriter2.println("}");
                printWriter2.close();
            }
        }
        catch (IOException iOException) {
            throw new RuntimeException("File IO error" + iOException);
        }
    }

    private String getValue() {
        TypeSpec typeSpec = this.const_type.symbol.typeSpec();
        while (typeSpec instanceof AliasTypeSpec) {
            typeSpec = ((AliasTypeSpec)typeSpec).originalType();
        }
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("ConstDecl(" + this.name + ": " + typeSpec.getClass() + ") = " + this.const_type.toString());
        }
        if (typeSpec instanceof ShortType) {
            return "(short)(" + this.const_expr.toString() + ")";
        }
        if (typeSpec instanceof FloatType) {
            return "(float)(" + this.const_expr.toString() + ")";
        }
        if (typeSpec instanceof OctetType) {
            return "(byte)(" + this.const_expr.toString() + ")";
        }
        if (typeSpec instanceof FixedPointConstType || typeSpec instanceof FixedPointType) {
            return "new java.math.BigDecimal (" + this.const_expr.toString() + ")";
        }
        return this.const_expr.toString();
    }
}

