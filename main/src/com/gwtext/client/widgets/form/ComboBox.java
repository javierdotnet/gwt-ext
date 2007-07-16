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
import com.gwtext.client.widgets.form.event.ComboBoxListener;

public class ComboBox extends TriggerField {
    public ComboBox() {
        setJsObj(create(null));
    }

    public ComboBox(String id, ComboBoxConfig config) {
        super(config);
        if (config.getComboBoxListener() != null) {
            addComboBoxListener(config.getComboBoxListener());
        }
        //Element container = DOM.createDiv();
        //DOM.setElementProperty(container, "id", id+"-container");
        //RootPanel.get().add(new HTML("<div id='" + id+"-container'></div>"));

        //applyTo(id+"-container");
        //RootPanel.get().add(this);
        //DOM.setElementProperty(getElement(), "id", id);

    }

    public ComboBox(ComboBoxConfig config) {
        super(config);
        if (config.getComboBoxListener() != null) {
            addComboBoxListener(config.getComboBoxListener());
        }
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
        return new $wnd.Ext.form.ComboBox(jsObj);
    }-*/;

    public native void clearValue() /*-{
        var cb = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        cb.clearValue();
    }-*/;

    public native void collapse() /*-{
        var cb = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        cb.collapse();
    }-*/;

    public native void doQuery(String query, boolean forceAll) /*-{
        var cb = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        cb.doQuery(query, forceAll);
    }-*/;

    public native void expand() /*-{
        var cb = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        cb.expand();
    }-*/;

    public native String getValue() /*-{
        var cb = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return cb.getValue();
    }-*/;

    public native boolean isExpanded() /*-{
        var cb = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return cb.isExpanded();
    }-*/;

    public native void select(int index, boolean scrollIntoView) /*-{
        var cb = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        cb.select(index, scrollIntoView);
    }-*/;

    public native void selectByValue(String value, boolean scrollIntoView) /*-{
        var cb = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        cb.selectByValue(value, scrollIntoView);
    }-*/;

    public native void setEditable() /*-{
        var cb = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        cb.setEditable();
    }-*/;

    /**
     * Sets the specified value into the field. If the value finds a match, the corresponding record text will be displayed in the field. If the value does
     * not match the data value of an existing item, and the valueNotFoundText config option is defined, it will be displayed as the default field text. Otherwise the field will be blank (although the value will still be set).
     */
    public native void setValue(String value) /*-{
        var cb = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        cb.setValue(value);
    }-*/;

/*    protected void onAttach() {
    DeferredCommand.addCommand(new Command() {
        public void execute() {
            Widget parent = getParent();
            Element parentElement = parent.getElement();
            render(parentElement);
        }
    });
}*/

    public native void addComboBoxListener(ComboBoxListener listener) /*-{
        var fieldJ = this;
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;

        field.addListener('beforequery',
                function(fld, o) {
                    var cbJ = @com.gwtext.client.widgets.form.event.ComboBoxCallback::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(o);
                    return listener.@com.gwtext.client.widgets.form.event.ComboBoxListener::doBeforeQuery(Lcom/gwtext/client/widgets/form/ComboBox;Lcom/gwtext/client/widgets/form/event/ComboBoxCallback;)(fieldJ,cbJ);
                }
        );

        field.addListener('beforeselect',
                function(fld, record, index) {
                    var recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
                    return listener.@com.gwtext.client.widgets.form.event.ComboBoxListener::doBeforeSelect(Lcom/gwtext/client/widgets/form/ComboBox;Lcom/gwtext/client/data/Record;I)(fieldJ, recordJ, index);
                }
        );

        field.addListener('collapse',
                function(fld) {
                    listener.@com.gwtext.client.widgets.form.event.ComboBoxListener::onCollapse(Lcom/gwtext/client/widgets/form/ComboBox;)(fieldJ);
                }
        );
        field.addListener('expand',
                function(fld) {
                    listener.@com.gwtext.client.widgets.form.event.ComboBoxListener::onExpand(Lcom/gwtext/client/widgets/form/ComboBox;)(fieldJ);
                }
        );

        field.addListener('select',
                function(fld, record, index) {
                    var recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
                    listener.@com.gwtext.client.widgets.form.event.ComboBoxListener::onSelect(Lcom/gwtext/client/widgets/form/ComboBox;Lcom/gwtext/client/data/Record;I)(fieldJ, recordJ, index);
                }
        );
    }-*/;

}
