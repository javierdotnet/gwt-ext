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

package com.gwtext.client.widgets.grid;

import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.core.BaseConfig;

public class ColumnConfig extends BaseConfig {

    public void setAlign(String align) {
        JavaScriptObjectHelper.setAttribute(jsObj, "align", align);
    }

    //id assigned so we can apply custom css (e.g. .x-grid-col-topic b { color:#333 })
    //assigning id to columnconfig results in the column dom element having that id
    //todo not documented by ext
    public void setId(String id) {
        JavaScriptObjectHelper.setAttribute(jsObj, "id", id);
    }

    public void setDataIndex(String dataIndex) {
        JavaScriptObjectHelper.setAttribute(jsObj, "dataIndex", dataIndex);
    }

    //todo missing from ext doc
    public void setCss(String css) {
        JavaScriptObjectHelper.setAttribute(jsObj, "css", css);
    }

    public void setHeader(String header) {
        JavaScriptObjectHelper.setAttribute(jsObj, "header", header);
    }

    public void setHidden(boolean hidden) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hidden", hidden);
    }

    public void setLocked(boolean locked) {
        JavaScriptObjectHelper.setAttribute(jsObj, "locked", locked);
    }

    public native void setRenderer(Renderer renderer) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['renderer'] = function(s, p, r, rowIndex, colNum, ds) {
            var str = s.toString();
            var rec = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
            return renderer.@com.gwtext.client.widgets.grid.Renderer::render(Ljava/lang/String;Lcom/gwtext/client/data/Record;II)(str, rec, rowIndex, colNum);
        }
    }-*/;

    public void setResizable(boolean resizable) {
        JavaScriptObjectHelper.setAttribute(jsObj, "resizable", resizable);
    }

    //todo see possible format strings in Ext.util.Format
    public void setRenderer(String renderer) {
        JavaScriptObjectHelper.setAttribute(jsObj, "renderer", renderer);
    }

    public void setSortable(boolean sortable) {
        JavaScriptObjectHelper.setAttribute(jsObj, "sortable", sortable);
    }

   public void setWidth(int width) {
        JavaScriptObjectHelper.setAttribute(jsObj, "width", width);
    }

    public void setEditor(GridEditor editor) {
        JavaScriptObjectHelper.setAttribute(jsObj, "editor", editor.getJsObj());
    }

}
