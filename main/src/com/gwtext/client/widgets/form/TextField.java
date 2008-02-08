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
import com.gwtext.client.widgets.form.event.TextFieldListener;

/**
 * Basic text field.
 */
public class TextField extends Field {

    /**
     * Creates a new TextField.
     */
    public TextField() {
        setJsObj(create(null));
    }

    /**
     * Creates a new TextField.
     *
     * @param config the TextField configuration
     */
    public TextField(TextFieldConfig config) {
        super(config);
        if (config.getTextFieldListener() != null) {
            addTextFieldListener(config.getTextFieldListener());
        }
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
        return new $wnd.Ext.form.TextField(jsObj);
    }-*/;

    /**
     * Add a TextField listener.
     *
     * @param listener the listener
     */
    public native void addTextFieldListener(TextFieldListener listener) /*-{
        var fieldJ = this;
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;

        field.addListener('autosize',
                function(fld, width) {
                    listener.@com.gwtext.client.widgets.form.event.TextFieldListener::onAutoSize(Lcom/gwtext/client/widgets/form/Field;I)(fieldJ, width);
                }
        );
    }-*/;

    /**
     * Automatically grows the field to accomodate the width of the text up to the maximum field width allowed. This only takes effect if grow = true,
     * and fires the autosize event.
     */
    public native void autoSize() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        field.autoSize();
    }-*/;

    /**
     * Selects text in this field.
     */
    public native void selectText() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        field.selectText();
    }-*/;

    /**
     * Selects text in this field.
     *
     * @param start the index where the selection should start 
     * @param end the index where the selection should end
     */
    public native void selectText(int start, int end) /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        field.selectText(start, end);
    }-*/;

    /**
     * Validates a value according to the field's validation rules and marks the field as invalid if the validation fails.
     * 
     * @param value the value to valdiate
     * @return true if valid
     */
    public native boolean validateValue(String value) /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return field.validateValue(value);
    }-*/;

    /**
     * Returns the value of the text field.
     * 
     * @return the text field value
     */
    public String getText() {
        return getValueAsString();
    }
}
