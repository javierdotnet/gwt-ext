/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * A specialized toolbar that is bound to a {@link Store} and provides automatic paging controls.
 */
public class PagingToolbar extends Toolbar {

    private Store store;
/*	private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()*//*-{
        var c = new $wnd.Ext.PagingToolbar();
        @com.gwtext.client.widgets.PagingToolbar::configPrototype = c.initialConfig;
    }-*//*;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}*/

    public String getXType() {
        return "paging";
    }

    /**
     * Create a new PagingToolbar.
     */
    public PagingToolbar() {
    }

    /**
     * Create a new PagingToolbar.
     *
     * @param store the underlying Store
     */
    public PagingToolbar(Store store) {
        setStore(store);
    }

    public PagingToolbar(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.PagingToolbar(config);
    }-*/;

    /**
     * Binds the paging toolbar to the specified Store.
     *
     * @param store the Store to bind to
     */
    public void bind(Store store) {
        if(!isCreated()) {
            setStore(store);
        } else {
            bindCreated(store);
        }
    }

    private native void bindCreated(Store store) /*-{
		var pagingToolbar = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		var storeJS = store.@com.gwtext.client.core.JsObject::getJsObj()();
		pagingToolbar.bind(storeJS);
	}-*/;

    /**
     * Unbinds the paging toolbar from the specified Store.
     *
     * @param store the store
     */
    public void unbind(Store store)  {
        if(!isCreated()) {
            setStore(null);
        } else {
            unbindCreated(store);
        }
    }

    private  native void unbindCreated(Store store) /*-{
		var pagingToolbar = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		var storeJS = store.@com.gwtext.client.core.JsObject::getJsObj()();
		pagingToolbar.unbind(storeJS);
	}-*/;

    private native void updateInfo() /*-{
		var pagingToolbar = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		pagingToolbar.updateInfo();
	}-*/;

    // --- config properties ---

    /**
     * The paging status message to display (defaults to "Displaying {start} - {end} of {total}").
     *
     * @param displayMsg the display message
     */
    public void setDisplayMsg(String displayMsg)  {
        setAttribute("displayMsg", displayMsg, true, true);
    }

    /**
     * The paging status message to display (defaults to "Displaying {start} - {end} of {total}").
     *
     * @return the display message
     */
    public String getDisplayMsg() {
        return getAttribute("displayMsg");
    }

    /**
     * The message to display when no records are found (defaults to "No data to display").
     *
     * @param emptyMsg the empty message
     */
    public void setEmptyMsg(String emptyMsg) {
        setAttribute("emptyMsg", emptyMsg, true, true);
    }

    /**
     * @return the message dispalyed when no records are found
     */
    public String getEmptyMsg() {
        return getAttribute("emptyMsg");
    }

    /**
     * The number of records to display per page (defaults to 20).
     *
     * @param pageSize the page size
     */
    public void setPageSize(int pageSize) {
        if (isRendered()) {
            setPageSizeRendered(pageSize);
        } else {
            setAttribute("pageSize", pageSize, true);
        }
    }

    /**
     * The number of records to display per page (defaults to 20).
     *
     * @return the page size
     */
    public int getPageSize() {
        if(isRendered()) {
           return getPageSizeRendered();
        } else {
            return JavaScriptObjectHelper.getAttributeAsInt(config, "pageSize");
        }
    }

    //http://extjs.com/forum/showthread.php?p=101628
    private native void setPageSizeRendered(int pageSize) /*-{
		var pagingToolbar = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();

        pagingToolbar.pageSize = pageSize;
        pagingToolbar.updateInfo();
        if(pagingToolbar.displayEl) {
            var d = pagingToolbar.getPageData();
            pagingToolbar.afterTextEl.el.innerHTML = $wnd.String.format(pagingToolbar.afterPageText, d.pages);
        }
        pagingToolbar.doLoad(Math.floor(pagingToolbar.cursor/pagingToolbar.pageSize) * pagingToolbar.pageSize);
    }-*/;

    private native int getPageSizeRendered() /*-{
		var pagingToolbar = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return pagingToolbar.pageSize;
    }-*/;

