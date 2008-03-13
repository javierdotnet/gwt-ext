/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.menu;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.Ext;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.menu.event.MenuListener;

/**
 * A menu object. This is the container to which you add all other menu items.
 */
public class Menu extends Widget {
	protected String id;
	protected JavaScriptObject config;
	protected JavaScriptObject jsObj;



    public Menu() {
		id = Ext.generateId();
		config = JavaScriptObjectHelper.createObject();
		JavaScriptObjectHelper.setAttribute(config, "id", id);
	}


	public void setId(String id) {
		JavaScriptObjectHelper.setAttribute(config, "id", id);
		this.id = id;
	}


	public Menu(JavaScriptObject jsObj) {
		id = JavaScriptObjectHelper.getAttribute(jsObj, "id");
		setElement(getElement(jsObj));
	}

	protected native Element getElement(JavaScriptObject jsObj) /*-{
        //var el = jsObj.el;
        var el = jsObj.getEl().dom;
        if(el == null || el === undefined) {
            return null;
            //forms buttons are detached when initially added
            //throw new Error('Widget ' + jsObj + ' has no element property set');
        } else {
            //There's an inconsistency in Ext where most elements have the property 'el' set to Ext's Element
            //with the exception of Menu->Item, Menu->Separator, Menu->TextItem,  Toolbar.Item and subclasses
            //(Toolbar.Separator, Toolbar.Spacer, Toolbar.TextItem) where the 'el' property is set to
            //the DOM element itself. Therefore retruning 'el' if 'el' is not Ext's Element. See details in issue 39.
             return el.dom || el ;
        }
    }-*/;

	public Element getElement() {
		if (super.getElement() == null) {

			if (jsObj == null) {
				jsObj = create(config);
			}
			setElement(getElement(jsObj));
		}
		return super.getElement();
	}

	public JavaScriptObject getOrCreateJsObj() {

		if (jsObj != null) {
			return jsObj;
		} else {
			//create object here
			jsObj = create(config);
			return jsObj;
		}
	}

	protected static native JavaScriptObject getComponent(String id)/*-{
		try {
			var cmp = $wnd.Ext.menu.MenuMgr.get(id);
			return (cmp === undefined || cmp == null) ? null : cmp;
		}catch(e){
			return null;
		}
	}-*/;

	private static Menu instance(JavaScriptObject jsObj) {
		return new Menu(jsObj);
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
        var menu = this.@com.gwtext.client.widgets.menu.Menu::getOrCreateJsObj()();
        menu.addElement(element);
    }-*/;

	/**
	 * Adds an Ext.Element object to the menu.
	 *
	 * @param elemID the element ID
	 */
	public native void addElement(String elemID) /*-{
        var menu = this.@com.gwtext.client.widgets.menu.Menu::getOrCreateJsObj()();
        menu.addElement(elemID);
    }-*/;

	/**
	 * Adds an {@link Item} to the menu.
	 *
	 * @param item the item to add
	 */
	public native void addItem(BaseItem item) /*-{
        var menu = this.@com.gwtext.client.widgets.menu.Menu::getOrCreateJsObj()();
        var itemJS = item.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        menu.addItem(itemJS);
    }-*/;

	/**
	 * Adds a separator bar to the menu.
	 */
	public native void addSeparator() /*-{
        var menu = this.@com.gwtext.client.widgets.menu.Menu::getOrCreateJsObj()();
        menu.addSeparator();
    }-*/;

	/**
	 * Creates a new {@link TextItem} with the supplied text and adds it to the menu.
	 *
	 * @param text the text to add
	 */
	public native void addText(String text) /*-{
        var menu = this.@com.gwtext.client.widgets.menu.Menu::getOrCreateJsObj()();
        menu.addText(text);
    }-*/;

	/**
	 * Gets an Item.
	 *
	 * @param itemId the item Id
	 * @return the item
	 */
	public native BaseItem getItem(String itemId) /*-{
        var menu = this.@com.gwtext.client.widgets.menu.Menu::getOrCreateJsObj()();
        var item = menu.items.get(itemId);
        if(item == null || item === undefined) {
            return null;
        } else {
			//todo2 ext2 doesnt have xtypes for baseitem and subclasses
			var itemJ = @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
			return itemJ =! null ? itemJ : @com.gwtext.client.widgets.menu.BaseItem::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
		}
    }-*/;

    /**
     * Gets all of this menu's items
     * 
     * @return the items
     */
    public BaseItem[] getItems() {
        JavaScriptObject nativeArray = getItems(getOrCreateJsObj());
        return convertFromNativeBaseItemsArray(nativeArray);
    };
    
    private static BaseItem[] convertFromNativeBaseItemsArray(JavaScriptObject nativeArray) {
        JavaScriptObject[] itemsj = JavaScriptObjectHelper.toArray(nativeArray);
        BaseItem[] items = new BaseItem[itemsj.length];
        for (int i = 0; i < itemsj.length; i++) {
            JavaScriptObject item = itemsj[i];
            items[i] = new BaseItem(item);
        }
        return items;
    }
    
    private native JavaScriptObject getItems(JavaScriptObject menu) /*-{
	    return menu.items.items;
	}-*/;

