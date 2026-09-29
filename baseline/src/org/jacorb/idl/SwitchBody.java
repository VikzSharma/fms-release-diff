/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;
import org.jacorb.idl.Case;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.UnionType;
import org.jacorb.idl.parser;

public class SwitchBody
extends IdlSymbol {
    public Vector caseListVector = new Vector();
    TypeSpec ts = null;
    UnionType myUnion = null;

    public SwitchBody(int n) {
        super(n);
    }

    public void setTypeSpec(TypeSpec typeSpec) {
        this.ts = typeSpec;
        Enumeration enumeration = this.caseListVector.elements();
        while (enumeration.hasMoreElements()) {
            Case case_ = (Case)enumeration.nextElement();
            case_.setPackage(this.pack_name);
            case_.setTypeSpec(typeSpec);
        }
    }

    public void setUnion(UnionType unionType) {
        this.myUnion = unionType;
        Enumeration enumeration = this.caseListVector.elements();
        while (enumeration.hasMoreElements()) {
            Case case_ = (Case)enumeration.nextElement();
            case_.setUnion(unionType);
        }
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
        Enumeration enumeration = this.caseListVector.elements();
        while (enumeration.hasMoreElements()) {
            ((IdlSymbol)enumeration.nextElement()).setEnclosingSymbol(idlSymbol);
        }
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        if (this.ts != null) {
            this.ts.setPackage(string);
        }
    }

    public void parse() {
        HashMap<String, IdlSymbol> hashMap = new HashMap<String, IdlSymbol>();
        Enumeration enumeration = this.caseListVector.elements();
        while (enumeration.hasMoreElements()) {
            Case case_ = (Case)enumeration.nextElement();
            case_.parse();
            IdlSymbol[] idlSymbolArray = case_.getLabels();
            for (int i = 0; i < idlSymbolArray.length; ++i) {
                if (idlSymbolArray[i] == null) continue;
                IdlSymbol idlSymbol = (IdlSymbol)hashMap.get(idlSymbolArray[i].toString());
                if (idlSymbol != null) {
                    parser.error("Duplicate case label <" + idlSymbol.toString() + ">", idlSymbol.get_token());
                }
                hashMap.put(idlSymbolArray[i].toString(), idlSymbolArray[i]);
            }
        }
        hashMap.clear();
        this.ts.parse();
        this.myUnion.addImportedName(this.ts.typeName());
    }

    public void print(PrintWriter printWriter) {
        Enumeration enumeration = this.caseListVector.elements();
        while (enumeration.hasMoreElements()) {
            Case case_ = (Case)enumeration.nextElement();
            case_.print(printWriter);
        }
    }
}

