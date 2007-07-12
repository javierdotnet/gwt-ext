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

package com.gwtext.client;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.UIObject;

//Original Authod SeanC
//http://groups.google.com/group/Google-Web-Toolkit/browse_frm/thread/ecb25ba44760c88c/b09cea646cecef59?lnk=gst&q=eventutils&rnum=1&hl=en#b09cea646cecef59

public class EventUtils {

    public static void sendClickEvent(UIObject componentToClick) {
        fireClickEvent(componentToClick.getElement());
    }

    /**
     * requires Internet Explorer 5.5 or later.
     */
    public static void sendDoubleClickEvent(UIObject componentToDoubleClick) {
        fireDoubleClickEvent(componentToDoubleClick.getElement());
    }

    /**
     * requires Internet Explorer 5.5 or later.
     */
    public static void sendMouseOverEvent(UIObject componentToMouseOver) {
        fireMouseOverEvent(componentToMouseOver.getElement());
    }

    /**
     * requires Internet Explorer 5.5 or later.
     */
    public static void sendFocusEvent(UIObject componentToFocus) {
        fireFocusEvent(componentToFocus.getElement());
    }

    /**
     * requires Internet Explorer 5.5 or later.
     */
    public static void sendChangeEvent(UIObject componentChanged) {
        fireChangeEvent(componentChanged.getElement());
    }

    /**
     * requires Internet Explorer 5.5 or later.
     */
    public static void sendEnterKeyPressEvent(UIObject componentToKeyPressOn) {
        fireEnterKeyPressEvent(componentToKeyPressOn.getElement());
    }

    static native void fireClickEvent(Element elementToClick)/*-{
         elementToClick.click();
         }-*/;

    static native void fireDoubleClickEvent(Element elementToDoubleClick)/*-{
         var newEvent = $doc.createEventObject();
         elementToDoubleClick.fireEvent("ondblclick", newEvent);
         }-*/;

    static native void fireMouseOverEvent(Element elementToMouseOver)/*-{
         var newEvent = $doc.createEventObject();
         elementToMouseOver.fireEvent("onmouseover", newEvent);
         }-*/;

    static native void fireFocusEvent(Element elementToFocus) /*-{
         var newEvent = $doc.createEventObject();
         elementToFocus.fireEvent("onfocus", newEvent);
         }-*/;

    static native void fireChangeEvent(Element elementChanged) /*-{
         var newEvent = $doc.createEventObject();
         elementChanged.fireEvent("onchange", newEvent);
         }-*/;

    static native void fireEnterKeyPressEvent(Element elementToKeyPressOn) /*-{
         var newEvent = $doc.createEventObject();
         newEvent.keyCode = 13;
         elementToKeyPressOn.fireEvent("onkeypress", newEvent);
    }-*/;
}
