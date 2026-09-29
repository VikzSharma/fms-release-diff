/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.vaadin.event.dd.DragAndDropEvent
 *  com.vaadin.event.dd.DropHandler
 *  com.vaadin.event.dd.acceptcriteria.AcceptAll
 *  com.vaadin.event.dd.acceptcriteria.AcceptCriterion
 *  com.vaadin.server.StreamVariable
 *  com.vaadin.server.StreamVariable$StreamingEndEvent
 *  com.vaadin.server.StreamVariable$StreamingErrorEvent
 *  com.vaadin.server.StreamVariable$StreamingProgressEvent
 *  com.vaadin.server.StreamVariable$StreamingStartEvent
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Button$ClickListener
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.DragAndDropWrapper
 *  com.vaadin.ui.DragAndDropWrapper$WrapperTransferable
 *  com.vaadin.ui.Html5File
 *  com.vaadin.ui.Window
 *  com.vaadin.v7.shared.ui.label.ContentMode
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.Upload$FailedEvent
 *  com.vaadin.v7.ui.Upload$StartedEvent
 *  com.vaadin.v7.ui.Upload$SucceededEvent
 */
package com.filemaker.jwpc.iwp.ui.layout.component.container;

import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.iwp.action.ActionResultGetterHandler;
import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppException;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.thrift.common.BinaryData;
import com.filemaker.jwpc.iwp.thrift.common.BinaryDataOptions;
import com.filemaker.jwpc.iwp.thrift.common.DBAccessLevel;
import com.filemaker.jwpc.iwp.thrift.common.IWPError;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldType;
import com.filemaker.jwpc.iwp.thrift.layout.FieldObjectData;
import com.filemaker.jwpc.iwp.ui.common.ErrorDialog;
import com.filemaker.jwpc.iwp.ui.component.IWPUpload;
import com.filemaker.jwpc.iwp.ui.component.UploadDialog;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.AbsoluteCssLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.LOWrapper;
import com.filemaker.jwpc.iwp.ui.layout.component.LayoutFieldObjectDelegate;
import com.filemaker.jwpc.iwp.ui.layout.component.StringDataUpdateParameters;
import com.filemaker.jwpc.iwp.ui.layout.component.WDImage;
import com.filemaker.jwpc.iwp.ui.layout.component.container.ContainerContentFactory;
import com.filemaker.jwpc.iwp.ui.layout.component.container.ContainerEmbedded;
import com.filemaker.jwpc.iwp.ui.layout.component.container.ContainerUploadDialog;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.RepetitionContainer;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.ContainerClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.ContainerState;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptAll;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.server.StreamVariable;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.Html5File;
import com.vaadin.ui.Window;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.Upload;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

