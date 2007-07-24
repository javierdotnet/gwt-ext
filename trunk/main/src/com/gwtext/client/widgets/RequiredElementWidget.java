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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.core.BaseConfig;

public abstract class RequiredElementWidget extends BaseExtWidget {
    protected String id;
    protected BaseConfig config;

    protected RequiredElementWidget() {
    }

    public RequiredElementWidget(String id) {
        this(id, null);
    }

    protected RequiredElementWidget(String id, BaseConfig config) {
        this.id = id;
        this.config = config;
        if (id != null) {
            Element div = null;
            if(RootPanel.get(id) == null) {
                div = DOM.createDiv();
                DOM.setElementProperty(div, "id", id);
            } else {
                div = DOM.getElementById(id);
            }
            setElement(div);
            RootPanel.get().add(this);
            jsObj = create(id, config == null ? JavaScriptObjectHelper.createObject() : config.getJsObj());
        }
    }

    public RequiredElementWidget(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected abstract JavaScriptObject create(String id, JavaScriptObject config);
}
