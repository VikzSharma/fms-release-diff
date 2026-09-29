/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.FieldEvents$BlurEvent
 *  com.vaadin.event.FieldEvents$FocusEvent
 *  com.vaadin.event.SerializableEventListener
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.AbstractField
 */
package com.filemaker.fields;

import com.filemaker.fields.client.common.FMClientRpc;
import com.filemaker.fields.client.common.FMServerRpc;
import com.filemaker.fields.client.common.FMState;
import com.filemaker.fields.client.common.FocusMode;
import com.filemaker.fields.interfaces.SelectionRange;
import com.filemaker.fields.interfaces.TextAreaEvents;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.event.FieldEvents;
import com.vaadin.event.SerializableEventListener;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.AbstractField;
import java.util.EventObject;

public abstract class FMField<T>
extends AbstractField<T> {
    private SelectionRange lastSelection = new SelectionRange();
    private HorizontalTextAlignment horizontalTextAlignment = HorizontalTextAlignment.LEFT;
    private VerticalTextAlignment verticalTextAlignment = VerticalTextAlignment.TOP;

    public FMField() {
        this.initBooleanState();
        this.registerRpc(new FMServerRpcImpl(this), FMServerRpc.class);
    }

    private void initBooleanState() {
        this.setNewLineAllowed(true);
        this.setWordwrap(true);
        this.setResetScrollPositionOnExit(true);
    }

    public void startEdit() {
        this.focus();
        ((FMClientRpc)this.getRpcProxy(FMClientRpc.class)).startEdit();
    }

    protected FMState getState() {
        return (FMState)super.getState();
    }

    protected FMState getState(boolean bl) {
        return (FMState)super.getState(bl);
    }

    public String getInputPrompt() {
        return this.getState((boolean)false).inputPrompt;
    }

    public void setInputPrompt(String string) {
        this.getState().inputPrompt = string;
    }

    public void setCursorPosition(int n) {
        this.setSelectionRange(n, 0);
    }

    public void setSelectionRange(int n, int n2) {
        this.lastSelection.setPosition(n);
        this.lastSelection.setLength(n2);
        ((FMClientRpc)this.getRpcProxy(FMClientRpc.class)).setSelectionRange(n, n2);
    }

    public void setSelectionRangeImmediately(int n, int n2) {
        this.lastSelection.setPosition(n);
        this.lastSelection.setLength(n2);
        ((FMClientRpc)this.getRpcProxy(FMClientRpc.class)).setSelectionRangeImmediately(n, n2);
    }

    public void selectAllText() {
        ((FMClientRpc)this.getRpcProxy(FMClientRpc.class)).selectAll();
    }

    public int getCursorPosition() {
        return this.lastSelection.getPosition();
    }

    public SelectionRange getSelectionRange() {
        return this.lastSelection;
    }

    public int getSelectionRangeEndPosition() {
        return this.lastSelection.getLength() + this.lastSelection.getPosition();
    }

    protected void setNewLineAllowed(boolean bl) {
        if (this.isNewLineAllowed() != bl) {
            this.updateBooleanState(FMState.BooleanState.newLineAllowed, bl);
        }
    }

    protected boolean isNewLineAllowed() {
        return this.getBooleanState(FMState.BooleanState.newLineAllowed);
    }

    public void setWordwrap(boolean bl) {
        if (this.isWordwrap() != bl) {
            this.updateBooleanState(FMState.BooleanState.wordwrap, bl);
        }
    }

    public boolean isWordwrap() {
        return this.getBooleanState(FMState.BooleanState.wordwrap);
    }

    public void showScrollbarsOnTextOverflow(boolean bl) {
        if (bl) {
            this.addStyleName("show-scrollbars");
        } else {
            this.removeStyleName("show-scrollbars");
        }
    }

    public void setResetScrollPositionOnExit(boolean bl) {
        if (this.isResetScrollPositionOnExit() != bl) {
            this.updateBooleanState(FMState.BooleanState.resetScrollPositionOnExit, bl);
        }
    }

    public boolean isResetScrollPositionOnExit() {
        return this.getBooleanState(FMState.BooleanState.resetScrollPositionOnExit);
    }

    public void addLineBreakBlockedListener(TextAreaEvents.LineBreakBlockedListener lineBreakBlockedListener) {
        this.addListener("linebreak", TextAreaEvents.LineBreakBlockedEvent.class, (SerializableEventListener)lineBreakBlockedListener, TextAreaEvents.LineBreakBlockedListener.lineBreakBlockedMethod);
    }

    public void removeLineBreakBlockedListener(TextAreaEvents.LineBreakBlockedListener lineBreakBlockedListener) {
        this.removeListener("linebreak", TextAreaEvents.LineBreakBlockedEvent.class, lineBreakBlockedListener);
    }

    public HorizontalTextAlignment getHorizontalTextAlignment() {
        return this.horizontalTextAlignment;
    }

    public void setHorizontalTextAlignment(HorizontalTextAlignment horizontalTextAlignment) {
        this.horizontalTextAlignment = horizontalTextAlignment;
        this.removeStyleName("horizontal-left");
        this.removeStyleName("horizontal-center");
        this.removeStyleName("horizontal-right");
        if (horizontalTextAlignment.equals((Object)HorizontalTextAlignment.LEFT)) {
            this.addStyleName("horizontal-left");
        } else if (horizontalTextAlignment.equals((Object)HorizontalTextAlignment.CENTER)) {
            this.addStyleName("horizontal-center");
        } else if (horizontalTextAlignment.equals((Object)HorizontalTextAlignment.RIGHT)) {
            this.addStyleName("horizontal-right");
        }
    }

    public VerticalTextAlignment getVerticalTextAlignment() {
        return this.verticalTextAlignment;
    }

    public void setVerticalTextAlignment(VerticalTextAlignment verticalTextAlignment) {
        this.verticalTextAlignment = verticalTextAlignment;
        this.removeStyleName("vertical-top");
        this.removeStyleName("vertical-middle");
        this.removeStyleName("vertical-bottom");
        if (verticalTextAlignment.equals((Object)VerticalTextAlignment.TOP)) {
            this.addStyleName("vertical-top");
        } else if (verticalTextAlignment.equals((Object)VerticalTextAlignment.MIDDLE)) {
            this.addStyleName("vertical-middle");
        } else if (verticalTextAlignment.equals((Object)VerticalTextAlignment.BOTTOM)) {
            this.addStyleName("vertical-bottom");
        }
    }

    public void setSelectContentsOnEdit(boolean bl) {
        if (this.isSelectContentsOnEdit() != bl) {
            this.updateBooleanState(FMState.BooleanState.selectContentsOnEdit, bl);
        }
    }

    public boolean isSelectContentsOnEdit() {
        return this.getBooleanState(FMState.BooleanState.selectContentsOnEdit);
    }

    public void setFocusMode(FocusMode focusMode) {
        this.getState().focusMode = focusMode;
    }

    public FocusMode getFocusMode() {
        return this.getState((boolean)false).focusMode;
    }

    public void setPaddingTop(Integer n) {
        this.getState().padding.top = n;
    }

    public Integer getPaddingTop() {
        return this.getState((boolean)false).padding.top;
    }

    public void setPaddingRight(Integer n) {
        this.getState().padding.right = n;
    }

    public Integer getPaddingRight() {
        return this.getState((boolean)false).padding.right;
    }

    public void setPaddingBottom(Integer n) {
        this.getState().padding.bottom = n;
    }

    public Integer getPaddingBottom() {
        return this.getState((boolean)false).padding.bottom;
    }

    public void setPaddingLeft(Integer n) {
        this.getState().padding.left = n;
    }

    public Integer getPaddingLeft() {
        return this.getState((boolean)false).padding.left;
    }

    private void updateBooleanState(FMState.BooleanState booleanState, boolean bl) {
        this.getState().fmbs = IWPUtilities.applyBooleanValue(this.getState().fmbs, booleanState.ordinal(), bl);
    }

    private boolean getBooleanState(FMState.BooleanState booleanState) {
        return IWPUtilities.getBooleanValue(this.getState((boolean)false).fmbs, booleanState.ordinal());
    }

    public void setPadding(Integer n, Integer n2, Integer n3, Integer n4) {
        this.getState().padding.top = n;
        this.getState().padding.right = n2;
        this.getState().padding.bottom = n3;
        this.getState().padding.left = n4;
    }

    public void syncServerValue() {
        ((FMClientRpc)this.getRpcProxy(FMClientRpc.class)).syncServerValue();
    }

    public void updateKeyboardType(int n) {
        this.getState().touchKeyboardType = n;
    }

    public abstract void onTextChange(String var1, boolean var2);

    public static enum HorizontalTextAlignment {
        LEFT,
        CENTER,
        RIGHT;

    }

    public static enum VerticalTextAlignment {
        TOP,
        MIDDLE,
        BOTTOM;

    }

    private class FMServerRpcImpl
    implements FMServerRpc {
        private FMField context;

        public FMServerRpcImpl(FMField fMField2) {
            this.context = fMField2;
        }

        @Override
        public void handleFocus() {
            FMField.this.fireEvent((EventObject)new FieldEvents.FocusEvent((Component)this.context));
        }

        @Override
        public void handleBlur() {
            FMField.this.fireEvent((EventObject)new FieldEvents.BlurEvent((Component)this.context));
        }

        @Override
        public void updateSelectionRange(int n, int n2) {
            FMField.this.lastSelection.setPosition(n);
            FMField.this.lastSelection.setLength(n2);
        }

        @Override
        public void handleBlockedLineBreak() {
            FMField.this.fireEvent((EventObject)((Object)new TextAreaEvents.LineBreakBlockedEvent((Component)this.context)));
        }
    }
}

