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
package com.gwtext.client.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.NameValuePair;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.tree.AsyncTreeNode;
import com.gwtext.client.widgets.tree.ColumnNodeUI;
import com.gwtext.client.widgets.tree.NodeModelServiceAsync;
import com.gwtext.client.widgets.tree.NodeModelTreeLoader;
import com.gwtext.client.widgets.tree.TreeNode;

public class NodeModel implements IsSerializable {

	/**
	 * children
	 * 
	 * @gwt.typeArgs <java.lang.String>
	 */
	protected static ArrayList attributesAllowed = new ArrayList() {
		{
			add(new String("disabled"));
			add(new String("id"));
			add(new String("allowChildren"));
			add(new String("allowDrag"));
			add(new String("allowDrop"));
			add(new String("checked"));
			add(new String("cls"));
			add(new String("draggable"));
			add(new String("expandable"));
			add(new String("expanded"));
			add(new String("href"));
			add(new String("hrefTarget"));
			add(new String("icon"));
			add(new String("iconCls"));
			add(new String("id"));
			add(new String("isTarget"));
			add(new String("leaf"));
			add(new String("qtip"));
			add(new String("qtipCfg"));
			add(new String("singleClickExpand"));
			add(new String("text"));
		}
	};

	/**
	 * children
	 * 
	 * @gwt.typeArgs <com.gwtext.client.data.NodeModel>
	 */
	protected ArrayList children = new ArrayList();

	/**
	 * properties
	 * 
	 * @gwt.typeArgs 
	 *               <java.lang.String,com.google.gwt.user.client.rpc.IsSerializable
	 *               >
	 */
	protected HashMap properties = new HashMap();

	/**
	 * local not-serialized listeners
	 */
	private transient ArrayList listeners = new ArrayList();

	private transient NodeModelServiceAsync asynchChildren = null;
	
	private transient TreeNode treeNode = null;
	private transient String[] columnDataName = null;
	
	private boolean asyncChildrenCalled = false;

	/**
	 * Empty constructor
	 */
	public NodeModel() {
		//properties.put("id", Ext.generateId());
	}

	/**
	 * Constructor that accepts properties
	 * 
	 * @param properties
	 */
	public NodeModel(HashMap properties) {
		this.properties = properties;
//		if(!properties.containsKey("id")){
//			properties.put("id", Ext.generateId());
//		}
	}

	/**
	 * Constructor that accepts Node
	 * 
	 * @param root
	 */
	public NodeModel(Node root) {
		setAs(root);
//		if(!properties.containsKey("id")){
//			properties.put("id", Ext.generateId());
//		}
	}

	public void addListener(NodeModelListener listener) {
		this.listeners.add(listener);
	}

	public void removeListener(NodeModelListener listener) {
		this.listeners.remove(listener);
	}

	/**
	 * This method add a child node and all its children to this NodeModel
	 * 
	 * @param child
	 *            a Node instance with properties and children values
	 */
	public void addChild(Node child) {
		addChild(this, child);
	}

	/**
	 * Add a node as a this model node (root)
	 * 
	 * @param root
	 *            the node to be the NodeModel
	 */
	public void setAs(Node root) {
		String propName[] = root.getProperties();
		for (int i = 0; i < propName.length; i++) {
			addProperty(propName[i], root.getAttributeAsObject(propName[i]));
		}

		Node children[] = root.getChildNodes();
		if (children != null && children.length > 0) {
			for (int i = 0; i < children.length; i++) {
				addChild(this, children[i]);
			}
		}
	}
	
	public boolean addChild(NodeModel child){
		return addChild(child, getChildSize());
	}
	
	/**
	 * Recursive method that adds node to a given root NodeModel
	 * 
	 * @param rootNode
	 *            the root NodeModel to add the child node to
	 * @param child
	 *            the child not to add with all its children
	 */
	protected boolean addChild(NodeModel rootNode, Node child) {
		NodeModel childModel = new NodeModel();
		String propName[] = child.getProperties();
		for (int i = 0; i < propName.length; i++) {
			childModel.addProperty(propName[i], child.getAttributeAsObject(propName[i]));
		}

		Node children[] = child.getChildNodes();
		if (children != null && children.length > 0) {
			for (int i = 0; i < children.length; i++) {
				childModel.addChild(childModel, children[i]);
			}
		}

		return rootNode.addChild(childModel, rootNode.getChildSize());

	}

	/**
	 * Gets the current direct number of children
	 * 
	 * @return the number of direct children
	 */
	public int getChildSize() {
		return children.size();
	}

