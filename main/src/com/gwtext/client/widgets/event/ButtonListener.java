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

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.menu.Menu;

/**
 * @author Sanjiv Jivan
 */
public interface ButtonListener extends ComponentListener {

    /**
     * Fires when this button is clicked
     *
     * @param button this
     * @param e      the event object
     */
    void onClick(Button button, EventObject e);

    /**
     * If this button has a menu, this event fires when it is hidden.
     *
     * @param button his
     * @param menu   the menu
     */
    void onMenuHide(Button button, Menu menu);

    /**
     * If this button has a menu, this event fires when it is shown.
     *
     * @param button this
     * @param menu   the menu
     */
    void onMenuShow(Button button, Menu menu);

    /**
     * If this button has a menu, this event fires when the mouse leaves the menu triggering element.
     *
     * @param button this
     * @param menu   the menu
     * @param e      the event
     */
    void onMenuTriggerOut(Button button, Menu menu, EventObject e);

    /**
     * If this button has a menu, this event fires when the mouse enters the menu triggering element.
     *
     * @param button this
     * @param menu   the menu
     * @param e      the event
     */
    void onMenuTriggerOver(Button button, Menu menu, EventObject e);

    /**
     * Fires when the mouse exits the button.
     *
     * @param button this
     * @param e      the event object
     */
    void onMouseOut(Button button, EventObject e);

    /**
     * Fires when the mouse hovers over the button.
     *
     * @param button this
     * @param e      the event object
     */
    void onMouseOver(Button button, EventObject e);

    /**
     * Fires when the "pressed" state of this button changes (only if enableToggle = true).
     *
     * @param button  this
     * @param pressed true if pressed
     */
    void onToggle(Button button, boolean pressed);
}
