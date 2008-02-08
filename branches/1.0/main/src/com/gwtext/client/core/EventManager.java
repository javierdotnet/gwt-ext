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

import com.google.gwt.user.client.Element;
import com.gwtext.client.core.event.TextResizeListener;

/**
 * Registers event handlers that want to receive a normalized EventObject instead of the standard browser event and
 * provides several useful events directly.
 */
public class EventManager {

    /**
     * Appends an event handler to an element.
     *
     * @param element the element
     * @param eventName the event name
     * @param cb the callback to execute on event
     * @param config the listener config 
     */
    public static native void addListener(Element element, String eventName, EventCallback cb, ListenerConfig config) /*-{        
        $wnd.Ext.EventManager.addListener(element, eventName, function(event) {
                var e = (event === undefined || event == null) ? null : @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(e);
            },
            null,
            config.@com.gwtext.client.core.JsObject::jsObj
        );
    }-*/;

    /**
     * Fires when the document is ready (before onload and before images are loaded).
     * Can alternatively use the GWT entry point mechanism.
     * 
     * @param cb callback to execute
     */
    public static native void onDocumentReady(Function cb) /*-{
        $wnd.Ext.EventManager.onDocumentReady(function() {
                cb.@com.gwtext.client.core.Function::execute()();
            });
    }-*/;

    // excluded onWindowResize
    // Use com.google.gwt.user.client.WindowResizeListener instead

    public static native void addTextResizeListener(TextResizeListener listener) /*-{        
        $wnd.Ext.EventManager.onTextResize(
                function(oldSize, newSize) {
                   listener.@com.gwtext.client.core.event.TextResizeListener::onTextResize(II)(oldSize, newSize);
                });
    }-*/;
}
