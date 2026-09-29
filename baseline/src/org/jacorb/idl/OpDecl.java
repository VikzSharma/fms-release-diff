/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.jacorb.idl.AliasTypeSpec;
import org.jacorb.idl.ArrayTypeSpec;
import org.jacorb.idl.BaseType;
import org.jacorb.idl.CharType;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.Declaration;
import org.jacorb.idl.FixedPointType;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.NoHelperException;
import org.jacorb.idl.Operation;
import org.jacorb.idl.ParamDecl;
import org.jacorb.idl.RaisesExpr;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.StringType;
import org.jacorb.idl.StructType;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.VoidTypeSpec;
import org.jacorb.idl.parser;

public class OpDecl
extends Declaration
implements Operation {
    public static final int NO_ATTRIBUTE = 0;
    public static final int ONEWAY = 1;
    public int opAttribute;
    public TypeSpec opTypeSpec;
    public Vector paramDecls;
    public RaisesExpr raisesExpr;
    public IdlSymbol myInterface;

    public OpDecl(int n) {
        super(n);
        this.paramDecls = new Vector();
    }

    public OpDecl(IdlSymbol idlSymbol, int n, TypeSpec typeSpec, String string, List list, RaisesExpr raisesExpr) {
        super(OpDecl.new_num());
        this.myInterface = idlSymbol;
        this.opAttribute = n;
        this.opTypeSpec = typeSpec;
        this.name = string;
        this.paramDecls = new Vector(list);
        this.raisesExpr = raisesExpr;
        this.setEnclosingSymbol(idlSymbol);
        this.pack_name = idlSymbol.full_name();
    }

    public OpDecl(IdlSymbol idlSymbol, String string, List list) {
        this(idlSymbol, 0, new VoidTypeSpec(OpDecl.new_num()), string, list, new RaisesExpr(OpDecl.new_num()));
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        this.opTypeSpec.setPackage(string);
        Enumeration enumeration = this.paramDecls.elements();
        while (enumeration.hasMoreElements()) {
            ((ParamDecl)enumeration.nextElement()).setPackage(string);
        }
        this.raisesExpr.setPackage(string);
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("opDecl.setEnclosingSymbol " + idlSymbol);
        }
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        if (idlSymbol == null) {
            throw new RuntimeException("Compiler Error: enclosing symbol is null!");
        }
        this.enclosing_symbol = idlSymbol;
        this.raisesExpr.setEnclosingSymbol(idlSymbol);
    }

    public void parse() {
        if (this.enclosing_symbol == null) {
            throw new RuntimeException("Compiler Error: enclosing symbol in parse is null!");
        }
        this.myInterface = this.enclosing_symbol;
        if (this.opAttribute == 1) {
            if (!this.raisesExpr.empty()) {
                parser.error("Oneway operation " + this.full_name() + " may not define a raises clause.", this.token);
            }
            if (!(this.opTypeSpec.typeSpec() instanceof VoidTypeSpec)) {
                parser.error("Oneway operation " + this.full_name() + " may only define void as return type.", this.token);
            }
        }
        try {
            NameTable.define(this.full_name(), "operation");
        }
        catch (NameAlreadyDefined nameAlreadyDefined) {
            parser.error("Operation " + this.full_name() + " already defined", this.token);
        }
        Object object = this.paramDecls.elements();
        while (object.hasMoreElements()) {
            String string;
            ParamDecl paramDecl = (ParamDecl)object.nextElement();
            String string2 = string = paramDecl.paramTypeSpec.typeName().indexOf(".") < 0 ? paramDecl.paramTypeSpec.typeName() : paramDecl.paramTypeSpec.typeName().substring(paramDecl.paramTypeSpec.typeName().lastIndexOf(".") + 1);
            if (string.toUpperCase().equals(paramDecl.simple_declarator.toString().toUpperCase())) {
                parser.error("In operation " + this.full_name() + " argument " + paramDecl.simple_declarator + " clashes with type " + paramDecl.paramTypeSpec.typeName());
            }
            paramDecl.parse();
            try {
                NameTable.define(this.full_name() + "." + paramDecl.simple_declarator.name(), "argument");
            }
            catch (NameAlreadyDefined nameAlreadyDefined) {
                parser.error("Argument " + paramDecl.simple_declarator.name() + " already defined in operation " + this.full_name(), this.token);
            }
            if (paramDecl.paramAttribute != 1) {
                this.myInterface.addImportedNameHolder(paramDecl.paramTypeSpec.holderName());
            }
            if (!(paramDecl.paramTypeSpec.typeSpec() instanceof BaseType)) {
                if (this.logger.isInfoEnabled()) {
                    this.logger.info("classname: " + paramDecl.paramTypeSpec.typeSpec().getClass().getName());
                }
                this.myInterface.addImportedName(paramDecl.paramTypeSpec.typeSpec().full_name(), paramDecl.paramTypeSpec.typeSpec());
            }
            if (!(paramDecl.paramTypeSpec.typeSpec() instanceof ConstrTypeSpec) || !(((ConstrTypeSpec)paramDecl.paramTypeSpec.typeSpec()).c_type_spec instanceof StructType) || !((StructType)((ConstrTypeSpec)paramDecl.paramTypeSpec.typeSpec()).c_type_spec).exc) continue;
            parser.error("Can't pass an exception as a parameter.");
        }
        if (this.opTypeSpec.typeSpec() instanceof ScopedName) {
            object = ((ScopedName)this.opTypeSpec.typeSpec()).resolvedTypeSpec();
            if (object != null) {
                this.opTypeSpec = object;
            }
            this.myInterface.addImportedName(this.opTypeSpec.typeName());
        }
        this.raisesExpr.parse();
    }

    public void print(PrintWriter printWriter) {
        if (this.is_pseudo) {
            printWriter.print("\tpublic abstract " + this.opTypeSpec.toString());
        } else {
            printWriter.print("\t" + this.opTypeSpec.toString());
        }
        printWriter.print(" ");
        printWriter.print(this.name);
        printWriter.print("(");
        Enumeration enumeration = this.paramDecls.elements();
        if (enumeration.hasMoreElements()) {
            ((ParamDecl)enumeration.nextElement()).print(printWriter);
        }
        while (enumeration.hasMoreElements()) {
            printWriter.print(", ");
            ((ParamDecl)enumeration.nextElement()).print(printWriter);
        }
        printWriter.print(")");
        this.raisesExpr.print(printWriter);
        printWriter.println(";");
    }

    public void printStreamBody(PrintWriter printWriter, String string, String string2, boolean bl, boolean bl2) {
        String[] stringArray;
        String[] stringArray2;
        printWriter.println("\t\twhile(true)");
        printWriter.println("\t\t{");
        if (!bl) {
            printWriter.println("\t\tif(! this._is_local())");
            printWriter.println("\t\t{");
            printWriter.println("\t\t\torg.omg.CORBA.portable.InputStream _is = null;");
            printWriter.println("\t\t\ttry");
            printWriter.println("\t\t\t{");
            printWriter.print("\t\t\t\torg.omg.CORBA.portable.OutputStream _os = _request( \"" + string2 + "\",");
            if (this.opAttribute == 0) {
                printWriter.println(" true);");
            } else {
                printWriter.println(" false);");
            }
            stringArray2 = this.paramDecls.elements();
            while (stringArray2.hasMoreElements()) {
                stringArray = (String[])stringArray2.nextElement();
                if (stringArray.paramAttribute == 2) continue;
                printWriter.println("\t\t\t\t" + stringArray.printWriteStatement("_os"));
            }
            printWriter.println("\t\t\t\t_is = _invoke(_os);");
            if (this.opAttribute == 0 && !(this.opTypeSpec.typeSpec() instanceof VoidTypeSpec)) {
                printWriter.println("\t\t\t\t" + this.opTypeSpec.toString() + " _result = " + this.opTypeSpec.typeSpec().printReadExpression("_is") + ";");
            }
            stringArray2 = this.paramDecls.elements();
            while (stringArray2.hasMoreElements()) {
                stringArray = (ParamDecl)stringArray2.nextElement();
                if (stringArray.paramAttribute == 1) continue;
                printWriter.println("\t\t\t\t" + stringArray.simple_declarator + ".value = " + stringArray.printReadExpression("_is") + ";");
            }
            if (this.opAttribute == 0 && !(this.opTypeSpec.typeSpec() instanceof VoidTypeSpec)) {
                printWriter.println("\t\t\t\treturn _result;");
            } else {
                printWriter.println("\t\t\t\treturn;");
            }
            printWriter.println("\t\t\t}");
            printWriter.println("\t\t\tcatch( org.omg.CORBA.portable.RemarshalException _rx ){}");
            printWriter.println("\t\t\tcatch( org.omg.CORBA.portable.ApplicationException _ax )");
            printWriter.println("\t\t\t{");
            printWriter.println("\t\t\t\tString _id = _ax.getId();");
            if (!this.raisesExpr.empty()) {
                stringArray2 = this.raisesExpr.getExceptionIds();
                stringArray = this.raisesExpr.getExceptionClassNames();
                printWriter.print("\t\t\t\t");
                for (int i = 0; i < stringArray2.length; ++i) {
                    if (i > 0) {
                        printWriter.print("\t\t\t\telse ");
                    }
                    printWriter.println("if( _id.equals(\"" + stringArray2[i] + "\"))");
                    printWriter.println("\t\t\t\t{");
                    printWriter.println("\t\t\t\t\tthrow " + stringArray[i] + "Helper.read(_ax.getInputStream());");
                    printWriter.println("\t\t\t\t}");
                }
            }
            printWriter.println("\t\t\t\tthrow new RuntimeException(\"Unexpected exception \" + _id );");
            printWriter.println("\t\t\t}");
            printWriter.println("\t\t\tfinally");
            printWriter.println("\t\t\t{");
            printWriter.println("\t\t\t\tthis._releaseReply(_is);");
            printWriter.println("\t\t\t}");
            printWriter.println("\t\t}");
            printWriter.println("\t\telse");
            printWriter.println("\t\t{");
        }
        printWriter.println("\t\t\torg.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( \"" + string2 + "\", _opsClass );");
        printWriter.println("\t\t\tif( _so == null )");
        printWriter.println("\t\t\t\tthrow new org.omg.CORBA.UNKNOWN(\"local invocations not supported!\");");
        if (bl2) {
            printWriter.println("\t\t\t" + string + " _localServant = (" + string + ")_so.servant;");
        } else {
            printWriter.println("\t\t\t" + string + "Operations _localServant = (" + string + "Operations)_so.servant;");
        }
        if (this.opAttribute == 0 && !(this.opTypeSpec.typeSpec() instanceof VoidTypeSpec)) {
            printWriter.println("\t\t\t" + this.opTypeSpec.toString() + " _result;");
        }
        printWriter.println("\t\t\ttry");
        printWriter.println("\t\t\t{");
        if (this.opAttribute == 0 && !(this.opTypeSpec.typeSpec() instanceof VoidTypeSpec)) {
            printWriter.print("\t\t\t\t_result = ");
        } else {
            printWriter.print("\t\t\t\t");
        }
        printWriter.print("_localServant." + this.name + "(");
        stringArray2 = this.paramDecls.elements();
        while (stringArray2.hasMoreElements()) {
            stringArray = (ParamDecl)stringArray2.nextElement();
            printWriter.print(stringArray.simple_declarator.toString());
            if (!stringArray2.hasMoreElements()) continue;
            printWriter.print(",");
        }
        printWriter.println(");");
        printWriter.println("\t\t\t}");
        printWriter.println("\t\t\tfinally");
        printWriter.println("\t\t\t{");
        printWriter.println("\t\t\t\t_servant_postinvoke(_so);");
        printWriter.println("\t\t\t}");
        if (this.opAttribute == 0 && !(this.opTypeSpec.typeSpec() instanceof VoidTypeSpec)) {
            printWriter.println("\t\t\treturn _result;");
        } else {
            printWriter.println("\t\t\treturn;");
        }
        if (!bl) {
            printWriter.println("\t\t}\n");
        }
        printWriter.println("\t\t}\n");
    }

    private void printDIIBody(PrintWriter printWriter, String string, String string2, boolean bl, boolean bl2) {
        Object object;
        printWriter.println("\t\torg.omg.CORBA.Request _request = _request( \"" + string2 + "\" );");
        printWriter.println("");
        if (this.opAttribute == 0 && !(this.opTypeSpec.typeSpec() instanceof VoidTypeSpec)) {
            if (this.opTypeSpec.typeSpec() instanceof BaseType) {
                object = (BaseType)this.opTypeSpec.typeSpec();
                printWriter.println("\t\t_request.set_return_type( " + ((BaseType)object).getTypeCodeExpression() + " );");
            } else if (this.opTypeSpec.typeSpec() instanceof StringType) {
                object = (StringType)this.opTypeSpec.typeSpec();
                printWriter.println("\t\t_request.set_return_type( " + ((StringType)object).getTypeCodeExpression() + " );");
            } else {
                try {
                    object = this.opTypeSpec.typeSpec().helperName();
                    printWriter.println("\t\t_request.set_return_type(" + (String)object + ".type()" + ");");
                }
                catch (NoHelperException noHelperException) {
                    printWriter.println("\t\t_request.set_return_type(" + this.opTypeSpec.typeSpec().getTypeCodeExpression() + ");");
                }
            }
        } else {
            printWriter.println("\t\t_request.set_return_type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));");
        }
        printWriter.println("");
        object = this.paramDecls.elements();
        while (object.hasMoreElements()) {
            ParamDecl paramDecl = (ParamDecl)object.nextElement();
            paramDecl.printAddArgumentStatement(printWriter, "_request");
            printWriter.println("");
        }
        if (!this.raisesExpr.empty()) {
            object = this.raisesExpr.getExceptionClassNames();
            for (int i = 0; i < ((String[])object).length; ++i) {
                printWriter.println("\t\t_request.exceptions().add(" + object[i] + "Helper.type());");
            }
            printWriter.println("");
        }
        printWriter.println("\t\t_request.invoke();");
        printWriter.println("");
        printWriter.println("\t\tjava.lang.Exception _exception = _request.env().exception();");
        printWriter.println("\t\tif (_exception != null)");
        printWriter.println("\t\t{");
        if (!this.raisesExpr.empty()) {
            printWriter.println("\t\t\tif(_exception instanceof org.omg.CORBA.UnknownUserException)");
            printWriter.println("\t\t\t{");
            printWriter.println("\t\t\t\torg.omg.CORBA.UnknownUserException _userException = (org.omg.CORBA.UnknownUserException) _exception;");
            printWriter.print("\t\t\t\t");
            object = this.raisesExpr.getExceptionClassNames();
            for (int i = 0; i < ((Object)object).length; ++i) {
                printWriter.println("if (_userException.except.type().equals(" + (String)object[i] + "Helper.type()))");
                printWriter.println("\t\t\t\t{");
                printWriter.println("\t\t\t\t\tthrow " + (String)object[i] + "Helper.extract(_userException.except);");
                printWriter.println("\t\t\t\t}");
                printWriter.println("\t\t\t\telse");
            }
            printWriter.println("\t\t\t\t{");
            printWriter.println("\t\t\t\t\tthrow new org.omg.CORBA.UNKNOWN();");
            printWriter.println("\t\t\t\t}");
            printWriter.println("\t\t\t}");
        }
        printWriter.println("\t\t\tthrow (org.omg.CORBA.SystemException) _exception;");
        printWriter.println("\t\t}");
        printWriter.println("");
        object = this.paramDecls.elements();
        while (object.hasMoreElements()) {
            ParamDecl paramDecl = (ParamDecl)object.nextElement();
            if (paramDecl.paramAttribute == 1) continue;
            paramDecl.printExtractArgumentStatement(printWriter);
        }
        if (this.opAttribute == 0 && !(this.opTypeSpec.typeSpec() instanceof VoidTypeSpec)) {
            printWriter.println("\t\t" + this.opTypeSpec.toString() + " _result;");
            this.opTypeSpec.typeSpec().printExtractResult(printWriter, "_result", "_request.return_value()", this.opTypeSpec.toString());
            printWriter.println("\t\treturn _result;");
        } else {
            printWriter.println("\t\treturn;");
        }
    }

    public void printMethod(PrintWriter printWriter, String string, boolean bl, boolean bl2) {
        String string2 = this.name.startsWith("_") ? this.name.substring(1) : this.name;
        printWriter.print("\tpublic " + this.opTypeSpec.toString() + " " + this.name + "(");
        Enumeration enumeration = this.paramDecls.elements();
        if (enumeration.hasMoreElements()) {
            ((ParamDecl)enumeration.nextElement()).print(printWriter);
        }
        while (enumeration.hasMoreElements()) {
            printWriter.print(", ");
            ((ParamDecl)enumeration.nextElement()).print(printWriter);
        }
        printWriter.print(")");
        this.raisesExpr.print(printWriter);
        printWriter.println("\n\t{");
        if (parser.generateDiiStubs) {
            this.printDIIBody(printWriter, string, string2, bl, bl2);
        } else {
            this.printStreamBody(printWriter, string, string2, bl, bl2);
        }
        printWriter.println("\t}\n");
    }

    public void print_sendc_Method(PrintWriter printWriter, String string) {
        ParamDecl paramDecl;
        String string2 = this.name.startsWith("_") ? this.name.substring(1) : this.name;
        printWriter.print("\tpublic void sendc_" + this.name + "(");
        printWriter.print("AMI_" + string + "Handler ami_handler");
        Iterator iterator = this.paramDecls.iterator();
        while (iterator.hasNext()) {
            paramDecl = (ParamDecl)iterator.next();
            if (paramDecl.paramAttribute == 2) continue;
            printWriter.print(", ");
            paramDecl.asIn().print(printWriter);
        }
        printWriter.print(")");
        printWriter.println("\n\t{");
        printWriter.println("\t\twhile(true)");
        printWriter.println("\t\t{");
        printWriter.println("\t\t\ttry");
        printWriter.println("\t\t\t{");
        printWriter.print("\t\t\t\torg.omg.CORBA.portable.OutputStream _os = _request( \"" + string2 + "\",");
        if (this.opAttribute == 0) {
            printWriter.println(" true);");
        } else {
            printWriter.println(" false);");
        }
        iterator = this.paramDecls.iterator();
        while (iterator.hasNext()) {
            paramDecl = (ParamDecl)iterator.next();
            if (paramDecl.paramAttribute == 2) continue;
            printWriter.println("\t\t\t\t" + paramDecl.asIn().printWriteStatement("_os"));
        }
        printWriter.println("\t\t\t\t((org.jacorb.orb.Delegate)_get_delegate()).invoke(this, _os, ami_handler);");
        printWriter.println("\t\t\t\treturn;");
        printWriter.println("\t\t\t}");
        printWriter.println("\t\t\tcatch( org.omg.CORBA.portable.RemarshalException _rx )");
        printWriter.println("\t\t\t{");
        printWriter.println("\t\t\t}");
        printWriter.println("\t\t\tcatch( org.omg.CORBA.portable.ApplicationException _ax )");
        printWriter.println("\t\t\t{");
        printWriter.println("\t\t\t}");
        printWriter.println("\t\t}\n");
        printWriter.println("\t}\n");
    }

    public void printDelegatedMethod(PrintWriter printWriter) {
        printWriter.print("\tpublic " + this.opTypeSpec.toString() + " " + this.name + "(");
        Enumeration enumeration = this.paramDecls.elements();
        if (enumeration.hasMoreElements()) {
            ((ParamDecl)enumeration.nextElement()).print(printWriter);
        }
        while (enumeration.hasMoreElements()) {
            printWriter.print(", ");
            ((ParamDecl)enumeration.nextElement()).print(printWriter);
        }
        printWriter.print(")");
        this.raisesExpr.print(printWriter);
        printWriter.println("\n\t{");
        if (this.opAttribute == 0 && !(this.opTypeSpec.typeSpec() instanceof VoidTypeSpec)) {
            printWriter.print("\t\treturn ");
        }
        printWriter.print("_delegate." + this.name + "(");
        enumeration = this.paramDecls.elements();
        if (enumeration.hasMoreElements()) {
            printWriter.print(((ParamDecl)enumeration.nextElement()).simple_declarator);
        }
        while (enumeration.hasMoreElements()) {
            printWriter.print(",");
            printWriter.print(((ParamDecl)enumeration.nextElement()).simple_declarator);
        }
        printWriter.println(");");
        printWriter.println("\t}\n");
    }

    public void printInvocation(PrintWriter printWriter) {
        String[] stringArray;
        int n;
        Object object;
        Object object2;
        if (!this.raisesExpr.empty()) {
            printWriter.println("\t\t\ttry");
            printWriter.println("\t\t\t{");
        }
        int n2 = 0;
        boolean bl = false;
        Enumeration enumeration = this.paramDecls.elements();
        while (enumeration.hasMoreElements()) {
            object2 = (ParamDecl)enumeration.nextElement();
            object = ((ParamDecl)object2).paramTypeSpec.typeSpec();
            boolean bl2 = object instanceof StringType && ((StringType)object).isWide();
            int n3 = n = object instanceof CharType && ((CharType)object).isWide() ? 1 : 0;
            if (((ParamDecl)object2).paramAttribute == 1) {
                printWriter.println("\t\t\t\t" + ((TypeSpec)object).toString() + " _arg" + n2++ + "=" + ((TypeSpec)object).printReadExpression("_input") + ";");
                continue;
            }
            bl = true;
            printWriter.println("\t\t\t\t" + ((TypeSpec)object).holderName() + " _arg" + n2++ + "= new " + ((TypeSpec)object).holderName() + "();");
            if (((ParamDecl)object2).paramAttribute != 3) continue;
            if (n != 0) {
                printWriter.println("\t\t\t\t_arg" + (n2 - 1) + ".value = _input.read_wchar ();");
                continue;
            }
            if (bl2) {
                printWriter.println("\t\t\t\t_arg" + (n2 - 1) + ".value = _input.read_wstring ();");
                continue;
            }
            printWriter.println("\t\t\t\t_arg" + (n2 - 1) + "._read (_input);");
        }
        boolean bl3 = this.opTypeSpec.typeSpec() instanceof ArrayTypeSpec || this.opTypeSpec.typeSpec() instanceof FixedPointType;
        object2 = null;
        object = null;
        String string = null;
        printWriter.println("\t\t\t\t_out = handler.createReply();");
        if (!(this.opTypeSpec.typeSpec() instanceof VoidTypeSpec) && !bl3) {
            object2 = this.opTypeSpec.typeSpec().printWriteStatement("**", "_out");
            n = ((String)object2).indexOf("**");
            object = ((String)object2).substring(0, n);
            string = ((String)object2).substring(n + 2);
            printWriter.print("\t\t\t\t" + (String)object);
        } else {
            printWriter.print("\t\t\t\t");
        }
        if (bl3) {
            printWriter.print(this.opTypeSpec.typeSpec().typeName() + " _result = ");
        }
        printWriter.print(this.name + "(");
        for (n = 0; n < n2; ++n) {
            printWriter.print("_arg" + n);
            if (n >= n2 - 1) continue;
            printWriter.print(",");
        }
        if (!(this.opTypeSpec.typeSpec() instanceof VoidTypeSpec)) {
            printWriter.print(")");
        }
        if (!bl3) {
            if (this.opTypeSpec.typeSpec() instanceof VoidTypeSpec) {
                printWriter.println(");");
            } else {
                printWriter.println(string);
            }
        } else {
            printWriter.println(";");
            printWriter.println(this.opTypeSpec.typeSpec().printWriteStatement("_result", "_out"));
        }
        n2 = 0;
        String[] stringArray2 = this.paramDecls.elements();
        while (stringArray2.hasMoreElements()) {
            stringArray = (String[])stringArray2.nextElement();
            TypeSpec typeSpec = stringArray.paramTypeSpec;
            if (stringArray.paramAttribute != 1) {
                printWriter.println("\t\t\t\t" + stringArray.printWriteStatement("_arg" + n2, "_out"));
            }
            ++n2;
        }
        if (!this.raisesExpr.empty()) {
            printWriter.println("\t\t\t}");
            stringArray2 = this.raisesExpr.getExceptionNames();
            stringArray = this.raisesExpr.getExceptionClassNames();
            for (int i = 0; i < stringArray2.length; ++i) {
                printWriter.println("\t\t\tcatch(" + stringArray2[i] + " _ex" + i + ")");
                printWriter.println("\t\t\t{");
                printWriter.println("\t\t\t\t_out = handler.createExceptionReply();");
                printWriter.println("\t\t\t\t" + stringArray[i] + "Helper.write(_out, _ex" + i + ");");
                printWriter.println("\t\t\t}");
            }
        }
    }

    public String signature() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.name + "(");
        Enumeration enumeration = this.paramDecls.elements();
        if (enumeration.hasMoreElements()) {
            stringBuffer.append(((ParamDecl)enumeration.nextElement()).paramTypeSpec.toString());
        }
        while (enumeration.hasMoreElements()) {
            stringBuffer.append("," + ((ParamDecl)enumeration.nextElement()).paramTypeSpec.toString());
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    public String name() {
        return this.name;
    }

    public String opName() {
        return this.name();
    }

    public void printSignature(PrintWriter printWriter) {
        this.printSignature(printWriter, false);
    }

    public void printSignature(PrintWriter printWriter, boolean bl) {
        printWriter.print("\t");
        if (bl) {
            printWriter.print("public abstract ");
        }
        printWriter.print(this.opTypeSpec.toString() + " " + this.name + "(");
        Enumeration enumeration = this.paramDecls.elements();
        while (enumeration.hasMoreElements()) {
            ((ParamDecl)enumeration.nextElement()).print(printWriter);
            if (!enumeration.hasMoreElements()) continue;
            printWriter.print(", ");
        }
        printWriter.print(")");
        this.raisesExpr.print(printWriter);
        printWriter.println(";");
    }

    public void getIRInfo(Hashtable hashtable) {
        StringBuffer stringBuffer = new StringBuffer();
        TypeSpec typeSpec = this.opTypeSpec.typeSpec();
        if (typeSpec instanceof AliasTypeSpec) {
            stringBuffer.append(typeSpec.full_name());
        }
        stringBuffer.append("(");
        Enumeration enumeration = this.paramDecls.elements();
        while (enumeration.hasMoreElements()) {
            ParamDecl paramDecl = (ParamDecl)enumeration.nextElement();
            if (paramDecl.paramAttribute == 3) {
                stringBuffer.append("inout:" + paramDecl.simple_declarator.name + " ");
            } else if (paramDecl.paramAttribute == 2) {
                stringBuffer.append("out:" + paramDecl.simple_declarator.name + " ");
            } else {
                stringBuffer.append("in:" + paramDecl.simple_declarator.name + " ");
            }
            typeSpec = paramDecl.paramTypeSpec.typeSpec();
            if (typeSpec instanceof AliasTypeSpec) {
                stringBuffer.append(typeSpec.full_name());
            }
            stringBuffer.append(",");
        }
        if (this.paramDecls.size() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        stringBuffer.append(")");
        if (this.opAttribute == 1) {
            stringBuffer.append("-oneway");
        }
        hashtable.put(this.name, stringBuffer.toString());
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("OpInfo for " + this.name + " : " + stringBuffer.toString());
        }
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        iDLTreeVisitor.visitOpDecl(this);
    }
}

