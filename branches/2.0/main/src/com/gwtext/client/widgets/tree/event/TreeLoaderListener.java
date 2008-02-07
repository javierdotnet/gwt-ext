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

public interface TreeLoaderListener {

    /**
     * Fires before a network request is made to retrieve the Json text which specifies a node's children.
     *
     * @param self this
     * @param node the node
     * @return false to cancel
     */
    boolean doBeforeLoad(TreeLoader self, TreeNode node);

    /**
     * Fires when the node has been successfuly loaded.
     *
     * @param self     this
     * @param node     the node
     * @param response the response text containing the data from the server
     */
    void onLoad(TreeLoader self, TreeNode node, String response);

    /**
     * Fires if the network request failed.
     *
     * @param self     this
     * @param node     the node
     * @param response the response  containing the data from the server
     */
    void onLoadException(TreeLoader self, TreeNode node, String response);
}
