package com.lowes.framework.base;

import com.lowes.framework.config.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/** Created by Hemanth BL **/
public class DriverContext {

    public static void GoToUrl(String url) {
        LocalDriverContext.getWebDriver().get(url);
        LocalDriverContext.getWebDriver().manage().window().maximize();
        LocalDriverContext.getWebDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static void WaitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(LocalDriverContext.getWebDriver(), 30);
        JavascriptExecutor jsExecutor = (JavascriptExecutor)LocalDriverContext.getWebDriver();
        ExpectedCondition<Boolean> jsLoad = webDriver -> ((JavascriptExecutor) LocalDriverContext.getWebDriver())   //LocalDriverContext.getRemoteWebDriver()
                .executeScript("return document.readyState").toString().equals("complete");
        //Get JS Ready
        boolean jsReady = jsExecutor.executeScript("return document.readyState").toString().equals("complete");

        if (!jsReady)
            wait.until(jsLoad);
        else
            Settings.Logs.Write("Page is ready !");
    }

    public static void WaitForElementVisible(final WebElement elementFindBy) {
        WebDriverWait wait = new WebDriverWait(LocalDriverContext.getWebDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(elementFindBy));
    }

    public static void WaitForElementTextVisible(final WebElement elementFindBy, String text) {
        WebDriverWait wait = new WebDriverWait(LocalDriverContext.getWebDriver(), 30);
        wait.until(ExpectedConditions.textToBePresentInElement(elementFindBy, text));
    }

    public static void WaitUntilTextDisplayed(final By element, String text) {
        WebDriverWait wait = new WebDriverWait(LocalDriverContext.getWebDriver(), 30);
        wait.until(textDisplayed(element, text));
    }

    private static ExpectedCondition<Boolean> textDisplayed(final By elementFindBy, final String text) {
        return webDriver -> webDriver.findElement(elementFindBy).getText().contains(text);
    }

    public static void WaitElementEnabled(final By elementFindBy) {
        WebDriverWait wait = new WebDriverWait(LocalDriverContext.getWebDriver(), 30);
        wait.until(webDriver -> webDriver.findElement(elementFindBy).isEnabled());
    }

}