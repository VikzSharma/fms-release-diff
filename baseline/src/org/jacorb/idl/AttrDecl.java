/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.jacorb.idl.Declaration;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.Method;
import org.jacorb.idl.RaisesExpr;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.SimpleDeclarator;
import org.jacorb.idl.SymbolList;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.parser;

public class AttrDecl
extends Declaration {
    public boolean readOnly;
    public TypeSpec param_type_spec;
    public SymbolList declarators;
    public RaisesExpr getRaisesExpr;
    public RaisesExpr setRaisesExpr;
    private Vector operations = new Vector();

    public AttrDecl(int n) {
        super(n);
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        this.declarators.setPackage(string);
        this.param_type_spec.setPackage(string);
        this.getRaisesExpr.setPackage(string);
        this.setRaisesExpr.setPackage(string);
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
        this.getRaisesExpr.setEnclosingSymbol(idlSymbol);
        this.setRaisesExpr.setEnclosingSymbol(idlSymbol);
    }

    public void parse() {
        Object object;
        IdlSymbol idlSymbol = this.enclosing_symbol;
        if (this.param_type_spec.typeSpec() instanceof ScopedName) {
            object = ((ScopedName)this.param_type_spec.typeSpec()).resolvedTypeSpec();
            if (object != null) {
                this.param_type_spec = object;
            }
            idlSymbol.addImportedName(((TypeSpec)object).typeName());
        }
        if (parser.strict_attributes) {
            this.declarators.parse();
        }
        this.getRaisesExpr.parse();
        this.setRaisesExpr.parse();
        object = this.declarators.v.elements();
        while (object.hasMoreElements()) {
            this.operations.addElement(new Method(this.param_type_spec, null, ((SimpleDeclarator)object.nextElement()).name(), this.getRaisesExpr, this.is_pseudo));
        }
        if (!this.readOnly) {
            object = this.declarators.v.elements();
            while (object.hasMoreElements()) {
                SimpleDeclarator simpleDeclarator = (SimpleDeclarator)object.nextElement();
                this.operations.addElement(new Method(null, this.param_type_spec, simpleDeclarator.name(), this.setRaisesExpr, this.is_pseudo));
            }
        }
    }

    public void print(PrintWriter printWriter) {
    }

    public Enumeration getOperations() {
        return this.operations.elements();
    }

    public void getIRInfo(Hashtable hashtable) {
        Enumeration enumeration = this.declarators.v.elements();
        while (enumeration.hasMoreElements()) {
            String string = this.param_type_spec.full_name();
            hashtable.put(((SimpleDeclarator)enumeration.nextElement()).name(), "attribute" + (this.readOnly ? "" : "-w") + ";" + (string != null ? string : this.param_type_spec.typeName()));
        }
    }
}

