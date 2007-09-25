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
import com.gwtext.client.data.Node;
import com.gwtext.client.data.Tree;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.RequiredElementWidget;
import com.gwtext.client.widgets.tree.event.TreePanelListener;


public class TreePanel extends RequiredElementWidget {
    private TreeSelectionModel selectionModel;

    public TreePanel(String id) {
        this(id, null);
    }

    public TreePanel(String id, TreePanelConfig config) {
        super(id, config);
        this.selectionModel = config.getSelectionModel();
    }

    protected native JavaScriptObject create(String id, JavaScriptObject config) /*-{
        return new $wnd.Ext.tree.TreePanel(id, config);
    }-*/;

    public String getId() {
        return id;
    }

    public native TreeDragZone getDragZone()/*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var dragZone = tp.dragZone;
        return dragZone == null ? null : @com.gwtext.client.widgets.tree.TreeDragZone::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(dragZone);
    }-*/;

    public native TreeDropZone getDropZone()/*-{
        var tp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var dropZone = tp.dropZone;
        return dropZone == null ? null : @com.gwtext.client.widgets.tree.TreeDropZone::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(dropZone);        
    }-*/;

    public native Tree getTree()/*-{
        //in Ext TreePanel (UI aspect) extends Tree (dat structure).. kinda strange
        //but lets model it as a contains relationship in GWT-Ext
        var tree = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree);                            
    }-*/;

    public native void collapseAll() /*-{
        var panel = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        panel.collapseAll();
    }-*/;

    public native void expandAll() /*-{
        var panel = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        panel.expandAll();
    }-*/;

    public native void expandPath(String path, NodeExpansionCallback cb) /*-{
        var panel = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        if(cb == null) {
            panel.expandPath(path);
        } else {
            panel.expandPath(path, null, function(success, node) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                cb.@com.gwtext.client.widgets.tree.NodeExpansionCallback::onExpand(ZLcom/gwtext/client/widgets/tree/TreeNode;)(success, nodeJ);
            });
        }
    }-*/;

    public TreeNode[] getChecked() {
        JavaScriptObject arr = getChecked(jsObj);
        return convertFromNativeTreeNodeArray(arr);
    }

