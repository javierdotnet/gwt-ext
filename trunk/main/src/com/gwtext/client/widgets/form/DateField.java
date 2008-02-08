/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.util.JavaScriptObjectHelper;

import java.util.Date;

/**
 * Provides a date input field with {@link com.gwtext.client.widgets.DatePicker} dropdown and automatic date validation.
 */
public class DateField extends TextField {

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
        return new $wnd.Ext.form.DateField(jsObj);
    }-*/;

    /**
     * Returns the current date value of the date field.
     *
     * @return the date value
     */
    public Date getValue() {
        long date = getTime(getOrCreateJsObj());
        return date == -1 ? null : new Date(date);
    }


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

    private native void setTime(JavaScriptObject df, long time)/*-{
        df.setValue(new $wnd.Date(time));
    }-*/;

    private native long getTime(JavaScriptObject df)/*-{
        //ext 1.1rc1 returns empty string.
        var val = df.getValue();
        return (val == '' || val == null || val === undefined)? -1 : df.getValue().getTime();
    }-*/;

    //-- config properties ---

    public String getXType() {
        return "datefield";
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
