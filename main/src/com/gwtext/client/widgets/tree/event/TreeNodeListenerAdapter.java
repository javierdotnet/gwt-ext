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

package com.gwtext.client.widgets.tree.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.Node;

public class TreeNodeListenerAdapter implements TreeNodeListener {

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

    public boolean doBeforeCheckChanged(Node node, boolean checked) {
        return true;
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
