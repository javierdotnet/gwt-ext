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
import com.gwtext.client.core.Function;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.tree.event.TreeLoaderListener;

/**
 * A TreeLoader provides for lazy loading of an {@link TreeNode}'s child nodes from a specified URL.
 * The response must be a Json array definition who's elements are node definition objects. eg:
 * <pre>
 * <code>
 *
 * [{ 'id': 1, 'text': 'A folder Node', 'leaf': false },
 * { 'id': 2, 'text': 'A leaf Node', 'leaf': true }]
 *
 * </code>
 * </pre>
 *
 * A server request is sent, and child nodes are loaded only when a node is expanded. The loading node's
 * id is passed to the server under the parameter name "node" to enable the server to produce the correct
 * child nodes.

 */
public class TreeLoader extends JsObject {

	protected TreeLoader() {}
	
	public TreeLoader(JavaScriptObject jsObj) {
        super(jsObj);
    }

	/**
	 * Create a new TreeLoader.
	 *
	 * @param config the TreeLoader config
	 */
	public TreeLoader(TreeLoaderConfig config) {
        jsObj = create(config.getJsObj());
    }

    protected native JavaScriptObject create(JavaScriptObject config)/*-{
        return new $wnd.Ext.tree.TreeLoader(config);
    }-*/;

    public static TreeLoader instance(JavaScriptObject jsObj) {
        return new TreeLoader(jsObj);
    }

	/**
	 * Specify HTTP parameters to be passed to each request for child nodes.
	 * 
	 * @param params the params
	 */
	public void setBaseParams(UrlParam[] params) {
        JavaScriptObject paramObj = UrlParam.getJsObj(params);
        JavaScriptObjectHelper.setAttribute(jsObj, "baseParams", paramObj);
    }
	
	//todo add pluggable createNode strategy
    //createNode()
	/**
	 * Load a TreeNode from the URL specified in the TreeLoader configuration. This is called automatically when a node
	 * is expanded, but may be used to reload a node (or append new children if the clearOnLoad option is false.)
	 */
    public native void load() /*-{
        var tree = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tree.load();
    }-*/;

	/**
	 * Load a TreeNode from the URL specified in the TreeLoader configuration. This is called automatically when a node
	 * is expanded, but may be used to reload a node (or append new children if the clearOnLoad option is false.)
	 *
	 * @param callback the callback to execute on load
	 */
    public native void load(Function callback) /*-{
        var tree = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tree.load(function() {
			callback.@com.gwtext.client.core.Function::execute()();
		});
    }-*/;

	/**
	 * Add a TreeLoader listener.
	 *
	 * @param listener the listener
	 */
	public native void addTreeLoaderListener(TreeLoaderListener listener)/*-{
        var loader = this.@com.gwtext.client.core.JsObject::jsObj;
        var loaderJ = this;

         loader.addListener('beforeload',
                 function(loader, node) {
                    var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                    return listener.@com.gwtext.client.widgets.tree.event.TreeLoaderListener::doBeforeLoad(Lcom/gwtext/client/widgets/tree/TreeLoader;Lcom/gwtext/client/widgets/tree/TreeNode;)(loaderJ, nodeJ)
			    }
          );

         loader.addListener('load',
                 function(loader, node, response) {
                    var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                    return listener.@com.gwtext.client.widgets.tree.event.TreeLoaderListener::onLoad(Lcom/gwtext/client/widgets/tree/TreeLoader;Lcom/gwtext/client/widgets/tree/TreeNode;Ljava/lang/String;)(loaderJ, nodeJ, response);
			    }
          );
            loader.addListener('loadexception',
                 function(loader, node, response) {
                    var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                    return listener.@com.gwtext.client.widgets.tree.event.TreeLoaderListener::onLoadException(Lcom/gwtext/client/widgets/tree/TreeLoader;Lcom/gwtext/client/widgets/tree/TreeNode;Ljava/lang/String;)(loaderJ, nodeJ, response);
			    }
          );
    }-*/;
}
