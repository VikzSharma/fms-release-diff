/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import org.jacorb.idl.BaseType;

public class FloatPtType
extends BaseType {
    public FloatPtType(int n) {
        super(n);
    }

    public String holderName() {
        return this.type_spec.holderName();
    }
}

