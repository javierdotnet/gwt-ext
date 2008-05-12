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
import com.gwtext.client.core.GenericConfig;
import com.gwtext.client.core.XTemplate;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.event.DataViewListener;

/**
 * A mechanism for displaying data using custom layout templates and formatting. DataView uses {@link XTemplate} as its internal
 * templating mechanisma, and is bound to an {@link Store} so that as the data in the store changes the view is automatically
 * updated to reflect the changes. The view also provides built-in behavior for many common events that can occur for its contained
 * items including click, doubleclick, mouseover, mouseout, etc. as well as a built-in selection model.
 *
 * An itemSelector which is passed to the constructor is used to determine what nodes it will be working with.
 *
 * The example below binds a DataView to a Store and renders it into a {@link Panel}.
 *
 * <pre>
 * <code>
 *
 * // data here is Object[][] of local data.
 * MemoryProxy dataProxy = new MemoryProxy(getData());
 * ArrayReader reader = new ArrayReader(new RecordDef(new FieldDef[]{
 *                                      new StringFieldDef("name"),
 *                                      new IntegerFieldDef("size"),
 *                                      new DateFieldDef("lastmod", "timestamp"),
 *                                      new StringFieldDef("url")}));
 *
 * Store store = new Store(dataProxy, reader);
 * store.load();
 *
 * XTemplate template = new XTemplate(new String[]{
 *                  "&lt;tpl for='.'&gt;",
 *                  "&lt;div class='thumb-wrap' id='{name}'&gt;",
 *                  "&lt;div class='thumb'&gt;&lt;img src='{url}' title='{name}'&gt;&lt;/div&gt;",
 *                  "&lt;span class='x-editable'&gt;{shortName}&lt;/span&gt;&lt;/div&gt;",
 *                  "&lt;/tpl&gt;",
 *                  "&lt;div class='x-clear'&gt;&lt;/div&gt;"});
 *
 * Panel panel = new Panel();
 * panel.setId("images-view");
 * panel.setFrame(true);
 * panel.setAutoHeight(true);
 * panel.setCollapsible(true);
 * panel.setLayout(new FitLayout());
 * panel.setTitle("Simple DataView with editable labels, multi and drag selection");
 *
 * //pre process the data from te store before passing it to the DataView
 * DataView dataView = new DataView("div.thumb-wrap") {
 *               public void prepareData(Data data) {
 *                   data.setProperty("shortName", Format.ellipsis(data.getProperty("name"), 15));
 *               } };
 *
 *
 * dataView.setStore(store);
 * dataView.setTpl(template);
 * dataView.setAutoHeight(true);
 * dataView.setMultiSelect(true);
 * dataView.setOverCls("x-view-over");
 * dataView.setEmptyText("No Images to display");
 *
 * panel.add(dataView);
 * RootPanel.get().add(panel);
 * </code>
 * </pre>
 *
 * @author Sanjiv Jivan
 */
public class DataView extends BoxComponent {
    static {
		init();
	}

    private static native void init()/*-{
        //var c = new $wnd.Ext.Component();
        //@com.gwtext.client.widgets.Component::configPrototype = c.initialConfig;

        $wnd.Ext.DataView.prototype.prepareData=function(data) {
            var compJ = this.__compJ;
            if(compJ != null) {
                var dataJ = @com.gwtext.client.widgets.DataView$Data::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
                compJ.@com.gwtext.client.widgets.DataView::prepareData(Lcom/gwtext/client/widgets/DataView$Data;)(dataJ);
                return data;
            } else {
                return data;
            }
        };
    }-*/;

    /**
     * Create a new DataView.
     *
     * @param itemSelector a CSS selector in any format supported by {@link com.gwtext.client.core.DomQuery} that will be used to determine
     *                     what nodes this DataView will be working with.
     */
    public DataView(String itemSelector) {
        setItemSelector(itemSelector);
    }

