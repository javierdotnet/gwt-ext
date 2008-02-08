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
import com.gwtext.client.core.Box;
import com.gwtext.client.core.Size;
import com.gwtext.client.widgets.event.BoxComponentListener;

/**
 * Base class for any visual {@link Component} that uses a box container. BoxComponent provides automatic box model adjustments
 * for sizing and positioning and will work correctly withnin the Component rendering model. All container classes should subclass
 * BoxComponent so that they will work consistently when nested within other Ext layout containers.
 */
public abstract class BoxComponent extends Component {

    protected BoxComponent() {
    }

    public BoxComponent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Gets the current box measurements of the component's.
     * 
     * @return the box measurements
     */
    public native Box getBox()/*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var boxJS = component.getBox();
        return @com.gwtext.client.core.Box::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(boxJS);
    }-*/;

    /**
     * Gets the current box measurements of the component's.
     *
     * @param local if true the element's left and top are returned instead of page XY (defaults to false)
     * @return the box measurements
     */
    public native Box getBox(boolean local)/*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var boxJS = component.getBox(local);
        return @com.gwtext.client.core.Box::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(boxJS);
    }-*/;

    /**
     * Gets the current size of the component's underlying element.
     *
     * @return the components Size
     */
    public native Size getSize()/*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var sizeJS = component.getSize();
        return @com.gwtext.client.core.Size::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(sizeJS);
    }-*/;

    /**
     * Sets the page XY position of the component. To set the left and top instead, use setPosition.
     * This method fires the move event.
     * 
     * @param x the new X position
     * @param y the new Y opsition
     */
    public native void setPagePosition(int x, int y) /*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        component.setPagePosition(x, y);            
    }-*/;

    /**
     * Sets the left and top of the component. To set the page XY position instead, use setPagePosition.
     * This method fires the move event.
     * 
     * @param left the new left
     * @param top the new right
     */
    public native void setPosition(int left, int top) /*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        component.setPosition(left, top);
    }-*/;

    /**
     * Sets the width and height of the component. This method fires the resize event.
     *
     * @param width the new width
     * @param height the new height
     */
    public native void setSize(int width, int height) /*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        component.setSize(width, height);
    }-*/;

    /**
     * Force the component's size to recalculate based on the underlying element's current height and width.
     */
    public native void syncSize()/*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        component.syncSize();
    }-*/;

    /**
     * Sets the current box measurements of the component's underlying element.
     *
     * @param box the new box measurements
     */
    public native void updateBox(Box box)/*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var boxJS = box.@com.gwtext.client.core.JsObject::jsObj;
        component.updateBox(boxJS);                    
    }-*/;

    /**
     * Add a Component listener.
     *
     * @param listener the listener
     */
    public native void addComponentListener(BoxComponentListener listener) /*-{
        var componentJ = this;
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;

        component.addListener('move',
                function(source, x, y) {
                    listener.@com.gwtext.client.widgets.event.BoxComponentListener::onMove(Lcom/gwtext/client/widgets/BoxComponent;II)(componentJ, x, y)
                }
        );

        component.addListener('resize',
                function(source, adjWidth, adjHeight, rawWidth, rawHeight) {
                    listener.@com.gwtext.client.widgets.event.BoxComponentListener::onResize(Lcom/gwtext/client/widgets/BoxComponent;IIII)(componentJ, adjWidth, adjHeight, rawWidth, rawHeight);
                }
        );
    }-*/;
}
