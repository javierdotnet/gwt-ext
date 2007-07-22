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

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

//If no tag is specified then a div will be automatically generated with the specified attributes.
public class DomConfig {
    private String tag;
    private String id;
    private String cls;
    //todo support style object
    private String style;
    private String html;
    private List children;

    public DomConfig(String tag, String id, String cls) {
        this.tag = tag;
        this.id = id;
        this.cls = cls;
    }

    public DomConfig(String tag, String id, String cls, String html) {
        this.tag = tag;
        this.id = id;
        this.cls = cls;
        this.html = html;
    }

    public DomConfig addChild(DomConfig child) {
        if(html != null) {
            throw new IllegalArgumentException("Dom spec cannot have inner html and child elelents");
        }
        if(children == null) children = new ArrayList();
        children.add(child);
        return this;
    }

    public JavaScriptObject getJsObject() {
        JavaScriptObject jsObj = JavaScriptObjectHelper.createObject();
        if(tag != null) JavaScriptObjectHelper.setAttribute(jsObj, "tag", tag);
        if(id != null) JavaScriptObjectHelper.setAttribute(jsObj, "id", id);
        if(cls != null) JavaScriptObjectHelper.setAttribute(jsObj, "cls", cls);
        if(style != null) JavaScriptObjectHelper.setAttribute(jsObj, "style", style);
        if(html != null) JavaScriptObjectHelper.setAttribute(jsObj, "html", html);

        if(children != null) {
            JavaScriptObject[] childrenJS = new JavaScriptObject[children.size()];
            int i=0;
            for(Iterator it = children.iterator(); it.hasNext(); i++) {
                DomConfig config = (DomConfig) it.next();
                childrenJS[i] = config.getJsObject();
            }
            JavaScriptObjectHelper.setAttribute(jsObj, "children", childrenJS);
        }
        return jsObj;
    }
}
