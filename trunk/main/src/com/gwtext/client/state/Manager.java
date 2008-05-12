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
 

package com.gwtext.client.state;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * This is the global state manager. By default all components that are "state aware" check this class for state information
 * if you don't pass them a custom state provider. In order for this class to be useful, it must be initialized with a
 * provider when your application initializes.
 *
 * @author Sanjiv Jivan
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
