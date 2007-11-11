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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.Template;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.event.ViewListener;

/**
 * Create a "View" for an element based on a data model or UpdateManager and the supplied DomHelper template. This class also supports single and multi selection modes.
 */
public class View extends BaseExtWidget {

    /**
     * Create a new View.
     *
     * @param id the contaienr element ID
     * @param template the rendering template string
     * @param config the config object
     */
    public View(String id, String template, ViewConfig config) {
        Element div = DOM.getElementById(id);
        if(div == null) {
            div = DOM.createDiv();
            DOM.setElementProperty(div, "id", id);
        }
        setElement(div);
        RootPanel.get().add(this);
        jsObj = create(div, template, config.getJsObj());
    }

    /**
     * Create a new View.
     *
     * @param id the contaienr element ID
     * @param template the rendering template
     * @param config the config object
     */
    public View(String id, Template template, ViewConfig config) {
        Element div = DOM.getElementById(id);
        if(div == null) {
            div = DOM.createDiv();
            DOM.setElementProperty(div, "id", id);
        }
        setElement(div);
        RootPanel.get().add(this);
        jsObj = create(div, template.getJsObj(), config.getJsObj());
    }


    protected native JavaScriptObject create(Element container, String template, JavaScriptObject config) /*-{
        return new $wnd.Ext.View(container, template, config);
    }-*/;

    protected native JavaScriptObject create(Element container, JavaScriptObject template, JavaScriptObject config) /*-{
        return new $wnd.Ext.View(container, template, config);
    }-*/;

    /**
     * Clear all selections.
     */
    public native void clearSelections() /*-{
       var view = this.@com.gwtext.client.core.JsObject::jsObj;
       view.clearSelections();
   }-*/;

    /**
     * Clear all selections.
     *
     * @param supressEvent true to skip firing of the selectionchange event 
     */
    public native void clearSelections(boolean supressEvent) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.clearSelections(supressEvent);
    }-*/;

    /**
     * Returns the template node the passed child belongs to or null if it doesn't belong to one.
     *
     * @param node the element
     * @return the template node
     */
    public native Element findItemFromChild(Element node) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.findItemFromChild(node);
    }-*/;

    /**
     * Gets a template node.
     *
     * @param templateNode the template node
     * @return the node or null if not found
     */
    public native Element getNode(Element templateNode) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.getNode(templateNode);
    }-*/;

    /**
     * Gets a template node.
     *
     * @param index the template node index
     * @return the node or null if not found
     */
    public native Element getNode(int index) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.getNode(index);
    }-*/;

    /**
     * Gets a template node.
     *
     * @param id the template node Id
     * @return the node or null if not found
     */
    public native Element getNode(String id) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.getNode(id);
    }-*/;

    /**
     * Gets a range template nodes.
     *
     * @param startIndex the start index
     * @param endIndex the end index
     * @return an array of matched nodes
     */
    public native Element[] getNodes(int startIndex, int endIndex) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var nodes = view.getNodes(startIndex, endIndex);
        return @com.gwtext.client.util.JavaScriptObjectHelper::toElementArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodes);
    }-*/;

    /**
     * Get the indexes of the selected nodes.
     *
     * @return the indexes of the selected nodes
     */
    public native int[] getSelectedIndexes() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var selected = view.getSelectedIndexes();
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selected);
    }-*/;

    /**
     * Get the currently selected nodes.
     *
     * @return the currently selected nodes
     */
    public native Element[] getSelectedNodes() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var nodes = view.getSelectedNodes();
        return @com.gwtext.client.util.JavaScriptObjectHelper::toElementArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodes);
    }-*/;

    /**
     * Get the number of selected nodes.
     *
     * @return the number of selected nodes
     */
    public native int getSelectionCount() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.getSelectionCount();
    }-*/;

    /**
     * Finds the index of the passed node.
     * 
     * @param templateNode the html template node
     * @return the index of node or -1 if not found
     */
    public native int indexOf(Element templateNode) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.indexOf(templateNode);
    }-*/;

    /**
     * Finds the index of the passed node.
     *
     * @param index the node template index
     * @return the index of node
     */
    public native int indexOf(int index) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.indexOf(index);
    }-*/;

    /**
     *  Finds the index of the passed node.
     *
     * @param id the ID of tempalte node
     * @return the node index
     */
    public native int indexOf(String id) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.indexOf(id);
    }-*/;

    /**
     * Returns true if the passed node is selected.
     * 
     * @param node the node
     * @return true if node selected
     */
    public native boolean isSelected(Element node) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.isSelected(node);
    }-*/;

    /**
     * Returns true if the passed node is selected.
     *
     * @param nodeindex the node index
     * @return true if node selected
     */
    public native boolean isSelected(int nodeindex) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.isSelected(nodeindex);
    }-*/;

    //todo maybe just document since user will need to implement using jsni?
    //prepareData()

    /**
     * Refreshes the view.
     */
    public native void refresh() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.refresh();
    }-*/;

    /**
     * Changes the data store this view uses and refresh the view.
     *
     * @param store the store
     */
    public native void setStore(Store store) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var storeJS = store.@com.gwtext.client.core.JsObject::jsObj;
        view.setStore(storeJS);
    }-*/;

    /**
     * The template used by this View.
     *
     * @param template the template
     */
    public native void setTemplate(Template template) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var templateJS = template.@com.gwtext.client.core.JsObject::jsObj;
        view.tpl = templateJS;
    }-*/;

    /**
     * The css class to add to selected nodes
     *
     * @param selectedClass teh CSS class
     */
    public native void setSelectedClass(String selectedClass) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.selectedClass = selectedClass;
    }-*/;

    //todo not documeted by ext
    /**
     * Text to display when there are no nodes to display.
     *
     * @param emptyText the empty text
     */
    public native void setEmptyText(String emptyText) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.emptyText = emptyText;
    }-*/;

    /**
     * Add a View listener.
     *
     * @param listener the listener
     */
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