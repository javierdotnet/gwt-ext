/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.History;
import com.gwtext.client.core.EventCallback;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Function;
import com.gwtext.client.data.*;
import com.gwtext.client.util.DelayedTask;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.event.TextFieldListenerAdapter;
import com.gwtext.client.widgets.layout.AccordionLayout;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.tree.TreeFilter;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.TreeTraversalCallback;
import com.gwtext.client.widgets.tree.event.TreeNodeListenerAdapter;
import com.gwtext.sample.showcase2.client.button.ButtonsSample;
import com.gwtext.sample.showcase2.client.button.CycleButtonSample;
import com.gwtext.sample.showcase2.client.button.MenuButtonSample;
import com.gwtext.sample.showcase2.client.button.ToggleButtonSample;
import com.gwtext.sample.showcase2.client.chooser.ImageChooserSample;
import com.gwtext.sample.showcase2.client.combination.ChartGeneratorSample;
import com.gwtext.sample.showcase2.client.combo.*;
import com.gwtext.sample.showcase2.client.dd.BasicDDSample;
import com.gwtext.sample.showcase2.client.dd.BasicOnTopSample;
import com.gwtext.sample.showcase2.client.form.*;
import com.gwtext.sample.showcase2.client.grid.*;
import com.gwtext.sample.showcase2.client.layout.*;
import com.gwtext.sample.showcase2.client.misc.*;
import com.gwtext.sample.showcase2.client.panel.PanelsSample;
import com.gwtext.sample.showcase2.client.tabs.BottomTabPanelSample;
import com.gwtext.sample.showcase2.client.tabs.TabPanelSample;
import com.gwtext.sample.showcase2.client.toolbar.ToolbarSample;
import com.gwtext.sample.showcase2.client.tooltip.ToolTipTypesSample;
import com.gwtext.sample.showcase2.client.tree.*;
import com.gwtext.sample.showcase2.client.view.DataViewSample;
import com.gwtext.sample.showcase2.client.window.LayoutWindowSample;
import com.gwtext.sample.showcase2.client.window.MessageBoxSample;

import java.util.ArrayList;
import java.util.List;

public class ScreenManager {

    private static Store store;
    private TabPanel appTabPanel;
    private TextField searchField;
    private TreeFilter treeFilter;
    private TreePanel treePanel;
    private DelayedTask delayedTask = new DelayedTask();

    public ScreenManager(TabPanel tabPanel) {
        this.appTabPanel = tabPanel;
    }

    public Panel getAccordionNav() {
        Panel accordion = new Panel();
        accordion.setTitle("Accordion");
        accordion.setLayout(new AccordionLayout(true));

        Store store = getStore();

        Record[] records = store.getRecords();
        for (int i = 0; i < records.length; i++) {
            Record record = records[i];

            String id = record.getAsString("id");
            final String category = record.getAsString("category");
            String title = record.getAsString("title");
            final String iconCls = record.getAsString("iconCls");

            String thumbnail = record.getAsString("thumbnail");
            String qtip = record.getAsString("qtip");

            final ShowcasePanel panel = (ShowcasePanel) record.getAsObject("screen");

            if (category == null) {
                Panel categoryPanel = new Panel();
                categoryPanel.setAutoScroll(true);
                categoryPanel.setLayout(new FitLayout());
                categoryPanel.setId(id + "-acc");
                categoryPanel.setTitle(title);
                categoryPanel.setIconCls(iconCls);
                accordion.add(categoryPanel);
            } else {
                Panel categoryPanel = (Panel) accordion.findByID(category + "-acc");
                TreePanel treePanel = (TreePanel) categoryPanel.findByID(category + "-acc-tree");
                TreeNode root = null;
                if (treePanel == null) {
                    treePanel = new TreePanel();
                    treePanel.setAutoScroll(true);
                    treePanel.setId(category + "-acc-tree");
                    treePanel.setRootVisible(false);
                    root = new TreeNode();
                    treePanel.setRootNode(root);
                    categoryPanel.add(treePanel);
                } else {
                    root = treePanel.getRootNode();
                }

                TreeNode node = new TreeNode();
                node.setText(title);
                node.setId(id);
                if (iconCls != null) node.setIconCls(iconCls);
                if (qtip != null) node.setTooltip(qtip);
                root.appendChild(node);

                addNodeClickListener(node, panel, iconCls);
            }
        }

        return accordion;
    }

