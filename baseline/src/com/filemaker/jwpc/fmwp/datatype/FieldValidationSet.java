/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.fmwp.datatype;

import com.filemaker.jwpc.fmwp.datatype.BitFlags;

public class FieldValidationSet
extends BitFlags {
    public static String YES = "yes";
    public static String NO = "no";

    public FieldValidationSet(int n) {
        super(n);
    }

    public String hasFlagSet(ValidationFlag validationFlag) {
        return this.isFlagSet(validationFlag.value) ? YES : NO;
    }

    public boolean isFlagSet(ValidationFlag validationFlag) {
        return this.isFlagSet(validationFlag.value);
    }

    public static enum ValidationFlag {
        ValidateCalc(1),
        ValidateCalcAlways(2),
        ValidateStrict(4),
        ValidateNotEmpty(8),
        ValidateUnique(16),
        ValidateExisting(32),
        ValidateRange(64),
        ValidateMessage(128),
        ValidateValueList(256),
        ValidateMaxLength(512),
        ValidateAlways(1024),
        ValidateOneValue(2048),
        StrictNumber(4096),
        StrictFourDigitYear(8192),
        StrictTimeOfDay(16384);

        private int value;

        private ValidationFlag(int n2) {
            this.value = n2;
        }

        public int value() {
            return this.value;
        }
    }
}

