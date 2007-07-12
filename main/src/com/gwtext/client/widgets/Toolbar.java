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

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.form.Field;

public class Toolbar extends RequiredElementWidget {

    protected Toolbar() {
    }

    public Toolbar(String id) {
        super(id);
    }

    public Toolbar(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(String id, JavaScriptObject config) /*-{
        return new $wnd.Ext.Toolbar(id);
    }-*/;


    public void addButton(ToolbarButton button) {
        addButton(jsObj, button.getJsObj());
        button.registerEventHandlers();
        button.setRendered(true);
    }

    public void addButton(ToolbarMenuButton button) {
        addButton(jsObj, button.getJsObj());
        button.registerEventHandlers();
        button.setRendered(true);
    }

    private native void addButton(JavaScriptObject toolbar, JavaScriptObject button) /*-{
        toolbar.addButton(button);
    }-*/;

    public native void addElement(String html) /*-{
        var toolbar = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        toolbar.addElement(html);
    }-*/;

    public void addField(Field field) {
        addField(jsObj, field.getJsObj());
    }

    private static native void addField(JavaScriptObject toolbar, JavaScriptObject field)/*-{
        toolbar.addField(field);
    }-*/;

    public native void addFill() /*-{
        var toolbar = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        toolbar.addFill();
    }-*/;

    public native void addItem(ToolbarItem item) /*-{
        var toolbar = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var itemJS = item.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        toolbar.addItem(itemJS);
    }-*/;

    public native void addSeparator() /*-{
        var toolbar = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        toolbar.addSeparator();
    }-*/;

    public native void addSpacer() /*-{
        var toolbar = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        toolbar.addSpacer();
    }-*/;

    public native void addText(String text) /*-{
        var toolbar = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        toolbar.addText(text);
    }-*/;

    public void insertButton(int index, ToolbarItem item) {
        insertButton(jsObj, index, item.getJsObj());
    }

    private native void insertButton(JavaScriptObject toolbar, int index, JavaScriptObject item) /*-{
        toolbar.insertButton(index, item);
    }-*/;

    public void insertButton(int index, ToolbarButton button) {
        insertButton(jsObj, index, button.getJsObj());
    }
}
