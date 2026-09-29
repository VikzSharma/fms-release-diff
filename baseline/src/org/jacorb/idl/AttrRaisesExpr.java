/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.util.Vector;
import org.jacorb.idl.IdlSymbol;

public class AttrRaisesExpr
extends IdlSymbol {
    public Vector getNameList = new Vector();
    public Vector setNameList = new Vector();

    public AttrRaisesExpr(int n) {
        super(n);
    }
}

