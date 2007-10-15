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
import com.gwtext.client.util.DOMUtil;
import com.gwtext.client.widgets.form.Form;
import com.gwtext.client.widgets.form.FormConfig;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.TextFieldConfig;
import com.gwtext.client.widgets.grid.Grid;
import com.gwtext.client.widgets.grid.RowSelectionModel;
import com.gwtext.client.widgets.grid.event.RowSelectionListenerAdapter;
import com.gwtext.sample.showcase.client.SampleData;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class GridFormPanel extends ShowcaseExampleVSD {


    public String getDataUrl() {
        return "data/CompanyData.java.html";
    }

    public String getSourceUrl() {
        return "form/GridFormPanel.java.html";
    }

    public Panel getViewPanel() {

        final Form form = new Form(new FormConfig() {
            {
                setWidth(350);
                setHeader("Form with Grid");
                setLabelWidth(75); 
                setSurroundWithBox(true);
            }
        });

        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Company");
                setName("company");
                setWidth(175);
                setAllowBlank(false);
            }
        }));


        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Symbol");
                setName("symbol");
                setWidth(175);
            }
        }));

        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Price");
                setName("price");
                setWidth(175);
            }
        }));

        form.fieldset("My Favourites");

        form.container("my-form-grid-container");
        form.end(); //end contianer

        form.end();  //end fieldset

        form.addButton("Save");
        form.addButton("Cancel");
        form.render();

        Panel gridPanel = DOMUtil.convertDivToPanel("my-form-grid-container");

        Grid grid = SampleData.getSampleGrid("my-form-grid", "300px", "300px");

        //add a grid row selection listener so that when a row is selcted, the corresponding record is loaded into the form
        grid.getSelectionModel().addRowSelectionListener(new RowSelectionListenerAdapter() {
            public void onRowSelect(RowSelectionModel sm, int rowIndex) {
                form.loadRecord(sm.getSelected());
            }
        });
        gridPanel.add(grid);

        VerticalPanel vp = createPanel();
        vp.add(new HTML(intro));
        vp.add(form);

        return vp;
    }

    private static String intro = "<h3>Form with Grid Record Binding</h3>\n" +
            "<p>\n" +
            "    This example illustrates how to embed a Grid in a Form. It also demonstrates \n" +
            "    data binding between a Form and Grid using the underlying Store's Records.\n" +
            "    Try clicking on a Grid row. The selected Record's data is displayed in the Form.\n" +
            "</p>";
}