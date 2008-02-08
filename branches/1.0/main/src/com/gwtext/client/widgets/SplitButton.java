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
import com.gwtext.client.widgets.event.MenuButtonListener;

/**
 * A split button that provides a built-in dropdown arrow that can fire an event separately from the default click event
 * of the button. Typically this would be used to display a dropdown menu that provides additional options to the primary
 * button action, but any custom handler can provide the arrowclick implementation.
 */
public class SplitButton extends Button {

    /**
     * Create a new menu button.
     * 
     * @param id The element to append the button to
     * @param config the config object
     */
    public SplitButton(String id, SplitButtonConfig config) {
        super(id, config);
        if (config.getMenuButtonListener() != null) {
            addMenuButtonListener(config.getMenuButtonListener());
        }
    }

    protected native JavaScriptObject create(String id, JavaScriptObject config) /*-{
        return new $wnd.Ext.MenuButton(id, config);
    }-*/;

    /**
     * Add a listener.
     *
     * @param listener  the listener
     */
    public native void addMenuButtonListener(MenuButtonListener listener) /*-{
        var componentJ = this;
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;

        component.addListener('arrowclick',
                function(self, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.event.MenuButtonListener::onArrowClick(Lcom/gwtext/client/widgets/SplitButton;Lcom/gwtext/client/core/EventObject;)(componentJ, e);
                }
        );
    }-*/;
}
