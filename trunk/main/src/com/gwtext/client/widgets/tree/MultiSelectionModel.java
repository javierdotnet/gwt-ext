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
import com.gwtext.client.widgets.tree.event.MultiSelectionModelListener;

/**
 * Selection model for multi selecting tree nodes.
 *
 * @author Sanjiv Jivan
 * @see com.gwtext.client.widgets.tree.DefaultSelectionModel
 */
public class MultiSelectionModel extends JsObject implements TreeSelectionModel {

    public MultiSelectionModel() {
        jsObj = create();
    }

    private native JavaScriptObject create() /*-{
        return new $wnd.Ext.tree.MultiSelectionModel();   
    }-*/;

    public MultiSelectionModel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static MultiSelectionModel instance(JavaScriptObject jsObj) {
        return new MultiSelectionModel(jsObj);
    }

    public native void clearSelections() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.clearSelections();
    }-*/;

    public native void clearSelections(boolean suppressEvent) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.clearSelections(suppressEvent);
    }-*/;

    public TreeNode[] getSelectedNodes() {
        JavaScriptObject nativeArray = getSelectedNodes(jsObj);
        return TreePanel.convertFromNativeTreeNodeArray(nativeArray);
    }

    private native JavaScriptObject getSelectedNodes(JavaScriptObject sm) /*-{
        var treeNodes = sm.getSelectedNodes();
        return (treeNodes === undefined) ? null : treeNodes;
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

    public native void select(TreeNode treeNode, boolean keepExisting) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var tn = treeNode.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.select(tn, null, keepExisting);
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

    public native void addSelectionModelListener(MultiSelectionModelListener listener)/*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var smJ = this;

        sm.addListener('selectionchange',
                 function(self, nodes) {
                    if(nodes === undefined) nodes = null;
                    var nodesJ = @com.gwtext.client.widgets.tree.TreePanel::convertFromNativeTreeNodeArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodes);
                    listener.@com.gwtext.client.widgets.tree.event.MultiSelectionModelListener::onSelectionChange(Lcom/gwtext/client/widgets/tree/MultiSelectionModel;[Lcom/gwtext/client/widgets/tree/TreeNode;)(smJ, nodesJ);
			    }
          );
    }-*/;
}