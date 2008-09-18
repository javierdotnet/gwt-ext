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
 

package com.gwtext.sample.showcase2.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.*;
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.event.PanelListenerAdapter;
import com.gwtext.client.widgets.event.TabPanelListenerAdapter;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.event.DataViewListenerAdapter;
import com.gwtext.client.widgets.layout.*;
import com.gwtext.client.widgets.menu.BaseItem;
import com.gwtext.client.widgets.menu.Item;
import com.gwtext.client.widgets.menu.Menu;
import com.gwtext.client.widgets.menu.event.BaseItemListenerAdapter;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.data.*;
import com.gwtext.client.util.Format;

public class Showcase2 implements EntryPoint, HistoryListener {

    private static PopupPanel messagePanel = new PopupPanel(true);
    private TabPanel centerPanel;
    private ScreenManager screenManager;
    private Menu menu;

	public void onModuleLoad() {

        //create the main panel and assign it a BorderLayout
        Panel mainPanel = new Panel();
        mainPanel.setLayout(new BorderLayout());

        BorderLayoutData northLayoutData = new BorderLayoutData(RegionPosition.NORTH);
        northLayoutData.setSplit(false);

        BorderLayoutData centerLayoutData = new BorderLayoutData(RegionPosition.CENTER);
        centerLayoutData.setMargins(new Margins(5, 0, 5, 5));

        Panel centerPanelWrappper = new Panel();
        centerPanelWrappper.setLayout(new FitLayout());
        centerPanelWrappper.setBorder(false);
        centerPanelWrappper.setBodyBorder(false);

        centerPanel = new TabPanel();
        centerPanel.setBodyBorder(false);
        centerPanel.setEnableTabScroll(true);
        centerPanel.setAutoScroll(true);
        centerPanel.setAutoDestroy(false);
        centerPanel.setActiveTab(0);

        //hide the panel when the tab is closed
        centerPanel.addListener(new TabPanelListenerAdapter() {
            public boolean doBeforeTabChange(TabPanel source, Panel newPanel, Panel oldPanel) {
                WindowMgr.hideAll();
                return true;
            }

            public void onRemove(Container self, Component component) {
                component.hide();
            }

            public void onContextMenu(TabPanel source, Panel tab, EventObject e) {
                showMenu(tab, e);
            }
        });

        centerPanel.setLayoutOnTabChange(true);
        centerPanel.setTitle("Main Content");

        screenManager = new ScreenManager(centerPanel);

        //setup the west regions layout properties
        BorderLayoutData westLayoutData = new BorderLayoutData(RegionPosition.WEST);
        westLayoutData.setMargins(new Margins(5, 5, 0, 5));
        westLayoutData.setCMargins(new Margins(5, 5, 5, 5));
        westLayoutData.setMinSize(155);
        westLayoutData.setMaxSize(350);
        westLayoutData.setSplit(true);

        //create the west panel and add it to the main panel applying the west region layout properties
        Panel westPanel = createWestPanel();
        mainPanel.add(westPanel, westLayoutData);

        final Panel introPanel = new Panel();
        introPanel.setTitle("GWT-Ext 2.0.5 Showcase");
        introPanel.setPaddings(10);
        introPanel.setLayout(new FitLayout());
        final ShowcaseView showcaseView = new ShowcaseView(screenManager);
        introPanel.add(showcaseView);

        centerPanel.add(introPanel, centerLayoutData);
        centerPanelWrappper.add(centerPanel);
        mainPanel.add(centerPanelWrappper, centerLayoutData);

        final String initToken = History.getToken();
        if (initToken.length() != 0) {
            mainPanel.addListener(new PanelListenerAdapter() {
                public void onRender(Component component) {
                    onHistoryChanged(initToken);
                }
            });
        }

        Viewport viewport = new Viewport(mainPanel);

        // Add history listener
        History.addHistoryListener(this);
    }

