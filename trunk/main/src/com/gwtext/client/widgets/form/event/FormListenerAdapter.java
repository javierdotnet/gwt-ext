/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.form.event;

import com.gwtext.client.widgets.form.Form;

public class FormListenerAdapter implements FormListener {

    public void onActionComplete(Form form, int httpStatus, String responseText) {
    }

    public void onActionFailed(Form form, int httpStatus, String responseText) {
    }

    public boolean doBeforeAction(Form form) {
        return true;
    }
}
