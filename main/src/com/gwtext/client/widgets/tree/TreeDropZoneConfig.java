/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.tree;

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * A TreePanel DropZone configuration.
 */
public class TreeDropZoneConfig extends BaseConfig {

    public void setAllowParentInsert(boolean allowParentInsert) {
        JavaScriptObjectHelper.setAttribute(jsObj, "allowParentInsert", allowParentInsert);
    }

    public void setAllowContainerDrop(boolean allowContainerDrop) {
        JavaScriptObjectHelper.setAttribute(jsObj, "allowContainerDrop", allowContainerDrop);
    }

    public void setAppendOnly(boolean appendOnly) {
        JavaScriptObjectHelper.setAttribute(jsObj, "appendOnly", appendOnly);
    }

    public void setLastInsertClass(String lastInsertClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "lastInsertClass", lastInsertClass);
    }

    public void setDropNotAllowed(boolean dropNotAllowed) {
        JavaScriptObjectHelper.setAttribute(jsObj, "dropNotAllowed", dropNotAllowed);
    }
}
