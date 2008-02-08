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

import com.gwtext.client.widgets.tree.MultiSelectionModel;
import com.gwtext.client.widgets.tree.TreeNode;

/**
 * Listener for MultiSelectionModel
 *
 * @author Sanjiv Jivan
 * @see com.gwtext.client.widgets.tree.MultiSelectionModel
 */
public interface MultiSelectionModelListener {

    /**
     * Fires when the selected nodes change.
     * 
     * @param sm selection model
     * @param nodes selected nodes
     */
    void onSelectionChange(MultiSelectionModel sm, TreeNode[] nodes);
}
