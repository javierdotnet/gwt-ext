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

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.client.data.*;
import com.gwtext.sample.showcase2.client.SampleGrid;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class CreditsPanel extends ShowcasePanel {


	public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();

			ColumnConfig descCol = new ColumnConfig("Description", "description", 40, true);

			descCol.setId("descCol");

			ColumnConfig[] columnConfigs = new ColumnConfig[] {
					new ColumnConfig("Name", "name", 120, true),
					descCol
			};

			RecordDef recordDef = new RecordDef(new FieldDef[] {
					new StringFieldDef("name"),
					new StringFieldDef("description")
			});

			ArrayReader reader = new ArrayReader(recordDef);
			MemoryProxy proxy = new MemoryProxy(getData());

			Store store = new Store(proxy, reader);
			store.load();

			final GridPanel grid = new GridPanel();
			grid.setColumnModel(new ColumnModel(columnConfigs));
			grid.setStore(store);
			grid.setHeight(200);
			grid.setWidth(600);
			grid.setTitle("Credits");
			grid.setAutoExpandColumn("descCol");

			panel.add(grid);
		}
		return panel;
	}

	private static Object[][] getData() {
		return new Object[][] {
				new Object[] {"Ext JS Samples", "Many of the samples in this showcase are adapted from the <a href=\"http://extjs.com/deploy/dev/examples/\" target=\"_blank\">ExtJS samples</a>"},
				new Object[] {"Silk Icons", "The icons used in this Showcase are from <a href=\"http://www.famfamfam.com\" target=\"_blank\">famfamfam.com</a>"},
				new Object[] {"Green Theme", "Author : Charles Dietrich. Site <a href=\"http://code.google.com/p/tobydietrichlibs/\" target=\"_blank\">here</a>"},
				new Object[] {"Slate Theme", "Author : J.C. Bize. Site <a href=\"http://extjs.com/learn/Extension:SlateTheme/\" target=\"_blank\">here</a>"},
				new Object[] {"Indigo Theme", "Author : elyxr. Site <a href=\"http://extjs.com/forum/showthread.php?t=26294/\" target=\"_blank\">here</a>"},
				new Object[] {"Silver cherry Theme", "Author : elyxr. Site <a href=\"http://extjs.com/forum/showthread.php?t=26294/\" target=\"_blank\">here</a>"}
		};
	}
}