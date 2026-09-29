/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.jacorb.idl.AnyType;
import org.jacorb.idl.ArrayDeclarator;
import org.jacorb.idl.BaseType;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.Environment;
import org.jacorb.idl.GlobalInputStream;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.ParseException;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.VectorType;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;

public class ArrayTypeSpec
extends VectorType {
    ArrayDeclarator declarator = null;
    String typename = null;
    String dimensionStr = "";
    public int[] dims = null;
    int my_dim = 0;
    String typeSig;
    private boolean written = false;

    public ArrayTypeSpec(int n, TypeSpec typeSpec, ArrayDeclarator arrayDeclarator, String string) {
        super(n);
        this.declarator = arrayDeclarator;
        this.name = this.declarator.name();
        this.set_token(arrayDeclarator.get_token());
        this.setEnclosingSymbol(arrayDeclarator.getEnclosingSymbol());
        this.pack_name = string;
        this.type_spec = typeSpec;
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("ArrayTypeSpec with declarator " + arrayDeclarator.name());
        }
    }

    private ArrayTypeSpec(int n, TypeSpec typeSpec, ArrayDeclarator arrayDeclarator, String string, int n2) {
        super(n);
        this.declarator = arrayDeclarator;
        this.name = this.declarator.name();
        this.dims = this.declarator.dimensions();
        this.set_token(arrayDeclarator.get_token());
        this.setEnclosingSymbol(arrayDeclarator.getEnclosingSymbol());
        this.pack_name = string;
        this.my_dim = n2;
        this.type_spec = this.dims.length > n2 + 1 ? new ArrayTypeSpec(ArrayTypeSpec.new_num(), typeSpec, arrayDeclarator, string, n2 + 1) : typeSpec;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = n2; i < this.dims.length; ++i) {
            stringBuffer.append("[]");
        }
        this.dimensionStr = stringBuffer.toString();
    }

    public Object clone() {
        ArrayTypeSpec arrayTypeSpec = new ArrayTypeSpec(ArrayTypeSpec.new_num(), this.type_spec, this.declarator, this.pack_name);
        arrayTypeSpec.dims = this.dims;
        arrayTypeSpec.included = this.included;
        arrayTypeSpec.typedefd = this.typedefd;
        arrayTypeSpec.inhibitionFlag = this.inhibitionFlag;
        arrayTypeSpec.dims = this.dims;
        arrayTypeSpec.my_dim = this.my_dim;
        arrayTypeSpec.dimensionStr = this.dimensionStr;
        arrayTypeSpec.set_token(this.get_token());
        arrayTypeSpec.setEnclosingSymbol(this.getEnclosingSymbol());
        return arrayTypeSpec;
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
        throw new RuntimeException("ArrayTypeSpec.setPackage should never be called!");
    }

    public void markTypeDefd() {
        this.typedefd = true;
    }

    public void parse() throws ParseException {
        Object object;
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("ArrayTypeSpec.parse " + this.declarator.name());
        }
        this.dims = this.declarator.dimensions();
        if (this.dims.length > 1) {
            this.type_spec = new ArrayTypeSpec(ArrayTypeSpec.new_num(), this.type_spec, this.declarator, this.pack_name, 1);
        } else if (this.type_spec.typeSpec() instanceof ConstrTypeSpec) {
            this.type_spec.parse();
        } else if (this.type_spec.typeSpec() instanceof ScopedName && (object = ((ScopedName)this.type_spec.typeSpec()).resolvedTypeSpec()) != null) {
            this.type_spec = object;
        }
        object = new StringBuffer();
        for (int i = this.my_dim; i < this.dims.length; ++i) {
            ((StringBuffer)object).append("[]");
        }
        this.dimensionStr = ((StringBuffer)object).toString();
        try {
            if (!this.typedefd) {
                NameTable.define(this.full_name(), "type");
            }
            if (!NameTable.isDefined(this.typeName(), "type")) {
                NameTable.define(this.typeName(), "type");
            }
        }
        catch (NameAlreadyDefined nameAlreadyDefined) {
            parser.fatal_error("Name " + this.full_name() + " already defined.", null);
        }
    }

    public String getTypeCodeExpression() {
        String string = "org.omg.CORBA.ORB.init().create_array_tc(" + this.dims[this.my_dim] + "," + this.elementTypeSpec().getTypeCodeExpression() + ")";
        return string;
    }

    public int getTCKind() {
        return 20;
    }

    public String helperName() {
        return ScopedName.unPseudoName(this.full_name()) + "Helper";
    }

    public String holderName() {
        return ScopedName.unPseudoName(this.full_name()) + "Holder";
    }

    public String className() {
        String string;
        String string2 = this.pack_name.length() > 0 ? ScopedName.unPseudoName(this.pack_name + "." + this.name) : ScopedName.unPseudoName(this.name);
        if (string2.indexOf(46) > 0) {
            this.pack_name = string2.substring(0, string2.lastIndexOf(46));
            string = string2.substring(string2.lastIndexOf(46) + 1);
        } else {
            this.pack_name = "";
            string = string2;
        }
        return string;
    }

    public int length() {
        return this.dims[this.my_dim];
    }

    public String printReadStatement(String string, String string2) {
        if (this.logger.isWarnEnabled()) {
            this.logger.warn("Array printReadStatement");
        }
        StringBuffer stringBuffer = new StringBuffer();
        String string3 = this.typeName();
        stringBuffer.append(string + " = new " + string3.substring(0, string3.indexOf("[")));
        stringBuffer.append("[" + this.length() + "]");
        stringBuffer.append(string3.substring(string3.indexOf(93) + 1) + ";\n");
        if (this.elementTypeSpec() instanceof BaseType && !(this.elementTypeSpec() instanceof AnyType)) {
            String string4 = this.elementTypeSpec().printReadExpression(string2);
            stringBuffer.append("\t\t" + string4.substring(0, string4.indexOf("(")) + "_array(" + string + ",0," + this.length() + ");");
        } else {
            char c = 'i';
            String string5 = "";
            if (string.endsWith("]")) {
                c = (char)(string.charAt(string.length() - 2) + '\u0001');
                string5 = "    ";
            }
            stringBuffer.append("\t\t" + string5 + "for (int " + c + "=0;" + c + "<" + this.length() + ";" + c + "++)\n\t\t" + string5 + "{\n");
            stringBuffer.append("\t\t\t" + string5 + this.elementTypeSpec().printReadStatement(string + "[" + c + "]", string2) + "\n");
            stringBuffer.append("\t\t" + string5 + "}\n");
        }
        return stringBuffer.toString();
    }

    public String printWriteStatement(String string, String string2) {
        StringBuffer stringBuffer = new StringBuffer();
        String string3 = this.typeName();
        stringBuffer.append("\t\tif (" + string + ".length<" + this.length() + ")\n\t\t\tthrow new org.omg.CORBA.MARSHAL(\"Incorrect array size \"+" + string + ".length+\", expecting " + this.length() + "\");\n");
        if (this.elementTypeSpec() instanceof BaseType && !(this.elementTypeSpec() instanceof AnyType)) {
            String string4 = this.elementTypeSpec().printWriteStatement(string, string2);
            stringBuffer.append("\t\t" + string4.substring(0, string4.indexOf("(")) + "_array(" + string + ",0," + this.length() + ");");
        } else {
            char c = 'i';
            String string5 = "";
            if (string.endsWith("]")) {
                c = (char)(string.charAt(string.length() - 2) + '\u0001');
                string5 = "    ";
            }
            stringBuffer.append("\t\t" + string5 + "for (int " + c + "=0; " + c + "<" + this.length() + ";" + c + "++)\n\t\t" + string5 + "{\n");
            stringBuffer.append("\t\t\t" + string5 + this.elementTypeSpec().printWriteStatement(string + "[" + c + "]", string2) + "\n");
            stringBuffer.append("\t\t" + string5 + "}\n");
        }
        return stringBuffer.toString();
    }

    private void printHolderClass(String string, PrintWriter printWriter) {
        if (Environment.JAVA14 && this.pack_name.equals("")) {
            lexer.emit_warn("No package defined for " + string + " - illegal in JDK1.4", this.token);
        }
        if (!this.pack_name.equals("")) {
            printWriter.println("package " + this.pack_name + ";\n");
        }
        String string2 = this.typeName();
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
        TypeSpec typeSpec = this.type_spec;
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
        printWriter.println("public" + parser.getFinalString() + " class " + string + "Helper");
        printWriter.println("{");
        printWriter.println("\tprivate static org.omg.CORBA.TypeCode _type = " + this.getTypeCodeExpression() + ";");
        TypeSpec.printHelperClassMethods(printWriter, string3);
        this.printIdMethod(printWriter);
        printWriter.println("\tpublic static " + string3 + " read (final org.omg.CORBA.portable.InputStream _in)");
        printWriter.println("\t{");
        printWriter.print("\t\t" + string3 + " result = new " + string3.substring(0, string3.indexOf(91)) + "[" + this.length() + "]");
        printWriter.println(string3.substring(string3.indexOf(93) + 1) + "; // " + string3);
        if (this.elementTypeSpec() instanceof BaseType && !(this.elementTypeSpec() instanceof AnyType)) {
            string2 = this.elementTypeSpec().printReadExpression("_in");
            printWriter.println("\t\t" + string2.substring(0, string2.indexOf("(")) + "_array(result,0," + this.length() + ");");
        } else {
            printWriter.println("\t\tfor (int i = 0; i < " + this.length() + "; i++)\n\t\t{");
            printWriter.println("\t\t\t" + this.elementTypeSpec().printReadStatement("result[i]", "_in") + "\n\t\t}");
        }
        printWriter.println("\t\treturn result;");
        printWriter.println("\t}");
        printWriter.println("\tpublic static void write (final org.omg.CORBA.portable.OutputStream out, final " + string3 + " s)");
        printWriter.println("\t{");
        if (this.declarator.dimensions()[0] != 0) {
            printWriter.println("\t\tif (s.length != " + this.declarator.dimensions()[0] + ")");
            printWriter.println("\t\t\tthrow new org.omg.CORBA.MARSHAL(\"Incorrect array size\");");
        }
        if (this.elementTypeSpec() instanceof BaseType && !(this.elementTypeSpec() instanceof AnyType)) {
            string2 = this.elementTypeSpec().printWriteStatement("s", "out");
            printWriter.println("\t\t" + string2.substring(0, string2.indexOf("(")) + "_array(s,0," + this.length() + ");");
        } else {
            printWriter.println("\t\tfor (int i = 0; i < s.length; i++)\n\t\t{");
            printWriter.println("\t\t\t" + this.elementTypeSpec().printWriteStatement("s[i]", "out") + "\n\t\t}");
        }
        printWriter.println("\t}");
        printWriter.println("}");
    }

    public void print(PrintWriter printWriter) {
        if (this.included && !this.generateIncluded()) {
            return;
        }
        try {
            this.type_spec.print(printWriter);
            if (!this.written && this.typedefd) {
                PrintWriter printWriter2;
                String string;
                File file;
                String string2 = this.className();
                String string3 = parser.out_dir + fileSeparator + this.pack_name.replace('.', fileSeparator);
                File file2 = new File(string3);
                if (!file2.exists() && !file2.mkdirs()) {
                    parser.fatal_error("Unable to create " + string3, null);
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
        String string3 = this.className() + "Helper";
        printWriter.println("\t\t" + this.pack_name + "." + string3 + ".insert(" + string + ", " + string2 + " );");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        throw new RuntimeException("DII-stubs not completely implemented for array types!");
    }
}

