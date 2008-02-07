/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 *
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.data.Record;
import com.gwtext.client.dd.DragData;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.grid.GridPanel;

/**
 * An implementation of DragData that is passed to the drop target when the source is a Panel.
 *
 */
public class PanelDragData extends DragData {

    public PanelDragData(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * The source Panel.
     *
     * @return the source Panel
     */
    public Panel getPanel() {
        JavaScriptObject gridJS = getPropertyAsJavaScriptObject("panel");
        return (Panel) ComponentFactory.getComponent(gridJS);
    }

}