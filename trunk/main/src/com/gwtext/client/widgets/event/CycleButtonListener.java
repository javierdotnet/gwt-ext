/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.event;

import com.gwtext.client.widgets.CycleButton;
import com.gwtext.client.widgets.menu.CheckItem;

/**
 * Listener for {@link com.gwtext.client.widgets.CycleButton}.
 */
public interface CycleButtonListener extends SplitButtonListener {

    /**
     * Fires after the button's active menu item has changed.
     *
     * @param self this
     * @param item the menu item that was selected
     */
    void onChange(CycleButton self, CheckItem item);
}
