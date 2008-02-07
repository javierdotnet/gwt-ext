/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.event.ClickRepeaterListener;

/**
 * A wrapper class which can be applied to any element. Fires a "click" event while the mouse is pressed.
 * The interval between firings may be specified in the config but defaults to 10 milliseconds. Optionally,
 * a CSS class may be applied to the element during the time it is pressed.
 */
public class ClickRepeater extends JsObject {

    /**
     * Create a new ClickRepeater.
     *
     * @param config ClickRepeater configuration
     */
    public ClickRepeater(ClickRepeaterConfig config) {
        jsObj = create(config.getJsObj());
    }

    private native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.util.ClickRepeater(config);
    }-*/;

    /**
     * Add a ClickRepeater listener.
     *
     * @param listener the listener
     */
    public native void addListener(ClickRepeaterListener listener)/*-{
        var cr = this.@com.gwtext.client.core.JsObject::jsObj;
        var crJ = this;

        cr.addListener('click',
                function(source) {
                    listener.@com.gwtext.client.util.event.ClickRepeaterListener::onClick(Lcom/gwtext/client/util/ClickRepeater;)(crJ);
                }
        );

        cr.addListener('mousedown',
                function(source) {
                    listener.@com.gwtext.client.util.event.ClickRepeaterListener::onMouseDown(Lcom/gwtext/client/util/ClickRepeater;)(crJ);
                }
        );

        cr.addListener('mouseup',
                function(source) {
                    listener.@com.gwtext.client.util.event.ClickRepeaterListener::onMouseUp(Lcom/gwtext/client/util/ClickRepeater;)(crJ);
                }
        );
    }-*/;
}
