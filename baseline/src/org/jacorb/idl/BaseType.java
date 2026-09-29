/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.SimpleTypeSpec;
import org.jacorb.idl.SwitchTypeSpec;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.parser;

public class BaseType
extends SimpleTypeSpec {
    public BaseType(int n) {
        super(n);
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
    }

    public TypeSpec typeSpec() {
        return this.type_spec.typeSpec();
    }

    public boolean basic() {
        return this.type_spec.basic();
    }

    public boolean isSwitchType() {
        return this.type_spec instanceof SwitchTypeSpec && ((SwitchTypeSpec)((Object)this.type_spec)).isSwitchable();
    }

    public void parse() {
    }

    public static boolean isBasicName(String string) {
        int n = string.indexOf(91);
        String string2 = string.substring(0, n == -1 ? string.length() : n);
        return string2.equals("long") || string2.equals("int") || string2.equals("short") || string2.equals("float") || string2.equals("double") || string2.equals("byte") || string2.equals("boolean") || string2.equals("char") || string2.equals("java.lang.String");
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
    }

    public int getTCKind() {
        return ((BaseType)this.type_spec).getTCKind();
    }

    protected String typeCodeExpressionSkeleton(int n) {
        return "org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(" + n + "))";
    }

    public String getTypeCodeExpression() {
        return this.typeCodeExpressionSkeleton(this.getTCKind());
    }

    public String toString() {
        if (this.type_spec != null) {
            return this.type_spec.toString();
        }
        return "BaseType";
    }

    public String typeName() {
        return this.type_spec.typeName();
    }

    public String id() {
        return "IDL:*primitive*:1.0";
    }

    public void print(PrintWriter printWriter) {
    }
}

