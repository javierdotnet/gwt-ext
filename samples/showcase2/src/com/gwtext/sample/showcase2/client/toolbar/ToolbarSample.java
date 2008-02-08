/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.toolbar;

import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.menu.*;
import com.gwtext.client.widgets.menu.event.CheckItemListenerAdapter;
import com.gwtext.sample.showcase2.client.Showcase2;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class ToolbarSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/toolbar/ToolbarSample.java.html";
    }

    public String getCssUrl() {
        return "source/toolbar/ToolbarSample.css.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            //create a toolbar and various menu items
            Toolbar toolbar = new Toolbar();

            Menu menu = new Menu();
            menu.setShadow(true);
            menu.setMinWidth(10);

            final CheckItemListenerAdapter listener = new CheckItemListenerAdapter() {
                public void onCheckChange(CheckItem item, boolean checked) {
                    Showcase2.showMessage("Event: checkchange", "'" + item.getText() + "' is now " + (checked ? "checked" : "unchecked"));
                }
            };

            CheckItem checkItem = new CheckItem();
            checkItem.setText("I like Ext");
            checkItem.setChecked(true);
            checkItem.addListener(listener);
            menu.addItem(checkItem);

            CheckItem checkItem2 = new CheckItem();
            checkItem2.setText("I also like GWT-Ext :)");
            checkItem2.setChecked(true);
            checkItem2.addListener(listener);
            menu.addItem(checkItem2);

            CheckItem checkItem3 = new CheckItem();
            checkItem3.setText("I donated");
            checkItem3.setChecked(false);
            checkItem3.addListener(listener);
            menu.addItem(checkItem3);

            menu.addSeparator();

            Menu submenu = new Menu();
            submenu.setShadow(true);
            submenu.setMinWidth(10);
            submenu.addItem(new TextItem("<b class=\"menu-title\">Choose a Theme</b>"));

            CheckItem checkItem4 = new CheckItem();
            checkItem4.setText("Aero Glass");
            checkItem4.setChecked(true);
            checkItem4.setGroup("theme");
            checkItem4.addListener(listener);
            submenu.addItem(checkItem4);

            CheckItem checkItem5 = new CheckItem();
            checkItem5.setText("Vista Black");
            checkItem5.setGroup("theme");
            checkItem5.addListener(listener);
            submenu.addItem(checkItem5);

            CheckItem checkItem7 = new CheckItem();
            checkItem7.setText("Gray Theme");
            checkItem7.setGroup("theme");
            checkItem7.addListener(listener);
            submenu.addItem(checkItem7);

            CheckItem checkItem8 = new CheckItem();
            checkItem8.setText("Default Theme");
            checkItem8.setGroup("theme");
            checkItem8.addListener(listener);
            submenu.addItem(checkItem8);

            MenuItem menuItem = new MenuItem("Radio Options", submenu);
            MenuItem dateMenuItem = new MenuItem("Choose a Date", new DateMenu());
            MenuItem colorMenuItem = new MenuItem("Choose a Color", new ColorMenu());
            menu.addItem(menuItem);
            menu.addItem(dateMenuItem);
            menu.addItem(colorMenuItem);
            menu.addSeparator();

            Item item = new Item();
            item.setText("Dynamically added");

            Item item2 = new Item("Disabled");
            item2.setDisabled(true);
            menu.addItem(item);
            menu.addItem(item2);

            ToolbarMenuButton menuButton = new ToolbarMenuButton("Button w/ Menu");
            menuButton.setMenu(menu);
            menuButton.setArrowTooltip("Arrow Tooltip");
            menuButton.setIconCls("bmenu");
            toolbar.addButton(menuButton);
            toolbar.addSeparator();

            Menu splitMenu = new Menu();
            Item bi = new Item();
            bi.setText("<b>Bold</b>");
            splitMenu.addItem(bi);

            Item ii = new Item();
            ii.setText("<i>Italic</i>");
            splitMenu.addItem(ii);

            Item ui = new Item();
            ui.setText("<u>Underline</u>");
            splitMenu.addItem(ui);

            splitMenu.addSeparator();

            Menu colorMenu = new Menu();
            colorMenu.addItem(new ColorItem());
            colorMenu.addSeparator();
            Item moreColors = new Item();
            moreColors.setText("More Colors...");
            colorMenu.addItem(moreColors);

            MenuItem colorMI = new MenuItem("Pic a Color", colorMenu);
            splitMenu.addItem(colorMI);
            Item excellent = new Item();
            excellent.setText("Excellent");
            splitMenu.addItem(excellent);

            ToolbarMenuButton button2 = new ToolbarMenuButton("Split Button", splitMenu);

            toolbar.addButton(button2);
            toolbar.addSeparator();

            ToolbarButton toggleButton = new ToolbarButton("Toggle Me");
            toggleButton.setEnableToggle(true);
            toggleButton.setPressed(true);
            QuickTipsConfig tipsConfig = new QuickTipsConfig();
            tipsConfig.setText("This is a quicktip with a title");
            tipsConfig.setTitle("Tip Title");
            toggleButton.setTooltip(tipsConfig);

            ToolbarButton iconOnly = new ToolbarButton();
            iconOnly.setIcon("images/add-feed.gif");
            iconOnly.setCls("x-btn-icon");
            iconOnly.setTooltip("<b>Quick Tips</b><br/>Icon only button with tooltip");

            toolbar.addButton(iconOnly);
            toolbar.addSeparator();
            toolbar.addButton(toggleButton);

            toolbar.addSeparator();
            ToolbarTextItem ti = new ToolbarTextItem("Text Item");
            toolbar.addItem(ti);

            Panel toolbarPanel = new Panel();
            toolbarPanel.setWidth(500);
            toolbarPanel.setHeight(400);
            toolbarPanel.setTopToolbar(toolbar);

            panel.add(toolbarPanel);
        }
        return panel;
    }

    protected boolean showEvents() {
        return true;
    }

    public String getIntro() {
        return "<p>This example demonstrates creatign a Toolbar with various items and menu items. A toobar directly to a Panel " +
                "or placed at the top and / or bottom on any Panel like a GridPanel, a FormPanel or a TreePanel as illustrated by " +
                "other examples in this Showcase.</p>";
    }
}