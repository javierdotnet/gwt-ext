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
import com.gwtext.client.core.AnchorPosition;
import com.gwtext.client.core.Template;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.form.event.ComboBoxListener;

/**
 * Configuration class for {@link ComboBox}.
 */
public class ComboBoxConfig extends TriggerFieldConfig {

    private ComboBoxListener comboBoxListener;
    private String displayField;

    /**
     * The text query to send to the server to return all records for the list with no
     * filtering (defaults to '')
     *
     * @param allQuery the all query string
     */
    public void setAllQuery(String allQuery) {
        JavaScriptObjectHelper.setAttribute(jsObj, "allQuery", allQuery);
    }

    /**
     * The underlying data field name to bind to this ComboBox (defaults to undefined if mode = 'remote' or 'text' if mode = 'local').
     * 
     * @param displayField the display field
     */
    public void setDisplayField(String displayField) {
        JavaScriptObjectHelper.setAttribute(jsObj, "displayField", displayField);
        JavaScriptObject store = JavaScriptObjectHelper.getAttributeAsJavaScriptObject(jsObj, "store");
        if(store != null) {
            setFilterColParam(store, displayField);
        } else {
            this.displayField = displayField;
        }
    }

    private native void setFilterColParam(JavaScriptObject store, String displayField) /*-{
        store.baseParams['filterCol'] = displayField;
    }-*/;

    /**
     * False to prevent the user from typing text directly into the field, just like a traditional select (defaults to true).
     *
     * @param editable false to disable editing
     */
    public void setEditable(boolean editable) {
        JavaScriptObjectHelper.setAttribute(jsObj, "editable", editable);
    }

    /**
     * True to restrict the selected value to one of the values in the list, false to allow the user to set arbitrary text
     *  into the field (defaults to false)
     *
     * @param forceSelection true to force selection
     */
    public void setForceSelection(boolean forceSelection) {
        JavaScriptObjectHelper.setAttribute(jsObj, "forceSelection", forceSelection);
    }

    /**
     * The height in pixels of the dropdown list resize handle if resizable = true (defaults to 8)
     *
     * @param handleHeight the handle height
     */
    public void setHandleHeight(int handleHeight) {
        JavaScriptObjectHelper.setAttribute(jsObj, "handleHeight", handleHeight);
    }

