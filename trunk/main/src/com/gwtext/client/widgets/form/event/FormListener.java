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

import com.gwtext.client.widgets.form.Form;

public interface FormListener {

    /**
     * Fires when an action is completed.
     *
     * @param form this
     */
    void onActionComplete(Form form);

    /**
     * Fires when an action fails.
     *
     * @param form this
     */
    void onActionFailed(Form form);

    /**
     * Fires before any action is performed. Return false to cancel the action.
     *
     * @param form this
     * @return false to cancel the action
     */
    boolean doBeforeAction(Form form);

    /**
     * If the monitorValid config option is true, this event fires repetitively to notify of valid state.
     *
     * @param form this
     * @param valid true if the form has passed client-side validation
     */
    void onClientValidation(Form form, boolean valid);
}
