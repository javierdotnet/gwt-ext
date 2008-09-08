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