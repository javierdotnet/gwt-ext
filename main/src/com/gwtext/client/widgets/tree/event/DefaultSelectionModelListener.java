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

import com.gwtext.client.widgets.tree.DefaultSelectionModel;
import com.gwtext.client.widgets.tree.TreeNode;

/**
 * Listener for DefaultSelectionModel.
 *
 * @author Sanjiv Jivan
 * @see DefaultSelectionModel
 */
public interface DefaultSelectionModelListener {

    /**
     * Fires before the selected node changes, return false to cancel the change.
     *
     * @param sm      selection model
     * @param newNode the new selection
     * @param oldNode the old selection
     * @return false to cancel change
     */
    boolean doBeforeSelect(DefaultSelectionModel sm, TreeNode newNode, TreeNode oldNode);

    /**
     * Fires when the selected node changes. Note TreeNode passed is null when clearSelection is called,
     * or when a node is unselected.
     *
     * @param sm   selection model
     * @param node new selection
     */
    void onSelectionChange(DefaultSelectionModel sm, TreeNode node);
}
