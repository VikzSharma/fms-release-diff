/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import org.jacorb.idl.NameAlreadyDefined;

public class IllegalRedefinition
extends NameAlreadyDefined {
    public String newDef;

    public IllegalRedefinition(String string) {
        super(string);
        this.newDef = string;
    }
}

