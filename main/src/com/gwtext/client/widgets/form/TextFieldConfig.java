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
import com.gwtext.client.widgets.form.event.TextFieldListener;
import com.google.gwt.core.client.JavaScriptObject;

public class TextFieldConfig extends FieldConfig {
    private TextFieldListener textFieldListener;

    public void setAllowBlank(boolean allowBlank) {
        JavaScriptObjectHelper.setAttribute(jsObj, "allowBlank", allowBlank);
    }

    public void setBlanktext(String blanktext) {
        JavaScriptObjectHelper.setAttribute(jsObj, "blanktext", blanktext);
    }

    public void setDisableKeyFilter(boolean disableKeyFilter) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disableKeyFilter", disableKeyFilter);
    }

    public void setEmptyClass(String emptyClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "emptyClass", emptyClass);
    }

    public void setEmptyText(String emptyText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "emptyText", emptyText);
    }

    public void setGrow(boolean grow) {
        JavaScriptObjectHelper.setAttribute(jsObj, "grow", grow);
    }

    public void setGrowMax(int growMax) {
        JavaScriptObjectHelper.setAttribute(jsObj, "growMax", growMax);
    }

    public void setGrowMin(int growMin) {
        JavaScriptObjectHelper.setAttribute(jsObj, "growMin", growMin);
    }

    public void setMaskRe(String maskRe) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maskRe", maskRe);
    }

    public void setMaxLength(int maxLength) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxLength", maxLength);
    }

    public void setMaxLengthText(String maxLengthText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxLengthText", maxLengthText);
    }

    public void setMinLength(int minLength) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minLength", minLength);
    }

    public void setMinLengthText(String minLengthText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minLengthText", minLengthText);
    }


      public void setRegex(String regex) {
        setRegex(jsObj, regex);
    }

    private native void setRegex(JavaScriptObject config, String regex) /*-{
        config['regex'] = new $wnd.RegExp(regex);
    }-*/;

    public void setRegexText(String regexText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "regexText", regexText);
    }

    public void setSelectOnFocus(boolean selectOnFocus) {
        JavaScriptObjectHelper.setAttribute(jsObj, "selectOnFocus", selectOnFocus);
    }


    public void setValidator(Validator validator) {
        setValidator(jsObj, validator);
    }

    private native void setValidator(JavaScriptObject config, Validator validator) /*-{
        config['validator'] = function(value) {
            return this.@com.gwtext.client.widgets.form.Validator::validate(Ljava/lang/String;)(value);
        }
    }-*/;

    //http://extjs.com/forum/showthread.php?t=5717&highlight=vtype
    public void setVtype(VType vtype) {
        JavaScriptObjectHelper.setAttribute(jsObj, "vtype", vtype.getVType());
    }

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