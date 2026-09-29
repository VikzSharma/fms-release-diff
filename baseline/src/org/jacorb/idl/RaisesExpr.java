/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.StructType;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.parser;

public class RaisesExpr
extends IdlSymbol {
    public Vector nameList;

    public RaisesExpr(int n) {
        super(n);
        this.nameList = new Vector();
    }

    public RaisesExpr() {
        this(RaisesExpr.new_num());
    }

    public RaisesExpr(Vector vector) {
        super(RaisesExpr.new_num());
        this.nameList = (Vector)vector.clone();
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        Enumeration enumeration = this.nameList.elements();
        while (enumeration.hasMoreElements()) {
            ((ScopedName)enumeration.nextElement()).setPackage(string);
        }
    }

    public boolean empty() {
        return this.nameList.size() == 0;
    }

    public String[] getExceptionNames() {
        String[] stringArray = new String[this.nameList.size()];
        Enumeration enumeration = this.nameList.elements();
        for (int i = 0; i < stringArray.length; ++i) {
            stringArray[i] = ((ScopedName)enumeration.nextElement()).toString();
        }
        return stringArray;
    }

    public String[] getExceptionIds() {
        String[] stringArray = new String[this.nameList.size()];
        Enumeration enumeration = this.nameList.elements();
        for (int i = 0; i < stringArray.length; ++i) {
            stringArray[i] = ((ScopedName)enumeration.nextElement()).id();
        }
        return stringArray;
    }

    public String[] getExceptionClassNames() {
        String[] stringArray = new String[this.nameList.size()];
        Enumeration enumeration = this.nameList.elements();
        for (int i = 0; i < stringArray.length; ++i) {
            stringArray[i] = ((ScopedName)enumeration.nextElement()).toString();
        }
        return stringArray;
    }

    public void parse() {
        IdlSymbol idlSymbol;
        Hashtable<String, IdlSymbol> hashtable = new Hashtable<String, IdlSymbol>();
        Enumeration<Object> enumeration = this.nameList.elements();
        while (enumeration.hasMoreElements()) {
            idlSymbol = null;
            try {
                idlSymbol = (ScopedName)enumeration.nextElement();
                TypeSpec typeSpec = ((ScopedName)idlSymbol).resolvedTypeSpec();
                if (((StructType)((ConstrTypeSpec)typeSpec).declaration()).isException()) {
                    hashtable.put(((ScopedName)idlSymbol).resolvedName(), idlSymbol);
                    continue;
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            parser.fatal_error("Illegal type in raises clause: " + ((ScopedName)idlSymbol).toString(), this.token);
        }
        this.nameList = new Vector();
        enumeration = hashtable.keys();
        while (enumeration.hasMoreElements()) {
            this.nameList.addElement(hashtable.get(enumeration.nextElement()));
        }
        hashtable.clear();
        enumeration = this.getExceptionClassNames();
        idlSymbol = this.enclosing_symbol;
        for (int i = 0; i < ((Enumeration<Object>)enumeration).length; ++i) {
            idlSymbol.addImportedName((String)((Object)enumeration[i]));
        }
    }

    public void print(PrintWriter printWriter) {
        Enumeration enumeration = this.nameList.elements();
        if (enumeration.hasMoreElements()) {
            printWriter.print(" throws " + enumeration.nextElement());
        }
        while (enumeration.hasMoreElements()) {
            printWriter.print("," + enumeration.nextElement());
        }
    }
}

