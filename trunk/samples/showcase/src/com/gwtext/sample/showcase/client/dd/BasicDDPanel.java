/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package com.gwtext.sample.showcase.client.dd;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.gwtext.client.dd.DD;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class BasicDDPanel extends ShowcaseExampleVSD {

    private static String DEMO_HTML = "<div id=\"dd-demo-1a\" class=\"dd-demo\"></div>\n" +
            "<div id=\"dd-demo-2a\" class=\"dd-demo\"></div>\n" +
            "<div id=\"dd-demo-3a\" class=\"dd-demo\"></div>";
    
    public String getSourceUrl() {
        return "dd/BasicDDPanel.java.html";
    }

    public Panel getViewPanel() {

        Panel panel = createPanel();
        panel.add(new HTML("<h1>Basic Drag and Drop</h1>"));
        panel.add(new HTML("<p>This example demonstrates basic features of the Drag & Drop </p>"));
        panel.add(new HTML(DEMO_HTML));

        DeferredCommand.addCommand(new Command() {
            public void execute() {
                DD dd1 = new DD("dd-demo-1a");
	            DD dd2 = new DD("dd-demo-2a");
	            DD dd3 = new DD("dd-demo-3a");
            }
        });
        return panel;
    }
}