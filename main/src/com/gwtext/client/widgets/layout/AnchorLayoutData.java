/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.layout;

import com.gwtext.client.util.JavaScriptObjectHelper;

public class AnchorLayoutData extends LayoutData {

    public AnchorLayoutData(String anchor) {
        JavaScriptObjectHelper.setAttribute(jsObj, "anchor", anchor);
    }
}
