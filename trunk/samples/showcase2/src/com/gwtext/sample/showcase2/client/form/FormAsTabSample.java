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