    static TreeNode[] convertFromNativeTreeNodeArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) return new TreeNode[0];
        JavaScriptObject[] treeNodesJ = JavaScriptObjectHelper.toArray(nativeArray);
        TreeNode[] treeNodes = new TreeNode[treeNodesJ.length];
        for (int i = 0; i < treeNodesJ.length; i++) {
            JavaScriptObject treeNode = treeNodesJ[i];
            treeNodes[i] = new TreeNode(treeNode);
        }
        return treeNodes;
    }

    private native JavaScriptObject getChecked(JavaScriptObject tree) /*-{
        var checked = tree.getChecked();
        return checked === undefined || (checked.length == 1 && checked[0] === undefined) ? null : checked;
    }-*/;

    public TreeNode[] getChecked(TreeNode startNode) {
        JavaScriptObject arr = getChecked(jsObj, startNode.getJsObj());
        return convertFromNativeTreeNodeArray(arr);
    }

    private native JavaScriptObject getChecked(JavaScriptObject tree, JavaScriptObject startNode) /*-{
        var checked =  tree.getChecked(startNode);
        return checked === undefined || (checked.length == 1 && checked[0] === undefined) ? null : checked;
    }-*/;

    public native TreeLoader getLoader() /*-{
        var tree = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return @com.gwtext.client.widgets.tree.TreeLoader::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree.getLoader());
    }-*/;

    public TreeNode getNodeById(String id) {
        JavaScriptObject node = getNodeById(jsObj, id);
        if (node == null) {
            return null;
        } else {
            return new TreeNode(node);
        }
    }

    private native JavaScriptObject getNodeById(JavaScriptObject tree, String id) /*-{
        var node = tree.getNodeById(id);
        if(node === undefined) {
            return null;
        } else {
            return node;
        }
    }-*/;

    public TreeNode getRootNode() {
        JavaScriptObject rootJS = getRootNode(jsObj);
        return rootJS == null ? null : new TreeNode(rootJS);
    }
    
    private native JavaScriptObject getRootNode(JavaScriptObject tree) /*-{
        var root = tree.getRootNode();
        return root === undefined ? null : root;
    }-*/;

    public native void selectPath(String path, NodeExpansionCallback cb) /*-{
        var panel = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        if(cb == null) {
            panel.selectPath(path);
        } else {
            panel.selectPath(path, null, function(success, node) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                cb.@com.gwtext.client.widgets.tree.NodeSelectionCallback::onSelect(ZLcom/gwtext/client/widgets/tree/TreeNode;)(success, nodeJ);
            });
        }
    }-*/;

    public native void setRootNode(Node node) /*-{
        var tree = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var nodeJS = node.@com.gwtext.client.core.JsObject::jsObj;
        tree.setRootNode(nodeJS);
    }-*/;

    public native void render() /*-{
        var tree = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tree.render();
    }-*/;

    public TreeSelectionModel getSelectionModel() {
        if(selectionModel == null) {
            return doGetSelectionModel();
        } else {
            return selectionModel;
        }
    }
    
    private native DefaultSelectionModel doGetSelectionModel() /*-{
        var tree = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var sm = tree.getSelectionModel();
        return @com.gwtext.client.widgets.tree.DefaultSelectionModel::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(sm);
    }-*/;

    public native void setPathSeparator(String separator)/*-{
        var panel = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        panel.pathSeparator = separator;
    }-*/;

    public native void addTreePanelListener(TreePanelListener listener)/*-{
        var treePanel = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var treePanelJ = this;

        treePanel.addListener('beforechildrenrendered',
            function(node, event) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                return listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::doBeforeChildrenRendered(Lcom/gwtext/client/widgets/tree/TreeNode;)(nodeJ);
            }
        );

        treePanel.addListener('beforeclick',
            function(node, event) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                return listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::doBeforeClick(Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/core/EventObject;)(nodeJ, e);
            }
        );
              
        treePanel.addListener('beforecollapse',
            function(node, deep, anim) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                if(deep === undefined || deep == null) deep = false;
                if(anim === undefined || anim == null) anim = false;
                return listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::doBeforeCollapse(Lcom/gwtext/client/widgets/tree/TreeNode;ZZ)(nodeJ, deep, anim);
            }
        );
    
        treePanel.addListener('beforeexpand',
            function(node, deep, anim) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                if(deep === undefined || deep == null) deep = false;
                if(anim === undefined || anim == null) anim = false;
                return listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::doBeforeExpand(Lcom/gwtext/client/widgets/tree/TreeNode;ZZ)(nodeJ, deep, anim);
            }
        );
    
        treePanel.addListener('beforenodedrop',
            function(e) {
                var tree = e.tree;
                var targetNode = e.target;
                var data = e.data;
                var point = e.point;
                var source = e.source;
                var rawEvent = e.rawEvent;
                var dropNode = e.dropNode;

                var targetNodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(targetNode);
                var sourceJ = @com.gwtext.client.dd.DragDrop::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
                var dropNodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(dropNode);
                return listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::doBeforeNodeDrop(Lcom/gwtext/client/widgets/tree/TreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;Ljava/lang/String;Lcom/gwtext/client/dd/DragDrop;Lcom/gwtext/client/widgets/tree/TreeNode;)(treePanelJ, targetNodeJ, point, sourceJ, dropNodeJ);
            }
        );

        treePanel.addListener('beforeload',
            function(node) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                return listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::doBeforeLoad(Lcom/gwtext/client/widgets/tree/TreeNode;)(nodeJ);
            }
        );
    
        treePanel.addListener('checkchange',
            function(node, checked) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                if(checked === undefined || checked == null) checked = false;
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onCheckChange(Lcom/gwtext/client/widgets/tree/TreeNode;Z)(nodeJ, checked);
            }
        );
    
        treePanel.addListener('click',
            function(node, event) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onClick(Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/core/EventObject;)(nodeJ, e);
            }
        );

        treePanel.addListener('collapse',
            function(node) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onCollapse(Lcom/gwtext/client/widgets/tree/TreeNode;)(nodeJ);
            }
        );

        treePanel.addListener('contextmenu',
            function(node, event) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onContextMenu(Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/core/EventObject;)(nodeJ, e);
            }
        );

        treePanel.addListener('dblclick',
            function(node, event) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onDblClick(Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/core/EventObject;)(nodeJ, e);
            }
        );

        treePanel.addListener('disabledchange',
            function(node, disabled) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                if(disabled === undefined || disabled == null) disabled = false;
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onDisabledChange(Lcom/gwtext/client/widgets/tree/TreeNode;Z)(nodeJ, disabled);
            }
        );

        treePanel.addListener('dragdrop',
            function(treePanel, node, dd, e) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                var ddJ = @com.gwtext.client.dd.DD::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(dd);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onDragDrop(Lcom/gwtext/client/widgets/tree/TreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/dd/DD;)(treePanelJ, nodeJ, ddJ);
            }
        );

        treePanel.addListener('enddrag',
            function(treePanel, node, e) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onEndDrag(Lcom/gwtext/client/widgets/tree/TreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;)(treePanelJ, nodeJ);
            }
        );

        treePanel.addListener('expand',
            function(node) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onExpand(Lcom/gwtext/client/widgets/tree/TreeNode;)(nodeJ);
            }
        );

        treePanel.addListener('load',
            function(node) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onLoad(Lcom/gwtext/client/widgets/tree/TreeNode;)(nodeJ);
            }
        );

        treePanel.addListener('nodedragover',
            function(e) {
                var tree = e.tree;
                var targetNode = e.target;
                var data = e.data;
                var point = e.point;
                var source = e.source;
                var rawEvent = e.rawEvent;
                var dropNode = e.dropNode;

                var targetNodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(targetNode);
                var sourceJ = @com.gwtext.client.dd.DragDrop::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
                var dropNodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(dropNode);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onNodeDragOver(Lcom/gwtext/client/widgets/tree/TreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;Ljava/lang/String;Lcom/gwtext/client/dd/DragDrop;Lcom/gwtext/client/widgets/tree/TreeNode;)(treePanelJ, targetNodeJ, point, sourceJ, dropNodeJ);
            }
        );

        treePanel.addListener('nodedrop',
            function(e) {
                var tree = e.tree;
                var targetNode = e.target;
                var data = e.data;
                var point = e.point;
                var source = e.source;
                var rawEvent = e.rawEvent;
                var dropNode = e.dropNode;

                var targetNodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(targetNode);
                var sourceJ = @com.gwtext.client.dd.DragDrop::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
                var dropNodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(dropNode);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onNodeDrop(Lcom/gwtext/client/widgets/tree/TreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;Ljava/lang/String;Lcom/gwtext/client/dd/DragDrop;Lcom/gwtext/client/widgets/tree/TreeNode;)(treePanelJ, targetNodeJ, point, sourceJ, dropNodeJ);
            }
        );
    
        treePanel.addListener('startdrag',
            function(treePanel, node, e) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onStartDrag(Lcom/gwtext/client/widgets/tree/TreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;)(treePanelJ, nodeJ);
            }
        );

        treePanel.addListener('textchange',
            function(node, newText, oldText) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                if(newText === undefined) newText = null;
                if(oldText === undefined) oldText = null;
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onTextChange(Lcom/gwtext/client/widgets/tree/TreeNode;Ljava/lang/String;Ljava/lang/String;)(nodeJ, newText, oldText);
            }
        );
    }-*/;
}