	/**
	 * adds a NodeModel as a child of this NodeModel in a specific location
	 * 
	 * @param child
	 * @param index
	 */
	public boolean addChild(NodeModel child, int index) {
		boolean added = false;

		if (index == getChildSize()) {
			children.add(index, child);
			notifyAppendListeners(child);
			added = true;
		} else if (index < getChildSize()) {
			children.add(index, child);
			notifyInsertListeners(child, index);
			added = true;
		}

		return added;
	}

	/**
	 * adds a property to this NodeModel
	 * 
	 * @param name
	 *            name of the NodeModel property
	 * @param value
	 *            the value given to the property
	 */
	public void addProperty(String name, Object value) {
		addProperty(name, value, false);
	}

	/**
	 * adds a property to this NodeModel
	 * 
	 * @param name
	 *            name of the NodeModel property
	 * @param value
	 *            the value given to the property
	 * @param force
	 *            add even if the property is not in the allow list
	 */
	public void addProperty(String name, Object value, boolean force) {
		if (force || attributesAllowed.contains(name)){
			properties.put(name, value);
			notifyUpdateListeners(name, value);
		}
	}

	/**
	 * gets the property as an Object
	 * 
	 * @param name
	 *            the name of the property needed
	 * @return the property object instance
	 */
	public Object getPropertyAsObject(String name) {
		return properties.get(name);
	}

	/**
	 * gets the property as an String
	 * 
	 * @param name
	 *            the name of the property needed
	 * @return the property String instance
	 */
	public String getProperty(String name) {
		Object obj = properties.get(name);
		if (obj == null)
			return null;

		if (obj instanceof Boolean) {
			if (((Boolean) obj).booleanValue()) {
				return "true";
			} else {
				return "false";
			}
		}
		return obj.toString();

	}
	
	public HashMap getProperties(){
		return properties;
	}

	/**
	 * get the child of an specific index
	 * 
	 * @param index
	 *            integer value for the index
	 * @return the NodeModel child for the index given
	 */
	public NodeModel getChild(int index) {
		if ((index < 0) || (index >= getChildSize()))
			return null;
		return (NodeModel) children.get(index);
	}

	/**
	 * this method tells this class if the children are fetched
	 * asynchronously.
	 * @param asyncChildren the interface to implement to get the children
	 */
	public void setAsynchChildren(NodeModelServiceAsync asyncChildren){
		this.asynchChildren  = asyncChildren;
	}
	/**
	 * Gets the complete list of direct children
	 * 
	 * @return ArrayList of the direct children
	 */
	public ArrayList getChildren() {
//		if(!asyncChildrenCalled && asynchChildren != null){
//			children = asynchChildren.getChildren(this);
//			asyncChildrenCalled = true;
//		}
		return children;
	}

	/**
	 * removes all children for this NodeModel recursively
	 */
	public void removeAllChildren() {
		int size = getChildSize();
		for (int i = 0; i < size; i++) {
			remove((NodeModel) children.get(0));
		}
	}

	public void remove(NodeModel child) {
		if (children.contains(child)) {
			child.removeAllChildren();
			children.remove(child);
			notifyRemoveListeners(child);
		}
	}

	public NodeModel findById(String id) {
		NodeModel ret = null;

		if (((String) this.properties.get("id")).equals(id))
			return this;

		for (int i = 0; i < getChildSize(); i++) {
			ret = ((NodeModel) children.get(i)).findById(id);
			if (ret != null)
				break;
		}
		return ret;
	}

	/**
	 * returns the JsonVersion that can be used to pass to the AsyncTreeNode
	 * directly.
	 * 
	 * @return the JsonVersion of the node and its children
	 */
	public JavaScriptObject getJsonVersion() {
		return getJsonVersion(this);
	}
	
	private JavaScriptObject getJsonVersion(NodeModel root) {
		JavaScriptObject jsObject = getJsonChildren(root);
		
		if(children.size() > 0){
			JavaScriptObject childrenArray = JavaScriptObjectHelper.createJavaScriptArray();
			
			for (int i = 0; i < children.size(); i++) {
				JavaScriptObjectHelper.setArrayValue(childrenArray, i, getJsonChildren((NodeModel)children.get(i)));
				if(((NodeModel)children.get(i)).getChildSize() > 0)
					return getJsonVersion((NodeModel)children.get(i));
			}
			
			JavaScriptObjectHelper.setAttribute(jsObject, "children", childrenArray);
		}
		
		return jsObject;
	}
	
