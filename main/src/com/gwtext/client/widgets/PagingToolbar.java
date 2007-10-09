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

public class PagingToolbar extends Toolbar {

    public PagingToolbar(ExtElement container, Store store, PagingToolbarConfig config) {
        jsObj = create(container.getJsObj(), store.getJsObj(), config.getJsObj());
    }

    private native JavaScriptObject create(JavaScriptObject container, JavaScriptObject store, JavaScriptObject config) /*-{
        return new $wnd.Ext.PagingToolbar(container, store, config);
    }-*/;

    public native void bind(Store store) /*-{
		var pagingToolbar = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
		var storeJS = store.@com.gwtext.client.core.JsObject::jsObj;
		pagingToolbar.bind(storeJS);
	}-*/;

    public void setAfterPageText(String afterPageText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "afterPageText", afterPageText);
    }

    public void setBeforePageText(String beforePageText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "beforePageText", beforePageText);
    }

    public void setFirstText(String firstText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "firstText", firstText);
    }

    public void setLastText(String lastText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "lastText", lastText);
    }

    public void setNextText(String nextText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "nextText", nextText);
    }

    public void setPrevText(String prevText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "prevText", prevText);
    }

    public void setRefreshText(String refreshText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "refreshText", refreshText);
    }

    public native void unbind(Store store) /*-{
		var pagingToolbar = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
		var storeJS = store.@com.gwtext.client.core.JsObject::jsObj;
		pagingToolbar.unbind(storeJS);
	}-*/;
}
