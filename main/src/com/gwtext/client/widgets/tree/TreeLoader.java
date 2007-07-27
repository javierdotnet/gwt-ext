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
import com.gwtext.client.widgets.tree.event.TreeLoaderListener;

public class TreeLoader extends JsObject {

    public TreeLoader(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public TreeLoader(TreeLoaderConfig config) {
        jsObj = create(config.getJsObj());
    }

    private native JavaScriptObject create(JavaScriptObject config)/*-{
        return new $wnd.Ext.tree.TreeLoader(config);
    }-*/;

    public static TreeLoader instance(JavaScriptObject jsObj) {
        return new TreeLoader(jsObj);
    }

    //todo add pluggable createNode strategy
    //createNode()

    public native void load() /*-{
        var tree = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tree.load();
    }-*/;

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
