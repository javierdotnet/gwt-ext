/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
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

/**
 *
 * @author Sanjiv Jivan
 */
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
