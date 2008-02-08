/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.layout;

/**
 * Vertical layout that allows you to add components vertically with the specified spacing betwen them.
 */
public class VerticalLayout extends TableLayout {

    /**
     * Createa new VerticalLayout with no spacing.
     */
    public VerticalLayout() {
        setColumns(1);
    }

    /**
     * Create a new VerticalLayout with the specified spacing between components added.
     *
     * @param spacing the spacing between components
     */
    public VerticalLayout(int spacing) {
        setColumns(1);
        setSpacing("padding:0 0 " + spacing +"px 0");
    }

	public final void setColumns(int columns) {
		super.setColumns(columns);
	}
}
