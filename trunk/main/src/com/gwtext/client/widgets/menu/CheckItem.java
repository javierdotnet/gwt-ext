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
import com.gwtext.client.widgets.menu.event.CheckItemListener;

/**
 * Adds a menu item that contains a checkbox by default, but can also be part of a radio group.
 */
public class CheckItem extends Item {

/*    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()*//*-{
        var c = new $wnd.Ext.menu.CheckItem();
        @com.gwtext.client.widgets.menu.CheckItem::configPrototype = c.initialConfig;
    }-*//*;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}*/

	protected JavaScriptObject getConfigPrototype() {
		return JavaScriptObjectHelper.createObject();
	}

	/**
     * Create a new CheckItem.
     *
     */
    public CheckItem() {
    }

    /**
     * Create a new CheckItem.
     *
      * @param text the CheckItem text
     */
    public CheckItem(String text) {
        setText(text);
    }

    /**
     * Create a new CheckItem.
     *
     * @param text the CheckItem text
     * @param checked true for checked 
     */
    public CheckItem(String text, boolean checked) {
        super(text);
        setChecked(checked);
    }

    public CheckItem(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
        return new $wnd.Ext.menu.CheckItem(jsObj);
    }-*/;

    private static CheckItem instance(JavaScriptObject jsObj) {
        return new CheckItem(jsObj);
    }
    /**
     * Set the checked state of this item.
     *
     * @param checked the checked state
     */
    private native void setCheckedRendered(boolean checked) /*-{
        var checkItem = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        checkItem.setChecked(checked);
    }-*/;

    /**
     * Add a CheckItemListener.
     *
     * @param listener the listener
     */
    public native void addListener(CheckItemListener listener)/*-{
        this.@com.gwtext.client.widgets.menu.BaseItem::addListener(Lcom/gwtext/client/widgets/menu/event/BaseItemListener;)(listener);
        var checkItemJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforecheckchange',
                function(source, checked) {
                    return listener.@com.gwtext.client.widgets.menu.event.CheckItemListener::doBeforeCheckChange(Lcom/gwtext/client/widgets/menu/CheckItem;Z)(checkItemJ, checked);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('checkchange',
                function(source, checked) {
                    listener.@com.gwtext.client.widgets.menu.event.CheckItemListener::onCheckChange(Lcom/gwtext/client/widgets/menu/CheckItem;Z)(checkItemJ, checked);
                }
        );
     }-*/;

    // --- config proeprties ---



    /**
     * True to mark the checkbox as checked (defaults to false). Note that if this checkbox is part of a radio group (group = true)
     * only the last item in the group that is initialized with checked = true will be rendered as checked.
     *
     * @param checked true to set as checked
     */
    public void setChecked(boolean checked) {
        if(!isRendered()) {
            setAttribute("checked", checked, true);
        } else {
            setCheckedRendered(checked);
        }

    }

    /**
     * True if checked.
     *
     * @return true if checked
     */
    public boolean isChecked() {
        return getAttributeAsBoolean("checked");
    }

    /**
     * All check items with the same group name will automatically be grouped into a single-select radio button group (defaults to '').
     *
     * @param group the group name
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setGroup(String group) throws IllegalStateException {
        setAttribute("group", group, true);
    }

    /**
     * The default CSS class to use for radio group check items (defaults to "x-menu-group-item").
     *
     * @param groupClass the group CSS class
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setGroupClass(String groupClass) throws IllegalStateException {
        setAttribute("groupClass", groupClass, true);
    }

    /**
     * The default CSS class to use for check items (defaults to "x-menu-item x-menu-check-item").
     *
     * @param itemCls the default CSS class to use for check items
     */
    public void setItemCls(String itemCls) throws IllegalArgumentException {
        setAttribute("itemCls", itemCls, true);
    }
}
