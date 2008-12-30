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
 * RowParams class that is passed to the user when specifying a custom row rendering.
 *
 * @author Sanjiv Jivan
 * @see com.gwtext.client.widgets.grid.GridView#getRowClass(com.gwtext.client.data.Record, int, RowParams, com.gwtext.client.data.Store)
 */
public class RowParams extends JsObject {

	private RowParams(JavaScriptObject jsObj) {
		super(jsObj);
	}

	private static RowParams instance(JavaScriptObject jsObj) {
		return new RowParams(jsObj);
	}
	/**
	 * An HTML fragment to be rendered as the cell's body content (defaults to '').
	 *
	 * @return the row body
	 */
	public native String getBody() /*-{
        var rp = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return rp.body;
    }-*/;

	/**
	 * Set the row body as HTML.
	 *
	 * @param body the row body
	 */
	public native void setBody(String body) /*-{
        var rp = this.@com.gwtext.client.core.JsObject::getJsObj()();
        rp.body = body;
    }-*/;

	/**
	 * A CSS style string that will be applied to the row's TR style attribute (defaults to '').
	 *
	 * @return the row body the body CSS style
	 */
	public native String getBodyStyle() /*-{
        var rp = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return rp.bodyStyle;
    }-*/;

	/**
	 * A CSS style string that will be applied to the row's TR style attribute (defaults to '').
	 *
	 * @param bodyStyle the body style
	 */
	public native void setBodyStyle(String bodyStyle) /*-{
        var rp = this.@com.gwtext.client.core.JsObject::getJsObj()();
        rp.bodyStyle = bodyStyle;
    }-*/;

	/**
	 * The column count to apply to the body row's TD colspan attribute (defaults to the current column count of the grid).
	 *
	 * @return the number of cols
	 */
	public native int getCols() /*-{
        var rp = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return rp.cols;
    }-*/;

	/**
	 * The column count to apply to the body row's TD colspan attribute (defaults to the current column count of the grid).
	 *
	 * @param cols the number of cols
	 */
	public native void setcols(int cols) /*-{
        var rp = this.@com.gwtext.client.core.JsObject::getJsObj()();
        rp.cols = cols;
    }-*/;
}