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
 

package com.gwtext.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.data.event.NodeListener;
import com.gwtext.client.util.JavaScriptObjectHelper;

import java.util.Comparator;

/**
 * A data Node class.
 *
 * @author Sanjiv Jivan
 */
public class Node extends JsObject {

    protected JavaScriptObject configJS = JavaScriptObjectHelper.createObject();
    
    /**
     * Create a new Node instance.
     */
    public Node() {
    }

    public Node(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static Node instance(JavaScriptObject node) {
        return new Node(node);
    }

    protected native JavaScriptObject create(JavaScriptObject config)/*-{
        return new $wnd.Ext.data.Node(config);    
    }-*/;

    protected Node createNode(JavaScriptObject jsNode) {
        return new Node(jsNode);
    }

    public JavaScriptObject getJsObj() {
        if(jsObj == null) {
            jsObj = create(configJS);
            setUserObject(userObject);
        }
        return jsObj;
    }

    /**
     * Associate a user defined Object with the node.
     *
     * @param o the user data object
     */
    private native void setUserObjectCreated(Object o) /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        node.attributes._data = o;
    }-*/;

    /**
     * Return the user defined object associated with the node.
     *
     * @return the user defined object , null if not defined
     */
    private native Object getUserObjectCreated() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();

        //need to convert javascript undefined to null before passing to java layer
        if(node.attributes._data === undefined) {
            return null;
        } else {
            return node.attributes._data;
       }
    }-*/;

    private static native Object getUserObject(JavaScriptObject node) /*-{
        //need to convert javascript undefined to null before passing to java layer
        if(node.attributes._data === undefined) {
            return null;
        } else {
            return node.attributes._data;
       }
    }-*/;

    /**
     * Sets a attribute on the node.
     *
     * @param name  the attribute name
     * @param value the attribute value
     */
    public native void setAttribute(String name, Object value) /*-{
		var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
		node.attributes[name] = value;
	}-*/;

    /**
     * Sets a attribute on the node.
     *
     * @param name  the attribute name
     * @param value the attribute value
     */
    public native void setAttribute(String name, String value) /*-{
		var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
		node.attributes[name] = value;
	}-*/;

    protected native void setAttribute(String name, JavaScriptObject value) /*-{
		var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
		node.attributes[name] = value;
	}-*/;

    /**
     * Returns a node's attribute as String.
     *
     * @param name the attribute name
     * @return attribute value as String
     */
    public native String getAttribute(String name) /*-{
		var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
		var value = node.attributes[name];
		return value == null || value === undefined ? null : value.toString();
	}-*/;

    /**
     * Returns a node's Object attribute.
     *
     * @param name the attribute name
     * @return attribute value
     * @see #setAttribute(String, Object)
     */
    public native Object getAttributeAsObject(String name) /*-{
		var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
		var value = node.attributes[name];
		if (typeof(value)=='boolean') {
	      if(value==true) {
	        return @java.lang.Boolean::TRUE;
	      } else {
	        return @java.lang.Boolean::FALSE;
	      }			
		}
		return value === undefined ? null : value;
	}-*/;

    /**
     * Returns all child nodes of this node.
     *
     * @return node's child nodes, null if none present
     */
    public Node[] getChildNodes() {
        JavaScriptObject[] jsNodes = JavaScriptObjectHelper.getAttributeAsJavaScriptObjectArray(getJsObj(), "childNodes");
        if (jsNodes == null) return null;
        Node[] nodes = new Node[jsNodes.length];
        for (int i = 0; i < jsNodes.length; i++) {
            JavaScriptObject jsNode = jsNodes[i];
            nodes[i] = createNode(jsNode);
        }
        return nodes;
    }

    /**
     * Return the first direct child node of this node, or null if this node has no child nodes.
     *
     * @return the first child node
     */
    public native Node getFirstChild() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        if(node.firstChild == null || node.firstChild === undefined)  {
            return null;
        } else {
            return this.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(node.firstChild);
        }
    }-*/;

    /**
     * Return the node's ID.
     *
     * @return the node ID, null if not defined
     */
    public native String getId() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return node.id === undefined ? null : node.id.toString();
    }-*/;

    /**
     * Set the Node's ID.
     *
     * @param id the node ID
     */
    private native void setIdCreated(String id) /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        node.id = id;
    }-*/;

    /**
     * return the last direct child node of this node, or null if this node has no child nodes.
     *
     * @return the last child node
     */
    public native Node getLastChild() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        if(node.lastChild == null || node.lastChild === undefined)  {
            return null;
        } else {
            return this.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(node.lastChild);
        }
    }-*/;

    /**
     * Return the node immediately following this node in the tree, or null if there is no sibling node.
     *
     * @return this nodes next sibling
     */
    public native Node getNextSibling() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        if(node.nextSibling == null || node.nextSibling === undefined)  {
            return null;
        } else {
            return this.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(node.nextSibling);
        }
    }-*/;

    /**
     * The parent node for this node.
     *
     * @return the parent node, null if root node
     */
    public native Node getParentNode() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        if(node.parentNode == null || node.parentNode === undefined)  {
            return null;
        } else {
            return this.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(node.parentNode);
        }
    }-*/;

    /**
     * Return the node immediately preceding this node in the tree, or null if there is no sibling node.
     *
     * @return this nodes previosu sibling
     */
    public native Node getPreviousSibling() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        if(node.previousSibling == null || node.previousSibling === undefined)  {
            return null;
        } else {
            return this.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(node.previousSibling);
        }
    }-*/;

    /**
     * Insert node as the last child node of this node.
     *
     * @param child node to append
     */
    public native void appendChild(Node child) /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var childJS = child.@com.gwtext.client.core.JsObject::getJsObj()();
        node.appendChild(childJS);
    }-*/;

    /**
     * Bubbles up the tree from this node, calling the specified function with each node. If the callback method returns false at
     * any point, the bubble is stopped.
     *
     * @param cb the callback function handle
     */
    public native void bubble(NodeTraversalCallback cb)/*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
                  var nodeJ = this;
                  node.bubble(function(n) {
                      var nj = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
                      return cb.@com.gwtext.client.data.NodeTraversalCallback::execute(Lcom/gwtext/client/data/Node;)(nj);
            });
    }-*/;

    /**
     * Cascades down the tree from this node, calling the specified function with each node. If the callback method returns
     * false at any point, the cascade is stopped on that branch.
     *
     * @param cb the callback function handle
     */
    public native void cascade(NodeTraversalCallback cb)/*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
             var nodeJ = this;
             node.cascade(function(n) {
                 var nj = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
                 return cb.@com.gwtext.client.data.NodeTraversalCallback::execute(Lcom/gwtext/client/data/Node;)(nj);
             });
    }-*/;

    /**
     * Returns true if this node is an ancestor (at any point) of the passed node.
     *
     * @param child the node
     * @return true if contains
     */
    public native boolean contains(Node child) /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var childJS = child.@com.gwtext.client.core.JsObject::getJsObj()();
        return node.contains(childJS);
    }-*/;

    /**
     * Interates the child nodes of this node, calling the specified function with each node. If the callback function
     * returns false at any point, the iteration stops.
     *
     * @param cb the callback function handle
     */
    public native void eachChild(NodeTraversalCallback cb)/*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
             var nodeJ = this;
             node.eachChild(function(n) {
                 var nj = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
                 return cb.@com.gwtext.client.data.NodeTraversalCallback::execute(Lcom/gwtext/client/data/Node;)(nj);
             });
         }-*/;

    //skipping findChild in favor of more powerful and flexible findChildBy API
    /**
     * Finds the first child by a custom callback function. The child matches if the function passed returns true.
     *
     * @param cb the callback function handle
     * @return the child or null if not found
     */
    public native Node findChildBy(NodeTraversalCallback cb)/*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var nodeJ = this;
        var nodeC = node.findChildBy(function(n) {
                 var nj = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
                 return cb.@com.gwtext.client.data.NodeTraversalCallback::execute(Lcom/gwtext/client/data/Node;)(nj);
        });
        return nodeC == null ? null : nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodeC);
    }-*/;

    /**
     * Returns depth of this node (the root node has a depth of 0).
     *
     * @return the depth of this node
     */
    public native int getDepth() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return node.getDepth();
    }-*/;

    /**
     * Returns the tree this node is in.
     *
     * @return the owner tree
     */
    public native Tree getOwnerTree()/*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var treeJS = node.getOwnerTree();
        return treeJS == null ? null : @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(treeJS);
    }-*/;

    /**
     * Returns the path for this node. The path can be used to expand or select this node programmatically.
     *
     * @return the path
     */
    public native String getPath() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return node.getPath();
    }-*/;

    /**
     * Returns the path for this node. The path can be used to expand or select this node programmatically.
     *
     * @param attr the attr to use for the path (defaults to the node's id)
     * @return the path
     */
    public native String getPath(String attr) /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return node.getPath(attr);
    }-*/;

    /**
     * Returns the index of a child node.
     *
     * @param child the child node
     * @return the index of the node or -1 if it was not found
     */
    public native int indexOf(Node child) /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var childJS = child.@com.gwtext.client.core.JsObject::getJsObj()();
        return node.indexOf(childJS);
    }-*/;

    /**
     * Inserts the first node before the second node in this nodes childNodes collection.
     *
     * @param node    the node to insert
     * @param nodeRef the node to insert before (if null the node is appended)
     * @return the inserted node
     */
    public native Node insertBefore(Node node, Node nodeRef) /*-{
        var self = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var node1 = node.@com.gwtext.client.core.JsObject::getJsObj()();
        var node2 = nodeRef.@com.gwtext.client.core.JsObject::getJsObj()();
        self.insertBefore(node1, node2);
        return node;
    }-*/;

    /**
     * Returns true if the passed node is an ancestor (at any point) of this node.
     *
     * @param node the node to test
     * @return true of ancestor
     */
    public native boolean isAncestor(Node node) /*-{
        var self = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var nodeJS = node.@com.gwtext.client.core.JsObject::getJsObj()();
        return self.isAncestor(nodeJS);
    }-*/;

    /**
     * Returns true if this node is the first child of its parent.
     *
     * @return true if first node
     */
    public native boolean isFirst() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return node.isFirst();
    }-*/;

    /**
     * Returns true if this node is the last child of its parent.
     *
     * @return true if last
     */
    public native boolean isLast() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return node.isLast();
    }-*/;

    /**
     * Returns true if this node is a leaf.
     *
     * @return true if leaf node
     */
    public native boolean isLeaf() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return node.isLeaf();
    }-*/;

    /**
     * Returns the child node at the specified index.
     *
     * @param index the index
     * @return the child at index, null if none present
     */
    public native Node item(int index)/*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var itemNode = node.item(index);
        if(itemNode == null || itemNode === undefined) return null;
        return this.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(itemNode);
    }-*/;

    /**
     * Removes this node from it's parent.
     */
    public native void remove() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        node.remove();
    }-*/;

    /**
     * Removes a child node from this node.
     *
     * @param child the node to remove
     * @return the removed node
     */
    public native Node removeChild(Node child) /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var childJS = child.@com.gwtext.client.core.JsObject::getJsObj()();
        var nodeRemoved = node.removeChild(childJS);
        if(nodeRemoved == null || nodeRemoved === undefined) return null;
        return this.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodeRemoved);
    }-*/;

    /**
     * Replaces one child node in this node with another.
     *
     * @param newChild the replacement node
     * @param oldChild the node to replace
     * @return the replaced node
     */
    public native Node replaceChild(Node newChild, Node oldChild) /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var newChildJS = newChild.@com.gwtext.client.core.JsObject::getJsObj()();
        var oldChildJS = oldChild.@com.gwtext.client.core.JsObject::getJsObj()();
        var nodeReplaced = node.replaceChild(newChildJS, oldChildJS);
        if(nodeReplaced == null || nodeReplaced === undefined) return null;
        return this.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodeReplaced);
    }-*/;

    /**
     * Sorts this nodes children using the supplied sort function.
     *
     * @param c the Comparator return 0 if equal, -1 if first node less than second, 1 if first greater than second
     */
    public native void sort(Comparator c) /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var nodeJ = this;
        node.sort(function(n1, n2) {
            var n1J = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(n1);
            var n2J = nodeJ.@com.gwtext.client.data.Node::createNode(Lcom/google/gwt/core/client/JavaScriptObject;)(n2);
            return c.@java.util.Comparator::compare(Ljava/lang/Object;Ljava/lang/Object;)(n1J, n2J);
        })
    }-*/;

    /**
     * Add a Node listener.
     *
     * @param listener the listener
     */
    public native void addListener(NodeListener listener) /*-{
        
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
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

    //config options

    private Object userObject;

    /**
     * Associate a user defined Object with the node.
     *
     * @param userObject the user data object
     */
    public void setUserObject(Object userObject) {
        if(!isCreated()) {
            this.userObject = userObject;
        } else {
            setUserObjectCreated(userObject);
        }
    }

    /**
     * Return the user defined object
     *
     * @return the user defined object
     */
    public Object getUserObject() {
        if(!isCreated()) {
            return userObject;
        } else {
            return  getUserObjectCreated();
        }
    }

    /**
     * Set the Node's ID.
     *
     * @param id the node ID
     */
    public void setId(String id) {
        if(!isCreated()) {
            JavaScriptObjectHelper.setAttribute(configJS, "id", id);
        } else {
            setIdCreated(id);
        }
    }

    /**
     * Sets whether the node is a leaf.
     *
     * @param leaf true if leaf
     */
    public void setLeaf(boolean leaf) {
        JavaScriptObjectHelper.setAttribute(configJS, "leaf", leaf);
    }
}
