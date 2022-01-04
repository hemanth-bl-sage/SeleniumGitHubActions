package com.lowes.framework.base;

import com.lowes.framework.config.Settings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

/** Created by Hemanth BL **/
public class FrameworkInitialize extends Base {

    public static RemoteWebDriver driver = null;

    public static void InitializeBrowser(BrowserType browserType) throws MalformedURLException {

        switch (browserType) {

            case Chrome: {
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--ignore-ssl-errors=yes");
                if (Settings.Execution.equalsIgnoreCase("local")){
                    driver = new ChromeDriver(options);
                }else{
                    driver = new RemoteWebDriver(new URL(Settings.SeleniumGridHub),options);
                }
                LocalDriverContext.setWebDriverThreadLocal(driver);
                break;
            }

            case Firefox: {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--ignore-ssl-errors=yes");
                if (Settings.Execution.equalsIgnoreCase("local")){
                    driver = new FirefoxDriver(options);
                }else{
                    driver = new RemoteWebDriver(new URL(Settings.SeleniumGridHub),options);
                }
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