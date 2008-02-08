/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 *
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.dd.DragData;

/**
 * An implementation of DragData that is passed to the drop target when the source is a TreeNode from a Draggable tree.
 *
 * @see com.gwtext.client.widgets.tree.event.TreePanelListener#doBeforeNodeDrop(TreePanel, TreeNode, com.gwtext.client.dd.DragData, String, com.gwtext.client.dd.DragDrop, TreeNode, DropNodeCallback)
 * @see com.gwtext.client.widgets.tree.event.TreePanelListener#onNodeDrop(TreePanel, TreeNode, com.gwtext.client.dd.DragData, String, com.gwtext.client.dd.DragDrop, TreeNode)
 */
public class TreeDragData extends DragData {

    public TreeDragData(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Return the dropped TreeNode.
     *
     * @return the dropped TreeNode
     */
    public TreeNode getTreeNode() {
        JavaScriptObject treeNode = getPropertyAsJavaScriptObject("node");
        return new TreeNode(treeNode);
    }
}