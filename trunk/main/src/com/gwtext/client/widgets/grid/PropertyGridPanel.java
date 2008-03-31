package com.gwtext.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.NameValuePair;
import com.gwtext.client.core.Function;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.grid.event.PropertyGridPanelListener;

import java.util.Map;

/**
 * A specialized grid implementation intended to mimic the traditional property grid as typically seen in development IDEs.
 * Each row in the grid represents a property of some object, and the data is stored as a set of name/value pairs
 */
public class PropertyGridPanel extends EditorGridPanel {

	private boolean sorted;

	static {
        init();
    }

    //http://extjs.com/forum/showthread.php?t=23138
    private static native void init()/*-{
        $wnd.Ext.reg('propertygrid', $wnd.Ext.grid.PropertyGrid);
    }-*/;

    public String getXType() {
        return "propertygrid";
    }

    /**
     * Create a new PropertGridPanel.
     */
    public PropertyGridPanel() {
		addListener("render", new Function() {
			public void execute() {
				if(!sorted) {
					clearSortState(false);
					doClearSort(getJsObj());
				}
			}

			private native void doClearSort(JavaScriptObject propGrid)/*-{
				propGrid.store.sortInfo = null;
				propGrid.setSource(propGrid.getSource());
			}-*/;
		});
	}

    public PropertyGridPanel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject configJS) /*-{
        return new $wnd.Ext.grid.PropertyGrid(configJS);
    }-*/;

    private void setSourceRendered(Map source) {
        JavaScriptObject sourceJS = JavaScriptObjectHelper.convertMapToJavascriptObject(source);
        doSetSource(sourceJS);
    }

    /**
     * Sets the source data object containing the property data. The data object can contain one or more name/value pairs
     * representing all of the properties of an object to display in the grid, and this data will automatically be loaded
     * into the grid's store. If the grid already contains data, this method will replace any existing data.
     *
     * @param source the data source
     */
    private void setSourceRendered(NameValuePair[] source) {
        JavaScriptObject sourceJS = NameValuePair.getJsObj(source);
        doSetSource(sourceJS);
    }

    private native void doSetSource(JavaScriptObject source) /*-{
        var grid = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        grid.setSource(source);
    }-*/;

    /**
     * Add a PropertGridPanel listener.
     *
     * @param listener the listener.
     */
    public native void addPropertyGridPanelListener(PropertyGridPanelListener listener) /*-{
        var gridJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforepropertychange',
                function(self, recordID, value, oldValue) {
                    if(recordID === undefined) recordID = null;
                    var valueJ = (value  == null || value === undefined ) ? null : $wnd.GwtExt.convertToJavaType(value);
                    var oldValueJ = (oldValue  == null || oldValue === undefined ) ? null : $wnd.GwtExt.convertToJavaType(oldValue);
                    return listener.@com.gwtext.client.widgets.grid.event.PropertyGridPanelListener::doBeforePropertyChange(Lcom/gwtext/client/widgets/grid/PropertyGridPanel;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)(gridJ, recordID, valueJ, oldValueJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('propertychange',
                function(self, recordID, value, oldValue) {
                    if(recordID === undefined) recordID = null;
                    var valueJ = (value  == null || value === undefined ) ? null : $wnd.GwtExt.convertToJavaType(value);
                    var oldValueJ = (oldValue  == null || oldValue === undefined ) ? null : $wnd.GwtExt.convertToJavaType(oldValue);
                    listener.@com.gwtext.client.widgets.grid.event.PropertyGridPanelListener::onPropertyChange(Lcom/gwtext/client/widgets/grid/PropertyGridPanel;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)(gridJ, recordID, valueJ, oldValueJ);
                }
        );
    }-*/;

    //--- config properties ---

    /**
     * Sets the source data object containing the property data. The data object can contain one or more name/value pairs
     * representing all of the properties of an object to display in the grid, and this data will automatically be loaded
     * into the grid's store. If the grid already contains data, this method will replace any existing data.
     *
     * @param source the data source
     */
    public void setSource(NameValuePair[] source) {
        if (!isRendered()) {
            JavaScriptObject sourceJS = NameValuePair.getJsObj(source);
            setAttribute("source", sourceJS, true);
        } else {
            setSourceRendered(source);
        }
    }

    /**
     * Sets the source data object containing the property data. The data object can contain one or more name/value pairs
     * representing all of the properties of an object to display in the grid, and this data will automatically be loaded
     * into the grid's store. If the grid already contains data, this method will replace any existing data.
     *
     * @param source the data source
     */
    public void setSource(Map source) {
        if (!isRendered()) {
            JavaScriptObject sourceJS = JavaScriptObjectHelper.convertMapToJavascriptObject(source);
            setAttribute("source", sourceJS, true);
        } else {
            setSourceRendered(source);
        }
    }

    /**
     * The value of the property name text.
	 *
     * @param nameText the property name text
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setNameText(String nameText) throws IllegalStateException {
        setAttribute("nameText", nameText, true);
    }

	/**
	 * True to render with properties initially sorted.
	 *
	 * @return true to render with properties initially sorted.
	 */
	public boolean isSorted() {
		return sorted;
	}

	/**
	 * True to render with properties initially sorted. Defaults to false.
	 *
	 * @param sorted true to render with properties initially sorted.
	 */
	public void setSorted(boolean sorted) {
		this.sorted = sorted;
	}

	/**
     * An object containing name/value pairs of custom editor type definitions that allow the grid to support additional
     * types of editable fields. By default, the grid supports strongly-typed editing of strings, dates, numbers and booleans
     * using built-in form editors, but any custom type can be supported and associated with a custom input control by specifying
     * a custom editor. The name of the editor type should correspond with the name of the property that will use the editor.
     * <p/>
     * <pre>
     * <code>
     * PropertyGridPanel grid = new PropertyGridPanel();
     * Map source = new HashMap();
     * source.put("Edit Time", "10:00 AM");
     * Map customEditors = new HashMap();
     * GridEditor timeEditor = new GridEditor(new TimeField());
     * customEditors.put("Edit Time", timeEditor);
     * grid.setCustomEditors(customEditors);</code>
     * </pre>    
     * 
     * @param customEditors custom editors
     */
    public void setCustomEditors(Map customEditors) {
        setAttribute("customEditors", customEditors, true, true);
    }	
}