    private void addNodeClickListener(TreeNode node, final Panel panel, final String iconCls) {
        if (panel != null) {
            node.addListener(new TreeNodeListenerAdapter() {
                public void onClick(Node node, EventObject e) {
                    String panelID = panel.getId();
                    if (appTabPanel.hasItem(panelID)) {
                        showScreen(panel, null, null, node.getId());
                    } else {
                        TreeNode treeNode = (TreeNode) node;
                        panel.setTitle(treeNode.getText());
                        String nodeIconCls = iconCls;
                        if (iconCls == null) {
                            nodeIconCls = ((TreeNode) treeNode.getParentNode()).getIconCls();
                        }
                        showScreen(panel, treeNode.getText(), nodeIconCls, node.getId());
                    }
                }
            });
        }
    }

    public void showScreen(String historyToken) {
        if (historyToken == null || historyToken.equals("")) {
            appTabPanel.activate(0);
        } else {
            Record record = store.getById(historyToken);
            if (record != null) {
                ShowcasePanel panel = (ShowcasePanel) record.getAsObject("screen");
                String title = record.getAsString("title");
                String iconCls = record.getAsString("iconCls");
                showScreen(panel, title, iconCls, historyToken);
            }
        }
    }

    public void showScreen(Panel panel, String title, String iconCls, String screenName) {
        String panelID = panel.getId();
        if (appTabPanel.hasItem(panelID)) {
            appTabPanel.scrollToTab(panel, true);
            appTabPanel.activate(panelID);
        } else {
            if (!panel.isRendered()) {
                panel.setTitle(title);
                if (iconCls == null) {
                    iconCls = "plugins-nav-icon";
                }
                panel.setIconCls(iconCls);
            }
            appTabPanel.add(panel);
            appTabPanel.activate(panel.getId());
        }
        History.newItem(screenName);
    }

