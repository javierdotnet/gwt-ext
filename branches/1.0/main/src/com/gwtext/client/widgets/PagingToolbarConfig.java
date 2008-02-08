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

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Configuration class for {@link com.gwtext.client.widgets.PagingToolbar}.
 *
 */
public class PagingToolbarConfig extends BaseConfig {

	/**
	 * The paging status message to display (defaults to "Displaying {start} - {end} of {total}")
	 *
	 * @param displayMsg the display message
	 */
	public void setDisplayMsg(String displayMsg) {
        JavaScriptObjectHelper.setAttribute(jsObj, "displayMsg", displayMsg);
    }

	/**
	 * The message to display when no records are found (defaults to "No data to display").
	 *
	 * @param emptyMsg the empty message
	 */
	public void setEmptyMsg(String emptyMsg) {
        JavaScriptObjectHelper.setAttribute(jsObj, "emptyMsg", emptyMsg);
    }

	/**
	 * The number of records to display per page (defaults to 20).
	 *
	 * @param pageSize the page size
	 */
	public void setPageSize(int pageSize) {
        JavaScriptObjectHelper.setAttribute(jsObj, "pageSize", pageSize);
    }

	/**
	 * True to display the displayMsg (defaults to false).
	 *
	 * @param displayInfo the display message
	 */
	public void setDisplayInfo(boolean displayInfo) {
        JavaScriptObjectHelper.setAttribute(jsObj, "displayInfo", displayInfo);
    }
}
