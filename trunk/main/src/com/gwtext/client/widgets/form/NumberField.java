/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 *
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Numeric text field that provides automatic keystroke filtering and numeric validation.
 */
public class NumberField extends TextField {

    //tempory fix until fix gets rolled into Ext 1.1.2
    //see http://extjs.com/forum/showthread.php?p=79055#post79055
    //see http://code.google.com/p/gwt-ext/issues/detail?id=76&can=1
    //see http://groups.google.com/group/gwt-ext/browse_thread/thread/36cf6032ad34feeb
    static {
        init();
    }

    private native static void init() /*-{
        $wnd.Ext.form.NumberField.prototype.fixPrecision = function(value){
            var nan = isNaN(value);
            if(!this.allowDecimals || this.decimalPrecision == -1 || nan || !value){
                return nan ? '' : value;
            }
            return parseFloat(parseFloat(value).toFixed(this.decimalPrecision));
        }
    }-*/;

    /**
     * Creates a new NumberField.
     */
    public NumberField() {
    }

	public NumberField(String fieldLabel) {
		super(fieldLabel);
	}

	public NumberField(String fieldLabel, String name) {
		super(fieldLabel, name);
	}

	public NumberField(String fieldLabel, String name, int width) {
		super(fieldLabel, name, width);
	}

	public NumberField(String fieldLabel, String name, int width, float value) {
		super(fieldLabel, name, width);
        setValue(value);
    }

    public NumberField(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj)/*-{
        return new $wnd.Ext.form.NumberField(jsObj);
    }-*/;

    /**
     * Returns the field value.
     *
     * @return the field value
     */
    public native Number getValue() /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var value = field.getValue();
        return (value == null || value === undefined || value === '') ? null : $wnd.GwtExt.convertToJavaType(parseFloat(value));
    }-*/;

    /**
     * Sets the fields value.
     *
     * @param value the field value
     */
    public native void setValue(float value) /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        field.setValue(value);
    }-*/;

    /**
     * Sets the fields value.
     *
     * @param value the field value
     */
    public void setValue(Number value) {
        if(value == null) {
            setNullValue();
        } else {
            setValue(value.floatValue());
        }
    }

    /**
     * Sets the fields value to null.
     *
     */
    private native void setNullValue() /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        field.setValue(null);
    }-*/;

    /**
     * Validates a value according to the field's validation rules and marks the field as invalid if the validation fails.
     *
     * @param value the value to validate
     * @return true if valid
     */
    public boolean validateValue(Number value) {
        return value == null ? validateNullValue() : validateValue(value.floatValue());
    }

    /**
     * Validates a null value according to the field's validation rules and marks the field as invalid if the validation fails.
     *
     * @return true if valid
     */
    private native boolean validateNullValue() /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return field.validateValue(null);
    }-*/;

    /**
     * Validates a value according to the field's validation rules and marks the field as invalid if the validation fails.
     *
     * @param value the value to validate
     * @return true if valid
     */
    public native boolean validateValue(float value) /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return field.validateValue(value);
    }-*/;

    // --- config properties ---
	public String getXType() {
        return "numberfield";
    }

    /**
     * False to disallow decimal values (defaults to true).
     *
     * @param allowDecimals false to disallow decimal values
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setAllowDecimals(boolean allowDecimals) throws IllegalStateException {
        setAttribute("allowDecimals", allowDecimals, true);
    }

    /**
     * False to prevent entering a negative sign (defaults to true).
     *
     * @param allowNegative false to prevent entering a negative sign
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setAllowNegative(boolean allowNegative) throws IllegalStateException {
        setAttribute("allowNegative", allowNegative, true);
    }

    /**
     * The maximum precision to display after the decimal separator (defaults to 2).
	 *
     * @param decimalPrecision the decimal precision
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setDecimalPrecision(int decimalPrecision) throws IllegalStateException {
        setAttribute("decimalPrecision", decimalPrecision, true);
    }

    /**
     *  Character(s) to allow as the decimal separator (defaults to '.').
	 *
     * @param decimalSeparator decimal separator
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setDecimalSeparator(String decimalSeparator) throws IllegalStateException {
        setAttribute("decimalSeparator", decimalSeparator, true);
    }

    /**
     * Error text to display if the maximum value validation fails (defaults to "The maximum value for this field is {maxValue}").
     *
     * @param maxText the max error text
     */
    public void setMaxText(String maxText)  {
        setAttribute("maxText", maxText, true, true);
    }

    /**
     * The maximum allowed value (defaults to Number.MAX_VALUE).
     *
     * @param maxValue the max value
     */
    public void setMaxValue(int maxValue) {
        setAttribute("maxValue", maxValue, true, true);
    }

    /**
     * Error text to display if the minimum value validation fails (defaults to "The minimum value for this field is {minValue}").
     *
     * @param minText the min error text
     */
    public void setMinText(String minText)  {
        setAttribute("minText", minText, true, true);
    }

    /**
     *  The minimum allowed value (defaults to Number.NEGATIVE_INFINITY).
     *
     * @param minValue the min value
     */
    public void setMinValue(int minValue) {
        setAttribute("minValue", minValue, true, true);
    }

    /**
     * Error text to display if the value is not a valid number. For example, this can happen if a valid character like
     * '.' or '-' is left in the field with no number (defaults to "throws IllegalArgumentException {value} is not a valid number").
     *
     * @param nanText the Nan text
     */
    public void setNanText(String nanText) {
        setAttribute("nanText", nanText, true, true);
    }
}
