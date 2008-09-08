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

package com.gwtext.client.widgets.event;

import com.gwtext.client.widgets.Window;

/**
 * {@link com.gwtext.client.widgets.Window} listener.
 *
 * @author Sanjiv Jivan
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
