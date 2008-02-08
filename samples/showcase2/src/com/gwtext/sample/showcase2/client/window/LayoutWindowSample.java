/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.window;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class LayoutWindowSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/window/LayoutWindowSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            //center panel
            TabPanel tabPanel = new TabPanel();
            tabPanel.setActiveTab(0);

            Panel tab1 = new Panel();
            tab1.setTitle("Bogus Tab");
            tab1.setHtml(SampleData.getBogusMarkup());
            tab1.setAutoScroll(true);

            Panel tab2 = new Panel();
            tab2.setTitle("Another Tab");
            tab2.setHtml(SampleData.getBogusMarkup());
            tab2.setAutoScroll(true);

            Panel tab3 = new Panel();
            tab3.setTitle("Closable Tab");
            tab3.setHtml(SampleData.getBogusMarkup());
            tab3.setAutoScroll(true);
            tab3.setClosable(true);

            tabPanel.add(tab1);
            tabPanel.add(tab2);
            tabPanel.add(tab3);

            //west panel
            Panel navPanel = new Panel();
            navPanel.setTitle("Navigation");
            navPanel.setWidth(200);
            navPanel.setCollapsible(true);

            BorderLayoutData centerData = new BorderLayoutData(RegionPosition.CENTER);
            centerData.setMargins(3, 0, 3, 3);

            BorderLayoutData westData = new BorderLayoutData(RegionPosition.WEST);
            westData.setSplit(true);
            westData.setMargins(3, 3, 0, 3);
            westData.setCMargins(3, 3, 3, 3);


            final Window window = new Window();
            window.setTitle("Layout Window");
            window.setClosable(true);
            window.setWidth(600);
            window.setHeight(350);
            window.setPlain(true);
            window.setLayout(new BorderLayout());
            window.add(tabPanel, centerData);
            window.add(navPanel, westData);
            window.setCloseAction(Window.HIDE);

            Button button = new Button("Show Window");
            button.addListener(new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    window.show(button.getId());
                }
            });

            panel.add(button);
        }
        return panel;
    }
}