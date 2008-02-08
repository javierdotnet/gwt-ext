/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.menu.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.menu.BaseItem;
import com.gwtext.client.widgets.menu.Menu;

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
