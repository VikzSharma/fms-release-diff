/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.action;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.log.JWPCLogger;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UIAction {
    private static JWPCLogger logger = JWPCLogger.getLogger(UIAction.class);
    private static final String ACTION_STATE_CHANGE_EVENT = "ACTION_STATE_CHANGE";
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private boolean actionEnabled = true;
    protected final UIActionType actionType;

    public UIAction(UIActionType uIActionType) {
        this.actionType = uIActionType;
    }

    protected void performAction(App app, Object[] objectArray) {
        if (IWPUtilities.isDebugMode()) assert (objectArray == null);
        app.getAppSession().onUIAction(this.actionType, true);
    }

    public final void perform(App app, Object[] objectArray) {
        if (logger.isDebugLoggingEnabled()) {
            logger.debug(String.format("perform(arguments=%s)", objectArray));
        }
        if (this.isEnabledFor(app)) {
            this.performAction(app, objectArray);
        }
    }

    public boolean isEnabledFor(App app) {
        return this.actionEnabled;
    }

    public void setEnabled(boolean bl) {
        if (this.actionEnabled != bl) {
            this.actionEnabled = bl;
            Boolean bl2 = bl ? Boolean.FALSE : Boolean.TRUE;
            Boolean bl3 = bl ? Boolean.TRUE : Boolean.FALSE;
            this.support.firePropertyChange(ACTION_STATE_CHANGE_EVENT, bl2, bl3);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.support.addPropertyChangeListener(propertyChangeListener);
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.support.removePropertyChangeListener(propertyChangeListener);
    }
}

