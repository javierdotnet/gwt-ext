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
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.ExtElement;

public abstract class BaseExtWidget extends Widget {

    protected JavaScriptObject jsObj;

    protected BaseExtWidget() {
    }

    protected BaseExtWidget(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
        setElement(getElement(this.jsObj));
    }

    public JavaScriptObject getJsObj() {
        return jsObj;
    }

    public void setJsObj(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    public ExtElement getEl() {
        return jsObj == null ? null : new ExtElement(getElement());
    }

    //jsObj is JS object representing the UI Widget
    //jsObj.el is the ExtElement of the Widget
    //jsObj.el.dom is the DOM Element of the widget
    private native Element getElement(JavaScriptObject jsObj) /*-{
        var el = jsObj.el;
        if(el === undefined) {
            return null;
        } else {
             return el.dom;
        }
    }-*/;

    protected void onLoad() {
        if (getElement() == null) {
            setElement(getElement(jsObj));
        }
    }

    public Element getElement() {
        if (super.getElement() == null) {
            setElement(getElement(jsObj));
        }
        return super.getElement();
    }

    public int getOffsetHeight() {
        return DOM.getElementPropertyInt(getElement(), "offsetHeight");
    }

    public int getOffsetWidth() {
        return DOM.getElementPropertyInt(getElement(), "offsetWidth");
    }

    protected Element getStyleElement() {
        return getElement();
    }

    public String getTitle() {
        return DOM.getElementProperty(getElement(), "title");
    }

    public boolean isVisible() {
        return isVisible(getElement());
    }

    public native void purgeListeners() /*-{
        var widget = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        widget.purgeListeners();
    }-*/;
        
    public void setHeight(String height) {
        // This exists to deal with an inconsistency in IE's implementation where
        // it won't accept negative numbers in length measurements
        assert extractLengthValue(height.trim().toLowerCase()) >= 0 :
                "CSS heights should not be negative";
        DOM.setStyleAttribute(getElement(), "height", height);
    }

    private native double extractLengthValue(String s) /*-{
    if (s == "auto" || s == "inherit" || s == "") {
      return 0;
    } else {
      return parseFloat(s);
    }
  }-*/;

    public void setTitle(String title) {
        if (title == null || title.length() == 0) {
            DOM.removeElementAttribute(getElement(), "title");
        } else {
            DOM.setElementAttribute(getElement(), "title", title);
        }
    }

    public void setVisible(boolean visible) {
        setVisible(getElement(), visible);
    }

    public void setWidth(String width) {
        // This exists to deal with an inconsistency in IE's implementation where
        // it won't accept negative numbers in length measurements
        assert extractLengthValue(width.trim().toLowerCase()) >= 0 :
                "CSS widths should not be negative";
        DOM.setStyleAttribute(getElement(), "width", width);
    }

    public String toString() {
        if (getElement() == null) {
            return "(null handle)";
        }
        return DOM.toString(getElement());
    }
}
