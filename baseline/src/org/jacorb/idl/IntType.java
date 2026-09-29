/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import org.jacorb.idl.BaseType;
import org.jacorb.idl.SwitchTypeSpec;

public class IntType
extends BaseType
implements SwitchTypeSpec {
    public boolean unsigned = false;

    public IntType(int n) {
        super(n);
    }

    public void setUnsigned() {
        this.unsigned = true;
        if (this.type_spec != null) {
            ((IntType)this.type_spec).setUnsigned();
        }
    }

    public boolean isSwitchable() {
        return true;
    }
}

