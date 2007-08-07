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
import com.gwtext.client.core.JsObject;
import com.gwtext.client.core.Template;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.event.ViewListener;

public class View extends JsObject {

    public View(Element container, String template, ViewConfig config) {
        jsObj = create(container, template, config.getJsObj());
    }

    public View(Element container, Template template, ViewConfig config) {
        jsObj = create(container, template.getJsObj(), config.getJsObj());
    }

    protected native JavaScriptObject create(Element container, String template, JavaScriptObject config) /*-{
        return new $wnd.Ext.View(container, template, config);
    }-*/;

    protected native JavaScriptObject create(Element container, JavaScriptObject template, JavaScriptObject config) /*-{
        return new $wnd.Ext.View(container, template, config);
    }-*/;

    public native void clearSelections() /*-{
       var view = this.@com.gwtext.client.core.JsObject::jsObj;
       view.clearSelections();
   }-*/;

    public native void clearSelections(boolean supressEvent) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.clearSelections(supressEvent);
    }-*/;

    public native Element findItemFromChild(Element node) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.findItemFromChild(node);
    }-*/;

    public native Element getEl() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var el = view.getEl();
        return el.dom;
    }-*/;

    public native Element getNode(Element templateNode) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.getNode(templateNode);
    }-*/;

    public native Element getNode(int index) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.getNode(index);
    }-*/;

    public native Element getNode(String id) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.getNode(id);
    }-*/;

    public native Element[] getNodes(int startIndex, int endIndex) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var nodes = view.getNodes(startIndex, endIndex);
        return @com.gwtext.client.util.JavaScriptObjectHelper::toElementArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodes);
    }-*/;

    public native int[] getSelectedIndexes() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var selected = view.getSelectedIndexes();
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selected);
    }-*/;

    public native Element[] getSelectedNodes() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var nodes = view.getSelectedNodes();
        return @com.gwtext.client.util.JavaScriptObjectHelper::toElementArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodes);
    }-*/;

    public native int getSelectionCount() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.getSelectionCount();
    }-*/;

    public native int indexOf(Element templateNode) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.indexOf(templateNode);
    }-*/;

    public native int indexOf(int index) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.indexOf(index);
    }-*/;

    public native int indexOf(String id) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.indexOf(id);
    }-*/;

    public native boolean isSelected(Element node) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.isSelected(node);
    }-*/;

    public native boolean isSelected(int nodeindex) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.isSelected(nodeindex);
    }-*/;

    //todo maybe just document since user will need to implement using jsni?
    //prepareData()

    public native void refresh() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.refresh();
    }-*/;

    public native void setStore(Store store) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var storeJS = store.@com.gwtext.client.core.JsObject::jsObj;
        view.setStore(storeJS);
    }-*/;

    public native void setTemplate(Template template) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var templateJS = template.@com.gwtext.client.core.JsObject::jsObj;
        view.tpl = templateJS;
    }-*/;

    public native void setSelectedClass(String selectedClass) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.selectedClass = selectedClass;
    }-*/;

    //todo not documeted by ext
    public native void setEmptyText(String emptyText) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.emptyText = emptyText;
    }-*/;

    public native void addViewListener(ViewListener listener) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var viewJ = this;

        view.addListener('beforeclick',
                function(self, index, node, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    return listener.@com.gwtext.client.widgets.event.ViewListener::doBeforeClick(Lcom/gwtext/client/widgets/View;ILcom/google/gwt/user/client/Element;Lcom/gwtext/client/core/EventObject;)(viewJ, index, node, e);
                }
        );

        view.addListener('beforeselect',
                function(self, node, selections) {
                    var selectionsJ = selections == null ? null : @com.gwtext.client.util.JavaScriptObjectHelper::toElementArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selections)
                    return listener.@com.gwtext.client.widgets.event.ViewListener::doBeforeSelect(Lcom/gwtext/client/widgets/View;Lcom/google/gwt/user/client/Element;[Lcom/google/gwt/user/client/Element;)(viewJ, node, selectionsJ);
                }
        );

        view.addListener('click',
                function(self, index, node, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.event.ViewListener::onClick(Lcom/gwtext/client/widgets/View;ILcom/google/gwt/user/client/Element;Lcom/gwtext/client/core/EventObject;)(viewJ, index, node, e);
                }
        );

        view.addListener('contextmenu',
                function(self, index, node, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.event.ViewListener::onContextMenu(Lcom/gwtext/client/widgets/View;ILcom/google/gwt/user/client/Element;Lcom/gwtext/client/core/EventObject;)(viewJ, index, node, e);
                }
        );

        view.addListener('dblclick',
                function(self, index, node, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.event.ViewListener::onDblClick(Lcom/gwtext/client/widgets/View;ILcom/google/gwt/user/client/Element;Lcom/gwtext/client/core/EventObject;)(viewJ, index, node, e);
                }
        );

        view.addListener('selectionchange',
                function(self, selections) {
                    var selectionsJ = selections == null ? null : @com.gwtext.client.util.JavaScriptObjectHelper::toElementArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selections)
                    listener.@com.gwtext.client.widgets.event.ViewListener::onSelectionChange(Lcom/gwtext/client/widgets/View;[Lcom/google/gwt/user/client/Element;)(viewJ, selectionsJ);
                }
        );

    }-*/;
}