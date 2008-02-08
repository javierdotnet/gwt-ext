/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.misc;

import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.Checkbox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.event.CheckboxListenerAdapter;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class MaskingSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/misc/MaskingSample.java.html";
    }
    
    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            FormPanel formPanel = new FormPanel();
            formPanel.setTitle("Mask Region");
            formPanel.setBorder(false);
            formPanel.setFrame(true);
            formPanel.setWidth(400);
            formPanel.setLabelWidth(100);

            final TextField maskField = new TextField("Mask Message", "maskMessage", 175);
            maskField.setSelectOnFocus(true);
            formPanel.add(maskField);

            Checkbox maskNav = new Checkbox();
            maskNav.setBoxLabel("Mask Side Nav");
            maskNav.addListener(new CheckboxListenerAdapter() {
                public void onCheck(Checkbox field, boolean checked) {
                    String message = maskField.getText();
                    final ExtElement element = Ext.get("side-nav");
                    if (checked) {
                        if (message.trim().equals("")) {
                            element.mask();
                        } else {
                            element.mask(message);
                        }
                    } else {
                        element.unmask();
                    }
                }
            });
            formPanel.add(maskNav);

            panel.add(formPanel);
        }
        return panel;
    }

    public String getIntro() {
        return "<p>This example demonstrates masking elements. Masking containers is an effective way of disabling the control and its children.</p>" +
                "<p>Any element can be masked like TreePanel, Grids etc</p>";
    }
}