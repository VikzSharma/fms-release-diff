/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.BaseType;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.parser;

class AbstractBase
extends BaseType {
    public AbstractBase(int n) {
        super(n);
    }

    public Object clone() {
        return this;
    }

    public String typeName() {
        return "java.lang.Object";
    }

    public TypeSpec typeSpec() {
        return this;
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
    }

    public boolean basic() {
        return true;
    }

    public void set_constr(TypeDeclaration typeDeclaration) {
    }

    public void parse() {
    }

    public String toString() {
        return this.typeName();
    }

    public String getTypeCodeExpression() {
        return "org.omg.CORBA.ORB.init().create_value_tc(\"" + this.id() + "\",\"AbstractBase\", org.omg.CORBA.VM_NONE.value, org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_null), new org.omg.CORBA.ValueMember[]{} )";
    }

    public String id() {
        return "IDL:omg.org/CORBA/AbstractBase:1.0";
    }

    public void print(PrintWriter printWriter) {
    }

    public String holderName() {
        return this.typeName() + "Holder";
    }

    public String printReadExpression(String string) {
        return "((org.omg.CORBA_2_3.portable.InputStream)" + string + ").read_Abstract()";
    }

    public String printWriteStatement(String string, String string2) {
        return "((org.omg.CORBA_2_3.portable.OutputStream)" + string2 + ").write_Abstract(" + string + ");";
    }
}

