package com.gwtext.client.widgets.tree;

import com.gwtext.client.widgets.tree.event.TreePanelListener;

public interface ColumnTreeListener extends TreePanelListener{
	public boolean onBeforeCellEdit(ColumnTree columnTree, TreeNode node, String dataIndex);
}
