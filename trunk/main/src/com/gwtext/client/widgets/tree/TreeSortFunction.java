/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.tree;

/**
 * The sort function interface when calling {@link TreeSorterConfig#setSortType(TreeSortFunction)}.
 */
public interface TreeSortFunction {

    /**
     * A custom "casting" function used to convert node values before sorting.
     *
     * @param node the tree node
     * @return thre tree node sort value
     */
    String sortValue(TreeNode node);
}
