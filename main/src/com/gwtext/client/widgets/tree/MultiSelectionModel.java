/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.widgets.tree.event.MultiSelectionModelListener;

/**
 * Selection model for multi selecting tree nodes.
 *
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
        return sm.select(tn);
    }-*/;

    public native void select(TreeNode treeNode, boolean keepExisting) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var tn = treeNode.@com.gwtext.client.core.JsObject::getJsObj()();
        return sm.select(tn, null, keepExisting);
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
        return sm.unselect(tn);
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