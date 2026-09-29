/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.net;

public class Base64 {
    static String lineSeparator = System.getProperty("line.separator");
    private static int lineLength = 72;
    static final char[] valueToChar = new char[64];
    static final int[] charToValue = new int[256];
    static final int IGNORE = -1;
    static final int PAD = -2;
    private static final boolean debug = true;

    static {
        int i = 0;
        while (i <= 25) {
            Base64.valueToChar[i] = (char)(65 + i);
            ++i;
        }
        i = 0;
        while (i <= 25) {
            Base64.valueToChar[i + 26] = (char)(97 + i);
            ++i;
        }
        i = 0;
        while (i <= 9) {
            Base64.valueToChar[i + 52] = (char)(48 + i);
            ++i;
        }
        Base64.valueToChar[62] = 43;
        Base64.valueToChar[63] = 47;
        i = 0;
        while (i < 256) {
            Base64.charToValue[i] = -1;
            ++i;
        }
        i = 0;
        while (i < 64) {
            Base64.charToValue[Base64.valueToChar[i]] = i;
            ++i;
        }
        Base64.charToValue[61] = -2;
    }

    public static String encode(byte[] b) {
        int outputLength = (b.length + 2) / 3 * 4;
        if (lineLength != 0) {
            outputLength += (outputLength - 1) / lineLength * lineSeparator.length();
        }
        StringBuffer sb = new StringBuffer(outputLength);
        int linePos = 0;
        int len = b.length / 3 * 3;
        int leftover = b.length - len;
        int i = 0;
        while (i < len) {
            if ((linePos += 4) > lineLength) {
                linePos = 0;
                if (lineLength != 0) {
                    sb.append(lineSeparator);
                }
            }
            int combined = b[i + 0] & 0xFF;
            combined <<= 8;
            combined |= b[i + 1] & 0xFF;
            combined <<= 8;
            int c3 = (combined |= b[i + 2] & 0xFF) & 0x3F;
            int c2 = (combined >>>= 6) & 0x3F;
            int c1 = (combined >>>= 6) & 0x3F;
            int c0 = (combined >>>= 6) & 0x3F;
            sb.append(valueToChar[c0]);
            sb.append(valueToChar[c1]);
            sb.append(valueToChar[c2]);
            sb.append(valueToChar[c3]);
            i += 3;
        }
        switch (leftover) {
            default: {
                break;
            }
            case 1: {
                if ((linePos += 4) > lineLength) {
                    linePos = 0;
                    if (lineLength != 0) {
                        sb.append(lineSeparator);
                    }
                }
                byte[] byArray = new byte[3];
                byArray[0] = b[len];
                sb.append(Base64.encode(byArray).substring(0, 2));
                sb.append("==");
                break;
            }
            case 2: {
                if ((linePos += 4) > lineLength) {
                    linePos = 0;
                    if (lineLength != 0) {
                        sb.append(lineSeparator);
                    }
                }
                byte[] byArray = new byte[3];
                byArray[0] = b[len];
                byArray[1] = b[len + 1];
                sb.append(Base64.encode(byArray).substring(0, 3));
                sb.append("=");
            }
        }
        if (outputLength != sb.length()) {
            System.out.println("oops: minor program flaw: output length mis-estimated");
            System.out.println("estimate:" + outputLength);
            System.out.println("actual:" + sb.length());
        }
        return sb.toString();
    }

    public static byte[] decode(String s) {
        byte[] b = new byte[s.length() / 4 * 3];
        int cycle = 0;
        int combined = 0;
        int j = 0;
        int len = s.length();
        int dummies = 0;
        int i = 0;
        while (i < len) {
            char c = s.charAt(i);
            int value = c <= '\u00ff' ? charToValue[c] : -1;
            block0 : switch (value) {
                case -1: {
                    break;
                }
                case -2: {
                    value = 0;
                    ++dummies;
                }
                default: {
                    switch (cycle) {
                        case 0: {
                            combined = value;
                            cycle = 1;
                            break block0;
                        }
                        case 1: {
                            combined <<= 6;
                            combined |= value;
                            cycle = 2;
                            break block0;
                        }
                        case 2: {
                            combined <<= 6;
                            combined |= value;
                            cycle = 3;
                            break block0;
                        }
                        case 3: {
                            combined <<= 6;
                            b[j + 2] = (byte)(combined |= value);
                            b[j + 1] = (byte)(combined >>>= 8);
                            b[j] = (byte)(combined >>>= 8);
                            j += 3;
                            cycle = 0;
                        }
                    }
                }
            }
            ++i;
        }
        if (cycle != 0) {
            throw new ArrayIndexOutOfBoundsException("Input to decode not an even multiple of 4 characters; pad with =.");
        }
        if (b.length != (j -= dummies)) {
            byte[] b2 = new byte[j];
            System.arraycopy(b, 0, b2, 0, j);
            b = b2;
        }
        return b;
    }

    public static void setLineLength(int length) {
        lineLength = length / 4 * 4;
    }

    public static void show(byte[] b) {
        int i = 0;
        while (i < b.length) {
            System.out.print(String.valueOf(Integer.toHexString(b[i] & 0xFF)) + " ");
            ++i;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        byte[] a = new byte[]{-4, 15, -64};
        byte[] b = new byte[]{3, -16, 63};
        byte[] c = new byte[3];
        byte[] d = new byte[]{-1, -1, -1};
        byte[] e = new byte[]{-4, 15, -64, 1};
        byte[] f = new byte[]{-4, 15, -64, 1, 2};
        byte[] g = new byte[]{-4, 15, -64, 1, 2, 3};
        byte[] h = "AAAAAAAAAAB".getBytes();
        Base64.show(a);
        Base64.show(b);
        Base64.show(c);
        Base64.show(d);
        Base64.show(e);
        Base64.show(f);
        Base64.show(g);
        Base64.show(h);
        Base64.show(Base64.decode(Base64.encode(a)));
        Base64.show(Base64.decode(Base64.encode(b)));
        Base64.show(Base64.decode(Base64.encode(c)));
        Base64.show(Base64.decode(Base64.encode(d)));
        Base64.show(Base64.decode(Base64.encode(e)));
        Base64.show(Base64.decode(Base64.encode(f)));
        Base64.show(Base64.decode(Base64.encode(g)));
        Base64.show(Base64.decode(Base64.encode(h)));
        Base64.setLineLength(8);
        Base64.show(Base64.encode(h).getBytes());
    }
}

