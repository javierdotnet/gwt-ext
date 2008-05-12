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
 
package com.gwtext.sample.showcase2.client.combo;

import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class ComboBoxCompactSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/combo/ComboBoxCompactSample.java.html";
    }

    public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();

			final Store store = new SimpleStore(new String[]{"abbr", "states"}, SampleData.getStates());
            store.load();
            
            ComboBox cb = new ComboBox();
			cb.setMinChars(1);
			cb.setFieldLabel("State");
			cb.setStore(store);
			cb.setDisplayField("states");
			cb.setMode(ComboBox.LOCAL);
			cb.setEmptyText("Enter State");
			cb.setLoadingText("Searching...");
			cb.setTypeAhead(true);
			cb.setSelectOnFocus(true);
			cb.setWidth(200);
			//do not show drop fown icon
			cb.setHideTrigger(true);

			FormPanel form = new FormPanel();
			form.setLabelWidth(35);
			form.setBorder(false);
            form.add(cb);

            panel.add(form);
		}
		return panel;
	}

	public String getIntro() {
		return "<p>This is an example of a compact ComboBox where there is no drop down icon. This is done by calling setHideTrigger(true) on the ComboBox.</p>" +
				"<p>As the user types in the ComboBox field, the ComboBox options are displayed.</p>";
	}
}