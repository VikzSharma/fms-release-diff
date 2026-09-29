/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.common.DataObject
 */
package com.filemaker.jwpc.fmwp.datatype;

import com.filemaker.jwpc.common.DataObject;

public abstract class BitFlags
extends DataObject {
    protected int bitValues;

    public BitFlags(int n) {
        this.bitValues = n;
    }

    public int getValue() {
        return this.bitValues;
    }

    public void setValue(int n) {
        this.bitValues = n;
    }

    public void setFlag(int n, boolean bl) {
        this.bitValues = bl ? this.bitValues | n : this.bitValues & ~n;
    }

    public boolean isFlagSet(int n) {
        return (n & this.bitValues) != 0;
    }
}

