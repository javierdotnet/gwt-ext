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

package com.gwtext.client.data.event;

import com.gwtext.client.data.Node;
import com.gwtext.client.data.Tree;

/**
 * {@link Node} listener interface.
 */
public interface NodeListener {

    /**
     *  Fires when a new child node is appended.
     *
     * @param tree the owner tree
     * @param self this node
     * @param node the newly appended node
     * @param index the index of the newly appended node
     */
    void onAppend(Tree tree, Node self, Node node, int index);

    /**
     * Fires before a new child is appended, return false to cancel the append.
     *
     * @param tree the owner tree
     * @param self this node
     * @param node the child node to be appended
     * @return false to cancel the append
     */
    boolean doBeforeAppend(Tree tree, Node self, Node node);

    /**
     *  Fires before a new child is inserted, return false to cancel the insert.
     *
     * @param tree the owner tree
     * @param self this node
     * @param node the child node to be inserted
     * @param refNode the child node the node is being inserted before
     * @return false to cancel the insert
     */
    boolean doBeforeInsert(Tree tree, Node self, Node node, Node refNode);

    /**
     * Fires before this node is moved to a new location in the tree. Return false to cancel the move.
     *
     * @param tree the owner tree
     * @param self this node
     * @param oldParent the parent of this node
     * @param newParent the new parent this node is moving to
     * @param index the index it is being moved to
     * @return false to cancel the move
     */
    boolean doBeforeMove(Tree tree, Node self, Node oldParent, Node newParent, int index);

    /**
     * Fires before a child is removed, return false to cancel the remove.
     *
     * @param tree the owner tree
     * @param self this node
     * @param node the child node to be removed
     * @return false to cancel the remove
     */
    boolean doBeforeRemove(Tree tree, Node self, Node node);

    /**
     * Fires when a new child node is inserted.
     *
     * @param tree the owner tree
     * @param self this node
     * @param node the child node inserted
     * @param refNode the child node the node was inserted before
     */
    void onInsert(Tree tree, Node self, Node node, Node refNode);

    /**
     * Fires when this node is moved to a new location in the tree.
     *
     * @param tree the owner tree 
     * @param self this node
     * @param oldParent the old parent of this node 
     * @param newParent the new parent of this node
     * @param index the index it was moved to
     */
    void onMove(Tree tree, Node self, Node oldParent, Node newParent, int index);

    /**
     * Fires before a child is removed, return false to cancel the remove.
     *
     * @param tree the owner tree
     * @param self this node
     * @param node the child node to be removed
     */
    void onRemove(Tree tree, Node self, Node node);
}
