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

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Base class for representing a native Javascript class. <b>Note</b> : For internal use only.
 */
public abstract class JsObject {

    //Ext global initialization code
    static {
        Ext.setBlankImageUrl(GWT.getModuleBaseURL() + "clear.cache.gif");
        //setup Ext Function prototypes for the GWT scope
        //see http://groups.google.com/group/Google-Web-Toolkit/browse_thread/thread/3412d58a3c7a5e0d/f5f7bbe5754513aa#f5f7bbe5754513aa
        init();
    }

    private static native void init()/*-{

        @com.gwtext.client.core.EventObject::initConstants()();

        Function.prototype.createCallback = function() {
            // make args available, in function below
            var args = arguments;
            var method = this;
            return function() {
                return method.apply(window, args);
            };
        };

        Function.prototype.createDelegate = function(obj, args, appendArgs) {
            var method = this;
            return function() {
                var callArgs = args || arguments;
                if (appendArgs === true) {
                    callArgs = Array.prototype.slice.call(arguments, 0);
                    callArgs = callArgs.concat(args);
                } else if (typeof appendArgs == "number") {
                    callArgs = Array.prototype.slice.call(arguments, 0);
                    // copy arguments first
                    var applyArgs = [appendArgs, 0].concat(args);
                    // create method call params
                    Array.prototype.splice.apply(callArgs, applyArgs);
                    // splice them in
                }
                return method.apply(obj || window, callArgs);
            };
        };

        Function.prototype.defer = function(millis, obj, args, appendArgs) {
            var fn = this.createDelegate(obj, args, appendArgs);
            if (millis) {
                return setTimeout(fn, millis);
            }
            fn();
            return 0;
        };

        Function.prototype.createSequence = function(fcn, scope) {
            if (typeof fcn != "function") {
                return this;
            }
            var method = this;
            return function() {
                var retval = method.apply(this || window, arguments);
                fcn.apply(scope || this || window, arguments);
                return retval;
            };
        };

        Function.prototype.createInterceptor = function(fcn, scope) {
            if (typeof fcn != "function") {
                return this;
            }
            var method = this;
            return function() {
                fcn.target = this;
                fcn.method = method;
                if (fcn.apply(scope || this || window, arguments) === false) {
                    return;
                }
                return method.apply(this || window, arguments);
            };
        };

        $wnd.Ext.namespace("GwtExt");

        //convert javascript data types into corresponding Java wrapper types
        //int -> Integer, float -> Float, boolean -> Boolean and date - > java.util.Date
        $wnd.GwtExt.convertToJavaType = function(obj) {
                if(obj == null || obj === undefined) return null;
                if(typeof obj == 'string') {
                    return obj;
                } else if (typeof obj == 'number') {
                    if(obj.toString().indexOf('.') == -1) {
                        if(obj <= @java.lang.Integer::MAX_VALUE) {
                            return @com.gwtext.client.util.JavaScriptObjectHelper::toInteger(I)(obj);
                        } else {
                          return @com.gwtext.client.util.JavaScriptObjectHelper::toLong(J)(obj);
                        }
                    } else {
                        if(obj <= @java.lang.Float::MAX_VALUE) {
                            return @com.gwtext.client.util.JavaScriptObjectHelper::toFloat(F)(obj);
                        } else {
                            return @com.gwtext.client.util.JavaScriptObjectHelper::toDouble(D)(obj);
                        }
                    }
                } else if(typeof obj == 'boolean') {
                    return @com.gwtext.client.util.JavaScriptObjectHelper::toBoolean(Z)(obj);
                } else if(obj instanceof $wnd.Date) {
                    return @com.gwtext.client.util.JavaScriptObjectHelper::toDate(J)(obj.getTime());
                } else {
                    throw 'Unrecognized type ' + (typeof obj) + ' for value ' + obj.toString();
                }
        };
        
    }-*/;

    protected JavaScriptObject jsObj;

    protected JsObject() {
    }

    public JsObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    public JavaScriptObject getJsObj() {
        return jsObj;
    }
}
