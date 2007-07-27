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

package com.gwtext.sample.showcase.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Ext;
import com.gwtext.client.widgets.QuickTips;
import com.gwtext.client.widgets.UserObject;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.ContentPanel;
import com.gwtext.client.widgets.layout.LayoutRegionConfig;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreeNodeConfig;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.TreePanelConfig;
import com.gwtext.client.widgets.tree.event.TreePanelListener;
import com.gwtext.client.widgets.tree.event.TreePanelListenerAdapter;
import com.gwtext.sample.showcase.client.dialog.DialogPanel;
import com.gwtext.sample.showcase.client.dialog.MessageBoxPanel;
import com.gwtext.sample.showcase.client.form.Forms1Panel;
import com.gwtext.sample.showcase.client.form.Forms2Panel;
import com.gwtext.sample.showcase.client.form.Forms3Panel;
import com.gwtext.sample.showcase.client.grid.Grid1Panel;
import com.gwtext.sample.showcase.client.grid.Grid2Panel;
import com.gwtext.sample.showcase.client.grid.Grid3Panel;
import com.gwtext.sample.showcase.client.menu.MenusPanel;
import com.gwtext.sample.showcase.client.tabs.TabsPanel;


public class Showcase implements EntryPoint {
    private static PopupPanel messagePanel = new PopupPanel(true);

    public void onModuleLoad() {
        //globally sets error messages on form fields to the side      
        Field.setMsgTarget("side");
		
        QuickTips.init();

        //create the main layout
        BorderLayout layout = createBorderLayout();

        //add a header
        ContentPanel ncp = new ContentPanel("north", "North Title");
        ncp.add(new HTML("North Panel"));
        layout.add(LayoutRegionConfig.NORTH, ncp);

        //setup the main / center panel
        ContentPanel centerPanel = new ContentPanel("center-panel", "Center Panel");
        VerticalPanel contentPanel = new VerticalPanel();
        contentPanel.setWidth("100%");
        contentPanel.setHeight("100%");
        centerPanel.add(contentPanel);
        layout.add(LayoutRegionConfig.CENTER, centerPanel);

        //add a navigation tree menu
        ContentPanel navcp = createExamplesExplorer(contentPanel);
        layout.add(LayoutRegionConfig.WEST, navcp);

        RootPanel.get().add(layout);
    }

