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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.Ext;
import com.gwtext.client.data.Record;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.BaseExtWidget;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.form.event.FormListener;

/**
 * Form widget.
 */
public class Form extends BaseExtWidget {

    private boolean rendered = false;

    //used in jsni render method
    private String id;

    /**
     * Constucts a new Form.
     */
    public Form() {
        this((String)null);
    }

    /**
     * Constructs a new Form.
     *
     * @param id the Form ID
     */
    public Form(String id) {
        this.id = id == null ? Ext.generateId() : id;
        FormConfig fconfig = new FormConfig();
        createElement(this.id, fconfig);
        setJsObj(create(fconfig.getJsObj()));
        RootPanel.get().add(this);
    }


    /**
     * Constructs a Form with the specified width.
     * 
     * @param width the form width
     */
    public Form(final int width) {
        this(new FormConfig() {
            {
                setWidth(width);
            }
        });
    }

    /**
     * Constructs a new Form using the specified configuration.
     *
     * @param config the Form configuration
     */
    public Form(FormConfig config) {
        this(null, config);
    }

    /**
     * Constructs a new Form.
     *
     * @param id the Form ID
     * @param config the Form configuraiton
     */
    public Form(String id, FormConfig config) {
        this.id = (id == null) ? Ext.generateId() : id;
        createElement(this.id, config);
        setJsObj(create(config.getJsObj()));
        RootPanel.get().add(this);
        if (config.getFormListener() != null) {
            addFormListenerListener(config.getFormListener());
        }
    }

    private void createElement(String id, FormConfig config) {
        int width = config.getWidth();
        String widthStr = config.getWidthStr();
        if (width == -1 && widthStr == null) {
            Element div = DOM.createDiv();
            DOM.setElementProperty(div, "id", id);
            setElement(div);
        } else {
            Element root = DOM.createDiv();
            if(width != -1) {
                DOM.setStyleAttribute(root, "width", width + "px");
            } else {
                DOM.setStyleAttribute(root, "width", widthStr);
            }

            Element parent = root;
            if (config.isSurroundWithBox()) {
                Element tl = DOM.createDiv();
                DOM.setElementProperty(tl, "className", "x-box-tl");

                Element tr = DOM.createDiv();
                DOM.setElementProperty(tr, "className", "x-box-tr");

                Element tc = DOM.createDiv();
                DOM.setElementProperty(tc, "className", "x-box-tc");

                DOM.appendChild(tr, tc);
                DOM.appendChild(tl, tr);
                DOM.appendChild(root, tl);

                Element ml = DOM.createDiv();
                DOM.setElementProperty(ml, "className", "x-box-ml");

                Element mr = DOM.createDiv();
                DOM.setElementProperty(mr, "className", "x-box-mr");

                Element mc = DOM.createDiv();
                DOM.setElementProperty(mc, "className", "x-box-mc");

                ///===================
                DOM.appendChild(mr, mc);
                DOM.appendChild(ml, mr);
                DOM.appendChild(root, ml);


                Element bl = DOM.createDiv();
                DOM.setElementProperty(bl, "className", "x-box-bl");

                Element br = DOM.createDiv();
                DOM.setElementProperty(br, "className", "x-box-br");

                Element bc = DOM.createDiv();
                DOM.setElementProperty(bc, "className", "x-box-bc");

                DOM.appendChild(br, bc);
                DOM.appendChild(bl, br);
                DOM.appendChild(root, bl);

                parent = mc;
            }

            if (config.getHeader() != null) {
                Element header = DOM.createElement("h3");
                DOM.setStyleAttribute(header, "margin-bottom", "5px");
                DOM.setInnerText(header, config.getHeader());
                DOM.appendChild(parent, header);
            }

            Element formDiv = DOM.createDiv();
            DOM.setElementProperty(formDiv, "id", id);

            DOM.appendChild(parent, formDiv);

            setElement(root);
        }
    }

    protected native JavaScriptObject create(JavaScriptObject config)/*-{
        return new $wnd.Ext.form.Form(config);
    }-*/;

    /**
     * Add a Field to the current open container (e.g. column, fieldset, etc.).
     * 
     * @param field the field to add
     */
    public native void add(Field field) /*-{
       var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
       var fieldJS = field.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
       form.add(fieldJS);
   }-*/;

