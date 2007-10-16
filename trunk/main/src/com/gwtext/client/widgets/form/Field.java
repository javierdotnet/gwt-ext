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
import com.gwtext.client.widgets.BoxComponent;
import com.gwtext.client.widgets.form.event.FieldListener;

/**
 * Base class for form fields that provides default event handling, sizing, value handling and other functionality.
 */
public class Field extends BoxComponent {

    /**
     * Creates a new Field.
     */
    public Field() {
        setJsObj(create(null));
    }

    /**
     * Creates a new Field using the specified configuration.
     *
     * @param config field config
     */
    public Field(FieldConfig config) {
        setJsObj(create(config.getJsObj()));        
        if (config.getFieldListener() != null) {
            addFieldListener(config.getFieldListener());
        }
    }

    public Field(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static Field instance(JavaScriptObject jsObj) {
        return new Field(jsObj);
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

    /**
     * Apply the behaviors of this component to an existing element. This is used instead of render().
     *
     * @param id the ID of the node
     */
    public void applyTo(String id) {
        Element el = DOM.getElementById(id);
        if (el == null) {
            throw new IllegalArgumentException("Element with id : " + id + " not found.");
            //RootPanel.get().add(new HTML("<div id='" + id + "'></div"));
        }
        applyTo(jsObj, id);
    }

    /**
     * Apply the behaviors of this component to an existing element. This is used instead of render().
     *
     * @param element the element
     */
    public native void applyTo(Element element) /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        field.applyTo(element);
    }-*/;

    private native void applyTo(JavaScriptObject field, String id) /*-{
        field.applyTo(id);
    }-*/;

    /**
     * Clear any invalid styles/messages for this field.
     */
    public native void clearInvalid() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        field.clearInvalid();
    }-*/;

    /**
     * Returns the name attribute of the field if available.
     *
     * @return  the name attribute of the Field
     */
    public native String getName() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return field.getName();
    }-*/;

    /**
     * Returns the raw data value which may or may not be a valid, defined value.
     *
     * @return the raw field value
     */
    public native String getRawValue() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return field.getRawValue();
    }-*/;

    /**
     * Return the value of the field as a String.
     *
     * @return value as String
     */
    public native String getValueAsString() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var value = field.getValue();
        return (value == null || value === undefined ) ? '' : value.toString();
    }-*/;

    /**
     * Returns true if this field has been changed since it was originally loaded and is not disabled.
     *
     * @return true if field changed
     */
    public native boolean isDirty() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return field.isDirty();
    }-*/;

    /**
     * Returns whether or not the field value is currently valid.
     *
     * @return true if valid
     */
    public native boolean isValid() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return field.isValid();
    }-*/;

    /**
     * Returns whether or not the field value is currently valid.
     * 
     * @param preventMark true to disable marking the field invalid
     * @return true if valid
     */
    public native boolean isValid(boolean preventMark) /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return field.isValid(preventMark);
    }-*/;

    /**
     * Mark this field as invalid.
     *
     * @param message the validation message
     */
    public native void markInvalid(String message) /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        field.markInvalid(message);
    }-*/;

    /**
     * Resets the current field value to the originally loaded value and clears any validation messages.
     */
    public native void reset() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        field.reset();
    }-*/;

    /**
     * Sets the underlying DOM field's value directly, bypassing validation. To set the value with validation use {@link #setValue(String)}.
     *
     * @param value field value
     */
    public native void setRawValue(String value) /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        field.setRawValue(value);
    }-*/;

    /**
     * Sets a data value into the field and validates it. To set the value directly without validation see {@link #setRawValue(String)}.
     *
     * @param value the field value
     */
    public native void setValue(String value) /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        field.setValue(value);
    }-*/;

    public native boolean validate() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return field.validate();
    }-*/;

    /**
     * Add a Field Listener.
     *
     * @param listener the listener
     */
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
                    var newValJ = (newVal  == null || newVal === undefined || newVal == '') ? null : $wnd.GwtExt.convertToJavaType(newVal);
                    var oldValJ = (oldVal  == null || oldVal === undefined || oldVal == '' ) ? null : $wnd.GwtExt.convertToJavaType(oldVal);
					listener.@com.gwtext.client.widgets.form.event.FieldListener::onChange(Lcom/gwtext/client/widgets/form/Field;Ljava/lang/Object;Ljava/lang/Object;)(fieldJ, newValJ, oldValJ);
                }
        );

        field.addListener('focus',
                function(fld) {
                    listener.@com.gwtext.client.widgets.form.event.FieldListener::onFocus(Lcom/gwtext/client/widgets/form/Field;)(fieldJ);
                }
        );

        field.addListener('invalid',
                function(fld, msg) {
					if(msg === undefined) msg = null;
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
