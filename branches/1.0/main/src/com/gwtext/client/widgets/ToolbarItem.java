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
 * The base class that other classes should extend in order to get some basic common toolbar item functionality.
 */
public abstract class ToolbarItem extends BaseExtWidget {

    /**
     * Removes and destroys this item.
     */
    public native void destroy()/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.destroy();
    }-*/;

    /**
     * Disables this item.
     */
    public native void disable()/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.disable();
    }-*/;

    /**
     * Enables this item.
     */
    public native void enable()/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.enable();
    }-*/;

    /**
     * Try to focus this item.
     */
    public native void focus()/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.focus();
    }-*/;

    /**
     * Hides this item.
     */
    public native void hide()/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.hide();
    }-*/;

    /**
     * Shows this item.
     */
    public native void show()/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.show();
    }-*/;

    /**
     * Convenience function for boolean show/hide.
     * 
     * @param visible true to show
     */
    public native void setVisible(boolean visible)/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.setVisible(visible);
    }-*/;
}
