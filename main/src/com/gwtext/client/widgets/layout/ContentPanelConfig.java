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

package com.gwtext.client.widgets.layout;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.layout.event.ContentPanelListener;

public class ContentPanelConfig extends BaseConfig {

    private ContentPanelListener contentPanelListener;
    private Toolbar toolbar;
    private String cls;

    public ContentPanelConfig() {
        jsObj = JavaScriptObjectHelper.createObject();
    }

    public void setAdjustments(int widthAdjustment, int heightAdjustment) {
        int[] adjustments = new int[]{widthAdjustment, heightAdjustment};
        JavaScriptObjectHelper.setAttribute(jsObj, "adjustments", adjustments);
    }

    public void setAutoCreate(boolean autoCreate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoCreate", autoCreate);
    }

    public void setAutoScroll(boolean autoScroll) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoScroll", autoScroll);
    }

    public void setBackground(boolean background) {
        JavaScriptObjectHelper.setAttribute(jsObj, "background", background);
    }

    public void setClosable(boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "closable", value);
    }

    //TODO not supported in Ext 1.1 but in Ext 2.x. added local functionality
    public void setCls(String cls) {
        this.cls = cls;
    }

    String getCls() {
        return cls;
    }

    public void setFitToContainer(boolean fitToContainer) {
        JavaScriptObjectHelper.setAttribute(jsObj, "fitToContainer", fitToContainer);
    }

    public void setFitToFrame(boolean fitToFrame) {
        JavaScriptObjectHelper.setAttribute(jsObj, "fitToFrame", fitToFrame);
    }

    public void setParams(String params) {
        JavaScriptObjectHelper.setAttribute(jsObj, "params", params);
    }

    public void setParams(UrlParam[] params) {
        JavaScriptObject paramObj = UrlParam.getJsObj(params);
        JavaScriptObjectHelper.setAttribute(jsObj, "params", paramObj);
    }

    public void setResizeEl(String id) {
        JavaScriptObjectHelper.setAttribute(jsObj, "id", id);
    }

    public void setTitle(String value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "title", value);
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
        JavaScriptObjectHelper.setAttribute(jsObj, "toolbar", toolbar.getJsObj());
    }

    Toolbar getToolbar() {
        return toolbar;
    }

    public void setUrl(String url, boolean loadOnce) {
        JavaScriptObjectHelper.setAttribute(jsObj, "url", url);
        JavaScriptObjectHelper.setAttribute(jsObj, "loadOnce", loadOnce);
    }

    public ContentPanelListener getContentPanelListener() {
        return contentPanelListener;
    }

    public void setContentPanelListener(ContentPanelListener contentPanelListener) {
        this.contentPanelListener = contentPanelListener;
    }
}
