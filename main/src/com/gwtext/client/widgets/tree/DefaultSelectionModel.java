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
import com.gwtext.client.widgets.tree.event.DefaultSelectionModelListener;

public class DefaultSelectionModel extends JsObject implements TreeSelectionModel {

    public DefaultSelectionModel() {
        jsObj = create();
    }

    private native JavaScriptObject create() /*-{
        return new $wnd.Ext.tree.DefaultSelectionModel();
    }-*/;

    public DefaultSelectionModel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static DefaultSelectionModel instance(JavaScriptObject jsObj) {
        return new DefaultSelectionModel(jsObj);
    }

    public native void clearSelections() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.clearSelections();
    }-*/;

    public native TreeNode getSelectedNode() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        var treeNode = sm.getSelectedNode();
        if(treeNode == null || treeNode === undefined) {
            return null;
        } else  {
            return @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(treeNode);
        }
    }-*/;

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

    public native void addSelectionModelListener(DefaultSelectionModelListener listener)/*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
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
