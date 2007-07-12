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

public class DialogManager {
    public static native void setZseed(int zseed)/*-{
        $wnd.Ext.DialogManager.zseed = zseed;
    }-*/;

    public static native void bringToFront(String id)/*-{
        $wnd.Ext.DialogManager.bringToFront(id);
    }-*/;

    public static native LayoutDialog get(String id)/*-{
        var dlg = $wnd.Ext.DialogManager.get(id);
        return @com.gwtext.client.widgets.LayoutDialog::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(dlg);
    }-*/;

    public static native void hideAll()/*-{
        $wnd.Ext.DialogManager.hideAll();
    }-*/;

    public static native void sendToBack(String id)/*-{
        $wnd.Ext.DialogManager.sendToBack(id);
    }-*/;
}
