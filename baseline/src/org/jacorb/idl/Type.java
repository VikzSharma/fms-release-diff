/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

public interface Type
extends Cloneable {
    public String typeName();

    public boolean basic();

    public String getTypeCodeExpression();

    public String holderName();

    public String printReadExpression(String var1);

    public String printReadStatement(String var1, String var2);

    public String printWriteStatement(String var1, String var2);
}

