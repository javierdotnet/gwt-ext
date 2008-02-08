/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.core;

/**
 * Event callback interface. The {@link EventObject} as a result of the event is passed in the callback.
 *
 * @see com.gwtext.client.core.BaseElement#addListener(String, EventCallback)
 */
public interface EventCallback {

    /**
     * Callback method.
     *
     * @param e the event object
     */
    void execute(EventObject e);
}
