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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.*;
import com.gwtext.client.core.EventCallback;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Function;
import com.gwtext.client.data.NodeTraversalCallback;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.CSS;
import com.gwtext.client.util.DelayedTask;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.*;
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter;
import com.gwtext.client.widgets.layout.*;
import com.gwtext.client.widgets.tree.*;
import com.gwtext.client.widgets.tree.event.TreePanelListener;
import com.gwtext.client.widgets.tree.event.TreePanelListenerAdapter;
import com.gwtext.sample.showcase.client.animation.CustomAnimationPanel;
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
import com.gwtext.sample.showcase.client.tree.CheckboxTreePanel;
import com.gwtext.sample.showcase.client.tree.EditableTreePanel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Showcase implements EntryPoint {
    private static PopupPanel messagePanel = new PopupPanel(true);

    private Map screens = new HashMap();
    private TextField searchField;
    private TreeFilter treeFilter;
    private DelayedTask delayedTask = new DelayedTask();

    public void onModuleLoad() {

        Field.setMsgTarget("side");
        QuickTips.init();

        //create the main layout
        BorderLayout layout = createBorderLayout();

        //add a header
        ContentPanel ncp = new ContentPanel("north", "North Title");

        DockPanel dock = new DockPanel();
        dock.setVerticalAlignment(DockPanel.ALIGN_MIDDLE);
        dock.add(new HTML("<h3><a href='http://code.google.com/p/gwt-ext/' style='color:#333333;text-decoration:none;'>GWT-Ext 0.9.2 Showcase</a>  " +
                "<span style='font-size:10'>(<a href='http://code.google.com/p/gwt-ext/' target='_blank'>http://code.google.com/p/gwt-ext/</a>)</span></h3> "), DockPanel.WEST);

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
        final TreePanel menuTree = new TreePanel("eg-tree", new TreePanelConfig() {
            {
                setAnimate(true);
                setEnableDD(true);
                setContainerScroll(true);
                setRootVisible(true);
            }
        });

        treeFilter = new TreeFilter(menuTree);

        final XMLTreeLoader loader = new XMLTreeLoader(new XMLTreeLoaderConfig() {
            {
                setDataUrl("side-nav.xml");
                setRootTag("side-nav");
                setFolderTag("node");
                setFolderTitleMapping("@title");
                setLeafTitleMapping("@title");
                setLeafTag("leaf");
            }
        });
        AsyncTreeNode root = new AsyncTreeNode("Examples and Demos", new AsyncTreeNodeConfig() {
            {
                setLoader(loader);
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
        menuTree.render();

        //loads tree data asynchronously
        root.expand();
        menuTree.expandAll();

        final Toolbar filterToolbar = new Toolbar("filter-tb");
        ToolbarButton funnelButton = new ToolbarButton(new ButtonConfig() {
            {
                setTooltip("Tree filtering is currently OFF<br>Click to turn Tree filtering <b>ON</b>");
                setCls("x-btn-icon filter-btn");
                setEnableToggle(true);
                setButtonListener(new ButtonListenerAdapter() {
                    public void onToggle(Button button, boolean pressed) {
                        if (pressed) {
                            DOM.setStyleAttribute(button.getButtonElement(), "backgroundImage", "url(images/funnel_X.gif)");
                            button.setTooltip("Tree filtering is currently ON<br>Click to turn Tree filtering <b>OFF</b>");
                            onSearchChange(true);
                        } else {
                            DOM.setStyleAttribute(button.getButtonElement(), "backgroundImage", "url(images/funnel_plus.gif)");
                            button.setTooltip("Tree filtering is currently OFF<br>Click to turn Tree filtering <b>ON</b>");
                            treeFilter.clear();
                            onSearchChange(false);
                        }
                    }
                });
            }
        });

        filterToolbar.addButton(funnelButton);

        searchField = new TextField(new TextFieldConfig() {
            {
                setMaxLength(40);
                setGrow(false);
                setSelectOnFocus(true);
            }
        });

        filterToolbar.addField(searchField);
        filterToolbar.addSeparator();

        filterToolbar.addButton(new ToolbarButton(new ButtonConfig() {
            {
                setCls("x-btn-icon expand-all-btn");
                setTooltip("Expand All");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        menuTree.expandAll();
                    }
                });
            }
        }));

        filterToolbar.addButton(new ToolbarButton(new ButtonConfig() {
            {
                setCls("x-btn-icon collapse-all-btn");
                setTooltip("Collapse All");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        menuTree.collapseAll();
                    }
                });
            }
        }));

        ContentPanel cp = new ContentPanel("eg-explorer", "Examples Explorer", new ContentPanelConfig() {
            {
                setToolbar(filterToolbar);
            }
        });
        cp.add(menuTree);

        searchField.getEl().addListener("keyup", new EventCallback() {
            public void execute(EventObject e) {
                delayedTask.delay(500, new Function() {
                    public void execute() {
                        onSearchChange(false);
                    }
                });
            }
        });

        return cp;
    }

    private void onSearchChange(final boolean filteredOnly) {
        final String filter = searchField.getText();
        if (filter == null || filter.equals("")) {
            treeFilter.clear();
            treeFilter.filterBy(new TreeTraversalCallback() {
                public boolean execute(TreeNode node) {
                    node.setText(Format.stripTags(node.getText()));
                    return true;
                }
            });
        } else {
            treeFilter.filterBy(new TreeTraversalCallback() {
                public boolean execute(TreeNode node) {
                    String text = Format.stripTags(node.getText());
                    node.setText(text);
                    if (text.toLowerCase().indexOf(filter.toLowerCase()) != -1) {
                        node.setText("<b>" + text + "</b>");
                        ((TreeNode) node.getParentNode()).expand();
                        return true;
                    } else {
                        final List childMatches = new ArrayList();
                        node.cascade(new NodeTraversalCallback() {
                            public boolean execute(com.gwtext.client.data.Node node) {
                                String childText = ((TreeNode) node).getText();
                                if (childText.toLowerCase().indexOf(filter.toLowerCase()) != -1) {
                                    childMatches.add(new Object());
                                }
                                return true;
                            }
                        });
                        return !filteredOnly || childMatches.size() != 0;
                    }
                }
            });
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

        screens.put("Animation>Custom", new CustomAnimationPanel());
        screens.put("Tree>Editable and Sortable", new EditableTreePanel());
        screens.put("Tree>Checkbox", new CheckboxTreePanel());
    }
}
