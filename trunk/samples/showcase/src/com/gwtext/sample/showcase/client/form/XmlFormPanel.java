/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package com.gwtext.sample.showcase.client.form;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Template;
import com.gwtext.client.data.*;
import com.gwtext.client.data.Field;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.ButtonConfig;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.*;
import com.gwtext.sample.showcase.client.SampleData;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class XmlFormPanel extends ShowcaseExampleVSD {

    public String getDataUrl() {
        return "data/xml-form.xml.html";
    }

    public String getSourceUrl() {
        return "form/XmlFormPanel.java.html";
    }

    public Panel getViewPanel() {
        final Reader reader = new XmlReader(new XmlReaderConfig() {
            {
                setRecord("contact");
                setSuccess("@success");
            }
        }, new RecordDef(new Field[]{
                new StringField("first", "name/first"),
                new StringField("last", "name/last"),
                new StringField("company"),
                new StringField("email"),
                new StringField("state"),
                new com.gwtext.client.data.DateField("dob", "dob", "m/d/Y")}));

        final XmlReader errorReader = new XmlReader(new XmlReaderConfig() {
            {
                setRecord("field");
                setSuccess("@success");
            }
        }, new RecordDef(new Field[]{
                new StringField("id"),
                new StringField("msg")
        }));

        final Form form = new Form("form-ct11", new FormConfig() {
            {
                setLabelAlign("right");
                setHeader("XML Form");
                setWidth(400);
                setLabelWidth(75);
                setSurrondWithBox(true);
                setReader(reader);
                setErrorReader(errorReader);
            }
        });

        form.fieldset(new FieldSetConfig() {
            {
                setLegend("Contact Information");
            }
        });
        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("First Name");
                setName("first");
                setWidth(190);
            }
        }));
        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Last Name");
                setName("last");
                setWidth(190);
            }
        }));

        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Company");
                setName("company");
                setWidth(190);
            }
        }));
        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Email");
                setName("email");
                setVtype(VType.EMAIL);
                setWidth(190);
            }
        }));

        MemoryProxy proxy = new MemoryProxy(SampleData.getStates());

        Reader cbReader = new ArrayReader(new RecordDef(
                new Field[]{
                        new StringField("abbr", "0"),
                        new StringField("state", "1")
                })
        );

        final Store store = new Store(proxy, cbReader);
        store.load();

        form.add(new ComboBox(new ComboBoxConfig() {
            {
                setFieldLabel("State");
                setHiddenName("state");
                setStore(store);
                setDisplayField("abbr");
                setTpl(new Template("<div class=search-item>" +
                        "<b><span>{abbr}</b> - {state}" +
                        "</div>"));
                setTypeAhead(true);
                setMode("local");
                setTriggerAction("all");
                setEmptyText("Select a state...");
                setSelectOnFocus(true);
                setWidth(190);
            }
        }));

        form.add(new com.gwtext.client.widgets.form.DateField(new DateFieldConfig() {
            {
                setFieldLabel("Date of birth");
                setName("dob");
                setWidth(190);
                setAllowBlank(false);
            }
        }));

        form.end();

        Button loadBtn = new Button("xml-load-btn", new ButtonConfig() {
            {
                setText("Load");
            }
        });
        form.addButton(loadBtn);

        final Button submitBtn = new Button("xml-submit-btn", new ButtonConfig() {
            {
                setText("Submit");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        form.submit(new FormActionConfig() {
                            {
                                setMethod("GET");
                                setUrl("data/xml-errors.xml");
                                setWaitMsg("Saving Data...");
                            }
                        });
                    }
                });
            }
        });

        loadBtn.addButtonListener(new ButtonListenerAdapter() {
            public void onClick(Button button, EventObject e) {
                form.load(new FormActionConfig() {
                    {
                        setMethod("GET");
                        setUrl("data/xml-form.xml");
                        setWaitMsg("Loading");
                        submitBtn.enable();
                    }
                });
            }
        });

        form.addButton(submitBtn);
        form.render();

        Panel panel = createPanel();
        panel.add(new HTML("<div id='wait-div'></div>"));
        panel.add(new HTML(intro));
        panel.add(form);

        return panel;
    }

    private static String intro = "<h1>Loading/Saving a Dynamic Form using XML</h1>" +
            "<p>" +
            "    This is a very simple example of using XML for load and submit of data with an Ext dynamic form." +
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
