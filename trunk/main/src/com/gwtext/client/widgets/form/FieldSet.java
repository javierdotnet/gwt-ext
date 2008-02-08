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
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.ContainerLayout;

/**
 * Creates a fieldset container for layout and rendering of fields in a {@link Form}.
 *
 */
public class FieldSet extends Panel {

	private static JavaScriptObject configPrototype;

	static {
		init();
	}

	private static native void init()/*-{
        var c = new $wnd.Ext.form.FieldSet();
        @com.gwtext.client.widgets.form.FieldSet::configPrototype = c.initialConfig;
    }-*/;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

    public String getXType() {
        return "fieldset";
    }


	/**
     * Creates a new FieldSet.
     */
    public FieldSet() {
    }

    public FieldSet(String title) {
        setTitle(title);
    }

    public FieldSet(String title, int labelWidth) {
        setTitle(title);
        setLabelWidth(labelWidth);
    }

    public FieldSet(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
        return new $wnd.Ext.form.FieldSet(jsObj);
    }-*/;


    // --- config properties ---

	/** 
	 * The base CSS class applied to the fieldset (defaults to 'x-fieldset').
     *
	 * @param baseCls the base CSS class applied to the fieldset (defaults to 'x-fieldset').
	 * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
    public void setBaseCls(String baseCls) throws IllegalStateException {
		setAttribute("baseCls", baseCls, true);
	}

	/**
	 *  The name to assign to the fieldset's checkbox if checkboxToggle = true (defaults to '[checkbox id]-checkbox').
     *
	 * @param checkboxName the name to assign to the fieldset's checkbox if checkboxToggle = true (defaults to '[checkbox id]-checkbox').
	 * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setCheckboxName(String checkboxName) throws IllegalStateException {
		setAttribute("checkboxName", checkboxName, true);
	}

	/**
	 * True to render a checkbox into the fieldset frame just in front of the legend (defaults to false). The fieldset
     * will be expanded or collapsed when the checkbox is toggled.
     *
	 * @param checkboxToggle true to render a checkbox into the fieldset frame just in front of the legend (defaults to false).
	 * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setCheckboxToggle(boolean checkboxToggle) throws IllegalStateException {
		setAttribute("checkboxToggle", checkboxToggle, true);
	}

	/**
	 * A css class to apply to the x-form-item of fields. This property cascades to child containers.
     *
	 * @param itemCls a css class to apply to the x-form-item of fields. This property cascades to child containers.
	 * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setItemCls(String itemCls) throws IllegalStateException {
		setAttribute("itemCls", itemCls, true);
	}

	/**
	 * The width of labels. This property cascades to child containers.
     *
	 * @param labelWidth The width of labels. This property cascades to child containers.
	 * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setLabelWidth(int labelWidth) throws IllegalStateException {
		setAttribute("labelWidth", labelWidth, true);
	}

	/**
     * The {@link com.gwtext.client.widgets.Container} layout to use inside the fieldset (defaults to {@link com.gwtext.client.widgets.layout.FormLayout}).
     *
	 * @param layout the container layout to use inside the fieldset
	 * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setLayout(ContainerLayout layout) throws IllegalStateException {
		setAttribute("layout", layout.getJsObj(), true);
	}

	/**
     * The fieldset legend text.
     *
	 * @param legend the fieldset legend text.
	 * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setLegend(String legend) throws IllegalStateException {
        setAttribute("legend", legend, true);
    }
}
