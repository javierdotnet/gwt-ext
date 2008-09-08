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
 
package com.gwtext.client.widgets.event;

import com.google.gwt.user.client.Element;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.DataView;

/**
 * {@link com.gwtext.client.widgets.DataView} listener.
 *
 * @author Sanjiv Jivan
 */
public interface DataViewListener extends BoxComponentListener {

    /**
     * Fires before a click is processed. Returns false to cancel the default action.
     *
     * @param source this 
     * @param index The index of the target node
     * @param node The target node
     * @param e The raw event object
     * @return false to cancel
     */
    boolean doBeforeClick(DataView source, int index, Element node, EventObject e);

    /**
     * Fires before a selection is made. If any handlers return false, the selection is cancelled.
     * 
     * @param source this
     * @param node The node to be selected 
     * @param selections Array of currently selected nodes
     * @return false to cancel
     */
    boolean doBeforeSelect(DataView source, Element node, Element[] selections);

    /**
     * Fires when a template node is clicked.
     * 
     * @param source this 
     * @param index The index of the target node
     * @param node The target node
     * @param e The raw event object
     */
    void onClick(DataView source, int index, Element node, EventObject e);

    /**
     * Fires when a click occurs and it is not on a template node.
     *
     * @param source this
     * @param e The raw event object
     */
    void onContainerClick(DataView source, EventObject e);

    /**
     * Fires when a template node is right clicked.
     * 
     * @param source this
     * @param index The index of the target node
     * @param node  The target node
     * @param e The raw event object
     */
    void onContextMenu(DataView source, int index, Element node, EventObject e);

    /**
     * Fires when a template node is double clicked.
     *
     * @param source this 
     * @param index The index of the target node
     * @param node The target node
     * @param e The raw event object
     */
    void onDblClick(DataView source, int index, Element node, EventObject e);

    /**
     * Fires when the selected nodes change.
     *
     * @param view this
     * @param selections array of the selected nodes
     */
    void onSelectionChange(DataView view, Element[] selections);

}
