/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.form.event.CheckboxListener;

/**
 * Single checkbox field.
 */
public class Checkbox extends Field {

	private static JavaScriptObject configPrototype;

	static {
		init();
	}

	private static native void init()/*-{
		var c = new $wnd.Ext.form.Checkbox();
		var c = new $wnd.Ext.form.Checkbox();
		@com.gwtext.client.widgets.form.Checkbox::configPrototype = c.initialConfig;
	}-*/;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "checkbox";
	}


	public Checkbox(JavaScriptObject jsObj) {
		super(jsObj);
	}

	/**
	 * Creates a new Checkbox field.
	 */
	public Checkbox() {
	}

    /**
	 * Creates a new Checkbox field.
     *
     * @param boxLabel the box label
	 */
    public Checkbox(String boxLabel) {
        if (boxLabel != null) setBoxLabel(boxLabel);
    }

    /**
     * Creates a new Checkbox field.
     *
     * @param boxLabel the box label
     * @param name the field name
     */
    public Checkbox(String boxLabel, String name) {
        setBoxLabel(boxLabel);
        setName(name);
    }

    /**
     * Creates a new Checkbox field.
     *
     * @param boxLabel the box label
     * @param listener the checkbox listener
     */
    public Checkbox(String boxLabel, CheckboxListener listener) {
        if (boxLabel != null) setBoxLabel(boxLabel);
        addListener(listener);
    }

    protected native JavaScriptObject create(JavaScriptObject config)/*-{
        return new $wnd.Ext.form.Checkbox(config);    
    }-*/;

	/**
	 * Returns the checked state of the checkbox.
	 *
	 * @return true if checked, else false
	 */
	public native boolean getValue() /*-{
         var cb = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
         return cb.getValue();
     }-*/;

	/**
	 * Sets the checked state of the checkbox.
	 *
	 * @param checked true to chec the checkbox, false to uncheck it
	 */
	public native void setValue(boolean checked) /*-{
        var cb = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        cb.setValue(checked);
    }-*/;

	/**
	 * Add a checkbox listener.
	 *
	 * @param listener the listener
	 */
	public native void addListener(CheckboxListener listener) /*-{
        this.@com.gwtext.client.widgets.form.Field::addListener(Lcom/gwtext/client/widgets/form/event/FieldListener;)(listener);
        var fieldJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('check',
                function(fld, checked) {
                    listener.@com.gwtext.client.widgets.form.event.CheckboxListener::onCheck(Lcom/gwtext/client/widgets/form/Checkbox;Z)(fieldJ, checked);
                }
        );
    }-*/;

	// --- config properties ---


	/**
	 * The text that appears beside the checkbox.
	 *
	 * @param boxLabel the box label
	*/
	public void setBoxLabel(String boxLabel)  {
		setAttribute("boxLabel", boxLabel, true, true);
		setLabelSeparator("&nbsp;");
        if(isRendered()) {
            setFieldLabelRendered(boxLabel, getId());
        }
    }

    /**
     * The box label.
     *
     * @return the box label
     */
    public String getBoxLabel() {
        return getAttribute("boxLabel");
    }

    private native void setFieldLabelRendered(String fieldLabel, String fieldId) /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var label = $wnd.Ext.DomQuery.select($wnd.String.format('label[for="{0}"]', fieldId));
        if (label){
            //todo preserve user specified labelSeparator and only update the label text.
            //var separator = typeof field.container.labelSeparator == 'undefined' ? field.labelSeparator : field.container.labelSeparator;
            label[0].childNodes[0].nodeValue = fieldLabel;
        }
    }-*/;
	/**
	 * True if the the checkbox should render already checked (defaults to false).
	 *
	 * @param checked true to render checked
	 */
	public void setChecked(boolean checked) {
		if(!isRendered()) {
			setAttribute("checked", checked, true);
		} else {
			setValue(checked);
		}
	}

	/**
	 * The value that should go into the generated input element's value attribute.
	 *
	 * @param inputValue fields input value
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setInputValue(String inputValue) throws IllegalStateException {
		setAttribute("inputValue", inputValue, true);
	}
}
