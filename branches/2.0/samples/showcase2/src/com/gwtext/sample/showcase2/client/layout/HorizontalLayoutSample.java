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
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class HorizontalLayoutSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/layout/HorizontalLayoutSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            panel.setLayout(new HorizontalLayout(15));

            panel.add(new Panel("Item 1", 100, 150));
            panel.add(new Panel("Item 2", 75, 150));
            panel.add(new Panel("Item 3", 100, 150));
            panel.add(new Panel("Item 4", 150, 150));
        }
        return panel;
    }

    public String getIntro() {
        return "A simple example of HorizontalLayout used to lay out Panels horizontall 15px between them.";
    }
}