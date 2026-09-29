/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import org.jacorb.idl.ParseException;
import org.jacorb.idl.SimpleTypeSpec;

public class TemplateTypeSpec
extends SimpleTypeSpec {
    protected boolean typedefd = false;

    public TemplateTypeSpec(int n) {
        super(n);
    }

    public void parse() throws ParseException {
        if (this.type_spec != null) {
            this.type_spec.parse();
        }
    }

    public void markTypeDefd() {
        this.typedefd = true;
    }

    public boolean basic() {
        return true;
    }
}

