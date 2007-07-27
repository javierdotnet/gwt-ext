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
import com.gwtext.client.widgets.form.event.CheckboxListener;

public class Checkbox extends Field {

    public Checkbox() {
        this(new CheckboxConfig());
    }

    public Checkbox(CheckboxConfig config) {
        super(config);
        if (config.getCheckboxListener() != null) {
            addCheckboxListener(config.getCheckboxListener());
        }
    }

    protected native JavaScriptObject create(JavaScriptObject config)/*-{
        return new $wnd.Ext.form.Checkbox(config);    
    }-*/;

    public native boolean getValue() /*-{
         var cb = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
         return cb.getValue();
     }-*/;

    public native void setValue(boolean checked) /*-{
        var cb = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        cb.setValue(checked);
    }-*/;

    public native void addCheckboxListener(CheckboxListener listener) /*-{
        var fieldJ = this;
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;

        field.addListener('check',
                function(fld, checked) {
                    listener.@com.gwtext.client.widgets.form.event.CheckboxListener::onCheck(Lcom/gwtext/client/widgets/form/Checkbox;Z)(fieldJ, checked);
                }
        );
    }-*/;
}
