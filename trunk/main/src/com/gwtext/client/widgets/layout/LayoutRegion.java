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
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.layout.event.LayoutRegionListener;

public class LayoutRegion extends JsObject {

    protected LayoutRegion(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static LayoutRegion instance(JavaScriptObject jsObj) {
        return new LayoutRegion(jsObj);
    }

    public native ExtElement getBodyEl()/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        var bodyEL = layoutRegion.bodyEl;
        return bodyEL == null ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(bodyEL);
    }-*/;

    public native ExtElement getCollapsedEl()/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        var collapsedEL = layoutRegion.collapsedEl;
        return (collapsedEL == null || collapsedEL === undefined) ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(collapsedEL);
    }-*/;

    public native ExtElement getEl()/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        var el = layoutRegion.el;
        return el == null ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    public native ExtElement getTitleEl()/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        var titleEl = layoutRegion.titleEl;
        return titleEl == null ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(titleEl);
    }-*/;

    public native Element getTitleTextEl()/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        return layoutRegion.titleTextEl;
    }-*/;

    public native void add(ContentPanel panel) /*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        var contentPanel = panel.@com.gwtext.client.widgets.layout.ContentPanel::getJsObj()();
        layoutRegion.add(contentPanel);
    }-*/;

    public native void collapse() /*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        layoutRegion.collapse();
    }-*/;

    public native void collapse(boolean skipAnim) /*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        layoutRegion.collapse();
    }-*/;

    public native void expand() /*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        layoutRegion.collapse();
    }-*/;

    public native void expand(boolean skipAnim) /*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        layoutRegion.collapse(null, skipAnim);
    }-*/;

    public native ContentPanel getActivePanel()/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        var panel = layoutRegion.getActivePanel();
        return panel == null || panel === undefined ? null : @com.gwtext.client.widgets.layout.ContentPanel::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(panel);
    }-*/;

    public native ContentPanel getPanel(String contentPanelId)/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        var panel = layoutRegion.getPanel(contentPanelId);
        return panel == null || panel === undefined ? null : @com.gwtext.client.widgets.layout.ContentPanel::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(panel);
    }-*/;

    public native ContentPanel getPanel(int index)/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        var panel = layoutRegion.getPanel(index);
        return panel == null || panel === undefined ? null : @com.gwtext.client.widgets.layout.ContentPanel::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(panel);
    }-*/;

    public native String getPosition() /*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        return layoutRegion.getPosition();
    }-*/;

    public native TabPanel getTabs() /*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        var tabPanel = layoutRegion.getTabs();
        return tabPanel == null || tabPanel === undefined ? null : @com.gwtext.client.widgets.TabPanel::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tabPanel);
    }-*/;

    public native boolean hasPanel(String contentPanelId)/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        return layoutRegion.hasPanel(contentPanelId);
    }-*/;

    public native boolean hasPanel(int index)/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        return layoutRegion.hasPanel(index);
    }-*/;

    public native void hide() /*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        layoutRegion.hide();
    }-*/;

    public native void hidePanel(String contentPanelId)/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        layoutRegion.hidePanel(contentPanelId);
    }-*/;

    public native void hidePanel(int index)/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        layoutRegion.hidePanel(index);
    }-*/;

    public native boolean isVisible() /*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        return layoutRegion.isVisible();
    }-*/;

    public native void remove(String contentPanelId)/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        layoutRegion.remove(contentPanelId);
    }-*/;

    public native void remove(String contentPanelId, boolean preservePanel)/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        layoutRegion.remove(contentPanelId, preservePanel);
    }-*/;
    
    public native void remove(int index)/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        layoutRegion.remove(index);
    }-*/;

    public native void remove(int index, boolean preservePanel)/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        layoutRegion.remove(index, preservePanel);
    }-*/;

    public native void resizeTo(int newSize)/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        layoutRegion.resizeTo(newSize);
    }-*/;

    public native void setCollapsedTitle(String title) /*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        layoutRegion.setCollapsedTitle(title);
    }-*/;

    public native void show() /*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        layoutRegion.show();
    }-*/;

    public native void showPanel(String contentPanelId)/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        layoutRegion.showPanel(contentPanelId);
    }-*/;

    public native void showPanel(int index)/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        layoutRegion.showPanel(index);
    }-*/;

    public native void unhidePanel(String contentPanelId)/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        layoutRegion.unhidePanel(contentPanelId);
    }-*/;

    public native void unhidePanel(int index)/*-{
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;
        layoutRegion.unhidePanel(index);
    }-*/;

    public native void addLayoutRegionListener(LayoutRegionListener listener)/*-{
        var layoutRegionJ = this;
        var layoutRegion = this.@com.gwtext.client.core.JsObject::jsObj;

        layoutRegion.addListener('beforeremove',
                function(region, panel) {
                    var panelJ = @com.gwtext.client.widgets.layout.ContentPanel::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(panel);
                    return listener.@com.gwtext.client.widgets.layout.event.LayoutRegionListener::doBeforeRemove(Lcom/gwtext/client/widgets/layout/LayoutRegion;Lcom/gwtext/client/widgets/layout/ContentPanel;)(layoutRegionJ, panelJ);
                }
        );

        layoutRegion.addListener('collapsed',
                function(region) {
                    listener.@com.gwtext.client.widgets.layout.event.LayoutRegionListener::onCollapsed(Lcom/gwtext/client/widgets/layout/LayoutRegion;)(layoutRegionJ);
                }
        );

        layoutRegion.addListener('expanded',
                function(region) {
                    listener.@com.gwtext.client.widgets.layout.event.LayoutRegionListener::onExpanded(Lcom/gwtext/client/widgets/layout/LayoutRegion;)(layoutRegionJ);
                }
        );

        layoutRegion.addListener('invalidated',
                function(region) {
                    listener.@com.gwtext.client.widgets.layout.event.LayoutRegionListener::onInvalidated(Lcom/gwtext/client/widgets/layout/LayoutRegion;)(layoutRegionJ);
                }
        );

        layoutRegion.addListener('panelactivated',
                function(region, panel) {
                    var panelJ = @com.gwtext.client.widgets.layout.ContentPanel::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(panel);
                    return listener.@com.gwtext.client.widgets.layout.event.LayoutRegionListener::onPanelActivated(Lcom/gwtext/client/widgets/layout/LayoutRegion;Lcom/gwtext/client/widgets/layout/ContentPanel;)(layoutRegionJ, panelJ);
                }
        );    

        layoutRegion.addListener('paneladded',
                function(region, panel) {
                    var panelJ = @com.gwtext.client.widgets.layout.ContentPanel::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(panel);
                    return listener.@com.gwtext.client.widgets.layout.event.LayoutRegionListener::onPanelAdded(Lcom/gwtext/client/widgets/layout/LayoutRegion;Lcom/gwtext/client/widgets/layout/ContentPanel;)(layoutRegionJ, panelJ);
                }
        ); 

        layoutRegion.addListener('panelremoved',
                function(region, panel) {
                    var panelJ = @com.gwtext.client.widgets.layout.ContentPanel::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(panel);
                    return listener.@com.gwtext.client.widgets.layout.event.LayoutRegionListener::onPanelRemoved(Lcom/gwtext/client/widgets/layout/LayoutRegion;Lcom/gwtext/client/widgets/layout/ContentPanel;)(layoutRegionJ, panelJ);
                }
        ); 
    
        layoutRegion.addListener('resized',
                function(region, newSize) {
                    listener.@com.gwtext.client.widgets.layout.event.LayoutRegionListener::onResized(Lcom/gwtext/client/widgets/layout/LayoutRegion;I)(layoutRegionJ, newSize);
                }
        );

        layoutRegion.addListener('slidehide',
                function(region) {
                    listener.@com.gwtext.client.widgets.layout.event.LayoutRegionListener::onSlideHide(Lcom/gwtext/client/widgets/layout/LayoutRegion;)(layoutRegionJ);
                }
        );

        layoutRegion.addListener('slideshow',
                function(region) {
                    listener.@com.gwtext.client.widgets.layout.event.LayoutRegionListener::onSlideShow(Lcom/gwtext/client/widgets/layout/LayoutRegion;)(layoutRegionJ);
                }
        );

        layoutRegion.addListener('visibilitychange',
                function(region, visibility) {
                    listener.@com.gwtext.client.widgets.layout.event.LayoutRegionListener::onVisibilityChange(Lcom/gwtext/client/widgets/layout/LayoutRegion;Z)(layoutRegionJ, visibility);
                }
        );            
    }-*/;
}
