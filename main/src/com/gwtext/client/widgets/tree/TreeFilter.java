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
        jsObj = create(treePanel.getJsObj(), null);
    }

	/**
	 * Create a new TreeFilter.
	 *
	 * @param treePanel the tree panel to filter
	 * @param config the TreePanelFilter config
	 */
	public TreeFilter(TreePanel treePanel, TreeFilterConfig config) {
        jsObj = create(treePanel.getJsObj(), config == null ? null : config.getJsObj());
    }

    protected native JavaScriptObject create(JavaScriptObject treePanel, JavaScriptObject config)/*-{
        return new $wnd.Ext.tree.TreeFilter(treePanel, config);
    }-*/;

	/**
	 * Clears the current filter. Note: with the "remove" TreeFilterConfig option set a filter cannot be cleared.
	 */
	public native void clear() /*-{
        var filter = this.@com.gwtext.client.core.JsObject::jsObj;
        filter.clear();
    }-*/;

    //TODO filter based on specific node attributes
	/**
	 *  Filter the data.
	 * 
	 * @param value the node's text value
	 */
	public native void filter(String value) /*-{
        var filter = this.@com.gwtext.client.core.JsObject::jsObj;
        filter.filter(value);
    }-*/;

	/**
	 *  Filter the data.
	 *
	 * @param value the node's text
	 * @param startNode the node to start filtering from
	 */
    public native void filter(String value, TreeNode startNode) /*-{
        var filter = this.@com.gwtext.client.core.JsObject::jsObj;
        var node = startNode.@com.gwtext.client.core.JsObject::jsObj;
        filter.filter(value, null, node);
    }-*/;

	/**
	 *  Filter the data.
	 *
	 * @param regexp regexp to test the node value against
	 */
	public native void filterRe(String regexp) /*-{
        var filter = this.@com.gwtext.client.core.JsObject::jsObj;
        filter.filter(new $wnd.RegExp(regexp));
    }-*/;

	/**
	 *  Filter the data.
	 *
	 * @param regexp regexp to test the node value against
	 * @param startNode the node to start filtering from
	 */
    public native void filterRe(String regexp, TreeNode startNode) /*-{
        var filter = this.@com.gwtext.client.core.JsObject::jsObj;
        var node = startNode.@com.gwtext.client.core.JsObject::jsObj;
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
       var filter = this.@com.gwtext.client.core.JsObject::jsObj;
       filter.filterBy(function(node) {
            var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
            return callback.@com.gwtext.client.widgets.tree.TreeTraversalCallback::execute(Lcom/gwtext/client/widgets/tree/TreeNode;)(nodeJ);
        });
   }-*/;
}
