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
import com.gwtext.client.widgets.event.PanelListenerAdapter;
import com.gwtext.client.widgets.tree.DropNodeCallback;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;

public class TreePanelListenerAdapter extends PanelListenerAdapter implements TreePanelListener {

    public boolean doBeforeChildrenRendered(TreeNode node) {
        return true;
    }

    public void onAppend(Tree tree, TreeNode parent, TreeNode node, int index) {
    }

    public boolean doBeforeAppend(Tree tree, TreeNode parent, TreeNode node) {
        return true;
    }

    public boolean doBeforeInsert(Tree tree, TreeNode parent, TreeNode node, TreeNode refNode) {
        return true;
    }

    public void onInsert(Tree tree, TreeNode parent, TreeNode node, TreeNode refNode) {
    }

    public boolean doBeforeRemove(Tree tree, TreeNode parent, TreeNode node) {
        return true;
    }

    public void onRemove(Tree tree, TreeNode parent, TreeNode node) {
    }

    public boolean doBeforeClick(TreeNode node, EventObject e) {
        return true;
    }

    public boolean doBeforeCollapseNode(TreeNode node, boolean deep, boolean anim) {
        return true;
    }

    public boolean doBeforeExpandNode(TreeNode node, boolean deep, boolean anim) {
        return true;
    }

    public boolean doBeforeLoad(TreeNode node) {
        return true;
    }

    public boolean doBeforeNodeDrop(TreePanel treePanel, TreeNode target, DragData dragData, String point, DragDrop source, TreeNode dropNode, DropNodeCallback dropNodeCallback) {
        return true;
    }

    public void onCheckChange(TreeNode node, boolean checked) {
    }

    public void onClick(TreeNode node, EventObject e) {
    }

    public void onCollapseNode(TreeNode node) {
    }

    public void onContextMenu(TreeNode node, EventObject e) {
    }

    public void onDblClick(TreeNode node, EventObject e) {
    }

    public void onDisabledChange(TreeNode node, boolean disabled) {
    }

    public void onDragDrop(TreePanel treePanel, TreeNode node, DD dd) {
    }

    public void onEndDrag(TreePanel treePanel, TreeNode node) {
    }

    public void onExpandNode(TreeNode node) {
    }

    public void onLoad(TreeNode node) {
    }

    public boolean onNodeDragOver(TreePanel treePanel, TreeNode target, DragData dragData, String point, DragDrop source, TreeNode dropNode) {
        return true;
    }

    public void onNodeDrop(TreePanel treePanel, TreeNode target, DragData dragData, String point, DragDrop source, TreeNode dropNode) {
    }

    public boolean doBeforeMoveNode(Tree tree, TreeNode node, TreeNode oldParent, TreeNode newParent, int index) {
        return true;
    }

    public void onMoveNode(Tree treePanel, TreeNode node, TreeNode oldParent, TreeNode newParent, int index) {
    }

    public void onStartDrag(TreePanel treePanel, TreeNode node) {
    }

    public void onTextChange(TreeNode node, String text, String oldText) {
    }
}
