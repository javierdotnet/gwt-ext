/*
 * Copyright (c) 2007, Sanjiv Jivan
 * All rights reserved.
 *
 * Each copy or derived work must preserve the copyright notice and this
 * notice unmodified.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Numeric text field that provides automatic keystroke filtering and numeric validation.
 */
public class NumberField extends TextField {

    /**
     * Creates a new NumberField.
     */
    public NumberField() {
        this(new NumberFieldConfig());
    }

    /**
     * Creates a new NumberField using the specified configuration.
     *
     * @param config the configuration object
     */
    public NumberField(NumberFieldConfig config) {
        super(config);
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
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var value = field.getValue();
        return (value == null || value === undefined || value === '') ? null : $wnd.GwtExt.convertToJavaType(value);
    }-*/;

    /**
     * Sets the fields value.
     *
     * @param value the field value
     */
    public native void setValue(float value) /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
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
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
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
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return field.validateValue(null);
    }-*/;

    /**
     * Validates a value according to the field's validation rules and marks the field as invalid if the validation fails.
     *
     * @param value the value to validate
     * @return true if valid
     */
    public native boolean validateValue(float value) /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return field.validateValue(value);
    }-*/;
}
