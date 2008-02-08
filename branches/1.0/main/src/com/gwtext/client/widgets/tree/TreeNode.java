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
import com.gwtext.client.data.Node;
import com.gwtext.client.widgets.tree.event.TreeNodeListener;

/**
 * TreeNode class.
 *
 * @see com.gwtext.client.widgets.tree.TreePanel
 */
public class TreeNode extends Node {

	/**
	 * Create a new TreeNode.
	 *
	 * @param text the text / label of the TreeNode
	 */
	public TreeNode(final String text) {
        this(new TreeNodeConfig() {
            {
                setText(text);
            }
        });
    }

	/**
	 * Create a new TreeNode.
	 *
	 * @param text the text / label of the TreeNode
	 * @param config the TreeNode config
	 */
	public TreeNode(String text, TreeNodeConfig config) {
        this(config);
		setText(text);
	}

	TreeNode(JavaScriptObject jsObj) {
        super(jsObj);
    }

	/**
	 * Create a new TreeNode.
	 *
	 * @param config the TreeNode config
	 */
	public TreeNode(TreeNodeConfig config) {
        super(config);
    }

    public static Node instance(JavaScriptObject jsObj) {
        return new TreeNode(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config)/*-{
        return new $wnd.Ext.tree.TreeNode(config);
    }-*/;

    protected Node createNode(JavaScriptObject jsNode) {
        return new TreeNode(jsNode);
    }

	/**
	 * Collapse this node.
	 */
	public native void collapse() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.collapse();
    }-*/;

