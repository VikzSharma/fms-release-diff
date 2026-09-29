/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.metadata;

import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import java.util.LinkedHashMap;

public class RepetitionMetaData
extends ObjectMetaData {
    private String width;
    private String height;
    private int itop;
    private int ileft;
    private int iBottom;
    private int iRight;

    public RepetitionMetaData(LinkedHashMap<String, ?> linkedHashMap) {
        super(linkedHashMap);
    }

    public RepetitionMetaData(ObjectMetaData objectMetaData) {
        super(objectMetaData.jsonObject);
        this.width = objectMetaData.getWidth();
        this.height = objectMetaData.getHeight();
        this.itop = objectMetaData.getTopAsInt();
        this.ileft = objectMetaData.getLeftAsInt();
        this.iBottom = objectMetaData.getBottomAsInt();
        this.iRight = objectMetaData.getRightAsInt();
        this.layoutRoot = objectMetaData.layoutRoot;
        this.parent = objectMetaData.parent;
    }

    @Override
    public String getWidth() {
        return this.width;
    }

    public void setWidth(String string) {
        this.width = string;
    }

    @Override
    public String getHeight() {
        return this.height;
    }

    public void setHeight(String string) {
        this.height = string;
    }

    @Override
    public int getTopAsInt() {
        return this.itop;
    }

    public void setTop(int n) {
        this.itop = n;
    }

    @Override
    public int getLeftAsInt() {
        return this.ileft;
    }

    public void setLeft(int n) {
        this.ileft = n;
    }

    @Override
    public int getBottomAsInt() {
        return this.iBottom;
    }

    public void setBottom(int n) {
        this.iBottom = n;
    }

    @Override
    public int getRightAsInt() {
        return this.iRight;
    }

    public void setRight(int n) {
        this.iRight = n;
    }

    @Override
    public int getMinWidthAsInt() {
        return -1;
    }

    @Override
    public int getMinHeightAsInt() {
        return -1;
    }

    @Override
    public boolean containsKey(String string) {
        return super.containsKey(string);
    }
}

