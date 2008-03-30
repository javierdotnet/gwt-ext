/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.BoxComponent;

/**
 * A label class for Forms.
 */
public class Label extends BoxComponent {
	/**
	 * Create a new Label
	 */
	public Label() {
	}

	/**
	 * Create a new label.
	 *
	 * @param label the label as text
	 */
	public Label(String label) {
		setText(label);
	}

	public Label(JavaScriptObject jsObj) {
		super(jsObj);
	}

	protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
        return new $wnd.Ext.form.Label(jsObj);
    }-*/;

	public String getXType() {
		return "label";
	}

	/**
	 * Set the label as text.
	 *
	 * @param text the label text
	 */
	public void setText(String text) {
		if (!isRendered()) {
			setAttribute("text", text, true);
		} else {
			DOM.setElementProperty(getElement(), "innerHTML", Format.htmlEncode(text));
		}
	}

	/**
	 * Return the label text.
	 *
	 * @return the text
	 */
	public String getText() {
		return getAttribute("text");
	}

	/**
	 * Set the label as html.
	 *
	 * @param html the html
	 */
	public void setHtml(String html) {
		if (!isRendered()) {
			setAttribute("html", html, true);
		} else {
			DOM.setElementProperty(getElement(), "innerHTML", html);
		}
	}

	/**
	 * Return the html.
	 *
	 * @return the html
	 */
	public String getHtml() {
		return getAttribute("html");
	}
}
