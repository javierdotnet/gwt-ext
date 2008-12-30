package com.gwtext.client.widgets.tree;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtext.client.data.NodeModel;

public interface NodeModelServiceAsync {
	public void getTreeNodeModel(NodeModel curNode, AsyncCallback callback);
}
