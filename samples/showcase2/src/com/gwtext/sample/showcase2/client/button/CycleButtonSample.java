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