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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.JsObject;

/**
 * A simple utility class for generically masking elements while loading data. If the element being masked has an
 * underlying {@link com.gwtext.client.data.Store}, the masking will be automatically synchronized with the store's
 * loading process and the mask element will be cached for reuse. For all other elements, this mask will replace the
 * element's UpdateManager load indicator and will be destroyed after the initial load.
 */
public class LoadMask extends JsObject {

	/**
	 * Create a new LoadMask.
	 *
	 * @param element the element to mask
	 * @param config the mask config
	 */
	public LoadMask(Element element, LoadMaskConfig config) {
        jsObj = create(element, config.getJsObj());
    }

	/**
	 * Create a new LoadMask.
	 *
	 * @param id the element ID to mask
	 * @param config the mask config
	 */
    public LoadMask(String id, LoadMaskConfig config) {
        jsObj = create(id, config.getJsObj());
    }

    private native JavaScriptObject create(Element element, JavaScriptObject config) /*-{
        return new $wnd.Ext.LoadMask(element, config);
    }-*/;

    private native JavaScriptObject create(String id, JavaScriptObject config) /*-{
        return new $wnd.Ext.LoadMask(id, config);
    }-*/;

	/**
	 * Disables the mask to prevent it from being displayed.
	 */
	public native void disable() /*-{
        var lm = this.@com.gwtext.client.core.JsObject::jsObj;
        lm.disable();
    }-*/;

	/**
	 * Enables the mask so that it can be displayed.
	 */
	public native void enable() /*-{
        var lm = this.@com.gwtext.client.core.JsObject::jsObj;
        lm.enable();
    }-*/;

	/**
	 * True if the mask is currently disabled so that it will not be displayed (defaults to false)
	 *
	 * @return true if mask disabled
	 */
	public native boolean isDisabled() /*-{
        var lm = this.@com.gwtext.client.core.JsObject::jsObj;
        return lm.disabled;
    }-*/;
}
