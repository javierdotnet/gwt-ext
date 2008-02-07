/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.event;

import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.core.EventObject;

/**
 * TabPanelListener adapter class.
 */
public class TabPanelListenerAdapter extends PanelListenerAdapter implements TabPanelListener {

    public boolean doBeforeTabChange(TabPanel source, Panel newPanel, Panel oldPanel) {
        return true;
    }

    public void onContextMenu(TabPanel source, Panel tab, EventObject e) {        
    }

    public void onTabChange(TabPanel source, Panel tab) {
    }
}
