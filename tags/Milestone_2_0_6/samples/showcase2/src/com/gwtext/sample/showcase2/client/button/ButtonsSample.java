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
 
package com.gwtext.sample.showcase2.client.button;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

/**
 * Example that illustrates simple buttons.
 */
public class ButtonsSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/button/ButtonsSample.java.html";
    }

    public String getCssUrl() {
        return "source/button/ButtonsSample.css.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            //create a listener for adding an icon to the Button if not present
            ButtonListenerAdapter listener = new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    button.setIconCls("c-icon");
                    button.setText("Icon Button");
                    log(EVENT, button.getText() + " clicked");
                }
            };
            Button button = new Button("Set Icon", listener);

            //icon button
            Button iconButton = new Button("Search", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    log(EVENT, button.getText() + " clicked");
                }
            });
            iconButton.setIconCls("search-icon");

            //disabled button
            Button disabled = new Button("Disabled");
            disabled.setDisabled(true);

            Panel buttonPanel = new Panel();

            //layout buttons horizontally with 10 pixels between them
            buttonPanel.setLayout(new HorizontalLayout(10));
            buttonPanel.add(button);
            buttonPanel.add(iconButton);
            buttonPanel.add(disabled);

            panel.add(buttonPanel);
        }
        return panel;
    }

    protected boolean showEvents() {
        return true;
    }

    public String getIntro() {
        return "<p>This is a simple example illustrating basic Button styles. Notice that when you click the 'Set Icon' button," +
                " the button icon gets added dynamically.</p>";
    }
}