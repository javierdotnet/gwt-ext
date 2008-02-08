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

package com.gwtext.client.widgets.menu;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.RequiredElementWidget;
import com.gwtext.client.widgets.menu.event.MenuListener;

/**
 * A menu object. This is the container to which you add all other menu items.
 */
public class Menu extends RequiredElementWidget {

    /**
     * Createa new Menu.
     *
     * @param id the menu ID
     */
    public Menu(String id) {
        super(id);
    }

    /**
     * Create a new Menu.
     *
     * @param id the menu ID
     * @param menuConfig the config object
     */
    public Menu(String id, MenuConfig menuConfig) {
        super(id, menuConfig);
        if (menuConfig.getMenuListener() != null) {
            addMenuListener(menuConfig.getMenuListener());
        }
    }

    protected JavaScriptObject create(String id, JavaScriptObject config) {
        JavaScriptObjectHelper.setAttribute(config, "id", id);
        return create(config);
    }

    protected native JavaScriptObject create(JavaScriptObject menuConfig)/*-{
        return new $wnd.Ext.menu.Menu(menuConfig);
    }-*/;

    /**
     * Adds an Element object to the menu.
     * 
     * @param element the element to add
     */
    public native void addElement(Element element) /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.addElement(element);
    }-*/;

    /**
     * Adds an Ext.Element object to the menu.
     *
     * @param elemID the element ID
     */
    public native void addElement(String elemID) /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.addElement(elemID);
    }-*/;

    /**
     * Adds an {@link Item} to the menu.
     *
     * @param item the item to add
     */
    public native void addItem(BaseItem item) /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var itemJS = item.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.addItem(itemJS);
    }-*/;

    /**
     * Adds a separator bar to the menu.
     */
    public native void addSeparator() /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.addSeparator();
    }-*/;

    /**
     * Creates a new {@link TextItem} with the supplied text and adds it to the menu.
     *
     * @param text the text to add
     */
    public native void addText(String text) /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.addText(text);
    }-*/;

    /**
     * Gets an Item.
     *
     * @param itemId the item Id
     * @return the item
     */
    public native BaseItem getItem(String itemId) /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var item = menu.items.get(itemId);
        if(item == null || item === undefined) {
            return null;
        } else {
            return @com.gwtext.client.widgets.menu.BaseItem::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
        }
    }-*/;

    /**
     * Hides this menu.
     */
    public native void hide() /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.hide();
    }-*/;

    /**
     * Hides this menu and optionally all parent menus.
     *
     * @param deep true to hide all parent menus recursively, if any (defaults to false)
     */
    public native void hide(boolean deep) /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.hide(deep);
    }-*/;

    /**
     * Inserts an e{@link Item} to the menu at a specified index.
     *
     * @param index the index to insert
     * @param item the item to insert
     */
    public native void insert(int index, BaseItem item) /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var itemJS = item.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.insert(index, itemJS);
    }-*/;

    /**
     * Returns true if the menu is currently displayed, else false.
     * 
     * @return true if visible
     */
    public native boolean isVisible() /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.isVisible();
    }-*/;

    /**
     * Removes an {@link Item} from the menu and destroys the object.
     * 
     * @param item the item to remove
     */
    public native void remove(BaseItem item) /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var itemJS = item.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.remove(itemJS);
    }-*/;

    /**
     * Removes and destroys all items in the menu
     */
    public native void removeAll() /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.removeAll();
    }-*/;

    /**
     * Displays this menu relative to another element.
     *
     * @param id the element ID to align to
     */
    public native void show(String id) /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.show(id);
    }-*/;

    /**
     * Displays this menu at a specific xy position.
     *
     * @param x the X position
     * @param y the Y position
     */
    public void showAt(int x, int y) {
        int[] xyPosition = new int[]{x, y};
        showAt(xyPosition);
    }

    /**
     * Displays this menu at a specific xy position.
     *
     * @param xy the xy position
     */
    public void showAt(int[] xy) {
        showAt(jsObj, JavaScriptObjectHelper.convertToJavaScriptArray(xy), null);
    }

    /**
     * Displays this menu at a specific xy position.
     * 
     * @param x the X position
     * @param y the Y position
     * @param parentMenu the menu's parent menu, if applicable
     */
    public void showAt(int x, int y, Menu parentMenu) {
        int[] xyPosition = new int[]{x, y};
        showAt(jsObj, JavaScriptObjectHelper.convertToJavaScriptArray(xyPosition), parentMenu.getJsObj());
    }

    private static native void showAt(JavaScriptObject menu, JavaScriptObject xyPosition, JavaScriptObject parentMenu) /*-{
        menu.showAt(xyPosition, parentMenu);
    }-*/;

    /**
     * Add a menu listener.
     *
     * @param listener the listener
     */
    public native void addMenuListener(MenuListener listener)/*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var menuJ = this;

        menu.addListener('beforehide',
                function(source) {
                    return listener.@com.gwtext.client.widgets.menu.event.MenuListener::doBeforeHide(Lcom/gwtext/client/widgets/menu/Menu;)(menuJ);
                }
        );

        menu.addListener('beforeshow',
                function(source) {
                    return listener.@com.gwtext.client.widgets.menu.event.MenuListener::doBeforeShow(Lcom/gwtext/client/widgets/menu/Menu;)(menuJ);
                }
        );

        menu.addListener('click',
                function(source, menuItem, event) {
                    var menuItemId = (menuItem == null || menuItem === undefined) ? null : menuItem.id;
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    return listener.@com.gwtext.client.widgets.menu.event.MenuListener::onClick(Lcom/gwtext/client/widgets/menu/Menu;Ljava/lang/String;Lcom/gwtext/client/core/EventObject;)(menuJ, menuItemId, e);
                }
        );

        menu.addListener('hide',
                function(source) {
                    return listener.@com.gwtext.client.widgets.menu.event.MenuListener::onHide(Lcom/gwtext/client/widgets/menu/Menu;)(menuJ);
                }
        );

        menu.addListener('itemclick',
                function(item, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    var itemJ = @com.gwtext.client.widgets.menu.BaseItem::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
                    return listener.@com.gwtext.client.widgets.menu.event.MenuListener::onItemClick(Lcom/gwtext/client/widgets/menu/BaseItem;Lcom/gwtext/client/core/EventObject;)(itemJ, e);
                }
        );

        //TODO getting undefined for menuitemid onmouseover
        menu.addListener('mouseout',
                //todo order inconsistent
                function(source, event, menuItem) {
                    var menuItemJ = null;
                    if(menuItem != null && !(menuItem === undefined)) {
                        menuItemJ = @com.gwtext.client.widgets.menu.BaseItem::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(menuItem);
                    }
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    return listener.@com.gwtext.client.widgets.menu.event.MenuListener::onMouseOut(Lcom/gwtext/client/widgets/menu/Menu;Lcom/gwtext/client/widgets/menu/BaseItem;Lcom/gwtext/client/core/EventObject;)(menuJ, menuItemJ, e);
                }
        );

        //TODO getting undefined for menuitemid onmouseover
        menu.addListener('mouseover',
                function(source, event, menuItem) {
                    var menuItemJ = null;
                    if(menuItem != null && !(menuItem === undefined)) {
                        menuItemJ = @com.gwtext.client.widgets.menu.BaseItem::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(menuItem);
                    }
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    return listener.@com.gwtext.client.widgets.menu.event.MenuListener::onMouseOver(Lcom/gwtext/client/widgets/menu/Menu;Lcom/gwtext/client/widgets/menu/BaseItem;Lcom/gwtext/client/core/EventObject;)(menuJ, menuItemJ, e);
                }
        );

        menu.addListener('show',
                function(source) {
                    return listener.@com.gwtext.client.widgets.menu.event.MenuListener::onShow(Lcom/gwtext/client/widgets/menu/Menu;)(menuJ);
                }
        );
     }-*/;
}

