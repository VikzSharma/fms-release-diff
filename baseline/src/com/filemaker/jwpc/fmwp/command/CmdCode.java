/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.fmwp.command;

import java.util.HashMap;

public enum CmdCode {
    INVALID(-1),
    QUIT(0),
    PING(1),
    CREATESESSION(2),
    DELETESESSION(3),
    CONFIGURE(4),
    DBNAMES(5),
    LAYOUTNAMES(6),
    SCRIPTNAMES(7),
    FINDALL(8),
    FINDANY(9),
    FIND(10),
    FINDQUERY(11),
    ADD(12),
    REMOVE(13),
    MODIFY(14),
    DUPLICATE(15),
    VIEW(16),
    CONTAINER(17),
    LINK(18),
    UNLINK(19),
    TOTAL(20);

    private int value;
    private static HashMap<Integer, CmdCode> sCmdMap;
    private static HashMap<String, CmdCode> sCmdParameterMap;

    private CmdCode(int n2) {
        this.value = n2;
    }

    public static CmdCode fromValue(int n) {
        CmdCode cmdCode = sCmdMap.get(n);
        if (cmdCode == null) {
            cmdCode = INVALID;
        }
        return cmdCode;
    }

    public static CmdCode fromString(String string) {
        CmdCode cmdCode = sCmdParameterMap.get(string);
        if (cmdCode == null) {
            cmdCode = INVALID;
        }
        return cmdCode;
    }

    public int value() {
        return this.value;
    }

    public static int getTotalCmds() {
        return TOTAL.value();
    }

    static {
        sCmdMap = new HashMap();
        sCmdMap.put(CmdCode.INVALID.value, INVALID);
        sCmdMap.put(CmdCode.QUIT.value, QUIT);
        sCmdMap.put(CmdCode.PING.value, PING);
        sCmdMap.put(CmdCode.CREATESESSION.value, CREATESESSION);
        sCmdMap.put(CmdCode.DELETESESSION.value, DELETESESSION);
        sCmdMap.put(CmdCode.CONFIGURE.value, CONFIGURE);
        sCmdMap.put(CmdCode.DBNAMES.value, DBNAMES);
        sCmdMap.put(CmdCode.LAYOUTNAMES.value, LAYOUTNAMES);
        sCmdMap.put(CmdCode.SCRIPTNAMES.value, SCRIPTNAMES);
        sCmdMap.put(CmdCode.FINDALL.value, FINDALL);
        sCmdMap.put(CmdCode.FINDANY.value, FINDANY);
        sCmdMap.put(CmdCode.FIND.value, FIND);
        sCmdMap.put(CmdCode.FINDQUERY.value, FINDQUERY);
        sCmdMap.put(CmdCode.ADD.value, ADD);
        sCmdMap.put(CmdCode.REMOVE.value, REMOVE);
        sCmdMap.put(CmdCode.MODIFY.value, MODIFY);
        sCmdMap.put(CmdCode.DUPLICATE.value, DUPLICATE);
        sCmdMap.put(CmdCode.VIEW.value, VIEW);
        sCmdMap.put(CmdCode.CONTAINER.value, CONTAINER);
        sCmdMap.put(CmdCode.LINK.value, LINK);
        sCmdMap.put(CmdCode.UNLINK.value, UNLINK);
        sCmdParameterMap = new HashMap();
        sCmdParameterMap.put("-dbnames", DBNAMES);
        sCmdParameterMap.put("-layoutnames", LAYOUTNAMES);
        sCmdParameterMap.put("-scriptnames", SCRIPTNAMES);
        sCmdParameterMap.put("-findall", FINDALL);
        sCmdParameterMap.put("-findany", FINDANY);
        sCmdParameterMap.put("-find", FIND);
        sCmdParameterMap.put("-findquery", FINDQUERY);
        sCmdParameterMap.put("-new", ADD);
        sCmdParameterMap.put("-delete", REMOVE);
        sCmdParameterMap.put("-edit", MODIFY);
        sCmdParameterMap.put("-dup", DUPLICATE);
        sCmdParameterMap.put("-view", VIEW);
    }
}