    private Panel createWestPanel() {
        Panel westPanel = new Panel();
        westPanel.setId("side-nav");
        westPanel.setTitle("Showcase Explorer");
        westPanel.setLayout(new FitLayout());
        westPanel.setWidth(210);
        westPanel.setCollapsible(true);

        Toolbar toolbar = new Toolbar();

		if(Ext.isFirebug()) {
			ToolbarButton button = new ToolbarButton();
			button.setIconCls("bug-icon");
			QuickTipsConfig qtipsConfig = new QuickTipsConfig();
			qtipsConfig.setText("Firebug can make the demo run slow.");
			qtipsConfig.setWidth(100);
			qtipsConfig.setMaxWidth(100);
			button.setTooltip(qtipsConfig);
			button.addListener(new ButtonListenerAdapter() {
				public void onClick(Button button, EventObject e) {
					Panel fb = new Panel();
					fb.setAutoScroll(true);
					fb.setAutoLoad("firebug.html");
					final Window window = new Window("Firebug");
					window.setIconCls("bug-icon");
					window.setWidth(550);
					window.setHeight(260);
					window.add(fb);
					window.setCloseAction(Window.CLOSE);
					window.show(button.getElement());

				}
			});
			toolbar.addButton(button);
		}
		toolbar.addFill();
        toolbar.addItem(new ToolbarTextItem("Select Theme "));
        toolbar.addSpacer();
        toolbar.addField(new ThemeChanger());
        westPanel.setTopToolbar(toolbar);
        
        TabPanel tabPanel = new TabPanel();
        tabPanel.setActiveTab(0);
        tabPanel.setDeferredRender(true);
        tabPanel.setTabPosition(Position.BOTTOM);
        TreePanel treePanel = screenManager.getTreeNav();

        tabPanel.add(treePanel);
        tabPanel.add(screenManager.getAccordionNav());
        westPanel.add(tabPanel);

        return westPanel;
    }

    /**
     * This method is called whenever the application's history changes.
     *
     * @param historyToken the histrory token
     */
    public void onHistoryChanged(String historyToken) {
        screenManager.showScreen(historyToken);
    }

    private void showMenu(final Panel tab, EventObject e) {
        if (menu == null) {
            menu = new Menu();
            Item close = new Item("Close Tab");
            close.setId("close-tab-item");
            close.addListener(new BaseItemListenerAdapter() {
                public void onClick(BaseItem item, EventObject e) {
                    centerPanel.remove(centerPanel.getActiveTab());
                }
            });
            menu.addItem(close);

            Item closeOthers = new Item("Close Other Tabs");
            closeOthers.setId("close-others-item");
            closeOthers.addListener(new BaseItemListenerAdapter() {
                public void onClick(BaseItem item, EventObject e) {
                    Component[] items = centerPanel.getItems();
                    for (int i = 0; i < items.length; i++) {
                        Panel panel = (Panel) items[i];
                        if (panel.isClosable() && !panel.getId().equals(centerPanel.getActiveTab().getId())) {
                            centerPanel.remove(panel);
                        }
                    }
                }
            });
            menu.addItem(closeOthers);
        }

        BaseItem close = menu.getItem("close-tab-item");
        if (!centerPanel.getActiveTab().isClosable()) {
            close.disable();
        } else {
            close.enable();
        }

        BaseItem closeOthers = menu.getItem("close-others-item");
        if (centerPanel.getItems().length == 1) {
            closeOthers.disable();
        } else {
            closeOthers.enable();
        }
        menu.showAt(e.getXY());
    }

    public static void showMessage(String title, String message) {
        messagePanel.setPopupPosition(500, 300);
        messagePanel.setWidget(new HTML(getMessageHtml(title, message)));
        messagePanel.setWidth("300px");
        messagePanel.show();
    }

    private static native String getMessageHtml(String title, String message) /*-{
                                                          return ['<div class="msg">',
                                                                  '<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>',
                                                                  '<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc"><h3>', title, '</h3>', message, '</div></div></div>',
                                                                  '<div class="x-box-bl"><div class="x-box-br"><div class="x-box-bc"></div></div></div>',
                                                                  '</div>'].join('');
                                                      }-*/;


}
