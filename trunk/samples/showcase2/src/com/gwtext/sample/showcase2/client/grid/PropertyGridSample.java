/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.grid;

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

            PropertyGridPanel grid = new PropertyGridPanel();
            grid.setId("props-grid");
            grid.setNameText("Properties Grid");
            grid.setWidth(300);
            grid.setAutoHeight(true);

            GridView view = new GridView();
            view.setForceFit(true);
            view.setScrollOffset(2); // the grid will never have scrollbars
            grid.setView(view);

            Map source = new HashMap();
            source.put("(name)", "Properties Grid");
            source.put("grouping", Boolean.FALSE);
            source.put("autoFitColumns", Boolean.TRUE);
            source.put("productionQuality", Boolean.FALSE);
            source.put("created", new Date());
            source.put("tested", Boolean.FALSE);
            source.put("version", new Float(0.1f));
            source.put("borderWidth", new Integer(1));

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