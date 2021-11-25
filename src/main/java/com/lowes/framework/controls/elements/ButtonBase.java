package com.lowes.framework.controls.elements;

import com.lowes.framework.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

/**
 * Created by Hemanth BL.
 **/
public class ButtonBase extends ControlBase implements Button {


    public ButtonBase(WebElement element) {
        super(element);
    }

    @Override
    public void PerformClick() {
        getWrappedElement().click();
    }

    @Override
    public String GetButtonText() {
        return getWrappedElement().getText();
    }

    @Override
    public void PerformSubmit() {
        getWrappedElement().submit();
    }
}
