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