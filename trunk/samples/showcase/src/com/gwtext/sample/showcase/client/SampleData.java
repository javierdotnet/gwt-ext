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

package com.gwtext.sample.showcase.client;

import com.gwtext.client.data.*;
import com.gwtext.client.widgets.grid.*;

public class SampleData {

    public static Object[][] getCountries() {
        //abbr, name, capital, continent, population, area in sq. km
        return new Object[][]{
                new Object[]{"au", "Australia", "Canberra", "Australia", new Integer(18090000), new Integer(7713360)},
                new Object[]{"br", "Brazil", "Brasilia", "South America", new Integer(170000000), new Integer(8547404)},
                new Object[]{"ca", "Canada", "Ottawa", "North America", new Integer(31000000), new Integer(9976140)},
                new Object[]{"cn", "China", "Beijing", "Asia", new Integer(1222017000), new Integer(9596960)},
                new Object[]{"de", "Germany", "Berlin", "Europe", new Integer(80942000), new Integer(356910)},
                new Object[]{"fr", "France", "Paris", "Europe", new Integer(57571000), new Integer(551500)},
                new Object[]{"in", "India", "New Delhi", "Asia", new Integer(913747000), new Integer(3287590)},
                new Object[]{"sc", "Seychelles", "Victoria", "Africa", new Integer(73000), new Integer(280)},
                new Object[]{"us", "United States", "Washington, DC", "North America", new Integer(260513000), new Integer(9372610)},
                new Object[]{"jp", "Japan", "Tokyo", "Asia", new Integer(125422000), new Integer(377800)},
                new Object[]{"ie", "Italy", "Rome", "Eorope", new Integer(57867000), new Integer(301270)},
                new Object[]{"gh", "Ghana", "Accra", "Africa", new Integer(16944000), new Integer(238540)},
                new Object[]{"ie", "Iceland", "Reykjavik", "Europe", new Integer(270000), new Integer(103000)},
                new Object[]{"fi", "Finland", "Helsinki", "Europe", new Integer(5033000), new Integer(338130)},
                new Object[]{"ch", "Switzerland", "Berne", "Europe", new Integer(6910000), new Integer(41290)}
        };
    }

    public static Object[][] getStates() {
        return new Object[][]{
                new Object[]{"AL", "Alabama"},
                new Object[]{"AK", "Alaska"},
                new Object[]{"AZ", "Arizona"},
                new Object[]{"AR", "Arkansas"},
                new Object[]{"CA", "California"},
                new Object[]{"CO", "Colorado"},
                new Object[]{"CN", "Connecticut"},
                new Object[]{"DE", "Delaware"},
                new Object[]{"DC", "District of Columbia"},
                new Object[]{"FL", "Florida"},
                new Object[]{"GA", "Georgia"},
                new Object[]{"HW", "Hawaii"},
                new Object[]{"ID", "Idaho"},
                new Object[]{"IL", "Illinois"},
                new Object[]{"IN", "Indiana"},
                new Object[]{"IA", "Iowa"},
                new Object[]{"KS", "Kansas"},
                new Object[]{"KY", "Kentucky"},
                new Object[]{"LA", "Louisiana"},
                new Object[]{"MA", "Massachusetts"},
                new Object[]{"ME", "Maine"},
                new Object[]{"MD", "Maryland"},
                new Object[]{"MI", "Michigan"},
                new Object[]{"MN", "Minnesota"},
                new Object[]{"MS", "Mississippi"},
                new Object[]{"MO", "Missouri"},
                new Object[]{"MT", "Montana"},
                new Object[]{"NE", "Nebraska"},
                new Object[]{"NV", "Nevada"},
                new Object[]{"NH", "New Hampshire"},
                new Object[]{"NJ", "New Jersey"},
                new Object[]{"NM", "New Mexico"},
                new Object[]{"NY", "New York"},
                new Object[]{"NC", "North Carolina"},
                new Object[]{"ND", "North Dakota"},
                new Object[]{"OH", "Ohio"},
                new Object[]{"OK", "Oklahoma"},
                new Object[]{"OR", "Oregon"},
                new Object[]{"PA", "Pennsylvania"},
                new Object[]{"RH", "Rhode Island"},
                new Object[]{"SC", "South Carolina"},
                new Object[]{"SD", "South Dakota"},
                new Object[]{"TE", "Tennessee"},
                new Object[]{"TX", "Texas"},
                new Object[]{"UT", "Utah"},
                new Object[]{"VE", "Vermont"},
                new Object[]{"VA", "Virginia"},
                new Object[]{"WA", "Washington"},
                new Object[]{"WV", "West Virginia"},
                new Object[]{"WI", "Wisconsin"},
                new Object[]{"WY", "Wyoming"}
        };
    }

