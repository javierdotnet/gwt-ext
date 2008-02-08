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

import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.LayoutRegion;

public interface LayoutListener {

    /**
     * Fires when a layout is performed.
     *
     * @param layout this
     */
    void onLayout(BorderLayout layout);

    /**
     * Fires when a region is collapsed.
     *
     * @param region the collapsed region
     */
    void onRegionCollapsed(LayoutRegion region);

    /**
     * Fires when a region is expanded.
     *
     * @param region the expanded region
     */
    void onRegionExpanded(LayoutRegion region);

    /**
     * Fires when the user resizes a region.
     * 
     * @param region the resized region
     * @param newSize the new size (width for east/west, height for north/south)
     */
    void onRegionResized(LayoutRegion region, int newSize);
}
