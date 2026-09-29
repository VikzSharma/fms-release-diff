/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.Declarator;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.Interface;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.SequenceType;
import org.jacorb.idl.TemplateTypeSpec;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.UnionType;
import org.jacorb.idl.parser;

public class ElementSpec
extends IdlSymbol {
    public TypeSpec typeSpec = new TypeSpec(ElementSpec.new_num());
    public Declarator declarator = null;
    private UnionType containingUnion;

    public ElementSpec(int n) {
        super(n);
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        this.typeSpec.setPackage(string);
        this.declarator.setPackage(string);
    }

    public void setUnion(UnionType unionType) {
        this.containingUnion = unionType;
        if (this.typeSpec.typeSpec() instanceof ConstrTypeSpec) {
            String string = ((ConstrTypeSpec)this.typeSpec.typeSpec()).c_type_spec.pack_name;
            if (string.endsWith("PackagePackage") || !string.startsWith("_") && string.endsWith("Package")) {
                string = string.substring(0, string.lastIndexOf("Package"));
            }
            if (ScopedName.isPseudoScope(string)) {
                ((ConstrTypeSpec)this.typeSpec.typeSpec()).c_type_spec.pack_name = ((ConstrTypeSpec)this.typeSpec.typeSpec()).c_type_spec.pack_name + "." + unionType.name + "Package";
            }
        }
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        this.typeSpec.setEnclosingSymbol(idlSymbol);
        this.declarator.setEnclosingSymbol(idlSymbol);
    }

    public void parse() {
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("EelementSpec.parse(): element_spec is " + this.typeSpec.typeSpec().getClass().getName());
        }
        if (this.typeSpec.typeSpec() instanceof TemplateTypeSpec || this.typeSpec.typeSpec() instanceof ConstrTypeSpec) {
            this.typeSpec.parse();
            if (this.typeSpec.typeSpec() instanceof SequenceType) {
                TypeSpec typeSpec = ((SequenceType)this.typeSpec.typeSpec()).elementTypeSpec().typeSpec();
                SequenceType sequenceType = (SequenceType)this.typeSpec.typeSpec();
                while (typeSpec instanceof SequenceType) {
                    sequenceType = (SequenceType)typeSpec;
                    typeSpec = ((SequenceType)typeSpec.typeSpec()).elementTypeSpec().typeSpec();
                }
                if (ScopedName.isRecursionScope(typeSpec.typeName())) {
                    ((SequenceType)sequenceType.typeSpec()).setRecursive();
                }
            }
        } else if (this.typeSpec.typeSpec() instanceof ScopedName) {
            TypeSpec typeSpec = ((ScopedName)this.typeSpec.typeSpec()).resolvedTypeSpec();
            if (typeSpec.typeName().equals(this.containingUnion.typeName())) {
                parser.error("Illegal recursion in union " + this.containingUnion.full_name(), this.token);
            }
            this.containingUnion.addImportedName(typeSpec.typeName());
            if (!(typeSpec instanceof ConstrTypeSpec) || !(((ConstrTypeSpec)typeSpec).declaration() instanceof Interface)) {
                this.typeSpec = typeSpec;
            }
        }
        try {
            NameTable.define(this.containingUnion.full_name() + "." + this.declarator.name(), "declarator");
        }
        catch (NameAlreadyDefined nameAlreadyDefined) {
            parser.error("Declarator " + this.declarator.name() + " already defined in union " + this.containingUnion.full_name(), this.token);
        }
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("ElementSpec.parse-end(): element_spec is " + this.typeSpec.typeSpec().getClass().getName());
        }
    }

    public void print(PrintWriter printWriter) {
        if (this.typeSpec.typeSpec() instanceof TemplateTypeSpec || this.typeSpec.typeSpec() instanceof ConstrTypeSpec) {
            this.typeSpec.print(printWriter);
        }
    }
}

