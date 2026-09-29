/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl.runtime;

import java.util.Stack;
import org.jacorb.idl.runtime.symbol;
import org.jacorb.idl.runtime.token;
import org.jacorb.idl.runtime.virtual_parse_stack;

public abstract class lr_parser {
    protected static final int _error_sync_size = 3;
    protected boolean _done_parsing = false;
    protected int tos;
    protected token cur_token;
    protected Stack stack = new Stack();
    protected short[][] production_tab;
    protected short[][] action_tab;
    protected short[][] reduce_tab;
    protected token[] lookahead;
    protected int lookahead_pos;

    protected int error_sync_size() {
        return 3;
    }

    public abstract short[][] production_table();

    public abstract short[][] action_table();

    public abstract short[][] reduce_table();

    public abstract int start_state();

    public abstract int start_production();

    public abstract int EOF_sym();

    public abstract int error_sym();

    public void done_parsing() {
        this._done_parsing = true;
    }

    public abstract symbol do_action(int var1, lr_parser var2, Stack var3, int var4) throws Exception;

    public void user_init() throws Exception {
    }

    protected abstract void init_actions() throws Exception;

    public abstract token scan() throws Exception;

    public void report_fatal_error(String string, Object object) throws Exception {
        this.done_parsing();
        this.report_error(string, object);
        throw new Exception("Can't recover from previous error(s)");
    }

    public void report_error(String string, Object object) {
        System.err.println(string);
    }

    public void syntax_error(token token2) {
        this.report_error("Syntax error", null);
    }

    public void unrecovered_syntax_error(token token2) throws Exception {
        this.report_fatal_error("Couldn't repair and continue parse", null);
    }

    protected final short get_action(int n, int n2) {
        short[] sArray = this.action_tab[n];
        if (sArray.length < 20) {
            for (int i = 0; i < sArray.length; ++i) {
                short s;
                if ((s = sArray[i++]) != n2 && s != -1) continue;
                return sArray[i];
            }
        } else {
            int n3 = 0;
            int n4 = (sArray.length - 1) / 2 - 1;
            while (n3 <= n4) {
                int n5 = (n3 + n4) / 2;
                if (n2 == sArray[n5 * 2]) {
                    return sArray[n5 * 2 + 1];
                }
                if (n2 > sArray[n5 * 2]) {
                    n3 = n5 + 1;
                    continue;
                }
                n4 = n5 - 1;
            }
            return sArray[sArray.length - 1];
        }
        return 0;
    }

    protected final short get_reduce(int n, int n2) {
        short[] sArray = this.reduce_tab[n];
        if (sArray == null) {
            return -1;
        }
        for (int i = 0; i < sArray.length; ++i) {
            short s;
            if ((s = sArray[i++]) != n2 && s != -1) continue;
            return sArray[i];
        }
        return -1;
    }

    public void parse() throws Exception {
        this.production_tab = this.production_table();
        this.action_tab = this.action_table();
        this.reduce_tab = this.reduce_table();
        this.init_actions();
        this.user_init();
        this.cur_token = this.scan();
        this.stack.push(new symbol(0, this.start_state()));
        this.tos = 0;
        this._done_parsing = false;
        while (!this._done_parsing) {
            short s;
            if (this.cur_token == null) {
                this.unrecovered_syntax_error(this.cur_token);
            }
            if ((s = this.get_action(((symbol)this.stack.peek()).parse_state, this.cur_token.sym)) > 0) {
                this.cur_token.parse_state = s - 1;
                this.stack.push(this.cur_token);
                ++this.tos;
                this.cur_token = this.scan();
                continue;
            }
            if (s < 0) {
                symbol symbol2 = this.do_action(-s - 1, this, this.stack, this.tos);
                short s2 = this.production_tab[-s - 1][0];
                int n = this.production_tab[-s - 1][1];
                for (int i = 0; i < n; ++i) {
                    this.stack.pop();
                    --this.tos;
                }
                s = this.get_reduce(((symbol)this.stack.peek()).parse_state, s2);
                symbol2.parse_state = s;
                this.stack.push(symbol2);
                ++this.tos;
                continue;
            }
            if (s != 0) continue;
            this.syntax_error(this.cur_token);
            if (this.error_recovery(false)) continue;
            this.unrecovered_syntax_error(this.cur_token);
            this.done_parsing();
        }
    }

