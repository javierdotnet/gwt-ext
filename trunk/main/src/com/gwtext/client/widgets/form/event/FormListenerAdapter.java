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

    /**
     * Use {@link #onActionComplete(com.gwtext.client.widgets.form.Form, int, String)}
     *
     * @param form this
     */
    final public void onActionComplete(Form form) {
    }

    public void onActionComplete(Form form, int httpStatus, String responseText) {
    }

    public void onActionFailed(Form form, int httpStatus, String responseText) {
    }

    public boolean doBeforeAction(Form form) {
        return true;
    }

    public void onClientValidation(Form form, boolean valid) {
    }
}
