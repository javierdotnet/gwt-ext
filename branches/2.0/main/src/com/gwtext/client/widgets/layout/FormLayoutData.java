/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 *
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.layout;

import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Supporting class for {@link FormLayout}. Any type of components can be added to a FormLayout, but items that inherit from {@link com.gwtext.client.widgets.form.Field}
 *  can also supply the following field-specific config properties.
 *
 * @see com.gwtext.client.widgets.layout.FormLayout
 */
public class FormLayoutData extends LayoutData {

    /**
     * The CSS class to apply to the special clearing div rendered directly after each form field wrapper (defaults to 'x-form-clear-left')
     *
     * @param clearCls the CSS class to apply to the special clearing div rendered directly after each form field wrapper (defaults to 'x-form-clear-left')
     */
    public void setClearCls(String clearCls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "clearCls", clearCls);
    }

    /**
     * The text to display as the label for this field (defaults to '')
     *
     * @param fieldLabel the text to display as the label for this field (defaults to '')
     */
    public void setFieldLabel(String fieldLabel) {
        JavaScriptObjectHelper.setAttribute(jsObj, "fieldLabel", fieldLabel);
    }

    /**
     * True to hide the label and separator for this field (defaults to false).
     *
     * @param hideLabel true to hide the label and separator for this field (defaults to false).
     */
    public void setHideLabel(boolean hideLabel) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hideLabel", hideLabel);
    }

    /**
     * A CSS class to add to the div wrapper that contains this field label and field element
     * (the default class is 'x-form-item' and itemCls will be added to that). If supplied, itemCls at the field level
     * will override the default itemCls supplied at the container level.
     *
     * @param itemCls the item CSS class
     */
    public void setItemCls(String itemCls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "itemCls", itemCls);
    }

    /**
     * The separator to display after the text of the label for this field (defaults to a colon ':' or the layout's value for labelSeparator).
     * To hide the separator use empty string ''.
     *
     * @param labelSeparator the label separator
     */
    public void setLabelSeparator(String labelSeparator) {
        JavaScriptObjectHelper.setAttribute(jsObj, "labelSeparator", labelSeparator);
    }

    /**
     * A CSS style specification string to add to the field label for this field (defaults to '' or the layout's value for labelStyle).
     *
     * @param labelStyle the label CSS style
     */
    public void setLabelStyle(String labelStyle) {
        JavaScriptObjectHelper.setAttribute(jsObj, "labelStyle", labelStyle);
    }



    
    
}