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

import com.google.gwt.user.client.Event;
import com.gwtext.client.widgets.grid.Grid;
import com.gwtext.client.widgets.grid.GridDD;

public interface GridDragListener {

    //add raw broswer event

    //raw event?

    /**
     * Fires when row(s) start being dragged.
     *
     * @param grid this
     * @param dd The drag drop object
     * @param e the browser event
     */
    void onStartDrag(Grid grid, GridDD dd, Event e);

    /**
     * Fires when dragged row(s) are dropped on a valid DD target.
     * 
     * @param grid this
     * @param dd the drag drop object
     * @param targetId The target drag drop object
     * @param e the browser event
     */
    void onDragDrop(Grid grid, GridDD dd, String targetId, Event e);

    /**
     * Fires when the dragged row(s) first cross another DD target while being dragged.
     *
     * @param grid this
     * @param dd the drag drop object
     * @param targetId The target drag drop object
     * @param e the browser event
     */
    void onDragEnter(Grid grid, GridDD dd, String targetId, Event e);

    /**
     * Fires when the dragged row(s) leave another DD target while being dragged.
     *
     * @param grid this
     * @param dd the drag drop object
     * @param targetId The target drag drop object
     * @param e the browser event
     */
    void onDragOut(Grid grid, GridDD dd, String targetId, Event e);

    /**
     * Fires while row(s) are being dragged. "targetId" is the id of the target object the selected rows are being
     * dragged over.
     *
     * @param grid this
     * @param dd the drag drop object
     * @param targetId The target drag drop object
     * @param e the browser event
     */
    void onDragOver(Grid grid, GridDD dd, String targetId, Event e);

}
