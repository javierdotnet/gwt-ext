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
import com.google.gwt.http.client.*;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.xml.client.*;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.CSS;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.QuickTips;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.ComboBoxConfig;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.Form;
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.ContentPanel;
import com.gwtext.client.widgets.layout.LayoutRegion;
import com.gwtext.client.widgets.layout.LayoutRegionConfig;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreeNodeConfig;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.TreePanelConfig;
import com.gwtext.client.widgets.tree.event.TreePanelListener;
import com.gwtext.client.widgets.tree.event.TreePanelListenerAdapter;
import com.gwtext.sample.showcase.client.combo.*;
import com.gwtext.sample.showcase.client.dd.BasicDDPanel;
import com.gwtext.sample.showcase.client.dd.DDHandlesPanel;
import com.gwtext.sample.showcase.client.dd.DDOnTopPanel;
import com.gwtext.sample.showcase.client.dd.DDProxyPanel;
import com.gwtext.sample.showcase.client.dialog.*;
import com.gwtext.sample.showcase.client.form.*;
import com.gwtext.sample.showcase.client.grid.*;
import com.gwtext.sample.showcase.client.menu.MenusPanel;
import com.gwtext.sample.showcase.client.tabs.TabsPanel;

import java.util.HashMap;
import java.util.Map;

public class Showcase implements EntryPoint {
    private static PopupPanel messagePanel = new PopupPanel(true);

    private Map screens = new HashMap();

    public void onModuleLoad() {

        Field.setMsgTarget("side");
        QuickTips.init();

        //create the main layout
        BorderLayout layout = createBorderLayout();

        //add a header
        ContentPanel ncp = new ContentPanel("north", "North Title");

        DockPanel dock = new DockPanel();
        dock.setVerticalAlignment(DockPanel.ALIGN_MIDDLE);
        dock.add(new HTML("<h3><a href='http://code.google.com/p/gwt-ext/' style='color:#333333;text-decoration:none;'>GWT-Ext 0.9.1 Showcase</a></h3>"), DockPanel.WEST);

        Form themeForm = new Form();
        final Store store = new SimpleStore(new String[]{"theme", "label"}, new Object[][]{
                new Object[]{"xtheme-aero.css", "Aero Glass Theme"},
                new Object[]{"xtheme-gray.css", "Gray Theme"},
                new Object[]{"xtheme-vista.css", "Vista Dark Theme"}
        });

        ComboBox themeCb = new ComboBox(new ComboBoxConfig() {
            {
                setEditable(false);
                setStore(store);
                setDisplayField("label");
                setForceSelection(true);
                setTriggerAction("all");
                setValue("Aero Glass Theme");
                setFieldLabel("Switch theme");
                setComboBoxListener(new ComboBoxListenerAdapter() {
                    public void onSelect(ComboBox comboBox, Record record, int index) {
                        String theme = record.getAsString("theme");
                        CSS.swapStyleSheet("theme", "js/ext/resources/css/" + theme);
                    }
                });
            }
        });
        themeForm.add(themeCb);
        themeForm.render();

        dock.setVerticalAlignment(DockPanel.ALIGN_MIDDLE);
        dock.add(themeForm, DockPanel.EAST);
        dock.setWidth("100%");
        ncp.add(dock);

        layout.add(LayoutRegionConfig.NORTH, ncp);

        //setup the main / center panel
        ContentPanel centerPanel = new ContentPanel("center-panel");
        VerticalPanel contentPanel = new VerticalPanel();
        contentPanel.setWidth("100%");
        contentPanel.setHeight("100%");
        centerPanel.add(contentPanel);
        layout.add(LayoutRegionConfig.CENTER, centerPanel);

        //add a navigation tree menu
        ContentPanel navcp = createExamplesExplorer(layout);
        layout.add(LayoutRegionConfig.WEST, navcp);

        RootPanel.get().add(layout);
    }

    private static String getScreenName(TreeNode node, String name) {
        TreeNode parentNode = (TreeNode) node.getParentNode();
        return (parentNode == null || parentNode.getParentNode() == null) ? name : getScreenName(parentNode, parentNode.getText() + ">" + name);
    }


