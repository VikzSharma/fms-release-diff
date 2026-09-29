/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.parser;

public class ExceptionHolderTypeSpec
extends TypeSpec {
    public ExceptionHolderTypeSpec(int n) {
        super(n);
    }

    public Object clone() {
        return this;
    }

    public String typeName() {
        return "org.omg.Messaging.ExceptionHolder";
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

    public String id() {
        return "IDL:omg.org/Messaging/ExceptionHolder:1.0";
    }

    public String toString() {
        return "org.omg.Messaging.ExceptionHolder";
    }

    public String getTypeCodeExpression() {
        return "org.omg.CORBA.ORB.init().create_value_tc(\"IDL:omg.org/Messaging/ExceptionHolder:1.0\",\"ExceptionHolder\", (short)0, null,new org.omg.CORBA.ValueMember[] {new org.omg.CORBA.ValueMember (\"\", \"IDL:*primitive*:1.0\",\"ExceptionHolder\", \"1.0\", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(8)), null, (short)0),new org.omg.CORBA.ValueMember (\"\", \"IDL:*primitive*:1.0\",\"ExceptionHolder\", \"1.0\", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(8)), null, (short)0),new org.omg.CORBA.ValueMember (\"\", \"IDL:marshaled_exception:1.0\",\"ExceptionHolder\", \"1.0\", org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(10)) ), null, (short)0)});";
    }

    public void print(PrintWriter printWriter) {
    }

    public String holderName() {
        return this.typeName() + "Holder";
    }

    public String printWriteStatement(String string, String string2) {
        return "((org.omg.CORBA_2_3.portable.OutputStream)" + string2 + ")" + ".write_value (" + string + " );";
    }

    public String printReadExpression(String string) {
        return "(" + this.typeName() + ")" + "((org.omg.CORBA_2_3.portable.InputStream)" + string + ")" + ".read_value (\"" + this.id() + "\")";
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        String string3 = this.typeName() + "Helper";
        printWriter.println("\t\t" + string3 + ".insert(" + string + ", " + string2 + " );");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        throw new RuntimeException("ExceptionHolderTypeSpec.printExtractResult: Should not be called");
    }
}

