package com.gwtext.sample.charts.client;

import com.google.gwt.user.client.History;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.tree.TreeFilter;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.event.TreeNodeListenerAdapter;
import com.gwtext.sample.charts.client.yui.ColumnChartSkinnedSample;
import com.gwtext.sample.charts.client.yui.IncomeChartSample;
import com.gwtext.sample.charts.client.yui.LineChartSample;
import com.gwtext.sample.charts.client.yui.PieChartSample;

public class ScreenManager {
    private static Store store;
    private TabPanel appTabPanel;
    private TreeFilter treeFilter;
    private TreePanel treePanel;

    public ScreenManager(TabPanel tabPanel) {
        this.appTabPanel = tabPanel;
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
                if (iconCls != null) {
                    panel.setIconCls(iconCls);
                }
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
        treePanel.expandAll();
        return treePanel;
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
                new Object[]{"yui-charts-category", null, "YUI Charts", "chart-icon", null, null, null},
                new Object[]{"lineChart", "yui-charts-category", "Line Chart", "line-chart-icon", null, null, new LineChartSample()},
                new Object[]{"incomeChart", "yui-charts-category", "Income Chart Sample", "income-chart-icon", null, null, new IncomeChartSample()},
                new Object[]{"pieChart", "yui-charts-category", "Pie Chart", "pie-chart-icon", null, null, new PieChartSample()},
                new Object[]{"columnChart", "yui-charts-category", "Column Chart Skinned", "bar-chart-icon", null, null, new ColumnChartSkinnedSample()}
        };
    }
}