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
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Represents an HTML fragment template. Templates can be precompiled for greater performance.
 *
 * The list of available inbuild functions for use within templates are :
 * 'capitalize', 'date', 'ellipsis', 'htmlDecode', 'htmlEncode', 'lowecase', 'stripTags',
 * 'substr', 'trim', 'undef', 'uppercase', 'usMoney'.
 *
 */
public class Template extends JsObject {

    /**
     * Create a new Template.
     *
     * @param html the HTML fragment
     */
    public Template(String html) {
        jsObj = create(html.replaceAll("'", "\""));
    }

    public Template(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Create a new Template.
     *
     * @param htmlfrags the HTML fragments
     */
    public Template(String[] htmlfrags) {
        String htmlfrag = "";
        for (int i = 0; i < htmlfrags.length; i++) {
            htmlfrag += htmlfrags[i];
        }
        jsObj = create(htmlfrag.replaceAll("'", "\""));
    }

    private static Template instance(JavaScriptObject jsObj) {
        return new Template(jsObj);
    }

    private native JavaScriptObject create(String html) /*-{
        return new $wnd.Ext.Template(html);
    }-*/;

    public native JavaScriptObject create(JavaScriptObject htmlfrags) /*-{
        return new $wnd.Ext.Template.apply($wnd.Ext.Template.create, htmlfrags);
    }-*/;

    /**
     * True to disable format functions (defaults to false).
     *
     * @param disable true to disable format functions
     */
    public native void setDisableFormats(boolean disable) /*-{
        var template = this.@com.gwtext.client.core.JsObject::jsObj;
        template.disableFormats = disable;
    }-*/;

    /**
     * Returns an HTML fragment of this template with the specified values applied. Use this method when the
     * params are numeric (i.e. {0})
     *
     * @param values the param values
     * @return the html fragment
     */
    public String applyTemplate(String[] values) {
        return applyTemplate(JavaScriptObjectHelper.convertToJavaScriptArray(values));
    }

    /**
     * Returns an HTML fragment of this template with the specified values applied. Use this method when the
     * params are named (i.e. {foo})
     *
     * @param values the param values
     * @return the html fragment
     */
    public String applyTemplate(NameValuePair[] values) {
        return applyTemplate(NameValuePair.getJsObj(values));
    }

    private native String applyTemplate(JavaScriptObject values) /*-{
        var template = this.@com.gwtext.client.core.JsObject::jsObj;
        return template.applyTemplate(values);
    }-*/;

    /**
     * Compiles the template into an internal function, eliminating the RegEx overhead.
     */
    public native void compile() /*-{
        var template = this.@com.gwtext.client.core.JsObject::jsObj;
        template.compile();
    }-*/;
}

