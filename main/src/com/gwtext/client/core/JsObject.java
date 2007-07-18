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

public abstract class JsObject {

    //Ext global initialization code
    static {
        Ext.setBlankImageUrl("images/s.gif");
        //setup Ext Function prototypes for the GWT scope
        //see http://groups.google.com/group/Google-Web-Toolkit/browse_thread/thread/3412d58a3c7a5e0d/f5f7bbe5754513aa#f5f7bbe5754513aa
        init();
    }

    private static native void init()/*-{    
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
