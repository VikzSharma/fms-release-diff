/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Button
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Button$ClickListener
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.Panel
 *  com.vaadin.ui.Window
 *  com.vaadin.ui.Window$CloseEvent
 *  com.vaadin.ui.Window$CloseListener
 *  com.vaadin.v7.shared.ui.label.ContentMode
 *  com.vaadin.v7.ui.HorizontalLayout
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.util.developertool;

import com.filemaker.jwpc.iwp.cache.CacheManager;
import com.filemaker.jwpc.iwp.util.IWPConstants;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.util.developertool.DeveloperToolType;
import com.filemaker.jwpc.iwp.util.developertool.DeveloperTools;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;
import com.vaadin.v7.shared.ui.label.ContentMode;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.VerticalLayout;
import java.util.Date;
import java.util.Map;

public class DeveloperToolWindow
extends Window {
    private static final String endLabel = "<b style=\"color: blue;\">----------------------------------END-------------------------------------</b><br><br>";
    private final VerticalLayout rootContainer;
    private final Panel msgPanel = new Panel();
    private final VerticalLayout msgContainer;

    public DeveloperToolWindow(final DeveloperTools developerTools, final DeveloperToolType developerToolType) {
        this.setResizable(true);
        this.rootContainer = new VerticalLayout();
        this.rootContainer.setSizeFull();
        this.setContent((Component)this.rootContainer);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setMargin(false);
        horizontalLayout.setSpacing(true);
        horizontalLayout.addComponent((Component)this.getClearButton());
        this.rootContainer.addComponent((Component)horizontalLayout);
        this.msgPanel.setSizeFull();
        this.msgContainer = new VerticalLayout();
        this.msgContainer.setSizeFull();
        this.msgContainer.setMargin(true);
        this.msgContainer.setSpacing(true);
        this.msgPanel.setContent((Component)this.msgContainer);
        this.rootContainer.addComponent((Component)this.msgPanel);
        this.rootContainer.setExpandRatio((Component)this.msgPanel, 1.0f);
        switch (developerToolType) {
            case UI_ACTION: {
                this.initUIActions(horizontalLayout);
                break;
            }
            case SERVER_NOTIFICATION: {
                this.initServerNotifications(horizontalLayout);
                break;
            }
            case UI_EVENT: {
                this.initUIEvent(horizontalLayout);
                break;
            }
            case THREAD_DUMP: {
                this.initThreadDump(horizontalLayout);
                break;
            }
            case THREAD_DIAGNOSTICS: {
                this.initThreadDiagnostics(horizontalLayout);
                break;
            }
            case CACHE_DIAGNOSTICS: {
                this.initCacheDiagnostics(horizontalLayout);
            }
        }
        this.addCloseListener(new Window.CloseListener(){
            final /* synthetic */ DeveloperToolWindow this$0;
            {
                this.this$0 = developerToolWindow;
            }

            public void windowClose(Window.CloseEvent closeEvent) {
                switch (developerToolType) {
                    case UI_ACTION: {
                        developerTools.closeUIActionsWindow(true);
                        break;
                    }
                    case SERVER_NOTIFICATION: {
                        developerTools.closeNotificationsWindow(true);
                        break;
                    }
                    case UI_EVENT: {
                        developerTools.closeUIEventWindow(true);
                        break;
                    }
                    case THREAD_DUMP: {
                        developerTools.closeThreadDumpWindow(true);
                        break;
                    }
                    case THREAD_DIAGNOSTICS: {
                        developerTools.closeThreadDiagnosticsWindow(true);
                        break;
                    }
                    case CACHE_DIAGNOSTICS: {
                        developerTools.closeCacheDiagnosticsWindow(true);
                    }
                }
            }
        });
    }

    private Button getClearButton() {
        Button button = new Button("Clear");
        button.addClickListener(new Button.ClickListener(){

            public void buttonClick(Button.ClickEvent clickEvent) {
                DeveloperToolWindow.this.msgContainer.removeAllComponents();
            }
        });
        return button;
    }

    private void initUIActions(HorizontalLayout horizontalLayout) {
        this.setCaption("Debug UI Actions");
        this.setWidth("400px");
        this.setHeight("400px");
        this.setPositionX(20);
        this.setPositionY(500);
        Label label = new Label("<b style=\"color: green;\">(Actions will be logged as and when you perform)</b>");
        label.setContentMode(ContentMode.HTML);
        horizontalLayout.addComponent((Component)label);
    }

    private void initServerNotifications(HorizontalLayout horizontalLayout) {
        this.setCaption("Debug Server Notifications");
        this.setWidth("400px");
        this.setHeight("400px");
        this.setPositionX(440);
        this.setPositionY(500);
        Label label = new Label("<b style=\"color: green;\">(Notifications will be logged when they arrive)</b> ");
        label.setContentMode(ContentMode.HTML);
        horizontalLayout.addComponent((Component)label);
    }

    private void initUIEvent(HorizontalLayout horizontalLayout) {
        this.setCaption("Debug UI Events");
        this.setWidth("400px");
        this.setHeight("400px");
        this.setPositionX(860);
        this.setPositionY(500);
        Label label = new Label("<b style=\"color: green;\">(Events will be logged for various listeners)</b> ");
        label.setContentMode(ContentMode.HTML);
        horizontalLayout.addComponent((Component)label);
    }

    private void initThreadDump(HorizontalLayout horizontalLayout) {
        this.setCaption("Debug Thread Dumps");
        this.setWidth("1000px");
        this.setHeight("600px");
        this.center();
        Button button = new Button("Thread Dump");
        horizontalLayout.addComponent((Component)button);
        Label label = new Label("<b style=\"color: green;\">(Click to get the latest dump of all active threads at the moment)</b> ");
        label.setContentMode(ContentMode.HTML);
        horizontalLayout.addComponent((Component)label);
        button.addClickListener(new Button.ClickListener(){

            public void buttonClick(Button.ClickEvent clickEvent) {
                DeveloperToolWindow.this.dumpStack();
            }
        });
    }

    private void initThreadDiagnostics(HorizontalLayout horizontalLayout) {
        this.setCaption("System Thread Diagnostics");
        this.setWidth("1000px");
        this.setHeight("600px");
        this.center();
        Button button = new Button("Thread Diagnostics");
        horizontalLayout.addComponent((Component)button);
        Label label = new Label("<b style=\"color: green;\">(Click to get the latest system thread diagnostics at the moment)</b> ");
        label.setContentMode(ContentMode.HTML);
        horizontalLayout.addComponent((Component)label);
        button.addClickListener(new Button.ClickListener(){

            public void buttonClick(Button.ClickEvent clickEvent) {
                DeveloperToolWindow.this.addThreadDiagnostics();
            }
        });
    }

    private void initCacheDiagnostics(HorizontalLayout horizontalLayout) {
        this.setCaption("System Cache Diagnostics");
        this.setWidth("1000px");
        this.setHeight("600px");
        this.center();
        Button button = new Button("Cache Diagnostics");
        horizontalLayout.addComponent((Component)button);
        Label label = new Label("<b style=\"color: green;\">(Click to get the latest system cache diagnostics at the moment)</b> ");
        label.setContentMode(ContentMode.HTML);
        horizontalLayout.addComponent((Component)label);
        button.addClickListener(new Button.ClickListener(){

            public void buttonClick(Button.ClickEvent clickEvent) {
                DeveloperToolWindow.this.addCacheDiagnostics();
            }
        });
    }

    private void addCacheDiagnostics() {
        VerticalLayout verticalLayout = new VerticalLayout();
        StringBuilder stringBuilder = new StringBuilder("<b style=\"color: blue;\">Time:</b> ").append(new Date()).append("<br>");
        stringBuilder.append(CacheManager.getCacheStatistics());
        Label label = new Label(stringBuilder.toString());
        label.setContentMode(ContentMode.HTML);
        verticalLayout.addComponent((Component)label);
        verticalLayout.setSizeFull();
        verticalLayout.setSpacing(true);
        this.msgContainer.removeAllComponents();
        this.msgContainer.addComponent((Component)verticalLayout);
    }

    public void addMessage(String string, String string2) {
        Label label;
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeFull();
        Label label2 = new Label("<b style=\"color: blue;\">Time:</b> " + String.valueOf(new Date()));
        label2.setContentMode(ContentMode.HTML);
        verticalLayout.addComponent((Component)label2);
        if (string != null) {
            label = new Label("<b style=\"color: blue;\">Title:</b> " + string);
            label.setContentMode(ContentMode.HTML);
            verticalLayout.addComponent((Component)label);
        }
        label = new Label("<b style=\"color: blue;\">Message:</b> " + string2);
        label.setContentMode(ContentMode.HTML);
        verticalLayout.addComponent((Component)label);
        verticalLayout.addComponent((Component)this.getEndLabel());
        this.msgContainer.addComponent((Component)verticalLayout);
    }

    private Label getEndLabel() {
        Label label = new Label(endLabel);
        label.setContentMode(ContentMode.HTML);
        return label;
    }

    private void dumpStack() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeFull();
        Label label = new Label("<b style=\"color: blue;\">Time:</b> " + String.valueOf(new Date()));
        label.setContentMode(ContentMode.HTML);
        verticalLayout.addComponent((Component)label);
        Label label2 = new Label("<b style=\"color: blue;\">Total active threads:</b> " + this.getThreadCount());
        label2.setContentMode(ContentMode.HTML);
        verticalLayout.addComponent((Component)label2);
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        this.fillThreadStack(stringBuilder, stringBuilder2);
        Label label3 = new Label("<b style=\"color: blue;\">Thread's ids and names:</b> " + stringBuilder2.toString());
        label3.setContentMode(ContentMode.HTML);
        verticalLayout.addComponent((Component)label3);
        Label label4 = new Label("<b style=\"color: blue;\">Stacks:</b><br> " + stringBuilder.toString());
        label4.setContentMode(ContentMode.HTML);
        verticalLayout.addComponent((Component)label4);
        verticalLayout.addComponent((Component)this.getEndLabel());
        this.msgContainer.addComponent((Component)verticalLayout);
    }

    private int getThreadCount() {
        return Thread.getAllStackTraces().size();
    }

    private void fillThreadStack(StringBuilder stringBuilder, StringBuilder stringBuilder2) {
        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        for (Thread thread : map.keySet()) {
            StackTraceElement[] stackTraceElementArray = map.get(thread);
            stringBuilder2.append("[id:" + thread.getId() + ", name:" + thread.getName() + "]");
            stringBuilder.append("<b style=\"color: red;\">Thread ID:[" + thread.getId() + "] Name:[" + thread.getName() + "] State:[" + String.valueOf((Object)thread.getState()) + "]</b><br>");
            for (StackTraceElement stackTraceElement : stackTraceElementArray) {
                stringBuilder.append("File: [" + stackTraceElement.getFileName() + "]     ");
                stringBuilder.append("Class: [" + stackTraceElement.getClassName() + "]     ");
                stringBuilder.append("Method: [" + stackTraceElement.getMethodName() + "]     ");
                stringBuilder.append("Line: [" + stackTraceElement.getLineNumber() + "] <br>");
            }
            stringBuilder.append("<br>");
        }
    }

    private void addThreadDiagnostics() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeFull();
        Label label = new Label("<b style=\"color: blue;\">Time:</b> " + String.valueOf(new Date()));
        label.setContentMode(ContentMode.HTML);
        verticalLayout.addComponent((Component)label);
        StringBuilder stringBuilder = new StringBuilder();
        DeveloperToolWindow.prepareStatistics(stringBuilder, "<br>", "<b style=\"color: green;\">", "</b>");
        Label label2 = new Label("<b style=\"color: blue;\">Diagnostics:</b> " + stringBuilder.toString());
        label2.setContentMode(ContentMode.HTML);
        verticalLayout.addComponent((Component)label2);
        verticalLayout.addComponent((Component)this.getEndLabel());
        this.msgContainer.addComponent((Component)verticalLayout);
    }

    public static void prepareStatistics(StringBuilder stringBuilder, String string, String string2, String string3) {
        if (!IWPConstants.WPE_CONFIG_INITIALIZED) {
            IWPUtilities.initConfigConstants();
        }
        DeveloperToolWindow.prepare(stringBuilder, "iwp-notification-executor", IWPConstants.JWPC_NOTIFICATION_WORKER_COUNT, string, string2, string3);
        DeveloperToolWindow.prepare(stringBuilder, "iwp-non-blocking-session-executor", IWPConstants.JWPC_WORKER_COUNT, string, string2, string3);
        stringBuilder.append(string).append(string);
    }

    private static void prepare(StringBuilder stringBuilder, String string, int n, String string2, String string3, String string4) {
        stringBuilder.append(string2 + " The pool '").append(string3).append(string).append(string4).append("' has following thread statistics as of ").append(new Date());
        stringBuilder.append(string2 + " Current number of threads actively executing the tasks in this pool : ").append(string3).append(n).append(string4);
    }
}

