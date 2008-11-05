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
import com.gwtext.client.core.NameValuePair;

public class ColumnNodeUI extends TreeNodeUI {
	
	public ColumnNodeUI(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public static ColumnNodeUI instance(){
		return new ColumnNodeUI(create());
	}
	
    private static ColumnNodeUI instance(JavaScriptObject jsObj) {
        return new ColumnNodeUI(jsObj);
    }
	
    public native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.tree.ColumnNodeUI(config);
	}-*/;
    
    protected static native JavaScriptObject create() /*-{
		return new $wnd.Ext.tree.ColumnNodeUI();
	}-*/;
    
    public native static JavaScriptObject getUiProvider()/*-{
    	var colui = {};
		colui['col'] = $wnd.Ext.tree.ColumnNodeUI
		return colui;
    }-*/;
    
    public static TreeNode getNewTreeNode(NameValuePair[] values){
    	ColumnTreeNode newTreeNode = new ColumnTreeNode();
    	for (int i = 0; i < values.length; i++) {
			if(values[i].getType() == NameValuePair.BOOLEAN){
				newTreeNode.setColumnValue(values[i].getName(), values[i].getValueAsBoolean());
			}
			else if(values[i].getType() == NameValuePair.STRING){
				newTreeNode.setColumnValue(values[i].getName(), values[i].getValue());
			}
			else if(values[i].getType() == NameValuePair.FLOAT){
				newTreeNode.setColumnValue(values[i].getName(), values[i].getValueAsFloat());
			}
			else if(values[i].getType() == NameValuePair.DATE){
				newTreeNode.setColumnValue(values[i].getName(), values[i].getValueAsDate());
			}
			else if(values[i].getType() == NameValuePair.INT){
				newTreeNode.setColumnValue(values[i].getName(), values[i].getValueAsInt());
			}
		}
    	newTreeNode.setUiProvider(getNewTreeUiProvider());
    	
    	
    	return newTreeNode;
    }
    
    public static AsyncTreeNode getNewAsyncTreeNode(NameValuePair[] values){
    	ColumnAsyncTreeNode newTreeNode = new ColumnAsyncTreeNode();
    	for (int i = 0; i < values.length; i++) {
			if(values[i].getType() == NameValuePair.BOOLEAN){
				newTreeNode.setColumnValue(values[i].getName(), values[i].getValueAsBoolean());
			}
			else if(values[i].getType() == NameValuePair.STRING){
				newTreeNode.setColumnValue(values[i].getName(), values[i].getValue());
			}
			else if(values[i].getType() == NameValuePair.FLOAT){
				newTreeNode.setColumnValue(values[i].getName(), values[i].getValueAsFloat());
			}
			else if(values[i].getType() == NameValuePair.DATE){
				newTreeNode.setColumnValue(values[i].getName(), values[i].getValueAsDate());
			}
			else if(values[i].getType() == NameValuePair.INT){
				newTreeNode.setColumnValue(values[i].getName(), values[i].getValueAsInt());
			}
		}
    	newTreeNode.setUiProvider(getNewTreeUiProvider());
    	
    	
    	return newTreeNode;
    }
    private native static JavaScriptObject getNewTreeUiProvider()/*-{
		return $wnd.Ext.tree.ColumnNodeUI;
	}-*/;
}
