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

import com.gwtext.client.core.Function;

public class ComponentMgr {

    public native Component get(String id)/*-{
        var comp = $wnd.Ext.ComponentMgr.get(id);
        if(comp == null) {
            return null;
        } else {
            return @com.gwtext.client.widgets.Component::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(comp);
        }
    }-*/;

    public native void onAvailable(String id, Function fn)/*-{
        $wnd.Ext.ComponentMgr.onAvailable(id, function() {
            fn.@com.gwtext.client.core.Function::execute()();
        });
    }-*/;
}
