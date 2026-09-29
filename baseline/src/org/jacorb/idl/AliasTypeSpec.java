/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.jacorb.idl.AnyType;
import org.jacorb.idl.ArrayTypeSpec;
import org.jacorb.idl.BaseType;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.Environment;
import org.jacorb.idl.FixedPointType;
import org.jacorb.idl.GlobalInputStream;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.Interface;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.SequenceType;
import org.jacorb.idl.StringType;
import org.jacorb.idl.TemplateTypeSpec;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.VectorType;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;

public class AliasTypeSpec
extends TypeSpec {
    public TypeSpec originalType;
    private boolean written;
    private boolean originalTypeWasScopedName = false;

    public AliasTypeSpec(TypeSpec typeSpec) {
        super(IdlSymbol.new_num());
        this.originalType = typeSpec;
    }

    public Object clone() {
        AliasTypeSpec aliasTypeSpec = new AliasTypeSpec((TypeSpec)this.type_spec.clone());
        aliasTypeSpec.name = this.name;
        aliasTypeSpec.pack_name = this.pack_name;
        return aliasTypeSpec;
    }

    public String full_name() {
        if (this.pack_name.length() > 0) {
            String string = ScopedName.unPseudoName(this.pack_name + "." + this.name);
            return this.getFullName(string);
        }
        return ScopedName.unPseudoName(this.name);
    }

    public String typeName() {
        return this.originalType.typeName();
    }

    public TypeSpec typeSpec() {
        return this;
    }

    public TypeSpec originalType() {
        if (this.originalType instanceof AliasTypeSpec) {
            return ((AliasTypeSpec)this.originalType).originalType();
        }
        return this.originalType;
    }

    public void setPackage(String string) {
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        this.pack_name = parser.pack_replace(this.pack_name);
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
    }

    public boolean basic() {
        return false;
    }

    public void parse() {
        if (this.originalType instanceof TemplateTypeSpec) {
            ((TemplateTypeSpec)this.originalType).markTypeDefd();
        }
        if (this.originalType instanceof ConstrTypeSpec || this.originalType instanceof FixedPointType || this.originalType instanceof SequenceType || this.originalType instanceof ArrayTypeSpec) {
            this.originalType.parse();
            if (this.originalType.typeName().indexOf(46) < 0) {
                String string = null;
                string = this.originalType instanceof VectorType ? this.originalType.typeName().substring(0, this.originalType.typeName().indexOf(91)) : this.originalType.typeName();
                this.addImportedName(string);
            }
        }
        if (this.originalType instanceof ScopedName) {
            if (this.logger.isDebugEnabled()) {
                this.logger.debug(" Alias " + this.name + " has scoped name orig Type : " + ((ScopedName)this.originalType).toString());
            }
            this.originalType = ((ScopedName)this.originalType).resolvedTypeSpec();
            this.originalTypeWasScopedName = true;
            if (this.originalType instanceof AliasTypeSpec) {
                this.addImportedAlias(this.originalType.full_name());
            } else {
                this.addImportedName(this.originalType.typeName());
            }
        }
    }

    public String toString() {
        return this.originalType.toString();
    }

    public String getTypeCodeExpression() {
        return this.full_name() + "Helper.type()";
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

    public void print(PrintWriter printWriter) {
        this.setPrintPhaseNames();
        if (this.included && !this.generateIncluded()) {
            return;
        }
        if (!this.written) {
            this.written = true;
            try {
                File file;
                if (!(this.originalType.typeSpec() instanceof StringType || this.originalType.typeSpec() instanceof SequenceType || this.originalTypeWasScopedName || this.originalType instanceof ConstrTypeSpec && ((ConstrTypeSpec)this.originalType).declaration() instanceof Interface)) {
                    this.originalType.print(printWriter);
                }
                String string = this.className();
                String string2 = parser.out_dir + fileSeparator + this.pack_name.replace('.', fileSeparator);
                File file2 = new File(string2);
                if (!file2.exists() && !file2.mkdirs()) {
                    parser.fatal_error("Unable to create " + string2, null);
                }
                String string3 = null;
                PrintWriter printWriter2 = null;
                if (this.originalType instanceof TemplateTypeSpec && !(this.originalType instanceof StringType) && GlobalInputStream.isMoreRecentThan(file = new File(file2, string3 = string + "Holder.java"))) {
                    printWriter2 = new PrintWriter(new FileWriter(file));
                    this.printHolderClass(string, printWriter2);
                    printWriter2.close();
                }
                if (GlobalInputStream.isMoreRecentThan(file = new File(file2, string3 = string + "Helper.java"))) {
                    printWriter2 = new PrintWriter(new FileWriter(file));
                    this.printHelperClass(string, printWriter2);
                    printWriter2.close();
                }
            }
            catch (IOException iOException) {
                throw new RuntimeException("File IO error" + iOException);
            }
        }
    }

    public String printReadStatement(String string, String string2) {
        if (this.doUnwind()) {
            return this.originalType.printReadStatement(string, string2);
        }
        return string + " = " + this.full_name() + "Helper.read(" + string2 + ");";
    }

    public String printReadExpression(String string) {
        if (this.doUnwind()) {
            return this.originalType.printReadExpression(string);
        }
        return this.full_name() + "Helper.read(" + string + ")";
    }

    public String printWriteStatement(String string, String string2) {
        if (this.doUnwind()) {
            return this.originalType.printWriteStatement(string, string2);
        }
        return this.full_name() + "Helper.write(" + string2 + "," + string + ");";
    }

    private boolean doUnwind() {
        return this.originalType.basic() && (!(this.originalType instanceof TemplateTypeSpec) || this.originalType instanceof StringType) || this.originalType instanceof AliasTypeSpec || this.originalType instanceof ConstrTypeSpec || this.originalType instanceof AnyType;
    }

    public String holderName() {
        if (this.doUnwind()) {
            return this.originalType.holderName();
        }
        return this.full_name() + "Holder";
    }

    private void printHolderClass(String string, PrintWriter printWriter) {
        if (Environment.JAVA14 && this.pack_name.equals("")) {
            lexer.emit_warn("No package defined for " + string + " - illegal in JDK1.4", this.token);
        }
        if (!this.pack_name.equals("")) {
            printWriter.println("package " + this.pack_name + ";");
        }
        this.printImport(printWriter);
        this.printClassComment("alias", string, printWriter);
        printWriter.println("public" + parser.getFinalString() + " class " + string + "Holder");
        printWriter.println("\timplements org.omg.CORBA.portable.Streamable");
        printWriter.println("{");
        printWriter.println("\tpublic " + this.originalType.typeName() + " value;\n");
        printWriter.println("\tpublic " + string + "Holder ()");
        printWriter.println("\t{");
        printWriter.println("\t}");
        printWriter.println("\tpublic " + string + "Holder (final " + this.originalType.typeName() + " initial)");
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
        boolean bl;
        if (Environment.JAVA14 && this.pack_name.equals("")) {
            lexer.emit_warn("No package defined for " + string + " - illegal in JDK1.4", this.token);
        }
        if (!this.pack_name.equals("")) {
            printWriter.println("package " + this.pack_name + ";");
        }
        this.printImport(printWriter);
        this.printClassComment("alias", string, printWriter);
        printWriter.println("public" + parser.getFinalString() + " class " + string + "Helper");
        printWriter.println("{");
        printWriter.println("\tprivate static org.omg.CORBA.TypeCode _type = null;\n");
        String string2 = this.originalType.typeName();
        printWriter.println("\tpublic static void insert (org.omg.CORBA.Any any, " + string2 + " s)");
        printWriter.println("\t{");
        TypeSpec typeSpec = this.originalType();
        boolean bl2 = bl = !(typeSpec instanceof TemplateTypeSpec) && !(typeSpec instanceof ConstrTypeSpec) && BaseType.isBasicName(typeSpec.typeName());
        if (bl) {
            printWriter.print("\t\tany.");
            printWriter.print(this.originalType().printInsertExpression());
            printWriter.println("(s);");
        } else {
            printWriter.println("\t\tany.type (type ());");
            printWriter.println("\t\twrite (any.create_output_stream (), s);");
        }
        printWriter.println("\t}\n");
        printWriter.println("\tpublic static " + string2 + " extract (final org.omg.CORBA.Any any)");
        printWriter.println("\t{");
        if (bl) {
            printWriter.print("\t\treturn any.");
            printWriter.print(this.originalType().printExtractExpression());
            printWriter.println("();");
        } else {
            printWriter.println("\t\treturn read (any.create_input_stream ());");
        }
        printWriter.println("\t}\n");
        printWriter.println("\tpublic static org.omg.CORBA.TypeCode type ()");
        printWriter.println("\t{");
        printWriter.println("\t\tif (_type == null)");
        printWriter.println("\t\t{");
        printWriter.println("\t\t\t_type = org.omg.CORBA.ORB.init().create_alias_tc(" + this.full_name() + "Helper.id(), \"" + this.name + "\"," + this.originalType.typeSpec().getTypeCodeExpression() + ");");
        printWriter.println("\t\t}");
        printWriter.println("\t\treturn _type;");
        printWriter.println("\t}\n");
        this.printIdMethod(printWriter);
        printWriter.println("\tpublic static " + string2 + " read (final org.omg.CORBA.portable.InputStream _in)");
        printWriter.println("\t{");
        printWriter.println("\t\t" + string2 + " _result;");
        printWriter.println("\t\t" + this.originalType.printReadStatement("_result", "_in"));
        printWriter.println("\t\treturn _result;");
        printWriter.println("\t}\n");
        printWriter.println("\tpublic static void write (final org.omg.CORBA.portable.OutputStream _out, " + string2 + " _s)");
        printWriter.println("\t{");
        printWriter.println("\t\t" + this.originalType.printWriteStatement("_s", "_out"));
        printWriter.println("\t}");
        printWriter.println("}");
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        String string3 = this.className() + "Helper";
        printWriter.println("\t\t" + this.pack_name + "." + string3 + ".insert(" + string + ", " + string2 + " );");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        String string4 = this.className() + "Helper";
        printWriter.println("\t\t" + string + " = " + this.pack_name + "." + string4 + ".extract(" + string2 + ");");
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        iDLTreeVisitor.visitAlias(this);
    }
}

