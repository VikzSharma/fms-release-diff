/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.Serializable;
import org.jacorb.idl.GlobalInputStream;
import org.jacorb.idl.PositionInfo;
import org.jacorb.idl.lexer;

public class str_token
extends org.jacorb.idl.runtime.str_token
implements Serializable {
    public String str_val;
    public String line_val;
    public int line_no;
    public int char_pos;
    public String pragma_prefix = "";
    public String fileName = "";

    public str_token(int n, String string, PositionInfo positionInfo, String string2) {
        super(n);
        this.str_val = string;
        this.line_val = positionInfo.line;
        this.line_no = positionInfo.line_no;
        this.char_pos = positionInfo.line_pos;
        this.pragma_prefix = positionInfo.pragma_prefix;
        this.fileName = string2;
    }

    public str_token(int n) {
        this(n, "", lexer.getPosition(), GlobalInputStream.currentFile().getName());
    }
}

