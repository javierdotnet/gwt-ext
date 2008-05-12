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

import com.gwtext.client.core.NameValuePair;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.TimeField;
import com.gwtext.client.widgets.grid.GridEditor;
import com.gwtext.client.widgets.grid.GridView;
import com.gwtext.client.widgets.grid.PropertyGridPanel;
import com.gwtext.client.widgets.grid.event.PropertyGridPanelListener;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PropertyGridSample extends ShowcasePanel {

   public String getSourceUrl() {
        return "source/grid/PropertyGridSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            final PropertyGridPanel grid = new PropertyGridPanel();
            grid.setId("props-grid");
            grid.setNameText("Properties Grid");
            grid.setWidth(300);
            grid.setAutoHeight(true);
			grid.setSorted(false);

			GridView view = new GridView();
            view.setForceFit(true);
            view.setScrollOffset(2); // the grid will never have scrollbars
            grid.setView(view);

			NameValuePair[] source = new NameValuePair[9];
			source[0] = new NameValuePair("(name)", "Properties Grid");
			source[1] = new NameValuePair("grouping", Boolean.FALSE);
			source[2] = new NameValuePair("autoFitColumns", Boolean.TRUE);
			source[3] = new NameValuePair("productionQuality", Boolean.FALSE);
			source[4] = new NameValuePair("created", new Date());
			source[5] = new NameValuePair("Edit Time", new Date());
			source[6] = new NameValuePair("tested", Boolean.FALSE);
			source[7] = new NameValuePair("version", new Float(0.1f));
			source[8] = new NameValuePair("borderWidth", new Integer(1));

			Map customEditors = new HashMap();
            GridEditor timeEditor = new GridEditor(new TimeField());

            customEditors.put("Edit Time", timeEditor);
            grid.setCustomEditors(customEditors);

            grid.setSource(source);

            grid.addPropertyGridPanelListener(new PropertyGridPanelListener() {
                public boolean doBeforePropertyChange(PropertyGridPanel source, String recordID, Object value, Object oldValue) {
                    return true;
                }

                public void onPropertyChange(PropertyGridPanel source, String recordID, Object value, Object oldValue) {
                    log(EVENT, Format.format("Property '{0}' changed from {1} to {2}.", recordID, String.valueOf(oldValue), String.valueOf(value)));
                }
            });

			panel.add(grid);

        }
        return panel;
    }

    protected boolean showEvents() {
        return true;
    }

    public String getIntro() {
        return "<p>This is an example of a PropertyGrid which is a specialized grid implementation intended to mimic the " +
                "traditional property grid as typically seen in development IDEs.</p>" +
                " <p>Each row in the grid represents a property of some object, and the data is stored as a set of name/value pairs.</p>";
    }
}