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

package com.gwtext.sample.showcase.client.dialog;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.ButtonConfig;
import com.gwtext.client.widgets.LayoutDialog;
import com.gwtext.client.widgets.LayoutDialogConfig;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.ContentPanel;
import com.gwtext.client.widgets.layout.LayoutRegionConfig;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class BasicDialogPanel extends ShowcaseExampleVSD {

    public String getSourceUrl() {
        return "dialog/BasicDialogPanel.java.html";
    }

    public Panel getViewPanel() {

        //create and configure layout dialog
        final LayoutDialog dialog = new LayoutDialog(new LayoutDialogConfig() {
            {
                setTitle("Basic Dialog");
                setModal(true);
                setWidth(500);
                setHeight(300);
                setShadow(true);
                setMinHeight(300);
                setMinHeight(300);
            }
        }, new LayoutRegionConfig());

        //first way to add button
        Button saveBtn = dialog.addButton("Submit");
        saveBtn.disable();

        //another way to add button
        dialog.addButton(new Button("Cancel", new ButtonConfig() {
            {
                setText("Cancel");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        dialog.hide();
                    }
                });
            }
        }));

        //add content to the center region
        BorderLayout layout = dialog.getLayout();
        ContentPanel contentPanel = new ContentPanel();
        contentPanel.add(new HTML("<h1>Hello World!!</h1>"));
        layout.add(contentPanel);

        Button button = new Button("Hello World");
        button.addButtonListener(new ButtonListenerAdapter() {
            public void onClick(Button button, EventObject e) {
                dialog.show(button.getEl());
            }
        });

        Panel panel = createPanel();
        panel.add(new HTML("<h1>Basic Dialog</h1>"));
        panel.add(new HTML("<p>This example shows how to create a simple dialog</p>"));
        panel.add(button);
        return panel;
    }
}