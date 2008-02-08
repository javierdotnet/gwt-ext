/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.state;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The default Provider implementation which saves state via cookies.
 * <p/>
 * Usage :
 * <pre>
 * CookieProvider cp = new CookieProvider(...);
 * Manager.setProvider(cp);
 * </pre>
 *
 * @see com.gwtext.client.state.Manager
 */
public class CookieProvider extends Provider {

    public CookieProvider() {
        jsObj = create();
    }

    /**
     * Creates a new Cookieprovider using the specified configuration.
     *
     * @param config the configuration
     */
    public CookieProvider(CookieProviderConfig config) {
        jsObj = create(config.getJsObj());
    }

    private native JavaScriptObject create() /*-{
        return new $wnd.Ext.state.CookieProvider();    
    }-*/;

    private native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.state.CookieProvider(config);    
    }-*/;
}
