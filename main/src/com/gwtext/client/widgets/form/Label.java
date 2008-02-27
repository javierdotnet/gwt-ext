/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
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
     * @param text the tab index
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setText(String text) {
        setAttribute("text", text, true);
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
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setHtml(String html) {
        setAttribute("html", html, true);
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
