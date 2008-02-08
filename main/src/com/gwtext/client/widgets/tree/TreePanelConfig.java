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

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Configuration class for {@link TreePanel}.
 */
public class TreePanelConfig extends BaseConfig {
	
	private TreeSelectionModel selectionModel;

    /**
     * True to enable animated expand/collapse. Defaults to true.
     *
     * @param animate true to enable enimation.
     */
    public void setAnimate(boolean animate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "animate", animate);
    }

    /**
     * True to register this container with ScrollManager. Doing so provides automatic scrolling
     * of overflow regions in the page during drag operations. Defaults to false.
     * 
     * @param containerScroll true to register this container with ScrollManager
     */
    public void setContainerScroll(boolean containerScroll) {
        JavaScriptObjectHelper.setAttribute(jsObj, "containerScroll", containerScroll);
    }

    /**
     * True if the tree should only allow append drops (use for trees which are sorted).
     *
     * @param ddAppendOnly true to allow only append drops
     */
    public void setDdAppendOnly(String ddAppendOnly) {
        JavaScriptObjectHelper.setAttribute(jsObj, "ddAppendOnly", ddAppendOnly);
    }

    /**
     * The DD group this TreePanel belongs to.
     * 
     * @param ddGroup the DD group
     */
    public void setDdGroup(String ddGroup) {
        JavaScriptObjectHelper.setAttribute(jsObj, "ddGroup", ddGroup);
    }

    /**
     * True to enable body scrolling
     * 
     * @param ddScroll true to enable body scrolling.
     */
    public void setDdScroll(boolean ddScroll) {
        JavaScriptObjectHelper.setAttribute(jsObj, "ddScroll", ddScroll);
    }

    //TODO no TreeDragZone configs appear to be in Ext
    //dragConfig

    /**
     * Custom config to pass to the {@link TreeDropZone} instance.
     *
     * @param dropConfig the drop config
     */
    public void setDropConfig(TreeDropZone dropConfig) {
        JavaScriptObjectHelper.setAttribute(jsObj, "dropConfig", dropConfig.getJsObj());
    }

    /**
     * True to enable drag and drop.
     * 
     * @param enableDD true to enable drag and drop
     */
    public void setEnableDD(boolean enableDD) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableDD", enableDD);
    }

    /**
     * True to enable just drag.
     * 
     * @param enableDrag true to enable just drag
     */
    public void setEnableDrag(boolean enableDrag) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableDrag", enableDrag);
    }

    /**
     * True to enable just drop.
     * 
     * @param enableDrop true to enable just drop
     */
    public void setEnableDrop(boolean enableDrop) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableDrop", enableDrop);
    }

    /**
     * The color of the node highlight (defaults to C3DAF9).
     * 
     * @param hlColor the color of the node highlight
     */
    public void setHlColor(String hlColor) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hlColor", hlColor);
    }

    /**
     * False to disable node highlight on drop.
     *
     * @param hlDrop false to disable drop drop highlight
     */
    public void setHlDrop(boolean hlDrop) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hlDrop", hlDrop);
    }

    /**
     * False to disable tree lines (defaults to true).
     * 
     * @param lines false to disable tree lines
     */
    public void setLines(boolean lines) {
        JavaScriptObjectHelper.setAttribute(jsObj, "lines", lines);
    }

    /**
     * A TreeLoader for use with this TreePanel.
     * 
     * @param loader the tree loader
     */
    public void setLoader(TreeLoader loader) {
        JavaScriptObjectHelper.setAttribute(jsObj, "loader", loader.getJsObj());
    }

    /**
     * False to hide the root node (defaults to true).
     * 
     * @param rootVisible false to hide the root node
     */
    public void setRootVisible(boolean rootVisible) {
        JavaScriptObjectHelper.setAttribute(jsObj, "rootVisible", rootVisible);
    }

    /**
     * Set the Tree seelction model
     *
     * @param selectionModel the selection model
     */
    public void setSelectionModel(TreeSelectionModel selectionModel) {
        JavaScriptObjectHelper.setAttribute(jsObj, "selModel", selectionModel.getJsObj());
        this.selectionModel = selectionModel;
    }

    /**
     * Return the Tree's selection model
     *
     * @return the selection model
     */
    public TreeSelectionModel getSelectionModel() {
        return selectionModel;
    }

    /**
     * True if only 1 node per branch may be expanded.
     *
     * @param singleExpand true if only 1 node per branch may be expanded
     */
    public void setSingleExpand(boolean singleExpand) {
        JavaScriptObjectHelper.setAttribute(jsObj, "singleExpand", singleExpand);
    }
}
