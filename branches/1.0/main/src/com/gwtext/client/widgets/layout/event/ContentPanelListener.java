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

public interface ContentPanelListener {

    /**
     * Fires when this panel is activated.
     *
     * @param cp this
     */
    void onActivate(ContentPanel cp);

    /**
     * Fires when this panel is deactivated.
     * 
     * @param cp this
     */
    void onDeactivate(ContentPanel cp);

    /**
     * Fires when this panel is resized if fitToFrame is true.
     *
     * @param cp this
     * @param width the width after any component adjustments
     * @param height the height after any component adjustments
     */
    void onResize(ContentPanel cp, int width, int height);
}
