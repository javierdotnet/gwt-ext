/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
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
