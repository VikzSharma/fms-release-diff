/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  com.vaadin.server.ExternalResource
 *  com.vaadin.server.Resource
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.server.StreamResource$StreamSource
 *  com.vaadin.server.ThemeResource
 *  com.vaadin.server.VaadinSession
 *  com.vaadin.server.WebBrowser
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.Embedded
 *  com.vaadin.ui.HasComponents
 *  com.vaadin.ui.Image
 *  com.vaadin.ui.JavaScriptFunction
 *  com.vaadin.ui.Notification
 *  com.vaadin.ui.Notification$Type
 *  com.vaadin.v7.ui.HorizontalLayout
 *  com.vaadin.v7.ui.Label
 *  elemental.json.JsonArray
 *  elemental.json.JsonException
 */
package com.filemaker.jwpc.iwp.util;

import com.filemaker.fields.FMField;
import com.filemaker.fields.interfaces.SelectionRange;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppCardWindowContainer;
import com.filemaker.jwpc.iwp.application.AppController;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.thrift.common.Attribute;
import com.filemaker.jwpc.iwp.thrift.common.BinaryData;
import com.filemaker.jwpc.iwp.thrift.common.BrowserClientInfo;
import com.filemaker.jwpc.iwp.thrift.common.HAlign;
import com.filemaker.jwpc.iwp.thrift.common.IWPError;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldDataType;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldType;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.thrift.common.StringData;
import com.filemaker.jwpc.iwp.thrift.common.VAlign;
import com.filemaker.jwpc.iwp.thrift.layout.Data;
import com.filemaker.jwpc.iwp.thrift.layout.DataType;
import com.filemaker.jwpc.iwp.thrift.layout.FieldData;
import com.filemaker.jwpc.iwp.thrift.layout.FieldObjectData;
import com.filemaker.jwpc.iwp.ui.component.FileDownloadDialog;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.ValueListDataSource;
import com.filemaker.jwpc.iwp.ui.layout.component.ValueListItem;
import com.filemaker.jwpc.iwp.ui.layout.component.WDImageResource;
import com.filemaker.jwpc.iwp.ui.layout.component.container.ContainerContentFactory;
import com.filemaker.jwpc.iwp.ui.layout.component.container.ContainerEmbedded;
import com.filemaker.jwpc.iwp.util.IWPConstants;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.util.RemoteContainerUtilities;
import com.filemaker.jwpc.util.Utilities;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.server.StreamResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinSession;
import com.vaadin.server.WebBrowser;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HasComponents;
import com.vaadin.ui.Image;
import com.vaadin.ui.JavaScriptFunction;
import com.vaadin.ui.Notification;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.Label;
import elemental.json.JsonArray;
import elemental.json.JsonException;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public final class IWPUtilities {
    private static final String PDF_IMAGE_WHITE_BACKGROUND = "iwp-pdf-image-background";
    private static BufferedImage img = new BufferedImage(1, 1, 2);
    private static FontMetrics fm = img.getGraphics().getFontMetrics(new Font("Arial", 0, 11));
    private static FontMetrics fm_bold = img.getGraphics().getFontMetrics(new Font("Arial", 1, 11));
    private static final String RESERVED_CHARACTERS = ".*[/\\\\*?:$%|\"<>].*";
    private static AtomicInteger atomicCount = new AtomicInteger(0);
    public static final String POPUP_STATUS_CALLBACK = "myPopupStatusCallback";

    private IWPUtilities() {
    }

    public static boolean isAllowedFileName(String string) {
        boolean bl = true;
        if (Utilities.isEmptyString(string)) {
            bl = false;
        } else if (string.toLowerCase().matches(RESERVED_CHARACTERS)) {
            bl = false;
        }
        return bl;
    }

    public static int getBatchSize(App app, int n, int n2, int n3) {
        int n4 = (int)Math.floor(n / n2);
        n4 = n4 > 0 ? n4 : n3;
        return n4;
    }

    public static String createID(String string, String string2) {
        return (string + "_" + string2.replaceAll("\\s+", "_")).trim();
    }

    public static FieldObjectData createFieldObjectData(LayoutFieldObject layoutFieldObject, Object object) {
        Data data = new Data();
        FieldData fieldData = new FieldData();
        fieldData.setFieldSpec(layoutFieldObject.getAttributes().getFieldSpec());
        fieldData.setDataType(DataType.STRING);
        fieldData.setData(data);
        FieldObjectData fieldObjectData = new FieldObjectData();
        fieldObjectData.setObjectSpec(layoutFieldObject.getAttributes().getObjectSpec());
        fieldObjectData.setFieldData(fieldData);
        switch (layoutFieldObject.getMetaData().getType()) {
            case CONTAINER: {
                data.setBinaryValue((BinaryData)object);
                fieldData.setDataType(DataType.BINARY);
                break;
            }
            default: {
                StringData stringData = new StringData();
                if (object == null) {
                    stringData.setValue("");
                } else {
                    String string = (String)object;
                    if (string.endsWith("\n")) {
                        string = string.substring(0, string.length() - 1);
                    }
                    string = string.replace("\n", "\r");
                    stringData.setValue(string);
                }
                data.setStringValue(stringData);
                break;
            }
        }
        return fieldObjectData;
    }

    public static String generateLayoutKey(int n, boolean bl) {
        Object object = String.valueOf(n);
        if (bl) {
            object = (String)object + "_c";
        }
        return object;
    }

    public static String generateUniqueId(App app, LayoutObject layoutObject) {
        StringBuilder stringBuilder = new StringBuilder();
        if (app.getAppView().isCardStyleWindow()) {
            stringBuilder.append("c");
        }
        stringBuilder.append(layoutObject.getMetaData().getObjectIdPrefix());
        int n = layoutObject.getAttributes().getRecordIndex();
        if (app.isFormView() || layoutObject.getMetaData().isFixedPart()) {
            n = 0;
        }
        int n2 = layoutObject.getAttributes().getPortalRecordIndex();
        short s = layoutObject.getAttributes().getRepetition();
        return stringBuilder.append("i").append(n).append("i").append(n2).append("r").append(s).toString();
    }

    public static void assignUniqueId(App app, String string, Component component) {
        String string2 = string + 0 + component.getClass().getSimpleName().toLowerCase();
        component.setId(string2);
    }

    public static String[] splitValues(String string) {
        return string.replaceAll("\n", "\r").split("\r");
    }

    public static String getValueListStoredStringValue(ValueListDataSource valueListDataSource, Object object) {
        String string = "";
        if (object != null) {
            if (object instanceof ValueListItem) {
                string = ((ValueListItem)object).getStored();
            } else if (object instanceof Set) {
                string = IWPUtilities.convertValueListDataFromSetToStoredStringValue(valueListDataSource, (Set)object);
            } else if (valueListDataSource != null) {
                String string2 = (String)object;
                ValueListItem valueListItem = valueListDataSource.lookupDisplayed(string2);
                string = valueListItem != null ? valueListItem.getStored() : string2;
            }
        }
        return string;
    }

    private static String convertValueListDataFromSetToStoredStringValue(ValueListDataSource valueListDataSource, Set<Object> set) {
        Iterator<Object> iterator = set.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = true;
        while (iterator.hasNext()) {
            Object object = iterator.next();
            ValueListItem valueListItem = valueListDataSource.lookupDisplayed(object);
            if (valueListItem != null) {
                object = valueListItem.getStored();
            }
            if (!bl) {
                stringBuilder.append("\r");
            }
            stringBuilder.append(object);
            if (!bl) continue;
            bl = false;
        }
        return stringBuilder.toString();
    }

    public static Set<String> convertStringValueToValueListSet(ValueListDataSource valueListDataSource, String string) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        if (string != null) {
            String[] stringArray;
            for (String string2 : stringArray = IWPUtilities.splitValues(string)) {
                linkedHashSet.add(string2);
            }
        }
        return linkedHashSet;
    }

    public static void updateImage(AbstractComponent abstractComponent, BinaryData binaryData, boolean bl, boolean bl2) {
        byte[] byArray = binaryData.getData();
        String string = binaryData.getName();
        if (byArray != null && byArray.length > 0 && string != null) {
            IWPUtilities.constructImageResource(abstractComponent, binaryData);
            if (bl && binaryData.getMasterType().equalsIgnoreCase("application/pdf") && !bl2) {
                abstractComponent.addStyleName(PDF_IMAGE_WHITE_BACKGROUND);
            } else {
                abstractComponent.removeStyleName(PDF_IMAGE_WHITE_BACKGROUND);
            }
        }
    }

    public static void constructImageResource(AbstractComponent abstractComponent, BinaryData binaryData) {
        final byte[] byArray = binaryData.getData();
        String string = binaryData.getName();
        if (byArray != null && byArray.length > 0 && string != null) {
            String string2 = IWPUtilities.getDisplayFileExtension(binaryData);
            if (string2 == null) {
                string2 = "jpg";
            }
            String string3 = IWPUtilities.createContainerFileName(string, string2);
            StreamResource.StreamSource streamSource = new StreamResource.StreamSource(){

                public InputStream getStream() {
                    return new ByteArrayInputStream(byArray);
                }
            };
            WDImageResource wDImageResource = new WDImageResource(streamSource, string3);
            String string4 = IWPUtilities.getImageResourceMIMEType(byArray, binaryData.getDisplayType());
            if (string4 != null && string4.length() > 0) {
                wDImageResource.setMIMEType(string4);
            }
            if (abstractComponent instanceof Embedded) {
                ((Embedded)abstractComponent).setType(1);
                ((Embedded)abstractComponent).setSource((Resource)wDImageResource);
            } else if (abstractComponent instanceof Image) {
                ((Image)abstractComponent).setSource((Resource)wDImageResource);
            }
        }
    }

    public static String getImageResourceMIMEType(byte[] byArray, String string) {
        String string2 = null;
        try {
            string2 = ByteBuffer.wrap(Arrays.copyOfRange(byArray, 0, 4)).getInt() == -1991225785 && ByteBuffer.wrap(Arrays.copyOfRange(byArray, 4, 8)).getInt() == 218765834 ? "image/png" : (ByteBuffer.wrap(Arrays.copyOfRange(byArray, 0, 4)).getInt() == -2555936 ? "image/jpeg" : (ByteBuffer.wrap(Arrays.copyOfRange(byArray, 0, 4)).getInt() == 1195984440 ? "image/gif" : (ByteBuffer.wrap(Arrays.copyOfRange(byArray, 0, 2)).getShort() == 16973 ? "image/bmp" : string)));
        }
        catch (Exception exception) {
            string2 = string;
        }
        return string2;
    }

    public static String getResourceConnectorString(boolean bl, int n, String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        if (bl) {
            stringBuilder.append("webd/");
        }
        stringBuilder.append("APP/connector/");
        stringBuilder.append(n);
        stringBuilder.append('/');
        stringBuilder.append(string);
        stringBuilder.append("/source/");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static ExternalResource constructMediaResource(BinaryData binaryData) {
        return new ExternalResource(RemoteContainerUtilities.createStreamingURL(binaryData.getUrl()));
    }

    public static int[] getImageDimension(ByteArrayInputStream byteArrayInputStream, String string) {
        ImageReader imageReader = null;
        try {
            Iterator<ImageReader> iterator = ImageIO.getImageReadersBySuffix(string);
            imageReader = iterator.next();
            ImageInputStream imageInputStream = ImageIO.createImageInputStream(byteArrayInputStream);
            imageReader.setInput(imageInputStream);
            int n = imageReader.getWidth(imageReader.getMinIndex());
            int n2 = imageReader.getHeight(imageReader.getMinIndex());
            if (imageReader != null) {
                imageReader.dispose();
            }
            return new int[]{n, n2};
        }
        catch (Exception exception) {
            if (imageReader != null) {
                imageReader.dispose();
            }
            return new int[]{0, 0};
        }
    }

    public static String getFileExt(String string) {
        int n;
        if (string != null && (n = string.lastIndexOf(".")) > 0) {
            return string.substring(n + 1).toLowerCase();
        }
        return null;
    }

    public static String createContainerFileName(String string, String string2) {
        String string3 = string.replaceAll("\\s", "_");
        return string3 + "_" + IWPUtilities.GetCounter() + "." + string2;
    }

    public static void showDebugMessage(App app, String string) {
        if (IWPUtilities.isDebugMode()) {
            app.getMessenger().showTrayMessage(string);
        }
    }

    public static boolean isDebugMode() {
        return System.getProperty("fmDebug") != null;
    }

    public static String getTitle(App app, String string, int n) {
        Object object = IWPUtilities.isDebugMode() ? string + " [SID:" + n + ", RID:" + app.getUIId() + ", Roots Count:" + AppController.getAllActiveApp().size() + "]" : string;
        return object;
    }

    public static int getCTRLorMetaKey(App app) {
        return BrowserInfoHandler.isMacOSClient(app) ? 91 : 17;
    }

    public static boolean isValidSessionID(int n) {
        return n > 0;
    }

    public static boolean hasError(IWPError iWPError) {
        if (iWPError == null) {
            return true;
        }
        return !ErrorCode.fromValue((int)iWPError.getErrorCode()).ok();
    }

    public static String getErrorString(IWPError iWPError) {
        ErrorCode errorCode = ErrorCode.fromValue((int)iWPError.getErrorCode());
        return errorCode.name();
    }

    public static boolean isImageType(String string) {
        int n = string.indexOf(47);
        if (n != -1) {
            return string.substring(0, n).equalsIgnoreCase("image");
        }
        return false;
    }

    public static IWPError getInternalError() {
        return IWPUtilities.getIWPError(ErrorCode.InternalError);
    }

    public static boolean isAuthenticationError(int n) {
        return n == ErrorCode.UserAccountDisabled.getErrorCode() || n == ErrorCode.PasswordExpired.getErrorCode() || n == ErrorCode.InvalidUserAccount.getErrorCode() || n == ErrorCode.InvalidPassword.getErrorCode() || n == ErrorCode.AccessDenied.getErrorCode() || n == ErrorCode.LoginRequired.getErrorCode() || n == ErrorCode.TooManyInvalidAttempts.getErrorCode();
    }

    public static boolean isValidationError(IWPError iWPError) {
        int n = iWPError.getErrorCode();
        if (iWPError.isHasExtendedError()) {
            n = iWPError.getExtendedErrorCode();
        }
        return IWPUtilities.isValidationError(ErrorCode.fromValue((int)n));
    }

    public static boolean isValidationError(ErrorCode errorCode) {
        boolean bl = false;
        switch (errorCode) {
            case InvalidDate: 
            case InvalidTime: 
            case InvalidNumber: 
            case ValueOutOfRange: 
            case NotUniqueValue: 
            case NotExistingValue: 
            case NotMemberValue: 
            case NotValidValue: 
            case InvalidQueryValue: 
            case MissingRequiredValue: 
            case MissingJoinValue: 
            case ExceedsMaximumLength: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    public static String getStandardizedClientTimestamp(App app) {
        WebBrowser webBrowser = app.getWebBrowser();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(3, 2, new Locale("en", "US"));
        return IWPUtilities.ConvertToFourDigitYear(webBrowser, dateFormat);
    }

    public static TimeZone getBrowserTimeZone(int n) {
        return new SimpleTimeZone(n, "Fake client time zone");
    }

    private static String ConvertToFourDigitYear(WebBrowser webBrowser, DateFormat dateFormat) {
        if (dateFormat instanceof SimpleDateFormat) {
            Object object;
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat)dateFormat;
            String string = simpleDateFormat.toLocalizedPattern();
            if (string.contains("y")) {
                object = string.substring(string.indexOf("y"), string.lastIndexOf("y") + 1);
                string = string.replace((CharSequence)object, "yyyy");
                string = string.replace(",", "");
                string = string.replace("\u202fa", "a");
            }
            ((SimpleDateFormat)dateFormat).applyLocalizedPattern(string);
            object = IWPUtilities.getBrowserTimeZone(webBrowser.getTimezoneOffset());
            simpleDateFormat.setTimeZone((TimeZone)object);
            return simpleDateFormat.format(webBrowser.getCurrentDate());
        }
        return dateFormat.format(webBrowser.getCurrentDate());
    }

    public static int pixelsToInt(String string) {
        if (string.length() == 0) {
            return 0;
        }
        return Integer.parseInt(string.replace("px", ""));
    }

    public static IWPError getIWPError(ErrorCode errorCode) {
        return new IWPError(errorCode.getErrorCode(), errorCode.getErrorCode(), false, null, "", new HashMap<Attribute, String>());
    }

    public static boolean isValidObjectSpec(ObjectSpec objectSpec) {
        boolean bl = objectSpec != null && objectSpec.getObjectId() > 0 && objectSpec.getRepetition() > 0;
        return bl;
    }

    public static boolean representsSameFMLayoutObject(ObjectSpec objectSpec, ObjectSpec objectSpec2) {
        boolean bl;
        boolean bl2;
        boolean bl3 = IWPUtilities.isValidObjectSpec(objectSpec);
        boolean bl4 = bl2 = bl3 == (bl = IWPUtilities.isValidObjectSpec(objectSpec2));
        if (bl3 && bl) {
            bl2 = objectSpec.getObjectId() == objectSpec2.getObjectId() && objectSpec.getRepetition() == objectSpec2.getRepetition() && objectSpec.getPortalRowIndex() == objectSpec2.getPortalRowIndex() && objectSpec.getRowId() == objectSpec2.getRowId();
        }
        return bl2;
    }

    public static String getValueAfterInsert(String string, int n, int n2, String string2) {
        return new StringBuffer(string).replace(n, n2, string2).toString();
    }

    public static String getValueAfterDelete(String string, int n, boolean bl) {
        StringBuffer stringBuffer = new StringBuffer(string);
        int n2 = 0;
        n2 = bl ? n - 1 : n;
        try {
            stringBuffer.delete(n2, n2 + 1);
        }
        catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
            // empty catch block
        }
        return stringBuffer.toString();
    }

    public static void openHelp(App app) {
        BrowserClientInfo browserClientInfo = app.getBrowserInfoHandler().getBrowserClientInfo();
        StringBuilder stringBuilder = new StringBuilder();
        if (app.need_webd_VirtualDir()) {
            stringBuilder.append("../fmwd_help/");
        } else {
            stringBuilder.append("../../fmwd_help/");
        }
        stringBuilder.append(browserClientInfo.getBrowserLanguage()).append("/index.html");
        IWPUtilities.openURL(app, stringBuilder.toString());
    }

    public static void openURL(App app, String string) {
        IWPUtilities.openURL(app, string, "_blank");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void openURL(App app, String string, String string2) {
        boolean bl;
        VaadinSession vaadinSession = app.getSession();
        boolean bl2 = bl = !vaadinSession.hasLock();
        if (bl) {
            vaadinSession.lock();
        }
        try {
            IWPUtilities.addPopupStatusCallback(app);
            String string3 = String.format("<script>window.sessionStorage.removeItem(\"fmkey\");window.location.href=\"%s\"</script>", string);
            String string4 = String.format("var popup; window.%s((popup = window.open('','%s')) != null);popup.document.write('%s');", POPUP_STATUS_CALLBACK, string2, string3);
            app.getPage().getJavaScript().execute(string4);
            app.pushChanges();
        }
        catch (Exception exception) {
            System.err.println(exception);
        }
        finally {
            if (bl) {
                vaadinSession.unlock();
            }
        }
    }

    public static void addPopupStatusCallback(final App app) {
        app.getPage().getJavaScript().addFunction(POPUP_STATUS_CALLBACK, new JavaScriptFunction(){

            public void call(JsonArray jsonArray) throws JsonException {
                if (!jsonArray.getBoolean(0)) {
                    Notification.show((String)IWPI18N.get(app, "POPUP_BLOCKER_WARNING", new Object[0]), (Notification.Type)Notification.Type.WARNING_MESSAGE);
                }
            }
        });
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void openMailTo(App app, String string) {
        boolean bl;
        VaadinSession vaadinSession = app.getSession();
        boolean bl2 = bl = !vaadinSession.hasLock();
        if (bl) {
            vaadinSession.lock();
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            if (app.getPage().getWebBrowser().isIOS() && app.getPage().getWebBrowser().isSafari()) {
                stringBuilder.append("window.location='").append(string).append("'; return false;");
            } else {
                stringBuilder.append("var iframe = document.createElement('iframe');");
                stringBuilder.append("iframe.src = '" + string + "';");
                stringBuilder.append("iframe.style.display = 'none';");
                stringBuilder.append("document.body.appendChild(iframe);");
                stringBuilder.append("setTimeout(function() {");
                stringBuilder.append("document.body.removeChild(iframe);");
                stringBuilder.append("}, 500);");
            }
            app.getPage().getJavaScript().execute(stringBuilder.toString());
            app.pushChanges();
        }
        catch (Exception exception) {
            System.err.println(exception);
        }
        finally {
            if (bl) {
                vaadinSession.unlock();
            }
        }
    }

    public static void showFileDownloadDialog(App app, InputStream inputStream, String string, String string2) {
        FileDownloadDialog fileDownloadDialog = app.getAppView().getFileDownloadDialog();
        if (!fileDownloadDialog.isShown()) {
            fileDownloadDialog.showDialog();
        }
        fileDownloadDialog.addDownloadButton(inputStream, string2, string);
    }

    public static void showFileDownloadDialog(App app, String string, String string2, String string3, String string4) {
        FileDownloadDialog fileDownloadDialog = app.getAppView().getFileDownloadDialog();
        if (!fileDownloadDialog.isShown()) {
            fileDownloadDialog.showDialog();
        }
        fileDownloadDialog.addDownloadButton(string, string2, string4, string3);
    }

    public static String computeComponentPositioningCSS(ObjectMetaData objectMetaData, int n, int n2, AbstractComponent abstractComponent) {
        Object object = "";
        object = abstractComponent.getWidthUnits() == Sizeable.Unit.PERCENTAGE && (double)abstractComponent.getWidth() == 100.0 ? IWPUtilities.computeComponentHorizontalPositioningCSS(objectMetaData.getHAlign(), n, n) : IWPUtilities.computeComponentHorizontalPositioningCSS(objectMetaData.getHAlign(), n, (int)abstractComponent.getWidth());
        object = abstractComponent.getHeightUnits() == Sizeable.Unit.PERCENTAGE && (double)abstractComponent.getHeight() == 100.0 ? (String)object + IWPUtilities.computeComponentVerticalPositioningCSS(objectMetaData.getVAlign(), n2, n2) : (String)object + IWPUtilities.computeComponentVerticalPositioningCSS(objectMetaData.getVAlign(), n2, (int)abstractComponent.getHeight());
        if (abstractComponent instanceof ContainerEmbedded && ((ContainerEmbedded)abstractComponent).isGenericContainerType()) {
            int n3 = 32;
            Resource resource = ((ContainerEmbedded)abstractComponent).getSource();
            if (resource instanceof ThemeResource) {
                ThemeResource themeResource = (ThemeResource)resource;
                String string = themeResource.getResourceId();
                n3 = themeResource.equals((Object)ContainerContentFactory.GENERIC_DOCUMENT_ICON) ? 32 : (string.contains("48") ? 48 : (string.contains("64") ? 64 : (string.contains("128") ? 128 : 48)));
            }
            object = IWPUtilities.computeComponentHorizontalPositioningCSS(objectMetaData.getHAlign(), n, n3) + IWPUtilities.computeComponentVerticalPositioningCSS(objectMetaData.getVAlign(), n2, n3);
        }
        return object;
    }

    public static String computeComponentHorizontalPositioningCSS(HAlign hAlign, int n, int n2) {
        Object object = "";
        switch (hAlign) {
            case LEFT_ALIGN: {
                object = "left:0;";
                break;
            }
            case RIGHT_ALIGN: {
                object = "right:0;";
                break;
            }
            default: {
                object = "left: " + (n - n2) / 2 + "px;";
            }
        }
        return object;
    }

    public static String computeComponentVerticalPositioningCSS(VAlign vAlign, int n, int n2) {
        Object object = "";
        switch (vAlign) {
            case TOP_ALIGN: {
                object = (String)object + "top:0;";
                break;
            }
            case BOTTOM_ALIGN: {
                object = (String)object + "bottom:0;";
                break;
            }
            default: {
                object = (String)object + "top: " + (n - n2) / 2 + "px;";
            }
        }
        return object;
    }

    public static String getDatabaseNameFromFragment(String string) {
        String string2 = "";
        string2 = string.contains("?") ? string.substring(0, string.indexOf("?")) : string;
        return string2;
    }

    public static String getDatabaseNameFromPath(String string) {
        String string2 = "";
        if (Utilities.isValidText(string) && string.startsWith("/fmi/webd/") && !string.equals("/fmi/webd/")) {
            String string3 = string.substring("/fmi/webd".length());
            string2 = string3.substring(string3.lastIndexOf("/") + 1);
        }
        return string2;
    }

    public static LayoutFieldType getFieldTypeFromString(String string) {
        if (string.equals("e12")) {
            return LayoutFieldType.NORMAL;
        }
        if (string.equals("e4")) {
            return LayoutFieldType.CALCULATED;
        }
        if (string.equals("e16")) {
            return LayoutFieldType.SUMMARY;
        }
        return LayoutFieldType.INVALID;
    }

    public static LayoutFieldDataType getFieldDataTypeFromString(String string) {
        if (string.equalsIgnoreCase("text")) {
            return LayoutFieldDataType.TEXT;
        }
        if (string.equalsIgnoreCase("number")) {
            return LayoutFieldDataType.NUMBER;
        }
        if (string.equalsIgnoreCase("date")) {
            return LayoutFieldDataType.DATE;
        }
        if (string.equalsIgnoreCase("time")) {
            return LayoutFieldDataType.TIME;
        }
        if (string.equalsIgnoreCase("timestamp")) {
            return LayoutFieldDataType.TIMESTAMP;
        }
        if (string.equalsIgnoreCase("container")) {
            return LayoutFieldDataType.CONTAINER;
        }
        if (string.equalsIgnoreCase("boolean")) {
            return LayoutFieldDataType.BOOLEAN;
        }
        if (string.equalsIgnoreCase("invalid")) {
            return LayoutFieldDataType.INVALID;
        }
        if (string.equalsIgnoreCase("unknown")) {
            return LayoutFieldDataType.UNKNOWN;
        }
        return LayoutFieldDataType.UNKNOWN;
    }

    public static boolean isPDF(String string) {
        return string.equalsIgnoreCase("application/pdf");
    }

    public static boolean isAudio(String string) {
        return string.startsWith("audio");
    }

    public static boolean isVideo(String string) {
        return string.startsWith("video");
    }

    public static boolean isStreamingMedia(String string) {
        return IWPUtilities.isPDF(string) || IWPUtilities.isAudio(string) || IWPUtilities.isVideo(string);
    }

    public static String getDisplayFileExtension(BinaryData binaryData) {
        if (!binaryData.getType().equalsIgnoreCase(binaryData.getMasterType())) {
            return IWPUtilities.mimeTypeToFileExtension(binaryData.getType());
        }
        String string = IWPUtilities.getFileExt(binaryData.getName());
        if (string == null || string.length() == 0) {
            string = IWPUtilities.mimeTypeToFileExtension(binaryData.getMasterType());
        }
        return string;
    }

    private static String mimeTypeToFileExtension(String string) {
        if (string.equalsIgnoreCase("image/jpeg")) {
            return "jpg";
        }
        if (string.equalsIgnoreCase("image/png")) {
            return "png";
        }
        return "";
    }

    public static String determineTrueFileType(BinaryData binaryData) {
        if (!binaryData.getType().equalsIgnoreCase(binaryData.getMasterType())) {
            return binaryData.getMasterType();
        }
        return binaryData.getType();
    }

    public static String getMimeTypeFromFilename(String string) {
        String string2 = "";
        if (Utilities.isValidText(string)) {
            string = string.toLowerCase();
            string2 = URLConnection.getFileNameMap().getContentTypeFor(string);
            if (string2 == null || string2.equals("application/x-troff-msvideo")) {
                string2 = IWPUtilities.jwpcMimeTypeGuessFromFileName(string);
            }
            if (!Utilities.isValidText(string2)) {
                string2 = string.endsWith(".tab") ? "text/tab-separated-value" : (string.endsWith(".csv") ? "text/csv" : (string.endsWith(".mer") ? "application/octet-stream" : (string.endsWith(".psd") ? "image/vnd.adobe.photoshop" : "application/octet-stream")));
            }
        }
        return string2;
    }

    private static String jwpcMimeTypeGuessFromFileName(String string) {
        String string2;
        String string3 = null;
        int n = string.lastIndexOf(46);
        if (n > -1 && (string2 = string.substring(n + 1)) != null && string2.length() > 0) {
            if (string2.equals("mp4")) {
                string3 = "video/mp4";
            } else if (string2.equals("m4v")) {
                string3 = "video/mp4";
            } else if (string2.equals("m4a")) {
                string3 = "audio/mp4";
            } else if (string2.equals("pdf")) {
                string3 = "application/pdf";
            } else if (string2.equals("avi")) {
                string3 = "video/avi";
            }
        }
        return string3;
    }

    public static boolean isSupportedBrowser(WebBrowser webBrowser) {
        boolean bl = true;
        if (webBrowser.isOpera()) {
            bl = false;
        } else if (webBrowser.isIE()) {
            if (webBrowser.getBrowserMajorVersion() < 9) {
                bl = false;
            }
        } else if (webBrowser.isSafari() && webBrowser.getBrowserMajorVersion() < 6) {
            bl = webBrowser.getBrowserMajorVersion() == 5 && !webBrowser.getBrowserApplication().contains("Version");
        }
        return bl;
    }

    private static HorizontalLayout getGenericErrorPage(String string) {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSizeFull();
        horizontalLayout.setSpacing(true);
        horizontalLayout.setMargin(true);
        Label label = new Label(string);
        label.setStyleName("h1");
        horizontalLayout.addComponent((Component)label);
        horizontalLayout.setComponentAlignment((Component)label, Alignment.MIDDLE_CENTER);
        return horizontalLayout;
    }

    public static HorizontalLayout getUnsupportedBrowserScreen(App app) {
        return IWPUtilities.getGenericErrorPage(IWPI18N.get(app, "UNSUPPORTED_BROWSER_ERROR", new Object[0]));
    }

    public static HorizontalLayout getUnsupportedPageError(App app) {
        return IWPUtilities.getGenericErrorPage(IWPI18N.get(app, "UNSUPPORTED_PAGE_ERROR", new Object[0]));
    }

    public static HorizontalLayout getTechnologyDisabledScreen(App app) {
        return IWPUtilities.getGenericErrorPage(IWPI18N.get(app, "TECHNOLOGY_DISABLED", new Object[0]));
    }

    public static FontMetrics getFontMetrcs(String string, boolean bl, boolean bl2, int n) {
        int n2 = bl ? (bl2 ? 3 : 1) : (bl2 ? 2 : 0);
        return img.getGraphics().getFontMetrics(new Font(string, n2, n));
    }

    public static String getStringPixelLength(String string, String string2) {
        int n = IWPUtilities.getStringPixelLengthAsInt(string, string2);
        return n + "px";
    }

    public static int getStringPixelLengthAsInt(String string, String string2) {
        int n = fm.stringWidth(string);
        String string3 = string2;
        if (string3.equals("ja") || string3.equals("zh") || string3.equals("ko")) {
            n = n * 11 / 8;
        }
        return n + 10;
    }

    public static int getStringPixelLengthForButtons(String string, boolean bl, String string2) {
        if (!bl) {
            return IWPUtilities.getStringPixelLengthAsInt(string, string2);
        }
        int n = fm_bold.stringWidth(string);
        String string3 = string2;
        if (string3.equals("ja") || string3.equals("zh") || string3.equals("ko")) {
            n = n * 11 / 8;
        }
        return n + 20;
    }

    public static String mapISO6392CodeToISO6391(String string) {
        if (string == null || string.length() == 0) {
            return "en";
        }
        if (string.equals("eng")) {
            return "en";
        }
        if (string.equals("deu")) {
            return "de";
        }
        if (string.equals("fre")) {
            return "fr";
        }
        if (string.equals("ita")) {
            return "it";
        }
        if (string.equals("jpn")) {
            return "ja";
        }
        if (string.equals("swe")) {
            return "sv";
        }
        if (string.equals("spa")) {
            return "es";
        }
        if (string.equals("kor")) {
            return "ko";
        }
        if (string.equals("dut") || string.equals("nld")) {
            return "nl";
        }
        if (string.equals("por")) {
            return "pt";
        }
        if (string.equals("chi") || string.equals("zho")) {
            return "zh";
        }
        return "en";
    }

    public static String convertSpacesToNbsp(String string) {
        if (string == null) {
            return null;
        }
        Pattern pattern = Pattern.compile("\\u0020(?=\\u0020)|(?<=\\u0020)\\u0020");
        string = pattern.matcher(string).replaceAll("&nbsp;");
        string = string.replace("&#9;", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        return string;
    }

    public static String generateCFId(int n) {
        return "fm-cf-" + n;
    }

    public static String normailzeMimeType(String string) {
        if (string.equalsIgnoreCase("application/x-photoshop")) {
            return "image/vnd.adobe.photoshop";
        }
        return string;
    }

    public static String makeFilesystemSafeFilename(String object) {
        String string;
        object = ((String)object).replace('*', '_');
        object = ((String)object).replace('?', '_');
        object = ((String)object).replace('\"', '_');
        object = ((String)object).replace('<', '_');
        object = ((String)object).replace('>', '_');
        object = ((String)object).replace('|', '_');
        object = ((String)object).replace(':', '_');
        object = ((String)object).replace('/', '-');
        int n = ((String)(object = ((String)object).replace('\\', '_'))).indexOf(46);
        if (n >= 0 && ((string = ((String)object).substring(0, n)).equalsIgnoreCase("CON") || string.equalsIgnoreCase("PRN") || string.equalsIgnoreCase("AUX") || string.equalsIgnoreCase("NUL") || string.length() == 4 && string.charAt(3) >= '0' && string.charAt(3) <= '9' && (string.substring(0, 3).equalsIgnoreCase("COM") || string.substring(0, 3).equalsIgnoreCase("LPT")))) {
            object = "_" + (String)object;
        }
        return object;
    }

    public static boolean isLocalhostIpAddress(String string) {
        return string.equalsIgnoreCase("localhost") || string.equalsIgnoreCase("127.0.0.1");
    }

    public static SelectionRange getFieldSelectionRange(LayoutFieldObject layoutFieldObject) {
        SelectionRange selectionRange = new SelectionRange();
        if (layoutFieldObject != null && layoutFieldObject instanceof FMField) {
            FMField fMField = (FMField)((Object)layoutFieldObject);
            selectionRange.setPosition(fMField.getCursorPosition());
            selectionRange.setLength(fMField.getSelectionRangeEndPosition() - selectionRange.getPosition());
        }
        return selectionRange;
    }

    private static AtomicInteger GetCounter() {
        if (!atomicCount.compareAndSet(Integer.MAX_VALUE, 0)) {
            atomicCount.incrementAndGet();
        }
        return atomicCount;
    }

    public static int safeLongToInt(long l) {
        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
            throw new IllegalArgumentException(l + " cannot be cast to int. OverFlow exception!");
        }
        return (int)l;
    }

    public static String getImageCacheName(String string, int n, int n2) {
        return string + "_" + n + "x" + n2;
    }

    public static int applyBooleanValue(int n, int n2, boolean bl) {
        n = bl ? (n |= 1 << n2) : (n &= Integer.MAX_VALUE - (1 << n2));
        return n;
    }

    public static boolean getBooleanValue(int n, int n2) {
        return (n & 1 << n2) != 0;
    }

    public static void initConfigConstants() {
        Path path = Paths.get("/Library/FileMaker Server/Web Publishing/publishing-engine/wpeConfig.json", new String[0]);
        Path path2 = Paths.get("C:\\Program Files\\FileMaker\\FileMaker Server\\Web Publishing\\publishing-engine\\wpeConfig.json", new String[0]);
        Path path3 = Paths.get("/opt/FileMaker/FileMaker Server/Web Publishing/publishing-engine/wpeConfig.json", new String[0]);
        Path path4 = null;
        if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            path4 = path;
        } else if (Files.exists(path2, LinkOption.NOFOLLOW_LINKS)) {
            path4 = path2;
        } else if (Files.exists(path3, LinkOption.NOFOLLOW_LINKS)) {
            path4 = path3;
        }
        if (path4 != null) {
            try {
                int n;
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = (JsonObject)jsonParser.parse(new String(Files.readAllBytes(path4)));
                StringBuilder stringBuilder = new StringBuilder();
                int n2 = 30;
                if (jsonObject.has("jwpc_worker_count")) {
                    n2 = jsonObject.get("jwpc_worker_count").getAsInt();
                    stringBuilder.append("\\n\\t");
                    stringBuilder.append("jwpc_worker_count = " + n2 + " (Default = 30)");
                }
                int n3 = 50;
                if (jsonObject.has("cwpc_worker_count")) {
                    n3 = jsonObject.get("cwpc_worker_count").getAsInt();
                    stringBuilder.append("\\n\\t");
                    stringBuilder.append("cwpc_worker_count = " + n3 + " (Default = 50)");
                }
                if (jsonObject.has("dialog_max_duration")) {
                    n = jsonObject.get("dialog_max_duration").getAsInt();
                    stringBuilder.append("\\n\\t");
                    stringBuilder.append("dialog_max_duration = " + n + " (Default = " + IWPConstants.DIALOG_MAX_DURATION + ")");
                    IWPConstants.DIALOG_MAX_DURATION = n;
                }
                if (jsonObject.has("list_max_touchmove_offset")) {
                    n = jsonObject.get("list_max_touchmove_offset").getAsInt();
                    stringBuilder.append("\\n\\t");
                    stringBuilder.append("list_max_touchmove_offset = " + n + " (Default = " + IWPConstants.LIST_MAX_TOUCHMOVE_OFFSET + ")");
                    IWPConstants.LIST_MAX_TOUCHMOVE_OFFSET = n;
                }
                if (jsonObject.has("list_valuelist_throttle_delay")) {
                    n = jsonObject.get("list_valuelist_throttle_delay").getAsInt();
                    stringBuilder.append("\\n\\t");
                    stringBuilder.append("list_valuelist_throttle_delay = " + n + " (Default = " + IWPConstants.LIST_VALUELIST_THROTTLE_DELAY + ")");
                    IWPConstants.LIST_VALUELIST_THROTTLE_DELAY = n;
                }
                if (jsonObject.has("list_filtered_valuelist_throttle_delay")) {
                    n = jsonObject.get("list_filtered_valuelist_throttle_delay").getAsInt();
                    stringBuilder.append("\\n\\t");
                    stringBuilder.append("list_filtered_valuelist_throttle_delay = " + n + " (Default = " + IWPConstants.LIST_FILTERED_VALUELIST_THROTTLE_DELAY + ")");
                    IWPConstants.LIST_FILTERED_VALUELIST_THROTTLE_DELAY = n;
                }
                if (jsonObject.has("list_valuelist_item_throttle_delay")) {
                    n = jsonObject.get("list_valuelist_item_throttle_delay").getAsInt();
                    stringBuilder.append("\\n\\t");
                    stringBuilder.append("list_valuelist_item_throttle_delay = " + n + " (Default = " + IWPConstants.LIST_VALUELIST_ITEM_THROTTLE_DELAY + ")");
                    IWPConstants.LIST_VALUELIST_ITEM_THROTTLE_DELAY = n;
                }
                if (jsonObject.has("list_min_cache_multiplier")) {
                    double d = jsonObject.get("list_min_cache_multiplier").getAsDouble();
                    stringBuilder.append("\\n\\t");
                    stringBuilder.append("list_min_cache_multiplier = " + d + " (Default = " + IWPConstants.LIST_MIN_CACHE_MULTIPLIER + ")");
                    IWPConstants.LIST_MIN_CACHE_MULTIPLIER = d;
                }
                if (jsonObject.has("list_max_cache_multiplier")) {
                    double d = jsonObject.get("list_max_cache_multiplier").getAsDouble();
                    stringBuilder.append("\\n\\t");
                    stringBuilder.append("list_max_cache_multiplier = " + d + " (Default = " + IWPConstants.LIST_MAX_CACHE_MULTIPLIER + ")");
                    IWPConstants.LIST_MAX_CACHE_MULTIPLIER = d;
                }
                if (jsonObject.has("list_scroll_position_enabled")) {
                    boolean bl = jsonObject.get("list_scroll_position_enabled").getAsBoolean();
                    stringBuilder.append("\\n\\t");
                    stringBuilder.append("list_scroll_position_enabled = " + bl + " (Default = " + IWPConstants.LIST_SCROLL_POSITION_ENABLED + ")");
                    IWPConstants.LIST_SCROLL_POSITION_ENABLED = bl;
                }
                if (jsonObject.has("thrift_client_max_frame_size")) {
                    int n4 = jsonObject.get("thrift_client_max_frame_size").getAsInt();
                    stringBuilder.append("\\n\\t");
                    stringBuilder.append("thrift_client_max_frame_size = " + n4 + " (Default =" + IWPConstants.THRIFT_CLIENT_MAX_FRAME_SIZE + ")");
                    IWPConstants.THRIFT_CLIENT_MAX_FRAME_SIZE = n4;
                }
                IWPConstants.JWPC_WORKER_COUNT = n2;
                IWPConstants.THRIFT_CLIENT_WORKER_COUNT = n2 * 2;
                IWPConstants.THRIFT_SERVER_WORKER_MAX_COUNT = IWPConstants.THRIFT_CLIENT_WORKER_COUNT + n3;
                if (IWPConstants.THRIFT_SERVER_WORKER_MAX_COUNT < 10) {
                    IWPConstants.THRIFT_SERVER_WORKER_MAX_COUNT = 10;
                }
                IWPConstants.JWPC_NOTIFICATION_WORKER_COUNT = IWPConstants.THRIFT_SERVER_WORKER_MAX_COUNT;
                IWPConstants.WPE_CONFIG_INITIALIZED = true;
                IWPConstants.WPE_CONFIG_LOG = stringBuilder.toString();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public static URLConnection getXHR(String string) {
        try {
            return IWPUtilities.getXHR(string, null, false);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static URLConnection getXHR(String string, String string2) {
        try {
            return IWPUtilities.getXHR(string, string2, false);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static URLConnection getXHR(String string, boolean bl) {
        try {
            return IWPUtilities.getXHR(string, null, bl);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static URLConnection getXHR(String string, String string2, boolean bl) {
        try {
            URL uRL = new URL(string);
            HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
            if (Utilities.isValidText(string2)) {
                httpURLConnection.setRequestMethod(string2);
            }
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setReadTimeout(60000);
            if (string.toLowerCase().contains("https") && bl) {
                TrustManager[] trustManagerArray = new TrustManager[]{new X509TrustManager(){

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @Override
                    public void checkClientTrusted(X509Certificate[] x509CertificateArray, String string) {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] x509CertificateArray, String string) {
                    }
                }};
                SSLContext sSLContext = SSLContext.getInstance("SSL");
                sSLContext.init(null, trustManagerArray, new SecureRandom());
                ((HttpsURLConnection)httpURLConnection).setSSLSocketFactory(sSLContext.getSocketFactory());
                HostnameVerifier hostnameVerifier = new HostnameVerifier(){

                    @Override
                    public boolean verify(String string, SSLSession sSLSession) {
                        return true;
                    }
                };
                ((HttpsURLConnection)httpURLConnection).setHostnameVerifier(hostnameVerifier);
            }
            return httpURLConnection;
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String getCaseInsensitiveURI(String string) {
        int n = "/fmi/webd".length();
        if (string != null && string.length() >= n && string.substring(0, n).equalsIgnoreCase("/fmi/webd")) {
            return "/fmi/webd" + string.substring(n, string.length());
        }
        return string;
    }

    public static boolean isShareButtonAvailable(App app) {
        return false;
    }

    public static boolean isLayoutEditorAvailable(App app) {
        return app.getSessionContext() != null && app.getSessionContext().canEditLayout();
    }

    public static boolean isInCardWindow(Component component) {
        for (HasComponents hasComponents = component.getParent(); hasComponents != null; hasComponents = hasComponents.getParent()) {
            if (!(hasComponents instanceof AppCardWindowContainer)) continue;
            return true;
        }
        return false;
    }

    public static boolean isDBEnabledOAuth(int n) {
        return n == AuthType.kDatabaseUser.getValue() || n == AuthType.kBoth.getValue();
    }

    public static void setAttributeBySelector(App app, String string, String string2, String string3) {
        String string4 = string.replace("'", "\\'");
        String string5 = string2.replace("'", "\\'");
        String string6 = string3.replace("'", "\\'");
        String string7 = String.format("var el = document.querySelector('%s');if (el) { el.setAttribute('%s', '%s'); }", string4, string5, string6);
        app.getPage().getJavaScript().execute(string7);
    }

    public static void setAttributeById(App app, String string, String string2, String string3) {
        IWPUtilities.setAttributeBySelector(app, "#" + string, string2, string3);
    }

    public static void setAriaLabelById(App app, String string, String string2) {
        IWPUtilities.setAttributeById(app, string, "aria-label", string2);
    }

    public static String toSafeAltText(String string) {
        int n;
        if (string == null || string.isBlank()) {
            return "";
        }
        String string2 = string;
        int n2 = Math.max(string2.lastIndexOf(47), string2.lastIndexOf(92));
        if (n2 != -1) {
            string2 = string2.substring(n2 + 1);
        }
        if ((n = string2.lastIndexOf(46)) > 0) {
            string2 = string2.substring(0, n);
        }
        if ((string2 = string2.replaceAll("[_\\-\\.]+", " ").replaceAll("\\s+", " ").trim()).isBlank()) {
            return "";
        }
        String string3 = string2.toLowerCase();
        if (string3.matches("^(img|image|photo|picture|graphic|logo|icon|diagram|chart|table|file)\\s*\\d*$")) {
            return "";
        }
        if (string3.matches(".*\\b(image|photo|picture|graphic|logo|icon)$")) {
            return "";
        }
        if (string3.matches("^\\d{5,}$")) {
            return "";
        }
        String[] stringArray = string3.split(" ");
        if (stringArray.length <= 2) {
            for (String string4 : stringArray) {
                if (!string4.matches("(img|image|photo|pic|file|dsc|pxl)\\d*")) continue;
                return "";
            }
        }
        if (string2.length() < 3) {
            return "";
        }
        return string2;
    }

    public static enum AuthType {
        kServerAdmin(1),
        kDatabaseUser(2),
        kBoth(3),
        kOther(4);

        private final int value;

        private AuthType(int n2) {
            this.value = n2;
        }

        public int getValue() {
            return this.value;
        }
    }
}

