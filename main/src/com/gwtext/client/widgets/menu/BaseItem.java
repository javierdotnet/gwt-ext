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

package com.gwtext.client.widgets.menu;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.menu.event.BaseItemListener;

//todo - only reason non abstract because menu item click event returns a base item and need to instanticte

//node baselem return null for getEl()
public class BaseItem extends Component {

    public BaseItem() {
    }

    public BaseItem(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public BaseItem(BaseItemConfig config) {
        setJsObj(create(config.getJsObj()));
        if (config.getBaseItemListener() != null) {
            addBaseItemListener(config.getBaseItemListener());
        }
    }

    private static BaseItem instance(JavaScriptObject jsObj) {
        return new BaseItem(jsObj);
    }

    public native void addBaseItemListener(BaseItemListener listener)/*-{
        var baseItem = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var baseItemJ = this;

        baseItem.addListener('click',
                function(source, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    return listener.@com.gwtext.client.widgets.menu.event.BaseItemListener::onClick(Lcom/gwtext/client/widgets/menu/BaseItem;Lcom/gwtext/client/core/EventObject;)(baseItemJ, e);
                }
        );
        baseItem.addListener('deactivate',
                function(source) {
                    return listener.@com.gwtext.client.widgets.menu.event.BaseItemListener::onDeactivate(Lcom/gwtext/client/widgets/menu/BaseItem;)(baseItemJ);
                }
        );
     }-*/;

    protected JavaScriptObject create(JavaScriptObject config) {
        throw new IllegalArgumentException("mut be overridden");
    }
}
