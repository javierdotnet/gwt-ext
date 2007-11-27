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
import com.gwtext.client.core.*;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.layout.event.ContentPanelListener;

public class ContentPanel extends ComplexPanel {

    protected JavaScriptObject jsObj;

    public ContentPanel() {
        this(null, (String) null);
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
        JavaScriptObjectHelper.setAttribute(config.getJsObj(), "autoCreate", true);
        if (title != null) config.setTitle(title);

        //TODO handle attaching ContentPanel to existing elements
        Element div = DOM.createDiv();
        setElement(div);
        if (id == null) id = Ext.generateId();
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

        if (config.getContentPanelListener() != null) {
            addContentPanelListener(config.getContentPanelListener());
        }

        Toolbar toolbar = config.getToolbar();
        if (toolbar != null) {
            DOM.insertChild(getElement(), toolbar.getElement(), 0);
        }
    }

    public native void purgeListeners() /*-{
        var cp = this.@com.gwtext.client.widgets.layout.ContentPanel::jsObj;
        cp.purgeListeners();
    }-*/;

    /*
       Supports attaching ContentPanel to existing element. Existing element "becomes" this ContentPanel.
       Frame frame = new Frame(sourceUrl);
       frame.setHeight("100%");
       frame.setWidth("100%");
       RootPanel.get().add(frame);
       ContentPanel cp = new ContentPanel(frame, "Source", new ContentPanelConfig() {
           {
               setFitToFrame(true);
           }
       });
    */
    public ContentPanel(Widget container, String title, ContentPanelConfig config) {
        if (config == null) {
            config = new ContentPanelConfig();
        }
        JavaScriptObjectHelper.setAttribute(config.getJsObj(), "autoCreate", true);
        if (title != null) config.setTitle(title);

        jsObj = create(container.getElement(), config.getJsObj());
        setElement(getElement(jsObj));

        if (config.getContentPanelListener() != null) {
            addContentPanelListener(config.getContentPanelListener());
        }

        Toolbar toolbar = config.getToolbar();
        if (toolbar != null) {
            DOM.insertChild(getElement(), toolbar.getElement(), 0);
        }
    }

    private native Element getElement(JavaScriptObject jsObj) /*-{
        var el = jsObj.el;
        if(el === undefined) {
            return null;
        } else {
             return el.dom;
        }
    }-*/;

    protected ContentPanel(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    public static ContentPanel instance(JavaScriptObject jsObj) {
        return new ContentPanel(jsObj);
    }

    public JavaScriptObject getJsObj() {
        return jsObj;
    }

    public void setJsObj(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    protected static native JavaScriptObject create(Element container, JavaScriptObject config)/*-{
        return new $wnd.Ext.ContentPanel(container, config);
    }-*/;

    protected static native JavaScriptObject create(String id, JavaScriptObject config)/*-{
        return new $wnd.Ext.ContentPanel(id, config);
    }-*/;

    public void add(Widget w) {
		add(w, DOM.getFirstChild(getElement()));
    }

    public native void destroy() /*-{
        var contentPanel = this.@com.gwtext.client.widgets.layout.ContentPanel::jsObj;
        contentPanel.destroy();
    }-*/;

    public ExtElement getEl() {
        return new ExtElement(getEl(jsObj));
    }

    private static native JavaScriptObject getEl(JavaScriptObject contentPanel)/*-{
        return contentPanel.getEl();
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
        var tb = contentPanel.getToolbar();
        return tb == null || tb === undefined ? null : tb;
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
        params.setUrl(url);
        load(jsObj, params.getJsObj(), callback, discardUrl);
    }

    private static native void load(JavaScriptObject contentPanel, JavaScriptObject params, UrlLoadCallback callback, boolean discardUrl)/*-{
        var cb;
        if(callback != null) {
            cb = function(options, success, response) {
                callback.@com.gwtext.client.core.UrlLoadCallback::execute(ZILjava/lang/String;)(success, response.status, response.responseText);
            }
        }
        contentPanel.load(params, null, cb, discardUrl);
    }-*/;

    public native void refresh()/*-{
        var contentPanel = this.@com.gwtext.client.widgets.layout.ContentPanel::jsObj;
        contentPanel.refresh();
    }-*/;

    //add in separate div so that clean contents on clears divs contents and preserves the toolbar
    public void setContent(String content) {
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
        setUrl(jsObj, url, params == null ? null : params.getJsObj(), loadOnce);
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
