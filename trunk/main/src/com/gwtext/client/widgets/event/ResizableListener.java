/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Resizable;

public interface ResizableListener {

    /**
     * Fires event before the resize.
     *
     * @param self this
     * @param e    the event object
     * @return false to prevent the resize
     */
    boolean doBeforeResize(Resizable self, EventObject e);

    /**
     * Fires when the element is resized.
     *
     * @param self   this
     * @param width  the new width
     * @param height the new height
     */
    void onResize(Resizable self, int width, int height);
}
