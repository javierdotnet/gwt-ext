/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets;

/**
 * Component traversal callback interface.
 *
 * @see Container#bubble(ComponentTraversalCallback)
 * @see Container#cascade(ComponentTraversalCallback)
 */
public interface ComponentTraversalCallback {

    /**
     * The callback method.
     * 
     * @param component the component being traversed
     * @return false to stop traversal
     */
    boolean execute(Component component);
}
