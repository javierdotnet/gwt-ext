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
import com.gwtext.client.core.Ext;
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.ContentPanel;
import com.gwtext.client.widgets.layout.ContentPanelConfig;
import com.gwtext.client.widgets.layout.LayoutRegionConfig;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class LayoutDialogPanel extends ShowcaseExampleVSD {

    public String getSourceUrl() {
        return "dialog/LayoutDialogPanel.java.html";
    }

    public Panel getViewPanel() {

        //create layout regions for layout dialog
        LayoutRegionConfig west = new LayoutRegionConfig() {
            {
                setSplit(true);
                setInitialSize(150);
                setMinSize(100);
                setMaxSize(250);
                setCollapsible(true);
                setAnimate(true);
                setTitlebar(true);
            }
        };

        LayoutRegionConfig center = new LayoutRegionConfig() {
            {
                setAutoScroll(true);
                setTabPosition("top");
                setCloseOnTab(true);
                setAlwaysShowTabs(true);
            }
        };

        final LayoutDialog dialog = new LayoutDialog(new LayoutDialogConfig() {
            {
                setModal(true);
                setWidth(600);
                setHeight(400);
                setShadow(true);
                setMinHeight(300);
                setMinHeight(300);
                setProxyDrag(true);
                setTitle("Hello World");
            }
        }, null, null, west, null, center);

        Button saveBtn = dialog.addButton("Save");
        saveBtn.addButtonListener(new ButtonListenerAdapter() {
            public void onClick(Button button, EventObject e) {
                MessageBox.alert("Save", "Save clicked");
            }
        });

        dialog.addButton(new Button("cancel", new ButtonConfig() {
            {
                setText("Cancel");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        MessageBox.alert("Cancel", "Cancel clicked");
                    }
                });
            }
        }));

        //add content to various regions
        final BorderLayout layout = dialog.getLayout();
        layout.beginUpdate();
        layout.add(LayoutRegionConfig.WEST, new ContentPanel(Ext.generateId(), "West"));

        //adding multiple Content Panels to the same region resutls in tabs
        layout.add(LayoutRegionConfig.CENTER, new ContentPanel(Ext.generateId(), "The First Tab"));
        layout.add(LayoutRegionConfig.CENTER, new ContentPanel(Ext.generateId(), new ContentPanelConfig() {
            {
                setTitle("Another Tab");
                setBackground(true);
            }
        }));
        layout.add(LayoutRegionConfig.CENTER, new ContentPanel(Ext.generateId(), new ContentPanelConfig() {
            {
                setTitle("Third Tab");
                setClosable(true);
                setBackground(true);
            }
        }));
        layout.endUpdate();

        Button button = new Button("Click Me!");
        button.addButtonListener(new ButtonListenerAdapter() {
            public void onClick(Button button, EventObject e) {
                dialog.show(button.getEl());
            }
        });

        VerticalPanel panel = createPanel();
        panel.add(new HTML("<h1>Layout Dialog</h1>"));
        panel.add(new HTML("<p>This example shows how to a dialog with a layout</p>"));
        panel.add(button);

        return panel;
    }
}
