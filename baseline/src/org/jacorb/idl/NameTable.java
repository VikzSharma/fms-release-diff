/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log.Logger
 */
package org.jacorb.idl;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.log.Logger;
import org.jacorb.idl.IllegalRedefinition;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.SymbolList;
import org.jacorb.idl.TypeMap;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.parser;

public class NameTable {
    private static final Hashtable names = new Hashtable(10000);
    private static final Map shadows = new Hashtable();
    private static final Map ancestors = new Hashtable();
    private static final Map operationSources = new Hashtable();
    public static final Map parsed_interfaces = new Hashtable();
    static Logger logger;

    public static void init() {
        names.clear();
        operationSources.clear();
        shadows.clear();
        ancestors.clear();
        operationSources.clear();
        parsed_interfaces.clear();
        names.put("char", "type");
        names.put("boolean", "type");
        names.put("long", "type");
        names.put("long", "type");
        names.put("short", "type");
        names.put("int", "type");
        names.put("float", "type");
        names.put("double", "type");
        names.put("byte", "type");
        names.put("void", "type");
        names.put("org.omg.CORBA.Any", "type");
        names.put("org.omg.CORBA.Object", "interface");
        logger = parser.getLogger();
    }

    private static void checkScopingRules(String string, String string2) throws NameAlreadyDefined {
        if (logger.isDebugEnabled()) {
            logger.debug("NameTable.checkScopingRules:  " + string + " kind: " + string2);
        }
        if (string2.equals("argument")) {
            return;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string.toUpperCase(), ".");
        String[] stringArray = new String[stringTokenizer.countTokens()];
        int n = 0;
        while (stringTokenizer.hasMoreTokens()) {
            stringArray[n] = stringTokenizer.nextToken();
            ++n;
        }
        if (logger.isDebugEnabled()) {
            logger.debug("NameTable.checkScopingRules2:  " + string + " kind: " + string2);
        }
        if (stringArray.length > 1 && stringArray[stringArray.length - 2].equals(stringArray[stringArray.length - 1])) {
            throw new IllegalRedefinition(string);
        }
    }

    public static void define(String string, String string2) throws NameAlreadyDefined {
        if (logger.isInfoEnabled()) {
            logger.info("NameTable.define2: putting " + string + " kind " + string2 + " hash: " + string.hashCode());
        }
        if (names.containsKey(string) || names.containsKey(string.toUpperCase())) {
            if (string2.equals("module")) {
                return;
            }
            if (names.containsKey(string) && !names.get(string).equals(string2) && parser.get_pending(string) == null) {
                throw new IllegalRedefinition(string);
            }
            if (!shadows.containsKey(string) || string2.equals("operation") || string2.equals("interface")) {
                throw new NameAlreadyDefined(string);
            }
            if (logger.isInfoEnabled()) {
                logger.info("NameTable.define2: redefining  " + string);
            }
            shadows.remove(string);
            names.remove(string);
            if (string2.startsWith("type")) {
                TypeMap.removeDefinition(string);
            }
        }
        if (parser.strict_names) {
            NameTable.checkScopingRules(string, string2);
        }
        names.put(string, string2);
        if (parser.strict_names) {
            names.put(string.toUpperCase(), "dummy");
        }
        if (string2.equals("operation")) {
            operationSources.put(string, string.substring(0, string.lastIndexOf(".")));
        }
    }

    private static void defineInheritedOperation(String string, String string2) throws NameAlreadyDefined {
        if (names.containsKey(string)) {
            String string3 = null;
            String string4 = string.indexOf(".") < 0 ? string : string.substring(string.lastIndexOf(".") + 1);
            String string5 = string;
            while ((string3 = (String)operationSources.get(string5)) != null && !string5.equals(string3 + "." + string4)) {
                string5 = string3 + "." + string4;
            }
            if (logger.isInfoEnabled()) {
                logger.info("NameTable source of " + string + " is " + string5);
            }
            String string6 = string2 + "." + string4;
            while ((string3 = (String)operationSources.get(string6)) != null && !string6.equals(string3 + "." + string4)) {
                string6 = string3 + "." + string4;
            }
            if (logger.isInfoEnabled()) {
                logger.info("NameTable other source of " + string + " is " + string6);
            }
            if (string6.equals(string5)) {
                return;
            }
            throw new NameAlreadyDefined(string);
        }
        names.put(string, "operation");
        operationSources.put(string, string2);
    }

