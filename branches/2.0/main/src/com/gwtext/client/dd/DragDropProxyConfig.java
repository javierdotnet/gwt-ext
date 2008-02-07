/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.dd;

import com.gwtext.client.util.JavaScriptObjectHelper;

public class DragDropProxyConfig extends DragDropConfig {

    public void setResizeFrame(boolean resizeFrame) {
        JavaScriptObjectHelper.setAttribute(jsObj, "resizeFrame", resizeFrame);
    }

    public void setCenterFrame(boolean centerFrame) {
        JavaScriptObjectHelper.setAttribute(jsObj, "centerFrame", centerFrame);
    }

    public void setDragElId(String dragElId) {
        JavaScriptObjectHelper.setAttribute(jsObj, "dragElId", dragElId);
    }

}
