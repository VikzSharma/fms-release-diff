/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.businessobject;

import com.filemaker.jwpc.common.DataObject;

public class ProductInfo
extends DataObject {
    String mBuild = "";
    String mName = "";
    String mVersion = "";

    public ProductInfo(String string, String string2, String string3) {
        this.mBuild = string;
        this.mName = string2;
        this.mVersion = string3;
    }

    public void setBuild(String string) {
        this.mBuild = string;
    }

    public String getBuild() {
        return this.mBuild;
    }

    public void setName(String string) {
        this.mName = string;
    }

    public String getName() {
        return this.mName;
    }

    public void setVersion(String string) {
        this.mVersion = string;
    }

    public String getVersion() {
        return this.mVersion;
    }
}

