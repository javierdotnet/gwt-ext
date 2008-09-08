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
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.ContainerLayout;

/**
 * Creates a fieldset container for layout and rendering of fields in a {@link Form}.
 *
 * @author Sanjiv Jivan
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
        setAutoHeight(true);
    }

    public FieldSet(String title) {
        setTitle(title);
        setAutoHeight(true);
    }

    public FieldSet(String title, int labelWidth) {
        setTitle(title);
        setLabelWidth(labelWidth);
        setAutoHeight(true);
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
	
	/**
	 * Overwriting this method so that the labels are taken care of.  This
	 * method will call the super method when the removeAll is called
	 */
	public void removeAll(){
		super.removeAll();
		removeLabels(false);
	}
	
	/**
	 * Overwriting this method so that the labels are taken care of.  This
	 * method will call the super method when the removeAll is called
	 */
	public void removeAll(boolean autoDestroy){
		super.removeAll(autoDestroy);
		removeLabels(autoDestroy);
	}
	
	/**
	 * Private method that will remove the labels in the fieldSet after
	 * the field itself has been removed.
	 * @param autoDestroy to destroy the label or not.
	 */
	private native void removeLabels(boolean autoDestroy) /*-{
		var fieldset = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		if(autoDestroy){
			fieldset.getEl().update("");
		}
		else{
			// don't know what to do since the superclass just hides the fields...
			// for now, it's the same as autoDestroy but if someone has a better
			// idea, they we should change here!!!
			fieldset.getEl().update("");
		}
	}-*/;
}
