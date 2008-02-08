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

/**
 * A lightweight tab container.
 */
public class TabPanel extends BaseExtWidget {

    /**
     * Creates a tab panel on top.
     */
    public TabPanel() {
        this(Ext.generateId());
    }

    /**
     * Creates a tab panel.
     *
     * @param bottom true to create tabs on bottom
     */
    public TabPanel(boolean bottom) {
        this(Ext.generateId(), bottom);
    }

   /**
    * Creates a tab panel on top.
    *
    * @param id tab panel id
    */
    public TabPanel(String id) {
        this(id, false);
    }

   /**
    * Creates a tab panel.
    *
    * @param id tab panel id
    * @param bottom true to create tabs at bottom
    */
    public TabPanel(String id, boolean bottom) {
        RootPanel.get().add(new HTML("<div id='" + id + "'></div>"));
        Element div = DOM.getElementById(id);

        jsObj = create(id, bottom);
        setElement(div);
    }

    public TabPanel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static TabPanel instance(JavaScriptObject jsObj) {
        return new TabPanel(jsObj);
    }

    private native JavaScriptObject create(String id, boolean bottom) /*-{
        return new $wnd.Ext.TabPanel(id, bottom);
    }-*/;

    /**
     * Return the max tab width.
     *
     * @return the max tab width
     */
    public native int getMaxTabWidth() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return tp.maxTabWidth;
    }-*/;

    /**
     * Set the max tab width
     *
     * @param maxWidth the max tab width
     */
    public native void setMaxTabWidth(int maxWidth) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.maxTabWidth = maxWidth;
    }-*/;

    /**
     * Return the min tab width.
     *
     * @return the min tab width
     */
    public native int getMinTabWidth() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return tp.minTabWidth;
    }-*/;

    /**
     * Set the min tab width.
     *
     * @param minTabWidth the min tab width
     */
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

    /**
     * Return the preferred tab width.
     *
     * @return the preferred tab width
     */
    public native int getPreferredTabWidth() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return tp.preferredTabWidth;
    }-*/;

    /**
     *
     * Set the preferred tab width.
     *
     * @param preferredTabWidth the preferred tab width
     */
    public native void setPreferredTabWidth(int preferredTabWidth) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.preferredTabWidth = preferredTabWidth;
    }-*/;

    public native boolean isResizeTabs() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return tp.resizeTabs;
    }-*/;

    public native void setResizeTabs(boolean resizeTabs) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.resizeTabs = resizeTabs;
    }-*/;

    public native String getTabPosition() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return tp.tabPosition;
    }-*/;

    /**
     * Activates a {@link TabPanelItem}. The currently active one will be deactivated.
     *
     * @param tabID the tab id
     */
    public native void activate(String tabID) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.activate(tabID);
    }-*/;

    /**
     * Activates a {@link TabPanelItem}. The currently active one will be deactivated.
     *
     * @param tabIndex the tab index
     */
    public native void activate(int tabIndex) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.activate(tabIndex);
    }-*/;

    /**
     * Add a new Tab Panel Item.
     *
     * @param label the tab label
     * @param closable true to create a close icon on the tab
     * @return the created TabPanelItem
     */
    public TabPanelItem addTab(String label, boolean closable) {
        return addTab(Ext.generateId(), label, closable);
    }
    
    /**
     * Add a new Tab Panel Item.
     *
     * @param id the TabPanelItem ID
     * @param label the tab label
     * @param closable true to create a close icon on the tab
     * @return the created TabPanelItem
     */
    public TabPanelItem addTab(String id, String label, boolean closable) {
        return new TabPanelItem(createTabPanelItem(jsObj, id, label, closable));
    }

    private native JavaScriptObject createTabPanelItem(JavaScriptObject tabPanel, String id, String label, boolean closable) /*-{
         return tabPanel.addTab(id, label, "", closable);
    }-*/;

    /**
     * Adda TabPanelItem.
     *
     * @param tab the tab
     */
    public native void addTabItem(TabPanelItem tab) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var tabJS = tab.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.addTabItem(tabJS);
    }-*/;

    /**
     * Manual call to resize the tabs (if resizeTabs is false this does nothing)
     */
    public native void autoSizeTabs() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.autoSizeTabs();
    }-*/;

    /**
     * Disables tab resizing while tabs are being added (if resizeTabs is false this does nothing).
     */
    public native void beginUpdate() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.beginUpdate();
    }-*/;

    /**
     * Destroys this TabPanel.
     * 
     */
    public native void destroy() /*-{
        var tb = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tb.destroy();
    }-*/;

    /**
     * Destroys this TabPanel.
     *
     * @param removeEL True to remove the element from the DOM as well
     */
    public native void destroy(boolean removeEL) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.destroy(removeEL);
    }-*/;

    /**
     * Disables a {@link TabPanelItem}. It cannot be the active tab, if it is this call is ignored.
     * 
     * @param tabID the tab ID to disable
     */
    public native void disableTab(String tabID) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.disableTab(tabID);
    }-*/;

    /**
     * Disables a {@link TabPanelItem}. It cannot be the active tab, if it is this call is ignored.
     *
     * @param tabIndex the tab index to disable
     */
    public native void disableTab(int tabIndex) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.disableTab(tabIndex);
    }-*/;

    /**
     * Enables a {@link TabPanelItem} that is disabled.
     * 
     * @param tabID the tab ID
     */
    public native void enableTab(String tabID) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.enableTab(tabID);
    }-*/;

    /**
     * Enables a {@link TabPanelItem} that is disabled.
     *
     * @param tabIndex the tab index
     */
    public native void enableTab(int tabIndex) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.enableTab(tabIndex);
    }-*/;

    /**
     * Stops an update and resizes the tabs (if resizeTabs is false this does nothing).
     * 
     */
    public native void endUpdate() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.endUpdate();
    }-*/;

    /**
     * Returns the active tab or null if none present.
     *
     * @return the active tab
     */
    public native TabPanelItem getActiveTab()/*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var activeTab = tp.getActiveTab();
        return activeTab ? @com.gwtext.client.widgets.TabPanelItem::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(activeTab):null;
    }-*/;

    /**
     * Returns the number of tabs in this TabPanel.
     *
     * @return the number of tabs in this TabPanel
     */
    public native int getCount() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return tp.getCount();
    }-*/;

    /**
     * Returns the TabPanelItem with the specified id.
     *
     * @param id the tab id
     * @return the TabPanelItem or null if not exist
     */
    public native TabPanelItem getTab(String id)/*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var tab = tp.getTab(id);
        return tab ? @com.gwtext.client.widgets.TabPanelItem::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tab) : null;
    }-*/;

    /**
     * Returns the TabPanelItem with the specified index.
     *
     * @param tabIndex the tab index
     * @return the TabPanelItem or null if not exist
     */
    public native TabPanelItem getTab(int tabIndex) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var tab = tp.getTab(tabIndex);
        return tab ? @com.gwtext.client.widgets.TabPanelItem::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tab) : null;
    }-*/;

    /**
     * Hides the TabPanelItem with the specified id.
     * 
     * @param tabID the tab ID
     */
    public native void hideTab(String tabID) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
       tp.hideTab(tabID);
    }-*/;

    /**
     * Hides the TabPanelItem with the specified index.
     *
     * @param tabIndex the tab index
     */
    public native void hideTab(int tabIndex) /*-{
       var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
       tp.hideTab(tabIndex);
    }-*/;

    /**
     * Removes the TabPanelItem with the specified id.
     *
     * @param tabID the tab ID
     */
    public native void removeTab(String tabID) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.removeTab(tabID);
    }-*/;

    /**
     * Hides the TabPanelItem with the specified index.
     *
     * @param tabIndex the tab index
     */
    public native void removeTab(int tabIndex) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.removeTab(tabIndex);
    }-*/;

    /**
     * Resizes all the tabs to the passed width.
     *
     * @param width the new tab width
     */
    public native void setTabWidth(int width) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.setTabWidth(width);
    }-*/;

    /**
     * Updates the tab body element to fit the height of the container element for overflow scrolling.
     */
    public native void syncHeight() /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.syncHeight();
    }-*/;

    /**
     * Updates the tab body element to fit the height of the container element for overflow scrolling
     *
     * @param targetHeight override the starting height from the elements height
     */
    public native void syncHeight(int targetHeight) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.syncHeight(targetHeight);
    }-*/;

    /**
     * Unhides" the TabPanelItem with the specified id.
     *
     * @param tabID the tab ID
     */
    public native void unhideTab(String tabID) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.unhideTab(tabID);
    }-*/;

    /**
     * Unhides" the TabPanelItem with the specified index.
     *
     * @param tabIndex the tab index
     */
    public native void unhideTab(int tabIndex) /*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tp.unhideTab(tabIndex);
    }-*/;

    /**
     * Add a TabPanel listner.
     *
     * @param listener the listener
     */
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
                    var val = listener.@com.gwtext.client.widgets.event.TabPanelListener::doBeforeTabChange(Lcom/gwtext/client/widgets/TabPanel;Lcom/gwtext/client/widgets/TabPanelItem;)(tabPanelJ, tpiJ);
                    e.cancel = !val;
                    return val;
            }
        );
    }-*/;
}