/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;

public interface TreeSelectionModel {

    JavaScriptObject getJsObj();

    /**
     * Clear all selections.
     */
    void clearSelections();

    /**
     * Returns true if the node is selected.
     *
     * @param treeNode the node to test
     * @return true if selected
     */
    boolean isSelected(TreeNode treeNode);

    /**
     * Select a node.
     *
     * @param treeNode the tree node to select
     */
    void select(TreeNode treeNode);

    /**
     * Selects the node above the selected node in the tree, intelligently walking the nodes.
     */
    void selectNext();

    /**
     * Selects the node above the selected node in the tree, intelligently walking the nodes.
     */
    void selectPrevious();

    /**
     * Deselect a node.
     *
     * @param treeNode the node to deselect
     */
    void unselect(TreeNode treeNode);
}
