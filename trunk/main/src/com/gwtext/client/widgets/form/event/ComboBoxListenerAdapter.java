/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.form.event;

import com.gwtext.client.data.Record;
import com.gwtext.client.widgets.form.ComboBox;

public class ComboBoxListenerAdapter extends FieldListenerAdapter implements ComboBoxListener {

    public boolean doBeforeQuery(ComboBox comboBox, ComboBoxCallback cb) {
        return true;
    }

    public boolean doBeforeSelect(ComboBox comboBox, Record record, int index) {
        return true;
    }

    public void onCollapse(ComboBox comboBox) {
    }

    public void onExpand(ComboBox comboBox) {
    }

    public void onSelect(ComboBox comboBox, Record record, int index) {
    }
}
