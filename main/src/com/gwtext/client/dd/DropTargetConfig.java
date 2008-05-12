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
 
package com.gwtext.client.dd;

import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 *
 * @author Sanjiv Jivan
 */
public class DropTargetConfig extends DragDropConfig {
    /**
     * A named drag drop group to which this object belongs. If a group is specified,
     * then this object will only interact with other drag drop objects in the same group (defaults to undefined).
     *
     * @param ddGroup the group name
     */
    public void setdDdGroup(String ddGroup) {
        JavaScriptObjectHelper.setAttribute(jsObj, "ddGroup", ddGroup);
    }

    /**
     * The CSS class returned to the drag source when drop is allowed (defaults to "x-dd-drop-ok").
     *
     * @param dropAllowed drop allowed CSS
     */
    public void setDropAllowed(String dropAllowed) {
        JavaScriptObjectHelper.setAttribute(jsObj, "dropAllowed", dropAllowed);
    }

    /**
     * The CSS class returned to the drag source when drop is not allowed (defaults to "x-dd-drop-nodrop").
     *
     * @param dropNotAllowed drop not allowed CSS
     */
    public void setDropNotAllowed(String dropNotAllowed) {
        JavaScriptObjectHelper.setAttribute(jsObj, "dropNotAllowed", dropNotAllowed);
    }

    /**
     * The CSS class applied to the drop target element while the drag source is over it (defaults to "").
     * 
     * @param overClass the over class
     */
    public void setOverClass(String overClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "overClass", overClass);
    }

}
