/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.tree.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.Tree;
import com.gwtext.client.dd.DD;
import com.gwtext.client.dd.DragData;
import com.gwtext.client.dd.DragDrop;
import com.gwtext.client.widgets.event.PanelListener;
import com.gwtext.client.widgets.tree.DropNodeCallback;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;

public interface TreePanelListener extends PanelListener {

    /**
     * Fires when a new child node is appended to a node in this tree.
     * 
     * @param tree The owner tree
     * @param parent The parent node
     * @param node The newly appended node
     * @param index The index of the newly appended node
     */
    void onAppend(Tree tree, TreeNode parent, TreeNode node, int index);

    /**
     * Fires before a new child is appended to a node in this tree, return false to cancel the append.
     *
     * @param tree The owner tree
     * @param parent The parent node
     * @param node The newly appended node
     * @return false to cancel
     */
    boolean doBeforeAppend(Tree tree, TreeNode parent, TreeNode node);

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
     * @param e    the event object
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
    boolean doBeforeCollapseNode(TreeNode node, boolean deep, boolean anim);

    /**
     * Fires before this node is expanded, return false to cancel.
     *
     * @param node the node
     * @param deep whether deep expand
     * @param anim whether animated
     * @return false to cancel
     */
    boolean doBeforeExpandNode(TreeNode node, boolean deep, boolean anim);

    /**
     * Fires before a new child is inserted in a node in this tree, return false to cancel the insert.
     * 
     * @param tree The owner tree
     * @param parent The parent node
     * @param node The child node to be inserted
     * @param refNode The child node the node is being inserted before
     * @return false to cancel
     */
    boolean doBeforeInsert(Tree tree, TreeNode parent, TreeNode node, TreeNode refNode);
    
    /**
     * Fires before a node is loaded, return false to cancel.
     *
     * @param node the node
     * @return false to cancel
     */
    boolean doBeforeLoad(TreeNode node);

    /**
     * Fires before a node is moved to a new location in the tree. Return false to cancel the move.
     *
     * @param tree The owner tree
     * @param node The node being moved
     * @param oldParent The parent of the node
     * @param newParent The new parent the node is moving to
     * @param index The index it is being moved to
     * @return false to cancel
     */
    boolean doBeforeMoveNode(Tree tree, TreeNode node, TreeNode oldParent, TreeNode newParent, int index);

    //treepanel, target, data, point, source, rawEvent, dropNode
    //todo data?, enum
    /**
     * Fires when a DD object is dropped on a node in this tree for preprocessing. Return false to cancel the drop.
     *
     * @param treePanel        this
     * @param target           the node being targeted for the drop
     * @param dragData         the drag data
     * @param point            the point of the drop - append, above or below
     * @param source           the drag source
     * @param dropNode         drop node provided by the source
     * @param dropNodeCallback call setDropNode / setDropNodes on this callback to use a custon drop node. Can by used to drop a copy of the originally dropped
     * @return false to cancel
     */
    boolean doBeforeNodeDrop(TreePanel treePanel, TreeNode target, DragData dragData, String point, DragDrop source, TreeNode dropNode, DropNodeCallback dropNodeCallback);

    /**
     * Fires when a node with a checkbox's checked property changes.
     *
     * @param node    the node
     * @param checked true if checked
     */
    void onCheckChange(TreeNode node, boolean checked);

    /**
     * Fires when this node is clicked.
     *
     * @param node the node
     * @param e    the event object
     */
    void onClick(TreeNode node, EventObject e);

    /**
     * Fires when this node is collapsed.
     *
     * @param node the node
     */
    void onCollapseNode(TreeNode node);

    /**
     * Fires when this node is right clicked.
     *
     * @param node the node
     * @param e    the event obejct
     */
    void onContextMenu(TreeNode node, EventObject e);

    /**
     * Fires when this node is double clicked.
     *
     * @param node the node
     * @param e    the event object
     */
    void onDblClick(TreeNode node, EventObject e);

    /**
     * Fires when the disabled status of this node changes.
     *
     * @param node     the node
     * @param disabled true if disabled
     */
    void onDisabledChange(TreeNode node, boolean disabled);

    /**
     * Fires when a dragged node is dropped on a valid DD target.
     *
     * @param treePanel this
     * @param node      the node
     * @param dd        the DD it was dropped on
     */
    void onDragDrop(TreePanel treePanel, TreeNode node, DD dd);

    /**
     * Fires when a drag operation is complete
     *
     * @param treePanel this
     * @param node      the node
     */
    void onEndDrag(TreePanel treePanel, TreeNode node);

    /**
     * Fires when this node is expanded.
     *
     * @param node the node
     */
    void onExpandNode(TreeNode node);

    /**
     * Fires when a new child node is inserted in a node in this tree.
     * 
     * @param tree The owner tree
     * @param parent The parent node
     * @param node The child node inserted
     * @param refNode The child node the node was inserted before
     */
    void onInsert(Tree tree, TreeNode parent, TreeNode node, TreeNode refNode);

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
     * @param target    the node being targeted for the drop
     * @param dragData the drag data
     * @param point     the point of the drop - append, above or below
     * @param source    the drag source
     * @param dropNode  Drop node provided by the source @return false to cancel
     * @return false to cancel
     */
    boolean onNodeDragOver(TreePanel treePanel, TreeNode target, DragData dragData, String point, DragDrop source, TreeNode dropNode);

    /**
     * Fires after a DD object is dropped on a node in this tree.
     *
     * @param treePanel this
     * @param target    the node being targeted for the drop
     * @param dragData  the drag data
     * @param point     the point of the drop - append, above or below
     * @param source    the drag source
     * @param dropNode  Drop node provided by the source
     */
    void onNodeDrop(TreePanel treePanel, TreeNode target, DragData dragData, String point, DragDrop source, TreeNode dropNode);

    /**
     * Fires when a node is moved to a new location in the tree.
     *
     * @param tree the owner tree
     * @param node      the node
     * @param oldParent the old parent of this node
     * @param newParent the new parent of this node
     * @param index     the index it was moved to
     */
    void onMoveNode(Tree tree, TreeNode node, TreeNode oldParent, TreeNode newParent, int index);

    /**
     * Fires before a child node is removed from a node in this tree. Return false to cancel.
     *
     * @param tree the owner tree
     * @param parent the paent node
     * @param node the child node removed
     * @return false to cancel
     */
    boolean doBeforeRemove(Tree tree, TreeNode parent, TreeNode node);

    /**
     * Fires when a child node is removed from a node in this tree.
     *
     * @param tree the owner tree
     * @param parent the paent node
     * @param node the child node removed
     */
    void onRemove(Tree tree, TreeNode parent, TreeNode node);

    /**
     * Fires when a node starts being dragged.
     *
     * @param treePanel this
     * @param node      the node
     */
    void onStartDrag(TreePanel treePanel, TreeNode node);

    /**
     * Fires when the text for this node is changed.
     *
     * @param node    the node
     * @param text    the new text
     * @param oldText the old text
     */
    void onTextChange(TreeNode node, String text, String oldText);
}