    public TreePanel getTreeNav() {
        treePanel = new TreePanel();
        treePanel.setTitle("Tree View");
        treePanel.setId("nav-tree");
        treePanel.setWidth(180);
        treePanel.setCollapsible(true);
        treePanel.setAnimate(true);
        treePanel.setEnableDD(false);
        treePanel.setAutoScroll(true);
        treePanel.setContainerScroll(true);
        treePanel.setRootVisible(false);
        treePanel.setBorder(false);
        treePanel.setTopToolbar(getFilterToolbar());

        TreeNode root = new TreeNode("Showcase Explorer");
        treePanel.setRootNode(root);

        Store store = getStore();

        Record[] records = store.getRecords();
        for (int i = 0; i < records.length; i++) {
            Record record = records[i];

            String id = record.getAsString("id");
            final String category = record.getAsString("category");
            String title = record.getAsString("title");
            final String iconCls = record.getAsString("iconCls");

            String thumbnail = record.getAsString("thumbnail");
            String qtip = record.getAsString("qtip");

            final ShowcasePanel panel = (ShowcasePanel) record.getAsObject("screen");

            TreeNode node = new TreeNode(title);
            node.setId(id);
            if (iconCls != null) node.setIconCls(iconCls);
            if (qtip != null) node.setTooltip(qtip);
            if (category == null || category.equals("")) {
                root.appendChild(node);
            } else {
                Node categoryNode = root.findChildBy(new NodeTraversalCallback() {
                    public boolean execute(Node node) {
                        return node.getId().equals(category);
                    }
                });

                if (categoryNode != null) {
                    categoryNode.appendChild(node);
                }
            }
            addNodeClickListener(node, panel, iconCls);
        }
        treeFilter = new TreeFilter(treePanel);
        return treePanel;
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

    private Toolbar getFilterToolbar() {
        final Toolbar filterToolbar = new Toolbar();
        ToolbarButton funnelButton = new ToolbarButton();

        funnelButton.setTooltip("Tree filtering is currently OFF<br>Click to turn Tree filtering <b>ON</b>");
        funnelButton.setCls("x-btn-icon filter-btn");
        funnelButton.setEnableToggle(true);
        funnelButton.addListener(new ButtonListenerAdapter() {
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
        filterToolbar.addButton(funnelButton);

        searchField = new TextField();
        searchField.setWidth(120);
        searchField.setMaxLength(40);
        searchField.setGrow(false);
        searchField.setSelectOnFocus(true);

        searchField.addListener(new TextFieldListenerAdapter() {
            public void onRender(Component component) {
                searchField.getEl().addListener("keyup", new EventCallback() {
                    public void execute(EventObject e) {
                        delayedTask.delay(500, new Function() {
                            public void execute() {
                                onSearchChange(false);
                            }
                        });
                    }
                });
            }
        });

        filterToolbar.addField(searchField);
        filterToolbar.addFill();

        ToolbarButton expandButton = new ToolbarButton();
        expandButton.setCls("x-btn-icon expand-all-btn");
        expandButton.setTooltip("Expand All");
        expandButton.addListener(new ButtonListenerAdapter() {
            public void onClick(Button button, EventObject e) {
                treePanel.expandAll();
            }
        });
        filterToolbar.addButton(expandButton);

        ToolbarButton collapseButton = new ToolbarButton();
        collapseButton.setCls("x-btn-icon collapse-all-btn");
        collapseButton.setTooltip("Collapse All");
        collapseButton.addListener(new ButtonListenerAdapter() {
            public void onClick(Button button, EventObject e) {
                treePanel.collapseAll();
            }
        });

        filterToolbar.addButton(collapseButton);
        return filterToolbar;
    }

    public static Store getStore() {
        if (store == null) {
            MemoryProxy proxy = new MemoryProxy(getData());

            RecordDef recordDef = new RecordDef(new FieldDef[]{
                    new StringFieldDef("id"),
                    new StringFieldDef("category"),
                    new StringFieldDef("title"),
                    new StringFieldDef("iconCls"),
                    new StringFieldDef("thumbnail"),
                    new StringFieldDef("qtip"),
                    new ObjectFieldDef("screen")
            });

            ArrayReader reader = new ArrayReader(0, recordDef);
            store = new Store(proxy, reader);
            store.load();
        }
        return store;
    }

    private static Object[][] getData() {
        return new Object[][]{

                new Object[]{"tree-category", null, "Tree", "tree-category-icon", null, null, null},
                new Object[]{"editableTree", "tree-category", "Editable Tree", null, "images/thumbnails/tree/editable.gif", null, new EditableTreePanel()},
                new Object[]{"checkboxTree", "tree-category", "Checkbox Tree", null, null, null, new CheckboxTreePanel()},
                new Object[]{"sortMultiSelectTree", "tree-category", "Sort &amp; Multi-Select", null, null, null, new SortableMultiSelectTreeSample()},
                new Object[]{"twoTrees", "tree-category", "Tree to Tree Drag &amp; Drop", null, "images/thumbnails/tree/two-tree.gif", null, new TwoTreesSample()},
                new Object[]{"gridDD", "tree-category", "Grid - Tree Drag &amp; Drop", null, "images/thumbnails/tree/grid-tree.gif", null, new GridTreeDDSample()},

                new Object[]{"buttons-category", null, "Buttons", "buttons-category-icon", null, null, null},
                new Object[]{"buttons", "buttons-category", "Simple Buttons", null, null, null, new ButtonsSample()},
                new Object[]{"cycleButton", "buttons-category", "Cycle Button", null, null, null, new CycleButtonSample()},
                new Object[]{"menuButton", "buttons-category", "Menu Button", null, "images/thumbnails/button/button-menu.gif", null, new MenuButtonSample()},
                new Object[]{"toggleButtons", "buttons-category", "Toggle Buttons", null, null, null, new ToggleButtonSample()},

                new Object[]{"layouts-category", null, "Layouts", "layout-category-icon", null, null, null},
                new Object[]{"horizontalLayout", "layouts-category", "Horizontal Layout", null, null, null, new HorizontalLayoutSample()},
                new Object[]{"verticalLayout", "layouts-category", "Vertical Layout", null, null, null, new VerticalLayoutSample()},
                new Object[]{"hvLayout", "layouts-category", "Horizontal &amp Vertical Layout", null, null, null, new HorizontalVerticalLayoutSample()},
                new Object[]{"accordionLayout", "layouts-category", "Accordion Layout", null, "images/thumbnails/layout/accordion.gif", null, new AccordionLayoutSample()},
                new Object[]{"anchorLayout", "layouts-category", "Anchor Layout", null, null, null, new AnchorSample()},
                new Object[]{"columnPctLayout", "layouts-category", "Column Layout - Pct Only", null, null, null, new ColumnPctSample()},
                new Object[]{"columnMixedLayout", "layouts-category", "Column Layout - Mixed", null, null, null, new ColumnMixedSample()},
                new Object[]{"combinedLayout", "layouts-category", "Combined Layouts", null, null, null, new CombinedLayoutSample()},
                new Object[]{"complexLayout", "layouts-category", "Complex Layout", null, "images/thumbnails/layout/complex.gif", null, new ComplexSample()},
                new Object[]{"tableLayout", "layouts-category", "Table Layout", null, null, null, new TableSample()},
                new Object[]{"cardLayout", "layouts-category", "Wizard w/ CardLayout", null, null, null, new CardLayoutSample()},
                new Object[]{"rowLayout", "layouts-category", "Row Layout", null, null, null, new RowLayoutSample()},

                new Object[]{"panels-category", null, "Panels", "panels-category-icon", null, null, null},
                new Object[]{"panels", "panels-category", "Panels", null, "images/thumbnails/panels/panel.gif", null, new PanelsSample()},

                new Object[]{"windows-category", null, "Windows", "windows-category-icon", null, null, null},
                new Object[]{"messageBox", "windows-category", "MessageBox &amp Progress", null, "images/thumbnails/windows/msg-box.gif", null, new MessageBoxSample()},
                new Object[]{"layoutWindow", "windows-category", "Layout Window", null, "images/thumbnails/windows/layout-window.gif", null, new LayoutWindowSample()},

                new Object[]{"combo-category", null, "Combobox", "combo-category-icon", null, null, null},
                new Object[]{"basicComboBox", "combo-category", "Basic ComboBox", null, "images/thumbnails/combo/combo.gif", null, new BasicComboBoxSample()},
                new Object[]{"linkedComboBox", "combo-category", "Linked ComboBox", null, "images/thumbnails/combo/combo-linked.gif", null, new LinkedComboBoxSample()},
                new Object[]{"compactComboBox", "combo-category", "Compact ComboBox", null, null, null, new ComboBoxCompactSample()},
                new Object[]{"pagingComboBox", "combo-category", "Paging ComboBox", null, "images/thumbnails/combo/combo-paging.gif", null, new ComboBoxPagingSample()},
                new Object[]{"styledComboBox", "combo-category", "Styled ComboBox", null, "images/thumbnails/combo/combo-styled.gif", null, new ComboBoxStyledSample()},
                new Object[]{"liveSearch", "combo-category", "Live Search", null, "images/thumbnails/combo/combo-custom.gif", null, new LiveSearchSample()},

                new Object[]{"toolbar-category", null, "Toolbar & Menu Examples", "toolbar-category-icon", null, null, null},
                new Object[]{"toolbarAndMenus", "toolbar-category", "Toolbar & Menus", null, "images/thumbnails/toolbar/toolbar.gif", null, new ToolbarSample()},

                new Object[]{"grids-category", null, "Grids", "grids-category-icon", null, null, null},
                new Object[]{"basicArrayGrid", "grids-category", "Basic Array Grid", null, "images/thumbnails/grid/grid-array.gif", null, new BasicArrayGridSample()},
                new Object[]{"propertyGrid", "grids-category", "Property Grid", null, "images/thumbnails/grid/property.gif", null, new PropertyGridSample()},
                new Object[]{"gridGrouping", "grids-category", "Grid Grouping", null, "images/thumbnails/grid/grid-grouping.gif", null, new GridGroupingSample()},
                new Object[]{"checkboxSelectionGrid", "grids-category", "Checkbox Row Selection", null, null, null, new CheckboxSelectionSample()},
                new Object[]{"numberedRowsGrid", "grids-category", "Numbered Rows", null, "images/thumbnails/grid/grid-numbered.gif", null, new NumberedRowsSample()},
                new Object[]{"jsonGrid", "grids-category", "Json Grid", null, null, null, new JsonGridSample()},
                new Object[]{"localJsonGrid", "grids-category", "Local Json Grid", null, null, null, new LocalJsonGridSample()},
                new Object[]{"localXmlGrid", "grids-category", "Local XML Grid", null, "images/thumbnails/grid/grid-xml.gif", null, new LocalXmlGridSample()},
                new Object[]{"editableGrid", "grids-category", "Editable Grid", null, "images/thumbnails/grid/grid-edit.gif", null, new EditableGridSample()},
                new Object[]{"localPagingGrid", "grids-category", "Grid with Local Paging", null, "images/thumbnails/grid/grid-local-paging.gif", null, new LocalPagingSample()},
                new Object[]{"remotePagingGrid", "grids-category", "Grid with Remote Paging", null, "images/thumbnails/grid/grid-paging.gif", null, new RemotePagingSample()},
                new Object[]{"gridEvents", "grids-category", "Grid Events", null, null, null, new GridEventsSample()},
                new Object[]{"listGrid", "grids-category", "Grid as List box", null, null, null, new ListGridSample()},
                new Object[]{"largeGrid", "grids-category", "Large Grid", null, null, null, new LargeGridSample()},

                new Object[]{"forms-category", null, "Forms", "forms-category-icon", null, null, null},
                new Object[]{"anchoringForm", "forms-category", "Anchoring", null, null, null, new AnchoringSample()},
                new Object[]{"simpleForm", "forms-category", "Simple", null, null, null, new SimpleFormSample()},
                new Object[]{"fieldSetForm", "forms-category", "FieldSet", null, "images/thumbnails/forms/form-fieldset.gif", null, new FieldSetsSample()},
                new Object[]{"multiColumnForm", "forms-category", "Multi Column", null, "images/thumbnails/forms/form-multi-column.gif", null, new MultiColumnFormPanel()},
                new Object[]{"loadSubmitXmlForm", "forms-category", "Load / Submit", null, "images/thumbnails/forms/form-xml.gif", null, new XmlFormSample()},
                new Object[]{"multipleFieldForm", "forms-category", "Multiple Fields on Row", null, "images/thumbnails/forms/form-multi-field.gif", null, new MultiFieldFormSample()},
                new Object[]{"formAsTab", "forms-category", "Form as Tab", null, null, null, new FormAsTabSample()},
                new Object[]{"formWithTab", "forms-category", "Form with Tab", null, "images/thumbnails/forms/form-tabs.gif", null, new FormWithTabSample()},
                new Object[]{"formGrid", "forms-category", "Form Grid Binding", null, "images/thumbnails/forms/form-grid.gif", null, new FormGridSample()},
                new Object[]{"itemSelectorForm", "forms-category", "Dual Item Selector", null, "images/thumbnails/forms/item-selector.gif", null, new ItemSelectorSample()},

                new Object[]{"tabs-category", null, "Tab Panels", "tabs-category-icon", null, null, null},
                new Object[]{"dynamicTabPanel", "tabs-category", "Dynamic Tabs", null, "images/thumbnails/tabs/tabs-adv.gif", null, new TabPanelSample()},
                new Object[]{"bottomTabPanel", "tabs-category", "Bottom Tabs", null, "images/thumbnails/tabs/tabs-bottom.gif", null, new BottomTabPanelSample()},

                new Object[]{"combination-category", null, "Combination Samples", "combination-category-icon", null, null, null},
                new Object[]{"chartGenerator", "combination-category", "Dion's Chart Generator", null, "images/thumbnails/combination/chart-generator.gif", null, new ChartGeneratorSample()},

                new Object[]{"dd-category", null, "Drag & Drop", "dd-category-icon", null, null, null},
                new Object[]{"basicDD", "dd-category", "Basic", null, null, null, new BasicDDSample()},
                new Object[]{"onTopDD", "dd-category", "On Top", null, null, null, new BasicOnTopSample()},

                new Object[]{"misc-category", null, "Miscellaneous", "misc-category-icon", null, "Miscellaneous", null},
                new Object[]{"dataView", "misc-category", "Data View", "dataview-nav-icon", null, null, new DataViewSample()},
                new Object[]{"progressBar", "misc-category", "Progress Bar", "progressbar-nav-icon", "images/thumbnails/misc/progressbar.gif", null, new ProgressBarSample()},
                new Object[]{"colorPicker", "misc-category", "Color Picker", "colorpicker-nav-icon", null, null, new ColorPaletteSample()},
                new Object[]{"datePicker", "misc-category", "Date Picker", "datepicker-nav-icon", null, null, new DatePickerSample()},
                new Object[]{"tooltips", "misc-category", "Tooltips", null, "images/thumbnails/misc/tooltip.gif", null, new ToolTipTypesSample()},
                new Object[]{"mask", "misc-category", "Mask Demo", "mask-nav-icon", "images/thumbnails/misc/mask.gif", null, new MaskingSample()},
                new Object[]{"portal", "misc-category", "Portal Demo", null, null, null, new PortalSample()},

                new Object[]{"user-category", null, "User Contributions", "user-icon", null, "User Contributions", null},
                new Object[]{"imageChooser", "user-category", "Image Chooser", null, "images/thumbnails/combination/chooser.gif", null, new ImageChooserSample()}

        };
    }
}
