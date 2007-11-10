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

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
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
public class Resizable extends BaseExtWidget {

    /**
     * Create a new resizable component. The component needs to be attached to the browser DOM.
     * 
     * @param id the element ID
     * @param config the resizable config
     */
    public Resizable(String id, ResizableConfig config) {
        jsObj = create(id, config.getJsObj());
    }

    /**
     * Create a new resizable component. The component needs to be attached to the browser DOM.
     *
     * @param elem the element
     * @param config the resizable config
     */
    public Resizable(Element elem, ResizableConfig config) {
        jsObj = create(elem, config.getJsObj());
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
    public native void addResizableListener(ResizableListener listener) /*-{
        var rz = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
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


    public static class  Handle {
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
    public static Handle SOUTH_EAST= new Handle("se");
    public static Handle NORTH_EAST = new Handle("ne");
    public static Handle ALL = new Handle("all");

}
