/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 

package com.gwtext.client.core.event;

import com.gwtext.client.core.Connection;

/**
 * The ConnectionListener interface.
 *
 * @author Sanjiv Jivan
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
