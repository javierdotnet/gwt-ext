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

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.form.event.TextFieldListener;

/**
 * {@link TextField} configuration class.
 * 
 */
public class TextFieldConfig extends FieldConfig {

    private TextFieldListener textFieldListener;

    /**
     * False to validate that the value length > 0 (defaults to true).
     *
     * @param allowBlank false to disallow blank
     */
    public void setAllowBlank(boolean allowBlank) {
        JavaScriptObjectHelper.setAttribute(jsObj, "allowBlank", allowBlank);
    }

    /**
     * Error text to display if the allow blank validation fails (defaults to "This field is required").
     *
     * @param blankText error message for blank field
     */
    public void setBlankText(String blankText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "blankText", blankText);
    }

    /**
     * True to disable input keystroke filtering (defaults to false).
     *
     * @param disableKeyFilter true to disable 
     */
    public void setDisableKeyFilter(boolean disableKeyFilter) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disableKeyFilter", disableKeyFilter);
    }

    /**
     * The CSS class to apply to an empty field to style the emptyText (defaults to 'x-form-empty-field'). This class is
     * automatically added and removed as needed depending on the current field value.
     *
     * @param emptyClass the empty field CSS class
     */
    public void setEmptyClass(String emptyClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "emptyClass", emptyClass);
    }

    /**
     * The default text to display in an empty field (defaults to null).
     *
     * @param emptyText the empty field text
     */
    public void setEmptyText(String emptyText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "emptyText", emptyText);
    }

    /**
     * True if this field should automatically grow and shrink to its content.
     * 
     * @param grow true to allow grow
     */
    public void setGrow(boolean grow) {
        JavaScriptObjectHelper.setAttribute(jsObj, "grow", grow);
    }

    /**
     *  The maximum width to allow when grow = true (defaults to 800)
     *
     * @param growMax the max width
     */
    public void setGrowMax(int growMax) {
        JavaScriptObjectHelper.setAttribute(jsObj, "growMax", growMax);
    }

    /**
     * The minimum width to allow when grow = true (defaults to 30).
     * 
     * @param growMin the minimum width
     */
    public void setGrowMin(int growMin) {
        JavaScriptObjectHelper.setAttribute(jsObj, "growMin", growMin);
    }

    /**
     * An input mask regular expression that will be used to filter keystrokes that
     * don't match (defaults to null).
     *
     * @param maskRe the mask regular expression
     */
    public native void setMaskRe(String maskRe) /*-{
        var jsObj = this.@com.gwtext.client.core.JsObject::jsObj;
        jsObj['maskRe'] = new $wnd.RegExp(maskRe);
    }-*/;

    public void setMaxLength(int maxLength) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxLength", maxLength);
    }

    /**
     * Error text to display if the maximum length validation fails.
     * (defaults to "The maximum length for this field is {maxLength}")
     *
     * @param maxLengthText the max lenght error text
     */
    public void setMaxLengthText(String maxLengthText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxLengthText", maxLengthText);
    }

    /**
     * Minimum input field length required (defaults to 0).
     *
     * @param minLength the min length
     */
    public void setMinLength(int minLength) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minLength", minLength);
    }

    /**
     * Error text to display if the minimum length validation fails.
     *  (defaults to "The minimum length for this field is {minLength}")
     *
     * @param minLengthText the min length error text
     */
    public void setMinLengthText(String minLengthText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minLengthText", minLengthText);
    }

    /**
     * Set true if field is a password field.
     *
     * @param password true if passowrd field
     */
    public void setPassword(boolean password) {
        if(password) setInputType("password");
    }

    /**
     * A Regular Expressionto be tested against the field value during validation (defaults to null).
     * If available, this regex will be evaluated only after the basic validators all return true, and will be passed
     * the current field value. If the test fails, the field will be marked invalid using regexText.
     *
     * @param regex the regular expression
     */
    public void setRegex(String regex) {
        setRegex(jsObj, regex);
    }

    private native void setRegex(JavaScriptObject config, String regex) /*-{
        config['regex'] = new $wnd.RegExp(regex);
    }-*/;

    /**
     * The error text to display if regex is used and the test fails during validation (defaults to "").
     *
     * @param regexText the regexp text
     */
    public void setRegexText(String regexText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "regexText", regexText);
    }

    /**
     * True to automatically select any existing field text when the field receives input focus (defaults to false).
     *
     * @param selectOnFocus true to select text on focus
     */
    public void setSelectOnFocus(boolean selectOnFocus) {
        JavaScriptObjectHelper.setAttribute(jsObj, "selectOnFocus", selectOnFocus);
    }

    /**
     * Set a custom Validator for the Field.
     *
     * @param validator the field validator
     */
    public void setValidator(Validator validator) {
        setValidator(jsObj, validator);
    }

    private static String doValidate(Validator validator, String value) {
        try {
            return validator.validate(value) ? "true-val" : "false-val";
        } catch (ValidationException e) {
            return e.getMessage();
        }
    }

    private native void setValidator(JavaScriptObject config, Validator validator) /*-{
        config['validator'] = function(value) {            
            var val = @com.gwtext.client.widgets.form.TextFieldConfig::doValidate(Lcom/gwtext/client/widgets/form/Validator;Ljava/lang/String;)(validator, value);
            if(val === "true-val") {
                return true;
            } else if ( val === "false-val") {
                return false;
            } else {
                return val;
            }
        }
    }-*/;

    //http://extjs.com/forum/showthread.php?t=5717&highlight=vtype
    /**
     * A validation type name as defined in {@link VType} (defaults to null)
     *
     * @param vtype the validation type
     */
    public void setVtype(VType vtype) {
        JavaScriptObjectHelper.setAttribute(jsObj, "vtype", vtype.getVType());
    }

    /**
     * The validation type text if the validation specified by {@link #setVtype(VType)} fails.
     *
     * @param vtypeText
     */
    public void setVtypeText(String vtypeText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "vtypeText", vtypeText);
    }

    public TextFieldListener getTextFieldListener() {
        return textFieldListener;
    }

    public void setTextFieldListener(TextFieldListener textFieldListener) {
        this.textFieldListener = textFieldListener;
    }
}
