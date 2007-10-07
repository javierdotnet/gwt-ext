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
import com.gwtext.client.data.event.NodeListener;
import com.gwtext.client.util.JavaScriptObjectHelper;

import java.util.Comparator;

public class Node extends JsObject {
   
    public Node(NodeConfig config) {
        jsObj = create(config.getJsObj());
    }

    public Node(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static Node instance(JavaScriptObject node) {
        return new Node(node);
    }

    protected native JavaScriptObject create(JavaScriptObject config)/*-{
        return new $wnd.Ext.data.Node(config);    
    }-*/;

    protected Node createNode(JavaScriptObject jsNode) {
        return new Node(jsNode);
    }

    public native void setUserObject(Object o) /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.attributes.data = o;
    }-*/;

    public native Object getUserObject() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;

        //need to convert javascript undefined to null before passing to java layer
        if(node.attributes.data === undefined) {
            return null;
        } else {
            return node.attributes.data;
       }
    }-*/;

	public native void setAttribute(String name, String value) /*-{
		var node = this.@com.gwtext.client.core.JsObject::jsObj;
		node.attributes[name] = value;
	}-*/;
			
	protected native void setAttribute(String name, JavaScriptObject value) /*-{
		var node = this.@com.gwtext.client.core.JsObject::jsObj;
		node.attributes[name] = value;
	}-*/;

	public native String getAttribute(String name) /*-{
		var node = this.@com.gwtext.client.core.JsObject::jsObj;
		var value = node.attributes[name];
		return value === undefined ? null : value;
	}-*/;

	private static native Object getUserObject(JavaScriptObject node) /*-{
        //need to convert javascript undefined to null before passing to java layer
        if(node.attributes.data === undefined) {
            return null;
        } else {
            return node.attributes.data;
       }
    }-*/;

    public Node[] getChildNodes() {
        JavaScriptObject[] jsNodes = JavaScriptObjectHelper.getAttributeAsJavaScriptObjectArray(jsObj, "childNodes");
        if(jsNodes == null) return null;
        Node[] nodes = new Node[jsNodes.length];
        for (int i = 0; i < jsNodes.length; i++) {
            JavaScriptObject jsNode = jsNodes[i];
            nodes[i] = createNode(jsNode);
        }
        return nodes;
    }

    public native Node getFirstChild() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        if(node.firstChild == null || node.firstChild === undefined)  {
            return null;
        } else {
            return this.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(node.firstChild);
        }
    }-*/;

    public native String getId() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        return node.id;
    }-*/;

    public native void setId(String id) /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.id = id;
    }-*/;

	public native Node getLastChild() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        if(node.lastChild == null || node.lastChild === undefined)  {
            return null;
        } else {
            return this.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(node.lastChild);
        }
    }-*/;

    public native Node getNextSibling() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        if(node.nextSibling == null || node.nextSibling === undefined)  {
            return null;
        } else {
            return this.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(node.nextSibling);
        }
    }-*/;

    public native Node getParentNode() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        if(node.parentNode == null || node.parentNode === undefined)  {
            return null;
        } else {
            return this.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(node.parentNode);
        }
    }-*/;

    public native Node getPreviousSibling() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        if(node.previousSibling == null || node.previousSibling === undefined)  {
            return null;
        } else {
            return this.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(node.previousSibling);
        }
    }-*/;

    public native void appendChild(Node child) /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        var childJS = child.@com.gwtext.client.core.JsObject::jsObj;
        node.appendChild(childJS);
    }-*/;

    public native void bubble(NodeTraversalCallback cb)/*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
                  var nodeJ = this;
                  node.bubble(function(n) {
                      var nj = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
                      return cb.@com.gwtext.client.data.NodeTraversalCallback::execute(Lcom/gwtext/client/data/Node;)(nj);
                  });
              }-*/;

    public native void cascade(NodeTraversalCallback cb)/*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
             var nodeJ = this;
             node.cascade(function(n) {
                 var nj = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
                 return cb.@com.gwtext.client.data.NodeTraversalCallback::execute(Lcom/gwtext/client/data/Node;)(nj);
             });
         }-*/;

    public native boolean contains(Node child) /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        var childJS = child.@com.gwtext.client.core.JsObject::jsObj;
        return node.contains(childJS);
    }-*/;

    public native void eachChild(NodeTraversalCallback cb)/*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
             var nodeJ = this;
             node.eachChild(function(n) {
                 var nj = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
                 return cb.@com.gwtext.client.data.NodeTraversalCallback::execute(Lcom/gwtext/client/data/Node;)(nj);
             });
         }-*/;

    //skipping findChild in favor of more powerful and flexible findChildBy API
    public native void findChildBy(NodeTraversalCallback cb)/*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
             var nodeJ = this;
             node.findChildBy(function(n) {
                 var nj = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
                 return cb.@com.gwtext.client.data.NodeTraversalCallback::execute(Lcom/gwtext/client/data/Node;)(nj);
             });
         }-*/;

    public native int getDepth() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        return node.getDepth();
    }-*/;

    public native Tree getOwnerTree()/*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        var treeJS = node.getOwnerTree();
        return @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(treeJS);
    }-*/;

    public native String getPath() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        return node.getPath();
    }-*/;

    public native String getPath(String attr) /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        return node.getPath(attr);
    }-*/;

    public native int indexOf(Node child) /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        var childJS = child.@com.gwtext.client.core.JsObject::jsObj;
        return node.indexOf(childJS);
    }-*/;

    public native Node insertBefore(Node node, Node nodeRef) /*-{
        var self = this.@com.gwtext.client.core.JsObject::jsObj;
        var node1 = node.@com.gwtext.client.core.JsObject::jsObj;
        var node2 = nodeRef.@com.gwtext.client.core.JsObject::jsObj;
        self.insertBefore(node1, node2);
        return node;
    }-*/;

    public native boolean isAncestor(Node node) /*-{
        var self = this.@com.gwtext.client.core.JsObject::jsObj;
        var nodeJS = node.@com.gwtext.client.core.JsObject::jsObj;
        return self.isAncestor(nodeJS);
    }-*/;

    public native boolean isFirst() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        return node.isFirst();
    }-*/;

    public native boolean isLast() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        return node.isLast();
    }-*/;

    public native boolean isLeaf() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        return node.isLeaf();
    }-*/;

    public native Node item(int index)/*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        var itemNode = node.item(index);
        if(itemNode == null || itemNode === undefined) return null;
        return this.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(itemNode);
    }-*/;

    public native Node removeChild(Node child) /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        var childJS = child.@com.gwtext.client.core.JsObject::jsObj;
        var nodeRemoved = node.removeChild(childJS);
        if(nodeRemoved == null || nodeRemoved === undefined) return null;
        return this.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodeRemoved);
    }-*/;

    public native Node replaceChild(Node newChild, Node oldChild) /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        var newChildJS = newChild.@com.gwtext.client.core.JsObject::jsObj;
        var oldChildJS = oldChild.@com.gwtext.client.core.JsObject::jsObj;
        var nodeReplaced = node.replaceChild(newChildJS, oldChildJS);
        if(nodeReplaced == null || nodeReplaced === undefined) return null;
        return this.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodeReplaced);
    }-*/;

    //todo test
    public native void sort(Comparator c) /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        var nodeJ = this;
        node.sort(function(n1, n2) {
            var n1J = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(n1);
            var n2J = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(n2);
            c.@java.util.Comparator::compare(Ljava/lang/Object;Ljava/lang/Object;)(n1J, n2J);
        })
    }-*/;

    public native void addNodeListener(NodeListener listener) /*-{
	    var node = this.@com.gwtext.client.core.JsObject::jsObj;
        var nodeJ = this;

		node.addListener('append',
					function(tree, self, newNode, index) {
						var treeJ = @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree);
						var newNodeJ = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(newNode);
						listener.@com.gwtext.client.data.event.NodeListener::onAppend(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;I)(treeJ, nodeJ, newNodeJ, index);
					}
		);

		node.addListener('beforeappend',
					function(tree, self, newNode) {
						var treeJ = @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree);
						var newNodeJ = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(newNode);
						return listener.@com.gwtext.client.data.event.NodeListener::doBeforeAppend(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;)(treeJ, nodeJ, newNodeJ);
					}
		);

		node.addListener('beforeinsert',
					function(tree, self, newNode, refNode) {
						var treeJ = @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree);
						var newNodeJ = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(newNode);
						var refNodeJ = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(refNode);
						return listener.@com.gwtext.client.data.event.NodeListener::doBeforeInsert(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;)(treeJ, nodeJ, newNodeJ, refNodeJ);
					}
		);

		node.addListener('beforemove',
					function(tree, self, oldParent, newParent, index) {
						var treeJ = @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree);
						var oldParentJ = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(oldParent);
						var newParentJ = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(newParent);
						return listener.@com.gwtext.client.data.event.NodeListener::doBeforeMove(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;I)(treeJ, nodeJ, oldParentJ, newParentJ, index);
					}
		);

		node.addListener('beforeremove',
					function(tree, self, removeNode) {
						var treeJ = @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree);
						var removeNodeJ = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(removeNode);
						return listener.@com.gwtext.client.data.event.NodeListener::doBeforeRemove(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;)(treeJ, nodeJ, removeNodeJ);
					}
		);

		node.addListener('insert',
					function(tree, self, newNode, refNode) {
						var treeJ = @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree);
						var newNodeJ = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(newNode);
						var refNodeJ = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(refNode);
						listener.@com.gwtext.client.data.event.NodeListener::onInsert(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;)(treeJ, nodeJ, newNodeJ, refNodeJ);
					}
		);

		node.addListener('move',
					function(tree, self, oldParent, newParent, index) {
						var treeJ = @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree);
						var oldParentJ = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(oldParent);
						var newParentJ = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(newParent);
						listener.@com.gwtext.client.data.event.NodeListener::onMove(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;I)(treeJ, nodeJ, oldParentJ, newParentJ, index);
					}
		);

		node.addListener('remove',
					function(tree, self, removeNode) {
						var treeJ = @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree);
						var removeNodeJ = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(removeNode);
						listener.@com.gwtext.client.data.event.NodeListener::onRemove(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/data/Node;Lcom/gwtext/client/data/Node;)(treeJ, nodeJ, removeNodeJ);
					}
		);
	 }-*/;

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Node)) return false;

        Node node = (Node) o;
        String id = getId();
        String oid = node.getId();
        if (id != null ? !id.equals(oid) : oid != null) return false;
        return true;
    }

    public int hashCode() {
        String id = getId();
        return (id != null ? id.hashCode() : 0);
    }
}
