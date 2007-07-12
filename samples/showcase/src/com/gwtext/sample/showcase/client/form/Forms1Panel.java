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

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.form.*;
import com.gwtext.client.widgets.form.DateField;

public class Forms1Panel extends Composite {

    private boolean init = false;
    private VerticalPanel vp;

    public Forms1Panel() {
        vp = new VerticalPanel();
        vp.setSpacing(15);
        initWidget(vp);
    }

    protected void onLoad() {
        if (!init) {
            init = true;
            setup();
        }
    }

    private void setup() {
        //create and configure few forms
        Form simple = new Form("form-ct1", new FormConfig() {
            {
                setWidth(300);
                setHeader("Simple Form");
                setLabelWidth(75);
                setUrl("foobar.php");
                setSurrondWithBox(true);
            }
        });
        simple.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("First Name");
                setName("first");
                setWidth(175);
                setAllowBlank(false);
            }
        }));

        simple.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Last Name");
                setName("last");
                setWidth(175);
            }
        }));

        simple.add(new DateField(new DateFieldConfig() {
            {
                setDisableDays(new int[]{0, 4});
                setFieldLabel("Sample Date");
                setValue("05/07/07");
            }
        }));

        simple.addButton("Save");
        simple.addButton("Cancel");
        simple.render();

        Form top = new Form("form-ct2", new FormConfig() {
            {
                setLabelAlign("top");
                setHeader("Multi-column and labels top");
                setWidth(600);
                setSurrondWithBox(true);
            }
        });

        top.column(new ColumnConfig() {
            {
                setWidth(282);
            }
        });

        top.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("First Name");
                setName("name");
                setWidth(225);
            }
        }));
        top.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Company");
                setName("company");
                setWidth(225);
            }
        }));

        top.end();

        top.column(new ColumnConfig() {
            {
                setWidth(272);
                setStyle("margin-left:10px;");
                setClear(true);
            }
        });

        top.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Last Name");
                setName("company");
                setWidth(225);
            }
        }));
        top.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Email");
                setName("email");
                setVtype(VType.EMAIL);
                setWidth(225);
            }
        }));

        top.end();

        top.addButton("Save");
        top.addButton("Cancel");
        top.render();

        //another form
        Form fs = new Form("form-ct3", new FormConfig() {
            {
                setLabelAlign("right");
                setHeader("Multi-column and labels top");
                setWidth(400);
                setLabelWidth(75);
                setSurrondWithBox(true);
            }
        });

        fs.fieldset(new FieldSetConfig() {
            {
                setLegend("Contact Information");
            }
        });
        fs.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("First Name");
                setName("name");
                setWidth(200);
            }
        }));
        fs.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Last Name");
                setName("company");
                setWidth(200);
            }
        }));

        fs.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Company");
                setName("company");
                setWidth(200);
            }
        }));
        fs.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Email");
                setName("email");
                setVtype(VType.EMAIL);
                setWidth(200);
            }
        }));


        //configure data store for combo box
        HttpProxy proxy = new HttpProxy("plants.xml");

        Reader reader = new XmlReader("plant", new RecordDef(
                new com.gwtext.client.data.Field[]{
                        new StringField("common"),
                        new StringField("botanical"),
                        new StringField("light"),
                        new FloatField("price"),
                        new com.gwtext.client.data.DateField("availDate", "availability", "m/d/Y"),
                        new BooleanField("indoor")
                })
        );
        final Store store = new Store(proxy, reader);
        store.load();

        fs.add(new ComboBox(new ComboBoxConfig() {
            {
                setFieldLabel("State");
                setHiddenName("state");
                setStore(store);
                setDisplayField("common");
                setTypeAhead(true);
                setMode("local");
                setTriggerAction("all");
                setEmptyText("Select a state...");
                setSelectOnFocus(true);
                setWidth(190);
            }
        }));

        fs.add(new DateField(new DateFieldConfig() {
            {
                setFieldLabel("Date of birth");
                setName("dob");
                setWidth(190);
                setAllowBlank(false);
            }
        }));

        fs.end();
        fs.addButton("Save");
        fs.addButton("Cancel");
        fs.render();

        //another form
        Form form = new Form("form-ct4", new FormConfig() {
            {
                setLabelAlign("right");
                setLabelWidth(75);
                setWidth(700);
                setHeader("Multi-column, nesting and fieldsets");
                setSurrondWithBox(true);
            }
        });

        form.column(new ColumnConfig() {
            {
                setWidth(342);
                setLabelWidth(75);
            }
        });

        form.fieldset(new FieldSetConfig() {
            {
                setLegend("Contact Information");
            }
        });

        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Full Name");
                setName("fullName");
                setAllowBlank(false);
                setValue("Jack Slocum");
            }
        }));

        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Job Title");
                setName("title");
                setValue("Jr. Developer");
            }
        }));

        form.add(new TextArea(new TextAreaConfig() {
            {
                setFieldLabel("Address");
                setName("address");
                setGrow(true);
                setPreventScrollbars(true);
                setValue("4 Redbulls Drive");
            }
        }));
        form.end();

        form.fieldset(new FieldSetConfig() {
            {
                setLegend("Phone Numbers");
            }
        });

        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Home");
                setName("home");
                setValue("(888) 555-1212");
            }
        }));

        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Business");
                setName("business");
            }
        }));

        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Mobile");
                setName("mobile");
            }
        }));

        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Fax");
                setName("fax");
            }
        }));
        form.end();
        form.end();

        form.column(new ColumnConfig() {
            {
                setWidth(202);
                setStyle("margin-left:10px;");
                setClear(true);
            }
        });

        form.fieldset(new FieldSetConfig() {
            {
                setLegend("Photo");
            }
        });
        form.end();

        form.fieldset(new FieldSetConfig() {
            {
                setLegend("Options");
                setHideLabels(true);
            }
        });

        form.end();
        form.end();
        form.addButton("Save");
        form.addButton("Cancel");

        form.applyIfToFields(new FieldConfig() {
            {
                setWidth(230);
            }
        });
        form.render();

        vp.add(simple);
        vp.add(top);
        vp.add(fs);
        vp.add(form);
    }
}