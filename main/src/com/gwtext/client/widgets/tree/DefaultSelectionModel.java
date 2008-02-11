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
import com.gwtext.client.widgets.tree.event.DefaultSelectionModelListener;

/**
 * Default Tree selection model. Using this selection model only a single node can be selected.
 * To enable selection of multiple nodes, use {@link com.gwtext.client.widgets.tree.MultiSelectionModel}.
 *
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
        return sm.select(tn);
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
