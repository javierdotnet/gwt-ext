package com.gwtext.client.widgets.menu;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Adds a separator bar to a menu, used to divide logical groups of menu items.
 */
public class Separator extends BaseItem {
	
    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
        var c = new $wnd.Ext.menu.Separator();
        @com.gwtext.client.widgets.menu.Separator::configPrototype = c.initialConfig;
    }-*/;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}
	
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.menu.Separator();
    }-*/;

    /**
     * The default CSS class to use for separator items (defaults to "x-menu-sep).
     *
     * @param itemCls the item CSS class
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setItemCls(String itemCls) throws IllegalStateException {
        setAttribute("itemCls", itemCls, true);
    }

    /**
     * The default CSS class to use for separator items (defaults to "x-menu-sep").
     *
     * @return the default CSS class to use for text items
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public String getItemCls() throws IllegalStateException {
        return JavaScriptObjectHelper.getAttribute(config, "itemCls");
    }	
}
