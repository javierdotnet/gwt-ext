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

import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.HtmlEditor;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.*;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class FormWithTabSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/form/FormWithTabSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            FormPanel formPanel = new FormPanel();
            formPanel.setLabelAlign(Position.TOP);
            formPanel.setTitle("Inner Tabs");
            formPanel.setPaddings(5);
            formPanel.setWidth(600);

            Panel topPanel = new Panel();
            topPanel.setLayout(new ColumnLayout());
            topPanel.setBorder(false);

            Panel firstColumn = new Panel();
            firstColumn.setLayout(new FormLayout());
            firstColumn.setBorder(false);

            firstColumn.add(new TextField("First Name", "first"), new AnchorLayoutData("95%"));
            firstColumn.add(new TextField("Company", "company"), new AnchorLayoutData("95%"));
            topPanel.add(firstColumn, new ColumnLayoutData(0.5));

            Panel secondColumn = new Panel();
            secondColumn.setLayout(new FormLayout());
            secondColumn.setBorder(false);

            secondColumn.add(new TextField("Last Name", "last"), new AnchorLayoutData("95%"));
            secondColumn.add(new TextField("Email", "email"), new AnchorLayoutData("95%"));
            topPanel.add(secondColumn, new ColumnLayoutData(0.5));

            formPanel.add(topPanel);

            TabPanel tabPanel = new TabPanel();
            tabPanel.setPlain(true);
            tabPanel.setActiveTab(0);
            tabPanel.setHeight(235);

            Panel firstTab = new Panel();
            firstTab.setTitle("Personal Details");
            firstTab.setLayout(new FormLayout());
            firstTab.setPaddings(10);

            firstTab.add(new TextField("First Name", "first", 230, "James"));
            firstTab.add(new TextField("Last  Name", "last", 230));
            firstTab.add(new TextField("Company", "company", 230));
            firstTab.add(new TextField("Email", "email", 230));
            tabPanel.add(firstTab);

            Panel secondTab = new Panel();
            secondTab.setTitle("Phone Numbers");
            secondTab.setLayout(new FormLayout());
            secondTab.setPaddings(10);

            secondTab.add(new TextField("Home", "home", 230, "(888) 555-2222"));
            secondTab.add(new TextField("Business", "business", 230));
            secondTab.add(new TextField("Mobile", "mobile", 230));
            secondTab.add(new TextField("Fax", "fax", 230));
            tabPanel.add(secondTab);

            Panel thirdPanel = new Panel();
            thirdPanel.setTitle("Biography");
            thirdPanel.setLayout(new FitLayout());
            thirdPanel.add(new HtmlEditor("Biography"));
            tabPanel.add(thirdPanel);

            formPanel.add(tabPanel);
            formPanel.addButton(new Button("Save"));
            formPanel.addButton(new Button("Cancel"));

            panel.add(formPanel);
        }

        return panel;
    }

    public String getIntro() {
        return "This is an example of a Form that containts a TabPanel and each tab can have Form fields.";
    }
}