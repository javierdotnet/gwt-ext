/*
 * Copyright (c) 2007, Sanjiv Jivan
 * All rights reserved.
 *
 * Each copy or derived work must preserve the copyright notice and this
 * notice unmodified.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;

public class NumberField extends TextField {

    public NumberField() {
        this(new NumberFieldConfig());
    }

    public NumberField(NumberFieldConfig config) {
        super(config);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj)/*-{
        return new $wnd.Ext.form.NumberField(jsObj);
    }-*/;

    public native float getValue() /*-{
         var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
         return field.getValue();
    }-*/;


}
