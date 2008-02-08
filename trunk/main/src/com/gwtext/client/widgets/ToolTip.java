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
import com.gwtext.client.core.Function;

/**
 * A standard tooltip implementation for providing additional information when hovering over a target element.
 */
public class ToolTip extends Tip {

    public ToolTip() {
    }

    public ToolTip(String html) {
        super(html);
    }

    public ToolTip(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ToolTip(config);
    }-*/;

    /**
     * True to automatically hide the tooltip after the mouse exits the target element or after the dismissDelay has
     * expired if set (defaults to true). If closable = true a close tool button will be rendered into the tooltip header.
     *
     * @param autoHide true to auto hide
     */
    public void setAutoHide(boolean autoHide) {
        setAttribute("autoHide", autoHide, true, true);
    }

    /**
     * Delay in milliseconds before the tooltip automatically hides (defaults to 5000). To disable automatic hiding,
     * set dismissDelay = 0.
     *
     * @param dismissDelay the dismiss delay
     */
    public void setDismissDelay(int dismissDelay) {
        setAttribute("dismissDelay", dismissDelay, true, true);
    }

    /**
     * Delay in milliseconds after the mouse exits the target element but before the tooltip actually hides (defaults to 200).
     * Set to 0 for the tooltip to hide immediately.
     *
     * @param hideDelay the hide delay
     */
    public void setHideDelay(int hideDelay) {
        setAttribute("hideDelay", hideDelay, true, true);
    }

    /**
     * An XY offset from the mouse position where the tooltip should be shown.
     *
     * @param x the X offset
     * @param y the Y offset
     */
    public void setMouseOffset(int x, int y) {
        int[] mouseOffset = new int[]{x, y};
        setAttribute("mouseOffset", mouseOffset, true, true);
    }

    /**
     * Delay in milliseconds before the tooltip displays after the mouse enters the target element (defaults to 500).
     *
     * @param showDelay the show delay
     */
    public void setShowDelay(int showDelay) {
        setAttribute("showDelay", showDelay, true, true);
    }

    /**
     * True to have the tooltip follow the mouse as it moves over the target element (defaults to false).
     *
     * @param trackMouse true to track mouse
     */
    public void setTrackMouse(boolean trackMouse) {
        setAttribute("trackMouse", trackMouse, true, true);
    }

    /**
     * Hides this tooltip if visible.
     */
    public native void hide() /*-{
        var tooltip  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        tooltip.hide();
    }-*/;

    /**
     * Shows this tooltip at the current event target XY position.
     */
    public native void show() /*-{
        var tooltip  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        tooltip.show();
    }-*/;

    /**
     * Applies the tooltip to the specified target.
     *
     * @param target the target element
     */
    public void applyTo(Element target) {
        setAttribute("target", target, true);
        getOrCreateJsObj();
    }

    /**
     * Applies the tooltip to the specified target. Note that the element with the specified ID must be
     * rendered to the DOM before this call is made.
     *
     * @param elementID the target element ID
     */
    public void applyTo(String elementID) {
        setAttribute("target", elementID, true);
        getOrCreateJsObj();
    }

    /**
     * Applies the tooltip to the specified target.
     *
     * @param component the component to apply the tooltip to
     */
    public void applyTo(final Component component) {
        if (component.isRendered()) {
            setAttribute("target", component.getElement(), true);
            create(config);
        } else {
            component.addListener("render", new Function() {
                public void execute() {
                    applyTo(component);
                }
            });
        }
    }


}
