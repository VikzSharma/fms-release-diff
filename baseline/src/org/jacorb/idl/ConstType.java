/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.parser;

public class ConstType
extends IdlSymbol {
    TypeSpec symbol;

    public ConstType(int n) {
        super(n);
    }

    public void parse() {
        TypeSpec typeSpec;
        if (this.symbol.typeSpec() instanceof ScopedName && (typeSpec = ((ScopedName)this.symbol.typeSpec()).resolvedTypeSpec()) != null) {
            this.symbol = typeSpec;
        }
        this.symbol.parse();
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        this.symbol.setPackage(string);
    }

    public String toString() {
        return this.symbol.toString();
    }
}

