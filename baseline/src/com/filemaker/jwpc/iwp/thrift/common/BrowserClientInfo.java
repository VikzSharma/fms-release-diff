/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.thrift.EncodingUtils
 *  org.apache.thrift.TBase
 *  org.apache.thrift.TBaseHelper
 *  org.apache.thrift.TException
 *  org.apache.thrift.TFieldIdEnum
 *  org.apache.thrift.annotation.Nullable
 *  org.apache.thrift.meta_data.EnumMetaData
 *  org.apache.thrift.meta_data.FieldMetaData
 *  org.apache.thrift.meta_data.FieldValueMetaData
 *  org.apache.thrift.meta_data.StructMetaData
 *  org.apache.thrift.protocol.TCompactProtocol
 *  org.apache.thrift.protocol.TField
 *  org.apache.thrift.protocol.TProtocol
 *  org.apache.thrift.protocol.TProtocolUtil
 *  org.apache.thrift.protocol.TStruct
 *  org.apache.thrift.protocol.TTupleProtocol
 *  org.apache.thrift.scheme.IScheme
 *  org.apache.thrift.scheme.SchemeFactory
 *  org.apache.thrift.scheme.StandardScheme
 *  org.apache.thrift.scheme.TupleScheme
 *  org.apache.thrift.transport.TIOStreamTransport
 *  org.apache.thrift.transport.TTransport
 */
package com.filemaker.jwpc.iwp.thrift.common;

import com.filemaker.jwpc.iwp.thrift.common.BrowserType;
import com.filemaker.jwpc.iwp.thrift.common.Dimensions;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.annotation.Nullable;
import org.apache.thrift.meta_data.EnumMetaData;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.protocol.TStruct;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.transport.TIOStreamTransport;
import org.apache.thrift.transport.TTransport;

