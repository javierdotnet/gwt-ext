/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.ColorPalette;
import com.gwtext.client.widgets.event.ColorPaletteListenerAdapter;
import com.gwtext.client.widgets.form.TriggerField;

public class LookupField extends TriggerField {

    private ColorPalette colorPalette;

    public LookupField() {
    }


    public LookupField(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected void onTriggerClick(EventObject event) {
        if (colorPalette == null) {
            colorPalette = new ColorPalette();
            colorPalette.addListener(new ColorPaletteListenerAdapter() {
                public void onSelect(ColorPalette colorPalette, String color) {
                    LookupField.this.setStyle("background-color:" + color + ";background-image:none;");
                    colorPalette.hide();
                }
            });
            colorPalette.render(RootPanel.getBodyElement());
        }
        colorPalette.getEl().setXY(event.getXY()[0], event.getXY()[1], false);
        colorPalette.show();
    }

}
