/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 
package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;

/**
 * Supports filtering of TreePanel nodes.
 *
 * @author Sanjiv Jivan
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
            var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::treeNodeInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
            return callback.@com.gwtext.client.widgets.tree.TreeTraversalCallback::execute(Lcom/gwtext/client/widgets/tree/TreeNode;)(nodeJ);
        });
   }-*/;
}
