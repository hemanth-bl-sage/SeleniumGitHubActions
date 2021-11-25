package com.lowes.framework.controls.elements;

import com.lowes.framework.controls.api.ImplementedBy;
import com.lowes.framework.controls.internals.Control;

/**
 * Created by Hemanth BL
 **/

@ImplementedBy(HyperLinkBase.class)
public interface HyperLink extends Control {


    void ClickLink();

    String GetUrlText();

    boolean CheckUrlTextContains(String containsText);
}
