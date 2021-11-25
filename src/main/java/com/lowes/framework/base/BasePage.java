package com.lowes.framework.base;

/** Created by Hemanth BL **/
public abstract class BasePage extends Base {

    public <TPage extends BasePage> TPage As(Class<TPage> pageInstance) {
        try {
            return (TPage) this;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

}