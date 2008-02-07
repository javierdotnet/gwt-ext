/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.dd;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.gwtext.client.dd.DD;
import com.gwtext.client.dd.DDProxy;
import com.gwtext.client.widgets.Panel;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

/**
 * Example that illustrates basic Drag Drop functionality.
 */
public class BasicDDSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/dd/BasicDDSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            HorizontalPanel horizontalPanel = new HorizontalPanel();
            horizontalPanel.setSpacing(15);

            Panel draggable = new Panel();
            draggable.setTitle("Draggable");
            draggable.setBorder(true);
            draggable.setWidth(200);
            draggable.setCollapsible(true);
            draggable.setHtml(SampleData.getShortBogusMarkup());

            Panel proxy = new Panel();
            proxy.setTitle("Draggable with Proxy");
            proxy.setBorder(true);
            proxy.setWidth(200);
            proxy.setCollapsible(true);
            proxy.setHtml(SampleData.getShortBogusMarkup());

            DD dd = new DD(draggable);
            DD ddProxy = new DDProxy(proxy);

            horizontalPanel.add(draggable);
            horizontalPanel.add(proxy);

            panel.add(horizontalPanel);
        }

        return panel;
    }

    public String getIntro() {
        return "<p>This is a simple example illustrating basic Drag Drop functionality. The second Panel is configred to have a Proxy when dragging.</p>";
    }
}