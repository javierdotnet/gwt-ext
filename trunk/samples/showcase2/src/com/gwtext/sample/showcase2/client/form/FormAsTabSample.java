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
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.VType;
import com.gwtext.client.widgets.layout.FormLayout;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class FormAsTabSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/form/FormAsTabSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            FormPanel formPanel = new FormPanel();
            formPanel.setFrame(true);
            formPanel.setLabelWidth(75);
            formPanel.setBorder(false);
            formPanel.setWidth(350);

            final TabPanel tabPanel = new TabPanel();
            tabPanel.setActiveTab(0);

            Panel firstTab = new Panel();
            firstTab.setTitle("Personal Details");
            firstTab.setLayout(new FormLayout());
            firstTab.setAutoHeight(true);
            firstTab.setPaddings(10);

            TextField firstName = new TextField("First Name", "first", 230);
            firstName.setAllowBlank(false);
            firstName.setValue("Steve");
            firstTab.add(firstName);

            TextField lastName = new TextField("Last Name", "last", 230);
            lastName.setValue("Rogge");
            firstTab.add(lastName);

            TextField company = new TextField("Company", "company", 230);
            firstTab.add(company);

            TextField email = new TextField("Email", "email", 230);
            email.setVtype(VType.EMAIL);
            firstTab.add(email);

            tabPanel.add(firstTab);

            Panel secondTab = new Panel();
            secondTab.setTitle("Phone Numbers");
            secondTab.setLayout(new FormLayout());
            secondTab.setAutoHeight(true);
            secondTab.setPaddings(10);

            secondTab.add(new TextField("Home", "home", 230, "(888) 555-2222"));
            secondTab.add(new TextField("Business", "business", 230));
            secondTab.add(new TextField("Mobile", "mobile", 230));
            secondTab.add(new TextField("Fax", "fax", 230));

            tabPanel.add(secondTab);

            Button save = new Button("Save");
            Button cancel = new Button("Cancel");

            formPanel.addButton(save);
            formPanel.addButton(cancel);

            formPanel.add(tabPanel);
            panel.add(formPanel);
        }

        return panel;
    }

    public String getIntro() {
        return "<b>Form as a TabPanel</b>" +
                "<p>" +
                "This example shows that a Form can be setup as a TabPanel with form fields on separate tabs." +
                " An key feature of this is that when the form is submitted, the field values form all the tabs are posted." +
                "</p>";
    }
}