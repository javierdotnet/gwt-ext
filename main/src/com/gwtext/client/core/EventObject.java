/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package com.gwtext.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

//DOM.eventGetType(Event)
public class EventObject extends JsObject {

    public static int BACKSPACE, CONTROL, DELETE, DOWN, END, ENTER, ESC, F5, HOME, LEFT, PAGEDOWN,
            PAGEUP, RETURN, RIGHT, SHIFT, SPACE, TAB, UP;

    static {
        initConstants();
    }

    public EventObject(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static EventObject instance(JavaScriptObject event) {
        return new EventObject(event);
    }

    public native int getCharCode() /*-{
        var e = this.@com.gwtext.client.core.JsObject::jsObj;
        return e.getCharCode();
    }-*/;

    public native int getKey() /*-{
        var e = this.@com.gwtext.client.core.JsObject::jsObj;
        return e.getKey();
    }-*/;

    public native Element getRelatedTarget() /*-{
        var e = this.@com.gwtext.client.core.JsObject::jsObj;
        return e.getRelatedTarget();
    }-*/;

    public native Element getTarget() /*-{
        var e = this.@com.gwtext.client.core.JsObject::jsObj;
        return e.getTarget();
    }-*/;

    public native Element getTarget(String selector, int maxDepth) /*-{
        var e = this.@com.gwtext.client.core.JsObject::jsObj;
        return e.getTarget(selector, maxDepth);
    }-*/;

    public native long getTime() /*-{
        var e = this.@com.gwtext.client.core.JsObject::jsObj;
        return e.getTime();
    }-*/;

    public native int getWheelDelta() /*-{
        var e = this.@com.gwtext.client.core.JsObject::jsObj;
        return e.getWheelDelta();
    }-*/;

    public int[] getXY() {
        return new int[]{
                getPageX(),
                getPageY()
        };
    }

    private native int getPageX() /*-{
        var e = this.@com.gwtext.client.core.JsObject::jsObj;
        return e.getPageX();
    }-*/;

    private native int getPageY() /*-{
        var e = this.@com.gwtext.client.core.JsObject::jsObj;
        return e.getPageY();
    }-*/;

    public native boolean hasModifier() /*-{
        var e = this.@com.gwtext.client.core.JsObject::jsObj;
        return e.hasModifier();
    }-*/;

    public native void stopEvent() /*-{
        var e = this.@com.gwtext.client.core.JsObject::jsObj;
        e.stopEvent();
    }-*/;

    public native void stopPropagation() /*-{
        var e = this.@com.gwtext.client.core.JsObject::jsObj;
        e.stopPropagation();
    }-*/;

    public native boolean within(String id) /*-{
        var e = this.@com.gwtext.client.core.JsObject::jsObj;
        e.within(id);
    }-*/;

    public native boolean within(Element elem) /*-{
        var e = this.@com.gwtext.client.core.JsObject::jsObj;
        e.within(elem);
    }-*/;

    public native boolean isAltKey() /*-{
        var e = this.@com.gwtext.client.core.JsObject::jsObj;
        return e.altKey;
    }-*/;

    public native boolean isCtrlKey() /*-{
        var e = this.@com.gwtext.client.core.JsObject::jsObj;
        return e.ctrlKey;
    }-*/;

    public native boolean isShiftKey() /*-{
        var e = this.@com.gwtext.client.core.JsObject::jsObj;
        return e.shiftKey;
    }-*/;

    //-1 = none, 0 = left, 1 = middle, 2 right
    public native int getMouseButton() /*-{
        var e = this.@com.gwtext.client.core.JsObject::jsObj;
        return e.button;
    }-*/;


    public native Event getBrowserEvent() /*-{
        var e = this.@com.gwtext.client.core.JsObject::jsObj;
        return e.browserEvent;
    }-*/;

    private native static void initConstants() /*-{
        @com.gwtext.client.core.EventObject::BACKSPACE = $wnd.Ext.EventObject.BACKSPACE;
        @com.gwtext.client.core.EventObject::CONTROL = $wnd.Ext.EventObject.CONTROL;
        @com.gwtext.client.core.EventObject::DELETE = $wnd.Ext.EventObject.DELETE;
        @com.gwtext.client.core.EventObject::DOWN = $wnd.Ext.EventObject.DOWN;
        @com.gwtext.client.core.EventObject::END = $wnd.Ext.EventObject.END;
        @com.gwtext.client.core.EventObject::ENTER = $wnd.Ext.EventObject.ENTER;
        @com.gwtext.client.core.EventObject::ESC = $wnd.Ext.EventObject.ESC;
        @com.gwtext.client.core.EventObject::F5 = $wnd.Ext.EventObject.F5;
        @com.gwtext.client.core.EventObject::HOME = $wnd.Ext.EventObject.HOME;
        @com.gwtext.client.core.EventObject::LEFT = $wnd.Ext.EventObject.LEFT;
        @com.gwtext.client.core.EventObject::PAGEDOWN = $wnd.Ext.EventObject.PAGEDOWN;
        @com.gwtext.client.core.EventObject::PAGEUP = $wnd.Ext.EventObject.PAGEUP;
        @com.gwtext.client.core.EventObject::RETURN = $wnd.Ext.EventObject.RETURN;
        @com.gwtext.client.core.EventObject::RIGHT = $wnd.Ext.EventObject.RIGHT;
        @com.gwtext.client.core.EventObject::SHIFT = $wnd.Ext.EventObject.SHIFT;
        @com.gwtext.client.core.EventObject::SPACE = $wnd.Ext.EventObject.SPACE;
        @com.gwtext.client.core.EventObject::TAB = $wnd.Ext.EventObject.TAB;
        @com.gwtext.client.core.EventObject::UP = $wnd.Ext.EventObject.UP;
    }-*/;
}

