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
package com.gwtext.client.widgets;

import com.gwtext.client.util.JavaScriptObjectHelper;

import java.util.Date;

public class EditorConfig extends ComponentConfig {

    public void setAlignment(String alignment) {
        JavaScriptObjectHelper.setAttribute(jsObj, "alignment", alignment);
    }

    public void setAutosize(boolean autosize) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autosize", autosize);
    }

    public void setAutosize(String autosize) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autosize", autosize);
    }

    public void setCancelOnEsc(boolean cancelOnEsc) {
        JavaScriptObjectHelper.setAttribute(jsObj, "cancelOnEsc", cancelOnEsc);
    }

    public void setCompleteOnEnter(boolean completeOnEnter) {
        JavaScriptObjectHelper.setAttribute(jsObj, "completeOnEnter", completeOnEnter);
    }

    public void setConstrain(boolean constrain) {
        JavaScriptObjectHelper.setAttribute(jsObj, "constrain", constrain);
    }

    public void setHideEl(boolean hideEl) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hideEl", hideEl);
    }

    public void setIgnoreNoChange(boolean ignoreNoChange) {
        JavaScriptObjectHelper.setAttribute(jsObj, "ignoreNoChange", ignoreNoChange);
    }

    public void setRevertInvalid(boolean revertInvalid) {
        JavaScriptObjectHelper.setAttribute(jsObj, "revertInvalid", revertInvalid);
    }

    public void setShadow(boolean shadow) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shadow", shadow);
    }

    public void setShadow(String shadow) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shadow", shadow);
    }

    public void setUpdateEl(boolean updateEl) {
        JavaScriptObjectHelper.setAttribute(jsObj, "updateEl", updateEl);
    }

    public void setValue(String value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "value", value);
    }

    public void setValue(Date value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "value", value);
    }

    public void setValue(long value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "value", value);
    }

    public void setValue(double value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "value", value);
    }

    public void setValue(boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "value", value);
    }        
}
