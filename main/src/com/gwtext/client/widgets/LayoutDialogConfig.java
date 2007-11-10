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

package com.gwtext.client.widgets;

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Configuration for {@link com.gwtext.client.widgets.LayoutDialog}.
 */
public class LayoutDialogConfig extends BaseConfig {

    private String id;
    /**
     * Sets the LayoutDialog's element id. If none is specified, one is generated.
     * @param id LayoutDialog id
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

	/**
	 * ID or element from which the dialog should animate while opening (defaults to null with no animation).
	 *
	 * @param animateTarget the animation target
	 */
	public void setAnimateTarget(String animateTarget) {
        JavaScriptObjectHelper.setAttribute(jsObj, "animateTarget", animateTarget);
    }

	/**
	 * True to allow the dialog body contents to overflow and display scrollbars (defaults to false).
	 *
	 * @param autoScroll true for auto scroll
	 */
	public void setAutoScroll(boolean autoScroll) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoScroll", autoScroll);
    }

	/**
	 * If true, all elements with class 'x-dlg-tab' will get automatically converted to tabs (defaults to false).
	 *
	 * @param autoTabs true for auto tabs
	 */
	public void setAutoTabs(boolean autoTabs) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoTabs", autoTabs);
    }

	/**
	 * Valid values are "left," "center" and "right" (defaults to "right")
	 * 
	 * @param buttonAlign the button alignment
	 */
	public void setButtonAlign(String buttonAlign) {
        JavaScriptObjectHelper.setAttribute(jsObj, "buttonAlign", buttonAlign);
    }

	/**
	 * False to remove the built-in top-right corner close button (defaults to true).
	 * 
	 * @param closable true for closable
	 */
	public void setClosable(boolean closable) {
        JavaScriptObjectHelper.setAttribute(jsObj, "closable", closable);
    }

	/**
	 * False to remove the built-in top-right corner collapse button (defaults to true).
	 * 
	 * @param collapsible false to disable collapsible
	 */
	public void setCollapsible(boolean collapsible) {
        JavaScriptObjectHelper.setAttribute(jsObj, "collapsible", collapsible);
    }

	/**
	 * True to keep the dialog constrained within the visible viewport boundaries (defaults to true).
	 * 
	 * @param constrainttoviewport true to constrain to viewport
	 */
	public void setConstrainToViewport(boolean constrainttoviewport) {
        JavaScriptObjectHelper.setAttribute(jsObj, "constraintoviewport", constrainttoviewport);
    }

	/**
	 * False to disable dragging of the dialog within the viewport (defaults to true).
	 * 
	 * @param draggable false to disable dragging
	 */
	public void setDraggable(boolean draggable) {
        JavaScriptObjectHelper.setAttribute(jsObj, "draggable", draggable);
    }

	/**
	 * True to ensure that anytime the dialog is shown or resized it gets centered (defaults to false).
	 *
	 * @param fixedcenter true to ensure dialog is centered
	 */
	public void setFixedCenter(boolean fixedcenter) {
        JavaScriptObjectHelper.setAttribute(jsObj, "fixedcenter", fixedcenter);
    }

	/**
	 * Height of the dialog in pixels (can also be set via CSS). Determined by browser if unspecified.
	 * 
	 * @param height the dialog height
	 */
	public void setHeight(int height) {
        JavaScriptObjectHelper.setAttribute(jsObj, "height", height);
    }

	/**
	 * Minimum width of all dialog buttons (defaults to 75).
	 *
	 * @param minButtonWidth the button min width
	 */
	public void setMinButtonWidth(int minButtonWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minButtonWidth", minButtonWidth);
    }

	/**
	 * The minimum allowable height for a resizable dialog (defaults to 80).
	 * 
	 * @param minHeight the min height of the dialog
	 */
	public void setMinHeight(int minHeight) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minHeight", minHeight);
    }

	/**
	 * The minimum allowable width for a resizable dialog (defaults to 200).
	 * 
	 * @param minWidth the min width of the dialog
	 */
	public void setMinWidth(int minWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minWidth", minWidth);
    }

	/**
	 * True to show the dialog modally, preventing user interaction with the rest of the page (defaults to false).
	 * 
	 * @param modal true for modal
	 */
	public void setModal(boolean modal) {
        JavaScriptObjectHelper.setAttribute(jsObj, "modal", modal);
    }

	/**
	 * True to drag a lightweight proxy element rather than the dialog itself, used when draggable = true (defaults to false).
	 *
	 * @param proxyDrag true for proxy display on drag
	 */
	public void setProxyDrag(boolean proxyDrag) {
        JavaScriptObjectHelper.setAttribute(jsObj, "proxyDrag", proxyDrag);
    }

	/**
	 * False to disable manual dialog resizing (defaults to true).
	 *
	 * @param resizable false to dissable manual resizing
	 */
	public void setResizable(boolean resizable) {
        JavaScriptObjectHelper.setAttribute(jsObj, "resizable", resizable);
    }

	/**
	 * Which resize handles to display - see the {@link Resizable} handles config property for valid values (defaults to 'all')
	 *
	 * @param resizeHandles the resize handles to display
	 */
	public void setResizeHandles(String resizeHandles) {
        JavaScriptObjectHelper.setAttribute(jsObj, "resizeHandles", resizeHandles);
    }

	/**
	 * True or "sides" for the default effect, "frame" for 4-way shadow, and "drop" for bottom-right shadow (defaults to false).
	 * 
	 * @param shadow shadow setting
	 */
	public void setShadow(boolean shadow) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shadow", shadow);
    }

	/**
	 * True or "sides" for the default effect, "frame" for 4-way shadow, and "drop" for bottom-right shadow (defaults to false).
	 *
	 * @param shadow shadow setting
	 */
    public void setShadow(String shadow) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shadow", shadow);
    }

	/**
	 * he number of pixels to offset the shadow if displayed (defaults to 5).
	 *
	 * @param shadowOffset the shadow offset in pixels
	 */
	public void setShadowOffset(int shadowOffset) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shadowOffset", shadowOffset);
    }

	/**
	 * True to create an iframe shim that prevents selects from showing through (defaults to false).
	 * 
	 * @param shim true to create shim
	 */
	public void setShim(boolean shim) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shim", shim);
    }

	/**
	 * True to cause the dimensions to be recalculated before the dialog is shown (defaults to false).
	 *
	 * @param syncHeightBeforeShow true to sync height before show
	 */
	public void setSyncHeightBeforeShow(boolean syncHeightBeforeShow) {
        JavaScriptObjectHelper.setAttribute(jsObj, "syncHeightBeforeShow", syncHeightBeforeShow);
    }

	/**
	 * The tag name of tab elements, used when autoTabs = true (defaults to 'div').
	 *
	 * @param tabTag the tab tag
	 */
	public void setTabTag(String tabTag) {
        JavaScriptObjectHelper.setAttribute(jsObj, "tabTag", tabTag);
    }

	/**
	 * Default text to display in the title bar.
	 * 
	 * @param title the dialog title
	 */
	public void setTitle(String title) {
        JavaScriptObjectHelper.setAttribute(jsObj, "title", title);
    }

	/**
	 * Width of the dialog in pixels (can also be set via CSS). Determined by browser if unspecified.
	 *
	 * @param width the dialog width
	 */
	public void setWidth(int width) {
        JavaScriptObjectHelper.setAttribute(jsObj, "width", width);
    }

	/**
	 * The default left page coordinate of the dialog (defaults to center screen)
	 *
	 * @param x the x coordinate
	 */
	public void setX(int x) {
        JavaScriptObjectHelper.setAttribute(jsObj, "x", x);
    }

	/**
	 * The default top page coordinate of the dialog (defaults to center screen).
	 *
	 * @param y the y coordinate
	 */
	public void setY(int y) {
        JavaScriptObjectHelper.setAttribute(jsObj, "y", y);
    }
}
