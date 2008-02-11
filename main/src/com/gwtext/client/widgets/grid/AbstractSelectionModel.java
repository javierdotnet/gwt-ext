/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;

/**
 * Abstract base class for grid SelectionModels. It provides the interface that should be implemented by descendant
 * classes. This class should not be directly instantiated.
 */
public abstract class AbstractSelectionModel extends JsObject {

    public AbstractSelectionModel() {
    }

    public AbstractSelectionModel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Returns true if the selections are locked.
     *
     * @return true if selections are locked
     */
    public native boolean isLocked() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return sm.isLocked();
    }-*/;

    /**
     * Locks the selections.
     */
    public native void lock() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.lock();
    }-*/;

    /**
     * Unlocks the selections.
     */
    public native void unlock() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.unlock();
    }-*/;
}
