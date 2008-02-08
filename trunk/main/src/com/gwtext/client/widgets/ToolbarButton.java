/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.event.ButtonListener;
import com.gwtext.client.widgets.menu.Menu;

//toolbar button doesnt get rendered and even created when a new object is instantiated. it is rendered at the point it
//is added to the toolbar. so we cant register the event handlers with the underlying widget until it is rendered

//ie. after it has been added to the toolbar
/**
 * A button that renders into a toolbar.
 */
public class ToolbarButton extends Button {

  private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
        var c = new $wnd.Ext.Toolbar.Button();
        @com.gwtext.client.widgets.ToolbarButton::configPrototype = c.initialConfig;
    }-*/;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "tbbutton";
	}

    /**
     * Create a new ToolbarButton.
     */
    public ToolbarButton() {
    }

    /**
     * Create a new ToolbarButton.
     *
     * @param text the button text
     */
    public ToolbarButton(String text) {
        super(text);
    }

    /**
     * Create a new ToolbarButton.
     *
     * @param text the button text
     * @param menu the button menu
     */
    public ToolbarButton(String text, Menu menu) {
        super(text, menu);
    }

    /**
     * Create a new ToolbarButton.
     *
     * @param text the button text
     * @param listener the button listner
     */
    public ToolbarButton(String text, ButtonListener listener) {
        super(text, listener);
    }

    /**
     * Create a new ToolbarButton.
     *
     * @param text the button text
     * @param listener the button listner
     * @param icon the button icon image path
     */
    public ToolbarButton(String text, ButtonListener listener, String icon) {
        super(text, listener, icon);
    }

    public ToolbarButton(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.Toolbar.Button(config);
    }-*/;
}