	/**
	 * Collapse this node.
	 *
	 * @param deep true to collapse all children as well
	 * @param anim false to disable the default animation
	 */
	public native void collapse(boolean deep, boolean anim) /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.collapse(deep, anim);
    }-*/;

	/**
	 * Collapse all child nodes.
	 *
	 * @param deep true if the child nodes should also collapse their child nodes
	 */
	public native void collapseChildNodes(boolean deep) /*-{
       var node = this.@com.gwtext.client.core.JsObject::jsObj;
       node.collapseChildNodes(deep);
    }-*/;

	/**
	 * Disables this node.
	 */
	public native void disable() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.disable();
    }-*/;

	/**
	 * True if this node is disabled.
	 *
	 * @return true if disabled
	 */
	public native boolean isDisabled() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        return node.disabled;                    
    }-*/;

	/**
	 * Enables this node.
	 */
	public native void enable() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.enable();
    }-*/;

	/**
	 * Ensures all parent nodes are expanded.
	 */
	public native void ensureVisible() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.ensureVisible();
    }-*/;

	/**
	 * Expand this node. The tree must be rendered before this method is called.
	 */
	public native void expand() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.expand();
    }-*/;

    //make sure tree is rendered before expand called
    //todo add callback
	/**
	 * Expand this node. The tree must be rendered before this method is called.
	 *
	 * @param deep true to expand all children as well
	 * @param anim false to cancel the default animation
	 */
	public native void expand(boolean deep, boolean anim) /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.expand(deep, anim);
    }-*/;

	/**
	 * Expand this node. The tree must be rendered before this method is called.
	 *
	 * @param deep true to expand all children as well
	 * @param anim false to cancel the default animation
	 * @param callback a callback to be called when expanding this node completes (does not wait for deep expand to complete)
	 */
	public native void expand(boolean deep, boolean anim, Function callback) /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.expand(deep, anim, function(self) {
			callback.@com.gwtext.client.core.Function::execute()();
		});
    }-*/;

	/**
	 * Expand all child nodes.
	 * 
	 * @param deep true if the child nodes should also expand their child nodes
	 */
	public native void expandChildNodes(boolean deep) /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.expandChildNodes(deep);
    }-*/;

	/**
	 * Returns the UI object for this node.
	 *
	 * @return the TreeNodeUI
	 */
	public native TreeNodeUI getUI() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        var ui = node.getUI();
        return @com.gwtext.client.widgets.tree.TreeNodeUI::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ui);
    }-*/;

	/**
	 * Returns true if this node is expanded.
	 *
	 * @return true if expanded
	 */
	public native boolean isExpanded() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        return node.isExpanded();
    }-*/;

	/**
	 * Returns true if this node is selected.
	 *
	 * @return true if selected
	 */
	public native boolean isSelected() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        return node.isSelected();
    }-*/;

	/**
	 * Triggers selection of this node.
	 */
	public native void select() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.select();
    }-*/;

	/**
	 * Sets the text for this node.
	 * 
	 * @param text the node text
	 */
	public native void setText(String text) /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.setText(text);
    }-*/;

	/**
	 * Return the nodes text.
	 *
	 * @return the nodes text
	 */
	public native String getText() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        return node.text;
    }-*/;

	/**
	 * Toggles expanded/collapsed state of the node.
	 */
	public native void toggle() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.toggle();
    }-*/;

	/**
	 * Triggers deselection of this node.
	 */
	public native void unselect() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.unselect();
    }-*/;

	/**
	 * Clones this TreeNode.
	 *
	 * @return the cloned node
	 */
	public native TreeNode cloneNode() /*-{
       var nodeJS = this.@com.gwtext.client.core.JsObject::jsObj;
       var copy = new $wnd.Ext.tree.TreeNode(
                $wnd.Ext.apply({}, nodeJS.attributes)
            );
        copy.loader = undefined;
        var copyJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(copy);
        return copyJ;
    }-*/;

	/**
	 * Clones this TreeNode applying the specified configuration to the cloned node.
	 *
	 * @param config the cloned node config
	 * @return the cloned node
	 */
	public native TreeNode cloneNode(TreeNodeConfig config) /*-{
       var nodeJS = this.@com.gwtext.client.core.JsObject::jsObj;
       var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
       var copy = new $wnd.Ext.tree.TreeNode(
                $wnd.Ext.apply(nodeJS.attributes, configJS)
            );
        copy.loader = undefined;
        var copyJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(copy);
        return copyJ;
    }-*/;

	/**
	 * Adds a TreeNode listener.
	 *
	 * @param listener the listener
	 */
    public native void addTreeNodeListener(TreeNodeListener listener)/*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        var nodeJ = this;

         node.addListener('beforechildrenrendered',
                 function(source) {
                    return listener.@com.gwtext.client.widgets.tree.event.TreeNodeListener::doBeforeChildrenRendered(Lcom/gwtext/client/data/Node;)(nodeJ);
			    }
          );

         node.addListener('beforeclick',
                 function(source, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    return listener.@com.gwtext.client.widgets.tree.event.TreeNodeListener::doBeforeClick(Lcom/gwtext/client/data/Node;Lcom/gwtext/client/core/EventObject;)(nodeJ, e);
			    }
          );

         node.addListener('beforecollapse',
                 function(source, deep, anim) {
                    if(deep == null || deep === undefined) deep = false;
                    if(anim == null || anim === undefined) anim = false;
                    return listener.@com.gwtext.client.widgets.tree.event.TreeNodeListener::doBeforeCollapse(Lcom/gwtext/client/data/Node;ZZ)(nodeJ, deep, anim);
			    }
          );

         node.addListener('beforeexpand',
                 function(source, deep, anim) {
                    if(deep == null || deep === undefined) deep = false;
                    if(anim == null || anim === undefined) anim = false;
                    return listener.@com.gwtext.client.widgets.tree.event.TreeNodeListener::doBeforeExpand(Lcom/gwtext/client/data/Node;ZZ)(nodeJ, deep, anim);
			    }
          );

        node.addListener('beforecheckchange',
                 function(source, checked) {
                    return listener.@com.gwtext.client.widgets.tree.event.TreeNodeListener::doBeforeCheckChanged(Lcom/gwtext/client/data/Node;Z)(nodeJ, checked);
			    }
          );

        node.addListener('click',
                 function(source, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.tree.event.TreeNodeListener::onClick(Lcom/gwtext/client/data/Node;Lcom/gwtext/client/core/EventObject;)(nodeJ, e);
			    }
          );

         node.addListener('collapse',
                 function(source) {
                    return listener.@com.gwtext.client.widgets.tree.event.TreeNodeListener::onCollapse(Lcom/gwtext/client/data/Node;)(nodeJ);
			    }
          );

         node.addListener('contextmenu',
                 function(source, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.tree.event.TreeNodeListener::onContextMenu(Lcom/gwtext/client/data/Node;Lcom/gwtext/client/core/EventObject;)(nodeJ, e);
			    }
          );

         node.addListener('dblclick',
                 function(source, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.tree.event.TreeNodeListener::onDblClick(Lcom/gwtext/client/data/Node;Lcom/gwtext/client/core/EventObject;)(nodeJ, e);
			    }
          );

         node.addListener('disabledchange',
                 function(source, disabled) {
                    listener.@com.gwtext.client.widgets.tree.event.TreeNodeListener::onDisabledChange(Lcom/gwtext/client/data/Node;Z)(nodeJ, disabled);
			    }
          );

         node.addListener('expand',
                 function(source) {
                    return listener.@com.gwtext.client.widgets.tree.event.TreeNodeListener::onExpand(Lcom/gwtext/client/data/Node;)(nodeJ);
			    }
          );

         node.addListener('textchange',
                 function(source, text, oldText) {
                    if(oldText === undefined) oldText = null;
                    return listener.@com.gwtext.client.widgets.tree.event.TreeNodeListener::onTextChange(Lcom/gwtext/client/data/Node;Ljava/lang/String;Ljava/lang/String;)(nodeJ, text, oldText);
			    }
          );
    }-*/;
}