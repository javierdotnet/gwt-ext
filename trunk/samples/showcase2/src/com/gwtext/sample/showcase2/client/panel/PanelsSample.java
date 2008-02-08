/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.panel;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Function;
import com.gwtext.client.dd.DD;
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class PanelsSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/panel/PanelsSample.java.html";
    }

    public String getCssUrl() {
        return "source/panel/PanelsSample.css.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            HorizontalPanel horizontalPanel = new HorizontalPanel();
            horizontalPanel.setSpacing(15);

            Panel collapsiblePanel = new Panel();
            collapsiblePanel.setTitle("Collapsible Panel");
            collapsiblePanel.setWidth(200);
            collapsiblePanel.setCollapsible(true);
            collapsiblePanel.setHtml(SampleData.getShortBogusMarkup());

            Panel iconPanel = new Panel();
            iconPanel.setTitle("Icon Panel");
            iconPanel.setIconCls("paste-icon");
            iconPanel.setWidth(200);
            iconPanel.setHtml(SampleData.getShortBogusMarkup());
            iconPanel.setShadow(true);

            HorizontalPanel horizontalPanel2 = new HorizontalPanel();
            horizontalPanel2.setSpacing(15);

            Panel draggablePanel = new Panel();
            draggablePanel.setTitle("Draggable Panel");
            draggablePanel.setDraggable(true);
            draggablePanel.setWidth(200);
            draggablePanel.setHtml(SampleData.getShortBogusMarkup());
            draggablePanel.setShadow(true);
            DD dd = new DD(draggablePanel);

            Panel toolsPanel = new Panel();
            toolsPanel.setTitle("Tools Panel");
            toolsPanel.setIconCls("paste-icon");
            toolsPanel.setWidth(200);
            toolsPanel.setHtml(SampleData.getShortBogusMarkup());
            toolsPanel.setShadow(true);
            toolsPanel.addTool(new Tool(Tool.GEAR, new Function() {
                public void execute() {
                    MessageBox.alert("Settings", "The Settings tool was clicked");
                }
            }, "Settings"));
            toolsPanel.addTool(new Tool(Tool.SEARCH, new Function() {
                public void execute() {
                    MessageBox.alert("Search", "The Search tool was clicked");
                }
            }, "Search"));

            Panel windowPanel = new Panel();
            windowPanel.setHtml(SampleData.getShortBogusMarkup());
            windowPanel.setShadow(true);

            final Window window = new Window();
            window.setTitle("Window Panel");
            window.setIconCls("paste-icon");
            window.setMaximizable(true);
            window.setResizable(true);
            window.setLayout(new FitLayout());
            window.setWidth(200);
            window.setModal(false);

            window.addTool(new Tool(Tool.REFRESH, new Function() {
                public void execute() {
                    MessageBox.alert("Refresh", "The Refresh tool was clicked");
                }
            }, "Refresh"));
            window.addTool(new Tool(Tool.PIN, new Function() {
                public void execute() {
                    MessageBox.alert("Pin", "The Pin tool was clicked");
                }
            }, "Pin"));
            window.add(windowPanel);

            Button button = new Button("Show Window Panel", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    window.show();
                }
            });

            window.setAnimateTarget(button.getId());

            horizontalPanel.add(collapsiblePanel);
            horizontalPanel.add(toolsPanel);
            horizontalPanel2.add(draggablePanel);
            horizontalPanel2.add(button);

            Panel verticalPanel = new Panel();
            verticalPanel.setLayout(new VerticalLayout(15));
            verticalPanel.add(horizontalPanel);
            verticalPanel.add(horizontalPanel2);

            panel.add(verticalPanel);
        }
        return panel;
    }

    public String getIntro() {
        return "A demonstration of basic Panel styles and configurations.";
    }
}