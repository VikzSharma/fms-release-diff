/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import org.jacorb.idl.AliasTypeSpec;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.Declaration;
import org.jacorb.idl.Definition;
import org.jacorb.idl.Definitions;
import org.jacorb.idl.EnumType;
import org.jacorb.idl.Interface;
import org.jacorb.idl.InterfaceBody;
import org.jacorb.idl.Method;
import org.jacorb.idl.Module;
import org.jacorb.idl.NativeType;
import org.jacorb.idl.OpDecl;
import org.jacorb.idl.ParamDecl;
import org.jacorb.idl.SimpleTypeSpec;
import org.jacorb.idl.Spec;
import org.jacorb.idl.StructType;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.TypeDef;
import org.jacorb.idl.UnionType;
import org.jacorb.idl.Value;
import org.jacorb.idl.VectorType;

public interface IDLTreeVisitor {
    public void visitSpec(Spec var1);

    public void visitModule(Module var1);

    public void visitInterface(Interface var1);

    public void visitInterfaceBody(InterfaceBody var1);

    public void visitDefinitions(Definitions var1);

    public void visitDefinition(Definition var1);

    public void visitDeclaration(Declaration var1);

    public void visitOpDecl(OpDecl var1);

    public void visitMethod(Method var1);

    public void visitParamDecl(ParamDecl var1);

    public void visitStruct(StructType var1);

    public void visitUnion(UnionType var1);

    public void visitEnum(EnumType var1);

    public void visitNative(NativeType var1);

    public void visitTypeDef(TypeDef var1);

    public void visitAlias(AliasTypeSpec var1);

    public void visitValue(Value var1);

    public void visitTypeDeclaration(TypeDeclaration var1);

    public void visitConstrTypeSpec(ConstrTypeSpec var1);

    public void visitSimpleTypeSpec(SimpleTypeSpec var1);

    public void visitVectorType(VectorType var1);
}

