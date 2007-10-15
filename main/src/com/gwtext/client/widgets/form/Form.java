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

public class Form extends BaseExtWidget {

    private boolean rendered = false;

    //used in jsni render method
    private String id;

    public Form() {
        this((String)null);
    }

    public Form(String id) {
        this.id = id == null ? Ext.generateId() : id;
        FormConfig fconfig = new FormConfig();
        createElement(this.id, fconfig);
        setJsObj(create(fconfig.getJsObj()));
        RootPanel.get().add(this);
    }

    public Form(FormConfig config) {
        this(null, config);
    }

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

    public native void add(Field field) /*-{
       var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
       var fieldJS = field.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
       form.add(fieldJS);
   }-*/;

    public native Button addButton(String text) /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var buttonJS = form.addButton(text);
        return @com.gwtext.client.widgets.Button::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(buttonJS);
   }-*/;

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


    public native void applyIfToFields(FieldConfig fieldConfig) /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var configJS = fieldConfig.@com.gwtext.client.core.JsObject::jsObj;
        field.applyIfToFields(configJS);
    }-*/;

    public native void applyToFields(FieldConfig fieldConfig) /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var configJS = fieldConfig.@com.gwtext.client.core.JsObject::jsObj;
        field.applyToFields(configJS);
    }-*/;

    public native void clearInvalid() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        form.clearInvalid();
    }-*/;

    public native void column(ColumnConfig config)/*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        form.column(configJS);
    }-*/;

    public void container(final String containerID) {
        container(new ContainerConfig() {
            {
                setId(containerID);
            }
        });
    }

    //http://extjs.com/forum/showthread.php?t=5262&page=2
    public native void container(ContainerConfig config)/*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        form.container(configJS);
    }-*/;


    public native void end() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        form.end();
    }-*/;


    public void fieldset(final String legend) {
        fieldset(new FieldSetConfig() {
            {
                setLegend(legend);
            }
        });
    }

    public native void fieldset(FieldSetConfig config)/*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        form.fieldset(configJS);
    }-*/;

    public Field findField(String id) {
        JavaScriptObject field = findField(getJsObj(), id);

        return field == null ? null : new Field(field);
    }

    private native JavaScriptObject findField(JavaScriptObject form, String id) /*-{
        return form.findField(id);
    }-*/;

    public native String getValues() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return form.getValues(true);
    }-*/;


    public native boolean isDirty() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return form.isDirty();
    }-*/;

    public native boolean isValid() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return form.isValid();
    }-*/;

    public native void load(FormActionConfig config) /*-{
		var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
		var configJS  = config.@com.gwtext.client.core.JsObject::jsObj;
		form.load(configJS);
	}-*/;

    public native void loadRecord(Record record) /*-{
		var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
		var recordJS  = record.@com.gwtext.client.core.JsObject::jsObj;
		form.loadRecord(recordJS);
	}-*/;

    //markInvalid( )  - no need since can findField by ID and call markInvalid on field itself

    public native void remove(Field field) /*-{
			var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
			var fieldJS  = field.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
			form.remove(fieldJS);
	}-*/;

    public native void render() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var containerID = this.@com.gwtext.client.widgets.form.Form::id;
        form.render(containerID);
    }-*/;

    public native void reset() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        form.reset();
    }-*/;

    //setValues  -- no need for now

    public native void startMonitoring() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        form.startMonitoring();
    }-*/;

    public native void stopMonitoring() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        form.stopMonitoring();
    }-*/;

    public native void submit() /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        form.submit();
    }-*/;

    public native void submit(FormActionConfig config) /*-{
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
		var configJS  = config.@com.gwtext.client.core.JsObject::jsObj;
		form.submit(configJS);
	}-*/;

    public void submit(FormActionConfig config, boolean clientValidation) {
        JavaScriptObjectHelper.setAttribute(config.getJsObj(), "clientValidation", clientValidation);
        submit(config);
    }

    public native void updateRecord(Record record) /*-{
		var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
		var recordJS  = record.@com.gwtext.client.core.JsObject::jsObj;
		form.updateRecord(recordJS);
	}-*/;

    public native void addFormListenerListener(FormListener listener) /*-{
        var formJ = this;
        var form = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;

        form.addListener('actioncomplete',
                function(frm) {
                    listener.@com.gwtext.client.widgets.form.event.FormListener::onActionComplete(Lcom/gwtext/client/widgets/form/Form;)(formJ);
                }
        );

        form.addListener('actionfailed',
                function(frm) {
                    listener.@com.gwtext.client.widgets.form.event.FormListener::onActionFailed(Lcom/gwtext/client/widgets/form/Form;)(formJ);
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
