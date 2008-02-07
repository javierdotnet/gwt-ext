/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.tabs;

import com.google.gwt.user.client.ui.Frame;
import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.menu.Menu;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class BottomTabPanelSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/tabs/BottomTabPanelSample.java.html";
    }

    public String getCssUrl() {
        return "source/tabs/BottomTabPanelSample.css.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            panel.setLayout(new FitLayout());

            TabPanel tabPanel = new TabPanel();
            tabPanel.setTabPosition(Position.BOTTOM);
            tabPanel.setResizeTabs(true);
            tabPanel.setMinTabWidth(115);
            tabPanel.setTabWidth(135);
            tabPanel.setActiveTab(0);

            Frame google = new Frame("http://www.google.com");

            Panel googlePanel = new Panel("Google");
            googlePanel.setLayout(new FitLayout());
            googlePanel.setIconCls("tab-icon");
            googlePanel.add(google);

            Panel staticPanel = new Panel();
            staticPanel.setTitle("News");
            staticPanel.setAutoScroll(true);
            staticPanel.setHtml(SampleData.getBogusMarkup());

            tabPanel.add(googlePanel);
            tabPanel.add(staticPanel);

            panel.add(tabPanel);
        }
        return panel;
    }

    public String getIntro() {
        return "<p>This TabPanel demonstrates:</p>" +
                "    <p>" +
                "        - Bottom tab position<br>" +
                "        - Adding an IFrame to a Tab<br>" +
                "    </p>";
    }
}