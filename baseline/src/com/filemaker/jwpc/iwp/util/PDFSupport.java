/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fmi.net.URLEncoder
 *  com.vaadin.server.DownloadStream
 *  com.vaadin.server.StreamResource
 *  com.vaadin.server.StreamResource$StreamSource
 *  javax.ws.rs.core.UriBuilder
 *  org.apache.pdfbox.pdmodel.PDDocument
 *  org.apache.pdfbox.pdmodel.PDPage
 *  org.apache.pdfbox.pdmodel.PDPageContentStream
 *  org.apache.pdfbox.pdmodel.common.PDRectangle
 *  org.apache.pdfbox.pdmodel.encryption.AccessPermission
 *  org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException
 *  org.apache.pdfbox.pdmodel.encryption.ProtectionPolicy
 *  org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy
 *  org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory
 *  org.apache.pdfbox.rendering.ImageType
 *  org.apache.pdfbox.rendering.PDFRenderer
 */
package com.filemaker.jwpc.iwp.util;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.thrift.common.SaveAsPDFSettings;
import com.filemaker.jwpc.iwp.thrift.notification.SaveAsPDFNotification;
import com.filemaker.jwpc.iwp.ui.component.FileDownloadDialog;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.util.Utilities;
import com.fmi.net.URLEncoder;
import com.vaadin.server.DownloadStream;
import com.vaadin.server.StreamResource;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import javax.ws.rs.core.UriBuilder;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.encryption.ProtectionPolicy;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

public final class PDFSupport {
    private static final String OWNER_PASSWORD_KEY = "fm-OP";
    private static final int INTERNAL_PRINT_CONTAINER_PDF_MARKER = -1;

