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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.util.JavaScriptObjectHelper;


/**
 * Simple class that can provide a shadow effect for any element. Note that the element MUST be absolutely positioned,
 * and the shadow does not provide any shimming. This should be used only in simple cases -- for more advanced functionality
 * that can also provide the same shadow effect, see the {@link Layer} class.
 *
 * @author Sanjiv Jivan
 */
public class Shadow extends BaseExtWidget {

    /**
     * Shadow on sides (default)
     */
     public static Type SIDES = new Type("sides");

    /**
     * For 4-way shadow
     */
    public static Type FRAME = new Type("frame");

    /**
     * Shadow on bottom right.
     */
    public static Type DROP = new Type("drop");

    
    /**
     * Create a new Shadow.
     *
     * @param mode  The shadow display mode. Supports the following options: sides: Shadow displays on both sides and bottom only,
     * frame: Shadow displays equally on all four sides, drop: Traditional bottom-right drop shadow (default)
     * @param offset the number of pixels to offset the shadow from the element (defaults to 4)
     */
    public Shadow(String mode, String offset) {
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "mode", mode);
        JavaScriptObjectHelper.setAttribute(config, "offset", offset);
        jsObj = create(config);
    }

    private native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.Shadow(config);
    }-*/;

    /**
     * Hides this shadow.
     */
    public native void hide() /*-{
        var shadow = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        shadow.hide();
    }-*/;

    /**
     * Returns true if the shadow is visible, else false.
     *
     * @return true if shadow visible
     */
    public native boolean isVisible() /*-{
        var shadow = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return shadow.isVisible();
    }-*/;

    /**
     * Direct alignment when values are already available. {@link #show} must be called at least once before calling
     * this method to ensure it is initialized.
     * 
     * @param left The target element left position 
     * @param top The target element top position
     * @param width The target element width
     * @param height The target element height
     */
    public native void realign(int left, int top, int width, int height) /*-{
        var shadow = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        shadow.realign(left, top, width, height);
    }-*/;

    /**
     * Adjust the z-index of this shadow.
     *
     * @param zindex The new z-index
     */
    public native void setZIndex(int zindex) /*-{
        var shadow = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        shadow.setZIndex(zindex);
    }-*/;

    /**
     * Displays the shadow under the target element.
     *
     * @param id the element ID
     */
    public native void show(String id) /*-{
        var shadow = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        shadow.show(id);
    }-*/;

    /**
     * Displays the shadow under the target element.
     *
     * @param element the element
     */
    public native void show(Element element) /*-{
        var shadow = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        shadow.show(element);
    }-*/;

    public static class Type {
        private String type;

        public Type(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}