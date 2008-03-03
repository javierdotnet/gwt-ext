/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.tree.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.Node;
import com.gwtext.client.data.event.NodeListener;

public interface TreeNodeListener extends NodeListener {

    /**
     * Fires right before the child nodes for this node are rendered.
     *
     * @param node the node
     * @return false to cancel
     */
    boolean doBeforeChildrenRendered(Node node);

    /**
     * Fires before click processing. Return false to cancel the default action.
     *
     * @param node the node
     * @param e    the event object
     * @return false to cancel
     */
    boolean doBeforeClick(Node node, EventObject e);

    /**
     * Fires before this node is collapsed, return false to cancel.
     *
     * @param node the node
     * @param deep whether deep collapse
     * @param anim whether animated
     * @return false to cancel
     */
    boolean doBeforeCollapse(Node node, boolean deep, boolean anim);

    /**
     * Fires before this node is expanded, return false to cancel.
     *
     * @param node the node
     * @param deep whether deep expand
     * @param anim whether animated
     * @return false to cancel
     */
    boolean doBeforeExpand(Node node, boolean deep, boolean anim);

    /**
     * Fires when a node with a checkbox's checked property changes.
     *
     * @param node    the node
     * @param checked the new checked value
     * @return false to cancel
     */
    void onCheckChanged(Node node, boolean checked);

    /**
     * Fires when this node is clicked.
     *
     * @param node the node
     * @param e    the event object
     */
    void onClick(Node node, EventObject e);

    /**
     * Fires when this node is collapsed.
     *
     * @param node the node
     */
    void onCollapse(Node node);

    /**
     * Fires when this node is right clicked.
     *
     * @param node the node
     * @param e    the event obejct
     */
    void onContextMenu(Node node, EventObject e);

    /**
     * Fires when this node is double clicked.
     *
     * @param node the node
     * @param e    the event object
     */
    void onDblClick(Node node, EventObject e);

    /**
     * Fires when the disabled status of this node changes.
     *
     * @param node     the node
     * @param disabled true if disabled
     */
    void onDisabledChange(Node node, boolean disabled);

    /**
     * Fires when this node is expanded.
     *
     * @param node the node
     */
    void onExpand(Node node);

    /**
     * Fires when the text for this node is changed.
     *
     * @param node    the node
     * @param text    the new text
     * @param oldText the old text
     */
    void onTextChange(Node node, String text, String oldText);
}
