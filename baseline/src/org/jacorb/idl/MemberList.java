/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.util.Enumeration;
import java.util.Vector;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.Member;
import org.jacorb.idl.SymbolList;
import org.jacorb.idl.TypeDeclaration;

public class MemberList
extends SymbolList {
    Vector extendVector = new Vector();
    private TypeDeclaration containingType;
    private boolean parsed = false;

    public MemberList(int n) {
        super(n);
    }

    public void setContainingType(TypeDeclaration typeDeclaration) {
        this.containingType = typeDeclaration;
        Enumeration enumeration = this.v.elements();
        while (enumeration.hasMoreElements()) {
            Member member = (Member)enumeration.nextElement();
            member.setContainingType(typeDeclaration);
        }
    }

    public void parse() {
        if (this.parsed) {
            throw new RuntimeException("Compiler error: MemberList already parsed!");
        }
        Enumeration enumeration = this.v.elements();
        while (enumeration.hasMoreElements()) {
            Member member = (Member)enumeration.nextElement();
            member.setExtendVector(this.extendVector);
            member.parse();
        }
        this.v = this.extendVector;
        this.parsed = true;
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            this.logger.error("was " + this.enclosing_symbol.getClass().getName() + " now: " + idlSymbol.getClass().getName());
            throw new RuntimeException("Compiler Error: trying to reassign container");
        }
        this.enclosing_symbol = idlSymbol;
        Enumeration enumeration = this.v.elements();
        while (enumeration.hasMoreElements()) {
            Member member = (Member)enumeration.nextElement();
            member.setEnclosingSymbol(idlSymbol);
        }
    }
}

