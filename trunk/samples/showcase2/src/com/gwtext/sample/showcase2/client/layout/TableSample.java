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
 
package com.gwtext.sample.showcase2.client.layout;

import com.gwtext.client.widgets.PaddedPanel;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.layout.TableLayout;
import com.gwtext.client.widgets.layout.TableLayoutData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class TableSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/layout/TableSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            panel.setLayout(new FitLayout());

            Panel wrapperPanel = new Panel();
            wrapperPanel.setAutoScroll(true);
            wrapperPanel.setBorder(true);
            wrapperPanel.setBodyStyle("border-style:dotted;border-color:blue;");
            wrapperPanel.setLayout(new TableLayout(3));
            //this add a blue background to the panel content area
            wrapperPanel.setBaseCls("x-plain");

            //add top and right padding to each panel so that they look neat instead of right beside each other
            wrapperPanel.add(new PaddedPanel(new Panel("Item 1", 100, 100), 0, 0, 10, 10));
            wrapperPanel.add(new PaddedPanel(new Panel("Item 2", 100, 100), 0, 0, 10, 10));
            wrapperPanel.add(new PaddedPanel(new Panel("Item 3", 100, 100), 0, 0, 10, 10));

            wrapperPanel.add(new PaddedPanel(new Panel("Item 4", 210, 100), 0, 0, 10, 10), new TableLayoutData(2));
            wrapperPanel.add(new PaddedPanel(new Panel("Item 5", 100, 100), 0, 0, 10, 10));
            wrapperPanel.add(new PaddedPanel(new Panel("Item 6", 100, 100), 0, 0, 10, 10));
            wrapperPanel.add(new PaddedPanel(new Panel("Item 7", 210, 100), 0, 0, 10, 10), new TableLayoutData(2));
            wrapperPanel.add(new PaddedPanel(new Panel("Item 8", 100, 100), 0, 0, 10, 10));

            panel.add(wrapperPanel);
        }
        return panel;
    }

    public String getIntro() {
        return "<p>This example demonstrates a TableLayout. You specify the number of columns in the TableLayout and add" +
                " child panels to the parent panel which has been assigned the TableLayout. The panels will get laid out accoridn to the table specification.</p>" +
                "<p> You can control the rowspan and colspan of panels as illustrated in this example where the Panel in the second row" +
                " has a colspan of 2.</p>";
    }
}