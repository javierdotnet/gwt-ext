/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.tree.event;

import com.gwtext.client.widgets.tree.TreeLoader;
import com.gwtext.client.widgets.tree.TreeNode;

public class TreeLoaderListenerAdapter implements TreeLoaderListener {

    public boolean doBeforeLoad(TreeLoader self, TreeNode node) {
        return true;
    }

    public void onLoad(TreeLoader self, TreeNode node, String response) {
    }

    public void onLoadException(TreeLoader self, TreeNode node, String response) {
    }
}
