package com.gwtext.client.widgets.portal;

import com.gwtext.client.core.JsObject;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.widgets.Layer;
import com.gwtext.client.widgets.Panel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

/**
 * This is an internal class.
 *
 * @author Sanjiv Jivan
 */
public class PanelProxy extends JsObject {

    public PanelProxy(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public PanelProxy() {
        jsObj = create(null);
    }

    protected native JavaScriptObject create(JavaScriptObject config)/*-{
        return new $wnd.Ext.dd.PanelProxy(config);
    }-*/;


    private static PanelProxy instance(JavaScriptObject jsObj) {
        return new PanelProxy(jsObj);
    }
    /**
     * Gets the proxy's element
     *
     * @return the The proxy's element
     */
    public native Element getEl() /*-{
        var proxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var el = proxy.getEl();
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Returns the ghost element.
     *
     * @return the ghost element
     */
    public native ExtElement getGhost() /*-{
        var proxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var ghost = proxy.getGhost();
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ghost);
    }-*/;

	public native Panel getPanel() /*-{
        var proxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var panel = proxy.panel;
        return panel == null || panel === undefined ? null : @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(panel);
    }-*/;

	public native ExtElement getProxy() /*-{
        var proxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var proxy = proxy.getProxy();
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(proxy);
    }-*/;

	public native void hide() /*-{
        var proxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        proxy.hide();
    }-*/;

    public native void show() /*-{
        var proxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        proxy.show();
    }-*/;

    public native void moveProxy(Element parentNode) /*-{
        var proxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        proxy.moveProxy(parentNode, null);
    }-*/;

	public native void moveProxy(Element parentNode, Element before) /*-{
        var proxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        proxy.moveProxy(parentNode, before);
    }-*/;
}