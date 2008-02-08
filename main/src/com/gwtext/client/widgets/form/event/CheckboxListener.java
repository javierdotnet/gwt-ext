/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.form.event;

import com.gwtext.client.widgets.form.Checkbox;

public interface CheckboxListener extends FieldListener {

    /**
     * Fires when the checkbox is checked or unchecked.
     *
     * @param field   this field
     * @param checked the new checked value
     */
    void onCheck(Checkbox field, boolean checked);
}
