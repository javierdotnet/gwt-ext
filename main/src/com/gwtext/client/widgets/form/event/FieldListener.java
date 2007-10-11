/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package com.gwtext.client.widgets.form.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.form.Field;

public interface FieldListener {

    /**
     * Fires when this field loses input focus.
     *
     * @param field this
     */
    void onBlur(Field field);

    /**
     * Fires just before the field blurs if the field value has changed.
     *
     * @param field this
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
     * @param msg the validation message
     */
    void onInvalid(Field field, String msg);

    /**
     * Fires when any key related to navigation (arrows, tab, enter, esc, etc.) is pressed. You can check
     * {@link EventObject#getKey} to determine which key was pressed.
     *
     * @param field this
     * @param e the event object
     */
    void onSpecialKey(Field field, EventObject e);

    /**
     * Fires after the field has been validated with no errors.
     * 
     * @param field this
     */
    void onValid(Field field);
}
