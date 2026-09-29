/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;

public class Declaration
extends IdlSymbol {
    public Declaration(int n) {
        super(n);
        this.pack_name = "";
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        iDLTreeVisitor.visitDeclaration(this);
    }
}

