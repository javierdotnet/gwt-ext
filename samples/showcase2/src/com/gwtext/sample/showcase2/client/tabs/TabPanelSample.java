/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.tabs;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.event.TabPanelListenerAdapter;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtext.client.widgets.menu.BaseItem;
import com.gwtext.client.widgets.menu.Item;
import com.gwtext.client.widgets.menu.Menu;
import com.gwtext.client.widgets.menu.event.BaseItemListenerAdapter;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class TabPanelSample extends ShowcasePanel {

    private TabPanel tabPanel;
    private int index;
    private Menu menu;

    public String getSourceUrl() {
        return "source/tabs/TabPanelSample.java.html";
    }

    public String getCssUrl() {
        return "source/tabs/TabPanelSample.css.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            Panel verticalPanel = new Panel();
            verticalPanel.setLayout(new VerticalLayout(15));

            Button button = new Button("Add Tab", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    Panel tab = addTab();
                    tabPanel.activate(tab.getId());
                    tabPanel.scrollToTab(tab, true);
                }
            });
            button.setIconCls("new-tab-icon");
            verticalPanel.add(button);

            tabPanel = new TabPanel();
            tabPanel.setResizeTabs(true);
            tabPanel.setMinTabWidth(115);
            tabPanel.setTabWidth(135);
            tabPanel.setEnableTabScroll(true);
            tabPanel.setWidth(450);
            tabPanel.setHeight(250);
            tabPanel.setActiveTab(0);

            tabPanel.addListener(new TabPanelListenerAdapter() {
                public void onContextMenu(TabPanel source, Panel tab, EventObject e) {
                    showMenu(tab, e);
                }
            });

            for (index = 0; index < 7; index++) {
                addTab();
            }
            verticalPanel.add(tabPanel);

            panel.add(verticalPanel);

        }
        return panel;
    }

    private void showMenu(final Panel tab, EventObject e) {
        if (menu == null) {
            menu = new Menu();
            Item close = new Item("Close Tab");
            close.setId("close-tab-item");
            close.addListener(new BaseItemListenerAdapter() {
                public void onClick(BaseItem item, EventObject e) {
                    tabPanel.remove(tabPanel.getActiveTab());
                }
            });
            menu.addItem(close);

            Item closeOthers = new Item("Close Other Tabs");
            closeOthers.setId("close-others-item");
            closeOthers.addListener(new BaseItemListenerAdapter() {
                public void onClick(BaseItem item, EventObject e) {
                    Component[] items = tabPanel.getItems();
                    for (int i = 0; i < items.length; i++) {
                        Component component = items[i];
                        if (!component.getId().equals(tabPanel.getActiveTab().getId())) {
                            tabPanel.remove(component);
                        }
                    }
                }
            });
            menu.addItem(closeOthers);
        }

        BaseItem closeOthers = menu.getItem("close-others-item");
        if (tabPanel.getItems().length == 1) {
            closeOthers.disable();
        } else {
            closeOthers.enable();
        }
        menu.showAt(e.getXY());
    }

    private Panel addTab() {
        Panel tab = new Panel();
        tab.setAutoScroll(true);
        tab.setTitle("New Tab " + (++index));
        tab.setIconCls("tab-icon");
        tab.setHtml("Tab Body " + index + "<br/><br/>" + SampleData.getBogusMarkup());
        tab.setClosable(true);
        tabPanel.add(tab);
        return tab;
    }

    public String getIntro() {
        return "<p>This TabPanel demonstrates:</p>" +
                "    <p>" +
                "        - Auto tab resizing<br>" +
                "        - Tab scrolling<br>" +
                "        - Tabs with icons<br>" +
                "        - Tab Context menu<br>" +
                "    </p>";
    }
}