/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Base abstract reader class. A Reader class defines the metadata of the data that needs to be read. The actual
 * datasource is defined as by a {@link DataProxy} implmentation. A {@link Store} is build using a Reader and a DataProxy and is capable of
 * actually reading the data out of the data source into {@link Record} objects. Several widgets like {@link com.gwtext.client.widgets.form.ComboBox} and
 * {@link com.gwtext.client.widgets.grid.GridPanel} are backed by {@link Store} to provide the "model" for the widget.
 */
public abstract class Reader extends JsObject {
    protected JavaScriptObject configJS = JavaScriptObjectHelper.createObject();

    protected RecordDef recordDef;

    public RecordDef getRecordDef() {
        return recordDef;
    }

    public void setRecordDef(RecordDef recordDef) {
        this.recordDef = recordDef;
    }

    public JavaScriptObject getJsObj() {
        if(jsObj == null) {
            if(recordDef == null) {
                throw new IllegalStateException("You must specify a RecordDef for this reader");
            }
            jsObj = create(configJS, recordDef.getJsObj());
        }
        return jsObj;
    }

    protected JavaScriptObject create(JavaScriptObject config, JavaScriptObject recordDef) {
		return null;
	}
}
