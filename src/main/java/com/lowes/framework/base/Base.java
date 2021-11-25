package com.lowes.framework.base;

import com.lowes.framework.controls.api.ControlFactory;

/** Created by Hemanth BL **/
public class Base {

    public static BasePage CurrentPage;

    public <TPage extends BasePage> TPage GetInstance(Class<TPage> page) {
        //Object obj = PageFactory.initElements(DriverContext.Driver, page);
        //Custom control page factory initialization
//        Object obj = ControlFactory.initElements(LocalDriverContext.getRemoteWebDriver(), page);
        Object obj = ControlFactory.initElements(LocalDriverContext.getWebDriver(),page);
        return page.cast(obj);
    }

}