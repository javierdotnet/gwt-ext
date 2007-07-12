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

package com.gwtext.client.data.event;

import com.gwtext.client.data.Node;
import com.gwtext.client.data.Tree;

public class TreeListenerAdapter implements TreeListener {
    public void onAppend(Tree tree, Node parent, Node node, int index) {

    }

    public boolean doBeforeAppend(Tree tree, Node parent, Node node) {
        return true;
    }

    public boolean doBeforeInsert(Tree tree, Node parent, Node node, Node refNode) {
        return true;
    }

    public boolean doBeforeMove(Tree tree, Node node, Node oldParent, Node newParent, int index) {
        return true;
    }

    public boolean doBeforeRemove(Tree tree, Node parent, Node node) {
        return true;
    }

    public void onInsert(Tree tree, Node parent, Node node, Node refNode) {

    }

    public void onMove(Tree tree, Node node, Node oldParent, Node newParent, int index) {

    }

    public void onRemove(Tree tree, Node parent, Node node) {

    }
}
