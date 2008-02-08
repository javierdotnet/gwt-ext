/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.tree;

/**
 * Callback interface invoked on an expandable node.
 *
 * @see TreePanel#expandPath(String, NodeExpansionCallback)
 */
public interface NodeExpansionCallback {

    /**
     * The callback method to call when the expand is complete. The callback will be called with
     * (success, lastNode) where success is if the expand was successful and lastNode is the last node that was expanded.
     *
     * @param success  true if expand successful
     * @param lastNode the last node expanded
     */
    void onExpand(boolean success, TreeNode lastNode);
}
