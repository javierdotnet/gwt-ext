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

package com.gwtext.client.widgets.menu.event;

import com.gwtext.client.widgets.menu.CheckItem;

public interface CheckItemListener {

    /**
     * Fires before the checked value is set, providing an opportunity to cancel if needed.
     *
     * @param item this
     * @param checked the new checked value that will be set
     * @return false to cancel
     */
    boolean doBeforeCheckChange(CheckItem item, boolean checked);

    /**
     * Fires after the checked value has been set.
     *
     * @param item this
     * @param checked the checked value that was set
     */
    void onCheckChange(CheckItem item, boolean checked);
}
