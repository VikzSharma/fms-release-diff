/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log.Priority
 */
package org.jacorb.idl;

import org.apache.log.Priority;

public final class Environment {
    static boolean JAVA14 = false;
    static boolean JAVA15 = false;

    public static Priority intToPriority(int n) {
        switch (n) {
            case 4: {
                return Priority.DEBUG;
            }
            case 3: {
                return Priority.INFO;
            }
            case 2: {
                return Priority.WARN;
            }
            case 1: {
                return Priority.ERROR;
            }
        }
        return Priority.FATAL_ERROR;
    }

    static {
        String string = System.getProperty("java.version");
        int n = 0;
        try {
            n = Integer.parseInt("" + string.charAt(0)) * 10 + Integer.parseInt("" + string.charAt(2));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        JAVA14 = n >= 14;
        JAVA15 = n >= 15;
    }
}

