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
