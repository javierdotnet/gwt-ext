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
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * A specialized toolbar that is bound to a {@link Store} and provides automatic paging controls.
 */
public class PagingToolbar extends Toolbar {

	/**
	 * Construct a new PagingToolbar.
	 *
	 * @param container the element that will contain the toolbar
	 * @param store the underlying data store providing the paged data
	 * @param config the config object
	 */
	public PagingToolbar(ExtElement container, Store store, PagingToolbarConfig config) {
        jsObj = create(container.getJsObj(), store.getJsObj(), config.getJsObj());
    }

    private native JavaScriptObject create(JavaScriptObject container, JavaScriptObject store, JavaScriptObject config) /*-{
        return new $wnd.Ext.PagingToolbar(container, store, config);
    }-*/;

	/**
	 * Binds the paging toolbar to the specified Store.
	 *
	 * @param store the Store to bind to
	 */
	public native void bind(Store store) /*-{
		var pagingToolbar = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
		var storeJS = store.@com.gwtext.client.core.JsObject::jsObj;
		pagingToolbar.bind(storeJS);
	}-*/;

	/**
	 * Customizable piece of the default paging text (defaults to "of %0").
	 *
	 * @param afterPageText the after page text
	 */
	public void setAfterPageText(String afterPageText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "afterPageText", afterPageText);
    }

	/**
	 * Customizable piece of the default paging text (defaults to "Page").
	 *
	 * @param beforePageText the before page text
	 */
	public void setBeforePageText(String beforePageText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "beforePageText", beforePageText);
    }

	/**
	 * Customizable piece of the default paging text (defaults to "First Page").
	 *
	 * @param firstText the first text
	 */
	public void setFirstText(String firstText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "firstText", firstText);
    }

	/**
	 * Customizable piece of the default paging text (defaults to "Last Page").
	 * 
	 * @param lastText the last text
	 */
	public void setLastText(String lastText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "lastText", lastText);
    }

	/**
	 * Customizable piece of the default paging text (defaults to "Next Page").
	 * 
	 * @param nextText the next text
	 */
	public void setNextText(String nextText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "nextText", nextText);
    }

	/**
	 * Customizable piece of the default paging text (defaults to "Previous Page")
	 * 
	 * @param prevText the previous text
	 */
	public void setPrevText(String prevText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "prevText", prevText);
    }

	/**
	 * Customizable piece of the default paging text (defaults to "Refresh").
	 * 
	 * @param refreshText the refresh text
	 */
	public void setRefreshText(String refreshText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "refreshText", refreshText);
    }

	/**
	 *  Unbinds the paging toolbar from the specified Store.
	 *
	 * @param store the store 
	 */
	public native void unbind(Store store) /*-{
		var pagingToolbar = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
		var storeJS = store.@com.gwtext.client.core.JsObject::jsObj;
		pagingToolbar.unbind(storeJS);
	}-*/;
}
