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

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;


public class ColumnTreeNode extends TreeNode{
	public ColumnTreeNode() {
		super();
	}
	
	public void setColumnValue(String dataIndex, String value){
		setTreeAttribute(dataIndex, value);
	}
	
	public void setColumnValue(String dataIndex, int value){
		setTreeAttribute(dataIndex, value);
	}
	
	public void setColumnValue(String dataIndex, float value){
		setTreeAttribute(dataIndex, value);
	}
	
	public void setColumnValue(String dataIndex, boolean value){
		setTreeAttribute(dataIndex, value);
	}

	public void setColumnValue(String dataIndex, Date value){
		setTreeAttribute(dataIndex, value);
	}

	public void setColumnValue(String dataIndex, JavaScriptObject value){
		setTreeAttribute(dataIndex, value);
	}
}