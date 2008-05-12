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
 *
 * @author Sanjiv Jivan
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
