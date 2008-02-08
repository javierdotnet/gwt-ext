/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.layout;

import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.AnchorLayout;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class AnchorSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/layout/AnchorSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {

            panel = new Panel();
            panel.setLayout(new FitLayout());

            //add wrapper panel just to dispaly the borders
            Panel wrapperPanel = new Panel();
            wrapperPanel.setBorder(true);
            wrapperPanel.setBodyStyle("border-style:dotted;border-color:blue;");

            wrapperPanel.setLayout(new AnchorLayout());

            wrapperPanel.add(new Panel("Item 1", "Anchor : '100% 20%'  width is 100% of the containing element and 20% of its height"),
                    new AnchorLayoutData("100% 20%"));
            wrapperPanel.add(new Panel("Item 2", "Anchor : '50% 25%'  width is 50% of the containing element and 25% of its height"),
                    new AnchorLayoutData("50% 25%"));


            wrapperPanel.add(new Panel("Item 3", "Anchor : '-100 30%'  width is (100% of the containing element - 100px) and height is 30% of containing element."),
                    new AnchorLayoutData("-100 30%"));

            panel.add(wrapperPanel);
        }
        return panel;
    }

    public String getIntro() {
        return "This example illustrates the use of AnchorLayout to lay out panels based on anchor values.";
    }
}