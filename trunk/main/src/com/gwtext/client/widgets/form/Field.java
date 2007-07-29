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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.form.event.FieldListener;

public class Field extends Component {

    public Field() {
        setJsObj(create(null));
    }

    public Field(FieldConfig config) {
        setJsObj(create(config.getJsObj()));        
        if (config.getFieldListener() != null) {
            addFieldListener(config.getFieldListener());
        }
    }

    public Field(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Set the location of the error message target globally.
     *
     * @param msgTarget supported values are 'qtip' (default) and 'side'
     */
    public static native void setMsgTarget(String msgTarget) /*-{
        $wnd.Ext.form.Field.prototype.msgTarget = msgTarget;
    }-*/;

    protected JavaScriptObject create(JavaScriptObject config) {
        throw new IllegalArgumentException("must be overridden");
    }

    public void applyTo(String id) {
        Element el = DOM.getElementById(id);
        if (el == null) {
            throw new IllegalArgumentException("Element with id : " + id + " not found.");
            //RootPanel.get().add(new HTML("<div id='" + id + "'></div"));
        }
        applyTo(jsObj, id);
    }

    public native void applyTo(Element element) /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        field.applyTo(element);
    }-*/;

    private native void applyTo(JavaScriptObject field, String id) /*-{
        field.applyTo(id);
    }-*/;

    public native void clearInvalid() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        field.clearInvalid();
    }-*/;

    public native String getName() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return field.getName();
    }-*/;

    public native String getRawValue() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return field.getRawValue();
    }-*/;

    public native String getValueAsString() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return field.getValue();
    }-*/;

    public native boolean isDirty() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return field.isDirty();
    }-*/;

    public native boolean isValid() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return field.isValid();
    }-*/;

    public native boolean isValid(boolean preventMark) /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return field.isValid(preventMark);
    }-*/;

    public native void markInvalid(String message) /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        field.markInvalid(message);
    }-*/;

    public native void reset() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        field.reset();
    }-*/;

    public native void setRawValue(String value) /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        field.setRawValue(value);
    }-*/;

    public native void setValue(String value) /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        field.setValue(value);
    }-*/;

    public native boolean validate() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return field.validate();
    }-*/;

    public native void addFieldListener(FieldListener listener) /*-{
        var fieldJ = this;
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;

        field.addListener('blur',
                function(fld) {
                    listener.@com.gwtext.client.widgets.form.event.FieldListener::onBlur(Lcom/gwtext/client/widgets/form/Field;)(fieldJ);
                }
        );

        field.addListener('change',
                function(fld, newVal, oldVal) {
                    listener.@com.gwtext.client.widgets.form.event.FieldListener::onChange(Lcom/gwtext/client/widgets/form/Field;Ljava/lang/String;Ljava/lang/String;)(fieldJ, newVal, oldVal);
                }
        );

        field.addListener('focus',
                function(fld) {
                    listener.@com.gwtext.client.widgets.form.event.FieldListener::onFocus(Lcom/gwtext/client/widgets/form/Field;)(fieldJ);
                }
        );

        field.addListener('invalid',
                function(fld, msg) {
                    listener.@com.gwtext.client.widgets.form.event.FieldListener::onInvalid(Lcom/gwtext/client/widgets/form/Field;Ljava/lang/String;)(fieldJ, msg);
                }
        );

        field.addListener('specialkey',
                function(fld, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.form.event.FieldListener::onSpecialKey(Lcom/gwtext/client/widgets/form/Field;Lcom/gwtext/client/core/EventObject;)(fieldJ, e);
                }
        );

        field.addListener('valid',
                function(fld) {
                    listener.@com.gwtext.client.widgets.form.event.FieldListener::onValid(Lcom/gwtext/client/widgets/form/Field;)(fieldJ);
                }
        );    

    }-*/;
}
