/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.form;

import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.*;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class SimpleFormSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/form/SimpleFormSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            final FormPanel formPanel = new FormPanel();
            formPanel.setFrame(true);
            formPanel.setTitle("Simple Form");

            formPanel.setWidth(350);
            formPanel.setLabelWidth(75);
            formPanel.setUrl("save-form.php");

            Label label = new Label();
            label.setHtml("<p>This is an example of a Form Label. This can have any <b>HTML</b> content.</p>");
            label.setWidth(350);

            formPanel.add(label);

            TextField firstName = new TextField("First Name", "first", 230);
            firstName.setAllowBlank(false);
            formPanel.add(firstName);

            TextField lastName = new TextField("Last Name", "last", 230);
            formPanel.add(lastName);

            final TextField company = new TextField("Company", "company", 230);
            formPanel.add(company);

            TextField email = new TextField("Email", "email", 230);
            email.setVtype(VType.EMAIL);
            formPanel.add(email);

            TimeField time = new TimeField("Time", "time", 230);
            time.setMinValue("8:00am");
            time.setMaxValue("6:00pm");
            formPanel.add(time);

            Button save = new Button("Save");
            formPanel.addButton(save);

            Button cancel = new Button("Cancel");
            formPanel.addButton(cancel);

            panel.add(formPanel);
        }

        return panel;
    }

    public String getIntro() {
        return "<p>This example demonstates a very basic form with minimal validation. 'First Name' field is required in" +
                " this example and the Buttons do not do anything but you can assocate actions with them.</p>";
    }
}