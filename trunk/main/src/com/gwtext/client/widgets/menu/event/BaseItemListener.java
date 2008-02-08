/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.menu.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.menu.BaseItem;
import com.gwtext.client.widgets.event.ComponentListener;

public interface BaseItemListener extends ComponentListener {

    /**
     * Fires when this item is activated
     *
     * @param item this
     */
    void onActivate(BaseItem item);

    /**
     * Fires when this item is clicked
     *
     * @param item the item
     * @param e    the event object
     */
    void onClick(BaseItem item, EventObject e);

    /**
     * Fires when this item is deactivated
     *
     * @param item this
     */
    void onDeactivate(BaseItem item);
}