	public JavaScriptObject getJsonChildren(NodeModel curModel) {
		JavaScriptObject jsObject = JavaScriptObjectHelper.createObject();
		Iterator it = curModel.properties.keySet().iterator();

		while (it.hasNext()) {
			String name = (String) it.next();
			Object value = curModel.properties.get(name);
			
			if (value instanceof Boolean) {
				JavaScriptObjectHelper.setAttribute(jsObject, name, ((Boolean) value).booleanValue());
			} else if (value instanceof Integer) {
				JavaScriptObjectHelper.setAttribute(jsObject, name, ((Integer) value).intValue());
			} else if (value instanceof String) {
				JavaScriptObjectHelper.setAttribute(jsObject, name, (String) value);
			} else if (value instanceof Double) {
				JavaScriptObjectHelper.setAttribute(jsObject, name, ((Double) value).doubleValue());
			} else if (value instanceof Float) {
				JavaScriptObjectHelper.setAttribute(jsObject, name, ((Float) value).floatValue());
			} else if (value instanceof Date) {
				JavaScriptObjectHelper.setAttribute(jsObject, name, (Date) value);
			} else if (value instanceof JavaScriptObject) {
				JavaScriptObjectHelper.setAttribute(jsObject, name, (JavaScriptObject) value);
			} else {
				JavaScriptObjectHelper.setAttribute(jsObject, name, value);
			}
		}

		return jsObject;
	}


	public Node getNode() {
		return getNode(this);
	}
	
	private Node getNode(NodeModel nodeModel){
		Node node = new Node();
		Iterator iter = nodeModel.properties.keySet().iterator();
		
		while (iter.hasNext()) {
			String key = (String)iter.next();
			Object value = nodeModel.getPropertyAsObject(key);
			node.setAttribute(key, value);
		}
		if(nodeModel.children.size() > 0){
			for (int i = 0; i < nodeModel.children.size(); i++) {
				node.appendChild(getNode(nodeModel.getChild(i)));
			}
			
		}
		return node;
	}
	
	public void setTreeNode(TreeNode node){
		treeNode = node;
	}
	
	public TreeNode getTreeNode(){
		return treeNode;
	}
	
	public void setColumnDataName(String[] columnDataName){
		this.columnDataName = columnDataName;
	}
	
	public String[] getColumnDataName(){
		return columnDataName;
	}
	
	private TreeNode createTreeNode(NodeModel nodeModel){
		TreeNode tnode = null;
		
		if(columnDataName != null){
			NameValuePair nodeData[] = new NameValuePair[columnDataName.length];

			for (int i = 0; i < columnDataName.length; i++) {
				String value = nodeModel.getProperty(columnDataName[i]);
				if(value != null)
					nodeData[i] = new NameValuePair(columnDataName[i], value);
				else
					nodeData[i] = new NameValuePair(columnDataName[i], "");

			}

			tnode = ColumnNodeUI.getNewTreeNode(nodeData);			
		}else{
			tnode = new TreeNode();
		}
		
		tnode.setNodeModel(nodeModel);
		HashMap props = nodeModel.getProperties();
		
		Iterator iter = props.keySet().iterator();
			
		while (iter.hasNext()) {
			String key = (String)iter.next();
			Object value = nodeModel.getPropertyAsObject(key);
			tnode.setAttribute(key, value);
		}
		
		return tnode;
	}
	
	////////////////////////////Notification event methods ////////////////////////////////
	
	protected void notifyAppendListeners(NodeModel newNode) {
		for (int i = 0; i < listeners.size(); i++) {
			NodeModelListener listener = (NodeModelListener) listeners.get(i);
			listener.onAppend(this, newNode);
		}
		if(treeNode != null){
			treeNode.appendChild(createTreeNode(newNode));
		}
	}
	
	protected void notifyInsertListeners(NodeModel newNode, int index) {
		for (int i = 0; i < listeners.size(); i++) {
			NodeModelListener listener = (NodeModelListener) listeners.get(i);
			listener.onInsert(this, newNode, index);
		}
		if(treeNode != null){
			Node node[] = treeNode.getChildNodes();
			treeNode.insertBefore(createTreeNode(newNode), node[index]);
		}
	}
	
	protected void notifyRemoveListeners(NodeModel node) {
		for (int i = 0; i < listeners.size(); i++) {
			NodeModelListener listener = (NodeModelListener) listeners.get(i);
			listener.onRemove(this, node);
		}
		if(treeNode != null){
			treeNode.removeChild(node.getTreeNode());
		}
	}
	
	protected void notifyUpdateListeners(String name, Object value) {
		for (int i = 0; i < listeners.size(); i++) {
			NodeModelListener listener = (NodeModelListener) listeners.get(i);
			listener.onUpdate(this, name, value);
		}
	}
	
}
