/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.xml;

import com.filemaker.jwpc.response.Document;
import java.io.PrintWriter;

public abstract class XMLDocument
implements Document {
    @Override
    public abstract void generateResponse();

    public abstract void getDTD(PrintWriter var1);

    public abstract String getNameSpace();
}

