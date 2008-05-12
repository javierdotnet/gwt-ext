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
 

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.event.ColorPaletteListener;

/**
 * Simple color palette class for choosing colors.
 *
 * @author Sanjiv Jivan 
 */
public class ColorPalette extends Component {

    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
        var c = new $wnd.Ext.ColorPalette();
        @com.gwtext.client.widgets.ColorPalette::configPrototype = c.initialConfig;
    }-*/;

	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
        return "colorpalette";
    }

    /**
     * Create a new CollorPalette.
     */
    public ColorPalette() {
    }

    public ColorPalette(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config)/*-{
        return new $wnd.Ext.ColorPalette(config);
    }-*/;

    private static ColorPalette instance(JavaScriptObject jsObj) {
        return new ColorPalette(jsObj);
    }
    
    /**
     * Selects the specified color in the palette (fires the select event).
     *
     * @param color A valid 6-digit color hex code (# will be stripped if included)
     */
    public void select(String color) {
        if(isRendered()) {
            selectRendered(color);
        } else {
            setValue(color);
        }
    }

    private native void selectRendered(String color) /*-{
        var cp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        cp.select(color);
    }-*/;

    /**
     * Add a ColorPalette listener.
     *
     * @param listener the listener
     */
    public native void addListener(ColorPaletteListener listener) /*-{
        this.@com.gwtext.client.widgets.Component::addListener(Lcom/gwtext/client/widgets/event/ComponentListener;)(listener);
        var componentJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('select',
                function(cp, color) {
                    listener.@com.gwtext.client.widgets.event.ColorPaletteListener::onSelect(Lcom/gwtext/client/widgets/ColorPalette;Ljava/lang/String;)(componentJ, color);
                }
        );
    }-*/;


    // --- config properties ---

    /**
     * Return true if reselecting is allowed.
     *
     * @return true if reselecting is allowed
     */
    public boolean isAllowReselect() {
        return getAttributeAsBoolean("allowReselect");
    }

    /**
     * If set to true then reselecting a color that is already selected fires the selection event.
     *
     * @param allowReselect true to allow reselect
     */
    public void setAllowReselect(boolean allowReselect) {
        setAttribute("allowReselect", allowReselect, true);
    }

    /**
     * @return the CSS of the containing element
     */
    public String getItemCls() {
        return getAttribute("itemCls");
    }

    /**
     * The CSS class to apply to the containing element (defaults to "x-color-palette").
     *
     * @param itemCls the item CSS class
     */
    public void setItemCls(String itemCls) {
		if(!isRendered()) {
			setAttribute("itemCls", itemCls, true);
		} else {
			DOM.setElementAttribute(getElement(), "className", itemCls);
			setAttribute("itemCls", itemCls, true, true);
		}
    }

    /**
     * The highlighted color.
     * 
     * @return the color value
     */
    public String getValue() {
        return getAttribute("value");
    }

    /**
     * The color to highlight (should be a valid 6-digit color hex code without the # symbol).
     * Note that the hex codes are case-sensitive.
     *
     * @param value the initial color
     */
    public void setValue(String value) {
        if(isRendered()) {
            select(value);
			setAttribute("value", value, true, true);
		} else {
			setAttribute("value", value, true);
		}
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
        return JavaScriptObjectHelper.getAttributeAsStringArray(config, "colors");
    }

    /**
     * Set the colors array.
     *
     * @param colors the colors array
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setColors(String[] colors) throws IllegalStateException {
        setAttribute("colors", JavaScriptObjectHelper.convertToJavaScriptArray(colors), true);
    }
}
