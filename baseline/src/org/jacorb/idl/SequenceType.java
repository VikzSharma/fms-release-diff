/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.jacorb.idl.AliasTypeSpec;
import org.jacorb.idl.AnyType;
import org.jacorb.idl.BaseType;
import org.jacorb.idl.ConstExpr;
import org.jacorb.idl.Environment;
import org.jacorb.idl.GlobalInputStream;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.VectorType;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;

public class SequenceType
extends VectorType {
    private boolean written = false;
    private static int idxNum = 0;
    private boolean recursive = false;
    public ConstExpr max = null;
    int length = 0;

    public SequenceType(int n) {
        super(n);
        this.name = null;
        this.typedefd = false;
    }

    public Object clone() {
        SequenceType sequenceType = new SequenceType(IdlSymbol.new_num());
        sequenceType.type_spec = this.type_spec;
        sequenceType.max = this.max;
        sequenceType.length = this.length;
        sequenceType.name = this.name;
        sequenceType.pack_name = this.pack_name;
        sequenceType.included = this.included;
        sequenceType.typedefd = this.typedefd;
        sequenceType.recursive = this.recursive;
        sequenceType.set_token(this.get_token());
        sequenceType.setEnclosingSymbol(this.getEnclosingSymbol());
        return sequenceType;
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
    }

    public TypeSpec typeSpec() {
        return this;
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        this.type_spec.setPackage(string);
        if (this.max != null) {
            this.max.setPackage(string);
        }
    }

    public int length() {
        return this.length;
    }

    void setRecursive() {
        if (this.logger.isWarnEnabled()) {
            this.logger.warn("Sequence " + this.typeName + " set recursive ------- this: " + this);
        }
        this.recursive = true;
    }

    public String getTypeCodeExpression() {
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Sequence getTypeCodeExpression " + this.name);
        }
        String string = null;
        string = this.recursive ? "org.omg.CORBA.ORB.init().create_sequence_tc(" + this.length + ", org.omg.CORBA.ORB.init().create_recursive_tc(\"" + this.elementTypeSpec().id() + "\"))" : "org.omg.CORBA.ORB.init().create_sequence_tc(" + this.length + ", " + this.elementTypeExpression() + ")";
        return string;
    }

    public static int getNumber() {
        return idxNum++;
    }

    public String printReadStatement(String string, String string2) {
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Sequence printReadStatement for " + this.typeName());
        }
        StringBuffer stringBuffer = new StringBuffer();
        String string3 = this.typeName();
        String string4 = "_l" + string.replace('.', '_');
        if (string4.indexOf(91) > 0) {
            string4 = string4.substring(0, string4.indexOf(91)) + "_";
        }
        string4 = string4 + SequenceType.getNumber();
        stringBuffer.append("int " + string4 + " = " + string2 + ".read_long();\n");
        if (this.length != 0) {
            stringBuffer.append("\t\tif (" + string4 + " > " + this.length + ")\n");
            stringBuffer.append("\t\t\tthrow new org.omg.CORBA.MARSHAL(\"Sequence length incorrect!\");\n");
        }
        stringBuffer.append("\t\ttry\n\t\t{\n");
        stringBuffer.append("\t\t\t int x = " + string2 + ".available();\n");
        stringBuffer.append("\t\t\t if ( x > 0 && " + string4 + " > x )\n");
        stringBuffer.append("\t\t\t\t{\n");
        stringBuffer.append("\t\t\t\t\tthrow new org.omg.CORBA.MARSHAL(\"Sequence length too large. Only \" + x + \" available and trying to assign \" + " + string4 + ");\n");
        stringBuffer.append("\t\t\t\t}\n");
        stringBuffer.append("\t\t}\n\t\tcatch (java.io.IOException e)\n\t\t{\n\t\t}\n");
        stringBuffer.append("\t\t" + string + " = new " + string3.substring(0, string3.indexOf(91)) + "[" + string4 + "]" + string3.substring(string3.indexOf(93) + 1) + ";\n");
        TypeSpec typeSpec = this.elementTypeSpec();
        while (typeSpec instanceof AliasTypeSpec) {
            typeSpec = ((AliasTypeSpec)typeSpec).originalType();
        }
        if (typeSpec instanceof BaseType && !(typeSpec instanceof AnyType)) {
            String string5 = typeSpec.printReadExpression(string2);
            stringBuffer.append("\t\t");
            stringBuffer.append(string5.substring(0, string5.indexOf(40)));
            stringBuffer.append("_array(");
            stringBuffer.append(string);
            stringBuffer.append(",0,");
            stringBuffer.append(string4);
            stringBuffer.append(");");
        } else {
            char c = 'i';
            String string6 = "";
            if (string.endsWith("]")) {
                c = (char)(string.charAt(string.length() - 2) + '\u0001');
                string6 = "    ";
            }
            stringBuffer.append("\t\t" + string6 + "for (int " + c + "=0;" + c + "<" + string + ".length;" + c + "++)\n\t\t" + string6 + "{\n");
            stringBuffer.append("\t\t\t" + string6 + this.elementTypeSpec().printReadStatement(string + "[" + c + "]", string2) + "\n");
            stringBuffer.append("\t\t" + string6 + "}\n");
        }
        return stringBuffer.toString();
    }

    public String printWriteStatement(String string, String string2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.length != 0) {
            stringBuffer.append("\t\tif (" + string + ".length > " + this.length + ")\n");
            stringBuffer.append("\t\t\tthrow new org.omg.CORBA.MARSHAL(\"Incorrect sequence length\");");
        }
        stringBuffer.append("\n\t\t" + string2 + ".write_long(" + string + ".length);\n");
        TypeSpec typeSpec = this.elementTypeSpec();
        while (typeSpec instanceof AliasTypeSpec) {
            typeSpec = ((AliasTypeSpec)typeSpec).originalType();
        }
        if (typeSpec instanceof BaseType && !(typeSpec instanceof AnyType)) {
            String string3 = typeSpec.printWriteStatement(string, string2);
            stringBuffer.append("\t\t");
            stringBuffer.append(string3.substring(0, string3.indexOf(40)));
            stringBuffer.append("_array(");
            stringBuffer.append(string);
            stringBuffer.append(",0,");
            stringBuffer.append(string);
            stringBuffer.append(".length);");
        } else {
            char c = 'i';
            String string4 = "";
            if (string.endsWith("]")) {
                c = (char)(string.charAt(string.length() - 2) + '\u0001');
                string4 = "    ";
            }
            stringBuffer.append("\t\t" + string4 + "for (int " + c + "=0; " + c + "<" + string + ".length;" + c + "++)\n\t\t" + string4 + "{\n");
            stringBuffer.append("\t\t\t" + string4 + this.elementTypeSpec().printWriteStatement(string + "[" + c + "]", string2) + "\n");
            stringBuffer.append("\t\t" + string4 + "}\n");
        }
        return stringBuffer.toString();
    }

    public String holderName() {
        if (!this.typedefd) {
            throw new RuntimeException("Compiler Error: should not be called (helpername on not typedef'd SequenceType " + this.name + ")");
        }
        String string = this.full_name();
        if (this.pack_name.length() > 0) {
            string = this.getFullName(string);
        }
        return string + "Holder";
    }

    public String helperName() {
        if (!this.typedefd) {
            throw new RuntimeException("Compiler Error: should not be called (helperName() on not typedef'd SequenceType)");
        }
        String string = this.full_name();
        if (this.pack_name.length() > 0) {
            string = this.getFullName(string);
        }
        return string + "Helper";
    }

    public String className() {
        String string;
        String string2 = this.full_name();
        if (string2.indexOf(46) > 0) {
            this.pack_name = string2.substring(0, string2.lastIndexOf(46));
            string = string2.substring(string2.lastIndexOf(46) + 1);
        } else {
            this.pack_name = "";
            string = string2;
        }
        return string;
    }

    public void parse() {
        if (this.max != null) {
            this.max.parse();
            this.length = this.max.pos_int_const();
        }
        if (this.type_spec.typeSpec() instanceof ScopedName) {
            TypeSpec typeSpec = ((ScopedName)this.type_spec.typeSpec()).resolvedTypeSpec();
            if (typeSpec != null) {
                this.type_spec = typeSpec;
            }
            if (this.type_spec instanceof AliasTypeSpec) {
                this.addImportedAlias(this.type_spec.full_name());
            } else {
                this.addImportedName(this.type_spec.typeName());
            }
            this.addImportedName(this.type_spec.typeSpec().typeName());
        }
        try {
            NameTable.define(this.full_name(), "type");
        }
        catch (NameAlreadyDefined nameAlreadyDefined) {
            // empty catch block
        }
    }

    public String full_name() {
        if (this.name == null) {
            return "<" + this.pack_name + ".anon>";
        }
        if (this.pack_name.length() > 0) {
            return ScopedName.unPseudoName(this.pack_name + "." + this.name);
        }
        return ScopedName.unPseudoName(this.name);
    }

    private void printHolderClass(String string, PrintWriter printWriter) {
        if (Environment.JAVA14 && this.pack_name.equals("")) {
            lexer.emit_warn("No package defined for " + string + " - illegal in JDK1.4", this.token);
        }
        if (!this.pack_name.equals("")) {
            printWriter.println("package " + this.pack_name + ";\n");
        }
        String string2 = this.typeName();
        this.printImport(printWriter);
        this.printClassComment("sequence", string, printWriter);
        printWriter.println("public" + parser.getFinalString() + " class " + string + "Holder");
        printWriter.println("\timplements org.omg.CORBA.portable.Streamable");
        printWriter.println("{");
        printWriter.println("\tpublic " + string2 + " value;");
        printWriter.println("\tpublic " + string + "Holder ()");
        printWriter.println("\t{");
        printWriter.println("\t}");
        printWriter.println("\tpublic " + string + "Holder (final " + string2 + " initial)\n\t{");
        printWriter.println("\t\tvalue = initial;");
        printWriter.println("\t}");
        printWriter.println("\tpublic org.omg.CORBA.TypeCode _type ()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn " + string + "Helper.type ();");
        printWriter.println("\t}");
        printWriter.println("\tpublic void _read (final org.omg.CORBA.portable.InputStream _in)");
        printWriter.println("\t{");
        printWriter.println("\t\tvalue = " + string + "Helper.read (_in);");
        printWriter.println("\t}");
        printWriter.println("\tpublic void _write (final org.omg.CORBA.portable.OutputStream _out)");
        printWriter.println("\t{");
        printWriter.println("\t\t" + string + "Helper.write (_out,value);");
        printWriter.println("\t}");
        printWriter.println("}");
    }

    private void printHelperClass(String string, PrintWriter printWriter) {
        String string2;
        if (Environment.JAVA14 && this.pack_name.equals("")) {
            lexer.emit_warn("No package defined for " + string + " - illegal in JDK1.4", this.token);
        }
        if (!this.pack_name.equals("")) {
            printWriter.println("package " + this.pack_name + ";");
        }
        String string3 = this.typeName();
        this.printImport(printWriter);
        this.printClassComment("sequence", string, printWriter);
        printWriter.println("public" + parser.getFinalString() + " class " + string + "Helper");
        printWriter.println("{");
        printWriter.println("\tprivate static org.omg.CORBA.TypeCode _type = " + this.getTypeCodeExpression() + ";");
        TypeSpec.printHelperClassMethods(printWriter, string3);
        this.printIdMethod(printWriter);
        printWriter.println("\tpublic static " + string3 + " read (final org.omg.CORBA.portable.InputStream in)");
        printWriter.println("\t{");
        printWriter.println("\t\tint l = in.read_long();");
        if (this.length != 0) {
            printWriter.println("\t\tif (l > " + this.length + ")");
            printWriter.println("\t\t\tthrow new org.omg.CORBA.MARSHAL();");
        }
        printWriter.println("\t\t" + string3 + " result = new " + string3.substring(0, string3.indexOf(91)) + "[l]" + string3.substring(string3.indexOf(93) + 1) + ";");
        if (this.elementTypeSpec() instanceof BaseType && !(this.elementTypeSpec() instanceof AnyType)) {
            string2 = this.elementTypeSpec().printReadExpression("in");
            printWriter.println("\t\t" + string2.substring(0, string2.indexOf(40)) + "_array(result,0,result.length);");
        } else {
            printWriter.println("\t\tfor (int i = 0; i < l; i++)");
            printWriter.println("\t\t{");
            printWriter.println("\t\t\t" + this.elementTypeSpec().printReadStatement("result[i]", "in"));
            printWriter.println("\t\t}");
        }
        printWriter.println("\t\treturn result;");
        printWriter.println("\t}");
        printWriter.println("\tpublic static void write (final org.omg.CORBA.portable.OutputStream out, final " + string3 + " s)");
        printWriter.println("\t{");
        if (this.length != 0) {
            printWriter.println("\t\tif (s.length > " + this.length + ")");
            printWriter.println("\t\t\tthrow new org.omg.CORBA.MARSHAL();");
        }
        printWriter.println("\t\tout.write_long(s.length);");
        if (this.elementTypeSpec() instanceof BaseType && !(this.elementTypeSpec() instanceof AnyType)) {
            string2 = this.elementTypeSpec().printWriteStatement("s", "out");
            printWriter.println(string2.substring(0, string2.indexOf(40)) + "_array(s,0,s.length);");
        } else {
            printWriter.println("\t\tfor (int i = 0; i < s.length; i++)");
            printWriter.println("\t\t\t" + this.elementTypeSpec().printWriteStatement("s[i]", "out"));
        }
        printWriter.println("\t}");
        printWriter.println("}");
    }

    public void print(PrintWriter printWriter) {
        try {
            if (!this.written && this.typedefd) {
                PrintWriter printWriter2;
                String string;
                File file;
                String string2;
                String string3 = this.full_name();
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
                if (GlobalInputStream.isMoreRecentThan(file = new File(file2, string = string2 + "Holder.java"))) {
                    printWriter2 = new PrintWriter(new FileWriter(file));
                    this.printHolderClass(string2, printWriter2);
                    printWriter2.close();
                }
                if (GlobalInputStream.isMoreRecentThan(file = new File(file2, string = string2 + "Helper.java"))) {
                    printWriter2 = new PrintWriter(new FileWriter(file));
                    this.printHelperClass(string2, printWriter2);
                    printWriter2.close();
                }
                this.written = true;
            }
        }
        catch (IOException iOException) {
            throw new RuntimeException("File IO error" + iOException);
        }
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        printWriter.println("\t" + this.helperName() + ".insert(" + string + ", " + string2 + " );");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        throw new RuntimeException("DII Stubs not yet complete for Sequence types");
    }
}

