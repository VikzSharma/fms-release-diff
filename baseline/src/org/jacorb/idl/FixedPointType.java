/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.jacorb.idl.ConstExpr;
import org.jacorb.idl.Environment;
import org.jacorb.idl.GlobalInputStream;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.TemplateTypeSpec;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;

public class FixedPointType
extends TemplateTypeSpec {
    public ConstExpr digit_expr = null;
    public ConstExpr scale_expr = null;
    public int digits = 0;
    public int scale = 0;

    public FixedPointType(int n) {
        super(n);
    }

    public Object clone() {
        FixedPointType fixedPointType = new FixedPointType(FixedPointType.new_num());
        fixedPointType.name = this.name;
        fixedPointType.pack_name = this.pack_name;
        fixedPointType.digit_expr = this.digit_expr;
        fixedPointType.digits = this.digits;
        fixedPointType.scale_expr = this.scale_expr;
        fixedPointType.scale = this.scale;
        fixedPointType.included = this.included;
        fixedPointType.typedefd = this.typedefd;
        fixedPointType.set_token(this.get_token());
        fixedPointType.setEnclosingSymbol(this.getEnclosingSymbol());
        return fixedPointType;
    }

    public String helperName() {
        if (this.pack_name.length() > 0) {
            String string = ScopedName.unPseudoName(this.pack_name + "." + this.name);
            return this.getFullName(string);
        }
        return ScopedName.unPseudoName(this.name);
    }

    public String typeName() {
        return "java.math.BigDecimal";
    }

    public String getIDLTypeName() {
        return "fixed";
    }

    public int getTCKind() {
        return 28;
    }

    public TypeSpec typeSpec() {
        return this;
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
    }

    private void printHelperClass(String string, PrintWriter printWriter) {
        if (Environment.JAVA14 && this.pack_name.equals("")) {
            lexer.emit_warn("No package defined for " + string + " - illegal in JDK1.4", this.token);
        }
        if (!this.pack_name.equals("")) {
            printWriter.println("package " + this.pack_name + ";");
        }
        printWriter.println("public" + parser.getFinalString() + " class " + string + "Helper");
        printWriter.println("{");
        printWriter.println("\tprivate static org.omg.CORBA.TypeCode _type = " + this.getTypeCodeExpression() + ";");
        printWriter.println("\tpublic static void insert(org.omg.CORBA.Any any, java.math.BigDecimal s)");
        printWriter.println("\t{");
        printWriter.println("\t\tany.insert_fixed(s, type());");
        printWriter.println("\t}");
        printWriter.println("\tpublic static java.math.BigDecimal extract(org.omg.CORBA.Any any)");
        printWriter.println("\t{");
        printWriter.println("\t\treturn any.extract_fixed();");
        printWriter.println("\t}");
        printWriter.println("\tpublic static org.omg.CORBA.TypeCode type()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn _type;");
        printWriter.println("\t}");
        this.printIdMethod(printWriter);
        printWriter.println("\tpublic static java.math.BigDecimal read (final org.omg.CORBA.portable.InputStream in)");
        printWriter.println("\t{");
        printWriter.println("\t\tjava.math.BigDecimal result = in.read_fixed();");
        printWriter.println("\t\treturn result.movePointLeft(" + this.scale + ");");
        printWriter.println("\t}");
        printWriter.println("\tpublic static void write (final org.omg.CORBA.portable.OutputStream out, final java.math.BigDecimal s)");
        printWriter.println("\t{");
        StringBuffer stringBuffer = new StringBuffer("1");
        for (int i = 0; i < this.digits - this.scale; ++i) {
            stringBuffer.append("0");
        }
        printWriter.println("\t\tif (s.scale() != " + this.scale + ")");
        printWriter.println("\t\t\tthrow new org.omg.CORBA.DATA_CONVERSION();");
        printWriter.println("\t\tjava.math.BigDecimal max = new java.math.BigDecimal(\"" + stringBuffer.toString() + "\");");
        printWriter.println("\t\tif (s.compareTo(max) != -1)");
        printWriter.println("\t\t\tthrow new org.omg.CORBA.DATA_CONVERSION();");
        printWriter.println("\t\tout.write_fixed(s);");
        printWriter.println("\t}");
        printWriter.println("}");
    }

    public void print(PrintWriter printWriter) {
        try {
            String string;
            File file;
            String string2;
            String string3 = this.helperName();
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
            if (GlobalInputStream.isMoreRecentThan(file = new File(file2, string = string2 + "Helper.java"))) {
                PrintWriter printWriter2 = new PrintWriter(new FileWriter(file));
                this.printHelperClass(string2, printWriter2);
                printWriter2.close();
            }
        }
        catch (IOException iOException) {
            throw new RuntimeException("File IO error" + iOException);
        }
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
    }

    public String toString() {
        return this.typeName();
    }

    public String holderName() {
        return "org.omg.CORBA.FixedHolder";
    }

    public String getTypeCodeExpression() {
        return "org.omg.CORBA.ORB.init().create_fixed_tc((short)" + this.digits + ",(short)" + this.scale + ")";
    }

    public String printReadExpression(String string) {
        return this.helperName() + "Helper.read(" + string + ")";
    }

    public String printReadStatement(String string, String string2) {
        String string3 = null;
        string3 = this.hashCode() > 0 ? "_fixed" + this.hashCode() : "_fixed" + -1 * this.hashCode();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\t\tjava.math.BigDecimal " + string3 + "=" + string2 + ".read_fixed();\n");
        stringBuffer.append("\t\t" + string + " = " + string3 + ".movePointLeft(" + this.scale + ");\n");
        return stringBuffer.toString();
    }

    public String printWriteStatement(String string, String string2) {
        StringBuffer stringBuffer = new StringBuffer("1");
        for (int i = 0; i < this.digits - this.scale; ++i) {
            stringBuffer.append("0");
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("\n\t\tif (" + string + ".scale() != " + this.scale + ")\n");
        stringBuffer2.append("\t\t\tthrow new org.omg.CORBA.DATA_CONVERSION(\"wrong scale in fixed point value, expecting " + this.scale + ", got \" + " + string + ".scale());\n");
        String string3 = null;
        string3 = this.hashCode() > 0 ? "_max" + this.hashCode() : "_max" + -1 * this.hashCode();
        stringBuffer2.append("\t\tjava.math.BigDecimal " + string3 + "= new java.math.BigDecimal(\"" + stringBuffer.toString() + "\");\n");
        stringBuffer2.append("\t\tif (" + string + ".compareTo(" + string3 + ") != -1)\n");
        stringBuffer2.append("\t\t\tthrow new org.omg.CORBA.DATA_CONVERSION(\"more than " + this.digits + " digits in fixed point value\");\n");
        stringBuffer2.append("\t\t" + string2 + ".write_fixed(" + string + ");\n");
        return stringBuffer2.toString();
    }

    public void parse() {
        this.digits = this.digit_expr.pos_int_const();
        this.scale = this.scale_expr.pos_int_const();
        if (this.scale < 0 || this.digits <= 0 || this.scale > this.digits) {
            parser.error("Error in fixed point type " + this.typeName() + ", invalid format: <" + this.digits + "," + this.scale + ">");
        }
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        String string3 = this.helperName();
        String string4 = string3.indexOf(46) > 0 ? string3.substring(string3.lastIndexOf(46) + 1) : string3;
        String string5 = string4 + "Helper";
        printWriter.println("\t\t" + string5 + ".insert(" + string + ", " + string2 + " )");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        throw new RuntimeException("DII-stubs not completely implemented for fixed-point types");
    }
}

