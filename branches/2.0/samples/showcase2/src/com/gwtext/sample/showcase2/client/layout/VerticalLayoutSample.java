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

public class VerticalLayoutSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/layout/VerticalLayoutSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {

            panel = new Panel();
            panel.setLayout(new VerticalLayout(15));

            panel.add(new Panel("Item 1", 150, 100));
            panel.add(new Panel("Item 2", 350, 75));
            panel.add(new Panel("Item 3", 150, 100));
            panel.add(new Panel("Item 3", 150, 150));
        }
        return panel;
    }

    public String getIntro() {
        return "A simple example of VerticalLayout used to lay out Panels vertically with 15px between them.";
    }
}