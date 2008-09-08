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
 
package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.BoxComponent;

/**
 * A label class for Forms.
 *
 * @author Sanjiv Jivan
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
