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

public class MultipleDialogPanel extends ShowcaseExampleVSD {

    public String getSourceUrl() {
        return "dialog/MultipleDialogPanel.java.html";
    }

    public Panel getViewPanel() {

        //create and configure layout dialog
        final LayoutDialog dialog = new LayoutDialog(new LayoutDialogConfig() {
            {
                setTitle("First");
                setModal(true);
                setWidth(500);
                setHeight(300);
                setShadow(true);
                setMinHeight(300);
                setMinHeight(300);
            }
        }, new LayoutRegionConfig());


        final LayoutDialog dialog2 = new LayoutDialog(new LayoutDialogConfig() {
            {
                setTitle("Second");
                setModal(true);
                setWidth(300);
                setHeight(200);
                setShadow(true);
            }
        }, new LayoutRegionConfig());

        ContentPanel contentPanel2 = new ContentPanel();
        contentPanel2.setContent("<h3>Second Dialog's content</h3>");
        dialog2.getLayout().add(contentPanel2);

        dialog.addButton(new Button(new ButtonConfig() {
            {
                setText("Show Second Dialog");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        dialog2.show();
                    }
                });
            }
        }));

        BorderLayout layout = dialog.getLayout();
        ContentPanel contentPanel = new ContentPanel();
        contentPanel.add(new HTML("<h1>First Dialog's content</h1>"));
        layout.add(contentPanel);

        Button button = new Button("Show First Dialog");
        button.addButtonListener(new ButtonListenerAdapter() {
            public void onClick(Button button, EventObject e) {
                dialog.show(button.getEl());
            }
        });

        VerticalPanel panel = createPanel();
        panel.add(new HTML("<h1>Multiple Dialogs </h1>"));
        panel.add(new HTML("<p>This example shows how multiple modal dialog's are displayed</p>"));
        panel.add(button);

        return panel;
    }
}