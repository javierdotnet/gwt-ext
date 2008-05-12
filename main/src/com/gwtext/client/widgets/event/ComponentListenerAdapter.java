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
 

package com.gwtext.client.widgets.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.Component;

/**
 *
 * @author Sanjiv Jivan
 */
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
