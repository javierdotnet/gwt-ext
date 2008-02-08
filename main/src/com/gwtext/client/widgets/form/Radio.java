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

package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Single radio field. Radio grouping is handled automatically by the browser if you give each radio in a group the same name.
 *
 */
public class Radio extends Checkbox {

    public Radio() {
    }

    /**
     * Constructs a Radio box using the specified configuration.
     *
     * @param config the Radio box configuration
     */
    public Radio(CheckboxConfig config) {
        super(config);
    }

    protected native JavaScriptObject create(JavaScriptObject config)/*-{
        return new $wnd.Ext.form.Radio(config);    
    }-*/;

    /**
     * If this radio is part of a group, it will return the selected value.
     * 
     * @return the group value
     */
    public native String getGroupValue() /*-{
        var rb = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return rb.getGroupValue();
    }-*/;
}
