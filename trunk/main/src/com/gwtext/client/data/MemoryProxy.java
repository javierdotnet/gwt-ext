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
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * An implementation of DataProxy that simply passes the data specified in its constructor to the Reader when its load method is called.
 * <p/>
 * <pre>
 * <code>
 * <p/>
 * Object[][] states = new Object[][]{
 *               new Object[]{"AL", "Alabama"},
 *               new Object[]{"AK", "Alaska"},
 *               new Object[]{"AZ", "Arizona"},
 *               new Object[]{"AR", "Arkansas"},
 *               new Object[]{"CA", "California"}};
 * <p/>
 * Reader reader = new ArrayReader(new RecordDef(
 *                new FieldDef[]{
 *                       new StringFieldDef("abbr"),
 *                       new StringFieldDef("state")
 *               }));
 * <p/>
 * Store store = new Store(proxy, reader);
 * </code>
 * </pre>
 *
 * @author Sanjiv Jivan
 */
public class MemoryProxy extends DataProxy {

    /**
     * Create s new memory proxy using the passed array data.
     *
     * @param data the array data
     */
    public MemoryProxy(Object[][] data) {
        jsObj = create(JavaScriptObjectHelper.convertToJavaScriptArray(data));
    }

    protected native JavaScriptObject create(JavaScriptObject data) /*-{
        return new $wnd.Ext.data.MemoryProxy(data);
    }-*/;
}
