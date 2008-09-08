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
import com.gwtext.client.data.event.NodeListenerAdapter;

/**
 *
 * @author Sanjiv Jivan
 */
public class TreeNodeListenerAdapter extends NodeListenerAdapter implements TreeNodeListener {

    public boolean doBeforeChildrenRendered(Node node) {
        return true;
    }

    public boolean doBeforeClick(Node node, EventObject e) {
        return true;
    }

    public boolean doBeforeCollapse(Node node, boolean deep, boolean anim) {
        return true;
    }

    public boolean doBeforeExpand(Node node, boolean deep, boolean anim) {
        return true;
    }

    public void onCheckChanged(Node node, boolean checked) {
    }

    public void onClick(Node node, EventObject e) {
    }

    public void onCollapse(Node node) {
    }

    public void onContextMenu(Node node, EventObject e) {
    }

    public void onDblClick(Node node, EventObject e) {
    }

    public void onDisabledChange(Node node, boolean disabled) {
    }

    public void onExpand(Node node) {
    }

    public void onTextChange(Node node, String text, String oldText) {
    }
}
