/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.parser;

public class Spec
extends IdlSymbol {
    public Vector definitions = new Vector();

    public Spec(int n) {
        super(n);
    }

    public void parse() {
        Enumeration enumeration = this.definitions.elements();
        while (enumeration.hasMoreElements()) {
            ((IdlSymbol)enumeration.nextElement()).parse();
        }
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        Enumeration enumeration = this.definitions.elements();
        while (enumeration.hasMoreElements()) {
            IdlSymbol idlSymbol = (IdlSymbol)enumeration.nextElement();
            idlSymbol.setPackage(string);
        }
    }

    public void print(PrintWriter printWriter) {
        Enumeration enumeration = this.definitions.elements();
        while (enumeration.hasMoreElements()) {
            ((IdlSymbol)enumeration.nextElement()).print(printWriter);
        }
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        iDLTreeVisitor.visitSpec(this);
    }
}

