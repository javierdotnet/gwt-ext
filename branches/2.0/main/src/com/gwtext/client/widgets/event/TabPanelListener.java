/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.event;

import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.core.EventObject;

public interface TabPanelListener extends PanelListener {

    /**
     * Fires before the active tab changes. Return false to cancel the tab change.
     *
     * @param source this
     * @param newPanel the new panel
     * @param oldPanel the old panel
     * @return false to cancel the tab change
     */
    boolean doBeforeTabChange(TabPanel source, Panel newPanel, Panel oldPanel);

    /**
     * Fires when the contextmenu event originated from a tab element.
     *
     * @param source this
     * @param tab the tab
     * @param e the event object
     */
    void onContextMenu(TabPanel source, Panel tab, EventObject e);

    /**
     * Fires after the active tab has changed.
     *
     * @param source this
     * @param tab the selected tab
     */
    void onTabChange(TabPanel source, Panel tab);
}
