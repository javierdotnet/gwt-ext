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
 

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.Function;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.widgets.event.ResizableListener;

//http://extjs.com/forum/showthread.php?t=1138&highlight=Resizable
//http://extjs.com/forum/showthread.php?t=339&highlight=Resizable

//todo 'east', 'dd' docs missing from Ext
/**
 * Applies drag handles to an element to make it resizable. The drag handles are inserted into the element and
 * positioned absolute. Some elements, such as a textarea or image, don't support this. To overcome that, you
 * can wrap the textarea in a div and set "resizeChild" to true (or to the id of the element), or set wrap:true
 * in your config and the element will be wrapped for you automatically.
 *
 * @author Sanjiv Jivan
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
	 * Destroys this resizable. If the element was wrapped and removeEl is not true then the element remains.
	 */
	public native void destroy() /*-{
        var resizable = this.@com.gwtext.client.core.JsObject::getJsObj()();
        resizable.destroy();
    }-*/;	

	/**
	 * Destroys this resizable. If the element was wrapped and removeEl is not true then the element remains.
	 *
	 * @param removeEL true to remove the element from the DOM
	 */
	public native void destroy(boolean removeEL) /*-{
        var resizable = this.@com.gwtext.client.core.JsObject::getJsObj()();
        resizable.destroy(removeEL);
    }-*/;

	/**
	 * Returns the element this component is bound to.
	 *
	 * @return the element this component is bound to.
	 */
	public native ExtElement getEl() /*-{
        var resizable = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var el = resizable.getEl();
		return el == null || el === undefined ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el); 
	}-*/;

	/**
	 * Perform a manual resize.
	 * 
	 * @param width the width
	 * @param height the height
	 */
	public native void resizeTo(int width, int height) /*-{
        var resizable = this.@com.gwtext.client.core.JsObject::getJsObj()();
        resizable.resizeTo(width, height);
	}-*/;

	/**
	 * Sets the visibilty of a given handle. The Resizable must be configured with this handle for this method to apply.
	 *
	 * @param handle the handle
	 * @param visible visibility of handle
	 */
	public native void setVisibility(Handle handle, boolean visible) /*-{
        var resizable = this.@com.gwtext.client.core.JsObject::getJsObj()();

		var handleVal = handle.@com.gwtext.client.widgets.Resizable.Handle::getHandle()();
		var pos = $wnd.Ext.Resizable.positions[handleVal];
		var h = resizable[pos];
		if(h != null && h !== undefined) {
			h.el.setDisplayed(visible);
		}
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
        var rz = this.@com.gwtext.client.core.JsObject::getJsObj()();
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
