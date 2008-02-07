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

public class EditorListenerAdapter extends ComponentListenerAdapter implements EditorListener {

    public boolean doBeforeComplete(Editor source, Object value, Object startValue) {
        return true;
    }

    public boolean doBeforeStartEdit(Editor source, ExtElement boundEl, Object value) {
        return true;
    }

    public void onComplete(Editor source, Object value, Object startValue) {
    }

    public void onSpeciakKey(Field field, EventObject e) {
    }
}
