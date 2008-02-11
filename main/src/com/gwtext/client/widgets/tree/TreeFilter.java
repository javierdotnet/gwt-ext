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
 * Supports filtering of TreePanel nodes.
 */
public class TreeFilter extends JsObject {

	/**
	 * Create a new TreeFilter.
	 *
	 * @param treePanel the tree panel to filter
	 */
	public TreeFilter(TreePanel treePanel) {
        jsObj = create(treePanel.getOrCreateJsObj(), null);
    }

	/**
	 * Create a new TreeFilter.
	 *
	 * @param treePanel the tree panel to filter
	 * @param config the TreePanelFilter config
	 */
	public TreeFilter(TreePanel treePanel, TreeFilterConfig config) {
        jsObj = create(treePanel.getOrCreateJsObj(), config == null ? null : config.getJsObj());
    }

    protected native JavaScriptObject create(JavaScriptObject treePanel, JavaScriptObject config)/*-{
        return new $wnd.Ext.tree.TreeFilter(treePanel, config);
    }-*/;

	/**
	 * Clears the current filter. Note: with the "remove" TreeFilterConfig option set a filter cannot be cleared.
	 */
	public native void clear() /*-{
        var filter = this.@com.gwtext.client.core.JsObject::getJsObj()();
        filter.clear();
    }-*/;

    //TODO filter based on specific node attributes
	/**
	 *  Filter the data.
	 * 
	 * @param value the node's text value
	 */
	public native void filter(String value) /*-{
        var filter = this.@com.gwtext.client.core.JsObject::getJsObj()();
        filter.filter(value);
    }-*/;

	/**
	 *  Filter the data.
	 *
	 * @param value the node's text
	 * @param startNode the node to start filtering from
	 */
    public native void filter(String value, TreeNode startNode) /*-{
        var filter = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var node = startNode.@com.gwtext.client.core.JsObject::getJsObj()();
        filter.filter(value, null, node);
    }-*/;

	/**
	 *  Filter the data.
	 *
	 * @param regexp regexp to test the node value against
	 */
	public native void filterRe(String regexp) /*-{
        var filter = this.@com.gwtext.client.core.JsObject::getJsObj()();
        filter.filter(new $wnd.RegExp(regexp));
    }-*/;

	/**
	 *  Filter the data.
	 *
	 * @param regexp regexp to test the node value against
	 * @param startNode the node to start filtering from
	 */
    public native void filterRe(String regexp, TreeNode startNode) /*-{
        var filter = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var node = startNode.@com.gwtext.client.core.JsObject::getJsObj()();
        filter.filter(new $wnd.RegExp(regexp), null, node);
    }-*/;

	/**
	 * Filter by a callback function. The passed function will be called with each node in the tree (or from the startNode).
	 * If the callback returns true, the node is kept otherwise it is filtered. If a node is filtered, its children are also
	 * filtered.
	 *
	 * @param callback the filter callback
	 */
   public native void filterBy(TreeTraversalCallback callback) /*-{
       var filter = this.@com.gwtext.client.core.JsObject::getJsObj()();
       filter.filterBy(function(node) {
            var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
            return callback.@com.gwtext.client.widgets.tree.TreeTraversalCallback::execute(Lcom/gwtext/client/widgets/tree/TreeNode;)(nodeJ);
        });
   }-*/;
}
