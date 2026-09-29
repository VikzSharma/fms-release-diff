/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.jacorb.idl.AliasTypeSpec;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.Environment;
import org.jacorb.idl.GlobalInputStream;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.IllegalRedefinition;
import org.jacorb.idl.InterfaceBody;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.ReplyHandler;
import org.jacorb.idl.ReplyHandlerTypeSpec;
import org.jacorb.idl.Scope;
import org.jacorb.idl.ScopeData;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.SymbolList;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.TypeMap;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;
import org.jacorb.idl.util.PrettyPrinter;

public class Interface
extends TypeDeclaration
implements Scope {
    public InterfaceBody body = null;
    public SymbolList inheritanceSpec = null;
    private String[] ids = null;
    private boolean is_local = false;
    private boolean is_abstract = false;
    private ScopeData scopeData;
    private boolean parsed = false;
    private ReplyHandler replyHandler = null;
    private Hashtable irInfoTable = new Hashtable();
    protected static HashSet abstractInterfaces;

    public Interface(int n) {
        super(n);
        this.pack_name = "";
    }

    public void setScopeData(ScopeData scopeData) {
        this.scopeData = scopeData;
    }

    public ScopeData getScopeData() {
        return this.scopeData;
    }

    public void setPackage(String string) {
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Interface setPackage " + string);
        }
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        if (this.body != null) {
            this.body.setPackage(string);
        }
        if (this.inheritanceSpec != null) {
            this.inheritanceSpec.setPackage(string);
        }
    }

    public void set_abstract() {
        this.is_abstract = true;
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

    private ConstrTypeSpec unwindTypedefs(ScopedName scopedName) {
        TypeSpec typeSpec = scopedName.resolvedTypeSpec();
        while (typeSpec instanceof AliasTypeSpec) {
            typeSpec = ((AliasTypeSpec)typeSpec).originalType();
        }
        if (!(typeSpec instanceof ConstrTypeSpec)) {
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("Illegal inheritance spec in Interface.unwindTypeDefs, not a constr. type but " + typeSpec.getClass() + ", name " + scopedName);
            }
            parser.fatal_error("Illegal inheritance spec in Interface.unwindTypeDefs (not a constr. type): " + this.inheritanceSpec, this.token);
        }
        return (ConstrTypeSpec)typeSpec;
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
        if (this.inheritanceSpec != null) {
            this.inheritanceSpec.setEnclosingSymbol(idlSymbol);
        }
    }

    public void set_locality(boolean bl) {
        this.is_local = bl;
    }

    public String getTypeCodeExpression() {
        if (this.is_abstract) {
            return "org.omg.CORBA.ORB.init().create_abstract_interface_tc(\"" + this.id() + "\", \"" + this.name + "\")";
        }
        return "org.omg.CORBA.ORB.init().create_interface_tc(\"" + this.id() + "\", \"" + this.name + "\")";
    }

    public String getTypeCodeExpression(Set set) {
        if (set.contains(this)) {
            return this.getRecursiveTypeCodeExpression();
        }
        return this.getTypeCodeExpression();
    }

    public boolean basic() {
        return true;
    }

    public String holderName() {
        return this.toString() + "Holder";
    }

    public String helperName() {
        return this.toString() + "Helper";
    }

    public String toString() {
        return this.getFullName(this.typeName());
    }

    public void set_included(boolean bl) {
        this.included = bl;
    }

    public String printReadExpression(String string) {
        return this.javaName() + "Helper.read(" + string + ")";
    }

    public String printWriteStatement(String string, String string2) {
        return this.javaName() + "Helper.write(" + string2 + "," + string + ");";
    }

    public void parse() {
        boolean bl;
        block19: {
            bl = false;
            if (this.parsed) {
                return;
            }
            this.escapeName();
            ConstrTypeSpec constrTypeSpec = new ConstrTypeSpec(Interface.new_num());
            if (this.is_abstract) {
                if (this.logger.isDebugEnabled()) {
                    this.logger.debug("Adding " + this.full_name() + " to abstract interface list");
                }
                if (abstractInterfaces == null) {
                    abstractInterfaces = new HashSet();
                }
                abstractInterfaces.add(this.full_name());
            }
            try {
                ScopedName.definePseudoScope(this.full_name());
                constrTypeSpec.c_type_spec = this;
                if (this.is_pseudo) {
                    NameTable.define(this.full_name(), "pseudo interface");
                } else {
                    NameTable.define(this.full_name(), "interface");
                }
                TypeMap.typedef(this.full_name(), constrTypeSpec);
            }
            catch (IllegalRedefinition illegalRedefinition) {
                parser.fatal_error("Cannot redefine " + this.token.str_val + " in nested scope as " + illegalRedefinition.newDef, this.token);
            }
            catch (NameAlreadyDefined nameAlreadyDefined) {
                if (parser.get_pending(this.full_name()) == null) break block19;
                if (this.body == null) {
                    bl = true;
                }
                if (this.full_name().equals("CORBA.TypeCode") || this.full_name().equals("org.omg.CORBA.TypeCode") || this.body == null) break block19;
                TypeMap.replaceForwardDeclaration(this.full_name(), constrTypeSpec);
            }
        }
        if (this.body != null) {
            if (this.inheritanceSpec != null && this.inheritanceSpec.v.size() > 0) {
                if (this.logger.isDebugEnabled()) {
                    this.logger.debug("Checking inheritanceSpec of " + this.full_name());
                }
                HashSet<String> hashSet = new HashSet<String>();
                Enumeration enumeration = this.inheritanceSpec.v.elements();
                while (enumeration.hasMoreElements()) {
                    ScopedName scopedName = (ScopedName)enumeration.nextElement();
                    ConstrTypeSpec constrTypeSpec = this.unwindTypedefs(scopedName);
                    if (constrTypeSpec.declaration() instanceof Interface) {
                        if (hashSet.contains(constrTypeSpec.full_name())) {
                            parser.fatal_error("Illegal inheritance spec: " + this.inheritanceSpec + " (repeated inheritance not allowed).", this.token);
                        }
                        hashSet.add(constrTypeSpec.full_name());
                        continue;
                    }
                    parser.fatal_error("Illegal inheritance spec: " + this.inheritanceSpec + " (ancestor " + constrTypeSpec.full_name() + " not an interface)", this.token);
                }
                this.body.set_ancestors(this.inheritanceSpec);
            }
            this.body.parse();
            NameTable.parsed_interfaces.put(this.full_name(), "");
            if (parser.generate_ami_callback) {
                this.replyHandler = new ReplyHandler(this);
                this.replyHandler.parse();
            }
        } else if (!bl) {
            parser.set_pending(this.full_name());
        }
        this.parsed = true;
    }

    InterfaceBody getBody() {
        if (parser.get_pending(this.full_name()) != null) {
            parser.fatal_error(this.full_name() + " is forward declared and still pending!", this.token);
        } else if (this.body == null) {
            if ((Interface)((ConstrTypeSpec)TypeMap.map((String)this.full_name())).c_type_spec != this) {
                this.body = ((Interface)((ConstrTypeSpec)TypeMap.map((String)this.full_name())).c_type_spec).getBody();
            }
            if (this.body == null) {
                parser.fatal_error(this.full_name() + " still has an empty body!", this.token);
            }
        }
        return this.body;
    }

    protected PrintWriter openOutput(String string) {
        String string2 = parser.out_dir + fileSeparator + this.pack_name.replace('.', fileSeparator);
        File file = new File(string2);
        if (!file.exists() && !file.mkdirs()) {
            parser.fatal_error("Unable to create " + string2, null);
        }
        try {
            final File file2 = new File(file, string + ".java");
            if (GlobalInputStream.isMoreRecentThan(file2)) {
                PrintWriter printWriter = new PrintWriter(new FileWriter(file2)){

                    public void close() {
                        super.close();
                        PrettyPrinter.prettify(file2);
                    }
                };
                return printWriter;
            }
            return null;
        }
        catch (IOException iOException) {
            throw new RuntimeException("Could not open output file for " + string + " (" + iOException + ")");
        }
    }

    protected void printPackage(PrintWriter printWriter) {
        if (Environment.JAVA14 && this.pack_name.equals("")) {
            lexer.emit_warn("No package defined for " + this.name + " - illegal in JDK1.4", this.token);
        }
        if (!this.pack_name.equals("")) {
            printWriter.println("package " + this.pack_name + ";\n");
        }
    }

    protected void printSuperclassImports(PrintWriter printWriter) {
        if (this.inheritanceSpec.v.size() > 0) {
            Enumeration enumeration = this.inheritanceSpec.v.elements();
            while (enumeration.hasMoreElements()) {
                ScopedName scopedName = (ScopedName)enumeration.nextElement();
                if (scopedName.resolvedName().indexOf(46) >= 0) continue;
                printWriter.println("import " + scopedName + ";");
            }
        }
    }

    protected void printInterface() {
        PrintWriter printWriter;
        block15: {
            block14: {
                printWriter = this.openOutput(this.name);
                if (printWriter == null) {
                    return;
                }
                this.printPackage(printWriter);
                this.printSuperclassImports(printWriter);
                this.printClassComment("interface", this.name, printWriter);
                if (!this.is_pseudo) break block14;
                printWriter.println("public abstract class " + this.name);
                if (this.inheritanceSpec.v.size() <= 0) break block15;
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                String string = " ";
                Enumeration enumeration = this.inheritanceSpec.v.elements();
                while (enumeration.hasMoreElements()) {
                    ScopedName scopedName = (ScopedName)enumeration.nextElement();
                    String string2 = scopedName.resolvedName();
                    if (scopedName.is_pseudo()) {
                        stringBuffer.append(string + string2);
                    } else {
                        stringBuffer2.append(string + string2);
                    }
                    if (this.inheritanceSpec.v.size() <= 1) continue;
                    string = ",";
                }
                if (stringBuffer.length() > 0) {
                    printWriter.println("\textends " + stringBuffer.toString());
                }
                if (stringBuffer2.length() <= 0) break block15;
                printWriter.println("\timplements " + stringBuffer2.toString());
                break block15;
            }
            printWriter.println("public interface " + this.name);
            if (this.is_abstract) {
                printWriter.print("\textends org.omg.CORBA.portable.IDLEntity");
            } else {
                printWriter.print("\textends " + this.name + "Operations");
                if (this.is_local) {
                    printWriter.print(", org.omg.CORBA.LocalInterface, org.omg.CORBA.portable.IDLEntity");
                } else {
                    printWriter.print(", org.omg.CORBA.Object, org.omg.CORBA.portable.IDLEntity");
                }
            }
            if (this.inheritanceSpec.v.size() > 0) {
                Enumeration enumeration = this.inheritanceSpec.v.elements();
                while (enumeration.hasMoreElements()) {
                    ScopedName scopedName = (ScopedName)enumeration.nextElement();
                    if (scopedName.resolvedTypeSpec() instanceof ReplyHandlerTypeSpec && parser.generate_ami_callback) {
                        printWriter.print(", " + scopedName);
                        continue;
                    }
                    ConstrTypeSpec constrTypeSpec = this.unwindTypedefs(scopedName);
                    printWriter.print(", " + constrTypeSpec);
                }
            }
        }
        printWriter.println("\n{");
        if (this.body != null) {
            this.body.printInterfaceMethods(printWriter);
            if (this.is_abstract) {
                this.body.printConstants(printWriter);
                this.body.printOperationSignatures(printWriter);
            }
        }
        printWriter.println("}");
        printWriter.close();
    }

    protected void printOperations() {
        PrintWriter printWriter = this.openOutput(this.name + "Operations");
        if (printWriter == null) {
            return;
        }
        this.printPackage(printWriter);
        this.printSuperclassImports(printWriter);
        this.printImport(printWriter);
        this.printClassComment("interface", this.name, printWriter);
        printWriter.println("public interface " + this.name + "Operations");
        if (this.inheritanceSpec.v.size() > 0) {
            printWriter.print("\textends ");
            Enumeration enumeration = this.inheritanceSpec.v.elements();
            do {
                ScopedName scopedName = (ScopedName)enumeration.nextElement();
                if (abstractInterfaces != null && abstractInterfaces.contains(scopedName.toString())) {
                    printWriter.print(scopedName);
                } else if (scopedName.resolvedTypeSpec() instanceof ReplyHandlerTypeSpec && parser.generate_ami_callback) {
                    printWriter.print(scopedName + "Operations");
                } else {
                    ConstrTypeSpec constrTypeSpec = this.unwindTypedefs(scopedName);
                    printWriter.print(constrTypeSpec + "Operations");
                }
                if (!enumeration.hasMoreElements()) continue;
                printWriter.print(" , ");
            } while (enumeration.hasMoreElements());
            printWriter.print("\n");
        }
        printWriter.println("{");
        if (this.body != null) {
            this.body.printConstants(printWriter);
            this.body.printOperationSignatures(printWriter);
        }
        printWriter.println("}");
        printWriter.close();
    }

    protected void printHolder() {
        PrintWriter printWriter = this.openOutput(this.name + "Holder");
        if (printWriter == null) {
            return;
        }
        this.printPackage(printWriter);
        this.printClassComment("interface", this.name, printWriter);
        printWriter.print("public" + parser.getFinalString() + " class " + this.name + "Holder");
        printWriter.print("\timplements org.omg.CORBA.portable.Streamable");
        printWriter.println("{");
        printWriter.println("\t public " + this.name + " value;");
        printWriter.println("\tpublic " + this.name + "Holder()");
        printWriter.println("\t{");
        printWriter.println("\t}");
        printWriter.println("\tpublic " + this.name + "Holder (final " + this.name + " initial)");
        printWriter.println("\t{");
        printWriter.println("\t\tvalue = initial;");
        printWriter.println("\t}");
        printWriter.println("\tpublic org.omg.CORBA.TypeCode _type()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn " + this.name + "Helper.type();");
        printWriter.println("\t}");
        printWriter.println("\tpublic void _read (final org.omg.CORBA.portable.InputStream in)");
        printWriter.println("\t{");
        printWriter.println("\t\tvalue = " + this.name + "Helper.read (in);");
        printWriter.println("\t}");
        printWriter.println("\tpublic void _write (final org.omg.CORBA.portable.OutputStream _out)");
        printWriter.println("\t{");
        printWriter.println("\t\t" + this.name + "Helper.write (_out,value);");
        printWriter.println("\t}");
        printWriter.println("}");
        printWriter.close();
    }

    protected void printNarrow(PrintWriter printWriter, boolean bl, boolean bl2) {
        printWriter.print("\tpublic static " + this.typeName());
        printWriter.print(bl ? " narrow" : " unchecked_narrow");
        printWriter.println(bl2 ? "(final org.omg.CORBA.Object obj)" : "(final java.lang.Object obj)");
        printWriter.println("\t{");
        printWriter.println("\t\tif (obj == null)");
        printWriter.println("\t\t{");
        printWriter.println("\t\t\treturn null;");
        printWriter.println("\t\t}");
        printWriter.println("\t\telse if (obj instanceof " + this.typeName() + ")");
        printWriter.println("\t\t{");
        printWriter.println("\t\t\treturn (" + this.typeName() + ")obj;");
        printWriter.println("\t\t}");
        if (parser.generate_stubs && !this.is_local) {
            if (bl && bl2) {
                printWriter.println("\t\telse if (obj._is_a(\"" + this.id() + "\"))");
                this.printStubInterposition(printWriter);
                this.printElseNarrowFailed(printWriter);
            } else if (!bl && bl2) {
                printWriter.println("\t\telse");
                this.printStubInterposition(printWriter);
            } else if (bl && !bl2) {
                printWriter.println("\t\telse if (obj instanceof org.omg.CORBA.Object &&");
                printWriter.println("\t\t         ((org.omg.CORBA.Object)obj)._is_a(\"" + this.id() + "\"))");
                this.printStubInterposition(printWriter);
                this.printElseNarrowFailed(printWriter);
            } else if (!bl && !bl2) {
                printWriter.println("\t\tif (obj instanceof org.omg.CORBA.Object)");
                this.printStubInterposition(printWriter);
                this.printElseNarrowFailed(printWriter);
            }
        } else {
            this.printElseNarrowFailed(printWriter);
        }
        printWriter.println("\t}");
    }

    protected void printStubInterposition(PrintWriter printWriter) {
        String string = Interface.stubName(this.typeName());
        printWriter.println("\t\t{");
        printWriter.println("\t\t\t" + string + " stub;");
        printWriter.println("\t\t\tstub = new " + string + "();");
        printWriter.println("\t\t\tstub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());");
        printWriter.println("\t\t\treturn stub;");
        printWriter.println("\t\t}");
    }

    protected void printElseNarrowFailed(PrintWriter printWriter) {
        printWriter.println("\t\telse");
        printWriter.println("\t\t{");
        printWriter.println("\t\t\tthrow new org.omg.CORBA.BAD_PARAM(\"Narrow failed\");");
        printWriter.println("\t\t}");
    }

    protected void printHelper() {
        PrintWriter printWriter = this.openOutput(this.name + "Helper");
        if (printWriter == null) {
            return;
        }
        this.printPackage(printWriter);
        this.printImport(printWriter);
        this.printClassComment("interface", this.name, printWriter);
        printWriter.println("public" + parser.getFinalString() + " class " + this.name + "Helper");
        printWriter.println("{");
        printWriter.println("\tpublic static void insert (final org.omg.CORBA.Any any, final " + this.typeName() + " s)");
        printWriter.println("\t{");
        if (this.is_abstract) {
            printWriter.println("\t\tif (s instanceof org.omg.CORBA.Object)");
            printWriter.println("\t\t{");
            printWriter.println("\t\t\tany.insert_Object((org.omg.CORBA.Object)s);");
            printWriter.println("\t\t}");
            printWriter.println("\t\telse if (s instanceof java.io.Serializable)");
            printWriter.println("\t\t{");
            printWriter.println("\t\t\tany.insert_Value((java.io.Serializable)s);");
            printWriter.println("\t\t}");
            printWriter.println("\t\telse");
            printWriter.println("\t\t{");
            printWriter.println("\t\t\tthrow new org.omg.CORBA.BAD_PARAM(\"Failed to insert in helper\");");
            printWriter.println("\t\t}");
        } else {
            printWriter.println("\t\t\tany.insert_Object(s);");
        }
        printWriter.println("\t}");
        printWriter.println("\tpublic static " + this.typeName() + " extract(final org.omg.CORBA.Any any)");
        printWriter.println("\t{");
        if (this.is_abstract) {
            printWriter.println("\t\ttry");
            printWriter.println("\t\t{");
            printWriter.println("\t\t\treturn narrow(any.extract_Object());");
            printWriter.println("\t\t}");
            printWriter.println("\t\tcatch (org.omg.CORBA.BAD_OPERATION ex)");
            printWriter.println("\t\t{");
            printWriter.println("\t\t\ttry");
            printWriter.println("\t\t\t{");
            printWriter.println("\t\t\t\treturn (" + this.typeName() + ")any.extract_Value();");
            printWriter.println("\t\t\t}");
            printWriter.println("\t\t\tcatch (ClassCastException e)");
            printWriter.println("\t\t\t{");
            printWriter.println("\t\t\t\tthrow new org.omg.CORBA.MARSHAL(e.getMessage());");
            printWriter.println("\t\t\t}");
            printWriter.println("\t\t}");
        } else if (parser.useUncheckedNarrow) {
            printWriter.println("\t\treturn unchecked_narrow(any.extract_Object());");
        } else {
            printWriter.println("\t\treturn narrow(any.extract_Object()) ;");
        }
        printWriter.println("\t}");
        printWriter.println("\tpublic static org.omg.CORBA.TypeCode type()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn " + this.getTypeCodeExpression() + ";");
        printWriter.println("\t}");
        this.printIdMethod(printWriter);
        printWriter.println("\tpublic static " + this.name + " read(final org.omg.CORBA.portable.InputStream in)");
        printWriter.println("\t{");
        if (this.is_local) {
            printWriter.println("\t\tthrow new org.omg.CORBA.MARSHAL();");
        } else if (this.is_abstract) {
            printWriter.println("\t\treturn narrow(((org.omg.CORBA_2_3.portable.InputStream)in).read_abstract_interface());");
        } else {
            String string;
            String string2 = string = parser.generate_stubs ? Interface.stubName(this.typeName()) + ".class" : "";
            if (parser.useUncheckedNarrow) {
                printWriter.println("\t\treturn unchecked_narrow(in.read_Object(" + string + "));");
            } else {
                printWriter.println("\t\treturn narrow(in.read_Object(" + string + "));");
            }
        }
        printWriter.println("\t}");
        printWriter.println("\tpublic static void write(final org.omg.CORBA.portable.OutputStream _out, final " + this.typeName() + " s)");
        printWriter.println("\t{");
        if (this.is_local) {
            printWriter.println("\t\tthrow new org.omg.CORBA.MARSHAL();");
        } else if (this.is_abstract) {
            printWriter.println("\t\t((org.omg.CORBA_2_3.portable.OutputStream)_out).write_abstract_interface(s);");
        } else {
            printWriter.println("\t\t_out.write_Object(s);");
        }
        printWriter.println("\t}");
        if (this.is_abstract) {
            this.printNarrow(printWriter, true, false);
            this.printNarrow(printWriter, false, false);
        } else if (this.hasAbstractBase()) {
            this.printNarrow(printWriter, true, true);
            this.printNarrow(printWriter, true, false);
            this.printNarrow(printWriter, false, true);
            this.printNarrow(printWriter, false, false);
        } else {
            this.printNarrow(printWriter, true, true);
            this.printNarrow(printWriter, false, true);
        }
        printWriter.println("}");
        printWriter.close();
    }

    public String[] get_ids() {
        if (this.ids == null) {
            Object object;
            HashSet<String> hashSet = new HashSet<String>();
            if (this.inheritanceSpec != null && this.inheritanceSpec.v.size() > 0) {
                Iterator iterator = this.inheritanceSpec.v.iterator();
                while (iterator.hasNext()) {
                    object = ((ScopedName)iterator.next()).resolvedTypeSpec();
                    if (object instanceof ConstrTypeSpec) {
                        Interface interface_ = (Interface)((ConstrTypeSpec)object).c_type_spec;
                        hashSet.addAll(Arrays.asList(interface_.get_ids()));
                        continue;
                    }
                    if (!(object instanceof ReplyHandlerTypeSpec)) continue;
                    hashSet.add("IDL:omg.org/Messaging/ReplyHandler:1.0");
                }
            }
            this.ids = new String[hashSet.size() + 1];
            this.ids[0] = this.id();
            int n = 1;
            object = hashSet.iterator();
            while (object.hasNext()) {
                this.ids[n] = (String)object.next();
                ++n;
            }
        }
        return this.ids;
    }

    protected boolean hasAbstractBase() {
        if (this.inheritanceSpec != null && this.inheritanceSpec.v.size() > 0) {
            Iterator iterator = this.inheritanceSpec.v.iterator();
            while (iterator.hasNext()) {
                TypeSpec typeSpec = ((ScopedName)iterator.next()).resolvedTypeSpec();
                if (!(typeSpec instanceof ConstrTypeSpec)) continue;
                Interface interface_ = (Interface)((ConstrTypeSpec)typeSpec).c_type_spec;
                if (!interface_.is_abstract && !interface_.hasAbstractBase()) continue;
                return true;
            }
        }
        return false;
    }

    protected void printStub() {
        PrintWriter printWriter = this.openOutput("_" + this.name + "Stub");
        if (printWriter == null) {
            return;
        }
        this.printPackage(printWriter);
        this.printImport(printWriter);
        this.printClassComment("interface", this.name, printWriter);
        printWriter.println("public class _" + this.name + "Stub");
        printWriter.println("\textends org.omg.CORBA.portable.ObjectImpl");
        printWriter.println("\timplements " + this.javaName());
        printWriter.println("{");
        printWriter.print("\tprivate String[] ids = {");
        String[] stringArray = this.get_ids();
        for (int i = 0; i < stringArray.length - 1; ++i) {
            printWriter.print("\"" + stringArray[i] + "\",");
        }
        printWriter.println("\"" + stringArray[stringArray.length - 1] + "\"};");
        printWriter.println("\tpublic String[] _ids()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn ids;");
        printWriter.println("\t}\n");
        if (!parser.cldc10) {
            printWriter.print("\tpublic final static java.lang.Class _opsClass = ");
            if (!this.pack_name.equals("")) {
                printWriter.print(this.pack_name + ".");
            }
            if (this.is_abstract) {
                printWriter.println(this.name + ".class;");
            } else {
                printWriter.println(this.name + "Operations.class;");
            }
        } else {
            String string = null;
            string = !this.pack_name.equals("") ? this.pack_name + "." + this.name : this.name;
            printWriter.println("\tpublic static final java.lang.Class _opsClass;");
            printWriter.println("\tstatic");
            printWriter.println("\t{");
            printWriter.println("\t\ttry");
            printWriter.println("\t\t{");
            printWriter.print("\t\t\t_opsClass = Class.forName(\"");
            if (!this.pack_name.equals("")) {
                printWriter.print(this.pack_name + ".");
            }
            printWriter.println(this.name + "Operations\");");
            printWriter.println("\t\t}");
            printWriter.println("\t\tcatch(ClassNotFoundException cnfe)");
            printWriter.println("\t\t{");
            printWriter.println("\t\t\tthrow new RuntimeException(\"Class " + string + " was not found.\");");
            printWriter.println("\t\t}");
            printWriter.println("\t}\n");
        }
        this.body.printStubMethods(printWriter, this.name, this.is_local, this.is_abstract);
        printWriter.println("}");
        printWriter.close();
    }

    protected void printImplSkeleton() {
        PrintWriter printWriter = this.openOutput(this.name + "POA");
        if (printWriter == null) {
            return;
        }
        this.printPackage(printWriter);
        this.printImport(printWriter);
        this.printClassComment("interface", this.name, printWriter);
        printWriter.print("public abstract class " + this.name + "POA");
        printWriter.println("\n\textends org.omg.PortableServer.Servant");
        printWriter.println("\timplements org.omg.CORBA.portable.InvokeHandler, " + this.javaName() + "Operations");
        printWriter.println("{");
        this.body.printOperationsHash(printWriter);
        printWriter.print("\tprivate String[] ids = {");
        String[] stringArray = this.get_ids();
        for (int i = 0; i < stringArray.length - 1; ++i) {
            printWriter.print("\"" + stringArray[i] + "\",");
        }
        printWriter.println("\"" + stringArray[stringArray.length - 1] + "\"};");
        printWriter.println("\tpublic " + this.javaName() + " _this()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn " + this.javaName() + "Helper.narrow(_this_object());");
        printWriter.println("\t}");
        printWriter.println("\tpublic " + this.javaName() + " _this(org.omg.CORBA.ORB orb)");
        printWriter.println("\t{");
        printWriter.println("\t\treturn " + this.javaName() + "Helper.narrow(_this_object(orb));");
        printWriter.println("\t}");
        printWriter.println("\tpublic org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)");
        printWriter.println("\t\tthrows org.omg.CORBA.SystemException");
        printWriter.println("\t{");
        if (this.body.getMethods().length > 0) {
            printWriter.println("\t\torg.omg.CORBA.portable.OutputStream _out = null;");
            printWriter.println("\t\t// do something");
        }
        this.body.printSkelInvocations(printWriter);
        printWriter.println("\t}\n");
        printWriter.println("\tpublic String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)");
        printWriter.println("\t{");
        printWriter.println("\t\treturn ids;");
        printWriter.println("\t}");
        printWriter.println("}");
        printWriter.close();
    }

    protected void printTieSkeleton() {
        PrintWriter printWriter = this.openOutput(this.name + "POATie");
        if (printWriter == null) {
            return;
        }
        this.printPackage(printWriter);
        printWriter.println("import org.omg.PortableServer.POA;");
        this.printImport(printWriter);
        this.printClassComment("interface", this.name, printWriter);
        printWriter.println("public class " + this.name + "POATie");
        printWriter.println("\textends " + this.name + "POA");
        printWriter.println("{");
        printWriter.println("\tprivate " + this.name + "Operations _delegate;\n");
        printWriter.println("\tprivate POA _poa;");
        printWriter.println("\tpublic " + this.name + "POATie(" + this.name + "Operations delegate)");
        printWriter.println("\t{");
        printWriter.println("\t\t_delegate = delegate;");
        printWriter.println("\t}");
        printWriter.println("\tpublic " + this.name + "POATie(" + this.name + "Operations delegate, POA poa)");
        printWriter.println("\t{");
        printWriter.println("\t\t_delegate = delegate;");
        printWriter.println("\t\t_poa = poa;");
        printWriter.println("\t}");
        printWriter.println("\tpublic " + this.javaName() + " _this()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn " + this.javaName() + "Helper.narrow(_this_object());");
        printWriter.println("\t}");
        printWriter.println("\tpublic " + this.javaName() + " _this(org.omg.CORBA.ORB orb)");
        printWriter.println("\t{");
        printWriter.println("\t\treturn " + this.javaName() + "Helper.narrow(_this_object(orb));");
        printWriter.println("\t}");
        printWriter.println("\tpublic " + this.name + "Operations _delegate()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn _delegate;");
        printWriter.println("\t}");
        printWriter.println("\tpublic void _delegate(" + this.name + "Operations delegate)");
        printWriter.println("\t{");
        printWriter.println("\t\t_delegate = delegate;");
        printWriter.println("\t}");
        printWriter.println("\tpublic POA _default_POA()");
        printWriter.println("\t{");
        printWriter.println("\t\tif (_poa != null)");
        printWriter.println("\t\t{");
        printWriter.println("\t\t\treturn _poa;");
        printWriter.println("\t\t}");
        printWriter.println("\t\treturn super._default_POA();");
        printWriter.println("\t}");
        this.body.printDelegatedMethods(printWriter);
        printWriter.println("}");
        printWriter.close();
    }

    protected void printIRHelper() {
        PrintWriter printWriter = this.openOutput(this.name + "IRHelper");
        if (printWriter == null) {
            return;
        }
        this.printPackage(printWriter);
        printWriter.println("\n/**");
        printWriter.println(" * This class contains generated Interface Repository information.");
        printWriter.println(" * @author JacORB IDL compiler.");
        printWriter.println(" */");
        printWriter.println("\npublic class " + this.name + "IRHelper");
        printWriter.println("{");
        String string = System.getProperty("java.version").startsWith("1.1") ? "com.sun.java.util.collections.Hashtable" : "java.util.Hashtable";
        printWriter.println("\tpublic static " + string + " irInfo = new " + string + "();");
        printWriter.println("\tstatic");
        printWriter.println("\t{");
        this.body.getIRInfo(this.irInfoTable);
        Enumeration enumeration = this.irInfoTable.keys();
        while (enumeration.hasMoreElements()) {
            String string2 = (String)enumeration.nextElement();
            printWriter.println("\t\tirInfo.put(\"" + string2 + "\", \"" + (String)this.irInfoTable.get(string2) + "\");");
        }
        printWriter.println("\t}");
        printWriter.println("}");
        printWriter.close();
    }

    protected void printLocalBase() {
        PrintWriter printWriter = this.openOutput("_" + this.name + "LocalBase");
        if (printWriter == null) {
            return;
        }
        this.printPackage(printWriter);
        printWriter.println("\n/**");
        printWriter.println(" * Abstract base class for implementations of local interface " + this.name);
        printWriter.println(" * @author JacORB IDL compiler.");
        printWriter.println(" */");
        printWriter.println("\npublic abstract class _" + this.name + "LocalBase");
        printWriter.println("\textends org.omg.CORBA.LocalObject");
        printWriter.println("\timplements " + this.name);
        printWriter.println("{");
        printWriter.print("\tprivate String[] _type_ids = {");
        String[] stringArray = this.get_ids();
        for (int i = 0; i < stringArray.length - 1; ++i) {
            printWriter.print("\"" + stringArray[i] + "\",");
        }
        printWriter.println("\"" + stringArray[stringArray.length - 1] + "\"};");
        printWriter.print("\tpublic String[] _ids()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn(String[])_type_ids.clone();");
        printWriter.println("\t}");
        printWriter.println("}");
        printWriter.close();
    }

    protected void printLocalTie() {
        PrintWriter printWriter = this.openOutput(this.name + "LocalTie");
        if (printWriter == null) {
            return;
        }
        this.printPackage(printWriter);
        this.printImport(printWriter);
        this.printClassComment("interface", this.name, printWriter);
        printWriter.println("public class " + this.name + "LocalTie");
        printWriter.println("\textends _" + this.name + "LocalBase");
        printWriter.println("{");
        printWriter.println("\tprivate " + this.name + "Operations _delegate;\n");
        printWriter.println("\tpublic " + this.name + "LocalTie(" + this.name + "Operations delegate)");
        printWriter.println("\t{");
        printWriter.println("\t\t_delegate = delegate;");
        printWriter.println("\t}");
        printWriter.println("\tpublic " + this.name + "Operations _delegate()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn _delegate;");
        printWriter.println("\t}");
        printWriter.println("\tpublic void _delegate(" + this.name + "Operations delegate)");
        printWriter.println("\t{");
        printWriter.println("\t\t_delegate = delegate;");
        printWriter.println("\t}");
        this.body.printDelegatedMethods(printWriter);
        printWriter.println("}");
        printWriter.close();
    }

    public void print(PrintWriter printWriter) {
        if (this.included && !this.generateIncluded()) {
            return;
        }
        if (this.body != null) {
            this.printInterface();
            if (!this.is_pseudo) {
                if (!this.is_abstract) {
                    this.printOperations();
                }
                this.printHelper();
                this.printHolder();
                if (parser.generate_stubs && !this.is_local) {
                    this.printStub();
                }
                if (parser.generate_skeletons && !this.is_local && !this.is_abstract) {
                    this.printImplSkeleton();
                    this.printTieSkeleton();
                }
                if (parser.generateIR) {
                    this.printIRHelper();
                }
                if (this.is_local) {
                    this.printLocalBase();
                    this.printLocalTie();
                }
            }
            this.body.print(null);
            if (this.replyHandler != null) {
                this.replyHandler.print(printWriter);
            }
        }
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        if (this.is_abstract) {
            throw new RuntimeException("DII stubs not yet implemented for abstract interfaces");
        }
        printWriter.println("\t\t" + string + ".insert_Object(" + string2 + ");");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        printWriter.println("\t\t" + string + " = " + this.helperName() + ".extract(" + string2 + ");");
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        iDLTreeVisitor.visitInterface(this);
    }

    private static final String stubName(String string) {
        String string2 = string.indexOf(46) > -1 ? string.substring(0, string.lastIndexOf(46)) + "._" + string.substring(string.lastIndexOf(46) + 1) + "Stub" : "_" + string + "Stub";
        return string2;
    }
}

