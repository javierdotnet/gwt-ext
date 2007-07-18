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

package com.gwtext.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.widgets.UserObject;

import java.util.Date;
import java.util.List;

public class JavaScriptObjectHelper {
    private JavaScriptObjectHelper() {
    }

    public static native String getAttribute(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined) ? null : String(ret);
    }-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, String value) /*-{
	    elem[attr] = value;
    }-*/;

    public static native JavaScriptObject getAttributeAsJavaScriptObject(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined) ? null : ret;
    }-*/;

    public static native JavaScriptObject[] getAttributeAsJavaScriptObjectArray(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined) ? null : ret;
    }-*/;

    public static JavaScriptObject[] toArray(JavaScriptObject array) {
        int length = getJavaScriptObjectArraySize(array);
        JavaScriptObject[] recs = new JavaScriptObject[length];
        for (int i = 0; i < length; i++) {
            recs[i] = getValueFromJavaScriptObjectArray(array, i);
        }
        return recs;
    }

    public static Element[] toElementArray(JavaScriptObject array) {
        int length = getJavaScriptObjectArraySize(array);
        Element[] recs = new Element[length];
        for (int i = 0; i < length; i++) {
            recs[i] = getElementValueFromJavaScriptObjectArray(array, i);
        }
        return recs;
    }

    public static native void setAttribute(JavaScriptObject elem, String attr, JavaScriptObject[] value) /*-{
	    elem[attr] = value;
    }-*/;

    public static void setAttribute(JavaScriptObject elem, String attr, int[] values) {
	    setAttribute(elem, attr, JavaScriptObjectHelper.convertToJavaScriptArray(values));
    };

    public static void setAttribute(JavaScriptObject elem, String attr, String[] values) {
	    setAttribute(elem, attr, JavaScriptObjectHelper.convertToJavaScriptArray(values));
    };

    public static native void setAttribute(JavaScriptObject elem, String attr, JavaScriptObject value) /*-{
	    elem[attr] = value;
    }-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, int value) /*-{
	    elem[attr] = value;
    }-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, boolean value) /*-{
	    elem[attr] = value;
    }-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, float value) /*-{
	    elem[attr] = value;
    }-*/;

    public static void setAttribute(JavaScriptObject elem, String attr, Date value) {
        setDateAttribute(elem, attr, value.getTime());
    }

    private static native void setDateAttribute(JavaScriptObject elem, String attr, long time) /*-{
        elem[attr] = new $wnd.Date(time);
    }-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, UserObject userObject) /*-{
	    elem[attr] = userObject.@com.gwtext.client.widgets.UserObject::data;
    }-*/;

    public static native void setObjectAttribute(JavaScriptObject elem, String attr, Object object) /*-{
            elem[attr] = object;
    }-*/;


    public static native int getAttributeAsInt(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined) ? null : ret;
    }-*/;

    public static native float getAttributeAsFloat(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined) ? null : ret;
    }-*/;

    public static int[] getAttributeAsIntArray(JavaScriptObject elem, String attr) {
        int[] rtn = null;
        JavaScriptObject hold = getAttributeAsJavaScriptObject(elem, attr);

        if (hold != null) {
            rtn = new int[getJavaScriptObjectArraySize(hold)];

            for (int i = 0; i < rtn.length; i++) {
                rtn[i] = getIntValueFromJavaScriptObjectArray(hold, i);
            }
        }
        return rtn;
    }

    public static String[] getAttributeAsStringArray(JavaScriptObject elem, String attr) {
        String[] rtn = null;
        JavaScriptObject hold = getAttributeAsJavaScriptObject(elem, attr);

        if (hold != null) {
            rtn = new String[getJavaScriptObjectArraySize(hold)];

            for (int i = 0; i < rtn.length; i++) {
                rtn[i] = getStringValueFromJavaScriptObjectArray(hold, i);
            }
        }
        return rtn;
    }

    public static native int getJavaScriptObjectArraySize(JavaScriptObject elem) /*-{
	    if (elem) return elem.length;
	    return 0;
    }-*/;

    public static native int getIntValueFromJavaScriptObjectArray(JavaScriptObject elem, int i) /*-{
	    return elem[i];
    }-*/;

    public static native String getStringValueFromJavaScriptObjectArray(JavaScriptObject elem, int i) /*-{
	    return elem[i];
    }-*/;

    public static native JavaScriptObject getValueFromJavaScriptObjectArray(JavaScriptObject elem, int i) /*-{
	    return elem[i];
    }-*/;

    public static native boolean getAttributeAsBoolean(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined) ? null : ret;
    }-*/;


    public static JavaScriptObject[] listToArray(List list) {
        JavaScriptObject[] array = new JavaScriptObject[list.size()];

        for (int i = 0; i < array.length; i++) {
            array[i] = (JavaScriptObject) list.get(i);
        }

        return array;
    }

    public static JavaScriptObject arrayConvert(Object[] array) {
        JavaScriptObject result = newJSArray(array.length);

        for (int i = 0; i < array.length; i++) {
            arraySet(result, i, array[i]);
        }

        return result;
    }

    public static JavaScriptObject arrayConvert(JavaScriptObject[] array) {
        JavaScriptObject result = newJSArray(array.length);

        for (int i = 0; i < array.length; i++) {
            arraySet(result, i, array[i]);
        }

        return result;
    }

    private static native JavaScriptObject newJSArray(int length) /*-{
	    if (length < 0)
	    {
	    return new Array();
	    }
	    else
	    {
	    return new Array(length);
	    }
    }-*/;

    public static native int arrayLength(JavaScriptObject array) /*-{
	    return array.length;
    }-*/;

    public static native Object arrayGetObject(JavaScriptObject array, int index) /*-{
	    return array[index];
    }-*/;

    public static native void arraySet(JavaScriptObject array, int index, Object value) /*-{
	    array[index] = value;
    }-*/;

    public static native void arraySet(JavaScriptObject array, int index, JavaScriptObject value) /*-{
	    array[index] = value;
    }-*/;


    /**
     * Find elements which match class name, returns null is none found.
     */
    public static Element[] getElementsByClassName(String className) {
        Element[] elements = null;

        JavaScriptObject arrayObject = getJavaScriptObjectElementsByClassName(className);

        int length = getJavaScriptObjectArraySize(arrayObject);

        if (length > 0) {
            elements = new Element[length];
            for (int index = 0; index < length; index++) {
                Element e = getElementValueFromJavaScriptObjectArray(arrayObject, index);
                elements[index] = e;
            }
        }

        return elements;
    }

    /**
     * Find elements which match class name and return as JavaScriptObject
     */
    public static native JavaScriptObject getJavaScriptObjectElementsByClassName(String className) /*-{
		var elements = new Array();
		if ($doc.getElementsByTagName)
		{
			var els = $doc.getElementsByTagName("*");
			var c = new RegExp('/b^|' + className + '|$/b');
			var n=0;
			for (var i=0; i < els.length; i++)
			{
			   if (els[i].className)
			   {
			      if(c.test(els[i].className))
			      {
			         elements[n] = els[i];
			         n++;
			      }
			  }
			}
		}

		return elements;
    }-*/;

    /**
     * This is used to access Element array as JavaScriptObject
     */
    public static native Element getElementValueFromJavaScriptObjectArray(JavaScriptObject elem, int i) /*-{
    	return elem[i];
	}-*/;

    public static native void invoke(JavaScriptObject jsobj, String functionName, Object arg1, JavaScriptObject arg2)/*-{
        alert(jsobj[functionName]);
        alert(arg1);
        alert(arg2);
       jsobj[functionName].call(jsobj, arg1, arg2);
    }-*/;

    public static native JavaScriptObject createObject() /*-{
        return new Object;
    }-*/;

    public static JavaScriptObject convertToJavaScriptArray(int[] array) {
        JavaScriptObject jsArray = createJavaScriptArray();
        for (int i = 0; i < array.length; i++) {
            JavaScriptObjectHelper.setArrayValue(jsArray, i, array[i]);
        }
        return jsArray;
    }


    public static JavaScriptObject convertToJavaScriptArray(Object[] array) {
        JavaScriptObject jsArray = createJavaScriptArray();
        for (int i = 0; i < array.length; i++) {
            Object val = array[i];
            if (val instanceof String) {
                JavaScriptObjectHelper.setArrayValue(jsArray, i, (String) val);
            } else if (val instanceof Integer) {
                JavaScriptObjectHelper.setArrayValue(jsArray, i, ((Integer) val).intValue());
            } else if (val instanceof Float) {
                JavaScriptObjectHelper.setArrayValue(jsArray, i, ((Float) val).floatValue());
            } else if (val instanceof Double) {
                JavaScriptObjectHelper.setArrayValue(jsArray, i, ((Double) val).doubleValue());
            } else if (val instanceof Boolean) {
                JavaScriptObjectHelper.setArrayValue(jsArray, i, ((Boolean) val).booleanValue());
            } else if (val instanceof JavaScriptObject) {
                JavaScriptObjectHelper.setArrayValue(jsArray, i, ((JavaScriptObject) val));
            } else if (val instanceof JsObject) {
                JavaScriptObjectHelper.setArrayValue(jsArray, i, ((JsObject) val).getJsObj());
            } else if (val instanceof Object[]) {
                JavaScriptObjectHelper.setArrayValue(jsArray, i, convertToJavaScriptArray((Object[]) val));
            }
        }
        return jsArray;
    }

    public static native JavaScriptObject createJavaScriptArray() /*-{
        return [];
    }-*/;

    public static native void setArrayValue(JavaScriptObject array, int index, String value) /*-{
        array[index] = value;
    }-*/;

    public static native void setArrayValue(JavaScriptObject array, int index, double value) /*-{
        array[index] = value;
    }-*/;

    public static native void setArrayValue(JavaScriptObject array, int index, float value) /*-{
        array[index] = value;
    }-*/;

    public static native void setArrayValue(JavaScriptObject array, int index, boolean value) /*-{
        array[index] = value;
    }-*/;

    public static native void setArrayValue(JavaScriptObject array, int index, JavaScriptObject value) /*-{
        array[index] = value;
    }-*/;

    public static native String getArrayValue(JavaScriptObject array, int index) /*-{
        var result = array[index];
        return (result == null || result === undefined) ? null : result;
    }-*/;

    public static native int getIntArrayValue(JavaScriptObject array, int index) /*-{
        return array[index];
    }-*/;

    public static native int getArrayLength(JavaScriptObject array) /*-{
        return array.length;
    }-*/;

    public static int[] convertToJavaIntArray(JavaScriptObject array) {
        int length = getArrayLength(array);
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getIntArrayValue(array, i);
        }
        return arr;
    }

}
