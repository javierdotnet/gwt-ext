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
 

package com.gwtext.client.widgets.tree;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.Function;
import com.gwtext.client.data.Node;
import com.gwtext.client.data.NodeModel;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.QuickTipsConfig;
import com.gwtext.client.widgets.tree.event.TreeNodeListener;

/**
 * TreeNode class.
 *
 * @author Sanjiv Jivan
 * @see com.gwtext.client.widgets.tree.TreePanel
 */
public class TreeNode extends Node {

	protected NodeModel nodeModel = null;
	
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

	/**
	 * Create a new TreeNode.
	 *
	 * @param text the text / label of the TreeNode
	 * @param iconCls the tree node icon CSS class
	 */
	public TreeNode(String text, String iconCls){
		setText(text);
		setIconCls(iconCls);
	}
	
	public TreeNode(NodeModel model){
		setNodeModel(model);
	}

	TreeNode(JavaScriptObject jsObj) {
        super(jsObj);
    }
    
    public static TreeNode treeNodeInstance(JavaScriptObject jsObj){
    	return new TreeNode(jsObj);
    }

    public JavaScriptObject getJsObj() {
        if(jsObj == null) {
            jsObj = super.getJsObj();
            setNodeModel(nodeModel);
        }
        return jsObj;
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
	 * Destroy this node.
	 */
	public native void destroy() /*-{
		var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
		node.destroy();
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

	public boolean isRendered() {
        if(jsObj == null) return false;
        TreeNodeUI treeNodeUI = getUI();
		if(treeNodeUI == null) {
			return false;
		} else {
			return treeNodeUI.getEl() != null;	
		}
	}

	/**
     * Expand this node. The tree must be rendered before this method is called.
     */
    public void expand(){
		if(isRendered()) {
			doExpand();
		} else {
			setExpanded(true);
	}
}
    private native void doExpand() /*-{
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
    public void expand(boolean deep, boolean anim){
	    if(isRendered()){
			doExpand(deep, anim);
		} else {
			setExpanded(true);
		}
	}

	private native void doExpand(boolean deep, boolean anim) /*-{
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
    public void expand(boolean deep, boolean anim, Function callback) {
		if(isRendered()) {
			doExpand(deep, anim, callback);
		} else {
			setExpanded(true);
		}
	}

	private native void doExpand(boolean deep, boolean anim, Function callback) /*-{
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
        return ui === undefined || ui == null ? null : @com.gwtext.client.widgets.tree.TreeNodeUI::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ui);
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
        var copyJ = @com.gwtext.client.widgets.tree.TreeNode::treeNodeInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(copy);
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
        var copyJ = @com.gwtext.client.widgets.tree.TreeNode::treeNodeInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(copy);
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

        node.addListener('checkchange',
                 function(source, checked) {
                    listener.@com.gwtext.client.widgets.tree.event.TreeNodeListener::onCheckChanged(Lcom/gwtext/client/data/Node;Z)(nodeJ, checked);
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
	 * Returns true if this node is expandable.
	 *
	 * @return true if expandable
	 */
	public  boolean isExpandable() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(configJS, "expandable");
    }

	/**
	 * True to mark the node as expandable. If set to true, the node will always show a plus/minus icon, even when empty
	 *
	 * @param expandable true to start expandable
	 */
	public void setExpandable(boolean expandable) {
		JavaScriptObjectHelper.setAttribute(configJS, "expandable", expandable);
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
        if(!isRendered()) {
            JavaScriptObjectHelper.setAttribute(configJS, "icon", icon);
        } else {
            Element el = getUI().getIconEl();
            if(el != null) {
                DOM.setElementAttribute(el, "src", icon);
            }
        }
    }

    /**
     * A css class to be added to the nodes icon element for applying css background images.
     *
     * @param iconCls the icon CSS class
     */
    public void setIconCls(String iconCls) {
        if (!isRendered()) {
            JavaScriptObjectHelper.setAttribute(configJS, "iconCls", iconCls);
        } else {
            Element el = getUI().getIconEl();
            if (el != null) {
                DOM.setElementAttribute(el, "className", "x-tree-node-icon " + iconCls);
                DOM.setElementAttribute(el, "class", "x-tree-node-icon " + iconCls);
            }
        }
    }

