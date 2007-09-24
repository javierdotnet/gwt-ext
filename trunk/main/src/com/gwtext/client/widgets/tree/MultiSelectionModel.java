/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.tree.event.MultiSelectionModelListener;

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
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.clearSelections();
    }-*/;

    public native void clearSelections(boolean suppressEvent) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.clearSelections(suppressEvent);
    }-*/;

    public  TreeNode[] getSelectedNodes() {
        JavaScriptObject nativeArray = getSelectedNodes(jsObj);
        return convertFromNativeTreeNodeArray(nativeArray);
    }

    private native JavaScriptObject getSelectedNodes(JavaScriptObject sm) /*-{
        var treeNodes = sm.getSelectedNode();
        return (treeNodes === undefined) ? null : treeNodes;
    }-*/;

    private static TreeNode[] convertFromNativeTreeNodeArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) return new TreeNode[0];
        JavaScriptObject[] treeNodesJ = JavaScriptObjectHelper.toArray(nativeArray);
        TreeNode[] treeNodes = new TreeNode[treeNodesJ.length];
        for (int i = 0; i < treeNodesJ.length; i++) {
            JavaScriptObject treeNode = treeNodesJ[i];
            treeNodes[i] = new TreeNode(treeNode);
        }
        return treeNodes;
    }


    public native boolean isSelected(TreeNode treeNode) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        var tn = treeNode.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return sm.isSelected(tn);
    }-*/;

    public native void select(TreeNode treeNode) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        var tn = treeNode.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return sm.select(tn);
    }-*/;

    public native void select(TreeNode treeNode, boolean keepExisting) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        var tn = treeNode.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return sm.select(tn, null, keepExisting);
    }-*/;

    public native void selectNext() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectNext();
    }-*/;

    public native void selectPrevious() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectPrevious();
    }-*/;

    public native void unselect(TreeNode treeNode) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        var tn = treeNode.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return sm.unselect(tn);
    }-*/;

    public native void addSelectionModelListener(MultiSelectionModelListener listener)/*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        var smJ = this;

        sm.addListener('selectionchange',
                 function(self, nodes) {
                    if(nodes === undefined) nodes = null;
                    var nodesJ = @com.gwtext.client.widgets.tree.MultiSelectionModel::convertFromNativeTreeNodeArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodes);
                    listener.@com.gwtext.client.widgets.tree.event.MultiSelectionModelListener::onSelectionChange(Lcom/gwtext/client/widgets/tree/MultiSelectionModel;[Lcom/gwtext/client/widgets/tree/TreeNode;)(smJ, nodesJ);
			    }
          );
    }-*/;
}