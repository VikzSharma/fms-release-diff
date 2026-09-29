/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.File;
import java.io.InputStream;

public class PositionInfo {
    public String line = "";
    public int line_no = 0;
    public int line_pos = 0;
    public String pragma_prefix = "";
    public File file;
    public InputStream stream;

    public PositionInfo(int n, int n2, String string, String string2, File file) {
        this.line_no = n;
        this.line_pos = n2;
        this.pragma_prefix = string;
        this.line = string2;
        this.file = file;
    }

    public String toString() {
        return this.file.getName() + ", line " + this.line_no + "(" + this.line_pos + ")";
    }
}

