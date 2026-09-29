/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl.runtime;

import java.util.Stack;
import org.jacorb.idl.runtime.symbol;

public class virtual_parse_stack {
    protected Stack real_stack;
    protected int real_next;
    protected Stack vstack;

    public virtual_parse_stack(Stack stack) throws Exception {
        if (stack == null) {
            throw new Exception("Internal parser error: attempt to create null virtual stack");
        }
        this.real_stack = stack;
        this.vstack = new Stack();
        this.real_next = 0;
        this.get_from_real();
    }

    protected void get_from_real() {
        if (this.real_next >= this.real_stack.size()) {
            return;
        }
        symbol symbol2 = (symbol)this.real_stack.elementAt(this.real_stack.size() - 1 - this.real_next);
        ++this.real_next;
        this.vstack.push(new Integer(symbol2.parse_state));
    }

    public boolean empty() {
        return this.vstack.empty();
    }

    public int top() throws Exception {
        if (this.vstack.empty()) {
            throw new Exception("Internal parser error: top() called on empty virtual stack");
        }
        return (Integer)this.vstack.peek();
    }

    public void pop() throws Exception {
        if (this.vstack.empty()) {
            throw new Exception("Internal parser error: pop from empty virtual stack");
        }
        this.vstack.pop();
        if (this.vstack.empty()) {
            this.get_from_real();
        }
    }

    public void push(int n) {
        this.vstack.push(new Integer(n));
    }
}

