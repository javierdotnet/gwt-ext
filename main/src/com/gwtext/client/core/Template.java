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

package com.gwtext.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;


//note that in template strings, only use double quotes around class names etc 
public class Template extends JsObject {
    public Template(String html) {
        jsObj = create(html.replaceAll("'", "\""));
    }

    public Template(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static Template instance(JavaScriptObject jsObj) {
        return new Template(jsObj);
    }

    public Template(String[] htmlfrags) {
        String htmlfrag = "";
        for (int i = 0; i < htmlfrags.length; i++) {
            htmlfrag += htmlfrags[i];
        }
        create(htmlfrag.replaceAll("'", "\""));
    }

    public native JavaScriptObject create(String html) /*-{
        return new $wnd.Ext.Template(html);
    }-*/;

    public native JavaScriptObject create(JavaScriptObject htmlfrags) /*-{
        return new $wnd.Ext.Template.apply($wnd.Ext.Template.create, htmlfrags);
    }-*/;

    public native void setDisableFormats(boolean disable) /*-{
        var template = this.@com.gwtext.client.core.JsObject::jsObj;
        template.disableFormats = disable;
    }-*/;

    public native void apply() /*-{
        var template = this.@com.gwtext.client.core.JsObject::jsObj;
        template.apply();
    }-*/;

    public String applyTemplate(String[] values) {
        return applyTemplate(JavaScriptObjectHelper.convertToJavaScriptArray(values));
    }

    private native String applyTemplate(JavaScriptObject values) /*-{
        var template = this.@com.gwtext.client.core.JsObject::jsObj;
        return template.applyTemplate(values);
    }-*/;

    public native void compile() /*-{
        var template = this.@com.gwtext.client.core.JsObject::jsObj;
        template.compile();
    }-*/;


}

