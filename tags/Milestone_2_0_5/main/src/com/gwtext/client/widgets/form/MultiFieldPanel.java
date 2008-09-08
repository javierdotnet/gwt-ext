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
 
package com.gwtext.client.widgets.form;

import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FormLayout;

/**
 * This is a helper class that allows you to add multiple fields / widgets to a single row in a Form.
 *
 * @author Sanjiv Jivan
 */
public class MultiFieldPanel extends Panel {

    /**
     * Create a new MultiFieldPanel.
     */
    public MultiFieldPanel() {
        setBorder(true);
        setLayout(new ColumnLayout());
    }

    /**
     * Add a Field with the specified width to the row.
     *
     * @param field the field
     * @param width the width to allocate to the field.
     */
    public void addToRow(Field field, int width) {
        Panel panel = new Panel();
        panel.setBorder(false);
        panel.setLayout(new FormLayout());
        panel.setWidth(width);
        panel.add(field);
        add(panel);
    }

    /**
     * Add a Field to the row.
     *
     * @param field            the field to add
     * @param columnLayoutData the column layout data
     * @see com.gwtext.client.widgets.layout.ColumnLayout
     */
    public void addToRow(Field field, ColumnLayoutData columnLayoutData) {
        Panel panel = new Panel();
        panel.setBorder(false);
        panel.setLayout(new FormLayout());
        panel.add(field);
        add(panel, columnLayoutData);
    }

    /**
     * Add a Widget with the specified width to the row.
     *
     * @param field the field to add
     * @param width the field width
     * @see com.gwtext.client.widgets.layout.ColumnLayout
     */
    public void addToRow(Widget field, int width) {
        Panel panel = new Panel();
        panel.setBorder(false);
        panel.setWidth(width);
        panel.add(field);
        add(panel);
    }

    /**
     * Add a Widget to the row.
     *
     * @param field            the field to add
     * @param columnLayoutData the column layout data
     * @see com.gwtext.client.widgets.layout.ColumnLayout
     */
    public void addToRow(Widget field, ColumnLayoutData columnLayoutData) {
        Panel panel = new Panel();
        panel.setBorder(false);
        panel.add(field);
        add(panel, columnLayoutData);
    }
}
