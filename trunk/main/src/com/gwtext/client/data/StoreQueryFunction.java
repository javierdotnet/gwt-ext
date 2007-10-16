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
package com.gwtext.client.data;

/**
 * Store query function.
 *
 * @see com.gwtext.client.data.Store#queryBy(StoreQueryFunction)
 */
public interface StoreQueryFunction {

    /**
     * Callback function invoked by {@link com.gwtext.client.data.Store#queryBy(StoreQueryFunction)}.
     * Return true if the record matches.
     *
     * @param record the record to test
     * @param id     the record ID
     * @return true to include Record in result
     * @see com.gwtext.client.data.Store#queryBy(StoreQueryFunction)
     */
    public boolean test(Record record, String id);
}
