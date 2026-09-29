/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import org.jacorb.idl.BaseType;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.Declarator;
import org.jacorb.idl.Environment;
import org.jacorb.idl.GlobalInputStream;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.Member;
import org.jacorb.idl.MemberList;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.Scope;
import org.jacorb.idl.ScopeData;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.TypeMap;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;

public class StructType
extends TypeDeclaration
implements Scope {
    private boolean written = false;
    public boolean exc;
    public MemberList memberlist = null;
    private boolean parsed = false;
    private ScopeData scopeData;
    private boolean forwardDecl;
    private static final HashSet systemExceptionNames = new HashSet();

    public StructType(int n) {
        super(n);
        this.pack_name = "";
    }

    public void setScopeData(ScopeData scopeData) {
        this.scopeData = scopeData;
    }

    public ScopeData getScopeData() {
        return this.scopeData;
    }

    public boolean isException() {
        return this.exc;
    }

    public Object clone() {
        StructType structType = new StructType(StructType.new_num());
        structType.pack_name = this.pack_name;
        structType.name = this.name;
        structType.memberlist = this.memberlist;
        structType.included = this.included;
        structType.token = this.token;
        structType.exc = this.exc;
        structType.scopeData = this.scopeData;
        structType.enclosing_symbol = this.enclosing_symbol;
        return structType;
    }

    public TypeDeclaration declaration() {
        return this;
    }

    public String typeName() {
        if (this.typeName == null) {
            this.setPrintPhaseNames();
        }
        return this.typeName;
    }

    public String getJavaTypeName() {
        if (this.typeName == null) {
            this.setPrintPhaseNames();
        }
        return this.typeName;
    }

    public String getIDLTypeName() {
        return this.getJavaTypeName();
    }

    public int getTCKind() {
        return 15;
    }

    public boolean basic() {
        return false;
    }

    public void set_memberlist(MemberList memberList) {
        memberList.setContainingType(this);
        this.memberlist = memberList;
        this.memberlist.setPackage(this.name);
        if (this.memberlist != null) {
            this.memberlist.setEnclosingSymbol(this);
        }
    }

    public void set_included(boolean bl) {
        this.included = bl;
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        if (this.memberlist != null) {
            this.memberlist.setPackage(string);
        }
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            this.logger.error("was " + this.enclosing_symbol.getClass().getName() + " now: " + idlSymbol.getClass().getName());
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
        if (this.memberlist != null) {
            this.memberlist.setEnclosingSymbol(this);
        }
    }

    public String toString() {
        return this.typeName();
    }

    public void parse() {
        boolean bl = false;
        if (this.parsed) {
            return;
        }
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Parsing Struct " + this.name);
        }
        this.escapeName();
        ConstrTypeSpec constrTypeSpec = new ConstrTypeSpec(StructType.new_num());
        try {
            ScopedName.definePseudoScope(this.full_name());
            constrTypeSpec.c_type_spec = this;
            NameTable.define(this.full_name(), "type-struct");
            TypeMap.typedef(this.full_name(), constrTypeSpec);
        }
        catch (NameAlreadyDefined nameAlreadyDefined) {
            if (this.exc) {
                parser.error("Struct " + this.getJavaTypeName() + " already defined", this.token);
            }
            if (parser.get_pending(this.full_name()) != null) {
                if (this.memberlist != null) {
                    bl = true;
                }
                if (!this.full_name().equals("org.omg.CORBA.TypeCode") && this.memberlist != null) {
                    TypeMap.replaceForwardDeclaration(this.full_name(), constrTypeSpec);
                }
            }
            parser.error("Struct " + this.getJavaTypeName() + " already defined", this.token);
        }
        if (this.memberlist != null) {
            ScopedName.addRecursionScope(this.getJavaTypeName());
            this.memberlist.parse();
            ScopedName.removeRecursionScope(this.getJavaTypeName());
            if (!this.exc) {
                NameTable.parsed_interfaces.put(this.full_name(), "");
                parser.remove_pending(this.full_name());
            }
        } else if (!bl && !this.exc) {
            parser.set_pending(this.full_name());
            this.forwardDecl = true;
        }
        this.parsed = true;
    }

    public String className() {
        String string = this.getJavaTypeName();
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
        return this.getJavaTypeName() + "Holder";
    }

    public String helperName() {
        return this.getJavaTypeName() + "Helper";
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
        this.printImport(printWriter);
        this.printClassComment(this.exc ? "exception" : "struct", string, printWriter);
        printWriter.println("public" + parser.getFinalString() + " class " + string + "Holder");
        printWriter.println("\timplements org.omg.CORBA.portable.Streamable");
        printWriter.println("{");
        printWriter.println("\tpublic " + this.getJavaTypeName() + " value;\n");
        printWriter.println("\tpublic " + string + "Holder ()");
        printWriter.println("\t{");
        printWriter.println("\t}");
        printWriter.println("\tpublic " + string + "Holder(final " + this.getJavaTypeName() + " initial)");
        printWriter.println("\t{");
        printWriter.println("\t\tvalue = initial;");
        printWriter.println("\t}");
        printWriter.println("\tpublic org.omg.CORBA.TypeCode _type ()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn " + this.getJavaTypeName() + "Helper.type ();");
        printWriter.println("\t}");
        printWriter.println("\tpublic void _read(final org.omg.CORBA.portable.InputStream _in)");
        printWriter.println("\t{");
        printWriter.println("\t\tvalue = " + this.getJavaTypeName() + "Helper.read(_in);");
        printWriter.println("\t}");
        printWriter.println("\tpublic void _write(final org.omg.CORBA.portable.OutputStream _out)");
        printWriter.println("\t{");
        printWriter.println("\t\t" + this.getJavaTypeName() + "Helper.write(_out, value);");
        printWriter.println("\t}");
        printWriter.println("}");
    }

    private void printHelperClass(String string, PrintWriter printWriter) {
        Declarator declarator;
        IdlSymbol idlSymbol;
        Enumeration enumeration;
        Object object;
        if (Environment.JAVA14 && this.pack_name.equals("")) {
            lexer.emit_warn("No package defined for " + string + " - illegal in JDK1.4", this.token);
        }
        if (!this.pack_name.equals("")) {
            printWriter.println("package " + this.pack_name + ";\n");
        }
        this.printImport(printWriter);
        this.printClassComment(this.exc ? "exception" : "struct", string, printWriter);
        printWriter.println("public" + parser.getFinalString() + " class " + string + "Helper");
        printWriter.println("{");
        printWriter.println("\tprivate static org.omg.CORBA.TypeCode _type = null;");
        printWriter.println("\tpublic static org.omg.CORBA.TypeCode type ()");
        printWriter.println("\t{");
        printWriter.println("\t\tif (_type == null)");
        printWriter.println("\t\t{");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("org.omg.CORBA.ORB.init().create_" + (this.exc ? "exception" : "struct") + "_tc(" + this.getJavaTypeName() + "Helper.id(),\"" + this.className() + "\",");
        if (this.memberlist != null) {
            stringBuffer.append("new org.omg.CORBA.StructMember[]{");
            object = this.memberlist.v.elements();
            while (object.hasMoreElements()) {
                enumeration = (Member)object.nextElement();
                idlSymbol = ((Member)((Object)enumeration)).declarator;
                stringBuffer.append("new org.omg.CORBA.StructMember(\"" + idlSymbol.name() + "\", ");
                stringBuffer.append(((Member)((Object)enumeration)).type_spec.typeSpec().getTypeCodeExpression());
                stringBuffer.append(", null)");
                if (!object.hasMoreElements()) continue;
                stringBuffer.append(",");
            }
            stringBuffer.append("}");
        } else {
            stringBuffer.append("new org.omg.CORBA.StructMember[0]");
        }
        stringBuffer.append(")");
        printWriter.println("\t\t\t_type = " + stringBuffer.toString() + ";");
        printWriter.println("\t\t}");
        printWriter.println("\t\treturn _type;");
        printWriter.println("\t}\n");
        object = this.getJavaTypeName();
        TypeSpec.printInsertExtractMethods(printWriter, (String)object);
        this.printIdMethod(printWriter);
        printWriter.println("\tpublic static " + (String)object + " read (final org.omg.CORBA.portable.InputStream in)");
        printWriter.println("\t{");
        printWriter.println("\t\t" + (String)object + " result = new " + (String)object + "();");
        if (this.exc) {
            printWriter.println("\t\tif (!in.read_string().equals(id())) throw new org.omg.CORBA.MARSHAL(\"wrong id\");");
        }
        if (this.memberlist != null) {
            enumeration = this.memberlist.v.elements();
            while (enumeration.hasMoreElements()) {
                idlSymbol = (Member)enumeration.nextElement();
                declarator = ((Member)idlSymbol).declarator;
                printWriter.println("\t\t" + ((Member)idlSymbol).type_spec.typeSpec().printReadStatement("result." + declarator.name(), "in"));
            }
        }
        printWriter.println("\t\treturn result;");
        printWriter.println("\t}");
        printWriter.println("\tpublic static void write (final org.omg.CORBA.portable.OutputStream out, final " + (String)object + " s)");
        printWriter.println("\t{");
        if (this.exc) {
            printWriter.println("\t\tout.write_string(id());");
        }
        if (this.memberlist != null) {
            enumeration = this.memberlist.v.elements();
            while (enumeration.hasMoreElements()) {
                idlSymbol = (Member)enumeration.nextElement();
                declarator = ((Member)idlSymbol).declarator;
                printWriter.println("\t\t" + ((Member)idlSymbol).type_spec.typeSpec().printWriteStatement("s." + declarator.name(), "out"));
            }
        }
        printWriter.println("\t}");
        printWriter.println("}");
    }

    private void printStructClass(String string, PrintWriter printWriter) {
        if (Environment.JAVA14 && this.pack_name.equals("")) {
            lexer.emit_warn("No package defined for " + string + " - illegal in JDK1.4", this.token);
        }
        String string2 = string;
        if (!this.pack_name.equals("")) {
            string2 = this.pack_name + "." + string;
            printWriter.println("package " + this.pack_name + ";");
        }
        this.printImport(printWriter);
        this.printClassComment(this.exc ? "exception" : "struct", string, printWriter);
        printWriter.println("public" + parser.getFinalString() + " class " + string);
        if (this.exc) {
            if (this.isSystemException(string)) {
                printWriter.println("\textends org.omg.CORBA.SystemException");
            } else {
                printWriter.println("\textends org.omg.CORBA.UserException");
            }
        } else {
            printWriter.println("\timplements org.omg.CORBA.portable.IDLEntity");
        }
        printWriter.println("{");
        if (this.exc) {
            if (this.isSystemException(string)) {
                printWriter.println("\tpublic " + string + "()");
                printWriter.println("\t{");
                printWriter.print("\t\tsuper(");
                printWriter.print(" \"\"");
                printWriter.print(", 0");
                printWriter.print(" ,org.omg.CORBA.CompletionStatus.COMPLETED_NO");
                printWriter.println(" ) ;");
                printWriter.println("\t}");
                printWriter.println();
                printWriter.println("\tpublic " + string + "( String reason )");
                printWriter.println("\t{");
                printWriter.print("\t\tsuper(");
                printWriter.print(" reason");
                printWriter.print(", 0");
                printWriter.print(" ,org.omg.CORBA.CompletionStatus.COMPLETED_NO");
                printWriter.println(" ) ;");
                printWriter.println("\t}");
                printWriter.println();
                printWriter.print("\tpublic " + string + "(");
                printWriter.print("int minor");
                printWriter.print(", org.omg.CORBA.CompletionStatus completed");
                printWriter.println(" )");
                printWriter.println("\t{");
                printWriter.print("\t\tsuper(");
                printWriter.print(" \"\"");
                printWriter.print(", minor");
                printWriter.print(", completed");
                printWriter.println(" ) ;");
                printWriter.println("\t}");
                printWriter.println();
                printWriter.print("\tpublic " + string + "(");
                printWriter.print("String reason");
                printWriter.print(", int minor");
                printWriter.print(", org.omg.CORBA.CompletionStatus completed");
                printWriter.println(" )");
                printWriter.println("\t{");
                printWriter.print("\t\tsuper(");
                printWriter.print(" reason");
                printWriter.print(", minor");
                printWriter.print(", completed");
                printWriter.println(" ) ;");
                printWriter.println("\t}");
                printWriter.println();
            } else {
                printWriter.println("\tpublic " + string + "()");
                printWriter.println("\t{");
                printWriter.println("\t\tsuper(" + string2 + "Helper.id());");
                printWriter.println("\t}");
                printWriter.println();
                if (this.memberlist == null) {
                    printWriter.println("\tpublic " + string + "(String value)");
                    printWriter.println("\t{");
                    printWriter.println("\t\tsuper(value);");
                    printWriter.println("\t}");
                }
            }
        } else {
            printWriter.println("\tpublic " + string + "(){}");
        }
        if (this.memberlist != null) {
            Declarator declarator;
            Member member;
            Enumeration enumeration = this.memberlist.v.elements();
            while (enumeration.hasMoreElements()) {
                ((Member)enumeration.nextElement()).member_print(printWriter, "\tpublic ");
                printWriter.println();
            }
            if (parser.generateEnhanced) {
                this.printToString(string2, printWriter);
                this.printEquals(string2, printWriter);
            }
            if (this.exc && !this.isSystemException(string)) {
                printWriter.print("\tpublic " + string + "(");
                printWriter.print("java.lang.String _reason,");
                enumeration = this.memberlist.v.elements();
                while (enumeration.hasMoreElements()) {
                    member = (Member)enumeration.nextElement();
                    declarator = member.declarator;
                    printWriter.print(member.type_spec.toString() + " " + declarator.toString());
                    if (!enumeration.hasMoreElements()) continue;
                    printWriter.print(", ");
                }
                printWriter.println(")");
                printWriter.println("\t{");
                printWriter.println("\t\tsuper(" + string2 + "Helper.id()+ \" \" + _reason);");
                enumeration = this.memberlist.v.elements();
                while (enumeration.hasMoreElements()) {
                    member = (Member)enumeration.nextElement();
                    declarator = member.declarator;
                    printWriter.print("\t\tthis.");
                    printWriter.print(declarator.name());
                    printWriter.print(" = ");
                    printWriter.println(declarator.name() + ";");
                }
                printWriter.println("\t}");
            }
            if (!this.isSystemException(string)) {
                printWriter.print("\tpublic " + string + "(");
                enumeration = this.memberlist.v.elements();
                while (enumeration.hasMoreElements()) {
                    member = (Member)enumeration.nextElement();
                    declarator = member.declarator;
                    printWriter.print(member.type_spec.toString() + " " + declarator.name());
                    if (!enumeration.hasMoreElements()) continue;
                    printWriter.print(", ");
                }
                printWriter.println(")");
                printWriter.println("\t{");
                if (this.exc) {
                    printWriter.println("\t\tsuper(" + string2 + "Helper.id());");
                }
                enumeration = this.memberlist.v.elements();
                while (enumeration.hasMoreElements()) {
                    member = (Member)enumeration.nextElement();
                    declarator = member.declarator;
                    printWriter.print("\t\tthis.");
                    printWriter.print(declarator.name());
                    printWriter.print(" = ");
                    printWriter.println(declarator.name() + ";");
                }
                printWriter.println("\t}");
            }
        }
        printWriter.println("}");
    }

    public void print(PrintWriter printWriter) {
        this.setPrintPhaseNames();
        if (!this.parsed) {
            lexer.restorePosition(this.myPosition);
            parser.fatal_error("Unparsed Struct!", this.token);
        }
        if (this.included && !this.generateIncluded()) {
            return;
        }
        if (!this.written) {
            this.written = true;
            try {
                PrintWriter printWriter2;
                String string = this.className();
                String string2 = parser.out_dir + fileSeparator + this.pack_name.replace('.', fileSeparator);
                File file = new File(string2);
                if (!file.exists() && !file.mkdirs()) {
                    parser.fatal_error("Unable to create " + string2, null);
                }
                String string3 = string + ".java";
                File file2 = new File(file, string3);
                if (!this.forwardDecl && GlobalInputStream.isMoreRecentThan(file2)) {
                    printWriter2 = new PrintWriter(new FileWriter(file2));
                    this.printStructClass(string, printWriter2);
                    printWriter2.close();
                }
                string3 = string + "Holder.java";
                file2 = new File(file, string3);
                if (!this.forwardDecl && GlobalInputStream.isMoreRecentThan(file2) && !this.exc && !this.isSystemException(string)) {
                    printWriter2 = new PrintWriter(new FileWriter(file2));
                    this.printHolderClass(string, printWriter2);
                    printWriter2.close();
                }
                string3 = string + "Helper.java";
                file2 = new File(file, string3);
                if (!this.forwardDecl && GlobalInputStream.isMoreRecentThan(file2)) {
                    printWriter2 = new PrintWriter(new FileWriter(file2));
                    this.printHelperClass(string, printWriter2);
                    printWriter2.close();
                }
            }
            catch (IOException iOException) {
                throw new RuntimeException("File IO error" + iOException);
            }
        }
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        printWriter.println("\t\t" + this.pack_name + "." + this.className() + "Helper.insert(" + string + ", " + string2 + ");");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        printWriter.println("\t\t" + string + " = " + this.pack_name + "." + this.className() + "Helper.extract(" + string2 + ");");
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        iDLTreeVisitor.visitStruct(this);
    }

    private void printEquals(String string, PrintWriter printWriter) {
        printWriter.println("\tpublic boolean equals(java.lang.Object o) ");
        printWriter.println("\t{ ");
        StringBuffer stringBuffer = new StringBuffer("\t\tif (this == o) return true;");
        stringBuffer.append("\n");
        stringBuffer.append("\t\tif (o == null) return false;");
        stringBuffer.append("\n");
        stringBuffer.append("\n");
        stringBuffer.append("\t\tif (o instanceof " + string + " )\n\t\t{");
        stringBuffer.append("\n");
        stringBuffer.append("\t\t\tfinal " + string + " obj = ( " + string + " )o;");
        stringBuffer.append("\n");
        stringBuffer.append("\t\t\tboolean res = true; ");
        stringBuffer.append("\n");
        stringBuffer.append("\t\t\tdo { ");
        stringBuffer.append("\n");
        Enumeration enumeration = this.memberlist.v.elements();
        while (enumeration.hasMoreElements()) {
            Member member = (Member)enumeration.nextElement();
            if (BaseType.isBasicName(member.type_spec.toString()) && !member.type_spec.toString().equals("String") && !member.type_spec.toString().equals("java.lang.String") && member.type_spec.toString().indexOf("[") < 0) {
                stringBuffer.append("\t\t\t\tres = (this." + member.declarator.toString() + " == obj." + member.declarator.toString() + ");");
                stringBuffer.append("\n\t\t\t\tif (!res) break;\n\n");
                continue;
            }
            if (member.type_spec.toString().indexOf("[") >= 0) {
                stringBuffer.append("\t\t\t\tres = (this." + member.declarator.toString() + " == obj." + member.declarator.toString() + ") || (this." + member.declarator.toString() + " != null && obj." + member.declarator.toString() + " != null && this." + member.declarator.toString() + ".length == obj." + member.declarator.toString() + ".length);\n");
                stringBuffer.append("\t\t\t\tif (res)\n\n\t\t\t\t{\n");
                stringBuffer.append("\t\t\t\t\tres = java.util.Arrays.equals(this." + member.declarator.toString() + ", obj." + member.declarator.toString() + ");");
                stringBuffer.append("\n\t\t\t\t}\n");
                stringBuffer.append("\t\t\t\tif(!res) break;\n\n");
                continue;
            }
            stringBuffer.append("\t\t\t\tres = (this." + member.declarator.toString() + " == obj." + member.declarator.toString() + ") || (this." + member.declarator.toString() + " != null && obj." + member.declarator.toString() + " != null && this." + member.declarator.toString() + ".equals (obj." + member.declarator.toString() + "));");
            stringBuffer.append("\n\t\t\t\tif (!res) break;\n\n");
        }
        stringBuffer.append("\t\t\t}");
        stringBuffer.append("\n");
        stringBuffer.append("\t\t\twhile(false);");
        stringBuffer.append("\n");
        stringBuffer.append("\t\t\treturn res;");
        stringBuffer.append("\n");
        stringBuffer.append("\t\t}");
        stringBuffer.append("\n");
        stringBuffer.append("\t\telse\n\t\t{\n");
        stringBuffer.append("\t\t\treturn false;");
        stringBuffer.append("\n");
        stringBuffer.append("\t\t}");
        stringBuffer.append("\n");
        stringBuffer.append("\t}");
        stringBuffer.append("\n");
        printWriter.println(stringBuffer.toString());
        printWriter.println();
    }

    private void printToString(String string, PrintWriter printWriter) {
        printWriter.println("\tpublic String toString() ");
        printWriter.println("\t{ ");
        StringBuffer stringBuffer = new StringBuffer("\t\tfinal java.lang.StringBuffer _ret  =  new java.lang.StringBuffer(\"struct " + string + " {\"); ");
        stringBuffer.append("\n");
        stringBuffer.append("\t\t_ret.append(\"\\n\"); ");
        Enumeration enumeration = this.memberlist.v.elements();
        while (enumeration.hasMoreElements()) {
            Member member = (Member)enumeration.nextElement();
            stringBuffer.append("\n");
            stringBuffer.append("\t\t_ret.append(\"" + member.type_spec.toString() + " " + member.declarator.toString() + "=\");");
            stringBuffer.append("\n");
            if (member.type_spec.toString().indexOf("[") < 0) {
                stringBuffer.append("\t\t_ret.append(" + member.declarator.toString() + ");");
            } else {
                stringBuffer.append("\t\t_ret.append(\"{\");");
                stringBuffer.append("\n");
                stringBuffer.append("\t\tif(" + member.declarator.toString() + "== null){");
                stringBuffer.append("\n");
                stringBuffer.append("\t\t\t_ret.append(" + member.declarator.toString() + ");");
                stringBuffer.append("\n");
                stringBuffer.append("\t\t}else { ");
                stringBuffer.append("\n");
                stringBuffer.append("\t\t\tfor(int $counter =0; $counter < " + member.declarator.toString() + ".length; $counter++){ ");
                stringBuffer.append("\n");
                stringBuffer.append("\t\t\t\t_ret.append(" + member.declarator + "[$counter]);");
                stringBuffer.append("\n");
                stringBuffer.append("\t\t\t\tif($counter < " + member.declarator.toString() + ".length-1) { ");
                stringBuffer.append("\n");
                stringBuffer.append("\t\t\t\t\t_ret.append(\",\");");
                stringBuffer.append("\n");
                stringBuffer.append("\t\t\t\t} ");
                stringBuffer.append("\n");
                stringBuffer.append("\t\t\t}");
                stringBuffer.append("\n");
                stringBuffer.append("\t\t} ");
                stringBuffer.append("\n");
                stringBuffer.append("\t\t_ret.append(\"}\");");
                stringBuffer.append("\n");
            }
            stringBuffer.append("\n");
            if (enumeration.hasMoreElements()) {
                stringBuffer.append("\t\t_ret.append(\",\\n\");");
                continue;
            }
            stringBuffer.append("\t\t_ret.append(\"\\n\");");
        }
        stringBuffer.append("\n");
        stringBuffer.append("\t\t_ret.append(\"}\");");
        stringBuffer.append("\n\t\treturn _ret.toString();");
        printWriter.println(stringBuffer);
        printWriter.println("\t} ");
        printWriter.println();
    }

    private boolean isSystemException(String string) {
        String string2 = string.toUpperCase();
        return systemExceptionNames.contains(string2);
    }

    static {
        systemExceptionNames.add("UNKNOWN");
        systemExceptionNames.add("BAD_PARAM");
        systemExceptionNames.add("NO_MEMORY");
        systemExceptionNames.add("IMP_LIMIT");
        systemExceptionNames.add("COMM_FAILURE");
        systemExceptionNames.add("INV_OBJREF");
        systemExceptionNames.add("NO_PERMISSION");
        systemExceptionNames.add("INTERNAL");
        systemExceptionNames.add("MARSHAL");
        systemExceptionNames.add("INITIALIZE");
        systemExceptionNames.add("NO_IMPLEMENT");
        systemExceptionNames.add("BAD_TYPECODE");
        systemExceptionNames.add("BAD_OPERATION");
        systemExceptionNames.add("NO_RESOURCES");
        systemExceptionNames.add("NO_RESPONSE");
        systemExceptionNames.add("PERSIST_STORE");
        systemExceptionNames.add("BAD_INV_ORDER");
        systemExceptionNames.add("TRANSIENT");
        systemExceptionNames.add("FREE_MEM");
        systemExceptionNames.add("INV_IDENT");
        systemExceptionNames.add("INV_FLAG");
        systemExceptionNames.add("INTF_REPOS");
        systemExceptionNames.add("BAD_CONTEXT");
        systemExceptionNames.add("OBJ_ADAPTER");
        systemExceptionNames.add("DATA_CONVERSION");
        systemExceptionNames.add("OBJECT_NOT_EXIST");
        systemExceptionNames.add("TRANSACTION_REQUIRED");
        systemExceptionNames.add("TRANSACTION_ROLLEDBACK");
        systemExceptionNames.add("INVALID_TRANSACTION");
        systemExceptionNames.add("INV_POLICY");
        systemExceptionNames.add("CODESET_INCOMPATIBLE");
        systemExceptionNames.add("REBIND");
        systemExceptionNames.add("TIMEOUT");
        systemExceptionNames.add("TRANSACTION_UNAVAILABLE");
        systemExceptionNames.add("TRANSACTION_MODE");
        systemExceptionNames.add("BAD_QOS");
        systemExceptionNames.add("INVALID_ACTIVITY");
        systemExceptionNames.add("ACTIVITY_COMPLETED");
        systemExceptionNames.add("ACTIVITY_REQUIRED");
    }
}

