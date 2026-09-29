/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CloneUtil {
    public static final Object deepClone(Object object) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(100);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            byte[] byArray = byteArrayOutputStream.toByteArray();
            objectOutputStream.close();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object2 = objectInputStream.readObject();
            objectInputStream.close();
            return object2;
        }
        catch (Exception exception) {
            return null;
        }
    }
}

