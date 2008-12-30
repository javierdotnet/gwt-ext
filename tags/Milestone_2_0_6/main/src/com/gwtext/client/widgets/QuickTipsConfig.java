/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 

package com.gwtext.client.widgets;

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.google.gwt.user.client.Element;

/**
 * Configuration class for {@link com.gwtext.client.widgets.QuickTips}.
 *
 * @author Sanjiv Jivan
 */
public class QuickTipsConfig extends BaseConfig {


    /**
     * True to automatically hide the quick tip after the mouse exits the target element (defaults to true).
     * Used in conjunction with hideDelay.
     *
     * @param autoHide true to auto hide
     */
    public void setAutoHide(boolean autoHide) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoHide", autoHide);
    }

    public void setCls(String cls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "cls", cls);
    }

    public void setDismissDelay(int dismissDelay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "dismissDelay", dismissDelay);
    }

    public void setTraget(Element traget) {
        JavaScriptObjectHelper.setAttribute(jsObj, "traget", traget);
    }

    public void setTarget(String target) {
        JavaScriptObjectHelper.setAttribute(jsObj, "target", target);
    }

    public void setTarget(Component target) {
        if(target.isRendered()) {
            JavaScriptObjectHelper.setAttribute(jsObj, "target", target.getElement());
        } else {
            JavaScriptObjectHelper.setAttribute(jsObj, "target", target.getId());
        }        
    }

    /**
     * Body text to display (defaults to ''). This can be any valid HTML markup.
     *
     * @param text the text
     */
    public void setText(String text) {
        JavaScriptObjectHelper.setAttribute(jsObj, "text", text);
    }

    /**
     * Title text to display (defaults to ''). This can be any valid HTML markup.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        JavaScriptObjectHelper.setAttribute(jsObj, "title", title);
    }

    public void setWidth(int width) {
        JavaScriptObjectHelper.setAttribute(jsObj, "width", width);
    }

    //TODO2 arethese used? V
    /**
     * Delay in milliseconds before the quick tip hides when autoHide = true (defaults to 200).
     *
     * @param hideDelay hide delay in milliseconds
     */
    public void setHideDelay(int hideDelay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hideDelay", hideDelay);
    }

    /**
     * True to hide the quick tip if the user clicks anywhere in the document (defaults to true).
     *
     * @param hideOnClick true to hide on click
     */
    public void setHideOnClick(boolean hideOnClick) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hideOnClick", hideOnClick);
    }

    /**
     * True to automatically use the element's DOM title value if available (defaults to false).
     *
     * @param interceptTitles true to automatically use the element's DOM title value if available
     */
    public void setInterceptTitles(boolean interceptTitles) {
        JavaScriptObjectHelper.setAttribute(jsObj, "interceptTitles", interceptTitles);
    }

    /**
     * The maximum width of the quick tip (defaults to 300).
     *
     * @param maxWidth the max width
     */
    public void setMaxWidth(int maxWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxWidth", maxWidth);
    }

    /**
     * The minimum width of the quick tip (defaults to 40).
     *
     * @param minWidth the min width
     */
    public void setMinWidth(int minWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minWidth", minWidth);
    }

    /**
     * Delay in milliseconds before the quick tip displays after the mouse enters the target element (defaults to 500).
     *
     * @param showDelay the show delay
     */
    public void setShowDelay(int showDelay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "showDelay", showDelay);
    }

    /**
     * True to have the quick tip follow the mouse as it moves over the target element (defaults to false).
     *
     * @param trackMouse true to track mouse
     */
    public void setTrackMouse(boolean trackMouse) {
        JavaScriptObjectHelper.setAttribute(jsObj, "trackMouse", trackMouse);
    }
}
