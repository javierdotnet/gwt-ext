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

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.data.*;
import com.gwtext.client.data.DateFieldDef;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.widgets.form.*;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.client.widgets.grid.event.GridCellListenerAdapter;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

import java.util.Date;

public class EditableGridPanel extends ShowcaseExampleVSD {

	public String getDataUrl() {
		return "data/plants.xml.html";
	}

	public String getSourceUrl() {
		return "grid/EditableGridPanel.java.html";
	}

	public Panel getViewPanel() {
		HttpProxy proxy = new HttpProxy("data/plants.xml", "GET");
		XmlReader reader = new XmlReader("plant", new RecordDef(
				new FieldDef[]{
						new StringFieldDef("common"),
						new StringFieldDef("botanical"),
						new StringFieldDef("light"),
						new FloatFieldDef("price"),
						new DateFieldDef("availDate", "availability", "m/d/Y"),
						new BooleanFieldDef("indoor")
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
                            public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
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
								setDisabledDays(new int[]{0, 6});
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
						//setEditor(new GridEditor(new Checkbox(new CheckboxConfig())));

						setRenderer(new Renderer() {
                            public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
								boolean checked = ((Boolean) value).booleanValue();
								return "<img class=\"checkbox\" src=\"js/ext/resources/images/default/menu/" + (checked ? "checked.gif" : "unchecked.gif") + "\"/>";
							}
						});
					}
				}
		});
		columnModel.setDefaultSortable(true);

		EditorGrid grid = new EditorGrid("grid-example2", "600px", "300px", store, columnModel);

		grid.addGridCellListener(new GridCellListenerAdapter() {
			public void onCellClick(Grid grid, int rowIndex, int colIndex, EventObject e) {
				if (grid.getColumnModel().getDataIndex(colIndex).equals("indoor") && e.getTarget(".checkbox", 1) != null) {
					Record record = grid.getStore().getAt(rowIndex);
					record.set("indoor", !record.getAsBoolean("indoor"));
				}
			}
		});

		grid.render();

		store.load(new StoreLoadConfig() {
			{
				setParams(new UrlParam[]{new UrlParam("rnd", new Date().getTime() + "")});
			}

		});

		VerticalPanel vp = createPanel();
		vp.add(new HTML("<h1>Editor Grid Example</h1>"));
		vp.add(new HTML("<p>This example shows how to create a grid with inline editing. Try double clicking on the table cells.</p>"));

		vp.add(grid);
		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		return vp;
	}
}
