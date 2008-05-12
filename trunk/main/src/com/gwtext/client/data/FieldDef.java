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
 

package com.gwtext.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

//todo investigate addition on defaultValue, although it works only with XmlReader

//http://extjs.com/forum/showthread.php?t=4537&page=2
/**
 * Base abstract FieldDef class.
 *
 * @author Sanjiv Jivan
 */
public abstract class FieldDef extends JsObject {

    static native void setConverter(JavaScriptObject config, Converter converter)/*-{
        config['convert'] = function(s) {
            return converter.@com.gwtext.client.data.Converter::format(Ljava/lang/String;)(s.toString());
        }
   }-*/;

    /**
     * Return the field name.
     *
     * @return the field name
     */
    public String getName() {
        return JavaScriptObjectHelper.getAttribute(getJsObj(), "name");
    }

    //not adding setSortType to API as combination of data type and renderer accomplishes
    //sort type behavior
    //http://extjs.com/forum/showthread.php?t=1853    
}
