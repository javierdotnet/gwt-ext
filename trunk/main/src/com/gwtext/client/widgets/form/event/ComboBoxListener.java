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

import com.gwtext.client.data.Record;
import com.gwtext.client.widgets.form.ComboBox;

/**
 *
 * @author Sanjiv Jivan
 */
public interface ComboBoxListener extends FieldListener {

    /**
     * Fires before all queries are processed. Return false to cancel the query.
     *
     * @param comboBox this
     * @param cb       callback
     * @return false to cancel the query
     */
    boolean doBeforeQuery(ComboBox comboBox, ComboBoxCallback cb);

    /**
     * Fires before a list item is selected. Return false to cancel the selection.
     *
     * @param comboBox this
     * @param record   the data record returned from the underlying store
     * @param index    the data record returned from the underlying store
     * @return false to cancel
     */
    boolean doBeforeSelect(ComboBox comboBox, Record record, int index);

    /**
     * Fires when the dropdown list is collapsed.
     *
     * @param comboBox this
     */
    void onCollapse(ComboBox comboBox);

    /**
     * Fires when the dropdown list is expanded.
     *
     * @param comboBox this
     */
    void onExpand(ComboBox comboBox);

    /**
     * Fires when a list item is selected.
     *
     * @param comboBox this
     * @param record   the data record returned from the underlying store
     * @param index    the data record returned from the underlying store
     */
    void onSelect(ComboBox comboBox, Record record, int index);
}
