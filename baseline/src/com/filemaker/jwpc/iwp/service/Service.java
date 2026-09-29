/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.thrift.TException
 *  org.apache.thrift.transport.TTransportException
 */
package com.filemaker.jwpc.iwp.service;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.service.ServiceClient;
import com.filemaker.jwpc.iwp.service.ServiceClientPoolLiaison;
import com.filemaker.jwpc.iwp.service.ServiceConfig;
import com.filemaker.jwpc.iwp.session.Session;
import com.filemaker.jwpc.iwp.thrift.common.BrowserClientInfo;
import com.filemaker.jwpc.iwp.thrift.common.ContextResult;
import com.filemaker.jwpc.iwp.thrift.common.Credentials;
import com.filemaker.jwpc.iwp.thrift.common.DatabasesDataResult;
import com.filemaker.jwpc.iwp.thrift.common.Result;
import com.filemaker.jwpc.iwp.thrift.common.ScriptInfo;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;

public final class Service {
    private final ServiceConfig config;
    private static String masterAddr = "";
    private static int masterHttpPort = -1;
    private static int masterHttpsPort = -1;
    private static Service sINSTANCE = new Service(ServiceConfig.getConfig());

    private Service(ServiceConfig serviceConfig) {
        this.config = serviceConfig;
    }

    public static Service getInstance() {
        return sINSTANCE;
    }

    public void onJwpcStart() throws AppRuntimeException {
        ServiceClient serviceClient = ServiceClientPoolLiaison.getClient(5500);
        try {
            serviceClient.getClient().onJwpcStart();
        }
        catch (TTransportException tTransportException) {
            serviceClient.setReset();
        }
        catch (TException tException) {
            serviceClient.setReset();
        }
        finally {
            ServiceClientPoolLiaison.putClient(serviceClient);
        }
    }

    public static String getMasterAddr() throws AppRuntimeException {
        if (masterAddr.isEmpty()) {
            ServiceClient serviceClient = ServiceClientPoolLiaison.getClient(5501);
            try {
                masterAddr = serviceClient.getClient().getMasterAddr();
            }
            catch (TTransportException tTransportException) {
                serviceClient.setReset();
                masterAddr = "";
            }
            catch (TException tException) {
                serviceClient.setReset();
                masterAddr = "";
            }
            finally {
                ServiceClientPoolLiaison.putClient(serviceClient);
            }
        }
        return masterAddr;
    }

    public static int getMasterHttpPort() throws AppRuntimeException {
        if (masterHttpPort == -1) {
            ServiceClient serviceClient = ServiceClientPoolLiaison.getClient(5504);
            try {
                masterHttpPort = serviceClient.getClient().getMasterHttpPort();
            }
            catch (TTransportException tTransportException) {
                serviceClient.setReset();
                masterHttpPort = -1;
            }
            catch (TException tException) {
                serviceClient.setReset();
                masterHttpPort = -1;
            }
            finally {
                ServiceClientPoolLiaison.putClient(serviceClient);
            }
        }
        return masterHttpPort;
    }

    public static int getMasterHttpsPort() throws AppRuntimeException {
        if (masterHttpsPort == -1) {
            ServiceClient serviceClient = ServiceClientPoolLiaison.getClient(5503);
            try {
                masterHttpsPort = serviceClient.getClient().getMasterHttpsPort();
            }
            catch (TTransportException tTransportException) {
                serviceClient.setReset();
                masterHttpsPort = -1;
            }
            catch (TException tException) {
                serviceClient.setReset();
                masterHttpsPort = -1;
            }
            finally {
                ServiceClientPoolLiaison.putClient(serviceClient);
            }
        }
        return masterHttpsPort;
    }

