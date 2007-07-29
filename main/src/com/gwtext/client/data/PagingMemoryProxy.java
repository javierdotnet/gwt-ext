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
package com.gwtext.client.data;

import com.google.gwt.core.client.JavaScriptObject;

public class PagingMemoryProxy extends MemoryProxy {

    static {
        init();
    }

    private static native void init() /*-{

        if (!$wnd.Array.prototype.filter) {
            $wnd.Array.prototype.filter = function(fun) {
                var len = this.length;
                if (typeof fun != "function")
                    throw new TypeError();

                var res = new Array();
                var thisp = arguments[1];
                for (var i = 0; i < len; i++) {
                    if (i in this) {
                        var val = this[i]; // in case fun mutates this
                        if (fun.call(thisp, val, i, this))
                            res.push(val);
                    }
                }
                return res;
            };
        }
        //original author Jack Slocum
        //this code is not part of the core Ext distribution but part of the examples shipped with Ext
        $wnd.Ext.data.PagingMemoryProxy = function(data) {
            $wnd.Ext.data.PagingMemoryProxy.superclass.constructor.call(this);
            this.data = data;
        };

        $wnd.Ext.extend($wnd.Ext.data.PagingMemoryProxy, $wnd.Ext.data.MemoryProxy, {
            load : function(params, reader, callback, scope, arg) {
                params = params || {};
                var result;
                try {
                    result = reader.readRecords(this.data);
                }catch(e){
                    this.fireEvent("loadexception", this, arg, null, e);
                    callback.call(scope, null, arg, false);
                    return;
                }

                // filtering
                if (params.query!==undefined) {
                    result.records = result.records.filter(function(el){
                        if (typeof(el)=="object"){
                            var att = params.filterCol || 0;
                            return String(el.data[att]).toLowerCase().match(params.query.toLowerCase());
                        } else {
                            return String(el).toLowerCase().match(params.query.toLowerCase());
                        }
                    });
                    result.totalRecords = result.records.length;
                }

                // sorting
                if (params.sort!==undefined) {
                    // use integer as params.sort to specify column, since arrays are not named
                    // params.sort=0; would also match a array without columns
                    var dir = String(params.dir).toUpperCase() == "DESC" ? -1 : 1;
                    var fn = function(r1, r2){
                        return r1 < r2;
                    };
                    result.records.sort(function(a, b) {
                        var v = 0;
                        if (typeof(a)=="object"){
                            v = fn(a.data[params.sort], b.data[params.sort]) * dir;
                        } else {
                            v = fn(a, b) * dir;
                        }
                        if (v==0) {
                            v = (a.index < b.index ? -1 : 1);
                        }
                        return v;
                    });
                }

                // paging (use undefined cause start can also be 0 (thus false))
                if (params.start!==undefined && params.limit!==undefined) {
                    result.records = result.records.slice(params.start, params.start+params.limit);
                }

                callback.call(scope, result, arg, true);
            }
        });
    }-*/;

    public PagingMemoryProxy(Object[][] data) {
        super(data);
    }

    protected native JavaScriptObject create(JavaScriptObject data) /*-{
        return new $wnd.Ext.data.PagingMemoryProxy(data);
    }-*/;
}



