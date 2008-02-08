/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.form.event;

import com.gwtext.client.widgets.form.Form;

public interface FormListener {

    /**
     * Fires when an action is completed.
     *
     * @param form this
     * @param httpStatus the http status code
     * @param responseText the result html returned by the server
     */
    void onActionComplete(Form form, int httpStatus, String responseText);

    /**
     * Fires when an action fails.
     *
     * @param form this
     * @param httpStatus the http status code
     * @param responseText the result html returned by the server
     */
    void onActionFailed(Form form, int httpStatus, String responseText);


    /**
     * Fires before any action is performed. Return false to cancel the action.
     *
     * @param form this
     * @return false to cancel the action
     */
    boolean doBeforeAction(Form form);
}