    public DatabasesDataResult getDatabasesData(App app) throws AppRuntimeException {
        return this.getDatabasesData(null, app);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DatabasesDataResult getDatabasesData(Credentials credentials, App app) throws AppRuntimeException {
        ServiceClient serviceClient = ServiceClientPoolLiaison.getClient(5505);
        try {
            DatabasesDataResult databasesDataResult = serviceClient.getClient().getDatabasesData(credentials);
            return databasesDataResult;
        }
        catch (TTransportException tTransportException) {
            serviceClient.setReset();
            app.showCommunicationError();
            DatabasesDataResult databasesDataResult = null;
            return databasesDataResult;
        }
        catch (TException tException) {
            serviceClient.setReset();
            app.showCommunicationError();
            DatabasesDataResult databasesDataResult = null;
            return databasesDataResult;
        }
        finally {
            ServiceClientPoolLiaison.putClient(serviceClient);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DatabasesDataResult getDatabasesData(Credentials credentials) throws AppRuntimeException {
        ServiceClient serviceClient = ServiceClientPoolLiaison.getClient(5506);
        try {
            DatabasesDataResult databasesDataResult = serviceClient.getClient().getDatabasesData(credentials);
            return databasesDataResult;
        }
        catch (TTransportException tTransportException) {
            serviceClient.setReset();
            DatabasesDataResult databasesDataResult = null;
            return databasesDataResult;
        }
        catch (TException tException) {
            serviceClient.setReset();
            DatabasesDataResult databasesDataResult = null;
            return databasesDataResult;
        }
        finally {
            ServiceClientPoolLiaison.putClient(serviceClient);
        }
    }

    public Session getSession(App app) {
        return new Session(app, this.config);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String ping(String string) {
        ServiceClient serviceClient = ServiceClientPoolLiaison.getClient(5507);
        try {
            String string2 = serviceClient.getClient().ping(string);
            return string2;
        }
        catch (TException tException) {
            serviceClient.setReset();
            String string3 = tException.getMessage();
            return string3;
        }
        finally {
            ServiceClientPoolLiaison.putClient(serviceClient);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deletePDFFiles(int n) throws AppRuntimeException {
        ServiceClient serviceClient = ServiceClientPoolLiaison.getClient(5508);
        try {
            serviceClient.getClient().deletePDFFiles(n);
        }
        catch (TTransportException tTransportException) {
            serviceClient.setReset();
        }
        catch (TException tException) {
            serviceClient.setReset();
        }
        finally {
            ServiceClientPoolLiaison.putClient(serviceClient);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ContextResult openDatabase(int n, Credentials credentials, boolean bl, BrowserClientInfo browserClientInfo, ScriptInfo scriptInfo, boolean bl2, boolean bl3) {
        ContextResult contextResult = null;
        ServiceClient serviceClient = ServiceClientPoolLiaison.getClient(5509);
        try {
            contextResult = serviceClient.getClient().openDatabase(n, credentials, bl, browserClientInfo, scriptInfo, bl2, bl3);
        }
        catch (TTransportException tTransportException) {
            serviceClient.setReset();
        }
        catch (TException tException) {
            serviceClient.setReset();
        }
        finally {
            ServiceClientPoolLiaison.putClient(serviceClient);
        }
        return contextResult;
    }

    public static boolean getHostAllowGuestSignIn() throws AppRuntimeException {
        ServiceClient serviceClient = ServiceClientPoolLiaison.getClient(5510);
        try {
            boolean bl = serviceClient.getClient().getHostAllowGuestSignIn();
            return bl;
        }
        catch (TTransportException tTransportException) {
            serviceClient.setReset();
            boolean bl = true;
            return bl;
        }
        catch (TException tException) {
            serviceClient.setReset();
            boolean bl = true;
            return bl;
        }
        finally {
            ServiceClientPoolLiaison.putClient(serviceClient);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean getSavePasswordToKeychain(int n, String string) throws AppRuntimeException {
        ServiceClient serviceClient = ServiceClientPoolLiaison.getClient(5511);
        try {
            boolean bl = serviceClient.getClient().getSavePasswordToKeychain(n, string);
            return bl;
        }
        catch (TTransportException tTransportException) {
            serviceClient.setReset();
            boolean bl = false;
            return bl;
        }
        catch (TException tException) {
            serviceClient.setReset();
            boolean bl = false;
            return bl;
        }
        finally {
            ServiceClientPoolLiaison.putClient(serviceClient);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String retrieveCSS(String string) throws AppRuntimeException {
        ServiceClient serviceClient = ServiceClientPoolLiaison.getClient(5507);
        try {
            String string2 = serviceClient.getClient().retrieveCSS(string);
            return string2;
        }
        catch (TException tException) {
            serviceClient.setReset();
            String string3 = tException.getMessage();
            return string3;
        }
        finally {
            ServiceClientPoolLiaison.putClient(serviceClient);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Result sendAppleIDPasscodeEmail(int n, String string, String string2) throws AppRuntimeException {
        Result result = null;
        ServiceClient serviceClient = ServiceClientPoolLiaison.getClient(5507);
        try {
            result = serviceClient.getClient().sendAppleIDPasscodeEmail(n, string, string2);
        }
        catch (TException tException) {
            serviceClient.setReset();
        }
        finally {
            ServiceClientPoolLiaison.putClient(serviceClient);
        }
        return result;
    }
}

