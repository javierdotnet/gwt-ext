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
import com.google.gwt.user.client.Element;
import com.gwtext.client.widgets.event.DatePickerListener;

import java.util.Date;

/**
 * Provides a date input field with {@link com.gwtext.client.widgets.DatePicker} dropdown and automatic date validation.
 *
 * @author Sanjiv Jivan
 */
public class DateField extends TextField {

	/**
	 * Fixes issues with the normal DateField...
	 */
	static {
		fix();
	}
	
	/**
	 * This method is called once when the DateField is instantiated.  
	 * This method currently fixes the fire of event on select!
	 */
	private static native void fix()/*-{
		$wnd.Ext.ux.DateFieldEx = $wnd.Ext.extend($wnd.Ext.form.DateField, {
			initComponent: function () {
				$wnd.Ext.ux.DateFieldEx.superclass.initComponent.call(this);
				this.addEvents(
			    	'select'
				);
			    this.menuListeners.select = function (m, d) {
			    	if (this.fireEvent("select", this, d) !== false)
			        	this.setValue(d);
			    };
			}
		});
		$wnd.Ext.reg('datefieldex', $wnd.Ext.ux.DateFieldEx);
	}-*/;
	
    /**
     * Construct a new DateField.
     */
    public DateField() {
    }

    /**
     * Construct a new DateField.
     *
     * @param fieldLabel the field label
     * @param name the field name
     * @param width the field width
     */
    public DateField(String fieldLabel, String name, int width) {
        super(fieldLabel, name, width);
    }

    /**
     * Construct a new DateField.
     *
     * @param label the field label value
     * @param format the date format value
     */
    public DateField(String label, String format) {
        setFieldLabel(label);
        setFormat(format);
    }

    public DateField(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
        return new $wnd.Ext.ux.DateFieldEx(jsObj);
    }-*/;

    /**
     * Returns the current date value of the date field.
     *
     * @return the date value
     */
    public Date getValue() {
        double date = getTime(getOrCreateJsObj());
        return date == -1 ? null : new Date((long)date);
    }

    /**
     * Add a Date Picker Listener.
     *
     * @param listener the listener
     */
    public native void addListener(DatePickerListener listener) /*-{
        this.@com.gwtext.client.widgets.Component::addListener(Lcom/gwtext/client/widgets/event/ComponentListener;)(listener);

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('select',
                function(datePicker, date) {
                    var d = @com.gwtext.client.util.DateUtil::create(D)(date.getTime());
                    var componentJ = @com.gwtext.client.widgets.DatePicker::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(datePicker);
                    listener.@com.gwtext.client.widgets.event.DatePickerListener::onSelect(Lcom/gwtext/client/widgets/DatePicker;Ljava/util/Date;)(componentJ, d);
                }
        );
    }-*/;
    
	protected native Element getElement(JavaScriptObject jsObj) /*-{
        //for trigger fields, we want the text area as well as the trigger button to be treated as the element
        //unit
        var extEl = jsObj.wrap;
        if(extEl == null || extEl === undefined) {
            return null;
        }
        var el = extEl.dom;
        if(el == null || el === undefined) {
            return null;
            //forms buttons are detached when initially added
        } else {
            //There's an inconsistency in Ext where most elements have the property 'el' set to Ext's Element
            //with the exception of Menu->Item, Menu->Separator, Menu->TextItem,  Toolbar.Item and subclasses
            //(Toolbar.Separator, Toolbar.Spacer, Toolbar.TextItem) where the 'el' property is set to
            //the DOM element itself. Therefore retruning 'el' if 'el' is not Ext's Element. See details in issue 39.
             return el.dom || el ;
        }
    }-*/;

    /**
     * Sets the value of the date field.
     *
     * @param date the date value
     */
    public void setValue(Date date) {
        long time = date.getTime();
        setTime(getOrCreateJsObj(), time);
    }

    private native void setTime(JavaScriptObject df, double time)/*-{
        df.setValue(new $wnd.Date(time));
    }-*/;

    private native double getTime(JavaScriptObject df)/*-{
        //ext 1.1rc1 returns empty string.
        var val = df.getValue();
        return (val == '' || val == null || val === undefined)? -1 : df.getValue().getTime();
    }-*/;

    //-- config properties ---

    public String getXType() {
        return "datefieldex";
    }

    public void setAltFormats(String altFormats) {
        setAttribute("altFormats", altFormats, true, true);
    }

    public void setDisabledDates(String[] disabledDates) {
        setAttribute("disabledDates", disabledDates, true, true);
    }

    public void setDisabledDatesText(String disabledDatesText) {
        setAttribute("disabledDatesText", disabledDatesText, true, true);
    }

    public void setDisabledDays(int[] disabledDays)  {
        setAttribute("disabledDays", disabledDays, true, true);
    }

    public void setDisabledDaysText(String disabledDaysText) {
        setAttribute("disabledDaysText", disabledDaysText, true, true);
    }

    public void setFormat(String format) {
        setAttribute("format", format, true, true);
    }

    public void setInvalidText(String invalidText) {
        setAttribute("invalidText", invalidText, true, true);
    }

    public void setMinValue(String minValue) throws IllegalArgumentException {
        setAttribute("minValue", minValue, true);
    }

    public void setMinValue(Date minValue) throws IllegalArgumentException {
        setAttribute("minValue", minValue, true);
    }

    public void setMinText(String minText) {
        setAttribute("minText", minText, true, true);
    }

    public void setMaxValue(String maxValue) throws IllegalArgumentException {
        setAttribute("maxValue", maxValue, true);
    }

    public void setMaxValue(Date maxValue) throws IllegalArgumentException {
        setAttribute("maxValue", maxValue, true);
    }

    public void setMaxText(String maxText) {
        setAttribute("maxText", maxText, true, true);
    }
}
