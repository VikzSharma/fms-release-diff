/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.jacorb.idl.AttrDecl;
import org.jacorb.idl.ConstDecl;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.Declaration;
import org.jacorb.idl.Definition;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.Interface;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.OpDecl;
import org.jacorb.idl.Operation;
import org.jacorb.idl.ReplyHandler;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.SymbolList;
import org.jacorb.idl.parser;

public class InterfaceBody
extends IdlSymbol {
    public Vector v = new Vector();
    public Interface my_interface;
    SymbolList inheritance_spec = null;
    private Operation[] methods = null;
    private String waitingName = "";
    public static Vector parseThreads = new Vector();

    public InterfaceBody(int n) {
        super(n);
    }

    public void commit() {
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
        Enumeration enumeration = this.v.elements();
        while (enumeration.hasMoreElements()) {
            ((IdlSymbol)enumeration.nextElement()).setEnclosingSymbol(this.my_interface);
        }
    }

    public void set_ancestors(SymbolList symbolList) {
        this.inheritance_spec = symbolList;
    }

    public void set_name(String string) {
        this.name = string;
        Enumeration enumeration = this.v.elements();
        while (enumeration.hasMoreElements()) {
            ((IdlSymbol)enumeration.nextElement()).setPackage(this.name);
        }
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        Enumeration enumeration = this.v.elements();
        while (enumeration.hasMoreElements()) {
            ((IdlSymbol)enumeration.nextElement()).setPackage(string);
        }
    }

    public void addDefinition(Declaration declaration) {
        this.v.add(new Definition(declaration));
    }

    public void parse() {
        this.escapeName();
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Interface Body parse " + this.full_name());
        }
        if (this.inheritance_spec != null) {
            Object object = null;
            boolean bl = false;
            Enumeration enumeration = this.inheritance_spec.v.elements();
            while (enumeration.hasMoreElements()) {
                ScopedName scopedName = (ScopedName)enumeration.nextElement();
                if (this.logger.isDebugEnabled()) {
                    this.logger.debug("Trying to resolve " + scopedName);
                }
                object = parser.get_pending(scopedName.resolvedName());
                bl = bl || object != null;
            }
            if (bl) {
                parser.set_pending(this.full_name());
                new ParseThread(this);
            } else {
                this.internal_parse();
                parser.remove_pending(this.full_name());
            }
        } else {
            this.internal_parse();
            parser.remove_pending(this.full_name());
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("Interface Body done parsing " + this.full_name());
            }
        }
    }

    public void internal_parse() {
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Interface Body internal_parse " + this.full_name());
        }
        if (this.inheritance_spec != null) {
            try {
                NameTable.inheritFrom(this.full_name(), this.inheritance_spec);
            }
            catch (NameAlreadyDefined nameAlreadyDefined) {
                parser.fatal_error("Name " + nameAlreadyDefined.getMessage() + " already defined in  base interface(s)", this.token);
            }
        }
        Definition definition = null;
        Enumeration enumeration = this.v.elements();
        while (enumeration.hasMoreElements()) {
            definition = (Definition)enumeration.nextElement();
            Declaration declaration = definition.get_declaration();
            if (this.is_pseudo) {
                declaration.set_pseudo();
            }
            declaration.parse();
        }
    }

    public void print(PrintWriter printWriter) {
        if (printWriter != null) {
            throw new RuntimeException("Compiler Error, interface body cannot be printed thus!");
        }
        Enumeration enumeration = this.v.elements();
        while (enumeration.hasMoreElements()) {
            Declaration declaration = ((Definition)enumeration.nextElement()).get_declaration();
            if (declaration instanceof OpDecl) continue;
            declaration.print(printWriter);
        }
    }

    public void printOperationSignatures(PrintWriter printWriter) {
        if (this.v.size() > 0) {
            printWriter.println("\t/* operations  */");
        }
        Enumeration enumeration = this.v.elements();
        while (enumeration.hasMoreElements()) {
            Definition definition = (Definition)enumeration.nextElement();
            if (definition.get_declaration() instanceof OpDecl) {
                ((OpDecl)definition.get_declaration()).printSignature(printWriter);
                continue;
            }
            if (!(definition.get_declaration() instanceof AttrDecl)) continue;
            Enumeration enumeration2 = ((AttrDecl)definition.get_declaration()).getOperations();
            while (enumeration2.hasMoreElements()) {
                ((Operation)enumeration2.nextElement()).printSignature(printWriter);
            }
        }
    }

    public void printConstants(PrintWriter printWriter) {
        if (this.v.size() > 0) {
            printWriter.println("\t/* constants */");
        }
        Enumeration enumeration = this.v.elements();
        while (enumeration.hasMoreElements()) {
            Definition definition = (Definition)enumeration.nextElement();
            if (!(definition.get_declaration() instanceof ConstDecl)) continue;
            ((ConstDecl)definition.get_declaration()).printContained(printWriter);
        }
    }

    public void printInterfaceMethods(PrintWriter printWriter) {
        Enumeration enumeration = this.v.elements();
        while (enumeration.hasMoreElements()) {
            Definition definition = (Definition)enumeration.nextElement();
            if (definition.get_declaration() instanceof ConstDecl || !this.is_pseudo()) continue;
            ((IdlSymbol)definition).print(printWriter);
        }
    }

    public Operation[] getMethods() {
        if (this.methods == null) {
            Operation[] operationArray;
            Object object;
            IdlSymbol idlSymbol;
            Hashtable<String, Object> hashtable = new Hashtable<String, Object>();
            Enumeration enumeration = this.v.elements();
            while (enumeration.hasMoreElements()) {
                idlSymbol = (Definition)enumeration.nextElement();
                if (idlSymbol.get_declaration() instanceof OpDecl) {
                    hashtable.put(((OpDecl)idlSymbol.get_declaration()).signature(), idlSymbol.get_declaration());
                    continue;
                }
                if (!(idlSymbol.get_declaration() instanceof AttrDecl)) continue;
                object = ((AttrDecl)idlSymbol.get_declaration()).getOperations();
                while (object.hasMoreElements()) {
                    operationArray = (Operation[])object.nextElement();
                    hashtable.put(operationArray.signature(), operationArray);
                }
            }
            enumeration = this.my_interface.inheritanceSpec.v.iterator();
            while (enumeration.hasNext()) {
                idlSymbol = ((ScopedName)enumeration.next()).resolvedTypeSpec();
                if (!(idlSymbol instanceof ConstrTypeSpec)) continue;
                object = (Interface)((ConstrTypeSpec)idlSymbol).c_type_spec;
                operationArray = ((Interface)object).getBody().getMethods();
                for (int i = 0; i < operationArray.length; ++i) {
                    if (hashtable.contains(operationArray[i].signature())) continue;
                    hashtable.put(operationArray[i].signature(), operationArray[i]);
                }
            }
            enumeration = hashtable.elements();
            this.methods = new Operation[hashtable.size()];
            for (int i = 0; i < this.methods.length; ++i) {
                this.methods[i] = (Operation)enumeration.nextElement();
            }
        }
        return this.methods;
    }

    public void printStubMethods(PrintWriter printWriter, String string, boolean bl, boolean bl2) {
        int n;
        Operation[] operationArray = this.getMethods();
        for (n = 0; n < operationArray.length; ++n) {
            operationArray[n].printMethod(printWriter, string, bl, bl2);
        }
        if (parser.generate_ami_callback && !(this.my_interface instanceof ReplyHandler)) {
            for (n = 0; n < operationArray.length; ++n) {
                operationArray[n].print_sendc_Method(printWriter, string);
            }
        }
    }

    public void printDelegatedMethods(PrintWriter printWriter) {
        Operation[] operationArray = this.getMethods();
        if (operationArray.length > 0) {
            for (int i = 0; i < operationArray.length; ++i) {
                operationArray[i].printDelegatedMethod(printWriter);
            }
        }
    }

    public void printOperationsHash(PrintWriter printWriter) {
        Operation[] operationArray = this.getMethods();
        if (operationArray.length <= 0) {
            return;
        }
        String string = System.getProperty("java.version").startsWith("1.1") ? "com.sun.java.util.collections.Hashtable" : "java.util.Hashtable";
        printWriter.println("\tstatic private final " + string + " m_opsHash = new " + string + "();");
        printWriter.println("\tstatic");
        printWriter.println("\t{");
        for (int i = 0; i < operationArray.length; ++i) {
            String string2 = operationArray[i] instanceof OpDecl && operationArray[i].opName().startsWith("_") ? operationArray[i].opName().substring(1) : operationArray[i].opName();
            printWriter.println("\t\tm_opsHash.put ( \"" + string2 + "\", new java.lang.Integer(" + i + "));");
        }
        printWriter.println("\t}");
    }

    public void printSkelInvocations(PrintWriter printWriter) {
        Operation[] operationArray = this.getMethods();
        if (operationArray.length <= 0) {
            printWriter.println("\t\tthrow new org.omg.CORBA.BAD_OPERATION(method + \" not found\");");
            return;
        }
        printWriter.println("\t\t// quick lookup of operation");
        printWriter.println("\t\tjava.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );");
        printWriter.println("\t\tif ( null == opsIndex )");
        printWriter.println("\t\t\tthrow new org.omg.CORBA.BAD_OPERATION(method + \" not found\");");
        printWriter.println("\t\tswitch ( opsIndex.intValue() )");
        printWriter.println("\t\t{");
        int n = 0;
        for (int i = 0; i < operationArray.length; ++i) {
            String string = operationArray[i] instanceof OpDecl && operationArray[i].opName().startsWith("_") ? operationArray[i].opName().substring(1) : operationArray[i].opName();
            printWriter.println("\t\t\tcase " + n++ + ": // " + string);
            printWriter.println("\t\t\t{");
            operationArray[i].printInvocation(printWriter);
            printWriter.println("\t\t\t\tbreak;");
            printWriter.println("\t\t\t}");
        }
        printWriter.println("\t\t}");
        printWriter.println("\t\treturn _out;");
    }

    void getIRInfo(Hashtable hashtable) {
        Enumeration enumeration = this.v.elements();
        while (enumeration.hasMoreElements()) {
            Definition definition = (Definition)enumeration.nextElement();
            if (definition.get_declaration() instanceof OpDecl) {
                ((OpDecl)definition.get_declaration()).getIRInfo(hashtable);
                continue;
            }
            if (!(definition.get_declaration() instanceof AttrDecl)) continue;
            ((AttrDecl)definition.get_declaration()).getIRInfo(hashtable);
        }
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        iDLTreeVisitor.visitInterfaceBody(this);
    }

    public class ParseThread
    extends Thread {
        private final InterfaceBody b;
        private boolean running = false;

        public ParseThread(InterfaceBody interfaceBody2) {
            this.b = interfaceBody2;
            this.setDaemon(true);
            parseThreads.addElement(this);
            parser.incActiveParseThreads();
            this.start();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void run() {
            parser.set_pending(this.b.full_name());
            Object object = null;
            Enumeration enumeration = InterfaceBody.this.inheritance_spec.v.elements();
            while (enumeration.hasMoreElements()) {
                InterfaceBody.this.waitingName = ((ScopedName)enumeration.nextElement()).resolvedName();
                object = parser.get_pending(InterfaceBody.this.waitingName);
                if (object == null) continue;
                try {
                    Object object2 = object;
                    synchronized (object2) {
                        object.wait();
                        this.running = true;
                    }
                }
                catch (InterruptedException interruptedException) {
                    InterfaceBody.this.logger.info("ParseThread " + this + " interrupted!");
                }
            }
            this.b.internal_parse();
            this.exitParseThread();
        }

        public synchronized boolean isRunnable() {
            boolean bl;
            boolean bl2 = bl = this.running || this.checkWaitCondition();
            if (InterfaceBody.this.logger.isWarnEnabled()) {
                InterfaceBody.this.logger.warn("Thread is runnable: " + bl);
            }
            return bl;
        }

        private synchronized void exitParseThread() {
            parser.remove_pending(this.b.full_name());
            parser.decActiveParseThreads();
            parseThreads.removeElement(this);
            this.running = false;
        }

        private boolean checkWaitCondition() {
            return parser.get_pending(InterfaceBody.this.waitingName) == null;
        }
    }
}

