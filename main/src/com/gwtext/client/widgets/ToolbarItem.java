/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

/**
 * The base class that other classes should extend in order to get some basic common toolbar item functionality.
 */
public class ToolbarItem extends BaseExtWidget {

    protected ToolbarItem() {
    }

    /**
     * Creates a new Item.
     *
     * @param element the html element
     */
    public ToolbarItem(Element element) {
        setJsObj(create(element));
    }

    private native JavaScriptObject create(Element element) /*-{
        return new $wnd.Ext.Toolbar.Item(element);
    }-*/;

    public ToolbarItem(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Removes and destroys this item.
     */
    public native void destroy()/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.destroy();
    }-*/;

    /**
     * Disables this item.
     */
    public native void disable()/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.disable();
    }-*/;

    /**
     * Enables this item.
     */
    public native void enable()/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.enable();
    }-*/;

    /**
     * Try to focus this item.
     */
    public native void focus()/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.focus();
    }-*/;

    /**
     * Hides this item.
     */
    public native void hide()/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.hide();
    }-*/;

    /**
     * Shows this item.
     */
    public native void show()/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.show();
    }-*/;

    /**
     * Convenience function for boolean show/hide.
     *
     * @param visible true to show
     */
    public native void setVisible(boolean visible)/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.setVisible(visible);
    }-*/;
}
