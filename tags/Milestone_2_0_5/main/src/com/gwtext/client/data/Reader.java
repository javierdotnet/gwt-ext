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
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Base abstract reader class. A Reader class defines the metadata of the data that needs to be read. The actual
 * datasource is defined as by a {@link DataProxy} implmentation. A {@link Store} is build using a Reader and a DataProxy and is capable of
 * actually reading the data out of the data source into {@link Record} objects. Several widgets like {@link com.gwtext.client.widgets.form.ComboBox} and
 * {@link com.gwtext.client.widgets.grid.GridPanel} are backed by {@link Store} to provide the "model" for the widget.
 *
 * @author Sanjiv Jivan
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
