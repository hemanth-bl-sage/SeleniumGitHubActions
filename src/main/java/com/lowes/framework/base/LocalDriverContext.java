package com.lowes.framework.base;

import com.lowes.framework.config.Settings;
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
    private static ThreadLocal<RemoteWebDriver> remoteWebDriverThreadLocal = new ThreadLocal<>();

//    public static WebDriver getWebDriver() {
//        return webDriverThreadLocal.get();
//    }

    public static <T extends RemoteWebDriver & WebDriver> T getWebDriver() {
        if (Settings.Execution.equalsIgnoreCase("local")){
            return (T) webDriverThreadLocal.get();
        }else {
            return (T) remoteWebDriverThreadLocal.get();
        }
    }

    static void setWebDriverThreadLocal(WebDriver driverThreadLocal) {
        webDriverThreadLocal.set(driverThreadLocal);
    }

//    public static RemoteWebDriver getWebDriver() {
//        return webDriverThreadLocal.get();
//    }

    static void setWebDriverThreadLocal(RemoteWebDriver driverThreadLocal) {
        remoteWebDriverThreadLocal.set(driverThreadLocal);
    }

}