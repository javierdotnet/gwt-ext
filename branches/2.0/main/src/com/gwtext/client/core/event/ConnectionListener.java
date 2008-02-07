/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.core.event;

import com.gwtext.client.core.Connection;

/**
 * The ConnectionListener interface.
 *
 * @see Connection
 */
public interface ConnectionListener {

    /**
     * Fires before a network request is made to retrieve a data object.
     *
     * @param conn the Collection
     * @return false to abort the request
     */
    boolean doBeforeRequest(Connection conn);

    /**
     * Fires if the request was successfully completed.
     *
     * @param conn         the Connection
     * @param responseText the response text
     */
    void onRequestComplete(Connection conn, String responseText);

    /**
     * Fires if an error HTTP status was returned from the server.
     *
     * @param conn         the Connection
     * @param httpStatus   the http status code
     * @param responseText the response text
     */
    void onRequestException(Connection conn, int httpStatus, String responseText);
}