    public String getIconCls() {
        return JavaScriptObjectHelper.getAttribute(configJS, "iconCls");
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
	/**
	 * Sets a new TreeNodeUI
	 *
	 * @param uiProvider the new UI Provider
	 */
	public void setUiProvider(JavaScriptObject uiProvider) {
		JavaScriptObjectHelper.setAttribute(configJS, "uiProvider", uiProvider);
	} 
	
    public void setTreeAttribute(String name, Object value) {
    	JavaScriptObjectHelper.setAttribute(configJS, name, value);
    }

    public void setTreeAttribute(String name, int value) {
    	JavaScriptObjectHelper.setAttribute(configJS, name, value);
    }
    public void setTreeAttribute(String name, float value) {
    	JavaScriptObjectHelper.setAttribute(configJS, name, value);
    }
    public void setTreeAttribute(String name, Date value) {
    	JavaScriptObjectHelper.setAttribute(configJS, name, value);
    }
    public void setTreeAttribute(String name, boolean value) {
    	JavaScriptObjectHelper.setAttribute(configJS, name, value);
    }
    public void setTreeAttribute(String name, double value) {
    	JavaScriptObjectHelper.setAttribute(configJS, name, value);
    }

    /**
     * add child information to this node.  
     * @param child node based on JSon data: <BR>
     * <code>
     * [{
     *    text: "TreeNode1",
     *    leaf: true
     *  }, {
     *    text: "TreeNode2",
     *    leaf: true
     *  }, {
     *    text: "TreeNode3",
     *    leaf: true
     * }]
     * </code>
     */
    public native void addChild(JavaScriptObject child)/*-{
    	var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        node.addChild(child);
    }-*/;
    
    /**
     * Set the NodeModel associated to this TreeNode
     * @param nodeModel The NodeModel to be associated to the TreeNode
     */
    public void setNodeModel(NodeModel nodeModel){
    	if(nodeModel == null) return;
    	
    	this.nodeModel = nodeModel;
        if(!isCreated()) {
            this.nodeModel = nodeModel;
        } else {
            setNodeModelCreated(nodeModel);
        }
		HashMap props = nodeModel.getProperties();
		Iterator iter = props.keySet().iterator();
			
		while (iter.hasNext()) {
			String key = (String)iter.next();
			Object value = nodeModel.getPropertyAsObject(key);
			if(value instanceof Boolean){
				JavaScriptObjectHelper.setAttribute(configJS, key, ((Boolean)value).booleanValue());
			}else if(value instanceof String){
				JavaScriptObjectHelper.setAttribute(configJS, key, (String) value);
			}else if(value instanceof Integer){
				JavaScriptObjectHelper.setAttribute(configJS, key, ((Integer)value).intValue());
			}else if(value instanceof Float){
				JavaScriptObjectHelper.setAttribute(configJS, key, ((Float)value).floatValue());
			}else if(value instanceof Double){
				JavaScriptObjectHelper.setAttribute(configJS, key, ((Double)value).doubleValue());
			}else if(value instanceof Date){
				JavaScriptObjectHelper.setAttribute(configJS, key, (Date) value);
			}else{
				JavaScriptObjectHelper.setAttribute(configJS, key, value);
			}
		}

    }
    
    /**
     * Return the user defined object
     *
     * @return the user defined object
     */
    public NodeModel getNodeModel() {
        if(!isCreated()) {
            return nodeModel;
        } else {
            return  (NodeModel)getNodeModelCreated();
        }
    }
    
    /**
     * Associate a NodeModel Object with the node.
     *
     * @param o the user data object
     */
    private native void setNodeModelCreated(Object o) /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        node.attributes._nodeModel = o;
    }-*/;

    /**
     * Return the NodeModel object associated with the node.
     *
     * @return the user defined object , null if not defined
     */
    private native Object getNodeModelCreated() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();

        //need to convert javascript undefined to null before passing to java layer
        if(node.attributes._nodeModel === undefined) {
            return null;
        } else {
            return node.attributes._nodeModel;
       }
    }-*/;
}