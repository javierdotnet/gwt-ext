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
 
package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;

/**
 * Helper class to enable tree node sorting functionality.
 *
 * @author Sanjiv Jivan
 */
public class TreeSorter extends JsObject {

    /**
     * Construct a new TreeSorter.
     *
     * @param treePanel the tree panel to sort
     * @param config the TreeSorter config
     */
    public TreeSorter(TreePanel treePanel, TreeSorterConfig config) {
       jsObj = create(treePanel.getOrCreateJsObj(), config == null ? null : config.getJsObj());
    }

    private native JavaScriptObject create(JavaScriptObject treePanel, JavaScriptObject config) /*-{
        return new $wnd.Ext.tree.TreeSorter(treePanel, config);
    }-*/;

    //http://extjs.com/forum/showthread.php?t=6795
    /**
     * Sort the TreePanel starting from the specified node.
     *
     * @param startNode the start node
     */
    public native void sort(TreeNode startNode) /*-{
        var sorter = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var startNodeJ = startNode.@com.gwtext.client.core.JsObject::getJsObj()();
        sorter.doSort(startNodeJ);
    }-*/;
}
