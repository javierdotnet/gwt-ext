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