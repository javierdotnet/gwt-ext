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
import com.gwtext.client.widgets.event.MenuButtonListener;
import com.gwtext.client.widgets.menu.Menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//toolbar button doesnt get rendered and even created when a new object is instantiated. it is rendered at the point it
//is added to the toolbar. so we cant register the event handlers with the underlying widget until it is rendered

//ie. after it has been added to the toolbar
public class ToolbarMenuButton extends SplitButton {

    private boolean rendered;
    private List menuButtonListeners;
    private List buttonListeners;

    public ToolbarMenuButton(Menu menu, SplitButtonConfig config) {
        this(null, menu, config);
    }

    public ToolbarMenuButton(String label, Menu menu) {
        this(label, menu, new SplitButtonConfig());
    }

    public ToolbarMenuButton(String label, Menu menu, SplitButtonConfig config) {
        super(null, config);
        JavaScriptObjectHelper.setAttribute(config.getJsObj(), "menu", menu.getJsObj());
        if (label != null) JavaScriptObjectHelper.setAttribute(config.getJsObj(), "text", label);
        jsObj = create(null, config.getJsObj());
        if (menuButtonListeners == null) {
            menuButtonListeners = new ArrayList();
        }
        if (buttonListeners == null) {
            buttonListeners = new ArrayList();
        }
    }

    protected native JavaScriptObject create(String id, JavaScriptObject config) /*-{
        return new $wnd.Ext.Toolbar.MenuButton(config);
    }-*/;

    void registerEventHandlers() {
        for (Iterator iterator = menuButtonListeners.iterator(); iterator.hasNext();) {
            MenuButtonListener buttonListener = (MenuButtonListener) iterator.next();
            super.addMenuButtonListener(buttonListener);
        }
        menuButtonListeners.clear();

        for (Iterator iterator = buttonListeners.iterator(); iterator.hasNext();) {
            ButtonListener buttonListener = (ButtonListener) iterator.next();
            super.addButtonListener(buttonListener);
        }
        buttonListeners.clear();
    }

    void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    public void addMenuButtonListener(MenuButtonListener listener) {
        if (!rendered) {
            if (menuButtonListeners == null) {
                menuButtonListeners = new ArrayList();
            }
            menuButtonListeners.add(listener);
        } else {
            super.addMenuButtonListener(listener);
        }
    }

    public void addButtonListener(ButtonListener listener) {
        if (!rendered) {
            if (buttonListeners == null) {
                buttonListeners = new ArrayList();
            }
            buttonListeners.add(listener);
        } else {
            super.addButtonListener(listener);
        }
    }
}
