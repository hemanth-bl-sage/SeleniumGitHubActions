package com.lowes.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

/** Created by Hemanth BL **/
public class FrameworkInitialize extends Base {

    public static void InitializeBrowser(BrowserType browserType) {

        WebDriver driver = null;
//        RemoteWebDriver driver = null;
//        String username = "";
//        String accesskey = "";
        switch (browserType) {
            case Chrome: {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\hemanth.l\\Downloads\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--ignore-ssl-errors=yes");
                driver = new ChromeDriver(options);
//                driver = new RemoteWebDriver(new URL(Settings.SeleniumGridHub),options);
                LocalDriverContext.setWebDriverThreadLocal(driver);
//                driver = new RemoteWebDriver(new URL("http://" + username + ":" + accesskey + "@ondemand.saucelabs.com:80/wd/hub"), options);
//                LocalDriverContext.setRemoteWebDriverThreadLocal(driver);
                break;
            }
            case Firefox: {
                //Open the browser
                driver = new FirefoxDriver();
                break;
            }
            case IE: {
                driver = new InternetExplorerDriver();
                break;
            }
            case Safari:{
                driver = new SafariDriver();
                break;
            }
        }
    }

}