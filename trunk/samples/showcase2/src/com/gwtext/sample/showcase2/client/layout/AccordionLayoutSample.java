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

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.AccordionLayout;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class AccordionLayoutSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/layout/AccordionLayoutSample.java.html";
    }

    public String getCssUrl() {
       return "source/layout/AccordionLayoutSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {

            panel = new Panel();
            panel.setLayout(new HorizontalLayout(15));

            Panel accordionPanel = createAccordionPanel();
            accordionPanel.setTitle("Accordion Panel");
            accordionPanel.setHeight(400);
            accordionPanel.setWidth(200);

            Button button = new Button("Show Accordion in Window", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    Panel accordionPanel = createAccordionPanel();
                    Window window = new Window();
                    window.setTitle("Accordion Window");
                    window.setWidth(200);
                    window.setHeight(400);
                    window.add(accordionPanel);
                    window.show(button.getId());
                }
            });

            panel.add(accordionPanel);
            panel.add(button);

        }
        return panel;
    }

    private Panel createAccordionPanel() {
        Panel accordionPanel = new Panel();
        accordionPanel.setLayout(new AccordionLayout(true));

        Panel panelOne = new Panel("Panel 1", "<p>Panel1 content!</p>");
        panelOne.setIconCls("settings-icon");
        accordionPanel.add(panelOne);

        Panel panelTwo = new Panel("Panel 2", "<p>Panel2 content!</p>");
        panelTwo.setIconCls("folder-icon");
        accordionPanel.add(panelTwo);

        Panel panelThree = new Panel("Panel 3", "<p>Panel3 content!</p>");
        panelThree.setIconCls("user-add-icon");
        accordionPanel.add(panelThree);

        return accordionPanel;
    }

    public String getIntro() {
        return "<p>This example illustrates how the create an Accordion using the AccordionLayout. You simply create a parent panel, " +
                "assign it the AccordionLayout and then add sub-panels to the main panel. Thats it! They layout manager takes care of " +
                "rendering the panels as an Accordion.</p>" +
                "<p>In this example clicking the Botton displays a Window to which an Accodion has been added.</p>";
    }
}