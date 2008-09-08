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
 

package com.gwtext.client.dd;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Function;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.core.Paddings;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Component;

/**
 *
 * @author Sanjiv Jivan
 */
public class DragDrop extends JsObject {
    static {
        init();
    }

    private static native void init() /*-{
         $wnd.Ext.dd.DragDrop.prototype.ddJ=null;
    
         $wnd.Ext.dd.DragDrop.prototype.startDrag = function(x, y) {
             var ddJ = this.ddJ;
             if(ddJ != null) ddJ.@com.gwtext.client.dd.DragDrop::startDrag(II)(x,y);
            }

         $wnd.Ext.dd.DragDrop.prototype.endDrag = function(e) {
             var ddJ = this.ddJ;
             if(ddJ != null) {
				 var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
				 ddJ.@com.gwtext.client.dd.DragDrop::endDrag(Lcom/gwtext/client/core/EventObject;)(eJ);
			 }
            }

        $wnd.Ext.dd.DragDrop.prototype.onDrag = function(e) {
             var ddJ = this.ddJ;
			 if(ddJ != null) {
			     var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
                 ddJ.@com.gwtext.client.dd.DragDrop::onDrag(Lcom/gwtext/client/core/EventObject;)(eJ);
		     }
			}

        $wnd.Ext.dd.DragDrop.prototype.onDragDrop = function(e, id) {
             var ddJ = this.ddJ;
			if(ddJ != null) {
				 var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
				 if(typeof id == 'string') {
					ddJ.@com.gwtext.client.dd.DragDrop::onDragDrop(Lcom/gwtext/client/core/EventObject;Ljava/lang/String;)(eJ, id);
				 } else {
					var items = @com.gwtext.client.dd.DragDrop::convertToDragDropArray(Lcom/google/gwt/core/client/JavaScriptObject;)(id);
					ddJ.@com.gwtext.client.dd.DragDrop::onDragDrop(Lcom/gwtext/client/core/EventObject;[Lcom/gwtext/client/dd/DragDrop;)(eJ, items);
				 }
			}
		}

        $wnd.Ext.dd.DragDrop.prototype.onDragEnter = function(e, id) {
             var ddJ = this.ddJ;
			if(ddJ != null) {
				 var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
				 if(typeof id == 'string') {
					ddJ.@com.gwtext.client.dd.DragDrop::onDragEnter(Lcom/gwtext/client/core/EventObject;Ljava/lang/String;)(eJ, id);
				 } else {
					var items = @com.gwtext.client.dd.DragDrop::convertToDragDropArray(Lcom/google/gwt/core/client/JavaScriptObject;)(id);
					ddJ.@com.gwtext.client.dd.DragDrop::onDragEnter(Lcom/gwtext/client/core/EventObject;[Lcom/gwtext/client/dd/DragDrop;)(eJ, items);
				 }
			}
		}

        $wnd.Ext.dd.DragDrop.prototype.onDragOut = function(e, id) {
             var ddJ = this.ddJ;
			 if(ddJ != null) {
				 var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
				 if(typeof id == 'string') {
					ddJ.@com.gwtext.client.dd.DragDrop::onDragOut(Lcom/gwtext/client/core/EventObject;Ljava/lang/String;)(eJ, id);
				 } else {
					var items = @com.gwtext.client.dd.DragDrop::convertToDragDropArray(Lcom/google/gwt/core/client/JavaScriptObject;)(id);
					ddJ.@com.gwtext.client.dd.DragDrop::onDragOut(Lcom/gwtext/client/core/EventObject;[Lcom/gwtext/client/dd/DragDrop;)(eJ, items);
				 }
			 }
		}

        $wnd.Ext.dd.DragDrop.prototype.onDragOver = function(e, id) {
             var ddJ = this.ddJ;
			 if(ddJ != null) {
				 var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
				 if(typeof id == 'string') {
					ddJ.@com.gwtext.client.dd.DragDrop::onDragOver(Lcom/gwtext/client/core/EventObject;Ljava/lang/String;)(eJ, id);
				 } else {
					var items = @com.gwtext.client.dd.DragDrop::convertToDragDropArray(Lcom/google/gwt/core/client/JavaScriptObject;)(id);
					ddJ.@com.gwtext.client.dd.DragDrop::onDragOver(Lcom/gwtext/client/core/EventObject;[Lcom/gwtext/client/dd/DragDrop;)(eJ, items);
				 }
			 }
		}

        $wnd.Ext.dd.DragDrop.prototype.onInvalidDrop = function(e) {
             var ddJ = this.ddJ;
			 if(ddJ != null) {
				 var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
				 ddJ.@com.gwtext.client.dd.DragDrop::onInvalidDrop(Lcom/gwtext/client/core/EventObject;)(eJ);
			 }
	    }

        $wnd.Ext.dd.DragDrop.prototype.onMouseDown = function(e) {
             var ddJ = this.ddJ;
			 if(ddJ != null) {
				 var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
				 ddJ.@com.gwtext.client.dd.DragDrop::onMouseDown(Lcom/gwtext/client/core/EventObject;)(eJ);
			}
		}

        $wnd.Ext.dd.DragDrop.prototype.onMouseUp = function(e) {
             var ddJ = this.ddJ;
			 if(ddJ != null) {
				 var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
				 ddJ.@com.gwtext.client.dd.DragDrop::onMouseUp(Lcom/gwtext/client/core/EventObject;)(eJ);
			}
	   }
    }-*/;

