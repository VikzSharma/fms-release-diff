/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.exceptions;

public class UnSupportedXMLGrammarException
extends Exception {
    private String grammar = "";

    public UnSupportedXMLGrammarException(String string) {
        this.grammar = string;
    }

    public String getInvalidGrammar() {
        return this.grammar;
    }
}

