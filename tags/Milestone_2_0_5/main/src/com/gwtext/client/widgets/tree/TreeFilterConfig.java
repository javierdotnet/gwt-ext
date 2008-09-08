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

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 *
 * @author Sanjiv Jivan
 */
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
