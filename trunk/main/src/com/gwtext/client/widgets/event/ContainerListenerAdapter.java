/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.event;

import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.Container;

public class ContainerListenerAdapter extends BoxComponentListenerAdapter implements ContainerListener {

    public void onAdd(Container self, Component component, int index) {
    }

    public void onAfterLayout(Container self) {
    }

    public boolean doBeforeAdd(Container self, Component component, int index) {
        return true;
    }

    public boolean doBeforeRemove(Container self, Component component) {
        return true;
    }

    public void onRemove(Container self, Component component) {
    }
}
