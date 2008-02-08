/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.form.event;

import com.gwtext.client.widgets.form.Field;

public interface TextFieldListener extends FieldListener {

    /**
     * Fires when the autosize function is triggered. The field may or may not have actually changed size according to
     * the default logic, but this event provides a hook for the developer to apply additional logic at runtime to
     * resize the field if needed.
     *
     * @param field this
     * @param width the new field width
     */
    void onAutoSize(Field field, int width);
}
