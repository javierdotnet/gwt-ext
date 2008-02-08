/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.util.event;

import com.gwtext.client.util.ClickRepeater;

/**
 * Interface for {@link com.gwtext.client.util.ClickRepeater}.
 */
public interface ClickRepeaterListener {

    /**
     * Fires on a specified interval during the time the element is pressed.
     *
     * @param self this
     */
    void onClick(ClickRepeater self);

    /**
     * Fires when the mouse button is depressed.
     *
     * @param self this
     */
    void onMouseDown(ClickRepeater self);

    /**
     * Fires when the mouse key is released.
     *
     * @param self this
     */
    void onMouseUp(ClickRepeater self);

}
