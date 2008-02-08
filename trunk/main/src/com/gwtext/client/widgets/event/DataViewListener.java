/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 *
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.event;

import com.google.gwt.user.client.Element;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.DataView;

/**
 * {@link com.gwtext.client.widgets.DataView} listener.
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
