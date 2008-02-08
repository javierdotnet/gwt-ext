/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.event;

import com.gwtext.client.widgets.BoxComponent;

public interface BoxComponentListener extends ComponentListener {

    /**
     * Fires after the component is moved.
     *
     * @param component this
     * @param x         the new x position
     * @param y         the new y position
     */
    void onMove(BoxComponent component, int x, int y);

    /**
     * Fires after the component is resized. Note that percentage based widths and auto widths are passed as -1.
     *
     * @param component this
     * @param adjWidth  the box-adjusted width that was set
     * @param adjHeight the box-adjusted height that was set
     * @param rawWidth  the width that was originally specified
     * @param rawHeight the height that was originally specified
     */
    void onResize(BoxComponent component, int adjWidth, int adjHeight, int rawWidth, int rawHeight);
}
