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
import com.gwtext.client.dd.DDProxy;
import com.gwtext.client.dd.DragDropProxyConfig;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class DDProxyPanel extends ShowcaseExampleVSD {

    private static String DEMO_HTML = "<div id=\"dd-demo-1\" class=\"dd-demo\"></div>\n" +
            "<div id=\"dd-demo-2\" class=\"dd-demo\"></div>\n" +
            "<div id=\"dd-demo-3\" class=\"dd-demo\"></div>\n" +
            "\n" +
            "<div id=\"dd-demo-3-proxy\">Custom</div>";

    public String getSourceUrl() {
        return null;
    }

    public Panel getViewPanel() {

        Panel panel = createPanel();
        panel.add(new HTML("<h1>Drag and Drop using a Proxy Element</h1>"));
        panel.add(new HTML("<p>This example demonstrates drag and drop using a proxy element.</p>"));
        panel.add(new HTML(DEMO_HTML));

        DeferredCommand.addCommand(new Command() {
            public void execute() {
                DDProxy dd = new DDProxy("dd-demo-1");
                DDProxy dd2 = new DDProxy("dd-demo-2");

                // The third instance has a dedicated custom proxy
                DDProxy dd3 = new DDProxy("dd-demo-3", "default", new DragDropProxyConfig() {
                    {
                        setDragElId("dd-demo-3-proxy");
                        setResizeFrame(false);
                    }
                });
            }
        });
        return panel;
    }
}