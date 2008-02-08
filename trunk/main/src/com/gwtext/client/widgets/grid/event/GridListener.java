/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.grid.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.grid.GridPanel;

public interface GridListener {

    /**
     * Fires when the body element is scrolled.
     *
     * @param scrollLeft scroll left value
     * @param scrollTop  scroll top value
     */
    void onBodyScroll(int scrollLeft, int scrollTop);

    /**
     * The raw click event for the entire grid.
     *
     * @param e the event object
     */
    void onClick(EventObject e);

    /**
     * The raw contextmenu event for the entire grid.
     *
     * @param e the event object
     */
    void onContextMenu(EventObject e);

    /**
     * The raw dblclick event for the entire grid.
     *
     * @param e the event object
     */
    void onDblClick(EventObject e);

    /**
     * The raw keydown event for the entire grid..
     *
     * @param e the event object
     */
    void onKeyDown(EventObject e);

    /**
     * The raw keypress event for the entire grid.
     *
     * @param e the event object
     */
    void onKeyPress(EventObject e);

}
