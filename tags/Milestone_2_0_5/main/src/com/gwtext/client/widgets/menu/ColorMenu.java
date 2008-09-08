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
import com.gwtext.client.widgets.ColorPalette;
import com.gwtext.client.widgets.menu.event.ColorMenuListener;

/**
 * A menu containing a {@link ColorItem} component (which provides a basic color picker).
 *
 * @author Sanjiv Jivan
 */
public class ColorMenu extends Menu {

    /**
     * Create a new ColorMenu.
     *
     */
    public ColorMenu() {
    }

    protected native JavaScriptObject create(JavaScriptObject menuConfig)/*-{
        return new $wnd.Ext.menu.ColorMenu(menuConfig);
    }-*/;

    /**
     * The ColorPalette instance for this ColorMenu.
     *
     * @return the ColorPalette instance
     */
    public ColorPalette getColorPalette() {
        return new ColorPalette(getColorPalette(getOrCreateJsObj()));
    }

    private native JavaScriptObject getColorPalette(JavaScriptObject colorMenu) /*-{
        return colorMenu.palette;    
    }-*/;

    /**
     * Add a ColorPalette listener.
     *
     * @param listener the listener
     */
    public native void addListener(ColorMenuListener listener)/*-{
        var menu = this.@com.gwtext.client.widgets.menu.Menu::getOrCreateJsObj()();
        var menuJ = this;

        menu.addListener('select',
                function(palette, color) {
                    var palleteJ = @com.gwtext.client.widgets.ColorPalette::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(palette);
                    return listener.@com.gwtext.client.widgets.menu.event.ColorMenuListener::onSelect(Lcom/gwtext/client/widgets/ColorPalette;Ljava/lang/String;)(palleteJ, color);
                }
        );
     }-*/;

}
