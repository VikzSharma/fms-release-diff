/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.PosIntConst;
import org.jacorb.idl.parser;

public class FixedArraySize
extends IdlSymbol {
    public PosIntConst pos_int_const;

    public FixedArraySize(int n) {
        super(n);
    }

    public void parse() {
        this.pos_int_const.parse();
    }

    public int value() {
        return this.pos_int_const.value();
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        this.pos_int_const.setPackage(string);
    }
}

