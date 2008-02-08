/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.layout;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.CardLayout;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class CardLayoutSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/layout/CardLayoutSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            final Panel wizardPanel = new Panel();
            wizardPanel.setHeight(250);
            wizardPanel.setWidth(350);
            wizardPanel.setTitle("Example Wizard");
            wizardPanel.setLayout(new CardLayout());
            wizardPanel.setActiveItem(0);
            wizardPanel.setPaddings(15);

            ButtonListenerAdapter listener = new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    String btnID = button.getId();
                    CardLayout cardLayout = (CardLayout)wizardPanel.getLayout();
                    String panelID = cardLayout.getActiveItem().getId();

                    if (btnID.equals("move-prev")) {
                        if (panelID.equals("card-3")) {
                            cardLayout.setActiveItem(1);
                        } else {
                            cardLayout.setActiveItem(0);
                        }
                    } else {

                        if (panelID.equals("card-1")) {
                            cardLayout.setActiveItem(1);
                        } else {
                            cardLayout.setActiveItem(2);
                        }
                    }
                }
            };

            Toolbar toolbar = new Toolbar();

            ToolbarButton backButton = new ToolbarButton("Back", listener);
            backButton.setId("move-prev");
            toolbar.addButton(backButton);
            toolbar.addFill();

            ToolbarButton nextButton = new ToolbarButton("Next", listener);
            nextButton.setId("move-next");
            toolbar.addButton(nextButton);

            wizardPanel.setBottomToolbar(toolbar);

            Panel first = new Panel();
            first.setBorder(false);
            first.setId("card-1");
            first.setHtml("<h1>Welcome to the Wizard!</h1><p>Step 1 of 3</p>");

            Panel second = new Panel();
            second.setBorder(false);
            second.setId("card-2");
            second.setHtml("<p>Step 2 of 3</p>");

            Panel third = new Panel();
            third.setBorder(false);
            third.setId("card-3");
            third.setHtml("<h1>Congratulations!</h1><p>Step 3 of 3 - Complete</p>");

            wizardPanel.add(first);
            wizardPanel.add(second);
            wizardPanel.add(third);

            panel.add(wizardPanel);
        }
        return panel;
    }

    public String getIntro() {
        return "<p>Card layout contains multiple panels, each fit to the container, where only a single panel can be visible at any given time.</p>" +
                "<p>This layout style is most commonly used for wizards as illustrated by this example.</p>";
    }
}
