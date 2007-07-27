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
import com.gwtext.client.data.Node;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.RequiredElementWidget;
import com.gwtext.client.widgets.tree.event.TreePanelListener;

//TODO very incomplete
public class TreePanel extends RequiredElementWidget {

    public TreePanel(String id) {
        this(id, null);
    }

    //todo drag zones

    public TreePanel(String id, TreePanelConfig config) {
        super(id, config);
    }

    protected native JavaScriptObject create(String id, JavaScriptObject config) /*-{
        return new $wnd.Ext.tree.TreePanel(id, config);
    }-*/;

    public String getId() {
        return id;
    }

    public TreeNode getNodeById(String id) {
        JavaScriptObject node = getNodeById(jsObj, id);
        if (node == null) {
            return null;
        } else {
            return new TreeNode(node);
        }
    }

    public native void setPathSeparator(String separator)/*-{
        var panel = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        panel.pathSeparator = separator;
    }-*/;

    public native void collapseAll() /*-{
        var panel = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        panel.collapseAll();
    }-*/;

    public native void expandAll() /*-{
        var panel = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        panel.expandAll();
    }-*/;

    public native void expandPath(String path, NodeExpansionCallback cb) /*-{
        var panel = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        if(cb == null) {
            panel.expandPath(path);
        } else {
            panel.expandPath(path, null, function(success, node) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                cb.@com.gwtext.client.widgets.tree.NodeExpansionCallback::onExpand(ZLcom/gwtext/client/widgets/tree/TreeNode;)(success, nodeJ);
            });
        }
    }-*/;

    public int[] getChecked() {
        JavaScriptObject arr = getChecked(jsObj);
        return JavaScriptObjectHelper.convertToJavaIntArray(arr);
    }

    private native JavaScriptObject getChecked(JavaScriptObject tree) /*-{
        return tree.getChecked();
    }-*/;

    public int[] getChecked(TreeNode startNode) {
        JavaScriptObject arr = getChecked(jsObj, startNode.getJsObj());
        return JavaScriptObjectHelper.convertToJavaIntArray(arr);
    }

    private native JavaScriptObject getChecked(JavaScriptObject tree, JavaScriptObject startNode) /*-{
        return tree.getChecked(startNode);
    }-*/;


    public native TreeLoader getLoader() /*-{
        var tree = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return @com.gwtext.client.widgets.tree.TreeLoader::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree.getLoader());
    }-*/;

    private native JavaScriptObject getNodeById(JavaScriptObject tree, String id) /*-{
        var node = tree.getNodeById(id);
        if(node === undefined) {
            return null;
        } else {
            return node;
        }
    }-*/;

    public Node getRootNode() {
        return new Node(getRootNode(jsObj));
    }

    private native JavaScriptObject getRootNode(JavaScriptObject tree) /*-{
        return tree.getRootNode();
    }-*/;

    public native void setRootNode(Node node) /*-{
        var tree = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var nodeJS = node.@com.gwtext.client.core.JsObject::jsObj;
        tree.setRootNode(nodeJS);
    }-*/;


    public native void render() /*-{
        var tree = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tree.render();
    }-*/;

    public native DefaultSelectionModel getSelectionModel() /*-{
        var tree = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var sm = tree.getSelectionModel();
        return @com.gwtext.client.widgets.tree.DefaultSelectionModel::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(sm);
    }-*/;

    //TODO
    //expandPath
    //getLoader
    //getSelctionModel
    //selectPath
    //getChecked

    //todo add rest

    public native void addTreePanelListener(TreePanelListener listener)/*-{
        var tree = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tree.addListener('click',
                 function(node, event) {
                    var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onClick(Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/core/EventObject;)(nodeJ, e);
			    }
          );
        tree.addListener('contextmenu',
                 function(node, event) {
                    var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onContextMenu(Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/core/EventObject;)(nodeJ, e);
			    }
          );
    }-*/;
}
