/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.form;

import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FormLayout;

/**
 * This is a helper class that allows you to add multiple fields / widgets to a single row in a Form.
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