    public DragDrop(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public DragDrop(String id) {
        this(id, null);
    }

    public DragDrop(final Component component) {
        this(component, null);
    }

    public DragDrop(String id, String sGroup) {
        this(id, sGroup, null);
    }

    public DragDrop(Component component, String sGroup) {
        this(component, sGroup, null);
    }

    public DragDrop(String id, String sGroup, DragDropConfig config) {
        jsObj = create(id, sGroup, config == null ? null : config.getJsObj());
        setLocalRef(jsObj, this);
        onAvailable();
    }

    public DragDrop(Element element, String sGroup, DragDropConfig config) {
        jsObj = create(element, sGroup, config == null ? null : config.getJsObj());
        setLocalRef(jsObj, this);
        onAvailable();
    }

    public DragDrop(final Component component, final String sGroup, final DragDropConfig config) {
        if (component.isRendered()) {
            jsObj = create(component.getId(), sGroup, config == null ? null : config.getJsObj());
            setLocalRef(jsObj, this);
            onAvailable();
        } else {
            component.addListener("render", new Function() {
                public void execute() {
                    jsObj = create(component.getId(), sGroup, config == null ? null : config.getJsObj());
                    setLocalRef(jsObj, DragDrop.this);
                    onAvailable();
                }
            });
        }
    }

    private native void setLocalRef(JavaScriptObject dd, DragDrop dragDrop) /*-{
        dd.ddJ = dragDrop;
    }-*/;

    protected native JavaScriptObject create(String id, String sGroup, JavaScriptObject config)/*-{
        return new $wnd.Ext.dd.DragDrop(id, sGroup, config);
    }-*/;

    protected native JavaScriptObject create(Element element, String sGroup, JavaScriptObject config)/*-{
        return new $wnd.Ext.dd.DragDrop(element, sGroup, config);
    }-*/;

    private static DragDrop dragDropInstance(JavaScriptObject jsObj) {
        return new DragDrop(jsObj);
    }

    public native boolean isAvailable() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return dd.available;
    }-*/;

    public String[] getGroups() {
        JavaScriptObject nativeArray = doGetGroups();
        String[] rtn = null;

        if (nativeArray != null) {
            rtn = new String[JavaScriptObjectHelper.getJavaScriptObjectArraySize(nativeArray)];

            for (int i = 0; i < rtn.length; i++) {
                rtn[i] = JavaScriptObjectHelper.getStringValueFromJavaScriptObjectArray(nativeArray, i);
            }
        }
        return rtn;
    }

