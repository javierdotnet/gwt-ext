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
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This is the base class for {@link QuickTips} and Tooltip that provides the basic layout and positioning that
 * all tip-based classes require. This class can be used directly for simple, statically-positioned tips that are
 * displayed programmatically.
 *
 * @author Sanjiv Jivan
 */
public class Tip extends Panel {

    public Tip() {
    }

    public Tip(String html) {
        setHtml(html);
    }
    
    public Tip(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.Tip(config);
    }-*/;

    /**
     * True to render a close tool button into the tooltip header (defaults to false).
     *
     * @param closable true for closable
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setClosable(boolean closable) throws IllegalStateException {
        setAttribute("closable", closable, false);
    }

    /**
     * The default {@link com.gwtext.client.core.ExtElement#alignTo(String, String)}  anchor position value for this tip
     * relative to its element of origin. (defaults to "tl-bl?")
     *
     * @param defaultAlign the align poistion.
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setDefaultAlign(String defaultAlign) throws IllegalStateException {
        setAttribute("defaultAlign", defaultAlign, true);
    }

    /**
     * The maximum width of the tip in pixels (defaults to 300). The maximum supported value is 500.
     *
     * @param maxWidth the max width
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMaxWidth(int maxWidth) throws IllegalStateException {
        setAttribute("maxWidth", maxWidth, true);
    }

    /**
     * The minimum width of the tip in pixels (defaults to 40).
     *
     * @param minWidth the min width
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMinWidth(int minWidth) throws IllegalStateException {
        setAttribute("minWidth", minWidth, true);
    }

    /**
     * True for shadows on sides.
     *
     * @param shadow true for shadow
     */
    public void setShadow(boolean shadow) {
        setAttribute("shadow", shadow, true);
    }

    /**
     * Set a shadow type for the tooltip.
     *
     * @param shadow the shadow type
     * @see com.gwtext.client.widgets.Shadow#SIDES
     * @see com.gwtext.client.widgets.Shadow#FRAME
     * @see com.gwtext.client.widgets.Shadow#DROP
     */
    public void setShadow(Shadow.Type shadow) {
        setAttribute("shadow", shadow.getType(), true);
    }

    /**
     * Width in pixels of the tip (defaults to auto). Width will be ignored if it exceeds the bounds of minWidth or maxWidth.
     * The maximum supported value is 500.
     *
     * @param width the tooltip width
     */
    public void setWidth(int width) {
        setAttribute("width", width, true);
    }

    /**
     * Shows this tip at the specified XY position.
     *
     * @param x the X position
     * @param y the Y position
     */
    public native void showAt(int x, int y) /*-{
       var tip  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
       tip.showAt([x, y]);
    }-*/;

    /**
     * Shows this tip at a position relative to another element. Default to the
     * poistion defaults to 'tl-br?'
     *
     * @param element the element to show tip by
     * @see com.gwtext.client.core.ExtElement#alignTo(String, String)
     */
    public native void showBy(Element element) /*-{
        var tip  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        tip.showBy(element);
    }-*/;

    /**
     * Shows this tip at a position relative to another element. Default to the
     * poistion defaults to 'tl-br?'
     *
     * @param elementID the element ID to show tip by
     * @see com.gwtext.client.core.ExtElement#alignTo(String, String)
     */
    public native void showBy(String elementID) /*-{
        var tip  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        tip.showBy(elementID);
    }-*/;

    /**
     * Shows this tip at a position relative to another element. Default to the
     * poistion defaults to 'tl-br?'
     *
     * @param element  the element to show tip by
     * @param position the tooltip position
     * @see com.gwtext.client.core.ExtElement#alignTo(String, String)
     */
    public native void showBy(Element element, String position) /*-{
        var tip  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        tip.showBy(element, position);
    }-*/;

    /**
     * Shows this tip at a position relative to another element. Default to the
     * poistion defaults to 'tl-br?'
     *
     * @param elementID the element ID to show tip by
     * @param position  the tooltip position
     * @see com.gwtext.client.core.ExtElement#alignTo(String, String)
     */
    public native void showBy(String elementID, String position) /*-{
        var tip  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        tip.showBy(elementID, position);
    }-*/;
}
