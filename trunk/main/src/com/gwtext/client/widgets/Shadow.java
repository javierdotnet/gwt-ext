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
import com.gwtext.client.util.JavaScriptObjectHelper;

//todo test
/**
 * Simple class that can provide a shadow effect for any element. Note that the element MUST be absolutely positioned,
 * and the shadow does not provide any shimming. This should be used only in simple cases -- for more advanced functionality
 * that can also provide the same shadow effect, see the {@link Layer} class.
 *
 */
public class Shadow extends BaseExtWidget {
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
     * @param id the elemetn ID
     */
    public native void show(String id) /*-{
        var shadow = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        shadow.show(id);
    }-*/;
}