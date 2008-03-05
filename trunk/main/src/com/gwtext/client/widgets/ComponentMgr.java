/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets;

import com.google.gwt.user.client.Element;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.Function;
import com.gwtext.client.util.DOMUtil;

/**
 * Component manager.
 */
public class ComponentMgr {

	/**
	 * Registers a function that will be called when a specified component is added to ComponentMgr.
	 *
	 * @param id the component ID
	 * @param fn the function to execute
	 */
	public native void onAvailable(String id, Function fn)/*-{
        $wnd.Ext.ComponentMgr.onAvailable(id, function() {
            fn.@com.gwtext.client.core.Function::execute()();
        });
    }-*/;

	/**
	 * Returns a component by id.
	 *
	 * @param id the component ID
	 * @return the component or null if not found
	 */
	public static native Component getComponent(String id) /*-{
        var comp = $wnd.Ext.ComponentMgr.get(id);
		return comp == null || comp === undefined ? null : @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(comp);
	}-*/;

	/**
	 * Returns a component that the passed element represents.
	 *
	 * @param element the element
	 * @return the component or null if not found
	 */
	public static Component getComponent(Element element) {
		return getComponent(DOMUtil.getID(element));
	}

	/**
	 * Returns a component that the passed element represents.
	 *
	 * @param element the element
	 * @return the component or null if not found
	 */
	public static Component getComponent(ExtElement element) {
		return getComponent(element.getDOM());
	}
}
