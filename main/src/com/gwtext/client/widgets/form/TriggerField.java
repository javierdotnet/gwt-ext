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
import com.gwtext.client.core.EventObject;

//http://extjs.com/forum/showthread.php?t=3613&highlight=triggerfield
/**
 * Provides a convenient wrapper for TextFields that adds a clickable trigger button (looks like a combobox by default).
 * The trigger has no default action, so you mustimplement the trigger click handler by overriding {@link #onTriggerClick(com.gwtext.client.core.EventObject)}.
 * You can create a TriggerField directly, as it renders exactly like a combobox for which you can provide a custom implementation.
 *
 */
public abstract class TriggerField extends TextField {

    /**
     * Construct a new TriggerField.
     */
    public TriggerField() {
    }

    public TriggerField(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected void initComponent() {
        super.initComponent();
        setup(this, getJsObj());
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
        } else {
            //There's an inconsistency in Ext where most elements have the property 'el' set to Ext's Element
            //with the exception of Menu->Item, Menu->Separator, Menu->TextItem,  Toolbar.Item and subclasses
            //(Toolbar.Separator, Toolbar.Spacer, Toolbar.TextItem) where the 'el' property is set to
            //the DOM element itself. Therefore retruning 'el' if 'el' is not Ext's Element. See details in issue 39.
             return el.dom || el ;
        }
    }-*/;

    private native void setup(TriggerField triggerField, JavaScriptObject jsObj) /*-{
        jsObj.onTriggerClick = function(event) {
            var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
            triggerField.@com.gwtext.client.widgets.form.TriggerField::onTriggerClick(Lcom/gwtext/client/core/EventObject;)(e);
        }
    }-*/;
    
    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
        return new $wnd.Ext.form.TriggerField(jsObj);
    }-*/;

    /**
     * Abstract method that must be implmented for custom trigger field behavior.
     *
     * @param event the event object
     */
    protected abstract void onTriggerClick(EventObject event);

    // config properties ---
    public String getXType() {
        return "trigger";
    }

    /**
     * True to hide the trigger element and display only the base text field (defaults to false).
     *
     * @param hideTrigger true to hide trigger
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setHideTrigger(boolean hideTrigger) throws IllegalStateException {
        setAttribute("hideTrigger", hideTrigger, true);
    }

    /**
     * A CSS class to apply to the trigger.
	 *
     * @param triggerClass the trigger CSS class.
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTriggerClass(String triggerClass) throws IllegalStateException {
        setAttribute("triggerClass", triggerClass, true);
    }
}
