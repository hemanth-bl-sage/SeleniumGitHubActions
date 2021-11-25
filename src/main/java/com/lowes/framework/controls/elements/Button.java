package com.lowes.framework.controls.elements;

import com.lowes.framework.controls.api.ImplementedBy;
import com.lowes.framework.controls.internals.Control;

/**
 * Created by Hemanth BL.
 **/

@ImplementedBy(ButtonBase.class)
public interface Button extends Control {

    void PerformClick();

    String GetButtonText();

    void PerformSubmit();
}
