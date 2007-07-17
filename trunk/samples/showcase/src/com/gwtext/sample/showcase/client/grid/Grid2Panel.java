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

package com.gwtext.sample.showcase.client.grid;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.data.*;
import com.gwtext.client.data.DateField;
import com.gwtext.client.data.Field;
import com.gwtext.client.widgets.layout.GridPanel;
import com.gwtext.client.widgets.form.*;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.ContentPanelConfig;
import com.gwtext.client.widgets.layout.LayoutRegionConfig;

import java.util.Date;

public class Grid2Panel extends Composite {

    private boolean init = false;
    private VerticalPanel vp;

    public Grid2Panel() {
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
        //this example loads an editable grid from remote xml data
        HttpProxy proxy = new HttpProxy("plants.xml", "GET");
        XmlReader reader = new XmlReader("plant", new RecordDef(
                new Field[]{
                        new StringField("common"),
                        new StringField("botanical"),
                        new StringField("light"),
                        new FloatField("price"),
                        new DateField("availDate", "availability", "m/d/Y"),
                        new BooleanField("indoor")
                }
        ));

        Store store = new Store(proxy, reader);

        ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{
                new ColumnConfig() {
                    {
                        setHeader("Common Name");
                        setDataIndex("common");
                        setWidth(220);
                        setEditor(new GridEditor(new TextField(new TextFieldConfig() {
                            {
                                setAllowBlank(false);
                            }
                        })));
                    }
                },
                new ColumnConfig() {
                    {
                        setHeader("Light");
                        setDataIndex("light");
                        setWidth(130);
                    }
                },
                new ColumnConfig() {
                    {
                        setHeader("Price");
                        setDataIndex("price");
                        setWidth(70);
                        setAlign("right");
                        setRenderer(new Renderer() {
                            public String render(String value, Record record, int rowIndex, int colNum) {
                                return "$" + value;
                            }
                        });
                        setEditor(new GridEditor(new NumberField(new NumberFieldConfig() {
                            {
                                setAllowBlank(false);
                                setAllowNegative(false);
                                setMaxValue(10);
                            }
                        })));
                    }
                },
                new ColumnConfig() {
                    {
                        setHeader("Available");
                        setDataIndex("availDate");
                        setWidth(95);
                        setEditor(new GridEditor(new com.gwtext.client.widgets.form.DateField(new DateFieldConfig() {
                            {
                                setFormat("m/d/Y");
                                setMinValue("01/01/06");
                                setDisableDays(new int[]{0, 6});
                                setDisabledDaysText("Plants are not available on the weekend");
                            }
                        })));
                    }
                },
                new ColumnConfig() {
                    {
                        setHeader("Indoor?");
                        setDataIndex("indoor");
                        setWidth(55);
                        setEditor(new GridEditor(new Checkbox(new CheckboxConfig())));
                    }
                }
        });

        columnModel.setDefaultSortable(true);
        Grid grid = new EditorGrid("grid-example2", "300px", "600px", store, columnModel);

        grid.render();
        store.load(new StoreLoadConfig() {
            {
                setParams(new UrlParam[]{new UrlParam("rnd", new Date().getTime() + "")});
            }

        });

        vp.setWidth("100%");
        vp.setHeight("100%");
        vp.add(grid);
        vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
    }
}