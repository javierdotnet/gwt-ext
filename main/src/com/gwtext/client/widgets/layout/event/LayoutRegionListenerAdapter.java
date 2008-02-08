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

import com.gwtext.client.widgets.layout.LayoutRegion;
import com.gwtext.client.widgets.layout.ContentPanel;

public class LayoutRegionListenerAdapter implements LayoutRegionListener {

    public boolean doBeforeRemove(LayoutRegion region, ContentPanel panel) {
        return true;
    }

    public void onCollapsed(LayoutRegion region) {
    }

    public void onExpanded(LayoutRegion region) {
    }

    public void onInvalidated(LayoutRegion region) {
    }

    public void onPanelActivated(LayoutRegion region, ContentPanel panel) {
    }

    public void onPanelAdded(LayoutRegion region, ContentPanel panel) {
    }

    public void onPanelRemoved(LayoutRegion region, ContentPanel panel) {
    }

    public void onResized(LayoutRegion region, int newSize) {
    }

    public void onSlideHide(LayoutRegion region) {
    }

    public void onSlideShow(LayoutRegion region) {
    }

    public void onVisibilityChange(LayoutRegion region, boolean visibility) {
    }
}
