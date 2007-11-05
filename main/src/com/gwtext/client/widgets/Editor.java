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
import com.google.gwt.user.client.Element;
import com.gwtext.client.widgets.event.EditorListener;
import com.gwtext.client.widgets.form.Field;

import java.util.Date;

/**
 * A base editor field that handles displaying/hiding on demand and has some built-in sizing and event handling logic.
 */
public class Editor extends Component {

    protected Editor() {
    }

    /**
     * Create a new Editor.
     *
     * @param field the editor field
     */
    public Editor(Field field) {
        this(field, null);
    }

    /**
     * Create a new Editor.
     *
     * @param field the editor field
     * @param config the editor config
     */
    public Editor(Field field, EditorConfig config) {
        jsObj = create(field.getJsObj(), config == null ? null : config.getJsObj());
    }

    private native JavaScriptObject create(JavaScriptObject field, JavaScriptObject config) /*-{
        return new $wnd.Ext.Editor(field, config);
    }-*/;

    /**
     * Cancels the editing process and hides the editor without persisting any changes. The field value will be reverted to the original starting value.
     *
     * @param remainVisible override the default behavior and keep the editor visible after cancel (defaults to false)
     */
    public native void cancelEdit(boolean remainVisible) /*-{
        var editor = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        editor.cancelEdit();
    }-*/;

    /**
     * Ends the editing process, persists the changed value to the underlying field, and hides the editor.
     *
     * @param remainVisible Override the default behavior and keep the editor visible after edit (defaults to false)
     */
    public native void completeEdit(boolean remainVisible) /*-{
        var editor = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        editor.completeEdit(true);
    }-*/;

    /**
     * Gets the data value of the editor.
     *
     * @return the value as String
     */
    public native String getValueAsString() /*-{
        var editor = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var val = editor.getValue();
        return val == null ? null : val.toString();
    }-*/;

    /**
     * Gets the data value of the editor.
     *
     * @return the editor value
     */
    public native Object getValue()/*-{
        var editor = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var val = editor.getValue();
        var valJ = (val  == null || val === undefined || val === '') ? null : $wnd.GwtExt.convertToJavaType(val);
        return valJ;
    }-*/;

    /**
     * Realigns the editor to the bound field based on the current alignment config value.
     */
    public native void realign() /*-{
        var editor = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        editor.realign();
    }-*/;

    /**
     * Sets the height and width of this editor.
     * 
     * @param width the new width
     * @param height the new height
     */
    public native void setSize(int width, int height) /*-{
        var editor = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        editor.setSize(width, height);
    }-*/;

    /**
     * Sets the data value of the editor.
     *
     * @param value the value
     */
    public native void setValue(String value) /*-{
        var editor = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        editor.setValue(value);
    }-*/;

    /**
     * Sets the data value of the editor.
     *
     * @param value the value
     */
    public native void setValue(boolean value) /*-{
        var editor = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        editor.setValue(value);
    }-*/;

    /**
     * Sets the data value of the editor.
     *
     * @param value the value
     */
    public native void setValue(double value) /*-{
        var editor = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        editor.setValue(value);
    }-*/;

    /**
     * Sets the data value of the editor.
     *
     * @param value the value
     */
    public native void setValue(long value) /*-{
        var editor = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        editor.setValue(value);
    }-*/;

    /**
     * Sets the data value of the editor.
     *
     * @param value the value
     */
    public native void setValue(Date value)/*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(value);
        var dateJS = new $wnd.Date(millis);
        var editor = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        editor.setValue(dateJS);
    }-*/;

    /**
     * Starts the editing process and shows the editor.
     *
     * @param id the element ID to edit
     */
    public native void startEdit(String id) /*-{
        var editor = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        editor.startEdit(id);
    }-*/;

    /**
     * Starts the editing process and shows the editor.
     *
     * @param id the element ID to edit
     * @param value A value to initialize the editor with. If a value is not provided, it defaults to the innerHTML of the element.
     */
    public native void startEdit(String id, String value) /*-{
        var editor = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        editor.startEdit(id, value);
    }-*/;

    /**
     * Starts the editing process and shows the editor.
     *
     * @param el  the element to edit
     */
    public native void startEdit(Element el) /*-{
        var editor = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        editor.startEdit(el);
    }-*/;

    /**
     * Starts the editing process and shows the editor.
     *
     * @param el  the element to edit
     * @param value A value to initialize the editor with. If a value is not provided, it defaults to the innerHTML of the element.
     */
    public native void startEdit(Element el, String value) /*-{
        var editor = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        editor.startEdit(el, value);
    }-*/;

    /**
     * Add an Editor listener.
     *
     * @param listener the listener
     */
    public native void addEditorListener(EditorListener listener) /*-{
        var editor = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var editorJ = this;

        editor.addListener('beforecomplete',
                function(source, value, startValue) {
                    var valueJ = (value  == null || value === undefined || value === '') ? null : $wnd.GwtExt.convertToJavaType(value);
                    var startValueJ = (startValue  == null || startValue === undefined || startValue === '') ? null : $wnd.GwtExt.convertToJavaType(startValue);
                    return listener.@com.gwtext.client.widgets.event.EditorListener::doBeforeComplete(Lcom/gwtext/client/widgets/Editor;Ljava/lang/Object;Ljava/lang/Object;)(editorJ, valueJ, startValueJ);
                }
        );

        editor.addListener('beforestartedit',
                function(source, boundEl, value) {
                    var boundElJ = @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(boundEl);
                    var valueJ = (value  == null || value === undefined || value === '') ? null : $wnd.GwtExt.convertToJavaType(value);
                    return listener.@com.gwtext.client.widgets.event.EditorListener::doBeforeStartEdit(Lcom/gwtext/client/widgets/Editor;Lcom/gwtext/client/core/ExtElement;Ljava/lang/Object;)(editorJ, boundElJ, valueJ);
                }
        );

        editor.addListener('complete',
                function(source, value, startValue) {
                    var valueJ = (value  == null || value === undefined || value === '') ? null : $wnd.GwtExt.convertToJavaType(value);
                    var startValueJ = (startValue  == null || startValue === undefined || startValue === '') ? null : $wnd.GwtExt.convertToJavaType(startValue);
                    listener.@com.gwtext.client.widgets.event.EditorListener::onComplete(Lcom/gwtext/client/widgets/Editor;Ljava/lang/Object;Ljava/lang/Object;)(editorJ, valueJ, startValueJ);
                }
        );

        editor.addListener('specialkey',
                function(source, field, e) {
                    var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
                    var fieldJ = field.obj;
                    listener.@com.gwtext.client.widgets.event.EditorListener::onSpeciakKey(Lcom/gwtext/client/widgets/form/Field;Lcom/gwtext/client/core/EventObject;)(editorJ, fieldJ, eJ);
                }
        );
    }-*/;
}