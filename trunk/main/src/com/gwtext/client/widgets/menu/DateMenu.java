/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 

package com.gwtext.client.widgets.menu;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.DatePicker;
import com.gwtext.client.widgets.menu.event.DateMenuListener;

/**
 * A menu containing a {@link DateItem} component (which provides a date picker).
 *
 * @author Sanjiv Jivan
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
                    var dateJS = @com.gwtext.client.util.DateUtil::create(D)(date.getTime());
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