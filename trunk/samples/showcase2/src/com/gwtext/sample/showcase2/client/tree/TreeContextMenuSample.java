/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.sample.showcase2.client.tree;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.Node;
import com.gwtext.client.data.NodeTraversalCallback;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.menu.BaseItem;
import com.gwtext.client.widgets.menu.Item;
import com.gwtext.client.widgets.menu.Menu;
import com.gwtext.client.widgets.menu.event.BaseItemListenerAdapter;
import com.gwtext.client.widgets.tree.TreeEditor;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.event.TreePanelListenerAdapter;
import com.gwtext.sample.showcase2.client.OutlookTreePanel;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class TreeContextMenuSample extends ShowcasePanel {

	private Menu menu;
	private TreeNode ctxNode;
	private TreeEditor treeEditor;

	public String getSourceUrl() {
		return "source/tree/TreeContextMenuSample.java.html";
	}

	public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();

			final TreePanel treePanel = new OutlookTreePanel();

			TextField field = new TextField();
			field.setSelectOnFocus(true);
			treeEditor = new TreeEditor(treePanel, field);

			treePanel.setWidth(190);
			treePanel.setHeight(400);

			TreeNode root = new TreeNode();

			treePanel.addListener(new TreePanelListenerAdapter() {
				public void onContextMenu(TreeNode node, EventObject e) {
					int[] xy = e.getXY();
					showContextMenu(node, e);
				}
			});

			panel.add(treePanel);
		}
		return panel;
	}

	private void showContextMenu(final TreeNode node, EventObject e) {
		if (menu == null) {
			menu = new Menu();
			Item editItem = new Item("Edit", new BaseItemListenerAdapter() {
				public void onClick(BaseItem item, EventObject e) {
					treeEditor.startEdit(ctxNode);
				}
			});
			editItem.setId("edit-item");
			menu.addItem(editItem);

			Item disableItem = new Item("Disable", new BaseItemListenerAdapter() {
				public void onClick(BaseItem item, EventObject e) {
					ctxNode.disable();
					ctxNode.cascade(new NodeTraversalCallback() {
						public boolean execute(Node node) {
							((TreeNode) node).disable();
							return true;
						}
					});
				}
			});
			disableItem.setId("disable-item");
			menu.addItem(disableItem);

			Item enableItem = new Item("Enable", new BaseItemListenerAdapter() {
				public void onClick(BaseItem item, EventObject e) {
					ctxNode.enable();
					ctxNode.cascade(new NodeTraversalCallback() {
						public boolean execute(Node node) {
							((TreeNode) node).enable();
							return true;
						}
					});
				}
			});
			enableItem.setId("enable-item");
			menu.addItem(enableItem);

			Item cloneItem = new Item("Clone", new BaseItemListenerAdapter() {
				public void onClick(BaseItem item, EventObject e) {
					TreeNode clone = ctxNode.cloneNode();
					clone.setText("Copy of " + clone.getText());
					ctxNode.getParentNode().appendChild(clone);
					treeEditor.startEdit(clone);
				}
			});
			cloneItem.setId("clone-item");
			menu.addItem(cloneItem);

			Item deleteItem = new Item("Delete", new BaseItemListenerAdapter() {
				public void onClick(BaseItem item, EventObject e) {
					ctxNode.getParentNode().removeChild(ctxNode);
					ctxNode.destroy();
				}
			});
			deleteItem.setId("delete-item");
			deleteItem.setIconCls("delete-icon");
			//menu.addItem(deleteItem);

			Item newFolderItem = new Item("New Folder", new BaseItemListenerAdapter() {
				public void onClick(BaseItem item, EventObject e) {
					TreeNode newFolder = new TreeNode("New Folder");
					ctxNode.getParentNode().appendChild(newFolder);
					treeEditor.startEdit(newFolder);
				}
			});
			newFolderItem.setId("newfolder-item");
			menu.addItem(newFolderItem);
		}

		if (ctxNode != null) {
			ctxNode = null;
		}
		ctxNode = node;

		/*
		if (ctxNode.getDepth() < 2) {
			menu.getItem("delete-item").disable();
		} else {
			menu.getItem("delete-item").enable();
		}*/

		if (ctxNode.isDisabled()) {
			menu.getItem("disable-item").disable();
			menu.getItem("enable-item").enable();
		} else {
			menu.getItem("disable-item").enable();
			menu.getItem("enable-item").disable();
		}
		menu.showAt(e.getXY());
	}
}