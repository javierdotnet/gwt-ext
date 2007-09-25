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

package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.JsObject;

public class TreeNodeUI extends JsObject {

    public TreeNodeUI(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static TreeNodeUI instance(JavaScriptObject jsObj) {
        return new TreeNodeUI(jsObj);
    }

    public native void addClass(String cls) /*-{
        var ui = this.@com.gwtext.client.core.JsObject::jsObj;
        ui.addClass(cls);
    }-*/;

    public native void removeClass(String cls) /*-{
        var ui = this.@com.gwtext.client.core.JsObject::jsObj;
        ui.removeClass(cls);
    }-*/;

    public native void hide() /*-{
        var ui = this.@com.gwtext.client.core.JsObject::jsObj;
        ui.hide();
    }-*/;

    public native void show() /*-{
        var ui = this.@com.gwtext.client.core.JsObject::jsObj;
        ui.show();
    }-*/;

    public native void toggleCheck() /*-{
        var ui = this.@com.gwtext.client.core.JsObject::jsObj;
        ui.toggleCheck();
    }-*/;

    public native void toggleCheck(boolean value) /*-{
        var ui = this.@com.gwtext.client.core.JsObject::jsObj;
        ui.toggleCheck(value);
    }-*/;

    public native void highlight() /*-{
        var ui = this.@com.gwtext.client.core.JsObject::jsObj;
        ui.highlight();
    }-*/;

    /**
     * This returns an element that represents the whole subtree starting with itselt as the
     * current node. The returned element has wtoe children. The first child represents its
     * node, and is what is returned when getElNode() is called. The second child containts
     * an array of its child elements.
     */
    public native Element getEl() /*-{
         var ui = this.@com.gwtext.client.core.JsObject::jsObj;
         return ui.getEl();
    }-*/;

    /**
     * Element for 'this' node.
     */
    public native Element getElNode()/*-{
        var ui = this.@com.gwtext.client.core.JsObject::jsObj;
        return ui.elNode;
     }-*/;

    public native boolean isChecked() /*-{
        var ui = this.@com.gwtext.client.core.JsObject::jsObj;
        return ui.isChecked();
     }-*/;
}
