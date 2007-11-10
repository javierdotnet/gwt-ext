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

package com.gwtext.client.widgets;

/**
 * Provides attractive and customizable tooltips for any element.
 *
 */
public class QuickTips {

	/**
	 * Disable this quick tip.
	 */
	public static native void disable()/*-{
        $wnd.Ext.QuickTips.disable();
    }-*/;

	/**
	 * Enable this quick tip.
	 */
	public static native void enable()/*-{
        $wnd.Ext.QuickTips.enable();
    }-*/;

	/**
	 * Initialize and enable QuickTips for first use. This should be called once before the first attempt to access or display QuickTips in a page.
	 */
	public static native void init()/*-{
        $wnd.Ext.QuickTips.init();
    }-*/;

	/**
	 * Returns true if the quick tip is enabled, else false.
	 * 
	 * @return true if enabled
	 */
	public static native boolean isEnabled()/*-{
        return $wnd.Ext.QuickTips.isEnabled();
    }-*/;

	/**
	 * Configures a new quick tip instance and assigns it to a target element.
	 *
	 * @param id target element id
	 * @param config the config
	 */
    public native void register(String id, QuickTipsConfig config) /*-{
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        configJS['target'] = id;
        $wnd.Ext.QuickTips.register(configJS);
     }-*/;
}
