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
import com.gwtext.client.core.JsObject;
import com.gwtext.client.widgets.tree.event.DefaultSelectionModelListener;

/**
 * Default Tree selection model. Using this selection model only a single node can be selected.
 * To enable selection of multiple nodes, use {@link com.gwtext.client.widgets.tree.MultiSelectionModel}.
 *
 * @author Sanjiv Jivan
 * @see com.gwtext.client.widgets.tree.MultiSelectionModel
 */
public class DefaultSelectionModel extends JsObject implements TreeSelectionModel {

    /**
     * Construct a DefaultSelectionModel.
     */
    public DefaultSelectionModel() {
        jsObj = create();
    }

    private native JavaScriptObject create() /*-{
        return new $wnd.Ext.tree.DefaultSelectionModel();
    }-*/;

    public DefaultSelectionModel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static DefaultSelectionModel instance(JavaScriptObject jsObj) {
        return new DefaultSelectionModel(jsObj);
    }

    public native void clearSelections() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.clearSelections();
    }-*/;

    public native TreeNode getSelectedNode() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var treeNode = sm.getSelectedNode();
        if(treeNode == null || treeNode === undefined) {
            return null;
        } else  {
            return @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(treeNode);
        }
    }-*/;

    public native boolean isSelected(TreeNode treeNode) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var tn = treeNode.@com.gwtext.client.core.JsObject::getJsObj()();
        return sm.isSelected(tn);
    }-*/;

    public native void select(TreeNode treeNode) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var tn = treeNode.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.select(tn);
    }-*/;

    public native void selectNext() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.selectNext();
    }-*/;

    public native void selectPrevious() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.selectPrevious();
    }-*/;

    public native void unselect(TreeNode treeNode) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var tn = treeNode.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.unselect(tn);
    }-*/;

    public native void addSelectionModelListener(DefaultSelectionModelListener listener)/*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var smJ = this;
        sm.addListener('beforeselect',
                 function(self, newNode, oldNode) {
                    var newNodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(newNode);
                    var oldNodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(oldNode);
                    return listener.@com.gwtext.client.widgets.tree.event.DefaultSelectionModelListener::doBeforeSelect(Lcom/gwtext/client/widgets/tree/DefaultSelectionModel;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/widgets/tree/TreeNode;)(smJ, newNodeJ, oldNodeJ);
			    }
          );

        sm.addListener('selectionchange',
                 function(self, node) {                     
                    var nodeJ = node == null ? null : @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                    listener.@com.gwtext.client.widgets.tree.event.DefaultSelectionModelListener::onSelectionChange(Lcom/gwtext/client/widgets/tree/DefaultSelectionModel;Lcom/gwtext/client/widgets/tree/TreeNode;)(smJ, nodeJ);
			    }
          );    
    }-*/;
}
