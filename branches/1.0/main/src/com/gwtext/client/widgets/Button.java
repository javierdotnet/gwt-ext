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
import com.gwtext.client.core.Ext;
import com.gwtext.client.widgets.event.ButtonListener;

/**
 * Simple Button class.
 */
public class Button extends RequiredElementWidget {

    /**
     * Construct a new Button.
     *
     * @param text the button text
     */
    public Button(final String text) {
        this(new ButtonConfig() {
            {
                setText(text);
            }
        });
    }

    /**
     * Construct a new Button
     *
     * @param config the button config
     */
    public Button(ButtonConfig config) {
        this(Ext.generateId(), config);
    }

    /**
     * Construct a new Button.
     *
     * @param id the button ID
     * @param config the button config
     */
    public Button(String id, ButtonConfig config) {
        super(id, config);
        if (config.getButtonListener() != null) {
            addButtonListener(config.getButtonListener());
        }
    }

    protected Button(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static Button instance(JavaScriptObject jsObj) {
        return new Button(jsObj);
    }

    protected native JavaScriptObject create(String id, JavaScriptObject config) /*-{
        return new $wnd.Ext.Button(id, config);
    }-*/;

    public JavaScriptObject getJsObj() {
        return jsObj;
    }

    /**
     * Returns true if button is disabled.
     *
     * @return true if disabled
     */
    public native boolean isDisabled() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return button.disabled;
    }-*/;

    /**
     * Returns true if Button is hidden.
     *
     * @return true if hidden
     */
    public native boolean isHidden() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return button.hidden;
    }-*/;

    /**
     * True if this button is pressed (only if enableToggle is true)
     *
     * @return true if pressed
     */
    public native boolean isPressed() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return button.pressed;
    }-*/;

    /**
     * Destroys this Button and removes any listeners.
     */
    public native void destroy() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        button.destroy();
    }-*/;

    /**
     * Disable this button.
     */
    public native void disable() /*-{
      var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
      button.disable();
    }-*/;

    /**
     * Enable this button.
     */
    public native void enable() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        button.enable();
    }-*/;

    /**
     * Focus the button.
     */
    public native void focus() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        button.focus();
    }-*/;

    /**
     * Gets the text of this button.
     *
     * @return teh button text
     */
    public native String getText() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return button.getText();
    }-*/;

    /**
     * An Ext Button consists of a table that wraps a button element. This method returns the underlying
     * Button element
     * @return the Button Element
     */
    public native Element getButtonElement() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var but = button.el.child('button:first').dom;
        return but;
    }-*/;

    /**
     * Hide this button.
     */
    public native void hide() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        button.hide();
    }-*/;

    /**
     * Sets this button's text.
     *
     * @param text
     */
    public native void setText(String text) /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        button.setText(text);
    }-*/;

    /**
     * Convenience function for boolean show/hide.
     *
     * @param visible true to set visible
     */
    public native void setVisible(boolean visible) /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        button.setVisible(visible);
    }-*/;

    /**
     * Show this button.
     */
    public native void show() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        button.show();
    }-*/;

    /**
     * Toggle the current state.
     */
    public native void toggle() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        button.toggle();
    }-*/;

    /**
     * Toggle the button to the passed state.
     *
     * @param state true to toggle pressed
     */
    public native void toggle(boolean state) /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        button.toggle(state);
    }-*/;

    /**
     * Sets the Button's tooltip.
     * 
     * @param tooltip Button's toolip
     */
    public native void setTooltip(String tooltip) /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var but = button.el.child('button:first').dom;
        but.qtip = tooltip;
    }-*/;

    /**
     * Add a Button listener.
     *
     * @param listener the listener
     */
    public native void addButtonListener(ButtonListener listener) /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var buttonJ = this;

        button.addListener('click',
                function(source, event) {
                    var e = (event === undefined || event == null) ? null : @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.event.ButtonListener::onClick(Lcom/gwtext/client/widgets/Button;Lcom/gwtext/client/core/EventObject;)(buttonJ, e);
                }
        );

        button.addListener('mouseout',
                function(source, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.event.ButtonListener::onMouseOut(Lcom/gwtext/client/widgets/Button;Lcom/gwtext/client/core/EventObject;)(buttonJ, e);
                }
        );

        button.addListener('mouseover',
                function(source, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.event.ButtonListener::onMouseOver(Lcom/gwtext/client/widgets/Button;Lcom/gwtext/client/core/EventObject;)(buttonJ, e);
                }
        );

        button.addListener('toggle',
                function(source,pressed) {
                    listener.@com.gwtext.client.widgets.event.ButtonListener::onToggle(Lcom/gwtext/client/widgets/Button;Z)(buttonJ, pressed);
                }
        );
    }-*/;
}
