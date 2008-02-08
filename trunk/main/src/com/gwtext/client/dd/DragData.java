/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 *
 * http://www.gwt-ext.com/license
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
