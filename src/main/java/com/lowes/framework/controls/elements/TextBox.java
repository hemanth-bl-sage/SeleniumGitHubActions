package com.lowes.framework.controls.elements;

import com.lowes.framework.controls.api.ImplementedBy;
import com.lowes.framework.controls.internals.Control;

/**
 * Created by Hemanth BL.
 */

@ImplementedBy(TextBoxBase.class)
public interface TextBox extends Control {

    void EnterText(String text);

    String GetTextValue();

}
