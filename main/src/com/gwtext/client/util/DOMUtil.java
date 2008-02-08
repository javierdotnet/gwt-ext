/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.util;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * DOM related helper methods.
 */
public class DOMUtil {

	public static String getID(Widget widget) {
		return getID(widget.getElement());
	}

	public static String getID(Element element) {
		String id = DOM.getElementProperty(element, "id");
		return id == null || id.equals("") ? null : id;

	}


	public static void setID(Widget widget, String id) {
		setID(widget.getElement(), id);
	}

	public static void setID(Element element, String id) {
		DOM.setElementProperty(element, "id", id);
	}

}
