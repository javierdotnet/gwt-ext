/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 *
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.event;

import com.gwtext.client.widgets.Panel;

/**
 * {@link Panel} listener adapter.
 */
public class PanelListenerAdapter extends ContainerListenerAdapter implements PanelListener {

    public void onActivate(Panel panel) {
    }

    public boolean doBeforeClose(Panel panel) {
        return true;
    }

    public boolean doBeforeCollapse(Panel panel, boolean animate) {
        return true;
    }

    public boolean doBeforeExpand(Panel panel, boolean animate) {
        return true;
    }

    public void onBodyResize(Panel panel, String width, String height) {
    }

    public void onClose(Panel panel) {
    }

    public void onCollapse(Panel panel) {
    }

    public void onDeactivate(Panel panel) {
    }

    public void onExpand(Panel panel) {
    }

    public void onTitleChange(Panel panel, String title) {
    }
}
