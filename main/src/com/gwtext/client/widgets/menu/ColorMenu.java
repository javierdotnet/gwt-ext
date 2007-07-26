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
import com.gwtext.client.widgets.ColorPalette;
import com.gwtext.client.widgets.menu.event.ColorMenuListener;

public class ColorMenu extends Menu {
    public ColorMenu(String id, ColorMenuConfig menuConfig) {
        super(id, menuConfig);
        if (menuConfig.getColorMenuListener() != null) {
            addColorMenuListener(menuConfig.getColorMenuListener());
        }
    }

    protected native JavaScriptObject create(JavaScriptObject menuConfig)/*-{
        return new $wnd.Ext.menu.ColorMenu(menuConfig);
    }-*/;

    public ColorPalette getColorPalette() {
        return new ColorPalette(getColorPalette(jsObj));
    }

    private native JavaScriptObject getColorPalette(JavaScriptObject colorMenu) /*-{
        return colorMenu.palette;    
    }-*/;


    public native void addColorMenuListener(ColorMenuListener listener)/*-{
        var colorMenu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var colorMenuJ = this;

        colorMenu.addListener('select',
                function(palette, color) {
                    return listener.@com.gwtext.client.widgets.menu.event.ColorMenuListener::onSelect(Lcom/gwtext/client/widgets/menu/ColorMenu;Ljava/lang/String;)(colorMenuJ, color);
                }
        );        
     }-*/;
}
