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
 

package com.gwtext.client.data;

/**
 * {@link NodeModel} listener interface.
 *
 * @author mlim1972
 */
public interface NodeModelListener {

    /**
     * Fires when a new child node is appended.
     *
     * @param self  this node
     * @param node  the newly appended node
     */
    void onAppend(NodeModel self, NodeModel node);

    /**
     * Fires when a new child node is inserted.
     *
     * @param self    this node
     * @param node    the child node inserted
     * @param index   the index of the location of the new node
     */
    void onInsert(NodeModel self, NodeModel node, int index);

    /**
     * Fires when this node is moved to a new location in the tree.
     *
     * @param self      this node
     * @param oldParent the old parent of this node
     * @param newParent the new parent of this node
     * @param index     the index it was moved to
     */
    void onMove(NodeModel self, NodeModel oldParent, NodeModel newParent, int index);

    /**
     * Fires before a child is removed, return false to cancel the remove.
     *
     * @param self this node
     * @param node the child node to be removed
     */
    void onRemove(NodeModel self, NodeModel node);
    
    /**
     * Fires on an update on attribute
     * @param self this node
     * @param attributeName the attribute name
     * @param value the value for the attribute
     */
    void onUpdate(NodeModel self, String attributeName, Object value);
}
