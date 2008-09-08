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
 
package com.gwtext.client.widgets.tree;

/**
 * This callback inferface can be used to customize what happends when a tree node is dropped on another node.
 * For example the behaviour can to move / copy the dropped node to the drop point, or even
 * create multiple tree nodes then a drop event occurs.
 *
 * @author Sanjiv Jivan
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
