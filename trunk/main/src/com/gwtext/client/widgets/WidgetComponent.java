/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 
package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.DOM;
import com.gwtext.client.core.*;
import com.gwtext.client.util.DOMUtil;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Adapter between GWT {@link com.google.gwt.user.client.ui.Widget}'s and {@link com.gwtext.client.widgets.Component}'s.
 *
 * @author Sanjiv Jivan
 */
public class WidgetComponent extends BoxComponent {

    public static final String hiddenDivID = "__gwtext_hidden";

    static {
        init();
    }

    private static native void init()/*-{

$wnd.Ext.ux.WidgetComponent = function(config){
    $wnd.Ext.ux.WidgetComponent.superclass.constructor.call(this, config);
};

$wnd.Ext.ux.WidgetComponent = $wnd.Ext.extend($wnd.Ext.BoxComponent, {
    widget : null,
    onRender : function(container, position){

        //a GWT widget must be attached to a GWT Panel for its events to fire.
        var attached = this.widget.@com.google.gwt.user.client.ui.Widget::isAttached()();
        if(!attached) {
            var rp = @com.google.gwt.user.client.ui.RootPanel::get(Ljava/lang/String;)('__gwtext_hidden');
            rp.@com.google.gwt.user.client.ui.HasWidgets::add(Lcom/google/gwt/user/client/ui/Widget;)(this.widget);
        }
        var widgetEl = this.widget.@com.google.gwt.user.client.ui.UIObject::getElement()();
        this.el = $wnd.Ext.get(widgetEl);
        this.el.setVisible(true);
        container.dom.insertBefore(widgetEl, position);
        delete this.widget;
    }

});
$wnd.Ext.reg('gwtwidget', $wnd.Ext.ux.WidgetComponent);
    }-*/;

    public WidgetComponent(Widget widget) {
        createHiddenDiv();
        setWidget(widget);
        setId(DOMUtil.getID(widget));
		addListener("beforedestroy", new Function() {
			public void execute() {
				Widget widget =  (Widget)JavaScriptObjectHelper.getAttributeAsObject(config, "widget");
				if(DOM.getParent(widget.getElement()) != null) {
					widget.removeFromParent();
				}
			}
		});
	}

    public static void createHiddenDiv() {
        ExtElement hiddenDiv = Ext.get(hiddenDivID);
        if (hiddenDiv == null) {
            DomConfig domConfig = new DomConfig("div", hiddenDivID, null);
            domConfig.setStyle("display:none;");
            DomHelper.append(RootPanel.getBodyElement(), domConfig);
        }
    }

    public WidgetComponent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public void setWidget(Widget widget) {
        JavaScriptObjectHelper.setAttribute(config, "widget", widget);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.ux.WidgetComponent(config);
    }-*/;

    public String getXType() {
        return "gwtwidget";
    }
}
