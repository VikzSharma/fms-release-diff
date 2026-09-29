/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.Declarator;
import org.jacorb.idl.Member;

public class StateMember
extends Member {
    public boolean isPublic = false;

    public StateMember(int n) {
        super(n);
    }

    public Member extractMember(Declarator declarator) {
        StateMember stateMember = new StateMember(StateMember.new_num());
        stateMember.declarator = declarator;
        stateMember.isPublic = this.isPublic;
        return stateMember;
    }

    public void print(PrintWriter printWriter) {
        if (this.isPublic) {
            this.member_print(printWriter, "\tpublic ");
        } else {
            this.member_print(printWriter, "\tprotected ");
        }
    }

    public String writeStatement(String string) {
        return this.type_spec.printWriteStatement(this.declarator.name(), string);
    }

    public String readStatement(String string) {
        return this.type_spec.printReadStatement(this.declarator.name(), string);
    }
}