public class Container
extends DragAndDropWrapper
implements DropHandler,
LayoutFieldObject {
    private LayoutFieldObjectDelegate delegate;
    private LayoutObject parent;
    private AbsoluteCssLayout target;
    private AbstractComponent contents;
    private UploadDialog uploadDialog;
    private boolean cancelClicked = false;
    private String mimeType = "";
    private String currentFileName = "";
    private BinaryData currentData;
    private final String uploadStoringMsg;
    private Label placeholderText = null;
    boolean isInterrupted = false;
    private boolean hasAccess = false;
    private DBAccessLevel access = DBAccessLevel.UnknownAccess;
    private boolean hideConditionOn = false;
    private static int maxContainerSize = 300000000;
    private boolean isActive = false;

    public Container(App app, LayoutView layoutView, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        super((Component)new AbsoluteCssLayout(true));
        this.delegate = new LayoutFieldObjectDelegate(app, layoutView, this, objectMetaData, objectAttributes);
        this.uploadStoringMsg = IWPI18N.get(app, "STORING_CONTAINER_FILE", new Object[0]);
        this.setDropHandler(this);
        this.delegate.setWidthAndHeight(this);
        this.target = (AbsoluteCssLayout)super.getCompositionRoot();
        this.target.setSizeFull();
        this.delegate.getApp().initContextMenu(false);
        this.initUI();
    }

    private void initUI() {
        LOWrapper lOWrapper = new LOWrapper(this, this.getMetaData().getPositionCss());
        Container container = this;
        this.delegate.init((AbstractComponent)lOWrapper, (AbstractComponent)container, null);
    }

    @Override
    public void cleanupMemory() {
        this.purgeContents();
        this.removePlaceholderTextIfNeeded();
        if (this.delegate != null && !this.delegate.isActiveAndInPopover()) {
            this.delegate.cleanupMemory();
            this.delegate = null;
        }
    }

    protected ContainerState getState() {
        return (ContainerState)super.getState();
    }

    public void beforeClientResponse(boolean bl) {
        super.beforeClientResponse(bl);
        this.updateBooleanState(ContainerState.BooleanState.hasTooltip, this.getDescription() != null && this.getDescription().length() > 0);
    }

    private void updateBooleanState(ContainerState.BooleanState booleanState, boolean bl) {
        this.getState().ctbs = IWPUtilities.applyBooleanValue(this.getState().ctbs, booleanState.ordinal(), bl);
    }

    @Override
    public Component getWrappedObject() {
        return this.delegate.getWrappedObject();
    }

    protected void reset() {
    }

    @Override
    public DBAccessLevel getAccess() {
        return this.access;
    }

    @Override
    public void setGlassPaneParent(AbsoluteCssLayout absoluteCssLayout) {
        this.delegate.setGlassPaneParent(absoluteCssLayout);
    }

    @Override
    public boolean allowGlassPaneActivation() {
        return this.delegate.allowGlassPaneActivation();
    }

    @Override
    public void updateDataEntry(DBAccessLevel dBAccessLevel, boolean bl) {
        this.access = dBAccessLevel;
        if (this.delegate.hasDataEntryHandler()) {
            boolean bl2 = this.hasAccess;
            this.hasAccess = LayoutObjectUtilities.allowDataEntry(this.delegate.getApp(), this, dBAccessLevel);
            if (bl || bl2 != this.hasAccess) {
                if (this.hasAccess) {
                    this.enableAccess();
                } else {
                    this.disableAccess();
                }
            }
        }
    }

    public boolean isAllowDataEntry() {
        return this.hasAccess;
    }

    public boolean isImageZoomEnabled() {
        if (!this.isContainerEmpty() && this.mimeType != null) {
            return IWPUtilities.isImageType(this.mimeType);
        }
        return false;
    }

    public boolean isDownloadEnabled() {
        return !this.isContainerEmpty();
    }

    public boolean isDeleteEnabled() {
        return !this.isContainerEmpty();
    }

    public void setContainerContents(AbstractComponent abstractComponent, int n, int n2) {
        this.replaceContents(abstractComponent, n, n2);
    }

    @Override
    public int getObjectId() {
        return this.delegate.getMetaData().getObjectId();
    }

    @Override
    public String getUniqueId() {
        return this.delegate.getWrappedObject().getId();
    }

    @Override
    public void updateUniqueId() {
        String string = this.getUniqueId();
        String string2 = IWPUtilities.generateUniqueId(this.delegate.getApp(), this);
        if (!string2.equals(string)) {
            this.delegate.getWrappedObject().setId(string2);
            this.delegate.resetNegativeNumberAttributes();
        }
    }

    @Override
    public ObjectAttributes getAttributes() {
        return this.delegate.getAttributes();
    }

    @Override
    public ObjectMetaData getMetaData() {
        return this.delegate.getMetaData();
    }

    @Override
    public void setParentComponent(LayoutContainerObject layoutContainerObject) {
        this.parent = layoutContainerObject;
    }

    @Override
    public LayoutObject getParentComponent() {
        return this.parent;
    }

    public void setCompositionRoot(Component component) {
        this.purgeContents();
        super.setCompositionRoot(component);
    }

    private void replaceContents(AbstractComponent abstractComponent, int n, int n2) {
        this.purgeContents();
        this.addContainerContentsToLayout(abstractComponent, n, n2);
        this.contents = abstractComponent;
        if (this.currentData != null && !this.currentData.getType().isEmpty()) {
            this.removePlaceholderTextIfNeeded();
        }
    }

    private void purgeContents() {
        if (this.contents != null) {
            this.target.removeComponent((Component)this.contents);
            this.target.removeStyleName("fm-cont-pos");
        }
        this.contents = null;
    }

    public AcceptCriterion getAcceptCriterion() {
        return AcceptAll.get();
    }

    private void showProgress(long l, long l2) {
        if (this.uploadDialog != null) {
            Float f = Float.valueOf((float)l / (float)l2);
            if ((double)f.floatValue() >= 0.95) {
                this.uploadDialog.setStatusStoringData();
            }
            this.uploadDialog.getProgressIndicator().setValue(f);
        }
    }

    private void initUpload(App app, String string, Button.ClickListener clickListener) {
        this.uploadDialog = new UploadDialog(app);
        this.uploadDialog.getFileNameLabel().setValue(string);
        this.uploadDialog.setCancelButtonHandler(clickListener);
        this.uploadDialog.showDialog();
        this.uploadDialog.setStoringStateMsg(IWPI18N.get(app, "STORING_CONTAINER_FILE", new Object[0]));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void uploadFinished(File file) {
        App app = this.delegate.getApp();
        synchronized (app) {
            App app2 = this.delegate.getApp();
            GlobalUIActionHandlers.InsertUploadedFileIntoContainer insertUploadedFileIntoContainer = GlobalUIActionHandlers.INSERT_UPLOADED_FILE_INTO_CONTAINER;
            insertUploadedFileIntoContainer.perform(app2, new Object[]{file.getAbsolutePath(), true});
            if (this.uploadDialog != null) {
                this.uploadDialog.getProgressIndicator().setValue(Float.valueOf(1.0f));
                this.uploadDialog.close();
            }
        }
    }

    private void uploadFailed(String string) {
        if (this.uploadDialog != null) {
            this.uploadDialog.closeDialog();
        }
    }

    public synchronized void drop(DragAndDropEvent dragAndDropEvent) {
        if (this.canActivate(true)) {
            try {
                this.startDrop(dragAndDropEvent);
            }
            catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
    }

    private void startDrop(DragAndDropEvent dragAndDropEvent) throws FileNotFoundException {
        boolean bl;
        this.isInterrupted = false;
        DragAndDropWrapper.WrapperTransferable wrapperTransferable = (DragAndDropWrapper.WrapperTransferable)dragAndDropEvent.getTransferable();
        Html5File[] html5FileArray = wrapperTransferable.getFiles();
        boolean bl2 = bl = !this.delegate.getApp().getBrowserInfoHandler().isIE() || wrapperTransferable.getData("Text") == null || wrapperTransferable.getData("Url") == null;
        if (html5FileArray != null && bl) {
            if (html5FileArray.length != 1) {
                this.delegate.getApp().getMessenger().showTrayMessage(IWPI18N.get(this.delegate.getApp(), "FILE_UPLOAD_INVALID_COUNT", html5FileArray.length));
                return;
            }
            for (Html5File html5File : html5FileArray) {
                String string = IWPUtilities.makeFilesystemSafeFilename(html5File.getFileName());
                String string2 = this.delegate.getApp().getAppSession().getUploadDirPath();
                final File file = new File(string2, string);
                final FileOutputStream fileOutputStream = new FileOutputStream(file);
                if (this.isUploadTooBig(html5File.getFileSize())) {
                    this.showUploadTooBigDialog();
                    break;
                }
                StreamVariable streamVariable = new StreamVariable(){
                    final /* synthetic */ Container this$0;
                    {
                        this.this$0 = container;
                    }

                    public OutputStream getOutputStream() {
                        return fileOutputStream;
                    }

                    public boolean listenProgress() {
                        return true;
                    }

                    public void onProgress(StreamVariable.StreamingProgressEvent streamingProgressEvent) {
                        this.this$0.showProgress(streamingProgressEvent.getBytesReceived(), streamingProgressEvent.getContentLength());
                    }

                    public void streamingStarted(StreamVariable.StreamingStartEvent streamingStartEvent) {
                        this.this$0.initUpload(this.this$0.delegate.getApp(), streamingStartEvent.getFileName(), new Button.ClickListener(){

                            public void buttonClick(Button.ClickEvent clickEvent) {
                                this$0.isInterrupted = true;
                                this$0.cancelClicked = true;
                            }
                        });
                    }

                    public void streamingFinished(StreamVariable.StreamingEndEvent streamingEndEvent) {
                        try {
                            fileOutputStream.close();
                            this.this$0.uploadFinished(file);
                        }
                        catch (IOException iOException) {
                            iOException.printStackTrace();
                        }
                    }

                    public void streamingFailed(StreamVariable.StreamingErrorEvent streamingErrorEvent) {
                        try {
                            fileOutputStream.close();
                            file.delete();
                            this.this$0.uploadFailed(streamingErrorEvent.getException().getLocalizedMessage());
                        }
                        catch (IOException iOException) {
                            iOException.printStackTrace();
                        }
                    }

                    public boolean isInterrupted() {
                        return this.this$0.isInterrupted;
                    }
                };
                html5File.setStreamVariable(streamVariable);
            }
        } else {
            this.delegate.getApp().getMessenger().showError(IWPI18N.get(this.delegate.getApp(), "NO_FILES_SELECTED", new Object[0]));
        }
    }

    private void updateContainer(BinaryData binaryData, boolean bl) {
        boolean bl2;
        AbstractComponent abstractComponent = null;
        if (this.contents != null) {
            abstractComponent = this.contents;
        }
        this.currentData = binaryData;
        int n = this.getMetaData().getWidthAsInt();
        int n2 = this.getMetaData().getHeightAsInt();
        if (binaryData != null && binaryData.getContentRectHeight() > 0 && binaryData.getContentRectWidth() > 0) {
            n = binaryData.getContentRectWidth();
            n2 = binaryData.getContentRectHeight();
        }
        if ((bl2 = bl) && !ContainerContentFactory.isImage(binaryData)) {
            bl2 = false;
        }
        if (binaryData != null) {
            String string = binaryData.getName();
            if (bl2 && (string == null || string.length() == 0)) {
                bl2 = false;
            }
            Object object = null;
            if (bl2) {
                String string2;
                App app = this.delegate.getApp();
                if (!app.containsKeyInContainerImageMap(string2 = IWPUtilities.getImageCacheName(string, binaryData.getImageWidth(), binaryData.getImageHeight()))) {
                    WDImage wDImage = (WDImage)ContainerContentFactory.createContainerContent(this.delegate.getApp(), this.delegate.getMetaData(), this.delegate.getAttributes(), binaryData, abstractComponent);
                    wDImage.setId(string2);
                    app.addToContainerImageMap(string2, wDImage);
                }
                int n3 = app.getUIId();
                String string3 = app.getFromContainerImageMap(string2).getConnectorId();
                String string4 = binaryData.getDisplayType();
                String string5 = IWPUtilities.getResourceConnectorString(app.need_webd_VirtualDir(), n3, string3, string2);
                ContainerEmbedded containerEmbedded = new ContainerEmbedded(this.delegate.getMetaData(), this.delegate.getAttributes());
                containerEmbedded.setFileName(string2);
                containerEmbedded.setWidth((String)(binaryData.getImageWidth() > 0 ? binaryData.getImageWidth() + "px" : "100%"));
                containerEmbedded.setHeight((String)(binaryData.getImageHeight() > 0 ? binaryData.getImageHeight() + "px" : "100%"));
                containerEmbedded.setMimeType(string4);
                containerEmbedded.setConnectorResource(string5, string4);
                if (AppServlet.isAriaCompliantControlEnabled()) {
                    String string6 = IWPUtilities.toSafeAltText(string);
                    containerEmbedded.setAlternateText(string6);
                }
                object = containerEmbedded;
            } else if (!(abstractComponent instanceof WDImage && ContainerContentFactory.isImage(binaryData) && ((WDImage)abstractComponent).isSameImage(binaryData))) {
                object = ContainerContentFactory.createContainerContent(this.delegate.getApp(), this.delegate.getMetaData(), this.delegate.getAttributes(), binaryData, abstractComponent);
            }
            if (object != null) {
                this.mimeType = new String(binaryData.getDisplayType());
                this.currentFileName = new String(binaryData.getName());
                this.setContainerContents((AbstractComponent)object, n, n2);
            }
        }
    }

    public void setConnectorResourceToObj(Container container, ContainerEmbedded containerEmbedded) {
        App app = container.delegate.getApp();
        String string = IWPUtilities.getResourceConnectorString(app.need_webd_VirtualDir(), app.getUIId(), container.contents.getConnectorId(), container.currentFileName);
        containerEmbedded.setConnectorResource(string, container.mimeType);
        containerEmbedded.setWidth(container.contents.getWidth(), container.contents.getWidthUnits());
        containerEmbedded.setHeight(container.contents.getHeight(), container.contents.getHeightUnits());
        containerEmbedded.setMimeType(container.mimeType);
    }

    private void addContainerContentsToLayout(AbstractComponent abstractComponent, int n, int n2) {
        String string = "top: 0px; left: 0px";
        if (this.currentData != null && !this.currentData.isFieldIsWebContainer() || !IWPUtilities.isStreamingMedia(this.mimeType)) {
            string = IWPUtilities.computeComponentPositioningCSS(this.delegate.getMetaData(), n, n2, abstractComponent);
        }
        if (abstractComponent instanceof WDImage) {
            ((WDImage)abstractComponent).setPositionCss("position: absolute; " + string);
        } else if (abstractComponent instanceof ContainerEmbedded) {
            this.target.addStyleName("fm-cont-pos");
        }
        this.target.addComponent((Component)abstractComponent);
    }

    public void showZoomedImage() throws AppException {
        BinaryDataOptions binaryDataOptions = new BinaryDataOptions();
        binaryDataOptions.setUseImageDimensions(true);
        this.delegate.getApp().getAppSession().getFieldObjectData(new ActionResultGetterHandler(){

            @Override
            public void onFinish(Object object) {
                LayoutObjectUtilities.handleGetFieldObjectDataNotification(Container.this.delegate.getApp(), Container.this, true, (FieldObjectData)object);
            }
        }, this.getAttributes().getObjectSpec(), this.getAttributes().getFieldSpec(), binaryDataOptions, true);
    }

    private boolean isContainerEmpty() {
        return this.currentFileName == null || this.currentFileName.length() == 0;
    }

    @Override
    public synchronized void updateLayoutObjectData(Object object, boolean bl) {
        throw new UnsupportedOperationException();
    }

    @Override
    public synchronized void updateFieldObjectData(StringDataUpdateParameters stringDataUpdateParameters, boolean bl) {
        throw new UnsupportedOperationException();
    }

    public synchronized void updateContainerData(BinaryData binaryData, DBAccessLevel dBAccessLevel, boolean bl, String string, boolean bl2, boolean bl3) {
        this.delegate.getApp().getMessenger().closeBusyDialog();
        if (!bl2) {
            boolean bl4 = false;
            if (binaryData != null) {
                bl4 = binaryData.isValid();
            }
            if (!bl4 || bl && this.getMetaData().hasDataFormatting()) {
                LayoutObjectUtilities.updateFieldObjectData(this.delegate.getApp(), this);
            } else {
                this.updateDataEntry(dBAccessLevel, false);
                this.updateContainer(binaryData, bl3);
            }
        } else {
            this.disableAccess();
            this.access = DBAccessLevel.NoAccess;
            ContainerEmbedded containerEmbedded = new ContainerEmbedded(this.delegate.getMetaData(), this.delegate.getAttributes());
            containerEmbedded.setCaption(string);
            containerEmbedded.setRole("group");
            this.setContainerContents((AbstractComponent)containerEmbedded, this.getMetaData().getWidthAsInt(), this.getMetaData().getHeightAsInt());
            this.mimeType = "text/html";
            this.currentFileName = string;
        }
    }

    private void disableAccess() {
        this.hasAccess = false;
        this.access = DBAccessLevel.ReadOnly;
        this.delegate.activateGlassPane();
        this.delegate.updateTabIndex(-1);
    }

    private void enableAccess() {
        this.hasAccess = true;
        this.access = DBAccessLevel.ReadWrite;
        if (this.getMetaData().hasValidAndExecutableScript()) {
            this.delegate.activateGlassPane();
        } else {
            this.delegate.deactivateGlassPane();
        }
        if (this.getMetaData().getFieldType() == LayoutFieldType.NORMAL) {
            this.delegate.updateTabIndex(this.getMetaData().getTabOrder(this.getAttributes().getRepetition()));
        } else {
            this.delegate.updateTabIndex(-1);
        }
    }

    @Override
    public Object getFieldData() {
        return this.currentData;
    }

    public BinaryData getBinData() {
        return this.currentData;
    }

    @Override
    public void addRepetitionObject(RepetitionContainer repetitionContainer, String string) {
        this.delegate.getWrappedObject().addStyleName(string);
        this.delegate.setRepetition(repetitionContainer);
    }

    @Override
    public Container getRepetitionObject(short s) {
        if (this.getMetaData().getRepetitionCount() == 1) {
            return this;
        }
        return (Container)this.delegate.getRepetition().getRepetitionObjects().get(s);
    }

    @Override
    public Collection<LayoutFieldObject> getAllRepetitionObjects() {
        if (this.getMetaData().getRepetitionCount() == 1) {
            ArrayList<LayoutFieldObject> arrayList = new ArrayList<LayoutFieldObject>();
            arrayList.add(this);
            return arrayList;
        }
        return this.delegate.getRepetition().getRepetitionObjects().values();
    }

    protected boolean isUploadTooBig(long l) {
        boolean bl = false;
        if (l > (long)maxContainerSize || l < 0L) {
            return true;
        }
        if (this.delegate.getMetaData().hasContainerMaxSize() && l > (long)(this.delegate.getMetaData().getContainerMaxSize() * 1000)) {
            bl = true;
        }
        return bl;
    }

    protected void showUploadTooBigDialog() {
        String string = "";
        if (Utilities.isValidText(this.delegate.getMetaData().getContainerMaxSizeError())) {
            string = this.delegate.getMetaData().getContainerMaxSizeError();
        } else {
            int n = this.delegate.getMetaData().getContainerMaxSize();
            if (n == -1) {
                n = maxContainerSize / 1000;
            }
            string = IWPI18N.get(this.delegate.getApp(), "UPLOAD_TOO_BIG_DIALOG_MESSAGE", String.valueOf(n));
        }
        ErrorDialog errorDialog = new ErrorDialog(this.delegate.getApp(), "", string);
        errorDialog.showDialog();
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case RESET_FIELD_OBJECT: {
                if (!this.delegate.getApp().isFormView()) break;
                this.reset();
                break;
            }
        }
    }

    @Override
    public void registerToolTip(String string) {
        this.setDescription(string, ContentMode.HTML);
    }

    private void removePlaceholderTextIfNeeded() {
        if (this.placeholderText != null) {
            this.target.removeComponent((Component)this.placeholderText);
            this.placeholderText = null;
        }
    }

    @Override
    public void setPlaceholderText(String string) {
        this.removePlaceholderTextIfNeeded();
        if (this.mimeType.length() == 0 && this.currentData.getType().length() == 0 && !this.isFileReference()) {
            String string2 = String.format("<div class=\"fm-placeholder\">%s</div>", string);
            this.placeholderText = new Label(string2, com.vaadin.v7.shared.ui.label.ContentMode.HTML);
            this.placeholderText.addStyleName("fm-cont-pos");
            this.target.addComponent((Component)this.placeholderText);
            this.target.markAsDirty();
        }
    }

    @Override
    public void insertData(String string) {
        throw new UnsupportedOperationException();
    }

    public void showContainerUploadDialog(App app) {
        ContainerUploadDialog containerUploadDialog = new ContainerUploadDialog(app, this, this.delegate.getApp().getAppSession().getUploadDirPath());
        containerUploadDialog.showDialog();
        containerUploadDialog.setClosable(true);
        containerUploadDialog.focus();
    }

    private boolean canActivate(boolean bl) {
        IWPError iWPError = this.delegate.getApp().getAppSession().enterContainerObject(this.getAttributes().getObjectSpec(), bl);
        if (iWPError.getErrorCode() == ErrorCode.None.getErrorCode()) {
            return true;
        }
        ErrorDialog errorDialog = new ErrorDialog(this.delegate.getApp(), this.delegate.getApp().getMessenger().getUserFriendlyErrorMessage(iWPError), iWPError.getErrorCode());
        errorDialog.showDialog();
        return false;
    }

    @Override
    public boolean hasHideCondition() {
        return this.getMetaData().hasHideCondition();
    }

    @Override
    public boolean isHideConditionOn() {
        return this.hideConditionOn;
    }

    @Override
    public boolean hasHideConditionInFindMode() {
        return this.getMetaData().hasHideConditionInFindMode();
    }

    @Override
    public void setHideConditionOn(boolean bl) {
        this.hideConditionOn = bl;
    }

    @Override
    public void onActive() {
        if (!this.isActive) {
            this.isActive = true;
            ((ContainerClientRpc)this.getRpcProxy(ContainerClientRpc.class)).setActive(true);
        }
    }

    @Override
    public void showContextMenu(int n, int n2) {
        App app = this.delegate.getApp();
        app.positionContextMenu(n, n2, this);
        app.showContextMenu(this);
    }

    @Override
    public void onInactive() {
        if (this.isActive) {
            this.isActive = false;
            ((ContainerClientRpc)this.getRpcProxy(ContainerClientRpc.class)).setActive(false);
        }
    }

    @Override
    public void addCFStyle(String string) {
        this.delegate.addCFStyle(string);
    }

    @Override
    public void removeCFStyle(String string) {
        this.delegate.removeCFStyle(string);
    }

    public boolean isFileReference() {
        if (this.currentData != null) {
            return this.currentData.isFileReference();
        }
        return false;
    }

    @Override
    public void onFieldObjectClick() {
    }

    public String getcurrentFileName() {
        return this.currentFileName;
    }

    public boolean areContentsAttached() {
        return this.contents != null && this.contents.isAttached();
    }

    @Override
    public boolean hasDelegate() {
        return this.delegate != null;
    }

    @Override
    public void registerAccTitle(String string) {
        if (string != null && !string.replace("\u00a0", "").trim().isEmpty()) {
            this.setCaption(string);
        }
        this.addStyleName("sr-only-caption-title-and-help");
    }

    @Override
    public void registerAccHelp(String string) {
    }

    @Override
    public void registerAccLabel(String string) {
    }

    class ContainerUpload
    extends IWPUpload {
        private Window parent;

        public ContainerUpload(App app, String string, Window window, String string2) {
            super(app, string, string2);
            this.parent = null;
            this.parent = window;
        }

        @Override
        public void uploadStarted(Upload.StartedEvent startedEvent) {
            IWPError iWPError = Container.this.delegate.getApp().getAppSession().enterContainerObject(Container.this.getAttributes().getObjectSpec(), true);
            if (!IWPUtilities.hasError(iWPError)) {
                if (Container.this.isUploadTooBig(startedEvent.getContentLength())) {
                    ContainerUpload.super.cancelUpload();
                    Container.this.showUploadTooBigDialog();
                } else {
                    ContainerUpload.super.uploadStarted(startedEvent);
                }
            } else if (this.parent != null) {
                ContainerUpload.super.cancelUpload();
                this.parent.close();
                ErrorDialog errorDialog = new ErrorDialog(Container.this.delegate.getApp(), Container.this.delegate.getApp().getMessenger().getUserFriendlyErrorMessage(iWPError), iWPError.getErrorCode());
                errorDialog.showDialog();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void uploadSucceeded(Upload.SucceededEvent succeededEvent) {
            App app = Container.this.delegate.getApp();
            synchronized (app) {
                super.uploadSucceeded(succeededEvent);
                App app2 = Container.this.delegate.getApp();
                GlobalUIActionHandlers.InsertUploadedFileIntoContainer insertUploadedFileIntoContainer = GlobalUIActionHandlers.INSERT_UPLOADED_FILE_INTO_CONTAINER;
                insertUploadedFileIntoContainer.perform(app2, new Object[]{this.getFile().getAbsolutePath(), false});
            }
        }

        @Override
        public void uploadFailed(Upload.FailedEvent failedEvent) {
            if (!Container.this.cancelClicked) {
                App app = Container.this.delegate.getApp();
                GlobalUIActionHandlers.InsertUploadedFileIntoContainer insertUploadedFileIntoContainer = GlobalUIActionHandlers.INSERT_UPLOADED_FILE_INTO_CONTAINER;
                insertUploadedFileIntoContainer.perform(app, new Object[]{"", true});
                super.uploadFailed(failedEvent);
                this.deleteFile();
            }
            Container.this.cancelClicked = false;
        }

        @Override
        protected void cancelUpload() {
            App app = Container.this.delegate.getApp();
            GlobalUIActionHandlers.InsertUploadedFileIntoContainer insertUploadedFileIntoContainer = GlobalUIActionHandlers.INSERT_UPLOADED_FILE_INTO_CONTAINER;
            insertUploadedFileIntoContainer.perform(app, new Object[]{"", true});
            super.cancelUpload();
            this.deleteFile();
            Container.this.cancelClicked = true;
        }

        @Override
        protected void postInitUpload() {
            if (this.uploadDialog != null) {
                this.uploadDialog.setStoringStateMsg(Container.this.uploadStoringMsg);
            }
            super.postInitUpload();
        }
    }
}

