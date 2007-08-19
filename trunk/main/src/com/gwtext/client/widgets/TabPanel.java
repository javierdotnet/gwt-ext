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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.Ext;
import com.gwtext.client.widgets.event.TabPanelListener;

public class TabPanel extends BaseExtWidget {

    public TabPanel() {
        this(Ext.generateId());
    }

    public TabPanel(String id) {
        RootPanel.get().add(new HTML("<div id='" + id + "'></div>"));
        Element div = DOM.getElementById(id);

        jsObj = create(id);
        setElement(div);
    }

    public TabPanel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static TabPanel instance(JavaScriptObject jsObj) {
        return new TabPanel(jsObj);
    }

    private native JavaScriptObject create(String id) /*-{
        return new $wnd.Ext.TabPanel(id);
    }-*/;

    public native int getMaxTabWidth() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return tp.maxTabWidth;
    }-*/;

    public native void setMaxTabWidth(int maxWidth) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.maxTabWidth = maxWidth;
    }-*/;

    public native int getMinTabWidth() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return tp.minTabWidth;
    }-*/;

    public native void setMinTabWidth(int minTabWidth) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.minTabWidth = minTabWidth;
    }-*/;

    public native boolean getMonitorResize() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return tp.monitorResize;
    }-*/;

    public native boolean setMonitorResize(boolean monitorResize) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.monitorResize = monitorResize;
    }-*/;

    public native int getPreferredTabWidth() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return tp.preferredTabWidth;
    }-*/;

    public native int setPreferredTabWidth(int preferredTabWidth) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.preferredTabWidth = preferredTabWidth;
    }-*/;

    public native boolean isResizeTabs() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return tp.resizeTabs;
    }-*/;

    public native void setResizeTabs(boolean resieTabs) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.resizeTabs = resieTabs;
    }-*/;

    public native String getTabPosition() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return tp.tabPosition;
    }-*/;

    public native void setTabPosition(String tabPosition) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.tabPosition = tabPosition;
    }-*/;

    public native void activate(String tabID) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.activate(tabID);
    }-*/;

    public native void activate(int tabIndex) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.activate(tabIndex);
    }-*/;

    public TabPanelItem addTab(String label, boolean closable) {
        return addTab(Ext.generateId(), label, closable);
    }
    
    public TabPanelItem addTab(String id, String label, boolean closable) {
        return new TabPanelItem(createTabPanelItem(jsObj, id, label, closable));
    }

    private native JavaScriptObject createTabPanelItem(JavaScriptObject tabPanel, String id, String label, boolean closable) /*-{
         return tabPanel.addTab(id, label, "", closable);
    }-*/;

    public native void addTabItem(TabPanelItem tab) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var tabJS = tab.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.addTabItem(tabJS);
    }-*/;

    public native void autoSizeTabs() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.autoSizeTabs();
    }-*/;

    public native void beginUpdate() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.beginUpdate();
    }-*/;
        
    public native void destroy() /*-{
        var tb = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tb.destroy();
    }-*/;

    public native void destroy(boolean removeEL) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.destroy(removeEL);
    }-*/;

    public native void disableTab(String tabID) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.disableTab(tabID);
    }-*/;

    public native void disableTab(int tabIndex) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.disableTab(tabIndex);
    }-*/;

    public native void enableTab(String tabID) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.enableTab(tabID);
    }-*/;

    public native void enableTab(int tabIndex) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.enableTab(tabIndex);
    }-*/;

    public native void endUpdate() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.endUpdate();
    }-*/;
    
    public native TabPanelItem getActiveTab()/*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var activeTab = tp.getActiveTab();
        return activeTab ? @com.gwtext.client.widgets.TabPanelItem::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(activeTab):null;
    }-*/;

    public native int getCount() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return tp.getCount();
    }-*/;

    public native TabPanelItem getTab(String id)/*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var tab = tp.getTab(id);
        return tab ? @com.gwtext.client.widgets.TabPanelItem::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tab) : null;
    }-*/;

    public native TabPanelItem getTab(int tabIndex) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var tab = tp.getTab(tabIndex);
        return tab ? @com.gwtext.client.widgets.TabPanelItem::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tab) : null;
    }-*/;

    public native void hideTab(String tabID) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
       tp.hideTab(tabID);
    }-*/;

    public native void hideTab(int tabIndex) /*-{
       var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
       tp.hideTab(tabIndex);
    }-*/;

    public native void removeTab(String tabID) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.removeTab(tabID);
    }-*/;

    public native void removeTab(int tabIndex) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.removeTab(tabIndex);
    }-*/;

    public native void setTabWidth(int width) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.setTabWidth(width);
    }-*/;

    public native void syncHeight() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.syncHeight();
    }-*/;

    public native void syncHeight(int targetHeight) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.syncHeight(targetHeight);
    }-*/;

    public native void unhideTab(String tabID) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.unhideTab(tabID);
    }-*/;

    public native void unhideTab(int tabIndex) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.unhideTab(tabIndex);
    }-*/;

    public native void addTabPanelListener(TabPanelListener listener) /*-{
        var tabPanel = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var tabPanelJ = this;

        tabPanel.addListener('tabchange',
                function(tab, tpi) {
                    var tpiJ = @com.gwtext.client.widgets.TabPanelItem::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tpi);
                    listener.@com.gwtext.client.widgets.event.TabPanelListener::onTabChange(Lcom/gwtext/client/widgets/TabPanel;Lcom/gwtext/client/widgets/TabPanelItem;)(tabPanelJ, tpiJ);
                }
        );
        tabPanel.addListener('beforetabchange',
                function(tab, e, tpi) {
                    var tpiJ = @com.gwtext.client.widgets.TabPanelItem::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tpi);
                    e.cancel = !listener.@com.gwtext.client.widgets.event.TabPanelListener::doBeforeTabChange(Lcom/gwtext/client/widgets/TabPanel;Lcom/gwtext/client/widgets/TabPanelItem;)(tabPanelJ, tpiJ);
                }
        );
    }-*/;
}