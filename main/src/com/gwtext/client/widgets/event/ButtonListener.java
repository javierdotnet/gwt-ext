/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.menu.Menu;

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
