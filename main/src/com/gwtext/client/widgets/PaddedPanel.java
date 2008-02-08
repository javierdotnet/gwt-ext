/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets;

/**
 * Helper class that wraps a Panel with shell panel adding the specified padding.
 * Useful when laying out panels using ColumnLayouts or the other layouts which
 * place the panels right beside each otehr without spacing.
 */
public class PaddedPanel extends Panel {

    /**
     * Create a Padded Panel.
     *
     * @param panel the panel to wrap
     * @param paddings the paddings
     */
    public PaddedPanel(Panel panel, int paddings) {
        setBaseCls("x-plain");
        setPaddings(paddings);
        add(panel);
    }

    /**
     * Wraps the passed Panel with a shell Panel having the specified padding values.
     *
     * @param panel the panel the wrap
     * @param top the top padding
     * @param left the left padding
     * @param right the right padding
     * @param bottom the bottom padding
     */
    public PaddedPanel(Panel panel, int top, int left, int right, int bottom) {
        setBaseCls("x-plain");
        setPaddings(top, left, right, bottom);
        add(panel);
    }
}