    private native JavaScriptObject doGetGroups() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var groups = dd.groups;
        var group;
        var arr = @com.gwtext.client.util.JavaScriptObjectHelper::createJavaScriptArray()();
        for(group in groups) {
            arr.push(group);
        }
        return arr;
    }-*/;

    public native boolean hasOuterHandles() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return dd.hasOuterHandles;
    }-*/;

    public native String getId() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return dd.id;
    }-*/;

    public String[] getInvalidHandleClasses() {
        return JavaScriptObjectHelper.getAttributeAsStringArray(jsObj, "invalidHandleClasses");
    }

    public native String getInvalidHandleTypes() /*-{
       var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
       return dd.invalidHandleTypes;
   }-*/;

    public native boolean isMaintainOffset() /*-{
       var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
       var mo = dd.maintainOffset;
       return (mo === undefined || mo == null) ? false : mo; 
   }-*/;

    public native boolean isPrimaryButtonOnly() /*-{
       var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
       return dd.primaryButtonOnly;
   }-*/;

    public int[] getXTicks() {
        return JavaScriptObjectHelper.getAttributeAsIntArray(jsObj, "xTicks");
    }

    public int[] getYTicks() {
        return JavaScriptObjectHelper.getAttributeAsIntArray(jsObj, "yTicks");
    }

    public native void addInvalidHandleClass(String cssClass) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.addInvalidHandleClass(cssClass);
    }-*/;

    public native void addInvalidHandleId(String id) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.addInvalidHandleId(id);
    }-*/;

    public native void addInvalidHandleType(String tagName) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.addInvalidHandleType(tagName);
    }-*/;

    public native void addToGroup(String sGroup) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.addToGroup(sGroup);
    }-*/;

    public native void applyConfig() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.applyConfig();
    }-*/;

    public native void clearConstraints() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.clearConstraints();
    }-*/;

    public native void clearTicks() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.clearTicks();
    }-*/;

    public void endDrag(EventObject e) {

    }


    public native Element getDragEl() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return dd.getDragEl();
    }-*/;

    public native Element getEl() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return dd.getEl();
    }-*/;

    public native void init(String id, String sGroup, DragDropConfig config) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var cfg = config.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.init(id, sGroup, cfg);
    }-*/;

    public native void initTarget(String id, String sGroup, DragDropConfig config) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var cfg = config.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.initTarget(id, sGroup, cfg);
    }-*/;

    public native boolean isLocked() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return dd.isLocked();
    }-*/;

    public native boolean isTarget() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return dd.isTarget();
    }-*/;

    public native boolean isValidHandleChild(Element element) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return dd.isValidHandleChild(element);
    }-*/;

    public native void lock() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.lock();
    }-*/;

    public void onAvailable() {
    }

    public void onDrag(EventObject e) {

    }

    private static DragDrop[] convertToDragDropArray(JavaScriptObject nativeArray) {
        JavaScriptObject[] itemsJ = JavaScriptObjectHelper.toArray(nativeArray);
        DragDrop[] items = new DragDrop[itemsJ.length];
        for (int i = 0; i < itemsJ.length; i++) {
            JavaScriptObject dd = itemsJ[i];
            items[i] = new DragDrop(dd);
        }
        return items;
    }

    public void onDragDrop(EventObject e, String id) {

    }

    public void onDragDrop(EventObject e, DragDrop[] items) {

    }

    public void onDragEnter(EventObject e, String id) {

    }

    public void onDragEnter(EventObject e, DragDrop[] items) {

    }

    public void onDragOut(EventObject e, String id) {

    }

    public void onDragOut(EventObject e, DragDrop[] items) {

    }

    public void onDragOver(EventObject e, String id) {

    }

    public void onDragOver(EventObject e, DragDrop[] items) {

    }


    public void onInvalidDrop(EventObject e) {

    }

    public void onMouseDown(EventObject e) {

    }

    public void onMouseUp(EventObject e) {

    }


    public native Paddings getPadding() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var padding = dd.padding;
        return @com.gwtext.client.core.Paddings::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(padding);
    }-*/;

    public native void removeFromGroup(String sGroup) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.removeFromGroup(sGroup);
    }-*/;

    public native void removeInvalidHandleClass(String cssClass) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.removeInvalidHandleClass(cssClass);
    }-*/;

    public native void removeInvalidHandleId(String id) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.removeInvalidHandleId(id);
    }-*/;

    public native void removeInvalidHandleType(String tagName) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.removeInvalidHandleType(tagName);
    }-*/;

    public native void resetConstraints(boolean maintainOffset) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.resetConstraints(maintainOffset);
    }-*/;

    public native void setDragElId(String id) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.setDragElId(id);
    }-*/;

    public native void setHandleElId(String id) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.setHandleElId(id);
    }-*/;

    //in doc but missing from code?
    /*public native void setInitialPosition(int diffX, int diffY) *//*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.setInitialPosition(diffX, diffY);
    }-*//*;*/

    public native void setOuterHandleElId(String id) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.setOuterHandleElId(id);
    }-*/;

    public native void setPadding(int iUp, int iDown, int iBottom, int iLeft) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.setPadding(iUp, iDown, iBottom, iLeft);
    }-*/;

    public native void setXConstraint(int iLeft, int iRight, int iTickSize) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.setXConstraint(iLeft, iRight, iTickSize);
    }-*/;

    public native void setYConstraint(int iUp, int iDown, int iTickSize) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.setYConstraint(iUp, iDown, iTickSize);
    }-*/;


    public void startDrag(int x, int y) {
    }

    public native String toString() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return dd.toString();
    }-*/;

    public native void unlock() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.unlock();
    }-*/;

    public native void unreg() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.unreg();
    }-*/;
}
