/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.AliasTypeSpec;
import org.jacorb.idl.BaseType;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.ObjectTypeSpec;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.SimpleTypeSpec;
import org.jacorb.idl.TemplateTypeSpec;
import org.jacorb.idl.TypeCodeTypeSpec;
import org.jacorb.idl.TypeSpec;

public abstract class VectorType
extends TemplateTypeSpec {
    TypeSpec type_spec;

    public VectorType(int n) {
        super(n);
    }

    public TypeSpec elementTypeSpec() {
        TypeSpec typeSpec = this.type_spec.typeSpec();
        if (typeSpec instanceof ScopedName) {
            typeSpec = ((ScopedName)typeSpec).resolvedTypeSpec().typeSpec();
        }
        return typeSpec;
    }

    public void setTypeSpec(SimpleTypeSpec simpleTypeSpec) {
        this.type_spec = simpleTypeSpec;
    }

    public String typeName() {
        String string = this.type_spec.typeSpec() instanceof ScopedName ? ((ScopedName)this.type_spec.typeSpec()).resolvedTypeSpec().toString() : this.type_spec.toString();
        return string + "[]";
    }

    boolean typedefd() {
        return this.typedefd;
    }

    public String printReadExpression(String string) {
        if (this.typedefd()) {
            return this.helperName() + ".read(" + string + ")";
        }
        return "*****";
    }

    protected String elementTypeExpression() {
        TypeSpec typeSpec = this.type_spec.typeSpec();
        if (typeSpec instanceof AliasTypeSpec) {
            return this.type_spec.full_name() + "Helper.type()";
        }
        if (typeSpec instanceof BaseType || typeSpec instanceof TypeCodeTypeSpec || typeSpec instanceof ConstrTypeSpec || typeSpec instanceof TemplateTypeSpec || typeSpec instanceof ObjectTypeSpec) {
            return typeSpec.getTypeCodeExpression();
        }
        return typeSpec.typeName() + "Helper.type()";
    }

    public String elementTypeName() {
        TypeSpec typeSpec = this.type_spec;
        if (typeSpec instanceof ScopedName) {
            if (this.logger.isFatalErrorEnabled()) {
                this.logger.fatalError("elementTypeName is outer ScopedName");
            }
            typeSpec = ((ScopedName)this.type_spec.type_spec).resolvedTypeSpec();
            while (typeSpec instanceof ScopedName || typeSpec instanceof AliasTypeSpec) {
                if (typeSpec instanceof ScopedName) {
                    if (this.logger.isFatalErrorEnabled()) {
                        this.logger.fatalError("elementTypeName is inner Alias");
                    }
                    typeSpec = ((ScopedName)typeSpec).resolvedTypeSpec();
                }
                if (!(typeSpec instanceof AliasTypeSpec)) continue;
                if (this.logger.isFatalErrorEnabled()) {
                    this.logger.fatalError("elementTypeName is inner Alias");
                }
                typeSpec = ((AliasTypeSpec)typeSpec).originalType();
            }
        }
        return typeSpec.typeName();
    }

    public abstract int length();

    public abstract String holderName();

    public abstract String helperName();

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        throw new RuntimeException("Not yet implemented");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        throw new RuntimeException("Not yet implemented");
    }

    public String toString() {
        return this.typeName();
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        iDLTreeVisitor.visitVectorType(this);
    }

    public int getTCKind() {
        return 20;
    }
}

