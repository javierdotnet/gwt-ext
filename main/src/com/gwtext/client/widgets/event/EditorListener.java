/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 
package com.gwtext.client.widgets.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.widgets.Editor;
import com.gwtext.client.widgets.form.Field;

/**
 *
 * @author Sanjiv Jivan
 */
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
