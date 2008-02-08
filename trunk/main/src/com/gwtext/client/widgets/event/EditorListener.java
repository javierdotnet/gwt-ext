/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.widgets.Editor;
import com.gwtext.client.widgets.form.Field;

public interface EditorListener extends ComponentListener {

    /**
     * Fires after a change has been made to the field, but before the change is reflected in the underlying field.
     * Saving the change to the field can be canceled by returning false from the handler of this event. Note that
     * if the value has not changed and ignoreNoChange = true, the editing will still end but this event will not fire since no edit actually occurred.
     *
     * @param source     this
     * @param value      the current field value
     * @param startValue the original field value
     * @return false to cancel the field edit
     */
    boolean doBeforeComplete(Editor source, Object value, Object startValue);

    /**
     * Fires when editing is initiated, but before the value changes. Editing can be canceled by returning false from
     * the handler of this event.
     *
     * @param source  this
     * @param boundEl the underlying element bound to this editor
     * @param value   the field value beign set
     * @return fale to cancel the editing
     */
    boolean doBeforeStartEdit(Editor source, ExtElement boundEl, Object value);

    /**
     * Fires after editing is complete and any changed value has been written to the underlying field.
     *
     * @param source     this
     * @param value      the current field value
     * @param startValue the original field value
     */
    void onComplete(Editor source, Object value, Object startValue);

    //todo not firing?
    /**
     * Fires when any key related to navigation (arrows, tab, enter, esc, etc.) is pressed. You can check
     * {@link EventObject#getKey} to determine which key was pressed.
     *
     * @param field this
     * @param e     the event object
     */
    void onSpeciakKey(Field field, EventObject e);
}
