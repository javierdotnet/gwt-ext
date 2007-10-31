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
 * Configuration class for {@link com.gwtext.client.data.JsonReader}.
 *
 * @see com.gwtext.client.data.JsonReader
 */
public class JsonReaderConfig extends BaseConfig {

    /**
     * Name of the property within a row object that contains a record identifier value.
     *
     * @param id the id property
     */
    public void setId(String id) {
        JavaScriptObjectHelper.setAttribute(jsObj, "id", id);
    }

    /**
     * Name of the property which contains the Array of row objects.
     * 
     * @param root the root property
     */
    public void setRoot(String root) {
        JavaScriptObjectHelper.setAttribute(jsObj, "root", root);
    }

    /**
     * Name of the property from which to retrieve the success attribute used by forms.
     *
     * @param successProperty the success property
     */
    public void setSuccessProperty(String successProperty) {
        JavaScriptObjectHelper.setAttribute(jsObj, "successProperty", successProperty);
    }

    /**
     * Name of the property from which to retrieve the total number of records in the dataset.
     * This is only needed if the whole dataset is not passed in one go, but is being paged from the remote server.
     *
     * @param totalProperty proeprty for total number of records
     */
    public void setTotalProperty(String totalProperty) {
        JavaScriptObjectHelper.setAttribute(jsObj, "totalProperty", totalProperty);
    }
}
