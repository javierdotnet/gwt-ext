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