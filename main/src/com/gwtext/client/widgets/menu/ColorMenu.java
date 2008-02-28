/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.menu;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.ColorPalette;
import com.gwtext.client.widgets.menu.event.ColorMenuListener;

/**
 * A menu containing a {@link ColorItem} component (which provides a basic color picker).
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
