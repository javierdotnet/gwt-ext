/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.Function;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.widgets.event.ResizableListener;

//http://extjs.com/forum/showthread.php?t=1138&highlight=Resizable
//http://extjs.com/forum/showthread.php?t=339&highlight=Resizable

//todo 'east', 'dd' docs missing from Ext
/**
 * Applies drag handles to an element to make it resizable. The drag handles are inserted into the element and
 * positioned absolute. Some elements, such as a textarea or image, don't support this. To overcome that, you
 * can wrap the textarea in a div and set "resizeChild" to true (or to the id of the element), or set wrap:true
 * in your config and the element will be wrapped for you automatically.
 */
public class Resizable extends JsObject {

    private Component lazyComponent;

    /**
     * Create a new resizable component. The component needs to be attached to the browser DOM.
     *
     * @param id     the element ID
     * @param config the resizable config
     */
    public Resizable(String id, ResizableConfig config) {
        jsObj = create(id, config.getJsObj());
    }

    /**
     * Create a new resizable component. The component needs to be attached to the browser DOM.
     *
     * @param elem   the element
     * @param config the resizable config
     */
    public Resizable(Element elem, ResizableConfig config) {
        jsObj = create(elem, config.getJsObj());
    }

    /**
     * Create a new resizable component.
     *
     * @param component the component
     * @param config    the resizable config
     */
    public Resizable(final Component component, final ResizableConfig config) {
        if (component.isRendered()) {
            jsObj = create(component.getId(), config == null ? null : config.getJsObj());
        } else {
            lazyComponent = component;
            component.addListener("render", new Function() {
                public void execute() {
                    jsObj = create(component.getId(), config == null ? null : config.getJsObj());
                }
            });
        }
    }

    private native JavaScriptObject create(String id, JavaScriptObject config)/*-{
        return new $wnd.Ext.Resizable(id, config);
    }-*/;

    private native JavaScriptObject create(Element elem, JavaScriptObject config)/*-{
        return new $wnd.Ext.Resizable(elem, config);
    }-*/;

    /**
     * Add a Resizable listener.
     *
     * @param listener the listener
     */
    public void addListener(final ResizableListener listener)  {
        if(lazyComponent != null) {
            lazyComponent.addListener("render", new Function(){
                public void execute() {
                    addListenerRendered(listener);
                }
            });
        } else {
            addListenerRendered(listener);
        }
    }

    private native void addListenerRendered(ResizableListener listener) /*-{
        var rz = this.@com.gwtext.client.core.JsObject::jsObj;
        var rzJ = this;

        rz.addListener('beforeresize',
                function(r, event) {
                    var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    return listener.@com.gwtext.client.widgets.event.ResizableListener::doBeforeResize(Lcom/gwtext/client/widgets/Resizable;Lcom/gwtext/client/core/EventObject;)(rzJ, eJ);
                }
        );
    
        rz.addListener('resize',
                function(r, w, h) {
                    listener.@com.gwtext.client.widgets.event.ResizableListener::onResize(Lcom/gwtext/client/widgets/Resizable;II)(rzJ, w, h);
                }
        );
    }-*/;


    public static class Handle {
        private String handle;

        private Handle(String handle) {
            this.handle = handle;
        }

        public String getHandle() {
            return handle;
        }
    }

    public static Handle NORTH = new Handle("n");
    public static Handle SOUTH = new Handle("s");
    public static Handle EAST = new Handle("e");
    public static Handle WEST = new Handle("w");
    public static Handle NORTH_WEST = new Handle("nw");
    public static Handle SOUTH_WEST = new Handle("sw");
    public static Handle SOUTH_EAST = new Handle("se");
    public static Handle NORTH_EAST = new Handle("ne");
    public static Handle ALL = new Handle("all");

}
