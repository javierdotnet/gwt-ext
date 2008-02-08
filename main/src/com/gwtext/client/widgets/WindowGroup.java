/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;

/**
 * An object that represents a group of {@link Window} instances and provides z-order management and window activation behavior.
 */
public class WindowGroup extends JsObject {

    /**
     * Create a new WindowGroup.
     */
    public WindowGroup() {
        jsObj = create();
    }

    public WindowGroup(JavaScriptObject manager) {
        jsObj = manager;
    }

    private native JavaScriptObject create() /*-{
        return new $wnd.WindowGroup();
    }-*/;

    /**
     * Brings the specified window to the front of any other active windows.
     *
     * @param windowID the window ID
     */
    public native void bringToFront(String windowID) /*-{
        var wg = this.@com.gwtext.client.core.JsObject::getJsObj()();
        wg.bringToFront(windowID);
    }-*/;

    /**
     * Brings the specified window to the front of any other active windows.
     *
     * @param window the window
     */
    public native void bringToFront(Window window) /*-{
        var w = window.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var wg = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var wg = this.@com.gwtext.client.core.JsObject::getJsObj()();
        wg.bringToFront(w);
    }-*/;

    /**
     * Executes the specified function once for every window in the group, passing each window as the only parameter. Returning false from the function will stop the iteration.
     *
     * @param cb the traversal callback function
     */
    public native void each(ComponentTraversalCallback cb)/*-{
        var wg = this.@com.gwtext.client.core.JsObject::getJsObj()();
        wg.each(function(comp) {
            var compJ = @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(comp);
            return cb.@com.gwtext.client.widgets.ComponentTraversalCallback::execute(Lcom/gwtext/client/widgets/Component;)(compJ);
        });
    }-*/;

    /**
     * Gets a registered window by id.
     *
     * @param id the window ID
     * @return the window or null if not found
     */
    public native Window get(String id) /*-{
        var wg = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var w = wg.get(id);
        return w == null || w=== undefined ? null : @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(w);
    }-*/;

    /**
     * Gets the currently-active window in the group.
     *
     * @return the window or null if not found
     */
    public native Window getActive() /*-{
        var wg = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var w = wg.getActive();
        return w == null || w=== undefined ? null : @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(w);
    }-*/;

    /**
     * Returns zero or more windows in the group using the custom search function passed to this method. The function
     * should accept a single Ext.Window reference as its only argument and should return true if the window matches
     * the search criteria, otherwise it should return false.
     *
     * @param cb the callback
     * @return an array of windows
     */
    public native Window[] findBy(ComponentTraversalCallback cb)/*-{
        var wg = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var comps = wg.findBy(function(comp) {
            var compJ = @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(comp);
            return cb.@com.gwtext.client.widgets.ComponentTraversalCallback::execute(Lcom/gwtext/client/widgets/Component;)(compJ);
        });
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaComponentArray(Lcom/google/gwt/core/client/JavaScriptObject;)(comps);
    }-*/;

    /**
     * Hides all windows in the group.
     */
    public native void hideAll() /*-{
        var wg = this.@com.gwtext.client.core.JsObject::getJsObj()();
        wg.hideAll();
    }-*/;

    /**
     * Sends the specified window to the back of other active windows.
     *
     * @param windowID the window ID
     */
    public native void sendToBack(String windowID) /*-{
        var wg = this.@com.gwtext.client.core.JsObject::getJsObj()();
        wg.sendToBack(windowID);
    }-*/;

    /**
     * Sends the specified window to the back of other active windows.
     *
     * @param window the window
     */
    public native void sendToBack(Window window) /*-{
        var w = window.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var wg = this.@com.gwtext.client.core.JsObject::getJsObj()();
        wg.sendToBack(w);
    }-*/;

    /**
     * The starting z-index for windows (defaults to 9000).
     *
     * @param zseed the zseed
     */
    public native void setZseed(int zseed) /*-{
        var wg = this.@com.gwtext.client.core.JsObject::getJsObj()();
        wg.zseed = zseed;
    }-*/;
}