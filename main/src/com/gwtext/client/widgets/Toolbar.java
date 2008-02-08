/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 *
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.widgets.form.Field;

/**
 * Basic Toolbar class.
 */
public class Toolbar extends BoxComponent {

  private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
        var c = new $wnd.Ext.Toolbar();
        @com.gwtext.client.widgets.Toolbar::configPrototype = c.initialConfig;
    }-*/;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

    /**
     * Create a new Toolbar.
     */
    public Toolbar() {
    }

    public Toolbar(JavaScriptObject jsObj) {
        super(jsObj);
    }

	public String getXType() {
        return "toolbar";
    }

	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		if(!config.items) config.items = new $wnd.Array();
		return new $wnd.Ext.Toolbar(config);
    }-*/;


    /**
     * Adds a button to the toolbar.
     *
     * @param button the button
     */
    public void addButton(ToolbarButton button) {
		if (isRendered()) {
			JavaScriptObject componentJS = button.isCreated() ? button.getOrCreateJsObj() : button.getConfig();
			addButtonPostRender(componentJS);

		} else {
			JavaScriptObject componentJS = button.isCreated() ? button.getOrCreateJsObj() : button.getConfig();
			addButtonPreRender(componentJS);
		}
	}

	private native void addButtonPreRender(JavaScriptObject componentJS) /*-{
		var config = this.@com.gwtext.client.widgets.Component::config;

        if(!config.items) {
            config.items = new $wnd.Array();
        }
        config.items.push(componentJS);
    }-*/;

	private native void addButtonPostRender(JavaScriptObject componentJS) /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        panel.addButton(componentJS);
    }-*/;


	/**
     * Adds a toolbar menu button.
     *
     * @param button the button to add
     */
	public void addButton(ToolbarMenuButton button) {
		if (isRendered()) {
			JavaScriptObject componentJS = button.isCreated() ? button.getOrCreateJsObj() : button.getConfig();
			addButtonPostRender(componentJS);

		} else {
			JavaScriptObject componentJS = button.isCreated() ? button.getOrCreateJsObj() : button.getConfig();
			addButtonPreRender(componentJS);
		}
	}

    /**
     * Adds any standard element to the toolbar.
     *
     * @param element the element to add
     */
    public void addElement(Element element) {
        addItem(new ToolbarItem(element));
    }

    /**
     * Adds a dynamically rendered {@link Field} (TextField, ComboBox, etc). Note: the field should not have been rendered yet.
     *
     * @param field the field to add
     */
    public void addField(Field field) {
		if (isRendered()) {
			JavaScriptObject componentJS = field.isCreated() ? field.getOrCreateJsObj() : field.getConfig();
			addFieldPostRender(componentJS);

		} else {
			JavaScriptObject componentJS = field.isCreated() ? field.getOrCreateJsObj() : field.getConfig();
			addFieldPreRender(componentJS);
		}
	}

    private static native void addFieldPostRender(JavaScriptObject field)/*-{
		var toolbar = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		toolbar.addField(field);
    }-*/;

	private native void addFieldPreRender(JavaScriptObject componentJS) /*-{
		var config = this.@com.gwtext.client.widgets.Component::config;

        if(!config.items) {
            config.items = new $wnd.Array();
        }
        config.items.push(componentJS);
    }-*/;

	//http://extjs.com/forum/showthread.php?t=2470
    /**
     * Adds a fill element that forces subsequent additions to the right side of the toolbar.
     */
	public void addFill() {
		if(isRendered()) {
			addFillRendered();
		} else {
			addItem(new ToolbarFill());
		}
	}

	private native void addFillRendered() /*-{
        var toolbar = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        toolbar.addFill();
    }-*/;

    /**
     * Adds any {@link ToolbarItem} or subclass.
     *
     * @param item the item to add
     */
    public void addItem(ToolbarItem item) {
	    if (isRendered()) {
			JavaScriptObject componentJS = item.getJsObj();
			addItemPostRender(componentJS);

		} else {
			JavaScriptObject componentJS = item.getJsObj();
			addItemPreRender(componentJS);
		}
	}

	private native void addItemPreRender(JavaScriptObject componentJS) /*-{
		var config = this.@com.gwtext.client.widgets.Component::config;

        if(!config.items) {
            config.items = new $wnd.Array();
        }
        config.items.push(componentJS);
    }-*/;

	private native void addItemPostRender(JavaScriptObject componentJS) /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        panel.addItem(componentJS);
    }-*/;

	/**
     * Adds a separator.
     */
	public void addSeparator() {
		if(isRendered()) {
			addSeparatorRendered();
		} else {
			addItem(new ToolbarSeparator());
		}
	}

	private native void addSeparatorRendered() /*-{
        var toolbar = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var separator = toolbar.addSeparator();
    }-*/;

    /**
     * Adds a spacer element.
     *
     */
    public void addSpacer(){
		if(isRendered()) {
			addSpacerRendered();
		} else {
			addItem(new ToolbarSpacer());
		}
	}

	private native void addSpacerRendered() /*-{
        var toolbar = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var spacer = toolbar.addSpacer();
    }-*/;

    /**
     * Adds text to the toolbar.
     *
     * @param text the text
     */
    public void addText(String text) {
	    if(isRendered()) {
			addTextRendered(text);
		} else {
			addItem(new ToolbarTextItem(text));
		}
	}

	private native void addTextRendered(String text) /*-{
        var toolbar = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        toolbar.addText(text);
    }-*/;

	//todo2
	/**
     * Inserts a ToolbarItem at the specified index.
     *
     * @param index the index to insert at
     * @param item the idnem to inser
     */
    /*public void insertItem(int index, ToolbarItem item) {
        insertButton(getJsObj(), index, item.getJsObj());
    }

    private native void insertButton(JavaScriptObject toolbar, int index, JavaScriptObject item) *//*-{
        toolbar.insertButton(index, item);
    }-*//*;
*/
    /**
     * Inserts a ToolbarButton at the specified index.
     *
     * @param index the index to insert at
     * @param button the button to isnert
     */
  /*  public void insertButton(int index, ToolbarButton button) {
        insertButton(getJsObj(), index, button.getJsObj());
    }*/
}
