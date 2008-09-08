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

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.data.Record;
import com.gwtext.client.dd.DragData;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.grid.GridPanel;

/**
 * An implementation of DragData that is passed to the drop target when the source is a Panel.
 *
 * @author Sanjiv Jivan
 */
public class PanelDragData extends DragData {

    public PanelDragData(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * The source Panel.
     *
     * @return the source Panel
     */
    public Panel getPanel() {
        JavaScriptObject gridJS = getPropertyAsJavaScriptObject("panel");
        return (Panel) ComponentFactory.getComponent(gridJS);
    }

}