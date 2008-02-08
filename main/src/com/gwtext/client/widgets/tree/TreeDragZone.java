/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.dd.DragZone;

/**
 * A TreePanel drag zone.
 *
 */
public class TreeDragZone extends DragZone {

    public TreeDragZone(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static TreeDragZone instance(JavaScriptObject jsObj) {
        return new TreeDragZone(jsObj);
    }
}
