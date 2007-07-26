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
import com.gwtext.client.widgets.event.ComponentListener;

//should be abstract but since ComponentMgr requires to return Component, making it concrete
public class Component extends BaseExtWidget {
    protected Component() {
    }

    public Component(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static Component instance(JavaScriptObject jsObj) {
        return new Component(jsObj);   
    }

    public native void disable() /*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        component.disable();
    }-*/;

    public native void enable() /*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        component.enable();
    }-*/;

    public native void focus(boolean selectText) /*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        component.focus(selectText);
    }-*/;

    public native String getId() /*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return component.getId();
    }-*/;

    public native void hide() /*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        component.hide();
    }-*/;

    public native boolean isVisible() /*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return component.isVisible();
    }-*/;

    public native void setVisible(boolean visible) /*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        component.setVisible(visible);
    }-*/;

    public native boolean isHidden() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return field.hidden;
    }-*/;

    public native void setDisabled(boolean disabled) /*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        component.setDisabled(disabled);
    }-*/;

    public native boolean isDisabled() /*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return component.disabled;
    }-*/;

    public native void setDisabledClass(String disabledClass) /*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        component.disabledClass = disabledClass;
    }-*/;

    public native String getDisabledClass() /*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return field.disabledClass();
    }-*/;

    public native void show() /*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        component.show();
    }-*/;

    /**
     * If this is a lazy rendering component, render it to its container element
     */
    public native void render() /*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        component.render();
    }-*/;

    public native void render(String id) /*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        component.render(id);
    }-*/;

    public native void render(Element element) /*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        component.render(element);
    }-*/;

    public native boolean isRendered() /*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return component.rendered;
    }-*/;


    /*    public native void render(JavaScriptObject parentElement) *//*-{
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        component.render(parentElement);
    }-*//*;*/

    public native void addComponentListener(ComponentListener listener) /*-{
        var componentJ = this;
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;

        component.addListener('beforedestroy',
                function(source) {
                    return listener.@com.gwtext.client.widgets.event.ComponentListener::doBeforeDestroy(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );

        component.addListener('beforehide',
                function(source) {
                    return listener.@com.gwtext.client.widgets.event.ComponentListener::doBeforeHide(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );
        component.addListener('beforerender',
                function(source) {
                    return listener.@com.gwtext.client.widgets.event.ComponentListener::doBeforeRender(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );
        component.addListener('beforeshow',
                function(source) {
                    return listener.@com.gwtext.client.widgets.event.ComponentListener::doBeforeShow(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );
        component.addListener('destroy',
                function(source) {
                    listener.@com.gwtext.client.widgets.event.ComponentListener::onDestroy(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );
        component.addListener('disable',
                function(source) {
                    listener.@com.gwtext.client.widgets.event.ComponentListener::onDisable(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );
        component.addListener('enable',
                function(source) {
                    listener.@com.gwtext.client.widgets.event.ComponentListener::onEnable(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );
        component.addListener('hide',
                function(source) {
                    listener.@com.gwtext.client.widgets.event.ComponentListener::onHide(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );
        component.addListener('render',
                function(source) {
                    listener.@com.gwtext.client.widgets.event.ComponentListener::onRender(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );
        component.addListener('show',
                function(source) {
                    listener.@com.gwtext.client.widgets.event.ComponentListener::onShow(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );
    }-*/;

}
