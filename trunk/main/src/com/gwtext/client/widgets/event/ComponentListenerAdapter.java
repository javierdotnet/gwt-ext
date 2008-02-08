/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.Component;

public class ComponentListenerAdapter implements ComponentListener {

    public boolean doBeforeDestroy(Component component) {
        return true;
    }

    public boolean doBeforeHide(Component component) {
        return true;
    }

    public boolean doBeforeRender(Component component) {
        return true;
    }

    public boolean doBeforeShow(Component component) {
        return true;
    }

    public boolean doBeforeStateRestore(Component component, JavaScriptObject state) {
        return true;
    }

    public boolean doBeforeStateSave(Component component, JavaScriptObject state) {
        return true;
    }

    public void onDestroy(Component component) {
    }

    public void onDisable(Component component) {
    }

    public void onEnable(Component component) {
    }

    public void onHide(Component component) {
    }

    public void onRender(Component component) {
    }

    public void onShow(Component component) {
    }

    public void onStateRestore(Component component, JavaScriptObject state) {
    }

    public void onStateSave(Component component, JavaScriptObject state) {
    }
}
