/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package com.gwtext.client.widgets.menu;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.DatePicker;
import com.gwtext.client.widgets.menu.event.DateMenuListener;

public class DateMenu extends Menu {

    public DateMenu(String id, DateMenuConfig menuConfig) {
        super(id, menuConfig);
        if (menuConfig.getDateMenuListener() != null) {
            addDateMenuListener(menuConfig.getDateMenuListener());
        }
    }

    protected native JavaScriptObject create(JavaScriptObject menuConfig)/*-{
        return new $wnd.Ext.menu.DateMenu(menuConfig);
    }-*/;

    public DatePicker getPicker() {
        return new DatePicker(getDatePicker(jsObj));
    }

    private native JavaScriptObject getDatePicker(JavaScriptObject dateMenu) /*-{
        return dateMenu.picker;    
    }-*/;

    public native void addDateMenuListener(DateMenuListener listener)/*-{

        var dateMenu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var dateMenuJ = this;

        dateMenu.addListener('select',
                function(dm, date) {
                    var dateJS = @com.gwtext.client.util.DateUtil::create(J)(date.getTime());
                    return listener.@com.gwtext.client.widgets.menu.event.DateMenuListener::onSelect(Lcom/gwtext/client/widgets/menu/DateMenu;Ljava/util/Date;)(dateMenuJ, dateJS);
                }
        );
    }-*/;
}