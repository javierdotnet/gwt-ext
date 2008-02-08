/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.grid;

import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.sample.showcase2.client.SampleGrid;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class ListGridSample extends ShowcasePanel {

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            GridPanel grid = new SampleGrid(false, new int[]{0});
            grid.setHideColumnHeader(true);
            grid.setHeight(320);
            grid.setWidth(220);
            grid.setIconCls(null);
            panel.add(grid);
        }
        return panel;
    }

    public String getIntro() {
        return "<p>This is an example of a simple Grid styled as a List box by hiding the Grid's column header. This is done by calling setHideColumnHeader(true) on the GridPanel</p>";
    }
}