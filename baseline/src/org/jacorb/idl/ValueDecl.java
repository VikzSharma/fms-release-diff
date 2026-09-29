/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jacorb.idl.AliasTypeSpec;
import org.jacorb.idl.AttrDecl;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.Declaration;
import org.jacorb.idl.Definition;
import org.jacorb.idl.Definitions;
import org.jacorb.idl.GlobalInputStream;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.InitDecl;
import org.jacorb.idl.Interface;
import org.jacorb.idl.MemberList;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.OpDecl;
import org.jacorb.idl.Operation;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.StateMember;
import org.jacorb.idl.Truncatable;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.TypeMap;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.Value;
import org.jacorb.idl.ValueAbsDecl;
import org.jacorb.idl.ValueInheritanceSpec;
import org.jacorb.idl.parser;

public class ValueDecl
extends Value {
    private MemberList stateMembers = new MemberList(ValueDecl.new_num());
    private List operations = new ArrayList();
    private List exports = new ArrayList();
    private List factories = new ArrayList();
    private ValueInheritanceSpec inheritanceSpec;
    private boolean isCustomMarshalled = false;
    private boolean hasStatefulBases = false;
    private boolean hasBody = false;

    public ValueDecl(int n) {
        super(n);
    }

    public void setValueElements(Definitions definitions) {
        this.hasBody = true;
        Iterator iterator = definitions.v.iterator();
        while (iterator.hasNext()) {
            Declaration declaration = ((Definition)iterator.next()).get_declaration();
            declaration.setPackage(this.name);
            if (declaration instanceof StateMember) {
                this.stateMembers.v.add(declaration);
                continue;
            }
            if (declaration instanceof OpDecl) {
                this.operations.add(declaration);
                continue;
            }
            if (declaration instanceof InitDecl) {
                this.factories.add(declaration);
                continue;
            }
            this.exports.add(declaration);
        }
        this.stateMembers.setContainingType(this);
        this.stateMembers.setPackage(this.name);
        this.stateMembers.setEnclosingSymbol(this);
        iterator = this.operations.iterator();
        while (iterator.hasNext()) {
            ((OpDecl)iterator.next()).setEnclosingSymbol(this);
        }
        iterator = this.exports.iterator();
        while (iterator.hasNext()) {
            ((IdlSymbol)iterator.next()).setEnclosingSymbol(this);
        }
        iterator = this.factories.iterator();
        while (iterator.hasNext()) {
            ((IdlSymbol)iterator.next()).setEnclosingSymbol(this);
        }
    }

    public void setInheritanceSpec(ValueInheritanceSpec valueInheritanceSpec) {
        this.inheritanceSpec = valueInheritanceSpec;
    }

    public ValueInheritanceSpec getInheritanceSpec() {
        return this.inheritanceSpec;
    }

    public void isCustomMarshalled(boolean bl) {
        this.isCustomMarshalled = bl;
    }

    public boolean isCustomMarshalled() {
        return this.isCustomMarshalled;
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        this.stateMembers.setPackage(string);
        if (this.inheritanceSpec != null) {
            this.inheritanceSpec.setPackage(string);
        }
        Iterator iterator = this.operations.iterator();
        while (iterator.hasNext()) {
            ((IdlSymbol)iterator.next()).setPackage(string);
        }
        iterator = this.exports.iterator();
        while (iterator.hasNext()) {
            ((IdlSymbol)iterator.next()).setPackage(string);
        }
        iterator = this.factories.iterator();
        while (iterator.hasNext()) {
            ((IdlSymbol)iterator.next()).setPackage(string);
        }
    }

    public TypeDeclaration declaration() {
        return this;
    }

    public void parse() {
        if (this.inheritanceSpec != null) {
            this.inheritanceSpec.parse();
        }
        boolean bl = false;
        if (this.isCustomMarshalled() && this.inheritanceSpec != null && this.inheritanceSpec.truncatable != null) {
            parser.error("Valuetype " + this.typeName() + " may no be BOTH custom AND truncatable", this.token);
        }
        ConstrTypeSpec constrTypeSpec = new ConstrTypeSpec(ValueDecl.new_num());
        try {
            this.escapeName();
            ScopedName.definePseudoScope(this.full_name());
            constrTypeSpec.c_type_spec = this;
            NameTable.define(this.full_name(), "type");
            TypeMap.typedef(this.full_name(), constrTypeSpec);
        }
        catch (NameAlreadyDefined nameAlreadyDefined) {
            if (parser.get_pending(this.full_name()) != null) {
                if (this.stateMembers.size() != 0) {
                    bl = true;
                }
                if (!this.full_name().equals("org.omg.CORBA.TypeCode") && this.stateMembers.size() != 0) {
                    TypeMap.replaceForwardDeclaration(this.full_name(), constrTypeSpec);
                }
            }
            parser.error("Valuetype " + this.typeName() + " already defined", this.token);
        }
        if (this.hasBody) {
            Enumeration enumeration;
            Object object;
            this.logger.warn("valueDecl.parse(): exports (but not attributes)");
            Iterator iterator = this.exports.iterator();
            while (iterator.hasNext()) {
                object = (IdlSymbol)iterator.next();
                if (object instanceof AttrDecl) continue;
                ((IdlSymbol)object).parse();
            }
            this.logger.warn("valueDecl.parse(): members");
            ScopedName.addRecursionScope(this.typeName());
            this.stateMembers.parse();
            ScopedName.removeRecursionScope(this.typeName());
            this.logger.warn("valueDecl.parse(): operations");
            iterator = this.operations.iterator();
            while (iterator.hasNext()) {
                object = (IdlSymbol)iterator.next();
                ((IdlSymbol)object).parse();
            }
            this.logger.warn("valueDecl.parse(): exports(attributes)");
            iterator = this.exports.iterator();
            while (iterator.hasNext()) {
                object = (IdlSymbol)iterator.next();
                if (!(object instanceof AttrDecl)) continue;
                ((IdlSymbol)object).parse();
                enumeration = ((AttrDecl)object).getOperations();
                while (enumeration.hasMoreElements()) {
                    this.operations.add(enumeration.nextElement());
                }
            }
            this.logger.warn("valueDecl.parse(): factories");
            iterator = this.factories.iterator();
            while (iterator.hasNext()) {
                object = (IdlSymbol)iterator.next();
                ((IdlSymbol)object).parse();
            }
            this.logger.warn("valueDecl.parse(): check inheritance");
            if (this.inheritanceSpec != null) {
                ConstrTypeSpec constrTypeSpec2;
                ScopedName scopedName;
                object = new HashSet();
                enumeration = this.inheritanceSpec.getValueTypes();
                while (enumeration.hasMoreElements()) {
                    scopedName = (ScopedName)enumeration.nextElement();
                    constrTypeSpec2 = this.unwindTypedefs(scopedName);
                    if (constrTypeSpec2.declaration() instanceof Value) {
                        if (((HashSet)object).contains(constrTypeSpec2.full_name())) {
                            parser.fatal_error("Illegal inheritance spec: " + this.inheritanceSpec + " (repeated inheritance not allowed).", this.token);
                        }
                        ((HashSet)object).add(constrTypeSpec2.full_name());
                        continue;
                    }
                    this.logger.error(" Declaration is " + constrTypeSpec2.declaration().getClass());
                    parser.fatal_error("Non-value type in inheritance spec: \n\t" + this.inheritanceSpec, this.token);
                }
                enumeration = this.inheritanceSpec.getSupportedInterfaces();
                while (enumeration.hasMoreElements()) {
                    scopedName = (ScopedName)enumeration.nextElement();
                    constrTypeSpec2 = (ConstrTypeSpec)scopedName.resolvedTypeSpec().typeSpec();
                    if (constrTypeSpec2.declaration() instanceof Interface) continue;
                    parser.fatal_error("Non-interface type in supported interfaces list:\n\t" + this.inheritanceSpec, this.token);
                }
            }
            NameTable.parsed_interfaces.put(this.full_name(), "");
            parser.remove_pending(this.full_name());
        } else if (!bl) {
            parser.set_pending(this.full_name());
        }
    }

    private ConstrTypeSpec unwindTypedefs(ScopedName scopedName) {
        TypeSpec typeSpec = scopedName.resolvedTypeSpec();
        while (typeSpec instanceof AliasTypeSpec) {
            typeSpec = ((AliasTypeSpec)typeSpec).originalType();
        }
        if (!(typeSpec instanceof ConstrTypeSpec)) {
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("Illegal inheritance spec, not a constr. type but " + typeSpec.getClass() + ", name " + scopedName);
            }
            parser.fatal_error("Illegal inheritance spec (not a constr. type): " + this.inheritanceSpec, this.token);
        }
        return (ConstrTypeSpec)typeSpec;
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            this.logger.error("was " + this.enclosing_symbol.getClass().getName() + " now: " + idlSymbol.getClass().getName());
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
    }

    public void set_included(boolean bl) {
        this.included = bl;
    }

    public boolean basic() {
        return true;
    }

    public String toString() {
        return this.full_name();
    }

    public String holderName() {
        return this.javaName() + "Holder";
    }

    public String helperName() {
        return this.javaName() + "Helper";
    }

    public String typeName() {
        return this.full_name();
    }

    public String getTypeCodeExpression() {
        return this.getTypeCodeExpression(new HashSet());
    }

    public String getTypeCodeExpression(Set set) {
        if (set.contains(this)) {
            return this.getRecursiveTypeCodeExpression();
        }
        set.add(this);
        String string = "null";
        if (this.hasStatefulBases && this.inheritanceSpec != null && this.inheritanceSpec.v.size() > 0) {
            string = ((ScopedName)this.inheritanceSpec.v.get(0)).resolvedName() + "Helper.type()";
        }
        StringBuffer stringBuffer = new StringBuffer("org.omg.CORBA.ORB.init().create_value_tc (\"" + this.id() + "\", " + "\"" + this.name + "\", " + "(short)" + (this.isCustomMarshalled() ? 1 : 0) + ", " + string + ", " + "new org.omg.CORBA.ValueMember[] {");
        Iterator iterator = this.stateMembers.v.iterator();
        while (iterator.hasNext()) {
            StateMember stateMember = (StateMember)iterator.next();
            stringBuffer.append(this.getValueMemberExpression(stateMember, set));
            if (!iterator.hasNext()) continue;
            stringBuffer.append(", ");
        }
        stringBuffer.append("})");
        return stringBuffer.toString();
    }

    private String getValueMemberExpression(StateMember stateMember, Set set) {
        TypeSpec typeSpec = stateMember.typeSpec();
        int n = stateMember.isPublic ? 1 : 0;
        return "new org.omg.CORBA.ValueMember (\"" + stateMember.name + "\", \"" + typeSpec.id() + "\", \"" + this.name + "\", \"1.0\", " + typeSpec.getTypeCodeExpression(set) + ", null, " + "(short)" + n + ")";
    }

    public void print(PrintWriter printWriter) {
        if (this.included && !this.generateIncluded()) {
            return;
        }
        if (!this.hasBody) {
            return;
        }
        try {
            String string = parser.out_dir + fileSeparator + this.pack_name.replace('.', fileSeparator);
            File file = new File(string);
            if (!file.exists() && !file.mkdirs()) {
                parser.fatal_error("Unable to create " + string, null);
            }
            this.printClass(file);
            this.printFactory(file);
            this.printHelper(file);
            this.printHolder(file);
            Iterator iterator = this.exports.iterator();
            while (iterator.hasNext()) {
                ((IdlSymbol)iterator.next()).print(null);
            }
        }
        catch (IOException iOException) {
            parser.fatal_error("I/O error writing " + this.javaName() + ": " + iOException, null);
        }
    }

    public String printWriteStatement(String string, String string2) {
        return "((org.omg.CORBA_2_3.portable.OutputStream)" + string2 + ")" + ".write_value (" + string + ");";
    }

    public String printReadExpression(String string) {
        return "(" + this.javaName() + ")" + "((org.omg.CORBA_2_3.portable.InputStream)" + string + ")" + ".read_value (\"" + this.id() + "\")";
    }

    public String printReadStatement(String string, String string2) {
        return string + " = " + this.printReadExpression(string2);
    }

    private void printClass(File file) throws IOException {
        File file2 = new File(file, this.name + ".java");
        if (this.hasBody && GlobalInputStream.isMoreRecentThan(file2)) {
            IdlSymbol idlSymbol;
            Object object;
            Object object2;
            PrintWriter printWriter = new PrintWriter(new FileWriter(file2));
            if (this.pack_name.length() > 0) {
                printWriter.println("package " + this.pack_name + ";\n");
            }
            this.printClassComment("valuetype", this.name, printWriter);
            printWriter.println("public abstract class " + this.name);
            StringBuffer stringBuffer = new StringBuffer("extends ");
            StringBuffer stringBuffer2 = new StringBuffer("implements ");
            if (this.isCustomMarshalled()) {
                stringBuffer2.append("org.omg.CORBA.portable.CustomValue");
            } else {
                stringBuffer2.append("org.omg.CORBA.portable.StreamableValue");
            }
            if (this.inheritanceSpec != null) {
                boolean bl = true;
                object2 = this.inheritanceSpec.getValueTypes();
                if (object2.hasMoreElements() || this.inheritanceSpec.truncatable != null) {
                    if (object2.hasMoreElements()) {
                        object = (ScopedName)object2.nextElement();
                        idlSymbol = this.unwindTypedefs((ScopedName)object);
                        if (idlSymbol.c_type_spec instanceof ValueAbsDecl) {
                            stringBuffer2.append(", " + idlSymbol.toString());
                        } else {
                            bl = false;
                            stringBuffer.append(idlSymbol.toString());
                        }
                    }
                    while (object2.hasMoreElements()) {
                        object = (ScopedName)object2.nextElement();
                        idlSymbol = (ConstrTypeSpec)((ScopedName)object).resolvedTypeSpec().typeSpec();
                        if (idlSymbol.c_type_spec instanceof ValueAbsDecl) {
                            stringBuffer2.append(", " + ((ScopedName)object).toString());
                            continue;
                        }
                        if (bl) {
                            stringBuffer.append(((ScopedName)object).toString());
                            bl = false;
                            continue;
                        }
                        stringBuffer.append(", " + ((ScopedName)object).toString());
                    }
                    if (this.inheritanceSpec.truncatable != null) {
                        stringBuffer.append((bl ? "" : ", ") + this.inheritanceSpec.truncatable.scopedName);
                    }
                }
                if ((object = this.inheritanceSpec.getSupportedInterfaces()).hasMoreElements()) {
                    while (object.hasMoreElements()) {
                        idlSymbol = (ScopedName)object.nextElement();
                        stringBuffer2.append(", " + idlSymbol);
                        if (Interface.abstractInterfaces != null && Interface.abstractInterfaces.contains(((ScopedName)idlSymbol).toString())) continue;
                        stringBuffer2.append("Operations");
                    }
                }
            }
            if (stringBuffer.length() > 8) {
                this.hasStatefulBases = true;
                printWriter.println("\t" + stringBuffer.toString());
            }
            printWriter.println("\t" + stringBuffer2.toString());
            printWriter.println("{");
            printWriter.print("\tprivate String[] _truncatable_ids = {\"" + this.id() + "\"");
            StringBuffer stringBuffer3 = new StringBuffer();
            if (this.inheritanceSpec != null && (object2 = this.inheritanceSpec.truncatable) != null) {
                stringBuffer3.append(", \"" + ((Truncatable)object2).getId() + "\"");
                object = ((Truncatable)object2).scopedName;
                while (object != null) {
                    Truncatable truncatable;
                    idlSymbol = (ValueDecl)((ConstrTypeSpec)((ScopedName)object).resolvedTypeSpec()).c_type_spec;
                    if (((ValueDecl)idlSymbol).inheritanceSpec == null || (truncatable = ((ValueDecl)idlSymbol).inheritanceSpec.truncatable) == null) break;
                    stringBuffer3.append(", \"" + truncatable.getId() + "\"");
                    object = truncatable.scopedName;
                }
            }
            printWriter.println(stringBuffer3.toString() + "};");
            object2 = this.stateMembers.v.iterator();
            while (object2.hasNext()) {
                ((StateMember)object2.next()).print(printWriter);
                printWriter.println();
            }
            object2 = this.operations.iterator();
            while (object2.hasNext()) {
                ((Operation)object2.next()).printSignature(printWriter, true);
                printWriter.println();
            }
            if (!this.isCustomMarshalled()) {
                this.printWriteMethod(printWriter);
                this.printReadMethod(printWriter);
            }
            printWriter.println("\tpublic String[] _truncatable_ids()");
            printWriter.println("\t{");
            printWriter.println("\t\treturn _truncatable_ids;");
            printWriter.println("\t}");
            printWriter.println("\tpublic org.omg.CORBA.TypeCode _type()");
            printWriter.println("\t{");
            printWriter.println("\t\treturn " + this.javaName() + "Helper.type();");
            printWriter.println("\t}");
            printWriter.println("}");
            printWriter.close();
        }
    }

    private void printFactory(File file) throws IOException {
        if (this.factories.size() == 0) {
            return;
        }
        File file2 = new File(file, this.name + "ValueFactory.java");
        if (this.hasBody && GlobalInputStream.isMoreRecentThan(file2)) {
            PrintWriter printWriter = new PrintWriter(new FileWriter(file2));
            if (this.pack_name.length() > 0) {
                printWriter.println("package " + this.pack_name + ";\n");
            }
            this.printClassComment("valuetype", this.name, printWriter);
            printWriter.println("public interface  " + this.name + "ValueFactory");
            printWriter.println("\textends org.omg.CORBA.portable.ValueFactory");
            printWriter.println("{");
            Iterator iterator = this.factories.iterator();
            while (iterator.hasNext()) {
                ((InitDecl)iterator.next()).print(printWriter, this.name);
            }
            printWriter.println("}");
            printWriter.close();
        }
    }

    private void printWriteMethod(PrintWriter printWriter) {
        printWriter.println("\tpublic void _write (org.omg.CORBA.portable.OutputStream os)");
        printWriter.println("\t{");
        if (this.hasStatefulBases) {
            printWriter.println("\t\tsuper._write(os);");
        }
        Iterator iterator = this.stateMembers.v.iterator();
        while (iterator.hasNext()) {
            printWriter.println("\t\t" + ((StateMember)iterator.next()).writeStatement("os"));
        }
        printWriter.println("\t}\n");
    }

    private void printReadMethod(PrintWriter printWriter) {
        printWriter.println("\tpublic void _read (final org.omg.CORBA.portable.InputStream os)");
        printWriter.println("\t{");
        if (this.hasStatefulBases) {
            printWriter.println("\t\tsuper._read(os);");
        }
        Iterator iterator = this.stateMembers.v.iterator();
        while (iterator.hasNext()) {
            printWriter.println("\t\t" + ((StateMember)iterator.next()).readStatement("os"));
        }
        printWriter.println("\t}\n");
    }

    private void printHelper(File file) throws IOException {
        File file2 = new File(file, this.name + "Helper.java");
        if (this.hasBody && GlobalInputStream.isMoreRecentThan(file2)) {
            PrintWriter printWriter = new PrintWriter(new FileWriter(file2));
            if (this.pack_name.length() > 0) {
                printWriter.println("package " + this.pack_name + ";\n");
            }
            this.printClassComment("valuetype", this.name, printWriter);
            printWriter.println("public abstract class " + this.name + "Helper");
            printWriter.println("{");
            printWriter.println("\tprivate static org.omg.CORBA.TypeCode type = null;");
            printWriter.println("\tpublic static void insert (org.omg.CORBA.Any a, " + this.javaName() + " v)");
            printWriter.println("\t{");
            printWriter.println("\t\ta.insert_Value (v, v._type());");
            printWriter.println("\t}");
            printWriter.println("\tpublic static " + this.javaName() + " extract " + "(org.omg.CORBA.Any a)");
            printWriter.println("\t{");
            printWriter.println("\t\treturn (" + this.javaName() + ")a.extract_Value();");
            printWriter.println("\t}");
            printWriter.println("\tpublic static org.omg.CORBA.TypeCode type()");
            printWriter.println("\t{");
            printWriter.println("\t\tif (type == null)");
            printWriter.println("\t\t\ttype = " + this.getTypeCodeExpression() + ";");
            printWriter.println("\t\treturn type;");
            printWriter.println("\t}");
            printWriter.println("\tpublic static String id()");
            printWriter.println("\t{");
            printWriter.println("\t\treturn \"" + this.id() + "\";");
            printWriter.println("\t}");
            printWriter.println("\tpublic static " + this.javaName() + " read " + "(org.omg.CORBA.portable.InputStream is)");
            printWriter.println("\t{");
            printWriter.println("\t\treturn (" + this.javaName() + ")((org.omg.CORBA_2_3.portable.InputStream)is).read_value (\"" + this.id() + "\");");
            printWriter.println("\t}");
            printWriter.println("\tpublic static void write (org.omg.CORBA.portable.OutputStream os, " + this.javaName() + " val)");
            printWriter.println("\t{");
            printWriter.println("((org.omg.CORBA_2_3.portable.OutputStream)os).write_value (val, \"" + this.id() + "\");");
            printWriter.println("\t}");
            Iterator iterator = this.factories.iterator();
            while (iterator.hasNext()) {
                InitDecl initDecl = (InitDecl)iterator.next();
                initDecl.printHelperMethod(printWriter, this.name);
            }
            printWriter.println("}");
            printWriter.close();
        }
    }

    private void printHolder(File file) throws IOException {
        File file2 = new File(file, this.name + "Holder.java");
        if (this.hasBody && GlobalInputStream.isMoreRecentThan(file2)) {
            PrintWriter printWriter = new PrintWriter(new FileWriter(file2));
            if (this.pack_name.length() > 0) {
                printWriter.println("package " + this.pack_name + ";\n");
            }
            this.printClassComment("valuetype", this.name, printWriter);
            printWriter.println("public" + parser.getFinalString() + " class " + this.name + "Holder");
            printWriter.println("\timplements org.omg.CORBA.portable.Streamable");
            printWriter.println("{");
            printWriter.println("\tpublic " + this.javaName() + " value;");
            printWriter.println("\tpublic " + this.name + "Holder () {}");
            printWriter.println("\tpublic " + this.name + "Holder (final " + this.javaName() + " initial)");
            printWriter.println("\t{");
            printWriter.println("\t\tvalue = initial;");
            printWriter.println("\t}");
            printWriter.println("\tpublic void _read (final org.omg.CORBA.portable.InputStream is)");
            printWriter.println("\t{");
            printWriter.println("\t\tvalue = " + this.javaName() + "Helper.read (is);");
            printWriter.println("\t}");
            printWriter.println("\tpublic void _write (final org.omg.CORBA.portable.OutputStream os)");
            printWriter.println("\t{");
            printWriter.println("\t\t" + this.javaName() + "Helper.write (os, value);");
            printWriter.println("\t}");
            printWriter.println("\tpublic org.omg.CORBA.TypeCode _type ()");
            printWriter.println("\t{");
            printWriter.println("\t\treturn value._type ();");
            printWriter.println("\t}");
            printWriter.println("}");
            printWriter.close();
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

