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

package com.gwtext.client.data;

import com.gwtext.client.core.JsObject;


/**
 * This class is an abstract base class for implementations which provide retrieval of unformatted data objects.
 * DataProxy implementations are usually used in conjunction with an implementation of {@link com.gwtext.client.data.Reader}
 * (of the appropriate type which knows how to parse the data object) to provide a block of {@link com.gwtext.client.data.Record}'s
 *  to a {@link Store}.
 *
 * @author Sanjiv Jivan
 * @since 0.9
 * @see com.gwtext.client.data.Reader
 * @see com.gwtext.client.data.Record
 * @see Store
 */
public abstract class DataProxy extends JsObject {

//Store has events for beforeload, load and load exeption events
//Also DataProxy implementation here does not have load() method because this is typically called by store.load()
//instead of being invoked directly

}
