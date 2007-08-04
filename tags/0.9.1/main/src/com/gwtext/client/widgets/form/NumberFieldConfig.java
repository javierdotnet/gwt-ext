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

public class NumberFieldConfig extends TextFieldConfig {

    public void setAllowDecimals(boolean allowDecimals) {
        JavaScriptObjectHelper.setAttribute(jsObj, "allowDecimals", allowDecimals);
    }

    public void setAllowNegative(boolean allowNegative) {
        JavaScriptObjectHelper.setAttribute(jsObj, "allowNegative", allowNegative);
    }

    public void setDecimalPrecision(int decimalPrecision) {
        JavaScriptObjectHelper.setAttribute(jsObj, "decimalPrecision", decimalPrecision);
    }

    public void setDecimalSeparator(String decimalSeparator) {
        JavaScriptObjectHelper.setAttribute(jsObj, "decimalSeparator", decimalSeparator);
    }

    public void setMaxText(String maxText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxText", maxText);
    }

    public void setMaxValue(int maxValue) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxValue", maxValue);
    }

    public void setMinText(String minText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minText", minText);
    }

    public void setMinValue(int minValue) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minValue", minValue);
    }

    public void setNanText(String nanText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "nanText", nanText);
    }
}
