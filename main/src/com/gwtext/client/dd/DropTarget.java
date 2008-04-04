/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.dd;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Component;

public class DropTarget extends DDTarget {

    static {
        init();
    }

    private static native void init() /*-{

         $wnd.Ext.dd.DropTarget.prototype.notifyDrop = function(source, e, data) {
             var ddJ = this.ddJ;
             if(ddJ != null) {
                 var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
                 var sourceJ = @com.gwtext.client.dd.DragSource::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
                 var dataJ = data == null || data == undefined ? null : @com.gwtext.client.dd.DragData::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
                 return ddJ.@com.gwtext.client.dd.DropTarget::notifyDrop(Lcom/gwtext/client/dd/DragSource;Lcom/gwtext/client/core/EventObject;Lcom/gwtext/client/dd/DragData;)(sourceJ, eJ, dataJ);
             }
         }

        $wnd.Ext.dd.DropTarget.prototype.notifyEnter = function(source, e, data) {
             var ddJ = this.ddJ;
             if(ddJ != null) {
                 var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
                 var sourceJ = @com.gwtext.client.dd.DragSource::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
                 var dataJ = data == null || data == undefined ? null : @com.gwtext.client.dd.DragData::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
                 return ddJ.@com.gwtext.client.dd.DropTarget::notifyEnter(Lcom/gwtext/client/dd/DragSource;Lcom/gwtext/client/core/EventObject;Lcom/gwtext/client/dd/DragData;)(sourceJ, eJ, dataJ);
             }
         }

        $wnd.Ext.dd.DropTarget.prototype.notifyOut = function(source, e, data) {
             var ddJ = this.ddJ;
             if(ddJ != null) {
                 var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
                 var sourceJ = @com.gwtext.client.dd.DragSource::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
                 var dataJ = data == null || data == undefined ? null : @com.gwtext.client.dd.DragData::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
                 ddJ.@com.gwtext.client.dd.DropTarget::notifyOut(Lcom/gwtext/client/dd/DragSource;Lcom/gwtext/client/core/EventObject;Lcom/gwtext/client/dd/DragData;)(sourceJ, eJ, dataJ);
             }
         }

        $wnd.Ext.dd.DropTarget.prototype.notifyOver = function(source, e, data) {
             var ddJ = this.ddJ;
             if(ddJ != null) {
                 var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
                 var sourceJ = @com.gwtext.client.dd.DragSource::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
                 var dataJ = data == null || data == undefined ? null : @com.gwtext.client.dd.DragData::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
                 return ddJ.@com.gwtext.client.dd.DropTarget::notifyOver(Lcom/gwtext/client/dd/DragSource;Lcom/gwtext/client/core/EventObject;Lcom/gwtext/client/dd/DragData;)(sourceJ, eJ, dataJ);
             }
         }

    }-*/;

    public DropTarget(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public DropTarget(String id,  DropTargetConfig config) {
        super(id, null, config);
    }

    public DropTarget(Element element, DropTargetConfig config) {
        super(element, null, config);
    }

    public DropTarget(Component component, DropTargetConfig config) {
        super(component, null, config);
    }

    protected native JavaScriptObject create(String id, String sGroup, JavaScriptObject config)/*-{
        return new $wnd.Ext.dd.DropTarget(id, config);
    }-*/;

    protected native JavaScriptObject create(Element element, String sGroup, JavaScriptObject config)/*-{
        return new $wnd.Ext.dd.DropTarget(element, config);
    }-*/;

    /**
     * The function {@link DragSource} calls once to notify this drop target that the dragged item has been dropped on it.
     * This method has no default implementation and returns false, so you must provide an implementation that does something
     * to process the drop event and returns true so that the drag source's repair action does not run.
     *
     * @param source the drag source
     * @param e      the event object
     * @param data   an object containing arbitrary data supplied by the drag source
     * @return true if the drop was valid, else false
     */
    public boolean notifyDrop(DragSource source, EventObject e, DragData data) {
        return false;
    }

    /**
     * The function a {@link DragSource} calls once to notify this drop target that the source is now over the target. This
     * default implementation adds the CSS class specified by overClass (if any) to the drop element and
     * returns the dropAllowed config value. This method should be overridden if drop validation is required.
     *
     * @param source The drag source that was dragged over this drop target
     * @param e      The event
     * @param data   An object containing arbitrary data supplied by the drag source
     * @return The CSS class that communicates the drop status back to the source so that the underlying {@link StatusProxy} can be updated
     */
    public String notifyEnter(DragSource source, EventObject e, DragData data) {
        return "";
    }

    /**
     * The function a Ext.dd.DragSource calls once to notify this drop target that the source has been dragged out of the target
     * without dropping. This default implementation simply removes the CSS class specified by overClass (if any) from the drop element.
     *
     * @param source
     * @param e
     * @param data
     */
    public void notifyOut(DragSource source, EventObject e, DragData data) {
    }

    public String notifyOver(DragSource source, EventObject e, DragData data) {
        return "";
    }

}
