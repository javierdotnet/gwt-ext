/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
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
