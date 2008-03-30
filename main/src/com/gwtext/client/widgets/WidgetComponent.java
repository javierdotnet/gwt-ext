/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 *
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.*;
import com.gwtext.client.util.DOMUtil;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Adapter between GWT {@link com.google.gwt.user.client.ui.Widget}'s and {@link com.gwtext.client.widgets.Component}'s.
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
				widget.removeFromParent();
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
