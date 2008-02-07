/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.tree.event;

import com.gwtext.client.widgets.tree.DefaultSelectionModel;
import com.gwtext.client.widgets.tree.TreeNode;

public class DefaultSelectionModelListenerAdapter implements DefaultSelectionModelListener {

    public boolean doBeforeSelect(DefaultSelectionModel sm, TreeNode newNode, TreeNode oldNode) {
        return true;
    }

    public void onSelectionChange(DefaultSelectionModel sm, TreeNode node) {
    }
}
