/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.SplitButton;

public interface SplitButtonListener extends ButtonListener {

    /**
     * Fires when this button's arrow is clicked.
     *
     * @param menuButton this
     * @param e          the event object
     */
    void onArrowClick(SplitButton menuButton, EventObject e);
}