	/**
	 * Return the current page number.
	 *
	 * @return the current page. The first page starts at 1
	 */
	public int getCurrentPage() {
        if(isRendered()) {
           return getCurrentPageRendered();
        } else {
            return 1;
        }
    }

    private native int getCurrentPageRendered() /*-{
		var pagingToolbar = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return pagingToolbar.getPageData().activePage;
    }-*/;

	/**
     * True to display the displayMsg (defaults to false).
     *
     * @param displayInfo the display message
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setDisplayInfo(boolean displayInfo) throws IllegalStateException {
        setAttribute("displayInfo", displayInfo, true);
    }

    /**
     * True to display the displayMsg.
     *
     * @return true to display the info
     */
    public boolean getDisplayInfo() {
        return getAttributeAsBoolean("displayInfo");
    }

    /**
     * Set the Store for the PagingToolbar.
     *
     * @param store the store
     */
    public void setStore(Store store) {
		if(this.store != null) {
			if(isCreated()) {
				unbind(this.store);
				bind(store);
			}
			this.store = store;
		} else {
			this.store = store;
        	setAttribute("store", store.getJsObj(), false);	
		}

    }

    /**
     * Return the Store of the PagingToolbar.
     *
     * @return the store
     */
    public Store getStore() {
        return store;
    }

    /**
     * The before page paging text tooltip (defaults to "First Page")
     *
     * @param beforePageText the before page tooltip
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setBeforePageText(String beforePageText) throws IllegalStateException{
        setAttribute("beforePageText", beforePageText, true);
    }

    /**
     * The before page paging text tooltip (defaults to "First Page")
     *
     * @return the before text tooltip
     */
    public String getBeforePageText() {
        return JavaScriptObjectHelper.getAttribute(config, "beforePageText");
    }

    /**
     * The after page paging text tooltip (defaults to "of %0")
     *
     * @param afterPageText the before page tooltip
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setAfterPageText(String afterPageText) throws IllegalStateException {
        setAttribute("afterPageText", afterPageText, true);
    }

    /**
     * The after page paging text tooltip (defaults to "of %0")
     *
     * @return the after page tooltip
     */
    public String getAfterPageText() {
        return getAttribute("afterPageText");
    }

    /**
     * The first page paging text tooltip (defaults to "First Page")
     *
     * @param firstText the first page tooltip
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setFirstText(String firstText) throws IllegalStateException {
        setAttribute("firstText", firstText, true);
    }

    /**
     * The first page paging text tooltip (defaults to "First Page")
     *
     * @return the after page tooltip
     */
    public String getFirstText() {
        return getAttribute("firstText");
    }

    /**
     * The previous page paging text tooltip (defaults to "Previous Page")
     *
     * @param prevText the first page tooltip
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setPrevText(String prevText) throws IllegalStateException {
        setAttribute("prevText", prevText, true);
    }

    /**
     * The previous page paging text tooltip (defaults to "Previous Page")
     *
     * @return the previous page tooltip
     */
    public String getPrevText() {
        return getAttribute("prevText");
    }

    /**
     * The next page paging text tooltip (defaults to "Next Page")
     *
     * @param nextText the first page tooltip
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setNextText(String nextText) throws IllegalStateException {
        setAttribute("nextText", nextText, true);
    }

    /**
     * The next page paging text tooltip (defaults to "Next Page")
     *
     * @return the next page tooltip
     */
    public String getNextText() {
        return getAttribute("nextText");
    }

    /**
     * The last page paging text tooltip (defaults to "Last Page")
     *
     * @param lastText the first page tooltip
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setLastText(String lastText) throws IllegalStateException {
        setAttribute("lastText", lastText, true);
    }

    /**
     * The last page paging text tooltip (defaults to "Last Page")
     *
     * @return the after page tooltip
     */
    public String getLastText() {
        return getAttribute("lastText");
    }

    /**
     * The refrest page paging text tooltip (defaults to "Refresh")
     *
     * @param refreshText the first page tooltip
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setRefreshText(String refreshText) throws IllegalStateException {
        setAttribute("refreshText", refreshText, true);
    }

    /**
     * The refresh page paging text tooltip (defaults to "Refresh")
     *
     * @return the after page tooltip
     */
    public String getRefreshText() {
        return getAttribute("refreshText");
    }
}
