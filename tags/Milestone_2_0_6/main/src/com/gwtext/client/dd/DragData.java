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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.grid.GridDragData;
import com.gwtext.client.widgets.tree.TreeDragData;
import com.gwtext.client.widgets.PanelDragData;

/**
 * Base DragData class that is passed to the drop target when the source is draggable.
 *
 * @author Sanjiv Jivan
 * @see com.gwtext.client.widgets.tree.event.TreePanelListener#doBeforeNodeDrop(com.gwtext.client.widgets.tree.TreePanel , com.gwtext.client.widgets.tree.TreeNode , com.gwtext.client.dd.DragData, String, com.gwtext.client.dd.DragDrop, com.gwtext.client.widgets.tree.TreeNode , com.gwtext.client.widgets.tree.DropNodeCallback)
 * @see com.gwtext.client.widgets.tree.event.TreePanelListener#onNodeDrop(com.gwtext.client.widgets.tree.TreePanel , com.gwtext.client.widgets.tree.TreeNode , com.gwtext.client.dd.DragData, String, com.gwtext.client.dd.DragDrop, com.gwtext.client.widgets.tree.TreeNode)
 */
public class DragData extends JsObject {

    protected DragData(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public int getPropertyAsInt(String property) {
        return JavaScriptObjectHelper.getAttributeAsInt(jsObj, property);
    }

    public boolean getPropertyAsBoolean(String property) {
        return JavaScriptObjectHelper.getAttributeAsBoolean(jsObj, property);
    }

    public String getProperty(String property) {
        return JavaScriptObjectHelper.getAttribute(jsObj, property);
    }

    public JavaScriptObject getPropertyAsJavaScriptObject(String property) {
        return JavaScriptObjectHelper.getAttributeAsJavaScriptObject(jsObj, property);
    }

    public Element getPropertyAsElement(String property) {
        return JavaScriptObjectHelper.getAttributeAsElement(jsObj, property);
    }

    /**
     * Retrun the DragDrop element. ie the Element displayed when the source is being dragged.
     *
     * @return the element being droppped
     */
    public Element getDDEl() {
        return getPropertyAsElement("ddel");
    }

    private static DragData instance(JavaScriptObject jsObj) {
        if (JavaScriptObjectHelper.getAttributeAsJavaScriptObject(jsObj, "grid") != null) {
            return new GridDragData(jsObj);
        } else if (JavaScriptObjectHelper.getAttributeAsJavaScriptObject(jsObj, "node") != null) {
            return new TreeDragData(jsObj);
        } else if(JavaScriptObjectHelper.getAttributeAsJavaScriptObject(jsObj, "panel") != null) {
            return new PanelDragData(jsObj);
        }
        return new DragData(jsObj);
    }
}
