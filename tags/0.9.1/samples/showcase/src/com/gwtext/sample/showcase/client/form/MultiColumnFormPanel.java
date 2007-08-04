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
import com.gwtext.client.widgets.form.*;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class MultiColumnFormPanel extends ShowcaseExampleVSD {

    public String getSourceUrl() {
        return "form/MultiColumnFormPanel.java.html";
    }

    public Panel getViewPanel() {

        Form form = new Form(new FormConfig() {
            {
                setLabelAlign("top");
                setHeader("Multi-column and labels top");
                setWidth(600);
                setSurrondWithBox(true);
            }
        });

        form.column(new ColumnConfig() {
            {
                setWidth(282);
            }
        });

        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("First Name");
                setName("name");
                setWidth(225);
            }
        }));
        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Company");
                setName("company");
                setWidth(225);
            }
        }));

        form.end();

        form.column(new ColumnConfig() {
            {
                setWidth(272);
                setStyle("margin-left:10px;");
                setClear(true);
            }
        });

        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Last Name");
                setName("company");
                setWidth(225);
            }
        }));
        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Email");
                setName("email");
                setVtype(VType.EMAIL);
                setWidth(225);
            }
        }));

        form.end();

        form.addButton("Save");
        form.addButton("Cancel");
        form.render();

        Panel panel = createPanel();
        panel.add(new HTML(intro));
        panel.add(form);
        return panel;
    }

    private static String intro = "<h3>Forms built using GWT-Ext</h3>\n" +
            "<p>\n" +
            "    These forms do not do anything and have very little validation. They solely demonstrate\n" +
            "    how you can use GWT-Ext Forms to build and layout forms.\n" +
            "</p>";
}
