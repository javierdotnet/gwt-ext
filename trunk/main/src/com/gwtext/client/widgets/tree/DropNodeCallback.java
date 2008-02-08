/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.tree;

/**
 * This callback inferface can be used to customize what happends when a tree node is dropped on another node.
 * For example the behaviour can to move / copy the dropped node to the drop point, or even
 * create multiple tree nodes then a drop event occurs.
 *
 * @see com.gwtext.client.widgets.tree.event.TreePanelListener#doBeforeNodeDrop(TreePanel, TreeNode, com.gwtext.client.dd.DragData, String, com.gwtext.client.dd.DragDrop, TreeNode, DropNodeCallback)
 */
public interface DropNodeCallback {

    /**
     * Set the drop node to a single tree node.
     *
     * @param node the new node
     */
    void setDropNode(TreeNode node);

    /**
     * Set the drop to result in multiple tree nodes.
     *
     * @param nodes the tree nodes
     */
    void setDropNodes(TreeNode[] nodes);

}
