package com.gwtext.client.widgets.tree;

import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.event.TreePanelListenerAdapter;

public class ColumnTreeListenerAdapter extends TreePanelListenerAdapter implements ColumnTreeListener {

	public boolean onBeforeCellEdit(ColumnTree columnTree, TreeNode node,
			String dataIndex) {
		return true;
	}
}
