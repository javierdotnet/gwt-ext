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

import com.gwtext.client.data.Node;
import com.gwtext.client.data.NodeConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.QuickTipsConfig;

public class TreeNodeConfig extends NodeConfig {

	/**
	 * False to make this node undraggable if DD is on (defaults to true).
	 *
	 * @param allowDrag false to disable drag
	 */
	public void setAllowDrag(boolean allowDrag) {
        JavaScriptObjectHelper.setAttribute(jsObj, "allowDrag", allowDrag);
    }

	/**
	 * False if this node cannot be drop on.
	 *
	 * @param allowDrop flase to disable drop
	 */
	public void setAllowDrop(boolean allowDrop) {
        JavaScriptObjectHelper.setAttribute(jsObj, "allowDrop", allowDrop);
    }

	/**
	 * True to render a checked checkbox for this node, false to render an unchecked checkbox
	 * (defaults to undefined with no checkbox rendered).
	 * 
	 * @param checked true for checked checkbox
	 */
	public void setChecked(boolean checked) {
        JavaScriptObjectHelper.setAttribute(jsObj, "checked", checked);
    }

	/**
	 * A CSS class to be added to the node.
	 * 
	 * @param cls a CSS class
	 */
	public void setCls(String cls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "cls", cls);
    }

	/**
	 * True to start the node disabled
	 * 
	 * @param disabled true to start disabled
	 */
    public void setDisabled(boolean disabled) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disabled", disabled);
    }

	/**
	 * True to start the node expanded
	 *
	 * @param expanded true to start expanded
	 */
	public void setExpanded(boolean expanded) {
        JavaScriptObjectHelper.setAttribute(jsObj, "expanded", expanded);
    }

	/**
	 * URL of the link used for the node (defaults to #).
	 *
	 * @param href the node href URL
	 */
	public void setHref(String href) {
        JavaScriptObjectHelper.setAttribute(jsObj, "href", href);
    }

	/**
	 * Target frame for the link
	 * 
	 * @param hrefTarget href frame target
	 */
	public void setHrefTarget(String hrefTarget) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hrefTarget", hrefTarget);
    }

	/**
	 * The path to an icon for the node. The preferred way to do this is to use the cls
	 * or iconCls attributes and add the icon via a CSS background image.
	 * 
	 * @param icon the node icon
	 */
	public void setIcon(String icon) {
        JavaScriptObjectHelper.setAttribute(jsObj, "icon", icon);
    }

	/**
	 * A css class to be added to the nodes icon element for applying css background images.
	 * 
	 * @param iconCls the icon CSS class
	 */
	public void setIconCls(String iconCls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "iconCls", iconCls);
    }

	/**
	 * True if this node is a leaf and does not have children.
	 *
	 * @param leaf true if leaf node
	 */
	public void setLeaf(Node leaf) {
        JavaScriptObjectHelper.setAttribute(jsObj, "leaf", leaf.getJsObj());
    }

	/**
	 * Set a Tree node tooltip.
	 * 
	 * @param qtip the tooltip
	 */
	public void setQtip(String qtip) {
        JavaScriptObjectHelper.setAttribute(jsObj, "qtip", qtip);
    }

	/**
	 * Set a Tree node tooltip.
	 *
	 * @param qtipCfg the tooltip configuration
	 */
	public void setQtipCfg(QuickTipsConfig qtipCfg) {
        JavaScriptObjectHelper.setAttribute(jsObj, "qtipCfg", qtipCfg.getJsObj());
    }

	/**
	 * True for single click expand on this node.
	 *
	 * @param singleClickExpand true for single click expand
	 */
	public void setSingleClickExpand(boolean singleClickExpand) {
        JavaScriptObjectHelper.setAttribute(jsObj, "singleClickExpand", singleClickExpand);
    }

	/**
	 * The text for this node.
	 *
	 * @param text the nodes text / label
	 */
	public void setText(String text) {
        JavaScriptObjectHelper.setAttribute(jsObj, "text", text);
    }

    //http://extjs.com/forum/showthread.php?t=4460&highlight=uiProvider
    //TODO
    //uiProvider

}
