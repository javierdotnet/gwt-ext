/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.menu.event;

import com.gwtext.client.widgets.ColorPalette;

public interface ColorMenuListener {

    /**
     * Fired when the color menu is selected.
     *
     * @param colorPalette the color palette
     * @param color        the selected color
     */
    void onSelect(ColorPalette colorPalette, String color);
}
