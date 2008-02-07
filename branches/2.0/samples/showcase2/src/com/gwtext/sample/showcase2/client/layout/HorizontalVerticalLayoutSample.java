/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.layout;

import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class HorizontalVerticalLayoutSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/layout/HorizontalVerticalLayoutSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {

            panel = new Panel();

            panel.setLayout(new VerticalLayout(15));
            panel.setBorder(true);

            Panel horizontalPanel = new Panel();
            horizontalPanel.setLayout(new HorizontalLayout(15));

            horizontalPanel.add(new Panel("Item 1a", 100, 150));
            horizontalPanel.add(new Panel("Item 1b", 75, 150));
            horizontalPanel.add(new Panel("Item 1c", 100, 150));

            panel.add(horizontalPanel);
            panel.add(new Panel("Item 2", 250, 75));
            panel.add(new Panel("Item 3", 150, 100));
            panel.add(new Panel("Item 4", 150, 150));

        }
        return panel;
    }

    public String getIntro() {
        return "An example of combining VerticalLayout and HorizontalLayout. The top row is created using a HorizontalLayout and is added" +
                "to a VerticalLayout along with three other panels.";
    }
}