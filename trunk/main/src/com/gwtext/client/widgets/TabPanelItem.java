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

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.UpdateManager;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.widgets.event.TabPanelItemListener;

public class TabPanelItem extends BaseExtWidget {

    public TabPanelItem(JavaScriptObject tabPanelItem) {
        super(tabPanelItem);
    }

    public static TabPanelItem instance(JavaScriptObject jsObj) {
        return new TabPanelItem(jsObj);
    }

    private native JavaScriptObject getEl(JavaScriptObject jsObj) /*-{
        return jsObj.el;
    }-*/;

    private native void setBodyEl(ExtElement elem) /*-{
        var tpi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var elemJS = elem.@com.gwtext.client.core.JsObject::jsObj;
        tpi.bodyEl = elemJS;
    }-*/;

    public ExtElement getBodyEl() {
        return new ExtElement(getBodyEl(jsObj));
    }

    private native JavaScriptObject getBodyEl(JavaScriptObject tpi) /*-{
        return tpi.bodyEl;
    }-*/;

    public native String getCloseText() /*-{
        var tpi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return tpi.closeText;
    }-*/;

    public native void setCloseText(String closeText) /*-{
        var tpi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tpi.closeText = closeText;
    }-*/;

    public native String getId() /*-{
        var tpi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return tpi.id;
    }-*/;

    public native void setId(String id) /*-{
        var tpi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tpi.id = id;
    }-*/;

    public TabPanel getTabPanel() {
        return new TabPanel(getTabPanel(jsObj));
    }

    private native JavaScriptObject getTabPanel(JavaScriptObject tpi) /*-{
        return tpi.tabPanel;
    }-*/;

    public native void activate() /*-{
        var tpi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tpi.activate();
    }-*/;

    public native void disable() /*-{
        var tpi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tpi.disable();
    }-*/;

    public native void enable() /*-{
        var tpi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tpi.enable();
    }-*/;

    public native String getText() /*-{
        var tpi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return tpi.getText();
    }-*/;


    public UpdateManager getUpdateManager() {
        return new UpdateManager(getUpdateManager(jsObj));
    }

    private native JavaScriptObject getUpdateManager(JavaScriptObject tpi) /*-{
        return tpi.getUpdateManager();
    }-*/;

    public native void hide() /*-{
        var tpi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tpi.hide();
    }-*/;

    public native boolean isActive() /*-{
        var tpi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return tpi.isActive();
    }-*/;

    public native boolean isHidden() /*-{
        var tpi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return tpi.isHidden();
    }-*/;

    public native void refresh() /*-{
        var tpi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tpi.refresh();
    }-*/;

    public native void setContent(String content, boolean loadScripts) /*-{
        var tpi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tpi.setContent(content, loadScripts);
    }-*/;

    public void setContent(Panel panel) {
        //important : got to make sure that the panel is attached to the browser dom using GWT mechinaishms so that
        // panels chils alos get attached to browser dom and subsequently the gwt event wiring takes place via
        // ->onload -> onattach-> DOM.setEventListener
        RootPanel.get().add(panel);        
        getBodyEl().appendChild(panel.getElement());
    }

    public native void setText(String text) /*-{
        var tpi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tpi.setText(text);
    }-*/;

    public native void setTooltip(String text) /*-{
        var tpi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tpi.setTooltip(text);
    }-*/;

    //todo - alt version of params
    public native void setUrl(String url, String params, boolean loadOnce) /*-{
        var tpi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tpi.setUrl(url, params, loadOnce);
    }-*/;

    public native void show() /*-{
        var tpi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tpi.show();
    }-*/;


    public native void addTabPanelItemListener(TabPanelItemListener listener) /*-{
        var tabPanelItem = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var tabPanelItemJ = this;

        tabPanelItem.addListener('activate',
                function(tab, tpi) {
                    listener.@com.gwtext.client.widgets.event.TabPanelItemListener::onActivate(Lcom/gwtext/client/widgets/TabPanelItem;)(tabPanelItemJ);
                }
        );
        tabPanelItem.addListener('beforeclose',
                function(tab) {
                    var tabJ = @com.gwtext.client.widgets.TabPanel::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tab);
                    return listener.@com.gwtext.client.widgets.event.TabPanelItemListener::doBeforeClose(Lcom/gwtext/client/widgets/TabPanel;)(tabJ);
                }
        );
        tabPanelItem.addListener('close',
                function(tpi) {
                    listener.@com.gwtext.client.widgets.event.TabPanelItemListener::onClose(Lcom/gwtext/client/widgets/TabPanelItem;)(tabPanelItemJ);
                }
        );
        tabPanelItem.addListener('deactivate',
                function(tab, tpi) {
                    listener.@com.gwtext.client.widgets.event.TabPanelItemListener::onDeactivate(Lcom/gwtext/client/widgets/TabPanelItem;)(tabPanelItemJ);
                }
        );

    }-*/;
}
