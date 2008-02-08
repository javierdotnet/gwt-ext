/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.menu.event;

import com.gwtext.client.widgets.menu.CheckItem;

public class CheckItemListenerAdapter extends BaseItemListenerAdapter implements CheckItemListener {

    public boolean doBeforeCheckChange(CheckItem item, boolean checked) {
        return true;
    }

    public void onCheckChange(CheckItem item, boolean checked) {
    }
}
