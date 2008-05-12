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
 

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.Position;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.event.TabPanelListener;
import com.gwtext.client.widgets.layout.ContainerLayout;

/**
 * A lightweight tab container.
 *
 * @author Sanjiv Jivan
 */
public class TabPanel extends Panel {

    private static JavaScriptObject configPrototype;

	static {
		init();
	}

	private static native void init()/*-{
        var c = new $wnd.Ext.TabPanel();
        @com.gwtext.client.widgets.TabPanel::configPrototype = c.initialConfig;
    }-*/;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "tabpanel";
	}

	public TabPanel() {
		//by default enable this as its too painful to track down this commonly applicable setting
		setLayoutOnTabChange(true);
        setActiveTab(0);
    }

	public TabPanel(JavaScriptObject jsObj) {
		super(jsObj);
	}

	private static TabPanel instance(JavaScriptObject jsObj) {
		return new TabPanel(jsObj);
	}

	protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.TabPanel(config);
    }-*/;

	/**
	 * Return the min tab width.
	 *
	 * @return the min tab width
	 */
	public native int getMinTabWidth() /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return tp.minTabWidth;
    }-*/;

	/**
	 * Set the min tab width.
	 *
	 * @param minTabWidth the min tab width
	 */
	private native void setMinTabWidthRendered(int minTabWidth) /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        tp.minTabWidth = minTabWidth;
    }-*/;

	public native boolean isResizeTabs() /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return tp.resizeTabs;
    }-*/;

	public native void setResizeTabsRendered(boolean resizeTabs) /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        tp.resizeTabs = resizeTabs;
    }-*/;

	public native String getTabPosition() /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return tp.tabPosition;
    }-*/;

    public void setActiveItemID(String activeItem)  {
        if(isRendered()) {
            activate(activeItem);
        } else {
            super.setActiveItemID(activeItem);
        }
    }

    public void setActiveItem(int activeItem) {
        if(isRendered()) {
            activate(activeItem);
        } else {
            super.setActiveItem(activeItem);
        }
    }

	public void setLayout(ContainerLayout layout) {
        throw new IllegalArgumentException("The layout of TabPanel should not be changed.");
    }

	/**
	 * Activates a tab panel. The currently active one will be deactivated.
	 *
	 * @param tabID the tab id
	 */
	public void activate(String tabID) {
        if(isRendered()) {
           activateRendered(tabID);
        } else {
            setActiveTab(tabID);
        }
    }

    private native void activateRendered(String tabID) /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        tp.activate(tabID);
    }-*/;

	/**
	 * Activates a tab panel. The currently active one will be deactivated.
	 *
	 * @param tabIndex the tab index
	 */
	public void activate(int tabIndex) {
        if(isRendered()) {
           activateRendered(tabIndex);
        } else {
            setActiveTab(tabIndex);
        }
    }

    private native void activateRendered(int tabIndex) /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        tp.activate(tabIndex);
    }-*/;

	/**
	 * Disables tab resizing while tabs are being added (if resizeTabs is false this does nothing).
	 */
	public native void beginUpdate() /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        tp.beginUpdate();
    }-*/;

	/**
	 * Stops an update and resizes the tabs (if resizeTabs is false this does nothing).
	 */
	public native void endUpdate() /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        tp.endUpdate();
    }-*/;

    /**
     * Gets the currently active tab.
     *
     * @return the active tab
     */
    public native Panel getActiveTab() /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var p = tp.getActiveTab();
		return p == null ||  p === undefined ? null : @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
	}-*/;

    /**
     * Gets the specified tab by id.
     *
     * @param id the tab id
     * @return the specified tab
     */
    public native Panel getItem(String id) /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var p = tp.getItem(id);
		return p == null ||  p === undefined ? null : @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
	}-*/;

    /**
     * Gets the DOM element for tab strip item which activates the child panel with the specified ID. Access this to
     * change the visual treatment of the item, for example by changing the CSS class name.
     *
     * @param panel the panel
     * @return the DOM node
     */
    public native Element getTabEl(Panel panel) /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var panelJS = panel.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return tp.getTabEl(panelJS);
	}-*/;

    /**
     * Hides the tab strip item for the passed tab.
     *
     * @param id the tab id
     */
    public native void hideTabStripItem(String id) /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        tp.hideTabStripItem(id);
	}-*/;

    /**
     * Hides the tab strip item for the passed tab.
     *
     * @param index the tab index
     */
    public native void hideTabStripItem(int index) /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        tp.hideTabStripItem(index);
	}-*/;

    /**
     * Hides the tab strip item for the passed tab.
     *
     * @param panel the tab panel
     */
    public native void hideTabStripItem(Panel panel) /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var panelJS = panel.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        tp.hideTabStripItem(panelJS);
	}-*/;

    /**
     * Scrolls to a particular tab if tab scrolling is enabled.
     *
     * @param panel the panel to scroll to
     * @param animate true to animate
     */
    public native void scrollToTab(Panel panel, boolean animate) /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var panelJS = panel.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        tp.scrollToTab(panelJS, animate);
	}-*/;

    /**
     * Unhides the tab strip item for the passed tab.
     *
     * @param id the tab id
     */
    public native void unhideTabStripItem(String id) /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        tp.unhideTabStripItem(id);
	}-*/;

    /**
     * Unhides the tab strip item for the passed tab.
     *
     * @param index the tab index
     */
    public native void unhideTabStripItem(int index) /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        tp.unhideTabStripItem(index);
	}-*/;

    /**
     * Unhides the tab strip item for the passed tab.
     *
     * @param panel the tab panel
     */
    public native void unhideTabStripItem(Panel panel) /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var panelJS = panel.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        tp.unhideTabStripItem(panelJS);
	}-*/;
    
    /**
     * Check if the TabPanel has the specified tab.
     *
     * @param id the tab id
     * @return true if tab present
     */
    public native boolean hasItem(String id) /*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var p = tp.getItem(id);
		return p != null && p !== undefined;
	}-*/;
    
    /**
	 * Add a TabPanel listner.
	 *
	 * @param listener the listener
	 */
	public native void addListener(TabPanelListener listener) /*-{
        this.@com.gwtext.client.widgets.Panel::addListener(Lcom/gwtext/client/widgets/event/PanelListener;)(listener);
        var tabPanelJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforetabchange',
                function(source, newPanel, oldPanel) {
                    var newPanelJ = @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(newPanel);
                    var oldPanelJ = oldPanel == null || oldPanel === undefined ? null : @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(oldPanel);
                    return listener.@com.gwtext.client.widgets.event.TabPanelListener::doBeforeTabChange(Lcom/gwtext/client/widgets/TabPanel;Lcom/gwtext/client/widgets/Panel;Lcom/gwtext/client/widgets/Panel;)(tabPanelJ, newPanelJ, oldPanelJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('contextmenu',
                function(source, tab, event) {
                    var tabJ = @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(tab);
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.event.TabPanelListener::onContextMenu(Lcom/gwtext/client/widgets/TabPanel;Lcom/gwtext/client/widgets/Panel;Lcom/gwtext/client/core/EventObject;)(tabPanelJ, tabJ, e);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('tabchange',
                function(source, tab) {
                    var tabJ = @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(tab);
                    listener.@com.gwtext.client.widgets.event.TabPanelListener::onTabChange(Lcom/gwtext/client/widgets/TabPanel;Lcom/gwtext/client/widgets/Panel;)(tabPanelJ, tabJ);
                }
        );
    
    }-*/;

	// --- config properties ---

    /**
     * The numeric index of the tab that should be initially
     * activated on render (defaults to none).
     *
     * @param activeTab the active tab index
     */
    public void setActiveTab(int activeTab) {
        if(!isRendered()) {
            setAttribute("activeTab", activeTab, true);
        } else {
            activate(activeTab);
        }
    }

    /**
     * The id of the tab that should be initially activated on render (defaults to none).
     *
     * @param activeTab the active tab ID
     */
    public void setActiveTab(String activeTab) {
        if(!isRendered()) {
           setAttribute("activeTab", activeTab, true);
        } else {
            activate(activeTab);
        }
	}

    /**
     * True to animate tab scrolling so that hidden tabs slide smoothly into view (defaults to true).
     * Only applies when enableTabScroll = true.
     *
     * @param animScroll true to animate tab scrolling
     * @see #setEnableTabScroll(boolean)
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setAnimScroll(boolean animScroll) throws IllegalStateException {
        setAttribute("animScroll", animScroll, true);
	}

    /**
     * True to animate tab scrolling so that hidden tabs slide smoothly into view (defaults to true).
     * Only applies when enableTabScroll = true.
     *
     * @return true if animate scroll
     */
    public boolean isAnimScroll() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "animScroll");
    }

    /**
     * Internally, the TabPanel uses a CardLayout to manage its tabs. This property will be
     * passed on to the layout as its CardLayout.deferredRender config value, determining whether
     * or not each tab is rendered only when first accessed (defaults to true).
     *
     * @param deferredRender true to defer rendering
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setDeferredRender(boolean deferredRender) throws IllegalStateException {
        setAttribute("deferredRender", deferredRender, true);
	}

    /**
     * Internally, the TabPanel uses a CardLayout to manage its tabs. This property will be
     * passed on to the layout as its CardLayout.deferredRender config value, determining whether
     * or not each tab is rendered only when first accessed (defaults to true).
     *
     * @return true if deferred render
     */
    public boolean isDeferredRender() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "deferredRender");
    }

    /**
     * True to enable scrolling to tabs that may be invisible due to overflowing the overall TabPanel width.
     * Only available with tabs on top. (defaults to false).
     *
     * @param enableTabScroll true to enable tab scroll
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setEnableTabScroll(boolean enableTabScroll) throws IllegalStateException {
        setAttribute("enableTabScroll", enableTabScroll, true);
	}

    /**
     * True to enable scrolling to tabs that may be invisible due to overflowing the overall TabPanel width.
     * Only available with tabs on top. (defaults to false).
     *
     * @return true if tab scrolling enabled
     */
    public boolean isEnableTabScroll() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "enableTabScroll");
    }

    /**
     * Set to true to do a layout of tab items as tabs are changed.
     *
     * @param layoutOnTabChange true to do a layout of tab items as tabs are changed (default true)
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setLayoutOnTabChange(boolean layoutOnTabChange) throws IllegalStateException {
        setAttribute("layoutOnTabChange", layoutOnTabChange, true);
	}

    /**
     * True to do a layout of tab items as tabs are changed.
     *
     * @return true to do a layout of tab items as tabs are changed
     */
    public boolean isLayoutOnTabChange() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "layoutOnTabChange");
    }

    /**
     * The minimum width in pixels for each tab when resizeTabs = true (defaults to 30).
     * 
     * @param minTabWidth the min tab width
     */
    public void setMinTabWidth(int minTabWidth) {
		if (!isRendered()) {
			setAttribute("minTabWidth", minTabWidth, true);
		} else {
			setMinTabWidthRendered(minTabWidth);
		}
	}

    /**
     * True to render the tab strip without a background container image (defaults to false).
     *
     * @param plain true for plain tabs
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setPlain(boolean plain) throws IllegalStateException {
        setAttribute("plain", plain, true);
	}

    /**
     * True to render the tab strip without a background container image (defaults to false).
     *
     * @return true to render the tab strip without a background container image (defaults to false).
     */
    public boolean isPlain() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "plain");
    }

    /**
     * True to automatically resize each tab so that the tabs will completely fill the tab strip (defaults to false).
     * Setting this to true may cause specific widths that might be set per tab to be overridden in order to fit them all
     * into view (although minTabWidth will always be honored).
     *
     * @param resizeTabs true to resize tabs
     */
    public void setResizeTabs(boolean resizeTabs) {
		if (!isRendered()) {
			setAttribute("resizeTabs", resizeTabs, true);
		} else {
			setResizeTabsRendered(resizeTabs);
		}
	}

    /**
     * The number of milliseconds that each scroll animation should last (defaults to .35). Only applies when
     * animScroll = true.
     *
     *
     * @param scrollDuration scroll duration
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setScrollDuration(int scrollDuration) throws IllegalStateException {
        setAttribute("scrollDuration", scrollDuration, true);
	}

    /**
     * The number of milliseconds that each scroll animation should last (defaults to .35). Only applies when
     * animScroll = true.
     *
     * @return the scroll duration
     */
    public int getScrollDuration() {
        return JavaScriptObjectHelper.getAttributeAsInt(config, "scrollDuration");
    }

    /**
     * The number of pixels to scroll each time a tab scroll button is pressed (defaults to 100, or if resizeTabs = true, the calculated tab width).
     * Only applies when enableTabScroll = true.
     *
     * @param scrollIncrement the scroll increment
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setScrollIncrement(int scrollIncrement) throws IllegalStateException {
        setAttribute("scrollIncrement", scrollIncrement, true);
	}

    /**
     * The number of pixels to scroll each time a tab scroll button is pressed (defaults to 100, or if resizeTabs = true, the calculated tab width).
     * Only applies when enableTabScroll = true.
     *
     * @return the scroll increment
     */
    public int getScrollIncrement() {
        return JavaScriptObjectHelper.getAttributeAsInt(config, "scrollIncrement");
    }

    /**
     * Number of milliseconds between each scroll while a tab scroll button is continuously pressed (defaults to 400).
     *
     * @param scrollRepeatInterval the scroll repeat interval
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setScrollRepeatInterval(int scrollRepeatInterval) throws IllegalStateException {
        setAttribute("scrollRepeatInterval", scrollRepeatInterval, true);
	}

    /**
     * Number of milliseconds between each scroll while a tab scroll button is continuously pressed (defaults to 400).
     *
     * @return the scroll repeat interval
     */
    public int getScrollRepeatInterval() {
        return JavaScriptObjectHelper.getAttributeAsInt(config, "scrollRepeatInterval");
    }

    /**
     * The number of pixels of space to calculate into the sizing and scrolling of tabs. If you change the margin in CSS,
     * you will need to update this value so calculations are correct with either resizeTabs or scrolling tabs. (defaults to 2).
     *
     * @param tabMargin the tab margin
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTabMargin(int tabMargin) throws IllegalStateException {
        setAttribute("tabMargin", tabMargin, true);
	}

    /**
     * The number of pixels of space to calculate into the sizing and scrolling of tabs. If you change the margin in CSS,
     * you will need to update this value so calculations are correct with either resizeTabs or scrolling tabs. (defaults to 2).
     *
     * @return the tab margin
     */
    public int getTabMargin() {
        return JavaScriptObjectHelper.getAttributeAsInt(config, "tabMargin");
    }

    /**
     * The position where the tab strip should be rendered (defaults to 'top'). The only other supported value is 'bottom'.
     * Note that tab scrolling is only supported for position 'top'.
     *
     * @param tabPosition the tab position
     * @see com.gwtext.client.core.Position#TOP
     * @see com.gwtext.client.core.Position#BOTTOM
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTabPosition(Position tabPosition) throws IllegalStateException {
        setAttribute("tabPosition", tabPosition.getPosition(), true);
	}

    /**
     * The initial width in pixels of each new tab (defaults to 120).
     *
     * @param tabWidth the tab width
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTabWidth(int tabWidth) throws IllegalStateException {
        setAttribute("tabWidth", tabWidth, true);
	}

    /**
     * The initial width in pixels of each new tab (defaults to 120).
     *
     * @return the initial tab width
     */
    public int getTabWidth() {
        return JavaScriptObjectHelper.getAttributeAsInt(config, "tabWidth");
    }

    /**
     * For scrolling tabs, the number of pixels to increment on mouse wheel scrolling (defaults to 20).
     *
     * @param wheelIncrement the wheel increment
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setWheelIncrement(int wheelIncrement) throws IllegalStateException {
        setAttribute("wheelIncrement", wheelIncrement, true);
	}

    /**
     * For scrolling tabs, the number of pixels to increment on mouse wheel scrolling (defaults to 20).
     *
     * @return the scroll wheel increment
     */
    public int getWheelIncrement() {
        return JavaScriptObjectHelper.getAttributeAsInt(config, "wheelIncrement");
    }
}