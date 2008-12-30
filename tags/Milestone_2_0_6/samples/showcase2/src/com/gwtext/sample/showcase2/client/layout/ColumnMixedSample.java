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

import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.sample.showcase2.client.ShowcasePanel;
import com.gwtext.sample.showcase2.client.SampleData;

public class ColumnMixedSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/layout/ColumnMixedSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {

            panel = new Panel();
            panel.setLayout(new FitLayout());

            //add wrapper panel just to dispaly the borders
            Panel wrapperPanel = new Panel();
            wrapperPanel.setBorder(true);
            wrapperPanel.setBodyStyle("border-style:dotted;border-color:blue;");
            wrapperPanel.setLayout(new ColumnLayout());

            wrapperPanel.setTitle("Column Layout - Mixed");
            Panel p1 = new Panel("Column 1", "120px width");
            p1.setWidth(120);
            wrapperPanel.add(p1);

            wrapperPanel.add(new Panel("Column 2", "80% width"), new ColumnLayoutData(.8));
            wrapperPanel.add(new Panel("Column 3", "20% width"), new ColumnLayoutData(.2));

            panel.add(wrapperPanel);
        }
        return panel;
    }

    public String getIntro() {
        return "<p>This exampel show the use of ColumnLayout where the first panel has a fixed width while the other two have thier " +
                "widths specified in percentage values</p>";
    }
}