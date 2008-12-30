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