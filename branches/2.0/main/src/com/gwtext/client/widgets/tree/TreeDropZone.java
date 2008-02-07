/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.dd.DropZone;

/**
 * A TreePanel DropZone.
 */
public class TreeDropZone extends DropZone {

    public TreeDropZone(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static TreeDropZone instance(JavaScriptObject jsObj) {
        return new TreeDropZone(jsObj);
    }
}
