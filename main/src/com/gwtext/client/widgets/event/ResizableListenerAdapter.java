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

/**
 * ResizableListener adapter class.
 */
public class ResizableListenerAdapter implements ResizableListener {

    public boolean doBeforeResize(Resizable self, EventObject e) {
        return true;
    }

    public void onResize(Resizable self, int width, int height) {
    }
}
