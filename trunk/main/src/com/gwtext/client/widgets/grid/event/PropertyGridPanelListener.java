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

package com.gwtext.client.widgets.grid.event;

import com.gwtext.client.widgets.grid.PropertyGridPanel;

/**
 * {@link com.gwtext.client.widgets.grid.PropertyGridPanel} listener.
 *
 * @author Sanjiv Jivan
 */
public interface PropertyGridPanelListener {

    /**
     * Fires before a property value changes. Handlers can return false to cancel the property change (this will internally call
     * {@link com.gwtext.client.data.Record#reject()}  on the property's record).
     *
     * @param source this
     * @param recordID the recordID
     * @param value the current edited property value
     * @param oldValue the original property value prior to editing
     * @return false to cancel
     */
    boolean doBeforePropertyChange(PropertyGridPanel source, String recordID, Object value, Object oldValue);

    /**
     * Fires after a property value has changed.
     *
     * @param source this
     * @param recordID the recordID
     * @param value the current edited property value
     * @param oldValue the original property value prior to editing
     */
    void onPropertyChange(PropertyGridPanel source, String recordID, Object value, Object oldValue);

    
}
