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

import com.gwtext.client.core.Template;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.form.event.ComboBoxListener;

public class ComboBoxConfig extends TriggerFieldConfig {

    private ComboBoxListener comboBoxListener;

    public void setAllQuery(String allQuery) {
        JavaScriptObjectHelper.setAttribute(jsObj, "allQuery", allQuery);
    }

    public void setDisplayField(String displayField) {
        JavaScriptObjectHelper.setAttribute(jsObj, "displayField", displayField);
    }

    public void setEditable(boolean editable) {
        JavaScriptObjectHelper.setAttribute(jsObj, "editable", editable);
    }

    public void setForceSelection(boolean forceSelection) {
        JavaScriptObjectHelper.setAttribute(jsObj, "forceSelection", forceSelection);
    }

    public void setHandleHeight(int handleHeight) {
        JavaScriptObjectHelper.setAttribute(jsObj, "handleHeight", handleHeight);
    }

    public void setHiddenName(String hiddenName) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hiddenName", hiddenName);
    }

    public void setLazyRender(boolean lazyRender) {
        JavaScriptObjectHelper.setAttribute(jsObj, "lazyRender", lazyRender);
    }

    //TODO enum
    public void setListAlign(String listAlign) {
        JavaScriptObjectHelper.setAttribute(jsObj, "listAlign", listAlign);
    }

    public void setListClass(String listClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "listClass", listClass);
    }

    public void setListWidth(int listWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "listWidth", listWidth);
    }

    public void setLoadingText(String loadingText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "loadingText", loadingText);
    }

    public void setMaxHeight(int maxHeight) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxHeight", maxHeight);
    }

    public void setMinChars(int minChars) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minChars", minChars);
    }

    public void setMinListWidth(int minListWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minListWidth", minListWidth);
    }

    public void setMode(String mode) {
        JavaScriptObjectHelper.setAttribute(jsObj, "mode", mode);
    }

    public void setPageSize(int pageSize) {
        JavaScriptObjectHelper.setAttribute(jsObj, "pageSize", pageSize);
    }

    public void setQueryDelay(int queryDelay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "queryDelay", queryDelay);
    }

    public void setQueryParam(String queryParam) {
        JavaScriptObjectHelper.setAttribute(jsObj, "queryParam", queryParam);
    }

    public void setResizable(boolean resizable) {
        JavaScriptObjectHelper.setAttribute(jsObj, "resizable", resizable);
    }


    public void setSelectedClass(String selectedClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "selectedClass", selectedClass);
    }

    public void setShadow(boolean shadow) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shadow", shadow);
    }

    public void setShadow(String shadow) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shadow", shadow);
    }

    //todo not doced by ext
    public void setStore(Store store) {
        JavaScriptObjectHelper.setAttribute(jsObj, "store", store.getJsObj());
    }

    //todo not doced by ext
    public void setTpl(Template template) {
        JavaScriptObjectHelper.setAttribute(jsObj, "tpl", template.getJsObj());
    }

    public void setTransform(String transform) {
        JavaScriptObjectHelper.setAttribute(jsObj, "transform", transform);
    }

    public void setTriggerAction(String triggerAction) {
        JavaScriptObjectHelper.setAttribute(jsObj, "triggerAction", triggerAction);
    }       

    public void setTypeAhead(boolean typeAhead) {
        JavaScriptObjectHelper.setAttribute(jsObj, "typeAhead", typeAhead);
    }

    public void setTypeAheadDelay(int typeAheadDelay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "typeAheadDelay", typeAheadDelay);
    }

    public void setValueField(String valueField) {
        JavaScriptObjectHelper.setAttribute(jsObj, "valueField", valueField);
    }

    public void setValueNotFoundText(String valueNotFoundText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "valueNotFoundText", valueNotFoundText);
    }

    public ComboBoxListener getComboBoxListener() {
        return comboBoxListener;
    }

    public void setComboBoxListener(ComboBoxListener comboBoxListener) {
        this.comboBoxListener = comboBoxListener;
    }
}
