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
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.event.KeyListener;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.ContentPanel;
import com.gwtext.client.widgets.layout.LayoutRegionConfig;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class KeyListenerDialogPanel extends ShowcaseExampleVSD {

    public String getSourceUrl() {
        return "dialog/KeyListenerDialogPanel.java.html";
    }

    public Panel getViewPanel() {

        //create and configure dialog
        final LayoutDialog dialog = new LayoutDialog(new LayoutDialogConfig() {
            {
                setModal(true);
                setWidth(500);
                setHeight(300);
                setShadow(true);
                setMinHeight(300);
                setMinHeight(300);
                setTitle("Dialog with Key Listeners");
            }
        }, new LayoutRegionConfig());

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

        //keycode 13 = Enter, 67 = c
        dialog.addKeyListener(new int[]{13, 67}, new KeyListener() {
            public void onKey(int key, EventObject e) {
                MessageBox.alert("Key Listener", "Key with keyCode " + key + " pressed.");
                //stop event userful to prevent bubbling of enter key
                e.stopEvent();
            }
        });

        //add content to the center region
        final BorderLayout layout = dialog.getLayout();
        ContentPanel contentPanel = new ContentPanel();
        contentPanel.add(new HTML("<h3>This Dialog has Key Listeners for the 'Enter' key and for the key 'c'. " +
                                    "Try pressing either key to invoke the key listener</h3>"));
        layout.add(LayoutRegionConfig.CENTER, contentPanel);

        Button button = new Button("Show Dialog");
        button.addButtonListener(new ButtonListenerAdapter() {
            public void onClick(Button button, EventObject e) {
                dialog.show(button.getEl());
            }
        });

        VerticalPanel vp = createPanel();
        vp.add(new HTML("<h1>Key Listener Dialog</h1>"));
        vp.add(new HTML("<p>This example shows how to create dialog with key listeners</p>"));
        vp.add(button);

        return vp;
    }
}