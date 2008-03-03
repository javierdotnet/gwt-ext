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
import com.gwtext.client.data.event.NodeListenerAdapter;

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
