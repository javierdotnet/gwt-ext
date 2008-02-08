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
import com.gwtext.client.widgets.event.BoxComponentListenerAdapter;

public class FieldListenerAdapter extends BoxComponentListenerAdapter implements FieldListener {

    public void onBlur(Field field) {
    }

    //make old API final so that it results in compile errors when users' previous code overrides this instead of
    //silently failing. Uses should now use onChange(Field field, Object newVal, Object oldVal)
    public final void onChange(Field field, String newVal, String oldVal) {
    }

    public void onChange(Field field, Object newVal, Object oldVal) {
    }

    public void onFocus(Field field) {
    }

    public void onInvalid(Field field, String msg) {
    }

    public void onSpecialKey(Field field, EventObject e) {
    }

    public void onValid(Field field) {
    }
}
