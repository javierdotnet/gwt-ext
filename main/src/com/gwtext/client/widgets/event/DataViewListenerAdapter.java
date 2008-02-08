/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 *
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.event;

import com.google.gwt.user.client.Element;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.DataView;

public class DataViewListenerAdapter extends BoxComponentListenerAdapter implements DataViewListener {

    public boolean doBeforeClick(DataView source, int index, Element node, EventObject e) {
        return true;
    }

    public boolean doBeforeSelect(DataView source, Element node, Element[] selections) {
        return true;
    }

    public void onClick(DataView source, int index, Element node, EventObject e) {
    }

    public void onContainerClick(DataView source, EventObject e) {
    }

    public void onContextMenu(DataView source, int index, Element node, EventObject e) {
    }

    public void onDblClick(DataView source, int index, Element node, EventObject e) {
    }

    public void onSelectionChange(DataView view, Element[] selections) {
    }
}