    private ContentPanel createExamplesExplorer(final BorderLayout layout) {

        //create and configure the main tree
        TreePanel menuTree = new TreePanel("eg-tree", new TreePanelConfig() {
            {
                setAnimate(true);
                setEnableDD(true);
                setContainerScroll(true);
                setRootVisible(true);
            }
        });

        //now create nodes for the various menu items
        final TreeNode root = new TreeNode(new TreeNodeConfig() {
            {
                setText("Examples and Demos");
            }
        });

        //setup a tree listener that reads the content panel associated with the
        //node that is clicked and then displays it in the main / center panel
        TreePanelListener treePanelListener = new TreePanelListenerAdapter() {
            public void onClick(TreeNode self, EventObject e) {
                String screenName = getScreenName(self, self.getText());
                if (screens.containsKey(screenName)) {
                    ShowcaseExample panel = (ShowcaseExample) screens.get(screenName);
                    LayoutRegion region = layout.getRegion(LayoutRegionConfig.CENTER);
                    region.removeAll(true);
                    ContentPanel[] panels = panel.getPanels();
                    for (int i = 0; i < panels.length; i++) {
                        ContentPanel contentPanel = panels[i];
                        layout.add(contentPanel);
                    }
                    region.showPanel(0);
                }
            }
        };

        //register listener
        menuTree.addTreePanelListener(treePanelListener);

        menuTree.setRootNode(root);

        //build side nav tree from xml data
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, "side-nav.xml");
        try {
            builder.sendRequest(null, new RequestCallback() {

                public void onResponseReceived(Request request, Response response) {
                    if (response.getStatusCode() == 200) {
                        Document xml = null;
                        try {
                            xml = XMLParser.parse(response.getText());
                        } catch (Exception e) {
                            MessageBox.alert("Error", e.getMessage());
                            return;
                        }
                        load(root, xml.getElementsByTagName("side-nav").item(0).getChildNodes());
                        root.expand();
                    } else {
                        MessageBox.alert("Error", "Error code : " + response.getStatusCode());
                    }
                }

                public void onError(Request request, Throwable throwable) {
                    MessageBox.alert("Error", throwable.getMessage());
                }
            });
        } catch (RequestException e) {
            MessageBox.alert("Error", e.getMessage());
        }

        menuTree.render();
        ContentPanel cp = new ContentPanel("eg-explorer", "Examples Explorer");
        cp.add(menuTree);

        return cp;
    }

    private void load(TreeNode currentNode, NodeList chidren) {
        for (int i = 0; i < chidren.getLength(); i++) {
            Node child = chidren.item(i);
            if (!(child instanceof Element)) continue;
            String name = child.getNodeName();

            final String title = child.getAttributes().getNamedItem("title").getNodeValue();
            TreeNode treeNode = new TreeNode(title);
            if (name.equals("node")) {
                TreeNode category = treeNode;
                currentNode.appendChild(category);
                load(category, child.getChildNodes());
            } else if (name.equals("leaf")) {
                currentNode.appendChild(treeNode);
            }
        }
    }

    private BorderLayout createBorderLayout() {
        LayoutRegionConfig north = new LayoutRegionConfig();
        north.setSplit(false);
        north.setInitialSize(30);
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
        center.setTitlebar(false);
        center.setAutoScroll(true);
        center.setTabPosition("top");

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

    {
        screens.put("Dialogs>Message Box and Progress", new MessageBoxPanel());
        screens.put("Dialogs>Basic Dialog", new BasicDialogPanel());
        screens.put("Dialogs>Dialog with Key Listeners", new KeyListenerDialogPanel());
        screens.put("Dialogs>Layout Dialog", new LayoutDialogPanel());
        screens.put("Dialogs>Multiple Dialogs", new MultipleDialogPanel());
        screens.put("Dialogs>Login Dialog", new LoginDialogPanel());

        screens.put("ComboBox>Basic", new BasicComboBoxPanel());
        screens.put("ComboBox>Compact", new CompactComboBoxPanel());
        screens.put("ComboBox>Paging", new ComboBoxPagingPanel());
        screens.put("ComboBox>Styled", new ComboBoxStyledPanel());
        screens.put("ComboBox>Live Search", new LiveSearchPanel());

        screens.put("Toolbar and Menus>Toolbar and Menus", new MenusPanel());

        screens.put("Grids>Basic Array Grid", new BasicArrayGridPanel());
        screens.put("Grids>Editable Grid", new EditableGridPanel());
        screens.put("Grids>Grid with Remote Paging", new RemotePagingGridPanel());
        screens.put("Grids>Dynamic Grid", new DynamicGridPanel());
        screens.put("Grids>Column Order", new ColumnOrderGridPanel());
        screens.put("Grids>Stock Ticker", new StockTickerGridPanel());

        screens.put("Forms>Simple Form", new SimpleFormPanel());
        screens.put("Forms>Multi-Column Form", new MultiColumnFormPanel());
        screens.put("Forms>Multi-Column Fieldset Form", new MultiColumnFieldsetPanel());
        screens.put("Forms>Multi-Column Labels Top Form", new MultiColumnLabelsTopPanel());
        screens.put("Forms>Load / Submit Xml Form", new XmlFormPanel());

        screens.put("Tab Panel>Dynamic and Events", new TabsPanel());

        screens.put("Drag and Drop>Basic", new BasicDDPanel());
        screens.put("Drag and Drop>Handles", new DDHandlesPanel());
        screens.put("Drag and Drop>On Top", new DDOnTopPanel());
        screens.put("Drag and Drop>Proxy", new DDProxyPanel());
    }
}
