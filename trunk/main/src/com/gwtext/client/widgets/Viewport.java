/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.widgets.layout.FitLayout;

/**
 * A specialized container representing the viewable application area (the browser viewport).
 * <br>
 * The Viewport renders itself to the document body, and automatically sizes itself to the size of the browser viewport and
 * manages window resizing. There may only be one Viewport created in a page.
 * <p>
 * This class takes the "main" / top level panel passed in its constructor and "expands" it to fit the browsers viewable area.
 *
 * You must not add the "main" panel to GWT's RootPanel via RootPanel.get().add(..) when using the ViewPort class - this is done
 * automatically for you.
 */
public class Viewport  {

    private JavaScriptObject jsObj;

    public Viewport() {
    }

    /**
     * Create a Viewport class.
     *
     * @param mainPanel the application's "main" / top level panel which can contain child panels and components.
     */
    public Viewport(Panel mainPanel) {

        final Panel viewportPanel = new Panel();
        viewportPanel.setLayout(new FitLayout());
        viewportPanel.add(mainPanel);

        jsObj = create(viewportPanel.getConfig());
        doLayout();        

    }

    /**
     * Force this container's layout to be recalculated. A call to this function is required after adding a new component to an
     * already rendered container. If you are not dynamically adding and removing components after render, this function will generally
     * not need to be called.
     */
    public native void doLayout() /*-{
		var container = this.@com.gwtext.client.widgets.Viewport::jsObj;
        container.doLayout();
    }-*/;
    
    protected native String getId(JavaScriptObject viewport) /*-{
        return viewport.getId();
    }-*/;

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.Viewport(config);
    }-*/;
}
