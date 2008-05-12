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
 
package com.gwtext.client.widgets.layout;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * <p>This layout contains multiple panels, each fit to the container, where only a single panel can be visible at any given time.
 * This layout style is most commonly used for wizards, tab implementations, etc. </p>
 * <p/>
 * <p>The CardLayout's focal method is setActiveItem. Since only one panel is displayed at a time, the only way to move
 * from one panel to the next is by calling setActiveItem, passing the id or index of the next panel to display. The layout
 * itself does not provide a mechanism for handling this navigation, so that functionality must be provided by the developer.</p>
 *
 * @author Sanjiv Jivan
 */
public class CardLayout extends FitLayout {

    /**
     * Contruct a new CardLayout
     */
    public CardLayout() {
    }

    /**
     * Construct a new CardLayout.
     *
     * @param deferredRender true to render each contained item at the time it becomes active, false to render all contained items as soon as
     *                         the layout is rendered (defaults to false).
     */
    public CardLayout(boolean deferredRender) {
        setDeferredRender(deferredRender);
    }

    /**
     * True to render each contained item at the time it becomes active, false to render all contained items as soon as
     * the layout is rendered (defaults to false). If there is a significant amount of content or a lot of heavy controls
     * being rendered into panels that are not displayed by default, setting this to true might improve performance.
     *
     * @param deferredRender true to render each contained item at the time it becomes active
     */
    public void setDeferredRender(boolean deferredRender) {
        JavaScriptObjectHelper.setAttribute(configJS, "deferredRender", deferredRender);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.layout.CardLayout(config);
    }-*/;

    /**
     * Sets the active (visible) item in the layout.
     *
     * @param index the item index
     */
    public native void setActiveItem(int index) /*-{
        var layout = this.@com.gwtext.client.widgets.layout.ContainerLayout::jsObj;
        layout.setActiveItem(index);
    }-*/;

    /**
     * Sets the active (visible) item in the layout.
     *
     * @param itemID the item ID
     */
    public native void setActiveItem(String itemID) /*-{
        var layout = this.@com.gwtext.client.widgets.layout.ContainerLayout::jsObj;
        layout.setActiveItem(itemID);
    }-*/;
}
