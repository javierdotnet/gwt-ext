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

/**
 * Provides global access to LayoutDialogs that have been created and support for z-indexing (layering) multiple open dialogs.
 */
public class DialogManager {

    /**
     * The starting z-index for BasicDialogs (defaults to 9000)
     *
     * @param zseed the z seed
     */
    public static native void setZseed(int zseed)/*-{
        $wnd.Ext.DialogManager.zseed = zseed;
    }-*/;

    /**
     * Brings the specified dialog to the front.
     *
     * @param id the dialog ID
     */
    public static native void bringToFront(String id)/*-{
        $wnd.Ext.DialogManager.bringToFront(id);
    }-*/;

    /**
     * Gets a registered dialog by id.
     * 
     * @param id the dialog ID
     * @return the dialog
     */
    public static native LayoutDialog get(String id)/*-{
        var dlg = $wnd.Ext.DialogManager.get(id);
        return @com.gwtext.client.widgets.LayoutDialog::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(dlg);
    }-*/;

    /**
     * Hides all dialogs.
     */
    public static native void hideAll()/*-{
        $wnd.Ext.DialogManager.hideAll();
    }-*/;

    /**
     * Sends the specified dialog to the back.
     *
     * @param id the dialog ID
     */
    public static native void sendToBack(String id)/*-{
        $wnd.Ext.DialogManager.sendToBack(id);
    }-*/;
}
