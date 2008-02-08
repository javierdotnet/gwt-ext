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
 * This is the global state manager. By default all components that are "state aware" check this class for state information
 * if you don't pass them a custom state provider. In order for this class to be useful, it must be initialized with a
 * provider when your application initializes.
 */
public class Manager {

    /**
     * Configures the default state provider for your application.
     *
     * @param provider the provider
     */
    public static void setProvider(Provider provider) {
        setProvider(provider.getJsObj());
    }

    private static native void setProvider(JavaScriptObject jsObj) /*-{
        $wnd.Ext.state.Manager.setProvider(jsObj);    
    }-*/;
}
