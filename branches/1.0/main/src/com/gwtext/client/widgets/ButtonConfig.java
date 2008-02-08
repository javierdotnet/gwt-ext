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

import com.gwtext.client.core.AnchorPosition;
import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.core.Template;
import com.gwtext.client.util.ClickRepeaterConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.event.ButtonListener;
import com.gwtext.client.widgets.menu.Menu;

/**
 * Configuration class for a {@link Button}.
 */
public class ButtonConfig extends BaseConfig {

    private ButtonListener buttonListener;

    //try
    public void setAutoCreate(boolean autoCreate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoCreate", autoCreate);
    }

    /**
     * A CSS class to apply to the button's main element.
     *
     * @param cls a CSS class
     */
    public void setCls(String cls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "cls", cls);
    }

    /**
     * True to start disabled (defaults to false).
     *
     * @param disabled
     */
    public void setDisabled(boolean disabled) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disabled", disabled);
    }

    /**
     * True to enable pressed/not pressed toggling (defaults to false).
     * 
     * @param enableToggle true to enable toggle
     */
    public void setEnableToggle(boolean enableToggle) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableToggle", enableToggle);
    }

    /**
     * You can bind your form buttons to the valid state of the form. Note: the Form's monitorValid config must be set to true.
     * To bind a button(s) enabled state to the valid state set this property to true.
     *
     * @param bindToForm to to bind to form's valid state
     */
    public void setFormBind(boolean bindToForm) {
       JavaScriptObjectHelper.setAttribute(jsObj, "formBind", bindToForm);
    }

    /**
     * False to disable visual cues on mouseover, mouseout and mousedown (defaults to true).
     *
     * @param handleMouseEvents false to diable visual cues
     */
    public void setHandleMouseEvents(boolean handleMouseEvents) {
        JavaScriptObjectHelper.setAttribute(jsObj, "handleMouseEvents", handleMouseEvents);
    }

    /**
     * True to start hidden (defaults to false).
     *
     * @param hidden true for hidden
     */
    public void setHidden(boolean hidden) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hidden", hidden);
    }

    //TODO doesnt seem to be working for toolbar menu button
    /**
     * The path to an image to display in the button (the image will be set as the background-image CSS property of the
     * button by default, so if you want a mixed icon/text button, set cls:"x-btn-text-icon")
     *
     * @param icon the icon
     */
    public void setIcon(String icon) {
        JavaScriptObjectHelper.setAttribute(jsObj, "icon", icon);
        //setCls("x-btn-icon");
    }

    /**
     * A css class which sets a background image to be used as the icon for this button (defaults to undefined).
     *
     * @param iconCls the icon CSS class
     */
    public void setIconCls(String iconCls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "iconCls", iconCls);
    }

    /**
     * Assign a button menu.
     * 
     * @param menu the button menu
     */
    public void setMenu(Menu menu) {
        JavaScriptObjectHelper.setAttribute(jsObj, "menu", menu.getJsObj());
    }


    /**
     * The position to align the menu to.
     *
     * @param elementAnchor the element's anchor point
     * @param targetAnchor the target's anchor point
     */
    public void setMenuAlign(AnchorPosition elementAnchor, AnchorPosition targetAnchor) {
        JavaScriptObjectHelper.setAttribute(jsObj, "menuAlign", elementAnchor.getPosition() +"-" + targetAnchor.getPosition());
    }

    /**
     * The minimum width for this button.
     *
     * @param minWidth the min width
     */
    public void setMinWidth(int minWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minWidth", minWidth);
    }

    /**
     * True to start pressed (only if enableToggle = true).
     *
     * @param pressed true for pressed
     */
    public void setPressed(boolean pressed) {
        JavaScriptObjectHelper.setAttribute(jsObj, "pressed", pressed);
    }

    /**
     * True to repeat fire the click event while the mouse is down. (defaults to false).
     *
     * @param repeat
     */
    public void setRepeat(boolean repeat) {
        JavaScriptObjectHelper.setAttribute(jsObj, "repeat", repeat);
    }

    /**
     * Fire click event when mouse is down.
     *
     * @param config the click repeat configuration
     */
    public void setRepeat(ClickRepeaterConfig config) {
        JavaScriptObjectHelper.setAttribute(jsObj, "config", config.getJsObj());
    }

    /**
     * Set a DOM tabIndex for this button.
     * 
     * @param tabIndex the tab index
     */
    public void setTabIndex(int tabIndex) {
        JavaScriptObjectHelper.setAttribute(jsObj, "tabIndex", tabIndex);
    }

    //TODO inconsistent since others use autoCreate with template overridden?
    public void setTemplate(Template template) {
        JavaScriptObjectHelper.setAttribute(jsObj, "template", template.getJsObj());
    }

    /**
     * The button text.
     *
     * @param text the buttons text
     */
    public void setText(String text) {
        JavaScriptObjectHelper.setAttribute(jsObj, "text", text);
    }

    /**
     * The group this toggle button is a member of (only 1 per group can be pressed, only applies if enableToggle = true).
     *
     * @param toggleGroup the button's toggle group
     */
    public void setToggleGroup(String toggleGroup) {
        JavaScriptObjectHelper.setAttribute(jsObj, "toggleGroup", toggleGroup);
    }

    /**
     *  The tooltip for the button.
     *
     * @param tooltip the tooltip
     */
    public void setTooltip(String tooltip) {
        JavaScriptObjectHelper.setAttribute(jsObj, "tooltip", tooltip);
    }

    /**
     *  The tooltip for the button.
     *
     * @param title the tootlip title
     * @param text the tootlip text
     */
    public void setTooltip(final String title, final String text) {
        JavaScriptObjectHelper.setAttribute(jsObj, "tooltip", new QuickTipsConfig() {
            {
                setTitle(title);
                setText(text);
            }
        }.getJsObj());
    }

    /**
     * The tooltip for the button.
     *
     * @param config the tooltip config
     */
    public void setTooltip(QuickTipsConfig config) {
        JavaScriptObjectHelper.setAttribute(jsObj, "tooltip", config.getJsObj());
    }

    /**
     * The type of tooltip to use.
     *
     * @param quickTip true for quicktips, false for the "title" attribute.
     */
    public void setTooltipType(boolean quickTip) {
        if(quickTip){
            JavaScriptObjectHelper.setAttribute(jsObj, "tooltipType", "qtip");
        } else {
            JavaScriptObjectHelper.setAttribute(jsObj, "tooltipType", "title");
        }
    }

    /**
     * The button's type, corresponding to the DOM input element type attribute. Either "submit," "reset" or "button" (default).
     * 
     * @param type the button type
     */
    public void setType(String type) {
        JavaScriptObjectHelper.setAttribute(jsObj, "type", type);
    }

    public ButtonListener getButtonListener() {
        return buttonListener;
    }

    /**
     * Add a Button Listener.
     *
     * @param buttonListener the listener
     */
    public void setButtonListener(ButtonListener buttonListener) {
        this.buttonListener = buttonListener;
    }
}
