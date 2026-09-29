/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.FieldEvents$BlurEvent
 *  com.vaadin.event.FieldEvents$BlurListener
 *  com.vaadin.event.FieldEvents$BlurNotifier
 *  com.vaadin.event.FieldEvents$FocusEvent
 *  com.vaadin.event.FieldEvents$FocusListener
 *  com.vaadin.event.FieldEvents$FocusNotifier
 *  com.vaadin.event.SerializableEventListener
 *  com.vaadin.shared.Registration
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.data.Property
 *  com.vaadin.v7.data.Property$ReadOnlyException
 *  com.vaadin.v7.event.FieldEvents$TextChangeEvent
 *  com.vaadin.v7.event.FieldEvents$TextChangeListener
 *  com.vaadin.v7.event.FieldEvents$TextChangeNotifier
 *  com.vaadin.v7.ui.AbstractTextField
 */
package com.filemaker.fields;

import com.filemaker.fields.FMField;
import com.filemaker.fields.client.textarea.TextAreaServerRpc;
import com.filemaker.fields.client.textarea.TextAreaState;
import com.vaadin.event.FieldEvents;
import com.vaadin.event.SerializableEventListener;
import com.vaadin.shared.Registration;
import com.vaadin.ui.Component;
import com.vaadin.v7.data.Property;
import com.vaadin.v7.event.FieldEvents;
import com.vaadin.v7.ui.AbstractTextField;
import java.util.EventObject;

public class FMTextArea
extends FMField<String>
implements FieldEvents.BlurNotifier,
FieldEvents.FocusNotifier,
FieldEvents.TextChangeNotifier {
    private String nullRepresentation = "null";
    private boolean nullSettingAllowed = false;
    private boolean clientSideTextChangeEvent;

    public FMTextArea() {
        this.setValue("");
        this.registerRpc(new TextAreaRpcImpl(), TextAreaServerRpc.class);
    }

    public FMTextArea(String string) {
        this();
        this.setCaption(string);
    }

    public FMTextArea(Property<String> property) {
        this();
        this.setPropertyDataSource(property);
    }

    public FMTextArea(String string, Property<String> property) {
        this(property);
        this.setCaption(string);
    }

    public FMTextArea(String string, String string2) {
        this(string);
        this.setValue(string2);
    }

    @Override
    protected TextAreaState getState() {
        return (TextAreaState)super.getState();
    }

    @Override
    protected TextAreaState getState(boolean bl) {
        return (TextAreaState)super.getState(bl);
    }

    public void beforeClientResponse(boolean bl) {
        super.beforeClientResponse(bl);
        this.updateFieldValue();
    }

    protected void updateFieldValue() {
        String string = (String)this.getValue();
        if (string == null) {
            string = this.getNullRepresentation();
        }
        this.getState().text = string;
    }

    @Override
    public void setNewLineAllowed(boolean bl) {
        super.setNewLineAllowed(bl);
    }

    @Override
    public boolean isNewLineAllowed() {
        return super.isNewLineAllowed();
    }

    public Class<String> getType() {
        return String.class;
    }

    public String getNullRepresentation() {
        return this.nullRepresentation;
    }

    public boolean isNullSettingAllowed() {
        return this.nullSettingAllowed;
    }

    public void setNullRepresentation(String string) {
        this.nullRepresentation = string;
        this.markAsDirty();
    }

    public void setNullSettingAllowed(boolean bl) {
        this.nullSettingAllowed = bl;
        this.markAsDirty();
    }

    public boolean isEmpty() {
        return super.isEmpty() || ((String)this.getValue()).length() == 0;
    }

    private void fireTextChangeEvent(String string) {
        this.fireEvent((EventObject)((Object)new TextChangeEventImpl(this, string)));
    }

    protected void setInternalValue(String string) {
        if (this.clientSideTextChangeEvent) {
            this.fireTextChangeEvent(string);
        }
        super.setInternalValue((Object)string);
    }

    public void setValue(String string) throws Property.ReadOnlyException {
        super.setValue((Object)string);
    }

    public void addTextChangeListener(FieldEvents.TextChangeListener textChangeListener) {
        this.addListener("ie", FieldEvents.TextChangeEvent.class, (SerializableEventListener)textChangeListener, FieldEvents.TextChangeListener.EVENT_METHOD);
    }

    public void removeTextChangeListener(FieldEvents.TextChangeListener textChangeListener) {
        this.removeListener("ie", FieldEvents.TextChangeEvent.class, textChangeListener);
    }

    public void selectAll() {
        super.selectAllText();
    }

    public Registration addFocusListener(FieldEvents.FocusListener focusListener) {
        return this.addListener("focus", FieldEvents.FocusEvent.class, (SerializableEventListener)focusListener, FieldEvents.FocusListener.focusMethod);
    }

    public Registration addBlurListener(FieldEvents.BlurListener blurListener) {
        return this.addListener("blur", FieldEvents.BlurEvent.class, (SerializableEventListener)blurListener, FieldEvents.BlurListener.blurMethod);
    }

    @Override
    public void onTextChange(String string, boolean bl) {
    }

    public class TextAreaRpcImpl
    implements TextAreaServerRpc {
        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void updateValue(String string) {
            FMTextArea.this.clientSideTextChangeEvent = true;
            try {
                if (!FMTextArea.this.isReadOnly()) {
                    String string2 = string;
                    String string3 = (String)FMTextArea.this.getValue();
                    if (string2 != null && (string3 == null || FMTextArea.this.isNullSettingAllowed()) && string2.equals(FMTextArea.this.getNullRepresentation())) {
                        string2 = null;
                    }
                    if (!(string2 == string3 || string2 != null && string2.equals(string3))) {
                        boolean bl = FMTextArea.this.isModified();
                        FMTextArea.this.setValue(string2, true);
                        if (bl != FMTextArea.this.isModified()) {
                            FMTextArea.this.markAsDirty();
                        }
                    }
                }
            }
            finally {
                FMTextArea.this.clientSideTextChangeEvent = false;
            }
        }
    }

    public static class TextChangeEventImpl
    extends FieldEvents.TextChangeEvent {
        private String curText;
        private int cursorPosition;

        private TextChangeEventImpl(FMTextArea fMTextArea, String string) {
            super((Component)fMTextArea);
            this.curText = string;
        }

        public AbstractTextField getComponent() {
            return (AbstractTextField)super.getComponent();
        }

        public String getText() {
            return this.curText;
        }

        public int getCursorPosition() {
            return this.cursorPosition;
        }
    }
}

