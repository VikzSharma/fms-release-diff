/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Enumeration;
import org.jacorb.idl.AliasTypeSpec;
import org.jacorb.idl.BaseType;
import org.jacorb.idl.BooleanType;
import org.jacorb.idl.CharType;
import org.jacorb.idl.ConstExpr;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.ElementSpec;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.IntType;
import org.jacorb.idl.Literal;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.SymbolList;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.UnionType;
import org.jacorb.idl.parser;

public class Case
extends IdlSymbol {
    public SymbolList case_label_list = null;
    private IdlSymbol[] labels;
    public ElementSpec element_spec = null;
    TypeSpec type_spec = null;

    public Case(int n) {
        super(n);
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        this.element_spec.setPackage(string);
        Enumeration enumeration = this.case_label_list.v.elements();
        while (enumeration.hasMoreElements()) {
            IdlSymbol idlSymbol = (IdlSymbol)enumeration.nextElement();
            if (idlSymbol == null) continue;
            idlSymbol.setPackage(string);
        }
        if (this.type_spec != null) {
            this.type_spec.setPackage(string);
        }
    }

    public void setUnion(UnionType unionType) {
        this.element_spec.setUnion(unionType);
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
        this.element_spec.setEnclosingSymbol(idlSymbol);
    }

    public void setTypeSpec(TypeSpec typeSpec) {
        this.type_spec = typeSpec;
        this.type_spec.setPackage(this.pack_name);
    }

    private String enumTypeName() {
        if (this.type_spec.type_spec instanceof ConstrTypeSpec) {
            return ((ConstrTypeSpec)this.type_spec.type_spec).full_name();
        }
        if (this.type_spec.type_spec instanceof ScopedName) {
            TypeSpec typeSpec = ((ScopedName)this.type_spec.type_spec).resolvedTypeSpec();
            while (typeSpec instanceof ScopedName || typeSpec instanceof AliasTypeSpec) {
                if (typeSpec instanceof ScopedName) {
                    typeSpec = ((ScopedName)typeSpec).resolvedTypeSpec();
                }
                if (!(typeSpec instanceof AliasTypeSpec)) continue;
                typeSpec = ((AliasTypeSpec)typeSpec).originalType();
            }
            if (typeSpec instanceof ConstrTypeSpec) {
                return ((ConstrTypeSpec)typeSpec).c_type_spec.full_name();
            }
        }
        return null;
    }

    public void parse() {
        this.element_spec.parse();
        this.labels = new IdlSymbol[this.case_label_list.v.size()];
        int n = 0;
        Enumeration enumeration = this.case_label_list.v.elements();
        while (enumeration.hasMoreElements()) {
            IdlSymbol idlSymbol;
            IdlSymbol idlSymbol2 = (IdlSymbol)enumeration.nextElement();
            this.labels[n++] = idlSymbol2;
            TypeSpec typeSpec = this.type_spec.typeSpec();
            if (idlSymbol2 != null && ((ConstExpr)idlSymbol2).or_expr.xor_expr.and_expr.shift_expr.add_expr.mult_expr.unary_expr.primary_expr.symbol instanceof Literal) {
                idlSymbol = (Literal)((ConstExpr)idlSymbol2).or_expr.xor_expr.and_expr.shift_expr.add_expr.mult_expr.unary_expr.primary_expr.symbol;
                if (typeSpec instanceof ScopedName) {
                    while (typeSpec instanceof ScopedName) {
                        typeSpec = ((ScopedName)this.type_spec.typeSpec()).resolvedTypeSpec();
                        if (!(typeSpec instanceof AliasTypeSpec)) continue;
                        typeSpec = ((AliasTypeSpec)typeSpec).originalType();
                    }
                }
                if (!(typeSpec instanceof BooleanType) && !(typeSpec instanceof IntType) && !(typeSpec instanceof CharType) && (!(typeSpec instanceof BaseType) || !((BaseType)typeSpec).isSwitchType()) || typeSpec instanceof BooleanType && !((Literal)idlSymbol).string.equals("true") && !((Literal)idlSymbol).string.equals("false") || typeSpec instanceof CharType && !((Literal)idlSymbol).string.startsWith("'")) {
                    parser.error("Illegal case label <" + ((Literal)idlSymbol).string + "> for switch type " + this.type_spec.typeName(), this.token);
                    return;
                }
                if (typeSpec instanceof IntType) {
                    try {
                        Integer.parseInt(((Literal)idlSymbol).string);
                    }
                    catch (NumberFormatException numberFormatException) {
                        parser.error("Illegal case label <" + ((Literal)idlSymbol).string + "> for integral switch type " + this.type_spec.typeName(), this.token);
                        return;
                    }
                }
            }
            if (this.enumTypeName() == null) {
                if (idlSymbol2 == null) continue;
                idlSymbol2.parse();
                continue;
            }
            if (idlSymbol2 == null) continue;
            idlSymbol = (ScopedName)((ConstExpr)idlSymbol2).or_expr.xor_expr.and_expr.shift_expr.add_expr.mult_expr.unary_expr.primary_expr.symbol;
            int n2 = this.case_label_list.v.indexOf(idlSymbol2);
            idlSymbol2 = new ScopedName(Case.new_num());
            ((ScopedName)idlSymbol2).setId(idlSymbol.typeName);
            idlSymbol2.setPackage(this.pack_name);
            idlSymbol2.parse();
            this.case_label_list.v.setElementAt(idlSymbol2, n2);
        }
    }

    IdlSymbol[] getLabels() {
        if (this.labels == null) {
            throw new RuntimeException("Case labels not initialized!");
        }
        return this.labels;
    }

    public void print(PrintWriter printWriter) {
        this.element_spec.print(printWriter);
    }
}

