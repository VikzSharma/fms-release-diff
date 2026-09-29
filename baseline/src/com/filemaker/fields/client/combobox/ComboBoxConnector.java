/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.dom.client.BlurEvent
 *  com.google.gwt.event.dom.client.FocusEvent
 *  com.google.gwt.user.client.Timer
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.fields.client.combobox;

import com.filemaker.fields.FMComboBox;
import com.filemaker.fields.client.combobox.ComboBoxClientRpc;
import com.filemaker.fields.client.combobox.ComboBoxItem;
import com.filemaker.fields.client.combobox.ComboBoxServerRpc;
import com.filemaker.fields.client.combobox.ComboBoxState;
import com.filemaker.fields.client.combobox.ComboBoxWidget;
import com.filemaker.fields.client.combobox.PageNavigationHandler;
import com.filemaker.fields.client.combobox.SelectionChangeHandler;
import com.filemaker.fields.client.combobox.SuggestionMenu;
import com.filemaker.fields.client.combobox.SuggestionProvider;
import com.filemaker.fields.client.combobox.UserInputChangeHandler;
import com.filemaker.fields.client.common.FMConnector;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.user.client.Timer;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;
import java.util.List;
import java.util.Set;

@Connect(value=FMComboBox.class)
public class ComboBoxConnector
extends FMConnector
implements PageNavigationHandler,
SelectionChangeHandler,
UserInputChangeHandler,
SuggestionProvider {
    private int currentIndex = 0;
    private int totalAmountOfOptions = 0;
    private ComboBoxClientRpc rpc = new ComboBoxClientRpcImpl();
    private Timer itemRequestTimer = null;
    private boolean waitingForItems = false;
    private String lastQueryString;

    @Override
    public void init() {
        super.init();
        this.registerRpc();
        this.getWidget().addNavigationListener(this);
        this.getWidget().addSelectionChangeHandler(this);
        this.getWidget().addUserInputChangeHandler(this);
        this.getWidget().setSuggestionProvider(this);
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        this.getWidget().setServerSelectedItem(this.getState().selectedItem);
    }

    private void registerRpc() {
        this.registerRpc(ComboBoxClientRpc.class, this.rpc);
    }

    @Override
    public ComboBoxState getState() {
        return (ComboBoxState)super.getState();
    }

    @Override
    public ComboBoxWidget getWidget() {
        return (ComboBoxWidget)super.getWidget();
    }

    private void showPage(final String string, final int n, final boolean bl, final boolean bl2) {
        this.clearItemRequestTimer();
        if (bl2 && !this.waitingForItems) {
            ((ComboBoxServerRpc)this.getRpcProxy(ComboBoxServerRpc.class)).requestOptions(string, n, this.getState().pageLength, bl);
            this.waitingForItems = string != null;
        } else {
            this.itemRequestTimer = new Timer(this){
                final /* synthetic */ ComboBoxConnector this$0;
                {
                    this.this$0 = comboBoxConnector;
                }

                public void run() {
                    if (this.this$0.waitingForItems) {
                        this.this$0.showPage(string, n, bl, bl2);
                    } else {
                        ((ComboBoxServerRpc)this.this$0.getRpcProxy(ComboBoxServerRpc.class)).requestOptions(string, n, this.this$0.getState().pageLength, bl);
                        this.this$0.waitingForItems = string != null;
                    }
                }
            };
            this.itemRequestTimer.schedule(200);
        }
    }

    @Override
    public void prevPageRequested() {
        int n = this.getState().pageLength;
        if (this.currentIndex > 0) {
            this.currentIndex = Math.max(this.currentIndex - n, 0);
            this.showPage(this.lastQueryString, this.currentIndex, false, true);
        }
    }

    @Override
    public void nextPageRequested() {
        int n = this.getState().pageLength;
        if (this.currentIndex < this.totalAmountOfOptions - n) {
            this.currentIndex += n;
            this.showPage(this.lastQueryString, this.currentIndex, false, true);
        }
    }

    @Override
    public void initialPageRequested() {
        this.currentIndex = 0;
        this.showPage(null, this.currentIndex, true, true);
    }

    @Override
    public void selectionChanged(ComboBoxItem comboBoxItem) {
        this.updateSelection(comboBoxItem, true);
    }

    @Override
    public void userInputChanged() {
        String string = this.getWidget().getUserInput();
        ComboBoxItem comboBoxItem = this.createItemFromUserInput(string);
        this.updateSelection(comboBoxItem, false);
    }

    private ComboBoxItem createItemFromUserInput(String string) {
        ComboBoxItem comboBoxItem = null;
        if (string.length() > 0) {
            comboBoxItem = new ComboBoxItem(null, string, string);
        }
        return comboBoxItem;
    }

    private void updateSelection(ComboBoxItem comboBoxItem, boolean bl) {
        this.getWidget().hideOptions();
        this.getWidget().setSelectedItem(comboBoxItem);
        ((ComboBoxServerRpc)this.getRpcProxy(ComboBoxServerRpc.class)).updateSelection(comboBoxItem, bl);
    }

    @Override
    public void provideSuggestions(String string) {
        this.currentIndex = 0;
        if (string != null && string.length() > 0) {
            this.showPage(SuggestionMenu.trimTrailingNewline(string), this.currentIndex, false, false);
        }
    }

    private void clearItemRequestTimer() {
        if (this.itemRequestTimer != null) {
            this.itemRequestTimer.cancel();
            this.itemRequestTimer = null;
        }
    }

    @Override
    public void onFocus(FocusEvent focusEvent) {
        this.getWidget().handleFocus();
        super.onFocus(focusEvent);
    }

    @Override
    public void onBlur(BlurEvent blurEvent) {
        if (this.getWidget().hasUserInputChanged()) {
            this.userInputChanged();
        }
        this.getWidget().handleBlur();
        super.onBlur(blurEvent);
        this.clearItemRequestTimer();
    }

    public void onUnregister() {
        super.onUnregister();
        this.clearItemRequestTimer();
    }

    public class ComboBoxClientRpcImpl
    implements ComboBoxClientRpc {
        @Override
        public void hideMenu() {
            ComboBoxConnector.this.clearItemRequestTimer();
            ComboBoxConnector.this.getWidget().hideOptions();
            ComboBoxConnector.this.waitingForItems = false;
        }

        @Override
        public void showMenu() {
            if (!ComboBoxConnector.this.getWidget().hasFocus()) {
                ComboBoxConnector.this.getWidget().setFocus(true);
            }
            ComboBoxConnector.this.clearItemRequestTimer();
            ComboBoxConnector.this.showPage(null, 0, true, true);
            ComboBoxConnector.this.waitingForItems = false;
        }

        @Override
        public void showOptions(List<ComboBoxItem> list, int n, int n2, int n3, Set<Integer> set, String string) {
            ComboBoxConnector.this.totalAmountOfOptions = n2;
            ComboBoxConnector.this.waitingForItems = false;
            ComboBoxConnector.this.lastQueryString = string;
            if (n3 != -1) {
                ComboBoxConnector.this.currentIndex = n3;
                ComboBoxConnector.this.getWidget().showOptions(list, n3, list.size(), n2, set);
            } else {
                ComboBoxConnector.this.getWidget().showOptions(list, n, list.size(), n2, set);
            }
        }
    }
}

