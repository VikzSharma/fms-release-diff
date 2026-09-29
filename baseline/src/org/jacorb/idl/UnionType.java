/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Set;
import java.util.Vector;
import org.jacorb.idl.AliasTypeSpec;
import org.jacorb.idl.ArrayDeclarator;
import org.jacorb.idl.ArrayTypeSpec;
import org.jacorb.idl.BaseType;
import org.jacorb.idl.BooleanType;
import org.jacorb.idl.Case;
import org.jacorb.idl.CharType;
import org.jacorb.idl.ConstExpr;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.Declarator;
import org.jacorb.idl.ElementSpec;
import org.jacorb.idl.EnumType;
import org.jacorb.idl.Environment;
import org.jacorb.idl.GlobalInputStream;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.IntType;
import org.jacorb.idl.LongLongType;
import org.jacorb.idl.LongType;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.NoHelperException;
import org.jacorb.idl.Scope;
import org.jacorb.idl.ScopeData;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.ShortType;
import org.jacorb.idl.SwitchBody;
import org.jacorb.idl.SwitchTypeSpec;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.TypeMap;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;

public class UnionType
extends TypeDeclaration
implements Scope {
    public TypeSpec switch_type_spec;
    public SwitchBody switch_body;
    private boolean written = false;
    private ScopeData scopeData;
    private boolean allCasesCovered = false;
    private boolean switch_is_enum = false;
    private boolean switch_is_bool = false;
    private boolean switch_is_longlong = false;
    private boolean explicit_default_case = false;
    private boolean isParsed = false;
    private int labels;

    public UnionType(int n) {
        super(n);
        this.pack_name = "";
    }

    public Object clone() {
        UnionType unionType = new UnionType(UnionType.new_num());
        unionType.switch_type_spec = this.switch_type_spec;
        unionType.switch_body = this.switch_body;
        unionType.pack_name = this.pack_name;
        unionType.name = this.name;
        unionType.written = this.written;
        unionType.scopeData = this.scopeData;
        unionType.enclosing_symbol = this.enclosing_symbol;
        unionType.token = this.token;
        return unionType;
    }

    public void setScopeData(ScopeData scopeData) {
        this.scopeData = scopeData;
    }

    public ScopeData getScopeData() {
        return this.scopeData;
    }

    public TypeDeclaration declaration() {
        return this;
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
        if (this.switch_body != null) {
            this.switch_body.setEnclosingSymbol(idlSymbol);
        }
    }

    public String typeName() {
        if (this.typeName == null) {
            this.setPrintPhaseNames();
        }
        return this.typeName;
    }

    public String className() {
        String string = this.typeName();
        if (string.indexOf(46) > 0) {
            return string.substring(string.lastIndexOf(46) + 1);
        }
        return string;
    }

    public String printReadExpression(String string) {
        return this.typeName() + "Helper.read(" + string + ")";
    }

    public String printWriteStatement(String string, String string2) {
        return this.typeName() + "Helper.write(" + string2 + "," + string + ");";
    }

    public String holderName() {
        return this.typeName() + "Holder";
    }

    public void set_included(boolean bl) {
        this.included = bl;
    }

    public void setSwitchType(TypeSpec typeSpec) {
        this.switch_type_spec = typeSpec;
    }

    public void setSwitchBody(SwitchBody switchBody) {
        this.switch_body = switchBody;
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? new String(string + "." + this.pack_name) : string;
        if (this.switch_type_spec != null) {
            this.switch_type_spec.setPackage(string);
        }
        if (this.switch_body != null) {
            this.switch_body.setPackage(string);
        }
    }

    public boolean basic() {
        return false;
    }

    public void parse() {
        if (this.isParsed) {
            return;
        }
        this.isParsed = true;
        boolean bl = false;
        this.escapeName();
        ConstrTypeSpec constrTypeSpec = new ConstrTypeSpec(UnionType.new_num());
        try {
            ScopedName.definePseudoScope(this.full_name());
            constrTypeSpec.c_type_spec = this;
            NameTable.define(this.full_name(), "type-union");
            TypeMap.typedef(this.full_name(), constrTypeSpec);
        }
        catch (NameAlreadyDefined nameAlreadyDefined) {
            if (parser.get_pending(this.full_name()) != null) {
                if (this.switch_type_spec == null) {
                    bl = true;
                }
                if (!this.full_name().equals("org.omg.CORBA.TypeCode") && this.switch_type_spec != null) {
                    TypeMap.replaceForwardDeclaration(this.full_name(), constrTypeSpec);
                }
            }
            parser.error("Union " + this.full_name() + " already defined", this.token);
        }
        if (this.switch_type_spec != null) {
            TypeSpec typeSpec;
            if (this.switch_type_spec.type_spec instanceof ScopedName) {
                typeSpec = ((ScopedName)this.switch_type_spec.type_spec).resolvedTypeSpec();
                while (typeSpec instanceof ScopedName || typeSpec instanceof AliasTypeSpec) {
                    if (typeSpec instanceof ScopedName) {
                        typeSpec = ((ScopedName)typeSpec).resolvedTypeSpec();
                        continue;
                    }
                    typeSpec = ((AliasTypeSpec)typeSpec).originalType();
                }
                this.addImportedName(this.switch_type_spec.typeName());
            } else {
                typeSpec = this.switch_type_spec.type_spec;
            }
            if (!(typeSpec instanceof SwitchTypeSpec && ((SwitchTypeSpec)((Object)typeSpec)).isSwitchable() || typeSpec instanceof BaseType && ((BaseType)typeSpec).isSwitchType() || typeSpec instanceof ConstrTypeSpec && ((ConstrTypeSpec)typeSpec).c_type_spec instanceof EnumType)) {
                parser.error("Illegal Switch Type: " + typeSpec.typeName(), this.token);
            }
            this.switch_type_spec.parse();
            this.switch_body.setTypeSpec(this.switch_type_spec);
            this.switch_body.setUnion(this);
            ScopedName.addRecursionScope(this.typeName());
            this.switch_body.parse();
            ScopedName.removeRecursionScope(this.typeName());
            Enumeration enumeration = this.switch_body.caseListVector.elements();
            while (enumeration.hasMoreElements()) {
                Case case_ = (Case)enumeration.nextElement();
                case_.element_spec.typeSpec = this.getElementType(case_.element_spec);
            }
            NameTable.parsed_interfaces.put(this.full_name(), "");
            parser.remove_pending(this.full_name());
        } else if (!bl) {
            parser.set_pending(this.full_name());
        }
    }

    public String getTypeCodeExpression() {
        return this.typeName() + "Helper.type()";
    }

    public String getTypeCodeExpression(Set set) {
        if (set.contains(this)) {
            return this.getRecursiveTypeCodeExpression();
        }
        return this.getTypeCodeExpression();
    }

    private void printUnionClass(String string, PrintWriter printWriter) {
        int n;
        int n2;
        Object object;
        int n3;
        Object object2;
        if (Environment.JAVA14 && this.pack_name.equals("")) {
            lexer.emit_warn("No package defined for " + string + " - illegal in JDK1.4", this.token);
        }
        if (!this.pack_name.equals("")) {
            printWriter.println("package " + this.pack_name + ";");
        }
        this.printImport(printWriter);
        this.printClassComment("union", string, printWriter);
        printWriter.println("public" + parser.getFinalString() + " class " + string);
        printWriter.println("\timplements org.omg.CORBA.portable.IDLEntity");
        printWriter.println("{");
        TypeSpec typeSpec = this.switch_type_spec.typeSpec();
        while (typeSpec instanceof ScopedName || typeSpec instanceof AliasTypeSpec) {
            if (typeSpec instanceof ScopedName) {
                typeSpec = ((ScopedName)typeSpec).resolvedTypeSpec();
            }
            if (!(typeSpec instanceof AliasTypeSpec)) continue;
            typeSpec = ((AliasTypeSpec)typeSpec).originalType();
        }
        printWriter.println("\tprivate " + typeSpec.typeName() + " discriminator;");
        String string2 = "";
        int n4 = 0;
        Vector<String> vector = new Vector<String>();
        Vector vector2 = new Vector();
        Enumeration enumeration = this.switch_body.caseListVector.elements();
        while (enumeration.hasMoreElements()) {
            object2 = (Case)enumeration.nextElement();
            for (n3 = 0; n3 < ((Case)object2).case_label_list.v.size(); ++n3) {
                ++this.labels;
                object = ((Case)object2).case_label_list.v.elementAt(n3);
                if (object != null) {
                    if (object instanceof ConstExpr) {
                        vector.addElement(((ConstExpr)object).value());
                        continue;
                    }
                    vector.addElement(ScopedName.unPseudoName(((ScopedName)object).resolvedName()));
                    continue;
                }
                n4 = 1;
                this.explicit_default_case = true;
            }
        }
        if (typeSpec instanceof ConstrTypeSpec && ((ConstrTypeSpec)typeSpec).declaration() instanceof EnumType) {
            this.switch_is_enum = true;
            object2 = (EnumType)((ConstrTypeSpec)typeSpec).declaration();
            if (vector.size() + n4 > ((EnumType)object2).size()) {
                lexer.emit_warn("Too many case labels in definition of union " + this.full_name() + ", default cannot apply", this.token);
            }
            if (vector.size() + n4 == ((EnumType)object2).size()) {
                this.allCasesCovered = true;
            }
            for (n3 = 0; n3 < ((EnumType)object2).size(); ++n3) {
                object = typeSpec.typeName() + "." + (String)((EnumType)object2).enumlist.v.elementAt(n3);
                if (vector.contains(object)) continue;
                if (string2.length() == 0) {
                    string2 = object;
                }
                vector2.addElement(object);
            }
        } else {
            if (typeSpec instanceof BaseType) {
                typeSpec = ((BaseType)typeSpec).typeSpec();
            }
            if (typeSpec instanceof BooleanType) {
                this.switch_is_bool = true;
                if (vector.size() + n4 > 2) {
                    parser.error("Case label error: too many default labels.", this.token);
                    return;
                }
                if (vector.size() == 1) {
                    string2 = ((String)vector.elementAt(0)).equals("true") ? "false" : "true";
                }
            } else if (typeSpec instanceof CharType) {
                boolean bl = false;
                for (n2 = 0; n2 < 256; n2 = (int)((short)(n2 + 1))) {
                    bl = false;
                    object2 = vector.elements();
                    while (object2.hasMoreElements()) {
                        String string3 = (String)object2.nextElement();
                        if ((string3 = string3.substring(1, string3.length() - 1)).charAt(0) == '\\') {
                            string3 = string3.substring(1);
                            n = Short.parseShort(string3);
                        } else {
                            n = (short)string3.charAt(0);
                        }
                        if (n2 != n) continue;
                        bl = true;
                        break;
                    }
                    if (bl) continue;
                    string2 = "(char)" + n2;
                    break;
                }
            } else if (typeSpec instanceof IntType) {
                int n5 = 65536;
                if (typeSpec instanceof LongType) {
                    n5 = Integer.MAX_VALUE;
                }
                for (n3 = 0; n3 < n5; ++n3) {
                    if (vector.contains(String.valueOf(n3))) continue;
                    string2 = Integer.toString(n3);
                    break;
                }
                if (typeSpec instanceof LongLongType) {
                    this.switch_is_longlong = true;
                }
            } else {
                this.logger.error("Something went wrong in UnionType, could not identify switch type " + this.switch_type_spec.type_spec);
            }
        }
        enumeration = this.switch_body.caseListVector.elements();
        while (enumeration.hasMoreElements()) {
            Case case_ = (Case)enumeration.nextElement();
            int n6 = case_.case_label_list.v.size();
            String[] stringArray = new String[n6];
            for (n = 0; n < n6; ++n) {
                Object e = case_.case_label_list.v.elementAt(n);
                if (e == null) {
                    stringArray[n] = null;
                    continue;
                }
                if (e != null && e instanceof ConstExpr) {
                    stringArray[n] = ((ConstExpr)e).value();
                    continue;
                }
                if (!(e instanceof ScopedName)) continue;
                stringArray[n] = ((ScopedName)e).typeName();
            }
            printWriter.println("\tprivate " + case_.element_spec.typeSpec.typeName() + " " + case_.element_spec.declarator.name() + ";");
        }
        printWriter.println("\n\tpublic " + string + " ()");
        printWriter.println("\t{");
        printWriter.println("\t}\n");
        printWriter.println("\tpublic " + typeSpec.typeName() + " discriminator ()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn discriminator;");
        printWriter.println("\t}\n");
        enumeration = this.switch_body.caseListVector.elements();
        while (enumeration.hasMoreElements()) {
            String string4;
            int n7;
            Case case_ = (Case)enumeration.nextElement();
            boolean bl = false;
            int n8 = case_.case_label_list.v.size();
            String[] stringArray = new String[n8];
            for (n2 = 0; n2 < n8; ++n2) {
                Object e = case_.case_label_list.v.elementAt(n2);
                if (e == null) {
                    stringArray[n2] = null;
                    bl = true;
                    continue;
                }
                if (e instanceof ConstExpr) {
                    stringArray[n2] = ((ConstExpr)e).value();
                    continue;
                }
                if (!(e instanceof ScopedName)) continue;
                stringArray[n2] = ((ScopedName)e).typeName();
            }
            printWriter.println("\tpublic " + case_.element_spec.typeSpec.typeName() + " " + case_.element_spec.declarator.name() + " ()");
            printWriter.println("\t{");
            printWriter.print("\t\tif (discriminator != ");
            n2 = 0;
            for (n7 = 0; n7 < n8; ++n7) {
                if (stringArray[n7] == null) {
                    n2 = 1;
                    printWriter.print(string2);
                } else {
                    printWriter.print(stringArray[n7]);
                }
                if (n7 >= n8 - 1) continue;
                printWriter.print(" && discriminator != ");
            }
            if (n2 != 0) {
                for (n7 = 0; n7 < vector2.size(); ++n7) {
                    string4 = (String)vector2.elementAt(n7);
                    if (string4.equals(string2)) continue;
                    printWriter.print(" && discriminator != " + string4);
                }
            }
            printWriter.println(")\n\t\t\tthrow new org.omg.CORBA.BAD_OPERATION();");
            printWriter.println("\t\treturn " + case_.element_spec.declarator.name() + ";");
            printWriter.println("\t}\n");
            printWriter.println("\tpublic void " + case_.element_spec.declarator.name() + " (" + case_.element_spec.typeSpec.typeName() + " _x)");
            printWriter.println("\t{");
            printWriter.print("\t\tdiscriminator = ");
            if (stringArray[0] == null) {
                printWriter.println(string2 + ";");
            } else {
                printWriter.println(stringArray[0] + ";");
            }
            printWriter.println("\t\t" + case_.element_spec.declarator.name() + " = _x;");
            printWriter.println("\t}\n");
            if (n8 <= 1 && !bl) continue;
            printWriter.println("\tpublic void " + case_.element_spec.declarator.name() + " (" + typeSpec.typeName() + " _discriminator, " + case_.element_spec.typeSpec.typeName() + " _x)");
            printWriter.println("\t{");
            printWriter.print("\t\tif (_discriminator != ");
            n2 = 0;
            for (n7 = 0; n7 < n8; ++n7) {
                if (stringArray[n7] == null) {
                    n2 = 1;
                    printWriter.print(string2);
                } else {
                    printWriter.print(stringArray[n7]);
                }
                if (n7 >= n8 - 1) continue;
                printWriter.print(" && _discriminator != ");
            }
            if (n2 != 0) {
                for (n7 = 0; n7 < vector2.size(); ++n7) {
                    string4 = (String)vector2.elementAt(n7);
                    if (string4.equals(string2)) continue;
                    printWriter.print(" && discriminator != " + string4);
                }
            }
            printWriter.println(")\n\t\t\tthrow new org.omg.CORBA.BAD_OPERATION();");
            printWriter.println("\t\tdiscriminator = _discriminator;");
            printWriter.println("\t\t" + case_.element_spec.declarator.name() + " = _x;");
            printWriter.println("\t}\n");
        }
        if (n4 == 0 && string2.length() > 0) {
            printWriter.println("\tpublic void __default ()");
            printWriter.println("\t{");
            printWriter.println("\t\tdiscriminator = " + string2 + ";");
            printWriter.println("\t}");
            printWriter.println("\tpublic void __default (" + typeSpec.typeName() + " _discriminator)");
            printWriter.println("\t{");
            printWriter.println("\t\tdiscriminator = _discriminator;");
            printWriter.println("\t}");
        }
        printWriter.println("}");
    }

    public void printHolderClass(String string, PrintWriter printWriter) {
        if (Environment.JAVA14 && this.pack_name.equals("")) {
            lexer.emit_warn("No package defined for " + string + " - illegal in JDK1.4", this.token);
        }
        if (!this.pack_name.equals("")) {
            printWriter.println("package " + this.pack_name + ";");
        }
        this.printClassComment("union", string, printWriter);
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
        printWriter.println("\t\t" + string + "Helper.write (out, value);");
        printWriter.println("\t}");
        printWriter.println("}");
    }

    private void printHelperClass(String string, PrintWriter printWriter) {
        String string2;
        Declarator declarator;
        TypeSpec typeSpec;
        int n;
        Case case_;
        boolean bl;
        PrintWriter printWriter2;
        ByteArrayOutputStream byteArrayOutputStream;
        if (Environment.JAVA14 && this.pack_name.equals("")) {
            lexer.emit_warn("No package defined for " + string + " - illegal in JDK1.4", this.token);
        }
        if (!this.pack_name.equals("")) {
            printWriter.println("package " + this.pack_name + ";");
        }
        this.printImport(printWriter);
        this.printClassComment("union", string, printWriter);
        printWriter.println("public" + parser.getFinalString() + " class " + string + "Helper");
        printWriter.println("{");
        printWriter.println("\tprivate static org.omg.CORBA.TypeCode _type;");
        TypeSpec.printInsertExtractMethods(printWriter, this.typeName());
        this.printIdMethod(printWriter);
        printWriter.println("\tpublic static " + string + " read (org.omg.CORBA.portable.InputStream in)");
        printWriter.println("\t{");
        printWriter.println("\t\t" + string + " result = new " + string + " ();");
        TypeSpec typeSpec2 = this.switch_type_spec;
        if (this.switch_type_spec.type_spec instanceof ScopedName) {
            typeSpec2 = ((ScopedName)this.switch_type_spec.type_spec).resolvedTypeSpec();
        }
        String string3 = "\t\t\t";
        String string4 = "\t\t\t\t";
        if (this.switch_is_longlong) {
            string3 = "\t\t";
            string4 = "\t\t\t";
        }
        String string5 = "case ";
        String string6 = ":";
        String string7 = "default:";
        if (this.switch_is_enum) {
            printWriter.println("\t\t" + typeSpec2.toString() + " disc = " + typeSpec2.toString() + ".from_int(in.read_long());");
            printWriter.println("\t\tswitch (disc.value ())");
            printWriter.println("\t\t{");
        } else {
            printWriter.println("\t\t" + typeSpec2.toString() + " " + typeSpec2.printReadStatement("disc", "in"));
            if (this.switch_is_bool) {
                string5 = "if (disc == ";
                string6 = ")";
                string7 = "else";
            } else if (this.switch_is_longlong) {
                string5 = "if (disc == ";
                string6 = ")";
                string7 = "else";
            } else {
                printWriter.println("\t\tswitch (disc)");
                printWriter.println("\t\t{");
            }
        }
        String string8 = null;
        Enumeration enumeration = this.switch_body.caseListVector.elements();
        while (enumeration.hasMoreElements()) {
            byteArrayOutputStream = new ByteArrayOutputStream();
            printWriter2 = new PrintWriter(byteArrayOutputStream);
            bl = false;
            case_ = (Case)enumeration.nextElement();
            n = case_.case_label_list.v.size();
            typeSpec = case_.element_spec.typeSpec;
            declarator = case_.element_spec.declarator;
            for (int i = 0; i < n; ++i) {
                Object e = case_.case_label_list.v.elementAt(i);
                if (e == null) {
                    printWriter2.println(string3 + string7);
                    bl = true;
                } else if (e instanceof ConstExpr) {
                    printWriter2.println(string3 + string5 + ((ConstExpr)e).value() + string6);
                } else if (e instanceof ScopedName) {
                    string2 = ((ScopedName)e).typeName();
                    if (this.switch_is_enum) {
                        printWriter2.println(string3 + string5 + string2.substring(0, string2.lastIndexOf(46) + 1) + "_" + string2.substring(string2.lastIndexOf(46) + 1) + string6);
                    } else {
                        printWriter2.println(string3 + string5 + string2 + string6);
                    }
                }
                if (i != n - 1) continue;
                printWriter2.println(string3 + "{");
                if (typeSpec instanceof ScopedName) {
                    typeSpec = ((ScopedName)typeSpec).resolvedTypeSpec();
                }
                typeSpec = typeSpec.typeSpec();
                string2 = "_var";
                printWriter2.println(string4 + typeSpec.typeName() + " " + string2 + ";");
                printWriter2.println(string4 + typeSpec.printReadStatement(string2, "in"));
                printWriter2.print(string4 + "result." + declarator.name() + " (");
                if (n > 1) {
                    printWriter2.print("disc,");
                }
                printWriter2.println(string2 + ");");
                if (e != null && !this.switch_is_bool && !this.switch_is_longlong) {
                    printWriter2.println(string4 + "break;");
                }
                if (this.switch_is_longlong) {
                    printWriter2.println(string4 + "return result;");
                }
                printWriter2.println(string3 + "}");
            }
            if (this.switch_is_bool && !bl) {
                string5 = "else " + string5;
            }
            printWriter2.close();
            if (byteArrayOutputStream.size() <= 0) continue;
            if (bl) {
                string8 = byteArrayOutputStream.toString();
                continue;
            }
            printWriter.print(byteArrayOutputStream.toString());
        }
        if (!(this.explicit_default_case || this.switch_is_bool || this.switch_is_longlong || this.allCasesCovered)) {
            printWriter.println("\t\t\tdefault: result.__default (disc);");
        }
        if (!this.explicit_default_case && this.switch_is_longlong) {
            printWriter.println("\t\tresult.__default (disc);");
            printWriter.println("\t\treturn result;");
        }
        if (string8 != null) {
            printWriter.print(string8);
        }
        if (!this.switch_is_bool && !this.switch_is_longlong) {
            printWriter.println("\t\t}");
        }
        if (!this.switch_is_longlong) {
            printWriter.println("\t\treturn result;");
        }
        printWriter.println("\t}");
        printWriter.println("\tpublic static void write (org.omg.CORBA.portable.OutputStream out, " + string + " s)");
        printWriter.println("\t{");
        if (this.switch_is_enum) {
            printWriter.println("\t\tout.write_long (s.discriminator().value ());");
            printWriter.println("\t\tswitch (s.discriminator().value ())");
            printWriter.println("\t\t{");
        } else {
            printWriter.println("\t\t" + this.switch_type_spec.typeSpec().printWriteStatement("s.discriminator ()", "out"));
            if (this.switch_is_bool) {
                string5 = "if (s.discriminator () ==";
            } else if (this.switch_is_longlong) {
                printWriter.println("\t\tlong disc = s.discriminator ();");
            } else {
                printWriter.println("\t\tswitch (s.discriminator ())");
                printWriter.println("\t\t{");
            }
        }
        string8 = null;
        enumeration = this.switch_body.caseListVector.elements();
        while (enumeration.hasMoreElements()) {
            bl = false;
            byteArrayOutputStream = new ByteArrayOutputStream();
            printWriter2 = new PrintWriter(byteArrayOutputStream);
            case_ = (Case)enumeration.nextElement();
            typeSpec = case_.element_spec.typeSpec;
            declarator = case_.element_spec.declarator;
            n = case_.case_label_list.v.size();
            for (int i = 0; i < n; ++i) {
                Object e = case_.case_label_list.v.elementAt(i);
                if (e == null) {
                    printWriter2.println(string3 + string7);
                    bl = true;
                } else if (e != null && e instanceof ConstExpr) {
                    printWriter2.println(string3 + string5 + ((ConstExpr)e).value() + string6);
                } else if (e instanceof ScopedName) {
                    string2 = ((ScopedName)e).typeName();
                    if (this.switch_is_enum) {
                        printWriter2.println(string3 + string5 + string2.substring(0, string2.lastIndexOf(46) + 1) + "_" + string2.substring(string2.lastIndexOf(46) + 1) + string6);
                    } else {
                        printWriter2.println(string3 + string5 + string2 + string6);
                    }
                }
                if (i != n - 1) continue;
                printWriter2.println(string3 + "{");
                if (typeSpec instanceof ScopedName) {
                    typeSpec = ((ScopedName)typeSpec).resolvedTypeSpec();
                }
                typeSpec = typeSpec.typeSpec();
                printWriter2.println(string4 + typeSpec.printWriteStatement("s." + declarator.name() + " ()", "out"));
                if (e != null && !this.switch_is_bool && !this.switch_is_longlong) {
                    printWriter2.println(string4 + "break;");
                }
                if (this.switch_is_longlong) {
                    printWriter2.println(string4 + "return;");
                }
                printWriter2.println(string3 + "}");
            }
            if (this.switch_is_bool && !bl) {
                string5 = "else " + string5;
            }
            printWriter2.close();
            if (byteArrayOutputStream.size() <= 0) continue;
            if (bl) {
                string8 = byteArrayOutputStream.toString();
                continue;
            }
            printWriter.print(byteArrayOutputStream.toString());
        }
        if (string8 != null) {
            printWriter.print(string8);
        }
        if (!this.switch_is_bool && !this.switch_is_longlong) {
            printWriter.println("\t\t}");
        }
        printWriter.println("\t}");
        printWriter.println("\tpublic static org.omg.CORBA.TypeCode type ()");
        printWriter.println("\t{");
        printWriter.println("\t\tif (_type == null)");
        printWriter.println("\t\t{");
        printWriter.println("\t\t\torg.omg.CORBA.UnionMember[] members = new org.omg.CORBA.UnionMember[" + this.labels + "];");
        printWriter.println("\t\t\torg.omg.CORBA.Any label_any;");
        typeSpec = this.switch_type_spec.typeSpec();
        if (typeSpec instanceof ScopedName) {
            typeSpec = ((ScopedName)typeSpec).resolvedTypeSpec();
        }
        typeSpec = typeSpec.typeSpec();
        enumeration = this.switch_body.caseListVector.elements();
        int n2 = 0;
        while (enumeration.hasMoreElements()) {
            case_ = (Case)enumeration.nextElement();
            TypeSpec typeSpec3 = case_.element_spec.typeSpec;
            if (typeSpec3 instanceof ScopedName) {
                typeSpec3 = ((ScopedName)typeSpec3).resolvedTypeSpec();
            }
            typeSpec3 = typeSpec3.typeSpec();
            Declarator declarator2 = case_.element_spec.declarator;
            n = case_.case_label_list.v.size();
            for (int i = 0; i < n; ++i) {
                Object e = case_.case_label_list.v.elementAt(i);
                printWriter.println("\t\t\tlabel_any = org.omg.CORBA.ORB.init().create_any ();");
                TypeSpec typeSpec4 = typeSpec;
                if (typeSpec instanceof AliasTypeSpec) {
                    typeSpec4 = ((AliasTypeSpec)typeSpec).originalType();
                }
                if (e == null) {
                    printWriter.println("\t\t\tlabel_any.insert_octet ((byte)0);");
                } else if (typeSpec4 instanceof BaseType) {
                    if (typeSpec4 instanceof CharType || typeSpec4 instanceof BooleanType || typeSpec4 instanceof LongType || typeSpec4 instanceof LongLongType) {
                        printWriter.print("\t\t\tlabel_any." + typeSpec4.printInsertExpression() + " (");
                    } else if (typeSpec4 instanceof ShortType) {
                        printWriter.print("\t\t\tlabel_any." + typeSpec4.printInsertExpression() + " ((short)");
                    } else {
                        throw new RuntimeException("Compiler error: unrecognized BaseType: " + typeSpec4.typeName() + ":" + typeSpec4 + ": " + typeSpec4.typeSpec() + ": " + typeSpec4.getClass().getName());
                    }
                    printWriter.println(((ConstExpr)e).value() + ");");
                } else if (this.switch_is_enum) {
                    String string9 = ((ScopedName)e).typeName();
                    printWriter.println("\t\t\t" + string9.substring(0, string9.lastIndexOf(46)) + "Helper.insert(label_any, " + string9 + ");");
                } else {
                    throw new RuntimeException("Compiler error: unrecognized label type: " + typeSpec4.typeName());
                }
                printWriter.print("\t\t\tmembers[" + n2++ + "] = new org.omg.CORBA.UnionMember (\"" + declarator2.deEscapeName() + "\", label_any, ");
                if (typeSpec3 instanceof ConstrTypeSpec) {
                    try {
                        printWriter.print(typeSpec3.typeSpec().helperName() + ".type(),");
                    }
                    catch (NoHelperException noHelperException) {
                        printWriter.print(typeSpec3.typeSpec().getTypeCodeExpression() + ",");
                    }
                } else {
                    printWriter.print(typeSpec3.typeSpec().getTypeCodeExpression() + ",");
                }
                printWriter.println("null);");
            }
        }
        printWriter.print("\t\t\t _type = org.omg.CORBA.ORB.init().create_union_tc(id(),\"" + this.className() + "\",");
        printWriter.println(this.switch_type_spec.typeSpec().getTypeCodeExpression() + ", members);");
        printWriter.println("\t\t}");
        printWriter.println("\t\treturn _type;");
        printWriter.println("\t}");
        printWriter.println("}");
    }

    public void print(PrintWriter printWriter) {
        this.setPrintPhaseNames();
        if (this.included && !this.generateIncluded()) {
            return;
        }
        if (!this.written && this.switch_type_spec != null) {
            try {
                PrintWriter printWriter2;
                String string;
                File file;
                this.switch_body.print(printWriter);
                String string2 = this.className();
                String string3 = parser.out_dir + fileSeparator + this.pack_name.replace('.', fileSeparator);
                File file2 = new File(string3);
                if (!file2.exists() && !file2.mkdirs()) {
                    parser.fatal_error("Unable to create " + string3, null);
                }
                if (GlobalInputStream.isMoreRecentThan(file = new File(file2, string = string2 + ".java"))) {
                    printWriter2 = new PrintWriter(new FileWriter(file));
                    this.printUnionClass(string2, printWriter2);
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

    private TypeSpec getElementType(ElementSpec elementSpec) {
        TypeSpec typeSpec = elementSpec.typeSpec;
        if (elementSpec.declarator.d instanceof ArrayDeclarator) {
            typeSpec = new ArrayTypeSpec(UnionType.new_num(), typeSpec, (ArrayDeclarator)elementSpec.declarator.d, this.pack_name);
            typeSpec.parse();
        }
        return typeSpec;
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        printWriter.println("\t\t" + this.pack_name + "." + this.className() + "Helper.insert(" + string + ", " + string2 + ");");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        printWriter.println("\t\t" + string + " = " + this.className() + "Helper.extract(" + string2 + ");");
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        iDLTreeVisitor.visitUnion(this);
    }
}

