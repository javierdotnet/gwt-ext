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
 

package com.gwtext.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;

/**
 * Abstract base class for grid SelectionModels. It provides the interface that should be implemented by descendant
 * classes. This class should not be directly instantiated.
 *
 * @author Sanjiv Jivan
 */
public abstract class AbstractSelectionModel extends JsObject {

    public AbstractSelectionModel() {
    }

    public AbstractSelectionModel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Returns true if the selections are locked.
     *
     * @return true if selections are locked
     */
    public native boolean isLocked() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return sm.isLocked();
    }-*/;

    /**
     * Locks the selections.
     */
    public native void lock() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.lock();
    }-*/;

    /**
     * Unlocks the selections.
     */
    public native void unlock() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.unlock();
    }-*/;
}
