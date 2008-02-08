/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.data;

/**
 * An HTTP specific {@link com.gwtext.client.data.StoreLoadException} that is raised  when using
 * the {@link HttpProxy}.
 *
 * @see com.gwtext.client.data.event.StoreListener#onLoadException(Throwable)
 */
public class HttpStoreLoadException extends StoreLoadException {

    private int httpStatus;

    public HttpStoreLoadException(int httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    /**
     * Returns the http status code.
     *
     * @return http status code
     */
    public int getHttpStatus() {
        return httpStatus;
    }
}