    public static Object[][] getCompanyData() {
        return new Object[][]{
                new Object[]{"3m Co", new Double(71.72), new Double(0.02), new Double(0.03), "9/1 12:00am", "MMM"},
                new Object[]{"Alcoa Inc", new Double(29.01), new Double(0.42), new Double(1.47), "9/1 12:00am", "AA"},
                new Object[]{"Altria Group Inc", new Double(83.81), new Double(0.28), new Double(0.34), "9/1 12:00am", "MO"},
                new Object[]{"American Express Company", new Double(52.55), new Double(0.01), new Double(0.02), "9/1 12:00am", "AXP"},
                new Object[]{"American International Group, Inc.", new Double(64.13), new Double(0.31), new Double(0.49), "9/1 12:00am", "AIG"},
                new Object[]{"AT&T Inc.", new Double(31.61), new Double(-0.48), new Double(-1.54), "9/1 12:00am", "T"},
                new Object[]{"Boeing Co.", new Double(75.43), new Double(0.53), new Double(0.71), "9/1 12:00am", "BA"},
                new Object[]{"Caterpillar Inc.", new Double(67.27), new Double(0.92), new Double(1.39), "9/1 12:00am", "CAT"},
                new Object[]{"Citigroup, Inc.", new Double(49.37), new Double(0.02), new Double(0.04), "9/1 12:00am", "C"},
                new Object[]{"E.I. du Pont de Nemours and Company", new Double(40.48), new Double(0.51), new Double(1.28), "9/1 12:00am", "DD"},
                new Object[]{"Exxon Mobil Corp", new Double(68.1), new Double(-0.43), new Double(-0.64), "9/1 12:00am", "XOM"},
                new Object[]{"General Electric Company", new Double(34.14), new Double(-0.08), new Double(-0.23), "9/1 12:00am", "GE"},
                new Object[]{"General Motors Corporation", new Double(30.27), new Double(1.09), new Double(3.74), "9/1 12:00am", "GM"},
                new Object[]{"Hewlett-Packard Co.", new Double(36.53), new Double(-0.03), new Double(-0.08), "9/1 12:00am", "HPQ"},
                new Object[]{"Honeywell Intl Inc", new Double(38.77), new Double(0.05), new Double(0.13), "9/1 12:00am", "HON"},
                new Object[]{"Intel Corporation", new Double(19.88), new Double(0.31), new Double(1.58), "9/1 12:00am", "INTC"},
                new Object[]{"International Business Machines", new Double(81.41), new Double(0.44), new Double(0.54), "9/1 12:00am", "IBM"},
                new Object[]{"Johnson & Johnson", new Double(64.72), new Double(0.06), new Double(0.09), "9/1 12:00am", "JNJ"},
                new Object[]{"JP Morgan & Chase & Co", new Double(45.73), new Double(0.07), new Double(0.15), "9/1 12:00am"},
                new Object[]{"McDonald\"s Corporation", new Double(36.76), new Double(0.86), new Double(2.40), "9/1 12:00am", "MCD"},
                new Object[]{"Merck & Co., Inc.", new Double(40.96), new Double(0.41), new Double(1.01), "9/1 12:00am", "MRK"},
                new Object[]{"Microsoft Corporation", new Double(25.84), new Double(0.14), new Double(0.54), "9/1 12:00am", "MSFT"},
                new Object[]{"Pfizer Inc", new Double(27.96), new Double(0.4), new Double(1.45), "9/1 12:00am", "PFE"},
                new Object[]{"The Coca-Cola Company", new Double(45.07), new Double(0.26), new Double(0.58), "9/1 12:00am", "KO"},
                new Object[]{"The Home Depot, Inc.", new Double(34.64), new Double(0.35), new Double(1.02), "9/1 12:00am", "HD"},
                new Object[]{"The Procter & Gamble Company", new Double(61.91), new Double(0.01), new Double(0.02), "9/1 12:00am", "PG"},
                new Object[]{"United Technologies Corporation", new Double(63.26), new Double(0.55), new Double(0.88), "9/1 12:00am", "UTX"},
                new Object[]{"Verizon Communications", new Double(35.57), new Double(0.39), new Double(1.11), "9/1 12:00am", "VZ"},
                new Object[]{"Wal-Mart Stores, Inc.", new Double(45.45), new Double(0.73), new Double(1.63), "9/1 12:00am", "WMT"},
                new Object[]{"Walt Disney Company (The) (Holding Company)", new Double(29.89), new Double(0.24), new Double(0.81), "9/1 12:00am", "DIS"}
        };
    }


    public static Grid getSampleGrid(String id, String width, String height) {
        MemoryProxy proxy = new MemoryProxy(SampleData.getCompanyData());
        RecordDef recordDef = new RecordDef(
                new FieldDef[]{
                        new StringFieldDef("company"),
                        new FloatFieldDef("price"),
                        new FloatFieldDef("change"),
                        new FloatFieldDef("pctChange"),
                        new DateFieldDef("lastChanged", "n/j h:ia"),
                        new StringFieldDef("symbol")
                }
        );



        ArrayReader reader = new ArrayReader(recordDef);
        Store store = new Store(proxy, reader);
        store.load();

        //setup column model
        ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{
                new ColumnConfig() {
                    {
                        setHeader("Company");
                        setWidth(160);
                        setSortable(true);
                        setLocked(false);
                        setDataIndex("company");
                    }
                },
                new ColumnConfig() {
                    {
                        setHeader("Price");
                        setWidth(75);
                        setSortable(true);
                        setDataIndex("price");
                        setRenderer(new Renderer() {
                            public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                                return "$" + value;
                            }
                        });
                    }
                },
                new ColumnConfig() {
                    {
                        setId("change");
                        setHeader("Change");
                        setWidth(75);
                        setSortable(true);
                        setDataIndex("change");
                        setRenderer(new Renderer() {
                            public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                                if (((Float) value).floatValue() < 0) {
                                    return "<span style='color:red;'>" + value + "</span>";
                                } else {
                                    return value.toString();
                                }
                            }
                        });
                    }
                },
                new ColumnConfig() {
                    {
                        setHeader("% Change");
                        setWidth(75);
                        setSortable(true);
                        setDataIndex("pctChange");
                    }
                }
        });

        //create and render grid
        final Grid grid = new Grid(id, width, height, store, columnModel);
        grid.render();
        return grid;
    }
}
