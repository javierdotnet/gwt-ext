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

public interface NodeListener {
    void onAppend(Tree tree, Node self, Node node, int index);

    boolean doBeforeAppend(Tree tree, Node self, Node node);

    boolean doBeforeInsert(Tree tree, Node self, Node node, Node refNode);

    boolean doBeforeMove(Tree tree, Node self, Node oldParent, Node newParent, int index);

    boolean doBeforeRemove(Tree tree, Node self, Node node);

    void onInsert(Tree tree, Node self, Node node, Node refNode);

    void onMove(Tree tree, Node self, Node oldParent, Node newParent, int index);

    void onRemove(Tree tree, Node self, Node node);
}
