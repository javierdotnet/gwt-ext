/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package com.gwtext.client.widgets.form;

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.form.event.FieldListener;

import java.util.Date;

/**
 * The Field configuration class.
 *
 * @see Field
 */
public class FieldConfig extends BaseConfig {

    private FieldListener fieldListener;

    /**
     * Set the fields ID.
     *
     * @param id field id
     */
    public void setId(String id) {
        JavaScriptObjectHelper.setAttribute(jsObj, "id", id);
    }

    /**
     * Returns the fields ID.
     *
     * @return the field ID
     */
    public String getId() {
        return JavaScriptObjectHelper.getAttribute(jsObj, "id");
    }

    
    public void setAutoCreate(boolean autoCreate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoCreate", autoCreate);
    }

    public boolean isAutoCreate() {
        return  JavaScriptObjectHelper.getAttributeAsBoolean(jsObj, "autoCreate");
    }

    public void setAutoCreate(String autoCreate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoCreate", autoCreate);
    }

    /**
     * A CSS class to apply to the field's underlying element.
     *
     * @param cls the CSS class
     */
    public void setCls(String cls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "cls", cls);
    }

    /**
     * True to disable the field (defaults to false).
     *
     * @param disabled true to disable
     */
    public void setDisabled(boolean disabled) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disabled", disabled);
    }

    /**
     * The default CSS class for the field (defaults to "x-form-field").
     *
     * @param fieldClass the fields class
     */
    public void setFieldClass(String fieldClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "fieldClass", fieldClass);
    }

    /**
     * The CSS class to use when the field receives focus (defaults to "x-form-focus").
     *
     * @param focusClass CSS class on focus
     */
    public void setFocusClass(String focusClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "focusClass", focusClass);
    }

    //not in docs
    /**
     * Set the fields label.
     *
     * @param fieldLabel the field label
     */
    public void setFieldLabel(String fieldLabel) {
        JavaScriptObjectHelper.setAttribute(jsObj, "fieldLabel", fieldLabel);
    }

    /**
     * The type attribute for input fields -- e.g. radio, text, password (defaults to "text").
     *
     * @param inputType the input type
     */
    public void setInputType(String inputType) {
        JavaScriptObjectHelper.setAttribute(jsObj, "inputType", inputType);
    }

    /**
     * The CSS class to use when marking a field invalid (defaults to "x-form-invalid").
     *
     * @param invalidClass CSS class when field is invalid
     */
    public void setInvalidClass(String invalidClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "invalidClass", invalidClass);
    }

    /**
     * The error text to use when marking a field invalid and no message is provided (defaults to "The value in this field is invalid").
     *
     * @param invalidText invalid text on error
     */
    public void setInvalidText(String invalidText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "invalidText", invalidText);
    }

	//not in ext docs
    /**
     * Set the CSS style of the fields label. For example 'display:none'.
     *
     * @param labelStyle the CSS style for the fields label
     */
    public void setLabelStyle(String labelStyle) {
        JavaScriptObjectHelper.setAttribute(jsObj, "labelStyle", labelStyle);
    }

	//not in ext docs
    /**
     * The seprator between the fields label and the field. Can use ' ' or '&amp;nbsp;'
     * 
     * @param labelSeparator
     */
    public void setLabelSeparator(String labelSeparator) {
        JavaScriptObjectHelper.setAttribute(jsObj, "labelSeparator", labelSeparator);
    }

    //todo enum
    /**
     * The effect used when displaying a validation message under the field (defaults to 'normal').
     * Other possible values are "slide" and "slideRight"
     *
     * @param msgFx validation message style
     */
    public void setMsgFx(String msgFx) {
        JavaScriptObjectHelper.setAttribute(jsObj, "msgFx", msgFx);
    }

    /**
     * The location where error text should display. Should be one of the following values (defaults to 'qtip') :
     *
     * <pre>
     * Value         Description
     * -----------   ----------------------------------------------------------------------
     * qtip          Display a quick tip when the user hovers over the field
     * title         Display a default browser title attribute popup
     * under         Add a block div beneath the field containing the error text
     * side          Add an error icon to the right of the field with a popup on hover
     * [element id]  Add the error text directly to the innerHTML of the specified element</pre>
     *
     * @param msgTarget the error message target
     */
    public void setMsgTarget(String msgTarget) {
        JavaScriptObjectHelper.setAttribute(jsObj, "msgTarget", msgTarget);
    }

    /**
     * Set the field's HTML name attribute.
     *
     * @param name the fields name
     */
    public void setName(String name) {
        JavaScriptObjectHelper.setAttribute(jsObj, "name", name);
    }

    /**
     * True to mark the field as readOnly in HTML (defaults to false) -- Note: this only sets the element's readOnly DOM attribute.
     *
     * @param readOnly true to mark field read only
     */
    public void setReadOnly(boolean readOnly) {
        JavaScriptObjectHelper.setAttribute(jsObj, "readOnly", readOnly);
    }

    /**
     * The tabIndex for this field. Note this only applies to fields that are rendered, not those which are built via applyTo.
     *
     * @param tabIndex the fields tab index
     */
    public void setTabIndex(int tabIndex) {
        JavaScriptObjectHelper.setAttribute(jsObj, "tabIndex", tabIndex);
    }

    /**
     * Whether the field should validate when it loses focus (defaults to true).
     *
     * @param validateOnBlur true to validate on blur
     */
    public void setValidateOnBlur(boolean validateOnBlur) {
        JavaScriptObjectHelper.setAttribute(jsObj, "validateOnBlur", validateOnBlur);
    }

    /**
     * The length of time in milliseconds after user input begins until validation is initiated (defaults to 250).
     *
     * @param validationDelay the validation delay in milliseconds
     */
    public void setValidationDelay(int validationDelay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "validationDelay", validationDelay);
    }

    /**
     *  Set to false to disable automatic validation.
     *
     * @param validationEvent false to disable automatic validation
     */
    public void setValidationEvent(boolean validationEvent) {
        JavaScriptObjectHelper.setAttribute(jsObj, "validationEvent", validationEvent);
    }

    /**
     * The event that should initiate field validation. (defaults to "keyup")..
     *
     * @param validationEvent event to initiate validation
     */
    public void setValidationEvent(String validationEvent) {
        JavaScriptObjectHelper.setAttribute(jsObj, "validationEvent", validationEvent);
    }

    /**
     * A value to initialize this field with.
     * 
     * @param value the field value
     */
    public void setValue(String value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "value", value);
    }

    /**
     * A value to initialize this field with.
     *
     * @param value the field value
     */
    public void setValue(Date value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "value", value);
    }

    /**
     * Set the width of the field.
     *
     * @param width the field width
     */
    public void setWidth(int width) {
        JavaScriptObjectHelper.setAttribute(jsObj, "width", width);
    }

    /**
     * Set the width of the field.
     *
     * @param width the field width
     */
	public void setWidth(String width) {
        JavaScriptObjectHelper.setAttribute(jsObj, "width", width);
    }

    /**
     * Return the field listener.
     *
     * @return field listener
     */
    public FieldListener getFieldListener() {
        return fieldListener;
    }

    /**
     * Shortcut to set the field listener.
     *
     * @param fieldListener listener
     */
    public void setFieldListener(FieldListener fieldListener) {
        this.fieldListener = fieldListener;
    }
}
