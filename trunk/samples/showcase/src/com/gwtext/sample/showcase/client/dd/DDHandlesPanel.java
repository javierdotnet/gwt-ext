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

public class DDHandlesPanel extends ShowcaseExampleVSD {

    private static String DEMO_HTML = "<div id=\"dd-demo-1\" class=\"dd-demo\">\n" +
            "    <div id=\"dd-handle-1a\" class=\"dd-multi-handle-1\">H1</div>\n" +
            "    <div id=\"dd-handle-1b\" class=\"dd-multi-handle-2\">H2</div>\n" +
            "</div>\n" +
            "<div id=\"dd-demo-2\" class=\"dd-demo\">\n" +
            "    <div id=\"dd-handle-2\" class=\"dd-handle\">H</div>\n" +
            "</div>\n" +
            "<div id=\"dd-handle-3b\" class=\"dd-outer-handle\">Outer</div>\n" +
            "<div id=\"dd-demo-3\" class=\"dd-demo\"></div>";

    public String getSourceUrl() {
        return null;
    }

    public Panel getViewPanel() {

        Panel panel = createPanel();
        panel.add(new HTML("<h1>Drag and Drop Handles</h1>"));
        panel.add(new HTML("<p>This example demonstrates how to use drag handles to control the specific places within an element from which a drag can be initiated.</p>"));
        panel.add(new HTML(DEMO_HTML));

        DeferredCommand.addCommand(new Command() {
            public void execute() {
                DD dd = new DD("dd-demo-1");

                // Configure one or more child element as a drag handle
                dd.setHandleElId("dd-handle-1a");
                dd.setHandleElId("dd-handle-1b");

                DD dd2 = new DD("dd-demo-2");
                dd2.setHandleElId("dd-handle-2");

                DD dd3 = new DD("dd-demo-3");
                dd3.setHandleElId("dd-handle-3a");

                // A handle that is not child of the source element
                dd3.setOuterHandleElId("dd-handle-3b");
            }
        });
        return panel;
    }
}