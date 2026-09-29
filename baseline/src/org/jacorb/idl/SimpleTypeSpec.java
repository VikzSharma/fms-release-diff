/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.TypeSpec;

public class SimpleTypeSpec
extends TypeSpec {
    public SimpleTypeSpec(int n) {
        super(n);
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        iDLTreeVisitor.visitSimpleTypeSpec(this);
    }

    public int getTCKind() {
        return this.type_spec.getTCKind();
    }
}

