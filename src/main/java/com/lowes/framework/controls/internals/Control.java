package com.lowes.framework.controls.internals;

import com.lowes.framework.controls.api.ImplementedBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;

/**
 * Created by Hemanth BL.
 **/

@ImplementedBy(ControlBase.class)
public interface Control extends WebElement, WrapsElement, Locatable {
}
