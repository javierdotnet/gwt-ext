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

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.menu.BaseItem;
import com.gwtext.client.widgets.menu.Menu;

public interface MenuListener {
    boolean doBeforeHide(Menu menu);

    boolean doBeforeShow(Menu menu);

    //todo inconsistent order of parms sent my ext
    void onClick(Menu menu, String menuItemId, EventObject e);

    void onHide(Menu menu);

    //todo ext inconsistent here
    void onItemClick(BaseItem item, EventObject e);

    void onMouseOut(Menu menu, BaseItem menuItem, EventObject e);

    void onMouseOver(Menu menu, BaseItem menuItem, EventObject e);

    void onShow(Menu menu);

}