    public void debug_message(String string) {
        System.err.println(string);
    }

    public void dump_stack() {
        if (this.stack == null) {
            this.debug_message("# Stack dump requested, but stack is null");
            return;
        }
        this.debug_message("============ Parse Stack Dump ============");
        for (int i = 0; i < this.stack.size(); ++i) {
            this.debug_message("Symbol: " + ((symbol)this.stack.elementAt((int)i)).sym + " State: " + ((symbol)this.stack.elementAt((int)i)).parse_state);
        }
        this.debug_message("==========================================");
    }

    public void debug_reduce(int n, int n2, int n3) {
        this.debug_message("# Reduce with prod #" + n + " [NT=" + n2 + ", " + "SZ=" + n3 + "]");
    }

    public void debug_shift(token token2) {
        this.debug_message("# Shift under term #" + token2.sym + " to state #" + token2.parse_state);
    }

    public void debug_parse() throws Exception {
        this.production_tab = this.production_table();
        this.action_tab = this.action_table();
        this.reduce_tab = this.reduce_table();
        this.debug_message("# Initializing parser");
        this.init_actions();
        this.user_init();
        this.cur_token = this.scan();
        this.debug_message("# Current token is #" + this.cur_token.sym);
        this.stack.push(new symbol(0, this.start_state()));
        this.tos = 0;
        this._done_parsing = false;
        while (!this._done_parsing) {
            short s = this.get_action(((symbol)this.stack.peek()).parse_state, this.cur_token.sym);
            if (s > 0) {
                this.cur_token.parse_state = s - 1;
                this.debug_shift(this.cur_token);
                this.stack.push(this.cur_token);
                ++this.tos;
                this.cur_token = this.scan();
                this.debug_message("# Current token is #" + this.cur_token.sym);
                continue;
            }
            if (s < 0) {
                symbol symbol2 = this.do_action(-s - 1, this, this.stack, this.tos);
                short s2 = this.production_tab[-s - 1][0];
                int n = this.production_tab[-s - 1][1];
                this.debug_reduce(-s - 1, s2, n);
                for (int i = 0; i < n; ++i) {
                    this.stack.pop();
                    --this.tos;
                }
                s = this.get_reduce(((symbol)this.stack.peek()).parse_state, s2);
                symbol2.parse_state = s;
                this.stack.push(symbol2);
                ++this.tos;
                this.debug_message("# Goto state #" + s);
                continue;
            }
            if (s != 0) continue;
            this.syntax_error(this.cur_token);
            if (this.error_recovery(true)) continue;
            this.unrecovered_syntax_error(this.cur_token);
            this.done_parsing();
        }
    }

    protected boolean error_recovery(boolean bl) throws Exception {
        if (bl) {
            this.debug_message("# Attempting error recovery");
        }
        if (!this.find_recovery_config(bl)) {
            if (bl) {
                this.debug_message("# Error recovery fails");
            }
            return false;
        }
        this.read_lookahead();
        while (true) {
            if (bl) {
                this.debug_message("# Trying to parse ahead");
            }
            if (this.try_parse_ahead(bl)) break;
            if (this.lookahead[0].sym == this.EOF_sym()) {
                if (bl) {
                    this.debug_message("# Error recovery fails at EOF");
                }
                return false;
            }
            if (bl) {
                this.debug_message("# Consuming token #" + this.cur_err_token().sym);
            }
            this.restart_lookahead();
        }
        if (bl) {
            this.debug_message("# Parse-ahead ok, going back to normal parse");
        }
        this.parse_lookahead(bl);
        return true;
    }

    protected boolean shift_under_error() {
        return this.get_action(((symbol)this.stack.peek()).parse_state, this.error_sym()) > 0;
    }

    protected boolean find_recovery_config(boolean bl) {
        if (bl) {
            this.debug_message("# Finding recovery state on stack");
        }
        while (!this.shift_under_error()) {
            if (bl) {
                this.debug_message("# Pop stack by one, state was # " + ((symbol)this.stack.peek()).parse_state);
            }
            this.stack.pop();
            --this.tos;
            if (!this.stack.empty()) continue;
            if (bl) {
                this.debug_message("# No recovery state found on stack");
            }
            return false;
        }
        short s = this.get_action(((symbol)this.stack.peek()).parse_state, this.error_sym());
        if (bl) {
            this.debug_message("# Recover state found (#" + ((symbol)this.stack.peek()).parse_state + ")");
            this.debug_message("# Shifting on error to state #" + (s - 1));
        }
        token token2 = new token(this.error_sym());
        token2.parse_state = s - 1;
        this.stack.push(token2);
        ++this.tos;
        return true;
    }

