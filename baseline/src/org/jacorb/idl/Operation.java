/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.io.Serializable;
import org.jacorb.idl.IDLTreeVisitor;

public interface Operation
extends Serializable {
    public String name();

    public String opName();

    public void printMethod(PrintWriter var1, String var2, boolean var3, boolean var4);

    public void print_sendc_Method(PrintWriter var1, String var2);

    public String signature();

    public void printSignature(PrintWriter var1, boolean var2);

    public void printSignature(PrintWriter var1);

    public void printDelegatedMethod(PrintWriter var1);

    public void printInvocation(PrintWriter var1);

    public void accept(IDLTreeVisitor var1);
}

