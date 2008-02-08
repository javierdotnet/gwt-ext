/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets;

import com.gwtext.client.animation.Easing;
import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Configuration class for {@link com.gwtext.client.widgets.Resizable}.
 */
public class ResizableConfig extends BaseConfig {

    /**
     * Sets the adjustments to "auto".
     */
    public void setAutoAdjustments() {
        JavaScriptObjectHelper.setAttribute(jsObj, "adjustments", "auto");
    }

    /**
     * The width, height adjustments to be added to the resize operation's new size. Defaults to 0, 0
     *
     * @param widthAdjustment  the width adjustment
     * @param heightAdjustment the height adjustent
     */
    public void setAdjustments(int widthAdjustment, int heightAdjustment) {
        int[] adjustments = new int[]{widthAdjustment, heightAdjustment};
        JavaScriptObjectHelper.setAttribute(jsObj, "adjustments", adjustments);
    }

    /**
     * True to animate the resize (not compatible with dynamic sizing, defaults to false).
     *
     * @param animate true to anumate resize
     */
    public void setAnimate(boolean animate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "animate", animate);
    }

    /**
     * True to disable mouse tracking. This is only applied at config time. (defaults to false).
     *
     * @param disableTrackOver true to disable mouse tracking
     */
    public void setDisableTrackOver(boolean disableTrackOver) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disableTrackOver", disableTrackOver);
    }

    /**
     * Convenience to initialize drag drop (defaults to false).
     *
     * @param draggable true to initialize drag and drop
     */
    public void setDraggable(boolean draggable) {
        JavaScriptObjectHelper.setAttribute(jsObj, "draggable", draggable);
    }

    /**
     * Animation duration if animate = true (defaults to .35).
     *
     * @param duration the animation duration
     */
    public void setDuration(float duration) {
        JavaScriptObjectHelper.setAttribute(jsObj, "duration", duration);
    }

    /**
     * True to resize the element while dragging instead of using a proxy (defaults to false).
     *
     * @param dynamic true to resize element and not proxy during dragging
     */
    public void setDynamic(boolean dynamic) {
        JavaScriptObjectHelper.setAttribute(jsObj, "dynamic", dynamic);
    }

    /**
     * Animation easieng if animate = true. Defaults to {@link Easing#EASE_OUT_STRONG}
     *
     * @param easing the easing method
     */
    public void setEasing(Easing easing) {
        JavaScriptObjectHelper.setAttribute(jsObj, "easing", easing.getMethod());
    }

    /**
     * False to disable resizing (defaults to true).
     *
     * @param enabled false to disable resizing
     */
    public void setEnabled(boolean enabled) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enabled", enabled);
    }

    /**
     * The resize handles to display (defaults to none)
     *
     * @param handles the resize handles to display
     */
    public void setHandles(Resizable.Handle handles) {
        JavaScriptObjectHelper.setAttribute(jsObj, "handles", handles.getHandle());
    }

    /**
     * The height of the element in pixels (defaults to null).
     *
     * @param height the element height
     */
    public void setHeight(int height) {
        JavaScriptObjectHelper.setAttribute(jsObj, "height", height);
    }

    /**
     * The increment to snap the height resize in pixels (dynamic must be true, defaults to 0).
     *
     * @param heightIncrement the height increment
     */
    public void setHeightIncrement(int heightIncrement) {
        JavaScriptObjectHelper.setAttribute(jsObj, "heightIncrement", heightIncrement);
    }

    /**
     * The maximum height for the element (defaults to 10000).
     *
     * @param maxHeight the max height of element
     */
    public void setMaxHeight(int maxHeight) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxHeight", maxHeight);
    }

    /**
     * The maximum width for the element (defaults to 10000).
     *
     * @param maxWidth the max width
     */
    public void setMaxWidth(int maxWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxWidth", maxWidth);
    }

    /**
     * The minimum height for the element (defaults to 5).
     *
     * @param minHeight the min height
     */
    public void setMinHeight(int minHeight) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minHeight", minHeight);
    }

    /**
     * The minimum width for the element (defaults to 5).
     *
     * @param minWidth the min width
     */
    public void setMinWidth(int minWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minWidth", minWidth);
    }

    /**
     * The minimum allowed page X for the element (only used for west resizing, defaults to 0).
     *
     * @param minX the min x value
     */
    public void setMinX(int minX) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minX", minX);
    }

    /**
     * The minimum allowed page Y for the element (only used for north resizing, defaults to 0).
     *
     * @param minY the min Y value
     */
    public void setMinY(int minY) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minY", minY);
    }

    /**
     * True to ensure that the resize handles are always visible, false to display them only when the user mouses over
     * the resizable borders. This is only applied at config time. (defaults to false)
     *
     * @param pinned true to ensure that the resize handles are always visible
     */
    public void setPinned(boolean pinned) {
        JavaScriptObjectHelper.setAttribute(jsObj, "pinned", pinned);
    }

    /**
     * True to preserve the original ratio between height and width during resize (defaults to false).
     *
     * @param preserveRatio true to preserve ratio
     */
    public void setPreserveRatio(boolean preserveRatio) {
        JavaScriptObjectHelper.setAttribute(jsObj, "preserveRatio", preserveRatio);
    }

    /**
     * True to resize the first child, or id/element to resize (defaults to false).
     *
     * @param resizeChild true to resize the first child
     */
    public void setResizeChild(boolean resizeChild) {
        JavaScriptObjectHelper.setAttribute(jsObj, "resizeChild", resizeChild);
    }

    /**
     * True for transparent handles. This is only applied at config time. (defaults to false).
     *
     * @param transparent true for transparent handles
     */
    public void setTransparent(boolean transparent) {
        JavaScriptObjectHelper.setAttribute(jsObj, "transparent", transparent);
    }

    /**
     * The width of the element in pixels (defaults to null).
     *
     * @param width the width of element
     */
    public void setWidth(int width) {
        JavaScriptObjectHelper.setAttribute(jsObj, "width", width);
    }

    /**
     * The increment to snap the width resize in pixels (dynamic must be true, defaults to 0).
     *
     * @param widthIncrement the width increment
     */
    public void setWidthIncrement(boolean widthIncrement) {
        JavaScriptObjectHelper.setAttribute(jsObj, "widthIncrement", widthIncrement);
    }

    /**
     * True to wrap an element with a div if needed (required for textareas and images, defaults to false).
     *
     * @param wrap true to wrap element in a div if needed
     */
    public void setWrap(boolean wrap) {
        JavaScriptObjectHelper.setAttribute(jsObj, "wrap", wrap);
    }
}
