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

package com.gwtext.sample.showcase.client.menu;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.menu.*;
import com.gwtext.client.widgets.menu.event.CheckItemListenerAdapter;
import com.gwtext.sample.showcase.client.Showcase;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class MenusPanel extends ShowcaseExampleVSD {

    public String getSourceUrl() {
        return "menu/MenusPanel.java.html";
    }

    public Panel getViewPanel() {

        //create a toolbar and various menu items
        Toolbar tb = new Toolbar("toolbar1");
        final ToolbarTextItem ti = new ToolbarTextItem("Text Item");
        tb.addItem(ti);

        Menu menu = new Menu("mainMenu", new MenuConfig() {
            {
                setShadow(true);
                setMinWidth(10);
            }
        });

        final CheckItemListenerAdapter listener = new CheckItemListenerAdapter() {
            public void onCheckChange(CheckItem item, boolean checked) {
                Showcase.showMessage("Event: checkchange", "'" + item.getText() + "' is now " + (checked ? "checked" : "unchecked"));
            }
        };

        menu.addItem(new CheckItem(new CheckItemConfig() {
            {
                setText("I like Ext");
                setChecked(true);
                setCheckItemListener(listener);
            }
        }));

        menu.addItem(new CheckItem(new CheckItemConfig() {
            {
                setText("I also like GWT-Ext :)");
                setChecked(true);
                setCheckItemListener(listener);
            }
        }));

        menu.addItem(new CheckItem(new CheckItemConfig() {
            {
                setText("I donated");
                setChecked(false);
                setCheckItemListener(listener);
            }
        }));

        menu.addSeparator();

        Menu menu2 = new Menu("mainMenu2", new MenuConfig() {
            {
                setShadow(true);
                setMinWidth(10);
            }
        });

        menu2.addItem(new TextItem("<b class=\"menu-title\">Choose a Theme</b>"));
        menu2.addItem(new CheckItem(new CheckItemConfig() {
            {
                setText("Aero Glass");
                setChecked(true);
                setGroup("theme");
                setCheckItemListener(listener);
            }
        }));
        menu2.addItem(new CheckItem(new CheckItemConfig() {
            {
                setText("Vista Black");
                setGroup("theme");
                setCheckItemListener(listener);
            }
        }));
        menu2.addItem(new CheckItem(new CheckItemConfig() {
            {
                setText("Gray Theme");
                setGroup("theme");
                setCheckItemListener(listener);
            }
        }));
        menu2.addItem(new CheckItem(new CheckItemConfig() {
            {
                setText("Default Theme");
                setGroup("theme");
                setCheckItemListener(listener);
            }
        }));

        MenuItem menuItem = new MenuItem("Radio Options", "", menu2);
        MenuItem dateMenuItem = new MenuItem("Choose a Date", "", new DateMenu("datemenu", new DateMenuConfig()));
        MenuItem colorMenuItem = new MenuItem("Choose a Color", "", new ColorMenu("colormenu", new ColorMenuConfig()));
        menu.addItem(menuItem);
        menu.addItem(dateMenuItem);
        menu.addItem(colorMenuItem);
        menu.addSeparator();

        Item item1 = new Item(new ItemConfig());
        item1.setText("Dynamically added");

        Item item2 = new Item("Disabled", new ItemConfig());
        item2.setDisabled(true);
        menu.addItem(item1);
        menu.addItem(item2);

        ToolbarMenuButton menuButton = new ToolbarMenuButton("foos-mb", "Button w/ Menu", menu, new SplitButtonConfig() {
            {
                setArrowTooltip("Arrow Tooltip");
                setCls("x-btn-text-icon bmenu");
            }
        });
        tb.addButton(menuButton);
        tb.addSeparator();

        Menu splitMenu = new Menu("split-menu", new MenuConfig());
        Item bi = new Item(new ItemConfig());
        bi.setText("<b>Bold</b>");
        splitMenu.addItem(bi);

        Item ii = new Item(new ItemConfig());
        ii.setText("<i>Italic</i>");
        splitMenu.addItem(ii);

        Item ui = new Item(new ItemConfig());
        ui.setText("<u>Underline</u>");
        splitMenu.addItem(ui);

        splitMenu.addSeparator();

        Menu colorMenu = new Menu("cmenu", new MenuConfig());
        colorMenu.addItem(new ColorItem());
        colorMenu.addSeparator();
        Item moreColors = new Item(new ItemConfig());
        moreColors.setText("More Colors...");
        colorMenu.addItem(moreColors);

        MenuItem colorMI = new MenuItem("Pic a Color", "", colorMenu);
        splitMenu.addItem(colorMI);
        Item excellent = new Item(new ItemConfig());
        excellent.setText("Excellent");
        splitMenu.addItem(excellent);

        ToolbarMenuButton button2 = new ToolbarMenuButton("Split Button", splitMenu);

        tb.addButton(button2);
        tb.addSeparator();

        ToolbarButton toggleButton = new ToolbarButton("foos-btn", "Toggle Me", new ButtonConfig() {
            {
                setEnableToggle(true);
                setPressed(true);
                setTooltip(new QuickTipsConfig() {
                    {
                        setText("This is a quicktip with autoHide set to false and a title");
                        setAutoHide(false);
                        setTitle("Tip Title");
                    }
                });
            }
        });

        ToolbarButton iconOnly = new ToolbarButton(new ButtonConfig() {
            {
                setIcon("images/add-feed.gif");
                setCls("x-btn-icon");
                setTooltip("<b>Quick Tips</b><br/>Icon only button with tooltip");
            }
        });

        tb.addButton(iconOnly);
        tb.addSeparator();
        tb.addButton(toggleButton);

        VerticalPanel vp = createPanel();
        vp.add(new HTML("<h1>Toolbar with Menus</h1>"));
        vp.setWidth("300px");
        vp.add(tb);

        return vp;
    }
}