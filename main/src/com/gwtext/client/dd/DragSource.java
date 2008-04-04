/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.dd;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.widgets.Component;

public class DragSource extends DDProxy {

    public DragSource(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public DragSource(String id,  DragSourceConfig config) {
        super(id, null, config);
    }

    public DragSource(Component component, DragSourceConfig config) {
        super(component, null, config);
    }

    protected native JavaScriptObject create(String id, String sGroup, JavaScriptObject config)/*-{
        return new $wnd.Ext.dd.DragSource(id, config);
    }-*/;

    protected native JavaScriptObject create(Element element, String sGroup, JavaScriptObject config)/*-{
        return new $wnd.Ext.dd.DragSource(element, config);
    }-*/;

    private static DragSource instance(JavaScriptObject jsObj) {
        return new DragSource(jsObj);
    }

    public native StatusProxy getProxy() /*-{
        var ds = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var proxy = ds.getProxy();
        return @com.gwtext.client.dd.StatusProxy::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(proxy);
    }-*/;
    
}
