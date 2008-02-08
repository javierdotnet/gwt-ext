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

/**
 * Lightweight Dialog Class.
 */
public class LayoutDialog extends BaseExtWidget {

    /**
     * Creates a Dialog with only a center region. i.e a Basic Dialog
     *
     * @param config the dialog config
     * @param center the center region config
     */
    public LayoutDialog(LayoutDialogConfig config, LayoutRegionConfig center) {
        this(config, null, null, null, null, center);
    }

	/**
	 * Creates a LayoutDialog.
	 *
	 * @param config the dialog config
	 * @param north the north region config
	 * @param south the south region config
	 * @param west the west region config
	 * @param east the east region config
	 * @param center the center rgion config
	 */
	public LayoutDialog(LayoutDialogConfig config, LayoutRegionConfig north, LayoutRegionConfig south, LayoutRegionConfig west, LayoutRegionConfig east, LayoutRegionConfig center) {
        JavaScriptObject configJS = config.getJsObj();

        //in GWT we always want the dialog to be autocreated
        JavaScriptObjectHelper.setAttribute(configJS, "autoCreate", true);
        if (north != null) JavaScriptObjectHelper.setAttribute(configJS, "north", north.getJsObj());
        if (south != null) JavaScriptObjectHelper.setAttribute(configJS, "south", south.getJsObj());
        if (west != null) JavaScriptObjectHelper.setAttribute(configJS, "west", west.getJsObj());
        if (east != null) JavaScriptObjectHelper.setAttribute(configJS, "east", east.getJsObj());
        if (center != null) JavaScriptObjectHelper.setAttribute(configJS, "center", center.getJsObj());
        String id = config.getId();
        jsObj = create(id == null ? Ext.generateId() : id, configJS);
    }

    public LayoutDialog(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static LayoutDialog instance(JavaScriptObject jsObj) {
        return new LayoutDialog(jsObj);
    }

    private native JavaScriptObject create(String id, JavaScriptObject configJS) /*-{
        return new $wnd.Ext.LayoutDialog(id, configJS);
    }-*/;

	/**
	 * Adds a button to the footer section of the dialog.
	 *
	 * @param text the button text
	 * @return the button instance
	 */
	public native Button addButton(String text) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var buttonJS = dialog.addButton(text);
        return @com.gwtext.client.widgets.Button::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(buttonJS);
    }-*/;

