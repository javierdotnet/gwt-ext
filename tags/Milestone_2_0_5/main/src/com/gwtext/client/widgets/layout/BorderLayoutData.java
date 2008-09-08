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

import com.gwtext.client.core.Margins;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Additional layout data associated with a {@link BorderLayout}.
 *
 * @author Sanjiv Jivan
 * @see com.gwtext.client.widgets.layout.BorderLayout
 */
public class BorderLayoutData extends LayoutData {

    /**
     * Create a new instance.
     *
     * @param region the border layout region.
     */
    public BorderLayoutData(RegionPosition region) {
        setRegion(region);
    }

    public BorderLayoutData(RegionPosition region, Margins margins) {
        setRegion(region);
        setMargins(margins);
    }

    /**
     * Set the BorderLayout region.
     *
     * @param region the region
     */
    public void setRegion(RegionPosition region) {
        JavaScriptObjectHelper.setAttribute(jsObj, "region", region.getPosition());
    }

    /**
     * When a collapsed region's bar is clicked, the region's panel will be displayed as a floated panel that will close
     * again once the user mouses out of that panel (or clicks out if autoHide = false). Setting animFloat to false will
     * prevent the open and close of these floated panels from being animated (defaults to true).
     *
     * @param animFloat true to amin float
     */
    public void setAnimFloat(boolean animFloat) {
        JavaScriptObjectHelper.setAttribute(jsObj, "animFloat", animFloat);
    }

    /**
     * When a collapsed region's bar is clicked, the region's panel will be displayed as a floated panel. If autoHide is
     * true, the panel will automatically hide after the user mouses out of the panel. If autoHide is false, the panel will
     * continue to display until the user clicks outside of the panel (defaults to true).
     *
     * @param autoHide true to auto hide
     */
    public void setAutoHide(boolean autoHide) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoHide", autoHide);
    }

    public void setCMargins(int top, int left, int right, int  bottom) {
        setCMargins(new Margins(top, left, right, bottom));
    }
    
    /**
     * The margins to apply to the region's collapsed element.
     *
     * @param cMargins the margins to apply to collapsed element
     */
    public void setCMargins(Margins cMargins) {
        JavaScriptObjectHelper.setAttribute(jsObj, "cmargins", cMargins.getJsObj());
    }

    /**
     * By default, collapsible regions are collapsed by clicking the expand/collapse tool button that renders into the
     * region's title bar. Optionally, when collapseMode is set to 'mini' the region's split bar will also display a
     * small collapse button in the center of the bar. In 'mini' mode the region will collapse to a thinner bar than in
     * normal mode.
     * <br><br>
     * Note that if a collapsible region does not have a title bar, then collapseMode must be set to 'mini' in order for
     * the region to be collapsible by the user as the tool button will not be rendered.
     *
     * @param miniMode true for mimi collapse mode
     */
    public void setCollapseModeMini(boolean miniMode) {
        if (miniMode) {
            JavaScriptObjectHelper.setAttribute(jsObj, "collapseMode", "mini");
        }
    }

    //set this on the panel
    /*   public void setCollapsible(boolean collapsible) {
        JavaScriptObjectHelper.setAttribute(jsObj, "collapsible", collapsible);
    }*/

    /**
     * True to allow clicking a collapsed region's bar to display the region's panel floated above the layout, false to
     * force the user to fully expand a collapsed region by clicking the expand button to see it again (defaults to true).
     *
     * @param floatable true for floatable
     */
    public void setFloatable(boolean floatable) {
        JavaScriptObjectHelper.setAttribute(jsObj, "floatable", floatable);
    }

    /**
     * The margins to apply to the region.
     */
    public void setMargins(int top, int left, int right, int bottom) {
        setMargins(new Margins(top, left, right, bottom));
    }
    
    public void setMargins(Margins margins) {
        JavaScriptObjectHelper.setAttribute(jsObj, "margins", margins.getJsObj());
    }

    /**
     * The minimum allowable height in pixels for this region (defaults to 50).
     *
     * @param minHeight the min height
     */
    public void setMinHeight(int minHeight) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minHeight", minHeight);
    }

    /**
     * The minimum allowable width in pixels for this region (defaults to 50).
     *
     * @param minWidth the min width
     */
    public void setMinWidth(int minWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minWidth", minWidth);
    }

    /**
     * When {@link #setSplit(boolean)} is true, it is common to specify a minSize and maxSize for the region.
     *
     * @param minSize the split regions min size
     */
    public void setMinSize(int minSize) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minSize", minSize);
    }

    /**
     * When {@link #setSplit(boolean)} is true, it is common to specify a minSize and maxSize for the region.
     *
     * @param maxSize the split regions max size
     */
    public void setMaxSize(int maxSize) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxSize", maxSize);
    }

    /**
     * True to display a SplitBar between this region and its neighbor, allowing the user to resize the regions
     * dynamically (defaults to false). When split = true, it is common to specify a minSize and maxSize for the region.
     *
     * @param split true for split bar
     */
    public void setSplit(boolean split) {
        JavaScriptObjectHelper.setAttribute(jsObj, "split", split);
    }

    /**
     * The tooltip to display when the user hovers over a collapsible region's split bar (defaults to "Drag to resize. Double click to hide.").
     * Setting this property automatically sets the split property to true.
     *
     * @param collapsibleSplitTip the tooltip to display when the user hovers over a collapsible region's split bar
     * @see #setSplit(boolean)
     */
    public void setCollapsibleSplitTip(String collapsibleSplitTip) {
        setSplit(true);
        JavaScriptObjectHelper.setAttribute(jsObj, "collapsibleSplitTip", collapsibleSplitTip);
    }

    /**
     * The tooltip to display when the user hovers over a non-collapsible region's split bar (defaults to "Drag to resize.").
     * <br>Setting this property automatically sets the split property to true.
     *
     * @param splitTip the tooltip to display when the user hovers over a non-collapsible region's split bar (defaults to "Drag to resize.").
     * @see #setSplit(boolean)
     */
    public void setSplitTip(String splitTip) {
        setSplit(true);
        JavaScriptObjectHelper.setAttribute(jsObj, "splitTip", splitTip);
    }

    /**
     * True to display a tooltip when the user hovers over a region's split bar (defaults to false). The tooltip text will
     * be the value of either splitTip or collapsibleSplitTip as appropriate.
     * <br>Setting this property automatically sets the split property to true.
     *
     * @param useSplitTips true to display a tooltip when the user hovers over a region's split bar (defaults to false)
     * @see #setSplit(boolean)
     */
    public void setUseSplitTips(boolean useSplitTips) {
        setSplit(true);
        JavaScriptObjectHelper.setAttribute(jsObj, "useSplitTips", useSplitTips);
    }


}