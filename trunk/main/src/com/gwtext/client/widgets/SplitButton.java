/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.event.ButtonListener;
import com.gwtext.client.widgets.event.SplitButtonListener;

/**
 * A split button that provides a built-in dropdown arrow that can fire an event separately from the default click event
 * of the button. Typically this would be used to display a dropdown menu that provides additional options to the primary
 * button action, but any custom handler can provide the arrowclick implementation.
 */
public class SplitButton extends Button {

/*	private static JavaScriptObject configPrototype;

	static {
		init();
	}

	private static native void init()*//*-{
        var c = new $wnd.Ext.SplitButton();
        @com.gwtext.client.widgets.SplitButton::configPrototype = c.initialConfig;
    }-*//*;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}*/

    public String getXType() {
        return "splitbutton";
    }

    /**
     * Create a new SplitButton.
     */
    public SplitButton() {
    }

    /**
     * Create a new SplitButton.
     *
     * @param text the button text
     */
    public SplitButton(String text) {
        super(text);
    }

    /**
     * Create a new SplitButton.
     *
     * @param text the button text
     * @param listener the button listener
     */
    public SplitButton(String text, SplitButtonListener listener) {
        super(text, listener);
    }

    /**
     * Create a new SplitButton.
     *
     * @param text the button text
     * @param listener the button listener
     * @param icon the button icon image path
     */
    public SplitButton(String text, SplitButtonListener listener, String icon) {
        super(text, listener, icon);
    }

    public SplitButton(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.SplitButton(config);
    }-*/;

    /**
     * Add a listener.
     *
     * @param listener the listener
     */
    public native void addListener(SplitButtonListener listener) /*-{
        this.@com.gwtext.client.widgets.Button::addListener(Lcom/gwtext/client/widgets/event/ButtonListener;)(listener);
        var componentJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('arrowclick',
                function(self, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.event.SplitButtonListener::onArrowClick(Lcom/gwtext/client/widgets/SplitButton;Lcom/gwtext/client/core/EventObject;)(componentJ, e);
                }
        );
    }-*/;

    // --- config properties ---

    /**
     * The title attribute of the arrow.
     *
     * @param arrowTooltip the arrow tooltip
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setArrowTooltip(String arrowTooltip) throws IllegalStateException {
        setAttribute("arrowTooltip", arrowTooltip, true);
    }

    /**
     * The title attribute of the arrow.
     *
     * @return the title attribute of the arrow.
     */
    public String getArrowTooltip() {
        return JavaScriptObjectHelper.getAttribute(config, "arrowTooltip");
    }
}
