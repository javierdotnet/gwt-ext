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

package com.gwtext.client.dd;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.EventCallback;
import com.gwtext.client.core.Function;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class DragDrop extends JsObject {

    public DragDrop(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public DragDrop(String id, String sGroup) {
        jsObj = create(id, sGroup, null);
    }

    public DragDrop(String id, String sGroup, DragDropConfig config) {
        jsObj = create(id, sGroup, config == null ? null : config.getJsObj());
    }

    protected native JavaScriptObject create(String id, String sGroup, JavaScriptObject config)/*-{
        return new $wnd.Ext.dd.DragDrop(id, sGroup, config);
    }-*/;

    public native boolean  isAvailable() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        return dd.available;
    }-*/;
    
    public native String getGroups() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        return dd.groups;
    }-*/;
    
    public native boolean hasOuterHandles() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        return dd.hasOuterHandles;
    }-*/;

    public native String getId() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        return dd.id;
    }-*/;

    public String[] getInvalidHandleClasses() {
        return JavaScriptObjectHelper.getAttributeAsStringArray(jsObj, "invalidHandleClasses");
    }

   public native String getInvalidHandleTypes() /*-{
       var dd = this.@com.gwtext.client.core.JsObject::jsObj;
       return dd.invalidHandleTypes;
   }-*/;

   public native boolean isMaintainOffset() /*-{
       var dd = this.@com.gwtext.client.core.JsObject::jsObj;
       return dd.maintainOffset;
   }-*/;

   public native boolean isPrimaryButtonOnly() /*-{
       var dd = this.@com.gwtext.client.core.JsObject::jsObj;
       return dd.primaryButtonOnly;
   }-*/;

    public int[] getXTicks() {
        return JavaScriptObjectHelper.getAttributeAsIntArray(jsObj, "xTicks");
    }

    public int[] getYTicks() {
        return JavaScriptObjectHelper.getAttributeAsIntArray(jsObj, "yTicks");
    }

    public native void addInvalidHandleClass(String cssClass) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.addInvalidHandleClass(cssClass);
    }-*/;

    public native void addInvalidHandleId(String id) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.addInvalidHandleId(id);
    }-*/;

    public native void addInvalidHandleType(String tagName) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.addInvalidHandleType(tagName);
    }-*/;

    public native void addToGroup(String sGroup) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.addToGroup(sGroup);
    }-*/;

    public native void applyConfig() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.applyConfig();
    }-*/;

    public native void clearConstraints() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.clearConstraints();
    }-*/;

    public native void clearTicks() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.clearTicks();
    }-*/;

    public native void onEndDrag(EventCallback callback) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.endDrag = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            callback.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;


    public native Element getDragEl() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        return dd.getDragEl();
    }-*/;

    public native Element getEl() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        return dd.getEl();
    }-*/;

    public native void init(String id, String sGroup, DragDropConfig config) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        var cfg = config.@com.gwtext.client.core.JsObject::jsObj;
        dd.init(id, sGroup, cfg);
    }-*/;

    public native void initTarget(String id, String sGroup, DragDropConfig config) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        var cfg = config.@com.gwtext.client.core.JsObject::jsObj;
        dd.initTarget(id, sGroup, cfg);
    }-*/;

    public native boolean isLocked() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        return dd.isLocked();
    }-*/;

    public native boolean isTarget() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        return dd.isTarget();
    }-*/;

    public native boolean isValidHandleChild(Element element) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        return dd.isValidHandleChild(element);
    }-*/;

    public native void lock() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.lock();
    }-*/;

    public native void onAvailable(Function callback) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.onAvailable = function() {
            callback.@com.gwtext.client.core.Function::execute()();
        };
    }-*/;

    public native void onDrag(EventCallback callback) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.onDrag = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            callback.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    private static DragDrop[] convertToDragDropArray(JavaScriptObject nativeArray) {
        JavaScriptObject[] itemsJ = JavaScriptObjectHelper.toArray(nativeArray);
        DragDrop[] items = new DragDrop[itemsJ.length];
        for (int i = 0; i < itemsJ.length; i++) {
            JavaScriptObject dd = itemsJ[i];
            items[i] = new DragDrop(dd);
        }
        return items;
    }

    public native void onDragDrop(DragDropCallback callback) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.onDragDrop = function(e, id) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            if(typeof id == 'string') {
                callback.@com.gwtext.client.dd.DragDropCallback::execute(Lcom/gwtext/client/core/EventObject;Ljava/lang/String;)(eJ, id)
            } else {
                var items = @com.gwtext.client.dd.DragDrop::convertToDragDropArray(Lcom/google/gwt/core/client/JavaScriptObject;)(id);
                callback.@com.gwtext.client.dd.DragDropCallback::execute(Lcom/gwtext/client/core/EventObject;[Lcom/gwtext/client/dd/DragDrop;)(eJ, items);
            }
        };
    }-*/;

    public native void onDragEnter(DragDropCallback callback) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.onDragEnter = function(e, id) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            if(typeof id == 'string') {
                callback.@com.gwtext.client.dd.DragDropCallback::execute(Lcom/gwtext/client/core/EventObject;Ljava/lang/String;)(eJ, id)
            } else {
                var items = @com.gwtext.client.dd.DragDrop::convertToDragDropArray(Lcom/google/gwt/core/client/JavaScriptObject;)(id);
                callback.@com.gwtext.client.dd.DragDropCallback::execute(Lcom/gwtext/client/core/EventObject;[Lcom/gwtext/client/dd/DragDrop;)(eJ, items);
            }
        };
    }-*/;

    public native void onDragOut(DragDropCallback callback) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.onDragOut = function(e, id) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            if(typeof id == 'string') {
                callback.@com.gwtext.client.dd.DragDropCallback::execute(Lcom/gwtext/client/core/EventObject;Ljava/lang/String;)(eJ, id)
            } else {
                var items = @com.gwtext.client.dd.DragDrop::convertToDragDropArray(Lcom/google/gwt/core/client/JavaScriptObject;)(id);
                callback.@com.gwtext.client.dd.DragDropCallback::execute(Lcom/gwtext/client/core/EventObject;[Lcom/gwtext/client/dd/DragDrop;)(eJ, items);
            }
        };
    }-*/;

    public native void onDragOver(DragDropCallback callback) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.onDragOver = function(e, id) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            if(typeof id == 'string') {
                callback.@com.gwtext.client.dd.DragDropCallback::execute(Lcom/gwtext/client/core/EventObject;Ljava/lang/String;)(eJ, id)
            } else {
                var items = @com.gwtext.client.dd.DragDrop::convertToDragDropArray(Lcom/google/gwt/core/client/JavaScriptObject;)(id);
                callback.@com.gwtext.client.dd.DragDropCallback::execute(Lcom/gwtext/client/core/EventObject;[Lcom/gwtext/client/dd/DragDrop;)(eJ, items);
            }
        };
    }-*/;

    public native void onInvalidDrop(EventCallback callback) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.onInvalidDrop = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            callback.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    public native void onMouseDown(EventCallback callback) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.onMouseDown = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            callback.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    public native void onMouseUp(EventCallback callback) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.onMouseUp = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            callback.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    public native void padding() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.padding();
    }-*/;

    public native void removeFromGroup(String sGroup) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.removeFromGroup(sGroup);
    }-*/;

    public native void removeInvalidHandleClass(String cssClass) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.removeInvalidHandleClass(cssClass);
    }-*/;

    public native void removeInvalidHandleId(String id) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.removeInvalidHandleId(id);
    }-*/;

    public native void removeInvalidHandleType(String tagName) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.removeInvalidHandleType(tagName);
    }-*/;

    public native void resetConstraints(boolean maintainOffset) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.resetConstraints(maintainOffset);
    }-*/;

    public native void setDragElId(String id) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.setDragElId(id);
    }-*/;

    public native void setHandleElId(String id) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.setHandleElId(id);
    }-*/;

    //in doc but missing from code?
    /*public native void setInitialPosition(int diffX, int diffY) *//*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.setInitialPosition(diffX, diffY);
    }-*//*;*/

    public native void setOuterHandleElId(String id) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.setOuterHandleElId(id);
    }-*/;

    public native void setPadding(int iUp, int iDown, int iBottom, int iLeft) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.setPadding(iUp, iDown, iBottom, iLeft);
    }-*/;

    public native void setXConstraint(int iLeft, int iRight, int iTickSize) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.setXConstraint(iLeft, iRight, iTickSize);
    }-*/;

    public native void setYConstraint(int iUp, int iDown, int iTickSize) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.setYConstraint(iUp, iDown, iTickSize);
    }-*/;

    public native void startDrag(StartDragCallback callback) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        var ddJ = this;
        dd.startDrag = function(x, y) {
            callback.@com.gwtext.client.dd.StartDragCallback::startDrag(Lcom/gwtext/client/dd/DragDrop;II)(ddJ, x, y);
        };
    }-*/;

    public native String toString() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        return dd.toString();
    }-*/;

    public native void unlock() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.unlock();
    }-*/;

    public native void unreg() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.unreg();
    }-*/;    
}
