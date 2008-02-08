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

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * {@link com.gwtext.client.data.XmlReader} configuration class.
 */
public class XmlReaderConfig extends BaseConfig {

    /**
     * The {@link com.gwtext.client.core.DomQuery} path relative from the record element to the element that contains a record identifier value..
     * The simples case is the tag name in the XML that maps to the Record ID
     *
     * @param id the ID
     */
    public void setId(String id) {
        JavaScriptObjectHelper.setAttribute(jsObj, "id", id);
    }

    /**
     * The {@link com.gwtext.client.core.DomQuery} path to the repeated element which contains record information. The simples
     * case is the tag name in the XML that maps to the root tag of what corresponnds to a "record".
     *
     * @param record the record mapping
     */
    public void setRecord(String record) {
        JavaScriptObjectHelper.setAttribute(jsObj, "record", record);
    }

    /**
     * The {@link com.gwtext.client.core.DomQuery} path to the success attribute used by forms.
     *
     * @param success the success {@link com.gwtext.client.core.DomQuery} path.
     */
    public void setSuccess(String success) {
        JavaScriptObjectHelper.setAttribute(jsObj, "success", success);
    }

    /**
     * The {@link com.gwtext.client.core.DomQuery} path from which to retrieve the total number of records in the dataset.
     * This is only needed if the whole dataset is not passed in one go, but is being paged from the remote server.
     *
     * @param totalRecords  the totalRecords DomQuery path
     */
    public void setTotalRecords(String totalRecords) {
        JavaScriptObjectHelper.setAttribute(jsObj, "totalRecords", totalRecords);
    }
}
