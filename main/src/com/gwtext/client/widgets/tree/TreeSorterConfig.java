/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.tree;

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.core.SortDir;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Configuration class for {@link TreeSorter}.
 */
public class TreeSorterConfig extends BaseConfig {

    /**
     * True for case sensitive sort (defaults to false)
     *
     * @param caseSensitive true for case sensitive sort
     */
    public void setCaseSensitive(boolean caseSensitive) {
        JavaScriptObjectHelper.setAttribute(jsObj, "caseSensitive", caseSensitive);
    }

    /**
     * The direction to sort (asc or desc) (defaults to asc).
     *
     * @param dir the sort direction
     */
    public void setDir(SortDir dir) {
        JavaScriptObjectHelper.setAttribute(jsObj, "dir", dir.getDirection().toLowerCase());
    }

    /**
     * True to sort leaf nodes under non leaf nodes.
     *
     * @param folderSort true to sort leaf nodes under non leaf nodes.
     */
    public void setFolderSort(boolean folderSort) {
        JavaScriptObjectHelper.setAttribute(jsObj, "folderSort", folderSort);
    }

    /**
     * The attribute used to determine leaf nodes in folder sort (defaults to "leaf")
     *
     * @param leafAttr the leaf attribute
     */
    public void setLeafAttr(String leafAttr) {
        JavaScriptObjectHelper.setAttribute(jsObj, "leafAttr", leafAttr);
    }

    /**
     * The named attribute on the node to sort by (defaults to text).
     *
     * @param property the sort property
     */
    public void setProperty(String property) {
        JavaScriptObjectHelper.setAttribute(jsObj, "property", property);
    }

    /**
     * A custom function used to convert node values before sorting.
     *
     * @param sortType the sort function
     */
    public native void setSortType(TreeSortFunction sortType) /*-{
        var config = this.@com.gwtext.client.core.JsObject::getJsObj()();
        config['sortType'] = function(node) {
            var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
            return sortType.@com.gwtext.client.widgets.tree.TreeSortFunction::sortValue(Lcom/gwtext/client/widgets/tree/TreeNode;)(nodeJ);
        }
    }-*/;
}
