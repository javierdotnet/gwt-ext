/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.menu;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.DatePicker;
import com.gwtext.client.widgets.menu.event.DateMenuListener;

/**
 * A menu containing a {@link DateItem} component (which provides a date picker).
 */
public class DateMenu extends Menu {

    /**
     * Create a new DateMenu.
     */
    public DateMenu() {
    }

    protected native JavaScriptObject create(JavaScriptObject menuConfig)/*-{
        return new $wnd.Ext.menu.DateMenu(menuConfig);
    }-*/;

    /**
     * The {@link DatePicker} instance for this DateMenu.
     *
     * @return the DatePicker instance for this DateMenu
     */
    public DatePicker getPicker() {
        return new DatePicker(getDatePicker(getOrCreateJsObj()));
    }

    private native JavaScriptObject getDatePicker(JavaScriptObject dateMenu) /*-{
        return dateMenu.picker;    
    }-*/;

    /**
     * Add a DateMenu listener.
     *
     * @param listener the listener
     */
    public native void addListener(DateMenuListener listener)/*-{
        var menu = this.@com.gwtext.client.widgets.menu.Menu::getOrCreateJsObj()();
        var menuJ = this;

        menu.addListener('select',
                function(dm, date) {
                    var dateJS = @com.gwtext.client.util.DateUtil::create(J)(date.getTime());
                    return listener.@com.gwtext.client.widgets.menu.event.DateMenuListener::onSelect(Lcom/gwtext/client/widgets/menu/DateMenu;Ljava/util/Date;)(menuJ, dateJS);
                }
        );

    }-*/;

    // --- config properties --
    private DateMenuListener dateMenuListener;

    /**
     * Return the DateMenu listener.
     *
     * @return the listener
     */
    public DateMenuListener getDateMenuListener() {
        return dateMenuListener;
    }

    /**
     * Set the DateMenu listener.
     *
     * @param dateMenuListener the listener
     */
    public void setDateMenuListener(DateMenuListener dateMenuListener) {
        this.dateMenuListener = dateMenuListener;
    }
}