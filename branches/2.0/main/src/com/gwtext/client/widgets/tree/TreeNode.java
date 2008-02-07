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
import com.gwtext.client.data.Node;
import com.gwtext.client.widgets.tree.event.TreeNodeListener;
import com.gwtext.client.widgets.QuickTipsConfig;
import com.gwtext.client.widgets.QuickTip;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * TreeNode class.
 *
 * @see com.gwtext.client.widgets.tree.TreePanel
 */
public class TreeNode extends Node {

    /**
     * Create a new TreeNode.
     */
    public TreeNode() {
    }

    /**
     * Create a new TreeNode.
     *
     * @param text the text / label of the TreeNode
     */
    public TreeNode(final String text) {
        setText(text);
    }

    TreeNode(JavaScriptObject jsObj) {
        super(jsObj);
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
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        node.collapse();
    }-*/;

    /**
     * Collapse this node.
     *
     * @param deep true to collapse all children as well
     * @param anim false to disable the default animation
     */
    public native void collapse(boolean deep, boolean anim) /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        node.collapse(deep, anim);
    }-*/;

    /**
     * Collapse all child nodes.
     *
     * @param deep true if the child nodes should also collapse their child nodes
     */
    public native void collapseChildNodes(boolean deep) /*-{
       var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
       node.collapseChildNodes(deep);
    }-*/;

    /**
     * Disables this node.
     */
    public native void disable() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        node.disable();
    }-*/;

    /**
     * True if this node is disabled.
     *
     * @return true if disabled
     */
    public native boolean isDisabled() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return node.disabled;                    
    }-*/;

    /**
     * Enables this node.
     */
    public native void enable() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        node.enable();
    }-*/;

    /**
     * Ensures all parent nodes are expanded.
     */
    public native void ensureVisible() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        node.ensureVisible();
    }-*/;

    /**
     * Expand this node. The tree must be rendered before this method is called.
     */
    public native void expand() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
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
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        node.expand(deep, anim);
    }-*/;

    /**
     * Expand this node. The tree must be rendered before this method is called.
     *
     * @param deep     true to expand all children as well
     * @param anim     false to cancel the default animation
     * @param callback a callback to be called when expanding this node completes (does not wait for deep expand to complete)
     */
    public native void expand(boolean deep, boolean anim, Function callback) /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
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
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        node.expandChildNodes(deep);
    }-*/;

    /**
     * Returns the UI object for this node.
     *
     * @return the TreeNodeUI
     */
    public native TreeNodeUI getUI() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var ui = node.getUI();
        return @com.gwtext.client.widgets.tree.TreeNodeUI::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ui);
    }-*/;

    /**
     * Returns true if this node is expanded.
     *
     * @return true if expanded
     */
    public native boolean isExpanded() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return node.isExpanded();
    }-*/;

    /**
     * Returns true if this node is selected.
     *
     * @return true if selected
     */
    public native boolean isSelected() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return node.isSelected();
    }-*/;

    /**
     * Triggers selection of this node.
     */
	public void select() {
		if(getOwnerTree() != null) {
			selectRendered();
		}
	}
	
	private native void selectRendered() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        node.select();
    }-*/;

    /**
     * Sets the text for this node.
     *
     * @param text the node text
     */
    private native void setTextCreated(String text) /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        node.setText(text);
    }-*/;

    /**
     * Return the nodes text.
     *
     * @return the nodes text
     */
    public native String getText() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return node.text;
    }-*/;

    /**
     * Toggles expanded/collapsed state of the node.
     */
    public native void toggle() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        node.toggle();
    }-*/;

    /**
     * Triggers deselection of this node.
     */
    public native void unselect() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        node.unselect();
    }-*/;

    /**
     * Clones this TreeNode.
     *
     * @return the cloned node
     */
    public native TreeNode cloneNode() /*-{
       var nodeJS = this.@com.gwtext.client.core.JsObject::getJsObj()();
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
    public native TreeNode cloneNode(TreeNode config) /*-{
       var nodeJS = this.@com.gwtext.client.core.JsObject::getJsObj()();
       var configJS = config.@com.gwtext.client.core.JsObject::getJsObj()();
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
    public native void addListener(TreeNodeListener listener)/*-{
        this.@com.gwtext.client.data.Node::addListener(Lcom/gwtext/client/data/event/NodeListener;)(listener);
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
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


    //config
   /**
     * False to make this node undraggable if DD is on (defaults to true).
     *
     * @param allowDrag false to disable drag
     */
    public void setAllowDrag(boolean allowDrag) {
        JavaScriptObjectHelper.setAttribute(configJS, "allowDrag", allowDrag);
    }

    /**
     * False if this node cannot be drop on.
     *
     * @param allowDrop flase to disable drop
     */
    public void setAllowDrop(boolean allowDrop) {
        JavaScriptObjectHelper.setAttribute(configJS, "allowDrop", allowDrop);
    }

    /**
     * True to render a checked checkbox for this node, false to render an unchecked checkbox
     * (defaults to undefined with no checkbox rendered).
     *
     * @param checked true for checked checkbox
     */
    public void setChecked(boolean checked) {
        JavaScriptObjectHelper.setAttribute(configJS, "checked", checked);
    }

    /**
     * A CSS class to be added to the node.
     *
     * @param cls a CSS class
     */
    public void setCls(String cls) {
        JavaScriptObjectHelper.setAttribute(configJS, "cls", cls);
    }

    /**
     * True to start the node disabled
     *
     * @param disabled true to start disabled
     */
    public void setDisabled(boolean disabled) {
        JavaScriptObjectHelper.setAttribute(configJS, "disabled", disabled);
    }

    /**
     * True to start the node expanded
     *
     * @param expanded true to start expanded
     */
    public void setExpanded(boolean expanded) {
        JavaScriptObjectHelper.setAttribute(configJS, "expanded", expanded);
    }

    /**
     * URL of the link used for the node (defaults to #).
     *
     * @param href the node href URL
     */
    public void setHref(String href) {
        JavaScriptObjectHelper.setAttribute(configJS, "href", href);
    }

    /**
     * Target frame for the link
     *
     * @param hrefTarget href frame target
     */
    public void setHrefTarget(String hrefTarget) {
        JavaScriptObjectHelper.setAttribute(configJS, "hrefTarget", hrefTarget);
    }

    /**
     * The path to an icon for the node. The preferred way to do this is to use the cls
     * or iconCls attributes and add the icon via a CSS background image.
     *
     * @param icon the node icon
     */
    public void setIcon(String icon) {
        JavaScriptObjectHelper.setAttribute(configJS, "icon", icon);
    }

    /**
     * A css class to be added to the nodes icon element for applying css background images.
     *
     * @param iconCls the icon CSS class
     */
    public void setIconCls(String iconCls) {
        JavaScriptObjectHelper.setAttribute(configJS, "iconCls", iconCls);
    }

    public String getIconCls() {
        return JavaScriptObjectHelper.getAttribute(configJS, "iconCls");
    }
        
    /**
     * True if this node is a leaf and does not have children.
     *
     * @param leaf true if leaf node
     */
    public void setLeaf(Node leaf) {
        JavaScriptObjectHelper.setAttribute(configJS, "leaf", leaf.getJsObj());
    }

    /**
     * Set a Tree node tooltip.
     *
     * @param qtip the tooltip
     */
    public void setTooltip(String qtip) {
        JavaScriptObjectHelper.setAttribute(configJS, "qtip", qtip);
    }

    /**
     * Set a Tree node tooltip.
     *
     * @param qtipConfig the tooltip configuration
     */
    public void setTooltip(QuickTipsConfig qtipConfig) {
        JavaScriptObjectHelper.setAttribute(configJS, "qtipCfg", qtipConfig.getJsObj());
    }

    /**
     * True for single click expand on this node.
     *
     * @param singleClickExpand true for single click expand
     */
    public void setSingleClickExpand(boolean singleClickExpand) {
        JavaScriptObjectHelper.setAttribute(configJS, "singleClickExpand", singleClickExpand);
    }

    /**
     * The text for this node.
     *
     * @param text the nodes text / label
     */
    public void setText(String text) {
        if(!isCreated()) {
            JavaScriptObjectHelper.setAttribute(configJS, "text", text);
        } else {
            setTextCreated(text);
        }
    }

    //http://extjs.com/forum/showthread.php?t=4460&highlight=uiProvider
    //TODO
    //uiProvider
}