public class BrowserClientInfo
implements TBase<BrowserClientInfo, _Fields>,
Serializable,
Cloneable,
Comparable<BrowserClientInfo> {
    private static final TStruct STRUCT_DESC = new TStruct("BrowserClientInfo");
    private static final TField HOST_IP_FIELD_DESC = new TField("hostIP", 11, 1);
    private static final TField CLIENT_IP_FIELD_DESC = new TField("clientIP", 11, 2);
    private static final TField SERVER_IP_FIELD_DESC = new TField("serverIP", 11, 3);
    private static final TField USER_AGENT_FIELD_DESC = new TField("userAgent", 11, 4);
    private static final TField SECURE_CONNECTION_FIELD_DESC = new TField("secureConnection", 2, 5);
    private static final TField BROWSER_TYPE_FIELD_DESC = new TField("browserType", 8, 6);
    private static final TField CLIENT_SYSTEM_VERSION_FIELD_DESC = new TField("clientSystemVersion", 11, 7);
    private static final TField CLIENT_DEVICE_FIELD_DESC = new TField("clientDevice", 6, 8);
    private static final TField BROWSER_COUNTRY_FIELD_DESC = new TField("browserCountry", 11, 9);
    private static final TField BROWSER_LANGUAGE_FIELD_DESC = new TField("browserLanguage", 11, 10);
    private static final TField HIGH_CONTRAST_COLOR_FIELD_DESC = new TField("highContrastColor", 11, 11);
    private static final TField HIGH_CONTRAST_STATE_FIELD_DESC = new TField("highContrastState", 2, 12);
    private static final TField PERSISTENT_ID_FIELD_DESC = new TField("persistentID", 11, 13);
    private static final TField SCREEN_DEPTH_FIELD_DESC = new TField("screenDepth", 8, 14);
    private static final TField SCREEN_HEIGHT_FIELD_DESC = new TField("screenHeight", 8, 15);
    private static final TField SCREEN_WIDTH_FIELD_DESC = new TField("screenWidth", 8, 16);
    private static final TField MENUBAR_HEIGHT_FIELD_DESC = new TField("menubarHeight", 8, 17);
    private static final TField FOOTER_CONTAINER_HEIGHT_FIELD_DESC = new TField("footerContainerHeight", 8, 18);
    private static final TField STATUS_AREA_HEIGHT_FIELD_DESC = new TField("statusAreaHeight", 8, 19);
    private static final TField BROWSER_DIMENSIONS_FIELD_DESC = new TField("browserDimensions", 12, 20);
    private static final TField RETINA_DISPLAY_FIELD_DESC = new TField("retinaDisplay", 2, 21);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new BrowserClientInfoStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new BrowserClientInfoTupleSchemeFactory();
    @Nullable
    private String hostIP;
    @Nullable
    private String clientIP;
    @Nullable
    private String serverIP;
    @Nullable
    private String userAgent;
    private boolean secureConnection;
    @Nullable
    private BrowserType browserType;
    @Nullable
    private String clientSystemVersion;
    private short clientDevice;
    @Nullable
    private String browserCountry;
    @Nullable
    private String browserLanguage;
    @Nullable
    private String highContrastColor;
    private boolean highContrastState;
    @Nullable
    private String persistentID;
    private int screenDepth;
    private int screenHeight;
    private int screenWidth;
    private int menubarHeight;
    private int footerContainerHeight;
    private int statusAreaHeight;
    @Nullable
    private Dimensions browserDimensions;
    private boolean retinaDisplay;
    private static final int __SECURECONNECTION_ISSET_ID = 0;
    private static final int __CLIENTDEVICE_ISSET_ID = 1;
    private static final int __HIGHCONTRASTSTATE_ISSET_ID = 2;
    private static final int __SCREENDEPTH_ISSET_ID = 3;
    private static final int __SCREENHEIGHT_ISSET_ID = 4;
    private static final int __SCREENWIDTH_ISSET_ID = 5;
    private static final int __MENUBARHEIGHT_ISSET_ID = 6;
    private static final int __FOOTERCONTAINERHEIGHT_ISSET_ID = 7;
    private static final int __STATUSAREAHEIGHT_ISSET_ID = 8;
    private static final int __RETINADISPLAY_ISSET_ID = 9;
    private short __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public BrowserClientInfo() {
    }

    public BrowserClientInfo(String string, String string2, String string3, String string4, boolean bl, BrowserType browserType, String string5, short s, String string6, String string7, String string8, boolean bl2, String string9, int n, int n2, int n3, int n4, int n5, int n6, Dimensions dimensions, boolean bl3) {
        this();
        this.hostIP = string;
        this.clientIP = string2;
        this.serverIP = string3;
        this.userAgent = string4;
        this.secureConnection = bl;
        this.setSecureConnectionIsSet(true);
        this.browserType = browserType;
        this.clientSystemVersion = string5;
        this.clientDevice = s;
        this.setClientDeviceIsSet(true);
        this.browserCountry = string6;
        this.browserLanguage = string7;
        this.highContrastColor = string8;
        this.highContrastState = bl2;
        this.setHighContrastStateIsSet(true);
        this.persistentID = string9;
        this.screenDepth = n;
        this.setScreenDepthIsSet(true);
        this.screenHeight = n2;
        this.setScreenHeightIsSet(true);
        this.screenWidth = n3;
        this.setScreenWidthIsSet(true);
        this.menubarHeight = n4;
        this.setMenubarHeightIsSet(true);
        this.footerContainerHeight = n5;
        this.setFooterContainerHeightIsSet(true);
        this.statusAreaHeight = n6;
        this.setStatusAreaHeightIsSet(true);
        this.browserDimensions = dimensions;
        this.retinaDisplay = bl3;
        this.setRetinaDisplayIsSet(true);
    }

    public BrowserClientInfo(BrowserClientInfo browserClientInfo) {
        this.__isset_bitfield = browserClientInfo.__isset_bitfield;
        if (browserClientInfo.isSetHostIP()) {
            this.hostIP = browserClientInfo.hostIP;
        }
        if (browserClientInfo.isSetClientIP()) {
            this.clientIP = browserClientInfo.clientIP;
        }
        if (browserClientInfo.isSetServerIP()) {
            this.serverIP = browserClientInfo.serverIP;
        }
        if (browserClientInfo.isSetUserAgent()) {
            this.userAgent = browserClientInfo.userAgent;
        }
        this.secureConnection = browserClientInfo.secureConnection;
        if (browserClientInfo.isSetBrowserType()) {
            this.browserType = browserClientInfo.browserType;
        }
        if (browserClientInfo.isSetClientSystemVersion()) {
            this.clientSystemVersion = browserClientInfo.clientSystemVersion;
        }
        this.clientDevice = browserClientInfo.clientDevice;
        if (browserClientInfo.isSetBrowserCountry()) {
            this.browserCountry = browserClientInfo.browserCountry;
        }
        if (browserClientInfo.isSetBrowserLanguage()) {
            this.browserLanguage = browserClientInfo.browserLanguage;
        }
        if (browserClientInfo.isSetHighContrastColor()) {
            this.highContrastColor = browserClientInfo.highContrastColor;
        }
        this.highContrastState = browserClientInfo.highContrastState;
        if (browserClientInfo.isSetPersistentID()) {
            this.persistentID = browserClientInfo.persistentID;
        }
        this.screenDepth = browserClientInfo.screenDepth;
        this.screenHeight = browserClientInfo.screenHeight;
        this.screenWidth = browserClientInfo.screenWidth;
        this.menubarHeight = browserClientInfo.menubarHeight;
        this.footerContainerHeight = browserClientInfo.footerContainerHeight;
        this.statusAreaHeight = browserClientInfo.statusAreaHeight;
        if (browserClientInfo.isSetBrowserDimensions()) {
            this.browserDimensions = new Dimensions(browserClientInfo.browserDimensions);
        }
        this.retinaDisplay = browserClientInfo.retinaDisplay;
    }

    public BrowserClientInfo deepCopy() {
        return new BrowserClientInfo(this);
    }

    public void clear() {
        this.hostIP = null;
        this.clientIP = null;
        this.serverIP = null;
        this.userAgent = null;
        this.setSecureConnectionIsSet(false);
        this.secureConnection = false;
        this.browserType = null;
        this.clientSystemVersion = null;
        this.setClientDeviceIsSet(false);
        this.clientDevice = 0;
        this.browserCountry = null;
        this.browserLanguage = null;
        this.highContrastColor = null;
        this.setHighContrastStateIsSet(false);
        this.highContrastState = false;
        this.persistentID = null;
        this.setScreenDepthIsSet(false);
        this.screenDepth = 0;
        this.setScreenHeightIsSet(false);
        this.screenHeight = 0;
        this.setScreenWidthIsSet(false);
        this.screenWidth = 0;
        this.setMenubarHeightIsSet(false);
        this.menubarHeight = 0;
        this.setFooterContainerHeightIsSet(false);
        this.footerContainerHeight = 0;
        this.setStatusAreaHeightIsSet(false);
        this.statusAreaHeight = 0;
        this.browserDimensions = null;
        this.setRetinaDisplayIsSet(false);
        this.retinaDisplay = false;
    }

    @Nullable
    public String getHostIP() {
        return this.hostIP;
    }

    public void setHostIP(@Nullable String string) {
        this.hostIP = string;
    }

    public void unsetHostIP() {
        this.hostIP = null;
    }

    public boolean isSetHostIP() {
        return this.hostIP != null;
    }

    public void setHostIPIsSet(boolean bl) {
        if (!bl) {
            this.hostIP = null;
        }
    }

    @Nullable
    public String getClientIP() {
        return this.clientIP;
    }

    public void setClientIP(@Nullable String string) {
        this.clientIP = string;
    }

    public void unsetClientIP() {
        this.clientIP = null;
    }

    public boolean isSetClientIP() {
        return this.clientIP != null;
    }

    public void setClientIPIsSet(boolean bl) {
        if (!bl) {
            this.clientIP = null;
        }
    }

    @Nullable
    public String getServerIP() {
        return this.serverIP;
    }

    public void setServerIP(@Nullable String string) {
        this.serverIP = string;
    }

    public void unsetServerIP() {
        this.serverIP = null;
    }

    public boolean isSetServerIP() {
        return this.serverIP != null;
    }

    public void setServerIPIsSet(boolean bl) {
        if (!bl) {
            this.serverIP = null;
        }
    }

    @Nullable
    public String getUserAgent() {
        return this.userAgent;
    }

    public void setUserAgent(@Nullable String string) {
        this.userAgent = string;
    }

    public void unsetUserAgent() {
        this.userAgent = null;
    }

    public boolean isSetUserAgent() {
        return this.userAgent != null;
    }

    public void setUserAgentIsSet(boolean bl) {
        if (!bl) {
            this.userAgent = null;
        }
    }

    public boolean isSecureConnection() {
        return this.secureConnection;
    }

    public void setSecureConnection(boolean bl) {
        this.secureConnection = bl;
        this.setSecureConnectionIsSet(true);
    }

    public void unsetSecureConnection() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)0);
    }

    public boolean isSetSecureConnection() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)0);
    }

    public void setSecureConnectionIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public BrowserType getBrowserType() {
        return this.browserType;
    }

    public void setBrowserType(@Nullable BrowserType browserType) {
        this.browserType = browserType;
    }

    public void unsetBrowserType() {
        this.browserType = null;
    }

    public boolean isSetBrowserType() {
        return this.browserType != null;
    }

    public void setBrowserTypeIsSet(boolean bl) {
        if (!bl) {
            this.browserType = null;
        }
    }

    @Nullable
    public String getClientSystemVersion() {
        return this.clientSystemVersion;
    }

    public void setClientSystemVersion(@Nullable String string) {
        this.clientSystemVersion = string;
    }

    public void unsetClientSystemVersion() {
        this.clientSystemVersion = null;
    }

    public boolean isSetClientSystemVersion() {
        return this.clientSystemVersion != null;
    }

    public void setClientSystemVersionIsSet(boolean bl) {
        if (!bl) {
            this.clientSystemVersion = null;
        }
    }

    public short getClientDevice() {
        return this.clientDevice;
    }

    public void setClientDevice(short s) {
        this.clientDevice = s;
        this.setClientDeviceIsSet(true);
    }

    public void unsetClientDevice() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)1);
    }

    public boolean isSetClientDevice() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)1);
    }

    public void setClientDeviceIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    @Nullable
    public String getBrowserCountry() {
        return this.browserCountry;
    }

    public void setBrowserCountry(@Nullable String string) {
        this.browserCountry = string;
    }

    public void unsetBrowserCountry() {
        this.browserCountry = null;
    }

    public boolean isSetBrowserCountry() {
        return this.browserCountry != null;
    }

    public void setBrowserCountryIsSet(boolean bl) {
        if (!bl) {
            this.browserCountry = null;
        }
    }

    @Nullable
    public String getBrowserLanguage() {
        return this.browserLanguage;
    }

    public void setBrowserLanguage(@Nullable String string) {
        this.browserLanguage = string;
    }

    public void unsetBrowserLanguage() {
        this.browserLanguage = null;
    }

    public boolean isSetBrowserLanguage() {
        return this.browserLanguage != null;
    }

    public void setBrowserLanguageIsSet(boolean bl) {
        if (!bl) {
            this.browserLanguage = null;
        }
    }

    @Nullable
    public String getHighContrastColor() {
        return this.highContrastColor;
    }

    public void setHighContrastColor(@Nullable String string) {
        this.highContrastColor = string;
    }

    public void unsetHighContrastColor() {
        this.highContrastColor = null;
    }

    public boolean isSetHighContrastColor() {
        return this.highContrastColor != null;
    }

    public void setHighContrastColorIsSet(boolean bl) {
        if (!bl) {
            this.highContrastColor = null;
        }
    }

    public boolean isHighContrastState() {
        return this.highContrastState;
    }

    public void setHighContrastState(boolean bl) {
        this.highContrastState = bl;
        this.setHighContrastStateIsSet(true);
    }

    public void unsetHighContrastState() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)2);
    }

    public boolean isSetHighContrastState() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)2);
    }

    public void setHighContrastStateIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    @Nullable
    public String getPersistentID() {
        return this.persistentID;
    }

    public void setPersistentID(@Nullable String string) {
        this.persistentID = string;
    }

    public void unsetPersistentID() {
        this.persistentID = null;
    }

    public boolean isSetPersistentID() {
        return this.persistentID != null;
    }

    public void setPersistentIDIsSet(boolean bl) {
        if (!bl) {
            this.persistentID = null;
        }
    }

    public int getScreenDepth() {
        return this.screenDepth;
    }

    public void setScreenDepth(int n) {
        this.screenDepth = n;
        this.setScreenDepthIsSet(true);
    }

    public void unsetScreenDepth() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)3);
    }

    public boolean isSetScreenDepth() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)3);
    }

    public void setScreenDepthIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)3, (boolean)bl);
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    public void setScreenHeight(int n) {
        this.screenHeight = n;
        this.setScreenHeightIsSet(true);
    }

    public void unsetScreenHeight() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)4);
    }

    public boolean isSetScreenHeight() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)4);
    }

    public void setScreenHeightIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)4, (boolean)bl);
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public void setScreenWidth(int n) {
        this.screenWidth = n;
        this.setScreenWidthIsSet(true);
    }

    public void unsetScreenWidth() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)5);
    }

    public boolean isSetScreenWidth() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)5);
    }

    public void setScreenWidthIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)5, (boolean)bl);
    }

    public int getMenubarHeight() {
        return this.menubarHeight;
    }

    public void setMenubarHeight(int n) {
        this.menubarHeight = n;
        this.setMenubarHeightIsSet(true);
    }

    public void unsetMenubarHeight() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)6);
    }

    public boolean isSetMenubarHeight() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)6);
    }

    public void setMenubarHeightIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)6, (boolean)bl);
    }

    public int getFooterContainerHeight() {
        return this.footerContainerHeight;
    }

    public void setFooterContainerHeight(int n) {
        this.footerContainerHeight = n;
        this.setFooterContainerHeightIsSet(true);
    }

    public void unsetFooterContainerHeight() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)7);
    }

    public boolean isSetFooterContainerHeight() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)7);
    }

    public void setFooterContainerHeightIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)7, (boolean)bl);
    }

    public int getStatusAreaHeight() {
        return this.statusAreaHeight;
    }

    public void setStatusAreaHeight(int n) {
        this.statusAreaHeight = n;
        this.setStatusAreaHeightIsSet(true);
    }

    public void unsetStatusAreaHeight() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)8);
    }

    public boolean isSetStatusAreaHeight() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)8);
    }

    public void setStatusAreaHeightIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)8, (boolean)bl);
    }

    @Nullable
    public Dimensions getBrowserDimensions() {
        return this.browserDimensions;
    }

    public void setBrowserDimensions(@Nullable Dimensions dimensions) {
        this.browserDimensions = dimensions;
    }

    public void unsetBrowserDimensions() {
        this.browserDimensions = null;
    }

    public boolean isSetBrowserDimensions() {
        return this.browserDimensions != null;
    }

    public void setBrowserDimensionsIsSet(boolean bl) {
        if (!bl) {
            this.browserDimensions = null;
        }
    }

    public boolean isRetinaDisplay() {
        return this.retinaDisplay;
    }

    public void setRetinaDisplay(boolean bl) {
        this.retinaDisplay = bl;
        this.setRetinaDisplayIsSet(true);
    }

    public void unsetRetinaDisplay() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)9);
    }

    public boolean isSetRetinaDisplay() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)9);
    }

    public void setRetinaDisplayIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)9, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetHostIP();
                    break;
                }
                this.setHostIP((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetClientIP();
                    break;
                }
                this.setClientIP((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetServerIP();
                    break;
                }
                this.setServerIP((String)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetUserAgent();
                    break;
                }
                this.setUserAgent((String)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetSecureConnection();
                    break;
                }
                this.setSecureConnection((Boolean)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetBrowserType();
                    break;
                }
                this.setBrowserType((BrowserType)((Object)object));
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetClientSystemVersion();
                    break;
                }
                this.setClientSystemVersion((String)object);
                break;
            }
            case 7: {
                if (object == null) {
                    this.unsetClientDevice();
                    break;
                }
                this.setClientDevice((Short)object);
                break;
            }
            case 8: {
                if (object == null) {
                    this.unsetBrowserCountry();
                    break;
                }
                this.setBrowserCountry((String)object);
                break;
            }
            case 9: {
                if (object == null) {
                    this.unsetBrowserLanguage();
                    break;
                }
                this.setBrowserLanguage((String)object);
                break;
            }
            case 10: {
                if (object == null) {
                    this.unsetHighContrastColor();
                    break;
                }
                this.setHighContrastColor((String)object);
                break;
            }
            case 11: {
                if (object == null) {
                    this.unsetHighContrastState();
                    break;
                }
                this.setHighContrastState((Boolean)object);
                break;
            }
            case 12: {
                if (object == null) {
                    this.unsetPersistentID();
                    break;
                }
                this.setPersistentID((String)object);
                break;
            }
            case 13: {
                if (object == null) {
                    this.unsetScreenDepth();
                    break;
                }
                this.setScreenDepth((Integer)object);
                break;
            }
            case 14: {
                if (object == null) {
                    this.unsetScreenHeight();
                    break;
                }
                this.setScreenHeight((Integer)object);
                break;
            }
            case 15: {
                if (object == null) {
                    this.unsetScreenWidth();
                    break;
                }
                this.setScreenWidth((Integer)object);
                break;
            }
            case 16: {
                if (object == null) {
                    this.unsetMenubarHeight();
                    break;
                }
                this.setMenubarHeight((Integer)object);
                break;
            }
            case 17: {
                if (object == null) {
                    this.unsetFooterContainerHeight();
                    break;
                }
                this.setFooterContainerHeight((Integer)object);
                break;
            }
            case 18: {
                if (object == null) {
                    this.unsetStatusAreaHeight();
                    break;
                }
                this.setStatusAreaHeight((Integer)object);
                break;
            }
            case 19: {
                if (object == null) {
                    this.unsetBrowserDimensions();
                    break;
                }
                this.setBrowserDimensions((Dimensions)object);
                break;
            }
            case 20: {
                if (object == null) {
                    this.unsetRetinaDisplay();
                    break;
                }
                this.setRetinaDisplay((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getHostIP();
            }
            case 1: {
                return this.getClientIP();
            }
            case 2: {
                return this.getServerIP();
            }
            case 3: {
                return this.getUserAgent();
            }
            case 4: {
                return this.isSecureConnection();
            }
            case 5: {
                return this.getBrowserType();
            }
            case 6: {
                return this.getClientSystemVersion();
            }
            case 7: {
                return this.getClientDevice();
            }
            case 8: {
                return this.getBrowserCountry();
            }
            case 9: {
                return this.getBrowserLanguage();
            }
            case 10: {
                return this.getHighContrastColor();
            }
            case 11: {
                return this.isHighContrastState();
            }
            case 12: {
                return this.getPersistentID();
            }
            case 13: {
                return this.getScreenDepth();
            }
            case 14: {
                return this.getScreenHeight();
            }
            case 15: {
                return this.getScreenWidth();
            }
            case 16: {
                return this.getMenubarHeight();
            }
            case 17: {
                return this.getFooterContainerHeight();
            }
            case 18: {
                return this.getStatusAreaHeight();
            }
            case 19: {
                return this.getBrowserDimensions();
            }
            case 20: {
                return this.isRetinaDisplay();
            }
        }
        throw new IllegalStateException();
    }

    public boolean isSet(_Fields _Fields2) {
        if (_Fields2 == null) {
            throw new IllegalArgumentException();
        }
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.isSetHostIP();
            }
            case 1: {
                return this.isSetClientIP();
            }
            case 2: {
                return this.isSetServerIP();
            }
            case 3: {
                return this.isSetUserAgent();
            }
            case 4: {
                return this.isSetSecureConnection();
            }
            case 5: {
                return this.isSetBrowserType();
            }
            case 6: {
                return this.isSetClientSystemVersion();
            }
            case 7: {
                return this.isSetClientDevice();
            }
            case 8: {
                return this.isSetBrowserCountry();
            }
            case 9: {
                return this.isSetBrowserLanguage();
            }
            case 10: {
                return this.isSetHighContrastColor();
            }
            case 11: {
                return this.isSetHighContrastState();
            }
            case 12: {
                return this.isSetPersistentID();
            }
            case 13: {
                return this.isSetScreenDepth();
            }
            case 14: {
                return this.isSetScreenHeight();
            }
            case 15: {
                return this.isSetScreenWidth();
            }
            case 16: {
                return this.isSetMenubarHeight();
            }
            case 17: {
                return this.isSetFooterContainerHeight();
            }
            case 18: {
                return this.isSetStatusAreaHeight();
            }
            case 19: {
                return this.isSetBrowserDimensions();
            }
            case 20: {
                return this.isSetRetinaDisplay();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof BrowserClientInfo) {
            return this.equals((BrowserClientInfo)object);
        }
        return false;
    }

    public boolean equals(BrowserClientInfo browserClientInfo) {
        if (browserClientInfo == null) {
            return false;
        }
        if (this == browserClientInfo) {
            return true;
        }
        boolean bl = this.isSetHostIP();
        boolean bl2 = browserClientInfo.isSetHostIP();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.hostIP.equals(browserClientInfo.hostIP)) {
                return false;
            }
        }
        boolean bl3 = this.isSetClientIP();
        boolean bl4 = browserClientInfo.isSetClientIP();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.clientIP.equals(browserClientInfo.clientIP)) {
                return false;
            }
        }
        boolean bl5 = this.isSetServerIP();
        boolean bl6 = browserClientInfo.isSetServerIP();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.serverIP.equals(browserClientInfo.serverIP)) {
                return false;
            }
        }
        boolean bl7 = this.isSetUserAgent();
        boolean bl8 = browserClientInfo.isSetUserAgent();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.userAgent.equals(browserClientInfo.userAgent)) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.secureConnection != browserClientInfo.secureConnection) {
                return false;
            }
        }
        boolean bl11 = this.isSetBrowserType();
        boolean bl12 = browserClientInfo.isSetBrowserType();
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (!this.browserType.equals((Object)browserClientInfo.browserType)) {
                return false;
            }
        }
        boolean bl13 = this.isSetClientSystemVersion();
        boolean bl14 = browserClientInfo.isSetClientSystemVersion();
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (!this.clientSystemVersion.equals(browserClientInfo.clientSystemVersion)) {
                return false;
            }
        }
        boolean bl15 = true;
        boolean bl16 = true;
        if (bl15 || bl16) {
            if (!bl15 || !bl16) {
                return false;
            }
            if (this.clientDevice != browserClientInfo.clientDevice) {
                return false;
            }
        }
        boolean bl17 = this.isSetBrowserCountry();
        boolean bl18 = browserClientInfo.isSetBrowserCountry();
        if (bl17 || bl18) {
            if (!bl17 || !bl18) {
                return false;
            }
            if (!this.browserCountry.equals(browserClientInfo.browserCountry)) {
                return false;
            }
        }
        boolean bl19 = this.isSetBrowserLanguage();
        boolean bl20 = browserClientInfo.isSetBrowserLanguage();
        if (bl19 || bl20) {
            if (!bl19 || !bl20) {
                return false;
            }
            if (!this.browserLanguage.equals(browserClientInfo.browserLanguage)) {
                return false;
            }
        }
        boolean bl21 = this.isSetHighContrastColor();
        boolean bl22 = browserClientInfo.isSetHighContrastColor();
        if (bl21 || bl22) {
            if (!bl21 || !bl22) {
                return false;
            }
            if (!this.highContrastColor.equals(browserClientInfo.highContrastColor)) {
                return false;
            }
        }
        boolean bl23 = true;
        boolean bl24 = true;
        if (bl23 || bl24) {
            if (!bl23 || !bl24) {
                return false;
            }
            if (this.highContrastState != browserClientInfo.highContrastState) {
                return false;
            }
        }
        boolean bl25 = this.isSetPersistentID();
        boolean bl26 = browserClientInfo.isSetPersistentID();
        if (bl25 || bl26) {
            if (!bl25 || !bl26) {
                return false;
            }
            if (!this.persistentID.equals(browserClientInfo.persistentID)) {
                return false;
            }
        }
        boolean bl27 = true;
        boolean bl28 = true;
        if (bl27 || bl28) {
            if (!bl27 || !bl28) {
                return false;
            }
            if (this.screenDepth != browserClientInfo.screenDepth) {
                return false;
            }
        }
        boolean bl29 = true;
        boolean bl30 = true;
        if (bl29 || bl30) {
            if (!bl29 || !bl30) {
                return false;
            }
            if (this.screenHeight != browserClientInfo.screenHeight) {
                return false;
            }
        }
        boolean bl31 = true;
        boolean bl32 = true;
        if (bl31 || bl32) {
            if (!bl31 || !bl32) {
                return false;
            }
            if (this.screenWidth != browserClientInfo.screenWidth) {
                return false;
            }
        }
        boolean bl33 = true;
        boolean bl34 = true;
        if (bl33 || bl34) {
            if (!bl33 || !bl34) {
                return false;
            }
            if (this.menubarHeight != browserClientInfo.menubarHeight) {
                return false;
            }
        }
        boolean bl35 = true;
        boolean bl36 = true;
        if (bl35 || bl36) {
            if (!bl35 || !bl36) {
                return false;
            }
            if (this.footerContainerHeight != browserClientInfo.footerContainerHeight) {
                return false;
            }
        }
        boolean bl37 = true;
        boolean bl38 = true;
        if (bl37 || bl38) {
            if (!bl37 || !bl38) {
                return false;
            }
            if (this.statusAreaHeight != browserClientInfo.statusAreaHeight) {
                return false;
            }
        }
        boolean bl39 = this.isSetBrowserDimensions();
        boolean bl40 = browserClientInfo.isSetBrowserDimensions();
        if (bl39 || bl40) {
            if (!bl39 || !bl40) {
                return false;
            }
            if (!this.browserDimensions.equals(browserClientInfo.browserDimensions)) {
                return false;
            }
        }
        boolean bl41 = true;
        boolean bl42 = true;
        if (bl41 || bl42) {
            if (!bl41 || !bl42) {
                return false;
            }
            if (this.retinaDisplay != browserClientInfo.retinaDisplay) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetHostIP() ? 131071 : 524287);
        if (this.isSetHostIP()) {
            n = n * 8191 + this.hostIP.hashCode();
        }
        n = n * 8191 + (this.isSetClientIP() ? 131071 : 524287);
        if (this.isSetClientIP()) {
            n = n * 8191 + this.clientIP.hashCode();
        }
        n = n * 8191 + (this.isSetServerIP() ? 131071 : 524287);
        if (this.isSetServerIP()) {
            n = n * 8191 + this.serverIP.hashCode();
        }
        n = n * 8191 + (this.isSetUserAgent() ? 131071 : 524287);
        if (this.isSetUserAgent()) {
            n = n * 8191 + this.userAgent.hashCode();
        }
        n = n * 8191 + (this.secureConnection ? 131071 : 524287);
        n = n * 8191 + (this.isSetBrowserType() ? 131071 : 524287);
        if (this.isSetBrowserType()) {
            n = n * 8191 + this.browserType.getValue();
        }
        n = n * 8191 + (this.isSetClientSystemVersion() ? 131071 : 524287);
        if (this.isSetClientSystemVersion()) {
            n = n * 8191 + this.clientSystemVersion.hashCode();
        }
        n = n * 8191 + this.clientDevice;
        n = n * 8191 + (this.isSetBrowserCountry() ? 131071 : 524287);
        if (this.isSetBrowserCountry()) {
            n = n * 8191 + this.browserCountry.hashCode();
        }
        n = n * 8191 + (this.isSetBrowserLanguage() ? 131071 : 524287);
        if (this.isSetBrowserLanguage()) {
            n = n * 8191 + this.browserLanguage.hashCode();
        }
        n = n * 8191 + (this.isSetHighContrastColor() ? 131071 : 524287);
        if (this.isSetHighContrastColor()) {
            n = n * 8191 + this.highContrastColor.hashCode();
        }
        n = n * 8191 + (this.highContrastState ? 131071 : 524287);
        n = n * 8191 + (this.isSetPersistentID() ? 131071 : 524287);
        if (this.isSetPersistentID()) {
            n = n * 8191 + this.persistentID.hashCode();
        }
        n = n * 8191 + this.screenDepth;
        n = n * 8191 + this.screenHeight;
        n = n * 8191 + this.screenWidth;
        n = n * 8191 + this.menubarHeight;
        n = n * 8191 + this.footerContainerHeight;
        n = n * 8191 + this.statusAreaHeight;
        n = n * 8191 + (this.isSetBrowserDimensions() ? 131071 : 524287);
        if (this.isSetBrowserDimensions()) {
            n = n * 8191 + this.browserDimensions.hashCode();
        }
        n = n * 8191 + (this.retinaDisplay ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(BrowserClientInfo browserClientInfo) {
        if (!this.getClass().equals(browserClientInfo.getClass())) {
            return this.getClass().getName().compareTo(browserClientInfo.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetHostIP(), browserClientInfo.isSetHostIP());
        if (n != 0) {
            return n;
        }
        if (this.isSetHostIP() && (n = TBaseHelper.compareTo((String)this.hostIP, (String)browserClientInfo.hostIP)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetClientIP(), browserClientInfo.isSetClientIP());
        if (n != 0) {
            return n;
        }
        if (this.isSetClientIP() && (n = TBaseHelper.compareTo((String)this.clientIP, (String)browserClientInfo.clientIP)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetServerIP(), browserClientInfo.isSetServerIP());
        if (n != 0) {
            return n;
        }
        if (this.isSetServerIP() && (n = TBaseHelper.compareTo((String)this.serverIP, (String)browserClientInfo.serverIP)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetUserAgent(), browserClientInfo.isSetUserAgent());
        if (n != 0) {
            return n;
        }
        if (this.isSetUserAgent() && (n = TBaseHelper.compareTo((String)this.userAgent, (String)browserClientInfo.userAgent)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSecureConnection(), browserClientInfo.isSetSecureConnection());
        if (n != 0) {
            return n;
        }
        if (this.isSetSecureConnection() && (n = TBaseHelper.compareTo((boolean)this.secureConnection, (boolean)browserClientInfo.secureConnection)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetBrowserType(), browserClientInfo.isSetBrowserType());
        if (n != 0) {
            return n;
        }
        if (this.isSetBrowserType() && (n = TBaseHelper.compareTo((Comparable)((Object)this.browserType), (Comparable)((Object)browserClientInfo.browserType))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetClientSystemVersion(), browserClientInfo.isSetClientSystemVersion());
        if (n != 0) {
            return n;
        }
        if (this.isSetClientSystemVersion() && (n = TBaseHelper.compareTo((String)this.clientSystemVersion, (String)browserClientInfo.clientSystemVersion)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetClientDevice(), browserClientInfo.isSetClientDevice());
        if (n != 0) {
            return n;
        }
        if (this.isSetClientDevice() && (n = TBaseHelper.compareTo((short)this.clientDevice, (short)browserClientInfo.clientDevice)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetBrowserCountry(), browserClientInfo.isSetBrowserCountry());
        if (n != 0) {
            return n;
        }
        if (this.isSetBrowserCountry() && (n = TBaseHelper.compareTo((String)this.browserCountry, (String)browserClientInfo.browserCountry)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetBrowserLanguage(), browserClientInfo.isSetBrowserLanguage());
        if (n != 0) {
            return n;
        }
        if (this.isSetBrowserLanguage() && (n = TBaseHelper.compareTo((String)this.browserLanguage, (String)browserClientInfo.browserLanguage)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetHighContrastColor(), browserClientInfo.isSetHighContrastColor());
        if (n != 0) {
            return n;
        }
        if (this.isSetHighContrastColor() && (n = TBaseHelper.compareTo((String)this.highContrastColor, (String)browserClientInfo.highContrastColor)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetHighContrastState(), browserClientInfo.isSetHighContrastState());
        if (n != 0) {
            return n;
        }
        if (this.isSetHighContrastState() && (n = TBaseHelper.compareTo((boolean)this.highContrastState, (boolean)browserClientInfo.highContrastState)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPersistentID(), browserClientInfo.isSetPersistentID());
        if (n != 0) {
            return n;
        }
        if (this.isSetPersistentID() && (n = TBaseHelper.compareTo((String)this.persistentID, (String)browserClientInfo.persistentID)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetScreenDepth(), browserClientInfo.isSetScreenDepth());
        if (n != 0) {
            return n;
        }
        if (this.isSetScreenDepth() && (n = TBaseHelper.compareTo((int)this.screenDepth, (int)browserClientInfo.screenDepth)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetScreenHeight(), browserClientInfo.isSetScreenHeight());
        if (n != 0) {
            return n;
        }
        if (this.isSetScreenHeight() && (n = TBaseHelper.compareTo((int)this.screenHeight, (int)browserClientInfo.screenHeight)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetScreenWidth(), browserClientInfo.isSetScreenWidth());
        if (n != 0) {
            return n;
        }
        if (this.isSetScreenWidth() && (n = TBaseHelper.compareTo((int)this.screenWidth, (int)browserClientInfo.screenWidth)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetMenubarHeight(), browserClientInfo.isSetMenubarHeight());
        if (n != 0) {
            return n;
        }
        if (this.isSetMenubarHeight() && (n = TBaseHelper.compareTo((int)this.menubarHeight, (int)browserClientInfo.menubarHeight)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFooterContainerHeight(), browserClientInfo.isSetFooterContainerHeight());
        if (n != 0) {
            return n;
        }
        if (this.isSetFooterContainerHeight() && (n = TBaseHelper.compareTo((int)this.footerContainerHeight, (int)browserClientInfo.footerContainerHeight)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetStatusAreaHeight(), browserClientInfo.isSetStatusAreaHeight());
        if (n != 0) {
            return n;
        }
        if (this.isSetStatusAreaHeight() && (n = TBaseHelper.compareTo((int)this.statusAreaHeight, (int)browserClientInfo.statusAreaHeight)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetBrowserDimensions(), browserClientInfo.isSetBrowserDimensions());
        if (n != 0) {
            return n;
        }
        if (this.isSetBrowserDimensions() && (n = TBaseHelper.compareTo((Comparable)this.browserDimensions, (Comparable)browserClientInfo.browserDimensions)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRetinaDisplay(), browserClientInfo.isSetRetinaDisplay());
        if (n != 0) {
            return n;
        }
        if (this.isSetRetinaDisplay() && (n = TBaseHelper.compareTo((boolean)this.retinaDisplay, (boolean)browserClientInfo.retinaDisplay)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        BrowserClientInfo.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        BrowserClientInfo.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("BrowserClientInfo(");
        boolean bl = true;
        stringBuilder.append("hostIP:");
        if (this.hostIP == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.hostIP);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("clientIP:");
        if (this.clientIP == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.clientIP);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("serverIP:");
        if (this.serverIP == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.serverIP);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("userAgent:");
        if (this.userAgent == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.userAgent);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("secureConnection:");
        stringBuilder.append(this.secureConnection);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("browserType:");
        if (this.browserType == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.browserType);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("clientSystemVersion:");
        if (this.clientSystemVersion == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.clientSystemVersion);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("clientDevice:");
        stringBuilder.append(this.clientDevice);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("browserCountry:");
        if (this.browserCountry == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.browserCountry);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("browserLanguage:");
        if (this.browserLanguage == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.browserLanguage);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("highContrastColor:");
        if (this.highContrastColor == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.highContrastColor);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("highContrastState:");
        stringBuilder.append(this.highContrastState);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("persistentID:");
        if (this.persistentID == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.persistentID);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("screenDepth:");
        stringBuilder.append(this.screenDepth);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("screenHeight:");
        stringBuilder.append(this.screenHeight);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("screenWidth:");
        stringBuilder.append(this.screenWidth);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("menubarHeight:");
        stringBuilder.append(this.menubarHeight);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("footerContainerHeight:");
        stringBuilder.append(this.footerContainerHeight);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("statusAreaHeight:");
        stringBuilder.append(this.statusAreaHeight);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("browserDimensions:");
        if (this.browserDimensions == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.browserDimensions);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("retinaDisplay:");
        stringBuilder.append(this.retinaDisplay);
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.browserDimensions != null) {
            this.browserDimensions.validate();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            this.write((TProtocol)new TCompactProtocol((TTransport)new TIOStreamTransport((OutputStream)objectOutputStream)));
        }
        catch (TException tException) {
            throw new IOException(tException);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.__isset_bitfield = 0;
            this.read((TProtocol)new TCompactProtocol((TTransport)new TIOStreamTransport((InputStream)objectInputStream)));
        }
        catch (TException tException) {
            throw new IOException(tException);
        }
    }

    private static <S extends IScheme> S scheme(TProtocol tProtocol) {
        return (S)(StandardScheme.class.equals((Object)tProtocol.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }

    static {
        EnumMap<_Fields, FieldMetaData> enumMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
        enumMap.put(_Fields.HOST_IP, new FieldMetaData("hostIP", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.CLIENT_IP, new FieldMetaData("clientIP", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.SERVER_IP, new FieldMetaData("serverIP", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.USER_AGENT, new FieldMetaData("userAgent", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.SECURE_CONNECTION, new FieldMetaData("secureConnection", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.BROWSER_TYPE, new FieldMetaData("browserType", 3, (FieldValueMetaData)new EnumMetaData(-1, BrowserType.class)));
        enumMap.put(_Fields.CLIENT_SYSTEM_VERSION, new FieldMetaData("clientSystemVersion", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.CLIENT_DEVICE, new FieldMetaData("clientDevice", 3, new FieldValueMetaData(6)));
        enumMap.put(_Fields.BROWSER_COUNTRY, new FieldMetaData("browserCountry", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.BROWSER_LANGUAGE, new FieldMetaData("browserLanguage", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.HIGH_CONTRAST_COLOR, new FieldMetaData("highContrastColor", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.HIGH_CONTRAST_STATE, new FieldMetaData("highContrastState", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.PERSISTENT_ID, new FieldMetaData("persistentID", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.SCREEN_DEPTH, new FieldMetaData("screenDepth", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.SCREEN_HEIGHT, new FieldMetaData("screenHeight", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.SCREEN_WIDTH, new FieldMetaData("screenWidth", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.MENUBAR_HEIGHT, new FieldMetaData("menubarHeight", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.FOOTER_CONTAINER_HEIGHT, new FieldMetaData("footerContainerHeight", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.STATUS_AREA_HEIGHT, new FieldMetaData("statusAreaHeight", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.BROWSER_DIMENSIONS, new FieldMetaData("browserDimensions", 3, (FieldValueMetaData)new StructMetaData(12, Dimensions.class)));
        enumMap.put(_Fields.RETINA_DISPLAY, new FieldMetaData("retinaDisplay", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(BrowserClientInfo.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        HOST_IP(1, "hostIP"),
        CLIENT_IP(2, "clientIP"),
        SERVER_IP(3, "serverIP"),
        USER_AGENT(4, "userAgent"),
        SECURE_CONNECTION(5, "secureConnection"),
        BROWSER_TYPE(6, "browserType"),
        CLIENT_SYSTEM_VERSION(7, "clientSystemVersion"),
        CLIENT_DEVICE(8, "clientDevice"),
        BROWSER_COUNTRY(9, "browserCountry"),
        BROWSER_LANGUAGE(10, "browserLanguage"),
        HIGH_CONTRAST_COLOR(11, "highContrastColor"),
        HIGH_CONTRAST_STATE(12, "highContrastState"),
        PERSISTENT_ID(13, "persistentID"),
        SCREEN_DEPTH(14, "screenDepth"),
        SCREEN_HEIGHT(15, "screenHeight"),
        SCREEN_WIDTH(16, "screenWidth"),
        MENUBAR_HEIGHT(17, "menubarHeight"),
        FOOTER_CONTAINER_HEIGHT(18, "footerContainerHeight"),
        STATUS_AREA_HEIGHT(19, "statusAreaHeight"),
        BROWSER_DIMENSIONS(20, "browserDimensions"),
        RETINA_DISPLAY(21, "retinaDisplay");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return HOST_IP;
                }
                case 2: {
                    return CLIENT_IP;
                }
                case 3: {
                    return SERVER_IP;
                }
                case 4: {
                    return USER_AGENT;
                }
                case 5: {
                    return SECURE_CONNECTION;
                }
                case 6: {
                    return BROWSER_TYPE;
                }
                case 7: {
                    return CLIENT_SYSTEM_VERSION;
                }
                case 8: {
                    return CLIENT_DEVICE;
                }
                case 9: {
                    return BROWSER_COUNTRY;
                }
                case 10: {
                    return BROWSER_LANGUAGE;
                }
                case 11: {
                    return HIGH_CONTRAST_COLOR;
                }
                case 12: {
                    return HIGH_CONTRAST_STATE;
                }
                case 13: {
                    return PERSISTENT_ID;
                }
                case 14: {
                    return SCREEN_DEPTH;
                }
                case 15: {
                    return SCREEN_HEIGHT;
                }
                case 16: {
                    return SCREEN_WIDTH;
                }
                case 17: {
                    return MENUBAR_HEIGHT;
                }
                case 18: {
                    return FOOTER_CONTAINER_HEIGHT;
                }
                case 19: {
                    return STATUS_AREA_HEIGHT;
                }
                case 20: {
                    return BROWSER_DIMENSIONS;
                }
                case 21: {
                    return RETINA_DISPLAY;
                }
            }
            return null;
        }

        public static _Fields findByThriftIdOrThrow(int n) {
            _Fields _Fields2 = _Fields.findByThriftId(n);
            if (_Fields2 == null) {
                throw new IllegalArgumentException("Field " + n + " doesn't exist!");
            }
            return _Fields2;
        }

        @Nullable
        public static _Fields findByName(String string) {
            return byName.get(string);
        }

        private _Fields(short s, String string2) {
            this._thriftId = s;
            this._fieldName = string2;
        }

        public short getThriftFieldId() {
            return this._thriftId;
        }

        public String getFieldName() {
            return this._fieldName;
        }

        static {
            byName = new HashMap<String, _Fields>();
            for (_Fields _Fields2 : EnumSet.allOf(_Fields.class)) {
                byName.put(_Fields2.getFieldName(), _Fields2);
            }
        }
    }

    private static class BrowserClientInfoStandardSchemeFactory
    implements SchemeFactory {
        private BrowserClientInfoStandardSchemeFactory() {
        }

        public BrowserClientInfoStandardScheme getScheme() {
            return new BrowserClientInfoStandardScheme();
        }
    }

    private static class BrowserClientInfoTupleSchemeFactory
    implements SchemeFactory {
        private BrowserClientInfoTupleSchemeFactory() {
        }

        public BrowserClientInfoTupleScheme getScheme() {
            return new BrowserClientInfoTupleScheme();
        }
    }

    private static class BrowserClientInfoTupleScheme
    extends TupleScheme<BrowserClientInfo> {
        private BrowserClientInfoTupleScheme() {
        }

        public void write(TProtocol tProtocol, BrowserClientInfo browserClientInfo) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (browserClientInfo.isSetHostIP()) {
                bitSet.set(0);
            }
            if (browserClientInfo.isSetClientIP()) {
                bitSet.set(1);
            }
            if (browserClientInfo.isSetServerIP()) {
                bitSet.set(2);
            }
            if (browserClientInfo.isSetUserAgent()) {
                bitSet.set(3);
            }
            if (browserClientInfo.isSetSecureConnection()) {
                bitSet.set(4);
            }
            if (browserClientInfo.isSetBrowserType()) {
                bitSet.set(5);
            }
            if (browserClientInfo.isSetClientSystemVersion()) {
                bitSet.set(6);
            }
            if (browserClientInfo.isSetClientDevice()) {
                bitSet.set(7);
            }
            if (browserClientInfo.isSetBrowserCountry()) {
                bitSet.set(8);
            }
            if (browserClientInfo.isSetBrowserLanguage()) {
                bitSet.set(9);
            }
            if (browserClientInfo.isSetHighContrastColor()) {
                bitSet.set(10);
            }
            if (browserClientInfo.isSetHighContrastState()) {
                bitSet.set(11);
            }
            if (browserClientInfo.isSetPersistentID()) {
                bitSet.set(12);
            }
            if (browserClientInfo.isSetScreenDepth()) {
                bitSet.set(13);
            }
            if (browserClientInfo.isSetScreenHeight()) {
                bitSet.set(14);
            }
            if (browserClientInfo.isSetScreenWidth()) {
                bitSet.set(15);
            }
            if (browserClientInfo.isSetMenubarHeight()) {
                bitSet.set(16);
            }
            if (browserClientInfo.isSetFooterContainerHeight()) {
                bitSet.set(17);
            }
            if (browserClientInfo.isSetStatusAreaHeight()) {
                bitSet.set(18);
            }
            if (browserClientInfo.isSetBrowserDimensions()) {
                bitSet.set(19);
            }
            if (browserClientInfo.isSetRetinaDisplay()) {
                bitSet.set(20);
            }
            tTupleProtocol.writeBitSet(bitSet, 21);
            if (browserClientInfo.isSetHostIP()) {
                tTupleProtocol.writeString(browserClientInfo.hostIP);
            }
            if (browserClientInfo.isSetClientIP()) {
                tTupleProtocol.writeString(browserClientInfo.clientIP);
            }
            if (browserClientInfo.isSetServerIP()) {
                tTupleProtocol.writeString(browserClientInfo.serverIP);
            }
            if (browserClientInfo.isSetUserAgent()) {
                tTupleProtocol.writeString(browserClientInfo.userAgent);
            }
            if (browserClientInfo.isSetSecureConnection()) {
                tTupleProtocol.writeBool(browserClientInfo.secureConnection);
            }
            if (browserClientInfo.isSetBrowserType()) {
                tTupleProtocol.writeI32(browserClientInfo.browserType.getValue());
            }
            if (browserClientInfo.isSetClientSystemVersion()) {
                tTupleProtocol.writeString(browserClientInfo.clientSystemVersion);
            }
            if (browserClientInfo.isSetClientDevice()) {
                tTupleProtocol.writeI16(browserClientInfo.clientDevice);
            }
            if (browserClientInfo.isSetBrowserCountry()) {
                tTupleProtocol.writeString(browserClientInfo.browserCountry);
            }
            if (browserClientInfo.isSetBrowserLanguage()) {
                tTupleProtocol.writeString(browserClientInfo.browserLanguage);
            }
            if (browserClientInfo.isSetHighContrastColor()) {
                tTupleProtocol.writeString(browserClientInfo.highContrastColor);
            }
            if (browserClientInfo.isSetHighContrastState()) {
                tTupleProtocol.writeBool(browserClientInfo.highContrastState);
            }
            if (browserClientInfo.isSetPersistentID()) {
                tTupleProtocol.writeString(browserClientInfo.persistentID);
            }
            if (browserClientInfo.isSetScreenDepth()) {
                tTupleProtocol.writeI32(browserClientInfo.screenDepth);
            }
            if (browserClientInfo.isSetScreenHeight()) {
                tTupleProtocol.writeI32(browserClientInfo.screenHeight);
            }
            if (browserClientInfo.isSetScreenWidth()) {
                tTupleProtocol.writeI32(browserClientInfo.screenWidth);
            }
            if (browserClientInfo.isSetMenubarHeight()) {
                tTupleProtocol.writeI32(browserClientInfo.menubarHeight);
            }
            if (browserClientInfo.isSetFooterContainerHeight()) {
                tTupleProtocol.writeI32(browserClientInfo.footerContainerHeight);
            }
            if (browserClientInfo.isSetStatusAreaHeight()) {
                tTupleProtocol.writeI32(browserClientInfo.statusAreaHeight);
            }
            if (browserClientInfo.isSetBrowserDimensions()) {
                browserClientInfo.browserDimensions.write((TProtocol)tTupleProtocol);
            }
            if (browserClientInfo.isSetRetinaDisplay()) {
                tTupleProtocol.writeBool(browserClientInfo.retinaDisplay);
            }
        }

        public void read(TProtocol tProtocol, BrowserClientInfo browserClientInfo) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(21);
            if (bitSet.get(0)) {
                browserClientInfo.hostIP = tTupleProtocol.readString();
                browserClientInfo.setHostIPIsSet(true);
            }
            if (bitSet.get(1)) {
                browserClientInfo.clientIP = tTupleProtocol.readString();
                browserClientInfo.setClientIPIsSet(true);
            }
            if (bitSet.get(2)) {
                browserClientInfo.serverIP = tTupleProtocol.readString();
                browserClientInfo.setServerIPIsSet(true);
            }
            if (bitSet.get(3)) {
                browserClientInfo.userAgent = tTupleProtocol.readString();
                browserClientInfo.setUserAgentIsSet(true);
            }
            if (bitSet.get(4)) {
                browserClientInfo.secureConnection = tTupleProtocol.readBool();
                browserClientInfo.setSecureConnectionIsSet(true);
            }
            if (bitSet.get(5)) {
                browserClientInfo.browserType = BrowserType.findByValue(tTupleProtocol.readI32());
                browserClientInfo.setBrowserTypeIsSet(true);
            }
            if (bitSet.get(6)) {
                browserClientInfo.clientSystemVersion = tTupleProtocol.readString();
                browserClientInfo.setClientSystemVersionIsSet(true);
            }
            if (bitSet.get(7)) {
                browserClientInfo.clientDevice = tTupleProtocol.readI16();
                browserClientInfo.setClientDeviceIsSet(true);
            }
            if (bitSet.get(8)) {
                browserClientInfo.browserCountry = tTupleProtocol.readString();
                browserClientInfo.setBrowserCountryIsSet(true);
            }
            if (bitSet.get(9)) {
                browserClientInfo.browserLanguage = tTupleProtocol.readString();
                browserClientInfo.setBrowserLanguageIsSet(true);
            }
            if (bitSet.get(10)) {
                browserClientInfo.highContrastColor = tTupleProtocol.readString();
                browserClientInfo.setHighContrastColorIsSet(true);
            }
            if (bitSet.get(11)) {
                browserClientInfo.highContrastState = tTupleProtocol.readBool();
                browserClientInfo.setHighContrastStateIsSet(true);
            }
            if (bitSet.get(12)) {
                browserClientInfo.persistentID = tTupleProtocol.readString();
                browserClientInfo.setPersistentIDIsSet(true);
            }
            if (bitSet.get(13)) {
                browserClientInfo.screenDepth = tTupleProtocol.readI32();
                browserClientInfo.setScreenDepthIsSet(true);
            }
            if (bitSet.get(14)) {
                browserClientInfo.screenHeight = tTupleProtocol.readI32();
                browserClientInfo.setScreenHeightIsSet(true);
            }
            if (bitSet.get(15)) {
                browserClientInfo.screenWidth = tTupleProtocol.readI32();
                browserClientInfo.setScreenWidthIsSet(true);
            }
            if (bitSet.get(16)) {
                browserClientInfo.menubarHeight = tTupleProtocol.readI32();
                browserClientInfo.setMenubarHeightIsSet(true);
            }
            if (bitSet.get(17)) {
                browserClientInfo.footerContainerHeight = tTupleProtocol.readI32();
                browserClientInfo.setFooterContainerHeightIsSet(true);
            }
            if (bitSet.get(18)) {
                browserClientInfo.statusAreaHeight = tTupleProtocol.readI32();
                browserClientInfo.setStatusAreaHeightIsSet(true);
            }
            if (bitSet.get(19)) {
                browserClientInfo.browserDimensions = new Dimensions();
                browserClientInfo.browserDimensions.read((TProtocol)tTupleProtocol);
                browserClientInfo.setBrowserDimensionsIsSet(true);
            }
            if (bitSet.get(20)) {
                browserClientInfo.retinaDisplay = tTupleProtocol.readBool();
                browserClientInfo.setRetinaDisplayIsSet(true);
            }
        }
    }

    private static class BrowserClientInfoStandardScheme
    extends StandardScheme<BrowserClientInfo> {
        private BrowserClientInfoStandardScheme() {
        }

        public void read(TProtocol tProtocol, BrowserClientInfo browserClientInfo) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            browserClientInfo.hostIP = tProtocol.readString();
                            browserClientInfo.setHostIPIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            browserClientInfo.clientIP = tProtocol.readString();
                            browserClientInfo.setClientIPIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            browserClientInfo.serverIP = tProtocol.readString();
                            browserClientInfo.setServerIPIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            browserClientInfo.userAgent = tProtocol.readString();
                            browserClientInfo.setUserAgentIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 2) {
                            browserClientInfo.secureConnection = tProtocol.readBool();
                            browserClientInfo.setSecureConnectionIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 8) {
                            browserClientInfo.browserType = BrowserType.findByValue(tProtocol.readI32());
                            browserClientInfo.setBrowserTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        if (tField.type == 11) {
                            browserClientInfo.clientSystemVersion = tProtocol.readString();
                            browserClientInfo.setClientSystemVersionIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 8: {
                        if (tField.type == 6) {
                            browserClientInfo.clientDevice = tProtocol.readI16();
                            browserClientInfo.setClientDeviceIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 9: {
                        if (tField.type == 11) {
                            browserClientInfo.browserCountry = tProtocol.readString();
                            browserClientInfo.setBrowserCountryIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 10: {
                        if (tField.type == 11) {
                            browserClientInfo.browserLanguage = tProtocol.readString();
                            browserClientInfo.setBrowserLanguageIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 11: {
                        if (tField.type == 11) {
                            browserClientInfo.highContrastColor = tProtocol.readString();
                            browserClientInfo.setHighContrastColorIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 12: {
                        if (tField.type == 2) {
                            browserClientInfo.highContrastState = tProtocol.readBool();
                            browserClientInfo.setHighContrastStateIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 13: {
                        if (tField.type == 11) {
                            browserClientInfo.persistentID = tProtocol.readString();
                            browserClientInfo.setPersistentIDIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 14: {
                        if (tField.type == 8) {
                            browserClientInfo.screenDepth = tProtocol.readI32();
                            browserClientInfo.setScreenDepthIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 15: {
                        if (tField.type == 8) {
                            browserClientInfo.screenHeight = tProtocol.readI32();
                            browserClientInfo.setScreenHeightIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 16: {
                        if (tField.type == 8) {
                            browserClientInfo.screenWidth = tProtocol.readI32();
                            browserClientInfo.setScreenWidthIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 17: {
                        if (tField.type == 8) {
                            browserClientInfo.menubarHeight = tProtocol.readI32();
                            browserClientInfo.setMenubarHeightIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 18: {
                        if (tField.type == 8) {
                            browserClientInfo.footerContainerHeight = tProtocol.readI32();
                            browserClientInfo.setFooterContainerHeightIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 19: {
                        if (tField.type == 8) {
                            browserClientInfo.statusAreaHeight = tProtocol.readI32();
                            browserClientInfo.setStatusAreaHeightIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 20: {
                        if (tField.type == 12) {
                            browserClientInfo.browserDimensions = new Dimensions();
                            browserClientInfo.browserDimensions.read(tProtocol);
                            browserClientInfo.setBrowserDimensionsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 21: {
                        if (tField.type == 2) {
                            browserClientInfo.retinaDisplay = tProtocol.readBool();
                            browserClientInfo.setRetinaDisplayIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    default: {
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                    }
                }
                tProtocol.readFieldEnd();
            }
            tProtocol.readStructEnd();
            browserClientInfo.validate();
        }

        public void write(TProtocol tProtocol, BrowserClientInfo browserClientInfo) throws TException {
            browserClientInfo.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (browserClientInfo.hostIP != null) {
                tProtocol.writeFieldBegin(HOST_IP_FIELD_DESC);
                tProtocol.writeString(browserClientInfo.hostIP);
                tProtocol.writeFieldEnd();
            }
            if (browserClientInfo.clientIP != null) {
                tProtocol.writeFieldBegin(CLIENT_IP_FIELD_DESC);
                tProtocol.writeString(browserClientInfo.clientIP);
                tProtocol.writeFieldEnd();
            }
            if (browserClientInfo.serverIP != null) {
                tProtocol.writeFieldBegin(SERVER_IP_FIELD_DESC);
                tProtocol.writeString(browserClientInfo.serverIP);
                tProtocol.writeFieldEnd();
            }
            if (browserClientInfo.userAgent != null) {
                tProtocol.writeFieldBegin(USER_AGENT_FIELD_DESC);
                tProtocol.writeString(browserClientInfo.userAgent);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(SECURE_CONNECTION_FIELD_DESC);
            tProtocol.writeBool(browserClientInfo.secureConnection);
            tProtocol.writeFieldEnd();
            if (browserClientInfo.browserType != null) {
                tProtocol.writeFieldBegin(BROWSER_TYPE_FIELD_DESC);
                tProtocol.writeI32(browserClientInfo.browserType.getValue());
                tProtocol.writeFieldEnd();
            }
            if (browserClientInfo.clientSystemVersion != null) {
                tProtocol.writeFieldBegin(CLIENT_SYSTEM_VERSION_FIELD_DESC);
                tProtocol.writeString(browserClientInfo.clientSystemVersion);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(CLIENT_DEVICE_FIELD_DESC);
            tProtocol.writeI16(browserClientInfo.clientDevice);
            tProtocol.writeFieldEnd();
            if (browserClientInfo.browserCountry != null) {
                tProtocol.writeFieldBegin(BROWSER_COUNTRY_FIELD_DESC);
                tProtocol.writeString(browserClientInfo.browserCountry);
                tProtocol.writeFieldEnd();
            }
            if (browserClientInfo.browserLanguage != null) {
                tProtocol.writeFieldBegin(BROWSER_LANGUAGE_FIELD_DESC);
                tProtocol.writeString(browserClientInfo.browserLanguage);
                tProtocol.writeFieldEnd();
            }
            if (browserClientInfo.highContrastColor != null) {
                tProtocol.writeFieldBegin(HIGH_CONTRAST_COLOR_FIELD_DESC);
                tProtocol.writeString(browserClientInfo.highContrastColor);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(HIGH_CONTRAST_STATE_FIELD_DESC);
            tProtocol.writeBool(browserClientInfo.highContrastState);
            tProtocol.writeFieldEnd();
            if (browserClientInfo.persistentID != null) {
                tProtocol.writeFieldBegin(PERSISTENT_ID_FIELD_DESC);
                tProtocol.writeString(browserClientInfo.persistentID);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(SCREEN_DEPTH_FIELD_DESC);
            tProtocol.writeI32(browserClientInfo.screenDepth);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(SCREEN_HEIGHT_FIELD_DESC);
            tProtocol.writeI32(browserClientInfo.screenHeight);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(SCREEN_WIDTH_FIELD_DESC);
            tProtocol.writeI32(browserClientInfo.screenWidth);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(MENUBAR_HEIGHT_FIELD_DESC);
            tProtocol.writeI32(browserClientInfo.menubarHeight);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(FOOTER_CONTAINER_HEIGHT_FIELD_DESC);
            tProtocol.writeI32(browserClientInfo.footerContainerHeight);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(STATUS_AREA_HEIGHT_FIELD_DESC);
            tProtocol.writeI32(browserClientInfo.statusAreaHeight);
            tProtocol.writeFieldEnd();
            if (browserClientInfo.browserDimensions != null) {
                tProtocol.writeFieldBegin(BROWSER_DIMENSIONS_FIELD_DESC);
                browserClientInfo.browserDimensions.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(RETINA_DISPLAY_FIELD_DESC);
            tProtocol.writeBool(browserClientInfo.retinaDisplay);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

