/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.menu;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.menu.event.BaseItemListener;

//todo - only reason non abstract because menu item click event returns a base item and need to instanticte

//node baselem return null for getEl()
/**
 * The base class for all items that render into menus. BaseItem provides default rendering, activated state management
 *  and base configuration options shared by all menu components.
 */
public class BaseItem extends Component {

    public BaseItem() {
    }

    public BaseItem(JavaScriptObject jsObj) {
        super(jsObj);
    }

	protected JavaScriptObject getConfigPrototype() {
		return null;
	}

	//todo2 -- ext 2 doesnt have xtype for base item so need this
	private static BaseItem instance(JavaScriptObject jsObj) {
		return new BaseItem(jsObj);
	}
	/**
     * Adda BaseItem listener.
     *
     * @param listener the listener
     */
    public native void addListener(BaseItemListener listener)/*-{
        this.@com.gwtext.client.widgets.Component::addListener(Lcom/gwtext/client/widgets/event/ComponentListener;)(listener);
        var baseItemJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('activate',
                function(source) {
                    return listener.@com.gwtext.client.widgets.menu.event.BaseItemListener::onActivate(Lcom/gwtext/client/widgets/menu/BaseItem;)(baseItemJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('click',
                function(source, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    return listener.@com.gwtext.client.widgets.menu.event.BaseItemListener::onClick(Lcom/gwtext/client/widgets/menu/BaseItem;Lcom/gwtext/client/core/EventObject;)(baseItemJ, e);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('deactivate',
                function(source) {
                    return listener.@com.gwtext.client.widgets.menu.event.BaseItemListener::onDeactivate(Lcom/gwtext/client/widgets/menu/BaseItem;)(baseItemJ);
                }
        );
     }-*/;

    protected JavaScriptObject create(JavaScriptObject config) {
        throw new IllegalArgumentException("must be overridden");
    }

    // --- config properties ---

    /**
     * The CSS class to use when the item becomes activated (defaults to "x-menu-item-active")
     *
     * @param activeClass the active CSS class
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setActiveClass(String activeClass) throws IllegalStateException {
        setAttribute("activeClass", activeClass, true);
    }

    /**
     * The CSS class to use when the item becomes activated.
     *
     * @return the CSS class to use when the item becomes activated
     */
    public String getActiveClass() {
        return JavaScriptObjectHelper.getAttribute(config, "activeClass");
    }

    /**
     * True if this item can be visually activated (defaults to false)
     *
     * @param canActivate true if can be activated
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setCanActivate(boolean canActivate) throws IllegalStateException {
        setAttribute("canActivate", canActivate, true);
    }

    /**
     * True if this item can be visually activated (defaults to false).
     *
     * @return true if this item can be visually activated (defaults to false)
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public boolean isCanActivate() throws IllegalStateException {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "canActivate");
    }

    /**
     * Length of time in milliseconds to wait before hiding after a click (defaults to 100).
     *
     * @param hideDelay the hide delay
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setHideDelay(int hideDelay) throws IllegalStateException {
        setAttribute("hideDelay", hideDelay, true);
    }

    /**
     * Length of time in milliseconds to wait before hiding after a click (defaults to 100).
     *
     * @return the hide delay
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public int getHideDelay() throws IllegalStateException {
        return JavaScriptObjectHelper.getAttributeAsInt(config, "hideDelay");
    }

    /**
     * Length of time in milliseconds to wait before showing a hidden item  after a click (defaults to 100)
     *
     * @param showDelay the show delay
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setShowDelay(int showDelay) throws IllegalStateException {
        setAttribute("showDelay", showDelay, true);
    }

    /**
     * Length of time in milliseconds to wait before showing a hidden item  after a click (defaults to 100).
     *
     * @return the show delay
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public int getShowDelay() throws IllegalStateException {
        return JavaScriptObjectHelper.getAttributeAsInt(config, "showDelay");
    }

    /**
     * True to hide the containing menu after this item is clicked (defaults to true).
     *
     * @param hideOnClick true to hide on click
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setHideOnClick(boolean hideOnClick) throws IllegalStateException {
        setAttribute("hideOnClick", hideOnClick, true);
    }

    /**
     * True to hide the containing menu after this item is clicked (defaults to true).
     *
     * @return true to hide on click
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public boolean isHideOnClick() throws IllegalStateException {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "hideOnClick");
    }

	//todo 2.0, not in docs, should it be  here?
	public void setIcon(String icon) {
        setAttribute("icon", icon, true);
    }
}
