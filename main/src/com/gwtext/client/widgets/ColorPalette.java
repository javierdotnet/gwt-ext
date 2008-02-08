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

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.event.ColorPaletteListener;

/**
 * Simple color palette class for choosing colors. 
 */
public class ColorPalette extends Component {

    public ColorPalette(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Create a new ColorPalette.
     *
     * @param config the ColorPalette config
     */
    public ColorPalette(ColorPaletteConfig config) {
        jsObj = create(config.getJsObj());
    }

    private native JavaScriptObject create(JavaScriptObject config)/*-{
        var cp = new $wnd.Ext.ColorPalette(config);
        return cp;
    }-*/;

    /**
     * Selects the specified color in the palette (fires the select event).
     *
     * @param color A valid 6-digit color hex code (# will be stripped if included)
     */
    public native void select(String color) /*-{
        var cp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        cp.select(color);
    }-*/;

    private static ColorPalette instance(JavaScriptObject jsObj) {
        return new ColorPalette(jsObj);
    }

    /**
     * An array of 6-digit color hex code strings (without the # symbol). This array can contain any number of colors,
     * and each hex code should be unique. The width of the palette is controlled via CSS by adjusting the width property
     * of the 'x-color-palette' class (or assigning a custom class), so you can balance the number of colors with the width
     * setting until the box is symmetrical.
     * 
     * @return the colors array
     */
    public String[] getColors() {
        return JavaScriptObjectHelper.getAttributeAsStringArray(jsObj, "colors");
    }

    /**
     * Set the colors array.
     *
     * @param colors the colors array
     */
    public void setColors(String[] colors) {
        JavaScriptObjectHelper.setAttribute(jsObj, "colors", JavaScriptObjectHelper.convertToJavaScriptArray(colors));
    }

    /**
     * Add a ColorPalette listener.
     *
     * @param listener the listener
     */
    public native void addColorPaletteListener(ColorPaletteListener listener) /*-{
        var componentJ = this;
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;

        component.addListener('select',
                function(cp, color) {
                    listener.@com.gwtext.client.widgets.event.ColorPaletteListener::onSelect(Lcom/gwtext/client/widgets/ColorPalette;Ljava/lang/String;)(componentJ, color);
                }
        );
    }-*/;
}
