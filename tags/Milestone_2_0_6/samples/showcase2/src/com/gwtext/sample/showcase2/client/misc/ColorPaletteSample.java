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