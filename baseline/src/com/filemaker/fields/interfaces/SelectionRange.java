/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.fields.interfaces;

public class SelectionRange {
    private int position = -1;
    private int length = 0;

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int n) {
        this.position = n;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int n) {
        this.length = n;
    }

    public int getEndPosition() {
        return this.position + this.length;
    }

    public void clear() {
        this.position = -1;
        this.length = 0;
    }

    public boolean isUndefined() {
        return this.position == -1;
    }

    public String toString() {
        return "pos:" + this.position + " length:" + this.length;
    }
}

