/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.tree.event;

import com.gwtext.client.widgets.tree.AsyncTreeNode;

public class AsyncTreeNodeListenerAdapter implements AsyncTreeNodeListener {

    public boolean doBeforeLoad(AsyncTreeNode node) {
        return true;
    }

    public void onLoad(AsyncTreeNode node) {
    }
}
