/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.Serializable;
import java.math.BigDecimal;
import org.jacorb.idl.runtime.long_token;

public class fixed_token
extends long_token
implements Serializable {
    public BigDecimal fixed_val;

    public fixed_token(int n, BigDecimal bigDecimal) {
        super(n);
        this.fixed_val = bigDecimal;
    }
}

