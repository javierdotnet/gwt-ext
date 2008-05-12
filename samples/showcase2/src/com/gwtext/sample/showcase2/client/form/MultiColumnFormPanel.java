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
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.HtmlEditor;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.VType;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FormLayout;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class MultiColumnFormPanel extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/form/MultiColumnFormPanel.java.html";
    }

    public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();

            //create the FormPanel and set the label position to top
            FormPanel formPanel = new FormPanel();
			formPanel.setFrame(true);
			formPanel.setTitle("Multi Column, Nested Layouts and Anchoring");
			formPanel.setPaddings(5, 5, 5, 0);
			formPanel.setWidth(600);
			formPanel.setLabelAlign(Position.TOP);

            //create a top panel with 2 columns (ColumnLayout). Create a Panel for the first column with
            //layout FormLayout and add the fields for the first column. Then create a second Panel with FormLayout
            //and add fields to the sencond panel. Finally add the first and secod pane to the top panel which lays
            //them out in columns since it has a ColumnLayout assigned to it.

            //create top panel with ColumnLayout
            Panel topPanel = new Panel();
			topPanel.setLayout(new ColumnLayout());

            //create first panel and add fields to it
            Panel columnOnePanel = new Panel();
			columnOnePanel.setLayout(new FormLayout());

			TextField firstName = new TextField("First Name", "first");
			columnOnePanel.add(firstName, new AnchorLayoutData("95%"));

			TextField company = new TextField("Company", "company");
			columnOnePanel.add(company, new AnchorLayoutData("95%"));

            //add first panel as first column with 50% of the width
            topPanel.add(columnOnePanel, new ColumnLayoutData(.5));

            //create second panel and add fields to it
            Panel columnTwoPanel = new Panel();
			columnTwoPanel.setLayout(new FormLayout());

			TextField lastName = new TextField("Last Name", "last");
			columnTwoPanel.add(lastName, new AnchorLayoutData("95%"));

			TextField email = new TextField("Email", "email");
			email.setVtype(VType.EMAIL);
			columnTwoPanel.add(email, new AnchorLayoutData("95%"));

            //add the second panel as the second column to the top panel to take up the other 50% width
            topPanel.add(columnTwoPanel, new ColumnLayoutData(0.5));
			formPanel.add(topPanel);

            //add a HtmlEditor below the 2-column top panel
            HtmlEditor htmlEditor = new HtmlEditor("Biography", "bio");
			htmlEditor.setHeight(200);
			formPanel.add(htmlEditor, new AnchorLayoutData("98%"));

            //add a couple of buttons to the form
            formPanel.addButton(new Button("Save"));
			formPanel.addButton(new Button("Cancel"));

			panel.add(formPanel);
		}
		return panel;
	}

    public String getIntro() {
        return "<p>This example illustrates a multi-column form with lables on top. The form has a top panel which has two columns. " +
                "The first column is a Panel with the 'First Name' and 'Company' fields added to it. And the second column " +
                "is a Panel with the 'Last Name' and 'Email' fields added to it.<p>" +
                "The top panel is added to the form and then a HtmlEditor with no label is added below it.</p>";
    }
}