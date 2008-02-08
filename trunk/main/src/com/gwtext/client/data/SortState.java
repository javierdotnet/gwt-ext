/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.data;

import com.gwtext.client.core.JsObject;
import com.gwtext.client.core.SortDir;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class SortState extends JsObject {

    private String field;
    private SortDir direction;


    public SortState(String field, SortDir direction) {
        this.field = field;
        this.direction = direction;
        jsObj = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(jsObj, "field", field);
        JavaScriptObjectHelper.setAttribute(jsObj, "direction", direction.getDirection());
    }

    public String getField() {
        return field;
    }

    public SortDir getDirection() {
        return direction;
    }
}
