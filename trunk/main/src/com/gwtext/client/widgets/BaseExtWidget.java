/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.ExtElement;

/**
 * Base abstract Widget class.
 */
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
        if(jsObj == null || getElement() == null) {
			return   null;
		} else {
			 return new ExtElement(getElement());
		}
    }
    
    //jsObj is JS object representing the UI Widget
    //jsObj.el is the ExtElement of the Widget
    //jsObj.el.dom is the DOM Element of the widget
    protected native Element getElement(JavaScriptObject jsObj) /*-{
        //var el = jsObj.el;
        var el = jsObj.getEl().dom;
        if(el == null || el === undefined) {
            return null;
            //forms buttons are detached when initially added
            //throw new Error('Widget ' + jsObj + ' has no element property set');
        } else {
            //There's an inconsistency in Ext where most elements have the property 'el' set to Ext's Element
            //with the exception of Menu->Item, Menu->Separator, Menu->TextItem,  Toolbar.Item and subclasses
            //(Toolbar.Separator, Toolbar.Spacer, Toolbar.TextItem) where the 'el' property is set to
            //the DOM element itself. Therefore retruning 'el' if 'el' is not Ext's Element. See details in issue 39.
             return el.dom || el ;
        }
    }-*/;

    protected void onLoad() {
        if (getElement() == null) {
            setElement(getElement(jsObj));
        }
    }

	protected void onAttach() {
		super.onAttach();
	}


	/*protected void onAttach() {
		super.onAttach();
		Widget parent = getParent();
		if(!isRendered()) {
			render(parent.getElement());
		}

	}
	*/
	/*public Element getElement() {
        if (super.getElement() == null) {
		if(!isRendered()) {
			render(parent.getElement());
		}
			setElement(getElement(jsObj));
        }
        return super.getElement();
    }*/

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
        var widget = this.@com.gwtext.client.widgets.Component::getJsObj()();
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

    public boolean equals(Object obj) {
        if (obj instanceof BaseExtWidget) {
            return getElement().equals(((BaseExtWidget) obj).getElement());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getElement().hashCode();
    }

    public String toString() {
        return "element";
        /*if (getElement() == null) {
            return "(null handle)";
        }
        return DOM.toString(getElement());*/
    }
}
