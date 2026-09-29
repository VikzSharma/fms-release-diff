/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.math.BigInteger;
import org.jacorb.idl.AliasTypeSpec;
import org.jacorb.idl.ConstDecl;
import org.jacorb.idl.FixedPointConstType;
import org.jacorb.idl.FloatPtType;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.IntType;
import org.jacorb.idl.LongLongType;
import org.jacorb.idl.LongType;
import org.jacorb.idl.ShortType;
import org.jacorb.idl.StringType;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.fixed_token;
import org.jacorb.idl.parser;
import org.jacorb.idl.runtime.float_token;
import org.jacorb.idl.runtime.int_token;
import org.jacorb.idl.runtime.long_token;
import org.jacorb.idl.runtime.token;

public class Literal
extends IdlSymbol {
    private static BigInteger maximum;
    public String string;
    public boolean wide;
    public token token;
    private ConstDecl declared_in;

    public Literal(int n) {
        super(n);
    }

    public void setDeclaration(ConstDecl constDecl) {
        this.declared_in = constDecl;
    }

    public void parse() {
        if (this.declared_in != null) {
            TypeSpec typeSpec = this.declared_in.const_type.symbol.typeSpec();
            if (typeSpec instanceof AliasTypeSpec) {
                typeSpec = ((AliasTypeSpec)typeSpec).originalType();
            }
            if (typeSpec instanceof IntType) {
                if (((IntType)typeSpec).unsigned && typeSpec instanceof LongLongType && this.token instanceof fixed_token) {
                    BigInteger bigInteger;
                    if (maximum == null) {
                        maximum = new BigInteger("18446744073709551615");
                    }
                    if ((bigInteger = new BigInteger(this.string)).compareTo(maximum) > 0) {
                        parser.error("Value too big for unsigned long");
                    } else {
                        this.token = new long_token(((fixed_token)this.token).sym, ((fixed_token)this.token).fixed_val.longValue());
                        this.string = Long.toString(((long_token)this.token).long_val);
                    }
                } else if (((IntType)typeSpec).unsigned && typeSpec instanceof LongType && this.token instanceof long_token) {
                    if (((long_token)this.token).long_val > 0xFFFFFFFFL) {
                        parser.error("Value (" + ((long_token)this.token).long_val + ") too big for unsigned long");
                    } else {
                        this.token = new int_token(((long_token)this.token).sym, (int)((long_token)this.token).long_val);
                        this.string = Integer.toString(((int_token)this.token).int_val);
                    }
                } else if (typeSpec instanceof LongType && this.token instanceof long_token) {
                    parser.error("Value (" + ((long_token)this.token).long_val + ") too big for Java int");
                } else if (typeSpec instanceof LongLongType && this.token instanceof fixed_token) {
                    parser.error("Value (" + ((fixed_token)this.token).fixed_val.toString() + ") too big for Java long");
                }
            }
            if (this.logger.isWarnEnabled()) {
                this.logger.warn("Literal " + typeSpec.getClass().getName() + " " + (this.token != null ? this.token.getClass().getName() : "<no token>"));
            }
            if (typeSpec instanceof FloatPtType && !(this.token instanceof float_token)) {
                parser.error("Expecting float/double constant!");
            } else if (typeSpec instanceof FixedPointConstType && !(this.token instanceof fixed_token)) {
                parser.error("Expecting fixed point constant (perhaps a missing \"d\")!");
            } else if (typeSpec instanceof StringType) {
                if (this.wide && !((StringType)typeSpec).isWide()) {
                    parser.error("Illegal assignment of wide string constant to string!");
                }
            } else if ((typeSpec instanceof LongType || typeSpec instanceof ShortType) && this.token instanceof long_token) {
                parser.error("Illegal assignment from long long");
            }
        }
    }

    public String toString() {
        String string = this.string;
        if (this.token instanceof long_token) {
            string = this.string.indexOf(46) > 0 ? this.string + 'D' : this.string + 'L';
        }
        return Literal.escapeBackslash(string);
    }

    public void print(PrintWriter printWriter) {
        printWriter.print(Literal.escapeBackslash(this.string));
    }

    public static String escapeBackslash(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] cArray = string.toCharArray();
        if (cArray[0] == '\"') {
            return string;
        }
        block13: for (int i = 0; i < cArray.length; ++i) {
            switch (cArray[i]) {
                case '\n': {
                    stringBuffer.append('\\');
                    stringBuffer.append('n');
                    continue block13;
                }
                case '\t': {
                    stringBuffer.append('\\');
                    stringBuffer.append('t');
                    continue block13;
                }
                case '\u000b': {
                    stringBuffer.append('\\');
                    stringBuffer.append("013");
                    continue block13;
                }
                case '\b': {
                    stringBuffer.append('\\');
                    stringBuffer.append('b');
                    continue block13;
                }
                case '\r': {
                    stringBuffer.append('\\');
                    stringBuffer.append('r');
                    continue block13;
                }
                case '\f': {
                    stringBuffer.append('\\');
                    stringBuffer.append('f');
                    continue block13;
                }
                case '\u0007': {
                    stringBuffer.append('\\');
                    stringBuffer.append("007");
                    continue block13;
                }
                case '\\': {
                    stringBuffer.append('\\');
                    stringBuffer.append('\\');
                    continue block13;
                }
                case '\u0000': {
                    stringBuffer.append('\\');
                    stringBuffer.append('0');
                    continue block13;
                }
                case '\'': {
                    if (i == 1) {
                        stringBuffer.append('\\');
                        stringBuffer.append('\'');
                        continue block13;
                    }
                    stringBuffer.append(cArray[i]);
                    continue block13;
                }
                case '\"': {
                    if (i == 1) {
                        stringBuffer.append('\\');
                        stringBuffer.append('\"');
                        continue block13;
                    }
                    stringBuffer.append(cArray[i]);
                    continue block13;
                }
                default: {
                    stringBuffer.append(cArray[i]);
                }
            }
        }
        return stringBuffer.toString();
    }
}

