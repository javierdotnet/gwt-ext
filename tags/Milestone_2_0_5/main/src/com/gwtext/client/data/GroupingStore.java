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
 
package com.gwtext.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * A specialized store implementation that provides for grouping records by one of the available fields.
 *
 * @author Sanjiv Jivan
 */
public class GroupingStore extends Store {

    /**
     * Construct a new GroupingStore.
     */
    public GroupingStore() {
    }

    /**
     * Create a Store using the specified {@link RecordDef}. Data can be added to the Store using
     * {@link #add(Record)}
     *
     * @param recordDef the record def
     */
    public GroupingStore(RecordDef recordDef) {
        super(recordDef);
    }

    /**
     * Create a Store using the specified {@link Reader}.
     *
     * @param reader the reader
     */
    public GroupingStore(Reader reader) {
        super(reader);
    }

    /**
     * Create a Store using the specified {@link com.gwtext.client.data.DataProxy} and {@link Reader}.
     *
     * @param dataProxy the data proxy
     * @param reader    the reader
     */
    public GroupingStore(DataProxy dataProxy, Reader reader) {
        super(dataProxy, reader);
    }

    /**
     * Create a Store using the specified {@link com.gwtext.client.data.DataProxy} and {@link Reader}.
     *
     * @param dataProxy  the data proxy
     * @param reader     the reader
     * @param remoteSort true to enable remote sort of the data
     */
    public GroupingStore(DataProxy dataProxy, Reader reader, boolean remoteSort) {
        super(dataProxy, reader, remoteSort);
    }

    /**
     * Create a Store using the specified configuration.
     *
     * @param dataProxy        the data proxy
     * @param reader           the reader
     * @param baseParams       base params which are to be sent as parameters on any HTTP request. Used only for Http based proxies.
     * @param initialSortState the initial sort field name and direction
     * @param remoteSort       true to enable remote sort
     */
    public GroupingStore(DataProxy dataProxy, Reader reader, UrlParam[] baseParams, SortState initialSortState, boolean remoteSort) {
        super(dataProxy, reader, baseParams, initialSortState, remoteSort);
    }

    native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.data.GroupingStore(config);
    }-*/;

    /**
     * Clears any existing grouping and refreshes the data using the default sort.
     */
    public native void clearGrouping() /*-{
        var gstore = this.@com.gwtext.client.core.JsObject::getJsObj()();
        gstore.clearGrouping();
    }-*/;

    /**
     * Groups the data by the specified field.
     *
     * @param field The field name by which to sort the store's data
     */
    public native void groupBy(String field) /*-{
        var gstore = this.@com.gwtext.client.core.JsObject::getJsObj()();
        gstore.groupBy(field);
    }-*/;

    /**
     * Groups the data by the specified field.
     *
     * @param field        The field name by which to sort the store's data
     * @param forceRegroup true to force the group to be refreshed even if the field passed in is the same as the current
     *                     grouping field, false to skip grouping on the same field (defaults to false)
     */
    public native void groupBy(String field, boolean forceRegroup) /*-{
        var gstore = this.@com.gwtext.client.core.JsObject::getJsObj()();
        gstore.groupBy(field, forceRegroup);
    }-*/;

    //config options
    /**
     * The field name by which to sort the store's data (defaults to '').
     *
     * @param groupField the group field
     */
    public void setGroupField(String groupField) {
        JavaScriptObjectHelper.setAttribute(configJS, "groupField", groupField);
    }

    /**
     * True to sort the data on the grouping field when a grouping operation occurs,
     * false to sort based on the existing sort info (defaults to false).
     *
     * @param groupOnSort true to group on sort
     */
    public void setGroupOnSort(boolean groupOnSort) {
        JavaScriptObjectHelper.setAttribute(configJS, "groupOnSort", groupOnSort);
    }

    /**
     * True if the grouping should apply on the server side, false if it is local only (defaults to false).
     * If the grouping is local, it can be applied immediately to the data. If it is remote, then it will simply act as
     * a helper, automatically sending the grouping field name as the 'groupBy' param with each XHR call.
     *
     * @param remoteGroup true if the grouping should apply on the server side
     */
    public void setRemoteGroup(boolean remoteGroup) {
        JavaScriptObjectHelper.setAttribute(configJS, "remoteGroup", remoteGroup);
    }
}
