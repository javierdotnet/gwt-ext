/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.button;

import com.gwtext.client.widgets.CycleButton;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.CycleButtonListenerAdapter;
import com.gwtext.client.widgets.menu.CheckItem;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

/**
 * Cycle Button example.
 */
public class CycleButtonSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/button/CycleButtonSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            //create a CycleButton
            CycleButton button = new CycleButton();
            button.setShowText(true);
            button.setPrependText("View as ");

            //add CheckItem's to the CycleButton
            button.addItem(new CheckItem("text only", true));
            button.addItem(new CheckItem("HTML", false));

            //log check item changes
            button.addListener(new CycleButtonListenerAdapter() {
                public void onChange(CycleButton self, CheckItem item) {
                    log(EVENT, item.getText() + " selected.");
                }
            });

            panel.add(button);
        }
        return panel;
    }

    protected boolean showEvents() {
        return true;
    }

    public String getIntro() {
        return "<p>A CycleButton is specialized SplitButton that contains Menu CheckItem elements.</p><p>The button automatically " +
                "cycles through each menu item on click, raising the button's change event for the active menu item. " +
                "Clicking on the arrow section of the button displays the dropdown menu just like a normal SplitButton.</p>";
    }
}