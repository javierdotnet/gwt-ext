/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.tree;

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class TreeFilterConfig extends BaseConfig {

    /**
     * If set to true and the filter value is blank, then clear the filter. Defaults to false.
     *
     * @param clearBlank true to clear filter when blank
     */
    public void setClearBlank(boolean clearBlank) {
        JavaScriptObjectHelper.setAttribute(jsObj, "clearBlank", clearBlank);
    }

    /**
     * If set to true and {@link com.gwtext.client.widgets.tree.TreeFilter#filterBy(TreeTraversalCallback)} is called, then the
     * filter based on the return value of the of the callback is reversed. Default is false.
     *
     * @param reverse true to reverse filter values
     */
    public void setReverse(boolean reverse) {
        JavaScriptObjectHelper.setAttribute(jsObj, "reverse", reverse);
    }

    public void setAutoClear(boolean autoClear) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoClear", autoClear);
    }

    /**
     * If set to true, the nodes are removed from the tree on filter. Defaults to false.
     *
     * @param remove true to remove nodes
     */
    public void setRemove(boolean remove) {
        JavaScriptObjectHelper.setAttribute(jsObj, "remove", remove);
    }
}
