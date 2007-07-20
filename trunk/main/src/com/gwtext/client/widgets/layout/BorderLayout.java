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

package com.gwtext.client.widgets.layout;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.Size;
import com.gwtext.client.state.Provider;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.BaseExtWidget;
import com.gwtext.client.widgets.layout.event.LayoutListener;

public class BorderLayout extends BaseExtWidget {

    private boolean hasContentPanel;

    public BorderLayout(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public BorderLayout(String width, String height, LayoutRegionConfig north, LayoutRegionConfig south, LayoutRegionConfig west, LayoutRegionConfig east, LayoutRegionConfig center) {
        // Create div to draw layout into
        Element divElement = DOM.createDiv();
        setElement(divElement);
        setHeight(height);
        setWidth(width);
        RootPanel.get().add(this);

        jsObj = createBorderLayout(getElement(), north, south, west, east, center);
    }

    private static JavaScriptObject createBorderLayout(Element elem, LayoutRegionConfig north, LayoutRegionConfig south, LayoutRegionConfig west, LayoutRegionConfig east, LayoutRegionConfig center) {
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        if (north != null) JavaScriptObjectHelper.setAttribute(config, "north", north.getJsObj());
        if (south != null) JavaScriptObjectHelper.setAttribute(config, "south", south.getJsObj());
        if (west != null) JavaScriptObjectHelper.setAttribute(config, "west", west.getJsObj());
        if (east != null) JavaScriptObjectHelper.setAttribute(config, "east", east.getJsObj());
        if (center != null) JavaScriptObjectHelper.setAttribute(config, "center", center.getJsObj());
        JavaScriptObject jsobj = create(elem, config);
        return jsobj;
    }

    private static native JavaScriptObject create(Element elem, JavaScriptObject config)/*-{
         return new $wnd.Ext.BorderLayout(elem, config);
    }-*/;


    private static native void add(JavaScriptObject borderLayout, String direction, JavaScriptObject panel) /*-{
       borderLayout.add(direction, panel);
    }-*/;

    boolean getHasContentPanel() {
        return hasContentPanel;
    }

    /**
     * add content to target region as a widget. The contentId has to be a unique value.
     * This takes config parameters as an object which let you have more control over the
     * region.
     */
    public void add(LayoutRegionConfig.LayoutRegionConstant direction, ContentPanel contentPanel) {
        hasContentPanel = true;
        add(jsObj, direction.getDirection(), contentPanel.getJsObj());
    }

    //TODO add batch?
    //http://extjs.com/forum/showthread.php?t=5136&highlight=LayoutDialog+dynamic

    /**
     *
     * @deprecated Use {@link #add(com.gwtext.client.widgets.layout.LayoutRegionConfig.LayoutRegionConstant, ContentPanel)}
     */
/*    public void add(Widget w) {
        throw new IllegalArgumentException("This method is not supported for BorderLayout")
        //add(w, getElement());
    }*/

    public native boolean isMonitorWindowResize() /*-{
        var layout = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return layout.monitorWindowResize;
    }-*/;

    public native void setMonitorWindowResize(boolean monitorWindowResize) /*-{
        var layout = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return layout.monitorWindowResize = monitorWindowResize;
    }-*/;

    public void beginUpdate() {
        beginUpdate(jsObj);
    }

    public void endUpdate() {
        endUpdate(jsObj, false);
    }

    public void endUpdate(boolean noLayout) {
        endUpdate(jsObj, noLayout);
    }

    private static native void beginUpdate(JavaScriptObject borderLayout) /*-{
         borderLayout.beginUpdate();
    }-*/;

    private static native void endUpdate(JavaScriptObject borderLayout, boolean noLayout) /*-{
        borderLayout.endUpdate(noLayout);
    }-*/;

    public ContentPanel findPanel(String contentId) {
        JavaScriptObject panel = findPanel(jsObj, contentId);
        return panel == null ? null : new ContentPanel(panel);
    }

    private static native JavaScriptObject findPanel(JavaScriptObject borderLayout, String contentId)/*-{
         return borderLayout.findPanel(contentId);
    }-*/;

    private static native JavaScriptObject getEl(JavaScriptObject borderLayout)/*-{
        return borderLayout.getEl();
    }-*/;

    public LayoutRegion getRegion(LayoutRegionConfig.LayoutRegionConstant direction) {
        return new LayoutRegion(getRegion(jsObj, direction.getDirection()));
    }

    private native JavaScriptObject getRegion(JavaScriptObject borderLayout, String direction)/*-{
        return borderLayout.getRegion(direction);
    }-*/;

    public Size getViewSize() {
        JavaScriptObject size = getViewSize(jsObj);
        int height = JavaScriptObjectHelper.getAttributeAsInt(size, "height");
        int width = JavaScriptObjectHelper.getAttributeAsInt(size, "width");
        return new Size(width, height);
    }

    private static native JavaScriptObject getViewSize(JavaScriptObject borderLayout) /*-{
         return borderLayout.getViewSize();
    }-*/;

    public native boolean isUpdating() /*-{
        var layout = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return layout.isUpdating();
    }-*/;

    public native void layout()/*-{
        var layout = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        layout.layout();
    }-*/;

    /**
     * Remove content from target region. The content layout must be connected to
     * main DOM before this operation canbe performed.
     */
    public void remove(LayoutRegionConfig.LayoutRegionConstant direction, String contentId) {
        remove(jsObj, direction.getDirection(), contentId);
    }

    private native void remove(JavaScriptObject borderLayout, String regionId, String contentId) /*-{
        borderLayout.remove(regionId, contentId);
    }-*/;

    public native void restoreState()/*-{
        var layout = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        layout.restoreState();
    }-*/;
    
    public void restoreState(Provider provider) {
        JavaScriptObject jsProviderObj = provider == null ? null : provider.getJsObj();
        restoreState(jsObj, jsProviderObj);
    }

    public static native void restoreState(JavaScriptObject borderLayout, JavaScriptObject provider) /*-{
        borderLayout.restoreState(provider);
    }-*/;

    public ContentPanel showPanel(String contentId) {
        JavaScriptObject panel = showPanel(jsObj, contentId);
        return panel == null ? null : new ContentPanel(panel);
    }

    private static native JavaScriptObject showPanel(JavaScriptObject borderLayout, String contentId)/*-{
        return borderLayout.showPanel(contentId);
    }-*/;


    public native void addLayoutListener(LayoutListener listener) /*-{
        var layout = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var layoutJ = this;

        layout.addListener('layout',
            function(source) {
                listener.@com.gwtext.client.widgets.layout.event.LayoutListener::onLayout(Lcom/gwtext/client/widgets/layout/BorderLayout;)(layoutJ );
            }
        );
        layout.addListener('regioncollapsed',
            function(region) {
                var regionJ = @com.gwtext.client.widgets.layout.LayoutRegion::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(region);
                listener.@com.gwtext.client.widgets.layout.event.LayoutListener::onRegionCollapsed(Lcom/gwtext/client/widgets/layout/LayoutRegion;)(regionJ);
            }
        );
        layout.addListener('regionexpanded',
            function(region) {
                var regionJ = @com.gwtext.client.widgets.layout.LayoutRegion::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(region);
                listener.@com.gwtext.client.widgets.layout.event.LayoutListener::onRegionExpanded(Lcom/gwtext/client/widgets/layout/LayoutRegion;)(regionJ);
            }
        );
        layout.addListener('regionresized',
            function(region, newSize) {
                var regionJ = @com.gwtext.client.widgets.layout.LayoutRegion::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(region);
                listener.@com.gwtext.client.widgets.layout.event.LayoutListener::onRegionResized(Lcom/gwtext/client/widgets/layout/LayoutRegion;I)(regionJ, newSize);
            }
        );
    }-*/;
}
