/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.data;

/**
 * The node traversal callback itnerface used by several Node methods.
 *
 * @see Node#cascade(NodeTraversalCallback)
 * @see Node#bubble(NodeTraversalCallback)
 * @see Node#findChildBy(NodeTraversalCallback)
 */
public interface NodeTraversalCallback {

    /**
     * The callback method.
     *
     * @param node the node beign traversed upon.
     * @return boolean value
     */
    boolean execute(Node node);
}
