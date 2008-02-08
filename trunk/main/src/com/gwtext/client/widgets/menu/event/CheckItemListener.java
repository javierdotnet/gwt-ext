/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.menu.event;

import com.gwtext.client.widgets.menu.CheckItem;

public interface CheckItemListener extends BaseItemListener {

    /**
     * Fires before the checked value is set, providing an opportunity to cancel if needed.
     *
     * @param item    this
     * @param checked the new checked value that will be set
     * @return false to cancel
     */
    boolean doBeforeCheckChange(CheckItem item, boolean checked);

    /**
     * Fires after the checked value has been set.
     *
     * @param item    this
     * @param checked the checked value that was set
     */
    void onCheckChange(CheckItem item, boolean checked);
}
