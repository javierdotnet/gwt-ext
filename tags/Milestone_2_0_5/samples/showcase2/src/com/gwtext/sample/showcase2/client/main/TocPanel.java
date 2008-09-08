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
 
package com.gwtext.sample.showcase2.client.main;

import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.form.Checkbox;
import com.gwtext.client.widgets.form.event.CheckboxListenerAdapter;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.client.widgets.grid.event.GridRowListenerAdapter;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.core.SortDir;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.util.Format;
import com.gwtext.sample.showcase2.client.ScreenManager;
import com.gwtext.sample.showcase2.client.ShowcasePanel;
import com.google.gwt.i18n.client.DateTimeFormat;

import java.util.Date;

public class TocPanel extends ShowcasePanel {

	private ScreenManager screenManager;

	private static DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("d MMM yyyy");

	public TocPanel(ScreenManager screenManager) {
		this.screenManager = screenManager;
	}

	public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();
			panel.setLayout(new FitLayout());
			panel.setTitle("Table of Contents");

			MemoryProxy proxy = ScreenManager.getProxy();

			ArrayReader reader = ScreenManager.getReader();

			final GroupingStore store = new GroupingStore();
			store.setReader(reader);
			store.setDataProxy(proxy);
			store.setSortInfo(new SortState("dateAdded", SortDir.DESC));
			store.setGroupField("category");
			store.load();

			store.filterBy(new StoreTraversalCallback() {
				public boolean execute(Record record) {
					return record.getAsString("category") != null;
				}
			});
			GroupingView gridView = new GroupingView();
			gridView.setForceFit(true);
			gridView.setGroupTextTpl("{text} ({[values.rs.length]} {[values.rs.length > 1 ? \"Items\" : \"Item\"]})");

			ColumnConfig categoryCol = new ColumnConfig("Category", "category", 10, true);
			categoryCol.setHidden(true);

			ColumnConfig descriptionCol = new ColumnConfig("Description", "title", 300);
			descriptionCol.setId("descCol");
			descriptionCol.setRenderer(new Renderer() {
				public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
					ShowcasePanel panel = (ShowcasePanel)record.getAsObject("screen");
					return  panel == null || panel.getIntro() == null ? "" : Format.ellipsis(panel.getIntro(), 300);
				}
			});

			ColumnConfig dateCol = new ColumnConfig("Date Added", "dateAdded", 30, true);
			dateCol.setRenderer(new Renderer() {
				public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
					Date date = (Date) value;
					return dateTimeFormat.format(date);
				}
			});


			BaseColumnConfig[] columnConfigs = new BaseColumnConfig[] {
					new RowNumberingColumnConfig(),
					categoryCol,
					new ColumnConfig("Sample", "title", 70, true),
					descriptionCol,
					dateCol
			};
			ColumnModel columnModel = new ColumnModel(columnConfigs);

			Toolbar toolbar = new Toolbar();
			toolbar.addFill();

			Checkbox cb = new Checkbox("Group by Category");
			cb.setChecked(true);
			cb.addListener(new CheckboxListenerAdapter() {
				public void onCheck(Checkbox field, boolean checked) {
					if(checked) {
						store.groupBy("category");
					} else {
						store.clearGrouping();
					}
				}
			});
			toolbar.addField(cb);

			GridPanel grid = new GridPanel();
			grid.setId("toc-grid");
			grid.setStore(store);
			grid.setColumnModel(columnModel);
			grid.setView(gridView);
			grid.setIconCls("grid-icon");
			grid.setTopToolbar(toolbar);
			grid.setAutoExpandColumn("descCol");

			grid.addGridRowListener(new GridRowListenerAdapter() {
				public void onRowDblClick(GridPanel grid, int rowIndex, EventObject e) {
					Record record = store.getAt(rowIndex);
					screenManager.showScreen(record.getAsString("id"));
				}
			});
			panel.add(grid);
		}
		return panel;
	}
}