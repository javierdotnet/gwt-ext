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
 

package com.gwtext.client.widgets;

import com.google.gwt.user.client.Element;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.Function;
import com.gwtext.client.util.DOMUtil;

/**
 * Component manager.
 *
 * @author Sanjiv Jivan
 */
public class ComponentMgr {

	/**
	 * Registers a function that will be called when a specified component is added to ComponentMgr.
	 *
	 * @param id the component ID
	 * @param fn the function to execute
	 */
	public native void onAvailable(String id, Function fn)/*-{
        $wnd.Ext.ComponentMgr.onAvailable(id, function() {
            fn.@com.gwtext.client.core.Function::execute()();
        });
    }-*/;

	/**
	 * Returns a component by id.
	 *
	 * @param id the component ID
	 * @return the component or null if not found
	 */
	public static native Component getComponent(String id) /*-{
        var comp = $wnd.Ext.ComponentMgr.get(id);
		return comp == null || comp === undefined ? null : @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(comp);
	}-*/;

	/**
	 * Returns a component that the passed element represents.
	 *
	 * @param element the element
	 * @return the component or null if not found
	 */
	public static Component getComponent(Element element) {
		return getComponent(DOMUtil.getID(element));
	}

	/**
	 * Returns a component that the passed element represents.
	 *
	 * @param element the element
	 * @return the component or null if not found
	 */
	public static Component getComponent(ExtElement element) {
		return getComponent(element.getDOM());
	}
}