    /**
     * If specified, a hidden form field with this name is dynamically generated to store the field's data value
     *  (defaults to the underlying DOM element's name)
     *
     * @param hiddenName the hidden name
     */
    public void setHiddenName(String hiddenName) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hiddenName", hiddenName);
    }

    /**
     * True to prevent the ComboBox from rendering until requested
     * (should always be used when rendering into an Editor, defaults to false).
     *
     * @param lazyRender true to lazy render
     */
    public void setLazyRender(boolean lazyRender) {
        JavaScriptObjectHelper.setAttribute(jsObj, "lazyRender", lazyRender);
    }

    /**
     * A valid anchor position value.
     *
     * @param anchor defaults to {@link com.gwtext.client.core.AnchorPosition#TOP_LEFT_CORNER}
     * @param targetAnchor defaults to {@link com.gwtext.client.core.AnchorPosition#BOTTOM_LEFT}
     */
    public void setListAlign(AnchorPosition anchor, AnchorPosition targetAnchor) {
        JavaScriptObjectHelper.setAttribute(jsObj, "listAlign", anchor.getPosition() + "-" + targetAnchor.getPosition());
    }

    /**
     * CSS class to apply to the dropdown list element (defaults to '').
     *
     * @param listClass list css class
     */
    public void setListClass(String listClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "listClass", listClass);
    }

    /**
     * The width in pixels of the dropdown list (defaults to the width of the ComboBox field)
     *
     * @param listWidth the list width
     */
    public void setListWidth(int listWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "listWidth", listWidth);
    }

    /**
     * The text to display in the dropdown list while data is loading. Only applies when mode = 'remote'
     * (defaults to 'Loading...')
     *
     * @param loadingText the loading text
     */
    public void setLoadingText(String loadingText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "loadingText", loadingText);
    }

    /**
     * The maximum height in pixels of the dropdown list before scrollbars are shown (defaults to 300).
     * 
     * @param maxHeight the max height
     */
    public void setMaxHeight(int maxHeight) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxHeight", maxHeight);
    }

    /**
     * The minimum number of characters the user must type before autocomplete and typeahead activate
     * (defaults to 4, does not apply if editable = false)
     * 
     * @param minChars the min chars before autocomplete
     */
    public void setMinChars(int minChars) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minChars", minChars);
    }

    /**
     * The minimum width of the dropdown list in pixels (defaults to 70, will be
     * ignored if listWidth has a higher value).
     *
     * @param minListWidth the min list width
     */
    public void setMinListWidth(int minListWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minListWidth", minListWidth);
    }

    /**
     * Set to {@link com.gwtext.client.widgets.form.ComboBox#LOCAL} if the ComboBox loads local data.
     * (defaults to {@link com.gwtext.client.widgets.form.ComboBox#REMOTE} which loads from the server)
     *
     * @param mode local or remote mode
     */
    public void setMode(ComboBox.Mode mode) {
        JavaScriptObjectHelper.setAttribute(jsObj, "mode", mode.getMode());
    }

    /**
     * Set to 'local' if the ComboBox loads local data (defaults to 'remote' which loads from the server)
     *
     * @param mode local or remote mode
     * @deprecated use {@link #setMode(com.gwtext.client.widgets.form.ComboBox.Mode)}
     */
    public void setMode(String mode) {
        JavaScriptObjectHelper.setAttribute(jsObj, "mode", mode);
    }

    /**
     * If greater than 0, a paging toolbar is displayed in the footer of the dropdown list and the filter queries will
     * execute with page start and limit parameters. Only applies when mode = 'remote' (defaults to 0).
     * 
     * @param pageSize the page size
     * @see #setMode(com.gwtext.client.widgets.form.ComboBox.Mode)
     */
    public void setPageSize(int pageSize) {
        JavaScriptObjectHelper.setAttribute(jsObj, "pageSize", pageSize);
    }

    /**
     * The length of time in milliseconds to delay between the start of typing and sending the query to filter the
     * dropdown list (defaults to 500 if mode = 'remote' or 10 if mode = 'local')
     * 
     * @param queryDelay query delay in milliseconds
     * @see #setMode(com.gwtext.client.widgets.form.ComboBox.Mode)
     */
    public void setQueryDelay(int queryDelay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "queryDelay", queryDelay);
    }

    /**
     * Name of the query as it will be passed on the querystring (defaults to 'query')
     * 
     * @param queryParam the query param
     */
    public void setQueryParam(String queryParam) {
        JavaScriptObjectHelper.setAttribute(jsObj, "queryParam", queryParam);
    }

    /**
     * True to add a resize handle to the bottom of the dropdown list (defaults to false).
     * 
     * @param resizable true for resizale
     */
    public void setResizable(boolean resizable) {
        JavaScriptObjectHelper.setAttribute(jsObj, "resizable", resizable);
    }

    /**
     * CSS class to apply to the selected item in the dropdown list (defaults to 'x-combo-selected')
     * 
     * @param selectedClass the selected css class
     */
    public void setSelectedClass(String selectedClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "selectedClass", selectedClass);
    }

    /**
     * True for default effect
     *
     * @param shadow true to enable shadow
     */
    public void setShadow(boolean shadow) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shadow", shadow);
    }

    //todo enum
    /**
     * "sides" for the default effect, "frame" for 4-way shadow, and "drop" for bottom-right.
     *
     * @param shadow shadow style
     */
    public void setShadow(String shadow) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shadow", shadow);
    }

    /**
     * The data store to which this combo is bound (defaults to undefined)
     *
     * @param store the combobox store
     */
    public void setStore(Store store) {
        JavaScriptObjectHelper.setAttribute(jsObj, "store", store.getJsObj());
        if(displayField != null) {
            setFilterColParam(store.getJsObj(), displayField);
        }
    }

    /**
     * If supplied, a header element is created containing this text and added into the top of the dropdown list
     * (defaults to undefined, with no header element).
     *
     * @param title the combobox title
     */
    public void setTitle(String title) {
        JavaScriptObjectHelper.setAttribute(jsObj, "title", title);
    }

    //todo not doced by ext
    /**
     * Set the template to use to render the ComboBox items. Used to customize dispaly of ComboBox items.
     * <br/><br/>
     * For example the template below uses the fields 'url' and 'text' from the Store's RecordDef.
     * <br/><br/>
     * setTpl(new Template("&lt;div class=\"x-combo-list-item\">" +
     *                   "&lt;em>{url}&lt;/em>&lt;strong>{text}&lt;/strong>" +
     *                   "&lt;div class=\"x-clear\">&lt;/div>&lt;/div>"));
     *
     * @param template template to use for rendering items.
     * @see Store
     * @see com.gwtext.client.data.RecordDef
     */
    public void setTpl(Template template) {
        JavaScriptObjectHelper.setAttribute(jsObj, "tpl", template.getJsObj());
    }

    /**
     * The id of an existing select to convert to a ComboBox
     *
     * @param id element id
     */
    public void setTransform(String id) {
        JavaScriptObjectHelper.setAttribute(jsObj, "transform", id);
    }

    /**
     * The action to execute when the trigger field is activated. Use 'all' to run the query specified by the allQuery
     * config option (defaults to 'query').
     *
     * @param triggerAction the trigger action
     */
    public void setTriggerAction(ComboBox.Trigger triggerAction) {
        JavaScriptObjectHelper.setAttribute(jsObj, "triggerAction", triggerAction.getTrigger());
    }

    /**
     * The action to execute when the trigger field is activated. Use 'all' to run the query specified by the allQuery
     * config option (defaults to 'query').
     *
     * @param triggerAction the trigger action
     * @deprecated use {@link #setTriggerAction(com.gwtext.client.widgets.form.ComboBox.Trigger)}
     */
    public void setTriggerAction(String triggerAction) {
        JavaScriptObjectHelper.setAttribute(jsObj, "triggerAction", triggerAction);
    }

    /**
     * True to populate and autoselect the remainder of the text being typed after a configurable delay (typeAheadDelay)
     * if it matches a known value (defaults to false).
     *
     * @param typeAhead enable type ahead
     */
    public void setTypeAhead(boolean typeAhead) {
        JavaScriptObjectHelper.setAttribute(jsObj, "typeAhead", typeAhead);
    }

    /**
     * The length of time in milliseconds to wait until the typeahead text is displayed if typeAhead = true (defaults to 250)
     *
     * @param typeAheadDelay typeahead delay in milliseconds
     */
    public void setTypeAheadDelay(int typeAheadDelay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "typeAheadDelay", typeAheadDelay);
    }

    /**
     * The underlying data value name to bind to this CombBox (defaults to undefined if mode = 'remote' or 'value' if mode = 'local').
     * Note: use of a valueField requires the user make a selection in order for a value to be mapped.
     *
     * @param valueField the value field
     */
    public void setValueField(String valueField) {
        JavaScriptObjectHelper.setAttribute(jsObj, "valueField", valueField);
    }

    /**
     * When using a name/value combo, if the value passed to setValue is not found in the store, valueNotFoundText
     * will be displayed as the field text if defined (defaults to undefined).
     *
     * @param valueNotFoundText text when value not found
     */
    public void setValueNotFoundText(String valueNotFoundText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "valueNotFoundText", valueNotFoundText);
    }

    public ComboBoxListener getComboBoxListener() {
        return comboBoxListener;
    }

    /**
     * Set the ComboBox listener.
     *
     * @param comboBoxListener the listener
     */
    public void setComboBoxListener(ComboBoxListener comboBoxListener) {
        this.comboBoxListener = comboBoxListener;
    }
}
