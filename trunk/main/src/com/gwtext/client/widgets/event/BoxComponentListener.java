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

import com.gwtext.client.widgets.BoxComponent;

/**
 *
 * @author Sanjiv Jivan
 */
public interface BoxComponentListener extends ComponentListener {

    /**
     * Fires after the component is moved.
     *
     * @param component this
     * @param x         the new x position
     * @param y         the new y position
     */
    void onMove(BoxComponent component, int x, int y);

    /**
     * Fires after the component is resized. Note that percentage based widths and auto widths are passed as -1.
     *
     * @param component this
     * @param adjWidth  the box-adjusted width that was set
     * @param adjHeight the box-adjusted height that was set
     * @param rawWidth  the width that was originally specified
     * @param rawHeight the height that was originally specified
     */
    void onResize(BoxComponent component, int adjWidth, int adjHeight, int rawWidth, int rawHeight);
}
