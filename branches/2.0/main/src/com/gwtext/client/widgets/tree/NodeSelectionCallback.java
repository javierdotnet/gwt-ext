/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.tree;

/**
 * Node selection callback.
 *
 * @see com.gwtext.client.widgets.tree.TreePanel#selectPath(String, NodeSelectionCallback)
 */
public interface NodeSelectionCallback {

    /**
     * Callback invoked when selection is complete.
     *
     * @param success true if selection successful
     * @param node    the selected node
     */
    void onSelect(boolean success, TreeNode node);
}