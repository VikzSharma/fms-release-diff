/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.SymbolList;
import org.jacorb.idl.Truncatable;
import org.jacorb.idl.Value;
import org.jacorb.idl.ValueAbsDecl;
import org.jacorb.idl.parser;

public class ValueInheritanceSpec
extends SymbolList {
    Vector supports = new Vector();
    Truncatable truncatable = null;

    public ValueInheritanceSpec(int n) {
        super(n);
    }

    public String getTruncatableId() {
        if (this.truncatable == null) {
            return null;
        }
        return this.truncatable.getId();
    }

    public boolean isEmpty() {
        return this.v.size() == 0 && this.truncatable == null;
    }

    public Enumeration getValueTypes() {
        return this.v.elements();
    }

    public Enumeration getSupportedInterfaces() {
        return this.supports.elements();
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        if (this.truncatable != null) {
            this.truncatable.scopedName.setPackage(string);
        }
        Enumeration enumeration = this.v.elements();
        while (enumeration.hasMoreElements()) {
            ((IdlSymbol)enumeration.nextElement()).setPackage(string);
        }
        enumeration = this.supports.elements();
        while (enumeration.hasMoreElements()) {
            ((IdlSymbol)enumeration.nextElement()).setPackage(string);
        }
    }

    public void parse() {
        Object object;
        if (this.truncatable != null) {
            object = this.truncatable.scopedName;
            Value value = (Value)((ConstrTypeSpec)((ScopedName)object).resolvedTypeSpec()).c_type_spec;
            if (value instanceof ValueAbsDecl) {
                parser.error("truncatable base value " + ((ScopedName)object).toString() + " must not be abstract", this.token);
            }
        }
        object = this.v.elements();
        while (object.hasMoreElements()) {
            ((IdlSymbol)object.nextElement()).parse();
        }
    }

    public void print(PrintWriter printWriter) {
        printWriter.print(this.toString());
    }

    public String toString() {
        Enumeration enumeration;
        StringBuffer stringBuffer = new StringBuffer();
        if (this.truncatable != null) {
            stringBuffer.append(this.truncatable.toString() + " ");
        }
        if ((enumeration = this.v.elements()).hasMoreElements()) {
            stringBuffer.append(enumeration.nextElement() + " ");
        }
        while (enumeration.hasMoreElements()) {
            stringBuffer.append("," + enumeration.nextElement() + " ");
        }
        Enumeration enumeration2 = this.supports.elements();
        if (enumeration2.hasMoreElements()) {
            stringBuffer.append("supports ");
            ((IdlSymbol)enumeration2.nextElement()).toString();
        }
        while (enumeration2.hasMoreElements()) {
            stringBuffer.append(',');
            ((IdlSymbol)enumeration2.nextElement()).toString();
        }
        return stringBuffer.toString();
    }
}

