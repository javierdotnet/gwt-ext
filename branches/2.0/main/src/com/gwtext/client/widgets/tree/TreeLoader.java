/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.Function;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.core.Connection;
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

    protected JavaScriptObject configJS = JavaScriptObjectHelper.createObject();

	public TreeLoader(JavaScriptObject jsObj) {
        super(jsObj);
        configJS = jsObj;
    }

	/**
	 * Create a new TreeLoader.
	 *
	 */
	public TreeLoader() {
    }

    public JavaScriptObject getJsObj() {
        if(!isCreated()) {
            jsObj = create(configJS);
        }
        return jsObj;
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
	private void setBaseParamsCreated(UrlParam[] params) {
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
        var tree = this.@com.gwtext.client.core.JsObject::jsObj;
        tree.load();
    }-*/;

	/**
	 * Load a TreeNode from the URL specified in the TreeLoader configuration. This is called automatically when a node
	 * is expanded, but may be used to reload a node (or append new children if the clearOnLoad option is false.)
	 *
	 * @param callback the callback to execute on load
	 */
    public native void load(Function callback) /*-{
        var tree = this.@com.gwtext.client.core.JsObject::jsObj;
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

    //config options

	/**
	 * The request parameters to be added to all nodes created by this loader.
	 * If the attributes sent by the server have an attribute in this object, they take priority.
	 *
	 * @param params the url params
	 */
	public void setBaseAttrs(UrlParam[] params) {
		JavaScriptObject paramObj = UrlParam.getJsObj(params);
		JavaScriptObjectHelper.setAttribute(configJS, "baseAttrs", paramObj);
	}

	/**
	 * The URL from which to request a Json string which specifies an array of node definition object representing the
	 * child nodes to be loaded.
	 *
	 * @param dataUrl the data URL
	 */
	public void setDataUrl(String dataUrl) {
		JavaScriptObjectHelper.setAttribute(configJS, "dataUrl", dataUrl);
	}

    public void setPreloadChildren(boolean preloadChildren) {
        JavaScriptObjectHelper.setAttribute(configJS, "preloadChildren ", preloadChildren);
    }



    /**
	 * The request method (GET OR POST).
	 *
	 * @param method the request method
	 * @see com.gwtext.client.core.Connection#GET
	 * @see com.gwtext.client.core.Connection#POST
	 */
	public void setMethod(Connection.Method method) {
		JavaScriptObjectHelper.setAttribute(configJS, "requestMethod", method.getMethod());
	}

	/**
	 * The request method (GET OR POST).
	 *
	 * @param method the request method
	 * @deprecated Use {@link #setMethod(com.gwtext.client.core.Connection.Method)}
	 */
	public void setMethod(String method) {
		JavaScriptObjectHelper.setAttribute(configJS, "requestMethod", method);
	}

	/**
	 * Request properties which specify HTTP parameters to be passed to each request for child nodes.
	 *
	 * @param params the request params
	 */
	public void setBaseParams(UrlParam[] params) {
        if(!isCreated()) {
            JavaScriptObject paramObj = UrlParam.getJsObj(params);
		    JavaScriptObjectHelper.setAttribute(configJS, "baseParams", paramObj);
        } else {
            setBaseParamsCreated(params);
        }
    }

	/**
	 * Default to true. Remove previously existing child nodes before loading.
	 *
	 * @param clearOnLoad true to clear on load
	 */
	public void setClearOnLoad(boolean clearOnLoad) {
		JavaScriptObjectHelper.setAttribute(configJS, "clearOnLoad", clearOnLoad);
	}

	//todo  uiProviders


}
