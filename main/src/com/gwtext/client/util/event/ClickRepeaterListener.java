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
package com.gwtext.client.util.event;

import com.gwtext.client.util.ClickRepeater;

/**
 * Interface for {@link com.gwtext.client.util.ClickRepeater}.
 */
public interface ClickRepeaterListener {

    /**
     * Fires on a specified interval during the time the element is pressed.
     *
     * @param self this
     */
    void onClick(ClickRepeater self);

    /**
     * Fires when the mouse button is depressed.
     *
     * @param self this
     */
    void onMouseDown(ClickRepeater self);

    /**
     * Fires when the mouse key is released.
     *
     * @param self this
     */
    void onMouseUp(ClickRepeater self);

}
