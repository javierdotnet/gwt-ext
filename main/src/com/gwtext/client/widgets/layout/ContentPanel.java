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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.UrlLoadCallback;
import com.gwtext.client.core.UpdateManager;
import com.gwtext.client.core.UpdateManagerConfig;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.layout.event.ContentPanelListener;

public class ContentPanel extends ComplexPanel {

    protected JavaScriptObject jsObj;

    protected ContentPanel() {
    }

    public ContentPanel(String id) {
        this(id, (ContentPanelConfig) null);
    }

    public ContentPanel(String id, final String title) {
        this(id, title, null);
    }

    public ContentPanel(String id, ContentPanelConfig config) {
        this(id, null, config);
    }

    public ContentPanel(String id, String title, ContentPanelConfig config) {
        if (config == null) {
            config = new ContentPanelConfig();
        }
        config.setAutoCreate(true);
        if(title != null) config.setTitle(title);

        Element div = DOM.createDiv();
        setElement(div);
        DOM.setElementProperty(div, "id", id);
        Element content = DOM.createDiv();
        String contentID = id + "-content";
        DOM.setElementProperty(content, "id", contentID);

        if (config.getCls() != null) {
            DOM.setElementProperty(content, "className", config.getCls());
        }
        DOM.appendChild(div, content);

        RootPanel.get().add(this);

        jsObj = create(id, config.getJsObj());
        //setElement(new ExtElement(jsObj).getDOM());
        if (config.getContentPanelListener() != null) {
            addContentPanelListener(config.getContentPanelListener());
        }

        Toolbar toolbar = config.getToolbar();
        if (toolbar != null) {
            DOM.insertChild(getElement(), toolbar.getElement(), 0);
        }
    }

    protected ContentPanel(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    public JavaScriptObject getJsObj() {
        return jsObj;
    }

    public void setJsObj(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    protected static native JavaScriptObject create(String id, JavaScriptObject config)/*-{
        return new $wnd.Ext.ContentPanel(id, config);
    }-*/;


    public void add(Widget w) {
        add(w, getElement());
    }

    public native void destroy() /*-{
        var contentPanel = this.@com.gwtext.client.widgets.layout.ContentPanel::jsObj;
        contentPanel.destroy();
    }-*/;


    public ExtElement getEl() {
        return new ExtElement(getEl(jsObj));
    }

    private static native JavaScriptObject getEl(JavaScriptObject contentPanel)/*-{
        return this.getEl();
    }-*/;

    public native String getId()/*-{
        var contenePanel = this.@com.gwtext.client.widgets.layout.ContentPanel::jsObj;
        return contenePanel.getId();
    }-*/;

    public native String getTitle()/*-{
        var contentPanel = this.@com.gwtext.client.widgets.layout.ContentPanel::jsObj;
        return contentPanel.getTitle();
    }-*/;

    public Toolbar getToolbar() {
        JavaScriptObject toolbar = getToolbar(jsObj);
        return toolbar == null ? null : new Toolbar(toolbar);
    }

    private static native JavaScriptObject getToolbar(JavaScriptObject contentPanel) /*-{
        return contentPanel.getToolbar();
    }-*/;

    public UpdateManager getUpdateManager() {
        return new UpdateManager(getUpdateManager(jsObj));
    }

    private static native JavaScriptObject getUpdateManager(JavaScriptObject contentPanel)/*-{
        return contentPanel.getUpdateManager();
    }-*/;

    public native boolean isClosable() /*-{
        var contentPanel = this.@com.gwtext.client.widgets.layout.ContentPanel::jsObj;
        return contentPanel.isClosable();
    }-*/;

    public void load(String url, UpdateManagerConfig params, UrlLoadCallback callback, boolean discardUrl) {
        load(jsObj, url, params.getJsObj(), callback, discardUrl);
    }

    private static native void load(JavaScriptObject contentPanel, String url, JavaScriptObject params, UrlLoadCallback callback, boolean discardUrl)/*-{
        var cb;
        if(callback != null) {
            cb = function(options, success, response) {
                callback.@com.gwtext.client.core.UrlLoadCallback::execute(ZLjava/lang/String;)(success, response.responseText);
            }
        }
        contentPanel.load(url, params, cb, discardUrl);
    }-*/;

    public native void refresh()/*-{
        var contentPanel = this.@com.gwtext.client.widgets.layout.ContentPanel::jsObj;
        contentPanel.refresh();
    }-*/;

/*    public native void setContent(String content, boolean loadScripts)*//*-{
        var contentPanel = this.@com.gwtext.client.widgets.layout.ContentPanel::jsObj;
        contentPanel.setContent(content, loadScripts);
    }-*//*;*/

    //add in separate div so that clean contents on clears divs contents and preserves the toolbar
    public void setContent(String content) {
        //Element contentElem = DOM.getElementById(getId() + "-content");
        //DOM.setInnerHTML(contentElem, content);
        ExtElement el = ExtElement.get(getId() + "-content");
        el.update(content, false);
    }

    public void setContent(String content, boolean loadScripts) {
        ExtElement el = ExtElement.get(getId() + "-content");
        el.update(content, loadScripts);
    }

    public native void setTitle(String title)/*-{
        var contentPanel = this.@com.gwtext.client.widgets.layout.ContentPanel::jsObj;
        contentPanel.setTitle(title);
    }-*/;

    public void setUrl(String url, UpdateManagerConfig params, boolean loadOnce) {
        setUrl(jsObj, url, params.getJsObj(), loadOnce);
    }

    private static native void setUrl(JavaScriptObject contentPanel, String url, JavaScriptObject params, boolean loadOnce) /*-{
        contentPanel.setUrl(url, params, loadOnce);
    }-*/;

    public native void addContentPanelListener(ContentPanelListener listener) /*-{
        var contentPanel = this.@com.gwtext.client.widgets.layout.ContentPanel::jsObj;
        var contentPanelJ = this;

        contentPanel.addListener('activate',
            function(source) {
                listener.@com.gwtext.client.widgets.layout.event.ContentPanelListener::onActivate(Lcom/gwtext/client/widgets/layout/ContentPanel;)(contentPanelJ);
            }
        );

        contentPanel.addListener('deactivate',
            function(source) {
                listener.@com.gwtext.client.widgets.layout.event.ContentPanelListener::onDeactivate(Lcom/gwtext/client/widgets/layout/ContentPanel;)(contentPanelJ);
            }
        );

        contentPanel.addListener('resize',
            function(source, width, height) {
                listener.@com.gwtext.client.widgets.layout.event.ContentPanelListener::onResize(Lcom/gwtext/client/widgets/layout/ContentPanel;II)(contentPanelJ, width, height);
            }
        );
    }-*/;
}
