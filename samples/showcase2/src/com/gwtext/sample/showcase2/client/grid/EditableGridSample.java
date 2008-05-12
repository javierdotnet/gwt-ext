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
 
package com.gwtext.sample.showcase2.client.grid;

import com.gwtext.client.core.Connection;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.TextAlign;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.DateField;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.client.widgets.grid.event.GridCellListenerAdapter;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

import java.util.Date;

public class EditableGridSample extends ShowcasePanel {

    private EditorGridPanel grid;

    public String getSourceUrl() {
        return "source/grid/EditableGridSample.java.html";
    }

    public String getXmlDataUrl() {
        return "source/grid/EditableGridSample.xml.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            HttpProxy proxy = new HttpProxy("data/plants.xml", Connection.GET);

            final RecordDef recordDef = new RecordDef(
                    new FieldDef[]{
                            new StringFieldDef("common"),
                            new StringFieldDef("botanical"),
                            new StringFieldDef("light"),
                            new FloatFieldDef("price"),
                            new DateFieldDef("availDate", "availability", "m/d/Y"),
                            new BooleanFieldDef("indoor")
                    }
            );

            XmlReader reader = new XmlReader("plant", recordDef);
            final Store store = new Store(proxy, reader);
            SimpleStore cbStore = new SimpleStore("lightTypes", new String[]{
                    "Shade",
                    "Mostly Shady",
                    "Sun or Shade",
                    "Mostly Sunny",
                    "Sunny"
            });

            store.load();
            cbStore.load();

            final ComboBox cb = new ComboBox();
            cb.setDisplayField("lightTypes");
            cb.setStore(cbStore);

            ColumnConfig commonCol = new ColumnConfig("Common Name", "common", 220, true, null, "common");
            commonCol.setEditor(new GridEditor(new TextField()));

            ColumnConfig lightCol = new ColumnConfig("Light", "light", 130);
            lightCol.setEditor(new GridEditor(cb));


            ColumnConfig priceCol = new ColumnConfig("Price", "price", 70, true);
            priceCol.setAlign(TextAlign.RIGHT);
            priceCol.setRenderer(new Renderer() {
                public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                    return "$" + value;
                }
            });
            NumberField numberField = new NumberField();
            numberField.setAllowBlank(false);
            numberField.setAllowNegative(false);
            numberField.setMaxValue(1000);
            priceCol.setEditor(new GridEditor(numberField));

            ColumnConfig availableCol = new ColumnConfig("Available", "availDate", 95, true);

            DateField dateField = new DateField();
            dateField.setFormat("m/d/Y");
            dateField.setMinValue("01/01/06");
            dateField.setDisabledDays(new int[]{0, 6});
            dateField.setDisabledDaysText("Plants are not available on the weekend");
            availableCol.setEditor(new GridEditor(dateField));

            ColumnConfig indoorCol = new ColumnConfig("Indoor?", "indoor", 55);

            indoorCol.setRenderer(new Renderer() {
                public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                    boolean checked = ((Boolean) value).booleanValue();
                    return "<img class=\"checkbox\" src=\"js/ext/resources/images/default/menu/" + (checked ? "checked.gif" : "unchecked.gif") + "\"/>";
                }
            });

            ColumnConfig[] columnConfigs = {
                    commonCol,
                    lightCol,
                    priceCol,
                    availableCol,
                    indoorCol
            };

            ColumnModel columnModel = new ColumnModel(columnConfigs);
            columnModel.setDefaultSortable(true);

            Toolbar toolbar = new Toolbar();

            ToolbarButton button = new ToolbarButton("Add Plant", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {

                    Record plant = recordDef.createRecord(new Object[]{"New Plant1", "Anguinaria Canadensis", "Mostly Shady", new Float(5), "", Boolean.FALSE});
                    grid.stopEditing();
                    store.insert(0, plant);
                    grid.startEditing(0, 0);
                }
            });

            toolbar.addButton(button);

            grid = new EditorGridPanel();
            grid.setStore(store);
            grid.setColumnModel(columnModel);
            grid.setWidth(500);
            grid.setHeight(300);
            grid.setAutoExpandColumn("common");
            grid.setTitle("Editor Grid Example");
            grid.setFrame(true);
            grid.setClicksToEdit(1);
            grid.setTopToolbar(toolbar);

            grid.addGridCellListener(new GridCellListenerAdapter() {
                public void onCellClick(GridPanel grid, int rowIndex, int colIndex, EventObject e) {
                    if (grid.getColumnModel().getDataIndex(colIndex).equals("indoor") && e.getTarget(".checkbox", 1) != null) {
                        Record record = grid.getStore().getAt(rowIndex);
                        record.set("indoor", !record.getAsBoolean("indoor"));
                    }
                }
            });

            store.load(new UrlParam[]{new UrlParam("rnd", new Date().getTime() + "")});
            panel = new Panel();
            panel.add(grid);
        }
        return panel;
    }

    public String getIntro() {
        return "<p>This example shows how to create a grid with inline editing. Try  clicking on the table cells. Each colum can be assigned its own cell editor.<p>" +
                "<p>The 'Common Name' column has a TextField editor, the 'Light' column has a ComboBox editor, 'Price' has a NumberField editor, 'Available' has a DateFieldEditor" +
                " and 'Indoor' has a custom Boolean editor.";
    }
}