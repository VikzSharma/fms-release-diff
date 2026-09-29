/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jacorb.idl.AttrDecl;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.Declaration;
import org.jacorb.idl.Definition;
import org.jacorb.idl.ExceptionHolderTypeSpec;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.Interface;
import org.jacorb.idl.InterfaceBody;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.OpDecl;
import org.jacorb.idl.ParamDecl;
import org.jacorb.idl.ReplyHandlerTypeSpec;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.SimpleDeclarator;
import org.jacorb.idl.SymbolList;
import org.jacorb.idl.TypeMap;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.VoidTypeSpec;
import org.jacorb.idl.parser;

public class ReplyHandler
extends Interface {
    public ReplyHandler(Interface interface_) {
        super(ReplyHandler.new_num());
        this.name = "AMI_" + interface_.name + "Handler";
        this.pack_name = interface_.pack_name;
        this.createInheritanceSpec(interface_.inheritanceSpec);
        this.body = new InterfaceBody(ReplyHandler.new_num());
        this.body.set_name(this.name);
        this.body.my_interface = this;
        this.body.setEnclosingSymbol(this);
        this.body.inheritance_spec = this.inheritanceSpec;
        this.createOperations(interface_);
    }

    private void createInheritanceSpec(SymbolList symbolList) {
        this.inheritanceSpec = new SymbolList(ReplyHandler.new_num());
        if (symbolList.v.isEmpty()) {
            ScopedName scopedName = new ScopedName(ReplyHandler.new_num());
            scopedName.pack_name = "org.omg.Messaging";
            scopedName.typeName = "ReplyHandler";
            this.inheritanceSpec.v.add(scopedName);
        } else {
            Iterator iterator = symbolList.v.iterator();
            while (iterator.hasNext()) {
                ScopedName scopedName = (ScopedName)iterator.next();
                ScopedName scopedName2 = new ScopedName(ReplyHandler.new_num());
                StringBuffer stringBuffer = new StringBuffer(scopedName.typeName());
                int n = stringBuffer.lastIndexOf(".") + 1;
                stringBuffer.insert(n, "AMI_");
                stringBuffer.append("Handler");
                scopedName2.typeName = stringBuffer.toString();
                this.inheritanceSpec.v.add(scopedName2);
            }
        }
    }

    private void createOperations(Interface interface_) {
        Iterator iterator = interface_.body.v.iterator();
        while (iterator.hasNext()) {
            Declaration declaration = ((Definition)iterator.next()).get_declaration();
            if (declaration instanceof OpDecl) {
                this.createOperationsFor((OpDecl)declaration);
                continue;
            }
            if (!(declaration instanceof AttrDecl)) continue;
            this.createOperationsFor((AttrDecl)declaration);
        }
    }

    private void createOperationsFor(OpDecl opDecl) {
        ArrayList<ParamDecl> arrayList = new ArrayList<ParamDecl>();
        if (!(opDecl.opTypeSpec.type_spec instanceof VoidTypeSpec)) {
            arrayList.add(new ParamDecl(1, opDecl.opTypeSpec, "ami_return_val"));
        }
        Iterator iterator = opDecl.paramDecls.iterator();
        while (iterator.hasNext()) {
            ParamDecl paramDecl = (ParamDecl)iterator.next();
            if (paramDecl.paramAttribute == 1) continue;
            arrayList.add(new ParamDecl(1, paramDecl.paramTypeSpec, paramDecl.simple_declarator));
        }
        this.body.addDefinition(new OpDecl(this, opDecl.name, arrayList));
        this.body.addDefinition(new OpDecl(this, opDecl.name + "_excep", this.excepParameterList()));
    }

    private void createOperationsFor(AttrDecl attrDecl) {
        Iterator iterator = attrDecl.declarators.v.iterator();
        while (iterator.hasNext()) {
            SimpleDeclarator simpleDeclarator = (SimpleDeclarator)iterator.next();
            this.body.addDefinition(new OpDecl(this, "get_" + simpleDeclarator.name, this.parameterList(attrDecl.param_type_spec, "ami_return_val")));
            this.body.addDefinition(new OpDecl(this, "get_" + simpleDeclarator.name + "_excep", this.excepParameterList()));
            if (attrDecl.readOnly) continue;
            this.body.addDefinition(new OpDecl(this, "set_" + simpleDeclarator.name, new ArrayList()));
            this.body.addDefinition(new OpDecl(this, "set_" + simpleDeclarator.name + "_excep", this.excepParameterList()));
        }
    }

    private List parameterList(TypeSpec typeSpec, String string) {
        ArrayList<ParamDecl> arrayList = new ArrayList<ParamDecl>();
        arrayList.add(new ParamDecl(1, typeSpec, string));
        return arrayList;
    }

    private List excepParameterList() {
        return this.parameterList(new ExceptionHolderTypeSpec(ReplyHandler.new_num()), "excep_holder");
    }

    public String id() {
        return "IDL:" + this.full_name().replace('.', '/') + ":1.0";
    }

    public void parse() {
        if (!NameTable.isDefined("org.omg.Messaging.ReplyHandler")) {
            try {
                NameTable.define("org.omg.Messaging.ReplyHandler", "type");
                TypeMap.typedef("org.omg.Messaging.ReplyHandler", new ReplyHandlerTypeSpec(IdlSymbol.new_num()));
            }
            catch (Exception exception) {
                throw new RuntimeException(exception.toString());
            }
        }
        ConstrTypeSpec constrTypeSpec = new ConstrTypeSpec(this);
        try {
            NameTable.define(this.full_name(), "interface");
            TypeMap.typedef(this.full_name(), constrTypeSpec);
        }
        catch (NameAlreadyDefined nameAlreadyDefined) {
            parser.error("Interface " + this.typeName() + " already defined", this.token);
        }
        this.body.parse();
    }

    public void print(PrintWriter printWriter) {
        this.printInterface();
        this.printOperations();
        this.printStub();
        this.printHelper();
        this.printImplSkeleton();
        this.printTieSkeleton();
    }
}

