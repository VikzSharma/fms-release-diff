/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import org.jacorb.idl.BaseType;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.Environment;
import org.jacorb.idl.GlobalInputStream;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.TypeMap;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.Value;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;

public class ValueBoxDecl
extends Value {
    private boolean written = false;
    private boolean parsed = false;
    TypeSpec typeSpec;

    public ValueBoxDecl(int n) {
        super(n);
        this.pack_name = "";
    }

    public Object clone() {
        return null;
    }

    public TypeDeclaration declaration() {
        return this;
    }

    public String typeName() {
        if (this.typeName == null) {
            this.setPrintPhaseNames();
        }
        if (this.typeSpec.typeSpec() instanceof BaseType) {
            return this.typeName;
        }
        return this.typeSpec.typeSpec().typeName();
    }

    public String boxTypeName() {
        if (this.typeName == null) {
            this.setPrintPhaseNames();
        }
        return this.typeName;
    }

    public boolean basic() {
        return false;
    }

    public void set_included(boolean bl) {
        this.included = bl;
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        this.typeSpec.setPackage(string);
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            this.logger.error("was " + this.enclosing_symbol.getClass().getName() + " now: " + idlSymbol.getClass().getName());
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
    }

    public String toString() {
        return this.typeName();
    }

    public void parse() {
        if (this.parsed) {
            throw new RuntimeException("Compiler error: Value box already parsed!");
        }
        this.escapeName();
        this.typeSpec.parse();
        try {
            ConstrTypeSpec constrTypeSpec = new ConstrTypeSpec(ValueBoxDecl.new_num());
            constrTypeSpec.c_type_spec = this;
            NameTable.define(this.full_name(), "type");
            TypeMap.typedef(this.full_name(), constrTypeSpec);
        }
        catch (NameAlreadyDefined nameAlreadyDefined) {
            parser.error("Value box " + this.typeName() + " already defined", this.token);
        }
        this.parsed = true;
    }

    public String className() {
        String string = this.typeName();
        if (string.indexOf(46) > 0) {
            return string.substring(string.lastIndexOf(46) + 1);
        }
        return string;
    }

    public String printReadExpression(String string) {
        return "(" + this.typeName() + ")((org.omg.CORBA_2_3.portable.InputStream)" + string + ").read_value (new " + this.helperName() + "())";
    }

    public String printWriteStatement(String string, String string2) {
        return "((org.omg.CORBA_2_3.portable.OutputStream)" + string2 + ").write_value (" + string + ", new " + this.helperName() + "());";
    }

    public String holderName() {
        return this.boxTypeName() + "Holder";
    }

    public String helperName() {
        return this.boxTypeName() + "Helper";
    }

    public String getTypeCodeExpression(Set set) {
        if (set.contains(this)) {
            return this.getRecursiveTypeCodeExpression();
        }
        set.add(this);
        StringBuffer stringBuffer = new StringBuffer();
        String string = this.boxTypeName();
        if (string.indexOf(46) > 0) {
            string = string.substring(string.lastIndexOf(46) + 1);
        }
        stringBuffer.append("org.omg.CORBA.ORB.init().create_value_box_tc(" + this.helperName() + ".id(),\"" + string + "\"," + this.typeSpec.typeSpec().getTypeCodeExpression() + ")");
        return stringBuffer.toString();
    }

    public String getTypeCodeExpression() {
        return this.getTypeCodeExpression(new HashSet());
    }

    private void printHolderClass(String string, PrintWriter printWriter) {
        if (Environment.JAVA14 && this.pack_name.equals("")) {
            lexer.emit_warn("No package defined for " + string + " - illegal in JDK1.4", this.token);
        }
        if (!this.pack_name.equals("")) {
            printWriter.println("package " + this.pack_name + ";");
        }
        printWriter.println("public" + parser.getFinalString() + " class " + string + "Holder");
        printWriter.println("\timplements org.omg.CORBA.portable.Streamable");
        printWriter.println("{");
        printWriter.println("\tpublic " + this.typeName() + " value;\n");
        printWriter.println("\tpublic " + string + "Holder ()");
        printWriter.println("\t{");
        printWriter.println("\t}");
        printWriter.println("\tpublic " + string + "Holder (final " + this.typeName() + " initial)");
        printWriter.println("\t{");
        printWriter.println("\t\tvalue = initial;");
        printWriter.println("\t}");
        printWriter.println("\tpublic org.omg.CORBA.TypeCode _type ()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn " + this.helperName() + ".type ();");
        printWriter.println("\t}");
        printWriter.println("\tpublic void _read (final org.omg.CORBA.portable.InputStream _in)");
        printWriter.println("\t{");
        printWriter.println("\t\tvalue = " + this.helperName() + ".read (_in);");
        printWriter.println("\t}");
        printWriter.println("\tpublic void _write (final org.omg.CORBA.portable.OutputStream _out)");
        printWriter.println("\t{");
        printWriter.println("\t\t" + this.helperName() + ".write (_out,value);");
        printWriter.println("\t}");
        printWriter.println("}");
    }

    private void printHelperClass(String string, PrintWriter printWriter) {
        if (Environment.JAVA14 && this.pack_name.equals("")) {
            lexer.emit_warn("No package defined for " + string + " - illegal in JDK1.4", this.token);
        }
        if (!this.pack_name.equals("")) {
            printWriter.println("package " + this.pack_name + ";");
        }
        printWriter.println("public" + parser.getFinalString() + " class " + string + "Helper");
        printWriter.println("\timplements org.omg.CORBA.portable.BoxedValueHelper");
        printWriter.println("{");
        printWriter.println("\tprivate static org.omg.CORBA.TypeCode _type = " + this.getTypeCodeExpression() + ";");
        String string2 = this.typeName();
        printWriter.println("\tpublic static org.omg.CORBA.TypeCode type()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn _type;");
        printWriter.println("\t}");
        printWriter.println();
        printWriter.println("\tpublic static void insert (final org.omg.CORBA.Any any, final " + string2 + " s)");
        printWriter.println("\t{");
        printWriter.println("\t\tany.insert_Value(s, type());");
        printWriter.println("\t}\n");
        printWriter.println("\tpublic static " + string2 + " extract (final org.omg.CORBA.Any any)");
        printWriter.println("\t{");
        printWriter.println("\t\treturn (" + string2 + ") any.extract_Value();");
        printWriter.println("\t}\n");
        this.printIdMethod(printWriter);
        printWriter.println("\tpublic static " + string2 + " read (final org.omg.CORBA.portable.InputStream in)");
        printWriter.println("\t{");
        if (this.typeSpec.typeSpec() instanceof BaseType) {
            printWriter.println("\t\t" + string2 + " result = new " + string2 + "(" + this.typeSpec.typeSpec().printReadExpression("in") + ");");
        } else {
            printWriter.println("\t\t" + string2 + " result;");
            printWriter.println("\t\t" + this.typeSpec.typeSpec().printReadStatement("result", "in"));
        }
        printWriter.println("\t\treturn result;");
        printWriter.println("\t}");
        printWriter.println("\tpublic static void write (final org.omg.CORBA.portable.OutputStream out, final " + string2 + " s)");
        printWriter.println("\t{");
        if (this.typeSpec.typeSpec() instanceof BaseType) {
            printWriter.println("\t\t" + this.typeSpec.typeSpec().printWriteStatement("s.value", "out"));
        } else {
            printWriter.println("\t\t" + this.typeSpec.typeSpec().printWriteStatement("s", "out"));
        }
        printWriter.println("\t}");
        printWriter.println("\tpublic java.io.Serializable read_value (final org.omg.CORBA.portable.InputStream is)");
        printWriter.println("\t{");
        printWriter.println("\t\treturn " + this.helperName() + ".read (is);");
        printWriter.println("\t}");
        printWriter.println("\tpublic void write_value (final org.omg.CORBA.portable.OutputStream os, final java.io.Serializable value)");
        printWriter.println("\t{");
        printWriter.println("\t\t" + this.helperName() + ".write (os, (" + string2 + ")value);");
        printWriter.println("\t}");
        printWriter.println("\tpublic java.lang.String get_id()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn " + this.helperName() + ".id();");
        printWriter.println("\t}");
        printWriter.println("}");
    }

    private void printValueClass(String string, PrintWriter printWriter) {
        String string2 = string;
        if (Environment.JAVA14 && this.pack_name.equals("")) {
            lexer.emit_warn("No package defined for " + string + " - illegal in JDK1.4", this.token);
        }
        if (!this.pack_name.equals("")) {
            string2 = this.pack_name + "." + string;
            printWriter.println("package " + this.pack_name + ";");
        }
        printWriter.println("public class " + string);
        printWriter.println("\timplements org.omg.CORBA.portable.ValueBase");
        printWriter.println("{");
        printWriter.println("\tpublic " + this.typeSpec.typeName() + " value;");
        printWriter.println("\tprivate static String[] _ids = { " + string + "Helper.id() };");
        printWriter.println("\tpublic " + string + "(" + this.typeSpec.typeName() + " initial)");
        printWriter.println("\t{");
        printWriter.println("\t\tvalue = initial;");
        printWriter.println("\t}");
        printWriter.println("\tpublic String[] _truncatable_ids()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn _ids;");
        printWriter.println("\t}");
        printWriter.println("}");
    }

    public void print(PrintWriter printWriter) {
        this.setPrintPhaseNames();
        if (this.included && !this.generateIncluded()) {
            return;
        }
        if (!this.written) {
            try {
                PrintWriter printWriter2;
                String string;
                File file;
                String string2 = this.boxTypeName();
                if (string2.indexOf(46) > 0) {
                    string2 = string2.substring(string2.lastIndexOf(46) + 1);
                }
                if (!(file = new File(string = parser.out_dir + fileSeparator + this.pack_name.replace('.', fileSeparator))).exists() && !file.mkdirs()) {
                    parser.fatal_error("Unable to create " + string, null);
                }
                String string3 = string2 + ".java";
                File file2 = new File(file, string3);
                if (this.typeSpec.typeSpec() instanceof BaseType && GlobalInputStream.isMoreRecentThan(file2)) {
                    printWriter2 = new PrintWriter(new FileWriter(file2));
                    this.printValueClass(string2, printWriter2);
                    printWriter2.close();
                }
                if (GlobalInputStream.isMoreRecentThan(file2 = new File(file, string3 = string2 + "Holder.java"))) {
                    printWriter2 = new PrintWriter(new FileWriter(file2));
                    this.printHolderClass(string2, printWriter2);
                    printWriter2.close();
                }
                if (GlobalInputStream.isMoreRecentThan(file2 = new File(file, string3 = string2 + "Helper.java"))) {
                    printWriter2 = new PrintWriter(new FileWriter(file2));
                    this.printHelperClass(string2, printWriter2);
                    printWriter2.close();
                }
                this.written = true;
            }
            catch (IOException iOException) {
                throw new RuntimeException("File IO error" + iOException);
            }
        }
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        printWriter.println("\t\t" + string + ".type(" + this.getTypeCodeExpression() + ");");
        printWriter.println("\t\t" + this.helperName() + ".write(" + string + ".create_output_stream()," + string2 + ");");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        printWriter.println("\t\t" + string + " = (" + string3 + ")" + string2 + ".extract_Value();");
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        iDLTreeVisitor.visitValue(this);
    }
}

