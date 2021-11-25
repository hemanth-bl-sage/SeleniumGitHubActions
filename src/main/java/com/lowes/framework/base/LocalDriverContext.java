package com.lowes.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LocalDriverContext {
    //ToDo: Bring condition to check execution is from local or from remote machine
//    private static ThreadLocal<RemoteWebDriver> remoteWebDriverThreadLocal = new ThreadLocal<>();
//
//    public static RemoteWebDriver getRemoteWebDriver() {
//        return remoteWebDriverThreadLocal.get();
//    }
//
//    static void setRemoteWebDriverThreadLocal(RemoteWebDriver driverThreadLocal) {
//        remoteWebDriverThreadLocal.set(driverThreadLocal);
//    }

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public static WebDriver getWebDriver() {
        return webDriverThreadLocal.get();
    }

    static void setWebDriverThreadLocal(WebDriver driverThreadLocal) {
        webDriverThreadLocal.set(driverThreadLocal);
    }

//    public static RemoteWebDriver getWebDriver() {
//        return webDriverThreadLocal.get();
//    }
//
//    static void setWebDriverThreadLocal(RemoteWebDriver driverThreadLocal) {
//        webDriverThreadLocal.set(driverThreadLocal);
//    }

}