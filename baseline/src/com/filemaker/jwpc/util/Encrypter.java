/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fmi.net.Base64
 */
package com.filemaker.jwpc.util;

import com.filemaker.jwpc.log.JWPCLogger;
import com.fmi.net.Base64;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Encrypter {
    private static JWPCLogger logger = JWPCLogger.getLogger(Encrypter.class);
    private static final int KEY_SIZE = 128;
    private static SecretKey key;
    private static final String cEncryptionMethod = "AES/GCM/NoPadding";

    public static String encodeString(String string) {
        String string2 = null;
        if (string != null) {
            try {
                Cipher cipher = Cipher.getInstance(cEncryptionMethod);
                cipher.init(1, key);
                string2 = new String(Base64.encode((byte[])cipher.doFinal(string.getBytes("UTF-16"))));
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            }
            catch (Exception exception) {
                logger.error("encodeString() caught an exception:", exception);
            }
        }
        return string2;
    }

    public static String decodeString(String string) {
        String string2 = null;
        if (string != null) {
            try {
                Cipher cipher = Cipher.getInstance(cEncryptionMethod);
                cipher.init(2, key);
                string2 = new String(cipher.doFinal(Base64.decode((String)string)), "UTF-16");
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            }
            catch (Exception exception) {
                logger.error("decodeString() caught an exception:", exception);
            }
        }
        return string2;
    }

    static {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            key = keyGenerator.generateKey();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
        }
    }
}

