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
package com.gwtext.client.widgets.event;

import com.google.gwt.user.client.Element;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.View;

public interface ViewListener {

    /**
     * Fires before a click is processed. Returns false to cancel the default action.
     *
     * @param view  the view
     * @param index the index of the target node
     * @param node the target node
     * @param e the event object
     * @return false to cancel the default action
     */
    boolean doBeforeClick(View view, int index, Element node, EventObject e);

    /**
     * Fires before a selection is made. If any handlers return false, the selection is cancelled.
     *
     * @param view the view
     * @param node the node to be selected
     * @param selections Array of currently selected nodes
     * @return false to cancel the selection
     */
    boolean doBeforeSelect(View view, Element node, Element[] selections);

    /**
     * Fires when a template node is clicked.
     *
     * @param view the view
     * @param index the index of the target node
     * @param node the target node
     * @param e the raw event object
     */
    void onClick(View view, int index, Element node, EventObject e);

    /**
     * Fires when a template node is right clicked.
     *
     * @param view the view
     * @param index the index of the target node
     * @param node the target node
     * @param e the raw event object
     */
    void onContextMenu(View view, int index, Element node, EventObject e);

    /**
     * Fires when a template node is double clicked.
     *
     * @param view the view
     * @param index the index of the target node
     * @param node the target node
     * @param e the raw event object
     */
    void onDblClick(View view, int index, Element node, EventObject e);

    /**
     * Fires when the selected nodes change.
     *
     * @param view the view
     * @param selections array of the selected nodes
     */
    void onSelectionChange(View view, Element[] selections);
}
