/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

//todo investigate addition on defaultValue, although it works only with XmlReader

//http://extjs.com/forum/showthread.php?t=4537&page=2
/**
 * Base abstract FieldDef class.
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
