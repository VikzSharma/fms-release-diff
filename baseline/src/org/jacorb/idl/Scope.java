/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import org.jacorb.idl.ScopeData;
import org.jacorb.idl.str_token;

public interface Scope {
    public void setScopeData(ScopeData var1);

    public ScopeData getScopeData();

    public str_token get_token();

    public String name();
}

