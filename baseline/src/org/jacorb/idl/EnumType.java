/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Set;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.Environment;
import org.jacorb.idl.GlobalInputStream;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.SwitchTypeSpec;
import org.jacorb.idl.SymbolList;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.TypeMap;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;

public class EnumType
extends TypeDeclaration
implements SwitchTypeSpec {
    public SymbolList enumlist;
    int const_counter = 0;
    private boolean written = false;
    private boolean parsed = false;

    public EnumType(int n) {
        super(n);
        this.pack_name = "";
    }

    public Object clone() {
        EnumType enumType = new EnumType(EnumType.new_num());
        enumType.enumlist = this.enumlist;
        enumType.typeName = this.typeName;
        enumType.pack_name = this.pack_name;
        enumType.name = this.name;
        enumType.token = this.token;
        enumType.included = this.included;
        enumType.enclosing_symbol = this.enclosing_symbol;
        enumType.parsed = this.parsed;
        return enumType;
    }

    public TypeDeclaration declaration() {
        return this;
    }

    public int size() {
        return this.enumlist.v.size();
    }

    public void set_included(boolean bl) {
        this.included = bl;
    }

    public String typeName() {
        if (this.typeName == null) {
            this.setPrintPhaseNames();
        }
        return this.typeName;
    }

    public boolean basic() {
        return true;
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

    public void parse() {
        if (this.parsed) {
            return;
        }
        this.parsed = true;
        this.escapeName();
        try {
            ConstrTypeSpec constrTypeSpec = new ConstrTypeSpec(EnumType.new_num());
            constrTypeSpec.c_type_spec = this;
            NameTable.define(this.full_name(), "type");
            TypeMap.typedef(this.full_name(), constrTypeSpec);
            String string = null;
            String string2 = this.pack_name.length() > 0 ? this.full_name().substring(0, this.full_name().lastIndexOf(46) + 1) : "";
            Enumeration enumeration = this.enumlist.v.elements();
            while (enumeration.hasMoreElements()) {
                string = (String)enumeration.nextElement();
                try {
                    NameTable.define(string2 + string, "enum label");
                    ScopedName.enumMap(string2 + string, this.full_name() + "." + string);
                }
                catch (NameAlreadyDefined nameAlreadyDefined) {
                    parser.error("Identifier " + string + " already defined in immediate scope\n", this.token);
                }
            }
        }
        catch (NameAlreadyDefined nameAlreadyDefined) {
            parser.error("Enum " + this.full_name() + " already defined", this.token);
        }
    }

    public String className() {
        String string = this.typeName();
        if (string.indexOf(46) > 0) {
            return string.substring(string.lastIndexOf(46) + 1);
        }
        return string;
    }

    public String printReadExpression(String string) {
        return this.toString() + "Helper.read(" + string + ")";
    }

    public String printWriteStatement(String string, String string2) {
        return this.toString() + "Helper.write(" + string2 + "," + string + ");";
    }

    public String holderName() {
        return this.typeName() + "Holder";
    }

    public String helperName() {
        return this.typeName() + "Helper";
    }

    public String getTypeCodeExpression() {
        return this.full_name() + "Helper.type()";
    }

    public String getTypeCodeExpression(Set set) {
        if (set.contains(this)) {
            return this.getRecursiveTypeCodeExpression();
        }
        return this.getTypeCodeExpression();
    }

    private void printHolderClass(String string, PrintWriter printWriter) {
        if (Environment.JAVA14 && this.pack_name.equals("")) {
            lexer.emit_warn("No package defined for " + string + " - illegal in JDK1.4", this.token);
        }
        if (!this.pack_name.equals("")) {
            printWriter.println("package " + this.pack_name + ";");
        }
        this.printClassComment("enum", string, printWriter);
        printWriter.println("public" + parser.getFinalString() + " class " + string + "Holder");
        printWriter.println("\timplements org.omg.CORBA.portable.Streamable");
        printWriter.println("{");
        printWriter.println("\tpublic " + string + " value;\n");
        printWriter.println("\tpublic " + string + "Holder ()");
        printWriter.println("\t{");
        printWriter.println("\t}");
        printWriter.println("\tpublic " + string + "Holder (final " + string + " initial)");
        printWriter.println("\t{");
        printWriter.println("\t\tvalue = initial;");
        printWriter.println("\t}");
        printWriter.println("\tpublic org.omg.CORBA.TypeCode _type ()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn " + string + "Helper.type ();");
        printWriter.println("\t}");
        printWriter.println("\tpublic void _read (final org.omg.CORBA.portable.InputStream in)");
        printWriter.println("\t{");
        printWriter.println("\t\tvalue = " + string + "Helper.read (in);");
        printWriter.println("\t}");
        printWriter.println("\tpublic void _write (final org.omg.CORBA.portable.OutputStream out)");
        printWriter.println("\t{");
        printWriter.println("\t\t" + string + "Helper.write (out,value);");
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
        this.printClassComment("enum", string, printWriter);
        printWriter.println("public" + parser.getFinalString() + " class " + string + "Helper");
        printWriter.println("{");
        printWriter.println("\tprivate static org.omg.CORBA.TypeCode _type = null;");
        printWriter.println("\tpublic static org.omg.CORBA.TypeCode type ()");
        printWriter.println("\t{");
        printWriter.println("\t\tif (_type == null)");
        printWriter.println("\t\t{");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("org.omg.CORBA.ORB.init().create_enum_tc(" + this.typeName() + "Helper.id(),\"" + this.className() + "\",");
        stringBuffer.append("new String[]{");
        Object object = this.enumlist.v.elements();
        while (object.hasMoreElements()) {
            stringBuffer.append("\"" + (String)object.nextElement() + "\"");
            if (!object.hasMoreElements()) continue;
            stringBuffer.append(",");
        }
        stringBuffer.append("})");
        printWriter.println("\t\t\t_type = " + stringBuffer.toString() + ";");
        printWriter.println("\t\t}");
        printWriter.println("\t\treturn _type;");
        printWriter.println("\t}\n");
        object = this.typeName();
        TypeSpec.printInsertExtractMethods(printWriter, (String)object);
        this.printIdMethod(printWriter);
        printWriter.println("\tpublic static " + string + " read (final org.omg.CORBA.portable.InputStream in)");
        printWriter.println("\t{");
        printWriter.println("\t\treturn " + string + ".from_int(in.read_long());");
        printWriter.println("\t}\n");
        printWriter.println("\tpublic static void write (final org.omg.CORBA.portable.OutputStream out, final " + string + " s)");
        printWriter.println("\t{");
        printWriter.println("\t\tout.write_long(s.value());");
        printWriter.println("\t}");
        printWriter.println("}");
    }

    private void printEnumClass(String string, PrintWriter printWriter) {
        String string2;
        if (Environment.JAVA14 && this.pack_name.equals("")) {
            lexer.emit_warn("No package defined for " + string + " - illegal in JDK1.4", this.token);
        }
        if (!this.pack_name.equals("")) {
            printWriter.println("package " + this.pack_name + ";");
        }
        this.printClassComment("enum", string, printWriter);
        printWriter.println("public" + parser.getFinalString() + " class " + string);
        printWriter.println("\timplements org.omg.CORBA.portable.IDLEntity\n{");
        printWriter.println("\tprivate int value = -1;");
        Enumeration enumeration = this.enumlist.v.elements();
        while (enumeration.hasMoreElements()) {
            string2 = (String)enumeration.nextElement();
            printWriter.println("\tpublic static final int _" + string2 + " = " + this.const_counter++ + ";");
            printWriter.println("\tpublic static final " + this.name + " " + string2 + " = new " + this.name + "(_" + string2 + ");");
        }
        printWriter.println("\tpublic int value()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn value;");
        printWriter.println("\t}");
        printWriter.println("\tpublic static " + this.name + " from_int(int value)");
        printWriter.println("\t{");
        printWriter.println("\t\tswitch (value) {");
        enumeration = this.enumlist.v.elements();
        while (enumeration.hasMoreElements()) {
            string2 = (String)enumeration.nextElement();
            printWriter.println("\t\t\tcase _" + string2 + ": return " + string2 + ";");
        }
        printWriter.println("\t\t\tdefault: throw new org.omg.CORBA.BAD_PARAM();");
        printWriter.println("\t\t}");
        printWriter.println("\t}");
        printWriter.println("\tpublic String toString()");
        printWriter.println("\t{");
        printWriter.println("\t\tswitch (value) {");
        enumeration = this.enumlist.v.elements();
        while (enumeration.hasMoreElements()) {
            string2 = (String)enumeration.nextElement();
            printWriter.println("\t\t\tcase _" + string2 + ": return \"" + string2 + "\";");
        }
        printWriter.println("\t\t\tdefault: throw new org.omg.CORBA.BAD_PARAM();");
        printWriter.println("\t\t}");
        printWriter.println("\t}");
        printWriter.println("\tprotected " + this.name + "(int i)");
        printWriter.println("\t{");
        printWriter.println("\t\tvalue = i;");
        printWriter.println("\t}");
        printWriter.println("\tjava.lang.Object readResolve()");
        if (!parser.cldc10) {
            printWriter.println("\tthrows java.io.ObjectStreamException");
        }
        printWriter.println("\t{");
        printWriter.println("\t\treturn from_int(value());");
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
                String string2 = this.className();
                String string3 = parser.out_dir + fileSeparator + this.pack_name.replace('.', fileSeparator);
                File file2 = new File(string3);
                if (!file2.exists() && !file2.mkdirs()) {
                    parser.fatal_error("Unable to create " + string3, null);
                }
                if (GlobalInputStream.isMoreRecentThan(file = new File(file2, string = string2 + ".java"))) {
                    printWriter2 = new PrintWriter(new FileWriter(file));
                    this.printEnumClass(string2, printWriter2);
                    printWriter2.close();
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
            catch (IOException iOException) {
                throw new RuntimeException("File IO error" + iOException);
            }
        }
    }

    public String toString() {
        return this.typeName();
    }

    public boolean isSwitchable() {
        return true;
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        printWriter.println("\t\t" + this.pack_name + "." + this.className() + "Helper.insert(" + string + ", " + string2 + ");");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        printWriter.println("\t\t" + string + " = " + this.pack_name + "." + this.className() + "Helper.extract(" + string2 + ");");
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        iDLTreeVisitor.visitEnum(this);
    }
}

