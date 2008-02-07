package com.gwtext.client.widgets.event;

import com.gwtext.client.widgets.Window;

/**
 * {@link com.gwtext.client.widgets.Window} listener.
 */
public interface WindowListener extends PanelListener {

    /**
     * Fires after the window has been visually activated via {@link Window#setActive}.
     *
     * @param source this
     */
    void onActivate(Window source);

    /**
     * Fires after the window has been visually deactivated via {@link Window#setActive(boolean)}
     *
     * @param source this
     */
    void onDeactivate(Window source);

    /**
     * Fires after the window has been maximized.
     *
     * @param source this
     */
    void onMaximize(Window source);

    /**
     * Fires after the window has been minimized.
     *
     * @param source this
     */
    void onMinimize(Window source);

    /**
     * Fires after the window has been resized.
     *
     * @param source this
     * @param width the new width
     * @param height the new height
     */
    void onResize(Window source, int width, int height);

    /**
     * Fires after the window has been restored to its original size after being maximized.
     *
     * @param source this
     */
    void onRestore(Window source);
}
