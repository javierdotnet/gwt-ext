/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Multiline text field. Can be used as a direct replacement for traditional textarea fields, plus adds support for auto-sizing.
 *
 */
public class TextArea extends TextField {

	private static JavaScriptObject configPrototype;

	static {
		init();
	}

	private static native void init()/*-{
		var c = new $wnd.Ext.form.TextArea();
		@com.gwtext.client.widgets.form.TextArea::configPrototype = c.initialConfig;
	}-*/;

	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "textarea";
	}

	/**
     * Constructs a new TextArea.
     */
    public TextArea() {
    }

    public TextArea(String fieldLabel) {
        super(fieldLabel);
    }

	public TextArea(String fieldLabel, String name) {
		super(fieldLabel, name);
	}

	public TextArea(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
        return new $wnd.Ext.form.TextArea(jsObj);
    }-*/;

    // --- config properties ---

    /**
     * The maximum height to allow when grow = true (defaults to 1000).
     *
     * @param growMax the max height
     */
    public void setGrowMax(int growMax) {
        super.setGrowMax(growMax);
    }

    /**
     * The minimum height to allow when grow = true (defaults to 60).
     *
     * @param growMin the min height
     */
    public void setGrowMin(int growMin) {
        super.setGrowMin(growMin);
    }

    /**
     * True to prevent scrollbars from appearing regardless of how much text is in the field (equivalent to setting
     * overflow: hidden, defaults to false).
	 *
     * @param preventScrollbars true to prevent scrollbars
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setPreventScrollbars(boolean preventScrollbars) throws IllegalStateException {
        setAttribute("preventScrollbars", preventScrollbars, true);
    }
}
