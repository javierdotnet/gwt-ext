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

import com.gwtext.client.core.Connection;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.*;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class XmlFormSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/form/XmlFormSample.java.html";
    }

    public String getXmlDataUrl() {
        return "source/form/XmlFormSample.xml.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            //setup form data reader
            RecordDef recordDef = new RecordDef(new FieldDef[]{
                    new StringFieldDef("first", "name/first"),
                    new StringFieldDef("last", "name/last"),
                    new StringFieldDef("company"),
                    new StringFieldDef("email"),
                    new StringFieldDef("state"),
                    new DateFieldDef("dob", "dob", "m/d/Y")});

            final XmlReader reader = new XmlReader("contact", recordDef);
            reader.setSuccess("@success");

            //setup error reader to process from submit response from server
            RecordDef errorRecordDef = new RecordDef(new FieldDef[]{
                    new StringFieldDef("id"),
                    new StringFieldDef("msg")
            });

            XmlReader errorReader = new XmlReader("field", errorRecordDef);
            errorReader.setSuccess("@success");

            final FormPanel formPanel = new FormPanel(Position.RIGHT);
            formPanel.setFrame(true);
            formPanel.setTitle("XML Form");
            formPanel.setWidth(400);
            formPanel.setLabelWidth(75);
            //set reader and error reader
            formPanel.setReader(reader);
            formPanel.setErrorReader(errorReader);

            //add some fields
            FieldSet fieldSet = new FieldSet("Contact Information");
            fieldSet.add(new TextField("First Name", "first", 190));
            fieldSet.add(new TextField("Last Name", "last", 190));
            fieldSet.add(new TextField("Company", "company", 190));

            TextField email = new TextField("Email", "email", 190);
            email.setVtype(VType.EMAIL);
            fieldSet.add(email);

            //add a ComboBox field
            Store store = new SimpleStore(new String[]{"abbr", "state"}, SampleData.getStates());
            store.load();

            ComboBox cb = new ComboBox();
            cb.setFieldLabel("State");
            cb.setHiddenName("state");
            cb.setStore(store);
            cb.setDisplayField("abbr");
            cb.setTypeAhead(true);
            cb.setMode(ComboBox.LOCAL);
            cb.setTriggerAction(ComboBox.ALL);
            cb.setEmptyText("Select a state...");
            cb.setSelectOnFocus(true);
            cb.setWidth(190);
            fieldSet.add(cb);

            DateField dob = new DateField("Date of birth", "dob", 190);
            dob.setAllowBlank(false);
            fieldSet.add(dob);

            formPanel.add(fieldSet);

            final Button submitBtn = new Button("Submit", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    formPanel.getForm().submit("data/xml-errors.xml", null, Connection.GET, "Saving Data...", false);
                }
            });

            Button loadBtn = new Button("Load", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    formPanel.getForm().load("data/xml-form.xml", null, Connection.GET, "Loading...");
                    submitBtn.enable();
                }
            });

            formPanel.addButton(loadBtn);
            formPanel.addButton(submitBtn);
            panel.add(formPanel);
        }

        return panel;
    }

    public String getIntro() {
        return "<b>Loading/Saving a Form using XML</b>" +
                "<p>" +
                "    This is a very simple example of using XML to load and submit Form data." +
                "</p>" +
                "<p>" +
                "    Click \"Load\" to load the dummy XML data from the server using an XmlReader." +
                "</p>" +
                "<p>" +
                "    After loading the form, you will be able to hit submit. The submit action will make a post to the server," +
                "    and the dummy XML file on the server with test server-side validation failure messages will be sent back." +
                "    Those messages will be applied to the appropriate fields in the form." +
                "" +
                "</p>" +
                "<p>" +
                "    Note: The built-in JSON support does not require any special readers for mapping. However, If you don't like the Form's built-in JSON format, you could also use a JsonReader for reading data into a form." +
                "</p>";
    }
}