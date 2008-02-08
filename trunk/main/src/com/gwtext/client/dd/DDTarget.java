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

public class DDTarget extends DragDrop {


    public DDTarget(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public DDTarget(String id, String sGroup, DragDropConfig config) {
        super(id, sGroup, config);
    }

    public DDTarget(Element element, String sGroup, DragDropConfig config) {
        super(element, sGroup, config);
    }

    public DDTarget(Component component, String sGroup, DragDropConfig config) {
        super(component, sGroup, config);
    }

    protected native JavaScriptObject create(String id, String sGroup, JavaScriptObject config)/*-{
        return new $wnd.Ext.dd.DDTarget(id, sGroup, config);
    }-*/;

    protected native JavaScriptObject create(Element element, String sGroup, JavaScriptObject config)/*-{
        return new $wnd.Ext.dd.DDTarget(element, sGroup, config);
    }-*/;

}
