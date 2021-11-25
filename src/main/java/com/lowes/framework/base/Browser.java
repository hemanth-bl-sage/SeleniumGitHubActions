package com.lowes.framework.base;

import org.openqa.selenium.WebDriver;

/** Created by Hemanth BL **/
public class Browser extends Base {

    private WebDriver _driver;

    public Browser(WebDriver driver) {
        _driver = driver;
    }

    public BrowserType Type;

}



