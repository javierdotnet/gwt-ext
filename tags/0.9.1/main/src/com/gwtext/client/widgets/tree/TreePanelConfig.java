/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package com.gwtext.client.widgets.tree;

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class TreePanelConfig extends BaseConfig {

    public void setAnimate(boolean animate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "animate", animate);
    }

    public void setContainerScroll(boolean containerScroll) {
        JavaScriptObjectHelper.setAttribute(jsObj, "containerScroll", containerScroll);
    }

    public void setDdAppendOnly(String ddAppendOnly) {
        JavaScriptObjectHelper.setAttribute(jsObj, "ddAppendOnly", ddAppendOnly);
    }

    public void setDdGroup(String ddGroup) {
        JavaScriptObjectHelper.setAttribute(jsObj, "ddGroup", ddGroup);
    }

    public void setDdScroll(boolean ddScroll) {
        JavaScriptObjectHelper.setAttribute(jsObj, "ddScroll", ddScroll);
    }

    //TODO
    //dragConfig

    //dropConfig

    public void setEnableDD(boolean enableDD) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableDD", enableDD);
    }

    public void setEnableDrag(boolean enableDrag) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableDrag", enableDrag);
    }

    public void setEnableDrop(boolean enableDrop) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableDrop", enableDrop);
    }

    public void setHlColor(String hlColor) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hlColor", hlColor);
    }

    public void setHlDrop(boolean hlDrop) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hlDrop", hlDrop);
    }

    public void setLines(boolean lines) {
        JavaScriptObjectHelper.setAttribute(jsObj, "lines", lines);
    }

    public void setLoader(boolean loader) {
        JavaScriptObjectHelper.setAttribute(jsObj, "loader", loader);
    }

    public void setRootVisible(boolean rootVisible) {
        JavaScriptObjectHelper.setAttribute(jsObj, "rootVisible", rootVisible);
    }

    public void setSelectionModel(TreeSelectionModel selectionModel) {
        JavaScriptObjectHelper.setAttribute(jsObj, "selModel", selectionModel.getJsObj());
    }

    public void setSingleExpand(boolean singleExpand) {
        JavaScriptObjectHelper.setAttribute(jsObj, "singleExpand", singleExpand);
    }
}
