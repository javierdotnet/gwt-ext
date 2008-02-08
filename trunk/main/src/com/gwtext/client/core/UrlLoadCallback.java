/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.core;

/**
 * Callback interface used in various methods of {@link com.gwtext.client.core.UpdateManager}.
 *
 * @see com.gwtext.client.core.UpdateManager#formUpdate(String, String, boolean, UrlLoadCallback)
 * @see com.gwtext.client.core.UpdateManager#update(String, UrlLoadConfig , UrlLoadCallback, boolean)
 */
public interface UrlLoadCallback {

    /**
     * The callback method.
     *
     * @param success      true if request is successful
     * @param httpStatus   the http status code
     * @param responseText thre response text
     */
    void execute(boolean success, int httpStatus, String responseText);
}
