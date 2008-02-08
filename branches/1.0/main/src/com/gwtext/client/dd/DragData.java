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
package com.gwtext.client.dd;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.grid.GridDragData;
import com.gwtext.client.widgets.tree.TreeDragData;

/**
 * Base DragData class that is passed to the drop target when the source is draggable.
 *
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
        }
        return new DragData(jsObj);
    }
}
