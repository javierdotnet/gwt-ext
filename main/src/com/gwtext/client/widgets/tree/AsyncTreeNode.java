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
import com.gwtext.client.core.Function;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.tree.event.AsyncTreeNodeListener;

/**
 * Provides the abilty to asynchronously lazy load a TreeNodes children. An AsyncTreeNode
 * is assigned a {@link TreeLoader} which is reponsible for fetching the tree data and loading it
 * into the tree as children. The {@link TreeLoader} can be configured to load tree data from remote Json data
 * and {@link com.gwtext.client.widgets.tree.XMLTreeLoader} can be use to load tree data from XML
 * returned from a remote URL.
 *<p>
 * Sample code for loading a Tree node using AsyncTreeNode and XmltreeLoader :
 *
 * <pre>
 * <code>
 *
 *     final TreePanel treePanel = new TreePanel();
 *     treePanel.setAnimate(true);
 *     treePanel.setEnableDD(true);
 *     treePanel.setContainerScroll(true);
 *     treePanel.setRootVisible(true);
 *
 *     final XMLTreeLoader loader = new XMLTreeLoader();
 *     loader.setDataUrl("countries-cb.xml");
 *     loader.setMethod(Connection.GET);
 *     loader.setRootTag("countries");
 *     loader.setFolderIdMapping("@id");
 *     loader.setLeafIdMapping("@id");
 *     loader.setFolderTitleMapping("@title");
 *     loader.setFolderTag("team");
 *     loader.setLeafTitleMapping("@title");
 *     loader.setLeafTag("country");
 *     loader.setQtipMapping("@qtip");
 *     loader.setDisabledMapping("@disabled");
 *     loader.setCheckedMapping("@checked");
 *     loader.setIconMapping("@icon");
 *     loader.setAttributeMappings(new String[]{"@rank"});
 *
 *     AsyncTreeNode root = new AsyncTreeNode("Countries", loader);
 *     treePanel.setRootNode(root);
 *
 *     root.expand();
 *     treePanel.expandAll();
 * </code>
 * </pre>
 *
 * The above code loads a Tree using the following XML data - countries-cb.xml
 *
 * <pre>
 * <code>
 *&lt;countries&gt;
 *    &lt;team id="team-a" title="Team A" icon="images/silk/flag_yellow.gif" checked="true"&gt;
 *        &lt;country title="Brazil" qtip="Rank 2" rank="2"  checked="false"/&gt;
 *        &lt;country title="Canada" qtip="Rank 3" rank="3" checked="false"/&gt;
 *        &lt;country title="China" qtip="Rank 4" rank="4" checked="false"/&gt;
 *    &lt;/team&gt;
 *    &lt;team title="Team B" icon="images/silk/flag_blue.gif"&gt;
 *        &lt;country title="Germany" qtip="Captain" checked="true" rank="1"/&gt;
 *        &lt;country title="France" qtip="Rank 2" rank="2" checked="false"/&gt;
 *        &lt;country title="Canada" qtip="Rank 3" rank="3" checked="false"/&gt;
 *        &lt;country title="India" qtip="Rank 4" rank="4" checked="false"/&gt;
 *        &lt;country title="Seychelles" qtip="Rank 5" rank="5" checked="false"/&gt;
 *    &lt;/team&gt;
 *
 *    &lt;team title="Team C" icon="images/silk/flag_green.gif"&gt;
 *        &lt;country title="United States" qtip="Captain - Rank 1" checked="true" rank="1"/&gt;
 *        &lt;country title="Japan" qtip="Rank 2" rank="2" checked="false"/&gt;
 *        &lt;country title="Italy" qtip="Rank 3" rank="3" checked="false"/&gt;
 *        &lt;country title="Finland" qtip="Rank 4" rank="4" checked="false"/&gt;
 *    &lt;/team&gt;
 *  &lt;/countries&gt;
 * </code>
 * </pre>
 *
 * @author Sanjiv Jivan
 * @see TreeLoader
 * @see com.gwtext.client.widgets.tree.XMLTreeLoader
 */

public class AsyncTreeNode extends TreeNode {

	/**
	 * Construct a new AsyncTreeNode
	 *
	 * @param jsObj
	 */
	public AsyncTreeNode(JavaScriptObject jsObj) {
		super(jsObj);
	}
	/**
	 * Construct a new AsyncTreeNode
	 *
	 * @param treeLoader the tree loader
	 */
	public AsyncTreeNode(TreeLoader treeLoader) {
        setLoader(treeLoader);
    }

	/**
	 * Construct a new AsyncTreeNode
	 *
	 * @param treeLoader the tree loader
	 * @param text the node label / display text
	 */
	public AsyncTreeNode(String text, TreeLoader treeLoader) {
		setText(text);
        setLoader(treeLoader);
    }

	/**
	 * Construct a new AsyncTreeNode
	 *
	 * @param treeLoader the tree loader
	 * @param text the node label / display text
     * @param expanded true to expand
	 */
    public AsyncTreeNode(String text, TreeLoader treeLoader, boolean expanded) {
		setText(text);
        setLoader(treeLoader);
        setExpanded(expanded);
    }

    protected native JavaScriptObject create(JavaScriptObject config)/*-{
        return new $wnd.Ext.tree.AsyncTreeNode(config);
    }-*/;

	/**
	 * Returns true if this node has been loaded.
	 *
	 * @return true if node loaded
	 */
	public native boolean isLoaded() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return node.isLoaded();
    }-*/;

	/**
	 * Returns true if this node is currently loading.
	 *
	 * @return true if node loading
	 */
	public native boolean isLoading() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return node.isLoading();
    }-*/;

	/**
	 * Return the TreeLoader associated with this node.
	 * 
	 * @return the tree loader
	 */
	public native TreeLoader getLoader()/*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var loader = node.loader;
        return @com.gwtext.client.widgets.tree.TreeLoader::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(loader);
    }-*/;

	/**
	 * Trigger a reload for this node.
	 */
    public native void reload() /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        node.reload();
    }-*/;

	/**
	 * Trigger a reload for this node.
	 *
	 * @param callback the callback to execute when the reload is complete
	 */
    public native void reload(Function callback) /*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        node.reload(function() {
                callback.@com.gwtext.client.core.Function::execute()();
			});           
	}-*/;

	/**
	 * Adds an AsyncTreeNode Listener.
	 *
	 * @param listener the listener
	 */
	public native void addListener(AsyncTreeNodeListener listener)/*-{
        var node = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var nodeJ = this;

         node.addListener('beforeload',
                 function(source) {
                    return listener.@com.gwtext.client.widgets.tree.event.AsyncTreeNodeListener::doBeforeLoad(Lcom/gwtext/client/widgets/tree/AsyncTreeNode;)(nodeJ);
			    }
          );

         node.addListener('load',
                 function(source) {
                    listener.@com.gwtext.client.widgets.tree.event.AsyncTreeNodeListener::onLoad(Lcom/gwtext/client/widgets/tree/AsyncTreeNode;)(nodeJ);
			    }
          );
    }-*/;

    //config options     
    public void setLoader(TreeLoader loader) {
        JavaScriptObjectHelper.setAttribute(configJS, "loader", loader.getJsObj());
    }
}
