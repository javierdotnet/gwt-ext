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
 

package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.form.event.TextFieldListener;
import com.gwtext.client.widgets.event.KeyListener;
import com.gwtext.client.core.Function;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.EventCallback;
import com.gwtext.client.core.ListenerConfig;

/**
 * Basic text field.
 *
 * @author Sanjiv Jivan
 */
public class TextField extends Field {

	private static JavaScriptObject configPrototype;
	private Validator validator;
	
	static {
		init();
	}

	private static native void init()/*-{
		var c = new $wnd.Ext.form.TextField();
		@com.gwtext.client.widgets.form.TextField::configPrototype = c.initialConfig;
	}-*/;

	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "textfield";
	}


    /**
     * Create a new TextField.
     */
    public TextField() {
    }

    /**
     * Create a new TextField.
     *
     * @param fieldLabel the field label
     */
    public TextField(String fieldLabel) {
        super(fieldLabel);
    }

    /**
     * Create a new TextField.
     *
     * @param fieldLabel the field label
     * @param name the field name
     */
    public TextField(String fieldLabel, String name) {
        super(fieldLabel, name);
    }

    /**
     * Create a new TextField.
     *
     * @param fieldLabel the field label
     * @param name the field name
     * @param width the field width
     */
    public TextField(String fieldLabel, String name, int width) {
        super(fieldLabel, name, width);
    }

    /**
     * Create a new TextField.
     *
     * @param fieldLabel the field label
     * @param name the field name
     * @param width the field width
     * @param value the field value
     */
    public TextField(String fieldLabel, String name, int width, String value) {
        super(fieldLabel, name, width);
        setValue(value);
    }

	public TextField(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
        return new $wnd.Ext.form.TextField(jsObj);
    }-*/;

	/**
	 * Add a key listener.
	 *
	 * @param keyCode the numeric key code
	 * @param listener the key listener
	 */
	public void addKeyListener(final int keyCode, final KeyListener listener) {
		if(!isRendered()) {
			addListener("render", new Function() {
				public void execute() {
					addKeyListener(keyCode, listener);
				}
			});
		} else {
			getEl().addKeyListener(keyCode, listener);
		}
	}

    /**
     * Add a key listener.
     *
     * @param keyCodes  array of key codes
     * @param listener the key listener
     */
	public void addKeyListener(final int[] keyCodes, final KeyListener listener) {
		if(!isRendered()) {
			addListener("render", new Function() {
				public void execute() {
					addKeyListener(keyCodes, listener);
				}
			});
		} else {
			getEl().addKeyListener(keyCodes, listener);
		}
	}

    /**
     * Add a key listener.
     *
     * @param keys  a string with the keys to listen for
     * @param listener the key listener
     */
	public void addKeyListener(final String keys, final KeyListener listener) {
		if(!isRendered()) {
			addListener("render", new Function() {
				public void execute() {
					addKeyListener(keys, listener);
				}
			});
		} else {
			getEl().addKeyListener(keys, listener);
		}
	}

	/**
	 * Add a key press listener
	 *
	 * @param listener the key press listener
	 */
	public void addKeyPressListener(final EventCallback listener) {
		if(!isRendered()) {
			addListener("render", new Function() {
				public void execute() {
					addKeyPressListener(listener);
				}
			});
		} else {
			getEl().addListener("keypress", listener);
		}
	}
	
	/**
	 * Add a key press listener
	 *
	 * @param listener the key press listener
	 * @param listenerConfig the listener config
	 */
	public void addKeyPressListener(final EventCallback listener, final ListenerConfig listenerConfig) {
		if(!isRendered()) {
			addListener("render", new Function() {
				public void execute() {
					addKeyPressListener(listener, listenerConfig);
				}
			});
		} else {
			getEl().addListener("keypress", listener, listenerConfig);
		}
	}

	/**
     * Add a TextField listener.
     *
     * @param listener the listener
     */
    public native void addListener(TextFieldListener listener) /*-{
        this.@com.gwtext.client.widgets.form.Field::addListener(Lcom/gwtext/client/widgets/form/event/FieldListener;)(listener);
        var fieldJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('autosize',
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
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        field.autoSize();
    }-*/;

    /**
     * Selects text in this field.
     */
    public native void selectText() /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        field.selectText();
    }-*/;

    /**
     * Selects text in this field.
     *
     * @param start the index where the selection should start 
     * @param end the index where the selection should end
     */
    public native void selectText(int start, int end) /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        field.selectText(start, end);
    }-*/;

    /**
     * Validates a value according to the field's validation rules and marks the field as invalid if the validation fails.
     * 
     * @param value the value to valdiate
     * @return true if valid
     */
    public native boolean validateValue(String value) /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
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


    // --- config properties ---


    /**
     * False to validate that the value length > 0 (defaults to true).
     *
     * @param allowBlank false to disallow blank
     */
    public void setAllowBlank(boolean allowBlank) {
        setAttribute("allowBlank", allowBlank, true, true);
    }
    
    /**
     * Error text to display if the allow blank validation fails (defaults to "This field is required").
     *
     * @param blankText error message for blank field
     */
    public void setBlankText(String blankText)  {
        setAttribute("blankText", blankText, true, true);
    }

    /**
     * True to disable input keystroke filtering (defaults to false).
     *
     * @param disableKeyFilter true to disable
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setDisableKeyFilter(boolean disableKeyFilter) throws IllegalStateException {
        setAttribute("disableKeyFilter", disableKeyFilter, true);
    }

    /**
     * The CSS class to apply to an empty field to style the emptyText (defaults to 'x-form-empty-field'). This class is
     * automatically added and removed as needed depending on the current field value.
     *
     * @param emptyClass the empty field CSS class
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setEmptyClass(String emptyClass) throws IllegalStateException {
        setAttribute("emptyClass", emptyClass, true);
    }

    /**
     * The default text to display in an empty field (defaults to null).
     *
     * @param emptyText the empty field text
     */
    public void setEmptyText(String emptyText) {
        setAttribute("emptyText", emptyText, true, true);
    }

    /**
     * True if this field should automatically grow and shrink to its content.
     *
     * @param grow true to allow grow
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setGrow(boolean grow) throws IllegalStateException {
        setAttribute("grow", grow, true);
    }

    /**
     *  The maximum width to allow when grow = true (defaults to 800).
	 *
     * @param growMax the max width
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setGrowMax(int growMax) throws IllegalStateException {
        setAttribute("growMax", growMax, true);
    }

    /**
     * The minimum width to allow when grow = true (defaults to 30).
	 *
     * @param growMin the minimum width
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setGrowMin(int growMin) throws IllegalStateException {
        setAttribute("growMin", growMin, true);
    }

    /**
     * An input mask regular expression that will be used to filter keystrokes that
     * don't match (defaults to null).
	 *
     * <br><br>
     * <b>Note:</b> This property cannot be changed after the Component has been rendered.
     *
     * @param maskRe the mask regular expression
     */
    public native void setMaskRe(String maskRe) /*-{
        var config = this.@com.gwtext.client.widgets.Component::config;
        config['maskRe'] = new $wnd.RegExp(maskRe);
    }-*/;

    public void setMaxLength(int maxLength) {
        setAttribute("maxLength", maxLength, true, true);
    }

    /**
     * Error text to display if the maximum length validation fails.
     * (defaults to "The maximum length for this field is {maxLength}")
     *
     * @param maxLengthText the max lenght error text
     */
    public void setMaxLengthText(String maxLengthText) {
        setAttribute("maxLengthText", maxLengthText, true, true);
    }

    /**
     * Minimum input field length required (defaults to 0).
     *
     * @param minLength the min length
     */
    public void setMinLength(int minLength) {
        setAttribute("minLength", minLength, true, true);
    }

    /**
     * Error text to display if the minimum length validation fails. (defaults to "The minimum length for this field is {minLength}")
     *
     * @param minLengthText the min length error text
     */
    public void setMinLengthText(String minLengthText) {
        setAttribute("minLengthText", minLengthText, true, true);
    }

    /**
     * Set true if field is a password field.
	 *
     * @param password true if passowrd field
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setPassword(boolean password) throws IllegalStateException {
        if(password) setInputType("password");
    }

    /**
     * A Regular Expressionto be tested against the field value during validation (defaults to null).
     * If available, this regex will be evaluated only after the basic validators all return true, and will be passed
     * the current field value. If the test fails, the field will be marked invalid using regexText.
	 *
     *
     * @param regex the regular expression
     */
    public void setRegex(String regex)  {
        setRegex(isCreated() ? getJsObj() : config, regex);
    }

    private native void setRegex(JavaScriptObject config, String regex) /*-{
        config['regex'] = new $wnd.RegExp(regex);
    }-*/;

    /**
     * The error text to display if regex is used and the test fails during validation (defaults to "").
     *
     * <br><br>
     * <b>Note:</b> This property cannot be changed after the Component has been rendered.
     *
     * @param regexText the regexp text
     */
    public void setRegexText(String regexText)  {
        setAttribute("regexText", regexText, true, true);
    }

    /**
     * True to automatically select any existing field text when the field receives input focus (defaults to false).
	 *
     * @param selectOnFocus true to select text on focus
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setSelectOnFocus(boolean selectOnFocus) throws IllegalStateException {
        setAttribute("selectOnFocus", selectOnFocus, true);
    }

    /**
     * Set a custom Validator for the Field.
	 *
     *
     * @param validator the field validator
     */
    public void setValidator(Validator validator) {
        this.validator = validator;
    	setValidator(config, validator);
    }

    /**
     * Get the validator set for this field (if any).
     * Returns null if user hasn't called setValidator() on this TextField instance.
     * 
     * @return the validator
     */
    public Validator getValidator() {
    	return this.validator;
    }
    
    private static String doValidate(Validator validator, String value) {
        try {
            return validator.validate(value) ? "true-val" : "false-val";
        } catch (ValidationException e) {
            return e.getMessage();
        }
    }

    private native void setValidator(JavaScriptObject config, Validator validator) /*-{
        config['validator'] = function(value) {
            var val = @com.gwtext.client.widgets.form.TextField::doValidate(Lcom/gwtext/client/widgets/form/Validator;Ljava/lang/String;)(validator, value);
            if(val === "true-val") {
                return true;
            } else if ( val === "false-val") {
                return false;
            } else {
                return val;
            }
        }
    }-*/;

    //http://extjs.com/forum/showthread.php?t=5717&highlight=vtype
    /**
     * A validation type name as defined in {@link VType} (defaults to null).
     *
     * @param vtype the validation type
     */
    public void setVtype(VType vtype) {
        setAttribute("vtype", vtype.getVType(), true);
    }

    /**
     * The validation type text if the validation specified by {@link #setVtype(VType)} fails.
     *
     * @param vtypeText the vtype
     */
    public void setVtypeText(String vtypeText) {
        setAttribute("vtypeText", vtypeText, true);
    }

    /** 
     * This method return the position of the caret as a
     * int array.  Two values are provided: start of highlight
     * and end of highlight.  If there is nothing highlighted,
     * the two values are the same.
     * @return the position of the caret: start and end position
     */
    public int[] getCaretPosition(){
    	int retval[] = new int[2];
    	JavaScriptObject jsob = getCaretPositionJs();
    	retval[0] = JavaScriptObjectHelper.getAttributeAsInt(jsob, "start");
    	retval[1] = JavaScriptObjectHelper.getAttributeAsInt(jsob, "end");
    	
    	return retval;    	
    }
    
    private native JavaScriptObject getCaretPositionJs()  /*-{
    	var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
    	var el = $doc.getElementById(field.getId());
	    var result = { start: 0, end: 0 };
	    
		// IE Support
		if ($doc.selection) {
		    el.focus();
			if (el.type === 'text') // textbox
			{
				var range = $doc.selection.createRange();
				var r2 = range.duplicate();
				result.start = 0 - r2.moveStart('character', -100000);
				result.end = result.start + range.text.length;
			}
			else // textarea
			{
				if (el.value.charCodeAt(el.value.length-1) < 14) {
					el.value=el.value.replace(/\034/g,'')+String.fromCharCode(28);
				}
				var oRng = $doc.selection.createRange();
				var oRng2 = oRng.duplicate();
				oRng2.moveToElementText(el);
				oRng2.setEndPoint('StartToEnd', oRng);
				result.end = el.value.length-oRng2.text.length;
				oRng2.setEndPoint('StartToStart', oRng);
				result.start = el.value.length-oRng2.text.length;

			}
		}
		// Firefox support
		else if (el.selectionStart || el.selectionStart == '0')
		{
			result.start = el.selectionStart;
			result.end = el.selectionEnd;
		}
		return result;
	}-*/;	

    /**
     * This method sets the caret position
     * @param caretPos the caret position
     */
    public native void setCaretPosition(int caretStart, int numToSelect) /*-{
    	var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
    	var el = $doc.getElementById(field.getId());

		if ($doc.selection) // IE
		{
			var range = $doc.selection.createRange();
			if (el.type == 'text') // textbox
			{
				range.moveStart ('character', -el.value.length);
				range.moveEnd ('character', -el.value.length);
				range.moveStart ('character', caretStart);
				range.moveEnd ('character', numToSelect);
				range.select();	
			}
			else // textarea
			{
				var sel = el.createTextRange();
				sel.collapse(true);
				sel.moveStart("character", caretStart);
				sel.moveEnd("character", numToSelect);
				sel.select();
			}
		}
		else if (el.selectionStart || el.selectionStart == '0') // Firefox
		{
			el.setSelectionRange(caretStart, caretStart+numToSelect);
		}
		
    }-*/;
    
    
    public native void insertAtCaret(String text) /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
    	var el = $doc.getElementById(field.getId());
    	
		if($doc.selection) {
			el.focus();
			var orig = el.value.replace(/\r\n/g, "\n");
			var range = $doc.selection.createRange();

			if(range.parentElement() != el) {
				return false;
			}

			range.text = text;
			var actual, tmp;
			
			actual = tmp = el.value.replace(/\r\n/g, "\n");

			for(var diff = 0; diff < orig.length; diff++) {
				if(orig.charAt(diff) != actual.charAt(diff)) break;
			}

			for(var index = 0, start = 0; 
				tmp.match(text) 
					&& (tmp = tmp.replace(text, "")) 
					&& index <= diff; 
				index = start + text.length
			) {
				start = actual.indexOf(text, index);
			}
		} else if(el.selectionStart) {
			var start = el.selectionStart;
			var end   = el.selectionEnd;

			el.value = el.value.substr(0, start) 
				+ text 
				+ el.value.substr(end, el.value.length);
		}
		
		if(start != null) {
		    var textend = start + text.length;
		    this.@com.gwtext.client.widgets.form.TextField::setCaretPosition(II)(textend,textend);
		} else {
			el.value += text;
		}
    }-*/;
    
}
