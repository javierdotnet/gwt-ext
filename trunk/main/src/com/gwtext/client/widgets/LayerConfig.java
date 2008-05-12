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
import com.gwtext.client.core.DomConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Configuration class for a Layer.
 *
 * @author Sanjiv Jivan
 */
public class LayerConfig extends BaseConfig {

    /**
     * CSS class to add to the element.
     *
     * @param cls the CSS class
     */
    public void setCls(String cls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "cls", cls);
    }

    /**
     * False to disable constrain to viewport (defaults to true)
     *
     * @param constrain true to constrain
     */
    public void setConstrain(boolean constrain) {
        JavaScriptObjectHelper.setAttribute(jsObj, "constrain", constrain);
    }

    /**
     * {@link com.gwtext.client.core.DomHelper} object config to create element with (defaults to {tag: "div", cls: "x-layer"}).
     * 
     * @param domConfig the dom config
     */
    public void setDomConfig(DomConfig domConfig) {
        JavaScriptObjectHelper.setAttribute(jsObj, "dh", domConfig.getJsObject());
    }

    /**
     * True to create a shadow element with default class "x-layer-shadow". False turns off the shadow.
     *
     * @param shadow true to create shadow
     */
    public void setShadow(boolean shadow) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shadow", shadow);
    }

    /**
     * Pass a string with a shadow CSS class name.
     *
     * @param shadowCls shadow class
     */
    public void setShadowCls(String shadowCls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shadow", shadowCls);
    }

    /**
     * Number of pixels to offset the shadow (defaults to 3).
     * 
     * @param shadowOffest offset in pixels
     */
    public void setShadowOffest(int shadowOffest) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shadowOffest", shadowOffest);
    }

    /**
     * False to disable the iframe shim in browsers which need one (defaults to true).
     *
     * @param shim false to disable shim
     */
    public void setShim(boolean shim) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shim", shim);
    }

    /**
     * Starting z-index (defaults to 11000).
     *
     * @param zindex the z-index
     */
    public void setZindex(int zindex) {
        JavaScriptObjectHelper.setAttribute(jsObj, "zindex", zindex);
    }
}
