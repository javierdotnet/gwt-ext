/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.core;

import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Base abstract configutation class.
 */
public abstract class BaseConfig extends JsObject {

    public BaseConfig() {
        jsObj = JavaScriptObjectHelper.createObject();
    }
}
