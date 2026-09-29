/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.common.DataObject
 */
package com.filemaker.jwpc.fmwp.datatype;

import com.filemaker.jwpc.common.DataObject;
import com.filemaker.jwpc.fmwp.api.thrift.service.FieldType;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLFieldSpec;
import com.filemaker.jwpc.fmwp.datatype.FieldOptionSet;
import com.filemaker.jwpc.fmwp.datatype.FieldValidationSet;

public class FieldMetaData {
    private IDLFieldSpec idlField;
    private FieldOptionSet fieldOptions;
    private FieldValidationSet fieldValidations;

    public FieldMetaData(IDLFieldSpec iDLFieldSpec) {
        this.idlField = iDLFieldSpec;
        this.fieldOptions = new FieldOptionSet(iDLFieldSpec.getOptions());
        this.fieldValidations = new FieldValidationSet(iDLFieldSpec.getValidations());
    }

    public String getName() {
        return this.idlField.getName();
    }

    public String isAutoEnterField() {
        return this.fieldOptions.hasFlagSet(FieldOptionSet.OptionBit.AutoEnter);
    }

    public String hasFourDigitYearValidation() {
        return this.fieldValidations.hasFlagSet(FieldValidationSet.ValidationFlag.StrictFourDigitYear);
    }

    public boolean isMaxCharsValidation() {
        return this.fieldValidations.isFlagSet(FieldValidationSet.ValidationFlag.ValidateMaxLength);
    }

    public String usesGlobalStorage() {
        return this.fieldOptions.hasFlagSet(FieldOptionSet.OptionBit.GlobalStorage);
    }

    public String getMaxRepeatValue() {
        return Short.toString(this.idlField.getMaxRepeat());
    }

    public String getMaxCharacters() {
        return Integer.toString(this.idlField.getMaxChars());
    }

    public String hasNotEmptyValidation() {
        return this.fieldValidations.hasFlagSet(FieldValidationSet.ValidationFlag.ValidateNotEmpty);
    }

    public String hasNumericOnlyValidation() {
        return this.fieldValidations.hasFlagSet(FieldValidationSet.ValidationFlag.StrictNumber);
    }

    public String getDataType() {
        String string = null;
        switch (this.idlField.getDataType()) {
            case DTBoolean: {
                string = "boolean";
                break;
            }
            case DTContainer: {
                string = "container";
                break;
            }
            case DTDate: {
                string = "date";
                break;
            }
            case DTNumber: {
                string = "number";
                break;
            }
            case DTText: {
                string = "text";
                break;
            }
            case DTTime: {
                string = "time";
                break;
            }
            case DTTimestamp: {
                string = "timestamp";
                break;
            }
            case DTUnknown: {
                string = "unknown";
            }
        }
        return string;
    }

    public String hasTimeOfDayValidation() {
        return this.fieldValidations.hasFlagSet(FieldValidationSet.ValidationFlag.StrictTimeOfDay);
    }

    public String getFieldType() {
        String string = this.idlField.getType() == null ? "normal" : (this.idlField.getType() == FieldType.FTUnknown ? "unknown" : this.idlField.getType().toString());
        return string;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DataObject.toString((Object)this.idlField));
        stringBuilder.append(this.fieldOptions.toString());
        stringBuilder.append(this.fieldValidations.toString());
        return stringBuilder.toString();
    }
}

