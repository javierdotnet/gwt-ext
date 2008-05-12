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
 

package com.gwtext.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * A template class that supports advanced functionality like autofilling arrays, conditional processing with basic
 * comparison operators, sub-templates, basic math function support, special built-in template variables, inline code
 * execution and more. XTemplate also provides the templating mechanism built into {@link com.gwtext.client.widgets.DataView}.
 *
 * @author Sanjiv Jivan
 */
//todo add docs
public class XTemplate extends JsObject {

    private String html;

    /**
     * Create a new Template.
     *
     * @param html the HTML fragment
     */
    public XTemplate(String html) {
        jsObj = create(html.replaceAll("'", "\""));
        this.html = html;
    }

    /**
     * Create a new Template.
     *
     * @param htmlfrags the HTML fragments
     */
    public XTemplate(String[] htmlfrags) {
        String htmlfrag = "";
        for (int i = 0; i < htmlfrags.length; i++) {
            htmlfrag += htmlfrags[i];
        }
        html = htmlfrag.replaceAll("'", "\"");
        jsObj = create(html);
    }

    private XTemplate(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public String getHtml() {
        return html;
    }

    private native JavaScriptObject create(String html) /*-{
        return new $wnd.Ext.XTemplate(html);
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

    public native String applyTemplate(JavaScriptObject values) /*-{
        var template = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return template.applyTemplate(values);
    }-*/;

    /**
     * Compiles the template into an internal function, eliminating the RegEx overhead.
     */
    public native void compile() /*-{
        var template = this.@com.gwtext.client.core.JsObject::getJsObj()();
        template.compile();
    }-*/;
}