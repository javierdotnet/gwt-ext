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
public class Resizable extends BaseExtWidget {

    public Resizable(String id, ResizableConfig config) {
        jsObj = create(id, config.getJsObj());
    }

    public Resizable(Element elem, ResizableConfig config) {
        jsObj = create(elem, config.getJsObj());
    }

    private native JavaScriptObject create(String id, JavaScriptObject config)/*-{
        return new $wnd.Ext.Resizable(id, config);
    }-*/;

    private native JavaScriptObject create(Element elem, JavaScriptObject config)/*-{
        return new $wnd.Ext.Resizable(elem, config);
    }-*/;

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
}
