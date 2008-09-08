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
 
package com.gwtext.sample.showcase2.client;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.grid.*;

import java.util.Date;

public class SampleGrid extends GridPanel {

    private static final NumberFormat nf = NumberFormat.getFormat("#,##0.00");
    private static final NumberFormat nfc = NumberFormat.getFormat("#,##0.00");
    private static final DateTimeFormat dateFormatter = DateTimeFormat.getFormat("M/d/y");

    protected static BaseColumnConfig[] columns = new BaseColumnConfig[]{

            new ColumnConfig("Company", "company", 160, true, null, "company"),

            new ColumnConfig("Price", "price", 35, true, new Renderer() {
                public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                    return nf.format(((Number) value).doubleValue());
                }
            }),

            new ColumnConfig("Change", "change", 45, true, new Renderer() {
                public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                    float val = ((Float) value).floatValue();
                    String valString = nfc.format(val);
                    if (val < 0) {
                        return "<span style='color:red;'>" + valString + "</span>";
                    } else {
                        return valString;
                    }
                }
            }, "change"),
            new ColumnConfig("% Change", "pctChange", 65, true, null, "pctChange"),

            new ColumnConfig("Last Updated", "lastChanged", 65, true, new Renderer() {
                public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                    Date date = (Date) value;
                    return dateFormatter.format(date);
                }
            }),
            new ColumnConfig("Industry", "industry", 60, true)
    };


    private static RecordDef recordDef = new RecordDef(
            new FieldDef[]{
                    new StringFieldDef("company"),
                    new FloatFieldDef("price"),
                    new FloatFieldDef("change"),
                    new FloatFieldDef("pctChange"),
                    new DateFieldDef("lastChanged", "n/j h:ia"),
                    new StringFieldDef("symbol"),
                    new StringFieldDef("industry")
            }
    );

    private int[] columnIndexes;
	protected Store store;

	public SampleGrid() {
        this(false);
    }

    public SampleGrid(boolean small) {
        this(false, null);
    }

    public SampleGrid(boolean small, int[] columnIndexes) {

        this.columnIndexes = columnIndexes;
        Object[][] data = small ? SampleData.getCompanyDataSmall() : SampleData.getCompanyDataLarge();
        MemoryProxy proxy = new MemoryProxy(data);

        ArrayReader reader = new ArrayReader(recordDef);
        store = new Store(proxy, reader);
        store.load();
        setStore(store);

        ColumnModel columnModel = getColumnConfigs();
        setColumnModel(columnModel);

        setFrame(true);
        setStripeRows(true);
        setAutoExpandColumn("company");
        setIconCls("grid-icon");
    }

    protected ColumnModel getColumnConfigs() {
        ColumnModel columnModel = null;
        if (columnIndexes == null) {
            columnModel = new ColumnModel(columns);
        } else {
            BaseColumnConfig[] columnConfigs = new BaseColumnConfig[columnIndexes.length];
            for (int i = 0; i < columnIndexes.length; i++) {
                int columnIndex = columnIndexes[i];
                columnConfigs[i] = columns[i];
            }
            columnModel = new ColumnModel(columnConfigs);
        }
        return columnModel;
    }
}
