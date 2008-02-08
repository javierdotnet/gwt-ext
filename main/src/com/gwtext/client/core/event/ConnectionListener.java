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
     * @param conn the Connection
     * @param responseText the response text
     */
    void onRequestComplete(Connection conn, String responseText);

    /**
     * Fires if an error HTTP status was returned from the server.
     *
     * @param conn the Connection
     * @param httpStatus the http status code
     * @param responseText the response text
     */
    void onRequestException(Connection conn, int httpStatus, String responseText);
}
