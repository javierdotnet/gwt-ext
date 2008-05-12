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
 
package com.gwtext.client.widgets.menu;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.Component;

/**
 * A base utility class that adapts a non-menu component so that it can be wrapped by a menu item and added to a menu.
 * It provides basic rendering, activation management and enable/disable logic required to work in menus.
 *
 * @author Sanjiv Jivan
 */
public class Adapter extends BaseItem {

    private Component component;

    public Adapter(Component component) {
        this.component = component;
    }

    protected JavaScriptObject create(JavaScriptObject configJS) {
        JavaScriptObject jsObj = doCreate(component.getOrCreateJsObj(), configJS);
        component = null;
        return jsObj;
    }

    private native JavaScriptObject doCreate(JavaScriptObject componentJS, JavaScriptObject configJS) /*-{
        return new $wnd.Ext.menu.Adapter(componentJS, configJS);
    }-*/;
}
