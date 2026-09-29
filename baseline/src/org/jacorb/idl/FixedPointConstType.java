/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import org.jacorb.idl.BaseType;
import org.jacorb.idl.TypeSpec;

public class FixedPointConstType
extends BaseType {
    public FixedPointConstType(int n) {
        super(n);
    }

    public Object clone() {
        return new FixedPointConstType(FixedPointConstType.new_num());
    }

    public String typeName() {
        return "java.math.BigDecimal";
    }

    public TypeSpec typeSpec() {
        return this;
    }

    public String toString() {
        return this.typeName();
    }

    public boolean basic() {
        return true;
    }

    public int getTCKind() {
        return 28;
    }

    public void parse() {
    }

    public String holderName() {
        return "org.omg.CORBA.FixedHolder";
    }

    public String printReadExpression(String string) {
        return string + ".read_fixed()";
    }

    public String printWriteStatement(String string, String string2) {
        return string2 + ".write_fixed(" + string + ");";
    }
}

