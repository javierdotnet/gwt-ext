/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.data.Node;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class ColumnTree extends TreePanel {

	private JavaScriptObject configPrototype = null;
	private Column cols[] =null;

	static {
		init();
	}

	private static native void init()/*-{
        var c = new $wnd.Ext.tree.ColumnTree();
        @com.gwtextux.client.widgets.tree.ColumnTree::configPrototype = c.initialConfig;
    }-*/;

	public ColumnTree(){
		super();
	}
	
	public ColumnTree(JavaScriptObject jsObj) {
		super(jsObj);
	}
	
	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "columntree";
	}
	
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.tree.ColumnTree(config);
	}-*/;
    
	/**
	 * Add a ColumnTree listener.
	 *
	 * @param listener the listener
	 */
	public native void addListener(ColumnTreeListener listener)/*-{
        this.@com.gwtext.client.widgets.tree.TreePanel::addListener(Lcom/gwtext/client/widgets/tree/event/TreePanelListener;)(listener);

        var colTreeJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforecelledit',
            function(tree, node, dataIndex) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::treeNodeInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                return listener.@com.gwtextux.client.widgets.tree.ColumnTreeListener::onBeforeCellEdit(Lcom/gwtextux/client/widgets/tree/ColumnTree;Lcom/gwtext/client/widgets/tree/TreeNode;Ljava/lang/String;)(this, nodeJ, dataIndex);
            }
        );
	}-*/;
	
	public native Node getSelectedNode() /*-{
		var tree = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		var nodeSelected = tree.getSelectionModel().getSelectedNode();
		return @com.gwtext.client.widgets.tree.TreeNode::treeNodeInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(nodeSelected);
	}-*/;
    
    public void setColumns(Column column[]){
		this.cols = column;
		JavaScriptObject columnArray = JavaScriptObjectHelper.createJavaScriptArray();
		for (int i = 0; i < cols.length; i++) {
			JavaScriptObject newObj = JavaScriptObjectHelper.createObject();
			JavaScriptObjectHelper.setAttribute(newObj, "header", column[i].getHeader());
			JavaScriptObjectHelper.setAttribute(newObj, "width", column[i].getWidth());
			JavaScriptObjectHelper.setAttribute(newObj, "dataIndex", column[i].getDataIndex());
			JavaScriptObjectHelper.setArrayValue(columnArray, i, newObj);
		}
		JavaScriptObjectHelper.setAttribute(config, "columns", columnArray);
    }
    
    public class Column{

		protected String header = "";
    	protected int width = 0;
    	protected String dataIndex = "";
    	
    	public Column(){
    		
    	}
    	public Column(String header, int width, String dataIndex){
    		setHeader(header);
    		setWidth(width);
    		setDataIndex(dataIndex);
    	}
    	
    	public String getHeader() {
			return header;
		}
		public void setHeader(String header) {
			this.header = header;
		}
		public int getWidth() {
			return width;
		}
		public void setWidth(int width) {
			this.width = width;
		}
		public String getDataIndex() {
			return dataIndex;
		}
		public void setDataIndex(String dataIndex) {
			this.dataIndex = dataIndex;
		}
    }
}
