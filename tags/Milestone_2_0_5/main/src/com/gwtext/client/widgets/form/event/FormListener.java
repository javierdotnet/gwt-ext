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
 

package com.gwtext.client.widgets.form.event;

import com.gwtext.client.widgets.form.Form;

/**
 *
 * @author Sanjiv Jivan
 */
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
