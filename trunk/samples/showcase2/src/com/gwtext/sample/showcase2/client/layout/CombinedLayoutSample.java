/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.layout;

import com.gwtext.client.core.Margins;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.PaddedPanel;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.*;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class CombinedLayoutSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/layout/CombinedLayoutSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            panel.setLayout(new FitLayout());

            Panel borderPanel = new Panel();
            borderPanel.setTitle("Use of BorderLayout, AccordionLayout and ColumnLayout");
            borderPanel.setLayout(new BorderLayout());

            final AccordionLayout accordion = new AccordionLayout();
            accordion.setAnimate(true);

            Panel westPanel = new Panel();
            westPanel.setTitle("West");
            westPanel.setCollapsible(true);
            westPanel.setWidth(200);
            westPanel.setLayout(accordion);

            Panel navigationPanel = new Panel();
            navigationPanel.setHtml(SampleData.getShortBogusMarkup());
            navigationPanel.setTitle("Navigation");
            navigationPanel.setAutoScroll(true);
            navigationPanel.setBorder(false);
            navigationPanel.setIconCls("folder-icon");
            westPanel.add(navigationPanel);

            Panel settingsPanel = new Panel();
            settingsPanel.setHtml(SampleData.getShortBogusMarkup());
            settingsPanel.setTitle("Settings");
            settingsPanel.setAutoScroll(true);
            settingsPanel.setBorder(false);
            settingsPanel.setIconCls("settings-icon");
            westPanel.add(settingsPanel);

            BorderLayoutData westData = new BorderLayoutData(RegionPosition.WEST);
            westData.setSplit(true);
            westData.setMinSize(175);
            westData.setMaxSize(400);
            westData.setMargins(new Margins(35, 5, 0, 5));
            westData.setCMargins(new Margins(35, 5, 5, 5));
            borderPanel.add(westPanel, westData);


            Panel centerPanel = new Panel();
            centerPanel.setAutoScroll(true);
            centerPanel.setLayout(new ColumnLayout());

            Panel firstPanel = new PaddedPanel(new Panel("A Panel", SampleData.getShortBogusMarkup()), 5, 5, 0, 5);
            Panel secondPanel = new PaddedPanel(new Panel("A Panel", SampleData.getShortBogusMarkup()), 5, 5, 0 ,5 );
            Panel thirdPanel = new PaddedPanel(new Panel("A Panel", SampleData.getShortBogusMarkup()), 5, 5, 0, 5);
            thirdPanel.add(new PaddedPanel(new Panel("Another Panel", SampleData.getShortBogusMarkup()), 5, 0, 0, 5));

            centerPanel.add(firstPanel, new ColumnLayoutData(0.33));
            centerPanel.add(secondPanel, new ColumnLayoutData(0.33));
            centerPanel.add(thirdPanel, new ColumnLayoutData(0.333));

            BorderLayoutData centerData = new BorderLayoutData(RegionPosition.CENTER);
            centerData.setMargins(35, 0, 5, 5);
            borderPanel.add(centerPanel, centerData);
            panel.add(borderPanel);

        }
        return panel;
    }
}