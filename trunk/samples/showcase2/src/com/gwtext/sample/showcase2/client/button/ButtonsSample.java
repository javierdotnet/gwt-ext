/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
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