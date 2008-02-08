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

public class ColumnPctSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/layout/ColumnPctSample.java.html";
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
            wrapperPanel.setTitle("Column Layout - Percentage Only");
            wrapperPanel.add(new Panel("Column 1", "25% width"), new ColumnLayoutData(.25));
            wrapperPanel.add(new Panel("Column 2", "60% width"), new ColumnLayoutData(.6));
            wrapperPanel.add(new Panel("Column 3", "15% width"), new ColumnLayoutData(.15));

            panel.add(wrapperPanel);

        }
        return panel;
    }

    public String getIntro() {
        return "This example illustrates a ColumnLayout where all the Panel's have thier width's specified as percentages";
    }
}