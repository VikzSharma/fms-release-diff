/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.fmwp.datatype;

import com.filemaker.jwpc.fmwp.datatype.BitFlags;

public class FieldOptionSet
extends BitFlags {
    public FieldOptionSet(int n) {
        super(n);
    }

    public String hasFlagSet(OptionBit optionBit) {
        return this.isFlagSet(optionBit.value) ? "yes" : "no";
    }

    public static enum OptionBit {
        AutoEnterVariable(1),
        AutoEnterSerial(2),
        AutoEnterConstant(4),
        AutoEnterCalc(8),
        AutoEnterPrevious(16),
        AlwaysEvaluateCalc(32),
        AutoEnterFurigana(64),
        OverwriteExisting(128),
        AutoEnterNoModify(256),
        GenerateSerialOnCommit(512),
        AutoEnterLookup(1024),
        Unmodifiable(2048),
        Reserved13(4096),
        Reserved14(8192),
        Reserved15(16384),
        Reserved16(32768),
        GlobalStorage(65536),
        NoStorage(131072),
        ClientComputation(262144),
        HasPureDependency(524288),
        PrimaryKey(0x100000),
        HasNoDependents(0x200000),
        NoStyleRunSupport(0x400000),
        SingleValueJoins(0x800000),
        SupplementalField(0x1000000),
        NoEquiFindSupport(0x2000000),
        Reserved27(0x4000000),
        RelaxedWordIndex(0x8000000),
        RelaxedValueIndex(0x10000000),
        WordIndex(0x20000000),
        PreventIndex(0x40000000),
        ValueIndex(Integer.MIN_VALUE),
        AutoEnter(AutoEnterVariable.value() | AutoEnterSerial.value() | AutoEnterConstant.value() | AutoEnterCalc.value() | AutoEnterPrevious.value() | AlwaysEvaluateCalc.value() | AutoEnterFurigana.value() | GenerateSerialOnCommit.value() | AutoEnterLookup.value()),
        AllIndexes(RelaxedWordIndex.value() | RelaxedValueIndex.value() | WordIndex.value() | ValueIndex.value());

        private int value;

        private OptionBit(int n2) {
            this.value = n2;
        }

        public int value() {
            return this.value;
        }
    }
}

