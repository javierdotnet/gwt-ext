/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.dd;

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class DragDropConfig extends BaseConfig {

    public void setTarget(boolean target) {
        JavaScriptObjectHelper.setAttribute(jsObj, "target", target);
    }

    public void setPrimaryButtonOnly(boolean primaryButtonOnly) {
        JavaScriptObjectHelper.setAttribute(jsObj, "primaryButtonOnly", primaryButtonOnly);
    }

    public void setMaintainOffset(boolean maintainOffset) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maintainOffset", maintainOffset);
    }

}
