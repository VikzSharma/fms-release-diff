/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.util.Hashtable;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.ObjectTypeSpec;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.TypeCodeTypeSpec;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.parser;

public class TypeMap {
    static final Hashtable typemap = new Hashtable(5000);

    public static void init() {
        typemap.clear();
        typemap.put("org.omg.CORBA.Object", new ObjectTypeSpec(IdlSymbol.new_num()));
        typemap.put("org.omg.CORBA.TypeCode", new TypeCodeTypeSpec(IdlSymbol.new_num()));
        typemap.put("CORBA.Object", new ObjectTypeSpec(IdlSymbol.new_num()));
        typemap.put("CORBA.TypeCode", new TypeCodeTypeSpec(IdlSymbol.new_num()));
    }

    public static TypeSpec map(String string) {
        return (TypeSpec)typemap.get(string);
    }

    public static void typedef(String string, TypeSpec typeSpec) {
        if (parser.getLogger().isInfoEnabled()) {
            parser.getLogger().info("Typedef'ing " + string + " , hash: " + typeSpec.hashCode());
        }
        if (typemap.containsKey(string)) {
            if (parser.getLogger().isDebugEnabled()) {
                parser.getLogger().info("Typedef'ing " + string + " already in type map!");
            }
        } else if (typeSpec.typeSpec() instanceof ScopedName) {
            if (((ScopedName)typeSpec.typeSpec()).resolvedTypeSpec() != null) {
                typemap.put(string, ((ScopedName)typeSpec.typeSpec()).resolvedTypeSpec());
            } else {
                typemap.put(string, typeSpec.typeSpec());
            }
            if (parser.getLogger().isInfoEnabled()) {
                parser.getLogger().info(" resolved " + ((ScopedName)typeSpec.typeSpec()).resolvedTypeSpec());
            }
        } else {
            typemap.put(string, typeSpec.typeSpec());
            if (parser.getLogger().isInfoEnabled()) {
                parser.getLogger().info(" (not a resolved scoped name) " + typeSpec.typeSpec().full_name());
            }
        }
    }

    static void removeDefinition(String string) {
        if (!typemap.containsKey(string)) {
            throw new RuntimeException("Could not find definition of : " + string);
        }
        typemap.remove(string);
    }

    public static void replaceForwardDeclaration(String string, TypeSpec typeSpec) {
        if (!typemap.containsKey(string)) {
            throw new RuntimeException("Could not find forward declaration!");
        }
        typemap.remove(string);
        TypeMap.typedef(string, typeSpec);
    }
}

