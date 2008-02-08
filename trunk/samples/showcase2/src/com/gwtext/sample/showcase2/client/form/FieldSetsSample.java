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
import com.gwtext.client.widgets.form.FieldSet;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.VType;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class FieldSetsSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/form/FieldSetsSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            //create the form
            FormPanel formPanel = new FormPanel();
            formPanel.setTitle("Simple Form with FieldSets");
            formPanel.setFrame(true);
            formPanel.setPaddings(5, 5, 5, 0);
            formPanel.setWidth(350);
            formPanel.setLabelWidth(75);
            formPanel.setUrl("save-form.php");

            //create first collapsible fieldset with checkbox
            FieldSet userFS = new FieldSet();
            userFS.setCheckboxToggle(true);
            userFS.setFrame(true);
            userFS.setTitle("User Information");
            userFS.setCollapsed(true);

            //add fields to the User FieldSet
            TextField first = new TextField("First Name", "first", 210);
            first.setAllowBlank(false);
            userFS.add(first);

            TextField last = new TextField("Last Name", "last", 210);
            userFS.add(last);

            TextField company = new TextField("Company", "company, 210");
            userFS.add(company);

            TextField email = new TextField("Email", "email", 210);
            email.setVtype(VType.EMAIL);
            userFS.add(email);

            //create another FieldSet
            FieldSet detailsFS = new FieldSet("Phone Number");
            detailsFS.setCollapsible(true);
            detailsFS.setAutoHeight(true);

            //add fields to Details FieldSet
            TextField home = new TextField("Home", "home", 210);
            home.setValue("(888) 555-1212");
            detailsFS.add(home);

            TextField business = new TextField("Business", "business", 210);
            detailsFS.add(business);

            TextField mobile = new TextField("Mobile", "mobile", 210);
            detailsFS.add(mobile);

            TextField fax = new TextField("Fax", "fax", 210);
            detailsFS.add(fax);

            formPanel.add(userFS);
            formPanel.add(detailsFS);

            formPanel.addButton(new Button("Save"));
            formPanel.addButton(new Button("Cancel"));

            panel.add(formPanel);
        }
        return panel;
    }

    public String getIntro() {
        return "<p>This example demonstrates the use of FieldSet's in Forms. FieldSets are a subclass of Panel and can be " +
                "added to the FormPaenl just like other Components. FieldSet's in turn can contain Form fields.</p>" +
                "<p>The FieldSet at the top is collapsible and has a toggle checkbox to expand / collapse the FieldSet.</p>" +
                "<p>The FieldSet at the bottom contains other form Fields</p>";
    }
}