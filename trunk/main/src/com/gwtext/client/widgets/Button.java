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
import com.gwtext.client.core.Ext;
import com.gwtext.client.widgets.event.ButtonListener;

public class Button extends RequiredElementWidget {

    public Button(ButtonConfig config) {
        this(Ext.generateId(), config);
    }
    
    public Button(String id, ButtonConfig config) {
        super(id, config);
        if (config.getButtonListener() != null) {
            addButtonListener(config.getButtonListener());
        }
    }

    protected Button(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static Button instance(JavaScriptObject jsObj) {
        return new Button(jsObj);
    }

    protected native JavaScriptObject create(String id, JavaScriptObject config) /*-{
        return new $wnd.Ext.Button(id, config);
    }-*/;

    public JavaScriptObject getJsObj() {
        return jsObj;
    }

    public native boolean isDisabled() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return button.disabled;
    }-*/;

    public native boolean isHidden() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return button.hidden;
    }-*/;

    public native boolean isPressed() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return button.pressed;
    }-*/;

    public native void destroy() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        button.destroy();
    }-*/;

    public native void disable() /*-{
      var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
      button.disable();
    }-*/;

    public native void enable() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        button.enable();
    }-*/;

    public native void focus() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        button.focus();
    }-*/;

    public native String getText() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return button.getText();
    }-*/;

    public native void hide() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        button.hide();
    }-*/;

    public native void setText(String text) /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        button.setText(text);
    }-*/;

    public native void setVisible(boolean visible) /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        button.setVisible(visible);
    }-*/;

    public native void show() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        button.show();
    }-*/;


    public native void toggle() /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        button.toggle();
    }-*/;

    public native void toggle(boolean state) /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        button.toggle(state);
    }-*/;

    public native void addButtonListener(ButtonListener listener) /*-{
        var button = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var buttonJ = this;

        button.addListener('click',
                function(source, event) {
                    //var self = @com.gwtext.client.widgets.Button::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);                    
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