    /**
     * Adds a button to the footer of the form - this must be called before the form is rendered.
     * 
     * @param text the button text
     * @return the added Button
     */
    public native Button addButton(String text) /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var buttonJS = form.addButton(text);
        return @com.gwtext.client.widgets.Button::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(buttonJS);
   }-*/;

    /**
     * Adds a button to the footer of the form - this must be called before the form is rendered.
     *
     * @param button the Button to add
     * @return the added Button
     */
    public Button addButton(Button button) {
        Element buttonEl = button.getElement();
        if (buttonEl != null) {
            Element parent = DOM.getParent(buttonEl);
            if (parent != null) {
                DOM.removeChild(parent, buttonEl);
            }
        }
        JavaScriptObject buttonJS = doAddButton(button);
		button.setJsObj(buttonJS);
		return button;
    }

    private native JavaScriptObject doAddButton(Button button) /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var buttonJS = button.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return form.addButton(buttonJS);
    }-*/;

    /**
     * Copies all properties of the passed config to all fields in this form with the passed object if they don't already exist.
     * 
     * @param fieldConfig the config object
     */
    public native void applyIfToFields(FieldConfig fieldConfig) /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var configJS = fieldConfig.@com.gwtext.client.core.JsObject::jsObj;
        field.applyIfToFields(configJS);
    }-*/;

    /**
     * Copies all properties of the passed config to all fields in this form with the passed object.
     *
     * @param fieldConfig the config object
     */
    public native void applyToFields(FieldConfig fieldConfig) /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var configJS = fieldConfig.@com.gwtext.client.core.JsObject::jsObj;
        field.applyToFields(configJS);
    }-*/;

    /**
     * Clears all invalid messages in this form.
     */
    public native void clearInvalid() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        form.clearInvalid();
    }-*/;

    /**
     * Opens a new {@link Column} container in the layout stack. The column remains open until end() is called.
     * 
     * @param config
     */
    public native void column(ColumnConfig config)/*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        form.column(configJS);
    }-*/;

    /**
     * Opens a new {@link Layout} container in the layout stack. The container remains open until end() is called.
     *
     * @param containerID the container ID
     */
    public void container(final String containerID) {
        container(new ContainerConfig() {
            {
                setId(containerID);
            }
        });
    }

    //http://extjs.com/forum/showthread.php?t=5262&page=2
    /**
     * Opens a new {@link Layout} container in the layout stack. The container remains open until end() is called.
     *
     * @param config the container config
     */
    public native void container(ContainerConfig config)/*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        form.container(configJS);
    }-*/;

    /**
     * Destroys the form and its fields. Removes the form element from the container.
     */
    public native void destroy() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        form.items.each( $wnd.Ext.destroy, $wnd.Ext );
        for(var i = 0, len = form.buttons.length; i < len; i++){
            var btn = form.buttons[i];
            $wnd.Ext.destroy(btn.el);
        }
        $wnd.Ext.destroy(form.el);
        var formEl = this.@com.gwtext.client.widgets.BaseExtWidget::getEl()();
        var formElJS = formEl.@com.gwtext.client.core.JsObject::jsObj;
        $wnd.Ext.destroy(formElJS);
        $wnd.Ext.Element.garbageCollect();
    }-*/;

    /**
     * Closes the current open container.
     */
    public native void end() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        form.end();
    }-*/;

    /**
     * Opens a new {@link FieldSet} container in the layout stack. The fieldset remains open until end() is called.
     *
     * @param legend the fieldset legend
     */
    public void fieldset(final String legend) {
        fieldset(new FieldSetConfig() {
            {
                setLegend(legend);
            }
        });
    }

    /**
     * Opens a new {@link FieldSet} container in the layout stack. The fieldset remains open until end() is called.
     *
     * @param config the fieldset config
     */
    public native void fieldset(FieldSetConfig config)/*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        form.fieldset(configJS);
    }-*/;

    /**
     * Find a {@link Field} in this form by id, dataIndex, name or hiddenName.
     * 
     * @param id the field ID to search for
     * @return the field
     */
    public native Field findField(String id) /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var fieldJS =  form.findField(id);
        return fieldJS.obj;
    }-*/;

    //todo add getValues() that returns Map
    /**
     * Returns the fields in this form as a String
     * 
     * @return form vield values as String
     */
    public native String getValues() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return form.getValues(true);
    }-*/;

    /**
     * Returns true if any fields in this form have changed since their original load.
     *
     * @return true if dirty
     */
    public native boolean isDirty() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return form.isDirty();
    }-*/;

    /**
     * Returns true if client-side validation on the form is successful.
     *
     * @return true if valid
     */
    public native boolean isValid() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return form.isValid();
    }-*/;

    //http://extjs.com/forum/showthread.php?t=4340
    public native void load(FormActionConfig config) /*-{
		var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
		var configJS  = config.@com.gwtext.client.core.JsObject::jsObj;
		form.load(configJS);
	}-*/;

    /**
     * Loads a {@link Record} into this form. The name of the Fields in the {@link com.gwtext.client.data.RecordDef}
     * must match the names of the Fields in the From.
     *
     * @param record the Record to load
     */
    public native void loadRecord(Record record) /*-{
		var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
		var recordJS  = record.@com.gwtext.client.core.JsObject::jsObj;
		form.loadRecord(recordJS);
	}-*/;

    //markInvalid( )  - no need since can findField by ID and call markInvalid on field itself

    /**
     * Removes a field from the items collection (does NOT remove its markup).
     *
     * @param field the field to remove
     */
    public native void remove(Field field) /*-{
	    var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
		var fieldJS  = field.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
		form.remove(fieldJS);
	}-*/;

    /**
     * Render this form. This should only be called once.
     */
    public native void render() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var containerID = this.@com.gwtext.client.widgets.form.Form::id;
        form.render(containerID);
    }-*/;

    /**
     * Resets this form.
     */
    public native void reset() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        form.reset();
    }-*/;

    //setValues  -- no need for now

    /**
     * Starts monitoring of the valid state of this form. Usually this is done by passing the config option
     * "monitorValid"
     */
    public native void startMonitoring() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        form.startMonitoring();
    }-*/;

    /**
     * Stops monitoring of the valid state of this form.
     */
    public native void stopMonitoring() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        form.stopMonitoring();
    }-*/;

    /**
     * Shortcut to do a submit action.
     */
    public native void submit() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        form.submit();
    }-*/;

    /**
     * Submit the form using the specified configuration.
     *
     * @param config form submit config
     */
    public native void submit(FormActionConfig config) /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
		var configJS  = config.@com.gwtext.client.core.JsObject::jsObj;
		form.submit(configJS);
	}-*/;

    /**
     * Submit the form using the specified configuration.
     *
     * @param config form submit config
     * @param clientValidation pass true to call form.isValid() prior to posting to validate the form on the client (defaults to false)
     */
    public void submit(FormActionConfig config, boolean clientValidation) {
        JavaScriptObjectHelper.setAttribute(config.getJsObj(), "clientValidation", clientValidation);
        submit(config);
    }

    /**
     * Persists the values in this Form into the passed Record object.
     * 
     * @param record the record to edit
     */
    public native void updateRecord(Record record) /*-{
		var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
		var recordJS  = record.@com.gwtext.client.core.JsObject::jsObj;
		form.updateRecord(recordJS);
	}-*/;

    /**
     * Add a Form listener.
     *
     * @param listener the form listener
     */
    public native void addFormListenerListener(FormListener listener) /*-{
        var formJ = this;
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;

        form.addListener('actioncomplete',
                function(frm, action) {
                    var responseText = '';
                    var status = 200;
                    if(action.response && action.response != null) {
                        responseText = action.response.responseText;
                        status = action.response.status;
                    }
                    listener.@com.gwtext.client.widgets.form.event.FormListener::onActionComplete(Lcom/gwtext/client/widgets/form/Form;ILjava/lang/String;)(formJ, status, responseText);
                }
        );

        form.addListener('actionfailed',
                function(frm, action) {
                    var responseText = '';
                    var status = 200;
                    if(action.response && action.response != null) {
                        responseText = action.response.responseText;
                        status = action.response.status;
                    }
                    listener.@com.gwtext.client.widgets.form.event.FormListener::onActionFailed(Lcom/gwtext/client/widgets/form/Form;ILjava/lang/String;)(formJ, status, responseText);
                }
        );

        form.addListener('beforeaction',
                function(frm) {
                    return listener.@com.gwtext.client.widgets.form.event.FormListener::doBeforeAction(Lcom/gwtext/client/widgets/form/Form;)(formJ);
                }
        );

        form.addListener('clientvalidation',
                function(frm, valid) {
                    listener.@com.gwtext.client.widgets.form.event.FormListener::onClientValidation(Lcom/gwtext/client/widgets/form/Form;Z)(formJ, valid);
                }
        );
    }-*/;
}
