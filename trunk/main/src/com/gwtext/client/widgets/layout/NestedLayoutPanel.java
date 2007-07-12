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

package com.gwtext.client.widgets.layout;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;

//NOTE: You must add ContentPanels to the inner BorderLayout only after constructing the NestedLayouyPanel with the BorderLayout
public class NestedLayoutPanel extends ContentPanel {

    public NestedLayoutPanel(BorderLayout borderLayout, final String title) {
        this(borderLayout, new ContentPanelConfig() {
            {
                setTitle(title);
            }
        });
    }

    public NestedLayoutPanel(BorderLayout borderLayout, ContentPanelConfig config) {
        if (borderLayout.getHasContentPanel()) {
            throw new IllegalArgumentException("You must add ContentPanel's to the inner BorderLayout only after constructing the NestedLayouyPanel with the BorderLayout");
        }
        Element div = DOM.createDiv();
        setElement(div);
        DOM.setElementProperty(div, "className", "ylayout-active-content");
        RootPanel.get().add(this);
        jsObj = create(borderLayout.getJsObj(), config.getJsObj());
    }

    private static native JavaScriptObject create(JavaScriptObject borderLayout, JavaScriptObject config)/*-{
        return new $wnd.Ext.NestedLayoutPanel(borderLayout, config);
    }-*/;

    protected native JavaScriptObject create(JavaScriptObject borderLayout, String title)/*-{
        return new $wnd.Ext.NestedLayoutPanel(borderLayout, title);
    }-*/;

    public BorderLayout getLayout() {
        return new BorderLayout(getLayout(getJsObj()));
    }

    private static native JavaScriptObject getLayout(JavaScriptObject nestedPanel)/*-{
        return nestedPanel.getLayout();
    }-*/;
}
