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
package com.gwtext.client.widgets;

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Configuration class for {@link View}.
 */
public class ViewConfig extends BaseConfig {

    /**
     * True for single select.
     *
     * @param singleSelect true for single select
     */
    public void setSingleSelect(boolean singleSelect) {
        JavaScriptObjectHelper.setAttribute(jsObj, "singleSelect", singleSelect);
    }

    /**
     * True for multi select.
     *
     * @param multiSelect true for multi select.
     */
    public void setMultiSelect(boolean multiSelect) {
        JavaScriptObjectHelper.setAttribute(jsObj, "multiSelect", multiSelect);
    }

    /**
     * The css class to add to selected nodes.
     *
     * @param selectedClass the CSS class
     */
    public void setSelectedClass(String selectedClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "selectedClass", selectedClass);
    }

    /**
     * Sets the data store this view uses and refresh the view.
     * 
     * @param store the store
     */
    public void setStore(Store store) {
        JavaScriptObjectHelper.setAttribute(jsObj, "store", store.getJsObj());
    }
}
