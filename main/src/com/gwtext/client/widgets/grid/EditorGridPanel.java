/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.grid.event.EditorGridListener;


/**
 * Class for creating and editable grid.
 */
public class EditorGridPanel extends GridPanel {

    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
		var c = new $wnd.Ext.grid.EditorGridPanel();
		@com.gwtext.client.widgets.grid.EditorGridPanel::configPrototype = c.initialConfig;
	}-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "editorgrid";
    }

    public EditorGridPanel() {
    }

    /**
     * Creates a new Editor Grid.
     *
     * @param store       the Grid's data store
     * @param columnModel the Grids column model
     */
    public EditorGridPanel(Store store, ColumnModel columnModel) {
        super(store, columnModel);
    }

    public EditorGridPanel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Creates a new Editor Grid.
     *
     * @param id          the Grid ID
     * @param width       the Grid width
     * @param height      the Grid height
     * @param store       the Grid's data store
     * @param columnModel the Grids column model
     */
    public EditorGridPanel(String id, int width, int height, Store store, ColumnModel columnModel) {
        super(id, width, height, store, columnModel);
    }

    protected native JavaScriptObject create(JavaScriptObject configJS) /*-{
        return new $wnd.Ext.grid.EditorGridPanel(configJS);
    }-*/;

    /**
     * Add an EditorGridPanel listener.
     *
     * @param listener the listener
     */
    public native void addEditorGridListener(EditorGridListener listener)/*-{
        var gridJ = this;
    
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('afteredit',
                function(e) {
                    var recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e.record);
                    var value = e.value === undefined ? null : $wnd.GwtExt.convertToJavaType(e.value);
                    var originalValue = e.originalValue === undefined ? null : $wnd.GwtExt.convertToJavaType(e.originalValue);
                    listener.@com.gwtext.client.widgets.grid.event.EditorGridListener::onAfterEdit(Lcom/gwtext/client/widgets/grid/GridPanel;Lcom/gwtext/client/data/Record;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;II)(gridJ, recordJ, e.field, value , originalValue, e.row, e.column);
                }
        );        

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforeedit',
                function(e) {
                    var recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e.record);
                    var value = e.value === undefined ? null : $wnd.GwtExt.convertToJavaType(e.value);
                    return listener.@com.gwtext.client.widgets.grid.event.EditorGridListener::doBeforeEdit(Lcom/gwtext/client/widgets/grid/GridPanel;Lcom/gwtext/client/data/Record;Ljava/lang/String;Ljava/lang/Object;II)(gridJ, recordJ, e.field, value, e.row, e.column);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('validateedit',
                function(e) {
                    var recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e.record);
                    var value = e.value === undefined ? null : $wnd.GwtExt.convertToJavaType(e.value);
                    var originalValue = e.originalValue === undefined ? null : $wnd.GwtExt.convertToJavaType(e.originalValue);
                    return listener.@com.gwtext.client.widgets.grid.event.EditorGridListener::doValidateEdit(Lcom/gwtext/client/widgets/grid/GridPanel;Lcom/gwtext/client/data/Record;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;II)(gridJ, recordJ, e.field, value, originalValue,  e.row, e.column);
                }
        );
    }-*/;

    /**
     * Starts editing the specified for the specified row/column.
     *
     * @param rowIndex row to edit
     * @param colIndex column to edit
     */
    public native void startEditing(int rowIndex, int colIndex) /*-{
        var grid = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        grid.startEditing(rowIndex, colIndex);
    }-*/;

    /**
     * Stops any active editing.
     */
    public native void stopEditing() /*-{
        var grid = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        grid.stopEditing();
    }-*/;

    /**
     * Returns the grid's cell selection model
     *
     * @return the cell selection model
     * @throws IllegalStateException if called before grid creation or before calling setSelectionModel(...)
     */
    public CellSelectionModel getCellSelectionModel() throws IllegalStateException {
    	JavaScriptObject smObj = getSelectionModelAsJavaScriptObject();
    	if(smObj != null) {
    		return new CellSelectionModel(smObj);
    	} else {
    		throw new IllegalStateException("getCellSelectionModel() cannot be called" +
    				" unless the grid has been created or setSelectionModel(...) has been called");
    	}
    }

    // --- config proeprties ---
    /**
     * The number of clicks on a cell required to display the cell's editor (defaults to 2).
	 *
     * @param clicksToEdit the number of clicks to edit
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setClicksToEdit(int clicksToEdit) throws IllegalStateException {
        setAttribute("clicksToEdit", clicksToEdit, true);
    }

    /**
     * True to automatically HTML encode and decode values pre and post edit (defaults to false)
     * 
     * @param autoEncode true to auto encode
     */
    public void setAutoEncode(boolean autoEncode) {
        setAttribute("autoEncode", autoEncode, true);
    }
}
