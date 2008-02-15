/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Command;
import com.gwtext.client.core.Function;
import com.gwtext.client.data.Node;
import com.gwtext.client.data.Tree;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.tree.event.TreePanelListener;

/**
 * A Tree widget.
 */
public class TreePanel extends Panel {

	private TreeSelectionModel selectionModel;

	private static JavaScriptObject configPrototype;

	static {
		init();
	}

	private static native void init()/*-{
        var c = new $wnd.Ext.tree.TreePanel();
        @com.gwtext.client.widgets.tree.TreePanel::configPrototype = c.initialConfig;
    }-*/;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "treepanel";
	}

	public TreePanel() {
	}

    protected void initComponent() {
        JavaScriptObject root = getAttributeAsJavaScriptObject("root");
        super.initComponent();
        if(root == null) {
            error("TreePanel root node must be assigned. See setRootNode(..)");
        }
    }

    /**
	 * Construct a new TreePanel.
	 *
	 * @param id the tree panel title
	 */
	public TreePanel(String title) {
		setTitle(title);
	}


	protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.tree.TreePanel(config);
    }-*/;

	/**
	 * The dragZone used by this tree if drag is enabled.
	 *
	 * @return the drag zone, or null if not enabled
	 */
	public native TreeDragZone getDragZone()/*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var dragZone = tp.dragZone;
        return dragZone == null ? null : @com.gwtext.client.widgets.tree.TreeDragZone::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(dragZone);
    }-*/;

	/**
	 * The dropZone used by this tree if drop is enabled.
	 *
	 * @return the drop zone, or null if not enabled
	 */
	public native TreeDropZone getDropZone()/*-{
        var tp = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var dropZone = tp.dropZone;
        return dropZone == null ? null : @com.gwtext.client.widgets.tree.TreeDropZone::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(dropZone);        
    }-*/;

	/**
	 * Return the underlying Tree data structure backing the TreePanel.
	 *
	 * @return the tree data structure
	 */
	public native Tree getTree()/*-{
        //in Ext TreePanel (UI aspect) extends Tree (dat structure).. kinda strange
        //but lets model it as a contains relationship in GWT-Ext
        var tree = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree);                            
    }-*/;

	/**
	 * Collapse all nodes.
	 */
	public void collapseAll() {
		if (!isRendered()) {
			addListener("render", new Function() {
                public void execute() {
					DeferredCommand.addCommand(new Command() {
						public void execute() {
							collapseAll();
						}
					});
                }
            });
		} else {
			collapseAllRendered();
		}
	}
	private native void collapseAllRendered() /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        panel.collapseAll();
    }-*/;

	/**
	 * Expand all nodes.
	 */
	public void expandAll() {
		if (!isRendered()) {
			addListener("render", new Function() {
                public void execute() {
					DeferredCommand.addCommand(new Command() {
						public void execute() {
							expandAll();
						}
					});
                }
            });
		} else {
			expandAllRendered();
		}
	}

	private native void expandAllRendered() /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        panel.expandAll();
    }-*/;

	/**
	 * Expands a specified path in this TreePanel. A path can be retrieved from a node with {@link Node#getPath}
	 *
	 * @param path the path
	 * @param cb   the callback to call when the expand is complete
	 */
	public native void expandPath(String path, NodeExpansionCallback cb) /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        if(cb == null) {
            panel.expandPath(path);
        } else {
            panel.expandPath(path, null, function(success, node) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                cb.@com.gwtext.client.widgets.tree.NodeExpansionCallback::onExpand(ZLcom/gwtext/client/widgets/tree/TreeNode;)(success, nodeJ);
            });
        }
    }-*/;

	/**
	 * Return an array of checked TreeNodes starting from the root node.
	 *
	 * @return array of checked nodes, empty array if no nodes are checked
	 */
	public TreeNode[] getChecked() {
		JavaScriptObject arr = getChecked(getOrCreateJsObj());
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

	/**
	 * Return an array of checked TreeNodes starting from the specified startNode.
	 *
	 * @param startNode the node to start from
	 * @return array of checked nodes, empty array if no nodes are checked
	 */

	public TreeNode[] getChecked(TreeNode startNode) {
		JavaScriptObject arr = getChecked(getOrCreateJsObj(), startNode.getJsObj());
		return convertFromNativeTreeNodeArray(arr);
	}

	private native JavaScriptObject getChecked(JavaScriptObject tree, JavaScriptObject startNode) /*-{
        var checked =  tree.getChecked(startNode);
        return checked === undefined || (checked.length == 1 && checked[0] === undefined) ? null : checked;
    }-*/;

	/**
	 * Retrun the TreeLoader associated with the TreePanel.
	 *
	 * @return the tree loader
	 */
	public native TreeLoader getLoader() /*-{
        var tree = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return @com.gwtext.client.widgets.tree.TreeLoader::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree.getLoader());
    }-*/;

	/**
	 * Gets a node in this tree by its ID.
	 *
	 * @param id the node ID
	 * @return the node, null if none found
	 */
	public TreeNode getNodeById(String id) {
		JavaScriptObject node = getNodeById(getOrCreateJsObj(), id);
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

	/**
	 * Returns the root node for this tree.
	 *
	 * @return the root node
	 */
	public TreeNode getRootNode() {
		JavaScriptObject rootJS = getRootNode(getOrCreateJsObj());
		return rootJS == null ? null : new TreeNode(rootJS);
	}

	private native JavaScriptObject getRootNode(JavaScriptObject tree) /*-{
        var root = tree.getRootNode();
        return root === undefined ? null : root;
    }-*/;

	/**
	 * Selects the node in this tree at the specified path. A path can be retrieved from a node with {@link Node#getPath}.
	 *
	 * @param path the path
	 * @param cb   the callback to call when the selection is complete
	 */
	public native void selectPath(String path, NodeSelectionCallback cb) /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        if(cb == null) {
            panel.selectPath(path);
        } else {
            panel.selectPath(path, null, function(success, node) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                cb.@com.gwtext.client.widgets.tree.NodeSelectionCallback::onSelect(ZLcom/gwtext/client/widgets/tree/TreeNode;)(success, nodeJ);
            });
        }
    }-*/;


	public void setRootNode(Node node) {
		if (!isRendered()) {
			setAttribute("root", node.getJsObj(), true);
		} else {
			setRootNodeRendered(node);
		}
	}

	/**
	 * Sets the root node for this tree.
	 *
	 * @param node the root node
	 */
	public native void setRootNodeRendered(Node node) /*-{
        var tree = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var nodeJS = node.@com.gwtext.client.core.JsObject::getJsObj()();
        tree.setRootNode(nodeJS);
    }-*/;


	/**
	 * Return the TreePanel's selection model.
	 *
	 * @return the selection model
	 */
	public TreeSelectionModel getSelectionModel() {
		if (selectionModel == null) {
			return doGetSelectionModel();
		} else {
			return selectionModel;
		}
	}

	private static DropNodeCallback createDropNodeCB(final JavaScriptObject event) {
		return new DropNodeCallback() {
			public void setDropNode(TreeNode node) {
				JavaScriptObjectHelper.setAttribute(event, "dropNode", node.getJsObj());
			}

			public void setDropNodes(TreeNode[] nodes) {
				JavaScriptObject[] nodesJS = new JavaScriptObject[nodes.length];
				for (int i = 0; i < nodes.length; i++) {
					TreeNode node = nodes[i];
					nodesJS[i] = node.getJsObj();
				}
				JavaScriptObject nativeRecordsArray = JavaScriptObjectHelper.convertToJavaScriptArray(nodesJS);
				JavaScriptObjectHelper.setAttribute(event, "dropNode", nativeRecordsArray);
			}
		};
	}

	private native DefaultSelectionModel doGetSelectionModel() /*-{
        var tree = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var sm = tree.getSelectionModel();
        return @com.gwtext.client.widgets.tree.DefaultSelectionModel::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(sm);
    }-*/;

	/**
	 * Set the token used to separate sub-paths in path strings (defaults to '/').
	 *
	 * @param separator the path separator
	 */
	public native void setPathSeparator(String separator)/*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        panel.pathSeparator = separator;
    }-*/;


	/**
	 * Add a TreePanel listener.
	 *
	 * @param listener the listener
	 */
	public native void addListener(TreePanelListener listener)/*-{

        this.@com.gwtext.client.widgets.Panel::addListener(Lcom/gwtext/client/widgets/event/PanelListener;)(listener);

        var treePanelJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('append',
            function(tree, parent, node, index) {
                var treeJ = @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree);
                var parentJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(parent);
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onAppend(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/widgets/tree/TreeNode;I)(treeJ, parentJ, nodeJ, index);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforeappend',
            function(tree, parent, node, index) {
                var treeJ = @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree);
                var parentJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(parent);
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                return listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::doBeforeAppend(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/widgets/tree/TreeNode;)(treeJ, parentJ, nodeJ);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforeinsert',
            function(tree, parent, node, refNode) {
                var treeJ = @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree);
                var parentJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(parent);
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                var refNodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(refNode);
                return listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::doBeforeInsert(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/widgets/tree/TreeNode;)(treeJ, parentJ, nodeJ, refNodeJ);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('insert',
            function(tree, parent, node, refNode) {
                var treeJ = @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree);
                var parentJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(parent);
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                var refNodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(refNode);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onInsert(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/widgets/tree/TreeNode;)(treeJ, parentJ, nodeJ, refNodeJ);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforeremove',
            function(tree, parent, node) {
                var treeJ = @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree);
                var parentJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(parent);
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                return listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::doBeforeRemove(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/widgets/tree/TreeNode;)(treeJ, parentJ, nodeJ);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('remove',
            function(tree, parent, node) {
                var treeJ = @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree);
                var parentJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(parent);
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onRemove(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/widgets/tree/TreeNode;)(treeJ, parentJ, nodeJ);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforechildrenrendered',
            function(node, event) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                return listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::doBeforeChildrenRendered(Lcom/gwtext/client/widgets/tree/TreeNode;)(nodeJ);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforeclick',
            function(node, event) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                return listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::doBeforeClick(Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/core/EventObject;)(nodeJ, e);
            }
        );
              
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforecollapsenode',
            function(node, deep, anim) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                if(deep === undefined || deep == null) deep = false;
                if(anim === undefined || anim == null) anim = false;
                return listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::doBeforeCollapseNode(Lcom/gwtext/client/widgets/tree/TreeNode;ZZ)(nodeJ, deep, anim);
            }
        );
    
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforeexpandnode',
            function(node, deep, anim) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                if(deep === undefined || deep == null) deep = false;
                if(anim === undefined || anim == null) anim = false;
                return listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::doBeforeExpandNode(Lcom/gwtext/client/widgets/tree/TreeNode;ZZ)(nodeJ, deep, anim);
            }
        );
    
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforenodedrop',
            function(e) {
                var tree = e.tree;
                var targetNode = e.target;
                var data = e.data;
                var point = e.point;
                var source = e.source;
                var rawEvent = e.rawEvent;
                var dropNode = e.dropNode;


                var targetNodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(targetNode);
                var dragDataJ = data == null || data == undefined ? null : @com.gwtext.client.dd.DragData::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
                var sourceJ = @com.gwtext.client.dd.DragDrop::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
                var dropNodeJ = dropNode == null || dropNode === undefined ? null : @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(dropNode);
                var dropNodeCB = @com.gwtext.client.widgets.tree.TreePanel::createDropNodeCB(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
                return listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::doBeforeNodeDrop(Lcom/gwtext/client/widgets/tree/TreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/dd/DragData;Ljava/lang/String;Lcom/gwtext/client/dd/DragDrop;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/widgets/tree/DropNodeCallback;)(treePanelJ, targetNodeJ, dragDataJ, point, sourceJ, dropNodeJ, dropNodeCB);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforeload',
            function(node) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                return listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::doBeforeLoad(Lcom/gwtext/client/widgets/tree/TreeNode;)(nodeJ);
            }
        );
    
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('checkchange',
            function(node, checked) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                if(checked === undefined || checked == null) checked = false;
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onCheckChange(Lcom/gwtext/client/widgets/tree/TreeNode;Z)(nodeJ, checked);
            }
        );
    
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('click',
            function(node, event) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onClick(Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/core/EventObject;)(nodeJ, e);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('collapsenode',
            function(node) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onCollapseNode(Lcom/gwtext/client/widgets/tree/TreeNode;)(nodeJ);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('contextmenu',
            function(node, event) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onContextMenu(Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/core/EventObject;)(nodeJ, e);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('dblclick',
            function(node, event) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onDblClick(Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/core/EventObject;)(nodeJ, e);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('disabledchange',
            function(node, disabled) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                if(disabled === undefined || disabled == null) disabled = false;
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onDisabledChange(Lcom/gwtext/client/widgets/tree/TreeNode;Z)(nodeJ, disabled);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('dragdrop',
            function(treePanel, node, dd, e) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                var ddJ = @com.gwtext.client.dd.DD::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(dd);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onDragDrop(Lcom/gwtext/client/widgets/tree/TreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/dd/DD;)(treePanelJ, nodeJ, ddJ);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('enddrag',
            function(treePanel, node, e) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onEndDrag(Lcom/gwtext/client/widgets/tree/TreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;)(treePanelJ, nodeJ);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('expandnode',
            function(node) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onExpandNode(Lcom/gwtext/client/widgets/tree/TreeNode;)(nodeJ);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('load',
            function(node) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onLoad(Lcom/gwtext/client/widgets/tree/TreeNode;)(nodeJ);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('nodedragover',
            function(e) {
                
                var tree = e.tree;
                var targetNode = e.target;
                var data = e.data;
                var point = e.point;
                var source = e.source;
                var rawEvent = e.rawEvent;
                var dropNode = e.dropNode;

                var targetNodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(targetNode);
                var dragDataJ = data == null || data == undefined ? null : @com.gwtext.client.dd.DragData::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
                var sourceJ = @com.gwtext.client.dd.DragDrop::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
                var dropNodeJ = dropNode == null || dropNode === undefined ? null : @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(dropNode);
                return listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onNodeDragOver(Lcom/gwtext/client/widgets/tree/TreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/dd/DragData;Ljava/lang/String;Lcom/gwtext/client/dd/DragDrop;Lcom/gwtext/client/widgets/tree/TreeNode;)(treePanelJ, targetNodeJ, dragDataJ, point, sourceJ, dropNodeJ);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('nodedrop',
            function(e) {
                var tree = e.tree;
                var targetNode = e.target;
                var data = e.data;
                var point = e.point;
                var source = e.source;
                var rawEvent = e.rawEvent;
                var dropNode = e.dropNode;

                var targetNodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(targetNode);
                var dragDataJ = data == null || data == undefined ? null : @com.gwtext.client.dd.DragData::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
                var sourceJ = @com.gwtext.client.dd.DragDrop::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
                var dropNodeJ = dropNode == null || dropNode === undefined ? null : @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(dropNode);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onNodeDrop(Lcom/gwtext/client/widgets/tree/TreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/dd/DragData;Ljava/lang/String;Lcom/gwtext/client/dd/DragDrop;Lcom/gwtext/client/widgets/tree/TreeNode;)(treePanelJ, targetNodeJ, dragDataJ, point, sourceJ, dropNodeJ);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforemovenode',
            function(tree, node, oldParent, newParent, index) {
                var treeJ = @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree);
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                var oldParentJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(oldParent);
                var newParentJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(newParent);
                return listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::doBeforeMoveNode(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/widgets/tree/TreeNode;I)(treeJ, nodeJ, oldParentJ, newParentJ, index);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('movenode',
            function(tree, node, oldParent, newParent, index) {
                var treeJ = @com.gwtext.client.data.Tree::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tree);
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                var oldParentJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(oldParent);
                var newParentJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(newParent);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onMoveNode(Lcom/gwtext/client/data/Tree;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/widgets/tree/TreeNode;I)(treeJ, nodeJ, oldParentJ, newParentJ, index);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('startdrag',
            function(treePanel, node, e) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onStartDrag(Lcom/gwtext/client/widgets/tree/TreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;)(treePanelJ, nodeJ);
            }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('textchange',
            function(node, newText, oldText) {
                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                if(newText === undefined) newText = null;
                if(oldText === undefined) oldText = null;
                listener.@com.gwtext.client.widgets.tree.event.TreePanelListener::onTextChange(Lcom/gwtext/client/widgets/tree/TreeNode;Ljava/lang/String;Ljava/lang/String;)(nodeJ, newText, oldText);
            }
        );
    }-*/;

	// --- config properties ---

	/**
	 * True to enable animated expand/collapse. Defaults to true.
	 *
	 * @param animate true to enable enimation.
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setAnimate(boolean animate) throws IllegalStateException {
		setAttribute("animate", animate, true);
	}

	/**
	 * True to register this container with ScrollManager. Doing so provides automatic scrolling
	 * of overflow regions in the page during drag operations. Defaults to false.
	 *
	 * @param containerScroll true to register this container with ScrollManager
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setContainerScroll(boolean containerScroll) throws IllegalStateException {
		setAttribute("containerScroll", containerScroll, true);
	}

	/**
	 * True if the tree should only allow append drops (use for trees which are sorted).
	 *
	 * @param ddAppendOnly true to allow only append drops
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setDdAppendOnly(String ddAppendOnly) throws IllegalStateException {
		setAttribute("ddAppendOnly", ddAppendOnly, true);
	}

	/**
	 * The DD group this TreePanel belongs to (defaults to 'TreeDD').
	 *
	 * @param ddGroup the DD group
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setDdGroup(String ddGroup) throws IllegalStateException {
		setAttribute("ddGroup", ddGroup, true);
	}

	/**
	 * True to enable body scrolling
	 *
	 * @param ddScroll true to enable body scrolling.
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setDdScroll(boolean ddScroll) throws IllegalStateException {
		setAttribute("ddScroll", ddScroll, true);
	}

	//TODO no TreeDragZone configs appear to be in Ext
	//dragConfig

	/**
	 * Custom config to pass to the {@link TreeDropZone} instance.
	 *
	 * @param dropConfig the drop config
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setDropConfig(TreeDropZone dropConfig) throws IllegalStateException {
		setAttribute("dropConfig", dropConfig.getJsObj(), true);
	}

	/**
	 * True to enable drag and drop.
	 *
	 * @param enableDD true to enable drag and drop
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setEnableDD(boolean enableDD) throws IllegalStateException {
		setAttribute("enableDD", enableDD, true);
	}

	/**
	 * True to enable just drag.
	 *
	 * @param enableDrag true to enable just drag
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setEnableDrag(boolean enableDrag) throws IllegalStateException {
		setAttribute("enableDrag", enableDrag, true);
	}

	/**
	 * True to enable just drop.
	 *
	 * @param enableDrop true to enable just drop
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setEnableDrop(boolean enableDrop) throws IllegalStateException {
		setAttribute("enableDrop", enableDrop, true);
	}

	/**
	 * The color of the node highlight (defaults to C3DAF9).
	 *
	 * @param hlColor the color of the node highlight
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setHlColor(String hlColor) throws IllegalStateException {
		setAttribute("hlColor", hlColor, true);
	}

	/**
	 * False to disable node highlight on drop.
	 *
	 * @param hlDrop false to disable drop drop highlight
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setHlDrop(boolean hlDrop) throws IllegalStateException {
		setAttribute("hlDrop", hlDrop, true);
	}

	/**
	 * False to disable tree lines (defaults to true).
	 *
	 * @param lines false to disable tree lines
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setLines(boolean lines) throws IllegalStateException {
		setAttribute("lines", lines, true);
	}

	/**
	 * A TreeLoader for use with this TreePanel.
	 *
	 * @param loader the tree loader
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setLoader(TreeLoader loader) throws IllegalStateException {
		setAttribute("loader", loader.getJsObj(), true);
	}

	/**
	 * False to hide the root node (defaults to true).
	 *
	 * @param rootVisible false to hide the root node
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setRootVisible(boolean rootVisible) throws IllegalStateException {
		setAttribute("rootVisible", rootVisible, true);
	}

	/**
	 * Set the Tree seelction model
	 *
	 * @param selectionModel the selection model
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setSelectionModel(TreeSelectionModel selectionModel) throws IllegalStateException {
		setAttribute("selModel", selectionModel.getJsObj(), true);
		this.selectionModel = selectionModel;
	}


	/**
	 * True if only 1 node per branch may be expanded.
	 *
	 * @param singleExpand true if only 1 node per branch may be expanded
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setSingleExpand(boolean singleExpand) throws IllegalStateException {
		setAttribute("singleExpand", singleExpand, true);
	}
}
