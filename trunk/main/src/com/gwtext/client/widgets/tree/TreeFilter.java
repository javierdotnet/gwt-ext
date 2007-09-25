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

public class TreeFilter extends JsObject {

    public TreeFilter(TreePanel treePanel) {
        jsObj = create(treePanel.getJsObj(), null);
    }
    
    public TreeFilter(TreePanel treePanel, TreeFilterConfig config) {
        jsObj = create(treePanel.getJsObj(), config == null ? null : config.getJsObj());
    }

    protected native JavaScriptObject create(JavaScriptObject treePanel, JavaScriptObject config)/*-{
        return new $wnd.Ext.tree.TreeFilter(treePanel, config);
    }-*/;

    public native void clear() /*-{
        var filter = this.@com.gwtext.client.core.JsObject::jsObj;
        filter.clear();
    }-*/;

    //TODO filter based on specific node attributes
    public native void filter(String value) /*-{
        var filter = this.@com.gwtext.client.core.JsObject::jsObj;
        filter.filter(value);
    }-*/;

    public native void filter(String value, TreeNode startNode) /*-{
        var filter = this.@com.gwtext.client.core.JsObject::jsObj;
        var node = startNode.@com.gwtext.client.core.JsObject::jsObj;
        filter.filter(value, null, node);
    }-*/;

    public native void filterRe(String regexp) /*-{
        var filter = this.@com.gwtext.client.core.JsObject::jsObj;
        filter.filter(new $wnd.RegExp(regexp));
    }-*/;

    public native void filterRe(String regexp, TreeNode startNode) /*-{
        var filter = this.@com.gwtext.client.core.JsObject::jsObj;
        var node = startNode.@com.gwtext.client.core.JsObject::jsObj;
        filter.filter(new $wnd.RegExp(regexp), null, node);
    }-*/;

   public native void filterBy(TreeTraversalCallback callback) /*-{
       var filter = this.@com.gwtext.client.core.JsObject::jsObj;
       filter.filterBy(function(node) {
            var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
            return callback.@com.gwtext.client.widgets.tree.TreeTraversalCallback::execute(Lcom/gwtext/client/widgets/tree/TreeNode;)(nodeJ);
        });
   }-*/;
}
