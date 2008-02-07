/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.tree.event;

import com.gwtext.client.widgets.tree.AsyncTreeNode;

public interface AsyncTreeNodeListener {

    /**
     * Fires before this node is loaded, return false to cancel.
     *
     * @param node the node
     * @return false to cancel
     */
    boolean doBeforeLoad(AsyncTreeNode node);

    /**
     * Fires when this node is loaded.
     *
     * @param node the node
     */
    void onLoad(AsyncTreeNode node);

}
