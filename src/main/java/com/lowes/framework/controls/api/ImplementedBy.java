package com.lowes.framework.controls.api;

import com.lowes.framework.controls.internals.ControlBase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Hemanth BL.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ImplementedBy {

    Class<?> value() default ControlBase.class;

}
