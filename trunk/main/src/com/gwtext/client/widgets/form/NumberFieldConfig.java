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

import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * {@link NumberField} config class.
 */
public class NumberFieldConfig extends TextFieldConfig {

    /**
     * False to disallow decimal values (defaults to true)
     * 
     * @param allowDecimals false to disallow decimal values
     */
    public void setAllowDecimals(boolean allowDecimals) {
        JavaScriptObjectHelper.setAttribute(jsObj, "allowDecimals", allowDecimals);
    }

    /**
     * False to prevent entering a negative sign (defaults to true).
     *
     * @param allowNegative false to prevent entering a negative sign
     */
    public void setAllowNegative(boolean allowNegative) {
        JavaScriptObjectHelper.setAttribute(jsObj, "allowNegative", allowNegative);
    }

    /**
     * The maximum precision to display after the decimal separator (defaults to 2).
     *
     * @param decimalPrecision the decimal precision
     */
    public void setDecimalPrecision(int decimalPrecision) {
        JavaScriptObjectHelper.setAttribute(jsObj, "decimalPrecision", decimalPrecision);
    }

    /**
     *  Character(s) to allow as the decimal separator (defaults to '.').
     *
     * @param decimalSeparator decimal separator
     */
    public void setDecimalSeparator(String decimalSeparator) {
        JavaScriptObjectHelper.setAttribute(jsObj, "decimalSeparator", decimalSeparator);
    }

    /**
     * Error text to display if the maximum value validation fails (defaults to "The maximum value for this field is {maxValue}").
     *
     * @param maxText the max error text
     */
    public void setMaxText(String maxText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxText", maxText);
    }

    /**
     * The maximum allowed value (defaults to Number.MAX_VALUE).
     *
     * @param maxValue the max value
     */
    public void setMaxValue(int maxValue) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxValue", maxValue);
    }

    /**
     * Error text to display if the minimum value validation fails (defaults to "The minimum value for this field is {minValue}").
     *
     * @param minText the min error text
     */
    public void setMinText(String minText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minText", minText);
    }

    /**
     *  The minimum allowed value (defaults to Number.NEGATIVE_INFINITY).
     *
     * @param minValue the min value
     */
    public void setMinValue(int minValue) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minValue", minValue);
    }

    /**
     * Error text to display if the value is not a valid number. For example, this can happen if a valid character like
     * '.' or '-' is left in the field with no number (defaults to "{value} is not a valid number").
     *
     * @param nanText the Nan text
     */
    public void setNanText(String nanText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "nanText", nanText);
    }
}
