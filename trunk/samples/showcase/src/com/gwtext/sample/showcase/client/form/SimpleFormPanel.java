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
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.widgets.form.*;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class SimpleFormPanel extends ShowcaseExampleVSD {

    public String getSourceUrl() {
        return "form/SimpleFormPanel.java.html";
    }

    public Panel getViewPanel() {
        Form form = new Form(new FormConfig() {
            {
                setWidth(300);
                setHeader("Simple Form");
                setLabelWidth(75);
                setUrl("foobar.php");
                setSurroundWithBox(true);
            }
        });

        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("First Name");
                setName("first");
                setWidth(175);
                setAllowBlank(false);
            }
        }));

        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Last Name");
                setName("last");
                setWidth(175);
            }
        }));

        final DateField dateField = new DateField(new DateFieldConfig() {
            {
                setDisabledDays(new int[]{0, 4});
                setFieldLabel("Sample Date");                
                setFormat("Y-m-d");
            }
        });

        form.add(dateField);

        form.addButton("Save");
        form.addButton("Cancel");
        form.render();

        VerticalPanel vp = createPanel();
        vp.add(new HTML(intro));
        vp.add(form);

        return vp;
    }

    private static String intro = "<h3>Forms built using GWT-Ext</h3>\n" +
            "<p>\n" +
            "    These forms do not do anything and have very little validation. They solely demonstrate\n" +
            "    how you can use GWT-Ext Forms to build and layout forms.\n" +
            "</p>";
}
