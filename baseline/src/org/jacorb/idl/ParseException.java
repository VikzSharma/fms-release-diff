/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import org.jacorb.idl.PositionInfo;

public class ParseException
extends RuntimeException {
    private PositionInfo position = null;

    public ParseException() {
    }

    public ParseException(String string) {
        super(string);
    }

    public ParseException(String string, PositionInfo positionInfo) {
        super(string);
        this.position = positionInfo;
    }

    public String getMessage() {
        return (this.position != null ? this.position.toString() + ": " : "") + "Parse error " + (super.getMessage() != null ? ": " + super.getMessage() : "");
    }
}

