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

import com.gwtext.client.data.Node;
import com.gwtext.client.data.NodeConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.QuickTipsConfig;

public class TreeNodeConfig extends NodeConfig {

    public void setAllowDrag(boolean allowDrag) {
        JavaScriptObjectHelper.setAttribute(jsObj, "allowDrag", allowDrag);
    }

    public void setAllowDrop(boolean allowDrop) {
        JavaScriptObjectHelper.setAttribute(jsObj, "allowDrop", allowDrop);
    }

    public void setCls(String cls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "cls", cls);
    }

    public void setDisabled(boolean disabled) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disabled", disabled);
    }

    public void setExpanded(boolean expanded) {
        JavaScriptObjectHelper.setAttribute(jsObj, "expanded", expanded);
    }

    public void setHref(String href) {
        JavaScriptObjectHelper.setAttribute(jsObj, "href", href);
    }

    public void setHrefTarget(String hrefTarget) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hrefTarget", hrefTarget);
    }

    public void setIcon(String icon) {
        JavaScriptObjectHelper.setAttribute(jsObj, "icon", icon);
    }

    public void setIconCls(String iconCls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "iconCls", iconCls);
    }

    public void setLeaf(Node leaf) {
        JavaScriptObjectHelper.setAttribute(jsObj, "leaf", leaf.getJsObj());
    }

    public void setQtip(String qtip) {
        JavaScriptObjectHelper.setAttribute(jsObj, "qtip", qtip);
    }

    public void setQtipCfg(QuickTipsConfig qtipCfg) {
        JavaScriptObjectHelper.setAttribute(jsObj, "qtipCfg", qtipCfg.getJsObj());
    }    

    public void setSingleClickExpand(boolean singleClickExpand) {
        JavaScriptObjectHelper.setAttribute(jsObj, "singleClickExpand", singleClickExpand);
    }

    public void setText(String text) {
        JavaScriptObjectHelper.setAttribute(jsObj, "text", text);
    }

    //http://extjs.com/forum/showthread.php?t=4460&highlight=uiProvider
    //TODO
    //uiProvider

}
