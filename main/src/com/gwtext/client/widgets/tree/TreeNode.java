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
import com.gwtext.client.widgets.tree.event.TreeNodeListener;

public class TreeNode extends Node {

    public TreeNode(final String text) {
        this(new TreeNodeConfig() {
            {
                setText(text);
            }
        });
    }

	public TreeNode(String text, TreeNodeConfig config) {
        this(config);
		setText(text);
	}

	TreeNode(JavaScriptObject jsObj) {
        super(jsObj);
    }

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

    public native void collapse() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.collapse();
    }-*/;

    public native void collapse(boolean deep, boolean anim) /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.collapse(deep, anim);
    }-*/;

    public native void collapseChildNodes(boolean deep) /*-{
            var node = this.@com.gwtext.client.core.JsObject::jsObj;
            node.collapseChildNodes(deep);
    }-*/;

    public native void disable() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.disable();
    }-*/;

    public native boolean isDisabled() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        return node.disabled;                    
    }-*/;

    public native void enable() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.enable();
    }-*/;

    public native void ensureVisible() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.ensureVisible();
    }-*/;

    public native void expand() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.expand();
    }-*/;

    //make sure tree is rendered before expand called
    //todo add callback
    public native void expand(boolean deep, boolean anim) /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.expand(deep, anim);
    }-*/;

    public native void expandChildNodes(boolean deep) /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.expandChildNodes(deep);
    }-*/;

    public native TreeNodeUI getUI() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        var ui = node.getUI();
        return @com.gwtext.client.widgets.tree.TreeNodeUI::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ui);
    }-*/;

    public native boolean isExpanded() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        return node.isExpanded();
    }-*/;

    public native boolean isSelected() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        return node.isSelected();
    }-*/;

    public native void select() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.select();
    }-*/;

    public native void setText(String text) /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.setText(text);
    }-*/;

	public native String getText() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        return node.text;
    }-*/;

    public native void toggle() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.toggle();
    }-*/;

    public native void unselect() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.unselect();
    }-*/;

    public native TreeNode clone() /*-{
       var nodeJS = this.@com.gwtext.client.core.JsObject::jsObj;
       var copy = new $wnd.Ext.tree.TreeNode(
                $wnd.Ext.apply({}, nodeJS.attributes)
            );
        copy.loader = undefined;
        var copyJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(copy);
        return copyJ;
    }-*/;

    public native TreeNode clone(TreeNodeConfig config) /*-{
       var nodeJS = this.@com.gwtext.client.core.JsObject::jsObj;
       var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
       var copy = new $wnd.Ext.tree.TreeNode(
                Ext.apply(configJS, nodeJS.attributes)
            );
        copy.loader = undefined;
        var copyJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(copy);
        return copyJ;
    }-*/;


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