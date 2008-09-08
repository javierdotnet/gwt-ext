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
 
package com.gwtext.sample.maps.client;

import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.layout.VerticalLayout;

public class CreditsPanel extends ShowcasePanel {


	public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();

			panel.setLayout(new VerticalLayout(15));




			RecordDef recordDef2 = new RecordDef(new FieldDef[]{
					new StringFieldDef("name"),
					new StringFieldDef("description")
			});

			ArrayReader reader2 = new ArrayReader(recordDef2);
			MemoryProxy proxy2 = new MemoryProxy(getCreditsData());

			Store store2 = new Store(proxy2, reader2);
			store2.load();

			ColumnConfig descCol = new ColumnConfig("Description", "description", 120, true);
			descCol.setId("descCol");
			ColumnConfig[] columnConfigs2 = new ColumnConfig[]{
					new ColumnConfig("Name", "name", 120, true),
					descCol
			};

			final GridPanel gridPanel = new GridPanel();
			gridPanel.setColumnModel(new ColumnModel(columnConfigs2));
			gridPanel.setStore(store2);
			gridPanel.setHeight(100);
			gridPanel.setWidth(500);
			gridPanel.setAutoExpandColumn("descCol");
			gridPanel.setTitle("Credits");


			panel.add(gridPanel);
		}
		return panel;
	}


	private static Object[][] getCreditsData() {
		return new Object[][]{
				new Object[]{"Sponsor", "Thanks to <a href=\"http://www.videoprotein.com\" target=\"_blank\">VideoProtein</a> for sponsoring this effort."}
		};
	}
}