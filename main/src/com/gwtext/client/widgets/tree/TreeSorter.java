/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;

/**
 * Helper class to enable tree node sorting functionality.
 */
public class TreeSorter extends JsObject {

    /**
     * Construct a new TreeSorter.
     *
     * @param treePanel the tree panel to sort
     * @param config the TreeSorter config
     */
    public TreeSorter(TreePanel treePanel, TreeSorterConfig config) {
       jsObj = create(treePanel.getOrCreateJsObj(), config == null ? null : config.getJsObj());
    }

    private native JavaScriptObject create(JavaScriptObject treePanel, JavaScriptObject config) /*-{
        return new $wnd.Ext.tree.TreeSorter(treePanel, config);
    }-*/;

    //http://extjs.com/forum/showthread.php?t=6795
    /**
     * Sort the TreePanel starting from the specified node.
     *
     * @param startNode the start node
     */
    public native void sort(TreeNode startNode) /*-{
        var sorter = this.@com.gwtext.client.core.JsObject::jsObj;
        var startNodeJ = startNode.@com.gwtext.client.core.JsObject::jsObj;
        sorter.doSort(startNodeJ);
    }-*/;
}
