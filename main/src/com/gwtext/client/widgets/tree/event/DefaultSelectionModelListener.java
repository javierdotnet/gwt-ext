/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.tree.event;

import com.gwtext.client.widgets.tree.DefaultSelectionModel;
import com.gwtext.client.widgets.tree.TreeNode;

/**
 * Listener for DefaultSelectionModel.
 *
 * @author Sanjiv Jivan
 * @see DefaultSelectionModel
 */
public interface DefaultSelectionModelListener {

    /**
     * Fires before the selected node changes, return false to cancel the change.
     *
     * @param sm      selection model
     * @param newNode the new selection
     * @param oldNode the old selection
     * @return false to cancel change
     */
    boolean doBeforeSelect(DefaultSelectionModel sm, TreeNode newNode, TreeNode oldNode);

    /**
     * Fires when the selected node changes. Note TreeNode passed is null when clearSelection is called,
     * or when a node is unselected.
     *
     * @param sm   selection model
     * @param node new selection
     */
    void onSelectionChange(DefaultSelectionModel sm, TreeNode node);
}
