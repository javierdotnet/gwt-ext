/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
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