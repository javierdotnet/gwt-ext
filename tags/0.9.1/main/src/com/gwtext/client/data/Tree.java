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

package com.gwtext.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.data.event.TreeListener;

public class Tree extends JsObject {

    public Tree() {
        jsObj = create();
    }

    Tree(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static Tree instance(JavaScriptObject treeJS) {
        return new Tree(treeJS);
    }

    private native JavaScriptObject create()/*-{
        return new $wnd.Ext.data.Tree();
    }-*/;

    public Node getNodeById(String id) {
        JavaScriptObject node = getNodeById(jsObj, id);
        return node == null ? null : new Node(node);
    }

    private native JavaScriptObject getNodeById(JavaScriptObject tree, String id) /*-{
        return tree.getNodeById(id);
    }-*/;

    public Node getRootNode() {
        JavaScriptObject root = getRootNode(jsObj);
        return root == null ? null : new Node(root);
    }

    private native JavaScriptObject getRootNode(JavaScriptObject tree) /*-{
        return tree.getRootNode();
    }-*/;

    public native void setRootNode(Node node) /*-{
        var tree = this.@com.gwtext.client.core.JsObject::jsObj;
        var nodeJS = node.@com.gwtext.client.core.JsObject::jsObj;
        tree.setRootNode(nodeJS);
    }-*/;

    public native void addNodeListener(TreeListener listener) /*-{
	    var tree = this.@com.gwtext.client.core.JsObject::jsObj;
        var treeJ = this;

		tree.addListener('append',
					function(tree, parent, node, index) {
						var parentJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(parent);
						var nodeJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
						listener.@com.gwtext.client.data.event.TreeListener::onAppend(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;I)(treeJ, parentJ, nodeJ, index);
					}
		);

		tree.addListener('beforeappend',
					function(tree, parent, node) {
                        var parentJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(parent);
						var nodeJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
						return listener.@com.gwtext.client.data.event.TreeListener::doBeforeAppend(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;)(treeJ, parentJ, nodeJ);
					}
		);

        tree.addListener('beforeinsert',
					function(tree, parent, node, refNode) {
                        var parentJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(parent);
						var nodeJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
						var refNodeJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(refNode);
						return listener.@com.gwtext.client.data.event.TreeListener::doBeforeInsert(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;)(treeJ, parentJ, nodeJ, refNodeJ);
					}
		);

        tree.addListener('beforemove',
					function(tree, node, oldParent, newParent, index) {
                        var nodeJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                        var oldParentJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(oldParent);
                        var newParentJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(newParent);

						return listener.@com.gwtext.client.data.event.TreeListener::doBeforeMove(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;I)(treeJ, nodeJ, oldParentJ, newParentJ, index);
					}
		);

        tree.addListener('beforeremove',
					function(tree, parent, node) {
                        var parentJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(parent);
						var nodeJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
						return listener.@com.gwtext.client.data.event.TreeListener::doBeforeRemove(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;)(treeJ, parentJ, nodeJ);
					}
		);

        tree.addListener('insert',
					function(tree, parent, node, refNode) {
                        var parentJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(parent);
						var nodeJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                        var refNodeJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(refNode);
                        listener.@com.gwtext.client.data.event.TreeListener::onInsert(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;)(treeJ, parentJ, nodeJ, refNodeJ);
					}
		);

        tree.addListener('move',
					function(tree, node, oldParent, newParent, index) {
                        var nodeJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                        var oldParentJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(oldParent);
                        var newParentJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(newParent);

						listener.@com.gwtext.client.data.event.TreeListener::onMove(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;I)(treeJ, nodeJ, oldParentJ, newParentJ, index);
					}
		);

        tree.addListener('remove',
					function(tree, parent, node) {
                        var parentJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(parent);
						var nodeJ = @com.gwtext.client.data.Node::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
						listener.@com.gwtext.client.data.event.TreeListener::onRemove(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;)(treeJ, parentJ, nodeJ);
					}
		);
     }-*/;
}
