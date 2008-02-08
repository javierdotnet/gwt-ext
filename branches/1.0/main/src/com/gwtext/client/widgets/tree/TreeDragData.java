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