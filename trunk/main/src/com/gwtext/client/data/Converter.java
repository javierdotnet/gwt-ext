/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.data;

/**
 * Converter that can be used to format the incoming data before processing it by the {@link Reader}.
 */
public interface Converter {

    /**
     * Format incoming data before processing it by the Reader.
     *
     * @param data raw data
     * @return processed data
     */
    String format(String data);
}
