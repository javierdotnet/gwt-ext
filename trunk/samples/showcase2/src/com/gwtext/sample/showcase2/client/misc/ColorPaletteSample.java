/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.misc;

import com.gwtext.client.widgets.ColorPalette;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ColorPaletteListenerAdapter;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.sample.showcase2.client.ShowcasePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ColorPaletteSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/misc/ColorPaletteSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            
            VerticalPanel verticalPanel = new VerticalPanel();
            verticalPanel.setSpacing(15);

            final TextField textField = new TextField("Color");
            textField.setWidth(146);

            ColorPalette colorPalette = new ColorPalette();
            colorPalette.addListener(new ColorPaletteListenerAdapter() {
                public void onSelect(ColorPalette colorPalette, String color) {
                    textField.setStyle("background-color:" + color + ";background-image:none;");
                    textField.setValue(color);
                }
            });

            colorPalette.setTitle("Pick a color");
            verticalPanel.add(colorPalette);
            verticalPanel.add(textField);

            panel.add(verticalPanel);
        }
        return panel;
    }

    public String getIntro() {
        return "A customizable ColorPalette that allows you to define the set of colors displayed. You can also attach listeners to determine the color selected by the user.";
    }
}