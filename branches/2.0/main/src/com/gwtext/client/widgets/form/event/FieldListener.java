/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.form.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.event.BoxComponentListener;

public interface FieldListener extends BoxComponentListener {

    /**
     * Fires when this field loses input focus.
     *
     * @param field this
     */
    void onBlur(Field field);

    /**
     * Fires just before the field blurs if the field value has changed.
     *
     * @param field  this
     * @param newVal the new value
     * @param oldVal the old value
     */
    void onChange(Field field, Object newVal, Object oldVal);

    /**
     * Fires when this field receives input focus.
     *
     * @param field this
     */
    void onFocus(Field field);

    /**
     * Fires after the field has been marked as invalid.
     *
     * @param field this
     * @param msg   the validation message
     */
    void onInvalid(Field field, String msg);

    /**
     * Fires when any key related to navigation (arrows, tab, enter, esc, etc.) is pressed. You can check
     * {@link EventObject#getKey} to determine which key was pressed.
     *
     * @param field this
     * @param e     the event object
     */
    void onSpecialKey(Field field, EventObject e);

    /**
     * Fires after the field has been validated with no errors.
     *
     * @param field this
     */
    void onValid(Field field);
}
