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
package com.gwtext.client.widgets.tree;

import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.EditorConfig;

public class TreeEditorConfig extends EditorConfig {
	/**
	 * CSS class to apply to the editor (defaults to "x-small-editor x-tree-editor")
	 *
	 * @param cls the CSS class
	 */
    public void setCls(String cls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "cls", cls);
    }

	/**
	 * The maximum width in pixels of the editor field (defaults to 250). Note that if the maxWidth would exceed the
	 * containing tree element's size, it will be automatically limited for you to the container width, taking scroll and client offsets into account prior to each edit.
	 *
	 * @param maxWidth the max width
	 */
	public void setMaxWidth(int maxWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxWidth", maxWidth);
    }

	/**
	 *  The edit delay in milliseconds. Default is 350ms.
	 * 
	 * @param editDelay the edit delay
	 */
	public void setEditDelay(int editDelay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "editDelay", editDelay);
    }

	/**
	 * True to shim the editor if selects/iframes could be displayed beneath it (defaults to false).
	 * 
	 * @param shim true to shim
	 */
	public void setShim(boolean shim) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shim", shim);
    }
}