    private static void defineShadows(Hashtable hashtable) throws NameAlreadyDefined {
        String string = null;
        Enumeration enumeration = hashtable.keys();
        while (enumeration.hasMoreElements()) {
            String string2 = (String)enumeration.nextElement();
            String string3 = (String)hashtable.get(string2);
            if (names.containsKey(string2)) {
                string = string2;
                continue;
            }
            names.put(string2, string3);
            if (logger.isDebugEnabled()) {
                logger.debug("Put shadow " + string2);
            }
            shadows.put(string2, "");
            if (!string3.equals("operation")) continue;
            operationSources.put(string2, string2.substring(0, string2.lastIndexOf(".")));
        }
        if (string != null) {
            throw new NameAlreadyDefined(string);
        }
    }

    public static synchronized void inheritFrom(String string, SymbolList symbolList) throws NameAlreadyDefined {
        block13: {
            Hashtable<String, String> hashtable = new Hashtable<String, String>();
            Enumeration enumeration = names.keys();
            while (enumeration.hasMoreElements()) {
                String string2 = (String)enumeration.nextElement();
                String string3 = null;
                if (string2.indexOf(46) <= 0) continue;
                string3 = string2.substring(0, string2.lastIndexOf(46));
                Enumeration enumeration2 = symbolList.v.elements();
                while (enumeration2.hasMoreElements()) {
                    String string4 = ((ScopedName)enumeration2.nextElement()).resolvedName();
                    if (!string3.equals(string4)) continue;
                    String string5 = (String)names.get(string2);
                    if (logger.isDebugEnabled()) {
                        logger.debug("NameTable.inheritFrom ancestor " + string4 + " : key " + string2 + " kind " + string5);
                    }
                    String string6 = string + string2.substring(string2.lastIndexOf(46));
                    hashtable.put(string6, string5);
                    if (string5.startsWith("type")) {
                        TypeSpec typeSpec;
                        if (logger.isDebugEnabled()) {
                            logger.debug("- NameTable.inherit type from:  " + string2);
                        }
                        if ((typeSpec = TypeMap.map(string4 + string2.substring(string2.lastIndexOf(46)))) != null) {
                            TypeMap.typedef(string + string2.substring(string2.lastIndexOf(46)), typeSpec);
                        }
                        hashtable.put(string + string2.substring(string2.lastIndexOf(46)), string5);
                    } else if (string5.equals("operation")) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("- NameTable.inherit operation from:  " + string2);
                        }
                        NameTable.defineInheritedOperation(string + string2.substring(string2.lastIndexOf(46)), string4);
                    } else if (logger.isDebugEnabled()) {
                        logger.debug("- NameTable.inherit " + string5 + " from:  " + string2);
                    }
                    if (NameTable.isDefined(string2)) continue;
                    throw new RuntimeException("CompilerError!");
                }
            }
            try {
                NameTable.defineShadows(hashtable);
            }
            catch (NameAlreadyDefined nameAlreadyDefined) {
                if (!logger.isDebugEnabled()) break block13;
                logger.debug("Exception ", (Throwable)nameAlreadyDefined);
            }
        }
    }

    public static boolean isDefined(String string) {
        return names.containsKey(string);
    }

    public static boolean isDefined(String string, String string2) {
        if (!names.containsKey(string)) {
            return false;
        }
        String string3 = (String)names.get(string);
        return string3.compareTo(string2) == 0;
    }

    static boolean baseType(String string) {
        return string.equals("int") || string.equals("short") || string.equals("long") || string.equals("float") || string.equals("boolean") || string.equals("double") || string.equals("byte") || string.equals("char") || string.equals("void") || string.equals("org.omg.CORBA.Object") || string.equals("org.omg.CORBA.Any") || string.equals("<anon>");
    }
}

