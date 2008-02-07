/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.event;

import com.gwtext.client.widgets.ColorPalette;

public interface ColorPaletteListener extends ComponentListener {

    /**
     * Fires when a color is selected.
     *
     * @param colorPalette this
     * @param color        The 6-digit color hex code (without the # symbol)
     */
    void onSelect(ColorPalette colorPalette, String color);
}
