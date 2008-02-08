/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.layout;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Component;

/**
 * Every layout is composed of one or more Ext.Container elements internally, and ContainerLayout provides the basic foundation
 * for all other layout classes in GWT-Ext. It is a non-visual class that simply provides the base logic required for a Container
 * to function as a layout. 
 */
public abstract class ContainerLayout  {

    protected JavaScriptObject configJS = JavaScriptObjectHelper.createObject();
    private JavaScriptObject jsObj;
    private String spacing;

    public JavaScriptObject getJsObj() {
        if(jsObj == null) {
            jsObj = create(configJS);
        }
        return jsObj;
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.layout.ContainerLayout(config);
    }-*/;

    public JavaScriptObject getContainerAttributes() {
        return null;
    }

    /**
     * An optional extra CSS class that will be added to the container (defaults to ''). This can be useful for adding
     * customized styles to the container or any of its children using standard CSS rules.
     *
     * @param extraCls an optional extra CSS class that will be added to the container (defaults to '').
     */
    public void setExtraCls(String extraCls) {
        JavaScriptObjectHelper.setAttribute(configJS, "extraCls", extraCls);
    }

    /**
     * True to hide each contained item on render (defaults to false).
     *
     * @param renderHidden true to hide each contained item on render (defaults to false).
     */
    public void setRenderHidden(boolean renderHidden) {
        JavaScriptObjectHelper.setAttribute(configJS, "renderHidden", renderHidden);
    }

    public native Component getActiveItem() /*-{       
       var layout = this.@com.gwtext.client.widgets.layout.ContainerLayout::getJsObj()();
       var jsoActiveItem = layout.activeItem;
       return jsoActiveItem == null ? null : @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(jsoActiveItem);
   }-*/;

    public String getSpacing() {
        return spacing;
    }

    public void setSpacing(String spacing) {
        this.spacing = spacing;
    }
}
