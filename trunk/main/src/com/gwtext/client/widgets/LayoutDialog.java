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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.Function;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.util.KeyMapConfig;
import com.gwtext.client.widgets.event.DialogListener;
import com.gwtext.client.widgets.event.KeyListener;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.LayoutRegionConfig;

public class LayoutDialog extends BaseExtWidget {

    /**
     * Creates a Dialog with only a center region. i.e a Basic Dialog
     *
     * @param config
     * @param center
     */
    public LayoutDialog(LayoutDialogConfig config, LayoutRegionConfig center) {
        this(config, null, null, null, null, center);
    }

    public LayoutDialog(LayoutDialogConfig config, LayoutRegionConfig north, LayoutRegionConfig south, LayoutRegionConfig west, LayoutRegionConfig east, LayoutRegionConfig center) {
        JavaScriptObject configJS = config.getJsObj();

        //in GWT we always want the dialog to be autocreated
        JavaScriptObjectHelper.setAttribute(configJS, "autoCreate", true);
        if (north != null) JavaScriptObjectHelper.setAttribute(configJS, "north", north.getJsObj());
        if (south != null) JavaScriptObjectHelper.setAttribute(configJS, "south", south.getJsObj());
        if (west != null) JavaScriptObjectHelper.setAttribute(configJS, "west", west.getJsObj());
        if (east != null) JavaScriptObjectHelper.setAttribute(configJS, "east", east.getJsObj());
        if (center != null) JavaScriptObjectHelper.setAttribute(configJS, "center", center.getJsObj());
        jsObj = create(Ext.generateId(), configJS);
    }

    public LayoutDialog(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static LayoutDialog instance(JavaScriptObject jsObj) {
        return new LayoutDialog(jsObj);
    }

    private native JavaScriptObject create(String id, JavaScriptObject configJS) /*-{
        return new $wnd.Ext.LayoutDialog(id, configJS);
    }-*/;

    public native Button addButton(String text) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var buttonJS = dialog.addButton(text);
        return @com.gwtext.client.widgets.Button::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(buttonJS);
    }-*/;

