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
 
package com.gwtext.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.data.Record;
import com.gwtext.client.dd.DragData;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * An implementation of DragData that is passed to the drop target when the source is a TreeNode from a Draggable tree.
 *
 * @author Sanjiv Jivan
 * @see com.gwtext.client.widgets.tree.event.TreePanelListener#doBeforeNodeDrop(com.gwtext.client.widgets.tree.TreePanel , com.gwtext.client.widgets.tree.TreeNode , com.gwtext.client.dd.DragData, String, com.gwtext.client.dd.DragDrop, com.gwtext.client.widgets.tree.TreeNode , com.gwtext.client.widgets.tree.DropNodeCallback)
 * @see com.gwtext.client.widgets.tree.event.TreePanelListener#onNodeDrop(com.gwtext.client.widgets.tree.TreePanel , com.gwtext.client.widgets.tree.TreeNode , com.gwtext.client.dd.DragData, String, com.gwtext.client.dd.DragDrop, com.gwtext.client.widgets.tree.TreeNode)
 */
public class GridDragData extends DragData {

    public GridDragData(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * The source GridPanel.
     *
     * @return the source GridPanel
     */
    public GridPanel getGrid() {
        JavaScriptObject gridJS = getPropertyAsJavaScriptObject("grid");
        return new GridPanel(gridJS);
    }

    /**
     * The rows selected in the source GridPanel.
     *
     * @return the selected rows
     */
    public Record[] getSelections() {
        JavaScriptObject recordsJS = getPropertyAsJavaScriptObject("selections");
        return convertFromNativeRecordsArray(recordsJS);
    }

    private static Record[] convertFromNativeRecordsArray(JavaScriptObject nativeArray) {
        JavaScriptObject[] recordsj = JavaScriptObjectHelper.toArray(nativeArray);
        Record[] records = new Record[recordsj.length];
        for (int i = 0; i < recordsj.length; i++) {
            JavaScriptObject record = recordsj[i];
            records[i] = new Record(record);
        }
        return records;
    }

    /**
     * The row index.
     *
     * @return the row index
     */
    public int getRowIndex() {
        return getPropertyAsInt("rowIndex");
    }
}
