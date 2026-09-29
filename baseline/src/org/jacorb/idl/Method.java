/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.Operation;
import org.jacorb.idl.RaisesExpr;
import org.jacorb.idl.TypeSpec;

public class Method
implements Operation {
    public TypeSpec resultType;
    public TypeSpec parameterType;
    private String name;
    private RaisesExpr raisesExpr;
    private boolean pseudo;

    public Method(TypeSpec typeSpec, TypeSpec typeSpec2, String string, RaisesExpr raisesExpr, boolean bl) {
        this.resultType = typeSpec;
        this.parameterType = typeSpec2;
        this.name = string;
        this.raisesExpr = raisesExpr;
        this.pseudo = bl;
    }

    public boolean isGetter() {
        return this.resultType != null;
    }

    public String name() {
        return this.name;
    }

    public String opName() {
        if (this.isGetter()) {
            return "_get_" + this.name;
        }
        return "_set_" + this.name;
    }

    public String signature() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.name + "(");
        if (this.parameterType != null) {
            stringBuffer.append(this.parameterType.toString());
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    public void printSignature(PrintWriter printWriter) {
        this.printSignature(printWriter, this.pseudo);
    }

    public void printSignature(PrintWriter printWriter, boolean bl) {
        printWriter.print("\t");
        if (bl) {
            printWriter.print("public abstract ");
        }
        if (this.isGetter()) {
            printWriter.print(this.resultType.toString());
            printWriter.print(" " + this.name + "()");
            this.raisesExpr.print(printWriter);
            printWriter.println(";");
        } else {
            printWriter.print("void " + this.name + "(");
            printWriter.print(this.parameterType.toString());
            printWriter.print(" arg)");
            this.raisesExpr.print(printWriter);
            printWriter.println(";");
        }
    }

    public void printMethod(PrintWriter printWriter, String string, boolean bl, boolean bl2) {
        printWriter.print("\tpublic ");
        if (this.isGetter()) {
            printWriter.print(this.resultType.toString());
            printWriter.print(" " + this.name + "()");
            this.raisesExpr.print(printWriter);
            printWriter.println();
            printWriter.println("\t{");
            printWriter.println("\t\twhile(true)");
            printWriter.println("\t\t{");
            if (!bl) {
                printWriter.println("\t\tif(! this._is_local())");
                printWriter.println("\t\t{");
                printWriter.println("\t\t\torg.omg.CORBA.portable.InputStream _is = null;");
                printWriter.println("\t\t\ttry");
                printWriter.println("\t\t\t{");
                printWriter.println("\t\t\t\torg.omg.CORBA.portable.OutputStream _os = _request(\"_get_" + this.name + "\",true);");
                printWriter.println("\t\t\t\t_is = _invoke(_os);");
                TypeSpec typeSpec = this.resultType.typeSpec();
                printWriter.println("\t\t\t\treturn " + typeSpec.printReadExpression("_is") + ";");
                printWriter.println("\t\t\t}");
                printWriter.println("\t\t\tcatch( org.omg.CORBA.portable.RemarshalException _rx ){}");
                printWriter.println("\t\t\tcatch( org.omg.CORBA.portable.ApplicationException _ax )");
                printWriter.println("\t\t\t{");
                printWriter.println("\t\t\t\tString _id = _ax.getId();");
                if (!this.raisesExpr.empty()) {
                    String[] stringArray = this.raisesExpr.getExceptionIds();
                    String[] stringArray2 = this.raisesExpr.getExceptionClassNames();
                    printWriter.print("\t\t\t\t");
                    for (int i = 0; i < stringArray.length; ++i) {
                        if (i > 0) {
                            printWriter.print("\t\t\t\telse ");
                        }
                        printWriter.println("if( _id.equals(\"" + stringArray[i] + "\"))");
                        printWriter.println("\t\t\t\t{");
                        printWriter.println("\t\t\t\t\tthrow " + stringArray2[i] + "Helper.read(_ax.getInputStream());");
                        printWriter.println("\t\t\t\t}");
                    }
                }
                printWriter.println("\t\t\t\tthrow new RuntimeException(\"Unexpected exception \" + _id );");
                printWriter.println("\t\t\t}");
                printWriter.println("\t\t\tfinally");
                printWriter.println("\t\t\t{");
                printWriter.println("\t\t\t\tthis._releaseReply(_is);");
                printWriter.println("\t\t\t}");
                printWriter.println("\t\t}\n");
                printWriter.println("\t\telse");
                printWriter.println("\t\t{");
            }
            printWriter.println("\t\torg.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( \"_get_" + this.name + "\", _opsClass);");
            printWriter.println("\t\tif( _so == null )");
            printWriter.println("\t\t\tthrow new org.omg.CORBA.UNKNOWN(\"local invocations not supported!\");");
            if (bl2) {
                printWriter.println("\t\t\t" + string + " _localServant = (" + string + ")_so.servant;");
            } else {
                printWriter.println("\t\t\t" + string + "Operations _localServant = (" + string + "Operations)_so.servant;");
            }
            printWriter.println("\t\t\t" + this.resultType + " _result;");
            printWriter.println("\t\ttry");
            printWriter.println("\t\t{");
            printWriter.println("\t\t\t_result = _localServant." + this.name + "();");
            printWriter.println("\t\t}");
            printWriter.println("\t\tfinally");
            printWriter.println("\t\t{");
            printWriter.println("\t\t\t_servant_postinvoke(_so);");
            printWriter.println("\t\t}");
            printWriter.println("\t\treturn _result;");
            printWriter.println("\t\t}");
            if (!bl) {
                printWriter.println("\t\t}\n");
            }
            printWriter.println("\t}\n");
        } else {
            printWriter.print("void " + this.name + "(" + this.parameterType.toString());
            printWriter.print(" a)");
            this.raisesExpr.print(printWriter);
            printWriter.println();
            printWriter.println("\t{");
            printWriter.println("\t\twhile(true)");
            printWriter.println("\t\t{");
            if (!bl) {
                printWriter.println("\t\tif(! this._is_local())");
                printWriter.println("\t\t{");
                printWriter.println("\t\t\torg.omg.CORBA.portable.InputStream _is = null;");
                printWriter.println("\t\t\ttry");
                printWriter.println("\t\t\t{");
                printWriter.println("\t\t\t\torg.omg.CORBA.portable.OutputStream _os = _request(\"_set_" + this.name + "\",true);");
                printWriter.println("\t\t\t\t" + this.parameterType.typeSpec().printWriteStatement("a", "_os"));
                printWriter.println("\t\t\t\t_is = _invoke(_os);");
                printWriter.println("\t\t\t\treturn;");
                printWriter.println("\t\t\t}");
                printWriter.println("\t\t\tcatch( org.omg.CORBA.portable.RemarshalException _rx ){}");
                printWriter.println("\t\t\tcatch( org.omg.CORBA.portable.ApplicationException _ax )");
                printWriter.println("\t\t\t{");
                printWriter.println("\t\t\t\tString _id = _ax.getId();");
                if (!this.raisesExpr.empty()) {
                    String[] stringArray = this.raisesExpr.getExceptionIds();
                    String[] stringArray3 = this.raisesExpr.getExceptionClassNames();
                    printWriter.print("\t\t\t\t");
                    for (int i = 0; i < stringArray.length; ++i) {
                        if (i > 0) {
                            printWriter.print("\t\t\t\telse ");
                        }
                        printWriter.println("if( _id.equals(\"" + stringArray[i] + "\"))");
                        printWriter.println("\t\t\t\t{");
                        printWriter.println("\t\t\t\t\tthrow " + stringArray3[i] + "Helper.read(_ax.getInputStream());");
                        printWriter.println("\t\t\t\t}");
                    }
                }
                printWriter.println("\t\t\t\tthrow new RuntimeException(\"Unexpected exception \" + _id );");
                printWriter.println("\t\t\t}");
                printWriter.println("\t\t\tfinally");
                printWriter.println("\t\t\t{");
                printWriter.println("\t\t\t\tthis._releaseReply(_is);");
                printWriter.println("\t\t\t}");
                printWriter.println("\t\t}\n");
                printWriter.println("\t\telse");
                printWriter.println("\t\t{");
            }
            printWriter.println("\t\t\torg.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( \"_set_" + this.name + "\", _opsClass);");
            printWriter.println("\t\t\tif( _so == null )");
            printWriter.println("\t\t\t\tthrow new org.omg.CORBA.UNKNOWN(\"local invocations not supported!\");");
            printWriter.println("\t\t\t" + string + "Operations _localServant = (" + string + "Operations)_so.servant;");
            printWriter.println("\t\t\t\ttry");
            printWriter.println("\t\t\t\t{");
            printWriter.println("\t\t\t\t\t_localServant." + this.name + "(a);");
            printWriter.println("\t\t\t\t}");
            printWriter.println("\t\t\t\tfinally");
            printWriter.println("\t\t\t\t{");
            printWriter.println("\t\t\t\t\t_servant_postinvoke(_so);");
            printWriter.println("\t\t\t\t}");
            printWriter.println("\t\t\t\treturn;");
            printWriter.println("\t\t\t}");
            if (!bl) {
                printWriter.println("\t\t}\n");
            }
            printWriter.println("\t}\n");
        }
    }

    public void print_sendc_Method(PrintWriter printWriter, String string) {
        printWriter.print("\tpublic void sendc_");
        if (this.isGetter()) {
            printWriter.print("get_" + this.name);
            printWriter.println("(AMI_" + string + "Handler ami_handler)");
            printWriter.println("\t{");
            printWriter.println("\t\twhile(true)");
            printWriter.println("\t\t{");
            printWriter.println("\t\t\ttry");
            printWriter.println("\t\t\t{");
            printWriter.println("\t\t\t\torg.omg.CORBA.portable.OutputStream _os = _request(\"_get_" + this.name + "\",true);");
            printWriter.println("\t\t\t\t((org.jacorb.orb.Delegate)_get_delegate()).invoke(this, _os, ami_handler);");
            printWriter.println("\t\t\t\treturn;");
            printWriter.println("\t\t\t}");
            printWriter.println("\t\t\tcatch( org.omg.CORBA.portable.RemarshalException _rx ){}");
            printWriter.println("\t\t\tcatch( org.omg.CORBA.portable.ApplicationException _ax )");
            printWriter.println("\t\t\t{");
            printWriter.println("\t\t\t\tString _id = _ax.getId();");
            printWriter.println("\t\t\t\tthrow new RuntimeException(\"Unexpected exception \" + _id );");
            printWriter.println("\t\t\t}");
            printWriter.println("\t\t}");
            printWriter.println("\t}\n");
        } else {
            printWriter.print("set_" + this.name);
            printWriter.print("(AMI_" + string + "Handler ami_handler, ");
            printWriter.println(this.parameterType.toString() + " attr_" + this.name + ")");
            printWriter.println("\t{");
            printWriter.println("\t\twhile(true)");
            printWriter.println("\t\t{");
            printWriter.println("\t\t\ttry");
            printWriter.println("\t\t\t{");
            printWriter.println("\t\t\t\torg.omg.CORBA.portable.OutputStream _os = _request(\"_set_" + this.name + "\",true);");
            printWriter.println("\t\t\t\t" + this.parameterType.typeSpec().printWriteStatement("attr_" + this.name, "_os"));
            printWriter.println("\t\t\t\t((org.jacorb.orb.Delegate)_get_delegate()).invoke(this, _os, ami_handler);");
            printWriter.println("\t\t\t\treturn;");
            printWriter.println("\t\t\t}");
            printWriter.println("\t\t\tcatch( org.omg.CORBA.portable.RemarshalException _rx ){}");
            printWriter.println("\t\t\tcatch( org.omg.CORBA.portable.ApplicationException _ax )");
            printWriter.println("\t\t\t{");
            printWriter.println("\t\t\t\tString _id = _ax.getId();");
            printWriter.println("\t\t\t\tthrow new RuntimeException(\"Unexpected exception \" + _id );");
            printWriter.println("\t\t\t}");
            printWriter.println("\t\t}");
            printWriter.println("\t}\n");
        }
    }

    public void printDelegatedMethod(PrintWriter printWriter) {
        printWriter.print("\tpublic ");
        if (this.isGetter()) {
            printWriter.print(this.resultType.toString());
            printWriter.print(" " + this.name + "()");
            this.raisesExpr.print(printWriter);
            printWriter.println();
            printWriter.println("\t{");
            printWriter.println("\t\treturn _delegate." + this.name + "();");
            printWriter.println("\t}\n");
        } else {
            printWriter.print("void " + this.name + "(" + this.parameterType.toString());
            printWriter.print(" a)");
            this.raisesExpr.print(printWriter);
            printWriter.println();
            printWriter.println("\t{");
            printWriter.println("\t\t_delegate." + this.name + "(a);");
            printWriter.println("\t}\n");
        }
    }

    public void printInvocation(PrintWriter printWriter) {
        if (!this.raisesExpr.empty()) {
            printWriter.println("\t\t\ttry");
            printWriter.println("\t\t\t{");
        }
        printWriter.println("\t\t\t_out = handler.createReply();");
        printWriter.print("\t\t\t");
        if (this.isGetter()) {
            printWriter.println(this.resultType.typeSpec().printWriteStatement(this.name + "()", "_out"));
        } else {
            printWriter.println(this.name + "(" + this.parameterType.printReadExpression("_input") + ");");
        }
        if (!this.raisesExpr.empty()) {
            printWriter.println("\t\t\t}");
            String[] stringArray = this.raisesExpr.getExceptionNames();
            String[] stringArray2 = this.raisesExpr.getExceptionClassNames();
            for (int i = 0; i < stringArray.length; ++i) {
                printWriter.println("\t\t\tcatch(" + stringArray[i] + " _ex" + i + ")");
                printWriter.println("\t\t\t{");
                printWriter.println("\t\t\t\t_out = handler.createExceptionReply();");
                printWriter.println("\t\t\t\t" + stringArray2[i] + "Helper.write(_out, _ex" + i + ");");
                printWriter.println("\t\t\t}");
            }
        }
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        iDLTreeVisitor.visitMethod(this);
    }
}

