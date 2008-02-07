/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.core.event;

/**
 * TextResizeListener interface.
 *
 * @see com.gwtext.client.core.EventManager
 */
public interface TextResizeListener {

    /**
     * Fires when the user changes the active text size.
     *
     * @param oldSize the old size
     * @param newSize the new size
     */
    void onTextResize(int oldSize, int newSize);
}
