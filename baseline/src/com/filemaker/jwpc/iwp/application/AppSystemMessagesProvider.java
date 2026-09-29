/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.CustomizedSystemMessages
 *  com.vaadin.server.SystemMessages
 *  com.vaadin.server.SystemMessagesInfo
 *  com.vaadin.server.SystemMessagesProvider
 */
package com.filemaker.jwpc.iwp.application;

import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.vaadin.server.CustomizedSystemMessages;
import com.vaadin.server.SystemMessages;
import com.vaadin.server.SystemMessagesInfo;
import com.vaadin.server.SystemMessagesProvider;
import java.util.Locale;

public class AppSystemMessagesProvider
implements SystemMessagesProvider {
    private static final long serialVersionUID = -3249512230488657645L;

    public SystemMessages getSystemMessages(SystemMessagesInfo systemMessagesInfo) {
        Locale locale = systemMessagesInfo.getLocale();
        CustomizedSystemMessages customizedSystemMessages = new CustomizedSystemMessages();
        customizedSystemMessages.setSessionExpiredCaption(IWPI18N.get(locale, "SESSION_EXPIRED_CAPTION", new Object[0]));
        customizedSystemMessages.setSessionExpiredMessage(IWPI18N.get(locale, "SESSION_EXPIRED_MESSAGE", new Object[0]));
        customizedSystemMessages.setCommunicationErrorCaption(IWPI18N.get(locale, "COMMUNICATION_ERROR_CAPTION", new Object[0]));
        customizedSystemMessages.setCommunicationErrorMessage(IWPI18N.get(locale, "COMMUNICATION_ERROR_MESSAGE", new Object[0]));
        customizedSystemMessages.setAuthenticationErrorCaption(IWPI18N.get(locale, "AUTH_ERROR_CAPTION", new Object[0]));
        customizedSystemMessages.setAuthenticationErrorMessage(IWPI18N.get(locale, "AUTH_ERROR_MESSAGE", new Object[0]));
        customizedSystemMessages.setInternalErrorCaption(IWPI18N.get(locale, "SESSION_EXPIRED_CAPTION", new Object[0]));
        customizedSystemMessages.setInternalErrorMessage(IWPI18N.get(locale, "SESSION_EXPIRED_MESSAGE", new Object[0]));
        customizedSystemMessages.setCookiesDisabledCaption(IWPI18N.get(locale, "COOKIES_DISABLED_CAPTION", new Object[0]));
        customizedSystemMessages.setCookiesDisabledMessage(IWPI18N.get(locale, "COOKIES_DISABLED_MESSAGE", new Object[0]));
        return customizedSystemMessages;
    }
}

