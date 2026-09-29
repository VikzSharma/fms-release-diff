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
import org.jacorb.idl.AliasTypeSpec;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.Environment;
import org.jacorb.idl.GlobalInputStream;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.IllegalRedefinition;
import org.jacorb.idl.Interface;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.NoHelperException;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.TypeMap;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.Value;
import org.jacorb.idl.ValueBody;
import org.jacorb.idl.ValueInheritanceSpec;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;

public class ValueAbsDecl
extends Value {
    ValueBody body = null;
    ValueInheritanceSpec inheritanceSpec;

    public ValueAbsDecl(int n) {
        super(n);
        this.pack_name = "";
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        if (this.body != null) {
            this.body.setPackage(string);
        }
        if (this.inheritanceSpec != null) {
            this.inheritanceSpec.setPackage(string);
        }
    }

    public void setInheritanceSpec(ValueInheritanceSpec valueInheritanceSpec) {
        this.inheritanceSpec = valueInheritanceSpec;
    }

    public ValueInheritanceSpec setInheritanceSpec() {
        return this.inheritanceSpec;
    }

    public TypeDeclaration declaration() {
        return this;
    }

    public String typeName() {
        return this.full_name();
    }

    public Object clone() {
        throw new RuntimeException("Don't clone me, i am an interface!");
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            this.logger.error("was " + this.enclosing_symbol.getClass().getName() + " now: " + idlSymbol.getClass().getName());
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
    }

    public boolean basic() {
        return true;
    }

    public String holderName() {
        return this.javaName() + "Holder";
    }

    public String helperName() throws NoHelperException {
        throw new NoHelperException();
    }

    public String toString() {
        return this.getFullName(this.typeName());
    }

    public void set_included(boolean bl) {
        this.included = bl;
    }

    public void parse() {
        boolean bl;
        block13: {
            bl = false;
            this.escapeName();
            ConstrTypeSpec constrTypeSpec = new ConstrTypeSpec(ValueAbsDecl.new_num());
            try {
                ScopedName.definePseudoScope(this.full_name());
                constrTypeSpec.c_type_spec = this;
                NameTable.define(this.full_name(), "type");
                TypeMap.typedef(this.full_name(), constrTypeSpec);
            }
            catch (IllegalRedefinition illegalRedefinition) {
                parser.fatal_error("Cannot redefine " + this.token.str_val + " in nested scope as " + illegalRedefinition.newDef, this.token);
            }
            catch (NameAlreadyDefined nameAlreadyDefined) {
                if (this.body != null) {
                    bl = true;
                }
                if (this.full_name().equals("org.omg.CORBA.TypeCode") || this.body == null) break block13;
                TypeMap.replaceForwardDeclaration(this.full_name(), constrTypeSpec);
            }
        }
        if (this.body != null) {
            if (this.inheritanceSpec != null && this.inheritanceSpec.v.size() > 0) {
                if (this.logger.isDebugEnabled()) {
                    this.logger.debug("Checking inheritanceSpec of " + this.full_name());
                }
                Enumeration enumeration = this.inheritanceSpec.v.elements();
                while (enumeration.hasMoreElements()) {
                    ConstrTypeSpec constrTypeSpec;
                    ScopedName scopedName = (ScopedName)enumeration.nextElement();
                    TypeSpec typeSpec = scopedName.resolvedTypeSpec();
                    if (!parser.strict_inheritance) continue;
                    while (typeSpec instanceof AliasTypeSpec) {
                        typeSpec = ((AliasTypeSpec)typeSpec).originalType();
                    }
                    if (!(typeSpec instanceof ConstrTypeSpec)) {
                        if (this.logger.isDebugEnabled()) {
                            this.logger.debug("Illegal inheritance spec, not a constr. type but " + typeSpec.getClass() + ", name " + scopedName);
                        }
                        parser.fatal_error("Illegal inheritance spec (not a constr. type): " + this.inheritanceSpec, this.token);
                    }
                    if ((constrTypeSpec = (ConstrTypeSpec)typeSpec).declaration() instanceof Interface || constrTypeSpec.declaration() instanceof ValueAbsDecl) continue;
                    parser.fatal_error("Illegal inheritance spec (not an intf. or abs. value type): " + this.inheritanceSpec, this.token);
                }
                this.body.set_ancestors(this.inheritanceSpec);
            }
            this.body.parse();
            NameTable.parsed_interfaces.put(this.full_name(), "");
        } else if (!bl) {
            parser.set_pending(this.full_name());
        }
    }

    ValueBody getBody() {
        if (parser.get_pending(this.full_name()) != null) {
            parser.fatal_error(this.full_name() + " is forward declared and still pending!", this.token);
        } else if (this.body == null) {
            if ((ValueAbsDecl)((ConstrTypeSpec)TypeMap.map((String)this.full_name())).c_type_spec != this) {
                this.body = ((ValueAbsDecl)((ConstrTypeSpec)TypeMap.map((String)this.full_name())).c_type_spec).getBody();
            }
            if (this.body == null) {
                parser.fatal_error(this.full_name() + " still has an empty body!", this.token);
            }
        }
        return this.body;
    }

    public String getTypeCodeExpression() {
        return this.getTypeCodeExpression(new HashSet());
    }

    public String getTypeCodeExpression(Set set) {
        if (set.contains(this)) {
            return this.getRecursiveTypeCodeExpression();
        }
        set.add(this);
        return "org.omg.CORBA.ORB.init().create_value_tc(\"" + this.id() + "\", \"" + this.name + "\", org.omg.CORBA.VM_ABSTRACT.value " + ", null, null)";
    }

    public String printReadExpression(String string) {
        return "(" + this.javaName() + ")" + "((org.omg.CORBA_2_3.portable.InputStream)" + string + ")" + ".read_value (\"" + this.id() + "\")";
    }

    public String printReadStatement(String string, String string2) {
        return string + " = " + this.printReadExpression(string2);
    }

    public String printWriteStatement(String string, String string2) {
        return "((org.omg.CORBA_2_3.portable.OutputStream)" + string2 + ")" + ".write_value (" + string + ");";
    }

    public void print(PrintWriter printWriter) {
        if (this.included && !this.generateIncluded()) {
            return;
        }
        if (this.body != null) {
            try {
                File file;
                String string = parser.out_dir + fileSeparator + this.pack_name.replace('.', fileSeparator);
                File file2 = new File(string);
                if (!file2.exists() && !file2.mkdirs()) {
                    parser.fatal_error("Unable to create " + string, null);
                }
                if (GlobalInputStream.isMoreRecentThan(file = new File(file2, this.name + ".java"))) {
                    Enumeration enumeration;
                    PrintWriter printWriter2 = new PrintWriter(new FileWriter(file));
                    if (Environment.JAVA14 && this.pack_name.equals("")) {
                        lexer.emit_warn("No package defined for " + this.name + " - illegal in JDK1.4", this.token);
                    }
                    if (!this.pack_name.equals("")) {
                        printWriter2.println("package " + this.pack_name + ";\n");
                    }
                    this.printClassComment("abstract value type", this.name, printWriter2);
                    if (this.inheritanceSpec != null && this.inheritanceSpec.v.size() > 0) {
                        enumeration = this.inheritanceSpec.v.elements();
                        while (enumeration.hasMoreElements()) {
                            ScopedName scopedName = (ScopedName)enumeration.nextElement();
                            if (scopedName.resolvedName().indexOf(46) >= 0) continue;
                            printWriter2.println("import " + scopedName + "Operations;");
                        }
                    }
                    this.printImport(printWriter2);
                    printWriter2.println("public interface " + this.name);
                    printWriter2.print("\textends org.omg.CORBA.portable.ValueBase ");
                    if (this.inheritanceSpec != null && this.inheritanceSpec.v.size() > 0) {
                        enumeration = this.inheritanceSpec.v.elements();
                        while (enumeration.hasMoreElements()) {
                            printWriter2.print(", " + enumeration.nextElement());
                        }
                    }
                    printWriter2.println("\n{");
                    if (this.body != null) {
                        this.body.printOperationSignatures(printWriter2);
                    }
                    printWriter2.println("}");
                    printWriter2.close();
                }
            }
            catch (IOException iOException) {
                throw new RuntimeException("File IO error" + iOException);
            }
        }
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        printWriter.println("\t\t" + string + ".insert_Value(" + string2 + ", " + string2 + "._type());");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        printWriter.println("\t\t" + string + " = (" + string3 + ")" + string2 + ".extract_Value();");
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        iDLTreeVisitor.visitValue(this);
    }
}