    private ContentPanel createExamplesExplorer(final VerticalPanel contentPanel) {

        //create and configure the main tree
        TreePanel menuTree = new TreePanel("eg-tree", new TreePanelConfig() {
            {
                setAnimate(true);
                setEnableDD(true);
                setContainerScroll(true);
                setRootVisible(false);
            }
        });

        //setup a tree listener that reads the content panel associated with the
        //node that is clicked and then displays it in the main / center panel
        TreePanelListener treePanelListener = new TreePanelListenerAdapter() {
            public void onClick(TreeNode self, EventObject e) {
                UserObject userObject = self.getUserObject();
                if (userObject != null) {
                    Widget contents = (Widget) userObject.getData();
                    contentPanel.clear();
                    contentPanel.add(contents);
                }
            }
        };
        //register listener
        menuTree.addTreePanelListener(treePanelListener);

        //now create nodes for the various menu items
        TreeNode root = new TreeNode(new TreeNodeConfig() {
            {
                setText("Examples and Demos");
            }
        });
        menuTree.setRootNode(root);

        //add dialog example menu
        TreeNode dialogs = new TreeNode(new TreeNodeConfig() {
            {
                setText("Dialogs");
            }
        });

        TreeNode dialogNode = new TreeNode(new TreeNodeConfig() {
            {
                setText("Hello World");
                //here is where we associate a Panl with a node so that when a node is clicked,
                //the tree listener can look this up and display the panel.
                setUserObject(new UserObject(new DialogPanel()));
            }
        });

        TreeNode messageBoxNode = new TreeNode(new TreeNodeConfig() {
            {
                setText("Message Box");
                //here is where we associate a Panl with a node so that when a node is clicked,
                //the tree listener can look this up and display the panel.
                setUserObject(new UserObject(new MessageBoxPanel()));
            }
        });

        dialogs.appendChild(dialogNode);
        dialogs.appendChild(messageBoxNode);
        root.appendChild(dialogs);

        //menu examples
        TreeNode tb = new TreeNode(new TreeNodeConfig() {
            {
                setText("Toolbar and Menus");
            }
        });
        TreeNode tb1 = new TreeNode(new TreeNodeConfig() {
            {
                setText("Toolbar and Menus");
                setUserObject(new UserObject(new MenusPanel()));
            }
        });
        tb.appendChild(tb1);
        root.appendChild(tb);

        //grid examples
        TreeNode grid = new TreeNode(new TreeNodeConfig() {
            {
                setText("Grid");
            }
        });

        TreeNode grid1 = new TreeNode(new TreeNodeConfig() {
            {
                setText("Basic grid from array data");
                setUserObject(new UserObject(new Grid1Panel()));
            }
        });

        TreeNode grid2 = new TreeNode(new TreeNodeConfig() {
            {
                setText("Editable Grid with remote XML data");
                setUserObject(new UserObject(new Grid2Panel()));
            }
        });

        TreeNode grid3 = new TreeNode(new TreeNodeConfig() {
            {
                setText("Paging and Remote Datasets");
                setUserObject(new UserObject(new Grid3Panel()));
            }
        });

        grid.appendChild(grid1);
        grid.appendChild(grid2);
        grid.appendChild(grid3);
        root.appendChild(grid);

        //forms example
        TreeNode form = new TreeNode(new TreeNodeConfig() {
            {
                setText("Form and Combobox");
            }
        });
        TreeNode form1 = new TreeNode(new TreeNodeConfig() {
            {
                setText("Dynamic Forms");
                setUserObject(new UserObject(new Forms1Panel()));
            }
        });

        TreeNode form2 = new TreeNode(new TreeNodeConfig() {
            {
                setText("Live Search");
                setUserObject(new UserObject(new Forms2Panel()));
            }
        });
        TreeNode form3 = new TreeNode(new TreeNodeConfig() {
            {
                setText("XML Form");
                setUserObject(new UserObject(new Forms3Panel()));
            }
        });

        form.appendChild(form1);
        form.appendChild(form2);
        form.appendChild(form3);
        root.appendChild(form);

        //tab example
        TreeNode tabPanel = new TreeNode(new TreeNodeConfig() {
            {
                setText("TabPanel");
            }
        });
        TreeNode tabPanel1 = new TreeNode(new TreeNodeConfig() {
            {
                setText("Advanced Tabs");
                setUserObject(new UserObject(new TabsPanel()));
            }
        });

        TreeNode tabPanel2 = new TreeNode(new TreeNodeConfig() {
            {
                setText("More Tabs (TODO)");
            }
        });
        tabPanel.appendChild(tabPanel1);
        tabPanel.appendChild(tabPanel2);
        root.appendChild(tabPanel);

        //render the tree
        menuTree.render();
        root.expand(false, true);
        //expand the grid menu on dispaly
        grid.expand();

        ContentPanel cp = new ContentPanel("eg-explorer", "Examples Explorer");
        cp.add(menuTree);

        return cp;
    }

    private BorderLayout createBorderLayout() {
        LayoutRegionConfig north = new LayoutRegionConfig();
        north.setSplit(false);
        north.setInitialSize(25);
        north.setTitlebar(false);
        north.setAutoScroll(false);

        LayoutRegionConfig west = new LayoutRegionConfig();
        west.setSplit(true);
        west.setInitialSize(300);
        west.setMinSize(175);
        west.setMaxSize(400);
        west.setTitlebar(true);
        west.setCollapsible(true);
        west.setAnimate(true);
        west.setCollapsed(false);
        west.setAutoScroll(false);

        LayoutRegionConfig east = new LayoutRegionConfig();
        east.setSplit(true);
        east.setInitialSize(202);
        east.setMinSize(175);
        east.setMaxSize(400);
        east.setTitlebar(true);
        east.setCollapsible(true);
        east.setAnimate(true);
        east.setAutoScroll(false);

        LayoutRegionConfig south = new LayoutRegionConfig();
        south.setSplit(true);
        south.setInitialSize(100);
        south.setMinSize(100);
        south.setMaxSize(200);
        south.setTitlebar(true);
        south.setCollapsible(true);
        south.setAnimate(true);
        south.setCollapsed(true);
        south.setAutoScroll(false);

        LayoutRegionConfig center = new LayoutRegionConfig();
        center.setTitlebar(true);
        center.setAutoScroll(true);

        return new BorderLayout("100%", "100%", north, null, west, null, center);
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
