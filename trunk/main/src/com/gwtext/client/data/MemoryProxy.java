/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
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

    native JavaScriptObject create(JavaScriptObject data) /*-{
        return new $wnd.Ext.data.MemoryProxy(data);
    }-*/;
}
