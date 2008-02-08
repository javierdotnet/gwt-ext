/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.grid.event;

import com.gwtext.client.core.EventObject;

public interface GridMouseListener {

    /**
     * The raw mousedown event for the entire grid.
     *
     * @param e the event object
     */
    void onMouseDown(EventObject e);

    /**
     * The raw mouseout event for the entire grid.
     *
     * @param e the event object
     */
    void onMouseOut(EventObject e);

    /**
     * The raw mouseover event for the entire grid.
     *
     * @param e the event object
     */
    void onMouseOver(EventObject e);

    /**
     * The raw mouseup event for the entire grid.
     *
     * @param e the event object
     */
    void onMouseUp(EventObject e);
}
