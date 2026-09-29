/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl.javamapping;

import java.util.Enumeration;
import org.jacorb.idl.AliasTypeSpec;
import org.jacorb.idl.AnyType;
import org.jacorb.idl.ArrayTypeSpec;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.Declaration;
import org.jacorb.idl.Definition;
import org.jacorb.idl.Definitions;
import org.jacorb.idl.EnumType;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.Interface;
import org.jacorb.idl.InterfaceBody;
import org.jacorb.idl.Member;
import org.jacorb.idl.MemberList;
import org.jacorb.idl.Method;
import org.jacorb.idl.Module;
import org.jacorb.idl.NativeType;
import org.jacorb.idl.ObjectTypeSpec;
import org.jacorb.idl.OpDecl;
import org.jacorb.idl.Operation;
import org.jacorb.idl.ParamDecl;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.SequenceType;
import org.jacorb.idl.SimpleTypeSpec;
import org.jacorb.idl.Spec;
import org.jacorb.idl.StringType;
import org.jacorb.idl.StructType;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.TypeDef;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.UnionType;
import org.jacorb.idl.Value;
import org.jacorb.idl.VectorType;

public class JavaMappingGeneratingVisitor
implements IDLTreeVisitor {
    public void visitSpec(Spec spec) {
        Enumeration enumeration = spec.definitions.elements();
        while (enumeration.hasMoreElements()) {
            IdlSymbol idlSymbol = (IdlSymbol)enumeration.nextElement();
            idlSymbol.accept(this);
        }
    }

    public void visitDefinitions(Definitions definitions) {
        Enumeration enumeration = definitions.getElements();
        while (enumeration.hasMoreElements()) {
            IdlSymbol idlSymbol = (IdlSymbol)enumeration.nextElement();
            idlSymbol.accept(this);
        }
    }

    public void visitDefinition(Definition definition) {
        definition.get_declaration().accept(this);
    }

    public void visitDeclaration(Declaration declaration) {
        System.out.println("Unimplemented behavior: visitDeclaration");
    }

    public void visitModule(Module module) {
        module.getDefinitions().accept(this);
    }

    public void visitInterface(Interface interface_) {
        if (interface_.body == null) {
            return;
        }
        String[] stringArray = interface_.get_ids();
        for (int i = 1; i < stringArray.length; ++i) {
        }
        if (interface_.body != null) {
            interface_.body.accept(this);
        }
    }

    public void visitInterfaceBody(InterfaceBody interfaceBody) {
        Operation[] operationArray = interfaceBody.getMethods();
        for (int i = 0; i < operationArray.length; ++i) {
            operationArray[i].accept(this);
        }
    }

    public void visitMethod(Method method) {
        if (method.isGetter()) {
            // empty if block
        }
    }

    public void visitOpDecl(OpDecl opDecl) {
        Enumeration enumeration = opDecl.paramDecls.elements();
        while (enumeration.hasMoreElements()) {
            ParamDecl paramDecl = (ParamDecl)enumeration.nextElement();
            paramDecl.accept(this);
        }
    }

    public void visitParamDecl(ParamDecl paramDecl) {
        String string = "in";
        if (paramDecl.paramAttribute == 2) {
            string = "out";
        } else if (paramDecl.paramAttribute == 3) {
            string = "inout";
        }
    }

    public void visitTypeDeclaration(TypeDeclaration typeDeclaration) {
    }

    public void visitConstrTypeSpec(ConstrTypeSpec constrTypeSpec) {
    }

    public void visitStruct(StructType structType) {
        int n = -1;
        boolean bl = false;
        boolean bl2 = false;
        MemberList memberList = structType.memberlist;
        if (memberList != null) {
            Enumeration enumeration = memberList.elements();
            while (enumeration.hasMoreElements()) {
                Member member = (Member)enumeration.nextElement();
                String string = this.typeSpecDesignator(member.type_spec);
                if (!(member.type_spec instanceof VectorType)) continue;
                string = this.typeSpecDesignator(((VectorType)member.type_spec).elementTypeSpec());
                n = ((VectorType)member.type_spec).length();
                if (member.type_spec instanceof SequenceType) {
                    bl = true;
                    continue;
                }
                if (member.type_spec instanceof ArrayTypeSpec) {
                    bl2 = true;
                    continue;
                }
                throw new RuntimeException("Internal Error: encountered vector that is neither array nor sequence!");
            }
        }
    }

    public void visitEnum(EnumType enumType) {
        Enumeration enumeration = enumType.enumlist.elements();
        while (enumeration.hasMoreElements()) {
        }
    }

    public void visitUnion(UnionType unionType) {
    }

    public void visitSequence(SequenceType sequenceType) {
    }

    public void visitNative(NativeType nativeType) {
    }

    public void visitTypeDef(TypeDef typeDef) {
    }

    public void visitAlias(AliasTypeSpec aliasTypeSpec) {
        boolean bl = false;
        boolean bl2 = false;
        int n = -1;
        String string = this.typeSpecDesignator(aliasTypeSpec.originalType());
        if (aliasTypeSpec.originalType() instanceof VectorType) {
            string = this.typeSpecDesignator(((VectorType)aliasTypeSpec.originalType()).elementTypeSpec());
            n = ((VectorType)aliasTypeSpec.originalType()).length();
            if (aliasTypeSpec.originalType() instanceof SequenceType) {
                bl = true;
            } else if (aliasTypeSpec.originalType() instanceof ArrayTypeSpec) {
                bl2 = true;
            } else {
                throw new RuntimeException("Internal Error: encountered vector that is neither array nor sequence!");
            }
        }
    }

    public void visitValue(Value value) {
    }

    private String typeSpecDesignator(TypeSpec typeSpec) {
        if (!typeSpec.basic()) {
            if (typeSpec.typeSpec() instanceof AnyType) {
                return "any";
            }
            return typeSpec.id();
        }
        if (typeSpec.typeSpec() instanceof ObjectTypeSpec) {
            return typeSpec.id();
        }
        if (typeSpec.typeSpec() instanceof ConstrTypeSpec) {
            return ((ConstrTypeSpec)typeSpec.typeSpec()).id();
        }
        if (typeSpec.typeSpec() instanceof ScopedName) {
            return this.typeSpecDesignator(((ScopedName)typeSpec.typeSpec()).resolvedTypeSpec());
        }
        if (typeSpec.typeSpec() instanceof StringType) {
            return "string";
        }
        return typeSpec.toString();
    }

    public void visitSimpleTypeSpec(SimpleTypeSpec simpleTypeSpec) {
    }

    public void visitVectorType(VectorType vectorType) {
    }
}

