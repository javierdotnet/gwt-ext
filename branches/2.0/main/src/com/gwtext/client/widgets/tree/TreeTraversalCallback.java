/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.tree;

/**
 * Tree traversal callback interface.
 *
 * @see TreeFilter#filterBy(TreeTraversalCallback)
 */
public interface TreeTraversalCallback {

    /**
     * Return true when criteria is met.
     *
     * @param node the node being traversed
     * @return true if criteria is met
     */
    boolean execute(TreeNode node);
}
