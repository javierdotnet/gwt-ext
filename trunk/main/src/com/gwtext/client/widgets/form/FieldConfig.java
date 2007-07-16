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

public class FieldConfig extends BaseConfig {
    private FieldListener fieldListener;

    public void setId(String id) {
        JavaScriptObjectHelper.setAttribute(jsObj, "id", id);
    }

    public void setAutoCreate(boolean autoCreate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoCreate", autoCreate);
    }
    
    public void setAutoCreate(String autoCreate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoCreate", autoCreate);
    }

    public void setCls(String cls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "cls", cls);
    }

    public void setDisabled(boolean disabled) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disabled", disabled);
    }

    public void setFieldClass(String fieldClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "fieldClass", fieldClass);
    }

    public void setFocusClass(String focusClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "focusClass", focusClass);
    }

    //not in docs
    public void setFieldLabel(String fieldLabel) {
        JavaScriptObjectHelper.setAttribute(jsObj, "fieldLabel", fieldLabel);
    }

    public void setInputType(String inputType) {
        JavaScriptObjectHelper.setAttribute(jsObj, "inputType", inputType);
    }

    public void setInvalidClass(String invalidClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "invalidClass", invalidClass);
    }

    public void setInvalidText(boolean invalidText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "invalidText", invalidText);
    }

    public void setMsgFx(String msgFx) {
        JavaScriptObjectHelper.setAttribute(jsObj, "msgFx", msgFx);
    }

    public void setMsgTarget(String msgTarget) {
        JavaScriptObjectHelper.setAttribute(jsObj, "msgTarget", msgTarget);
    }

    public void setName(String name) {
        JavaScriptObjectHelper.setAttribute(jsObj, "name", name);
    }

    public void setReadOnly(boolean readOnly) {
        JavaScriptObjectHelper.setAttribute(jsObj, "readOnly", readOnly);
    }
            
    public void setValidateOnBlur(boolean validateOnBlur) {
        JavaScriptObjectHelper.setAttribute(jsObj, "validateOnBlur", validateOnBlur);
    }

    public void setValidationDelay(int validationDelay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "validationDelay", validationDelay);
    }

    public void setValidationEvent(boolean validationEvent) {
        JavaScriptObjectHelper.setAttribute(jsObj, "validationEvent", validationEvent);
    }

    public void setValidationEvent(String validationEvent) {
        JavaScriptObjectHelper.setAttribute(jsObj, "validationEvent", validationEvent);
    }

    public void setValue(String value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "value", value);
    }

    public void setValue(Date value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "value", value);
    }

    //not in docs
    public void setWidth(int width) {
        JavaScriptObjectHelper.setAttribute(jsObj, "width", width);
    }

    public FieldListener getFieldListener() {
        return fieldListener;
    }

    public void setFieldListener(FieldListener fieldListener) {
        this.fieldListener = fieldListener;
    }
}
