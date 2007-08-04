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
import com.gwtext.client.widgets.menu.event.CheckItemListener;

public class CheckItem extends Item {

    public CheckItem(CheckItemConfig config) {
        super(config);
        if (config.getCheckItemListener() != null) {
            addCheckItemListener(config.getCheckItemListener());
        }
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
        return new $wnd.Ext.menu.CheckItem(jsObj);
    }-*/;

    public native void setChecked(boolean checked) /*-{
        var checkItem = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        checkItem.setChecked(checked);
    }-*/;

    public native void addCheckItemListener(CheckItemListener listener)/*-{
        var checkItem = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var checkItemJ = this;

        checkItem.addListener('beforecheckchange',
                function(source, checked) {
                    return listener.@com.gwtext.client.widgets.menu.event.CheckItemListener::doBeforeCheckChange(Lcom/gwtext/client/widgets/menu/CheckItem;Z)(checkItemJ, checked);
                }
        );
        checkItem.addListener('checkchange',
                function(source, checked) {
                    listener.@com.gwtext.client.widgets.menu.event.CheckItemListener::onCheckChange(Lcom/gwtext/client/widgets/menu/CheckItem;Z)(checkItemJ, checked);
                }
        );
     }-*/;
}
