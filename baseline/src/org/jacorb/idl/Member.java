/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;
import org.jacorb.idl.AliasTypeSpec;
import org.jacorb.idl.ArrayDeclarator;
import org.jacorb.idl.ArrayTypeSpec;
import org.jacorb.idl.BaseType;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.Declaration;
import org.jacorb.idl.Declarator;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.Interface;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.SequenceType;
import org.jacorb.idl.StringType;
import org.jacorb.idl.StructType;
import org.jacorb.idl.SymbolList;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.Value;
import org.jacorb.idl.VectorType;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;

public class Member
extends Declaration {
    public TypeSpec type_spec;
    SymbolList declarators;
    public Vector extendVector;
    public TypeDeclaration containingType;
    public Declarator declarator;

    public Member(int n) {
        super(n);
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        this.type_spec.setPackage(string);
        if (this.declarators != null) {
            this.declarators.setPackage(string);
        }
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        this.enclosing_symbol = idlSymbol;
        this.type_spec.setEnclosingSymbol(idlSymbol);
        Enumeration enumeration = this.declarators.v.elements();
        while (enumeration.hasMoreElements()) {
            ((Declarator)enumeration.nextElement()).setEnclosingSymbol(idlSymbol);
        }
    }

    public void setContainingType(TypeDeclaration typeDeclaration) {
        this.containingType = typeDeclaration;
    }

    public void setExtendVector(Vector vector) {
        this.extendVector = vector;
    }

    public Member extractMember(Declarator declarator) {
        Member member = new Member(Member.new_num());
        member.declarator = declarator;
        return member;
    }

    public void parse() {
        Object object;
        Object object2;
        IdlSymbol idlSymbol;
        Object object3;
        boolean bl = true;
        if (this.extendVector == null) {
            lexer.restorePosition(this.myPosition);
            parser.fatal_error("Internal Compiler Error: extendVector not set.", this.token);
        }
        if (this.type_spec.typeSpec() instanceof ScopedName) {
            this.token = this.type_spec.typeSpec().get_token();
            object3 = this.type_spec.typeSpec().toString();
            this.type_spec = ((ScopedName)this.type_spec.typeSpec()).resolvedTypeSpec();
            this.enclosing_symbol.addImportedName((String)object3, this.type_spec);
            if (this.type_spec instanceof AliasTypeSpec && (idlSymbol = ((AliasTypeSpec)(object2 = (AliasTypeSpec)this.type_spec)).originalType()) instanceof SequenceType && ((VectorType)(object = (SequenceType)idlSymbol)).elementTypeSpec().typeName().equals(this.containingType.typeName())) {
                ((SequenceType)object).setRecursive();
            }
            bl = false;
            if (this.type_spec instanceof ConstrTypeSpec && ((ConstrTypeSpec)this.type_spec.typeSpec()).c_type_spec instanceof StructType && ((ConstrTypeSpec)this.type_spec.typeSpec()).c_type_spec.typeName().equals(this.containingType.typeName())) {
                parser.fatal_error("Illegal type recursion (use sequence<" + this.containingType.typeName() + "> instead)", this.token);
            }
        } else if (this.type_spec.typeSpec() instanceof SequenceType) {
            object3 = ((SequenceType)this.type_spec.typeSpec()).elementTypeSpec().typeSpec();
            object2 = (SequenceType)this.type_spec.typeSpec();
            while (object3 instanceof SequenceType) {
                object2 = (SequenceType)object3;
                object3 = ((SequenceType)((TypeSpec)object3).typeSpec()).elementTypeSpec().typeSpec();
            }
            if (ScopedName.isRecursionScope(((TypeSpec)object3).typeName())) {
                ((SequenceType)object2).setRecursive();
            }
        } else if (this.type_spec instanceof ConstrTypeSpec) {
            this.type_spec.parse();
        }
        object3 = null;
        if (this.token != null && this.token.line_val != null && ((String)(object3 = this.token.line_val.trim())).length() == 0) {
            object3 = null;
        }
        object2 = this.declarators.v.elements();
        while (object2.hasMoreElements()) {
            idlSymbol = (Declarator)object2.nextElement();
            object = ((Declarator)idlSymbol).name();
            if (object3 != null) {
                if (parser.strict_names) {
                    if (((String)object).equalsIgnoreCase((String)object3)) {
                        parser.fatal_error("Declarator " + (String)object + " already defined in scope.", this.token);
                    }
                } else if (((String)object).equals(object3)) {
                    parser.fatal_error("Declarator " + (String)object + " already defined in scope.", this.token);
                }
            }
            Member member = this.extractMember((Declarator)idlSymbol);
            TypeSpec typeSpec = this.type_spec.typeSpec();
            if (bl || ((Declarator)idlSymbol).d instanceof ArrayDeclarator) {
                if (((Declarator)idlSymbol).d instanceof ArrayDeclarator) {
                    typeSpec = new ArrayTypeSpec(Member.new_num(), typeSpec, (ArrayDeclarator)((Declarator)idlSymbol).d, this.pack_name);
                    typeSpec.parse();
                } else if (!(typeSpec instanceof BaseType)) {
                    if (!((typeSpec = (TypeSpec)typeSpec.clone()) instanceof ConstrTypeSpec)) {
                        typeSpec.set_name(((Declarator)idlSymbol).name());
                    }
                    if (!object2.hasMoreElements()) {
                        typeSpec.parse();
                    }
                }
            }
            if (!(((Declarator)idlSymbol).d instanceof ArrayDeclarator)) {
                try {
                    NameTable.define(this.containingType + "." + ((Declarator)idlSymbol).name(), "declarator");
                }
                catch (NameAlreadyDefined nameAlreadyDefined) {
                    parser.fatal_error("Declarator " + ((Declarator)idlSymbol).name() + " already defined in scope.", this.token);
                }
            }
            member.type_spec = typeSpec;
            member.pack_name = this.pack_name;
            member.name = this.name;
            this.extendVector.addElement(member);
        }
        this.declarators = null;
    }

    public void print(PrintWriter printWriter) {
        this.member_print(printWriter, "\tpublic ");
    }

    public void member_print(PrintWriter printWriter, String string) {
        if (this.type_spec.typeSpec() instanceof ConstrTypeSpec && !(((ConstrTypeSpec)this.type_spec.typeSpec()).c_type_spec.declaration() instanceof Interface) && !(((ConstrTypeSpec)this.type_spec.typeSpec()).c_type_spec.declaration() instanceof Value) || this.type_spec.typeSpec() instanceof SequenceType || this.type_spec.typeSpec() instanceof ArrayTypeSpec) {
            this.type_spec.print(printWriter);
        }
        if (this.type_spec.typeSpec() instanceof StringType) {
            printWriter.print(string + this.type_spec.toString() + " " + this.declarator.toString() + " = \"\";");
        } else {
            printWriter.print(string + this.type_spec.toString() + " " + this.declarator.toString() + ";");
        }
    }

    public TypeSpec typeSpec() {
        return this.type_spec.typeSpec();
    }
}

