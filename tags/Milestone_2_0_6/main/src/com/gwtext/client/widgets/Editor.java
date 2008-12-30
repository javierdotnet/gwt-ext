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
 
package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.widgets.event.EditorListener;
import com.gwtext.client.widgets.form.Field;

import java.util.Date;

/**
 * A base editor field that handles displaying/hiding on demand and has some built-in sizing and event handling logic.
 *
 * @author Sanjiv Jivan
 */
public class Editor extends Component {

    private static JavaScriptObject configPrototype;
    private Field field;

    static {
        init();
    }

    private static native void init()/*-{
        var c = new $wnd.Ext.Editor();
        @com.gwtext.client.widgets.Editor::configPrototype = c.initialConfig;
    }-*/;


    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }


    public String getXType() {
        return "editor";
    }

    public Editor() {
    }

    //todo2 field must be rendered at this point
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        var field = this.@com.gwtext.client.widgets.Editor::field;
        var fieldJS = field.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var ed =  new $wnd.Ext.Editor(fieldJS, config);
		var id = ed.getId();
		this.@com.gwtext.client.widgets.Component::id = id;
		return ed;
	}-*/;

    /**
     * Create a new Editor.
     *
     * @param field the editor field
     */
    public Editor(Field field) {
        this.field = field;
    }

    public Editor(JavaScriptObject jsObj) {
        super(jsObj);
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
        var editor = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        editor.cancelEdit();
    }-*/;

    /**
     * Ends the editing process, persists the changed value to the underlying field, and hides the editor.
     *
     * @param remainVisible Override the default behavior and keep the editor visible after edit (defaults to false)
     */
    public native void completeEdit(boolean remainVisible) /*-{
        var editor = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        editor.completeEdit(true);
    }-*/;


	/**
     * Gets the data value of the editor.
     *
     * @return the value as String
     */
    public native String getValueAsString() /*-{
        var editor = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var val = editor.getValue();
        return val == null ? null : val.toString();
    }-*/;

    /**
     * Gets the data value of the editor.
     *
     * @return the editor value
     */
    public native Object getValue()/*-{
        var editor = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var val = editor.getValue();
        var valJ = (val  == null || val === undefined || val === '') ? null : $wnd.GwtExt.convertToJavaType(val);
        return valJ;
    }-*/;

    /**
     * Realigns the editor to the bound field based on the current alignment config value.
     */
    public native void realign() /*-{
        var editor = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        editor.realign();
    }-*/;

    /**
     * Sets the height and width of this editor.
     *
     * @param width  the new width
     * @param height the new height
     */
    public native void setSize(int width, int height) /*-{
        var editor = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        editor.setSize(width, height);
    }-*/;

    /**
     * Sets the data value of the editor.
     *
     * @param value the value
     */
    private native void setValueRendered(String value) /*-{
        var editor = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        editor.setValue(value);
    }-*/;

    /**
     * Sets the data value of the editor.
     *
     * @param value the value
     */
    public native void setValueRendered(boolean value) /*-{
        var editor = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        editor.setValue(value);
    }-*/;

    /**
     * Sets the data value of the editor.
     *
     * @param value the value
     */
    private native void setValueRendered(double value) /*-{
        var editor = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        editor.setValue(value);
    }-*/;

    /**
     * Sets the data value of the editor.
     *
     * @param value the value
     */
    public native void setValueRendered(Date value)/*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(value);
        var dateJS = new $wnd.Date(millis);
        var editor = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        editor.setValue(dateJS);
    }-*/;

    /**
     * Starts the editing process and shows the editor.
     *
     * @param id the element ID to edit
     */
    public native void startEdit(String id) /*-{
        var editor = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        editor.startEdit(id);
    }-*/;

    /**
     * Starts the editing process and shows the editor.
     *
     * @param id    the element ID to edit
     * @param value A value to initialize the editor with. If a value is not provided, it defaults to the innerHTML of the element.
     */
    public native void startEdit(String id, String value) /*-{
        var editor = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        editor.startEdit(id, value);
    }-*/;

    /**
     * Starts the editing process and shows the editor.
     *
     * @param el the element to edit
     */
    public native void startEdit(Element el) /*-{
		var editor = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        editor.startEdit(el);
    }-*/;

    /**
     * Starts the editing process and shows the editor.
     *
     * @param el    the element to edit
     * @param value A value to initialize the editor with. If a value is not provided, it defaults to the innerHTML of the element.
     */
    public native void startEdit(Element el, String value) /*-{
        var editor = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        editor.startEdit(el, value);
    }-*/;

    /**
     * Add an Editor listener.
     *
     * @param listener the listener
     */
    public native void addListener(EditorListener listener) /*-{
        this.@com.gwtext.client.widgets.Component::addListener(Lcom/gwtext/client/widgets/event/ComponentListener;)(listener);
        var editorJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforecomplete',
                function(source, value, startValue) {
                    var valueJ = (value  == null || value === undefined || value === '') ? null : $wnd.GwtExt.convertToJavaType(value);
                    var startValueJ = (startValue  == null || startValue === undefined || startValue === '') ? null : $wnd.GwtExt.convertToJavaType(startValue);
                    return listener.@com.gwtext.client.widgets.event.EditorListener::doBeforeComplete(Lcom/gwtext/client/widgets/Editor;Ljava/lang/Object;Ljava/lang/Object;)(editorJ, valueJ, startValueJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforestartedit',
                function(source, boundEl, value) {
                    var boundElJ = @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(boundEl);
                    var valueJ = (value  == null || value === undefined || value === '') ? null : $wnd.GwtExt.convertToJavaType(value);
                    return listener.@com.gwtext.client.widgets.event.EditorListener::doBeforeStartEdit(Lcom/gwtext/client/widgets/Editor;Lcom/gwtext/client/core/ExtElement;Ljava/lang/Object;)(editorJ, boundElJ, valueJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('complete',
                function(source, value, startValue) {
                    var valueJ = (value  == null || value === undefined || value === '') ? null : $wnd.GwtExt.convertToJavaType(value);
                    var startValueJ = (startValue  == null || startValue === undefined || startValue === '') ? null : $wnd.GwtExt.convertToJavaType(startValue);
                    listener.@com.gwtext.client.widgets.event.EditorListener::onComplete(Lcom/gwtext/client/widgets/Editor;Ljava/lang/Object;Ljava/lang/Object;)(editorJ, valueJ, startValueJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('specialkey',
                function(source, field, e) {
                    var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
                    var fieldJ = field.obj;
                    listener.@com.gwtext.client.widgets.event.EditorListener::onSpeciakKey(Lcom/gwtext/client/widgets/form/Field;Lcom/gwtext/client/core/EventObject;)(editorJ, fieldJ, eJ);
                }
        );
    }-*/;

    // --- config properties ---


    /**
     * The position to align to.
     *
     * @param anchorPosition defaults to "c-c"
     */
    public void setAlignment(String anchorPosition) {
        setAttribute( "alignment", anchorPosition, true, true);
    }

    /**
     * True for the editor to automatically adopt the size of the underlying field.
     *
     * @param autosize true to autosize
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setAutosize(boolean autosize) throws IllegalStateException {
        setAttribute("autosize", autosize, true);
    }

    /**
     * Set to "width" to adopt the width only, or "height" to adopt the height only.
     *
     * @param autosize the autosize value
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setAutosize(String autosize) throws IllegalStateException {
        setAttribute("autosize", autosize, true);
    }

    /**
     * True to cancel the edit when the escape key is pressed (defaults to false).
     *
     * @param cancelOnEsc cancel on escape
     */
    public void setCancelOnEsc(boolean cancelOnEsc) {
        setAttribute("cancelOnEsc", cancelOnEsc, true, true);
    }

    /**
     * True to complete the edit when the enter key is pressed (defaults to false).
     *
     * @param completeOnEnter true to complete on enter
     */
    public void setCompleteOnEnter(boolean completeOnEnter) {
        setAttribute("completeOnEnter", completeOnEnter, true, true);
    }

    /**
     * True to constrain the editor to the viewport.
     *
     * @param constrain true to constrain the editor to the viewport
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setConstrain(boolean constrain) throws IllegalStateException {
        setAttribute("constrain", constrain, true);
    }

    //todo2 on rendere pass field to object constructor
    public void setField(Field field) {
        this.field = field;
    }

    /**
     * False to keep the bound element visible while the editor is displayed (defaults to true).
     *
     * @param hideEl true to hide element
     */
    public void setHideEl(boolean hideEl) {
        setAttribute("hideEl", hideEl, true, true);
    }

    /**
     * True to skip the the edit completion process (no save, no events fired) if the user completes an edit and the
     * value has not changed (defaults to false). Applies only to string values - edits for other data types will never be ignored.
     *
     * @param ignoreNoChange true to ingnore no change
     */
    public void setIgnoreNoChange(boolean ignoreNoChange) {
        setAttribute("ignoreNoChange", ignoreNoChange, true, true);
    }

    /**
     * True to automatically revert the field value and cancel the edit when the user completes an edit and the field validation fails (defaults to true).
     *
     * @param revertInvalid true to rever invalid field value
     */
    public void setRevertInvalid(boolean revertInvalid) {
        setAttribute("revertInvalid", revertInvalid, true, true);
    }

    /**
     * "sides" for sides/bottom only, "frame" for 4-way shadow, and "drop" for bottom-right shadow (defaults to "frame")
     *
     * @param shadow the shadow setting
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setShadow(boolean shadow) throws IllegalStateException {
        setAttribute("shadow", shadow, true);
    }

    /**
     * "sides" for sides/bottom only, "frame" for 4-way shadow, and "drop" for bottom-right shadow (defaults to "frame")
     *
     * @param shadow the shadow setting
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setShadow(String shadow) throws IllegalStateException {
        setAttribute("shadow", shadow, true);
    }

    /**
     * Handle the keydown/keypress events so they don't propagate (defaults to true).
     *
     * @param swallowKeys true to swallow keys
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setSwallowKeys(boolean swallowKeys) throws IllegalStateException {
        setAttribute("swallowKeys", swallowKeys, true);
    }

    /**
     * True to update the innerHTML of the bound element when the update completes (defaults to false).
     *
     * @param updateEl true to update the element
     */
    public void setUpdateEl(boolean updateEl) {
        setAttribute("updateEl", updateEl, true, true);
    }

    /**
     * The data value of the underlying field (defaults to "").
     *
     * @param value the field value
     */
    public void setValue(String value) {
        if (!isRendered()) {
            setAttribute("value", value, true);
        } else {
            setValueRendered(value);
        }
    }

    /**
     * The data value of the underlying field (defaults to "").
     *
     * @param value the field value
     */
    public void setValue(Date value) {
        if (!isRendered()) {
            setAttribute("value", value, true);
        } else {
            setValueRendered(value);
        }
    }

    /**
     * The data value of the underlying field (defaults to "").
     *
     * @param value the field value
     */
    public void setValue(long value) {
        if (!isRendered()) {
            setAttribute("value", value, true);
        } else {
            setValueRendered(value);
        }
    }

    /**
     * The data value of the underlying field (defaults to "").
     *
     * @param value the field value
     */
    public void setValue(double value) {
        if (!isRendered()) {
            setAttribute("value", value, true);
        } else {
            setValueRendered(value);
        }
    }

    /**
     * The data value of the underlying field (defaults to "").
     *
     * @param value the field value
     */
    public void setValue(boolean value) {
        if (!isRendered()) {
            setAttribute("value", value, true);
        } else {
            setValueRendered(value);
		}
	}
}