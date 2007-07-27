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

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.core.Template;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.event.ButtonListener;
import com.gwtext.client.widgets.menu.Menu;

public class ButtonConfig extends BaseConfig {

    private ButtonListener buttonListener;

    //try
    public void setAutoCreate(boolean autoCreate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoCreate", autoCreate);
    }

    public void setCls(String cls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "cls", cls);
    }

    public void setDisabled(boolean disabled) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disabled", disabled);
    }

    public void setEnableToggle(boolean enableToggle) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableToggle", enableToggle);
    }

    public void setHandleMouseEvents(boolean handleMouseEvents) {
        JavaScriptObjectHelper.setAttribute(jsObj, "handleMouseEvents", handleMouseEvents);
    }

    public void setHidden(boolean hidden) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hidden", hidden);
    }

    //TODO doesnt seem to be working for toolbar menu button
    public void setIcon(String icon) {
        JavaScriptObjectHelper.setAttribute(jsObj, "icon", icon);
        //setCls("x-btn-icon");
    }

    public void setIconCls(String iconCls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "iconCls", iconCls);
    }

    public void setMenu(Menu menu) {
        JavaScriptObjectHelper.setAttribute(jsObj, "menu", menu.getJsObj());
    }

    //todo make typesafe with constants
    public void setMenuAlign(String menuAlign) {
        JavaScriptObjectHelper.setAttribute(jsObj, "menuAlign", menuAlign);
    }

    public void setMinWidth(int minWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minWidth", minWidth);
    }

    public void setPressed(boolean pressed) {
        JavaScriptObjectHelper.setAttribute(jsObj, "pressed", pressed);
    }

    public void setRepeat(boolean repeat) {
        JavaScriptObjectHelper.setAttribute(jsObj, "repeat", repeat);
    }

    //TODO  setRepeat
    /*public void setRepeat(ClickRepeater config) {
        //JavaScriptObjectHelper.setAttribute(jsObj, "config", config);
    }*/

    public void setTabIndex(int tabIndex) {
        JavaScriptObjectHelper.setAttribute(jsObj, "tabIndex", tabIndex);
    }

    //TODO inconsistent since others use autoCreate with template overridden?
    public void setTemplate(Template template) {
        JavaScriptObjectHelper.setAttribute(jsObj, "template", template.getJsObj());
    }

    public void setText(String text) {
        JavaScriptObjectHelper.setAttribute(jsObj, "text", text);
    }

    public void setToggleGroup(String toggleGroup) {
        JavaScriptObjectHelper.setAttribute(jsObj, "toggleGroup", toggleGroup);
    }

    public void setTooltip(String tooltip) {
        JavaScriptObjectHelper.setAttribute(jsObj, "tooltip", tooltip);
    }

    public void setTooltip(final String title, final String text) {
        JavaScriptObjectHelper.setAttribute(jsObj, "tooltip", new QuickTipsConfig() {
            {
                setTitle(title);
                setText(text);
            }
        }.getJsObj());
    }

    public void setTooltip(QuickTipsConfig config) {
        JavaScriptObjectHelper.setAttribute(jsObj, "tooltip", config.getJsObj());
    }

    //TODO make typesafe  "qtip" or "title"
    public void setTooltipType(String tooltipType) {
        JavaScriptObjectHelper.setAttribute(jsObj, "tooltipType", tooltipType);
    }

    public void setType(String type) {
        JavaScriptObjectHelper.setAttribute(jsObj, "type", type);
    }

    public ButtonListener getButtonListener() {
        return buttonListener;
    }

    public void setButtonListener(ButtonListener buttonListener) {
        this.buttonListener = buttonListener;
    }
}
