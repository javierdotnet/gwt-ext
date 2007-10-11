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

package com.gwtext.client.widgets.grid.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.grid.Grid;

public interface GridListener {

    /**
     * Fires when the body element is scrolled.
     *
     * @param scrollLeft scroll left value
     * @param scrollTop scroll top value
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

    /**
     * Fires when the grid is rendered
     * 
     * @param grid this
     */
    void onRender(Grid grid);
}
