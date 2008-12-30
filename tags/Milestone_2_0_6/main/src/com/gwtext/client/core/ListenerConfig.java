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
 
package com.gwtext.client.core;

import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 *
 * @author Sanjiv Jivan
 */
public class ListenerConfig extends BaseConfig {

    public void setStopEvent(boolean stopEvent) {
        JavaScriptObjectHelper.setAttribute(jsObj, "stopEvent", stopEvent);
    }

    public void setPreventDefault(boolean preventDefault) {
        JavaScriptObjectHelper.setAttribute(jsObj, "preventDefault", preventDefault);
    }

    public void setStopPropagation(boolean stopPropagation) {
        JavaScriptObjectHelper.setAttribute(jsObj, "stopPropagation", stopPropagation);
    }

    public void setDelay(int delay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "delay", delay);
    }

    public void setSingle(boolean single) {
        JavaScriptObjectHelper.setAttribute(jsObj, "single", single);
    }

    public void setBuffer(int buffer) {
        JavaScriptObjectHelper.setAttribute(jsObj, "buffer", buffer);
    }
}
