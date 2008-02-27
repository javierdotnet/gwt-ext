/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets;

/**
 * Container traversal callback interface.
 *
 * @see com.gwtext.client.widgets.Component#findParentBy(ContainerTraversalCallback)
 */
public interface ContainerTraversalCallback {

    /**
     * The callback method.
     *
     * @param container the parent container
     * @return false to stop traversal
     */
    boolean execute(Container container);
}