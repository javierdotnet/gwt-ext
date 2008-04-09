/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.gwtext.client.core.Function;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.event.DatePickerListener;

import java.util.Date;

/**
 * Simple date picker class.
 */
public class DatePicker extends Component {

    private static JavaScriptObject configPrototype;
    private Date initDate;

    static {
        init();
    }

    private static native void init()/*-{
        var c = new $wnd.Ext.DatePicker();
        @com.gwtext.client.widgets.DatePicker::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "datepicker";
    }

    /**
     * Create a new DatePicker.
     */
    public DatePicker() {
    }

    public DatePicker(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.DatePicker(config);    
    }-*/;

    private static DatePicker instance(JavaScriptObject jsObj) {
        return new DatePicker(jsObj);
    }

    /**
     * Get the value of the date picker.
     *
     * @return null if no value selected
     */
    public Date getValue() {
        if(!isRendered()) {
            return initDate;
        } else {
            double time = getValueMillis(getOrCreateJsObj());
            return time == -1 ? null : new Date((long)time);
        }
    }

    private native double getValueMillis(JavaScriptObject dp)/*-{
        var date = dp.getValue();
        return (date == '' || date == null) ? -1 : date.getTime();
    }-*/;

    /**
     * Set the value of the date picker.
     *
     * @param date the date
     */
    public void setValue(final Date date) {
        if(!isRendered()) {
            initDate = date;
            addListener("render", new Function() {
                public void execute() {
                    setValue(date);
                }
            });
        } else {
			DeferredCommand.addCommand(new Command() {
				public void execute() {
					setValueMillis(getOrCreateJsObj(), date.getTime());
				}
			});
		}        
    }

    private native void setValueMillis(JavaScriptObject dp, double time) /*-{
        var date = new $wnd.Date(time);
        dp.setValue(date);
    }-*/;

    /**
     * Add a Date Picker Listener.
     *
     * @param listener the listener
     */
    public native void addListener(DatePickerListener listener) /*-{
        this.@com.gwtext.client.widgets.Component::addListener(Lcom/gwtext/client/widgets/event/ComponentListener;)(listener);    
        var componentJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('select',
                function(datePicker, date) {
                    var d = @com.gwtext.client.util.DateUtil::create(D)(date.getTime());
                    listener.@com.gwtext.client.widgets.event.DatePickerListener::onSelect(Lcom/gwtext/client/widgets/DatePicker;Ljava/util/Date;)(componentJ, d);
                }
        );
    }-*/;

    // --- config properties ---

