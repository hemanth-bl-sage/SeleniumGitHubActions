package com.lowes.framework.base;

import com.lowes.framework.config.Settings;
import com.lowes.framework.controls.api.ControlFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/** Created by Hemanth BL **/
public class Base {

    public static BasePage CurrentPage;

    public <TPage extends BasePage> TPage GetInstance(Class<TPage> page) {
        //Object obj = PageFactory.initElements(DriverContext.Driver, page);
        //Custom control page factory initialization
        Object obj = null;
        if (Settings.Execution.equalsIgnoreCase("local")) {
            obj = ControlFactory.initElements((WebDriver) LocalDriverContext.getWebDriver(), page);
        }else{
            obj = ControlFactory.initElements((RemoteWebDriver) LocalDriverContext.getWebDriver(),page);
        }

        return page.cast(obj);
    }

}