    public native void addKeyListener(int keyCode, KeyListener listener)/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.addKeyListener(keyCode, function(dlg, key, event) {
              var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
              listener.@com.gwtext.client.widgets.event.KeyListener::onKey(ILcom/gwtext/client/core/EventObject;)(key, e);
            });
    }-*/;

    public native void addKeyListener(int[] keyCodes, KeyListener listener)/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var keyCodesJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(keyCodes);
        dialog.addKeyListener(keyCodesJS, function(dlg, key, event) {
              var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
              listener.@com.gwtext.client.widgets.event.KeyListener::onKey(ILcom/gwtext/client/core/EventObject;)(key, e);
            });
    }-*/;

    public native void addKeyListener(KeyMapConfig config, KeyListener listener)/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        dialog.addKeyListener(configJS, function(dlg, key, event) {
              var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
              listener.@com.gwtext.client.widgets.event.KeyListener::onKey(ILcom/gwtext/client/core/EventObject;)(key, e);
            });
    }-*/;

    public Button addButton(Button button) {
        Element buttonEl = button.getElement();
        if (buttonEl != null) {
            Element parent = DOM.getParent(buttonEl);
            if (parent != null) {
                DOM.removeChild(parent, buttonEl);
            }
        }
        JavaScriptObject btnJS = doAddButton(button);
        button.setJsObj(btnJS);
        return button;
    }

    private native JavaScriptObject doAddButton(Button button) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var buttonJS = button.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return dialog.addButton(buttonJS);
    }-*/;

    public native void alignTo(String id, String position, int[] offsetXY)/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var offsetJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(offsetXY);
        dialog.alignTo(id, position, offsetJS);
    }-*/;

    public native void anchorTo(String id, String position, int[] offsetXY, int bufferDelay)/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var offsetJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(offsetXY);
        dialog.anchorTo(id, position, offsetJS, bufferDelay);
    }-*/;

    public native void center() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.show();
    }-*/;

    public native void collapse() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.collapse();
    }-*/;

    public native void destroy() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.destroy();
    }-*/;

    public native void destroy(boolean removeEL) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.destroy(removeEL);
    }-*/;

    public native void expand() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.expand();
    }-*/;

    public native void focus() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.focus();
    }-*/;

    public BorderLayout getLayout() {
        return new BorderLayout(getLayout(jsObj));
    }

    private native JavaScriptObject getLayout(JavaScriptObject layoutDialog) /*-{
        return layoutDialog.getLayout();
    }-*/;

    public native ExtElement getHeaderEl()/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var header = dialog.header;
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(header);
    }-*/;

    public native ExtElement getBodyEl()/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var body = dialog.body;
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(body);
    }-*/;

    public native ExtElement getFooterEl()/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var footer = dialog.footer;
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(footer);
    }-*/;

    public native TabPanel getTabs()/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var tabs = dialog.getTabs();
        return tabs == null ? null : @com.gwtext.client.widgets.TabPanel::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tabs);
    }-*/;

    public native void hide() /*-{
            var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            dialog.hide();
    }-*/;

    public native void hide(Function cb) /*-{
            var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            dialog.hide(function() {
                cb.@com.gwtext.client.core.Function::execute()();
            });
    }-*/;

    public native TabPanel initTabs() /*-{
            var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            var tabs = dialog.initTabs();
            return tabs == null ? null : @com.gwtext.client.widgets.TabPanel::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tabs);
    }-*/;

    public native boolean isVisible() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return dialog.isVisible();
    }-*/;

    public native void moveTo(int x, int y) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.moveTo(x, y);
    }-*/;

    public native void resizeTo(int width, int height) /*-{
            var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            dialog.resizeTo(width, height);
    }-*/;

    public native void restoreState() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.restoreState();
    }-*/;

    public native void setContentSize(int width, int height) /*-{
            var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            dialog.setContentSize(width, height);
    }-*/;

    public native void setDefaultButton(Button btn) /*-{
            var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            var btnJS = btn.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            dialog.setDefaultButton(btnJS);
    }-*/;

    public native void setTitle(String title) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.setTitle(title);
    }-*/;

    public native void show() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.show();
    }-*/;

    public native void show(String animateTargetId) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.show(animateTargetId);
    }-*/;

    public native void show(Element target) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.show(target);
    }-*/;

    public native void show(ExtElement target) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var targetJS = target.@com.gwtext.client.core.JsObject::jsObj;
        dialog.show(targetJS);
    }-*/;

    public native void toBack() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.toBack();
    }-*/;

    public native void toFront() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.toFront();
    }-*/;

    public native void addDialogListener(DialogListener listener)/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var dialogJ = this;

        dialog.addListener('beforehide',
                function(source) {
                    return listener.@com.gwtext.client.widgets.event.DialogListener::doBeforeHide(Lcom/gwtext/client/widgets/LayoutDialog;)(dialogJ);
                }
        );

        dialog.addListener('beforeshow',
                function(source) {
                    return listener.@com.gwtext.client.widgets.event.DialogListener::doBeforeShow(Lcom/gwtext/client/widgets/LayoutDialog;)(dialogJ);
                }
        );
    
        dialog.addListener('hide',
                function(source) {
                    listener.@com.gwtext.client.widgets.event.DialogListener::onHide(Lcom/gwtext/client/widgets/LayoutDialog;)(dialogJ);
                }
        );

        dialog.addListener('keydown',
                function(source, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.event.DialogListener::onKeyDown(Lcom/gwtext/client/widgets/LayoutDialog;Lcom/gwtext/client/core/EventObject;)(dialogJ, e);
                }
        );

        dialog.addListener('move',
                function(source, x, y) {
                    listener.@com.gwtext.client.widgets.event.DialogListener::onMove(Lcom/gwtext/client/widgets/LayoutDialog;II)(dialogJ, x, y);
                }
        );

        dialog.addListener('resize',
                function(source, width, height) {
                    listener.@com.gwtext.client.widgets.event.DialogListener::onResize(Lcom/gwtext/client/widgets/LayoutDialog;II)(dialogJ, width, height);
                }
        );
                
        dialog.addListener('show',
                function(source) {
                    listener.@com.gwtext.client.widgets.event.DialogListener::onShow(Lcom/gwtext/client/widgets/LayoutDialog;)(dialogJ);
                }
        );
    }-*/;
}
