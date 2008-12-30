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
 
package com.gwtext.client.widgets.layout;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * This is a layout that contains multiple panels in an expandable accordion style such that only one panel can be open
 * at any given time. Each panel has built-in support for expanding and collapsing.
 * <br>
 * <b>Note that child Panels added to a Panel with an AccordionLayout must have a title.</b>
 *
 * @author Sanjiv Jivan
 */
public class AccordionLayout extends FitLayout {

    /**
     * Create a new Accordion.
     */
    public AccordionLayout() {
    }

    /**
     * Create a new Accordion.
     *
     * @param animate true to animate
     */
    public AccordionLayout(boolean animate) {
        setAnimate(animate);
    }

    /**
     * True to swap the position of each panel as it is expanded so that it becomes the first item in the container, false to keep the panels in the rendered order. This is NOT compatible with "animate:true" (defaults to false).
     *
     * @param activeOnTop true to swap the position of each panel as it is expanded
     */
    public void setActiveOnTop(boolean activeOnTop) {
        JavaScriptObjectHelper.setAttribute(configJS, "activeOnTop", activeOnTop);
    }

    /**
     * True to slide the contained panels open and closed during expand/collapse using animation, false to open and close
     * directly with no animation (defaults to false). Note: to defer to the specific config setting of each contained panel
     * for this property, set this to undefined at the layout level.
     *
     * @param animate true to animate
     */
    public void setAnimate(boolean animate) {
        JavaScriptObjectHelper.setAttribute(configJS, "animate", animate);
    }

    /**
     * True to set each contained item's width to 'auto', false to use the item's current width (defaults to true).
     *
     * @param autoWidth true to set each contained item's width to 'auto'
     */
    public void setAutoWidth(boolean autoWidth) {
        JavaScriptObjectHelper.setAttribute(configJS, "autoWidth", autoWidth);
    }

    /**
     * True to make sure the collapse/expand toggle button always renders first (to the left of) any other tools in the
     * contained panels' title bars, false to render it last (defaults to false).
     * 
     * @param collapseFirst true to make sure the collapse/expand toggle button always renders first
     */
    public void setCollapseFirst(boolean collapseFirst) {
        JavaScriptObjectHelper.setAttribute(configJS, "collapseFirst", collapseFirst);
    }

    /**
     * True to adjust the active item's height to fill the available space in the container, false to use the item's
     * current height, or auto height if not explicitly set (defaults to true).
     * 
     * @param fill true to adjust the active item's height to fill the available space in the container
     */
    public void setFill(boolean fill) {
        JavaScriptObjectHelper.setAttribute(configJS, "fill", fill);
    }

    /**
     * True to hide the contained panels' collapse/expand toggle buttons, false to display them (defaults to false).
     *  When set to true, {@link #setTitleCollapse} should be true also.
     * 
     * @param hideCollapseTool true to hide the contained panels' collapse/expand toggle buttons
     */
    public void setHideCollapseTool(boolean hideCollapseTool) {
        JavaScriptObjectHelper.setAttribute(configJS, "hideCollapseTool", hideCollapseTool);
    }

    /**
     * If animate is set to true, this will result in each animation running in sequence.
     *
     * @param sequence if animate is set to true, this will result in each animation running in sequence.
     */
    public void setSequence(boolean sequence) {
        JavaScriptObjectHelper.setAttribute(configJS, "sequence", sequence);
    }

    /**
     * True to allow expand/collapse of each contained panel by clicking anywhere on the title bar, false to allow expand/collapse
     * only when the toggle tool button is clicked (defaults to true). When set to false, {@link #setHideCollapseTool} should be false also.
     * 
     * @param titleCollapse true to allow expand/collapse of each contained panel by clicking anywhere on the title bar
     */
    public void setTitleCollapse(boolean titleCollapse) {
        JavaScriptObjectHelper.setAttribute(configJS, "titleCollapse", titleCollapse);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.layout.Accordion(config);
    }-*/;
}
