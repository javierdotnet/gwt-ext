/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.Template;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Shadow;
import com.gwtext.client.widgets.form.event.ComboBoxListener;

/**
 * A combobox control with support for autocomplete, remote-loading, paging and many other features.
 */
public class ComboBox extends TextField {

    public static Mode REMOTE = new Mode("remote");
    public static Mode LOCAL = new Mode("local");

    public static Trigger ALL = new Trigger("all");
    public static Trigger QUERY = new Trigger("query");

    private String displayField;

    private static JavaScriptObject configPrototype;
    private Store store;

    static {
		init();
	}

    private static native void init()/*-{
			var c = new $wnd.Ext.form.Checkbox();
			@com.gwtext.client.widgets.form.Checkbox::configPrototype = c.initialConfig;
		}-*/;


    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "combo";
    }

    public ComboBox() {
    }

	/**
	 * Create a new ComboBox.
	 *
	 * @param fieldLabel the field label
	 */
	public ComboBox(String fieldLabel) {
		super(fieldLabel);
	}

	/**
	 * Create a new ComboBox.
	 *
	 * @param fieldLabel the field label
	 * @param name the field name
	 */
	public ComboBox(String fieldLabel, String name) {
		super(fieldLabel, name);
	}

	/**
	 * Create a new ComboBox.
	 *
	 * @param fieldLabel the field label
	 * @param name the field name
	 * @param width the field width
	 */
	public ComboBox(String fieldLabel, String name, int width) {
		super(fieldLabel, name, width);
	}

	public ComboBox(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
        return new $wnd.Ext.form.ComboBox(jsObj);
    }-*/;

    protected void onDestroy() {
        super.onDestroy();
        this.store = null;
    }

    protected native Element getElement(JavaScriptObject jsObj) /*-{
        //for trigger fields, we want the text area as well as the trigger button to be treated as the element
        //unit
        var extEl = jsObj.wrap;
        if(extEl == null || extEl === undefined) {
            return null;
        }
        var el = extEl.dom;
        if(el == null || el === undefined) {
            return null;
            //forms buttons are detached when initially added
        } else {
            //There's an inconsistency in Ext where most elements have the property 'el' set to Ext's Element
            //with the exception of Menu->Item, Menu->Separator, Menu->TextItem,  Toolbar.Item and subclasses
            //(Toolbar.Separator, Toolbar.Spacer, Toolbar.TextItem) where the 'el' property is set to
            //the DOM element itself. Therefore retruning 'el' if 'el' is not Ext's Element. See details in issue 39.
             return el.dom || el ;
        }
    }-*/;

	/**
	 * Clears any text/value currently set in the field
	 */
	public native void clearValue() /*-{
        var cb = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        cb.clearValue();
    }-*/;

	/**
	 * Hides the dropdown list if it is currently expanded. Fires the 'collapse' event on completion.
	 */
	public native void collapse() /*-{
        var cb = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        cb.collapse();
    }-*/;

	/**
	 * Execute a query to filter the dropdown list. Fires the beforequery event prior to performing the query allowing the query action to be canceled if needed.
	 * 
	 * @param query the query to execute
	 * @param forceAll true to force the query to execute even if there are currently fewer characters in the field than the minimum specified by the minChars config option.
	 * It also clears any filter previously saved in the current store (defaults to false)
	 */
	public native void doQuery(String query, boolean forceAll) /*-{
        var cb = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        cb.doQuery(query, forceAll);
    }-*/;

	/**
	 * Expands the dropdown list if it is currently hidden. Fires the 'expand' event on completion.
	 */
	public native void expand() /*-{
        var cb = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        cb.expand();
    }-*/;

	/**
	 * Returns the currently selected field value or null if no value is set.
	 *
	 * @return the value 
	 */
	public native String getValue() /*-{
        var cb = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var val = cb.getValue();
        return val === '' ? null : val.toString();
    }-*/;

	/**
	 * Returns true if the dropdown list is expanded, else false.
	 *
	 * @return true if dropdown list is expanded
	 */
	public native boolean isExpanded() /*-{
        var cb = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return cb.isExpanded();
    }-*/;

	/**
	 * Select an item in the dropdown list by its numeric index in the list. This function does NOT cause the select event to fire.
	 * The store must be loaded and the list expanded for this function to work, otherwise use setValue.
	 * 
	 * @param index the zero-based index of the list item to select
	 * @param scrollIntoView false to prevent the dropdown list from autoscrolling to display the selected item if it is
	 * not currently in view (defaults to true)
	 */
	public native void select(int index, boolean scrollIntoView) /*-{
        var cb = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        cb.select(index, scrollIntoView);
    }-*/;

	/**
	 * Select an item in the dropdown list by its data value. This function does NOT cause the select event to fire.
	 * The store must be loaded and the list expanded for this function to work, otherwise use setValue.
	 * 
	 * @param value the data value of the item to select
	 * @param scrollIntoView false to prevent the dropdown list from autoscrolling to display the selected item if it is not currently in view (defaults to true)
	 */
	public native void selectByValue(String value, boolean scrollIntoView) /*-{
        var cb = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        cb.selectByValue(value, scrollIntoView);
    }-*/;

    private native void setEditableRendered(boolean value) /*-{
        var cb = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        cb.setEditable(value);
    }-*/;

    /**
     * Sets the specified value into the field. If the value finds a match, the corresponding record text will be displayed in the field. If the value does
     * not match the data value of an existing item, and the valueNotFoundText config option is defined, it will be displayed as the default field text. Otherwise the field will be blank (although the value will still be set).
     */
    public void setValue(String value) {
        super.setValue(value);
    }

	/**
	 * Add a Combobox listener.
	 *
	 * @param listener the listener
	 */
	public native void addListener(ComboBoxListener listener) /*-{
		this.@com.gwtext.client.widgets.form.Field::addListener(Lcom/gwtext/client/widgets/form/event/FieldListener;)(listener);

		var fieldJ = this;		

		this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforequery',
                function(o) {
                    var cbJ = @com.gwtext.client.widgets.form.event.ComboBoxCallback::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(o);
                    return listener.@com.gwtext.client.widgets.form.event.ComboBoxListener::doBeforeQuery(Lcom/gwtext/client/widgets/form/ComboBox;Lcom/gwtext/client/widgets/form/event/ComboBoxCallback;)(fieldJ,cbJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforeselect',
                function(fld, record, index) {
                    var recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
                    return listener.@com.gwtext.client.widgets.form.event.ComboBoxListener::doBeforeSelect(Lcom/gwtext/client/widgets/form/ComboBox;Lcom/gwtext/client/data/Record;I)(fieldJ, recordJ, index);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('collapse',
                function(fld) {
                    listener.@com.gwtext.client.widgets.form.event.ComboBoxListener::onCollapse(Lcom/gwtext/client/widgets/form/ComboBox;)(fieldJ);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('expand',
                function(fld) {
                    listener.@com.gwtext.client.widgets.form.event.ComboBoxListener::onExpand(Lcom/gwtext/client/widgets/form/ComboBox;)(fieldJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('select',
                function(fld, record, index) {
                    var recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
                    listener.@com.gwtext.client.widgets.form.event.ComboBoxListener::onSelect(Lcom/gwtext/client/widgets/form/ComboBox;Lcom/gwtext/client/data/Record;I)(fieldJ, recordJ, index);
                }
        );
    }-*/;

    public static class Mode {
        private String mode;

        private Mode(String mode) {
            this.mode = mode;
        }

        public String getMode() {
            return mode;
        }
    }

    public static class Trigger {
        private String trigger;

        private Trigger(String trigger) {
            this.trigger = trigger;
        }

        public String getTrigger() {
            return trigger;
        }
    }

    // --- config properties


    /**
     * The text query to send to the server to return all records for the list with no
     * filtering (defaults to '')
     *
     * @param allQuery the all query string
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setAllQuery(String allQuery) throws IllegalStateException {
        setAttribute("allQuery", allQuery, true);
    }

    /**
     * The underlying data field name to bind to this ComboBox (defaults to undefined).
     *
     * @param displayField the display field
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setDisplayField(String displayField) throws IllegalStateException {
        setAttribute("displayField", displayField, true);
        JavaScriptObject store = JavaScriptObjectHelper.getAttributeAsJavaScriptObject(config, "store");
        if (store != null) {
            setFilterColParam(store, displayField);
        } else {
            this.displayField = displayField;
        }
    }

    private native void setFilterColParam(JavaScriptObject store, String displayField) /*-{
        store.baseParams['filterCol'] = displayField;
    }-*/;

    /**
     * False to prevent the user from typing text directly into the field, just like a traditional select (defaults to true).
     *
     * @param editable false to disable editing
     */
    public void setEditable(boolean editable) {
		if(!isCreated()) {
			setAttribute("editable", editable, true);
		} else {
			setEditableRendered(editable);
		}
        if(!editable) {
            //if its not editable, set the fields value to be the underlying Store's value and not the disaply field.
            //if the field is editable, then we cant make this assumtion because hte user might want to have the user
            //any text that is not in the store and have this value submitted. under such circumstances it is expected that
            //the user makes the decision and sets hiddenName if desired
            String name = getName();
            if(name != null) {
                setHiddenName(name);
            }
        }
    }

    /**
     * True to restrict the selected value to one of the values in the list, false to allow the user to set arbitrary text
     * into the field (defaults to false)
     *
     * @param forceSelection true to force selection
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setForceSelection(boolean forceSelection) throws IllegalStateException {
        setAttribute("forceSelection", forceSelection, true);
        String name = getName();
        //if its not editable, set the fields value to be the underlying Store's value and not the disaply field.
        //if the field is editable, then we cant make this assumtion because hte user might want to have the user
        //any text that is not in the store and have this value submitted. under such circumstances it is expected that
        //the user makes the decision and sets hiddenName if desired
        if(name != null) {
            setHiddenName(name);
        }
    }

    /**
     * The height in pixels of the dropdown list resize handle if resizable = true (defaults to 8)
	 *
     * @param handleHeight the handle height
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setHandleHeight(int handleHeight) throws IllegalStateException {
        setAttribute("handleHeight", handleHeight, true);
    }

    /**
     * If specified, a hidden form field with this name is dynamically generated to store the field's data value
     * (defaults to the underlying DOM element's name)
     *
     * @param hiddenName the hidden name
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setHiddenName(String hiddenName) throws IllegalStateException {
        setAttribute("hiddenName", hiddenName, true);
    }

    /**
     * True to hide the trigger element and display only the base text field (defaults to false).
     *
     * @param hideTrigger true to hide trigger
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setHideTrigger(boolean hideTrigger) throws IllegalStateException {
        setAttribute("hideTrigger", hideTrigger, true);
    }

    /**
     * A CSS class to apply to the trigger.
     *
     * @param triggerClass the trigger CSS class.
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTriggerClass(String triggerClass) throws IllegalStateException {
        setAttribute("triggerClass", triggerClass, true);
    }

    /**
     * A CSS selector in any format supported by {@link com.gwtext.client.core.DomQuery} that will be used to determine
     * what nodes this DataView will be working with.
     *
     * @param itemSelector the items selector
     */
    public void setItemSelector(String itemSelector) {
        setAttribute("itemSelector", itemSelector, true);
    }

    /**
     * True to indicate this is a linked combo box.
     *
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setLinked(boolean linked) throws IllegalStateException {
        if(linked) {
            setAttribute("lastQuery", "", true);
        }
    }

    /**
     * True to prevent the ComboBox from rendering until requested
     * (should always be used when rendering into an Editor, defaults to false).
     *
     * @param lazyRender true to lazy render
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setLazyRender(boolean lazyRender) throws IllegalStateException {
        setAttribute( "lazyRender", lazyRender, false);
    }

    /**
     * A valid anchor position value.
     *
     * @param anchorPosition the anchor position
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setListAlign(String anchorPosition) throws IllegalStateException {
        setAttribute("listAlign", anchorPosition, true);
    }

    /**
     * CSS class to apply to the dropdown list element (defaults to '').
     *
     * @param listClass list css class
     */
    public void setListClass(String listClass) {
        setAttribute("listClass", listClass, true, true);
    }

    /**
     * The width in pixels of the dropdown list (defaults to the width of the ComboBox field)
     *
     * @param listWidth the list width
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setListWidth(int listWidth) throws IllegalStateException {
        setAttribute("listWidth", listWidth, true);
    }

    /**
     * The text to display in the dropdown list while data is loading. Only applies when mode = 'remote'
     * (defaults to 'Loading...')
     *
     * @param loadingText the loading text
     */
    public void setLoadingText(String loadingText)  {
        setAttribute("loadingText", loadingText, true, true);
    }

    /**
     * The maximum height in pixels of the dropdown list before scrollbars are shown (defaults to 300).
     *
     * @param maxHeight the max height
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMaxHeight(int maxHeight) throws IllegalStateException {
        setAttribute("maxHeight", maxHeight, true);
    }

    /**
     * The minimum number of characters the user must type before autocomplete and typeahead activate
     * (defaults to 4, does not apply if editable = false)
     *
     * @param minChars the min chars before autocomplete
     */
    public void setMinChars(int minChars) {
        setAttribute("minChars", minChars, true, true);
    }

    /**
     * Set the min height.
     *
     * @param minHeight the minHeight
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMinHeight(int minHeight) {
        setAttribute("minHeight", minHeight, true);
    }

    /**
     * Return the min height.
     *
     * @return the minHeight
     */
    public int getMinHeight() {
        return getAttributeAsInt("minHeight");
    }


    /**
     * The minimum width of the dropdown list in pixels (defaults to 70, will be
     * ignored if listWidth has a higher value).
	 *
     * @param minListWidth the min list width
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMinListWidth(int minListWidth) throws IllegalStateException {
        setAttribute("minListWidth", minListWidth, true);
    }

    /**
     * Set to {@link com.gwtext.client.widgets.form.ComboBox#LOCAL} if the ComboBox loads local data.
     * (defaults to {@link com.gwtext.client.widgets.form.ComboBox#REMOTE} which loads from the server)
     *
     * @param mode local or remote mode
     */
    public void setMode(ComboBox.Mode mode) {
        setAttribute("mode", mode.getMode(), true, true);
    }

    /**
     * If greater than 0, a paging toolbar is displayed in the footer of the dropdown list and the filter queries will
     * execute with page start and limit parameters. Only applies when mode = 'remote' (defaults to 0).
     *
     * @param pageSize the page size
     * @see #setMode(com.gwtext.client.widgets.form.ComboBox.Mode)
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setPageSize(int pageSize) throws IllegalStateException {
        setAttribute("pageSize", pageSize, true);
    }

    /**
     * The length of time in milliseconds to delay between the start of typing and sending the query to filter the
     * dropdown list (defaults to 500 if mode = 'remote' or 10 if mode = 'local')
     *
     * @param queryDelay query delay in milliseconds
     * @see #setMode(com.gwtext.client.widgets.form.ComboBox.Mode)
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setQueryDelay(int queryDelay) throws IllegalStateException {
        setAttribute("queryDelay", queryDelay, true);
    }

    /**
     * Name of the query as it will be passed on the querystring (defaults to 'query')
     *
     * @param queryParam the query param
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setQueryParam(String queryParam) throws IllegalStateException {
        setAttribute("queryParam", queryParam, true);
    }

    /**
     * True to add a resize handle to the bottom of the dropdown list (defaults to false).
     *
     * @param resizable true for resizale
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setResizable(boolean resizable) throws IllegalStateException {
        setAttribute("resizable", resizable, true);
    }

    /**
     * CSS class to apply to the selected item in the dropdown list (defaults to 'x-combo-selected')
     *
     * @param selectedClass the selected css class
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setSelectedClass(String selectedClass) throws IllegalStateException {
        setAttribute("selectedClass", selectedClass, true);
    }

    /**
     * True for default effect
     *
     * @param shadow true to enable shadow
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setShadow(boolean shadow) throws IllegalStateException {
        setAttribute("shadow", shadow, true);
    }

    /**
     * "sides" for the default effect, "frame" for 4-way shadow, and "drop" for bottom-right.
     *
     * @param shadow shadow style
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setShadow(Shadow.Type shadow) throws IllegalStateException {
        setAttribute("shadow", shadow.getType(), true);
    }

    /**
     * The data store to which this combo is bound (defaults to undefined)
     *
     * @param store the combobox store
     */
    public void setStore(Store store) throws IllegalStateException {
    	if(!isRendered()) {
			if(store instanceof SimpleStore) {
				setTriggerAction(ALL);
				if(!isCreated()) setMode(LOCAL);
				store.load();
			}
			setAttribute("store", store.getJsObj(), true);
	        if (displayField != null) {
	            setFilterColParam(store.getJsObj(), displayField);
	        }
	        this.store = store;
    	} else {
    		setStoreRendered(store.getJsObj());
    	}
    }
    
    private native void setStoreRendered(JavaScriptObject storeJS) /*-{
	    var cb  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
	    cb.bindStore(storeJS);
	}-*/;

    /**
     * The Store associated with the combobox.
     *
     * @return the store
     */
    public Store getStore() {
        return store;
    }

    /**
     * If supplied, a header element is created containing this text and added into the top of the dropdown list
     * (defaults to undefined, with no header element).
     *
     * @param title the combobox title
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTitle(String title) throws IllegalStateException {
        setAttribute("title", title, true);
    }

    /**
     * Set the template to use to render the ComboBox items. Used to customize dispaly of ComboBox items.
     * <br/><br/>
     * For example the template below uses the fields 'url' and 'text' from the Store's RecordDef.
     * <br/><br/>
     * setTpl(new Template("&lt;div class=\"x-combo-list-item\">" +
     * "&lt;em>{url}&lt;/em>&lt;strong>{text}&lt;/strong>" +
     * "&lt;div class=\"x-clear\">&lt;/div>&lt;/div>"));
     *
     * @param template template to use for rendering items.
     * @see Store
     * @see com.gwtext.client.data.RecordDef
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTpl(Template template) throws IllegalStateException {
        String html = template.getHtml();
        setTpl(html);
    }

    /**
     * Set the template to use to render the ComboBox items. Used to customize dispaly of ComboBox items.
     * <br/><br/>
     * For example the template below uses the fields 'url' and 'text' from the Store's RecordDef.
     * <br/><br/>
     * setTpl(new Template("&lt;div class=\"x-combo-list-item\">" +
     * "&lt;em>{url}&lt;/em>&lt;strong>{text}&lt;/strong>" +
     * "&lt;div class=\"x-clear\">&lt;/div>&lt;/div>"));
     *
     * @param template template to use for rendering items.
     * @see Store
     * @see com.gwtext.client.data.RecordDef
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTpl(String template) throws IllegalStateException {
        if(template.indexOf("<tpl") == -1) {
            template = "<tpl for=\".\">" + template + "</tpl>";
        }
        setAttribute("tpl", template, true);
    }

    /**
     * The action to execute when the trigger field is activated. Use 'all' to run the query specified by the allQuery
     * config option (defaults to 'query').
     *
     * @param triggerAction the trigger action
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTriggerAction(ComboBox.Trigger triggerAction) throws IllegalStateException {
        setAttribute("triggerAction", triggerAction.getTrigger(), true);
    }

    /**
     * True to populate and autoselect the remainder of the text being typed after a configurable delay (typeAheadDelay)
     * if it matches a known value (defaults to false).
     *
     * @param typeAhead enable type ahead
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTypeAhead(boolean typeAhead) throws IllegalStateException {
        setAttribute("typeAhead", typeAhead, true);
    }

    /**
     * The length of time in milliseconds to wait until the typeahead text is displayed if typeAhead = true (defaults to 250)
     *
     * @param typeAheadDelay typeahead delay in milliseconds
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTypeAheadDelay(int typeAheadDelay) throws IllegalStateException {
        setAttribute("typeAheadDelay", typeAheadDelay, true);
    }

    /**
     * The underlying data value name to bind to this CombBox (defaults to undefined).
     * Note: use of a valueField requires the user make a selection in order for a value to be mapped.
     *
     * @param valueField the value field
     */
    public void setValueField(String valueField) {
        setAttribute("valueField", valueField, true, true);
    }

    /**
     * When using a name/value combo, if the value passed to setValue is not found in the store, valueNotFoundText
     * will be displayed as the field text if defined (defaults to undefined).
     *
     * @param valueNotFoundText text when value not found
     */
    public void setValueNotFoundText(String valueNotFoundText) {
        setAttribute("valueNotFoundText", valueNotFoundText, true, true);
    }

}
