/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.tree.event;

import com.gwtext.client.widgets.tree.MultiSelectionModel;
import com.gwtext.client.widgets.tree.TreeNode;

/**
 * Listener for MultiSelectionModel
 *
 * @author Sanjiv Jivan
 * @see com.gwtext.client.widgets.tree.MultiSelectionModel
 */
public interface MultiSelectionModelListener {

    /**
     * Fires when the selected nodes change.
     *
     * @param sm    selection model
     * @param nodes selected nodes
     */
    void onSelectionChange(MultiSelectionModel sm, TreeNode[] nodes);
}
