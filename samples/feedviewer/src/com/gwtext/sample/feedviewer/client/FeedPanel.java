package com.gwtext.sample.feedviewer.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Ext;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.ButtonConfig;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.menu.BaseItem;
import com.gwtext.client.widgets.menu.Item;
import com.gwtext.client.widgets.menu.ItemConfig;
import com.gwtext.client.widgets.menu.Menu;
import com.gwtext.client.widgets.menu.event.BaseItemListenerAdapter;
import com.gwtext.client.widgets.menu.event.MenuListenerAdapter;
import com.gwtext.client.widgets.tree.*;
import com.gwtext.client.widgets.tree.event.DefaultSelectionModelListener;
import com.gwtext.client.widgets.tree.event.TreePanelListenerAdapter;

/**
 * Feed panel that has a tree view of the feeds added along with a toolbar to add/ remove feeds.
 */
public class FeedPanel extends Composite {

    private TreePanel treePanel;
    private TreeNode feeds;
    private Menu menu;
    private TreeNode ctxNode;
    private FeedWindow win;

    public FeedPanel() {
        this.treePanel = new TreePanel("feed-tree", new TreePanelConfig() {
            {
                setContainerScroll(true);
                setAnimate(true);
                setRootVisible(false);
            }
        });
        TreeNode root = new TreeNode("Feed Viewer");
        treePanel.setRootNode(root);
        treePanel.render();

        root.expand(false, true);

        Toolbar tbar = new Toolbar(Ext.generateId());
        tbar.addButton(new ToolbarButton("Add Feed", new ButtonConfig() {
            {
                setAutoCreate(true);
                setIconCls("add-feed");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        showWindow(button);
                    }
                });          
            }
        }));

        tbar.addButton(new ToolbarButton("Remove", new ButtonConfig() {
            {
                setIconCls("delete-icon");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        TreeNode node = treePanel.getSelectionModel().getSelectedNode();
                        if (node != null) {
                            String url = node.getId();
                            removeFeed(url);
                        }
                    }
                });
            }
        }));

        feeds = new TreeNode(new TreeNodeConfig() {
            {
                setText("My Feeds");
                setCls("feeds-node");
                setExpanded(true);

            }
        });
        root.appendChild(feeds);

        treePanel.addTreePanelListener(new TreePanelListenerAdapter() {

            public void onContextMenu(TreeNode node, EventObject e) {
                showContextMenu(node, e);
            }
        });

        VerticalPanel vp = new VerticalPanel();
        vp.setWidth("100%");
        vp.add(tbar);
        vp.add(treePanel);
        initWidget(vp);
    }

    public void addFeedListener(final FeedListener listener) {
        treePanel.getSelectionModel().addSelectionModelListener(new DefaultSelectionModelListener() {
            public boolean doBeforeSelect(DefaultSelectionModel sm, TreeNode newNode, TreeNode oldNode) {
                return newNode.isLeaf();
            }

            public void onSelectionChange(DefaultSelectionModel sm, TreeNode node) {
                if (node != null) {
                    String url = node.getId();
                    String name = node.getText();
                    listener.onSelect(name, url);
                }
            }
        });
    }

    public void showWindow(Button btn) {
        if (win == null) {
            win = new FeedWindow();
            win.addValidFeedListener(new ValidFeedListener() {
                public void onValid(String url, String text) {
                    addFeed(url, text, true, true);
                }
            });
        }
        win.show(btn);
    }

    public void removeFeed(String url) {
        TreeNode node = treePanel.getNodeById(url);
        if (node != null) {
            node.unselect();
            node.getParentNode().removeChild(node);
        }
    }

    public void addFeed(final String url, final String text, boolean inactive, boolean preventAnim) {
        TreeNode node = treePanel.getNodeById(url);
        if (node != null) {
            if (!inactive) {
                node.select();
            }
            return;
        }
        node = new TreeNode(new TreeNodeConfig() {
            {
                setIconCls("feed-icon");
                setLeaf(true);
                setCls("feed");
                setId(url);
                setText(text);
            }
        });
        feeds.appendChild(node);
        if (!inactive) {
            if (!preventAnim) {
                node.select();
            } else {
                node.select();
            }
        }
    }

    private void showContextMenu(TreeNode node, EventObject e) {
        //create context menu on first right click
        if (menu == null) {
            menu = new Menu("feeds-ctx");
            menu.addItem(new Item("Load Feed", new ItemConfig() {
                {
                    setId("load");
                    setIconCls("load-icon");
                    setBaseItemListener(new BaseItemListenerAdapter() {
                        public void onClick(BaseItem item, EventObject e) {
                            ctxNode.select();
                        }
                    });
                }
            }));

            menu.addItem(new Item("Remove", new ItemConfig() {
                {
                    setIconCls("delete-icon");
                    setBaseItemListener(new BaseItemListenerAdapter() {
                        public void onClick(BaseItem item, EventObject e) {
                            String url = ctxNode.getId();
                            removeFeed(url);
                            ctxNode = null;
                        }
                    });
                }
            }));
            menu.addItem(new Item("Add Feed", new ItemConfig() {
                {
                    setIconCls("add-feed");
                    setBaseItemListener(new BaseItemListenerAdapter() {
                        public void onClick(BaseItem item, EventObject e) {
                            showWindow(null);
                        }
                    });
                }
            }));

            menu.addMenuListener(new MenuListenerAdapter() {
                public void onHide(Menu menu) {
                    if (ctxNode != null) {
                        ctxNode = null;
                    }
                }
            });
        }

        if (ctxNode != null) {
            ctxNode = null;
        }

        if (node.isLeaf()) {
            ctxNode = node;
            menu.getItem("load").setDisabled(node.isSelected());
            menu.showAt(e.getXY());
        }
    }
}