    public DataView(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public String getXType() {
        return "dataview";
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.DataView(config);
    }-*/;

    /**
     * This method that can be overridden to provide custom formatting for the data that is sent to the template for each node.
     * Data can be retried by name for lookup and new fields / value can be added to it/
     *
     * @param data the view data
     */
    public void prepareData(Data data) {
    }

    /**
     * Clears all selections.
     */
    public native void clearSelections() /*-{
        var dv = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        dv.clearSelections();
    }-*/;

    /**
     * Clears all selections.
     *
     * @param suppressEvent true to prevent firing of the selectionchange event
     */
    public native void clearSelections(boolean suppressEvent) /*-{
        var dv = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        dv.clearSelections(suppressEvent);
    }-*/;

    /**
     * Deselects a node.
     *
     * @param element the node to delselect
     */
    public native void deselect(Element element) /*-{
        var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        dv.deselect(element);
    }-*/;

    /**
     * Deselects a node.
     *
     * @param nodeIndex index of node to deselect
     */
    public native void deselect(int nodeIndex) /*-{
        var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        dv.deselect(nodeIndex);
    }-*/;

    /**
     * Returns the template node the passed child belongs to, or null if it doesn't belong to one.
     *
     * @return template node the child belongs to
     */
    public native Element findItemFromChild() /*-{
        var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var item = dv.findItemFromChild();
        return item === undefined ? null : item;
    }-*/;

    /**
     * Gets a template node.
     *
     * @param nodeID the id of a template node
     * @return the node or null if it wasn't found
     */
    public native Element getNode(String nodeID) /*-{
        var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var node = dv.getNode(nodeID);
        return node === undefined ? null : node;
    }-*/;

    /**
     * Gets a template node.
     *
     * @param nodeIndex the index of a template node
     * @return the node or null if it wasn't found
     */
    public native Element getNode(int nodeIndex) /*-{
        var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var node = dv.getNode(nodeIndex);
        return node === undefined ? null : node;
    }-*/;

    /**
     * Gets a range nodes.
     *
     * @param start the index of the first node in the range
     * @param end   the index of the last node in the range
     * @return an array of nodes
     */
    public native Element[] getNodes(int start, int end) /*-{
        var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var nodes = dv.getNodes(start, end);
        return @com.gwtext.client.util.JavaScriptObjectHelper::toElementArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodes);
    }-*/;

    /**
     * Gets a record from a node.
     *
     * @param node The node to evaluate
     * @return the Record
     */
    public native Record getRecord(Element node) /*-{
        var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var record = dv.getRecord(node);
        return record == null || record === undefined ? null : @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
    }-*/;

    /**
     * Gets the indexes of the selected nodes.
     *
     * @return an array of numeric indexes
     */
    public native int[] getSelectedIndexes() /*-{
        var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var indexes = dv.getSelectedIndexes();
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(indexes);
    }-*/;

    /**
     * Gets an array of the selected records.
     *
     * @return an array of Records
     */
    public native Record[] getSelectedRecords() /*-{
        var dv = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var records = dv.getSelectedRecords();
        return @com.gwtext.client.data.Store::convertFromNativeRecordsArray(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
    }-*/;

    /**
     * Gets the number of selected nodes.
     *
     * @return the node count
     */
    public native int getSelectionCount() /*-{
        var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return dv.getSelectionCount();
    }-*/;

    /**
     * Finds the index of the passed node.
     *
     * @param element the node
     * @return The index of the node or -1
     */
    public native int indexOf(Element element) /*-{
        var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return dv.indexOf(element);
    }-*/;

    /**
     * Finds the index of the passed node.
     *
     * @param nodeID the node ID
     * @return The index of the node or -1
     */
    public native int indexOf(String nodeID) /*-{
        var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return dv.indexOf(nodeID);
    }-*/;

    /**
     * Finds the index of the passed node.
     *
     * @param nodeIndex the node index
     * @return The index of the node or -1
     */
    public native int indexOf(int nodeIndex) /*-{
        var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return dv.indexOf(nodeIndex);
    }-*/;

    /**
     * Returns true if the passed node is selected, else false.
     *
     * @param element the node
     * @return true if selected
     */
    public native boolean isSelected(Element element) /*-{
        var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return dv.isSelected(element);
    }-*/;

    /**
     * Returns true if the passed node is selected, else false.
     *
     * @param nodeIndex the node index
     * @return true if selected
     */
    public native boolean isSelected(int nodeIndex) /*-{
        var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return dv.isSelected(nodeIndex);
    }-*/;

    //TODO ext 2.0 prepareData

    /**
     * Refreshes the view by reloading the data from the store and re-rendering the template.
     */
    public native void refresh() /*-{
        if(this.@com.gwtext.client.widgets.Component::isRendered()()) {
            var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
            dv.refresh();
        }
    }-*/;

    /**
     * Refreshes an individual node's data from the store.
     *
     * @param nodeIndex the node index
     */
    public native void refreshNode(int nodeIndex) /*-{
        if(this.@com.gwtext.client.widgets.Component::isRendered()()) {
            var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
            dv.refreshNode(nodeIndex);
        }
    }-*/;

    /**
     * Selectsthe node.
     *
     * @param node the noed
     */
    public native void select(Element node) /*-{
        if(this.@com.gwtext.client.widgets.Component::isRendered()()) {
            var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
            dv.select(node);
        }
    }-*/;

    /**
     * Selects the node.
     *
     * @param node          the node
     * @param keepExisting  true to keep existing selections
     * @param suppressEvent true to skip firing of the selectionchange vent
     */
    public native void select(Element node, boolean keepExisting, boolean suppressEvent) /*-{
        if(this.@com.gwtext.client.widgets.Component::isRendered()()) {
            var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
            dv.select(node, keepExisting, suppressEvent);
        }
    }-*/;

    /**
     * Selects the node.
     *
     * @param nodeIndex the node index
     */
    public native void select(int nodeIndex) /*-{
        if(this.@com.gwtext.client.widgets.Component::isRendered()()) {
            var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
            dv.select(nodeIndex);
        }
    }-*/;

    /**
     * Selects the node.
     *
     * @param nodeIndex     the node index
     * @param keepExisting  true to keep existing selections
     * @param suppressEvent true to skip firing of the selectionchange event
     */
    public native void select(int nodeIndex, boolean keepExisting, boolean suppressEvent) /*-{
        if(this.@com.gwtext.client.widgets.Component::isRendered()()) {
            var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
            dv.select(nodeIndex, keepExisting, suppressEvent);
        }
    }-*/;

    /**
     * Selects a set of nodes.
     *
     * @param nodeIndexes the node indexes
     */
    public native void select(int[] nodeIndexes) /*-{
        if(this.@com.gwtext.client.widgets.Component::isRendered()()) {
            var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
            var nodeIndexesJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(nodeIndexes);
            dv.select(nodeIndexesJS);
        }
    }-*/;

    /**
     * Selects a set of nodes.
     *
     * @param nodeIndexes   the node indexes
     * @param keepExisting  true to keep existing selections
     * @param suppressEvent true to skip firing of the selectionchange event
     */
    public native void select(int[] nodeIndexes, boolean keepExisting, boolean suppressEvent) /*-{
        if(this.@com.gwtext.client.widgets.Component::isRendered()()) {
            var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
            var nodeIndexesJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(nodeIndexes);
            dv.select(nodeIndexesJS, keepExisting, suppressEvent);
        }
    }-*/;


    /**
     * Selects a set of nodes.
     *
     * @param nodeIDs the node ID's
     */
    public native void select(String[] nodeIDs) /*-{
        if(this.@com.gwtext.client.widgets.Component::isRendered()()) {
            var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
            var nodeIDsJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodeIDs);
            dv.select(nodeIDsJS);
        }
    }-*/;

    /**
     * Selects a set of nodes.
     *
     * @param nodeIDs       the node ID's
     * @param keepExisting  true to keep existing selections
     * @param suppressEvent true to skip firing of the selectionchange event
     */
    public native void select(String[] nodeIDs, boolean keepExisting, boolean suppressEvent) /*-{
        if(this.@com.gwtext.client.widgets.Component::isRendered()()) {
            var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
            var nodeIDsJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodeIDs);
            dv.select(nodeIDsJS, keepExisting, suppressEvent);
        }
    }-*/;

    /**
     * Selects a range of nodes. All nodes between start and end are selected.
     *
     * @param start The index of the first node in the range
     * @param end   The index of the last node in the range
     */
    public native void selectRange(int start, int end) /*-{
        if(this.@com.gwtext.client.widgets.Component::isRendered()()) {
            var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
            dv.selectRange(start, end);
        }
    }-*/;

    /**
     * Selects a range of nodes. All nodes between start and end are selected.
     *
     * @param start        The index of the first node in the range
     * @param end          The index of the last node in the range
     * @param keepExisting true to retain existing selections
     */
    public native void selectRange(int start, int end, boolean keepExisting) /*-{
        if(this.@com.gwtext.client.widgets.Component::isRendered()()) {
            var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
            dv.selectRange(start, end, keepExisting);
        }
    }-*/;

    public native void addListener(DataViewListener listener)/*-{    
        this.@com.gwtext.client.widgets.BoxComponent::addListener(Lcom/gwtext/client/widgets/event/BoxComponentListener;)(listener);
        var dvJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforeclick',
                function(source, index, node, event) {
                    var e = (event === undefined || event == null) ? null : @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    return listener.@com.gwtext.client.widgets.event.DataViewListener::doBeforeClick(Lcom/gwtext/client/widgets/DataView;ILcom/google/gwt/user/client/Element;Lcom/gwtext/client/core/EventObject;)(dvJ, index, node, e);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforeselect',
                function(source, node, selections) {
                    var selectionsJ = @com.gwtext.client.util.JavaScriptObjectHelper::toElementArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selections);
                    return listener.@com.gwtext.client.widgets.event.DataViewListener::doBeforeSelect(Lcom/gwtext/client/widgets/DataView;Lcom/google/gwt/user/client/Element;[Lcom/google/gwt/user/client/Element;)(dvJ, node, selectionsJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('click',
                function(source, index, node, event) {
                    var e = (event === undefined || event == null) ? null : @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.event.DataViewListener::onClick(Lcom/gwtext/client/widgets/DataView;ILcom/google/gwt/user/client/Element;Lcom/gwtext/client/core/EventObject;)(dvJ, index, node, e);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('containerclick',
                function(source, event) {
                    var e = (event === undefined || event == null) ? null : @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.event.DataViewListener::onContainerClick(Lcom/gwtext/client/widgets/DataView;Lcom/gwtext/client/core/EventObject;)(dvJ, e);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('contextmenu',
                function(source, index, node, event) {
                    var e = (event === undefined || event == null) ? null : @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.event.DataViewListener::onContextMenu(Lcom/gwtext/client/widgets/DataView;ILcom/google/gwt/user/client/Element;Lcom/gwtext/client/core/EventObject;)(dvJ, index, node, e);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('dblclick',
                function(source, index, node, event) {
                    var e = (event === undefined || event == null) ? null : @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.event.DataViewListener::onDblClick(Lcom/gwtext/client/widgets/DataView;ILcom/google/gwt/user/client/Element;Lcom/gwtext/client/core/EventObject;)(dvJ, index, node, e);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('selectionchange',
                function(source, selections) {
                    var selectionsJ = @com.gwtext.client.util.JavaScriptObjectHelper::toElementArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selections);
                    listener.@com.gwtext.client.widgets.event.DataViewListener::onSelectionChange(Lcom/gwtext/client/widgets/DataView;[Lcom/google/gwt/user/client/Element;)(dvJ, selectionsJ);
                }
        );
    
    }-*/;


    //config
    /**
     * The text to display in the view when there is no data to display (defaults to '').
     *
     * @param emptyText the empty text
     */
    public void setEmptyText(String emptyText) {
        setAttribute("emptyText", emptyText, true, true);
    }

    /**
     * A CSS selector in any format supported by {@link com.gwtext.client.core.DomQuery} that will be used to determine
     * what nodes this DataView will be working with.
     *
     * @param itemSelector the items selector
     */
    public void setItemSelector(String itemSelector) {
        setAttribute("itemSelector", itemSelector, true);
    }

    /**
     * A string to display during data load operations (defaults to undefined). If specified, this text will be displayed
     * in a loading div and the view's contents will be cleared while loading, otherwise the view's contents will continue
     * to display normally until the new data is loaded and the contents are replaced.
     *
     * @param loadingText the loading text
     */
    public void setLoadingText(String loadingText) {
        setAttribute("loadingText", loadingText, true);
    }

    /**
     * True to allow selection of more than one item at a time, false to allow selection of only a single item at a time
     * or no selection at all, depending on the value of singleSelect (defaults to false).
     *
     * @param multiSelect true to allow multiple selections
     */
    public void setMultiSelect(boolean multiSelect) {
        setAttribute("multiSelect", multiSelect, true);
    }

    /**
     * A CSS class to apply to each item in the view on mouseover (defaults to undefined).
     *
     * @param overCls a CSS class to apply to each item in the view on mouseover (defaults to undefined).
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setOverCls(String overCls) throws IllegalStateException {
        setAttribute("overClass", overCls, true);
    }

    /**
     * True to enable multiselection by clicking on multiple items without requiring the user to hold Shift or Ctrl,
     * false to force the user to hold Ctrl or Shift to select more than on item (defaults to false).
     *
     * @param simpleSelect true to enable multiselection by clicking on multiple items without requiring the user to hold Shift or Ctrl
     */
    public void setSimpleSelect(boolean simpleSelect) {
        setAttribute("simpleSelect", simpleSelect, true, true);
    }

    /**
     * True to allow selection of exactly one item at a time, false to allow no selection at all (defaults to false).
     * Note that if multiSelect = true, this value will be ignored.
     *
     * @param singleSelect true to allow selection of exactly one item at a time, false to allow no selection at all
     */
    public void setSingleSelect(boolean singleSelect) {
        setAttribute("singleSelect", singleSelect, true, true);
    }

    /**
     * The {@link Store} to bind this DataView to.
     *
     * @param store the Ext.data.Store to bind this DataView to.
     */
    public void setStore(Store store) {
        if (!isRendered()) {
            setAttribute("store", store.getJsObj(), true);
        } else {
            setStoreRendered(store.getJsObj());
        }
    }

    private native void setStoreRendered(JavaScriptObject storeJS) /*-{
        var dv  = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        dv.setStore(storeJS);
    }-*/;

    /**
     * An XTemplate constructed with the the HTML fragment or an array of fragments that will make up the template used
     * by this DataView.
     *
     * @param tpl the DataView tempalte
     */
    public void setTpl(XTemplate tpl) {
        setAttribute("tpl", tpl.getJsObj(), true, true);
    }


    public static class Data extends GenericConfig {
        public static Data instance(JavaScriptObject jsObj) {
            return new Data(jsObj);
        }

        private Data(JavaScriptObject jsObj) {
            this.jsObj = jsObj;
        }
    }
}
