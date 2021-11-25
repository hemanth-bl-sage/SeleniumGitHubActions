package com.lowes.framework.controls.elements;

import com.lowes.framework.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

/**
 * Created by Hemanth BL
 **/
public class TextBoxBase extends ControlBase implements TextBox {

    public TextBoxBase(WebElement element) {
        super(element);
    }

    @Override
    public void EnterText(String text) {

        getWrappedElement().sendKeys(text);

    }

    @Override
    public String GetTextValue() {
        return getWrappedElement().getText();
    }
}
