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

package com.gwtext.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * @author Sanjiv Jivan
 */
public class GroupingView extends GridView {

    public GroupingView() {
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        var gridJ = this;
        var gridV = new $wnd.Ext.grid.GroupingView(config);
        gridV.getRowClass = function(record, index, rp, store) {
            var recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var rpJ = @com.gwtext.client.widgets.grid.RowParams::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(rp);
			var storeJ = @com.gwtext.client.data.Store::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(store);
			return gridJ.@com.gwtext.client.widgets.grid.GridView::getRowClass(Lcom/gwtext/client/data/Record;ILcom/gwtext/client/widgets/grid/RowParams;Lcom/gwtext/client/data/Store;)(recordJ, index, rpJ, storeJ);
        }
        return gridV;
    }-*/;

    //config
    public void setEmptyGroupText(String emptyGroupText) {
        JavaScriptObjectHelper.setAttribute(configJS, "emptyGroupText", emptyGroupText);
    }

    public void setEnableGrouping(boolean enableGrouping) {
        JavaScriptObjectHelper.setAttribute(configJS, "enableGrouping", enableGrouping);
    }

    public void setEnableGroupingMenu(boolean enableGroupingMenu) {
        JavaScriptObjectHelper.setAttribute(configJS, "enableGroupingMenu", enableGroupingMenu);
    }

    public void setEnableNoGroups(boolean enableNoGroups) {
        JavaScriptObjectHelper.setAttribute(configJS, "enableNoGroups", enableNoGroups);
    }

    public void setGroupByText(String groupByText) {
        JavaScriptObjectHelper.setAttribute(configJS, "groupByText", groupByText);
    }

    public void setGroupTextTpl(String groupTextTpl) {
        JavaScriptObjectHelper.setAttribute(configJS, "groupTextTpl", groupTextTpl);
    }

    public void setHideGroupedColumn(boolean hideGroupedColumn) {
        JavaScriptObjectHelper.setAttribute(configJS, "hideGroupedColumn", hideGroupedColumn);
    }

    public void setIgnoreAdd(boolean ignoreAdd) {
        JavaScriptObjectHelper.setAttribute(configJS, "ignoreAdd", ignoreAdd);
    }

    public void setShowGroupName(boolean showGroupName) {
        JavaScriptObjectHelper.setAttribute(configJS, "showGroupName", showGroupName);
    }

    public void setShowGroupsText(boolean showGroupsText) {
        JavaScriptObjectHelper.setAttribute(configJS, "showGroupsText", showGroupsText);
    }

    public void setStartCollapsed(boolean startCollapsed) {
        JavaScriptObjectHelper.setAttribute(configJS, "startCollapsed", startCollapsed);
    }
}
