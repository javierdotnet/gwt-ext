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

package com.gwtext.client.widgets.tree.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.dd.DD;
import com.gwtext.client.dd.DragDrop;
import com.gwtext.client.widgets.tree.DropNodeCallback;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;

public interface TreePanelListener {

    /**
     * Fires right before the child nodes for a node are rendered.
     *
     * @param node the node
     * @return false to cancel
     */
    boolean doBeforeChildrenRendered(TreeNode node);

    /**
     * Fires before click processing. Return false to cancel the default action.
     *
     * @param node the node
     * @param e the event object
     * @return false to cancel
     */
    boolean doBeforeClick(TreeNode node, EventObject e);

    /**
     * Fires before this node is collapsed, return false to cancel.
     *
     * @param node the node
     * @param deep whether deep collapse
     * @param anim whether animated
     * @return false to cancel
     */
    boolean doBeforeCollapse(TreeNode node, boolean deep, boolean anim);

    /**
     * Fires before this node is expanded, return false to cancel.
     *
     * @param node the node
     * @param deep whether deep expand
     * @param anim whether animated
     * @return false to cancel
     */
    boolean doBeforeExpand(TreeNode node, boolean deep, boolean anim);

    /**
     * Fires before a node is loaded, return false to cancel.
     *
     * @param node the node
     * @return false to cancel
     */
    boolean doBeforeLoad(TreeNode node);

    //treepanel, target, data, point, source, rawEvent, dropNode
    //todo data?, enum
    /**
     * Fires when a DD object is dropped on a node in this tree for preprocessing. Return false to cancel the drop.
     * 
     * @param treePanel this
     * @param target the node being targeted for the drop
     * @param point the point of the drop - append, above or below
     * @param source the drag source
     * @param dropNode drop node provided by the source
     * @param dropNodeCallback call setDropNode / setDropNodes on this callback to use a custon drop node. Can by used to drop a copy of the originally dropped
     *              node by cloning the dropped node and calling setDropNode on this callback
     * @return false to cancel the drop
     */
    boolean doBeforeNodeDrop(TreePanel treePanel, TreeNode target, String point, DragDrop source, TreeNode dropNode, DropNodeCallback dropNodeCallback);

    /**
     * Fires when a node with a checkbox's checked property changes.
     *
     * @param node the node
     * @param checked true if checked
     */
    void onCheckChange(TreeNode node, boolean checked);

    /**
     * Fires when this node is clicked.
     *
     * @param node the node
     * @param e the event object
     */
    void onClick(TreeNode node, EventObject e);

    /**
     * Fires when this node is collapsed.
     *
     * @param node the node
     */
    void onCollapse(TreeNode node);

    /**
     * Fires when this node is right clicked.
     *
     * @param node the node
     * @param e the event obejct
     */
    void onContextMenu(TreeNode node, EventObject e);

    /**
     * Fires when this node is double clicked.
     *
     * @param node the node
     * @param e the event object
     */
    void onDblClick(TreeNode node, EventObject e);

    /**
     * Fires when the disabled status of this node changes.
     *
     * @param node the node
     * @param disabled true if disabled
     */
    void onDisabledChange(TreeNode node, boolean disabled);

    /**
     * Fires when a dragged node is dropped on a valid DD target.
     *
     * @param treePanel this
     * @param node the node
     * @param dd the DD it was dropped on
     */
    void onDragDrop(TreePanel treePanel, TreeNode node, DD dd);

    /**
     * Fires when a drag operation is complete
     *
     * @param treePanel this
     * @param node the node
     */
    void onEndDrag(TreePanel treePanel, TreeNode node);

    /**
     * Fires when this node is expanded.
     *
     * @param node the node
     */
    void onExpand(TreeNode node);

    /**
     * Fires when a node is loaded.
     * 
     * @param node the node
     */
    void onLoad(TreeNode node);

    /**
     * Fires when a tree node is being targeted for a drag drop, return false to signal drop not allowed.
     * 
     * @param treePanel this
     * @param target the node being targeted for the drop
     * @param point the point of the drop - append, above or below
     * @param source the drag source
     * @param dropNode Drop node provided by the source
     * @return false to cancel
     */
    boolean onNodeDragOver(TreePanel treePanel, TreeNode target, String point, DragDrop source, TreeNode dropNode);

    /**
     * Fires after a DD object is dropped on a node in this tree.
     *
     * @param treePanel this
     * @param target the node being targeted for the drop
     * @param point the point of the drop - append, above or below
     * @param source the drag source
     * @param dropNode Drop node provided by the source
     */
    void onNodeDrop(TreePanel treePanel, TreeNode target, String point, DragDrop source, TreeNode dropNode);

    /**
     * Fires when a node is moved to a new location in the tree.
     * 
     * @param treePanel this
     * @param node the node
     * @param oldParent the old parent of this node
     * @param newParent the new parent of this node
     * @param index the index it was moved to
     */
    void onMove(TreePanel treePanel, TreeNode node, TreeNode oldParent, TreeNode newParent, int index);

    /**
     * Fires when a node starts being dragged.
     * 
     * @param treePanel this
     * @param node the node
     */
    void onStartDrag(TreePanel treePanel, TreeNode node);

    /**
     * Fires when the text for this node is changed.
     *
     * @param node the node
     * @param text the new text
     * @param oldText the old text
     */
    void onTextChange(TreeNode node, String text, String oldText);
}