    //TODO this property is noed being used in Ext 2.0 final
    //http://extjs.com/forum/showthread.php?t=23365
    /**
     * True to constrain the date picker to the viewport (defaults to true).
     *
     * @param constrainToViewport true to constrain to view port
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setConstrainToViewport(boolean constrainToViewport) throws IllegalStateException {
        setAttribute("constrainToViewport", constrainToViewport, true);
    }

    /**
     * @return true if constrin to viewport
     */
    public boolean getConstrainToViewport() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "constrainToViewport");
    }

    /**
     * Regular expression used to disable a pattern of dates.
     *
     * @param disabledDatesRE regular expression to disable dates
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setDisabledDatesRE(String disabledDatesRE) throws IllegalStateException {
        check();
        doSetDisabledDatesRE(config, disabledDatesRE);
    }

    private native void doSetDisabledDatesRE(JavaScriptObject config, String disabledDatesRE) /*-{
        config['disabledDatesRE'] = new RegExp(disabledDatesRE);
    }-*/;

    /**
     * The tooltip text to display when the date falls on a disabled date (defaults to "").
     *
     * @param disabledDatesText disabled dates text
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setDisabledDatesText(String disabledDatesText) throws IllegalStateException {
        setAttribute("disabledDatesText", disabledDatesText, true);
    }

    /**
     * The tooltip text to display when the date falls on a disabled date (defaults to "").
     *
     * @return the disabled dates text
     */
    public String getDisabledDatesText() {
        return JavaScriptObjectHelper.getAttribute(config, "disabledDatesText");
    }

    /**
     * An array of days to disable, 0-based. For example, [0, 6] disables Sunday and Saturday.
     *
     * @param disabledDays dates to disable
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setDisabledDays(String[] disabledDays) throws IllegalStateException {
        setAttribute("disabledDays", JavaScriptObjectHelper.convertToJavaScriptArray(disabledDays), true);
    }

    /**
     * An array of days to disable, 0-based. For example, [0, 6] disables Sunday and Saturday.
     *
     * @return the disabled days
     */
    public String[] getDisabledDays() {
        return JavaScriptObjectHelper.getAttributeAsStringArray(config, "disabledDays");
    }
    /**
     * The tooltip to display when the date falls on a disabled day (defaults to "")
     *
     * @param disabledDaysText disabled days text
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setDisabledDaysText(String disabledDaysText) throws IllegalStateException {
        setAttribute("disabledDaysText", disabledDaysText, true);
    }

    /**
     * The tooltip to display when the date falls on a disabled day (defaults to "").
     *
     * @return the disabled days text
     */
    public String getDisabledDaysText() {
        return JavaScriptObjectHelper.getAttribute(config, "disabledDaysText");
    }

    /**
     * The default date format string which can be overriden for localization support. The format must be a valid pattern (defaults to 'm/d/y').
     *
     * @param format the date format
     * @see com.gwtext.client.util.DateUtil
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setFormat(String format) throws IllegalStateException {
        setAttribute("format", format, true);
    }

    /**
     * The default date format string which can be overriden for localization support. The format must be a valid pattern (defaults to 'm/d/y').
     *
     * @return the date format
     */
    public String getFormat() {
        return JavaScriptObjectHelper.getAttribute(config, "format");
    }

    /**
     * Maximum allowable date.
     *
     * @param maxDate the max date
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMaxDate(Date maxDate) throws IllegalStateException {
        setAttribute("maxDate", maxDate, true);
    }

    /**
     * Maximum allowable date.
     *
     * @return the max date
     */
    public Date getMaxDate() {
        return JavaScriptObjectHelper.getAttributeAsDate(config, "maxDate");
    }
    /**
     * The error text to display if the maxDate validation fails (defaults to "This date is after the maximum date").
     *
     * @param maxText the max error text
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMaxText(String maxText) throws IllegalStateException {
        setAttribute("maxText", maxText, true);
    }

    /**
     * The error text to display if the maxDate validation fails (defaults to "This date is after the maximum date").
     *
     * @return the error text to display if the maxDate validation fails
     */
    public String getMaxText() {
        return JavaScriptObjectHelper.getAttribute(config, "maxText");
    }

    /**
     * Minimum allowable date.
     *
     * @param minDate the min date
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMinDate(Date minDate) throws IllegalStateException {
        setAttribute("minDate", minDate, true);
    }

    /**
     * Minimum allowable date.
     *
     * @return the min date
     */
    public Date getMinDate() {
        return JavaScriptObjectHelper.getAttributeAsDate(config, "minDate");
    }

    /**
     * The error text to display if the minDate validation fails (defaults to "This date is before the minimum date").
     *
     * @param minText the min error text
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMinText(String minText) throws IllegalStateException {
        setAttribute("minText", minText, true);
    }

    /**
     * The error text to display if the minDate validation fails (defaults to "This date is before the minimum date").
     *
     * @return the error text to display if the minDate validation fails
     */
    public String getMinText() {
        return JavaScriptObjectHelper.getAttribute(config, "minText");
    }

    /**
     * An array of textual month names which can be overriden for localization support.
     *
     * @param monthNames the month names
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMonthNames(String[] monthNames) throws IllegalStateException {
        setAttribute("monthNames", JavaScriptObjectHelper.arrayConvert(monthNames), true);
    }

    /**
     * An array of textual month names which can be overriden for localization support.
     *
     * @return the month names
     */
    public String[] getMonthNames() {
        return JavaScriptObjectHelper.getAttributeAsStringArray(config, "monthNames");
    }

    /**
     * The header month selector tooltip (defaults to 'Choose a month (Control+Up/Down to move years)').
     *
     * @param monthYearText the header month tooltip text
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMonthYearText(String monthYearText) throws IllegalStateException {
        setAttribute("monthYearText", monthYearText, true);
    }

    /**
     * The header month selector tooltip (defaults to 'Choose a month (Control+Up/Down to move years)').
     *
     * @return the header month selector tooltip text
     */
    public String getMonthYearText() {
        return JavaScriptObjectHelper.getAttribute(config, "monthYearText");
    }

    /**
     * The next month navigation button tooltip (defaults to 'Next Month (Control+Right)').
     *
     * @param nextText the next button tooltip text
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setNextText(String nextText) throws IllegalStateException {
        setAttribute("nextText", nextText, true);
    }

    /**
     * The next month navigation button tooltip (defaults to 'Next Month (Control+Right)').
     *
     * @return the next month navigation button tooltip
     */
    public String getNextText() {
        return JavaScriptObjectHelper.getAttribute(config, "nextText");
    }

    /**
     * The text to display on the ok button.
     *
     * @param okText the OK text
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setOkText(String okText) throws IllegalStateException {
        setAttribute("okText", okText, true);
    }

    /**
     * The text to display on the ok button.
     *
     * @return the text for the ok button
     */
    public String getOkText() {
        return JavaScriptObjectHelper.getAttribute(config, "okText");
    }

    /**
     * The previous month navigation button tooltip (defaults to 'Previous Month (Control+Left)').
     *
     * @param prevText the previous month tooltip text
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setPrevText(String prevText) throws IllegalStateException {
        setAttribute("prevText", prevText, true);
    }

    /**
     * The previous month navigation button tooltip (defaults to 'Previous Month (Control+Left)').
     *
     * @return the previous month navigation button tooltip
     */
    public String getPrevText() {
        return JavaScriptObjectHelper.getAttribute(config, "prevText");
    }

    /**
     * Day index at which the week should begin, 0-based (defaults to 0, which is Sunday).
     *
     * @param startDay the start day
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setStartDay(int startDay) throws IllegalStateException {
        setAttribute("startDay", startDay, true);
    }

    /**
     * Day index at which the week should begin, 0-based (defaults to 0, which is Sunday).
     *
     * @return the day index at which the week should begin, 0-based
     */
    public int getStartDay() {
        return JavaScriptObjectHelper.getAttributeAsInt(config, "startDay");
    }

    /**
     * The text to display on the button that selects the current date (defaults to "Today").
     *
     * @param todayText the today text
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTodayText(String todayText) throws IllegalStateException {
        setAttribute("todayText", todayText, true);
    }

    /**
     * The text to display on the button that selects the current date (defaults to "Today").
     *
     * @return  the text to display on the button that selects the current date
     */
    public String getTodayText() {
        return getAttribute("todayText");
    }

    /**
     * The tooltip to display for the button that selects the current date (defaults to "{current date} (Spacebar)").
     *
     * @param todayTip the tooltip for current date
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTodayTip(String todayTip) throws IllegalStateException {
        //todo can handle internally
        setAttribute("todayTip", todayTip, true);
    }

    /**
     * The tooltip to display for the button that selects the current date (defaults to "{current date} (Spacebar)").
     *
     * @return the tooltip to display for the button that selects the current date
     */
    public String getTodayTip() {
        return getAttribute("todayTip");
    }
}
