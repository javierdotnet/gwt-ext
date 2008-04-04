/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.dd;

import com.gwtext.client.util.JavaScriptObjectHelper;

public class DropTargetConfig extends DragDropConfig {
    /**
     * A named drag drop group to which this object belongs. If a group is specified,
     * then this object will only interact with other drag drop objects in the same group (defaults to undefined).
     *
     * @param ddGroup the group name
     */
    public void setdDdGroup(String ddGroup) {
        JavaScriptObjectHelper.setAttribute(jsObj, "ddGroup", ddGroup);
    }

    /**
     * The CSS class returned to the drag source when drop is allowed (defaults to "x-dd-drop-ok").
     *
     * @param dropAllowed drop allowed CSS
     */
    public void setDropAllowed(String dropAllowed) {
        JavaScriptObjectHelper.setAttribute(jsObj, "dropAllowed", dropAllowed);
    }

    /**
     * The CSS class returned to the drag source when drop is not allowed (defaults to "x-dd-drop-nodrop").
     *
     * @param dropNotAllowed drop not allowed CSS
     */
    public void setDropNotAllowed(String dropNotAllowed) {
        JavaScriptObjectHelper.setAttribute(jsObj, "dropNotAllowed", dropNotAllowed);
    }

    /**
     * The CSS class applied to the drop target element while the drag source is over it (defaults to "").
     * 
     * @param overClass the over class
     */
    public void setOverClass(String overClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "overClass", overClass);
    }

}
