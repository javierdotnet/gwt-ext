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
package com.gwtext.client.widgets.layout.event;

import com.gwtext.client.widgets.layout.ContentPanel;
import com.gwtext.client.widgets.layout.LayoutRegion;

public interface LayoutRegionListener {

    /**
     * Fires before a panel is removed (or closed). To cancel the removal return false.
     *
     * @param region this
     * @param panel the panel
     * @return false to cancel removal
     */
    boolean doBeforeRemove(LayoutRegion region, ContentPanel panel);

    /**
     * Fires when this region is collapsed.
     *
     * @param region this
     */
    void onCollapsed(LayoutRegion region);

    /**
     * Fires when this region is expanded.
     *
     * @param region this
     */
    void onExpanded(LayoutRegion region);

    /**
     * Fires when the layout for this region is changed.
     *
     * @param region this
     */
    void onInvalidated(LayoutRegion region);

    /**
     * Fires when a panel is activated.
     *
     * @param region this
     * @param panel the activated panel
     */
    void onPanelActivated(LayoutRegion region, ContentPanel panel);

    /**
     * Fires when a panel is added.
     *
     * @param region this
     * @param panel the panel added
     */
    void onPanelAdded(LayoutRegion region, ContentPanel panel);

    /**
     * Fires when a panel is removed.
     *
     * @param region this
     * @param panel the panel removed
     */
    void onPanelRemoved(LayoutRegion region, ContentPanel panel);

    /**
     * Fires when the user resizes this region.
     *
     * @param region this
     * @param newSize The new size (width for east/west, height for north/south)
     */
    void onResized(LayoutRegion region, int newSize);

    /**
     * Fires when this region slides out of view.
     *
     * @param region this
     */
    void onSlideHide(LayoutRegion region);

    /**
     * Fires when this region is slid into view.
     *
     * @param region this
     */
    void onSlideShow(LayoutRegion region);

    /**
     * Fires when this region is shown or hidden.
     *
     * @param region this
     * @param visibility true if visible
     */
    void onVisibilityChange(LayoutRegion region, boolean visibility);
}
