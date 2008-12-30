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