    public static PDFInputStream getInputStream(String string, String string2) {
        PDFInputStream pDFInputStream = new PDFInputStream();
        try {
            File file = new File(string);
            PDDocument pDDocument = null;
            if (string2 != null && !string2.isEmpty()) {
                try {
                    Object object;
                    pDDocument = PDDocument.load((File)file, (String)string2);
                    AccessPermission accessPermission = pDDocument.getCurrentAccessPermission();
                    if (accessPermission == null || accessPermission.isOwnerPermission()) {
                        pDDocument.setAllSecurityToBeRemoved(true);
                    } else {
                        object = pDDocument.getDocumentInformation();
                        String string3 = object.getCustomMetadataValue(OWNER_PASSWORD_KEY);
                        if (Utilities.isValidText(string3)) {
                            object.setCustomMetadataValue(OWNER_PASSWORD_KEY, null);
                            StandardProtectionPolicy standardProtectionPolicy = new StandardProtectionPolicy(string3, "", accessPermission);
                            standardProtectionPolicy.setPermissions(accessPermission);
                            pDDocument.protect((ProtectionPolicy)standardProtectionPolicy);
                        } else {
                            pDDocument.setAllSecurityToBeRemoved(true);
                        }
                    }
                    object = new ByteArrayOutputStream();
                    pDDocument.save((OutputStream)object);
                    pDDocument.close();
                    pDFInputStream.contentLength = ((ByteArrayOutputStream)object).size();
                    pDFInputStream.stream = new ByteArrayInputStream(((ByteArrayOutputStream)object).toByteArray());
                }
                catch (InvalidPasswordException invalidPasswordException) {
                    string2 = null;
                }
            }
            if (string2 == null || string2.isEmpty()) {
                pDFInputStream.contentLength = (int)file.length();
                pDFInputStream.stream = new FileInputStream(file);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return pDFInputStream;
    }

    private static boolean shouldApplyPrintContainerPDFSettings(SaveAsPDFNotification saveAsPDFNotification) {
        return saveAsPDFNotification != null && saveAsPDFNotification.isViewPDF() && saveAsPDFNotification.isSetSettings() && saveAsPDFNotification.getSettings().getDocSaveType() == -1;
    }

    private static float inchesToPoints(double d) {
        return Math.round(d * 72.0);
    }

    private static float mmToPoints(double d) {
        return Math.round(d * 72.0 / 25.4);
    }

    private static PDRectangle getPaperRectangle(SaveAsPDFSettings saveAsPDFSettings) {
        float f;
        int n = saveAsPDFSettings.getPaperSize();
        if (n < 0 || n > 10) {
            n = 0;
        }
        float f2 = switch (n) {
            case 1 -> {
                f = PDFSupport.inchesToPoints(11.0);
                yield PDFSupport.inchesToPoints(17.0);
            }
            case 2 -> {
                f = PDFSupport.inchesToPoints(8.5);
                yield PDFSupport.inchesToPoints(14.0);
            }
            case 3 -> {
                f = PDFSupport.inchesToPoints(5.5);
                yield PDFSupport.inchesToPoints(8.5);
            }
            case 4 -> {
                f = PDFSupport.inchesToPoints(7.25);
                yield PDFSupport.inchesToPoints(10.5);
            }
            case 5 -> {
                f = PDFSupport.inchesToPoints(8.5);
                yield PDFSupport.inchesToPoints(13.0);
            }
            case 6 -> {
                f = PDFSupport.mmToPoints(297.0);
                yield PDFSupport.mmToPoints(420.0);
            }
            case 7 -> {
                f = PDFSupport.mmToPoints(210.0);
                yield PDFSupport.mmToPoints(297.0);
            }
            case 8 -> {
                f = PDFSupport.mmToPoints(148.0);
                yield PDFSupport.mmToPoints(210.0);
            }
            case 9 -> {
                f = PDFSupport.mmToPoints(250.0);
                yield PDFSupport.mmToPoints(353.0);
            }
            case 10 -> {
                f = PDFSupport.mmToPoints(176.0);
                yield PDFSupport.mmToPoints(250.0);
            }
            default -> {
                f = PDFSupport.inchesToPoints(8.5);
                yield PDFSupport.inchesToPoints(11.0);
            }
        };
        if (saveAsPDFSettings.getPageOrientation() > 1) {
            float f3 = f;
            f = f2;
            f2 = f3;
        }
        return new PDRectangle(f, f2);
    }

    /*
     * Enabled aggressive exception aggregation
     */
    private static File createPrintContainerPDFOutput(String string, SaveAsPDFSettings saveAsPDFSettings, String string2) {
        if (string == null || string.isEmpty() || saveAsPDFSettings == null) {
            return null;
        }
        File file = new File(string);
        if (!file.exists()) {
            return null;
        }
        float f = saveAsPDFSettings.getScaling() > 0.0 ? (float)saveAsPDFSettings.getScaling() : 1.0f;
        float f2 = Math.min(288.0f, Math.max(144.0f, 144.0f * Math.max(f, 1.0f)));
        PDRectangle pDRectangle = PDFSupport.getPaperRectangle(saveAsPDFSettings);
        try (PDDocument pDDocument = PDFSupport.loadPrintContainerPDFSourceDocument(file, string2);){
            Object object;
            try (PDDocument pDDocument2 = new PDDocument();){
                PDFRenderer pDFRenderer = new PDFRenderer(pDDocument);
                for (int i = 0; i < pDDocument.getNumberOfPages(); ++i) {
                    float f3;
                    object = pDDocument.getPage(i);
                    PDRectangle pDRectangle2 = object.getCropBox();
                    if (pDRectangle2 == null || pDRectangle2.getWidth() <= 0.0f || pDRectangle2.getHeight() <= 0.0f) {
                        pDRectangle2 = object.getMediaBox();
                    }
                    BufferedImage bufferedImage = pDFRenderer.renderImageWithDPI(i, f2, ImageType.RGB);
                    PDPage pDPage = new PDPage(pDRectangle);
                    pDDocument2.addPage(pDPage);
                    float f4 = pDRectangle.getWidth();
                    float f5 = pDRectangle.getHeight();
                    float f6 = pDRectangle2 != null ? pDRectangle2.getWidth() : 0.0f;
                    float f7 = pDRectangle2 != null ? pDRectangle2.getHeight() : 0.0f;
                    int n = object.getRotation();
                    if (n == 90 || n == 270) {
                        f3 = f6;
                        f6 = f7;
                        f7 = f3;
                    }
                    if (f6 <= 0.0f || f7 <= 0.0f) {
                        f6 = (float)bufferedImage.getWidth() * 72.0f / f2;
                        f7 = (float)bufferedImage.getHeight() * 72.0f / f2;
                    }
                    f3 = f6 * f;
                    float f8 = f7 * f;
                    float f9 = (f4 - f3) / 2.0f;
                    float f10 = (f5 - f8) / 2.0f;
                    try (PDPageContentStream pDPageContentStream = new PDPageContentStream(pDDocument2, pDPage);){
                        pDPageContentStream.drawImage(LosslessFactory.createFromImage((PDDocument)pDDocument2, (BufferedImage)bufferedImage), f9, f10, f3, f8);
                        continue;
                    }
                }
                if (Utilities.isValidText(string2)) {
                    AccessPermission accessPermission = new AccessPermission();
                    accessPermission.setCanPrint(true);
                    object = new StandardProtectionPolicy(string2, string2, accessPermission);
                    pDDocument2.protect((ProtectionPolicy)object);
                }
                File file2 = File.createTempFile("print-pdf-", ".pdf", file.getParentFile());
                pDDocument2.save(file2);
                file.delete();
                object = file2;
            }
            return object;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }

    private static PDDocument loadPrintContainerPDFSourceDocument(File file, String string) throws IOException {
        try {
            return PDDocument.load((File)file);
        }
        catch (InvalidPasswordException invalidPasswordException) {
            if (Utilities.isValidText(string)) {
                try {
                    return PDDocument.load((File)file, (String)string);
                }
                catch (InvalidPasswordException invalidPasswordException2) {
                    // empty catch block
                }
            }
            return PDDocument.load((File)file, (String)"");
        }
    }

    public static boolean handlePDFResult(App app, SaveAsPDFNotification saveAsPDFNotification) {
        boolean bl = true;
        String string = saveAsPDFNotification.getOutputPath();
        if (Utilities.isWindows()) {
            string = string.replace("\\", "/");
        }
        String string2 = "";
        try {
            string2 = URLEncoder.encode((String)saveAsPDFNotification.getViewName(), (String)"UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        }
        int n = string.lastIndexOf("PDF-");
        String string3 = string.substring(0, n);
        String string4 = string.substring(n);
        AppServlet.getInstance().setDocumentsDirectory(string3);
        if (saveAsPDFNotification.isViewPDF()) {
            Object object;
            String string5 = app.getSession().getSession().getId();
            String string6 = saveAsPDFNotification.getKey();
            if (PDFSupport.shouldApplyPrintContainerPDFSettings(saveAsPDFNotification) && (object = PDFSupport.createPrintContainerPDFOutput(string, saveAsPDFNotification.getSettings(), string6)) != null) {
                string = ((File)object).getAbsolutePath();
                if (Utilities.isWindows()) {
                    string = string.replace("\\", "/");
                }
            }
            n = string.lastIndexOf("PDF-");
            string3 = string.substring(0, n);
            string4 = string.substring(n);
            AppServlet.getInstance().setDocumentsDirectory(string3);
            object = "<form method=\"post\" action=\"/fmi/pdf?name=%s\"><input type=\"hidden\" name=\"path\" value=\"%s\" /><input type=\"hidden\" name=\"key\" value=\"%s\" /><input type=\"hidden\" name=\"pid\" value=\"%s\" /></form><script>document.forms[0].submit();</script>";
            object = String.format((String)object, string2, string4, string6, string5);
            IWPUtilities.addPopupStatusCallback(app);
            String string7 = String.format("var popup; window.%s((popup = window.open('', '_blank')) != null);popup.document.write('%s');", "myPopupStatusCallback", object);
            app.getPage().getJavaScript().execute(string7);
        } else {
            String string8 = saveAsPDFNotification.getOutputPath();
            if (!string8.isEmpty()) {
                FileDownloadDialog fileDownloadDialog = app.getAppView().getFileDownloadDialog();
                String[] stringArray = string8.split("::");
                String string9 = stringArray[0];
                for (int i = 1; i < stringArray.length; ++i) {
                    if (!PDFSupport.isFileUnique(stringArray, i)) continue;
                    String string10 = string9 + stringArray[i];
                    fileDownloadDialog.addPDFDownloadButton(string10, saveAsPDFNotification.getKey());
                }
                fileDownloadDialog.showDialog();
            } else {
                bl = false;
            }
        }
        return bl;
    }

    private static boolean isFileUnique(String[] stringArray, int n) {
        String string = stringArray[n];
        for (int i = 1; i < n; ++i) {
            if (!string.equals(stringArray[i])) continue;
            return false;
        }
        return true;
    }

    public static class PDFInputStream {
        private int contentLength = 0;
        private InputStream stream = null;

        public int getContentLength() {
            return this.contentLength;
        }

        public InputStream getStream() {
            return this.stream;
        }

        public int read() throws IOException {
            return this.stream.read();
        }

        public void close() throws IOException {
            this.stream.close();
        }
    }

    public static class PDFStreamResource
    extends StreamResource {
        public PDFStreamResource(StreamResource.StreamSource streamSource, String string) {
            super(streamSource, string);
        }

        public DownloadStream getStream() {
            DownloadStream downloadStream = super.getStream();
            downloadStream.setParameter("Content-Disposition", "attachment; filename*=UTF-8''" + UriBuilder.fromPath((String)"{filename}").build(new Object[]{this.getFilename()}).toString());
            return downloadStream;
        }
    }
}

