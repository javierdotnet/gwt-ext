/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.DomConfig;
import com.gwtext.client.widgets.BoxComponent;
import com.gwtext.client.widgets.form.event.FieldListener;

/**
 * Base class for form fields that provides default event handling, sizing, value handling and other functionality.
 */
public abstract class Field extends BoxComponent {

	public Field() {
    }

	public Field(String fieldLabel) {
		setFieldLabel(fieldLabel);
	}

	public Field(String fieldLabel, String name) {
		setFieldLabel(fieldLabel);
		setName(name);
	}
	
	public Field(String fieldLabel, String name, int width) {
		setFieldLabel(fieldLabel);
		setName(name);
		setWidth(width);
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

    protected abstract JavaScriptObject create(JavaScriptObject config) ;

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
        applyTo(getOrCreateJsObj(), id);
    }

    /**
     * Apply the behaviors of this component to an existing element. This is used instead of render().
     *
     * @param element the element
     */
    public native void applyTo(Element element) /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        field.applyTo(element);
    }-*/;

    private native void applyTo(JavaScriptObject field, String id) /*-{
        field.applyTo(id);
    }-*/;

    /**
     * Clear any invalid styles/messages for this field.
     */
    public native void clearInvalid() /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        field.clearInvalid();
    }-*/;

    /**
     * Returns the name attribute of the field if available.
     *
     * @return  the name attribute of the Field
     */
    public String getName() {
		return getAttribute("name");
	}
             
    /**
     * Returns the raw data value which may or may not be a valid, defined value.
     *
     * @return the raw field value
     */
    public native String getRawValue() /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return field.getRawValue();
    }-*/;

    /**
     * Return the value of the field as a String.
     *
     * @return value as String
     */
    public native String getValueAsString() /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var value = field.getValue();
        return (value == null || value === undefined ) ? '' : value.toString();
    }-*/;

    /**
     * Returns true if this field has been changed since it was originally loaded and is not disabled.
     *
     * @return true if field changed
     */
    public native boolean isDirty() /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return field.isDirty();
    }-*/;

    /**
     * Returns whether or not the field value is currently valid.
     *
     * @return true if valid
     */
    public native boolean isValid() /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return field.isValid();
    }-*/;

    /**
     * Returns whether or not the field value is currently valid.
     * 
     * @param preventMark true to disable marking the field invalid
     * @return true if valid
     */
    public native boolean isValid(boolean preventMark) /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return field.isValid(preventMark);
    }-*/;

    /**
     * Mark this field as invalid.
     *
     * @param message the validation message
     */
    public native void markInvalid(String message) /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        field.markInvalid(message);
    }-*/;

    /**
     * Resets the current field value to the originally loaded value and clears any validation messages.
     */
    public native void reset() /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        field.reset();
    }-*/;

    /**
     * Sets the underlying DOM field's value directly, bypassing validation. To set the value with validation use {@link #setValue(String)}.
     *
     * @param value field value
     */
    public native void setRawValue(String value) /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        field.setRawValue(value);
    }-*/;

    /**
     * Sets a data value into the field and validates it. To set the value directly without validation see {@link #setRawValue(String)}.
     *
     * @param value the field value
     */
    private native void setValueRendered(String value) /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        field.setValue(value);
    }-*/;

    public native boolean validate() /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return field.validate();
    }-*/;

    /**
     * Add a Field Listener.
     *
     * @param listener the listener
     */
    public native void addListener(FieldListener listener) /*-{
        this.@com.gwtext.client.widgets.BoxComponent::addListener(Lcom/gwtext/client/widgets/event/BoxComponentListener;)(listener);
        var fieldJ = this;

		this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('blur',
                function(fld) {
                    listener.@com.gwtext.client.widgets.form.event.FieldListener::onBlur(Lcom/gwtext/client/widgets/form/Field;)(fieldJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('change',
                function(fld, newVal, oldVal) {					
                    var newValJ = (newVal  == null || newVal === undefined || newVal == '') ? null : $wnd.GwtExt.convertToJavaType(newVal);
                    var oldValJ = (oldVal  == null || oldVal === undefined || oldVal == '' ) ? null : $wnd.GwtExt.convertToJavaType(oldVal);
					listener.@com.gwtext.client.widgets.form.event.FieldListener::onChange(Lcom/gwtext/client/widgets/form/Field;Ljava/lang/Object;Ljava/lang/Object;)(fieldJ, newValJ, oldValJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('focus',
                function(fld) {
                    listener.@com.gwtext.client.widgets.form.event.FieldListener::onFocus(Lcom/gwtext/client/widgets/form/Field;)(fieldJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('invalid',
                function(fld, msg) {
					if(msg === undefined) msg = null;
					listener.@com.gwtext.client.widgets.form.event.FieldListener::onInvalid(Lcom/gwtext/client/widgets/form/Field;Ljava/lang/String;)(fieldJ, msg);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('specialkey',
                function(fld, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.form.event.FieldListener::onSpecialKey(Lcom/gwtext/client/widgets/form/Field;Lcom/gwtext/client/core/EventObject;)(fieldJ, e);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('valid',
                function(fld) {
                    listener.@com.gwtext.client.widgets.form.event.FieldListener::onValid(Lcom/gwtext/client/widgets/form/Field;)(fieldJ);
                }
        );    

    }-*/;


    // --- config properties ---


    public String getXType() {
        return "field";
    }

	/**
	 * Set to true for a default element spec (defaults to {tag: "input", type: "text", size: "20", autocomplete: "off"})
	 *
	 * @param autoCreate true for a default element spec
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setAutoCreate(boolean autoCreate) throws IllegalStateException {
        setAttribute("autoCreate", autoCreate, true);
    }

	public boolean isAutoCreate() {
		return getAttributeAsBoolean("autoCreate");
	}

	/**
	 * A DomHelper config spec to use for field creation.
	 *
	 * @param domConfig  a DomHelper config spec to use for field creation
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setAutoCreate(DomConfig domConfig) throws IllegalStateException {
		setAttribute("autoCreate", domConfig.getJsObject(), true);
	}

	/**
	 * The CSS class used to provide field clearing (defaults to 'x-form-clear-left')
	 *
	 * @param clearCls the CSS class used to provide the clearing
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setClearCls(String clearCls) throws IllegalStateException {
		setAttribute("clearCls", clearCls, true);
	}

	/**
	 * The CSS class used to provide field clearing (defaults to 'x-form-clear-left')
	 *
	 * @return the clear Class
	 */
	public String getClearCls() {
		return getAttribute("clearCls");
	}

	/**
     * A CSS class to apply to the field's underlying element.
     *
     * @param cls the CSS class
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setCls(String cls) throws IllegalStateException {
        super.setCls(cls);
    }

	/**
	 * CSS class to apply to the field's underlying element
	 *
	 * @return the CSS class
	 */
	public String getCls() {
		return getAttribute("cls");
	}

	/**
     * True to disable the field (defaults to false).
     *
     * @param disabled true to disable
     */
    public void setDisabled(boolean disabled) {
        if(!isRendered()) {
            setAttribute("disabled", disabled, true, true);
        } else {
            super.setDisabled(disabled);
        }
    }

	/**
     * The default CSS class for the field (defaults to "x-form-field").
	 *
     * @param fieldClass the fields class
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setFieldClass(String fieldClass) throws IllegalStateException {
        setAttribute("fieldClass", fieldClass, true);
    }

    /**
     * The CSS class to use when the field receives focus (defaults to "x-form-focus").
     *
     * @param focusClass CSS class on focus
     */
    public void setFocusClass(String focusClass) {
        setAttribute("focusClass", focusClass, true, true);
    }

	/**
	 * The CSS class to use when the field receives focus (defaults to "x-form-focus").
	 *
	 * @return the focus class
	 */
	public String getFocusClass() {
		return getAttribute("focusClass");
	}

    /**
     * Set the fields label. Alias for {@link #setFieldLabel(String)}
     *
     * @param fieldLabel the field label
     */
    public void setLabel(String fieldLabel) {
        setFieldLabel(fieldLabel);
    }
    /**
     * Set the fields label.
     *
     * @param fieldLabel the field label
     */
    public void setFieldLabel(String fieldLabel) {
        setAttribute("fieldLabel", fieldLabel, true, true);
        if(isRendered()) {
            setFieldLabelRendered(fieldLabel, getId());
        }
    }

    /**
     * The field label.
     *
     * @return the field label
     */
    public String getFieldLabel() {
        return getAttribute("fieldLabel");
    }

    private native void setFieldLabelRendered(String fieldLabel, String fieldId) /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var label = $wnd.Ext.DomQuery.select($wnd.String.format('label[for="{0}"]', fieldId));
        if (label){
            //todo preserve user specified labelSeparator and only update the label text.
            //var separator = typeof field.container.labelSeparator == 'undefined' ? field.labelSeparator : field.container.labelSeparator;
            label[0].childNodes[0].nodeValue = fieldLabel;
        }
    }-*/;


    public void hide() {
        super.hide();
        getEl().up(".x-form-item").setDisplayed(false);
    }

    public void show() {
        super.show();
        getEl().up(".x-form-item").setDisplayed(true);
    }

    /**
	 * True to completely hide the label element (defaults to false).
	 *
	 * @param hideLabel true to completely hide the label element (defaults to false)
	 * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setHideLabel(boolean hideLabel) throws IllegalStateException {
		setAttribute("hideLabel", hideLabel, true);
	}

	public boolean isHideLabel() {
		return getAttributeAsBoolean("hideLabel");
	}

	/**
     * The type attribute for input fields -- e.g. radio, text, password (defaults to "text").
     *
     * @param inputType the input type
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setInputType(String inputType) throws IllegalStateException {
        setAttribute("inputType", inputType, true);
    }

	/**
	 * The type attribute for input fields -- e.g. radio, text, password (defaults to "text").
	 *
	 * @return the input type
	 */
	public String getInputType() {
		if(isRendered()) {
			return DOM.getElementProperty(getElement(), "type");
		} else {
			String inputType = getAttribute("inputType");
			if(inputType == null) inputType = "text";
			return inputType;
		}
	}

	/**
     * The CSS class to use when marking a field invalid (defaults to "x-form-invalid").
     *
     * @param invalidClass CSS class when field is invalid
     */
    public void setInvalidClass(String invalidClass) {
        setAttribute("invalidClass", invalidClass, true, true);
    }

	/**
	 * The CSS class to use when marking a field invalid (defaults to "x-form-invalid").
	 *
	 * @return the invalid CSS class
	 */
	public String getInvalidClass() {
		return getAttribute("invalidClass");
	}

	/**
     * The error text to use when marking a field invalid and no message is provided (defaults to "The value in this field is invalid").
     * This error message is displayed when the used specified validator returns false.
     *
     * @param invalidText invalid text on error
     * @see TextField#setValidator(Validator)
     */
    public void setInvalidText(String invalidText) {
        setAttribute("invalidText", invalidText, true, true);
    }

	/**
	 * The error text to use when marking a field invalid and no message is provided (defaults to "The value in this field is invalid").
     * This error message is displayed when the used specified validator returns false.
	 *
	 * @return the invalid text
	 */
	public String getInvalidText() {
		return getAttribute("invalidText");
	}

    /**
     * Set the CSS style of the fields label. For example 'display:none'.
	 *
     * @param labelStyle the CSS style for the fields label
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setLabelStyle(String labelStyle) throws IllegalStateException {
        setAttribute("labelStyle", labelStyle, true);
    }

	/**
	 * The CSS style of the fields label.
	 *
	 * @return the label style
	 */
	public String getLabelStyle() {
		return getAttribute("labelStyle");
	}

	/**
     * The seprator between the fields label and the field. Can use ' ' or '&amp;nbsp;'
	 *
     * @param labelSeparator the label separator
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setLabelSeparator(String labelSeparator) throws IllegalStateException {
        setAttribute("labelSeparator", labelSeparator, true);
    }

	/**
	 * The seprator between the fields label and the field.
	 *
	 * @return the label separator
	 */
	public String getLabelSeparator() {
		return getAttribute("labelSeparator");
	}

	//todo enum
    /**
     * The effect used when displaying a validation message under the field (defaults to 'normal').
     * Other possible values are "slide" and "slideRight"
     *
     * @param msgFx validation message style
     */
    public void setMsgFx(String msgFx) {
        setAttribute("msgFx", msgFx, true, true);
    }

    /**
     * The location where error text should display. Should be one of the following values (defaults to 'qtip') :
     *
     * <pre>
     * Value         Description
     * -----------   ----------------------------------------------------------------------
     * qtip          Display a quick tip when the user hovers over the field
     * title         Display a default browser title attribute popup
     * under         Add a block div beneath the field containing the error text
     * side          Add an error icon to the right of the field with a popup on hover
     * [element id]  Add the error text directly to the innerHTML of the specified element</pre>
     *
     * @param msgTarget the error message target
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setFieldMsgTarget(String msgTarget) throws IllegalStateException {
        setAttribute("msgTarget", msgTarget, true);
    }

	/**
     * Set the field's HTML name attribute.
	 *
     * @param name the fields name
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setName(String name) throws IllegalStateException {
        setAttribute("name", name, true);
    }


	/**
     * True to mark the field as readOnly in HTML (defaults to false) -- Note: this only sets the element's readOnly DOM attribute.
     *
     * @param readOnly true to mark field read only
     */
    public void setReadOnly(boolean readOnly)  {
        if(!isRendered()) {
            setAttribute("readOnly", readOnly, true);
        } else {
            DOM.setElementPropertyBoolean(getElement(), "readOnly", readOnly);
        }
    }

    /**
     * True if read only.
     *
     * @return true if read only.
     */
    public boolean isReadOnly() {
        if(!isRendered()) {
            return getAttributeAsBoolean("readOnly");
        } else {
            return DOM.getElementPropertyBoolean(getElement(), "readOnly");
        }
    }

	/**
     * The tabIndex for this field. Note this only applies to fields that are rendered, not those which are built via applyTo.
	 *
     * @param tabIndex the fields tab index
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTabIndex(int tabIndex) throws IllegalStateException {
        setAttribute("tabIndex", tabIndex, true);
    }

	/**
	 * The tabIndex for this field.
	 *
	 * @return the tab index
	 */
	public int getTabindex() {
		return getAttributeAsInt("tabindex");
	}

	/**
     * Whether the field should validate when it loses focus (defaults to true).
     *
     * @param validateOnBlur true to validate on blur
     */
    public void setValidateOnBlur(boolean validateOnBlur) {
        setAttribute("validateOnBlur", validateOnBlur, true, true);
    }

	/**
	 * Whether the field should validate when it loses focus (defaults to true).
	 *
	 * @return true if validate on blur
	 */
	public boolean isValidateOnBlur() {
		return getAttributeAsBoolean("validateOnBlur");
	}

	/**
     * The length of time in milliseconds after user input begins until validation is initiated (defaults to 250).
	 *
     * @param validationDelay the validation delay in milliseconds
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setValidationDelay(int validationDelay) throws IllegalStateException {
        setAttribute("validationDelay", validationDelay, true);
    }

	/**
	 * The length of time in milliseconds after user input begins until validation is initiated (defaults to 250).
	 *
	 * @return the validation delay
	 */
	public int getValidationDelay() {
		return getAttributeAsInt("validationDelay");
	}

	/**
     *  Set to false to disable automatic validation.
     *
     * @param validationEvent false to disable automatic validation
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setValidationEvent(boolean validationEvent) throws IllegalStateException {
        setAttribute("validationEvent", validationEvent, true);
    }

    /**
     * The event that should initiate field validation. (defaults to "keyup")..
     *
     * @param validationEvent event to initiate validation
     */
    public void setValidationEvent(String validationEvent) {
        setAttribute("validationEvent", validationEvent, true, true);
    }

    /**
     * A value to initialize this field with.
     *
     * @param value the field value
     */
    public void setValue(String value) {
        if(!isRendered()) {
            setAttribute("value", value, true);
        }else {
            setValueRendered(value);
        }
    }

}