    protected void read_lookahead() throws Exception {
        this.lookahead = new token[this.error_sync_size()];
        for (int i = 0; i < this.error_sync_size(); ++i) {
            this.lookahead[i] = this.cur_token;
            this.cur_token = this.scan();
        }
        this.lookahead_pos = 0;
    }

    protected token cur_err_token() {
        return this.lookahead[this.lookahead_pos];
    }

    protected boolean advance_lookahead() {
        ++this.lookahead_pos;
        return this.lookahead_pos < this.error_sync_size();
    }

    protected void restart_lookahead() throws Exception {
        for (int i = 1; i < this.error_sync_size(); ++i) {
            this.lookahead[i - 1] = this.lookahead[i];
        }
        this.lookahead[this.error_sync_size() - 1] = this.cur_token = this.scan();
        this.lookahead_pos = 0;
    }

    protected boolean try_parse_ahead(boolean bl) throws Exception {
        virtual_parse_stack virtual_parse_stack2 = new virtual_parse_stack(this.stack);
        short s;
        while ((s = this.get_action(virtual_parse_stack2.top(), this.cur_err_token().sym)) != 0) {
            if (s > 0) {
                virtual_parse_stack2.push(s - 1);
                if (bl) {
                    this.debug_message("# Parse-ahead shifts token #" + this.cur_err_token().sym + " into state #" + (s - 1));
                }
                if (this.advance_lookahead()) continue;
                return true;
            }
            if (-s - 1 == this.start_production()) {
                if (bl) {
                    this.debug_message("# Parse-ahead accepts");
                }
                return true;
            }
            short s2 = this.production_tab[-s - 1][0];
            int n = this.production_tab[-s - 1][1];
            for (int i = 0; i < n; ++i) {
                virtual_parse_stack2.pop();
            }
            if (bl) {
                this.debug_message("# Parse-ahead reduces: handle size = " + n + " lhs = #" + s2 + " from state #" + virtual_parse_stack2.top());
            }
            virtual_parse_stack2.push(this.get_reduce(virtual_parse_stack2.top(), s2));
            if (!bl) continue;
            this.debug_message("# Goto state #" + virtual_parse_stack2.top());
        }
        return false;
    }

    protected void parse_lookahead(boolean bl) throws Exception {
        this.lookahead_pos = 0;
        if (bl) {
            this.debug_message("# Reparsing saved input with actions");
            this.debug_message("# Current token is #" + this.cur_err_token().sym);
            this.debug_message("# Current state is #" + ((symbol)this.stack.peek()).parse_state);
        }
        while (!this._done_parsing) {
            short s = this.get_action(((symbol)this.stack.peek()).parse_state, this.cur_err_token().sym);
            if (s > 0) {
                this.cur_err_token().parse_state = s - 1;
                if (bl) {
                    this.debug_shift(this.cur_err_token());
                }
                this.stack.push(this.cur_err_token());
                ++this.tos;
                if (!this.advance_lookahead()) {
                    if (bl) {
                        this.debug_message("# Completed reparse");
                    }
                    this.cur_token = this.scan();
                    return;
                }
                if (!bl) continue;
                this.debug_message("# Current token is #" + this.cur_err_token().sym);
                continue;
            }
            if (s < 0) {
                symbol symbol2 = this.do_action(-s - 1, this, this.stack, this.tos);
                short s2 = this.production_tab[-s - 1][0];
                int n = this.production_tab[-s - 1][1];
                if (bl) {
                    this.debug_reduce(-s - 1, s2, n);
                }
                for (int i = 0; i < n; ++i) {
                    this.stack.pop();
                    --this.tos;
                }
                s = this.get_reduce(((symbol)this.stack.peek()).parse_state, s2);
                symbol2.parse_state = s;
                this.stack.push(symbol2);
                ++this.tos;
                if (!bl) continue;
                this.debug_message("# Goto state #" + s);
                continue;
            }
            if (s != 0) continue;
            this.report_fatal_error("Syntax error", null);
            return;
        }
    }
}