	/**
	 * Adds a key listener for when this dialog is displayed. This allows you to hook in a function that will be executed
	 * in response to a particular key being pressed while the dialog is active.
	 * 
	 * @param keyCode the numeric key code
	 * @param listener the key listener
	 */
	public native void addKeyListener(int keyCode, KeyListener listener)/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.addKeyListener(keyCode, function(dlg, key, event) {
              var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
              listener.@com.gwtext.client.widgets.event.KeyListener::onKey(ILcom/gwtext/client/core/EventObject;)(key, e);
            });
    }-*/;

	/**
	 * Adds a key listener for when this dialog is displayed. This allows you to hook in a function that will be executed
	 * in response to a particular key being pressed while the dialog is active.
	 *
	 * @param keyCodes an array of numeric key codes
	 * @param listener the key listener
	 */
    public native void addKeyListener(int[] keyCodes, KeyListener listener)/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var keyCodesJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(keyCodes);
        dialog.addKeyListener(keyCodesJS, function(dlg, key, event) {
              var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
              listener.@com.gwtext.client.widgets.event.KeyListener::onKey(ILcom/gwtext/client/core/EventObject;)(key, e);
            });
    }-*/;

	/**
	 * Adds a key listener for when this dialog is displayed. This allows you to hook in a function that will be executed
	 * in response to a particular key being pressed while the dialog is active.
	 *
	 * @param config the key map config
	 * @param listener the key listener
	 */
    public native void addKeyListener(KeyMapConfig config, KeyListener listener)/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        dialog.addKeyListener(configJS, function(dlg, key, event) {
              var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
              listener.@com.gwtext.client.widgets.event.KeyListener::onKey(ILcom/gwtext/client/core/EventObject;)(key, e);
            });
    }-*/;

	/**
	 * Adds a button to the footer section of the dialog.
	 *
	 * @param button the button to add
	 * @return the button instance
	 */
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

	/**
	 * Centers this dialog in the viewport.
	 */
	public native void center() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.center();
    }-*/;

	/**
	 * Collapses the dialog to its minimized state (only the title bar is visible). Equivalent to the user clicking the collapse dialog button.
	 */
	public native void collapse() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.collapse();
    }-*/;

	/**
	 * Destroys this dialog and all its supporting elements (including any tabs, shim, shadow, proxy, mask, etc.) Also removes all event listeners.
	 */
	public native void destroy() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.destroy();
    }-*/;

	/**
	 * Destroys this dialog and all its supporting elements (including any tabs, shim, shadow, proxy, mask, etc.) Also removes all event listeners.
	 *
	 * @param removeEL true to remove the element from the DOM
	 */
	public native void destroy(boolean removeEL) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.destroy(removeEL);
    }-*/;

	/**
	 * Expands a collapsed dialog back to its normal state. Equivalent to the user clicking the expand dialog button.
	 */
	public native void expand() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.expand();
    }-*/;

	/**
	 * Focuses the dialog. If a defaultButton is set, it will receive focus, otherwise the dialog itself will receive focus.
	 */
	public native void focus() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.focus();
    }-*/;

	/**
	 * Get the BorderLayout for this dialog.
	 *
	 * @return the BorderLayout for this dialog
	 */
	public BorderLayout getLayout() {
        return new BorderLayout(getLayout(jsObj));
    }

    private native JavaScriptObject getLayout(JavaScriptObject layoutDialog) /*-{
        return layoutDialog.getLayout();
    }-*/;

	/**
	 * Returns the header element.
	 *
	 * @return the header element.
	 */
	public native ExtElement getHeaderEl()/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var header = dialog.header;
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(header);
    }-*/;

	/**
	 * Returns the body element.
	 *
	 * @return the body element.
	 */
	public native ExtElement getBodyEl()/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var body = dialog.body;
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(body);
    }-*/;

	/**
	 * Returns the footer element.
	 *
	 * @return the footer element
	 */
	public native ExtElement getFooterEl()/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var footer = dialog.footer;
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(footer);
    }-*/;

	/**
	 * Returns the TabPanel component (creates it if it doesn't exist).
	 * 
	 * @return the tab panel
	 */
	public native TabPanel getTabs()/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var tabs = dialog.getTabs();
        return tabs == null ? null : @com.gwtext.client.widgets.TabPanel::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tabs);
    }-*/;

	/**
	 * Hides the dialog.
	 */
	public native void hide() /*-{
            var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            dialog.hide();
    }-*/;

	/**
	 * Hides the dialog.
	 * 
	 * @param cb function to call when the dialog is hidden
	 */
	public native void hide(Function cb) /*-{
            var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            dialog.hide(function() {
                cb.@com.gwtext.client.core.Function::execute()();
            });
    }-*/;

	/**
	 * Reinitializes the tabs component, clearing out old tabs and finding new ones.
	 *
	 * @return the tab panel
	 */
	public native TabPanel initTabs() /*-{
            var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            var tabs = dialog.initTabs();
            return tabs == null ? null : @com.gwtext.client.widgets.TabPanel::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tabs);
    }-*/;

	/**
	 * Returns true if the dialog is visible.
	 *
	 * @return true if the dialog is visible
	 */
	public native boolean isVisible() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return dialog.isVisible();
    }-*/;

	/**
	 * Moves the dialog's top-left corner to the specified point.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public native void moveTo(int x, int y) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.moveTo(x, y);
    }-*/;

	/**
	 * Resizes the dialog.
	 * 
	 * @param width the new width
	 * @param height the new height
	 */
	public native void resizeTo(int width, int height) /*-{
            var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            dialog.resizeTo(width, height);
    }-*/;

	/**
	 * Restores the previous state of the dialog if state is configured.
	 */
	public native void restoreState() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.restoreState();
    }-*/;

	/**
	 * Resizes the dialog to fit the specified content size.
	 * 
	 * @param width the new width
	 * @param height the new height
	 */
	public native void setContentSize(int width, int height) /*-{
            var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            dialog.setContentSize(width, height);
    }-*/;

	/**
	 * Sets the default button to be focused when the dialog is displayed.
	 *
	 * @param btn the default button
	 */
	public native void setDefaultButton(Button btn) /*-{
            var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            var btnJS = btn.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            dialog.setDefaultButton(btnJS);
    }-*/;

	/**
	 * Sets the dialog title text.
	 *
	 * @param title the dialog text
	 */
	public native void setTitle(String title) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.setTitle(title);
    }-*/;

	/**
	 * Shows the dialog.
	 */
	public native void show() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.show();
    }-*/;

	/**
	 * Shows the dialog.
	 *
	 * @param animateTargetId the target to animate from
	 */
	public native void show(String animateTargetId) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.show(animateTargetId);
    }-*/;

	/**
	 * Shows the dialog.
	 *
	 * @param target the target to animate from
	 */
	public native void show(Element target) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.show(target);
    }-*/;

	/**
	 * Shows the dialog.
	 *
	 * @param target the target to animate from
	 */
    public native void show(ExtElement target) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var targetJS = target.@com.gwtext.client.core.JsObject::jsObj;
        dialog.show(targetJS);
    }-*/;

	/**
	 * Sends this dialog to the back (under) of any other visible dialogs.
	 */
	public native void toBack() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.toBack();
    }-*/;

	/**
	 * Brings this dialog to the front of any other visible dialogs.
	 */
	public native void toFront() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.toFront();
    }-*/;

	/**
	 * Add a dialog listener.
	 *
	 * @param listener the listener
	 */
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
