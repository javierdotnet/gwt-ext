/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.event;

import com.gwtext.client.core.EventObject;

public interface KeyListener {

    /**
     * Fires when a key is entered.
     *
     * @param key the key code
     * @param e   the event object
     */
    void onKey(int key, EventObject e);
}
