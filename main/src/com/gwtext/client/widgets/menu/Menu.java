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


public class Menu extends RequiredElementWidget {

    public Menu(String id) {
        super(id);
    }

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

    public native void addElement(Element element) /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.addElement(element);
    }-*/;

    public native void addElement(String elemID) /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.addElement(elemID);
    }-*/;

    public native void addItem(BaseItem item) /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var itemJS = item.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.addItem(itemJS);
    }-*/;

    public native void addSeparator() /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.addSeparator();
    }-*/;

    public native void addText(String text) /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.addText(text);
    }-*/;

    public native BaseItem getItem(String itemId) /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var item = menu.items.get(itemId);
        if(item == null || item === undefined) {
            return null;
        } else {
            return @com.gwtext.client.widgets.menu.BaseItem::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
        }
    }-*/;

    public native void hide() /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.hide();
    }-*/;

    public native void hide(boolean deep) /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.hide(deep);
    }-*/;

    public native void insert(int index, BaseItem item) /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var itemJS = item.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.insert(index, itemJS);
    }-*/;

    public native boolean isVisible() /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.isVisible();
    }-*/;

    public native void remove(BaseItem item) /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var itemJS = item.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.remove(itemJS);
    }-*/;

    public native void removeAll() /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.removeAll();
    }-*/;

    public native void show(String id) /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.show(id);
    }-*/;

    public native void show(String id, String position, Menu parentMenu) /*-{
        var menu = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var parentMenuJS = parentMenu.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        menu.show(id, position, parentMenuJS);
    }-*/;

    public void showAt(int x, int y) {
        int[] xyPosition = new int[]{x, y};
        showAt(xyPosition);
    }

    public void showAt(int[] xy) {
        showAt(jsObj, JavaScriptObjectHelper.convertToJavaScriptArray(xy), null);
    }

    public void showAt(int x, int y, Menu parentMenu) {
        int[] xyPosition = new int[]{x, y};
        showAt(jsObj, JavaScriptObjectHelper.convertToJavaScriptArray(xyPosition), parentMenu.getJsObj());
    }

    private static native void showAt(JavaScriptObject menu, JavaScriptObject xyPosition, JavaScriptObject parentMenu) /*-{
        menu.showAt(xyPosition, parentMenu);
    }-*/;

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
                    var menuItemId = menuItem.id;
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
                    if(menuItem != null && menuItem != undefined) {
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
                    if(menuItem != null && menuItem != undefined) {
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

