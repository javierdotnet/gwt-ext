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

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * An implementation of DataProxy that simply passes the data specified in its constructor to the Reader when its load method is called.
 *
 * <pre>
 * <code>
 *
 * Object[][] states = new Object[][]{
 *               new Object[]{"AL", "Alabama"},
 *               new Object[]{"AK", "Alaska"},
 *               new Object[]{"AZ", "Arizona"},
 *               new Object[]{"AR", "Arkansas"},
 *               new Object[]{"CA", "California"}};
 *
 * Reader reader = new ArrayReader(new RecordDef(
 *                new FieldDef[]{
 *                       new StringFieldDef("abbr"),
 *                       new StringFieldDef("state")
 *               }));
 *
 * Store store = new Store(proxy, reader);
 * </code>
 * </pre>
 * 
 */
public class MemoryProxy extends DataProxy {

    /**
     *
     * Create s new memory proxy using the passed array data.
     *
     * @param data the array data
     */
    public MemoryProxy(Object[][] data) {
        jsObj = create(JavaScriptObjectHelper.convertToJavaScriptArray(data));
    }

    native JavaScriptObject create(JavaScriptObject data) /*-{
        return new $wnd.Ext.data.MemoryProxy(data);
    }-*/;
}
