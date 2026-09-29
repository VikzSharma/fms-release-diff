/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.client.ui.draganddropwrapper.DragAndDropWrapperConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.container.Container;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.ContainerClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.ContainerState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomContainer;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.draganddropwrapper.DragAndDropWrapperConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=Container.class)
public class ContainerConnector
extends DragAndDropWrapperConnector {
    public ContainerConnector() {
        this.registerRpc(ContainerClientRpc.class, new ContainerClientRpc(){

            @Override
            public void setActive(boolean bl) {
                ContainerConnector.this.getWidget().setActiveStyles(bl);
            }
        });
    }

    public VCustomContainer getWidget() {
        return (VCustomContainer)super.getWidget();
    }

    public ContainerState getState() {
        return (ContainerState)super.getState();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        this.getWidget().updateState(this.getState());
    }
}