    /**
	 * Hides this menu.
	 */
	public native void hide() /*-{
        var menu = this.@com.gwtext.client.widgets.menu.Menu::getOrCreateJsObj()();
        menu.hide();
    }-*/;

	/**
	 * Hides this menu and optionally all parent menus.
	 *
	 * @param deep true to hide all parent menus recursively, if any (defaults to false)
	 */
	public native void hide(boolean deep) /*-{
        var menu = this.@com.gwtext.client.widgets.menu.Menu::getOrCreateJsObj()();
        menu.hide(deep);
    }-*/;

	/**
	 * Inserts an e{@link Item} to the menu at a specified index.
	 *
	 * @param index the index to insert
	 * @param item  the item to insert
	 */
	public native void insert(int index, BaseItem item) /*-{
        var menu = this.@com.gwtext.client.widgets.menu.Menu::getOrCreateJsObj()();
        var itemJS = item.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        menu.insert(index, itemJS);
    }-*/;

	/**
	 * Returns true if the menu is currently displayed, else false.
	 *
	 * @return true if visible
	 */
	public native boolean isVisible() /*-{
        var menu = this.@com.gwtext.client.widgets.menu.Menu::getOrCreateJsObj()();
        menu.isVisible();
    }-*/;

	/**
	 * Removes an {@link Item} from the menu and destroys the object.
	 *
	 * @param item the item to remove
	 */
	public native void remove(BaseItem item) /*-{
        var menu = this.@com.gwtext.client.widgets.menu.Menu::getOrCreateJsObj()();
        var itemJS = item.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        menu.remove(itemJS);
    }-*/;

	/**
	 * Removes and destroys all items in the menu
	 */
	public native void removeAll() /*-{
        var menu = this.@com.gwtext.client.widgets.menu.Menu::getOrCreateJsObj()();
        menu.removeAll();
    }-*/;

	/**
	 * Displays this menu relative to another element.
	 *
	 * @param id the element ID to align to
	 */
	public native void show(String id) /*-{
        var menu = this.@com.gwtext.client.widgets.menu.Menu::getOrCreateJsObj()();
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
		showAt(getOrCreateJsObj(), JavaScriptObjectHelper.convertToJavaScriptArray(xy), null);
	}

	/**
	 * Displays this menu at a specific xy position.
	 *
	 * @param x		  the X position
	 * @param y		  the Y position
	 * @param parentMenu the menu's parent menu, if applicable
	 */
	public void showAt(int x, int y, Menu parentMenu) {
		int[] xyPosition = new int[]{x, y};
		showAt(getOrCreateJsObj(), JavaScriptObjectHelper.convertToJavaScriptArray(xyPosition), parentMenu.getOrCreateJsObj());
	}

	private static native void showAt(JavaScriptObject menu, JavaScriptObject xyPosition, JavaScriptObject parentMenu) /*-{
        menu.showAt(xyPosition, parentMenu);
    }-*/;

	/**
	 * Add a menu listener.
	 *
	 * @param listener the listener
	 */
	public native void addListener(MenuListener listener)/*-{
        var menu = this.@com.gwtext.client.widgets.menu.Menu::getOrCreateJsObj()();
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
                    //var itemJ = @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
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
                       // menuItemJ = @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(menuItem);
                        menuItemJ = @com.gwtext.client.widgets.menu.BaseItem::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(menuItem)
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
                        //menuItemJ = @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(menuItem);
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

	// --- config properties ---

	/**
	 * True to allow multiple menus to be displayed at the same time (defaults to false).
	 *
	 * @param allowOtherMenus true to allow multiple menus
	 */
	public void setAllowOtherMenus(boolean allowOtherMenus) {
		JavaScriptObjectHelper.setAttribute(config, "allowOtherMenus", allowOtherMenus);
	}

	/**
	 * The default {@link com.gwtext.client.core.ExtElement#alignTo} anchor position value for this menu relative to its
     * element of origin (defaults to "tl-bl").
	 *
	 * @param anchorPosition defaults to t-b?
	 */
	public void setDefaultAlign(String anchorPosition) {
		JavaScriptObjectHelper.setAttribute(config, "defaultAlign", anchorPosition);
	}

	/**
	 * The minimum width of the menu in pixels (defaults to 120).
	 *
	 * @param minWidth the min width
	 */
	public void setMinWidth(int minWidth) {
		JavaScriptObjectHelper.setAttribute(config, "minWidth", minWidth);
	}

	/**
	 * True for the default effect.
	 *
	 * @param shadow true for shadow
	 */
	public void setShadow(boolean shadow) {
		JavaScriptObjectHelper.setAttribute(config, "shadow", shadow);
	}

	/**
	 * "sides" for the default effect, "frame" for 4-way shadow, and "drop" for bottom-right shadow (defaults to "sides")
	 *
	 * @param shadow the shadow settings
	 */
	public void setShadow(String shadow) {
		JavaScriptObjectHelper.setAttribute(config, "shadow", shadow);
	}

	/**
	 * The Ext.Element.alignTo anchor position value to use for submenus of this menu (defaults to "tl-tr?").
	 *
	 * @param anchorPosition the anchor position
	 */
	public void setSubMenuAlign(String anchorPosition) {
		JavaScriptObjectHelper.setAttribute(config, "subMenuAlign", anchorPosition);
	}


}

