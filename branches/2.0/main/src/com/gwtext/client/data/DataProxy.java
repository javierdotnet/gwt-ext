/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.data;

import com.gwtext.client.core.JsObject;


/**
 * This class is an abstract base class for implementations which provide retrieval of unformatted data objects.
 * DataProxy implementations are usually used in conjunction with an implementation of {@link com.gwtext.client.data.Reader}
 * (of the appropriate type which knows how to parse the data object) to provide a block of {@link com.gwtext.client.data.Record}'s
 * to a {@link Store}.
 *
 * @author Sanjiv Jivan
 * @see com.gwtext.client.data.Reader
 * @see com.gwtext.client.data.Record
 * @see Store
 * @since 0.9
 */
public abstract class DataProxy extends JsObject {

//Store has events for beforeload, load and load exeption events
//Also DataProxy implementation here does not have load() method because this is typically called by store.load()
//instead of being invoked directly

}
