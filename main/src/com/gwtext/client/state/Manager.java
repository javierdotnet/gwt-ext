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
