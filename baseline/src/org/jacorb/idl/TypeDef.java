/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;
import org.jacorb.idl.AliasTypeSpec;
import org.jacorb.idl.ArrayDeclarator;
import org.jacorb.idl.ArrayTypeSpec;
import org.jacorb.idl.Declarator;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.TypeDeclarator;
import org.jacorb.idl.TypeMap;
import org.jacorb.idl.parser;

public class TypeDef
extends TypeDeclaration {
    public TypeDeclarator type_declarator;
    private Vector typeSpecs = new Vector();

    public TypeDef(int n) {
        super(n);
        this.pack_name = "";
    }

    public Vector getTypeSpecs() {
        return this.typeSpecs;
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        this.type_declarator.setPackage(string);
    }

    public void set_included(boolean bl) {
        this.included = bl;
    }

    public String id() {
        return this.type_declarator.id();
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            if (this.logger.isErrorEnabled()) {
                this.logger.error("Typedef.setEnclosingSymbol: was " + this.enclosing_symbol.getClass().getName() + " now: " + idlSymbol.getClass().getName());
            }
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
        this.type_declarator.setEnclosingSymbol(idlSymbol);
    }

    public void parse() {
        Enumeration enumeration = this.type_declarator.declarators.v.elements();
        while (enumeration.hasMoreElements()) {
            Declarator declarator = (Declarator)enumeration.nextElement();
            declarator.escapeName();
            try {
                AliasTypeSpec aliasTypeSpec = new AliasTypeSpec(this.type_declarator.type_spec());
                if (declarator.d instanceof ArrayDeclarator) {
                    aliasTypeSpec = new AliasTypeSpec(new ArrayTypeSpec(TypeDef.new_num(), aliasTypeSpec.originalType(), (ArrayDeclarator)declarator.d, this.pack_name));
                    aliasTypeSpec.parse();
                } else if (!enumeration.hasMoreElements()) {
                    aliasTypeSpec.parse();
                }
                aliasTypeSpec.set_name(declarator.name());
                aliasTypeSpec.setPackage(this.pack_name);
                aliasTypeSpec.setEnclosingSymbol(this.enclosing_symbol);
                aliasTypeSpec.set_token(declarator.d.get_token());
                aliasTypeSpec.set_included(this.included);
                this.typeSpecs.addElement(aliasTypeSpec);
                NameTable.define(declarator.full_name(), "type");
                TypeMap.typedef(declarator.full_name(), aliasTypeSpec);
            }
            catch (NameAlreadyDefined nameAlreadyDefined) {
                parser.error("TypeDef'd name " + declarator.name() + " already defined. ", declarator.token);
            }
        }
    }

    public void print(PrintWriter printWriter) {
        if (this.included && !this.generateIncluded()) {
            return;
        }
        Enumeration enumeration = this.typeSpecs.elements();
        while (enumeration.hasMoreElements()) {
            ((AliasTypeSpec)enumeration.nextElement()).print(printWriter);
        }
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        Enumeration enumeration = this.typeSpecs.elements();
        while (enumeration.hasMoreElements()) {
            ((AliasTypeSpec)enumeration.nextElement()).accept(iDLTreeVisitor);
        }
        iDLTreeVisitor.visitTypeDef(this);
    }
}

