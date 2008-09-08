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
 

package com.gwtext.client.widgets.menu.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.menu.BaseItem;
import com.gwtext.client.widgets.menu.Menu;

/**
 *
 * @author Sanjiv Jivan
 */
public interface MenuListener {

    /**
     * Fires before this menu is hidden.
     *
     * @param menu this
     */
    void doBeforeHide(Menu menu);

    /**
     * Fires before this menu is displayed.
     *
     * @param menu this
     */
    void doBeforeShow(Menu menu);

    //todo inconsistent order of parms sent my ext, docs say menu item sent, but only id sent
    /**
     * Fires when this menu is clicked (or when the enter key is pressed while it is active).
     *
     * @param menu       this
     * @param menuItemId the menu item ID
     * @param e          the event object
     */
    void onClick(Menu menu, String menuItemId, EventObject e);

    /**
     * Fires after this menu is hidden.
     *
     * @param menu this
     */
    void onHide(Menu menu);

    //todo ext inconsistent here
    /**
     * Fires when a menu item contained in this menu is clicked.
     *
     * @param item the clicked item
     * @param e    the event object
     */
    void onItemClick(BaseItem item, EventObject e);

    /**
     * Fires when the mouse exits this menu.
     *
     * @param menu     this
     * @param menuItem the menu item
     * @param e        the event object
     */
    void onMouseOut(Menu menu, BaseItem menuItem, EventObject e);

    /**
     * Fires when the mouse is hovering over this menu.
     *
     * @param menu     this
     * @param menuItem the menu item
     * @param e        the event object
     */
    void onMouseOver(Menu menu, BaseItem menuItem, EventObject e);

    /**
     * Fires after this menu is displayed.
     *
     * @param menu this
     */
    void onShow(Menu menu);
}
