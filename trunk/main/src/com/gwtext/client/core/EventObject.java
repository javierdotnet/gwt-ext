/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * A normalized Event object. Can use DOM.eventGetType(Event) for determinint event type too.
 */
public class EventObject extends JsObject {

    public static int BACKSPACE, CONTROL, DELETE, DOWN, END, ENTER, ESC, F5, HOME, LEFT, PAGEDOWN,
            PAGEUP, RETURN, RIGHT, SHIFT, SPACE, TAB, UP;

    /*
    Initializing constants from JsObject static bloc instead of here because of issue with OS X
    See http://code.google.com/p/gwt-ext/issues/detail?id=71
    static {
        initConstants();
    }*/

    public EventObject(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static EventObject instance(JavaScriptObject event) {
        return new EventObject(event);
    }

    /**
     * Gets the key code for the event.
     *
     * @return  the key code for the event.
     */
    public native int getCharCode() /*-{
        var e = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return e.getCharCode();
    }-*/;

    /**
     * Returns a normalized keyCode for the event.
     *
     * @return a normalized keyCode for the event.
     */
    public native int getKey() /*-{
        var e = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var key =  e.getKey();
        return key == null || key === undefined ? -1 : key;
    }-*/;

    /**
     * Gets the related target.
     *
     * @return the related target.
     */
    public native Element getRelatedTarget() /*-{
        var e = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var rt =  e.getRelatedTarget();
        return rt === undefined ? null : rt;
    }-*/;

    /**
     * Gets the target for the event.
     *
     * @return the target for the event.
     */
    public native Element getTarget() /*-{
        var e = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var el = e.getTarget();
        return el === undefined ? null : el;
    }-*/;

    public native Element getTarget(String selector, int maxDepth) /*-{
        var e = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var el =  e.getTarget(selector, maxDepth);
        return el === undefined ? null : el;
    }-*/;

    public native double getTime() /*-{
        var e = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return e.getTime();
    }-*/;

    public native int getWheelDelta() /*-{
        var e = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return e.getWheelDelta();
    }-*/;


    /**
     * Gets the xy coordinates of the event.
     *
     * @return the xy coordinates of the event.
     */
    public int[] getXY() {
        return new int[]{
                getPageX(),
                getPageY()
        };
    }

    /**
     * Gets the x coordinate of the event.
     *
     * @return the x coordinate of the event.
     */
    public native int getPageX() /*-{
        var e = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return e.getPageX();
    }-*/;

    /**
     * Gets the y coordinate of the event.
     *
     * @return the y coordinate of the event.
     */
    public native int getPageY() /*-{
        var e = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return e.getPageY();
    }-*/;

    /**
     * Returns true if the control, meta, shift or alt key was pressed during this event.
     *
     * @return true if the control, meta, shift or alt key was pressed during this event.
     */
    public native boolean hasModifier() /*-{
        var e = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return e.hasModifier();
    }-*/;

    /**
     * Stop the event (preventDefault and stopPropagation)
     */
    public native void stopEvent() /*-{
        var e = this.@com.gwtext.client.core.JsObject::getJsObj()();
        e.stopEvent();
    }-*/;

    /**
     *  Cancels bubbling of the event.
     */
    public native void stopPropagation() /*-{
        var e = this.@com.gwtext.client.core.JsObject::getJsObj()();
        e.stopPropagation();
    }-*/;

    /**
     * Returns true if the target of this event equals el or is a child of el
     *
     * @param id  the element ID
     * @return true if target within
     */
    public native boolean within(String id) /*-{
        var e = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var bool =  e.within(id);
        return bool == undefined || bool == null ? false : bool;
    }-*/;

    /**
     * Returns true if the target of this event equals el or is a child of el
     *
     * @param elem the element
     * @return true if target within
     */
    public native boolean within(Element elem) /*-{
        var e = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var bool = e.within(elem);
        return bool == undefined || bool == null ? false : bool;
    }-*/;

    /**
     * Return true if is Alt key.
     *
     * @return true if is Alt key.
     */
    public native boolean isAltKey() /*-{
        var e = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var isAlt = e.altKey;
        return (isAlt == null || isAlt === undefined) ? false : isAlt;
    }-*/;

    /**
     * Return true if is Ctrl key.
     *
     * @return true if is Ctrl key.
     */
    public native boolean isCtrlKey() /*-{
        var e = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var isCrtl = e.ctrlKey;
        return (isCrtl == null || isCrtl === undefined) ? false : isCrtl;
    }-*/;

    /**
     * Return true if is Shift key.
     *
     * @return true if is Shift key.
     */
    public native boolean isShiftKey() /*-{
        var e = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var isShift = e.shiftKey;
        return (isShift == null || isShift === undefined) ? false : isShift;
    }-*/;

    /**
     * @return -1 = none, 0 = left, 1 = middle, 2 right
     */
    public native int getMouseButton() /*-{
        var e = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return e.button;
    }-*/;

    /**
     * Return the native browser event.
     *
     * @return the native browser event
     */
    public native Event getBrowserEvent() /*-{
        var e = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return e.browserEvent;
    }-*/;
}

