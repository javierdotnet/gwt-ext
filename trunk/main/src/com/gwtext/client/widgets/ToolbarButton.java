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
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.event.ButtonListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//toolbar button doesnt get rendered and even created when a new object is instantiated. it is rendered at the point it
//is added to the toolbar. so we cant register the event handlers with the underlying widget until it is rendered

//ie. after it has been added to the toolbar
public class ToolbarButton extends Button {

    private boolean rendered;
    private List listeners;

    public ToolbarButton(ButtonConfig config) {
        this(null, config);
    }

    public ToolbarButton(String label, ButtonConfig config) {
        super(null, config);
        if (label != null) JavaScriptObjectHelper.setAttribute(config.getJsObj(), "text", label);
        jsObj = create(null, config.getJsObj());
        if (listeners == null) {
            listeners = new ArrayList();
        }
    }

    protected native JavaScriptObject create(String id, JavaScriptObject config) /*-{
        return new $wnd.Ext.Toolbar.Button(config);
    }-*/;


    void registerEventHandlers() {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext();) {
            ButtonListener buttonListener = (ButtonListener) iterator.next();
            super.addButtonListener(buttonListener);
        }
        listeners.clear();
    }

    void setRendered(boolean rendered) {
        this.rendered = rendered;
    }


    public void addButtonListener(ButtonListener listener) {
        if (!rendered) {
            if (listeners == null) {
                listeners = new ArrayList();
            }
            listeners.add(listener);
        } else {
            super.addButtonListener(listener);
        }
    }
}
